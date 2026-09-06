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

  it("las líneas con ✅ o ❌ reciben las clases code-line-error y code-line-success", () => {
    const card = deck.cards.find((c) => c.id === "ex-java-02-11");
    expect(card).toBeTruthy();
    const html = renderToString(
      h(CardContent, { text: card.back, cardImageUrl: card.imageUrl, codeTheme }),
    );
    expect(html).toContain("code-line-error");
    expect(html).toContain("code-line-success");
  });

  it("la tarjeta ex-java-04-13 incluye la imagen del diagrama de clases en su respuesta", () => {
    const card = deck.cards.find((c) => c.id === "ex-java-04-13");
    expect(card).toBeTruthy();
    const html = renderToString(
      h(CardContent, { text: card.back, cardImageUrl: card.imageUrl, codeTheme }),
    );
    expect(html).toContain('src="/images/jerarquia-empleados.png"');
    expect(html).toContain('alt="Diagrama UML - Jerarquía Empleado, Directivo y Técnico"');
  });

  it("la tarjeta ex-java-04-14 incluye la imagen del diagrama de interfaces en su respuesta", () => {
    const card = deck.cards.find((c) => c.id === "ex-java-04-14");
    expect(card).toBeTruthy();
    const html = renderToString(
      h(CardContent, { text: card.back, cardImageUrl: card.imageUrl, codeTheme }),
    );
    expect(html).toContain('src="/images/jerarquia-movible.png"');
    expect(html).toContain('alt="Diagrama UML - Jerarquía Movible, Sonoro, Robot y Coche"');
  });

  it("la tarjeta ex-java-04-15 incluye la imagen del diagrama de clases en su respuesta", () => {
    const card = deck.cards.find((c) => c.id === "ex-java-04-15");
    expect(card).toBeTruthy();
    const html = renderToString(
      h(CardContent, { text: card.back, cardImageUrl: card.imageUrl, codeTheme }),
    );
    expect(html).toContain('src="/images/instrumento.png"');
    expect(html).toContain('alt="Diagrama UML - Jerarquía Instrumento, Piano, Guitarra y Batería"');
  });
});



