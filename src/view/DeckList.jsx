import { useState, useEffect } from "react";
import "./DeckList.css";
import { Icons } from "./Icons";
import {
  MAIN_SUBJECTS,
  getSubjectIcon,
  getSubjectColor,
} from "./deckHelpers";
import {
  ExamenJavaFolder,
  PreguntasDirectasFolder,
  SubjectFolder,
  PracticasFolder,
  ExamenesFolder,
  PruebasFolder,
  MasFolder,
  ExtrasFolder,
} from "./SectionFolders";
import {
  ResetProgressModal,
  ClearAllDataModal,
} from "./DeckModals";
import {
  startRandomSpeedManager,
  stopRandomSpeedManager,
} from "./randomSpeedManager";

export function DeckList({
  decks,
  onDeleteDeck,
  onStudyDeck,
  onEditDeck,
  onStatsDeck,
  onResetDeck,
  onClearAllData,
  onBackup,
  onRestoreBackup,
}) {
  const [showResetModal, setShowResetModal] = useState(false);
  const [resetStep, setResetStep] = useState(1);
  const [deckToReset, setDeckToReset] = useState(null);

  const [showClearModal, setShowClearModal] = useState(false);
  const [clearStep, setClearStep] = useState(1);

  const [showExtras, setShowExtras] = useState(false);
  const [showPruebas, setShowPruebas] = useState(false);
  const [showPracticas, setShowPracticas] = useState(false);
  const [showExamenes, setShowExamenes] = useState(true); // abierto por defecto para ver el ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃ‚Â¡rea Examen
  const [showPreguntasDirectas, setShowPreguntasDirectas] = useState(false);
  const [showLibros, setShowLibros] = useState(false);
  const [showMateriasSalvadas, setShowMateriasSalvadas] = useState(false);
  const [isFirstTenSeconds] = useState(true);
  const [showHeroPctGlow] = useState(true);
  const [showMas, setShowMas] = useState(false);
  const [openSubjects, setOpenSubjects] = useState({}); // cada materia se abre/cierra individualmente

  const [googleBordersVisible, setGoogleBordersVisible] = useState(() => {
    const saved = localStorage.getItem("google_borders_visible");
    return saved === "true";
  });

  useEffect(() => {
    localStorage.setItem("google_borders_visible", String(googleBordersVisible));
    if (googleBordersVisible) {
      document.body.classList.remove("google-borders-hidden");
      startRandomSpeedManager();
    } else {
      document.body.classList.add("google-borders-hidden");
      stopRandomSpeedManager();
    }
  }, [googleBordersVisible]);

  const toggleGoogleBorders = () => {
    setGoogleBordersVisible((prev) => !prev);
  };

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
  const totalLearned = decks.reduce(
    (acc, d) => acc + d.cards.filter((c) => c.status === "aprendido").length,
    0,
  );

  const filteredDecks = decks;

  const examenJavaDecks = filteredDecks.filter((d) => d.id?.startsWith("examen-java"));
  const examenDecks = filteredDecks.filter(
    (d) =>
      d.id?.startsWith("examen-") &&
      !d.id?.startsWith("examen-java") &&
      d.subject !== "Materias salvadas",
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

  const subjectOrder = ["Programación", "Bases de Datos", "Sistemas", "Marcas"];
  const sortedSubjects = Object.keys(examenGroups).sort((a, b) => {
    const ia = subjectOrder.indexOf(a);
    const ib = subjectOrder.indexOf(b);
    if (ia !== -1 && ib !== -1) return ia - ib;
    if (ia !== -1) return -1;
    if (ib !== -1) return 1;
    return a.localeCompare(b);
  });

  const pruebaGroups = pruebaDecks.reduce((acc, deck) => {
    const subject = deck.subject || "Sin materia";
    if (!acc[subject]) acc[subject] = [];
    acc[subject].push(deck);
    return acc;
  }, {});
  const practicaDecks = filteredDecks.filter((d) =>
    d.id?.startsWith("practica-"),
  );
  const materiasSalvadasDecks = filteredDecks.filter(
    (d) => d.subject === "Materias salvadas",
  );
  const preguntasDirectasDecks = filteredDecks.filter(
    (d) => d.id?.startsWith("pd-") && !d.id?.startsWith("libro-"),
  );
  const librosDecks = filteredDecks.filter(
    (d) =>
      (d.id?.startsWith("libro-") || d.subject?.startsWith("Libro:")) &&
      d.subject !== "Materias salvadas",
  );
  const mainDecks = filteredDecks.filter(
    (d) =>
      !d.id?.startsWith("pd-") &&
      !d.id?.startsWith("examen-") &&
      !d.id?.startsWith("prueba-") &&
      !d.name?.startsWith("Prueba -") &&
      !d.id?.startsWith("libro-") &&
      d.subject !== "Materias salvadas",
  );
  const extraDecks = filteredDecks.filter(
    (d) => d.id?.startsWith("pd-") && !materiasSalvadasDecks.includes(d),
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
    const learned = sectionDecks.reduce(
      (acc, d) => acc + d.cards.filter((c) => c.status === "aprendido").length,
      0,
    );
    return Math.round((learned / total) * 100);
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
      {/* Stats unificados en un único cuadro compacto */}
      <section className="deck-hero-compact">
        <div className="hero-stats-row">
          <div className="stat-compact-item stat-compact-pill stat-pill-mazos">
            <div className="stat-compact-info">
              <div className="stat-compact-val">{decks.length}</div>
              <div className="stat-compact-lbl">Mazos Activos</div>
            </div>
          </div>

          <div className="stat-compact-item stat-compact-pill stat-pill-aprendidas">
            <div className="stat-compact-info">
              <div className="stat-compact-val">{totalLearned}</div>
              <div className="stat-compact-lbl">Aprendidas</div>
            </div>
          </div>

          <div className="stat-compact-item stat-compact-progress">
            <div className="stat-compact-info">
                {(() => {
                  const heroPct = Math.round((totalLearned / (totalCards || 1)) * 100) || 0;
                  return (
                    <div className={`bento-mini-bar ${isFirstTenSeconds ? "google-active" : "google-expired"}`}>
                    <div
                      className={`bento-mini-fill ${showHeroPctGlow ? "pct-glow-active" : "pct-glow-off"}`}
                      style={{
                        width: `${heroPct}%`,
                      }}
                    >
                      <span className="hero-fill-pct-text">
                        {heroPct}%
                      </span>
                    </div>
                  </div>
                  );
                })()}
              </div>
            </div>

            <button
              type="button"
            className={`btn-toggle-google-borders ${googleBordersVisible ? "borders-on" : "borders-off"}`}
            onClick={toggleGoogleBorders}
            title={
              googleBordersVisible
                ? "Ocultar bordes animados de Google"
                : "Mostrar bordes animados de Google"
            }
          >
            <span className="google-borders-icon">
              <svg
                width="16"
                height="16"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                strokeWidth="2.2"
                strokeLinecap="round"
                strokeLinejoin="round"
              >
                <circle cx="12" cy="12" r="4" />
                <path d="M12 2v2M12 20v2M4.93 4.93l1.41 1.41M17.66 17.66l1.41 1.41M2 12h2M20 12h2M6.34 17.66l-1.41 1.41M19.07 4.93l-1.41 1.41" />
              </svg>
            </span>
            <span className="google-borders-text">
              Bordes {googleBordersVisible ? "ON" : "OFF"}
            </span>
            <span
              className={`google-borders-status-dot ${googleBordersVisible ? "dot-on" : "dot-off"}`}
            />
          </button>
        </div>
      </section>

      <ExamenJavaFolder decks={examenJavaDecks} {...folderProps} />

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
        <div className="backup-actions">
          <button
            className="btn btn-backup"
            onClick={onBackup}
            title="Descargar una copia de seguridad con todo tu progreso"
          >
            <span className="btn-icon">{Icons.download}</span>
            <span>Guardar copia de seguridad</span>
          </button>
          <button
            className="btn btn-restore"
            onClick={onRestoreBackup}
            title="Restaurar el progreso desde un archivo de copia"
          >
            <span className="btn-icon">{Icons.upload}</span>
            <span>Restaurar copia</span>
          </button>
        </div>
        <button
          className="btn btn-clear-data"
          onClick={() => setShowClearModal(true)}
          title="Borrar todos los datos guardados"
        >
          <span className="btn-icon">{Icons.database}</span>
          <span>Borrar todos los datos</span>
        </button>
        <p className="clear-data-hint">
          Elimina todo el progreso y restaura los mazos originales. Antes de
          borrar, descarga una copia de seguridad.
        </p>
      </div>

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
