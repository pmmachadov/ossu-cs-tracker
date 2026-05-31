/**
 * fix-css-vars.js
 * Post-build script: reemplaza variables CSS por valores estáticos
 * Cross-platform (Node.js), reemplaza al antiguo fix-css-vars.ps1 de PowerShell
 *
 * Uso: node scripts/fix-css-vars.js
 * Se ejecuta automáticamente tras `npm run build`
 */

import { readFileSync, writeFileSync, readdirSync, existsSync } from 'fs';
import { join, extname } from 'path';
import { fileURLToPath } from 'url';

// Mapa de variables CSS → valores estáticos (debe coincidir con index.css)
const CSS_VARS = {
  '--bg-primary': '#000000',
  '--bg-secondary': '#0a0a0a',
  '--bg-tertiary': '#141414',
  '--bg-elevated': '#1a1a1a',
  '--text-primary': '#f0f6fc',
  '--text-secondary': '#8b949e',
  '--text-muted': '#6e7681',
  '--accent-primary': '#4285F4',
  '--accent-secondary': '#1A73E8',
  '--accent-success': '#34A853',
  '--accent-warning': '#FBBC04',
  '--accent-danger': '#EA4335',
  '--border-color': '#1f1f1f',
  '--border-light': '#0f0f0f',
  '--shadow-sm': '0 1px 2px rgba(0, 0, 0, 0.3)',
  '--shadow-md': '0 4px 12px rgba(0, 0, 0, 0.4)',
  '--shadow-lg': '0 8px 24px rgba(0, 0, 0, 0.5)',
  '--shadow-xl': '0 16px 48px rgba(0, 0, 0, 0.6)',
  '--radius-sm': '6px',
  '--radius-md': '8px',
  '--radius-lg': '12px',
  '--transition': 'all 0.2s ease',
};

const __dirname = fileURLToPath(new URL('.', import.meta.url));
const distDir = join(__dirname, '..', 'dist');

if (!existsSync(distDir)) {
  console.error('Directorio dist/ no encontrado. Ejecuta "npm run build" primero.');
  process.exit(1);
}

function processDirectory(dirPath) {
  const entries = readdirSync(dirPath, { withFileTypes: true });
  for (const entry of entries) {
    const fullPath = join(dirPath, entry.name);
    if (entry.isDirectory()) {
      processDirectory(fullPath);
    } else if (extname(entry.name) === '.css') {
      processCssFile(fullPath);
    }
  }
}

function processCssFile(filePath) {
  let content = readFileSync(filePath, 'utf-8');
  let replacedCount = 0;
  for (const [varName, value] of Object.entries(CSS_VARS)) {
    const regex = new RegExp(`var\\(${varName}(?:\\s*,\\s*[^)]*)?\\)`, 'g');
    const matches = content.match(regex);
    if (matches) {
      replacedCount += matches.length;
      content = content.replace(regex, value);
    }
  }
  if (replacedCount > 0) {
    writeFileSync(filePath, content, 'utf-8');
    console.log(`  ${filePath}: ${replacedCount} variables reemplazadas`);
  }
}

console.log('Procesando archivos CSS en dist/...');
processDirectory(distDir);
console.log('Hecho.');
