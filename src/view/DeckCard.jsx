import { useMemo } from "react";
import { motion } from "motion/react";
import { Icons } from "./Icons";
import { isExamDeck, getSubjectIcon, getSubjectColor } from "./deckHelpers";
import { useBorderSpeed } from "./useBorderSpeed";
import { GoogleAura } from "./GoogleAura";

const PULSE_VARIANTS = [
  "googleFadePulse10", // 10% del tiempo en negro
  "googleFadePulse15", // 15% del tiempo en negro
  "googleFadePulse20", // 20% del tiempo en negro
  "googleFadePulse25", // 25% del tiempo en negro
  "googleFadePulse30", // 30% del tiempo en negro
  "googleFadePulse35", // 35% del tiempo en negro
];

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

  // Variación única de velocidad de recorrido, duración de oscuridad, desfases y expansión de halo (salida de bordes):
  const {
    btnDelay,
    barDelay,
    fillDelay,
    btnFadeDelay,
    barFadeDelay,
    fillFadeDelay,
    btnPulseDuration,
    barPulseDuration,
    fillPulseDuration,
    btnPulseAnim,
    barPulseAnim,
    fillPulseAnim,
    btnSpeedFactor,
    barSpeedFactor,
    fillSpeedFactor,
  } = useMemo(() => {
    let h = 0;
    const s = String(deck.id || "");
    for (let i = 0; i < s.length; i++) h = (h * 31 + s.charCodeAt(i)) >>> 0;

    // Factores de velocidad de recorrido lineal rápidos y ágiles:
    const barSpeedFactor = 1.0 + ((h % 23) / 22) * 0.7;
    const fillSpeedFactor = 1.15 + (((h * 17 + 5) % 29) / 28) * 0.75;
    const btnSpeedFactor = 1.05 + (((h * 13) % 27) / 26) * 0.7;

    // Duración de pulso/oscurecimiento única para cada elemento (6.8s .. 11.8s)
    const btnPulseNum = 6.8 + ((h * 3) % 40) * 0.11;
    const barPulseNum = 7.5 + ((h * 11) % 45) * 0.09;
    const fillPulseNum = 7.0 + ((h * 19 + 7) % 42) * 0.1;

    const btnPulseDuration = `${btnPulseNum.toFixed(2)}s`;
    const barPulseDuration = `${barPulseNum.toFixed(2)}s`;
    const fillPulseDuration = `${fillPulseNum.toFixed(2)}s`;

    // Variante de tiempo en oscuridad distinta para el carril exterior y el relleno:
    const barPulseAnim = PULSE_VARIANTS[h % PULSE_VARIANTS.length];
    const fillPulseAnim = PULSE_VARIANTS[(h + 1) % PULSE_VARIANTS.length];
    const btnPulseAnim = PULSE_VARIANTS[(h + 2) % PULSE_VARIANTS.length];

    // Desfases de apagado garantizados en momentos opuestos:
    const barFadeOffset = (h % 30) * 0.15;
    const fillFadeOffset = barFadeOffset + fillPulseNum * 0.5; // Exactamente medio ciclo desfasado
    const btnFadeOffset = barFadeOffset + btnPulseNum * 0.25;

    const barFadeDelay = `${(-barFadeOffset).toFixed(2)}s`;
    const fillFadeDelay = `${(-fillFadeOffset).toFixed(2)}s`;
    const btnFadeDelay = `${(-btnFadeOffset).toFixed(2)}s`;

    // Desfase angular de rotación
    const btnDelay = `${(-((h % 16) * 0.35)).toFixed(2)}s`;
    const barDelay = `${(-(((h + 23) % 18) * 0.35)).toFixed(2)}s`;
    const fillDelay = `${(-(((h * 11 + 7) % 21) * 0.35)).toFixed(2)}s`;

    return {
      btnDelay,
      barDelay,
      fillDelay,
      btnFadeDelay,
      barFadeDelay,
      fillFadeDelay,
      btnPulseDuration,
      barPulseDuration,
      fillPulseDuration,
      btnPulseAnim,
      barPulseAnim,
      fillPulseAnim,
      btnSpeedFactor,
      barSpeedFactor,
      fillSpeedFactor,
    };
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

        {/* Progress Bar con encanto y dos bordes independientes */}
        <div className="deck-progress">
          <div className="progress-info">
            <span className="progress-label">Progreso</span>
            <span className="progress-value">{stats.mastery}%</span>
          </div>
          <div
            className="progress-bar"
            style={{
              "--bar-delay": barDelay,
              "--bar-fade-delay": barFadeDelay,
              "--bar-pulse-duration": barPulseDuration,
              "--bar-pulse-anim": barPulseAnim,
            }}
            ref={borderSpeed(`bar-track-${deck.id}`, barSpeedFactor)}
          >
            <GoogleAura duration={6.5} delay={0} showSparkles={true} />
            <div
              className="progress-fill"
              style={{
                width: `${Math.max(stats.mastery, 0)}%`,
                "--fill-delay": fillDelay,
                "--fill-fade-delay": fillFadeDelay,
                "--fill-pulse-duration": fillPulseDuration,
                "--fill-pulse-anim": fillPulseAnim,
              }}
              ref={borderSpeed(`bar-fill-${deck.id}`, fillSpeedFactor)}
            >
              <GoogleAura duration={4.5} delay={0.2} showSparkles={false} />
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
            style={{
              "--btn-delay": btnDelay,
              "--btn-fade-delay": btnFadeDelay,
              "--btn-pulse-duration": btnPulseDuration,
              "--btn-pulse-anim": btnPulseAnim,
            }}
            ref={borderSpeed(`btn-${deck.id}`, btnSpeedFactor)}
            onClick={() => onStudyDeck(deck)}
          >
            <GoogleAura duration={5.2} delay={0.5} showSparkles={true} />
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