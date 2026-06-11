import { describe, it, expect, beforeEach, vi } from 'vitest';
import { Card, Deck, DIFFICULTY } from '../model/Deck';

// ============================================================
// Card Tests
// ============================================================

describe('Card', () => {
  /** @type {Card} */
  let card;

  beforeEach(() => {
    vi.useFakeTimers();
    vi.setSystemTime(new Date('2026-05-17T12:00:00Z'));
    card = new Card('test-1', 'Front text', 'Back text', ['tag1'], '/img.png');
  });

  afterEach(() => {
    vi.useRealTimers();
  });

  describe('constructor', () => {
    it('assigns id, front, back, tags, and imageUrl', () => {
      expect(card.id).toBe('test-1');
      expect(card.front).toBe('Front text');
      expect(card.back).toBe('Back text');
      expect(card.tags).toEqual(['tag1']);
      expect(card.imageUrl).toBe('/img.png');
    });

    it('defaults tags to empty array when not provided', () => {
      const c = new Card('id', 'f', 'b');
      expect(c.tags).toEqual([]);
    });

    it('defaults imageUrl to empty string when not provided', () => {
      const c = new Card('id', 'f', 'b');
      expect(c.imageUrl).toBe('');
    });

    it('initializes SM-2 state correctly', () => {
      expect(card.interval).toBe(0);
      expect(card.repetitions).toBe(0);
      expect(card.easinessFactor).toBe(2.5);
      expect(card.status).toBe('new');
      expect(card.lastReviewed).toBeNull();
      // nextReview should be Date.now() (now in fake time)
      expect(card.nextReview).toBe(Date.now());
    });
  });

  describe('review — PROCESANDO (otra vez)', () => {
    beforeEach(() => {
      card.repetitions = 3;
      card.easinessFactor = 2.5;
      card.interval = 10;
      card.review(DIFFICULTY.PROCESANDO);
    });

    it('resets repetitions to 0', () => {
      expect(card.repetitions).toBe(0);
    });

    it('decreases easiness factor by 0.2', () => {
      expect(card.easinessFactor).toBe(2.3);
    });

    it('clamps easiness factor to minimum of 1.3', () => {
      card.easinessFactor = 1.3;
      card.review(DIFFICULTY.PROCESANDO);
      expect(card.easinessFactor).toBe(1.3);
    });

    it('sets interval to 1 day', () => {
      expect(card.interval).toBe(1);
    });

    it('sets status to procesando', () => {
      expect(card.status).toBe('procesando');
    });

    it('sets nextReview to now + 1 day', () => {
      const expected = Date.now() + 1 * 24 * 60 * 60 * 1000;
      expect(card.nextReview).toBe(expected);
    });

    it('sets lastReviewed', () => {
      expect(card.lastReviewed).toBe(Date.now());
    });
  });

  describe('review — APRENDIDO (first repetition)', () => {
    beforeEach(() => {
      card.review(DIFFICULTY.APRENDIDO);
    });

    it('increments repetitions to 1', () => {
      expect(card.repetitions).toBe(1);
    });

    it('increases easiness factor by 0.1', () => {
      expect(card.easinessFactor).toBe(2.6);
    });

    it('sets interval to 4 days', () => {
      expect(card.interval).toBe(4);
    });

    it('sets status to aprendido', () => {
      expect(card.status).toBe('aprendido');
    });
  });

  describe('review — APRENDIDO (second repetition)', () => {
    beforeEach(() => {
      card.repetitions = 1;
      card.review(DIFFICULTY.APRENDIDO);
    });

    it('increments repetitions to 2', () => {
      expect(card.repetitions).toBe(2);
    });

    it('sets interval to 8 days (4 * 2)', () => {
      expect(card.interval).toBe(8);
    });

    it('sets status to aprendido', () => {
      expect(card.status).toBe('aprendido');
    });
  });

  describe('review — APRENDIDO (third+ repetition)', () => {
    beforeEach(() => {
      card.repetitions = 2;
      card.interval = 8;
      card.easinessFactor = 2.5;
      card.review(DIFFICULTY.APRENDIDO);
    });

    it('increments repetitions to 3', () => {
      expect(card.repetitions).toBe(3);
    });

    it('multiplies interval by easiness factor (8 * 2.6 = 20.8 → 21)', () => {
      expect(card.interval).toBe(21);
    });

    it('sets status to aprendido', () => {
      expect(card.status).toBe('aprendido');
    });
  });

  describe('review — returns correct result object', () => {
    it('returns interval, nextReview, and status', () => {
      const result = card.review(DIFFICULTY.APRENDIDO);
      expect(result).toHaveProperty('interval');
      expect(result).toHaveProperty('nextReview');
      expect(result).toHaveProperty('status');
      expect(result.status).toBe('aprendido');
    });
  });

  describe('isDue', () => {
    it('returns true when now >= nextReview', () => {
      card.nextReview = Date.now() - 1000;
      expect(card.isDue()).toBe(true);
    });

    it('returns false when now < nextReview', () => {
      card.nextReview = Date.now() + 86400000; // 1 day later
      expect(card.isDue()).toBe(false);
    });
  });

  describe('getNextReviewText', () => {
    it('returns "Ahora" when due', () => {
      card.nextReview = Date.now() - 1000;
      expect(card.getNextReviewText()).toBe('Ahora');
    });

    it('returns "1 día" when 1 day away', () => {
      card.nextReview = Date.now() + 86400000;
      expect(card.getNextReviewText()).toBe('1 día');
    });

    it('returns "N días" when multiple days away', () => {
      card.nextReview = Date.now() + 3 * 86400000;
      expect(card.getNextReviewText()).toBe('3 días');
    });
  });
});

