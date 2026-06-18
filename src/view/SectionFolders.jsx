import { Icons } from "./Icons";
import {
  isExamDeck,
  getSubjectIcon,
  getSubjectColor,
} from "./deckHelpers";
import { DeckCard } from "./DeckCard";

export function PreguntasDirectasFolder({
  decks,
  show,
  onToggle,
  doneMap,
  onToggleDone,
  onStudyDeck,
  onStatsDeck,
  onEditDeck,
  onOpenResetModal,
  sectionProgress = 0,
}) {
  if (decks.length === 0) return null;

  const progClass = sectionProgress === 0 ? "progress-0"
    : sectionProgress === 100 ? "progress-done"
    : sectionProgress <= 33 ? "progress-start"
    : sectionProgress <= 66 ? "progress-mid"
    : "progress-high";

  return (
    <div className={`pd-section section-progress ${progClass}`} data-progress={sectionProgress}>
      <button
        className="pd-toggle"
        onClick={onToggle}
        aria-expanded={show}
      >
        <span className="pd-icon">🎯</span>
        <span className="pd-label">Preguntas Directas</span>
        <span className="exam-folder-dot" title="Materia de examen"></span>
        <span className="pd-count">
          {decks.length} mazo{decks.length !== 1 ? "s" : ""}
        </span>
        <span className={`pd-chevron ${show ? "open" : ""}`}>
          {show ? Icons.chevronUp : Icons.chevronDown}
        </span>
      </button>

      {show && (
        <div className="decks-grid pd-grid animate-fade-in">
          {decks.map((d) => (
            <DeckCard
              key={d.id}
              deck={d}
              doneMap={doneMap}
              onToggleDone={onToggleDone}
              theme="theme-green"
              onStudyDeck={onStudyDeck}
              onStatsDeck={onStatsDeck}
              onEditDeck={onEditDeck}
              onOpenResetModal={onOpenResetModal}
            />
          ))}
        </div>
      )}
    </div>
  );
}

export function SubjectFolder({
  subject,
  decks,
  icon,
  color,
  show,
  onToggle,
  doneMap,
  onToggleDone,
  onStudyDeck,
  onStatsDeck,
  onEditDeck,
  onOpenResetModal,
  sectionProgress = 0,
}) {
  if (decks.length === 0) return null;

  const progClass = sectionProgress === 0 ? "progress-0"
    : sectionProgress === 100 ? "progress-done"
    : sectionProgress <= 33 ? "progress-start"
    : sectionProgress <= 66 ? "progress-mid"
    : "progress-high";

  const subjectColor = color || { accent: "#5f6368", bg: "rgba(95, 99, 104, 0.08)" };

  return (
    <div
      className={`materias-section section-progress ${progClass}`}
      data-progress={sectionProgress}
      style={{
        borderLeft: `3px solid ${subjectColor.accent}`,
      }}
    >
      <button
        className="materias-toggle"
        onClick={onToggle}
        aria-expanded={show}
      >
        <span className="materias-icon">{icon || "📁"}</span>
        <span className="materias-label">{subject}</span>
        <span className="materias-count">
          {decks.length} mazo{decks.length !== 1 ? "s" : ""}
        </span>
        <span className={`materias-chevron ${show ? "open" : ""}`}>
          {show ? Icons.chevronUp : Icons.chevronDown}
        </span>
      </button>

      {show && (
        <div className="decks-grid materias-subgrid animate-fade-in">
          {decks.map((d) => (
            <DeckCard
              key={d.id}
              deck={d}
              doneMap={doneMap}
              onToggleDone={onToggleDone}
              theme="theme-green"
              onStudyDeck={onStudyDeck}
              onStatsDeck={onStatsDeck}
              onEditDeck={onEditDeck}
              onOpenResetModal={onOpenResetModal}
            />
          ))}
        </div>
      )}
    </div>
  );
}

