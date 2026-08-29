import fs from 'fs';

const pCtrl = 'C:/Users/Pablo/Desktop/Pablo/java-visualizer/src/controller/VisualizerController.js';
let ctrlSrc = fs.readFileSync(pCtrl, 'utf8');

// Añadir soporte para loopMode
ctrlSrc = ctrlSrc.replace('this.playing = false', 'this.playing = false\n    this.loop = false');
ctrlSrc = ctrlSrc.replace('playing: this.playing,', 'playing: this.playing,\n      loop: this.loop,');

// Método toggleLoop
const loopMethods = `
  toggleLoop() {
    this.loop = !this.loop
    if (this.loop && !this.playing) {
      if (this.interpreter && this.interpreter.done) {
        this._reset(this.code)
      }
      this.play()
    }
    this.notify()
  }
`;
ctrlSrc = ctrlSrc.replace('togglePlay() {', loopMethods + '\n  togglePlay() {');

// En play(), si termina y está en loop, reiniciar y seguir
const oldTick = `        if (this.interpreter.done || !this.playing) {
          this.playing = false
          this.timer = null
          this.notify()
          return
        }`;

const newTick = `        if (this.interpreter.done) {
          if (this.loop && this.playing) {
            this.timer = setTimeout(() => {
              if (!this.playing || !this.loop) return
              this._reset(this.code)
              this.notify()
              this.timer = setTimeout(tick, this.speed)
            }, Math.max(600, this.speed))
            return
          }
          this.playing = false
          this.timer = null
          this.notify()
          return
        }
        if (!this.playing) {
          this.timer = null
          this.notify()
          return
        }`;

ctrlSrc = ctrlSrc.replace(oldTick, newTick);
fs.writeFileSync(pCtrl, ctrlSrc, 'utf8');
console.log('VisualizerController.js updated with toggleLoop support');

// 2. Actualizar ControlsBar.jsx (pantalla normal)
const pControlsBar = 'C:/Users/Pablo/Desktop/Pablo/java-visualizer/src/views/ControlsBar.jsx';
let barSrc = fs.readFileSync(pControlsBar, 'utf8');

barSrc = barSrc.replace('const playing = state.playing', 'const playing = state.playing\n  const loop = state.loop || false');
barSrc = barSrc.replace(
  '<button className="btn-control" onClick={() => controller.reset()} title="Reiniciar (S)">',
  `<button
          className={'btn-control' + (loop ? ' active' : '')}
          onClick={() => controller.toggleLoop()}
          style={{ background: loop ? '#8b5cf6' : '', color: loop ? '#fff' : '', borderColor: loop ? '#a78bfa' : '' }}
          title={loop ? 'Bucle activado (repetir siempre)' : 'Activar Bucle (L)'}
        >
          🔁 Bucle
        </button>
        <button className="btn-control" onClick={() => controller.reset()} title="Reiniciar (S)">`
);
fs.writeFileSync(pControlsBar, barSrc, 'utf8');
console.log('ControlsBar.jsx updated with loop button');

// 3. Actualizar FullscreenOverlay.jsx (pantalla completa)
const pOverlay = 'C:/Users/Pablo/Desktop/Pablo/java-visualizer/src/views/FullscreenOverlay.jsx';
let overlaySrc = fs.readFileSync(pOverlay, 'utf8');

overlaySrc = overlaySrc.replace('const playing = state ? state.playing : false', 'const playing = state ? state.playing : false\n  const loop = state ? state.loop : false');
overlaySrc = overlaySrc.replace(
  'if ((e.key === \'s\' || e.key === \'S\') && controller) { controller.reset() }',
  'if ((e.key === \'s\' || e.key === \'S\') && controller) { controller.reset() }\n      if ((e.key === \'l\' || e.key === \'L\') && controller) { controller.toggleLoop() }'
);

const oldOverlayBtns = `<button
                  style={{ background: '#da3633', color: '#fff', border: 'none', borderRadius: '50%', width: '32px', height: '32px', cursor: 'pointer', display: 'grid', placeItems: 'center', fontSize: '13px' }}
                  onClick={() => controller.reset()}
                  title="Reiniciar / Stop"
                >
                  ⏹
                </button>`;

const newOverlayBtns = `<button
                  style={{ background: '#da3633', color: '#fff', border: 'none', borderRadius: '50%', width: '32px', height: '32px', cursor: 'pointer', display: 'grid', placeItems: 'center', fontSize: '13px' }}
                  onClick={() => controller.reset()}
                  title="Reiniciar / Stop"
                >
                  ⏹
                </button>
                <button
                  style={{
                    background: loop ? '#8b5cf6' : 'rgba(255, 255, 255, 0.08)',
                    color: loop ? '#ffffff' : '#94a3b8',
                    border: loop ? '1px solid #a78bfa' : '1px solid rgba(255, 255, 255, 0.12)',
                    borderRadius: '999px',
                    padding: '0 12px',
                    height: '32px',
                    cursor: 'pointer',
                    display: 'flex',
                    alignItems: 'center',
                    gap: '5px',
                    fontSize: '12px',
                    fontWeight: '600'
                  }}
                  onClick={() => controller.toggleLoop()}
                  title="Bucle infinito (L)"
                >
                  🔁 Bucle {loop ? 'ON' : 'OFF'}
                </button>`;

overlaySrc = overlaySrc.replace(oldOverlayBtns, newOverlayBtns);
fs.writeFileSync(pOverlay, overlaySrc, 'utf8');
console.log('FullscreenOverlay.jsx updated with loop button and hotkey (L)');
