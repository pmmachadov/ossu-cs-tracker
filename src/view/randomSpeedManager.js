// randomSpeedManager.js
// Controlador de velocidades aleatorias continuas e impredecibles para los bordes Google.
// Modifica periódicamente variables CSS (--rnd-dur-*) para que ningún elemento tenga
// una velocidad constante ni cambios predecibles o sincronizados.

const SPEED_VARS = [
  { name: "--rnd-dur-mazos", min: 4.0, max: 11.5 },
  { name: "--rnd-dur-aprendidas", min: 3.2, max: 10.0 },
  { name: "--rnd-dur-bar", min: 3.6, max: 10.5 },
  { name: "--rnd-dur-btn", min: 2.8, max: 9.2 },
  { name: "--rnd-dur-folder-1", min: 6.4, max: 14.5 },
  { name: "--rnd-dur-folder-2", min: 5.2, max: 13.0 },
  { name: "--rnd-dur-folder-3", min: 5.6, max: 12.5 },
  { name: "--rnd-dur-folder-4", min: 4.4, max: 11.2 },
  { name: "--rnd-dur-folder-5", min: 6.0, max: 13.8 },
  { name: "--rnd-dur-folder-6", min: 4.8, max: 11.6 },
  { name: "--rnd-dur-icon", min: 2.8, max: 7.8 },
  { name: "--rnd-dur-badge", min: 2.6, max: 7.0 },
  { name: "--rnd-dur-card-1", min: 7.0, max: 14.8 },
  { name: "--rnd-dur-card-2", min: 8.0, max: 16.4 },
  { name: "--rnd-dur-card-3", min: 5.8, max: 13.6 },
  { name: "--rnd-dur-mc-1", min: 4.2, max: 10.4 },
  { name: "--rnd-dur-mc-2", min: 3.4, max: 9.2 },
  { name: "--rnd-dur-mc-3", min: 4.8, max: 11.8 },
  { name: "--rnd-dur-mc-4", min: 3.6, max: 8.8 },
  { name: "--rnd-dur-stat-total", min: 3.6, max: 10.8 },
  { name: "--rnd-dur-stat-new", min: 3.0, max: 9.6 },
  { name: "--rnd-dur-stat-learned", min: 4.0, max: 11.5 },
  { name: "--rnd-dur-stat-pct", min: 3.2, max: 10.0 },
  { name: "--rnd-dur-bar-unfilled", min: 3.6, max: 10.5 },
];

let isRunning = false;
let timers = [];

export function startRandomSpeedManager() {
  if (isRunning) return;
  isRunning = true;

  const root = document.documentElement;

  // Asigna valores iniciales aleatorios
  SPEED_VARS.forEach(({ name, min, max }) => {
    const val = (Math.random() * (max - min) + min).toFixed(2);
    root.style.setProperty(name, `${val}s`);
  });

  // Cada variable se actualiza independientemente a intervalos desincronizados y aleatorios
  SPEED_VARS.forEach(({ name, min, max }) => {
    const scheduleNext = () => {
      const nextDelay = Math.floor(Math.random() * 2500 + 1200); // 1.2s - 3.7s
      const timer = setTimeout(() => {
        const val = (Math.random() * (max - min) + min).toFixed(2);
        root.style.setProperty(name, `${val}s`);
        scheduleNext();
      }, nextDelay);
      timers.push(timer);
    };
    scheduleNext();
  });
}

export function stopRandomSpeedManager() {
  timers.forEach((t) => clearTimeout(t));
  timers = [];
  isRunning = false;
}
