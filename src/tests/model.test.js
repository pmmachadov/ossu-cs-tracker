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

  describe('review — AGAIN', () => {
    beforeEach(() => {
      card.repetitions = 3;
      card.easinessFactor = 2.5;
      card.interval = 10;
      card.review(DIFFICULTY.AGAIN);
    });

    it('resets repetitions to 0', () => {
      expect(card.repetitions).toBe(0);
    });

    it('decreases easiness factor by 0.2', () => {
      expect(card.easinessFactor).toBe(2.3);
    });

    it('clamps easiness factor to minimum of 1.3', () => {
      card.easinessFactor = 1.3;
      card.review(DIFFICULTY.AGAIN);
      expect(card.easinessFactor).toBe(1.3);
    });

    it('sets interval to 1 day (AGAIN factor)', () => {
      expect(card.interval).toBe(1);
    });

    it('sets status to relearning', () => {
      expect(card.status).toBe('relearning');
    });

    it('sets nextReview to now + 1 day', () => {
      const expected = Date.now() + 1 * 24 * 60 * 60 * 1000;
      expect(card.nextReview).toBe(expected);
    });

    it('sets lastReviewed', () => {
      expect(card.lastReviewed).toBe(Date.now());
    });
  });

  describe('review — GOOD (first repetition)', () => {
    beforeEach(() => {
      card.review(DIFFICULTY.GOOD);
    });

    it('increments repetitions to 1', () => {
      expect(card.repetitions).toBe(1);
    });

    it('keeps easiness factor unchanged', () => {
      expect(card.easinessFactor).toBe(2.5);
    });

    it('sets interval to 3 days (GOOD factor)', () => {
      expect(card.interval).toBe(3);
    });

    it('sets status to learning', () => {
      expect(card.status).toBe('learning');
    });
  });

  describe('review — GOOD (second repetition)', () => {
    beforeEach(() => {
      card.repetitions = 1;
      card.review(DIFFICULTY.GOOD);
    });

    it('increments repetitions to 2', () => {
      expect(card.repetitions).toBe(2);
    });

    it('sets interval to 6 days (GOOD factor * 2)', () => {
      expect(card.interval).toBe(6);
    });

    it('sets status to review', () => {
      expect(card.status).toBe('review');
    });
  });

  describe('review — GOOD (third+ repetition)', () => {
    beforeEach(() => {
      card.repetitions = 2;
      card.interval = 6;
      card.easinessFactor = 2.5;
      card.review(DIFFICULTY.GOOD);
    });

    it('increments repetitions to 3', () => {
      expect(card.repetitions).toBe(3);
    });

    it('multiplies interval by easiness factor (6 * 2.5 = 15)', () => {
      expect(card.interval).toBe(15);
    });

    it('sets status to review', () => {
      expect(card.status).toBe('review');
    });
  });

  describe('review — HARD', () => {
    it('decreases easiness factor by 0.15', () => {
      card.easinessFactor = 2.5;
      card.review(DIFFICULTY.HARD);
      expect(card.easinessFactor).toBe(2.35);
    });

    it('does not set EF below 1.3', () => {
      card.easinessFactor = 1.3;
      card.review(DIFFICULTY.HARD);
      expect(card.easinessFactor).toBe(1.3);
    });
  });

  describe('review — EASY', () => {
    it('increases easiness factor by 0.15', () => {
      card.easinessFactor = 2.5;
      card.review(DIFFICULTY.EASY);
      expect(card.easinessFactor).toBe(2.65);
    });
  });

  describe('review — returns correct result object', () => {
    it('returns interval, nextReview, and status', () => {
      const result = card.review(DIFFICULTY.GOOD);
      expect(result).toHaveProperty('interval');
      expect(result).toHaveProperty('nextReview');
      expect(result).toHaveProperty('status');
      expect(result.status).toBe('learning');
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
        again: 0,
        hard: 0,
        good: 0,
        easy: 0,
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
      c2.status = 'learning';
      const newCards = deck.getNewCards();
      expect(newCards).toHaveLength(1);
      expect(newCards[0].id).toBe(c1.id);
    });
  });

  describe('getLearningCards', () => {
    it('returns cards with status "learning" or "relearning"', () => {
      const c1 = deck.addCard('F1', 'B1');
      const c2 = deck.addCard('F2', 'B2');
      c1.status = 'learning';
      c2.status = 'relearning';
      const learning = deck.getLearningCards();
      expect(learning).toHaveLength(2);
    });
  });

  describe('getStats', () => {
    it('returns correct counts for all categories', () => {
      const c1 = deck.addCard('F1', 'B1');
      const c2 = deck.addCard('F2', 'B2');
      const c3 = deck.addCard('F3', 'B3');
      c1.status = 'new';
      c1.nextReview = Date.now() + 86400000; // not due
      c2.status = 'learning';
      c2.nextReview = Date.now() + 86400000; // not due
      c3.status = 'review';
      c3.nextReview = Date.now() - 1000; // due

      const stats = deck.getStats();
      expect(stats.total).toBe(3);
      expect(stats.new).toBe(1);
      expect(stats.learning).toBe(1);
      expect(stats.due).toBe(1);
      expect(stats.reviewed).toBe(1);
    });

    it('calculates mastery as percentage of reviewed cards', () => {
      deck.addCard('F1', 'B1');
      const c2 = deck.addCard('F2', 'B2');
      c2.status = 'review';
      expect(deck.getStats().mastery).toBe(50);
    });

    it('returns 0 mastery when no cards', () => {
      expect(deck.getStats().mastery).toBe(0);
    });
  });

  describe('recordReview', () => {
    it('increments totalReviews', () => {
      deck.recordReview(DIFFICULTY.GOOD);
      expect(deck.studyStats.totalReviews).toBe(1);
    });

    it('increments the specific difficulty counter', () => {
      deck.recordReview(DIFFICULTY.AGAIN);
      deck.recordReview(DIFFICULTY.GOOD);
      deck.recordReview(DIFFICULTY.EASY);
      expect(deck.studyStats.again).toBe(1);
      expect(deck.studyStats.good).toBe(1);
      expect(deck.studyStats.easy).toBe(1);
      expect(deck.studyStats.hard).toBe(0);
    });

    it('adds entry to studyHistory', () => {
      deck.recordReview(DIFFICULTY.GOOD);
      expect(deck.studyStats.studyHistory).toHaveLength(1);
      expect(deck.studyStats.studyHistory[0].difficulty).toBe('good');
      expect(deck.studyStats.studyHistory[0].date).toBe(Date.now());
    });

    it('sets lastStudied', () => {
      deck.recordReview(DIFFICULTY.GOOD);
      expect(deck.lastStudied).toBe(Date.now());
    });

    describe('streak tracking', () => {
      it('starts streak at 1 on first review', () => {
        deck.recordReview(DIFFICULTY.GOOD);
        expect(deck.studyStats.streak).toBe(1);
      });

      it('increments streak when reviewing on consecutive days', () => {
        // Day 1
        deck.recordReview(DIFFICULTY.GOOD);
        expect(deck.studyStats.streak).toBe(1);

        // Day 2 — advance 1 day
        vi.setSystemTime(new Date('2026-05-18T12:00:00Z'));
        deck.recordReview(DIFFICULTY.GOOD);
        expect(deck.studyStats.streak).toBe(2);
      });

      it('resets streak to 1 when a day is skipped', () => {
        deck.recordReview(DIFFICULTY.GOOD);
        // Skip 2 days
        vi.setSystemTime(new Date('2026-05-20T12:00:00Z'));
        deck.recordReview(DIFFICULTY.GOOD);
        expect(deck.studyStats.streak).toBe(1);
      });

      it('updates bestStreak', () => {
        // Streak of 3
        deck.recordReview(DIFFICULTY.GOOD);
        vi.setSystemTime(new Date('2026-05-18T12:00:00Z'));
        deck.recordReview(DIFFICULTY.GOOD);
        vi.setSystemTime(new Date('2026-05-19T12:00:00Z'));
        deck.recordReview(DIFFICULTY.GOOD);
        expect(deck.studyStats.streak).toBe(3);
        expect(deck.studyStats.bestStreak).toBe(3);

        // Reset and get a smaller streak
        vi.setSystemTime(new Date('2026-06-01T12:00:00Z'));
        deck.recordReview(DIFFICULTY.GOOD);
        expect(deck.studyStats.streak).toBe(1);
        expect(deck.studyStats.bestStreak).toBe(3);
      });
    });

    it('does not increment streak when reviewing twice on the same day', () => {
      deck.recordReview(DIFFICULTY.GOOD);
      deck.recordReview(DIFFICULTY.GOOD);
      // Still same fake time
      expect(deck.studyStats.streak).toBe(1);
    });

    it('trims studyHistory to last 90 days', () => {
      // Add entries spanning more than 90 days
      for (let i = 0; i < 100; i++) {
        vi.setSystemTime(new Date(2026, 0, 1 + i)); // Jan 1 → Apr 11
        deck.recordReview(DIFFICULTY.GOOD);
      }
      // Advance time past 90 days from the first entry
      vi.setSystemTime(new Date(2026, 3, 15)); // April 15 — 104 days after Jan 1
      // Trigger the trim by recording one more review (the filter runs on push)
      deck.recordReview(DIFFICULTY.GOOD);
      // Entries older than 90 days should be trimmed
      expect(deck.studyStats.studyHistory.length).toBeLessThanOrEqual(90);
    });
  });

  describe('reset', () => {
    it('resets all cards to new state', () => {
      const c1 = deck.addCard('F1', 'B1');
      c1.review(DIFFICULTY.GOOD);
      deck.recordReview(DIFFICULTY.GOOD);
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
      c1.review(DIFFICULTY.GOOD);
      deck.recordReview(DIFFICULTY.GOOD);

      const json = deck.toJSON();
      const restored = Deck.fromJSON(json);

      expect(restored.name).toBe(deck.name);
      expect(restored.id).toBe(deck.id);
      expect(restored.description).toBe('A test deck');
      expect(restored.subject).toBe('Testing');
      expect(restored.cards).toHaveLength(1);
      expect(restored.cards[0].front).toBe('F1');
      expect(restored.cards[0].status).toBe('learning');
      expect(restored.cards[0].easinessFactor).toBe(2.5);
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
