import { motion, AnimatePresence } from "motion/react";
import { Icons } from "./Icons";

export function ResetProgressModal({
  show,
  deck,
  step,
  onClose,
  onConfirm,
}) {
  return (
    <AnimatePresence>
      {show && deck && (
        <motion.div
          className="modal-overlay"
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          exit={{ opacity: 0 }}
          transition={{ duration: 0.2 }}
          onClick={onClose}
        >
          <motion.div
            className="modal modal-reset"
            initial={{ scale: 0.94, opacity: 0, y: 10 }}
            animate={{ scale: 1, opacity: 1, y: 0 }}
            exit={{ scale: 0.94, opacity: 0, y: 10 }}
            transition={{ duration: 0.22, ease: "easeOut" }}
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
          </motion.div>
        </motion.div>
      )}
    </AnimatePresence>
  );
}

export function ClearAllDataModal({
  show,
  step,
  onClose,
  onConfirm,
}) {
  return (
    <AnimatePresence>
      {show && (
        <motion.div
          className="modal-overlay"
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          exit={{ opacity: 0 }}
          transition={{ duration: 0.2 }}
          onClick={onClose}
        >
          <motion.div
            className="modal modal-reset modal-clear"
            initial={{ scale: 0.94, opacity: 0, y: 10 }}
            animate={{ scale: 1, opacity: 1, y: 0 }}
            exit={{ scale: 0.94, opacity: 0, y: 10 }}
            transition={{ duration: 0.22, ease: "easeOut" }}
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
          </motion.div>
        </motion.div>
      )}
    </AnimatePresence>
  );
}
