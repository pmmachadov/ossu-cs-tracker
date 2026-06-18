import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/** Video 9-12: Mini Paint */
class Video_9_12_MiniPaint {

    static class AreaDibujo extends JComponent {
        private ArrayList<Trazo> trazos = new ArrayList<>();
        Color colorActual = Color.BLACK;
        float anchoTrazoActual = 1f;

        void agregarTrazo(Path2D.Float path) {
            trazos.add(new Trazo(path, colorActual, anchoTrazoActual));
            repaint();
        }
        void borrarTrazos() { trazos.clear(); repaint(); }
        void borrarUltimoTrazo() {
            if (!trazos.isEmpty()) { trazos.remove(trazos.size()-1); repaint(); }
        }

        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            for (Trazo t : trazos) {
                g2d.setColor(t.color);
                g2d.setStroke(new BasicStroke(t.ancho));
                g2d.draw(t.path);
            }
        }
        private static class Trazo {
            Path2D.Float path; Color color; float ancho;
            Trazo(Path2D.Float p, Color c, float a) { path=p; color=c; ancho=a; }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MiniPaint());
    }
}

class MiniPaint {
    private JFrame ventana = new JFrame("Mini Paint");
    private AreaDibujo areaDibujo = new AreaDibujo();
    private Path2D.Float trazoActual;

    MiniPaint() {
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        // Mouse: clic izquierdo -> crear trazo
        areaDibujo.addMouseListener(new MouseAdapter() {
            @Override public void mousePressed(MouseEvent e) {
                if (!SwingUtilities.isRightMouseButton(e)) {
                    trazoActual = new Path2D.Float();
                    trazoActual.moveTo(e.getX(), e.getY());
                    areaDibujo.agregarTrazo(trazoActual);
                }
            }
            @Override public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    mostrarMenuContextual(e.getX(), e.getY());
                }
            }
        });

        // Mouse: arrastrar -> dibujar linea
        areaDibujo.addMouseMotionListener(new MouseMotionAdapter() {
            @Override public void mouseDragged(MouseEvent e) {
                if (trazoActual != null) {
                    trazoActual.lineTo(e.getX(), e.getY());
                    areaDibujo.repaint();
                }
            }
        });

        ventana.add(areaDibujo, BorderLayout.CENTER);

        // Menu bar
        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Opciones");

        JMenuItem itemGuardar = new JMenuItem("Guardar imagen");
        itemGuardar.addActionListener(e -> guardarImagen());
        menu.add(itemGuardar);

        JMenuItem itemDeshacer = new JMenuItem("Deshacer");
        itemDeshacer.addActionListener(e -> areaDibujo.borrarUltimoTrazo());
        menu.add(itemDeshacer);

        JMenuItem itemLimpiar = new JMenuItem("Borrar todo");
        itemLimpiar.addActionListener(e -> areaDibujo.borrarTrazos());
        menu.add(itemLimpiar);

        barra.add(menu);
        ventana.setJMenuBar(barra);
        ventana.setVisible(true);
    }

    private void mostrarMenuContextual(int x, int y) {
        JPopupMenu popup = new JPopupMenu();

        // Colores
        JMenuItem itemRojo = new JMenuItem("Rojo");
        itemRojo.addActionListener(e -> areaDibujo.colorActual = Color.RED);
        popup.add(itemRojo);

        JMenuItem itemAzul = new JMenuItem("Azul");
        itemAzul.addActionListener(e -> areaDibujo.colorActual = Color.BLUE);
        popup.add(itemAzul);

        JMenuItem itemNegro = new JMenuItem("Negro");
        itemNegro.addActionListener(e -> areaDibujo.colorActual = Color.BLACK);
        popup.add(itemNegro);

        JMenuItem itemColor = new JMenuItem("Elegir color...");
        itemColor.addActionListener(e -> {
            Color c = JColorChooser.showDialog(ventana, "Selecciona un color", areaDibujo.colorActual);
            if (c != null) areaDibujo.colorActual = c;
        });
        popup.add(itemColor);

        popup.addSeparator();

        // Grosores
        JMenuItem itemFino = new JMenuItem("Trazo fino");
        itemFino.addActionListener(e -> areaDibujo.anchoTrazoActual = 1f);
        popup.add(itemFino);

        JMenuItem itemMedio = new JMenuItem("Trazo medio");
        itemMedio.addActionListener(e -> areaDibujo.anchoTrazoActual = 3f);
        popup.add(itemMedio);

        JMenuItem itemGrueso = new JMenuItem("Trazo grueso");
        itemGrueso.addActionListener(e -> areaDibujo.anchoTrazoActual = 5f);
        popup.add(itemGrueso);

        popup.show(areaDibujo, x, y);
    }

    private void guardarImagen() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("JPEG images", "jpg", "jpeg"));
        int resultado = fc.showSaveDialog(ventana);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
            if (!archivo.getName().toLowerCase().endsWith(".jpg")) {
                archivo = new File(archivo.getAbsolutePath() + ".jpg");
            }
            try {
                BufferedImage img = new BufferedImage(
                    areaDibujo.getWidth(), areaDibujo.getHeight(),
                    BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = img.createGraphics();
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, img.getWidth(), img.getHeight());
                areaDibujo.paint(g2d);
                g2d.dispose();
                ImageIO.write(img, "jpg", archivo);
                JOptionPane.showMessageDialog(ventana, "Imagen guardada correctamente",
                    "Guardada", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(ventana, "Error al guardar la imagen: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
