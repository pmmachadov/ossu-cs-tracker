import fs from 'fs';

function cleanAndIndentJava(code) {
  // First normalize line breaks
  let text = code.replace(/\r\n/g, '\n');

  // Split single-line main class
  text = text.replace(/public\s+class\s+(\w+)\s*\{\s*public\s+static\s+void\s+main\s*\(\s*String\[\]\s*(\w+)\s*\)\s*\{/g, 
    'public class $1 {\npublic static void main(String[] $2) {');

  // Split inline class definitions: "} class " -> "}\n\nclass "
  text = text.replace(/\}\s*(class|public class|abstract class|interface|enum)\s+/g, '}\n\n$1 ');

  // Split single line methods with braces: "getFoo() { return foo; }" -> "getFoo() {\nreturn foo;\n}"
  text = text.replace(/(\)\s*(?:throws\s+[^{]+)?\s*\{)\s*([^}\n]+;\s*)\}/g, '$1\n$2\n}');

  // Split classes starting on same line as opening brace: "class Foo { int x;" -> "class Foo {\nint x;"
  text = text.replace(/^(\s*(?:public\s+|private\s+|protected\s+|abstract\s+|static\s+)*class\s+\w+(?:<[^>]+>)?(?:\s+extends\s+\w+)?(?:\s+implements\s+[^{]+)?\s*\{)\s*([^\s\n{}].*)$/gm, '$1\n$2');

  const rawLines = text.split('\n');
  const cleanedLines = [];

  // Pass 1: Trim lines and drop blank lines immediately preceding closing braces '}'
  for (let i = 0; i < rawLines.length; i++) {
    const line = rawLines[i].trim();
    if (line === '') {
      // Check if next non-empty line starts with '}'
      let nextLine = '';
      for (let j = i + 1; j < rawLines.length; j++) {
        if (rawLines[j].trim() !== '') {
          nextLine = rawLines[j].trim();
          break;
        }
      }
      if (nextLine.startsWith('}')) {
        continue; // Skip blank line before closing brace
      }
    }
    cleanedLines.push(line);
  }

  // Pass 2: Indent cleanly (4 spaces per level)
  let currentIndent = 0;
  const indentSize = 4;
  const result = [];

  for (let i = 0; i < cleanedLines.length; i++) {
    const line = cleanedLines[i];
    if (!line) {
      if (result.length > 0 && result[result.length - 1] !== '') {
        result.push('');
      }
      continue;
    }

    const openCount = (line.match(/\{/g) || []).length;
    const closeCount = (line.match(/\}/g) || []).length;
    const leadingCloses = (line.match(/^\}+/) || [''])[0].length;
    const effectiveIndent = Math.max(0, currentIndent - leadingCloses);

    result.push(' '.repeat(effectiveIndent * indentSize) + line);

    currentIndent += (openCount - closeCount);
    if (currentIndent < 0) currentIndent = 0;
  }

  return result.join('\n');
}

function runFormatting() {
  ['public/data/examenes/examen-java-ejercicios.json', 'public/data/examenes/examen-java.json'].forEach(filePath => {
    const data = JSON.parse(fs.readFileSync(filePath, 'utf8'));
    let updated = 0;

    data.cards.forEach(card => {
      let cardChanged = false;

      ['front', 'back'].forEach(field => {
        if (!card[field]) return;

        const newField = card[field].replace(/```java\n([\s\S]*?)```/g, (fullMatch, codeBlock) => {
          const formatted = cleanAndIndentJava(codeBlock);
          if (formatted !== codeBlock) {
            cardChanged = true;
            return '```java\n' + formatted + '\n```';
          }
          return fullMatch;
        });

        if (newField !== card[field]) {
          card[field] = newField;
          cardChanged = true;
        }
      });

      if (cardChanged) updated++;
    });

    fs.writeFileSync(filePath, JSON.stringify(data, null, 2), 'utf8');
    console.log(`Formatted ${filePath}: ${updated} cards cleanly indented.`);
  });
}

runFormatting();
