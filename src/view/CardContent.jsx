import { useState } from "react";
import { Prism as SyntaxHighlighter } from "react-syntax-highlighter";
import { vscDarkPlus } from "react-syntax-highlighter/dist/esm/styles/prism";
import createElement from "react-syntax-highlighter/dist/esm/create-element";
import { YouTubeEmbed } from "./YouTubeEmbed";

// Tema personalizado: estilo VSCode Dark+ (vibrante) con comentarios en verde pastel claro
export const codeTheme = {
  ...vscDarkPlus,
  'comment': { color: '#34A853', fontStyle: 'italic' },
  'prolog': { color: '#34A853' },
  'doctype': { color: '#34A853' },
  'cdata': { color: '#34A853' },
};

const normalizeText = (text) => {
  if (!text) return "";
  return text.replace(/\\n/g, "\n").replace(/\\t/g, "\t");
};

// Extrae un ejemplo de código del back para mostrar como pista en el front
export const extractCodeHint = (backText) => {
  if (!backText) return null;
  const normalized = normalizeText(backText);
  // Buscar primer bloque de código
  const blockMatch = normalized.match(/```(\w*)\n([\s\S]*?)```/);
  if (blockMatch) {
    const lang = blockMatch[1] || "javascript";
    const lines = blockMatch[2]
      .split("\n")
      .filter((l) => l.trim().length > 0);
    if (lines.length > 0) {
      // Tomar hasta 3 líneas para el ejemplo
      const hintLines = lines.slice(0, 3);
      return { code: hintLines.join("\n"), lang };
    }
  }
  // Si no hay bloque, buscar código inline
  const inlineMatch = normalized.match(/`([^`]{5,50})`/);
  if (inlineMatch) {
    return { code: inlineMatch[1], lang: "javascript" };
  }
  return null;
};

// Hash simple para identificar el bloque de código (clave de persistencia)
const simpleHash = (str) => {
  let h = 5381;
  for (let i = 0; i < str.length; i++) h = ((h << 5) + h + str.charCodeAt(i)) >>> 0;
  return h.toString(36);
};

// Checkbox "¿Lo entiendo?" — bonito, a la derecha de la línea, persistente
const CheckItem = ({ storageKey }) => {
  const [checked, setChecked] = useState(() => {
    try {
      return localStorage.getItem(storageKey) === "1";
    } catch {
      return false;
    }
  });
  return (
    <label
      className="code-check"
      title={checked ? "Entendido ✓" : "Marca si lo entiendes"}
      onClick={(e) => e.stopPropagation()}
    >
      <input
        type="checkbox"
        checked={checked}
        onChange={(e) => {
          setChecked(e.target.checked);
          try {
            localStorage.setItem(storageKey, e.target.checked ? "1" : "0");
          } catch {
            // localStorage no disponible: solo estado en memoria
          }
        }}
      />
      <span className="code-check-box">{checked ? "✓" : ""}</span>
    </label>
  );
};

// Renderer de código: añade un checkbox a la derecha de cada línea con // ✅
// Nota: react-syntax-highlighter >= 16 invoca el renderer como
// renderer({ rows, stylesheet, useInlineStyles }), no con las filas sueltas.
// El árbol de filas usa nodos { type: 'text', value } dentro de los elementos.
const nodeText = (node) => {
  if (node == null) return "";
  if (node.type === "text") return node.value || "";
  if (Array.isArray(node.children)) return node.children.map(nodeText).join("");
  return "";
};

const codeRenderer = ({ rows, stylesheet, useInlineStyles }) => {
  return rows.map((row, i) => {
    const lineText = (row.children || []).map(nodeText).join("");
    const isErrorLine = lineText.includes("❌") || (/\berror\b/i.test(lineText) && !lineText.includes("✅"));
    const isSuccessLine = lineText.includes("✅") || (/\bcorrect[oa]\b/i.test(lineText) && !lineText.includes("❌"));

    if (isErrorLine || isSuccessLine) {
      row.properties = { ...row.properties };
      const classes = Array.isArray(row.properties.className)
        ? [...row.properties.className]
        : (row.properties.className ? [row.properties.className] : []);
      classes.push(isErrorLine ? "code-line-error" : "code-line-success");
      row.properties.className = classes;
    }

    return createElement({
      node: row,
      stylesheet,
      useInlineStyles,
      key: `l-${i}`,
    });
  });
};

// Renderiza código inline con estilo VSCode
const renderInlineCode = (code, key) => (
  <code key={key} className="inline-code">
    {code}
  </code>
);

// Render text and wrap markdown bold/italic, urls, and parentheses
const renderTextWithParens = (text, baseKey) => {
  if (!text) return [];

  // Parse **bold** and *italic* first
  const mdParts = text.split(/(\*\*[^*]+\*\*|\*[^*]+\*)/g);
  return mdParts.map((mdPart, mdi) => {
    if (!mdPart) return null;
    const mKey = `${baseKey}-md-${mdi}`;
    if (mdPart.startsWith("**") && mdPart.endsWith("**") && mdPart.length >= 4) {
      const boldContent = mdPart.slice(2, -2);
      return (
        <strong key={mKey} className="card-bold-text" style={{ color: "#ffffff", fontWeight: "700" }}>
          {renderTextWithParens(boldContent, `${mKey}-b`)}
        </strong>
      );
    }
    if (mdPart.startsWith("*") && mdPart.endsWith("*") && mdPart.length >= 2) {
      const italicContent = mdPart.slice(1, -1);
      return (
        <em key={mKey} className="card-italic-text" style={{ color: "var(--text-secondary)", fontStyle: "italic" }}>
          {renderTextWithParens(italicContent, `${mKey}-i`)}
        </em>
      );
    }

    // Split keeping parentheses characters
    const tokens = mdPart.split(/([()\[\]{}<>])/g);
    return tokens
      .map((t, i) => {
        if (!t) return null;
        const key = `${mKey}-${i}`;
        switch (t) {
          case "(":
          case ")":
            return (
              <span key={key} className="paren paren-round">
                {t}
              </span>
            );
          case "[":
          case "]":
            return (
              <span key={key} className="paren paren-square">
                {t}
              </span>
            );
          case "{":
          case "}":
            return (
              <span key={key} className="paren paren-curly">
                {t}
              </span>
            );
          case "<":
          case ">":
            return (
              <span key={key} className="paren paren-angle">
                {t}
              </span>
            );
          default:
            // Detectar URLs en medio del texto y convertirlas en enlaces clicables
            const urlWithinRegex = /(https?:\/\/[^\s]+)/g;
            const parts = t.split(urlWithinRegex);
            if (parts.length > 1) {
              return parts.map((part, pi) => {
                if (urlWithinRegex.test(part)) {
                  urlWithinRegex.lastIndex = 0;
                  return (
                    <a key={`${key}-url-${pi}`} href={part} target="_blank" rel="noopener noreferrer" className="card-link" onClick={(e) => e.stopPropagation()}>
                      {part}
                    </a>
                  );
                }
                return part;
              });
            }
            const fullTokenRegex = /^(https?:\/\/[^\s]+)$/;
            if (fullTokenRegex.test(t)) {
              return (
                <a key={key} href={t} target="_blank" rel="noopener noreferrer" className="card-link" onClick={(e) => e.stopPropagation()}>
                  {t}
                </a>
              );
            }
            return t;
        }
      })
      .filter(Boolean);
  }).filter(Boolean);
};

// Función para procesar texto y resaltar código
const renderCardContent = (text, cardImageUrl) => {
  if (!text) return null;

  const normalized = normalizeText(text);
  // Tarjeta de "encontrar el error": muestra números de línea en los bloques
  // de código (para no equivocarse de línea) — "errores" en plural o ❌.
  const isErrorCard = /\berrores\b/i.test(normalized) || normalized.includes("❌");
  const lines = normalized.split("\n");
  const elements = [];
  let codeBlock = null;
  let codeLines = [];
  // La primera línea con contenido tras una cabecera "Parte N:" es la pregunta
  let pendingQuestion = false;

  // Procesa una línea de texto como párrafo individual
  const processLine = (line, keyIdx) => {
    if (!line.trim()) return;

    const trimmed = line.trim();

    // Imagen markdown en línea completa: ![alt](url)
    const standaloneImgMatch = trimmed.match(/^!\[([^\]]*)\]\(([^)]+)\)$/);
    if (standaloneImgMatch) {
      elements.push(
        <div key={`img-${keyIdx}`} className="card-image-wrapper">
          <img
            src={standaloneImgMatch[2]}
            alt={standaloneImgMatch[1] || "Diagrama"}
            className="card-image"
          />
        </div>
      );
      return;
    }

    // Separador horizontal --- o ***
    if (trimmed === "---" || trimmed === "***" || trimmed === "___") {
      elements.push(
        <hr
          key={`hr-${keyIdx}`}
          className="card-divider"
          style={{
            border: "none",
            borderTop: "1px solid rgba(255, 255, 255, 0.15)",
            margin: "18px 0",
          }}
        />
      );
      return;
    }

    let contentLine = line;
    let isHeading = false;
    const headingMatch = trimmed.match(/^(#{1,4})\s+(.*)$/);
    if (headingMatch) {
      isHeading = true;
      contentLine = headingMatch[2];
    }

    const contentTrimmed = contentLine.trim();
    const isSection = /^Parte\s+\d+:\s*[A-ZÁÉÍÓÚÑ]/.test(contentTrimmed);
    const isQuestion = pendingQuestion;
    if (isSection) {
      pendingQuestion = true;
    } else if (isQuestion) {
      pendingQuestion = false;
    }

    // Procesa imágenes (![alt](url)) y enlaces ([texto](url)) markdown ANTES de dividir por paréntesis
    const mdTokenRegex = /(!?)\[([^\]]*)\]\(([^)]+)\)/g;
    const linkParts = [];
    let lastMdIdx = 0;
    let mdMatch;
    while ((mdMatch = mdTokenRegex.exec(contentLine)) !== null) {
      if (mdMatch.index > lastMdIdx) {
        linkParts.push(contentLine.slice(lastMdIdx, mdMatch.index));
      }
      const isImg = mdMatch[1] === "!";
      linkParts.push({
        type: isImg ? "image" : "link",
        text: mdMatch[2],
        url: mdMatch[3],
      });
      lastMdIdx = mdMatch.index + mdMatch[0].length;
    }
    if (lastMdIdx < contentLine.length) {
      linkParts.push(contentLine.slice(lastMdIdx));
    }

    const isSubtitle = isHeading || /^(?:[¿¡]?[A-ZÁÉÍÓÚÑ]|\d+\.\s*)[A-Za-zÁÉÍÓÚÑáéíóúñ0-9 (),./@]{0,70}[:?]$/.test(contentTrimmed);
    let pClassName = "card-text-paragraph";
    if (isQuestion) {
      pClassName += " card-question";
    } else if (isSection || isSubtitle) {
      pClassName += " card-subtitle";
    }

    // Si hay enlaces o imágenes markdown, usa el pipeline de tokens
    if (linkParts.some((p) => typeof p === "object")) {
      const mixed = linkParts.map((part, lpi) => {
        if (typeof part === "object") {
          if (part.type === "image") {
            return (
              <span key={`mdimg-${keyIdx}-${lpi}`} className="card-image-wrapper">
                <img
                  src={part.url}
                  alt={part.text || "Diagrama"}
                  className="card-image"
                />
              </span>
            );
          }
          if (part.type === "link") {
            // Detectar YouTube y mostrar thumbnail con overlay play
            const ytMatch = part.url.match(/(?:youtube\.com\/watch\?v=|youtu\.be\/)([a-zA-Z0-9_-]{11})/);
            if (ytMatch) {
              const videoId = ytMatch[1];
              return (
                <YouTubeEmbed
                  key={`mdlink-${keyIdx}-${lpi}`}
                  videoId={videoId}
                  label={part.text}
                  stopPropagation={true}
                />
              );
            }
            return (
              <a
                key={`mdlink-${keyIdx}-${lpi}`}
                href={part.url}
                target="_blank"
                rel="noopener noreferrer"
                className="card-link"
                onClick={(e) => e.stopPropagation()}
              >
                {part.text}
              </a>
            );
          }
        }
        // Procesar inline code y paréntesis en el texto sobrante
        const innerParts = part.split(/`([^`]+)`/g);
        return innerParts.map((inner, ii) => {
          if (ii % 2 === 1) {
            return renderInlineCode(inner, `md-inline-${keyIdx}-${lpi}-${ii}`);
          } else if (inner) {
            return renderTextWithParens(
              inner,
              `md-p-${keyIdx}-${lpi}-${ii}`,
            );
          }
          return null;
        });
      });

      elements.push(
        <p key={`text-${keyIdx}`} className={pClassName} style={{textAlign: 'left'}}>
          {mixed}
        </p>,
      );
      return;
    }

    // Divide la línea en partes para detectar código inline `...`
    const parts = contentLine.split(/`([^`]+)`/g);
    const mixed = [];
    parts.forEach((part, idx) => {
      if (idx % 2 === 1) {
        mixed.push(renderInlineCode(part, `inline-${keyIdx}-${idx}`));
      } else if (part) {
        // Replace parentheses characters with colored spans
        const parenNodes = renderTextWithParens(
          part,
          `p-${keyIdx}-${idx}`,
        );
        mixed.push(...parenNodes);
      }
    });

    elements.push(
      <p key={`text-${keyIdx}`} className={pClassName} style={{textAlign: 'left'}}>
        {mixed}
      </p>,
    );
  };

  // Colector de secciones Mermaid (diagrama + resumen bajo botón)
  let pendingMermaid = null; // { code, summaryLines: [] }

  const flushMermaid = (keySuffix) => {
    if (!pendingMermaid) return;

    elements.push(
      <div key={`mermaid-${keySuffix}`} className="code-block-wrapper">
        <div className="mermaid-img-wrapper">
          <img
            className="mermaid-img"
            src={cardImageUrl || `https://mermaid.ink/img/${btoa(unescape(encodeURIComponent(pendingMermaid.code)))}?bgColor=!black`}
            alt="Diagrama"
            onError={(e) => {
              e.target.style.display = "none";
              e.target.nextSibling.style.display = "block";
            }}
          />
          <div className="mermaid-img-fallback" style={{ display: "none" }}>
            <SyntaxHighlighter
              language={"mermaid"}
              style={codeTheme}
              customStyle={{
                margin: "0",
                borderRadius: "0",
                fontSize: "1.1rem",
                lineHeight: "1.6",
                background: "#1e1e1e",
                padding: "16px 20px",
              }}
              wrapLongLines={true}
            >
              {pendingMermaid.code}
            </SyntaxHighlighter>
          </div>
        </div>
      </div>,
    );
    // Process summary lines through the normal pipeline for markdown/YouTube support
    pendingMermaid.summaryLines.forEach((line, i) => {
      processLine(line, `mermaid-summary-${keySuffix}-${i}`);
    });
    pendingMermaid = null;
  };

  // Procesa acumulador de bloque de código
  const flushCode = (keySuffix) => {
    if (codeLines.length === 0) return;
    const code = codeLines.join("\n");
    const lang = codeBlock || "text";
    codeLines = [];
    codeBlock = null;

    // Flush any pending mermaid before this new code block
    flushMermaid(`before-${keySuffix}`);

    if (lang === "mermaid") {
      pendingMermaid = { code, summaryLines: [] };
      return; // Don't render now – start collecting summary lines
    }

    elements.push(
      <div key={`code-${keySuffix}`} className="code-block-wrapper">
        <div className="code-block-header">
          <span className="code-lang-label">{lang}</span>
          <button
            className="copy-code-btn"
            onClick={(e) => {
              e.stopPropagation();
              const btn = e.currentTarget;
              const copyText = () => {
                if (navigator.clipboard && navigator.clipboard.writeText) {
                  return navigator.clipboard.writeText(code);
                }
                // Fallback para HTTP
                const ta = document.createElement("textarea");
                ta.value = code;
                ta.style.position = "fixed";
                ta.style.opacity = "0";
                document.body.appendChild(ta);
                ta.select();
                document.execCommand("copy");
                document.body.removeChild(ta);
                return Promise.resolve();
              };
              copyText().then(() => {
                btn.classList.add("copied");
                btn.textContent = "✓ Copiado";
                setTimeout(() => {
                  btn.classList.remove("copied");
                  btn.textContent = "Copiar";
                }, 2000);
              }).catch(() => {
                btn.textContent = "Error";
                setTimeout(() => {
                  btn.textContent = "Copiar";
                }, 2000);
              });
            }}
          >
            Copiar
          </button>
        </div>
        <SyntaxHighlighter
          language={lang}
          style={codeTheme}
          customStyle={{
            margin: "0",
            borderRadius: "0 0 8px 8px",
            fontSize: "1.1rem",
            lineHeight: "1.6",
            background: "#1e1e1e",
            padding: "16px 20px",
          }}
          wrapLongLines={false}
          showLineNumbers={isErrorCard && lang !== "text"}
          renderer={
            code.split("\n").some(
              (l) => l.includes("✅") || l.includes("❌") || /\berror\b/i.test(l),
            )
              ? (rendererArgs) => codeRenderer(rendererArgs, simpleHash(code))
              : undefined
          }
        >
          {code}
        </SyntaxHighlighter>
      </div>,
    );
  };

  let prevLineWasBlank = false;
  let tableLines = [];

  const flushTable = (keySuffix) => {
    if (tableLines.length === 0) return;
    const linesToProcess = [...tableLines];
    tableLines = [];

    // Parse rows: ignore separator lines like |---|---|
    const rows = linesToProcess
      .map((l) => l.trim())
      .filter((l) => !/^\|?\s*[-:]+[-| :]*\|?$/.test(l))
      .map((l) => {
        // Strip leading and trailing pipe
        let clean = l;
        if (clean.startsWith("|")) clean = clean.slice(1);
        if (clean.endsWith("|")) clean = clean.slice(0, -1);
        return clean.split("|").map((c) => c.trim());
      });

    if (rows.length === 0) return;
    const headerRow = rows[0];
    const bodyRows = rows.slice(1);

    elements.push(
      <div key={`table-wrapper-${keySuffix}`} className="card-table-container" style={{ overflowX: 'auto', margin: '14px 0' }}>
        <table className="card-table" style={{ width: '100%', borderCollapse: 'collapse', fontSize: '0.95rem', textAlign: 'left', background: 'rgba(0,0,0,0.5)', border: '1px solid rgba(255,255,255,0.12)', borderRadius: '8px', overflow: 'hidden' }}>
          <thead>
            <tr style={{ background: 'rgba(255,255,255,0.06)', borderBottom: '1px solid rgba(255,255,255,0.15)' }}>
              {headerRow.map((cell, ci) => (
                <th key={`th-${ci}`} style={{ padding: '10px 14px', color: '#5ac8fa', fontWeight: 600 }}>
                  {renderTextWithParens(cell, `th-txt-${ci}`)}
                </th>
              ))}
            </tr>
          </thead>
          <tbody>
            {bodyRows.map((row, ri) => (
              <tr key={`tr-${ri}`} style={{ borderBottom: ri < bodyRows.length - 1 ? '1px solid rgba(255,255,255,0.08)' : 'none', background: ri % 2 === 1 ? 'rgba(255,255,255,0.02)' : 'transparent' }}>
                {row.map((cell, ci) => (
                  <td key={`td-${ri}-${ci}`} style={{ padding: '10px 14px', color: '#e6edf3' }}>
                    {cell.includes('`')
                      ? cell.split(/`([^`]+)`/g).map((part, pi) => pi % 2 === 1 ? renderInlineCode(part, `td-code-${ri}-${ci}-${pi}`) : renderTextWithParens(part, `td-txt-${ri}-${ci}-${pi}`))
                      : renderTextWithParens(cell, `td-txt-${ri}-${ci}`)}
                  </td>
                ))}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  };

  lines.forEach((line, index) => {
    const trimmed = line.trim();
    const codeBlockStart = line.match(/^```(\w+)?$/);
    const codeBlockEnd = trimmed === "```";
    const isBlank = !trimmed;
    const isTableRow = /^\|.+\|$/.test(trimmed);

    // Si estamos recolectando resumen de un mermaid…
    if (pendingMermaid && !isBlank && !codeBlockStart) {
      // ¿Separador --- ? → fin de colección
      if (trimmed === "---" || trimmed === "___" || trimmed === "***") {
        flushMermaid(`sep-${index}`);
        return;
      }
      // Seguir recolectando líneas de texto
      pendingMermaid.summaryLines.push(line);
      prevLineWasBlank = false;
      return;
    }

    if (isTableRow && !codeBlock) {
      tableLines.push(line);
      prevLineWasBlank = false;
      return;
    } else if (tableLines.length > 0) {
      flushTable(index);
    }

    prevLineWasBlank = isBlank;

    if (codeBlockStart && !codeBlock) {
      codeBlock = codeBlockStart[1] || "text";
    } else if (codeBlockEnd && codeBlock) {
      flushCode(index);
    } else if (codeBlock) {
      codeLines.push(line);
    } else {
      processLine(line, index);
    }
  });

  flushTable("final");
  flushCode("final");
  flushMermaid("final");

  return elements;
};

export function CardContent({ text, cardImageUrl, codeTheme: _unused }) {
  return renderCardContent(text, cardImageUrl);
}
