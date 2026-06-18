import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * Video 9-06: Java Swing - Imagenes e iconos
 *
 * Tema 9: Incluir imagenes e iconos en componentes Swing.
 * ImageIcon, JLabel con imagen, JButton con icono,
 * escalado de imagenes y JPanel con paintComponent.
 *
 * URL: https://www.youtube.com/watch?v=R98K2NnFbXY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=199
 */
class Video_9_06_ImagenesEIconos {

    static final String RUTA = "aulaenlanube/tema9/imagenes/";

    static final String CONTENIDO = """
        ================================================================
          VIDEO 9-06 - IMAGENES E ICONOS EN SWING
        ================================================================

        ImageIcon: clase para cargar imagenes (PNG, JPG, GIF).
        Se puede usar en JLabel, JButton, JPanel, etc.

        --- CONSTRUCTORES ---
        new ImageIcon(String ruta)   -> desde archivo
        new ImageIcon(URL url)       -> desde internet
        new ImageIcon(Image image)   -> desde una Image

        --- IMAGEICON EN COMPONENTES ---
        new JLabel(new ImageIcon("imagen.png"))
        new JButton("Texto", new ImageIcon("icono.png"))

        --- ESCALADO DE IMAGENES ---
        Image original = ImageIO.read(new File("ruta"));
        Image escalada = original.getScaledInstance(
            ancho, alto, Image.SCALE_SMOOTH);

        Modos de escalado:
          SCALE_DEFAULT      -> algoritmo por defecto
          SCALE_FAST         -> prioriza velocidad (pixelado)
          SCALE_SMOOTH       -> prioriza calidad (suave)
          SCALE_REPLICATE    -> replica pixeles
          SCALE_AREA_AVERAGING -> promedio de area

        --- JPANEL CON PAINTCOMPONENT ---
        Se sobrescribe paintComponent(Graphics g) para
        dibujar imagenes directamente en un panel.
        g.drawImage(imagen, x, y, ancho, alto, observer);

        --- IMAGEN DESDE URL ---
        BufferedImage img = ImageIO.read(new URL("https://..."));
        ================================================================
        """;

