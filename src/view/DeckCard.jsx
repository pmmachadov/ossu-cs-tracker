import { useMemo } from "react";
import { motion } from "motion/react";
import { Icons } from "./Icons";
import { isExamDeck, getSubjectIcon, getSubjectColor } from "./deckHelpers";

export function DeckCard({
  deck,
  doneMap,
  onToggleDone,
  isExtra,
  theme,
  onStudyDeck,
  onStatsDeck,
  onEditDeck,
  onOpenResetModal,
}) {
  const stats = deck.getStats();
  const subjectIcon = getSubjectIcon(deck.subject);
  const subjectColor = getSubjectColor(deck.subject);
  const hasDueCards = stats.due > 0;
  const themeClass = theme || (isExtra ? "theme-blue" : "");

  // Estrellas brillantes que cruzan y rotan a distintas velocidades
  // Constelación de estrellas que flotan y rotan a diferentes velocidades
  const stars = useMemo(() => {
    return [
      { id: 1, size: 15, top: 18, opacity: 0.95, drift: 6.5, rotate: 1.8, dir: "normal", delay: -0.8 },
      { id: 2, size: 10, top: 48, opacity: 0.8, drift: 9.0, rotate: 4.2, dir: "reverse", delay: -2.5 },
      { id: 3, size: 18, top: 14, opacity: 1.0, drift: 5.5, rotate: 1.4, dir: "normal", delay: -1.8 },
      { id: 4, size: 12, top: 40, opacity: 0.85, drift: 8.5, rotate: 3.2, dir: "reverse", delay: -3.6 },
      { id: 5, size: 9, top: 22, opacity: 0.75, drift: 11.0, rotate: 5.0, dir: "normal", delay: -0.4 },
      { id: 6, size: 14, top: 32, opacity: 0.9, drift: 7.5, rotate: 2.4, dir: "reverse", delay: -4.8 },
      { id: 7, size: 16, top: 16, opacity: 0.95, drift: 6.0, rotate: 1.6, dir: "normal", delay: -2.9 },
      { id: 8, size: 11, top: 52, opacity: 0.85, drift: 9.8, rotate: 3.8, dir: "reverse", delay: -5.4 },
      { id: 9, size: 8, top: 28, opacity: 0.7, drift: 12.0, rotate: 6.0, dir: "normal", delay: -1.2 },
      { id: 10, size: 17, top: 20, opacity: 1.0, drift: 5.8, rotate: 2.1, dir: "reverse", delay: -3.1 },
      { id: 11, size: 13, top: 44, opacity: 0.9, drift: 8.2, rotate: 2.8, dir: "normal", delay: -4.2 },
      { id: 12, size: 10, top: 36, opacity: 0.8, drift: 10.5, rotate: 4.6, dir: "reverse", delay: -6.0 },
      { id: 13, size: 15, top: 12, opacity: 0.95, drift: 6.8, rotate: 1.9, dir: "normal", delay: -7.1 },
      { id: 14, size: 11, top: 50, opacity: 0.85, drift: 9.2, rotate: 3.5, dir: "reverse", delay: -8.0 },
      { id: 15, size: 9, top: 25, opacity: 0.75, drift: 11.5, rotate: 5.2, dir: "normal", delay: -2.0 },
      { id: 16, size: 14, top: 38, opacity: 0.9, drift: 7.8, rotate: 2.6, dir: "reverse", delay: -6.5 },
      { id: 17, size: 12, top: 15, opacity: 0.85, drift: 8.8, rotate: 3.0, dir: "normal", delay: -4.5 },
      { id: 18, size: 16, top: 42, opacity: 0.95, drift: 6.2, rotate: 1.5, dir: "reverse", delay: -9.0 },
    ];
  }, [deck.id]);

  const status = doneMap[deck.id];
  const isProgress = status === "progress";
  const isDone = status === true;

  return (
    <motion.div
      key={deck.id}
      layout
      initial={{ opacity: 0, y: 16 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ duration: 0.25, ease: "easeOut" }}
      className={`deck-card ${hasDueCards ? "has-due" : ""} ${themeClass} ${
        isDone ? "done" : isProgress ? "in-progress" : ""
      }`}
    >
      {/* Apple style done badge */}
      <div
        className={`deck-done-badge ${isDone ? "on" : isProgress ? "progress" : "off"}`}
        title={
          isDone
            ? "Mazo completado"
            : isProgress
              ? "Mazo en progreso"
              : "Mazo pendiente"
        }
        role="button"
        tabIndex={0}
        aria-pressed={isDone ? true : isProgress ? "mixed" : false}
        onClick={() => onToggleDone(deck.id)}
        onKeyDown={(e) => {
          if (e.key === "Enter" || e.key === " ") {
            e.preventDefault();
            onToggleDone(deck.id);
          }
        }}
      >
        <span className="badge-text">
          {isDone ? "Completado" : isProgress ? "En curso" : "Pendiente"}
        </span>
      </div>

      {/* Card Content */}
      <div className="deck-card-content">
        <div className="deck-card-meta">
          {deck.subject && (
            <span className="deck-subject">
              {subjectIcon} {deck.subject}
            </span>
          )}
          {isExamDeck(deck) && (
            <span className="exam-badge">Examen</span>
          )}
          {hasDueCards && (
            <span className="due-badge-inline">
              {stats.due} de {stats.total} pendientes
            </span>
          )}
        </div>

        <div className="deck-card-header">
          <h3 className="deck-name">{deck.name}</h3>
        </div>

        {deck.description && (
          <p className="deck-description">{deck.description}</p>
        )}

        {/* Progress Bar con encanto y mayor altura */}
        <div className="deck-progress">
          <div className="progress-info">
            <span className="progress-label">Progreso</span>
            <span className="progress-value">{stats.mastery}%</span>
          </div>
          <div className="progress-bar">
            <div
              className="progress-fill"
              style={{ width: `${Math.max(stats.mastery, 0)}%` }}
            />
            <div className="stars-layer" aria-hidden="true">
              {stars.map((s) => (
                <span
                  key={s.id}
                  className="drift-star"
                  style={{
                    width: `${s.size}px`,
                    height: `${s.size}px`,
                    top: `${s.top}%`,
                    opacity: s.opacity,
                    "--drift-duration": `${s.drift}s`,
                    "--rotate-duration": `${s.rotate}s`,
                    "--rotate-dir": s.dir,
                    animationDelay: `${s.delay}s`,
                  }}
                >
                  <svg viewBox="0 0 24 24" fill="currentColor">
                    <polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2" />
                  </svg>
                </span>
              ))}
            </div>
          </div>
        </div>

        {/* Stats Row */}
        <div className="deck-stats-row">
          <div className="deck-stat" title="Total de tarjetas del mazo">
            <span className="stat-number">{stats.total}</span>
            <span className="stat-text">total</span>
          </div>
          <div className="deck-stat-divider" />
          <div className="deck-stat" title="Nuevas">
            <span className="stat-number">{stats.new}</span>
            <span className="stat-text">nuevas</span>
          </div>
          <div className="deck-stat-divider" />
          <div className="deck-stat" title="Aprendidas">
            <span className="stat-number">{stats.aprendido}</span>
            <span className="stat-text">aprendidas</span>
          </div>
        </div>

        {/* Actions */}
        <div className="deck-actions">
          <motion.button
            whileHover={{ scale: 1.02 }}
            whileTap={{ scale: 0.97 }}
            className="btn btn-primary btn-study"
            onClick={() => onStudyDeck(deck)}
          >
            <span className="btn-icon">{Icons.study}</span>
            <span>Estudiar</span>
          </motion.button>
          <motion.button
            whileHover={{ scale: 1.08 }}
            whileTap={{ scale: 0.92 }}
            className="btn btn-icon-only btn-stats"
            onClick={() => onStatsDeck(deck)}
            title="Ver estadísticas"
          >
            {Icons.stats}
          </motion.button>
          <motion.button
            whileHover={{ scale: 1.08 }}
            whileTap={{ scale: 0.92 }}
            className="btn btn-icon-only btn-edit"
            onClick={() => onEditDeck(deck)}
            title="Editar mazo"
          >
            {Icons.edit}
          </motion.button>
          <motion.button
            whileHover={{ scale: 1.08 }}
            whileTap={{ scale: 0.92 }}
            className="btn btn-icon-only btn-reset"
            onClick={() => onOpenResetModal(deck)}
            title="Reiniciar progreso"
          >
            {Icons.reset}
          </motion.button>
        </div>
      </div>
    </motion.div>
  );
}