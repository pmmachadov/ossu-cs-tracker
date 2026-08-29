import { useMemo } from "react";
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

  // Estrellas en la barra de progreso que rotan a diferentes velocidades
  const stars = useMemo(() => {
    return [
      { id: 1, size: 8, top: 12, opacity: 0.9, drift: 6.5, rotate: 1.8, dir: "normal", delay: -1.2 },
      { id: 2, size: 6, top: 28, opacity: 0.75, drift: 8.5, rotate: 4.2, dir: "reverse", delay: -3.8 },
      { id: 3, size: 9, top: 15, opacity: 0.95, drift: 5.5, rotate: 2.6, dir: "normal", delay: -2.1 },
      { id: 4, size: 7, top: 32, opacity: 0.8, drift: 9.0, rotate: 3.5, dir: "reverse", delay: -4.5 },
      { id: 5, size: 5, top: 20, opacity: 0.7, drift: 10.5, rotate: 5.8, dir: "normal", delay: -0.8 },
      { id: 6, size: 7, top: 10, opacity: 0.85, drift: 7.8, rotate: 2.1, dir: "reverse", delay: -5.2 },
    ];
  }, [deck.id]);

  const status = doneMap[deck.id];
  const isProgress = status === "progress";
  const isDone = status === true;

  return (
    <div
      key={deck.id}
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

        {/* Progress Bar */}
        <div className="deck-progress">
          <div className="progress-info">
            <span className="progress-label">Progreso</span>
            <span className="progress-value">{stats.mastery}%</span>
          </div>
          <div className="progress-bar">
            <div
              className="progress-fill"
              style={{ width: `${stats.mastery}%` }}
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
                    "--drift-duration": `${s.driftDuration || s.drift}s`,
                    "--rotate-duration": `${s.rotateDuration || s.rotate}s`,
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
            <div className="stat-icon-small icon-total">{Icons.cards}</div>
            <div className="stat-info">
              <span className="stat-number">{stats.total}</span>
              <span className="stat-text">total</span>
            </div>
          </div>
          <div className="deck-stat" title="Nuevas">
            <div className="stat-icon-small icon-new">{Icons.newCard}</div>
            <div className="stat-info">
              <span className="stat-number">{stats.new}</span>
              <span className="stat-text">nuevas</span>
            </div>
          </div>
          <div className="deck-stat" title="Aprendidas">
            <div className="stat-icon-small icon-review">{Icons.review}</div>
            <div className="stat-info">
              <span className="stat-number">{stats.aprendido}</span>
              <span className="stat-text">aprendidas</span>
            </div>
          </div>
        </div>

        {/* Actions */}
        <div className="deck-actions">
          <button
            className="btn btn-primary btn-study"
            onClick={() => onStudyDeck(deck)}
          >
            <span className="btn-icon">{Icons.study}</span>
            <span>Estudiar</span>
          </button>
          <button
            className="btn btn-icon-only btn-stats"
            onClick={() => onStatsDeck(deck)}
            title="Ver estadísticas"
          >
            {Icons.stats}
          </button>
          <button
            className="btn btn-icon-only btn-edit"
            onClick={() => onEditDeck(deck)}
            title="Editar mazo"
          >
            {Icons.edit}
          </button>
          <button
            className="btn btn-icon-only btn-reset"
            onClick={() => onOpenResetModal(deck)}
            title="Reiniciar progreso"
          >
            {Icons.reset}
          </button>
        </div>
      </div>
    </div>
  );
}