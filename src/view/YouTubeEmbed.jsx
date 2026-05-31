import { useState } from "react";

export function YouTubeEmbed({ videoId, label, stopPropagation }) {
  const [loaded, setLoaded] = useState(false);
  const handleClick = (e) => {
    e.stopPropagation();
    setLoaded(true);
  };
  if (loaded) {
    return (
      <div className="youtube-embed-wrapper" onClick={(e) => e.stopPropagation()}>
        <iframe
          className="youtube-embed"
          src={`https://www.youtube.com/embed/${videoId}?rel=0&autoplay=1`}
          title={label}
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          allowFullScreen
        />
      </div>
    );
  }
  return (
    <div className="youtube-thumb-link" onClick={handleClick}>
      <div className="youtube-thumb-wrapper">
        <img
          className="youtube-thumb"
          src={`https://img.youtube.com/vi/${videoId}/mqdefault.jpg`}
          alt={label}
          loading="lazy"
        />
        <div className="youtube-play-overlay">
          <svg viewBox="0 0 68 48" className="youtube-play-icon">
            <path d="M66.52,7.74c-0.78-2.93-2.49-5.41-5.42-6.19C55.79,.13,34,0,34,0S12.21,.13,6.9,1.55 C3.97,2.33,2.27,4.81,1.48,7.74C0.06,13.05,0,24,0,24s0.06,10.95,1.48,16.26c0.78,2.93,2.49,5.41,5.42,6.19 C12.21,47.87,34,48,34,48s21.79-0.13,27.1-1.55c2.93-0.78,4.64-3.26,5.42-6.19C67.94,34.95,68,24,68,24S67.94,13.05,66.52,7.74z" fill="#212121" fillOpacity="0.8"/>
            <path d="M 45,24 27,14 27,34" fill="#fff"/>
          </svg>
        </div>
        <span className="youtube-thumb-label">{label}</span>
      </div>
    </div>
  );
}
