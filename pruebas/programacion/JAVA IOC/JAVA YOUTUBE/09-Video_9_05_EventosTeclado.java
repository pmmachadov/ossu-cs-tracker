import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Video 9-05: Java Swing - Eventos de teclado (KeyListener)
 *
 * Tema 9: Capturar eventos del teclado con KeyListener.
 * keyPressed, keyTyped, keyReleased y deteccion de teclas
 * especiales (flechas, etc.).
 *
 * URL: https://www.youtube.com/watch?v=fxJgVGVFwZk&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=198
 */
class Video_9_05_EventosTeclado {

    static final String CONTENIDO = """
        ================================================================
          VIDEO 9-05 - EVENTOS DE TECLADO (KEYLISTENER)
        ================================================================

        KeyListener permite capturar eventos del teclado.

        --- 3 METODOS DE KEYLISTENER ---
        1. keyPressed(KeyEvent e)  -> se pulsa UNA TECLA (cualquiera)
        2. keyTyped(KeyEvent e)    -> se pulsa una tecla que genera
                                      un CARACTER UNICODE (letras, numeros...)
                                      NO se invoca para teclas especiales
                                      (Ctrl, Shift, flechas...)
        3. keyReleased(KeyEvent e) -> se suelta la tecla

        ORDEN DE EJECUCION:
          keyPressed -> keyTyped -> keyReleased

        --- METODOS DE KeyEvent ---
        getKeyCode() -> codigo numerico de la tecla (VK_...)
        getKeyChar()-> caracter Unicode de la tecla pulsada

        --- CONSTANTES (VK = Virtual Key) ---
        KeyEvent.VK_UP    -> flecha arriba
        KeyEvent.VK_DOWN  -> flecha abajo
        KeyEvent.VK_LEFT  -> flecha izquierda
        KeyEvent.VK_RIGHT -> flecha derecha
        KeyEvent.VK_ENTER -> tecla Enter
        KeyEvent.VK_ESCAPE -> tecla Escape
        ... y muchas mas

        --- IMPORTANTE ---
        KeyListener NO es una interfaz funcional (tiene 3 metodos).
        NO se puede usar lambda. Solo clase separada o anonima.
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        JFrame ventana = new JFrame("Eventos de teclado");
        ventana.setSize(500, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Anadir KeyListener con clase anonima (no se puede usar lambda)
        ventana.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                int codigo = e.getKeyCode();

                // Detectar teclas de flecha
                if (codigo == KeyEvent.VK_UP) {
                    System.out.println("  keyPressed: FLECHA ARRIBA");
                } else if (codigo == KeyEvent.VK_DOWN) {
                    System.out.println("  keyPressed: FLECHA ABAJO");
                } else if (codigo == KeyEvent.VK_LEFT) {
                    System.out.println("  keyPressed: FLECHA IZQUIERDA");
                } else if (codigo == KeyEvent.VK_RIGHT) {
                    System.out.println("  keyPressed: FLECHA DERECHA");
                } else if (codigo == KeyEvent.VK_ENTER) {
                    System.out.println("  keyPressed: ENTER");
                } else if (codigo == KeyEvent.VK_ESCAPE) {
                    System.out.println("  keyPressed: ESCAPE");
                }
                // NOTA: getKeyChar() aqui puede no devolver el caracter esperado
                // para teclas especiales, usar getKeyCode()
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // keyTyped SOLO se ejecuta para caracteres Unicode
                // NO se ejecuta para Ctrl, flechas, etc.
                char caracter = e.getKeyChar();
                System.out.println("  keyTyped: has escrito '" + caracter + "'");
                System.out.println("    (codigo Unicode: " + (int) caracter + ")");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("  keyReleased: has soltado tecla (codigo: "
                    + e.getKeyCode() + ")");
            }
        });

        ventana.setVisible(true);

        System.out.println("  (Pulsa teclas en la ventana para ver los eventos)");
        System.out.println("  NOTA: La ventana debe tener foco.");
        System.out.println("  Prueba letras, numeros, flechas, Enter, Escape...");
        System.out.println();
        System.out.println("  Orden de eventos: keyPressed -> keyTyped -> keyReleased");
        System.out.println("  keyTyped SOLO para caracteres Unicode (no flechas!)");
        System.out.println();

        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 9 - V05: EVENTOS DE TECLADO)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - KeyListener: 3 metodos (pressed, typed, released)");
        System.out.println("  - No es funcional -> no se puede usar lambda");
        System.out.println("  - keyTyped: solo para caracteres Unicode");
        System.out.println("  - keyPressed: cualquier tecla (flechas, Ctrl, etc.)");
        System.out.println("  - getKeyCode(): codigo de la tecla (VK_UP, VK_DOWN...)");
        System.out.println("  - getKeyChar(): caracter Unicode (solo en keyTyped)");
        System.out.println("  - addKeyListener(componente): registrar el listener");
        System.out.println("  - Proximo video: Eventos de raton");
    }
}
