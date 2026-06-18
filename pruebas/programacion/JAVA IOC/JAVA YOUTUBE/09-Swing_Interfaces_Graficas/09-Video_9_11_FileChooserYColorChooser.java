import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Video 9-11: Java Swing - JFileChooser y JColorChooser
 *
 * Tema 9: Componentes para seleccionar archivos y colores.
 * Incluye concepto de EDT (Event Dispatch Thread).
 *
 * URL: https://www.youtube.com/watch?v=Bcdf6KlVNto&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=204
 */
class Video_9_11_FileChooserYColorChooser {

    static final String CONTENIDO = """
        ================================================================
          VIDEO 9-11 - JFILECHOOSER Y JCOLORCHOOSER
        ================================================================

        Componentes para seleccionar archivos y colores.

        --- JColorChooser ---
        Color c = JColorChooser.showDialog(componente, "titulo", colorInicial);
        Si pulsa OK -> devuelve el color seleccionado
        Si cancela -> devuelve null

        --- JFileChooser ---
        JFileChooser fc = new JFileChooser();
        int resultado = fc.showOpenDialog(componente);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
        }
        showSaveDialog() para guardar archivos.
        Ambos son MODALES (bloquean hasta cerrar).

        --- EDT (Event Dispatch Thread) ---
        Todas las operaciones de Swing se ejecutan en un unico hilo.
        Para iniciar una app Swing correctamente:
          SwingUtilities.invokeLater(() -> new MiVentana());
        Esto asegura que la GUI se cree en el hilo de eventos.
        ================================================================
        """;

    // ================================================================
    // EJEMPLO 1: JColorChooser (cambiar color de un circulo)
    // ================================================================
    static class VentanaColorChooser extends JFrame {
        private Color colorCirculo = Color.BLACK;
        private final int diametro = 200;

        public VentanaColorChooser() {
            setTitle("Selector de color");
            setSize(500, 500);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton botonColor = new JButton("Elegir color");
            botonColor.addActionListener(e -> {
                Color nuevo = JColorChooser.showDialog(
                    this, "Elegir color del circulo", colorCirculo);
                if (nuevo != null) {
                    colorCirculo = nuevo;
                    repaint();
                }
            });

            add(botonColor, BorderLayout.SOUTH);
            setVisible(true);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            // Calcular centro de la ventana (restando espacio del boton)
            int x = (getWidth() - diametro) / 2;
            int y = (getHeight() - diametro - 50) / 2;
            g.setColor(colorCirculo);
            g.fillOval(x, y, diametro, diametro);
        }
    }

    // ================================================================
    // EJEMPLO 2: JFileChooser (cargar imagen)
    // ================================================================
    static class VentanaFileChooser extends JFrame {
        private JLabel etiquetaImagen;
        private BufferedImage imagen;

        public VentanaFileChooser() {
            setTitle("Selector de archivos - Imagen");
            setSize(600, 500);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            etiquetaImagen = new JLabel("Selecciona una imagen", SwingConstants.CENTER);
            add(etiquetaImagen, BorderLayout.CENTER);

            JButton botonSeleccionar = new JButton("Seleccionar imagen");
            botonSeleccionar.addActionListener(e -> {
                JFileChooser fc = new JFileChooser();
                int resultado = fc.showOpenDialog(this);

                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File archivo = fc.getSelectedFile();
                    cargarImagen(archivo);
                }
            });
            add(botonSeleccionar, BorderLayout.SOUTH);

            setVisible(true);
        }

        private void cargarImagen(File archivo) {
            try {
                BufferedImage imgOriginal = ImageIO.read(archivo);
                // Escalar para que se adapte al label
                Image imgEscalada = imgOriginal.getScaledInstance(
                    etiquetaImagen.getWidth() - 20,
                    etiquetaImagen.getHeight() - 20,
                    Image.SCALE_SMOOTH);
                etiquetaImagen.setIcon(new ImageIcon(imgEscalada));
                etiquetaImagen.setText("");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                    "Error al cargar la imagen: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // ================================================================
    // EJEMPLO 3: JFileChooser para guardar (save)
    // ================================================================
    static void ejemploFileChooserSave() {
        JFileChooser fc = new JFileChooser();
        int resultado = fc.showSaveDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
            System.out.println("  Archivo seleccionado para guardar: "
                + archivo.getAbsolutePath());
        } else {
            System.out.println("  No se selecciono archivo para guardar");
        }
    }

    // ================================================================
    // MAIN (usando EDT con SwingUtilities.invokeLater)
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // Iniciar en el Event Dispatch Thread (buena practica)
        SwingUtilities.invokeLater(() -> {
            System.out.println("================================================");
            System.out.println("  EJEMPLO 1: JColorChooser");
            System.out.println("================================================");
            System.out.println("  Ventana con circulo que cambia de color.");
            System.out.println("  Pulsa 'Elegir color' para abrir el selector.");
            System.out.println();

            new VentanaColorChooser();
        });

        esperar(8000);

        SwingUtilities.invokeLater(() -> {
            System.out.println("================================================");
            System.out.println("  EJEMPLO 2: JFileChooser (abrir imagen)");
            System.out.println("================================================");
            System.out.println("  Ventana para seleccionar y mostrar imagen.");
            System.out.println();

            new VentanaFileChooser();
        });

        esperar(8000);

        System.out.println("================================================");
        System.out.println("  EJEMPLO 3: JFileChooser (guardar)");
        System.out.println("================================================");
        ejemploFileChooserSave();
        System.out.println();

        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 9 - V11: FILECHOOSER Y COLORCHOOSER)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - JColorChooser.showDialog(): selector de color");
        System.out.println("  - Devuelve Color si OK, null si cancelar");
        System.out.println("  - JFileChooser: selector de archivos del SO");
        System.out.println("  - showOpenDialog(): abrir/select", " ");
        System.out.println("  - JColorChooser.showDialog(null, ...) -> Color o null");
        System.out.println("  - repaint() para refrescar el dibujo tras cambio de color");
        System.out.println("  - File -> ImageIO.read(file) -> BufferedImage");
        System.out.println("  - EDT: SwingUtilities.invokeLater()");
        System.out.println("  - Proximo video: Ejercicios Swing avanzados");
    }

    static void esperar(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }
}
