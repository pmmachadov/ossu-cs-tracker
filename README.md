# <div align="center">🧠 AnkiCards</div>

<div align="center">
  <strong>Spaced-repetition flashcard app for vocational and university students</strong>
</div>

<div align="center">
  <br>
  <img src="https://img.shields.io/badge/React-19.2-61DAFB?logo=react&logoColor=white&style=for-the-badge" alt="React">
  <img src="https://img.shields.io/badge/Vite-8.0-646CFF?logo=vite&logoColor=white&style=for-the-badge" alt="Vite">
  <img src="https://img.shields.io/badge/Recharts-3.8-22B5BF?logo=chart.js&logoColor=white&style=for-the-badge" alt="Recharts">
  <img src="https://img.shields.io/badge/License-MIT-green?style=for-the-badge" alt="License">
</div>

<br>

<div align="center">
  <img src="https://raw.githubusercontent.com/catppuccin/catppuccin/main/assets/misc/transparent.png" height="30" width="0px"/>
</div>

## ✨ Features

| Feature | Description |
|---------|-------------|
| 🎴 **Interactive flashcards** | 3D flip, smooth navigation, and a dark theme optimized for long study sessions |
| 🧮 **Adapted SM-2 algorithm** | Smart spaced repetition that optimizes when to review each card |
| ⌨️ **Keyboard shortcuts** | Study without touching your mouse: Space to flip, 1-4 to rate |
| 📊 **Visual statistics** | Progress charts, difficulty distribution, and mastery evolution |
| 📝 **Card editor** | Create, edit, and delete cards inside any deck |
| 🗂️ **Main decks + Extras** | Two core subjects always visible; the rest tucked inside a collapsible panel |
| 💾 **Local persistence** | All data is saved to localStorage; works without a server |
| 📱 **Responsive** | Optimized for mobile, tablet, and desktop |

<br>

## 🚀 Live demo

> Deploy your own instance on **Vercel** with one click:
>
> [![Deploy with Vercel](https://vercel.com/button)](https://vercel.com/new/clone?repository-url=https://github.com/your-username/anki-cards)

<br>

## 📸 Preview

```
┌─────────────────────────────────────────────────────────────┐
│  🧠 AnkiCards                                    [⛶]       │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│   ┌─────────┐  ┌──────────┐  ┌──────────┐                  │
│   │ 3 Decks │  │ 818 Cards│  │  0% Prog │                  │
│   └─────────┘  └──────────┘  └──────────┘                  │
│                                                             │
│   My Decks                                  [+ New Deck]   │
│   ─────────────────────────────────────────────────────    │
│                                                             │
│   ┌─────────────────────┐  ┌─────────────────────┐        │
│   │ 💻 Computer Systems │  │ 🔧 Dev Environments │        │
│   │                     │  │                     │        │
│   │ Progress 0%         │  │ Progress 0%         │        │
│   │ ████░░░░░░░░░░░     │  │ ████░░░░░░░░░░░     │        │
│   │                     │  │                     │        │
│   │ 510 new             │  │ 308 new             │        │
│   │ 0 learning          │  │ 0 learning          │        │
│   │ 510 review          │  │ 0 review            │        │
│   │                     │  │                     │        │
│   │ [📖 Study]          │  │ [📖 Study]          │        │
│   └─────────────────────┘  └─────────────────────┘        │
│                                                             │
│   [📂 Extras ▼]  —  8 additional decks                      │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

<br>

## 🛠️ Tech stack

```
Frontend     React 19 + Hooks
Build        Vite 8
Charts       Recharts
Styling      Plain CSS with variables (dark theme)
Storage      localStorage
Linting      ESLint 9 + react-hooks + react-refresh
```

<br>

## 📦 Local setup

```bash
# 1. Clone the repository
git clone https://github.com/your-username/anki-cards.git
cd anki-cards

# 2. Install dependencies
npm install

# 3. Start the dev server
npm run dev

# 4. Open in your browser
# http://localhost:5173
```

### Production build

```bash
npm run build
```

Output is generated in the `dist/` folder, ready to deploy on Vercel, Netlify, GitHub Pages, or any static CDN.

<br>

## ⌨️ Keyboard shortcuts (study mode)

| Key | Action |
|-----|--------|
| `Space` | Flip card |
| `1` | Again |
| `2` | Hard |
| `3` | Good |
| `4` | Easy |

<br>

## 📁 Project structure

```
anki-cards/
├── public/
│   └── data/               # Preloaded JSON decks
│       ├── sistemas-informaticos.json
│       ├── entornos-desarrollo.json
│       └── interconexion-redes-eac3.json
├── src/
│   ├── model/              # Business logic
│   │   ├── Deck.js         # Card/Deck classes + SM-2 algorithm
│   │   └── DataStore.js    # localStorage persistence
│   ├── view/               # React components
│   │   ├── DeckList.jsx    # Dashboard with deck grid
│   │   ├── StudyView.jsx   # Study session
│   │   ├── StatsView.jsx   # Charts and statistics
│   │   └── CardEditor.jsx  # Card CRUD
│   ├── App.jsx             # Root component / router
│   └── main.jsx            # Entry point
├── scripts/
│   └── fix-css-vars.js     # Post-build CSS inlining
├── index.html
├── vite.config.js
└── package.json
```

<br>

## 🧠 Adapted SM-2 algorithm

The spaced-repetition system implements an adapted version of the SM-2 algorithm:

| Difficulty | Ease factor change | Base interval |
|------------|--------------------|---------------|
| 🔴 Again   | −0.20              | 1 day         |
| 🟠 Hard    | −0.15              | 2 days        |
| 🟢 Good    | No change          | 3 days        |
| 🔵 Easy    | +0.15              | 4 days        |

New cards progress through the states: `new → learning → review`.

<br>

## 📝 Adding new subjects

1. Create a JSON file at `public/data/my-subject.json` following this schema:

```json
{
  "id": "my-subject",
  "name": "My Subject",
  "description": "Short description",
  "subject": "Category",
  "cards": [
    {
      "id": "uuid",
      "front": "Question",
      "back": "Answer",
      "tags": ["tag1"],
      "difficulty": "medium"
    }
  ]
}
```

2. Register it in `src/App.jsx` inside the `deckFiles` array.

3. Reload the application.

<br>

## 🤝 Contributing

Contributions are welcome. If you find a bug or want to propose an improvement:

1. Open an **issue** describing the problem or idea
2. **Fork** the repository
3. Create a branch for your feature: `git checkout -b feat/new-feature`
4. Submit a **pull request**

<br>

## 📄 License

Distributed under the **MIT** license. See `LICENSE` for more information.

<br>


