import { useState, useEffect, useCallback, useRef } from "react";
import { DIFFICULTY } from "../model/Deck";
import { Prism as SyntaxHighlighter } from "react-syntax-highlighter";
import { shadesOfPurple } from "react-syntax-highlighter/dist/esm/styles/prism";

// Componente para video YouTube: thumbnail -> iframe al click
function YouTubeEmbed({ videoId, label, stopPropagation }) {
  const [loaded, setLoaded] = useState(false);
  const handleClick = (e) => {
    e.stopPropagation();
    setLoaded(true);
  };
  if (loaded) {
    return (
      <div className="youtube-embed-wrapper" onClick={(e) => e.stopPropagation()}>
        <iframe
          className="youtube-embed"
          src={`https://www.youtube.com/embed/${videoId}?rel=0&autoplay=1`}
          title={label}
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          allowFullScreen
        />
      </div>
    );
  }
  return (
    <div className="youtube-thumb-link" onClick={handleClick}>
      <div className="youtube-thumb-wrapper">
        <img
          className="youtube-thumb"
          src={`https://img.youtube.com/vi/${videoId}/mqdefault.jpg`}
          alt={label}
          loading="lazy"
        />
        <div className="youtube-play-overlay">
          <svg viewBox="0 0 68 48" className="youtube-play-icon">
            <path d="M66.52,7.74c-0.78-2.93-2.49-5.41-5.42-6.19C55.79,.13,34,0,34,0S12.21,.13,6.9,1.55 C3.97,2.33,2.27,4.81,1.48,7.74C0.06,13.05,0,24,0,24s0.06,10.95,1.48,16.26c0.78,2.93,2.49,5.41,5.42,6.19 C12.21,47.87,34,48,34,48s21.79-0.13,27.1-1.55c2.93-0.78,4.64-3.26,5.42-6.19C67.94,34.95,68,24,68,24S67.94,13.05,66.52,7.74z" fill="#212121" fillOpacity="0.8"/>
            <path d="M 45,24 27,14 27,34" fill="#fff"/>
          </svg>
        </div>
        <span className="youtube-thumb-label">{label}</span>
      </div>
    </div>
  );
}