export function MateriasFolder({
  groups,
  show,
  onToggle,
  doneMap,
  onToggleDone,
  onStudyDeck,
  onStatsDeck,
  onEditDeck,
  onOpenResetModal,
  sectionProgress = 0,
}) {
  const total = Object.values(groups).reduce(
    (acc, arr) => acc + arr.length,
    0,
  );
  if (total === 0) return null;

  const progClass = sectionProgress === 0 ? "progress-0"
    : sectionProgress === 100 ? "progress-done"
    : sectionProgress <= 33 ? "progress-start"
    : sectionProgress <= 66 ? "progress-mid"
    : "progress-high";

  return (
    <div className={`materias-section section-progress ${progClass}`} data-progress={sectionProgress}>
      <button
        className="materias-toggle"
        onClick={onToggle}
        aria-expanded={show}
      >
        <span className="materias-icon">📁</span>
        <span className="materias-label">Materias</span>
        <span className="exam-folder-dot" title="Materia de examen"></span>
        <span className="materias-count">
          {total} mazo{total !== 1 ? "s" : ""}
        </span>
        <span className={`materias-chevron ${show ? "open" : ""}`}>
          {show ? Icons.chevronUp : Icons.chevronDown}
        </span>
      </button>

      {show && (
        <div className="materias-content animate-fade-in">
          {Object.entries(groups).map(([subject, subjectDecks]) => {
            const subjectColor = getSubjectColor(subject);
            const subjectIcon = getSubjectIcon(subject);
            return (
              <div key={subject} className="materias-subgroup">
                <div
                  className="materias-subject-header"
                  style={{ borderLeftColor: subjectColor.accent }}
                >
                  <span className="materias-subject-icon">
                    {subjectIcon}
                  </span>
                  <span className="materias-subject-name">{subject}</span>
                  <span className="materias-subject-count">
                    {subjectDecks.length} mazo
                    {subjectDecks.length !== 1 ? "s" : ""}
                  </span>
                </div>
                <div className="decks-grid materias-subgrid">
                  {subjectDecks.map((d) => (
                    <DeckCard
                      key={d.id}
                      deck={d}
                      doneMap={doneMap}
                      onToggleDone={onToggleDone}
                      theme="theme-green"
                      onStudyDeck={onStudyDeck}
                      onStatsDeck={onStatsDeck}
                      onEditDeck={onEditDeck}
                      onOpenResetModal={onOpenResetModal}
                    />
                  ))}
                </div>
              </div>
            );
          })}
        </div>
      )}
    </div>
  );
}

export function PracticasFolder({
  decks,
  show,
  onToggle,
  doneMap,
  onToggleDone,
  onStudyDeck,
  onStatsDeck,
  onEditDeck,
  onOpenResetModal,
  sectionProgress = 0,
}) {
  if (decks.length === 0) return null;

  const progClass = sectionProgress === 0 ? "progress-0"
    : sectionProgress === 100 ? "progress-done"
    : sectionProgress <= 33 ? "progress-start"
    : sectionProgress <= 66 ? "progress-mid"
    : "progress-high";

  return (
    <div className={`practicas-section section-progress ${progClass}`} data-progress={sectionProgress}>
      <button
        className="practicas-toggle"
        onClick={onToggle}
        aria-expanded={show}
      >
        <span className="practicas-icon">📝</span>
        <span className="practicas-label">Prácticas</span>
        {decks.some((d) => isExamDeck(d)) && (
          <span className="exam-folder-dot" title="Materia de examen"></span>
        )}
        <span className="practicas-count">
          {decks.length} mazo{decks.length !== 1 ? "s" : ""}
        </span>
        <span className={`practicas-chevron ${show ? "open" : ""}`}>
          {show ? Icons.chevronUp : Icons.chevronDown}
        </span>
      </button>

      {show && (
        <div className="decks-grid practicas-grid animate-fade-in">
          {decks.map((d) => (
            <DeckCard
              key={d.id}
              deck={d}
              doneMap={doneMap}
              onToggleDone={onToggleDone}
              theme="theme-practica"
              onStudyDeck={onStudyDeck}
              onStatsDeck={onStatsDeck}
              onEditDeck={onEditDeck}
              onOpenResetModal={onOpenResetModal}
            />
          ))}
        </div>
      )}
    </div>
  );
}

