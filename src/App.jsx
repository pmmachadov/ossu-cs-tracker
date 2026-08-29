import { useState, useEffect, useRef } from "react";
import toast from "react-hot-toast";
import { motion, AnimatePresence } from "motion/react";
import { DeckList } from "./view/DeckList";
import { StudyView } from "./view/StudyView";
import { CardEditor } from "./view/CardEditor";
import { StatsView } from "./view/StatsView";
import { DataStore } from "./model/DataStore";
import { Deck } from "./model/Deck";
import "./App.css";

function App() {
  const [decks, setDecks] = useState([]);
  const [currentView, setCurrentView] = useState("decks"); // decks, study, edit, stats
  const [selectedDeck, setSelectedDeck] = useState(null);
  const [loading, setLoading] = useState(true);
  const backupInputRef = useRef(null);

  // Cargar mazos al iniciar, preservando progreso guardado
  useEffect(() => {
    const loadData = async () => {
      try {
        // Intentar restaurar progreso guardado primero
        const savedDecks = DataStore.loadDecks();
        
        const deckFiles = [
          // Mazo Examen Java (los 20 exÃƒÂ¡menes de Grado Superior)
          "/data/examenes/examen-java.json",
        ];

        const results = await Promise.allSettled(
          deckFiles.map((url) => fetch(url).then((r) => r.json())),
        );

        const newDecks = [];
        results.forEach((result, index) => {
          if (result.status === "fulfilled") {
            const data = result.value;
            const deck = new Deck(data.name, data.id);
            deck.description = data.description || "";
            deck.subject = data.subject || "";
            if (Array.isArray(data.cards)) {
              data.cards.forEach((card) => {
                deck.addCard(card.front, card.back, card.tags || [], card.imageUrl || '', card.id);
              });
            }
            newDecks.push(deck);
          } else {
            console.error(`Error loading ${deckFiles[index]}:`, result.reason);
          }
        });

        // Fusionar progreso guardado (localStorage) con los datos frescos (JSON)
        if (savedDecks.length > 0) {
          newDecks.forEach(deck => {
            const savedDeck = savedDecks.find(d => d.id === deck.id);
            if (savedDeck) {
              // Restaurar progreso de cada tarjeta por ID estable
              deck.cards.forEach(card => {
                const savedCard = savedDeck.cards.find(c => c.id === card.id);
                if (savedCard) {
                  card.interval = savedCard.interval;
                  card.repetitions = savedCard.repetitions;
                  card.easinessFactor = savedCard.easinessFactor;
                  card.nextReview = savedCard.nextReview;
                  card.lastReviewed = savedCard.lastReviewed;
                  card.status = savedCard.status;
                }
              });
              // Restaurar estadÃƒÂ­sticas del mazo
              deck.lastStudied = savedDeck.lastStudied;
              if (savedDeck.studyStats) {
                deck.studyStats = savedDeck.studyStats;
              }
              // Restaurar registro de visualizaciones (datos del grÃƒÂ¡fico de progreso)
              if (savedDeck.viewLog) {
                deck.viewLog = savedDeck.viewLog;
              }
            }
          });
        }

        setDecks(newDecks);
        DataStore.saveDecks(newDecks);
      } catch (error) {
        console.error("Error loading default decks:", error);
        setDecks([]);
      }

      setLoading(false);
    };

    loadData();
  }, []);

  // Guardar mazos cuando cambian (con aviso si el guardado se degrada o falla)
  useEffect(() => {
    if (!loading) {
      const result = DataStore.saveDecks(decks);
      if (result && !result.ok) {
        toast.error(
          "⚠️ No se pudo guardar el progreso. El almacenamiento está lleno. Descarga una copia de seguridad.",
          { duration: 6000 },
        );
      } else if (result && result.degraded) {
        toast(
          "ℹ️ Almacenamiento casi lleno: el progreso se guardó, pero se recortó el historial de la gráfica.",
          { duration: 5000 },
        );
      }
    }
  }, [decks, loading]);

  const handleCreateDeck = (name, description = "") => {
    const newDeck = new Deck(name);
    newDeck.description = description;
    setDecks([...decks, newDeck]);
    return newDeck;
  };

  const handleDeleteDeck = (deckId) => {
    setDecks(decks.filter((d) => d.id !== deckId));
    if (selectedDeck?.id === deckId) {
      setSelectedDeck(null);
      setCurrentView("decks");
    }
  };

  const handleStudyDeck = (deck) => {
    setSelectedDeck(deck);
    setCurrentView("study");
  };

  const handleEditDeck = (deck) => {
    setSelectedDeck(deck);
    setCurrentView("edit");
  };

  const handleStatsDeck = (deck) => {
    setSelectedDeck(deck);
    setCurrentView("stats");
  };

  const handleUpdateDeck = (updatedDeck) => {
    const nextDecks = decks.map((d) => (d.id === updatedDeck.id ? updatedDeck : d));
    setDecks(nextDecks);
    setSelectedDeck(updatedDeck);
    // Guardado inmediato y seguro en localStorage
    DataStore.saveDecks(nextDecks);
  };

  const handleBack = () => {
    setCurrentView("decks");
    setSelectedDeck(null);
  };

  const handleResetProgress = (deckId) => {
    const deck = decks.find((d) => d.id === deckId);
    if (deck) {
      deck.reset();
      setDecks([...decks]);
    }
  };

  const handleClearAllData = async () => {
    // Limpiar localStorage
    DataStore.clearAll();
    // Recargar la pÃƒÂ¡gina para recrear los mazos desde cero
    window.location.reload();
  };

  // --- Copias de seguridad (protección frente a borrado del localStorage) ---
  const handleBackup = () => {
    const stamp = new Date().toISOString().slice(0, 10);
    DataStore.downloadBackup(decks, `anki-cards-backup-${stamp}.json`);
    toast.success("Copia de seguridad descargada ✅");
  };

  const handleRestoreBackup = (file) => {
    if (!file) return;
    const reader = new FileReader();
    reader.onload = (e) => {
      const imported = DataStore.importFromJSON(e.target.result);
      if (!imported) {
        toast.error("El archivo no es una copia de seguridad válida.");
        return;
      }
      setDecks(imported);
      setSelectedDeck(null);
      setCurrentView("decks");
      toast.success("Copia restaurada correctamente ✅");
    };
    reader.readAsText(file);
  };

  if (loading) {
    return (
      <div className="app-loading">
        <div className="spinner"></div>
        <p>Cargando...</p>
      </div>
    );
  }

  return (
    <div className="app">
      <input
        ref={backupInputRef}
        type="file"
        accept="application/json,.json"
        style={{ display: "none" }}
        onChange={(e) => {
          handleRestoreBackup(e.target.files && e.target.files[0]);
          e.target.value = "";
        }}
      />
      
      <main className="app-main">
        <AnimatePresence mode="wait">
          {currentView === "decks" && (
            <motion.div
              key="decks"
              initial={{ opacity: 0, y: 15 }}
              animate={{ opacity: 1, y: 0 }}
              exit={{ opacity: 0, y: -15 }}
              transition={{ duration: 0.25, ease: "easeOut" }}
            >
              <DeckList
                decks={decks}
                onDeleteDeck={handleDeleteDeck}
                onStudyDeck={handleStudyDeck}
                onEditDeck={handleEditDeck}
                onStatsDeck={handleStatsDeck}
                onResetDeck={handleResetProgress}
                onClearAllData={handleClearAllData}
                onBackup={handleBackup}
                onRestoreBackup={() => backupInputRef.current?.click()}
              />
            </motion.div>
          )}

          {currentView === "study" && selectedDeck && (
            <motion.div
              key={`study-${selectedDeck.id}`}
              initial={{ opacity: 0, scale: 0.98, y: 15 }}
              animate={{ opacity: 1, scale: 1, y: 0 }}
              exit={{ opacity: 0, scale: 0.98, y: -15 }}
              transition={{ duration: 0.25, ease: "easeOut" }}
            >
              <StudyView
                deck={selectedDeck}
                onBack={handleBack}
                onUpdateDeck={handleUpdateDeck}
              />
            </motion.div>
          )}

          {currentView === "edit" && selectedDeck && (
            <motion.div
              key={`edit-${selectedDeck.id}`}
              initial={{ opacity: 0, y: 15 }}
              animate={{ opacity: 1, y: 0 }}
              exit={{ opacity: 0, y: -15 }}
              transition={{ duration: 0.25, ease: "easeOut" }}
            >
              <CardEditor
                deck={selectedDeck}
                onBack={handleBack}
                onUpdateDeck={handleUpdateDeck}
              />
            </motion.div>
          )}

          {currentView === "stats" && selectedDeck && (
            <motion.div
              key={`stats-${selectedDeck.id}`}
              initial={{ opacity: 0, scale: 0.98, y: 15 }}
              animate={{ opacity: 1, scale: 1, y: 0 }}
              exit={{ opacity: 0, scale: 0.98, y: -15 }}
              transition={{ duration: 0.25, ease: "easeOut" }}
            >
              <StatsView
                deck={selectedDeck}
                onBack={handleBack}
                onResetProgress={handleResetProgress}
              />
            </motion.div>
          )}
        </AnimatePresence>
      </main>
    </div>
  );
}

export default App;