// Tema personalizado: mismo que shadesOfPurple pero con comentarios en celeste
const codeTheme = {
  ...shadesOfPurple,
  'comment': { color: '#7ec8e3', fontStyle: 'italic' },
  'prolog': { color: '#7ec8e3' },
  'doctype': { color: '#7ec8e3' },
  'cdata': { color: '#7ec8e3' },
};

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
    const newCards = deck.getNewCards().slice(0, 10); // Máximo 10 nuevas por sesión

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

  // Normaliza texto: los datos usan 'n' literal como marcador de newline
  const normalizeText = (text) => {
    if (!text) return "";
    let result = text.replace(/\\n/g, "\n").replace(/\\t/g, "\t");

    // Convierte n literal → newline dentro de bloques ```langn...n```
    result = result.replace(
      /```\s*(\w+)\s*n([\s\S]*?)n```/gi,
      (match, lang, codeContent) => {
        let c = codeContent;
        c = c.replace(/nn/g, "\n\n");
        // Solo n precedido de ;{}[](), espacio o inicio (no parte de una palabra)
        c = c.replace(/(?<=^|[;{}\[\],()\s])n/g, "\n");
        c = c.replace(/\n{3,}/g, "\n\n");
        return "```" + lang + "\n" + c.trim() + "\n```";
      },
    );

    // Fuera de bloques: nn y n antes de cierre
    result = result
      .replace(/nn/g, "\n\n")
      .replace(/(?<=^|[;{}\[\],()\s])n(?=```)/g, "\n")
      .replace(/\n{3,}/g, "\n\n");

    return result;
  };

  // Extrae un ejemplo de código del back para mostrar como pista en el front
  const extractCodeHint = (backText) => {
    if (!backText) return null;
    const normalized = normalizeText(backText);
    // Buscar primer bloque de código
    const blockMatch = normalized.match(/```(\w*)\n([\s\S]*?)```/);
    if (blockMatch) {
      const lang = blockMatch[1] || "javascript";
      const lines = blockMatch[2]
        .split("\n")
        .filter((l) => l.trim().length > 0);
      if (lines.length > 0) {
        // Tomar hasta 3 líneas para el ejemplo
        const hintLines = lines.slice(0, 3);
        return { code: hintLines.join("\n"), lang };
      }
    }
    // Si no hay bloque, buscar código inline
    const inlineMatch = normalized.match(/`([^`]{5,50})`/);
    if (inlineMatch) {
      return { code: inlineMatch[1], lang: "javascript" };
    }
    return null;
  };

  // Renderiza código inline con estilo VSCode
  const renderInlineCode = (code, key) => (
    <code key={key} className="inline-code">
      {code}
    </code>
  );

  // Render text and wrap different parentheses types with colored spans
  const renderTextWithParens = (text, baseKey) => {
    if (!text) return [];
    // Split keeping parentheses characters
    const tokens = text.split(/([()\[\]{}<>])/g);
    return tokens
      .map((t, i) => {
        if (!t) return null;
        const key = `${baseKey}-${i}`;
        switch (t) {
          case "(":
          case ")":
            return (
              <span key={key} className="paren paren-round">
                {t}
              </span>
            );
          case "[":
          case "]":
            return (
              <span key={key} className="paren paren-square">
                {t}
              </span>
            );
          case "{":
          case "}":
            return (
              <span key={key} className="paren paren-curly">
                {t}
              </span>
            );
          case "<":
          case ">":
            return (
              <span key={key} className="paren paren-angle">
                {t}
              </span>
            );
          default:
            // Detectar URLs en medio del texto y convertirlas en enlaces clicables
            const urlWithinRegex = /(https?:\/\/[^\s]+|\/[^\s]+)/g;
            const parts = t.split(urlWithinRegex);
            if (parts.length > 1) {
              return parts.map((part, pi) => {
                if (urlWithinRegex.test(part)) {
                  urlWithinRegex.lastIndex = 0;
                  return (
                    <a key={`${key}-url-${pi}`} href={part} target="_blank" rel="noopener noreferrer" className="card-link" onClick={(e) => e.stopPropagation()}>
                      {part}
                    </a>
                  );
                }
                return part;
              });
            }
            const fullTokenRegex = /^(https?:\/\/[^\s]+|\/[^\s]+)$/;
            if (fullTokenRegex.test(t)) {
              return (
                <a key={key} href={t} target="_blank" rel="noopener noreferrer" className="card-link" onClick={(e) => e.stopPropagation()}>
                  {t}
                </a>
              );
            }
            return t;
        }
      })
      .filter(Boolean);
  };

  // Función para procesar texto y resaltar código
  const renderCardContent = (text, cardImageUrl) => {
    if (!text) return null;

    const normalized = normalizeText(text);
    const lines = normalized.split("\n");
    const elements = [];
    let codeBlock = null;
    let codeLines = [];

    // Procesa una línea de texto como párrafo individual
    const processLine = (line, keyIdx) => {
      if (!line.trim()) return;

      // Procesa enlaces markdown [texto](url) ANTES de dividir por paréntesis
      const mdLinkRegex = /\[([^\]]+)\]\(([^)]+)\)/g;
      const linkParts = [];
      let lastMdIdx = 0;
      let mdMatch;
      while ((mdMatch = mdLinkRegex.exec(line)) !== null) {
        if (mdMatch.index > lastMdIdx) {
          linkParts.push(line.slice(lastMdIdx, mdMatch.index));
        }
        linkParts.push({ type: "link", text: mdMatch[1], url: mdMatch[2] });
        lastMdIdx = mdMatch.index + mdMatch[0].length;
      }
      if (lastMdIdx < line.length) {
        linkParts.push(line.slice(lastMdIdx));
      }

      const isSubtitle = /^(?:[¿¡]?[A-ZÁÉÍÓÚÑ]|\d+\.\s*)[A-Za-zÁÉÍÓÚÑáéíóúñ0-9 (),./@]{0,70}[:?]$/.test(line.trim());
      const pClassName = isSubtitle ? "card-text-paragraph card-subtitle" : "card-text-paragraph";

      // Si hay enlaces markdown, usa el nuevo pipeline
      if (linkParts.some((p) => typeof p === "object")) {
        const mixed = linkParts.map((part, lpi) => {
          if (typeof part === "object" && part.type === "link") {
            // Detectar YouTube y mostrar thumbnail con overlay play
            const ytMatch = part.url.match(/(?:youtube\.com\/watch\?v=|youtu\.be\/)([a-zA-Z0-9_-]{11})/);
            if (ytMatch) {
              const videoId = ytMatch[1];
              return (
                <YouTubeEmbed
                  key={`mdlink-${keyIdx}-${lpi}`}
                  videoId={videoId}
                  label={part.text}
                  stopPropagation={true}
                />
              );
            }
            return (
              <a
                key={`mdlink-${keyIdx}-${lpi}`}
                href={part.url}
                target="_blank"
                rel="noopener noreferrer"
                className="card-link"
                onClick={(e) => e.stopPropagation()}
              >
                {part.text}
              </a>
            );
          }
          // Procesar inline code y paréntesis en el texto sobrante
          const innerParts = part.split(/`([^`]+)`/g);
          return innerParts.map((inner, ii) => {
            if (ii % 2 === 1) {
              return renderInlineCode(inner, `md-inline-${keyIdx}-${lpi}-${ii}`);
            } else if (inner) {
              return renderTextWithParens(
                inner,
                `md-p-${keyIdx}-${lpi}-${ii}`,
              );
            }
            return null;
          });
        });

        elements.push(
          <p key={`text-${keyIdx}`} className={pClassName} style={{textAlign: 'left'}}>
            {mixed}
          </p>,
        );
        return;
      }

      // Divide la línea en partes para detectar código inline \\`...\\`
      const parts = line.split(/`([^`]+)`/g);
      const mixed = [];
      parts.forEach((part, idx) => {
        if (idx % 2 === 1) {
          mixed.push(renderInlineCode(part, `inline-${keyIdx}-${idx}`));
        } else if (part) {
          // Replace parentheses characters with colored spans
          const parenNodes = renderTextWithParens(
            part,
            `p-${keyIdx}-${idx}`,
          );
          mixed.push(...parenNodes);
        }
      });

      elements.push(
        <p key={`text-${keyIdx}`} className={pClassName} style={{textAlign: 'left'}}>
          {mixed}
        </p>,
      );
    };

    // Colector de secciones Mermaid (diagrama + resumen bajo botón)
    let pendingMermaid = null; // { code, summaryLines: [] }

    const flushMermaid = (keySuffix) => {
      if (!pendingMermaid) return;

      elements.push(
        <div key={`mermaid-${keySuffix}`} className="code-block-wrapper">
          <div className="mermaid-img-wrapper">
            <img
              className="mermaid-img"
              src={cardImageUrl || `https://mermaid.ink/img/${btoa(unescape(encodeURIComponent(pendingMermaid.code)))}?bgColor=!black`}
              alt="Diagrama"
              onError={(e) => {
                e.target.style.display = "none";
                e.target.nextSibling.style.display = "block";
              }}
            />
            <div className="mermaid-img-fallback" style={{ display: "none" }}>
              <SyntaxHighlighter
                language={"mermaid"}
                style={codeTheme}
                customStyle={{
                  margin: "0",
                  borderRadius: "0",
                  fontSize: "1.1rem",
                  lineHeight: "1.6",
                  background: "#1e1e1e",
                  padding: "16px 20px",
                }}
                wrapLongLines={true}
              >
                {pendingMermaid.code}
              </SyntaxHighlighter>
            </div>
          </div>
        </div>,
      );
      // Process summary lines through the normal pipeline for markdown/YouTube support
      pendingMermaid.summaryLines.forEach((line, i) => {
        processLine(line, `mermaid-summary-${keySuffix}-${i}`);
      });
      pendingMermaid = null;
    };

    // Procesa acumulador de bloque de código
    const flushCode = (keySuffix) => {
      if (codeLines.length === 0) return;
      const code = codeLines.join("\n");
      const lang = codeBlock || "text";
      codeLines = [];
      codeBlock = null;

      // Flush any pending mermaid before this new code block
      flushMermaid(`before-${keySuffix}`);

      if (lang === "mermaid") {
        pendingMermaid = { code, summaryLines: [] };
        return; // Don't render now – start collecting summary lines
      }

      elements.push(
        <div key={`code-${keySuffix}`} className="code-block-wrapper">
          <div className="code-block-header">
            <span className="code-lang-label">{lang}</span>
          </div>
          <SyntaxHighlighter
            language={lang}
            style={codeTheme}
            customStyle={{
              margin: "0",
              borderRadius: "0 0 8px 8px",
              fontSize: "1.1rem",
              lineHeight: "1.6",
              background: "#1e1e1e",
              padding: "16px 20px",
            }}
            wrapLongLines={true}
          >
            {code}
          </SyntaxHighlighter>
        </div>,
      );
    };

    let prevLineWasBlank = false;
    lines.forEach((line, index) => {
      const trimmed = line.trim();
      const codeBlockStart = line.match(/^```(\w+)?$/);
      const codeBlockEnd = trimmed === "```";
      const isBlank = !trimmed;

      // Si estamos recolectando resumen de un mermaid…
      if (pendingMermaid && !isBlank && !codeBlockStart) {
        // ¿Separador --- ? → fin de colección
        if (trimmed === "---" || trimmed === "___" || trimmed === "***") {
          flushMermaid(`sep-${index}`);
          return;
        }
        // Seguir recolectando líneas de texto
        pendingMermaid.summaryLines.push(line);
        prevLineWasBlank = false;
        return;
      }

      prevLineWasBlank = isBlank;

      if (codeBlockStart && !codeBlock) {
        codeBlock = codeBlockStart[1] || "text";
      } else if (codeBlockEnd && codeBlock) {
        flushCode(index);
      } else if (codeBlock) {
        codeLines.push(line);
      } else {
        processLine(line, index);
      }
    });

    flushCode("final");
    flushMermaid("final");

    return elements;
  };

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
          <h2>{deck.name}</h2>
          <div></div>
        </div>

        <div className="empty-study">
          <div className="empty-icon">🎉</div>
          <h3>No hay tarjetas pendientes</h3>
          <p>Has completado todas las tarjetas de este mazo por ahora.</p>
          <div className="empty-actions">
            <button className="btn btn-secondary" onClick={onBack}>
              Volver a mazos
            </button>
            <button
              className="btn btn-primary"
              onClick={() => {
                // Repasar todo el mazo de nuevo
                setCards(deck.cards);
                setCurrentCardIndex(0);
                setIsFlipped(false);
              }}
            >
              Repasar todo el mazo
            </button>
          </div>
        </div>
      </div>
    );
  }

  if (showComplete) {
    const total =
      sessionStats.again +
      sessionStats.hard +
      sessionStats.good +
      sessionStats.easy;
    const accuracy = Math.round(
      ((sessionStats.good + sessionStats.easy) / total) * 100,
    );

    return (
      <div className="study-view animate-fade-in">
        <div className="complete-view">
          <div className="complete-icon">🎊</div>
          <h2>¡Sesion completada!</h2>
          <p className="complete-subtitle">Has estudiado {total} tarjetas</p>

          <div className="session-stats">
            <div className="session-stat good">
              <span className="session-stat-value">{sessionStats.good}</span>
              <span className="session-stat-label">Procesando</span>
            </div>
            <div className="session-stat easy">
              <span className="session-stat-value">{sessionStats.easy}</span>
              <span className="session-stat-label">Aprendido</span>
            </div>
          </div>

          <div className="accuracy-display">
            <div className="accuracy-value">{accuracy}%</div>
            <div className="accuracy-label">Precisión</div>
          </div>

          <div className="complete-actions">
            <button className="btn btn-secondary" onClick={onBack}>
              Volver a mazos
            </button>
            <button
              className="btn btn-primary"
              onClick={() => window.location.reload()}
            >
              Estudiar de nuevo
            </button>
          </div>
        </div>
      </div>
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
                {renderCardContent(currentCard.front)}
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
                  {renderCardContent(currentCard.back, currentCard.imageUrl)}
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
