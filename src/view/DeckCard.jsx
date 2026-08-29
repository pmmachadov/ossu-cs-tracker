import { useMemo } from "react";
import { motion } from "motion/react";
import { Icons } from "./Icons";
import { isExamDeck, getSubjectIcon, getSubjectColor } from "./deckHelpers";
import { useBorderSpeed } from "./useBorderSpeed";

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

  // Velocidad lineal de los colores: bordes largos tardan más en recorrerlos.
  const borderSpeed = useBorderSpeed();

  // Desfase único por mazo: botón Estudiar y barra de progreso pulsan y giran
  // en momentos distintos (retardo negativo = ya van a mitad de ciclo).
  const { btnDelay, barDelay } = useMemo(() => {
    let h = 0;
    const s = String(deck.id || "");
    for (let i = 0; i < s.length; i++) h = (h * 31 + s.charCodeAt(i)) >>> 0;
    const btn = -((h % 14) * 0.5); // -0.0s .. -6.5s (ciclo 7s de pulso)
    const bar = -(((h + 7) % 14) * 0.5); // desfasado ~3.5s respecto al botón
    return { btnDelay: `${btn}s`, barDelay: `${bar}s` };
  }, [deck.id]);

  // (Estrellas de la barra de progreso eliminadas)

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
          <div className="progress-bar" style={{ "--bar-delay": barDelay }} ref={borderSpeed("bar")}>
            <div
              className="progress-fill"
              style={{ width: `${Math.max(stats.mastery, 0)}%` }}
            />
            {/* (Estrellas de la barra de progreso eliminadas) */}
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
            style={{ "--btn-delay": btnDelay }}
            ref={borderSpeed("btn")}
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