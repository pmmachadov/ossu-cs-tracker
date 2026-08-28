// ============================================================
//  merge-visualizers.mjs
//  Fusiona los dos visualizadores en UN solo HTML con pestañas:
//    - "Paso a Paso"   → bin/code-visualizer-output.html
//    - "Recursión"     → recursion-visualizer-java.html
//  Genera: visualizador-unificado.html
// ============================================================
import { readFileSync, writeFileSync } from 'node:fs';

const DBG = readFileSync('bin/code-visualizer-output.html', 'utf8');
const REC = readFileSync('recursion-visualizer-java.html', 'utf8');

// ---- utilidades de extracción ----
function extract(html, tag) {
  const re = new RegExp(`<${tag}[^>]*>([\\s\\S]*?)</${tag}>`, 'i');
  const m = html.match(re);
  if (!m) throw new Error(`No se encontró <${tag}>`);
  return m[1];
}

// extrae el contenido de <body> SIN los bloques <script> (el body llega hasta </body>,
// que en estos archivos está DESPUÉS del script; los scripts se ensamblan aparte)
function extractBody(html) {
  const body = extract(html, 'body');
  return body.replace(/<script>[\s\S]*?<\/script>/gi, '');
}

// ---- prefija selectores CSS con un scope (p.ej. #view-debug .cl { ... }) ----
function prefixCss(css, prefix) {
  let out = '';
  let buf = '';
  const stack = []; // 'media' | 'keyframes' | 'keyframe-step' | 'rule'
  let i = 0;
  const n = css.length;
  while (i < n) {
    const ch = css[i];
    // comentarios: copiar verbatim
    if (ch === '/' && css[i + 1] === '*') {
      const end = css.indexOf('*/', i + 2);
      const endIdx = end === -1 ? n : end + 2;
      out += css.slice(i, endIdx);
      i = endIdx;
      continue;
    }
    if (ch === '{') {
      const sel = buf.trim();
      buf = '';
      const top = stack[stack.length - 1];
      if (sel.startsWith('@media')) {
        out += sel + '{\n';
        stack.push('media');
      } else if (sel.startsWith('@keyframes')) {
        out += sel + '{\n';
        stack.push('keyframes');
      } else if (top === 'keyframes') {
        out += sel + '{\n'; // pasos 0% / from / to
        stack.push('keyframe-step');
      } else if (sel === ':root') {
        out += sel + '{\n';
        stack.push('rule');
      } else if (sel === '' || sel === '}') {
        out += sel + '{\n';
        stack.push('rule');
      } else {
        const prefixed = sel.split(',').map((s) => (s.trim() ? prefix + ' ' + s.trim() : s)).join(', ');
        out += prefixed + '{\n';
        stack.push('rule');
      }
      i++;
      continue;
    }
    if (ch === '}') {
      out += buf + '}\n';
      buf = '';
      stack.pop();
      i++;
      continue;
    }
    buf += ch;
    i++;
  }
  out += buf;
  return out;
}

// ---- extraer partes ----
const dbgStyle = extract(DBG, 'style');
const recStyle = extract(REC, 'style');
let dbgBody = extractBody(DBG);
let recBody = extractBody(REC);
const dbgScript = extract(DBG, 'script');
const recScript = extract(REC, 'script');

// ---- limpiar el body de la vista recursión ----
// quitar el wrapper <div class="container"> que ya aporta el shell unificado
recBody = recBody.replace(/^\s*<div class="container">/, '');
recBody = recBody.replace(/<\/div>\s*$/, '');
// quitar el header propio de la app de recursión (el unificado ya está arriba)
recBody = recBody.replace(/<!-- Header -->\s*<div class="header">[\s\S]*?<\/div>\s*(?=<!-- Code bar -->)/, '');

// ---- CSS con scope ----
const dbgCss = prefixCss(dbgStyle, '#view-debug') + '\n#view-debug .main { height: 640px; }\n';
const recCss = prefixCss(recStyle, '#view-recursion');

// ---- JS: guardas de teclado por pestaña + exponer stop de cada motor ----
let dbgJs = dbgScript;
// CORRECCIÓN DE BUG DEL ORIGINAL: el archivo fuente tenía un '/' sin escapar
// dentro de la regex de asignación con operador (rompía todo el script).
//   (\+=|-=|\*=|/=|%=)  →  (\+=|-=|\*=|/=|%=)   (slash escapado)
if (dbgJs.includes('(\\+=|-=|\\*=|/=|%=)') && !dbgJs.includes('(\\+=|-=|\\*=|\\/=|%=)')) {
  dbgJs = dbgJs.replace('(\\+=|-=|\\*=|/=|%=)', '(\\+=|-=|\\*=|\\/=|%=)');
  console.log('  fix regex asignación con operador: / escapado');
}
if (!dbgJs.includes("window.__activeTab !== 'debug'")) {
  dbgJs = dbgJs.replace(
    "document.addEventListener('keydown', e => {\n  if (e.target.tagName === 'INPUT') return;",
    "document.addEventListener('keydown', e => {\n  if (e.target.tagName === 'INPUT') return;\n  if (window.__activeTab !== 'debug') return;"
  );
}
dbgJs += '\nwindow.__dbgStop = stopPlay;\n';

let recJs = recScript;
if (!recJs.includes("window.__activeTab !== 'recursion'")) {
  recJs = recJs.replace(
    "  document.addEventListener('keydown', (e) => {\n    if (e.target.tagName === 'INPUT') return;",
    "  document.addEventListener('keydown', (e) => {\n    if (e.target.tagName === 'INPUT') return;\n    if (window.__activeTab !== 'recursion') return;"
  );
}
recJs = recJs.replace(/\}\)\(\);\s*$/, '  window.__recStop = stopPlay;\n})();\n');