    // ================================================================
    // EJEMPLO 1: Boton con icono
    // ================================================================
    static void ejemploBotonConIcono() {
        JFrame ventana = new JFrame("Boton con icono");
        ventana.setSize(500, 200);
        ventana.setLayout(new FlowLayout());

        ImageIcon icono = new ImageIcon(RUTA + "icono_aulaenlanube.png");
        JButton boton = new JButton("Pulsa aqui", icono);
        boton.setFocusable(false);  // quita el borde de foco
        boton.addActionListener(e ->
            System.out.println("  Has pulsado el boton con el icono"));

        ventana.add(boton);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    // ================================================================
    // EJEMPLO 2: JLabel con imagen escalada
    // ================================================================
    static void ejemploLabelConImagenEscalada() {
        JFrame ventana = new JFrame("Label con imagen escalada");
        ventana.setSize(500, 500);
        ventana.setLayout(new FlowLayout());

        try {
            BufferedImage imagenOriginal = ImageIO.read(
                new java.io.File(RUTA + "java_logo.png"));
            Image imagenEscalada = imagenOriginal.getScaledInstance(
                300, 300, Image.SCALE_SMOOTH);

            JLabel label = new JLabel(new ImageIcon(imagenEscalada));
            ventana.add(label);
        } catch (IOException e) {
            System.out.println("  Error al cargar imagen: " + e.getMessage());
        }

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    // ================================================================
    // EJEMPLO 3: Comparacion SCALE_FAST vs SCALE_SMOOTH
    // ================================================================
    static void ejemploComparacionEscalado() {
        JFrame ventana = new JFrame("Comparacion de escalado");
        ventana.setSize(600, 400);
        ventana.setLayout(new FlowLayout());

        try {
            BufferedImage imgOrg = ImageIO.read(
                new java.io.File(RUTA + "java_logo.png"));
            Image imgFast = imgOrg.getScaledInstance(
                200, 200, Image.SCALE_FAST);
            Image imgSmooth = imgOrg.getScaledInstance(
                200, 200, Image.SCALE_SMOOTH);

            ventana.add(new JLabel(new ImageIcon(imgFast)));
            ventana.add(new JLabel(new ImageIcon(imgSmooth)));
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    // ================================================================
    // EJEMPLO 4: Imagen desde URL
    // ================================================================
    static void ejemploImagenDesdeURL() {
        JFrame ventana = new JFrame("Imagen desde URL");
        ventana.setSize(600, 400);
        ventana.setLayout(new FlowLayout());

        try {
            URL url = new URL("https://upload.wikimedia.org/wikipedia/"
                + "en/3/30/Java_programming_language_logo.svg.png");
            BufferedImage imgOriginal = ImageIO.read(url);
            Image imgEscalada = imgOriginal.getScaledInstance(
                200, 200, Image.SCALE_SMOOTH);

            ventana.add(new JLabel(new ImageIcon(imgEscalada)));
        } catch (IOException e) {
            System.out.println("  Error al cargar imagen desde URL: " + e.getMessage());
        }

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    // ================================================================
    // EJEMPLO 5: JPanel con paintComponent
    // ================================================================
    static void ejemploPanelConPaint() {
        JFrame ventana = new JFrame("Panel con paintComponent");
        ventana.setSize(600, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            BufferedImage img = ImageIO.read(
                new java.io.File(RUTA + "java_logo.png"));

            // Panel personalizado que dibuja la imagen
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Dibujar imagen escalada al tamano del panel
                    // this.getWidth() y this.getHeight() = tamano del panel
                    g.drawImage(img, 0, 0,
                        this.getWidth(), this.getHeight(), this);
                }
            };

            ventana.add(panel);
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }

        ventana.setVisible(true);
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        System.out.println("================================================");
        System.out.println("  EJEMPLOS DE IMAGENES E ICONOS EN SWING");
        System.out.println("================================================");
        System.out.println();
        System.out.println("  Las ventanas se abriran una tras otra.");
        System.out.println("  Cierra cada ventana para ver la siguiente.");
        System.out.println();

        System.out.println("  --- EJEMPLO 1: Boton con icono ---");
        ejemploBotonConIcono();
        esperar();

        System.out.println("  --- EJEMPLO 2: JLabel con imagen escalada ---");
        ejemploLabelConImagenEscalada();
        esperar();

        System.out.println("  --- EJEMPLO 3: Comparacion SCALE_FAST vs SCALE_SMOOTH ---");
        ejemploComparacionEscalado();
        esperar();

        System.out.println("  --- EJEMPLO 4: Imagen desde URL ---");
        ejemploImagenDesdeURL();
        esperar();

        System.out.println("  --- EJEMPLO 5: JPanel con paintComponent ---");
        ejemploPanelConPaint();
        esperar();

        System.out.println();
        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 9 - V06: IMAGENES E ICONOS)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - ImageIcon: cargar imagenes en componentes Swing");
        System.out.println("  - JLabel(ImageIcon): etiqueta con imagen");
        System.out.println("  - JButton(texto, ImageIcon): boton con icono");
        System.out.println("  - getScaledInstance(w, h, hints): escalar imagenes");
        System.out.println("  - SCALE_FAST: rapido pero pixelado");
        System.out.println("  - SCALE_SMOOTH: calidad suave pero mas lento");
        System.out.println("  - ImageIO.read(File/URL): cargar imagen");
        System.out.println("  - paintComponent(Graphics): dibujar en JPanel");
        System.out.println("  - drawImage(img, x, y, w, h, observer): pintar imagen");
        System.out.println("  - Proximo video: Eventos de raton");
    }

    static void esperar() {
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
    }
}
