const fs = require('fs');
const code = fs.readFileSync('src/view/StudyView.jsx', 'utf8');

// Find the extra closing paren
let depth = 0;
let lines = code.split('\n');
for (let lineIdx = 0; lineIdx < lines.length; lineIdx++) {
  const line = lines[lineIdx];
  for (let i = 0; i < line.length; i++) {
    const ch = line[i];
    if (ch === '(') depth++;
    else if (ch === ')') depth--;
  }
  if (depth < 0) {
    console.log(`Extra ) detected at line ${lineIdx + 1}: ${line}`);
    break;
  }
}
console.log(`Final depth: ${depth} (should be 0)`);
