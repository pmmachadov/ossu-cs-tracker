// Diagnóstico: renderiza cada tarjeta del mazo a través de CardContent
// (misma ruta que StudyView) para localizar qué tarjeta provoca un crash.
import { describe, it, expect } from "vitest";
import { createElement as h } from "react";
import { act } from "react";
import { renderToString } from "react-dom/server";
import { createRoot } from "react-dom/client";
import fs from "node:fs";
import path from "node:path";
import { fileURLToPath } from "node:url";
import { CardContent, codeTheme } from "../view/CardContent";

const __dirname = path.dirname(fileURLToPath(import.meta.url));
const deckPath = path.resolve(
  __dirname,
  "../../public/data/examenes/examen-java.json",
);
const deck = JSON.parse(fs.readFileSync(deckPath, "utf8"));

describe("render de todas las tarjetas", () => {
  it("no lanza excepción en ninguna tarjeta", () => {
    const failures = [];
    for (const card of deck.cards) {
      try {
        renderToString(
          h(CardContent, {
            text: card.front,
            cardImageUrl: card.imageUrl,
            codeTheme,
          }),
        );
      } catch (e) {
        failures.push({ id: card.id, side: "front", error: String(e) });
      }
      try {
        renderToString(
          h(CardContent, {
            text: card.back,
            cardImageUrl: card.imageUrl,
            codeTheme,
          }),
        );
      } catch (e) {
        failures.push({ id: card.id, side: "back", error: String(e) });
      }
      // Análisis de opciones (mismo código que StudyView)
      try {
        // No se exporta analyzeAnswerOptions; se cubre indirectamente vía CardContent
        // y el propio render del front.
      } catch (e) {
        failures.push({ id: card.id, side: "analyze", error: String(e) });
      }
    }
    if (failures.length > 0) {
      console.error("TARJETAS QUE CRASHEAN:", failures);
    }
    expect(failures).toEqual([]);
  });

  it("las líneas con ✅, ❌ o 'error' generan checkbox (regresión renderer)", () => {
    const card = deck.cards.find((c) => c.id === "ex-java-02-11");
    expect(card).toBeTruthy();
    const html = renderToString(
      h(CardContent, { text: card.back, cardImageUrl: card.imageUrl, codeTheme }),
    );
    // Líneas marcadas de TODOS los bloques de código del dorso
    const blocks = [...card.back.matchAll(/```(\w*)\n([\s\S]*?)```/g)];
    const markLines = blocks.reduce(
      (acc, m) =>
        acc +
        m[2]
          .split("\n")
          .filter(
            (l) =>
              l.includes("✅") || l.includes("❌") || /\berror\b/i.test(l),
          ).length,
      0,
    );
    expect(markLines).toBeGreaterThan(0);
    const checkCount = (html.match(/code-line-check/g) || []).length;
    const checkboxCount = (html.match(/type="checkbox"/g) || []).length;
    expect(checkCount).toBe(markLines);
    expect(checkboxCount).toBe(checkCount);
  });

  it("el click en el checkbox no se propaga (no voltea la tarjeta)", async () => {
    const card = deck.cards.find((c) => c.id === "ex-java-02-11");
    expect(card).toBeTruthy();
    const container = document.createElement("div");
    document.body.appendChild(container);
    const spy = vi.fn();
    // Simula la tarjeta: el onClick del contenedor es el que voltearía (handleFlip)
    const root = createRoot(container);
    await act(async () => {
      root.render(
        h(
          "div",
          { onClick: spy },
          h(CardContent, {
            text: card.back,
            cardImageUrl: card.imageUrl,
            codeTheme,
          }),
        ),
      );
    });
    const label = container.querySelector(".code-check");
    expect(label).toBeTruthy();
    await act(async () => {
      label.dispatchEvent(new MouseEvent("click", { bubbles: true }));
    });
    expect(spy).not.toHaveBeenCalled();
    await act(async () => root.unmount());
    container.remove();
  });
});