export function ExamenesFolder({
  groups,
  show,
  onToggle,
  doneMap,
  onToggleDone,
  onStudyDeck,
  onStatsDeck,
  onEditDeck,
  onOpenResetModal,
  sectionProgress = 0,
}) {
  const total = Object.values(groups).reduce(
    (acc, arr) => acc + arr.length,
    0,
  );
  if (total === 0) return null;

  const progClass = sectionProgress === 0 ? "progress-0"
    : sectionProgress === 100 ? "progress-done"
    : sectionProgress <= 33 ? "progress-start"
    : sectionProgress <= 66 ? "progress-mid"
    : "progress-high";

  return (
    <div className={`examenes-section section-progress ${progClass}`} data-progress={sectionProgress}>
      <button
        className="examenes-toggle"
        onClick={onToggle}
        aria-expanded={show}
      >
        <span className="examenes-icon">📋</span>
        <span className="examenes-label">Exámenes</span>
        <span className="examenes-count">
          {total} mazo{total !== 1 ? "s" : ""}
        </span>
        <span className={`examenes-chevron ${show ? "open" : ""}`}>
          {show ? Icons.chevronUp : Icons.chevronDown}
        </span>
      </button>

      {show && (
        <div className="examenes-content animate-fade-in">
          {Object.entries(groups).map(([subject, subjectDecks]) => {
            const subjectColor = getSubjectColor(subject);
            const subjectIcon = getSubjectIcon(subject);
            return (
              <div key={subject} className="examenes-subgroup">
                <div
                  className="examenes-subject-header"
                  style={{ borderLeftColor: subjectColor.accent }}
                >
                  <span className="examenes-subject-icon">
                    {subjectIcon}
                  </span>
                  <span className="examenes-subject-name">{subject}</span>
                  <span className="examenes-subject-count">
                    {subjectDecks.length} mazo
                    {subjectDecks.length !== 1 ? "s" : ""}
                  </span>
                </div>
                <div className="decks-grid examenes-subgrid">
                  {subjectDecks.map((d) => (
                    <DeckCard
                      key={d.id}
                      deck={d}
                      doneMap={doneMap}
                      onToggleDone={onToggleDone}
                      theme="theme-examen"
                      onStudyDeck={onStudyDeck}
                      onStatsDeck={onStatsDeck}
                      onEditDeck={onEditDeck}
                      onOpenResetModal={onOpenResetModal}
                    />
                  ))}
                </div>
              </div>
            );
          })}
        </div>
      )}
    </div>
  );
}

export function PruebasFolder({
  groups,
  show,
  onToggle,
  doneMap,
  onToggleDone,
  onStudyDeck,
  onStatsDeck,
  onEditDeck,
  onOpenResetModal,
  sectionProgress = 0,
}) {
  const total = Object.values(groups).reduce(
    (acc, arr) => acc + arr.length,
    0,
  );
  if (total === 0) return null;

  const progClass = sectionProgress === 0 ? "progress-0"
    : sectionProgress === 100 ? "progress-done"
    : sectionProgress <= 33 ? "progress-start"
    : sectionProgress <= 66 ? "progress-mid"
    : "progress-high";

  return (
    <div className={`pruebas-section section-progress ${progClass}`} data-progress={sectionProgress}>
      <button
        className="pruebas-toggle"
        onClick={onToggle}
        aria-expanded={show}
      >
        <span className="pruebas-icon">📁</span>
        <span className="pruebas-label">Pruebas</span>
        <span className="pruebas-count">
          {total} mazo{total !== 1 ? "s" : ""}
        </span>
        <span className={`pruebas-chevron ${show ? "open" : ""}`}>
          {show ? Icons.chevronUp : Icons.chevronDown}
        </span>
      </button>

      {show && (
        <div className="pruebas-content animate-fade-in">
          {Object.entries(groups).map(([subject, subjectDecks]) => {
            const subjectColor = getSubjectColor(subject);
            const subjectIcon = getSubjectIcon(subject);
            return (
              <div key={subject} className="pruebas-subgroup">
                <div
                  className="pruebas-subject-header"
                  style={{ borderLeftColor: subjectColor.accent }}
                >
                  <span className="pruebas-subject-icon">
                    {subjectIcon}
                  </span>
                  <span className="pruebas-subject-name">{subject}</span>
                  <span className="pruebas-subject-count">
                    {subjectDecks.length} mazo
                    {subjectDecks.length !== 1 ? "s" : ""}
                  </span>
                </div>
                <div className="decks-grid pruebas-subgrid">
                  {subjectDecks.map((d) => (
                    <DeckCard
                      key={d.id}
                      deck={d}
                      doneMap={doneMap}
                      onToggleDone={onToggleDone}
                      theme="theme-prueba"
                      onStudyDeck={onStudyDeck}
                      onStatsDeck={onStatsDeck}
                      onEditDeck={onEditDeck}
                      onOpenResetModal={onOpenResetModal}
                    />
                  ))}
                </div>
              </div>
            );
          })}
        </div>
      )}
    </div>
  );
}

