import { useState } from "react";
import { Icons } from "./Icons";
import {
  isExamDeck,
  getSubjectIcon,
  getSubjectColor,
} from "./deckHelpers";
import { DeckCard } from "./DeckCard";

export function ExamenJavaFolder({
  deck,
  doneMap,
  onToggleDone,
  onStudyDeck,
  onStatsDeck,
  onEditDeck,
  onOpenResetModal,
}) {
  const [show, setShow] = useState(true);
  if (!deck) return null;

  const total = deck.cards.length;
  const studied = deck.cards.filter((c) => c.status !== "new").length;
  const sectionProgress = total === 0 ? 0 : Math.round((studied / total) * 100);
  const progClass = sectionProgress === 0 ? "progress-0"
    : sectionProgress === 100 ? "progress-done"
    : sectionProgress <= 33 ? "progress-start"
    : sectionProgress <= 66 ? "progress-mid"
    : "progress-high";

  return (
    <div className={`examenes-section section-progress ${progClass}`} data-progress={sectionProgress}>
      <button
        className="examenes-toggle examen-java-area"
        onClick={() => setShow(!show)}
        aria-expanded={show}
      >
        <span className="examenes-icon">📝</span>
        <span className="examenes-label">Examen Java</span>
        <span className="examenes-count">{total} tarjetas</span>
        <span className={`examenes-chevron ${show ? "open" : ""}`}>
          {show ? Icons.chevronUp : Icons.chevronDown}
        </span>
      </button>

      {show && (
        <div className="decks-grid examenes-grid animate-fade-in">
          <DeckCard
            key={deck.id}
            deck={deck}
            doneMap={doneMap}
            onToggleDone={onToggleDone}
            theme="theme-examen"
            onStudyDeck={onStudyDeck}
            onStatsDeck={onStatsDeck}
            onEditDeck={onEditDeck}
            onOpenResetModal={onOpenResetModal}
          />
        </div>
      )}
    </div>
  );
}

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
        <span className="pd-icon">⚡</span>
        <span className="pd-label">Preguntas Directas</span>
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
              theme="theme-pd"
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

  return (
    <div className={`subject-section section-progress ${progClass}`} data-progress={sectionProgress}>
      <button
        className="subject-toggle"
        onClick={onToggle}
        aria-expanded={show}
      >
        <span className="subject-icon">{icon}</span>
        <span className="subject-label">{subject}</span>
        <span className="subject-count">
          {decks.length} mazo{decks.length !== 1 ? "s" : ""}
        </span>
        <span className={`subject-chevron ${show ? "open" : ""}`}>
          {show ? Icons.chevronUp : Icons.chevronDown}
        </span>
      </button>

      {show && (
        <div className="decks-grid subject-grid animate-fade-in">
          {decks.map((d) => (
            <DeckCard
              key={d.id}
              deck={d}
              doneMap={doneMap}
              onToggleDone={onToggleDone}
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
        <span className="practicas-icon">🧪</span>
        <span className="practicas-label">Prácticas</span>
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
  const subjects = Object.keys(groups);
  if (subjects.length === 0) return null;

  const totalExamenDecks = subjects.reduce(
    (acc, s) => acc + groups[s].length,
    0,
  );

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
        <span className="examenes-icon">📝</span>
        <span className="examenes-label">Exámenes</span>
        <span className="examenes-count">
          {totalExamenDecks} mazo{totalExamenDecks !== 1 ? "s" : ""}
        </span>
        <span className={`examenes-chevron ${show ? "open" : ""}`}>
          {show ? Icons.chevronUp : Icons.chevronDown}
        </span>
      </button>

      {show && (
        <div className="examenes-content animate-fade-in">
          {subjects.map((subj) => {
            const subjectDecks = groups[subj] || [];
            const icon = getSubjectIcon(subj);
            return (
              <div key={subj} className="examenes-subject-group">
                <div className="examenes-subject-header">
                  <span className="examenes-subject-icon">{icon}</span>
                  <span className="examenes-subject-title">{subj}</span>
                  <span className="examenes-subject-count">
                    {subjectDecks.length}
                  </span>
                </div>
                <div className="decks-grid examenes-subgrid">
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
  const subjects = Object.keys(groups);
  if (subjects.length === 0) return null;

  const totalPruebaDecks = subjects.reduce(
    (acc, s) => acc + groups[s].length,
    0,
  );

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
        <span className="pruebas-icon">📋</span>
        <span className="pruebas-label">Pruebas</span>
        <span className="pruebas-count">
          {totalPruebaDecks} mazo{totalPruebaDecks !== 1 ? "s" : ""}
        </span>
        <span className={`pruebas-chevron ${show ? "open" : ""}`}>
          {show ? Icons.chevronUp : Icons.chevronDown}
        </span>
      </button>

      {show && (
        <div className="pruebas-content animate-fade-in">
          {subjects.map((subj) => {
            const subjectDecks = groups[subj] || [];
            const icon = getSubjectIcon(subj);
            return (
              <div key={subj} className="pruebas-subject-group">
                <div className="pruebas-subject-header">
                  <span className="pruebas-subject-icon">{icon}</span>
                  <span className="pruebas-subject-title">{subj}</span>
                  <span className="pruebas-subject-count">
                    {subjectDecks.length}
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
        <span className="mas-icon">📂</span>
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
        <span className="pd-icon">📖</span>
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