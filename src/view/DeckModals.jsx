import { Icons } from "./Icons";

export function CreateDeckModal({
  show,
  onClose,
  newDeckName,
  setNewDeckName,
  newDeckDesc,
  setNewDeckDesc,
  onCreate,
}) {
  if (!show) return null;

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal" onClick={(e) => e.stopPropagation()}>
        <div className="modal-header">
          <div className="modal-icon">{Icons.folder}</div>
          <h3>Nuevo Mazo</h3>
        </div>
        <form onSubmit={onCreate}>
          <div className="form-group">
            <label>Nombre</label>
            <input
              type="text"
              className="input"
              value={newDeckName}
              onChange={(e) => setNewDeckName(e.target.value)}
              placeholder="Ej: Sistemas Informaticos"
              autoFocus
            />
          </div>
          <div className="form-group">
            <label>Descripción (opcional)</label>
            <textarea
              className="textarea"
              value={newDeckDesc}
              onChange={(e) => setNewDeckDesc(e.target.value)}
              placeholder="Breve descripción del mazo..."
              rows={3}
            />
          </div>
          <div className="modal-actions">
            <button
              type="button"
              className="btn btn-secondary"
              onClick={onClose}
            >
              Cancelar
            </button>
            <button
              type="submit"
              className="btn btn-primary"
              disabled={!newDeckName.trim()}
            >
              Crear Mazo
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export function ResetProgressModal({
  show,
  deck,
  step,
  onClose,
  onConfirm,
}) {
  if (!show || !deck) return null;

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div
        className="modal modal-reset"
        onClick={(e) => e.stopPropagation()}
      >
        {step === 1 ? (
          <>
            <div className="modal-header">
              <div className="modal-icon warning-icon">
                {Icons.warning}
              </div>
              <h3>¿Reiniciar progreso?</h3>
            </div>
            <div className="modal-body">
              <p className="modal-text">
                Vas a reiniciar el progreso de{" "}
                <strong>"{deck.name}"</strong>.
              </p>
              <p className="modal-text">
                Se perderá todo el historial de estudio, pero las{" "}
                <strong>tarjetas se mantendrán</strong>.
              </p>
              <div className="modal-info-box">
                <span className="info-label">
                  ⚠️ Esta acción no se puede deshacer
                </span>
              </div>
            </div>
            <div className="modal-actions">
              <button
                type="button"
                className="btn btn-secondary"
                onClick={onClose}
              >
                Cancelar
              </button>
              <button
                type="button"
                className="btn btn-warning"
                onClick={onConfirm}
              >
                Continuar
              </button>
            </div>
          </>
        ) : (
          <>
            <div className="modal-header">
              <div className="modal-icon danger-icon">
                {Icons.warning}
              </div>
              <h3>⚠️ Advertencia</h3>
            </div>
            <div className="modal-body">
              <p className="modal-text danger-text">
                <strong>¡Atención!</strong> Estás a punto de borrar
                definitivamente:
              </p>
              <ul className="modal-list">
                <li>Todo tu progreso de estudio</li>
                <li>La fecha de tus repeticiones</li>
                <li>Tu racha actual</li>
                <li>Las estadísticas del mazo</li>
              </ul>
              <p className="modal-text highlight-text">
                Las tarjetas permanecerán, pero volverán al estado "nuevas".
              </p>
              <div className="modal-danger-box">
                <span className="danger-label">
                  ¿Estás completamente seguro?
                </span>
              </div>
            </div>
            <div className="modal-actions">
              <button
                type="button"
                className="btn btn-secondary"
                onClick={onClose}
              >
                No, cancelar
              </button>
              <button
                type="button"
                className="btn btn-danger"
                onClick={onConfirm}
              >
                Sí, reiniciar todo
              </button>
            </div>
          </>
        )}
      </div>
    </div>
  );
}

export function ClearAllDataModal({
  show,
  step,
  onClose,
  onConfirm,
}) {
  if (!show) return null;

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div
        className="modal modal-reset modal-clear"
        onClick={(e) => e.stopPropagation()}
      >
        {step === 1 ? (
          <>
            <div className="modal-header">
              <div className="modal-icon danger-icon">
                {Icons.warning}
              </div>
              <h3>¿Borrar todos los datos?</h3>
            </div>
            <div className="modal-body">
              <p className="modal-text">
                Esta acción <strong>borrará completamente</strong> toda la
                información guardada en tu navegador.
              </p>
              <div className="modal-info-box">
                <span className="info-label">📦 Se eliminará:</span>
              </div>
              <ul className="modal-list">
                <li>Todos tus mazos y tarjetas personalizadas</li>
                <li>Todo tu progreso de estudio</li>
                <li>Todas las estadísticas y repeticiones</li>
                <li>Cualquier configuración guardada</li>
              </ul>
              <div className="modal-info-box info-green">
                <span className="info-label">✅ Se restaurarán:</span>
              </div>
              <ul className="modal-list">
                <li>
                  Los mazos originales (Sistemas Informáticos, Entornos de
                  Desarrollo)
                </li>
                <li>Todo el contenido predefinido de las materias</li>
              </ul>
              <div className="modal-danger-box">
                <span className="danger-label">
                  ⚠️ Esta acción es irreversible
                </span>
              </div>
            </div>
            <div className="modal-actions">
              <button
                type="button"
                className="btn btn-secondary"
                onClick={onClose}
              >
                Cancelar
              </button>
              <button
                type="button"
                className="btn btn-warning"
                onClick={onConfirm}
              >
                Entendido, continuar
              </button>
            </div>
          </>
        ) : (
          <>
            <div className="modal-header">
              <div className="modal-icon danger-icon">
                {Icons.warning}
              </div>
              <h3>⚠️ Última advertencia</h3>
            </div>
            <div className="modal-body">
              <p className="modal-text danger-text">
                <strong>¡Atención!</strong> Estás a punto de eliminar todo:
              </p>
              <ul className="modal-list">
                <li>
                  <strong>510 tarjetas</strong> de Sistemas Informáticos con
                  tu progreso
                </li>
                <li>
                  <strong>308 tarjetas</strong> de Entornos de Desarrollo
                  con tu progreso
                </li>
                <li>Cualquier mazo o tarjeta que hayas creado</li>
                <li>Todo tu historial de estudio y estadísticas</li>
              </ul>
              <p className="modal-text highlight-text">
                Los mazos originales se recargarán, pero{" "}
                <strong>perderás todo tu avance</strong>.
              </p>
              <div className="modal-danger-box">
                <span className="danger-label">
                  ¿Estás completamente seguro de borrar TODO?
                </span>
              </div>
            </div>
            <div className="modal-actions">
              <button
                type="button"
                className="btn btn-secondary"
                onClick={onClose}
              >
                No, mantener mis datos
              </button>
              <button
                type="button"
                className="btn btn-danger"
                onClick={onConfirm}
              >
                Sí, borrar todo
              </button>
            </div>
          </>
        )}
      </div>
    </div>
  );
}