export function MasFolder({
  librosDecks,
  materiasSalvadasDecks,
  showMas,
  onToggleMas,
  showLibros,
  onToggleLibros,
  showMateriasSalvadas,
  onToggleMateriasSalvadas,
  doneMap,
  onToggleDone,
  onStudyDeck,
  onStatsDeck,
  onEditDeck,
  onOpenResetModal,
  sectionProgress = 0,
  librosProgress = 0,
  materiasSalvadasProgress = 0,
}) {
  if (librosDecks.length === 0 && materiasSalvadasDecks.length === 0)
    return null;

  const progClass = sectionProgress === 0 ? "progress-0"
    : sectionProgress === 100 ? "progress-done"
    : sectionProgress <= 33 ? "progress-start"
    : sectionProgress <= 66 ? "progress-mid"
    : "progress-high";

  return (
    <div className={`mas-section section-progress ${progClass}`} data-progress={sectionProgress}>
      <button
        className="mas-toggle"
        onClick={onToggleMas}
        aria-expanded={showMas}
      >
        <span className="mas-icon">➕</span>
        <span className="mas-label">Más</span>
        <span className="mas-count">
          {librosDecks.length + materiasSalvadasDecks.length} mazo
          {librosDecks.length + materiasSalvadasDecks.length !== 1
            ? "s"
            : ""}
        </span>
        <span className={`mas-chevron ${showMas ? "open" : ""}`}>
          {showMas ? Icons.chevronUp : Icons.chevronDown}
        </span>
      </button>

      {showMas && (
        <div className="mas-content animate-fade-in">
          <LibrosFolder
            decks={librosDecks}
            show={showLibros}
            onToggle={onToggleLibros}
            doneMap={doneMap}
            onToggleDone={onToggleDone}
            onStudyDeck={onStudyDeck}
            onStatsDeck={onStatsDeck}
            onEditDeck={onEditDeck}
            onOpenResetModal={onOpenResetModal}
            sectionProgress={librosProgress}
          />
          <MateriasSalvadasFolder
            decks={materiasSalvadasDecks}
            show={showMateriasSalvadas}
            onToggle={onToggleMateriasSalvadas}
            doneMap={doneMap}
            onToggleDone={onToggleDone}
            onStudyDeck={onStudyDeck}
            onStatsDeck={onStatsDeck}
            onEditDeck={onEditDeck}
            onOpenResetModal={onOpenResetModal}
            sectionProgress={materiasSalvadasProgress}
          />
        </div>
      )}
    </div>
  );
}

function LibrosFolder({
  decks,
  show,
  onToggle,
  doneMap,
  onToggleDone,
  onStudyDeck,
  onStatsDeck,
  onEditDeck,
  onOpenResetModal,
  sectionProgress = 0,
}) {
  if (decks.length === 0) return null;

  const progClass = sectionProgress === 0 ? "progress-0"
    : sectionProgress === 100 ? "progress-done"
    : sectionProgress <= 33 ? "progress-start"
    : sectionProgress <= 66 ? "progress-mid"
    : "progress-high";

  return (
    <div className={`pd-section section-progress ${progClass}`} data-progress={sectionProgress}>
      <button
        className="pd-toggle"
        onClick={(e) => {
          e.stopPropagation();
          onToggle();
        }}
        aria-expanded={show}
      >
        <span className="pd-icon">📚</span>
        <span className="pd-label">Libros</span>
        <span className="pd-count">
          {decks.length} mazo{decks.length !== 1 ? "s" : ""}
        </span>
        <span className={`pd-chevron ${show ? "open" : ""}`}>
          {show ? Icons.chevronUp : Icons.chevronDown}
        </span>
      </button>

      {show && (
        <div className="decks-grid pd-grid animate-fade-in">
          {decks.map((d) => (
            <DeckCard
              key={d.id}
              deck={d}
              doneMap={doneMap}
              onToggleDone={onToggleDone}
              isExtra={true}
              onStudyDeck={onStudyDeck}
              onStatsDeck={onStatsDeck}
              onEditDeck={onEditDeck}
              onOpenResetModal={onOpenResetModal}
            />
          ))}
        </div>
      )}
    </div>
  );
}

