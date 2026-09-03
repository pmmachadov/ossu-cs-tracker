// randomSpeedManager.js
// Controlador de cambio de velocidad gradual y progresivo ("de a poco") para los bordes Google.
// Las velocidades se desplazan de forma suave y continua sin saltos bruscos ni cambios repentinos.

const SPEED_VARS = [
  { name: "--rnd-dur-mazos", min: 4.5, max: 10.5 },
  { name: "--rnd-dur-aprendidas", min: 4.0, max: 9.5 },
  { name: "--rnd-dur-bar", min: 4.0, max: 10.0 },
  { name: "--rnd-dur-btn", min: 3.5, max: 8.5 },
  { name: "--rnd-dur-folder-1", min: 6.5, max: 13.5 },
  { name: "--rnd-dur-folder-2", min: 5.5, max: 12.5 },
  { name: "--rnd-dur-folder-3", min: 5.8, max: 12.0 },
  { name: "--rnd-dur-folder-4", min: 5.0, max: 11.0 },
  { name: "--rnd-dur-folder-5", min: 6.2, max: 13.0 },
  { name: "--rnd-dur-folder-6", min: 5.2, max: 11.5 },
  { name: "--rnd-dur-icon", min: 3.5, max: 7.5 },
  { name: "--rnd-dur-badge", min: 3.2, max: 6.8 },
  { name: "--rnd-dur-card-1", min: 7.5, max: 14.0 },
  { name: "--rnd-dur-card-2", min: 8.5, max: 15.5 },
  { name: "--rnd-dur-card-3", min: 6.5, max: 13.0 },
  { name: "--rnd-dur-mc-1", min: 4.8, max: 10.0 },
  { name: "--rnd-dur-mc-2", min: 4.0, max: 9.0 },
  { name: "--rnd-dur-mc-3", min: 5.0, max: 11.0 },
  { name: "--rnd-dur-mc-4", min: 4.2, max: 8.8 },
  { name: "--rnd-dur-stat-total", min: 4.2, max: 10.2 },
  { name: "--rnd-dur-stat-new", min: 3.8, max: 9.2 },
  { name: "--rnd-dur-stat-learned", min: 4.5, max: 11.0 },
  { name: "--rnd-dur-stat-pct", min: 3.8, max: 9.5 },
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

  // Ticker de transición gradual: cada 400ms avanza una fracción mínima (~0.05s)
  intervalId = setInterval(() => {
    state.forEach((item) => {
      // Si está muy cerca del objetivo, asigna un nuevo destino suave
      if (Math.abs(item.target - item.current) < 0.3) {
        item.target = Math.random() * (item.max - item.min) + item.min;
      }

      // Desplazamiento progresivo ("de a poco")
      const direction = item.target > item.current ? 1 : -1;
      const step = direction * (Math.random() * 0.04 + 0.03); // Paso suave de ~0.05s
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
