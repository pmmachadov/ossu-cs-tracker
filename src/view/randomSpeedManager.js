// randomSpeedManager.js
// Asigna velocidades orgánicas, variadas y estables proporcionales al tamaño de cada elemento.
// Los elementos grandes giran pausadamente (18s a 36s) y los botones pequeños giran con visibilidad fluida (6s a 9s).
// Al fijar valores estables por sesión, se evita el reajuste dinámico que provocaba saltos bruscos hacia atrás y adelante.

const SPEED_VARS = [
  { name: "--rnd-dur-mazos", min: 14.0, max: 22.0 },
  { name: "--rnd-dur-aprendidas", min: 13.0, max: 20.0 },
  { name: "--rnd-dur-bar", min: 15.0, max: 24.0 },
  { name: "--rnd-dur-btn", min: 6.5, max: 9.5 },
  { name: "--rnd-dur-folder-1", min: 18.0, max: 30.0 },
  { name: "--rnd-dur-folder-2", min: 16.0, max: 28.0 },
  { name: "--rnd-dur-folder-3", min: 17.0, max: 29.0 },
  { name: "--rnd-dur-folder-4", min: 15.0, max: 26.0 },
  { name: "--rnd-dur-folder-5", min: 19.0, max: 31.0 },
  { name: "--rnd-dur-folder-6", min: 16.0, max: 27.0 },
  { name: "--rnd-dur-icon", min: 6.0, max: 8.5 },
  { name: "--rnd-dur-badge", min: 6.5, max: 9.0 },
  { name: "--rnd-dur-card-1", min: 20.0, max: 34.0 },
  { name: "--rnd-dur-card-2", min: 22.0, max: 36.0 },
  { name: "--rnd-dur-card-3", min: 19.0, max: 32.0 },
  { name: "--rnd-dur-mc-1", min: 14.0, max: 22.0 },
  { name: "--rnd-dur-mc-2", min: 13.0, max: 21.0 },
  { name: "--rnd-dur-mc-3", min: 15.0, max: 24.0 },
  { name: "--rnd-dur-mc-4", min: 13.0, max: 22.0 },
  { name: "--rnd-dur-stat-total", min: 14.0, max: 22.0 },
  { name: "--rnd-dur-stat-new", min: 12.0, max: 20.0 },
  { name: "--rnd-dur-stat-learned", min: 15.0, max: 23.0 },
  { name: "--rnd-dur-stat-pct", min: 13.0, max: 21.0 },
];

let isInitialized = false;

export function startRandomSpeedManager() {
  if (isInitialized) return;
  isInitialized = true;

  const root = document.documentElement;

  // Asigna a cada elemento una velocidad orgánica única y constante para garantizar rotación 100% fluida sin saltos hacia atrás
  SPEED_VARS.forEach(({ name, min, max }) => {
    const duration = Math.random() * (max - min) + min;
    root.style.setProperty(name, `${duration.toFixed(2)}s`);
  });
}

export function stopRandomSpeedManager() {
  isInitialized = false;
}
