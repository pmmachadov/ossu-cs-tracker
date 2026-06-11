// Modelo: Deck - Gestiona las tarjetas y el algoritmo de repetición espaciada
import { NEW_CARDS_PER_SESSION } from "../config";

// Solo dos niveles: Procesando (0) y Aprendido (1)
export const DIFFICULTY = {
  PROCESANDO: 0,
  APRENDIDO: 1,
};

export { NEW_CARDS_PER_SESSION };

// Factores de intervalo base (en días)
const INTERVAL_FACTORS = {
  [DIFFICULTY.PROCESANDO]: 1,
  [DIFFICULTY.APRENDIDO]: 4,
};

export class Card {
  constructor(id, front, back, tags = [], imageUrl = '') {
    this.id = id;
    this.front = front;
    this.back = back;
    this.tags = tags;
    this.imageUrl = imageUrl;

    // Estado de repetición espaciada
    this.interval = 0;
    this.repetitions = 0;
    this.easinessFactor = 2.5;
    this.nextReview = Date.now();
    this.lastReviewed = null;
    this.status = "new"; // new | procesando | aprendido
  }

  review(difficulty) {
    this.lastReviewed = Date.now();

    if (difficulty === DIFFICULTY.PROCESANDO) {
      // No recordó bien → vuelve a "procesando"
      this.repetitions = 0;
      this.easinessFactor = Math.max(1.3, this.easinessFactor - 0.2);
      this.interval = INTERVAL_FACTORS[DIFFICULTY.PROCESANDO];
      this.status = "procesando";
    } else {
      // Aprendido
      this.repetitions++;
      this.easinessFactor = Math.max(1.3, this.easinessFactor + 0.1);

      if (this.repetitions === 1) {
        this.interval = INTERVAL_FACTORS[DIFFICULTY.APRENDIDO];
      } else if (this.repetitions === 2) {
        this.interval = INTERVAL_FACTORS[DIFFICULTY.APRENDIDO] * 2;
      } else {
        this.interval = Math.round(this.interval * this.easinessFactor);
      }

      this.status = "aprendido";
    }

    this.nextReview = Date.now() + this.interval * 24 * 60 * 60 * 1000;

    return {
      interval: this.interval,
      nextReview: this.nextReview,
      status: this.status,
    };
  }

  isDue() {
    return Date.now() >= this.nextReview;
  }

  getNextReviewText() {
    const now = Date.now();
    const diff = this.nextReview - now;

    if (diff <= 0) return "Ahora";

    const days = Math.ceil(diff / (24 * 60 * 60 * 1000));
    if (days === 1) return "1 día";
    return `${days} días`;
  }
}

export class Deck {
  constructor(name, id) {
    this.id = id || Date.now().toString();
    this.name = name;
    this.cards = [];
    this.created = Date.now();
    this.lastStudied = null;
    // Registro permanente de visualizaciones: { timestamp, cardId, status }
    // Nunca se borra, ni al resetear progreso
    this.viewLog = [];
    this.studyStats = {
      totalReviews: 0,
      procesando: 0,
      aprendido: 0,
      streak: 0,
      bestStreak: 0,
      studyHistory: [],
    };
  }

  addCard(front, back, tags = [], imageUrl = '', id = null) {
    const cardId = id || `${this.id}_${this.cards.length}`;
    const card = new Card(cardId, front, back, tags, imageUrl);
    this.cards.push(card);
    return card;
  }

  removeCard(cardId) {
    this.cards = this.cards.filter((c) => c.id !== cardId);
  }

  getDueCards() {
    return this.cards.filter((card) => card.isDue());
  }

  getNewCards() {
    return this.cards.filter((card) => card.status === "new");
  }

  getLearningCards() {
    return this.cards.filter(
      (card) => card.status === "procesando",
    );
  }

