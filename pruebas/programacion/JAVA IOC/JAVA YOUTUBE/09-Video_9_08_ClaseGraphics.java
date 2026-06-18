import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Video 9-08: Java Swing - Clase Graphics
 *
 * Tema 9: Dibujar formas, texto, colores y fuentes
 * usando la clase Graphics en el metodo paintComponent().
 *
 * URL: https://www.youtube.com/watch?v=-j4ZuT6YYMo&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=201
 */
class Video_9_08_ClaseGraphics {

    static final String CONTENIDO = """
        ================================================================
          VIDEO 9-08 - CLASE GRAPHICS EN SWING
        ================================================================

        La clase Graphics (java.awt.Graphics) es el contexto grafico
        sobre el que se dibuja en los componentes Swing.

        --- METODO paintComponent(Graphics g) ---
        Se invoca AUTOMATICAMENTE cuando:
          - El componente se hace visible por primera vez
          - Se redimensiona la ventana
          - Se invoca repaint() explicitamente

        Siempre llamar a super.paintComponent(g) al inicio.

        --- METODO repaint() ---
        Solicita a Swing que repinte el componente.
        No llama directamente a paintComponent(), Swing decide cuando.

        --- METODOS PRINCIPALES DE Graphics ---
        setColor(Color c) / getColor()
        setFont(Font f) / getFont()
        drawString(String str, int x, int y)
        drawLine(int x1, int y1, int x2, int y2)
        drawRect(int x, int y, int w, int h)
        fillRect(int x, int y, int w, int h)
        drawOval(int x, int y, int w, int h)
        fillOval(int x, int y, int w, int h)
        drawPolygon(Polygon p)
        fillPolygon(Polygon p)

        --- CLASE Color ---
        Color.RED, Color.GREEN, Color.BLUE, Color.BLACK...
        new Color(int r, int g, int b) -> 0-255 cada uno

        --- CLASE Font ---
        new Font("Arial", Font.BOLD, 18)

        --- CLASE Polygon ---
        Polygon p = new Polygon();
        p.addPoint(x, y);

        --- CLASE Timer ---
        Timer(int delay, ActionListener listener)
        timer.start() -> ejecuta cada 'delay' milisegundos
        Ideal para animaciones (ej: reloj en tiempo real)
        ================================================================
        """;

    // ================================================================
    // EJEMPLO 1: Dibujar figuras con colores
    // ================================================================
    static class PanelFiguras extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Linea en rojo
            g.setColor(Color.RED);
            g.drawLine(20, 30, 200, 30);

            // Rectangulo en verde (sin relleno)
            g.setColor(Color.GREEN);
            g.drawRect(50, 50, 200, 100);

            // Ovalo en azul (relleno)
            g.setColor(Color.BLUE);
            g.fillOval(220, 50, 150, 100);

            // Triangulo en magenta (relleno)
            Polygon triangulo = new Polygon();
            triangulo.addPoint(50, 250);
            triangulo.addPoint(150, 180);
            triangulo.addPoint(250, 250);
            g.setColor(Color.MAGENTA);
            g.fillPolygon(triangulo);

            // Texto con fuente personalizada
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString("Figuras en Swing", 50, 320);
        }
    }

    // ================================================================
    // EJEMPLO 2: Reloj en tiempo real (con Timer + repaint)
    // ================================================================
    static class PanelReloj extends JPanel {
        private String textoHora = "";

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Obtener hora actual
            LocalTime ahora = LocalTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
            textoHora = ahora.format(formato);

            // Dibujar el texto con la hora
            g.setFont(new Font("Arial", Font.BOLD, 18));
            g.setColor(Color.BLUE);
            g.drawString("Hola, mundo. Son las " + textoHora, 50, 50);
        }
    }

    // ================================================================
    // EJEMPLO 3: Figuras rellenas (fillRect, fillOval, fillPolygon)
    // ================================================================
    static class PanelFigurasRellenas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Rectangulo relleno en rojo
            g.setColor(Color.RED);
            g.fillRect(30, 30, 150, 100);

            // Ovalo relleno en verde
            g.setColor(Color.GREEN);
            g.fillOval(200, 30, 150, 100);

            // Poligono relleno (hexagono)
            Polygon hexagono = new Polygon();
            hexagono.addPoint(100, 180);
            hexagono.addPoint(160, 200);
            hexagono.addPoint(160, 260);
            hexagono.addPoint(100, 280);
            hexagono.addPoint(40, 260);
            hexagono.addPoint(40, 200);
            g.setColor(Color.ORANGE);
            g.fillPolygon(hexagono);
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // EJEMPLO 1: Figuras con colores
        JFrame ventana1 = new JFrame("Figuras con Graphics");
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana1.setSize(450, 400);
        ventana1.add(new PanelFiguras());
        ventana1.setVisible(true);
        esperar(3000);

        // EJEMPLO 2: Reloj con Timer + repaint
        JFrame ventana2 = new JFrame("Reloj con repaint() y Timer");
        ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana2.setSize(450, 150);
        PanelReloj panelReloj = new PanelReloj();
        ventana2.add(panelReloj);
        ventana2.setVisible(true);

        // Timer que actualiza cada segundo
        Timer reloj = new Timer(1000, e -> panelReloj.repaint());
        reloj.start();
        esperar(5000);

        // EJEMPLO 3: Figuras rellenas
        JFrame ventana3 = new JFrame("Figuras rellenas");
        ventana3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana3.setSize(400, 380);
        ventana3.add(new PanelFigurasRellenas());
        ventana3.setVisible(true);
        esperar(3000);

        System.out.println();
        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 9 - V08: CLASE GRAPHICS EN SWING)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Graphics: contexto grafico para dibujar en componentes");
        System.out.println("  - paintComponent(g): se invoca automaticamente al redibujar");
        System.out.println("  - super.paintComponent(g): llamada obligatoria al inicio");
        System.out.println("  - repaint(): solicita a Swing que repinte el componente");
        System.out.println("  - setColor / setFont: configuran el contexto grafico");
        System.out.println("  - drawLine, drawRect, drawOval, drawPolygon: contornos");
        System.out.println("  - fillRect, fillOval, fillPolygon: formas rellenas");
        System.out.println("  - Polygon: figura con puntos anadidos con addPoint()");
        System.out.println("  - Timer: animaciones periodicas con repaint()");
        System.out.println("  - Proximo video: Graphics2D (metodos avanzados)");
    }

    static void esperar(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }
}
