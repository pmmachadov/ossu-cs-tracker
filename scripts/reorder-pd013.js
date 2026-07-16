import { readFileSync, writeFileSync, cpSync } from 'fs';
import { join, dirname } from 'path';
import { fileURLToPath } from 'url';

const __dirname = dirname(fileURLToPath(import.meta.url));
const jsonPath = join(__dirname, '..', 'public', 'data', 'preguntas-directas', 'pd-all.json');
const htmlSrc = join(__dirname, '..', 'diagrama-flujo.html');
const htmlDst = join(__dirname, '..', 'public', 'diagrama-flujo.html');

const raw = readFileSync(jsonPath, 'utf-8');
const data = JSON.parse(raw);
const cards = data.cards;

const idx = cards.findIndex(c => c.id === 'pd-ed-013');
console.log(`pd-ed-013 at index: ${idx}`);

if (idx !== -1) {
  const card = cards.splice(idx, 1)[0];
  card.back += '\n\n📊 **Diagrama visual:** [`/diagrama-flujo.html`](/diagrama-flujo.html)';
  cards.unshift(card);
  data.cards = cards;
  writeFileSync(jsonPath, JSON.stringify(data, null, 2) + '\n', 'utf-8');
  console.log('Reordered: pd-ed-013 is now first');
}

// Copy diagram HTML to public/
cpSync(htmlSrc, htmlDst);
console.log('diagrama-flujo.html copied to public/');
