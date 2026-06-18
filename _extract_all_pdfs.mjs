import fs from 'fs';
import path from 'path';
import { getDocument } from 'pdfjs-dist/legacy/build/pdf.mjs';

const base = 'C:/Users/Pablo/Desktop/Pablo/anki-cards-completo/pruebas/programacion/JAVA IOC/curso-programacion-java/aulaenlanube';
const outDir = path.join(base, '_extraidos');

if (!fs.existsSync(outDir)) fs.mkdirSync(outDir, { recursive: true });

function walkPdfs(dir, results = []) {
  const entries = fs.readdirSync(dir, { withFileTypes: true });
  for (const e of entries) {
    if (e.name.startsWith('_')) continue;
    const full = path.join(dir, e.name);
    if (e.isDirectory()) walkPdfs(full, results);
    else if (e.name.toLowerCase().endsWith('.pdf')) results.push(full);
  }
  return results;
}

const pdfs = walkPdfs(base);
console.log('PDFs encontrados:', pdfs.length);
console.log('');

let totalChairs = 0;
let success = 0, fail = 0;

for (const f of pdfs) {
  const rel = path.relative(base, f);
  const outName = rel.replace(/[/\\:]/g, '_').replace(/\.pdf$/i, '.txt');
  const outPath = path.join(outDir, outName);

  try {
    const buf = new Uint8Array(fs.readFileSync(f));
    const doc = await getDocument({ data: buf }).promise;
    let fullText = '';
    for (let i = 1; i <= doc.numPages; i++) {
      const page = await doc.getPage(i);
      const content = await page.getTextContent();
      const pageText = content.items.map(item => item.str).join(' ');
      fullText += pageText + '\n';
    }
    fs.writeFileSync(outPath, fullText, 'utf8');
    console.log('OK  ' + rel + ' | ' + doc.numPages + ' pag | ' + fullText.length + ' chars');
    totalChairs += fullText.length;
    success++;
  } catch (e) {
    console.log('ERR ' + rel + ' | ' + (e.message || '').substring(0, 100));
    fail++;
  }
}

console.log('');
console.log('Resumen: ' + success + ' OK, ' + fail + ' ERROR, ' + totalChairs + ' chars totales');
