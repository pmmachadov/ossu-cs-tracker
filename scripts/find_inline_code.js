import fs from 'fs';

const files = [
  'public/data/examenes/examen-java-ejercicios.json',
  'public/data/examenes/examen-java.json',
  'public/data/examenes/examen-java-test.json'
];

// Find ALL cards where java code blocks have lines with class X { ... { ... } ... }
// (inline class/method bodies that should be expanded to multi-line)
const inlinePattern = /\{[^}]*\{[^}]*\}[^}]*\}/;
const codeBlockRe = /```java\n([\s\S]*?)```/g;

files.forEach(file => {
  const data = JSON.parse(fs.readFileSync(file, 'utf8'));
  data.cards.forEach(c => {
    ['front', 'back'].forEach(side => {
      if (!c[side]) return;
      let match;
      while ((match = codeBlockRe.exec(c[side])) !== null) {
        const code = match[1];
        const lines = code.split('\n');
        const badLines = lines.filter(l => inlinePattern.test(l) && !l.trim().startsWith('//'));
        if (badLines.length > 0) {
          console.log(`${file} -> ${c.id} (${side})`);
          badLines.forEach(l => console.log(`  BAD: ${l.trim().substring(0, 140)}`));
          console.log('');
        }
      }
      codeBlockRe.lastIndex = 0;
    });
  });
});
