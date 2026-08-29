import { motion } from "motion/react";

export function SessionComplete({ sessionStats, onBack }) {
  const total =
    sessionStats.again +
    sessionStats.hard +
    sessionStats.good +
    sessionStats.easy;
  const accuracy = Math.round(
    ((sessionStats.good + sessionStats.easy) / total) * 100,
  );

  return (
    <div className="study-view">
      <motion.div 
        className="complete-view"
        initial={{ opacity: 0, scale: 0.9, y: 20 }}
        animate={{ opacity: 1, scale: 1, y: 0 }}
        transition={{ duration: 0.35, ease: "easeOut" }}
      >
        <motion.div 
          className="complete-icon"
          initial={{ scale: 0, rotate: -20 }}
          animate={{ scale: 1, rotate: 0 }}
          transition={{ type: "spring", stiffness: 260, damping: 20, delay: 0.1 }}
        >
          🎊
        </motion.div>
        <h2>¡Sesion completada!</h2>
        <p className="complete-subtitle">Has estudiado {total} tarjetas</p>

        <div className="session-stats">
          <motion.div 
            className="session-stat good"
            initial={{ opacity: 0, x: -10 }}
            animate={{ opacity: 1, x: 0 }}
            transition={{ delay: 0.2 }}
          >
            <span className="session-stat-value">{sessionStats.good}</span>
            <span className="session-stat-label">Procesando</span>
          </motion.div>
          <motion.div 
            className="session-stat easy"
            initial={{ opacity: 0, x: 10 }}
            animate={{ opacity: 1, x: 0 }}
            transition={{ delay: 0.25 }}
          >
            <span className="session-stat-value">{sessionStats.easy}</span>
            <span className="session-stat-label">Aprendido</span>
          </motion.div>
        </div>

        <motion.div 
          className="accuracy-display"
          initial={{ opacity: 0, y: 10 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 0.3 }}
        >
          <div className="accuracy-value">{accuracy}%</div>
          <div className="accuracy-label">Precisión</div>
        </motion.div>

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
      </motion.div>
    </div>
  );
}
