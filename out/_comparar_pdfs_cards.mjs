import fs from 'fs';
import path from 'path';
import { getDocument } from 'pdfjs-dist/legacy/build/pdf.mjs';

const ANKI_DIR = 'C:/Users/Pablo/Desktop/Pablo/anki-cards-completo';
const PDF_BASE = path.join(ANKI_DIR, 'pruebas/programacion/JAVA IOC/curso-programacion-java/aulaenlanube');
const OUT_DIR = path.join(PDF_BASE, '_extraidos');

// Cargar cards existentes
function loadCards(relPath) {
  const full = path.join(ANKI_DIR, relPath);
  if (!fs.existsSync(full)) return [];
  try {
    const d = JSON.parse(fs.readFileSync(full, 'utf8'));
    return d.cards || [];
  } catch { return []; }
}

const allCards = [
  ...loadCards('public/data/java.json'),
  ...loadCards('public/data/programacion.json'),
  ...loadCards('public/data/java-ejercicios.json'),
];

// Keywords por tema de los PDFs para buscar en las cards
const temas = [
  {
    archivo: 'tema1_Introducción a la programación.txt',
    tema: 'Tema 1 - Introducción a la programación',
    keywords: ['algoritmo', 'pseudocódigo', 'diagrama de flujo', 'ordinograma', 'variable', 'constante',
               'tipo de dato', 'expresión', 'operador', 'compilador', 'intérprete',
               'lenguaje de programación', 'código máquina', 'bytecode', 'compilación',
               'datos', 'procesador', 'programa', 'software', 'ciclo de vida',
               'declaración', 'asignación', 'entrada', 'salida', 'lectura', 'escritura',
               'mientras', 'repetir', 'para', 'for', 'while', 'si', 'sino', 'if', 'else',
               'estructura de control', 'alternativa', 'repetitiva', 'condicional'],
  },
  {
    archivo: 'tema2_apuntes_Introducción a JAVA.txt',
    tema: 'Tema 2 - Introducción a JAVA',
    keywords: ['JVM', 'JRE', 'JDK', 'bytecode', 'compilar', 'javac', 'ejecutar', 'java',
               'hola mundo', 'main', 'System.out', 'print', 'println',
               'variable', 'int', 'double', 'float', 'long', 'short', 'byte', 'char', 'boolean',
               'String', 'cadena', 'length()', 'charAt', 'substring', 'indexOf', 'toUpperCase',
               'operador', 'aritmético', 'incremento', 'decremento', 'asignación',
               'constante', 'final', 'comentario', '//', '/*', '/**', 'javadoc',
               'hexadecimal', 'Unicode', 'ASCII', 'escape', '\\n', '\\t',
               'tipado fuerte', 'conversión', 'casting', 'entrada', 'Scanner',
               'if', 'else', 'switch', 'while', 'do-while', 'for', 'bucle'],
  },
  {
    archivo: 'tema3_apuntes_Métodos en JAVA.txt',
    tema: 'Tema 3 - Métodos en JAVA',
    keywords: ['método', 'función', 'parámetro', 'argumento', 'return', 'void',
               'sobrecarga', 'overloading', 'static', 'ámbito', 'scope', 'variable local',
               'variable global', 'paso por valor', 'recursividad', 'recursión',
               'modular', 'refinamiento', 'diseño descendente', 'top-down'],
  },
  {
    archivo: 'tema4_apuntes_Arrays en JAVA.txt',
    tema: 'Tema 4 - Arrays en JAVA',
    keywords: ['array', 'matriz', 'índice', 'length', 'bidimensional', 'multidimensional',
               'for each', 'búsqueda', 'ordenación', 'burbuja', 'quicksort',
               'binaria', 'secuencial', 'algoritmo de ordenación'],
  },
  {
    archivo: 'tema5_apuntes_POO en JAVA.txt',
    tema: 'Tema 5 - POO en JAVA',
    keywords: ['objeto', 'clase', 'atributo', 'método', 'constructor', 'instancia',
               'encapsulación', 'getter', 'setter', 'this', 'new', 'null',
               'static', 'miembro estático', 'modificador de acceso', 'public', 'private',
               'String', 'ArrayList', 'mutable', 'inmutable', 'instancia'],
  },
  {
    archivo: 'tema6_apuntes_Herencia y excepciones en JAVA.txt',
    tema: 'Tema 6 - Herencia y excepciones',
    keywords: ['herencia', 'extends', 'super', 'polimorfismo', 'sobrescritura', 'override',
               'clase abstracta', 'abstract', 'interface', 'interfaz', 'implement',
               'excepción', 'try', 'catch', 'finally', 'throw', 'throws',
               'checked', 'unchecked', 'exception', 'error'],
  },
  {
    archivo: 'tema7_apuntes_Colecciones y APIS en JAVA.txt',
    tema: 'Tema 7 - Colecciones y APIs',
    keywords: ['colección', 'ArrayList', 'LinkedList', 'HashSet', 'TreeSet', 'HashMap', 'TreeMap',
               'iterator', 'for each', 'lambda', 'stream', 'functional interface',
               'API', 'Math', 'Random', 'Date', 'Calendar', 'colecciones',
               'map', 'set', 'list', 'cola', 'pila', 'deque'],
  },
  {
    archivo: 'tema8_apuntes_Almacenamiento de datos en JAVA.txt',
    tema: 'Tema 8 - Almacenamiento de datos',
    keywords: ['fichero', 'archivo', 'File', 'FileReader', 'FileWriter', 'BufferedReader',
               'BufferedWriter', 'InputStream', 'OutputStream', 'lectura', 'escritura',
               'serialización', 'ObjectInputStream', 'ObjectOutputStream',
               'base de datos', 'JDBC', 'MySQL', 'SQL', 'conexión', 'Statement',
               'PreparedStatement', 'ResultSet', 'XML', 'JSON'],
  },
  {
    archivo: 'tema9_apuntes_Interfaz Gráfica en JAVA.txt',
    tema: 'Tema 9 - Interfaz Gráfica',
    keywords: ['GUI', 'interfaz gráfica', 'Swing', 'AWT', 'JavaFX', 'JFrame', 'JPanel',
               'JButton', 'JLabel', 'JTextField', 'JTextArea', 'evento', 'ActionListener',
               'MouseListener', 'layout', 'BorderLayout', 'FlowLayout', 'GridLayout',
               'diálogo', 'JOptionPane', 'menú', 'JMenu', 'componente'],
  },
];

