import fs from 'fs';
import path from 'path';
import * as pdfjsLib from 'pdfjs-dist';

// Set worker to use built-in
pdfjsLib.GlobalWorkerOptions.workerSrc = '';

const base = 'C:\\Users\\Pablo\\Desktop\\Pablo\\anki-cards-completo\\pruebas\\programacion\\JAVA IOC\\curso-programacion-java\\aulaenlanube';
const outFile = 'C:\\Users\\Pablo\\Desktop\\Pablo\\anki-cards-completo\\_pdf_report.txt';

async function readPdf(fullPath) {
  const buf = fs.readFileSync(fullPath);
  const uint8 = new Uint8Array(buf);
  const doc = await pdfjsLib.getDocument({ data: uint8 }).promise;
  let text = '';
  for (let i = 1; i <= doc.numPages; i++) {
    const page = await doc.getPage(i);
    const content = await page.getTextContent();
    text += content.items.map(item => item.str).join(' ') + '\n';
  }
  return { text, pages: doc.numPages };
}

function walkPdfs(dir, results = []) {
  const entries = fs.readdirSync(dir, { withFileTypes: true });
  for (const e of entries) {
    const full = path.join(dir, e.name);
    if (e.isDirectory()) walkPdfs(full, results);
    else if (e.name.toLowerCase().endsWith('.pdf')) results.push(full);
  }
  return results;
}

async function main() {
  const lines = [];
  lines.push('=== TODOS LOS PDFS DEL REPO ===');
  lines.push('');
  
  const pdfs = walkPdfs(base);
  for (const f of pdfs) {
    const rel = path.relative(base, f);
    try {
      const { text, pages } = await readPdf(f);
      const words = text.split(/\s+/).length;
      const snippet = text.trim().substring(0, 200).replace(/\n/g, ' | ');
      lines.push(`[OK] ${rel} | ${pages}p | ${words} palabras`);
      lines.push(`     -> ${snippet}`);
    } catch(e) {
      lines.push(`[ERR] ${rel} | ${e.message.substring(0,100)}`);
    }
  }
  
  fs.writeFileSync(outFile, lines.join('\n'), 'utf8');
  console.log('OK: ' + pdfs.length + ' PDFs checked');
}

main().catch(e => { console.error('FATAL:', e.message); process.exit(1); });
