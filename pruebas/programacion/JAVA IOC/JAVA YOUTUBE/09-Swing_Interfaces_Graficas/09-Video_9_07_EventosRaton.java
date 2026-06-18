import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Video 9-07: Java Swing - Eventos de raton (MouseListener)
 *
 * Tema 9: Capturar eventos del raton sobre componentes Swing.
 * MouseListener con 5 metodos: clicked, pressed, released,
 * entered, exited.
 *
 * URL: https://www.youtube.com/watch?v=e5DdHf45GzQ&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=200
 */
class Video_9_07_EventosRaton {

    static final String RUTA = "aulaenlanube/tema9/imagenes/";

    static final String CONTENIDO = """
        ================================================================
          VIDEO 9-07 - EVENTOS DE RATON (MOUSELISTENER)
        ================================================================

        MouseListener permite capturar eventos del raton.

        --- 5 METODOS DE MOUSELISTENER ---
        1. mouseClicked(MouseEvent e) -> clic completo (pulsar+soltar
            SIN mover el cursor)
        2. mousePressed(MouseEvent e) -> se pulsa el boton
        3. mouseReleased(MouseEvent e) -> se suelta el boton
            (aunque sea fuera del componente)
        4. mouseEntered(MouseEvent e) -> el cursor entra en el componente
        5. mouseExited(MouseEvent e)  -> el cursor sale del componente

        ORDEN: mousePressed -> mouseReleased -> mouseClicked
        (mouseClicked solo si no se movio el cursor entre pulsar y soltar)

        --- METODOS DE MouseEvent ---
        getX() -> coordenada X relativa al componente
        getY() -> coordenada Y relativa al componente

        --- IMPORTANTE ---
        MouseListener NO es funcional (tiene 5 metodos).
        No se puede usar lambda. Solo clase anonima o separada.
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        JFrame ventana = new JFrame("Eventos de raton");
        ventana.setSize(800, 500);
        ventana.setLayout(new FlowLayout());

        try {
            BufferedImage imgOriginal = ImageIO.read(
                new java.io.File(RUTA + "java_logo.png"));
            Image img1 = imgOriginal.getScaledInstance(
                300, 300, Image.SCALE_FAST);
            Image img2 = imgOriginal.getScaledInstance(
                300, 300, Image.SCALE_SMOOTH);

            JLabel labelImagen1 = new JLabel(new ImageIcon(img1));
            JLabel labelImagen2 = new JLabel(new ImageIcon(img2));

            // ============================================================
            // Anadir MouseListener a la primera imagen
            // ============================================================
            labelImagen1.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("  mouseClicked en imagen izquierda en coordenadas ("
                        + e.getX() + ", " + e.getY() + ")");
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    System.out.println("  mousePressed: has pulsado el boton en la imagen izquierda");
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    System.out.println("  mouseReleased: has soltado el boton del raton");
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    System.out.println("  mouseEntered: has entrado en la imagen IZQUIERDA");
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    System.out.println("  mouseExited: has salido de la imagen IZQUIERDA");
                }
            });

            // ============================================================
            // Anadir MouseListener a la segunda imagen
            // ============================================================
            labelImagen2.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("  mouseClicked en imagen derecha en coordenadas ("
                        + e.getX() + ", " + e.getY() + ")");
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    System.out.println("  mousePressed: has pulsado el boton en la imagen derecha");
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    System.out.println("  mouseReleased: has soltado el boton del raton");
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    System.out.println("  mouseEntered: has entrado en la imagen DERECHA");
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    System.out.println("  mouseExited: has salido de la imagen DERECHA");
                }
            });

            ventana.add(labelImagen1);
            ventana.add(labelImagen2);

        } catch (IOException e) {
            System.out.println("  Error al cargar imagen: " + e.getMessage());
        }

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

        System.out.println("  (Prueba los eventos del raton sobre las imagenes)");
        System.out.println();
        System.out.println("  Orden de eventos al hacer clic:");
        System.out.println("    1. mousePressed");
        System.out.println("    2. mouseReleased");
        System.out.println("    3. mouseClicked (solo si no moviste el cursor)");
        System.out.println();

        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 9 - V07: EVENTOS DE RATON)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - MouseListener: 5 metodos (clicked, pressed, released, entered, exited)");
        System.out.println("  - No es funcional -> no se puede usar lambda");
        System.out.println("  - mouseClicked: solo si pulsas y sueltas SIN mover");
        System.out.println("  - mouseReleased: se dispara aunque sueltes fuera");
        System.out.println("  - mouseEntered/Exited: al entrar/salir del componente");
        System.out.println("  - getX() / getY(): coordenadas relativas al componente");
        System.out.println("  - Proximo video: Ejercicios avanzados Swing");
    }
}
