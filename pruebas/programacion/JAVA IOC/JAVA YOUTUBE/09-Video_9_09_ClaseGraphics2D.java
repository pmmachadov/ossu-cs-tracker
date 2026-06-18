import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * Video 9-09: Java Swing - Clase Graphics2D
 *
 * Tema 9: Metodos avanzados de dibujo con Graphics2D:
 * rotacion, escalado, BasicStroke, GradientPaint,
 * trazos discontinuos y figuras aleatorias.
 *
 * URL: https://www.youtube.com/watch?v=Ywl8WSyTSn4&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=202
 */
class Video_9_09_ClaseGraphics2D {

    static final String CONTENIDO = """
        ================================================================
          VIDEO 9-09 - CLASE GRAPHICS2D
        ================================================================

        Graphics2D extiende Graphics con metodos avanzados
        para dibujo y renderizado. Se obtiene haciendo casting:
          Graphics2D g2d = (Graphics2D) g;

        --- METODOS PRINCIPALES ---
        rotate(double theta)          -> rotacion (radianes, sentido horario)
        rotate(double theta, x, y)    -> rotacion desde un punto
        scale(double sx, double sy)   -> escalar coordenadas
        setStroke(Stroke s)           -> establecer el trazo
        setPaint(Paint p)             -> establecer pintura (color, gradiente)

        --- BASICSTROKE ---
        new BasicStroke(ancho)
        new BasicStroke(ancho, int cap, int join)
          cap: CAP_ROUND, CAP_SQUARE, CAP_BUTT
          join: JOIN_ROUND, JOIN_MITER, JOIN_BEVEL
        new BasicStroke(ancho, cap, join, miter, float[] dash, phase)
          dash: patron de discontinuidad {pintado, blanco, pintado, blanco...}
          phase: desplazamiento inicial del patron

        --- GRADIENTPAINT ---
        new GradientPaint(x1, y1, color1, x2, y2, color2)
        g2d.setPaint(gradient);
        Luego fillRect/fillOval usara el degradado.

        --- NOTA ---
        rotate y scale se APLICAN A PARTIR DE ESE MOMENTO
        a todo lo que se dibuje despues.
        ================================================================
        """;

