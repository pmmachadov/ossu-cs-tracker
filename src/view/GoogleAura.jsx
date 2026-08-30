import React from 'react'
import { motion } from 'motion/react'

/**
 * GoogleAura: Efecto de haz de luz líquido y estela iridiscente estilo Apple Intelligence / Linear.
 * Produce un brillo sedoso y elegante sin artefactos toscos.
 */
export function GoogleAura({ 
  duration = 4, 
  delay = 0, 
  opacity = 0.4,
  className = '' 
}) {
  return (
    <div 
      className={`google-aurora-beam ${className}`}
      style={{
        position: 'absolute',
        inset: '-1px',
        borderRadius: 'inherit',
        pointerEvents: 'none',
        zIndex: 0,
        overflow: 'hidden'
      }}
      aria-hidden="true"
    >
      {/* Halo de luz suave sedoso que respira en sincronía */}
      <motion.div
        style={{
          position: 'absolute',
          inset: 0,
          borderRadius: 'inherit',
          background: 'radial-gradient(ellipse at 50% 50%, rgba(66, 133, 244, 0.15) 0%, transparent 70%)',
          pointerEvents: 'none'
        }}
        animate={{
          opacity: [0.2, 0.45, 0.2],
          scale: [0.99, 1.01, 0.99]
        }}
        transition={{
          duration: duration * 1.2,
          repeat: Infinity,
          ease: 'easeInOut',
          delay
        }}
      />
    </div>
  )
}
