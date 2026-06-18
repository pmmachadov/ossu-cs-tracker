import javax.swing.*;
import java.awt.*;

/**
 * Video 9-02: Java Swing - Layout Manager
 *
 * Tema 9: Distribucion de componentes en contenedores
 * usando distintos tipos de LayoutManager en Swing.
 *
 * URL: https://www.youtube.com/watch?v=rYFZNvJwMx4&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=193
 */
class Video_9_02_LayoutManager {

    public static final String TITULO = "9-02 JAVA: Swing - Layout Manager ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=rYFZNvJwMx4&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=193";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 9";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    static final String CONTENIDO = """
        ================================================================
          VIDEO 9-02 - LAYOUT MANAGER
        ================================================================

        Los LayoutManager controlan como se distribuyen los
        componentes dentro de un contenedor (JFrame, JPanel...).

        --- TIPOS DE LAYOUT ---
        FlowLayout    (por defecto) -> izquierda a derecha, arriba abajo
        BorderLayout  -> 5 regiones: NORTH, SOUTH, EAST, WEST, CENTER
        GridLayout    -> cuadricula de celdas de igual tamano
        CardLayout    -> como tarjetas apiladas (una visible a la vez)
        GridBagLayout -> cuadricula flexible (el mas potente)
        BoxLayout     -> una fila o una columna
        null          -> posicion manual con setBounds()

        --- METODOS IMPORTANTES ---
        contenedor.setLayout(new FlowLayout())
        contenedor.add(componente)
        contenedor.add(componente, BorderLayout.NORTH)
        componente.setBounds(x, y, ancho, alto)

        --- CONSEJO ---
        Evitar layout=null (no se adapta a cambios de tamano).
        Usar layouts para que la interfaz sea responsive.
        ================================================================
        """;

    // ================================================================
    // EJEMPLO 1: FlowLayout (por defecto)
    // ================================================================
    static void ejemploFlowLayout() {
        JFrame ventana = new JFrame("FlowLayout");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(400, 200);

        // FlowLayout: izquierda a derecha, centrado por defecto
        ventana.setLayout(new FlowLayout());

        ventana.add(new JButton("Boton 1"));
        ventana.add(new JButton("Boton 2"));
        ventana.add(new JButton("Boton 3"));
        ventana.add(new JButton("Boton 4"));

        ventana.setVisible(true);
    }

    // ================================================================
    // EJEMPLO 2: BorderLayout (5 regiones)
    // ================================================================
    static void ejemploBorderLayout() {
        JFrame ventana = new JFrame("BorderLayout");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(400, 300);

        ventana.setLayout(new BorderLayout());

        ventana.add(new JButton("NORTE"), BorderLayout.NORTH);
        ventana.add(new JButton("SUR"), BorderLayout.SOUTH);
        ventana.add(new JButton("ESTE"), BorderLayout.EAST);
        ventana.add(new JButton("OESTE"), BorderLayout.WEST);
        ventana.add(new JButton("CENTRO"), BorderLayout.CENTER);

        ventana.setVisible(true);
    }

    // ================================================================
    // EJEMPLO 3: GridLayout (cuadricula)
    // ================================================================
    static void ejemploGridLayout() {
        JFrame ventana = new JFrame("GridLayout");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(400, 300);

        // 3 filas, 2 columnas
        ventana.setLayout(new GridLayout(3, 2));

        ventana.add(new JButton("Celda 1"));
        ventana.add(new JButton("Celda 2"));
        ventana.add(new JButton("Celda 3"));
        ventana.add(new JButton("Celda 4"));
        ventana.add(new JButton("Celda 5"));
        ventana.add(new JButton("Celda 6"));

        ventana.setVisible(true);
    }

    // ================================================================
    // EJEMPLO 4: Layout null (posicion manual)
    // ================================================================
    static void ejemploNullLayout() {
        JFrame ventana = new JFrame("Layout NULL (manual)");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(500, 500);
        ventana.setLayout(null);  // sin layout manager

        JButton boton = new JButton("Pulsa aqui");
        boton.setBounds(150, 200, 200, 40);  // x, y, ancho, alto
        ventana.add(boton);

        JButton boton2 = new JButton("Boton 2");
        boton2.setBounds(150, 260, 200, 40);
        ventana.add(boton2);

        ventana.setVisible(true);
    }

    // ================================================================
    // EJEMPLO 5: FlowLayout con varios botones y redimension
    // ================================================================
    static void ejemploFlowLayoutRedimension() {
        JFrame ventana = new JFrame("FlowLayout - responsive");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(400, 200);
        ventana.setLayout(new FlowLayout());

        for (int i = 1; i <= 8; i++) {
            ventana.add(new JButton("Boton " + i));
        }

        ventana.setVisible(true);
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        System.out.println("=========================================");
        System.out.println("  EJEMPLOS DE LAYOUT MANAGER");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Las ventanas se abriran una tras otra.");
        System.out.println("  Cierra cada ventana para ver la siguiente.");
        System.out.println();

        System.out.println("  --- FlowLayout (por defecto) ---");
        System.out.println("  Los componentes se colocan de izquierda");
        System.out.println("  a derecha y de arriba a abajo.");
        System.out.println("  Al cambiar el tamano, se reordenan.");
        ejemploFlowLayout();
        esperar();

        System.out.println("  --- BorderLayout (5 regiones) ---");
        System.out.println("  NORTH, SOUTH, EAST, WEST, CENTER.");
        System.out.println("  El CENTER ocupa el espacio restante.");
        ejemploBorderLayout();
        esperar();

        System.out.println("  --- GridLayout (cuadricula) ---");
        System.out.println("  Todas las celdas del mismo tamano.");
        System.out.println("  3 filas x 2 columnas = 6 botones.");
        ejemploGridLayout();
        esperar();

        System.out.println("  --- Layout NULL (manual) ---");
        System.out.println("  Posicion fija con setBounds().");
        System.out.println("  No se adapta al redimensionar.");
        ejemploNullLayout();
        esperar();

        System.out.println("  --- FlowLayout + redimension ---");
        System.out.println("  Los botones se reordenan al cambiar");
        System.out.println("  el tamano de la ventana.");
        ejemploFlowLayoutRedimension();
        esperar();

        System.out.println();
        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 9 - V02: LAYOUT MANAGER)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - LayoutManager: controla la distribucion de componentes");
        System.out.println("  - FlowLayout: de izquierda a derecha (por defecto)");
        System.out.println("  - BorderLayout: 5 regiones fijas");
        System.out.println("  - GridLayout: cuadricula de celdas iguales");
        System.out.println("  - null: posicion manual con setBounds()");
        System.out.println("  - setLayout(layout): asigna el layout al contenedor");
        System.out.println("  - add(componente, region): anade en una region (BorderLayout)");
        System.out.println("  - Proximo video: Eventos en Swing");
    }

    static void esperar() {
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
    }
}
