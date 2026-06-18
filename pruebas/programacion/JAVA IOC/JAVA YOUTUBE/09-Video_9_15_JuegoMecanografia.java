import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

/**
 * 9-15: JAVA Swing - Juego de mecanografia
 * Muestra letras aleatorias, cronometra tiempo y aciertos.
 * Guarda puntuaciones en BD MySQL.
 */
class Video_9_15_JuegoMecanografia {

    static final String CONTENIDO = """
        VIDEO 9-15 - JUEGO DE MECANOGRAFIA
        Muestra letras aleatorias. El usuario debe teclearlas.
        Aciertos y tiempo se registran. BD guarda puntuaciones.
        ================================================================
        """;

    static class JuegoMecanografiaBD {
        private static final String USUARIO = "root";
        private static final String PASSWORD = "";
        private static final String URL = "jdbc:mysql://localhost:3306/juego_meca";

        static Connection conectar() throws SQLException {
            return DriverManager.getConnection(URL, USUARIO, PASSWORD);
        }

        static void insertarPuntuacion(String nombre, int puntuacion, double tiempo) {
            String sql = "INSERT INTO puntuaciones (nombre, puntuacion, tiempo) VALUES (?, ?, ?)";
            try (Connection conn = conectar();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nombre);
                stmt.setInt(2, puntuacion);
                stmt.setDouble(3, tiempo);
                stmt.executeUpdate();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,
                    "Error al guardar datos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        static String obtenerMejoresPuntuaciones() {
            String resultado = "MEJORES TIEMPOS\n-----------------\n";
            String sql = "SELECT nombre, puntuacion, tiempo FROM puntuaciones "
                + "ORDER BY puntuacion DESC, tiempo ASC LIMIT 10";
            try (Connection conn = conectar();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String nom = rs.getString("nombre");
                    int pts = rs.getInt("puntuacion");
                    double t = rs.getDouble("tiempo");
                    resultado += nom + " -- " + String.format("%.3f", t)
                        + "s (" + pts + " aciertos)\n";
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,
                    "Error al obtener datos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            return resultado;
        }
    }

    static class JuegoMecanografia extends JFrame {
        private static final int CANTIDAD_RONDAS = 10;
        private JLabel letraLabel;
        private JButton botonIniciar;
        private Timer cronometro;
        private int puntuacion = 0;
        private int rondaActual = 0;
        private long tiempoInicio;
        private char letraActual;
        private Random random = new Random();

        JuegoMecanografia() {
            setTitle("Juego de mecanografia");
            setSize(400, 300);
            setLayout(new BorderLayout());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            letraLabel = new JLabel("", SwingConstants.CENTER);
            letraLabel.setFont(new Font("Arial", Font.BOLD, 100));
            add(letraLabel, BorderLayout.CENTER);

            botonIniciar = new JButton("Iniciar partida");
            botonIniciar.addActionListener(e -> iniciarReiniciar());
            add(botonIniciar, BorderLayout.SOUTH);

            addKeyListener(new KeyAdapter() {
                @Override public void keyPressed(KeyEvent e) {
                    comprobarLetra(e.getKeyChar());
                }
            });
            setFocusable(true);

            setVisible(true);
        }

        private void iniciarReiniciar() {
            if (botonIniciar.getText().equals("Iniciar partida")) {
                iniciarJuego();
                botonIniciar.setText("Reiniciar partida");
            } else {
                reiniciarJuego();
                botonIniciar.setText("Iniciar partida");
            }
            requestFocusInWindow();
        }

        private void iniciarJuego() {
            puntuacion = 0;
            rondaActual = 0;
            tiempoInicio = System.currentTimeMillis();
            generarLetraAleatoria();
            if (cronometro != null) cronometro.stop();
            cronometro = new Timer(10, e -> {
                if (rondaActual > CANTIDAD_RONDAS) {
                    finalizarJuego();
                }
            });
            cronometro.start();
        }

        private void reiniciarJuego() {
            if (cronometro != null) cronometro.stop();
            puntuacion = 0;
            rondaActual = 0;
            letraLabel.setText("");
            requestFocusInWindow();
        }

        private void generarLetraAleatoria() {
            letraActual = (char) ('a' + random.nextInt(26));
            letraLabel.setText(String.valueOf(letraActual));
            rondaActual++;
        }

        private void comprobarLetra(char tecla) {
            if (rondaActual > CANTIDAD_RONDAS) return;
            if (tecla == letraActual) {
                puntuacion++;
            }
            generarLetraAleatoria();
        }

        private void finalizarJuego() {
            cronometro.stop();
            botonIniciar.setText("Iniciar partida");
            double tiempoFinal = (System.currentTimeMillis() - tiempoInicio) / 1000.0;

            String nombre = JOptionPane.showInputDialog(this, "Introduce tu nombre:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                JuegoMecanografiaBD.insertarPuntuacion(nombre.trim(), puntuacion, tiempoFinal);
            }

            String[] opciones = {"Ver mejores tiempos", "Cerrar"};
            int respuesta = JOptionPane.showOptionDialog(this,
                "Juego terminado\nAciertos: " + puntuacion
                    + "\nTiempo: " + String.format("%.3f", tiempoFinal) + " segundos",
                "Fin de juego", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (respuesta == 0) {
                String mejores = JuegoMecanografiaBD.obtenerMejoresPuntuaciones();
                JOptionPane.showMessageDialog(this, mejores,
                    "Mejores tiempos", JOptionPane.INFORMATION_MESSAGE);
            }

            reiniciarJuego();
        }
    }

    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        SwingUtilities.invokeLater(() -> new JuegoMecanografia());
    }
}
