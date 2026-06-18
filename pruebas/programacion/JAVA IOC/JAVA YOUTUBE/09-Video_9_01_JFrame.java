import javax.swing.JFrame;

/**
 * Video 9-01: Introduccion a Java Swing - JFrame
 *
 * Tema 9: Aplicaciones con interfaz grafica en Java.
 * Primer contacto con Swing: ventanas basicas con JFrame.
 *
 * URL: https://www.youtube.com/watch?v=-vJE6jLgMGY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=192
 */
class Video_9_01_JFrame {

    public static final String TITULO = "9-01 JAVA: Introduccion a Swing - JFrame ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=-vJE6jLgMGY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=192";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 9";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 9-01 - INTRODUCCION A JAVA SWING: JFRAME
        ================================================================

        Tema 9: Interfaces Graficas de Usuario (GUI) en Java.

        --- EVOLUCION DE LAS GUI EN JAVA ---
        1. AWT (1996, JDK 1.0): componentes nativos del SO
        2. Swing (1998, JDK 1.2): componentes escritos en Java
           - Independientes del SO (consistencia entre plataformas)
           - Sigue siendo mantenido y usado hoy en dia
        3. JavaFX (2014, JDK 8): sucesor de Swing
           - Desde JDK 11: OpenJFX (codigo abierto)

        --- JFRAME (VENTANA PRINCIPAL) ---
        JFrame es la clase principal para crear ventanas en Swing.
        Representa una ventana completa con titulo, icono,
        botones de minimizar, maximizar y cerrar.

        --- CONTENEDORES PRINCIPALES ---
        - JFrame: ventana principal (contenedor de alto nivel)
        - JPanel: panel para agrupar componentes (contenedor secundario)
        - JDialog: ventana emergente (hija de JFrame o JDialog)

        --- METODOS PRINCIPALES DE JFRAME ---
        JFrame(String titulo)     -> constructor con titulo
        setVisible(boolean)       -> muestra/oculta la ventana
        setSize(int ancho, int alto) -> establece el tamano
        setDefaultCloseOperation(int) -> que hacer al cerrar
        setTitle(String)          -> cambia el titulo
        setLocationRelativeTo(null) -> centra la ventana

        --- CONSTANTES DE CIERRE ---
        JFrame.EXIT_ON_CLOSE    -> cierra la aplicacion
        JFrame.DISPOSE_ON_CLOSE -> elimina la ventana (el programa sigue)
        JFrame.HIDE_ON_CLOSE    -> oculta la ventana (no libera recursos)

        IMPORTANTE: sin setDefaultCloseOperation, al cerrar la ventana
        el programa SIGUE EN EJECUCION (hay que pararlo manualmente).
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: Ventana simple
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 1: VENTANA SIMPLE");
        System.out.println("=========================================");
        System.out.println("  Creando ventana 'Mi primera ventana'...");
        System.out.println("  (Puede aparecer detras de esta terminal)");
        System.out.println();

        JFrame ventana = new JFrame("Mi primera ventana");
        ventana.setSize(500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

        // Pausa para que se vea la ventana antes de continuar
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        // ============================================================
        // EJEMPLO 2: Dos ventanas con distinta accion de cierre
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 2: DOS VENTANAS");
        System.out.println("=========================================");
        System.out.println("  Ventana 1: EXIT_ON_CLOSE (cierra todo)");
        System.out.println("  Ventana 2: DISPOSE_ON_CLOSE (solo la ventana)");
        System.out.println();

        JFrame ventana1 = new JFrame("Ventana 1 - EXIT");
        ventana1.setSize(300, 200);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana1.setLocation(100, 100);
        ventana1.setVisible(true);

        JFrame ventana2 = new JFrame("Ventana 2 - DISPOSE");
        ventana2.setSize(300, 200);
        ventana2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana2.setLocation(500, 100);
        ventana2.setVisible(true);

        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        // ============================================================
        // EXPLICACION DE LAS VENTANAS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  JERARQUIA DE COMPONENTES SWING");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  java.awt.Component");
        System.out.println("    +-- java.awt.Container");
        System.out.println("        +-- javax.swing.JComponent");
        System.out.println("            +-- JPanel      (contenedor secundario)");
        System.out.println("            +-- JLabel      (texto)");
        System.out.println("            +-- JButton     (boton)");
        System.out.println("            +-- JTextField  (campo de texto)");
        System.out.println("            +-- JComboBox   (desplegable)");
        System.out.println("            +-- JList       (lista)");
        System.out.println("            +-- JTextArea   (area de texto)");
        System.out.println("        +-- java.awt.Window");
        System.out.println("            +-- java.awt.Frame");
        System.out.println("                +-- javax.swing.JFrame");
        System.out.println("            +-- java.awt.Dialog");
        System.out.println("                +-- javax.swing.JDialog");
        System.out.println();

        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 9 - V01: INTRODUCCION A SWING / JFRAME)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Swing: componentes escritos en Java (independientes del SO)");
        System.out.println("  - JFrame: ventana principal con titulo y bordes");
        System.out.println("  - setVisible(true): muestra la ventana");
        System.out.println("  - setSize(ancho, alto): tamano en pixeles");
        System.out.println("  - setDefaultCloseOperation(): que hacer al cerrar");
        System.out.println("  - EXIT_ON_CLOSE: termina el programa");
        System.out.println("  - DISPOSE_ON_CLOSE: libera recursos de la ventana");
        System.out.println("  - Sin setDefaultCloseOperation -> el programa sigue ejecutandose");
        System.out.println("  - Proximo video: Layout Managers");
    }
}