function normalize(s) {
  return s.toLowerCase().normalize('NFD').replace(/[\u0300-\u036f]/g, '').replace(/[^a-z0-9]/g, ' ');
}

function searchCards(cards, keyword) {
  const nk = normalize(keyword);
  return cards.filter(c => {
    const front = normalize(c.front || '');
    const back = normalize(c.back || '');
    const tags = (c.tags || []).join(' ');
    return front.includes(nk) || back.includes(nk) || tags.includes(nk);
  });
}

console.log('========================================================');
console.log('COMPARATIVA: PDFs del curso JAVA vs CARDS existentes');
console.log('Cards totales en la app: ' + allCards.length);
console.log('  - java.json: 536 teoria y conceptos');
console.log('  - programacion.json: 310 modulo');
console.log('  - java-ejercicios.json: 368 ejercicios');
console.log('========================================================\n');

for (const t of temas) {
  const txtPath = path.join(OUT_DIR, t.archivo);
  if (!fs.existsSync(txtPath)) {
    console.log('✗ ' + t.tema + ' — archivo no encontrado\n');
    continue;
  }

  const text = fs.readFileSync(txtPath, 'utf8');
  
  // Extraer líneas relevantes del PDF (secciones/títulos)
  const lines = text.split('\n').map(l => l.trim()).filter(l => l.length > 10);
  const secciones = lines.filter(l => /^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]/.test(l) && l.length < 80 && !l.startsWith('CFGS') && !l.startsWith('Material') && !l.startsWith('Esta obra'))
                          .slice(0, 15);

  console.log('📘 ' + t.tema);
  console.log('   Secciones detectadas: ' + secciones.slice(0, 10).join(' | '));
  
  // Buscar keywords en las cards
  let encontrados = 0;
  let noEncontrados = [];
  for (const kw of t.keywords) {
    const matches = searchCards(allCards, kw);
    if (matches.length > 0) {
      encontrados++;
    } else {
      noEncontrados.push(kw);
    }
  }
  
  const pct = Math.round((encontrados / t.keywords.length) * 100);
  console.log('   Keywords cubiertas: ' + encontrados + '/' + t.keywords.length + ' (' + pct + '%)');
  
  if (noEncontrados.length > 0) {
    console.log('   ⚠ POSIBLES LAGUNAS: ' + noEncontrados.join(', '));
  } else {
    console.log('   ✅ Todas las keywords cubiertas');
  }
  console.log('');
}
