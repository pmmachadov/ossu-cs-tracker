import { useState, useEffect } from "react";
import "./DeckList.css";
import { Icons } from "./Icons";
import {
  MAIN_SUBJECTS,
  getSubjectIcon,
  getSubjectColor,
} from "./deckHelpers";
import {
  PreguntasDirectasFolder,
  SubjectFolder,
  PracticasFolder,
  ExamenesFolder,
  PruebasFolder,
  MasFolder,
  ExtrasFolder,
} from "./SectionFolders";
import {
  CreateDeckModal,
  ResetProgressModal,
  ClearAllDataModal,
} from "./DeckModals";

export function DeckList({
  decks,
  onCreateDeck,
  onDeleteDeck,
  onStudyDeck,
  onEditDeck,
  onStatsDeck,
  onResetDeck,
  onClearAllData,
}) {
  const [showCreateModal, setShowCreateModal] = useState(false);
  const [newDeckName, setNewDeckName] = useState("");
  const [newDeckDesc, setNewDeckDesc] = useState("");
  const [filterSubject, setFilterSubject] = useState("all");

  const [showResetModal, setShowResetModal] = useState(false);
  const [resetStep, setResetStep] = useState(1);
  const [deckToReset, setDeckToReset] = useState(null);

  const [showClearModal, setShowClearModal] = useState(false);
  const [clearStep, setClearStep] = useState(1);

  const [showExtras, setShowExtras] = useState(false);
  const [showPruebas, setShowPruebas] = useState(false);
  const [showPracticas, setShowPracticas] = useState(false);
  const [showExamenes, setShowExamenes] = useState(false);
  const [showPreguntasDirectas, setShowPreguntasDirectas] = useState(false);
  const [showLibros, setShowLibros] = useState(false);
  const [showMateriasSalvadas, setShowMateriasSalvadas] = useState(false);
  const [showMas, setShowMas] = useState(false);
  const [openSubjects, setOpenSubjects] = useState({}); // cada materia se abre/cierra individualmente

  const [doneMap, setDoneMap] = useState(() => {
    try {
      const raw = localStorage.getItem("deckDoneMap");
      return raw ? JSON.parse(raw) : {};
    } catch (e) {
      console.error("Error loading deckDoneMap", e);
      return {};
    }
  });

  useEffect(() => {
    try {
      localStorage.setItem("deckDoneMap", JSON.stringify(doneMap));
    } catch (e) {
      console.error("Error saving deckDoneMap", e);
    }
  }, [doneMap]);

  const toggleDone = (deckId) => {
    if (!deckId) return;
    setDoneMap((prev) => {
      const next = { ...prev };
      const current = next[deckId];
      if (!current) next[deckId] = "progress";
      else if (current === "progress") next[deckId] = true;
      else delete next[deckId];
      return next;
    });
  };

  const handleCreate = (e) => {
    e.preventDefault();
    if (newDeckName.trim()) {
      onCreateDeck(newDeckName.trim(), newDeckDesc.trim());
      setNewDeckName("");
      setNewDeckDesc("");
      setShowCreateModal(false);
    }
  };

  const openResetModal = (deck) => {
    setDeckToReset(deck);
    setResetStep(1);
    setShowResetModal(true);
  };

  const closeResetModal = () => {
    setShowResetModal(false);
    setDeckToReset(null);
    setResetStep(1);
  };

  const closeClearModal = () => {
    setShowClearModal(false);
    setClearStep(1);
  };

  const handleClearConfirm = () => {
    if (clearStep === 1) {
      setClearStep(2);
    } else {
      onClearAllData();
      closeClearModal();
    }
  };

  const handleResetConfirm = () => {
    if (resetStep === 1) {
      setResetStep(2);
    } else {
      if (deckToReset) {
        onResetDeck(deckToReset.id);
      }
      closeResetModal();
    }
  };

  const totalCards = decks.reduce((acc, d) => acc + d.cards.length, 0);
  const totalStudied = decks.reduce(
    (acc, d) => acc + d.cards.filter((c) => c.status !== "new").length,
    0,
  );

  const uniqueSubjects = [
    ...new Set(decks.map((d) => d.subject).filter(Boolean)),
  ];

  const filteredDecks =
    filterSubject === "all"
      ? decks
      : decks.filter((d) => d.subject === filterSubject);

  const examenDecks = filteredDecks.filter(
    (d) => d.id?.startsWith("examen-") && d.subject !== "Materias salvadas",
  );
  const pruebaDecks = filteredDecks.filter(
    (d) =>
      (d.id?.startsWith("prueba-") || d.name?.startsWith("Prueba -")) &&
      d.subject !== "Materias salvadas",
  );
  const examenGroups = examenDecks.reduce((acc, deck) => {
    const subject = deck.subject || "Exámenes";
    if (!acc[subject]) acc[subject] = [];
    acc[subject].push(deck);
    return acc;
  }, {});
  const pruebaGroups = pruebaDecks.reduce((acc, deck) => {
    const subject = deck.subject || "Sin materia";
    if (!acc[subject]) acc[subject] = [];
    acc[subject].push(deck);
    return acc;
  }, {});
  const practicaDecks = filteredDecks.filter(
    (d) => d.subject === "Practicas",
  );
  const materiasSalvadasDecks = filteredDecks.filter(
    (d) => d.subject === "Materias salvadas",
  );
  const preguntasDirectasDecks = filteredDecks.filter(
    (d) => d.id?.startsWith("pd-") && !materiasSalvadasDecks.includes(d),
  );
  const librosDecks = filteredDecks.filter((d) => d.subject === "Libros");
  const mainDecks = filteredDecks.filter(
    (d) =>
      MAIN_SUBJECTS.includes(d.subject) &&
      !pruebaDecks.includes(d) &&
      !examenDecks.includes(d) &&
      !preguntasDirectasDecks.includes(d) &&
      !materiasSalvadasDecks.includes(d),
  );
  const extraDecks = filteredDecks.filter(
    (d) =>
      !MAIN_SUBJECTS.includes(d.subject) &&
      !pruebaDecks.includes(d) &&
      !practicaDecks.includes(d) &&
      !examenDecks.includes(d) &&
      !preguntasDirectasDecks.includes(d) &&
      !librosDecks.includes(d) &&
      !materiasSalvadasDecks.includes(d),
  );
  const mainGroups = mainDecks.reduce((acc, deck) => {
    const subject = deck.subject || "Sin materia";
    if (!acc[subject]) acc[subject] = [];
    acc[subject].push(deck);
    return acc;
  }, {});

  const calcSectionProgress = (sectionDecks) => {
    if (!sectionDecks || sectionDecks.length === 0) return 0;
    const total = sectionDecks.reduce((acc, d) => acc + d.cards.length, 0);
    if (total === 0) return 0;
    const studied = sectionDecks.reduce(
      (acc, d) => acc + d.cards.filter((c) => c.status !== "new").length,
      0,
    );
    return Math.round((studied / total) * 100);
  };

  const preguntasDirectasProgress = calcSectionProgress(preguntasDirectasDecks);
  const mainProgress = calcSectionProgress(mainDecks);
  const practicasProgress = calcSectionProgress(practicaDecks);
  const examenesProgress = calcSectionProgress(examenDecks);
  const pruebasProgress = calcSectionProgress(pruebaDecks);
  const librosProgress = calcSectionProgress(librosDecks);
  const materiasSalvadasProgress = calcSectionProgress(materiasSalvadasDecks);
  const extraProgress = calcSectionProgress(extraDecks);

  const folderProps = {
    doneMap,
    onToggleDone: toggleDone,
    onStudyDeck,
    onStatsDeck,
    onEditDeck,
    onOpenResetModal: openResetModal,
  };

  return (
    <div className="deck-list animate-fade-in">
      <div className="deck-stats">
        <div className="stat-card stat-card-blue">
          <div className="stat-icon">{Icons.folder}</div>
          <div className="stat-content">
            <span className="stat-value">{decks.length}</span>
            <span className="stat-label">Mazos</span>
          </div>
        </div>
        <div className="stat-card stat-card-purple">
          <div className="stat-icon">{Icons.cards}</div>
          <div className="stat-content">
            <span className="stat-value">{totalCards}</span>
            <span className="stat-label">Tarjetas</span>
          </div>
        </div>
        <div className="stat-card stat-card-green">
          <div className="stat-icon">{Icons.target}</div>
          <div className="stat-content">
            <span className="stat-value">
              {Math.round((totalStudied / totalCards) * 100) || 0}%
            </span>
            <span className="stat-label">Progreso</span>
          </div>
        </div>
      </div>

      <div className="deck-header">
        <div className="deck-header-title">
          <div className="header-icon">{Icons.book}</div>
          <div>
            <h2>Mis Materias</h2>
            <p className="deck-header-subtitle">
              Selecciona un mazo para estudiar
            </p>
          </div>
        </div>
        <div className="header-buttons">
          <button
            className="btn btn-primary btn-create"
            onClick={() => setShowCreateModal(true)}
          >
            <span className="btn-icon">{Icons.plus}</span>
            <span>Nuevo Mazo</span>
          </button>
          <a
            href="/diagrama-uml.html"
            target="_blank"
            className="btn btn-secondary btn-diagrama"
            title="Diagrama UML de clases"
          >
            <span className="btn-icon">{Icons.diagrama}</span>
            <span>UML</span>
          </a>
        </div>
      </div>

      {uniqueSubjects.length > 1 && (
        <div className="subject-filter">
          <button
            className={`filter-pill ${filterSubject === "all" ? "active" : ""}`}
            onClick={() => setFilterSubject("all")}
          >
            📚 Todos
          </button>
          {uniqueSubjects.map((subject) => {
            const color = getSubjectColor(subject);
            const icon = getSubjectIcon(subject);
            return (
              <button
                key={subject}
                className={`filter-pill ${
                  filterSubject === subject ? "active" : ""
                }`}
                onClick={() => setFilterSubject(subject)}
                style={
                  filterSubject === subject
                    ? {
                        borderColor: color.accent,
                        background: color.bg,
                        color: color.accent,
                      }
                    : {}
                }
              >
                {icon} {subject}
              </button>
            );
          })}
        </div>
      )}

      <PreguntasDirectasFolder
        decks={preguntasDirectasDecks}
        show={showPreguntasDirectas}
        onToggle={() => setShowPreguntasDirectas(!showPreguntasDirectas)}
        sectionProgress={preguntasDirectasProgress}
        {...folderProps}
      />

      {MAIN_SUBJECTS.map((subject) => {
        const subjectDecks = mainGroups[subject] || [];
        if (subjectDecks.length === 0) return null;
        const color = getSubjectColor(subject);
        const icon = getSubjectIcon(subject);
        const isOpen = openSubjects[subject] || false;
        return (
          <SubjectFolder
            key={subject}
            subject={subject}
            decks={subjectDecks}
            icon={icon}
            color={color}
            show={isOpen}
            onToggle={() =>
              setOpenSubjects((prev) => ({
                ...prev,
                [subject]: !prev[subject],
              }))
            }
            sectionProgress={calcSectionProgress(subjectDecks)}
            {...folderProps}
          />
        );
      })}

      <PracticasFolder
        decks={practicaDecks}
        show={showPracticas}
        onToggle={() => setShowPracticas(!showPracticas)}
        sectionProgress={practicasProgress}
        {...folderProps}
      />

      <ExamenesFolder
        groups={examenGroups}
        show={showExamenes}
        onToggle={() => setShowExamenes(!showExamenes)}
        sectionProgress={examenesProgress}
        {...folderProps}
      />

      <PruebasFolder
        groups={pruebaGroups}
        show={showPruebas}
        onToggle={() => setShowPruebas(!showPruebas)}
        sectionProgress={pruebasProgress}
        {...folderProps}
      />

      <MasFolder
        librosDecks={librosDecks}
        materiasSalvadasDecks={materiasSalvadasDecks}
        showMas={showMas}
        onToggleMas={() => setShowMas(!showMas)}
        showLibros={showLibros}
        onToggleLibros={() => setShowLibros(!showLibros)}
        showMateriasSalvadas={showMateriasSalvadas}
        onToggleMateriasSalvadas={() =>
          setShowMateriasSalvadas(!showMateriasSalvadas)
        }
        sectionProgress={mainProgress}
        librosProgress={librosProgress}
        materiasSalvadasProgress={materiasSalvadasProgress}
        {...folderProps}
      />

      <ExtrasFolder
        decks={extraDecks}
        show={showExtras}
        onToggle={() => setShowExtras(!showExtras)}
        sectionProgress={extraProgress}
        {...folderProps}
      />

      {decks.length === 0 && (
        <div className="empty-state">
          <div className="empty-icon-wrapper">
            <div className="empty-icon">{Icons.book}</div>
          </div>
          <h3>No hay mazos</h3>
          <p>Crea tu primer mazo para empezar a estudiar</p>
          <button
            className="btn btn-primary btn-create"
            onClick={() => setShowCreateModal(true)}
          >
            <span className="btn-icon">{Icons.plus}</span>
            <span>Crear mazo</span>
          </button>
        </div>
      )}

      <div className="clear-data-section">
        <button
          className="btn btn-clear-data"
          onClick={() => setShowClearModal(true)}
          title="Borrar todos los datos guardados"
        >
          <span className="btn-icon">{Icons.database}</span>
          <span>Borrar todos los datos</span>
        </button>
        <p className="clear-data-hint">
          Elimina todo el progreso y restaura los mazos originales
        </p>
      </div>

      <CreateDeckModal
        show={showCreateModal}
        onClose={() => setShowCreateModal(false)}
        newDeckName={newDeckName}
        setNewDeckName={setNewDeckName}
        newDeckDesc={newDeckDesc}
        setNewDeckDesc={setNewDeckDesc}
        onCreate={handleCreate}
      />

      <ResetProgressModal
        show={showResetModal}
        deck={deckToReset}
        step={resetStep}
        onClose={closeResetModal}
        onConfirm={handleResetConfirm}
      />

      <ClearAllDataModal
        show={showClearModal}
        step={clearStep}
        onClose={closeClearModal}
        onConfirm={handleClearConfirm}
      />
    </div>
  );
}
