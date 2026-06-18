import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * Video 9-14: Java Swing - Cronometro
 *
 * Tema 9: Cronometro con segundos y centesimas usando
 * Timer de Swing y System.currentTimeMillis() para precision.
 *
 * URL: https://www.youtube.com/watch?v=lt_1BJlPIhM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=207
 */
class Video_9_14_Cronometro {

    static final String CONTENIDO = """
        ================================================================
          VIDEO 9-14 - CRONOMETRO EN JAVA SWING
        ================================================================

        Cronometro con segundos y centesimas.

        VERSION 1: Timer con delay=10ms
          - Simple pero impreciso (depende de JVM y carga del sistema)

        VERSION 2: System.currentTimeMillis()
          - Usa la hora del sistema para mayor precision
          - tiempoTranscurrido = timePaused + (ahora - startTime)

        FORMATO: siempre dos digitos (DecimalFormat("00"))

        BOTONES:
          - Iniciar/Pausar: inicia o pausa el cronometro
          - Reiniciar: vuelve a cero y para

        EXTRAS:
          - Si se pausa en centesimas=00 -> JOptionPane de enhorabuena
        ================================================================
        """;

    // ================================================================
    // VERSION 1: Cronometro simple (con Timer)
    // ================================================================
    static class Cronometro extends JFrame {
        private int milesimas = 0;  // contador interno (centesimas * 10)
        private boolean corriendo = false;
        private JLabel labelReloj;
        private Timer timer;
        private JButton botonIniciar, botonReiniciar;
        private DecimalFormat formato = new DecimalFormat("00");

        public Cronometro() {
            setTitle("Cronometro");
            setSize(400, 200);
            setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            labelReloj = new JLabel("00:00");
            labelReloj.setFont(new Font("Arial", Font.BOLD, 48));
            add(labelReloj);

            botonIniciar = new JButton("Iniciar");
            botonReiniciar = new JButton("Reiniciar");

            // Timer: se ejecuta cada 10ms
            timer = new Timer(10, e -> {
                if (corriendo) {
                    milesimas += 10;
                    int segundos = milesimas / 1000;
                    int centesimas = (milesimas % 1000) / 10;
                    labelReloj.setText(formato.format(segundos) + ":" + formato.format(centesimas));
                }
            });

            botonIniciar.addActionListener(e -> {
                if (corriendo) {
                    // Pausar
                    corriendo = false;
                    botonIniciar.setText("Iniciar");
                    if (milesimas % 1000 == 0) {
                        JOptionPane.showMessageDialog(this,
                            "Enhorabuena! Has parado el cronometro en 0 centesimas",
                            "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    // Iniciar
                    corriendo = true;
                    botonIniciar.setText("Pausar");
                    timer.start();
                }
            });

            botonReiniciar.addActionListener(e -> {
                milesimas = 0;
                corriendo = false;
                botonIniciar.setText("Iniciar");
                labelReloj.setText("00:00");
            });

            add(botonIniciar);
            add(botonReiniciar);
            setVisible(true);
        }
    }

    // ================================================================
    // VERSION 2: Cronometro con precision (System.currentTimeMillis)
    // ================================================================
    static class CronometroPrecision extends JFrame {
        private long tiempoPausado = 0;
        private long inicioTiempo = 0;
        private boolean corriendo = false;
        private JLabel labelReloj;
        private Timer timer;
        private JButton botonIniciar, botonReiniciar;
        private DecimalFormat formato = new DecimalFormat("00");

        public CronometroPrecision() {
            setTitle("Cronometro de precision");
            setSize(400, 200);
            setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            labelReloj = new JLabel("00:00");
            labelReloj.setFont(new Font("Arial", Font.BOLD, 48));
            add(labelReloj);

            botonIniciar = new JButton("Iniciar");
            botonReiniciar = new JButton("Reiniciar");

            timer = new Timer(10, e -> {
                if (corriendo) {
                    long ahora = System.currentTimeMillis();
                    long transcurrido = tiempoPausado + (ahora - inicioTiempo);
                    int segundos = (int) (transcurrido / 1000);
                    int centesimas = (int) ((transcurrido % 1000) / 10);
                    labelReloj.setText(formato.format(segundos) + ":" + formato.format(centesimas));
                }
            });

            botonIniciar.addActionListener(e -> {
                if (corriendo) {
                    // Pausar: acumular tiempo transcurrido
                    tiempoPausado += System.currentTimeMillis() - inicioTiempo;
                    corriendo = false;
                    botonIniciar.setText("Iniciar");
                    // Verificar si se paro en 00 centesimas
                    if (labelReloj.getText().endsWith(":00")) {
                        JOptionPane.showMessageDialog(this,
                            "Enhorabuena! Has parado el cronometro en 0 centesimas",
                            "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    inicioTiempo = System.currentTimeMillis();
                    corriendo = true;
                    botonIniciar.setText("Pausar");
                    timer.start();
                }
            });

            botonReiniciar.addActionListener(e -> {
                tiempoPausado = 0;
                inicioTiempo = 0;
                corriendo = false;
                botonIniciar.setText("Iniciar");
                labelReloj.setText("00:00");
            });

            add(botonIniciar);
            add(botonReiniciar);
            setVisible(true);
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        SwingUtilities.invokeLater(() -> {
            System.out.println("================================================");
            System.out.println("  CRONOMETRO (VERSION SIMPLE)");
            System.out.println("================================================");
            System.out.println("  Abriendo cronometro simple...");
            System.out.println("  (Cerrar ventana para continuar)");
            System.out.println();

            new Cronometro();
        });

        esperar(8000);

        SwingUtilities.invokeLater(() -> {
            System.out.println("================================================");
            System.out.println("  CRONOMETRO DE PRECISION");
            System.out.println("================================================");
            System.out.println("  (Usa System.currentTimeMillis())");
            System.out.println("  Abriendo cronometro de precision...");
            System.out.println();

            new CronometroPrecision();
        });

        esperar(8000);

        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 9 - V14: CRONOMETRO)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Timer: delay en ms, se ejecuta periodicamente");
        System.out.println("  - Timer(10, e -> { ... }) = 100 veces/segundo");
        System.out.println("  - DecimalFormat('00'): siempre dos digitos");
        System.out.println("  - Version simple: contador interno impreciso");
        System.out.println("  - Version precisa: System.currentTimeMillis()");
        System.out.println("  - tiempoTranscurrido = acumulado + (ahora - inicio)");
        System.out.println("  - Verificar :00 con endsWith()");
    }

    static void esperar(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }
}
