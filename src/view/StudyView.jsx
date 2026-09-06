import { useState, useEffect, useCallback, useRef, useMemo } from "react";
import { motion, AnimatePresence } from "motion/react";
import { DIFFICULTY } from "../model/Deck";

import { Prism as SyntaxHighlighter } from "react-syntax-highlighter";
import { CardContent, codeTheme, extractCodeHint } from "./CardContent";
import { getSubjectColor } from "./deckHelpers";
import { SessionComplete } from "./SessionComplete";
import { EmptyStudyView } from "./EmptyStudyView";
import { GoogleAura } from "./GoogleAura";

import "./StudyView.css";

// --- Opción múltiple / Verdadero-Falso interactivos con orden aleatorio ---
const MC_OPTION_RE = /^([a-hA-H])\s*[\)\.]\s*(.+)$/;

function stripCodeBlocks(text) {
  return (text || "").replace(/```[\s\S]*?```/g, "\n");
}

function shuffleArray(array) {
  const result = [...array];
  for (let i = result.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [result[i], result[j]] = [result[j], result[i]];
  }
  return result;
}

function analyzeMultipleChoice(front, back) {
  // Solo cards con opciones tipo "a) ...", "b) ..." en el frente.
  const frontLines = (front || "").split("\n");
  const matches = [];
  let inCode = false;
  frontLines.forEach((line, i) => {
    if (/^```/.test(line.trim())) {
      inCode = !inCode;
      return;
    }
    if (inCode) return;
    const m = line.trim().match(MC_OPTION_RE);
    if (m) matches.push({ index: i, letter: m[1].toLowerCase(), text: m[2].trim() });
  });
  if (matches.length < 2) return null;

  // Encontrar la letra correcta original del dorso
  let origCorrectLetter = null;
  const backClean = stripCodeBlocks(back).replace(/[*_~`✓]/g, "");
  for (const line of backClean.split("\n")) {
    const m = line.trim().match(MC_OPTION_RE);
    if (m) {
      origCorrectLetter = m[1].toLowerCase();
      break;
    }
  }
  if (!origCorrectLetter) return null;

  // Mezclar aleatoriamente las opciones (random shuffle en cada visualización)
  const rawOptions = matches.map((m) => ({
    origLetter: m.letter,
    text: m.text,
    isCorrect: m.letter === origCorrectLetter,
  }));
  const shuffled = shuffleArray(rawOptions);

  // Asignar nuevas letras consecutivas (a, b, c, d...) según el nuevo orden aleatorio
  const options = shuffled.map((item, idx) => {
    const newBadge = String.fromCharCode(97 + idx); // 'a', 'b', 'c', 'd'...
    return {
      letter: newBadge,
      badge: newBadge,
      text: item.text,
      isCorrect: item.isCorrect,
      origLetter: item.origLetter,
    };
  });

  const correctOption = options.find((o) => o.isCorrect);

  return {
    options,
    correctLetter: correctOption ? correctOption.letter : null,
    before: frontLines.slice(0, matches[0].index).join("\n").trim(),
    after: frontLines.slice(matches[matches.length - 1].index + 1).join("\n").trim(),
  };
}

function analyzeAnswerOptions(front, back) {
  // 1) Opción múltiple (a, b, c, d...)
  const mc = analyzeMultipleChoice(front, back);
  if (mc) return mc;

  // 2) Verdadero / Falso: orden aleatorio de opciones
  const backLines = stripCodeBlocks(back)
    .split("\n")
    .map((l) => l.trim())
    .filter(Boolean);
  let vf = null;
  for (const line of backLines.slice(0, 4)) {
    const lower = line.toLowerCase();
    if (/^verdadero\b/.test(lower)) {
      vf = "V";
      break;
    }
    if (/^falso\b/.test(lower)) {
      vf = "F";
      break;
    }
  }
  if (vf) {
    const vfList = [
      { letter: "V", text: "Verdadero", badge: "V", isCorrect: vf === "V" },
      { letter: "F", text: "Falso", badge: "F", isCorrect: vf === "F" },
    ];
    const shuffledVf = shuffleArray(vfList);

    return {
      options: shuffledVf,
      correctLetter: vf,
      before: front,
      after: "",
    };
  }
  return null;
}

export function StudyView({ deck, onBack, onUpdateDeck }) {
  const [currentCardIndex, setCurrentCardIndex] = useState(0);
  const [isFlipped, setIsFlipped] = useState(false);
  const [flipRotation, setFlipRotation] = useState(0);
  const [cards, setCards] = useState([]);
  const [sessionStats, setSessionStats] = useState({
    again: 0,
    hard: 0,
    good: 0,
    easy: 0,
  });
  const [showComplete, setShowComplete] = useState(false);
  const [mcSelection, setMcSelection] = useState(null); // opción elegida en cards de opción múltiple
  const [isFirstTenSeconds] = useState(true);
  const [showPctGlow] = useState(true);
  const [isScrubbing, setIsScrubbing] = useState(false);

  // Drag-to-scrub para la barra de progreso
  const dotsContainerRef = useRef(null);
  const isDragging = useRef(false);

  const updateCardFromPointer = (clientX) => {
    if (!dotsContainerRef.current || cards.length === 0) return;
    const rect = dotsContainerRef.current.getBoundingClientRect();
    if (rect.width <= 0) return;
    const clickX = clientX - rect.left;
    const ratio = Math.max(0, Math.min(1, clickX / rect.width));
    const newIndex = Math.min(cards.length - 1, Math.floor(ratio * cards.length));
    if (newIndex !== currentCardIndex) {
      setCurrentCardIndex(newIndex);
      setIsFlipped(false);
      setFlipRotation(0);
    }
  };

  const handleMouseDown = (e) => {
    if (!dotsContainerRef.current || cards.length === 0) return;
    isDragging.current = true;
    setIsScrubbing(true);
    updateCardFromPointer(e.clientX);
  };

  const handleTouchStart = (e) => {
    if (!dotsContainerRef.current || cards.length === 0) return;
    if (e.touches && e.touches[0]) {
      isDragging.current = true;
      setIsScrubbing(true);
      updateCardFromPointer(e.touches[0].clientX);
    }
  };

  // Seguimiento global para que al arrastrar no se corte si el cursor sale de la barra
  useEffect(() => {
    const handleGlobalMouseMove = (e) => {
      if (isDragging.current) {
        updateCardFromPointer(e.clientX);
      }
    };
    const handleGlobalMouseUp = () => {
      if (isDragging.current) {
        isDragging.current = false;
        setIsScrubbing(false);
      }
    };
    const handleGlobalTouchMove = (e) => {
      if (isDragging.current && e.touches && e.touches[0]) {
        updateCardFromPointer(e.touches[0].clientX);
      }
    };
    const handleGlobalTouchEnd = () => {
      if (isDragging.current) {
        isDragging.current = false;
        setIsScrubbing(false);
      }
    };

    window.addEventListener("mousemove", handleGlobalMouseMove);
    window.addEventListener("mouseup", handleGlobalMouseUp);
    window.addEventListener("touchmove", handleGlobalTouchMove);
    window.addEventListener("touchend", handleGlobalTouchEnd);

    return () => {
      window.removeEventListener("mousemove", handleGlobalMouseMove);
      window.removeEventListener("mouseup", handleGlobalMouseUp);
      window.removeEventListener("touchmove", handleGlobalTouchMove);
      window.removeEventListener("touchend", handleGlobalTouchEnd);
    };
  }, [cards.length, currentCardIndex]);

  // Preparar tarjetas para estudio: SOLO las no aprendidas (nuevas +
  // en procesamiento). Las marcadas como "aprendido" NO vuelven a
  // aparecer en la cola diaria hasta completar el mazo o resetear.
  useEffect(() => {
    const studyCards = deck.getPendingCards();
    setCards(studyCards);
    setCurrentCardIndex(0);
    setIsFlipped(false);
    setShowComplete(false);
  }, [deck]);

  const currentCard = cards[currentCardIndex];
  // Porcentaje real de dominio del mazo (idéntico a la página principal)
  const deckStats = deck ? deck.getStats() : { aprendido: 0, total: cards.length, mastery: 0 };
  const masteryPct = deckStats.mastery;
  const progressPct =
    cards.length > 1 ? (currentCardIndex / (cards.length - 1)) * 100 : 100;

  // Resetear selección al cambiar de tarjeta
  useEffect(() => {
    setMcSelection(null);
  }, [currentCardIndex, currentCard?.id]);

  // Análisis y mezclado aleatorio de opciones de la tarjeta actual (opción múltiple o V/F)
  const mc = useMemo(
    () =>
      currentCard && deck?.id !== "examen-java-ejercicios"
        ? analyzeAnswerOptions(currentCard.front, currentCard.back)
        : null,
    [currentCard, currentCardIndex, deck?.id],
  );

  // Color del mazo para la barra de progreso (p. ej. violeta en Examen Java)
  const subjectColor = getSubjectColor(deck.subject);

  const handleFlip = () => {
    if (mc) return; // en opción múltiple / V-F la respuesta aparece bajo las opciones
    setIsFlipped(!isFlipped);
    setFlipRotation((prev) => prev + 180);
  };

  const handleRate = useCallback(
    (difficulty) => {
      if (!currentCard) return;

      // Actualizar estado de la tarjeta en el modelo
      currentCard.review(difficulty);

      // Registrar evaluación en log permanente
      deck.logCardReview(currentCard.id, difficulty);

      // Actualizar estadísticas de sesión
      setSessionStats((prev) => ({
        ...prev,
        [Object.keys(DIFFICULTY)[difficulty].toLowerCase()]:
          prev[Object.keys(DIFFICULTY)[difficulty].toLowerCase()] + 1,
      }));

      // Guardar progreso y estadísticas
      deck.recordReview(difficulty);
      onUpdateDeck(deck);

      if (difficulty === DIFFICULTY.APRENDIDO) {
        // Si se marca como "Aprendido", se elimina INMEDIATAMENTE de la cola actual de estudio
        const updatedCards = cards.filter((c) => c.id !== currentCard.id);
        setCards(updatedCards);
        setIsFlipped(false);
        setFlipRotation(0);

        if (updatedCards.length === 0) {
          setShowComplete(true);
        } else if (currentCardIndex >= updatedCards.length) {
          setCurrentCardIndex(updatedCards.length - 1);
        }
      } else {
        // Si es "Procesando", pasa a la siguiente tarjeta de la cola
        const isLast = currentCardIndex >= cards.length - 1;
        if (!isLast) {
          setCurrentCardIndex((prev) => prev + 1);
          setIsFlipped(false);
          setFlipRotation(0);
        } else {
          setShowComplete(true);
        }
      }
    },
    [
      currentCard,
      currentCardIndex,
      cards,
      deck,
      onUpdateDeck,
    ],
  );

  // Scroll al inicio y reiniciar estado de giro cuando cambia la tarjeta
  useEffect(() => {
    window.scrollTo({ top: 0, behavior: "smooth" });
    setIsFlipped(false);
    setFlipRotation(0);
  }, [currentCardIndex]);

  // Nueva tarjeta => reiniciar selección de opción múltiple
  useEffect(() => {
    setMcSelection(null);
  }, [currentCard?.id]);

  // Registrar visualización de tarjeta en el log permanente
  useEffect(() => {
    if (currentCard) {
      deck.logCardView(currentCard.id);
      onUpdateDeck(deck);
    }
  }, [currentCard?.id, currentCardIndex]);

  // Auto-scroll para mantener el punto actual visible en la fila
  useEffect(() => {
    const currentDot = document.querySelector(".card-dot.current");
    if (currentDot && dotsContainerRef.current) {
      currentDot.scrollIntoView({
        behavior: "smooth",
        inline: "center",
        block: "nearest",
      });
    }
  }, [currentCardIndex]);

  // Keyboard shortcuts
  useEffect(() => {
    const handleKeyDown = (e) => {
      if (showComplete) return;

      if (e.code === "Space") {
        e.preventDefault();
        if (!mc) handleFlip();
      } else if (isFlipped || (mc && mcSelection !== null)) {
        switch (e.key) {
          case "1":
            handleRate(DIFFICULTY.PROCESANDO);
            break;
          case "2":
            handleRate(DIFFICULTY.APRENDIDO);
            break;
        }
      }
    };

    window.addEventListener("keydown", handleKeyDown);
    return () => window.removeEventListener("keydown", handleKeyDown);
  }, [isFlipped, handleFlip, handleRate, showComplete, mc, mcSelection]);

  if (cards.length === 0) {
    return (
      <EmptyStudyView
        deckName={deck.name}
        onBack={onBack}
        onReviewAll={() => {
          setCards(deck.cards);
          setCurrentCardIndex(0);
          setIsFlipped(false);
        }}
      />
    );
  }

  if (showComplete) {
    return (
      <SessionComplete sessionStats={sessionStats} onBack={onBack} />
    );
  }

  return (
    <div className="study-view animate-fade-in">
      {/* Barra de progreso integrada con botón Volver */}
      <div
        className="card-progress-wrapper"
        style={{
          "--pb-accent": subjectColor.accent,
          "--progress-pct": `${progressPct}%`,
          "--progress-ratio": progressPct / 100,
        }}
      >
        <button className="btn-back-inline" onClick={onBack} title="Volver al menú">
          <svg
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            strokeWidth="2.5"
            strokeLinecap="round"
            strokeLinejoin="round"
            style={{ width: "18px", height: "18px" }}
          >
            <line x1="19" y1="12" x2="5" y2="12" />
            <polyline points="12 19 5 12 12 5" />
          </svg>
          <span>Volver</span>
        </button>

        <div
          ref={dotsContainerRef}
          className={`card-progress-track ${isFirstTenSeconds ? "google-active" : "google-expired"} ${isScrubbing ? "is-scrubbing" : ""}`}
          style={{ "--card-count": cards.length }}
          onMouseDown={handleMouseDown}
          onTouchStart={handleTouchStart}
        >
          <div
            className={`card-progress-fill ${showPctGlow ? "pct-glow-active" : "pct-glow-off"}`}
            style={{ width: `${Math.max(masteryPct, 0)}%` }}
          >
            <span className="bento-fill-pct-badge">{masteryPct}%</span>
          </div>

          {cards.length > 0 && (
            <div
              className={`card-scrubber-marker ${isScrubbing ? "active" : ""}`}
              style={{
                left: `calc(44px + (${progressPct} / 100) * (100% - 88px))`,
              }}
            >
              <div className="scrubber-badge">
                <span className="scrubber-card-num">{currentCardIndex + 1}</span>
                <span className="scrubber-card-total">/{cards.length}</span>
              </div>
              <div className="scrubber-tooltip">
                Tarjeta {currentCardIndex + 1} de {cards.length}
              </div>
            </div>
          )}
        </div>
        <div className="card-progress-count" title="Progreso del mazo">
          <span className="card-progress-pos">
            {deckStats.aprendido} / {deckStats.total}
          </span>
        </div>
      </div>

      <div className="flashcard-container">
        <motion.div
          key={currentCardIndex}
          initial={{ opacity: 0, y: 14 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ duration: 0.25, ease: "easeOut" }}
          style={{ width: "100%", display: "flex", justifyContent: "center" }}
        >
          <div
            className={`flashcard ${isFlipped ? "is-flipped" : ""}`}
            onClick={handleFlip}
            style={{
              transform: `rotateY(${flipRotation}deg)`,
              transformStyle: "preserve-3d",
              transition: "transform 0.65s cubic-bezier(0.4, 0, 0.2, 1)",
            }}
          >
            <div className="flashcard-inner">
              <div className="flashcard-front">
                <div className="card-content" style={{ width: "100%", textAlign: "left", alignItems: "flex-start" }}>
                {mc ? (
                  <>
                    {mc.before && (
                      <CardContent
                        text={mc.before}
                        cardImageUrl={currentCard.imageUrl}
                        codeTheme={codeTheme}
                      />
                    )}
                    <div
                      className="mc-options"
                      style={{ "--pb-accent": subjectColor.accent }}
                    >
                      {mc.options.map((opt, optIndex) => {
                        const revealed = mcSelection !== null;
                        const isCorrect = opt.isCorrect;
                        const isSelected = mcSelection === opt.letter;
                        return (
                          <motion.button
                            key={`${opt.origLetter || opt.badge}-${optIndex}`}
                            initial={{ opacity: 0, y: 8 }}
                            animate={{ opacity: 1, y: 0 }}
                            transition={{ duration: 0.2, delay: optIndex * 0.04 }}
                            whileHover={!revealed ? { scale: 1.01, x: 2 } : {}}
                            whileTap={!revealed ? { scale: 0.99 } : {}}
                            className={`mc-option ${
                              revealed ? (isCorrect ? "correct" : isSelected ? "wrong" : "") : ""
                            }`}
                            disabled={revealed}
                            onClick={(e) => {
                              e.stopPropagation();
                              if (mcSelection === null) setMcSelection(opt.letter);
                            }}
                          >
                            <span className="mc-letter">{opt.badge}</span>
                            <span className="mc-text">
                              {opt.text.split(/`([^`]+)`/g).map((part, i) =>
                                i % 2 === 1 ? (
                                  <code key={i} className="inline-code">
                                    {part}
                                  </code>
                                ) : part ? (
                                  <span key={i}>{part}</span>
                                ) : null,
                              )}
                            </span>
                            {revealed && (isCorrect || isSelected) && (
                              <span className="mc-icon">
                                {isCorrect ? "✓" : "✗"}
                              </span>
                            )}
                          </motion.button>
                        );
                      })}
                    </div>
                    {mc.after && (
                      <CardContent
                        text={mc.after}
                        cardImageUrl={currentCard.imageUrl}
                        codeTheme={codeTheme}
                      />
                    )}
                    {/* Respuesta revelada bajo las opciones tras elegir */}
                    {mcSelection !== null && (
                      <div className="mc-answer-card">
                        <div className="mc-answer-header">
                          <span className="mc-answer-badge">
                            {mcSelection === mc.correctLetter ? "✓ Correcto" : "✗ Incorrecto"}
                          </span>
                          <span className="mc-answer-title">Solución y Explicación</span>
                        </div>
                        <div className="mc-answer-body">
                          <CardContent
                            text={currentCard.back}
                            cardImageUrl={currentCard.imageUrl}
                            codeTheme={codeTheme}
                          />
                        </div>
                      </div>
                    )}
                  </>
                ) : (
                  <CardContent
                    text={currentCard.front}
                    cardImageUrl={currentCard.imageUrl}
                    codeTheme={codeTheme}
                  />
                )}
                {(() => {
                  const hint = extractCodeHint(currentCard.back);
                  if (!hint || mc) return null; // en opciones la respuesta sale bajo ellas
                  return (
                    <div className="card-code-hint">
                      <span className="hint-label">Ejemplo relacionado</span>
                      <div className="hint-code-block">
                        <SyntaxHighlighter
                          language={hint.lang}
                          style={codeTheme}
                          customStyle={{
                            margin: "0",
                            borderRadius: "6px",
                            fontSize: "0.85rem",
                            lineHeight: "1.5",
                            background: "#0d0d0d",
                            padding: "10px 14px",
                          }}
                          wrapLongLines={true}
                        >
                          {hint.code}
                        </SyntaxHighlighter>
                      </div>
                    </div>
                  );
                })()}
              </div>
            </div>
            <div className="flashcard-back">
              <div className="card-content card-content-code" style={{ width: "100%", textAlign: "left", alignItems: "flex-start" }}>
                <div style={{ width: "100%", textAlign: "left" }}>
                  <CardContent text={currentCard.back} cardImageUrl={currentCard.imageUrl} codeTheme={codeTheme} />
                </div>
              </div>
            </div>
          </div>
        </div>
      </motion.div>
    </div>

      <AnimatePresence>
        {(isFlipped || (mc && mcSelection !== null)) ? (
          <motion.div
            className="rating-buttons"
            initial={{ opacity: 0, y: 16 }}
            animate={{ opacity: 1, y: 0 }}
            exit={{ opacity: 0, y: 16 }}
            transition={{ duration: 0.22, ease: "easeOut" }}
          >
            <motion.button
              whileHover={{ scale: 1.03 }}
              whileTap={{ scale: 0.97 }}
              className="rating-btn hard"
              onClick={() => handleRate(DIFFICULTY.PROCESANDO)}
            >
              Otra vez
            </motion.button>
            <motion.button
              whileHover={{ scale: 1.03 }}
              whileTap={{ scale: 0.97 }}
              className="rating-btn good"
              onClick={() => handleRate(DIFFICULTY.APRENDIDO)}
            >
              Aprendido
            </motion.button>
          </motion.div>
        ) : (
          <div style={{ height: "60px" }}></div>
        )}
      </AnimatePresence>
    </div>
  );
}
