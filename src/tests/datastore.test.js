import { describe, it, expect, beforeEach, vi } from 'vitest';
import { DataStore } from '../model/DataStore';
import { Deck } from '../model/Deck';

describe('DataStore', () => {
  beforeEach(() => {
    localStorage.clear();
    vi.useFakeTimers();
    vi.setSystemTime(new Date('2026-05-17T12:00:00Z'));
  });

  afterEach(() => {
    vi.useRealTimers();
  });

  describe('saveDecks / loadDecks', () => {
    it('saves and loads decks', () => {
      const deck = new Deck('Test', 'test-1');
      deck.addCard('Front', 'Back');
      DataStore.saveDecks([deck]);

      const loaded = DataStore.loadDecks();
      expect(loaded).toHaveLength(1);
      expect(loaded[0].name).toBe('Test');
      expect(loaded[0].cards).toHaveLength(1);
      expect(loaded[0].cards[0].front).toBe('Front');
    });

    it('loaded decks are Deck instances', () => {
      const deck = new Deck('Test', 'test-1');
      DataStore.saveDecks([deck]);
      const loaded = DataStore.loadDecks();
      expect(loaded[0]).toBeInstanceOf(Deck);
    });

    it('returns empty array when no data saved', () => {
      const loaded = DataStore.loadDecks();
      expect(loaded).toEqual([]);
    });

    it('returns empty array on corrupted data', () => {
      localStorage.setItem('anki_cards_data', '{corrupted json');
      const loaded = DataStore.loadDecks();
      expect(loaded).toEqual([]);
    });
  });

  describe('exportToJSON / importFromJSON', () => {
    it('exports and imports decks', () => {
      const deck = new Deck('Test', 'test-1');
      deck.addCard('Q', 'A');
      const json = DataStore.exportToJSON([deck]);
      expect(typeof json).toBe('string');

      const imported = DataStore.importFromJSON(json);
      expect(imported).toHaveLength(1);
      expect(imported[0].name).toBe('Test');
      expect(imported[0].cards[0].front).toBe('Q');
    });

    it('imported decks are Deck instances', () => {
      const deck = new Deck('Test', 'test-1');
      const json = DataStore.exportToJSON([deck]);
      const imported = DataStore.importFromJSON(json);
      expect(imported[0]).toBeInstanceOf(Deck);
    });

    it('returns null on invalid JSON', () => {
      const result = DataStore.importFromJSON('not json');
      expect(result).toBeNull();
    });
  });

  describe('clearAll', () => {
    it('removes saved data from localStorage', () => {
      DataStore.saveDecks([new Deck('Test', 't1')]);
      expect(DataStore.loadDecks()).toHaveLength(1);
      DataStore.clearAll();
      expect(DataStore.loadDecks()).toEqual([]);
    });
  });
});
