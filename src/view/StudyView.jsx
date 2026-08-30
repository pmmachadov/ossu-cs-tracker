import { useState, useEffect, useCallback, useRef, useMemo } from "react";
import { motion, AnimatePresence } from "motion/react";
import { DIFFICULTY } from "../model/Deck";

import { Prism as SyntaxHighlighter } from "react-syntax-highlighter";
import { CardContent, codeTheme, extractCodeHint } from "./CardContent";
import { getSubjectColor } from "./deckHelpers";
import { useBorderSpeed } from "./useBorderSpeed";
import { SessionComplete } from "./SessionComplete";
import { EmptyStudyView } from "./EmptyStudyView";
import { GoogleAura } from "./GoogleAura";
import { triggerStarCelebration } from "./StarCelebration";

import "./StudyView.css";

// --- Opción múltiple / Verdadero-Falso interactivos ---
const MC_OPTION_RE = /^([a-hA-H])\s*[\)\.]\s*(.+)$/;

function stripCodeBlocks(text) {
  return (text || "").replace(/```[\s\S]*?```/g, "\n");
}

function analyzeMultipleChoice(front, back) {
  // Solo cards con opciones tipo "a) ...", "b) ..." en el frente.
  // Se recorren las líneas ORIGINALES (con su código) y solo se ignoran
  // las opciones que estén dentro de un bloque ```...```.
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

  // La respuesta correcta es la primera opción del dorso (p. ej. "a) ...", "✓ **a) ...**", "a) ...")
  let correctLetter = null;
  const backClean = stripCodeBlocks(back).replace(/[*_~`✓]/g, "");
  for (const line of backClean.split("\n")) {
    const m = line.trim().match(MC_OPTION_RE);
    if (m) {
      correctLetter = m[1].toLowerCase();
      break;
    }
  }
  if (!correctLetter) return null;

  return {
    options: matches.map((m) => ({
      letter: m.letter,
      text: m.text,
      badge: m.letter,
    })),
    correctLetter,
    before: frontLines.slice(0, matches[0].index).join("\n").trim(),
    after: frontLines.slice(matches[matches.length - 1].index + 1).join("\n").trim(),
  };
}

function analyzeAnswerOptions(front, back) {
  // 1) Opción múltiple (a, b, c, d...)
  const mc = analyzeMultipleChoice(front, back);
  if (mc) return mc;

  // 2) Verdadero / Falso: alguna de las primeras líneas del dorso
  //    empieza por "Verdadero" o "Falso" (las backs llevan prefijo
  //    "RESPUESTA / SOLUCIÓN" u otras cabeceras)
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
    return {
      options: [
        { letter: "V", text: "Verdadero", badge: "V" },
        { letter: "F", text: "Falso", badge: "F" },
      ],
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

  // Drag-to-scroll para la fila de puntos
  const dotsContainerRef = useRef(null);
  const isDragging = useRef(false);
  const startX = useRef(0);
  const startCardIndex = useRef(0);
  const dragMoved = useRef(false);

  // Velocidad lineal de los colores del borde según su longitud real
  const borderSpeed = useBorderSpeed();

  const handleMouseDown = (e) => {
    if (!dotsContainerRef.current || cards.length === 0) return;
    isDragging.current = true;
    dragMoved.current = false;
    startX.current = e.clientX;
    startCardIndex.current = currentCardIndex;
  };

  const handleMouseMove = (e) => {
    if (!isDragging.current || !dotsContainerRef.current || cards.length === 0)
      return;
    const rect = dotsContainerRef.current.getBoundingClientRect();
    const deltaX = e.clientX - startX.current;
    const pxPerCard = rect.width / cards.length;
    const deltaCards = Math.round(deltaX / pxPerCard);
    const newIndex = Math.max(
      0,
      Math.min(cards.length - 1, startCardIndex.current + deltaCards),
    );
    if (Math.abs(newIndex - currentCardIndex) > 0 || Math.abs(deltaX) > 3) {
      dragMoved.current = true;
    }
    if (newIndex !== currentCardIndex) {
      setCurrentCardIndex(newIndex);
      setIsFlipped(false);
      setFlipRotation(0);
    }
  };

  const handleMouseUp = () => {
    isDragging.current = false;
  };

  const handleTouchStart = (e) => {
    if (!dotsContainerRef.current || cards.length === 0) return;
    isDragging.current = true;
    dragMoved.current = false;
    startX.current = e.touches[0].clientX;
    startCardIndex.current = currentCardIndex;
  };

  const handleTouchMove = (e) => {
    if (!isDragging.current || !dotsContainerRef.current || cards.length === 0)
      return;
    const rect = dotsContainerRef.current.getBoundingClientRect();
    const deltaX = e.touches[0].clientX - startX.current;
    const pxPerCard = rect.width / cards.length;
    const deltaCards = Math.round(deltaX / pxPerCard);
    const newIndex = Math.max(
      0,
      Math.min(cards.length - 1, startCardIndex.current + deltaCards),
    );
    if (Math.abs(newIndex - currentCardIndex) > 0 || Math.abs(deltaX) > 3) {
      dragMoved.current = true;
    }
    if (newIndex !== currentCardIndex) {
      setCurrentCardIndex(newIndex);
      setIsFlipped(false);
      setFlipRotation(0);
    }
  };

  const handleTouchEnd = () => {
    isDragging.current = false;
  };

  const handleDotClick = (index) => {
    if (dragMoved.current) return;
    setCurrentCardIndex(index);
    setIsFlipped(false);
    setFlipRotation(0);
  };

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

  // Análisis de opciones de la tarjeta actual (opción múltiple o V/F; null si no aplica)
  // En el mazo de Ejercicios, TODAS las tarjetas son tarjetas de desarrollo/análisis con giro 3D completo
  const mc = useMemo(
    () =>
      currentCard && deck?.id !== "examen-java-ejercicios"
        ? analyzeAnswerOptions(currentCard.front, currentCard.back)
        : null,
    [currentCard, deck?.id],
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
        // Lanzar animación de estrellas por 3 segundos
        triggerStarCelebration();

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
          ref={(el) => {
            dotsContainerRef.current = el;
            borderSpeed("track", 0.85)(el);
          }}
          className={`card-progress-track ${isFirstTenSeconds ? "google-active" : "google-expired"}`}
          style={{ "--card-count": cards.length }}
          onMouseDown={handleMouseDown}
          onMouseMove={handleMouseMove}
          onMouseUp={handleMouseUp}
          onMouseLeave={handleMouseUp}
          onTouchStart={handleTouchStart}
          onTouchMove={handleTouchMove}
          onTouchEnd={handleTouchEnd}
        >
          <div
            className={`card-progress-fill ${showPctGlow ? "pct-glow-active" : "pct-glow-off"}`}
            style={{ width: `${Math.max(masteryPct, 0)}%` }}
            ref={borderSpeed("fill", 1.4)}
          >
            <span className="bento-fill-pct-badge">{masteryPct}%</span>
          </div>
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
                <div className="card-content">
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
                        const isCorrect = opt.letter === mc.correctLetter;
                        return (
                          <motion.button
                            key={opt.letter}
                            initial={{ opacity: 0, y: 8 }}
                            animate={{ opacity: 1, y: 0 }}
                            transition={{ duration: 0.2, delay: optIndex * 0.04 }}
                            whileHover={!revealed ? { scale: 1.01, x: 2 } : {}}
                            whileTap={!revealed ? { scale: 0.99 } : {}}
                            className={`mc-option ${
                              revealed ? (isCorrect ? "correct" : "wrong") : ""
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
                            {revealed && (
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
              <div className="card-content card-content-code">
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
