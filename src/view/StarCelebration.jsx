/**
 * StarCelebration: Lluvia de estrellas ultra-fluida (60/120 FPS) con colores Google puros
 * (Azul #4285F4, Rojo #EA4335, Amarillo #FBBC05, Verde #34A853).
 * Duración: 1.5 segundos. Sin color blanco.
 */

// Paleta oficial Google pura (sin blanco)
const GOOGLE_COLORS = [
  { fill: "#4285F4", glow: "#8AB4F8" }, // Azul Google
  { fill: "#EA4335", glow: "#F28B82" }, // Rojo Google
  { fill: "#FBBC05", glow: "#FDD663" }, // Amarillo Google
  { fill: "#34A853", glow: "#81C995" }, // Verde Google
];

// Caché de sprites pre-renderizados en memoria para 0 coste de GPU/CPU en tiempo real
let spritesCache = null;

const initSprites = (dpr) => {
  if (spritesCache) return spritesCache;

  const sprites = [];
  const sizes = [6 * dpr, 10 * dpr, 16 * dpr, 24 * dpr];

  GOOGLE_COLORS.forEach((color) => {
    sizes.forEach((size) => {
      // 1. Sprite: Estrella de 5 puntas con color Google puro
      const c1 = document.createElement("canvas");
      const pad = size * 0.8;
      c1.width = size * 2 + pad * 2;
      c1.height = size * 2 + pad * 2;
      const ctx1 = c1.getContext("2d");
      const cx = c1.width / 2;
      const cy = c1.height / 2;

      ctx1.shadowBlur = size * 0.7;
      ctx1.shadowColor = color.glow;
      ctx1.fillStyle = color.fill;

      ctx1.beginPath();
      const spikes = 5;
      const step = Math.PI / spikes;
      let rot = (Math.PI / 2) * 3;
      ctx1.moveTo(cx, cy - size);
      for (let i = 0; i < spikes; i++) {
        ctx1.lineTo(cx + Math.cos(rot) * size, cy + Math.sin(rot) * size);
        rot += step;
        ctx1.lineTo(cx + Math.cos(rot) * (size * 0.45), cy + Math.sin(rot) * (size * 0.45));
        rot += step;
      }
      ctx1.closePath();
      ctx1.fill();

      // 2. Sprite: Destello 4 puntas estilo Gemini / Sparkle con color Google puro
      const c2 = document.createElement("canvas");
      c2.width = c1.width;
      c2.height = c1.height;
      const ctx2 = c2.getContext("2d");

      ctx2.shadowBlur = size * 0.7;
      ctx2.shadowColor = color.glow;
      ctx2.fillStyle = color.fill;

      ctx2.save();
      ctx2.translate(cx, cy);
      ctx2.beginPath();
      const r = size * 1.1;
      const inner = size * 0.18;
      for (let i = 0; i < 4; i++) {
        ctx2.lineTo(0, -r);
        ctx2.quadraticCurveTo(inner, -inner, r, 0);
        ctx2.rotate(Math.PI / 2);
      }
      ctx2.closePath();
      ctx2.fill();
      ctx2.restore();

      sprites.push({ canvas: c1, halfW: c1.width / 2, halfH: c1.height / 2 });
      sprites.push({ canvas: c2, halfW: c2.width / 2, halfH: c2.height / 2 });
    });
  });

  spritesCache = sprites;
  return sprites;
};

export const triggerStarCelebration = () => {
  let canvas = document.getElementById("star-celebration-canvas");
  if (!canvas) {
    canvas = document.createElement("canvas");
    canvas.id = "star-celebration-canvas";
    canvas.style.position = "fixed";
    canvas.style.top = "0";
    canvas.style.left = "0";
    canvas.style.width = "100vw";
    canvas.style.height = "100vh";
    canvas.style.pointerEvents = "none";
    canvas.style.zIndex = "999999";
    document.body.appendChild(canvas);
  }

  const ctx = canvas.getContext("2d");
  const dpr = Math.min(window.devicePixelRatio || 1, 2);
  let width = (canvas.width = window.innerWidth * dpr);
  let height = (canvas.height = window.innerHeight * dpr);

  const sprites = initSprites(dpr);
  const particles = [];

  // Función para crear lluvia de estrellas desde la parte superior / pantalla
  const spawnStarShower = (count = 30, fromTop = true) => {
    for (let i = 0; i < count; i++) {
      const sprite = sprites[Math.floor(Math.random() * sprites.length)];
      const x = Math.random() * width;
      const y = fromTop ? -20 - Math.random() * 80 : Math.random() * height * 0.4;
      
      const speedY = (Math.random() * 6 + 7) * dpr;
      const speedX = (Math.random() * 4 - 2) * dpr;

      particles.push({
        x,
        y,
        vx: speedX,
        vy: speedY,
        sprite,
        alpha: 1,
        rotation: Math.random() * Math.PI * 2,
        rotationSpeed: (Math.random() - 0.5) * 0.15,
        decay: Math.random() * 0.02 + 0.015,
        scale: Math.random() * 0.6 + 0.5,
      });
    }
  };

  // Explosión inicial + lluvia de estrellas
  spawnStarShower(70, false);
  spawnStarShower(60, true);

  const startTime = Date.now();
  const duration = 1500; // 1.5 segundos
  let lastShowerTime = 0;
  let animFrameId = null;

  const animate = () => {
    const elapsed = Date.now() - startTime;

    if (elapsed < duration) {
      if (elapsed - lastShowerTime > 90) {
        lastShowerTime = elapsed;
        spawnStarShower(18, true);
      }
    }

    ctx.clearRect(0, 0, width, height);

    for (let i = particles.length - 1; i >= 0; i--) {
      const p = particles[i];
      p.x += p.vx;
      p.y += p.vy;
      p.rotation += p.rotationSpeed;
      p.alpha -= p.decay;

      if (p.alpha <= 0 || p.y > height + 50 || p.x < -50 || p.x > width + 50) {
        particles.splice(i, 1);
        continue;
      }

      ctx.save();
      ctx.globalAlpha = Math.max(0, p.alpha);
      ctx.translate(p.x, p.y);
      ctx.rotate(p.rotation);
      ctx.scale(p.scale, p.scale);
      ctx.drawImage(p.sprite.canvas, -p.sprite.halfW, -p.sprite.halfH);
      ctx.restore();
    }

    if (elapsed < duration || particles.length > 0) {
      animFrameId = requestAnimationFrame(animate);
    } else {
      ctx.clearRect(0, 0, width, height);
      if (canvas && canvas.parentNode) {
        canvas.parentNode.removeChild(canvas);
      }
    }
  };

  animFrameId = requestAnimationFrame(animate);

  const handleResize = () => {
    if (canvas) {
      width = canvas.width = window.innerWidth * dpr;
      height = canvas.height = window.innerHeight * dpr;
    }
  };
  window.addEventListener("resize", handleResize);

  setTimeout(() => {
    window.removeEventListener("resize", handleResize);
  }, duration + 800);
};

export default triggerStarCelebration;
