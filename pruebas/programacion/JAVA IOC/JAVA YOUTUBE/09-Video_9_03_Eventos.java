import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Video 9-03: Java Swing y AWT - Eventos
 *
 * Tema 9: Modelo de eventos en Java. Programacion orientada a eventos.
 * Fuente de eventos + Listener + Objeto de evento.
 *
 * URL: https://www.youtube.com/watch?v=Hskkm0BtV4c&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=195
 */
class Video_9_03_Eventos {

    public static final String TITULO = "9-03 JAVA: Swing y AWT - Eventos ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=Hskkm0BtV4c&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=195";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 9";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    static final String CONTENIDO = """
        ================================================================
          VIDEO 9-03 - EVENTOS EN SWING / AWT
        ================================================================

        En aplicaciones con interfaz grafica NO hay un orden
        predefinido de ejecucion. Dependiendo de las acciones
        del usuario se ejecutan unas instrucciones u otras.
        Esto se denomina PROGRAMACION ORIENTADA A EVENTOS.

        --- MODELO DE EVENTOS EN JAVA ---
        3 elementos principales:
          1. FUENTE DEL EVENTO: el objeto que genera el evento
             (ej: JButton, JTextField, JComboBox...)
          2. LISTENER: objeto que permanece a la escucha
             (implementa una interfaz Listener)
          3. OBJETO DEL EVENTO: encapsula informacion del evento
             (ej: ActionEvent, KeyEvent, MouseEvent...)

        --- INTERFAZ ACTIONLISTENER ---
        Interfaz funcional con un unico metodo:
          void actionPerformed(ActionEvent e)

        --- METODO addActionListener() ---
        Se invoca sobre la fuente del evento para suscribir
        un listener. Cuando ocurre el evento, se ejecuta
        actionPerformed().

        --- 3 FORMAS DE IMPLEMENTAR ACTIONLISTENER ---
        1. CLASE SEPARADA:
           class MiListener implements ActionListener {
               public void actionPerformed(ActionEvent e) {
                   System.out.println("Hola mundo");
               }
           }
           boton.addActionListener(new MiListener());

        2. CLASE ANONIMA:
           boton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   System.out.println("Hola mundo");
               }
           });

        3. LAMBDA (ActionListener es funcional):
           boton.addActionListener(e -> System.out.println("Hola mundo"));

        --- INFORMACION DEL EVENTO (ActionEvent) ---
        e.getWhen()   -> milisegundos desde epoch Unix
        e.getSource() -> objeto que genero el evento
        ================================================================
        """;

    // ================================================================
    // FORMA 1: Clase separada que implementa ActionListener
    // ================================================================
    static class BotonSaludo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("  Hola mundo desde un boton (clase separada)");
        }
    }

    // ================================================================
    // METODO AUXILIAR: saludar (para ejemplo con lambda)
    // ================================================================
    static void saludar(ActionEvent evento) {
        System.out.println("  Hola mundo desde un metodo con lambda");
        System.out.println("  Cuando: " + evento.getWhen() + " ms (epoch)");
        System.out.println("  Fuente: " + evento.getSource());
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        JFrame ventana = new JFrame("Ventana con eventos");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(700, 500);
        ventana.setLayout(new java.awt.FlowLayout());

        JButton boton = new JButton("Pulsa aqui");

        // ============================================================
        // FORMA 1: Clase separada
        // ============================================================
        // boton.addActionListener(new BotonSaludo());

        // ============================================================
        // FORMA 2: Clase anonima
        // ============================================================
        // boton.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         System.out.println("  Hola mundo desde una clase anonima");
        //     }
        // });

        // ============================================================
        // FORMA 3: Lambda (recomendada)
        // ============================================================
        boton.addActionListener(e -> saludar(e));

        ventana.add(boton);
        ventana.setVisible(true);

        System.out.println("  (Pulsa el boton en la ventana para ver los eventos)");
        System.out.println();

        // ============================================================
        // EXPLICACION DEL MODELO DE EVENTOS
        // ============================================================
        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 9 - V03: EVENTOS EN SWING/AWT)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Programacion orientada a eventos: no hay orden fijo");
        System.out.println("  - Fuente: el componente (JButton, JTextField...)");
        System.out.println("  - Listener: implementa interfaz (ActionListener...)");
        System.out.println("  - Evento: objeto con informacion (ActionEvent...)");
        System.out.println("  - ActionListener: unico metodo actionPerformed()");
        System.out.println("  - addActionListener(): suscribe el listener");
        System.out.println("  - 3 formas: clase separada / anonima / lambda");
        System.out.println("  - Lambda es la mas concisa (interfaz funcional)");
        System.out.println("  - Proximo video: mas eventos (teclado, raton, ventana)");
    }
}
