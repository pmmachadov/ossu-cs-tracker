const fs = require('fs');
const pdf = require('pdf-parse');

const base = 'C:\\Users\\Pablo\\Desktop\\Pablo\\anki-cards-completo\\pruebas\\programacion\\JAVA IOC\\curso-programacion-java\\aulaenlanube';

async function extractPdfText(relPath) {
  const fullPath = base + '\\' + relPath;
  if (!fs.existsSync(fullPath)) return null;
  const buf = fs.readFileSync(fullPath);
  const data = await pdf(buf);
  return data.text;
}

async function main() {
  // 1. Leer apuntes principales (los PDFs de teoría)
  const apuntes = [
    { tema: 'Tema 1 - Introducción programación', pdf: 'tema1\\Introducción a la programación.pdf' },
    { tema: 'Tema 2 - Introducción JAVA', pdf: 'tema2\\apuntes\\Introducción a JAVA.pdf' },
    { tema: 'Tema 3 - Métodos', pdf: 'tema3\\apuntes\\Métodos en JAVA.pdf' },
    { tema: 'Tema 4 - Arrays', pdf: 'tema4\\apuntes\\Arrays en JAVA.pdf' },
    { tema: 'Tema 5 - POO', pdf: 'tema5\\apuntes\\POO en JAVA.pdf' },
    { tema: 'Tema 6 - Herencia y excepciones', pdf: 'tema6\\apuntes\\Herencia y excepciones en JAVA.pdf' },
    { tema: 'Tema 7 - Colecciones y APIs', pdf: 'tema7\\apuntes\\Colecciones y APIS en JAVA.pdf' },
    { tema: 'Tema 8 - Almacenamiento datos', pdf: 'tema8\\apuntes\\Almacenamiento de datos en JAVA.pdf' },
    { tema: 'Tema 9 - Interfaz Gráfica', pdf: 'tema9\\apuntes\\Interfaz Gráfica en JAVA.pdf' },
  ];

  console.log('=== RESUMEN PDFs DE TEORÍA ===\n');
  for (const a of apuntes) {
    const text = await extractPdfText(a.pdf);
    if (text === null) {
      console.log(`✗ ${a.tema}: NO ENCONTRADO`);
      continue;
    }
    // Extraer palabras clave significativas del PDF
    const lines = text.split('\n').filter(l => l.trim().length > 0);
    // Buscar títulos/secciones (líneas cortas que parezcan títulos)
    const titles = lines.filter(l => l.trim().length > 0 && l.trim().length < 80 && !l.startsWith(' ') && /[A-ZÁÉÍÓÚÑa-záéíóúñ]/.test(l)).slice(0, 20);
    const wordCount = text.split(/\s+/).length;
    console.log(`✓ ${a.tema}: ${wordCount} palabras, ~títulos: ${titles.slice(0,8).join(' | ')}`);
    console.log(`  Primeros 200 chars: ${text.trim().substring(0,200).replace(/\n/g,' ')}\n`);
  }

  // 2. Leer enunciados de ejercicios/prácticas
  console.log('\n=== EJERCICIOS/PRÁCTICAS ===\n');
  const practicas = [
    'tema2\\ejercicios\\Enunciados\\PRÁCTICA 1 JAVA - Iniciación.pdf',
    'tema2\\ejercicios\\Enunciados\\PRÁCTICA 2 JAVA - Strings.pdf',
    'tema2\\ejercicios\\Enunciados\\PRÁCTICA 3 JAVA - Figuras.pdf',
    'tema2\\ejercicios\\Enunciados\\PRÁCTICA AMPLIACIÓN - Figuras complejas.pdf',
    'tema6\\ejercicios\\practica1\\Enunciado\\Práctica 1 Herencia - Gestión de nóminas.pdf',
    'tema6\\ejercicios\\practica2\\Enunciado\\Práctica 2 Herencia - Gestión de empleados.pdf',
    'tema6\\ejercicios\\practica3\\Enunciado\\Práctica 3 Herencia - Gestión de biblioteca.pdf',
    'tema6\\ejercicios\\practica4\\Enunciado\\Práctica 4 Herencia - Gestión de eventos deportivos.pdf',
    'tema7\\ejercicios\\practica1\\Enunciado\\Práctica 1 Colecciones - Equipo de fútbol.pdf',
  ];
  for (const p of practicas) {
    const text = await extractPdfText(p);
    if (text === null) {
      console.log(`✗ ${p}: NO ENCONTRADO`);
      continue;
    }
    const wordCount = text.split(/\s+/).length;
    console.log(`✓ ${p}: ${wordCount} palabras`);
    console.log(`  ${text.trim().substring(0,300).replace(/\n/g,' ')}\n`);
  }

  // 3. Exámenes
  console.log('\n=== EXÁMENES ===\n');
  const examenes = [
    'examenes\\ev1\\Examen1 JAVA  - TEST [2022-2023].pdf',
    'examenes\\ev1\\Examen1 JAVA - PRACTICO ]2022-2023].pdf',
    'examenes\\ev3\\Examen Final JAVA - 2023.pdf',
  ];
  for (const e of examenes) {
    const text = await extractPdfText(e);
    if (text === null) {
      console.log(`✗ ${e}: NO ENCONTRADO`);
      continue;
    }
    const wordCount = text.split(/\s+/).length;
    console.log(`✓ ${e}: ${wordCount} palabras`);
    console.log(`  ${text.trim().substring(0,300).replace(/\n/g,' ')}\n`);
  }
}

main().catch(console.error);