    // ================================================================
    // EJEMPLO 1: Figuras con bordes, rotacion y escala
    // ================================================================
    static class PanelFigurasBordes extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Linea roja de ancho 5
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(5));
            g2d.drawLine(20, 30, 200, 30);

            // Rectangulo verde, rotado 5 grados, escalado x2
            g2d.setColor(Color.GREEN);
            g2d.setStroke(new BasicStroke(3));
            g2d.rotate(Math.toRadians(5));
            g2d.scale(2, 2);
            g2d.fillRect(50, 50, 150, 100);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(50, 50, 150, 100);
        }
    }

    // ================================================================
    // EJEMPLO 2: Bordes complejos con BasicStroke
    // ================================================================
    static class PanelFigurasBordesComplejos extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Trazo grueso con extremos y uniones redondeados
            g2d.setStroke(new BasicStroke(20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.setColor(Color.RED);
            g2d.drawLine(50, 80, 350, 80);

            // Gradiente diagonal rojo -> azul
            GradientPaint gradiente = new GradientPaint(
                50, 100, Color.RED, 350, 350, Color.BLUE);
            g2d.setPaint(gradiente);
            g2d.fillRect(50, 100, 300, 250);

            // Borde negro con mismo trazo grueso redondeado
            g2d.setColor(Color.BLACK);
            g2d.drawRect(50, 100, 300, 250);
        }
    }

    // ================================================================
    // EJEMPLO 3: Linea discontinua con patron
    // ================================================================
    static class PanelLineaDiscontinua extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Patron de discontinuidad: 20 pintado, 20 blanco, 10 pintado, 10 blanco
            float[] patron = {20, 20, 10, 10};
            g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_BEVEL, 1, patron, 0));

            g2d.setColor(Color.BLUE);
            g2d.drawLine(50, 50, 550, 50);
            g2d.drawRect(50, 80, 300, 200);
        }
    }

    // ================================================================
    // EJEMPLO 4: Figuras aleatorias con repaint()
    // ================================================================
    static class PanelFigurasAleatorias extends JPanel {
        private final Random random = new Random();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int ancho = getWidth();
            int alto = getHeight();
            int tam = Math.min(ancho, alto) - 40;
            int x = (ancho - tam) / 2;
            int y = (alto - tam) / 2;

            // Color aleatorio
            g2d.setColor(new Color(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256)));

            // Figura aleatoria
            int tipo = random.nextInt(5);
            switch (tipo) {
                case 0 -> g2d.fillOval(x, y, tam, tam);        // circulo
                case 1 -> g2d.fillRect(x, y, tam, tam);        // cuadrado
                case 2 -> {                                     // triangulo
                    Polygon t = new Polygon();
                    t.addPoint(x + tam/2, y);
                    t.addPoint(x, y + tam);
                    t.addPoint(x + tam, y + tam);
                    g2d.fillPolygon(t);
                }
                case 3 -> {                                     // pentagono
                    Polygon p = new Polygon();
                    for (int i = 0; i < 5; i++) {
                        double ang = Math.toRadians(i * 72 - 90);
                        p.addPoint((int)(x + tam/2 + tam/2 * Math.cos(ang)),
                                   (int)(y + tam/2 + tam/2 * Math.sin(ang)));
                    }
                    g2d.fillPolygon(p);
                }
                case 4 -> {                                     // hexagono
                    Polygon h = new Polygon();
                    for (int i = 0; i < 6; i++) {
                        double ang = Math.toRadians(i * 60 - 30);
                        h.addPoint((int)(x + tam/2 + tam/2 * Math.cos(ang)),
                                   (int)(y + tam/2 + tam/2 * Math.sin(ang)));
                    }
                    g2d.fillPolygon(h);
                }
            }
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // EJEMPLO 1: Bordes basicos + rotacion + escala
        JFrame v1 = new JFrame("Graphics2D: bordes, rotacion, escala");
        v1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v1.setSize(500, 400);
        v1.add(new PanelFigurasBordes());
        v1.setVisible(true);
        esperar(3000);

        // EJEMPLO 2: Bordes complejos + Gradiente
        JFrame v2 = new JFrame("Graphics2D: gradiente y bordes complejos");
        v2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v2.setSize(500, 450);
        v2.add(new PanelFigurasBordesComplejos());
        v2.setVisible(true);
        esperar(3000);

        // EJEMPLO 3: Linea discontinua
        JFrame v3 = new JFrame("Graphics2D: linea discontinua");
        v3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v3.setSize(600, 350);
        v3.add(new PanelLineaDiscontinua());
        v3.setVisible(true);
        esperar(3000);

        // EJEMPLO 4: Figuras aleatorias con repaint cada 500ms
        JFrame v4 = new JFrame("Graphics2D: figuras aleatorias con repaint()");
        v4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v4.setSize(400, 400);
        PanelFigurasAleatorias panelAleatorio = new PanelFigurasAleatorias();
        v4.add(panelAleatorio);
        v4.setVisible(true);

        Timer timer = new Timer(500, e -> panelAleatorio.repaint());
        timer.start();
        esperar(5000);

        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 9 - V09: CLASE GRAPHICS2D)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Graphics2D g2d = (Graphics2D) g;  (casting obligatorio)");
        System.out.println("  - rotate(theta): rotar en sentido horario (radianes)");
        System.out.println("  - scale(sx, sy): escalar coordenadas (se acumula)");
        System.out.println("  - BasicStroke: ancho, cap (extremos), join (uniones)");
        System.out.println("  - CAP_ROUND, CAP_SQUARE, CAP_BUTT: tipo de extremo");
        System.out.println("  - JOIN_ROUND, JOIN_MITER, JOIN_BEVEL: tipo de union");
        System.out.println("  - GradientPaint: degradado entre dos colores");
        System.out.println("  - setPaint(gradient): aplicar degradado");
        System.out.println("  - Patron discontinuo: float[] {pintado, blanco, ...}");
        System.out.println("  - repaint() + Timer: animaciones periodicas");
    }

    static void esperar(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }
}
