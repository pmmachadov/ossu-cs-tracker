import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Video 9-10: Java Swing - Ventanas emergentes
 *
 * Tema 9: JOptionPane, JDialog y JPopupMenu.
 *
 * URL: https://www.youtube.com/watch?v=cCDmOduFgEY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=203
 */
class Video_9_10_VentanasEmergentes {

    static final String CONTENIDO = """
        ================================================================
          VIDEO 9-10 - VENTANAS EMERGENTES EN SWING
        ================================================================

        Tipos de ventanas emergentes en Swing:

        1. JOptionPane - dialogos predefinidos
           - showMessageDialog(parent, msg, title, iconType)
             Iconos: INFORMATION_MESSAGE, ERROR_MESSAGE,
                     WARNING_MESSAGE, QUESTION_MESSAGE, PLAIN_MESSAGE
           - showConfirmDialog(parent, msg) -> int
             YES_OPTION, NO_OPTION, CANCEL_OPTION, CLOSED_OPTION
           - showInputDialog(parent, msg) -> String
           - showOptionDialog(parent, msg, title, tipo, icono,
                              null, opciones, opcionDefecto) -> int

        2. JDialog - ventana emergente personalizable
           - Puede contener cualquier componente Swing
           - setModal(true): bloquea el acceso a otras ventanas
           - setModal(false): permite interactuar con otras ventanas
           - dispose(): cierra el dialogo

        3. JPopupMenu - menu contextual (clic derecho)
           - JMenuItem para cada opcion
           - show(componente, x, y) para mostrarlo
           - Se dispara con MouseListener (mouseReleased)
           - Comodo usar MouseAdapter (solo metodo que interesa)
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: JOptionPane.showMessageDialog
        // ============================================================
        System.out.println("--- EJEMPLO 1: JOptionPane.showMessageDialog ---");
        JOptionPane.showMessageDialog(null, "Mensaje de informacion",
            "Info", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Mensaje de error",
            "Error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "Mensaje de advertencia",
            "Warning", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "Mensaje de pregunta",
            "Question", JOptionPane.QUESTION_MESSAGE);
        System.out.println();

        // ============================================================
        // EJEMPLO 2: JOptionPane.showConfirmDialog
        // ============================================================
        System.out.println("--- EJEMPLO 2: JOptionPane.showConfirmDialog ---");
        int respuesta = JOptionPane.showConfirmDialog(null,
            "Deseas continuar?", "Confirmacion",
            JOptionPane.YES_NO_CANCEL_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            System.out.println("  Has elegido: SI");
        } else if (respuesta == JOptionPane.NO_OPTION) {
            System.out.println("  Has elegido: NO");
        } else if (respuesta == JOptionPane.CANCEL_OPTION) {
            System.out.println("  Has elegido: CANCELAR");
        } else {
            System.out.println("  No has elegido ninguna opcion");
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 3: JOptionPane.showInputDialog
        // ============================================================
        System.out.println("--- EJEMPLO 3: JOptionPane.showInputDialog ---");
        String nombre = JOptionPane.showInputDialog(null, "Introduce tu nombre:");

        if (nombre != null && !nombre.isEmpty()) {
            System.out.println("  Hola " + nombre + "!");
        } else if (nombre != null) {
            System.out.println("  Hola !");
        } else {
            System.out.println("  Cancelaste la entrada");
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 4: JOptionPane.showOptionDialog
        // ============================================================
        System.out.println("--- EJEMPLO 4: JOptionPane.showOptionDialog ---");
        String[] colores = {"Rojo", "Verde", "Azul", "Amarillo", "Naranja",
            "Magenta", "Cyan", "Gris"};

        int seleccion = JOptionPane.showOptionDialog(null,
            "Elige un color:", "Selector de colores",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, colores, colores[0]);

        if (seleccion >= 0 && seleccion < colores.length) {
            System.out.println("  Has elegido: " + colores[seleccion]);
        } else {
            System.out.println("  No has seleccionado ningun color");
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 5: JDialog (ventana modal personalizada)
        // ============================================================
        System.out.println("--- EJEMPLO 5: JDialog (ventana modal) ---");

        JFrame ventanaPrincipal = new JFrame("Ventana principal");
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(400, 300);
        ventanaPrincipal.setLocation(100, 100);
        ventanaPrincipal.setVisible(true);

        JDialog dialogo = new JDialog(ventanaPrincipal, "Dialogo modal", true);
        dialogo.setSize(300, 200);
        dialogo.setLayout(new FlowLayout());
        dialogo.setLocationRelativeTo(null);

        dialogo.add(new JLabel("Este es un JDialog modal"));
        dialogo.add(new JLabel("Haz clic en Cancelar para cerrarlo"));

        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(e -> System.out.println("  Pulsado OK"));
        dialogo.add(btnOk);

        JButton btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(e -> dialogo.dispose());
        dialogo.add(btnCancel);

        dialogo.setVisible(true);  // modal: bloquea hasta cerrar
        System.out.println("  Dialogo cerrado");
        System.out.println();

        // ============================================================
        // EJEMPLO 6: JPopupMenu (menu contextual)
        // ============================================================
        System.out.println("--- EJEMPLO 6: JPopupMenu (menu contextual) ---");

        JFrame ventanaPopup = new JFrame("Popup Menu - Colores");
        ventanaPopup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPopup.setSize(500, 500);
        ventanaPopup.setLocationRelativeTo(null);

        final Color[] colorActual = {Color.BLACK};

        JPopupMenu colorMenu = new JPopupMenu();

        JMenuItem itemRojo = new JMenuItem("Rojo");
        itemRojo.addActionListener(e -> {
            colorActual[0] = Color.RED;
            ventanaPopup.repaint();
        });
        colorMenu.add(itemRojo);

        JMenuItem itemVerde = new JMenuItem("Verde");
        itemVerde.addActionListener(e -> {
            colorActual[0] = Color.GREEN;
            ventanaPopup.repaint();
        });
        colorMenu.add(itemVerde);

        JMenuItem itemAzul = new JMenuItem("Azul");
        itemAzul.addActionListener(e -> {
            colorActual[0] = Color.BLUE;
            ventanaPopup.repaint();
        });
        colorMenu.add(itemAzul);

        // Panel que dibuja un circulo del color seleccionado
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(colorActual[0]);
                g.fillOval(150, 150, 200, 200);
            }
        };
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    colorMenu.show(panel, e.getX(), e.getY());
                }
            }
        });

        ventanaPopup.add(panel);
        ventanaPopup.setVisible(true);

        System.out.println("  Haz clic derecho sobre el panel");
        System.out.println("  para elegir el color del circulo.");
        esperar(5000);

        System.out.println();
        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 9 - V10: VENTANAS EMERGENTES)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - JOptionPane.showMessageDialog: informacion, error, warning, question");
        System.out.println("  - JOptionPane.showConfirmDialog: YES_OPTION, NO_OPTION, CANCEL_OPTION");
        System.out.println("  - JOptionPane.showInputDialog: devuelve String");
        System.out.println("  - JOptionPane.showOptionDialog: botones personalizados");
        System.out.println("  - JDialog: ventana emergente personalizable");
        System.out.println("  - setModal(true): bloquea otras ventanas hasta cerrar");
        System.out.println("  - dispose(): cierra el JDialog");
        System.out.println("  - JPopupMenu + JMenuItem: menu contextual (clic derecho)");
        System.out.println("  - MouseAdapter: implementar solo los metodos necesarios");
        System.out.println("  - repaint() + paintComponent: actualizar dibujo");
    }

    static void esperar(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }
}
