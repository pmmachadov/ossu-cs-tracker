import { useState, useEffect } from "react";
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

  // Cargar mazos al iniciar, preservando progreso guardado
  useEffect(() => {
    const loadData = async () => {
      try {
        // Intentar restaurar progreso guardado primero
        const savedDecks = DataStore.loadDecks();
        
        const deckFiles = [
          "/data/sistemas-informaticos.json",
          "/data/sistemas-informaticos-eac3.json",
          "/data/entornos-desarrollo.json",
          "/data/dwec-completo.json",
          "/data/dwec-async.json",
          "/data/dwec-express.json",
          "/data/dwec-modulos.json",
          "/data/dwec-sintaxis.json",
          "/data/dwec-u3l2-actualizacion-dom.json",
          "/data/dwec-unidad3-dom-parte1.json",
          "/data/dwec-unidad3-dom-parte2.json",
          "/data/prueba-dwec-eac1.json",
          "/data/prueba-dwec-eac3.json",
          "/data/prueba-dwec-proyecto.json",
          "/data/prueba-ed-eac2.json",
          "/data/prueba-ed-eac3.json",
          "/data/prueba-ed-proyecto.json",
          "/data/prueba-si-eac1.json",
          "/data/prueba-si-eac2.json",
          "/data/prueba-si-eac3.json",
          "/data/practicas-dwec.json",
          "/data/practicas-ed.json",
          "/data/practicas-si.json",
          "/data/examenes/si-eac1.json",
          "/data/examenes/si-eac2.json",
          "/data/examenes/si-eac3.json",
          "/data/examenes/dwec-eac1.json",
          "/data/examenes/dwec-eac3.json",
          "/data/examenes/ed-eac2.json",
          "/data/examenes/ed-eac3.json",
          "/data/examenes/si-comandos.json",
          "/data/preguntas-directas/pd-all.json",
          "/data/preguntas-directas/materias salvadas/pd-dwec.json",
          "/data/libros/tips-web-dev.json",
          "/data/libros/eloquent-js.json",
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
              // Restaurar estadísticas del mazo
              deck.lastStudied = savedDeck.lastStudied;
              if (savedDeck.studyStats) {
                deck.studyStats = savedDeck.studyStats;
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

  // Guardar mazos cuando cambian
  useEffect(() => {
    if (!loading) {
      DataStore.saveDecks(decks);
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
    setDecks(decks.map((d) => (d.id === updatedDeck.id ? updatedDeck : d)));
    setSelectedDeck(updatedDeck);
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
    // Recargar la página para recrear los mazos desde cero
    window.location.reload();
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
      <main className="app-main">
        {currentView === "decks" && (
          <DeckList
            decks={decks}
            onCreateDeck={handleCreateDeck}
            onDeleteDeck={handleDeleteDeck}
            onStudyDeck={handleStudyDeck}
            onEditDeck={handleEditDeck}
            onStatsDeck={handleStatsDeck}
            onResetDeck={handleResetProgress}
            onClearAllData={handleClearAllData}
          />
        )}

        {currentView === "study" && selectedDeck && (
          <StudyView
            deck={selectedDeck}
            onBack={handleBack}
            onUpdateDeck={handleUpdateDeck}
          />
        )}

        {currentView === "edit" && selectedDeck && (
          <CardEditor
            deck={selectedDeck}
            onBack={handleBack}
            onUpdateDeck={handleUpdateDeck}
          />
        )}

        {currentView === "stats" && selectedDeck && (
          <StatsView
            deck={selectedDeck}
            onBack={handleBack}
            onResetProgress={handleResetProgress}
          />
        )}
      </main>
    </div>
  );
}

export default App;
