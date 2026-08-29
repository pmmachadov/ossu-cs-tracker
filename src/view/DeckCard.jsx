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