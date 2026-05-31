import { useState, useEffect, useCallback, useRef } from "react";
import { DIFFICULTY } from "../model/Deck";
import { NEW_CARDS_PER_SESSION } from "../config";

import { Prism as SyntaxHighlighter } from "react-syntax-highlighter";
import { CardContent, codeTheme, extractCodeHint } from "./CardContent";
import { SessionComplete } from "./SessionComplete";
import { EmptyStudyView } from "./EmptyStudyView";

import "./StudyView.css";

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

  // Drag-to-scroll para la fila de puntos
  const dotsContainerRef = useRef(null);
  const isDragging = useRef(false);
  const startX = useRef(0);
  const startCardIndex = useRef(0);
  const dragMoved = useRef(false);

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

  // Preparar tarjetas para estudio (solo las pendientes, sin duplicados)
  useEffect(() => {
    const dueCards = deck.getDueCards();
    const learningCards = deck.getLearningCards();
    const newCards = deck.getNewCards().slice(0, NEW_CARDS_PER_SESSION);

    // Evitar duplicados: una carta puede estar en dueCards (isDue=true)
    // y también en learningCards (status=relearning). Usamos un Map
    // para que el primer origen (dueCards) tenga prioridad.
    const studyCards = [...new Map(
      [...dueCards, ...learningCards, ...newCards]
        .map(c => [c.id, c])
    ).values()];
    setCards(studyCards);
    setCurrentCardIndex(0);
    setIsFlipped(false);
    setShowComplete(false);
  }, [deck]);

  const currentCard = cards[currentCardIndex];
  const progress =
    cards.length > 0 ? (currentCardIndex / cards.length) * 100 : 0;

  const handleFlip = () => {
    setIsFlipped(!isFlipped);
    setFlipRotation((prev) => prev + 180);
  };

  const handleRate = useCallback(
    (difficulty) => {
      if (!currentCard) return;

      // Actualizar tarjeta
      const result = currentCard.review(difficulty);

      // Actualizar estadísticas de sesión
      setSessionStats((prev) => ({
        ...prev,
        [Object.keys(DIFFICULTY)[difficulty].toLowerCase()]:
          prev[Object.keys(DIFFICULTY)[difficulty].toLowerCase()] + 1,
      }));

      // Guardar progreso y estadísticas
      deck.recordReview(difficulty);
      onUpdateDeck(deck);

      // Siguiente tarjeta
      if (currentCardIndex < cards.length - 1) {
        setCurrentCardIndex((prev) => prev + 1);
        setIsFlipped(false);
        setFlipRotation(0);
      } else {
        setShowComplete(true);
      }
    },
    [currentCard, currentCardIndex, cards.length, deck, onUpdateDeck],
  );

  // Scroll al inicio cuando cambia la tarjeta
  useEffect(() => {
    window.scrollTo({ top: 0, behavior: "smooth" });
  }, [currentCardIndex]);

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
        handleFlip();
      } else if (isFlipped) {
        switch (e.key) {
          case "1":
            handleRate(DIFFICULTY.AGAIN);
            break;
          case "2":
            handleRate(DIFFICULTY.HARD);
            break;
          case "3":
            handleRate(DIFFICULTY.GOOD);
            break;
          case "4":
            handleRate(DIFFICULTY.EASY);
            break;
        }
      }
    };

    window.addEventListener("keydown", handleKeyDown);
    return () => window.removeEventListener("keydown", handleKeyDown);
  }, [isFlipped, handleFlip, handleRate, showComplete]);

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
      <div className="study-header">
        <button className="btn btn-back" onClick={onBack}>
          <svg
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            strokeWidth="2"
            strokeLinecap="round"
            strokeLinejoin="round"
            style={{ width: "20px", height: "20px" }}
          >
            <line x1="19" y1="12" x2="5" y2="12" />
            <polyline points="12 19 5 12 12 5" />
          </svg>
          <span>Volver</span>
        </button>
        <div className="study-info">
          <h2>{deck.name}</h2>
        </div>
        <div></div>
      </div>

      {/* Card Progress Bar */}
      <div className="card-progress-wrapper">
        <div
          ref={dotsContainerRef}
          className="card-progress-track"
          onMouseDown={handleMouseDown}
          onMouseMove={handleMouseMove}
          onMouseUp={handleMouseUp}
          onMouseLeave={handleMouseUp}
          onTouchStart={handleTouchStart}
          onTouchMove={handleTouchMove}
          onTouchEnd={handleTouchEnd}
        >
          <div
            className="card-progress-fill"
            style={{
              width: `${
                cards.length > 1
                  ? (currentCardIndex / (cards.length - 1)) * 100
                  : 100
              }%`,
            }}
          >
            <div className="card-progress-thumb" />
          </div>
        </div>
      </div>

      <div className="flashcard-container">
        <div
          key={currentCardIndex}
          className="flashcard"
          onClick={handleFlip}
          style={{ transform: `rotateY(${flipRotation}deg)` }}
        >
          <div className="flashcard-inner">
            <div className="flashcard-front">
              <div className="card-content">
                <CardContent text={currentCard.front} cardImageUrl={currentCard.imageUrl} codeTheme={codeTheme} />
                {(() => {
                  const hint = extractCodeHint(currentCard.back);
                  if (!hint) return null;
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
      </div>

      {isFlipped ? (
        <div className="rating-buttons">
          <button
            className="rating-btn good"
            onClick={() => handleRate(DIFFICULTY.GOOD)}
          >
            Procesando
          </button>
          <button
            className="rating-btn easy"
            onClick={() => handleRate(DIFFICULTY.EASY)}
          >
            Aprendido
          </button>
        </div>
      ) : (
        <div style={{ height: "60px" }}></div>
      )}
    </div>
  );
}