// ---- shell + pestañas ----
const tabScript = `// ===== NAVEGACIÓN ENTRE VISUALIZADORES =====
(function(){
  'use strict';
  window.__activeTab = 'debug';

  function switchTab(name) {
    if (window.__activeTab === name) return;
    window.__activeTab = name;
    document.querySelectorAll('.view').forEach(function(v){ v.classList.remove('active'); });
    document.getElementById('view-' + name).classList.add('active');
    document.querySelectorAll('.tab-btn').forEach(function(b){
      b.classList.toggle('active', b.getAttribute('data-tab') === name);
    });
    // detener la reproducción del visualizador que queda oculto
    if (typeof window.__dbgStop === 'function') window.__dbgStop();
    if (typeof window.__recStop === 'function') window.__recStop();
  }

  document.querySelectorAll('.tab-btn').forEach(function(b){
    b.addEventListener('click', function(){ switchTab(b.getAttribute('data-tab')); });
  });
})();
`;

const head = `<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Visualizador de Código Java — Paso a Paso + Recursión</title>
<style>
/* ===== BASE (tema GitHub Dark) ===== */
*, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }
:root {
  --bg: #0d1117; --surface: #161b22; --border: #30363d;
  --text: #e6edf3; --text-dim: #8b949e; --accent: #58a6ff;
  --accent-bg: rgba(88,166,255,0.15); --green: #3fb950;
  --green-bg: rgba(63,185,80,0.15); --red: #f85149; --orange: #d29922;
  --font: 'Consolas','Courier New',monospace; --line-h: 22px;
}
body {
  font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
  background: #0d1117; color: #e6edf3; min-height: 100vh;
  display: flex; justify-content: center; align-items: center; padding: 32px;
}
.container {
  max-width: 1600px; width: 100%; background: #161b22;
  border-radius: 16px; border: 1px solid #30363d; overflow: hidden;
  box-shadow: 0 8px 32px rgba(0,0,0,.5);
}
@media (prefers-reduced-motion: reduce) {
  *, *::before, *::after { animation-duration: 0.001ms !important; animation-iteration-count: 1 !important; transition-duration: 0.001ms !important; }
}
/* ===== HEADER ===== */
.header {
  background: #161b22; border-bottom: 1px solid #30363d;
  padding: 24px 40px; display: flex; align-items: center; gap: 14px; flex-wrap: wrap;
}
.header-icon { font-size: 34px; line-height: 1; }
.header h1 { font-size: 24px; font-weight: 600; color: #58a6ff; }
.header .subtitle {
  font-size: 14px; color: #8b949e; margin-left: auto;
  font-family: 'Cascadia Code','Fira Code','Consolas',monospace;
}
/* ===== TAB BAR ===== */
.tab-bar {
  display: flex; gap: 10px; padding: 14px 40px;
  background: #0d1117; border-bottom: 1px solid #21262d; flex-wrap: wrap;
}
.tab-btn {
  background: #21262d; border: 1px solid #30363d; color: #8b949e;
  padding: 9px 20px; border-radius: 10px; cursor: pointer;
  font-size: 14px; font-weight: 500; font-family: inherit;
  display: inline-flex; align-items: center; gap: 8px; transition: all .2s;
}
.tab-btn:hover { border-color: #58a6ff; color: #e6edf3; }
.tab-btn.active { background: #1f6feb33; border-color: #1f6feb66; color: #58a6ff; }
/* ===== VISTAS ===== */
.view { display: none; }
.view.active { display: block; }
/* ===== SCROLLBAR ===== */
::-webkit-scrollbar { width: 8px; }
::-webkit-scrollbar-track { background: var(--bg); }
::-webkit-scrollbar-thumb { background: var(--border); border-radius: 4px; }
::-webkit-scrollbar-thumb:hover { background: #484f58; }
`;

const bodyMarkup = `\n<div class="container">

  <!-- Header unificado -->
  <div class="header">
    <span class="header-icon">🧠</span>
    <h1>Visualizador de Código Java</h1>
    <span class="subtitle">Paso a paso · Recursión con Stack</span>
  </div>

  <!-- Pestañas -->
  <div class="tab-bar">
    <button class="tab-btn active" data-tab="debug">⚡ Paso a Paso</button>
    <button class="tab-btn" data-tab="recursion">🧠 Recursión (Stack)</button>
  </div>

  <!-- VISTA 1: Depurador paso a paso -->
  <div class="view active" id="view-debug">
${dbgBody}
  </div>

  <!-- VISTA 2: Recursión con memoria stack -->
  <div class="view" id="view-recursion">
${recBody}
  </div>

</div>
`;

const html =
  head +
  dbgCss +
  '\n' +
  recCss +
  '\n</style>\n</head>\n<body>\n' +
  bodyMarkup +
  '\n<script>\n' +
  tabScript +
  '\n' +
  dbgJs +
  '\n' +
  recJs +
  '\n</script>\n</body>\n</html>\n';

writeFileSync('visualizador-unificado.html', html);

// archivo auxiliar para node --check (solo sintaxis)
writeFileSync('_merged-check.js', tabScript + '\n' + dbgJs + '\n' + recJs);

console.log('OK -> visualizador-unificado.html (' + Math.round(html.length / 1024) + ' KB)');
console.log('  debug view  : ' + /id="view-debug"/.test(html));
console.log('  recursión   : ' + /id="view-recursion"/.test(html));
console.log('  dbgStop exp : ' + dbgJs.includes('window.__dbgStop = stopPlay'));
console.log('  recStop exp : ' + recJs.includes('window.__recStop = stopPlay'));
console.log('  key guards  : ' + dbgJs.includes("window.__activeTab !== 'debug'") + ' / ' + recJs.includes("window.__activeTab !== 'recursion'"));
