const fs = require('fs');
const pdf = require('pdf-parse');

const base = 'C:\\Users\\Pablo\\Desktop\\Pablo\\anki-cards-completo\\pruebas\\programacion\\JAVA IOC\\curso-programacion-java\\aulaenlanube';

const pdfs = [
  'tema1\\Introducción a la programación.pdf',
  'tema2\\apuntes\\Introducción a JAVA.pdf',
  'tema2\\ejercicios\\Enunciados\\PRÁCTICA 1 JAVA - Iniciación.pdf',
  'tema3\\apuntes\\Métodos en JAVA.pdf',
  'tema4\\apuntes\\Arrays en JAVA.pdf',
  'tema5\\apuntes\\POO en JAVA.pdf',
  'tema6\\apuntes\\Herencia y excepciones en JAVA.pdf',
  'tema7\\apuntes\\Colecciones y APIS en JAVA.pdf',
  'tema8\\apuntes\\Almacenamiento de datos en JAVA.pdf',
  'tema9\\apuntes\\Interfaz Gráfica en JAVA.pdf',
  'examenes\\ev1\\Examen1 JAVA  - TEST [2022-2023].pdf',
  'examenes\\ev1\\Examen1 JAVA - PRACTICO ]2022-2023].pdf',
  'examenes\\ev3\\Examen Final JAVA - 2023.pdf',
];

async function main() {
  for (const relPath of pdfs) {
    const fullPath = base + '\\' + relPath;
    try {
      if (!fs.existsSync(fullPath)) {
        console.log(`[FALTA] ${relPath}`);
        continue;
      }
      const buf = fs.readFileSync(fullPath);
      const data = await pdf(buf);
      const firstLine = data.text.trim().split('\n')[0] || '(sin texto)';
      const pages = data.numpages;
      console.log(`[OK] ${relPath} → ${pages} páginas, 1ª línea: "${firstLine.substring(0, 80)}"`);
    } catch (e) {
      console.log(`[ERROR] ${relPath} → ${e.message.substring(0, 60)}`);
    }
  }

  // Also list all .pdf files to see if any are missing
  console.log('\n=== TODOS LOS PDFS EN EL REPO ===');
  function walk(dir, prefix) {
    const entries = fs.readdirSync(dir, { withFileTypes: true });
    for (const e of entries) {
      const full = dir + '\\' + e.name;
      if (e.isDirectory()) walk(full, prefix + e.name + '/');
      else if (e.name.endsWith('.pdf')) console.log('  ' + prefix + e.name);
    }
  }
  walk(base, '');
}

main().catch(console.error);
