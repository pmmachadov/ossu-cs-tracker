// Modelo: DataStore - Persistencia usando localStorage
// Protección del progreso en capas:
//   1) Antes de sobrescribir, se copia el último dato bueno a una clave de respaldo.
//   2) Si el guardado se desborda (quota ~5MB), se recorta lo volátil y se reintenta.
//   3) Si al cargar los datos principales están corruptos, se intenta el respaldo.

import { Deck } from './Deck';

const STORAGE_KEY = 'anki_cards_data';
const STORAGE_KEY_BACKUP = 'anki_cards_data_backup';

export class DataStore {
  /**
   * Guarda los mazos. Devuelve { ok: true, degraded: boolean } o { ok: false, error }.
   */
  static saveDecks(decks) {
    // 1) Copia de seguridad del último dato bueno antes de sobrescribir.
    try {
      const current = localStorage.getItem(STORAGE_KEY);
      if (current) localStorage.setItem(STORAGE_KEY_BACKUP, current);
    } catch (e) {
      // si no hay espacio para el respaldo, continuamos igualmente
    }

    // 2) Intento normal (toJSON() ya recorta los logs antes de persistir).
    try {
      const payload = decks.map((d) => d.toJSON());
      localStorage.setItem(STORAGE_KEY, JSON.stringify(payload));
      return { ok: true, degraded: false };
    } catch (err) {
      // 3) Quota superada → compactar lo volátil (historial gráfica) y reintentar.
      try {
        const compact = decks.map((d) => d.toJSON()).map((d) => ({
          ...d,
          viewLog: [],
          studyStats: { ...d.studyStats, studyHistory: [] },
        }));
        localStorage.setItem(STORAGE_KEY, JSON.stringify(compact));
        return { ok: true, degraded: true };
      } catch (err2) {
        return { ok: false, error: err2 };
      }
    }
  }

  static loadDecks() {
    // Intenta los datos principales y, si fallan, el respaldo.
    for (const key of [STORAGE_KEY, STORAGE_KEY_BACKUP]) {
      try {
        const data = localStorage.getItem(key);
        if (!data) continue;
        const parsed = JSON.parse(data);
        if (!Array.isArray(parsed)) continue;
        return parsed.map((d) => Deck.fromJSON(d));
      } catch (error) {
        console.error(`Error loading decks from ${key}:`, error);
      }
    }
    return [];
  }

  static exportToJSON(decks) {
    return JSON.stringify(decks.map((d) => d.toJSON()), null, 2);
  }

  static importFromJSON(jsonString) {
    try {
      const data = JSON.parse(jsonString);
      return data.map((d) => Deck.fromJSON(d));
    } catch (error) {
      console.error('Error importing decks:', error);
      return null;
    }
  }

  static clearAll() {
    localStorage.removeItem(STORAGE_KEY);
    localStorage.removeItem(STORAGE_KEY_BACKUP);
  }

  /** Descarga una copia de seguridad en un archivo .json (protección frente a
   *  borrado del localStorage por el navegador o al cambiar de dispositivo). */
  static downloadBackup(decks, filename = 'anki-cards-backup.json') {
    const blob = new Blob([DataStore.exportToJSON(decks)], {
      type: 'application/json',
    });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = filename;
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
    URL.revokeObjectURL(url);
  }
}
