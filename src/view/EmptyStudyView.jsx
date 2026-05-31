export function EmptyStudyView({ deckName, onBack, onReviewAll }) {
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
        <h2>{deckName}</h2>
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
          <button className="btn btn-primary" onClick={onReviewAll}>
            Repasar todo el mazo
          </button>
        </div>
      </div>
    </div>
  );
}
