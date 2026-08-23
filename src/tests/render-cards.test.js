// Diagnóstico: renderiza cada tarjeta del mazo a través de CardContent
// (misma ruta que StudyView) para localizar qué tarjeta provoca un crash.
import { describe, it, expect } from "vitest";
import { createElement as h } from "react";
import { renderToString } from "react-dom/server";
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

  it("las líneas con // ✅ generan checkbox (regresión renderer)", () => {
    const card = deck.cards.find((c) => c.id === "ex-java-02-11");
    expect(card).toBeTruthy();
    const html = renderToString(
      h(CardContent, { text: card.back, cardImageUrl: card.imageUrl, codeTheme }),
    );
    const checkCount = (html.match(/code-line-check/g) || []).length;
    const checkboxCount = (html.match(/type="checkbox"/g) || []).length;
    expect(checkCount).toBeGreaterThan(0);
    expect(checkboxCount).toBe(checkCount);
  });
});