function MateriasSalvadasFolder({
  decks,
  show,
  onToggle,
  doneMap,
  onToggleDone,
  onStudyDeck,
  onStatsDeck,
  onEditDeck,
  onOpenResetModal,
  sectionProgress = 0,
}) {
  if (decks.length === 0) return null;

  const progClass = sectionProgress === 0 ? "progress-0"
    : sectionProgress === 100 ? "progress-done"
    : sectionProgress <= 33 ? "progress-start"
    : sectionProgress <= 66 ? "progress-mid"
    : "progress-high";

  return (
    <div className={`pd-section section-progress ${progClass}`} data-progress={sectionProgress}>
      <button
        className="pd-toggle"
        onClick={(e) => {
          e.stopPropagation();
          onToggle();
        }}
        aria-expanded={show}
      >
        <span className="pd-icon">💾</span>
        <span className="pd-label">Materias salvadas</span>
        <span className="pd-count">
          {decks.length} mazo{decks.length !== 1 ? "s" : ""}
        </span>
        <span className={`pd-chevron ${show ? "open" : ""}`}>
          {show ? Icons.chevronUp : Icons.chevronDown}
        </span>
      </button>

      {show && (
        <div className="decks-grid pd-grid animate-fade-in">
          {decks.map((d) => (
            <DeckCard
              key={d.id}
              deck={d}
              doneMap={doneMap}
              onToggleDone={onToggleDone}
              theme="theme-salvadas"
              onStudyDeck={onStudyDeck}
              onStatsDeck={onStatsDeck}
              onEditDeck={onEditDeck}
              onOpenResetModal={onOpenResetModal}
            />
          ))}
        </div>
      )}
    </div>
  );
}

export function ExtrasFolder({
  decks,
  show,
  onToggle,
  doneMap,
  onToggleDone,
  onStudyDeck,
  onStatsDeck,
  onEditDeck,
  onOpenResetModal,
  sectionProgress = 0,
}) {
  if (decks.length === 0) return null;

  const progClass = sectionProgress === 0 ? "progress-0"
    : sectionProgress === 100 ? "progress-done"
    : sectionProgress <= 33 ? "progress-start"
    : sectionProgress <= 66 ? "progress-mid"
    : "progress-high";

  return (
    <div className={`extras-section section-progress ${progClass}`} data-progress={sectionProgress}>
      <button
        className="extras-toggle"
        onClick={onToggle}
        aria-expanded={show}
      >
        <span className="extras-icon">{Icons.extras}</span>
        <span className="extras-label">Extras</span>
        <span className="extras-count">
          {decks.length} mazo{decks.length !== 1 ? "s" : ""}
        </span>
        <span className={`extras-chevron ${show ? "open" : ""}`}>
          {show ? Icons.chevronUp : Icons.chevronDown}
        </span>
      </button>

      {show && (
        <div className="decks-grid extras-grid animate-fade-in">
          {decks.map((d) => (
            <DeckCard
              key={d.id}
              deck={d}
              doneMap={doneMap}
              onToggleDone={onToggleDone}
              isExtra={true}
              onStudyDeck={onStudyDeck}
              onStatsDeck={onStatsDeck}
              onEditDeck={onEditDeck}
              onOpenResetModal={onOpenResetModal}
            />
          ))}
        </div>
      )}
    </div>
  );
}
