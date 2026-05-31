import { Prism as SyntaxHighlighter } from "react-syntax-highlighter";
import { shadesOfPurple } from "react-syntax-highlighter/dist/esm/styles/prism";
import { YouTubeEmbed } from "./YouTubeEmbed";

// Tema personalizado: mismo que shadesOfPurple pero con comentarios en celeste
export const codeTheme = {
  ...shadesOfPurple,
  'comment': { color: '#7ec8e3', fontStyle: 'italic' },
  'prolog': { color: '#7ec8e3' },
  'doctype': { color: '#7ec8e3' },
  'cdata': { color: '#7ec8e3' },
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

// Renderiza código inline con estilo VSCode
const renderInlineCode = (code, key) => (
  <code key={key} className="inline-code">
    {code}
  </code>
);

// Render text and wrap different parentheses types with colored spans
const renderTextWithParens = (text, baseKey) => {
  if (!text) return [];
  // Split keeping parentheses characters
  const tokens = text.split(/([()\[\]{}<>])/g);
  return tokens
    .map((t, i) => {
      if (!t) return null;
      const key = `${baseKey}-${i}`;
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
};

// Función para procesar texto y resaltar código
const renderCardContent = (text, cardImageUrl) => {
  if (!text) return null;

  const normalized = normalizeText(text);
  const lines = normalized.split("\n");
  const elements = [];
  let codeBlock = null;
  let codeLines = [];

  // Procesa una línea de texto como párrafo individual
  const processLine = (line, keyIdx) => {
    if (!line.trim()) return;

    // Procesa enlaces markdown [texto](url) ANTES de dividir por paréntesis
    const mdLinkRegex = /\[([^\]]+)\]\(([^)]+)\)/g;
    const linkParts = [];
    let lastMdIdx = 0;
    let mdMatch;
    while ((mdMatch = mdLinkRegex.exec(line)) !== null) {
      if (mdMatch.index > lastMdIdx) {
        linkParts.push(line.slice(lastMdIdx, mdMatch.index));
      }
      linkParts.push({ type: "link", text: mdMatch[1], url: mdMatch[2] });
      lastMdIdx = mdMatch.index + mdMatch[0].length;
    }
    if (lastMdIdx < line.length) {
      linkParts.push(line.slice(lastMdIdx));
    }

    const isSubtitle = /^(?:[¿¡]?[A-ZÁÉÍÓÚÑ]|\d+\.\s*)[A-Za-zÁÉÍÓÚÑáéíóúñ0-9 (),./@]{0,70}[:?]$/.test(line.trim());
    const pClassName = isSubtitle ? "card-text-paragraph card-subtitle" : "card-text-paragraph";

    // Si hay enlaces markdown, usa el nuevo pipeline
    if (linkParts.some((p) => typeof p === "object")) {
      const mixed = linkParts.map((part, lpi) => {
        if (typeof part === "object" && part.type === "link") {
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
    const parts = line.split(/`([^`]+)`/g);
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
          wrapLongLines={true}
        >
          {code}
        </SyntaxHighlighter>
      </div>,
    );
  };

  let prevLineWasBlank = false;
  lines.forEach((line, index) => {
    const trimmed = line.trim();
    const codeBlockStart = line.match(/^```(\w+)?$/);
    const codeBlockEnd = trimmed === "```";
    const isBlank = !trimmed;

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

  flushCode("final");
  flushMermaid("final");

  return elements;
};

export function CardContent({ text, cardImageUrl, codeTheme: _unused }) {
  return renderCardContent(text, cardImageUrl);
}
