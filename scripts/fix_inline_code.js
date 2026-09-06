import fs from 'fs';

/**
 * Fixes all Java code blocks that have inline (one-line) class/method definitions.
 * Expands them to properly indented multi-line Java code.
 */

const files = [
  'public/data/examenes/examen-java-ejercicios.json',
  'public/data/examenes/examen-java.json',
  'public/data/examenes/examen-java-test.json'
];

/**
 * Check if a line of Java code has inline class/method body that should be expanded.
 */
function shouldExpand(line) {
  const trimmed = line.trim();
  if (!trimmed) return false;
  if (trimmed.startsWith('//')) return false;
  // Skip array initializers: int[] x = {1, 2, 3};
  if (/=\s*\{/.test(trimmed)) return false;
  // Skip lines with @annotations only
  if (trimmed.startsWith('@')) return false;
  // Must have nested braces (class/method body on one line)
  if (!/\{[^}]*\{/.test(trimmed)) return false;
  return true;
}

/**
 * Expand a single line with inline braces into properly indented multi-line code.
 */
function expandLine(line) {
  const trimmed = line.trim();
  const result = [];
  let depth = 0;
  let current = '';
  let inString = false;
  let escapeNext = false;
  
  for (let i = 0; i < trimmed.length; i++) {
    const ch = trimmed[i];
    
    if (escapeNext) {
      current += ch;
      escapeNext = false;
      continue;
    }
    if (ch === '\\') {
      current += ch;
      escapeNext = true;
      continue;
    }
    if (ch === '"') {
      inString = !inString;
      current += ch;
      continue;
    }
    if (inString) {
      current += ch;
      continue;
    }
    
    if (ch === '{') {
      // Emit what we have so far + opening brace
      const text = current.trimEnd();
      if (text) {
        result.push('    '.repeat(depth) + text + ' {');
      } else {
        // Append { to previous line if possible
        if (result.length > 0) {
          result[result.length - 1] += ' {';
        } else {
          result.push('    '.repeat(depth) + '{');
        }
      }
      current = '';
      depth++;
      continue;
    }
    
    if (ch === '}') {
      // Emit remaining content if any
      const text = current.trim();
      if (text) {
        result.push('    '.repeat(depth) + text);
      }
      current = '';
      depth = Math.max(0, depth - 1);
      result.push('    '.repeat(depth) + '}');
      continue;
    }
    
    if (ch === ';' && !inString) {
      current += ';';
      const text = current.trim();
      if (text) {
        result.push('    '.repeat(depth) + text);
      }
      current = '';
      continue;
    }
    
    current += ch;
  }
  
  // Remaining text
  const remaining = current.trim();
  if (remaining) {
    result.push('    '.repeat(depth) + remaining);
  }
  
  return result.length > 1 ? result.join('\n') : null;
}

let totalFixed = 0;

files.forEach(filePath => {
  const data = JSON.parse(fs.readFileSync(filePath, 'utf8'));
  let fileFixed = 0;

  data.cards.forEach(card => {
    ['front', 'back'].forEach(side => {
      if (!card[side]) return;
      
      const codeBlockRe = /(```java\n)([\s\S]*?)(```)/g;
      let modified = false;
      
      card[side] = card[side].replace(codeBlockRe, (match, open, code, close) => {
        const lines = code.split('\n');
        const newLines = [];
        let changed = false;
        
        for (const line of lines) {
          if (shouldExpand(line)) {
            const expanded = expandLine(line);
            if (expanded) {
              newLines.push(expanded);
              changed = true;
              continue;
            }
          }
          newLines.push(line);
        }
        
        if (changed) {
          modified = true;
          return open + newLines.join('\n') + close;
        }
        return match;
      });
      
      if (modified) {
        fileFixed++;
        console.log(`  Fixed ${card.id} (${side})`);
      }
    });
  });

  if (fileFixed > 0) {
    fs.writeFileSync(filePath, JSON.stringify(data, null, 2) + '\n');
  }
  console.log(`${filePath}: ${fileFixed} code blocks fixed`);
  totalFixed += fileFixed;
});

console.log(`\nTotal fixed: ${totalFixed}`);