  getStats() {
    const newCards = this.getNewCards().length;
    const procesando = this.cards.filter((c) => c.status === "procesando").length;
    const due = this.getDueCards().length;
    const aprendido = this.cards.filter((c) => c.status === "aprendido").length;

    return {
      total: this.cards.length,
      new: newCards,
      procesando: procesando,
      due: due,
      aprendido: aprendido,
      mastery:
        this.cards.length > 0
          ? Math.round((aprendido / this.cards.length) * 100)
          : 0,
    };
  }

  recordReview(difficulty) {
    const today = new Date().toDateString();
    const lastDate = this.lastStudied
      ? new Date(this.lastStudied).toDateString()
      : null;
    const yesterday = new Date(Date.now() - 86400000).toDateString();

    // Update streak
    if (lastDate !== today) {
      if (lastDate === yesterday) {
        this.studyStats.streak++;
      } else if (lastDate !== today) {
        this.studyStats.streak = 1;
      }

      if (this.studyStats.streak > this.studyStats.bestStreak) {
        this.studyStats.bestStreak = this.studyStats.streak;
      }
    }

    // Update difficulty stats
    this.studyStats.totalReviews++;
    const key = Object.keys(DIFFICULTY)[difficulty].toLowerCase();
    if (this.studyStats[key] !== undefined) {
      this.studyStats[key]++;
    }

    // Add to history
    this.studyStats.studyHistory.push({
      date: Date.now(),
      difficulty: key,
    });

    // Keep only last 90 days
    const ninetyDaysAgo = Date.now() - 90 * 24 * 60 * 60 * 1000;
    this.studyStats.studyHistory = this.studyStats.studyHistory.filter(
      (h) => h.date > ninetyDaysAgo,
    );

    this.lastStudied = Date.now();
  }

  reset() {
    this.cards.forEach((card) => {
      card.interval = 0;
      card.repetitions = 0;
      card.easinessFactor = 2.5;
      card.nextReview = Date.now();
      card.lastReviewed = null;
      card.status = "new";
    });
    this.studyStats = {
      totalReviews: 0,
      procesando: 0,
      aprendido: 0,
      streak: 0,
      bestStreak: this.studyStats.bestStreak,
      studyHistory: [],
    };
    // viewLog se conserva intencionadamente — registro permanente
  }

  /** Registrar que una tarjeta fue vista en sesión de estudio */
  logCardView(cardId) {
    const card = this.cards.find(c => c.id === cardId);
    this.viewLog.push({
      timestamp: Date.now(),
      cardId: cardId,
      status: card ? card.status : "unknown",
      isReview: false,
    });
  }

  /** Registrar que una tarjeta fue evaluada (review) */
  logCardReview(cardId, difficulty) {
    const card = this.cards.find(c => c.id === cardId);
    this.viewLog.push({
      timestamp: Date.now(),
      cardId: cardId,
      status: card ? card.status : "unknown",
      isReview: true,
      difficulty: difficulty,
    });
  }

  toJSON() {
    return {
      id: this.id,
      name: this.name,
      description: this.description,
      subject: this.subject,
      cards: this.cards.map(c => ({
        id: c.id,
        front: c.front,
        back: c.back,
        tags: c.tags,
        imageUrl: c.imageUrl,
        interval: c.interval,
        repetitions: c.repetitions,
        easinessFactor: c.easinessFactor,
        nextReview: c.nextReview,
        lastReviewed: c.lastReviewed,
        status: c.status,
      })),
      created: this.created,
      lastStudied: this.lastStudied,
      viewLog: this.viewLog,
      studyStats: this.studyStats,
    };
  }

  static fromJSON(data) {
    const deck = new Deck(data.name, data.id);
    deck.description = data.description || "";
    deck.subject = data.subject || "";
    deck.created = data.created;
    deck.lastStudied = data.lastStudied;
    deck.studyStats = data.studyStats || {
      totalReviews: 0,
      procesando: 0,
      aprendido: 0,
      streak: 0,
      bestStreak: 0,
      studyHistory: [],
    };
    deck.viewLog = data.viewLog || [];
    deck.cards = data.cards.map((c) => {
      const card = new Card(c.id, c.front, c.back, c.tags, c.imageUrl || '');
      Object.assign(card, c);
      return card;
    });
    return deck;
  }
}
