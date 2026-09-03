// randomSpeedManager.js
// Controlador de cambio de velocidad gradual, progresivo y pausado ("mucho más lento") para los bordes Google.
// Las velocidades se desplazan con gran suavidad en rangos lentos y majestuosos (10s a 45s).

const SPEED_VARS = [
  { name: "--rnd-dur-mazos", min: 13.0, max: 28.0 },
  { name: "--rnd-dur-aprendidas", min: 12.0, max: 26.0 },
  { name: "--rnd-dur-bar", min: 12.0, max: 27.0 },
  { name: "--rnd-dur-btn", min: 10.0, max: 22.0 },
  { name: "--rnd-dur-folder-1", min: 18.0, max: 38.0 },
  { name: "--rnd-dur-folder-2", min: 16.0, max: 34.0 },
  { name: "--rnd-dur-folder-3", min: 17.0, max: 35.0 },
  { name: "--rnd-dur-folder-4", min: 15.0, max: 32.0 },
  { name: "--rnd-dur-folder-5", min: 19.0, max: 39.0 },
  { name: "--rnd-dur-folder-6", min: 16.0, max: 33.0 },
  { name: "--rnd-dur-icon", min: 10.0, max: 20.0 },
  { name: "--rnd-dur-badge", min: 9.0, max: 18.0 },
  { name: "--rnd-dur-card-1", min: 20.0, max: 42.0 },
  { name: "--rnd-dur-card-2", min: 22.0, max: 45.0 },
  { name: "--rnd-dur-card-3", min: 18.0, max: 38.0 },
  { name: "--rnd-dur-mc-1", min: 14.0, max: 28.0 },
  { name: "--rnd-dur-mc-2", min: 12.0, max: 25.0 },
  { name: "--rnd-dur-mc-3", min: 15.0, max: 30.0 },
  { name: "--rnd-dur-mc-4", min: 13.0, max: 26.0 },
  { name: "--rnd-dur-stat-total", min: 12.0, max: 27.0 },
  { name: "--rnd-dur-stat-new", min: 11.0, max: 25.0 },
  { name: "--rnd-dur-stat-learned", min: 13.0, max: 28.0 },
  { name: "--rnd-dur-stat-pct", min: 11.0, max: 25.0 },
];

let isRunning = false;
let intervalId = null;
let state = [];

export function startRandomSpeedManager() {
  if (isRunning) return;
  isRunning = true;

  const root = document.documentElement;

  // Inicializa el estado con valores y objetivos iniciales si no existen
  if (state.length === 0) {
    state = SPEED_VARS.map(({ name, min, max }) => {
      const current = Math.random() * (max - min) + min;
      const target = Math.random() * (max - min) + min;
      return { name, min, max, current, target };
    });
  }

  // Aplica los valores actuales inmediatamente
  state.forEach((item) => {
    root.style.setProperty(item.name, `${item.current.toFixed(2)}s`);
  });

  // Ticker de transición gradual: cada 400ms avanza una fracción mínima
  intervalId = setInterval(() => {
    state.forEach((item) => {
      // Si está muy cerca del objetivo, asigna un nuevo destino suave
      if (Math.abs(item.target - item.current) < 0.4) {
        item.target = Math.random() * (item.max - item.min) + item.min;
      }

      // Desplazamiento progresivo y calmado ("de a poco")
      const direction = item.target > item.current ? 1 : -1;
      const step = direction * (Math.random() * 0.05 + 0.03); // Paso suave de ~0.05s
      item.current = Math.min(Math.max(item.current + step, item.min), item.max);

      root.style.setProperty(item.name, `${item.current.toFixed(2)}s`);
    });
  }, 400);
}

export function stopRandomSpeedManager() {
  if (intervalId) {
    clearInterval(intervalId);
    intervalId = null;
  }
  isRunning = false;
}
