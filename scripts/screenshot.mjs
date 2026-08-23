// Herramienta de diagnóstico: captura de pantalla de una URL con Playwright.
// Uso:
//   node scripts/screenshot.mjs <url> [salida.png] [ancho] [alto]
// Ejemplo:
//   node scripts/screenshot.mjs http://localhost:5173/ out/captura.png 1440 900
import { chromium } from "playwright";

const url = process.argv[2] || "http://localhost:5173/";
const out = process.argv[3] || "out/screenshot.png";
const width = Number(process.argv[4]) || 1440;
const height = Number(process.argv[5]) || 900;

const browser = await chromium.launch({ headless: true });
const page = await browser.newPage({ viewport: { width, height } });
const errors = [];
page.on("console", (m) => {
  if (m.type() === "error") errors.push(m.text().slice(0, 300));
});
page.on("pageerror", (e) => errors.push("PAGEERROR: " + String(e).slice(0, 300)));

await page.goto(url, { waitUntil: "networkidle" });
await page.waitForTimeout(1200);
await page.screenshot({ path: out });

console.log("Captura guardada en:", out);
console.log("Errores de consola:", errors.length ? errors : "ninguno");
await browser.close();
