import { useState, useEffect } from "react";
import "./ServerTray.css";

const SERVER_CHECK_URLS = [
  { port: 5173, label: "Vite (AnkiCards)", url: "http://localhost:5173" },
  { port: 4173, label: "Vite Preview", url: "http://localhost:4173" },
  { port: 3000, label: "Node", url: "http://localhost:3000" },
  { port: 8080, label: "HTTP", url: "http://localhost:8080" },
  { port: 5000, label: "Flask/Express", url: "http://localhost:5000" },
];

async function checkPort(entry) {
  try {
    const res = await fetch(entry.url, { method: "HEAD", signal: AbortSignal.timeout(2000) });
    return { ...entry, alive: true, status: res.status };
  } catch {
    return { ...entry, alive: false };
  }
}

export function ServerTray() {
  const [open, setOpen] = useState(false);
  const [servers, setServers] = useState([]);
  const [scanning, setScanning] = useState(false);

  const scan = async () => {
    setScanning(true);
    const results = await Promise.all(SERVER_CHECK_URLS.map(checkPort));
    setServers(results.filter((s) => s.alive));
    setScanning(false);
  };

  useEffect(() => {
    if (open) scan();
  }, [open]);

  const stopServer = async (entry) => {
    try {
      await fetch(`${entry.url}/__shutdown`, { method: "POST" });
      setServers((prev) => prev.filter((s) => s.port !== entry.port));
    } catch {
      // Si el server ya murio, lo quitamos igual
      setServers((prev) => prev.filter((s) => s.port !== entry.port));
    }
  };

  const closeAll = async () => {
    const promises = servers.map((s) =>
      fetch(`${s.url}/__shutdown`, { method: "POST" }).catch(() => {}),
    );
    await Promise.all(promises);
    setServers([]);
  };

  return (
    <div className={`server-tray ${open ? "open" : ""}`}>
      <button className="server-tray-toggle" onClick={() => setOpen(!open)} title="Servidores locales">
        <span className="tray-dot" />
        <span className="tray-label">{open ? "Servidores" : `${servers.length} activo${servers.length !== 1 ? "s" : ""}`}</span>
      </button>

      {open && (
        <div className="server-tray-panel">
          <div className="tray-panel-header">
            <span>Servidores locales</span>
            <div className="tray-panel-actions">
              {servers.length > 1 && (
                <button className="tray-btn tray-btn-danger" onClick={closeAll} title="Cerrar todos">
                  Cerrar todos
                </button>
              )}
              <button className="tray-btn tray-btn-scan" onClick={scan} disabled={scanning}>
                {scanning ? "..." : "Escanear"}
              </button>
            </div>
          </div>

          {servers.length === 0 && (
            <div className="tray-empty">
              <p>Ningún servidor local detectado</p>
              <button className="tray-btn" onClick={scan}>Escanear ahora</button>
            </div>
          )}

          <div className="tray-server-list">
            {servers.map((s) => (
              <div key={s.port} className="tray-server-item">
                <div className="tray-server-info">
                  <span className="tray-server-name">{s.label}</span>
                  <a
                    href={s.url}
                    target="_blank"
                    rel="noreferrer"
                    className="tray-server-url"
                  >
                    {s.url}
                  </a>
                  <span className="tray-server-status">HTTP {s.status}</span>
                </div>
                <button
                  className="tray-btn tray-btn-stop"
                  onClick={() => stopServer(s)}
                  title="Detener servidor"
                >
                  Detener
                </button>
              </div>
            ))}
          </div>
        </div>
      )}
    </div>
  );
}