// ============================================================
// Deck Tests
// ============================================================

describe('Deck', () => {
  /** @type {Deck} */
  let deck;

  beforeEach(() => {
    vi.useFakeTimers();
    vi.setSystemTime(new Date('2026-05-17T12:00:00Z'));
    deck = new Deck('Test Deck', 'test-deck-1');
  });

  afterEach(() => {
    vi.useRealTimers();
  });

  describe('constructor', () => {
    it('sets name and id', () => {
      expect(deck.name).toBe('Test Deck');
      expect(deck.id).toBe('test-deck-1');
    });

    it('generates id from Date.now() when not provided', () => {
      const d = new Deck('No ID');
      expect(d.id).toBe(Date.now().toString());
    });

    it('initializes cards as empty array', () => {
      expect(deck.cards).toEqual([]);
    });

    it('initializes studyStats with zeros', () => {
      expect(deck.studyStats).toEqual({
        totalReviews: 0,
        procesando: 0,
        aprendido: 0,
        streak: 0,
        bestStreak: 0,
        studyHistory: [],
      });
    });
  });

  describe('addCard', () => {
    it('adds a card to the deck', () => {
      const card = deck.addCard('Front', 'Back');
      expect(deck.cards).toHaveLength(1);
      expect(card.front).toBe('Front');
      expect(card.back).toBe('Back');
    });

    it('generates card id from deck id + index when not provided', () => {
      const card = deck.addCard('F', 'B');
      expect(card.id).toBe('test-deck-1_0');
    });

    it('uses provided card id', () => {
      const card = deck.addCard('F', 'B', [], '', 'custom-id');
      expect(card.id).toBe('custom-id');
    });

    it('accepts tags and imageUrl', () => {
      const card = deck.addCard('F', 'B', ['tag1', 'tag2'], '/img.svg');
      expect(card.tags).toEqual(['tag1', 'tag2']);
      expect(card.imageUrl).toBe('/img.svg');
    });

    it('returns the created Card instance', () => {
      const card = deck.addCard('Q', 'A');
      expect(card).toBeInstanceOf(Card);
    });
  });

  describe('removeCard', () => {
    it('removes a card by id', () => {
      deck.addCard('F1', 'B1');
      const c2 = deck.addCard('F2', 'B2');
      deck.addCard('F3', 'B3');
      deck.removeCard(c2.id);
      expect(deck.cards).toHaveLength(2);
      expect(deck.cards.every(c => c.id !== c2.id)).toBe(true);
    });

    it('does nothing when card id does not exist', () => {
      deck.addCard('F', 'B');
      deck.removeCard('nonexistent');
      expect(deck.cards).toHaveLength(1);
    });
  });

  describe('getDueCards', () => {
    it('returns cards whose nextReview has passed', () => {
      const c1 = deck.addCard('F1', 'B1');
      const c2 = deck.addCard('F2', 'B2');
      c1.nextReview = Date.now() - 1000; // due
      c2.nextReview = Date.now() + 86400000; // not due
      const due = deck.getDueCards();
      expect(due).toHaveLength(1);
      expect(due[0].id).toBe(c1.id);
    });
  });

  describe('getNewCards', () => {
    it('returns cards with status "new"', () => {
      const c1 = deck.addCard('F1', 'B1');
      const c2 = deck.addCard('F2', 'B2');
      c2.status = 'procesando';
      const newCards = deck.getNewCards();
      expect(newCards).toHaveLength(1);
      expect(newCards[0].id).toBe(c1.id);
    });
  });

  describe('getLearningCards', () => {
    it('returns cards with status "procesando"', () => {
      const c1 = deck.addCard('F1', 'B1');
      const c2 = deck.addCard('F2', 'B2');
      c1.status = 'procesando';
      c2.status = 'aprendido';
      const learning = deck.getLearningCards();
      expect(learning).toHaveLength(1);
      expect(learning[0].id).toBe(c1.id);
    });
  });

  describe('getStats', () => {
    it('returns correct counts for all categories', () => {
      const c1 = deck.addCard('F1', 'B1');
      const c2 = deck.addCard('F2', 'B2');
      const c3 = deck.addCard('F3', 'B3');
      c1.status = 'new';
      c1.nextReview = Date.now() + 86400000;
      c2.status = 'procesando';
      c2.nextReview = Date.now() + 86400000;
      c3.status = 'aprendido';
      c3.nextReview = Date.now() - 1000;

      const stats = deck.getStats();
      expect(stats.total).toBe(3);
      expect(stats.new).toBe(1);
      expect(stats.procesando).toBe(1);
      expect(stats.due).toBe(1);
      expect(stats.aprendido).toBe(1);
    });

    it('calculates mastery as percentage of aprendido cards', () => {
      deck.addCard('F1', 'B1');
      const c2 = deck.addCard('F2', 'B2');
      c2.status = 'aprendido';
      expect(deck.getStats().mastery).toBe(50);
    });

    it('returns 0 mastery when no cards', () => {
      expect(deck.getStats().mastery).toBe(0);
    });
  });

  describe('recordReview', () => {
    it('increments totalReviews', () => {
      deck.recordReview(DIFFICULTY.APRENDIDO);
      expect(deck.studyStats.totalReviews).toBe(1);
    });

    it('increments the specific difficulty counter', () => {
      deck.recordReview(DIFFICULTY.PROCESANDO);
      deck.recordReview(DIFFICULTY.APRENDIDO);
      expect(deck.studyStats.procesando).toBe(1);
      expect(deck.studyStats.aprendido).toBe(1);
    });

    it('adds entry to studyHistory', () => {
      deck.recordReview(DIFFICULTY.APRENDIDO);
      expect(deck.studyStats.studyHistory).toHaveLength(1);
      expect(deck.studyStats.studyHistory[0].difficulty).toBe('aprendido');
      expect(deck.studyStats.studyHistory[0].date).toBe(Date.now());
    });

    it('sets lastStudied', () => {
      deck.recordReview(DIFFICULTY.APRENDIDO);
      expect(deck.lastStudied).toBe(Date.now());
    });

    describe('streak tracking', () => {
      it('starts streak at 1 on first review', () => {
        deck.recordReview(DIFFICULTY.APRENDIDO);
        expect(deck.studyStats.streak).toBe(1);
      });

      it('increments streak when reviewing on consecutive days', () => {
        deck.recordReview(DIFFICULTY.APRENDIDO);
        expect(deck.studyStats.streak).toBe(1);

        vi.setSystemTime(new Date('2026-05-18T12:00:00Z'));
        deck.recordReview(DIFFICULTY.APRENDIDO);
        expect(deck.studyStats.streak).toBe(2);
      });

      it('resets streak to 1 when a day is skipped', () => {
        deck.recordReview(DIFFICULTY.APRENDIDO);
        vi.setSystemTime(new Date('2026-05-20T12:00:00Z'));
        deck.recordReview(DIFFICULTY.APRENDIDO);
        expect(deck.studyStats.streak).toBe(1);
      });

      it('updates bestStreak', () => {
        deck.recordReview(DIFFICULTY.APRENDIDO);
        vi.setSystemTime(new Date('2026-05-18T12:00:00Z'));
        deck.recordReview(DIFFICULTY.APRENDIDO);
        vi.setSystemTime(new Date('2026-05-19T12:00:00Z'));
        deck.recordReview(DIFFICULTY.APRENDIDO);
        expect(deck.studyStats.streak).toBe(3);
        expect(deck.studyStats.bestStreak).toBe(3);

        vi.setSystemTime(new Date('2026-06-01T12:00:00Z'));
        deck.recordReview(DIFFICULTY.APRENDIDO);
        expect(deck.studyStats.streak).toBe(1);
        expect(deck.studyStats.bestStreak).toBe(3);
      });
    });

    it('does not increment streak when reviewing twice on the same day', () => {
      deck.recordReview(DIFFICULTY.APRENDIDO);
      deck.recordReview(DIFFICULTY.APRENDIDO);
      expect(deck.studyStats.streak).toBe(1);
    });

    it('trims studyHistory to last 90 days', () => {
      for (let i = 0; i < 100; i++) {
        vi.setSystemTime(new Date(2026, 0, 1 + i));
        deck.recordReview(DIFFICULTY.APRENDIDO);
      }
      vi.setSystemTime(new Date(2026, 3, 15));
      deck.recordReview(DIFFICULTY.APRENDIDO);
      expect(deck.studyStats.studyHistory.length).toBeLessThanOrEqual(90);
    });
  });

  describe('reset', () => {
    it('resets all cards to new state', () => {
      const c1 = deck.addCard('F1', 'B1');
      c1.review(DIFFICULTY.APRENDIDO);
      deck.recordReview(DIFFICULTY.APRENDIDO);
      deck.reset();

      expect(c1.status).toBe('new');
      expect(c1.interval).toBe(0);
      expect(c1.repetitions).toBe(0);
      expect(c1.easinessFactor).toBe(2.5);
      expect(c1.lastReviewed).toBeNull();
    });

    it('resets study stats but preserves bestStreak', () => {
      deck.studyStats.bestStreak = 5;
      deck.studyStats.totalReviews = 100;
      deck.reset();

      expect(deck.studyStats.totalReviews).toBe(0);
      expect(deck.studyStats.bestStreak).toBe(5);
      expect(deck.studyStats.studyHistory).toEqual([]);
    });
  });

  describe('toJSON / fromJSON — serialization roundtrip', () => {
    it('serializes and deserializes a deck with cards', () => {
      deck.description = 'A test deck';
      deck.subject = 'Testing';
      const c1 = deck.addCard('F1', 'B1', ['tag'], '/img.png');
      c1.review(DIFFICULTY.APRENDIDO);
      deck.recordReview(DIFFICULTY.APRENDIDO);

      const json = deck.toJSON();
      const restored = Deck.fromJSON(json);

      expect(restored.name).toBe(deck.name);
      expect(restored.id).toBe(deck.id);
      expect(restored.description).toBe('A test deck');
      expect(restored.subject).toBe('Testing');
      expect(restored.cards).toHaveLength(1);
      expect(restored.cards[0].front).toBe('F1');
      expect(restored.cards[0].status).toBe('aprendido');
      expect(restored.cards[0].easinessFactor).toBe(2.6);
      expect(restored.studyStats.totalReviews).toBe(1);
      expect(restored.studyStats.studyHistory).toHaveLength(1);
    });

    it('restored cards are Card instances', () => {
      deck.addCard('F', 'B');
      const json = deck.toJSON();
      const restored = Deck.fromJSON(json);
      expect(restored.cards[0]).toBeInstanceOf(Card);
    });

    it('restored deck is a Deck instance', () => {
      const json = deck.toJSON();
      const restored = Deck.fromJSON(json);
      expect(restored).toBeInstanceOf(Deck);
    });
  });
});
