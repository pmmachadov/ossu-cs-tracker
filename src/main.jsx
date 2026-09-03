import React from 'react'
import ReactDOM from 'react-dom/client'
import { Toaster } from 'react-hot-toast'
import App from './App.jsx'
import './index.css'
import { startRandomSpeedManager } from './view/randomSpeedManager.js'

if (localStorage.getItem("google_borders_visible") !== "false") {
  startRandomSpeedManager();
} else {
  document.body.classList.add("google-borders-hidden");
}

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <App />
    <Toaster
      position="top-center"
      toastOptions={{
        style: {
          background: '#1c2128',
          color: '#f5f5f7',
          border: '1px solid rgba(255,255,255,0.12)',
          borderRadius: '12px',
        },
      }}
    />
  </React.StrictMode>,
)
