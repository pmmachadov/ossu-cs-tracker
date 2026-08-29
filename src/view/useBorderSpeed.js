import { useCallback, useEffect, useRef } from "react";

// Velocidad lineal de los colores a lo largo del borde (px por segundo).
// Con velocidad lineal constante, un borde largo tarda más en recorrerlo.
const DEFAULT_SPEED = 65;

// Perímetro aproximado de un rectángulo redondeado en "pastilla" (radio = h/2).
function borderPerimeter(w, h) {
  const r = h / 2;
  return 2 * (w - 2 * r) + 2 * Math.PI * r;
}

/**
 * Devuelve una función que genera callback refs. Cada ref mide el ancho/alto
 * real del elemento y fija `--rotate-duration` proporcional al perímetro del
 * borde, para que los colores Google tarden más en recorrer bordes largos.
 *
 * Uso:
 *   const borderSpeed = useBorderSpeed();
 *   <div ref={borderSpeed("bar")}>...</div>
 *   <button ref={borderSpeed("btn")}>...</button>
 */
export function useBorderSpeed(speed = DEFAULT_SPEED) {
  const observers = useRef(new Map());

  const borderSpeed = useCallback(
    (key) => (el) => {
      const prev = observers.current.get(key);
      if (prev) {
        prev.disconnect();
        observers.current.delete(key);
      }
      if (!el) return;

      const apply = () => {
        const w = el.offsetWidth || 1;
        const h = el.offsetHeight || 1;
        const duration = borderPerimeter(w, h) / speed;
        el.style.setProperty("--rotate-duration", `${duration.toFixed(2)}s`);
      };

      apply();
      const ro = new ResizeObserver(apply);
      ro.observe(el);
      observers.current.set(key, ro);
    },
    [speed],
  );

  useEffect(() => {
    const map = observers.current;
    return () => {
      map.forEach((ro) => ro.disconnect());
      map.clear();
    };
  }, []);

  return borderSpeed;
}
