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

  // Estrellas que cruzan la barra de progreso (solo tema examen): varias a la
  // vez, cada una con tamaño, altura, opacidad, velocidad y trayectoria
  // distintos (3 trayectorias distintas repartidas en bucle). left inicial
  // aleatorio: si la animación está desactivada quedan repartidas y visibles.
  const stars = useMemo(() => {
    if (themeClass !== "theme-examen") return [];
    const anims = ["star-drift-a", "star-drift-b", "star-drift-c"];
    return Array.from({ length: 10 }, (_, i) => ({
      id: i,
      size: 10 + Math.random() * 14,
      top: 8 + Math.random() * 72,
      left: 5 + Math.random() * 85,
      opacity: 0.7 + Math.random() * 0.3,
      duration: 4.5 + Math.random() * 5.5,
      delay: -(Math.random() * 10),
      anim: anims[i % anims.length],
    }));
  }, [deck.id, themeClass]);

  const status = doneMap[deck.id];
  const isProgress = status === "progress";
  const isDone = status === true;

  return (
    <div
      key={deck.id}
      className={`deck-card ${hasDueCards ? "has-due" : ""} ${themeClass} ${
        isDone ? "done" : isProgress ? "in-progress" : ""
      }`}
      style={{ borderLeft: `3px solid ${subjectColor.accent}` }}
    >
      {/* Large top-right done badge */}
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
          {isDone ? "Hecho ✓" : isProgress ? "En proceso" : "Pendiente"}
        </span>
      </div>
      {/* Card Content */}
      <div className="deck-card-content">
        {deck.subject && (
          <span
            className="deck-subject"
            style={{ background: subjectColor.badge }}
          >
            {subjectIcon} {deck.subject}
          </span>
        )}
        {isExamDeck(deck) && (
          <span className="exam-badge">📘 Examen</span>
        )}
        {hasDueCards && (
          <div className="due-badge-inline">
            <span>
              {stats.due} de {stats.total} pendientes
            </span>
          </div>
        )}
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
            {stars.length > 0 && (
              <div className="stars-layer" aria-hidden="true">
                {stars.map((s) => (
                  <span
                    key={s.id}
                    className="drift-star"
                    style={{
                      width: `${s.size}px`,
                      height: `${s.size}px`,
                      top: `${s.top}%`,
                      left: `${s.left}%`,
                      opacity: s.opacity,
                      animationDuration: `${s.duration}s`,
                      animationDelay: `${s.delay}s`,
                      animationName: s.anim,
                    }}
                  />
                ))}
              </div>
            )}
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
