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
