import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Video 9-13: Java Swing - Tres en Raya (Tic-Tac-Toe)
 *
 * Tema 9: Juego del tres en raya para dos jugadores
 * usando JButton, GridLayout y eventos.
 *
 * URL: https://www.youtube.com/watch?v=qZbXj9njg5Q&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=206
 */
class Video_9_13_TresEnRaya {

    // ================================================================
    // CLASE TRES EN RAYA
    // ================================================================
    static class TresEnRaya extends JFrame {
        private int ronda = 0;
        private boolean jugadorAzul = true;  // true=azul, false=rojo
        private JButton[][] tablero = new JButton[3][3];

        public TresEnRaya() {
            setTitle("3 en Raya");
            setSize(400, 400);
            setLayout(new GridLayout(3, 3));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Crear los 9 botones con sus listeners
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    JButton boton = new JButton();
                    boton.addActionListener(this::jugar);
                    tablero[i][j] = boton;
                    add(boton);
                }
            }

            setVisible(true);
        }

        private void jugar(ActionEvent e) {
            JButton botonPulsado = (JButton) e.getSource();

            if (jugadorAzul) {
                botonPulsado.setBackground(Color.BLUE);
            } else {
                botonPulsado.setBackground(Color.RED);
            }
            botonPulsado.setEnabled(false);
            jugadorAzul = !jugadorAzul;
            ronda++;
            verificarFinDeJuego();
        }

        private boolean verificarTresEnRaya(JButton p1, JButton p2, JButton p3) {
            Color c = p1.getBackground();
            return c != null
                && c.equals(p2.getBackground())
                && c.equals(p3.getBackground())
                && (c.equals(Color.BLUE) || c.equals(Color.RED));
        }

        private void verificarFinDeJuego() {
            // Filas y columnas
            for (int i = 0; i < 3; i++) {
                if (verificarTresEnRaya(tablero[i][0], tablero[i][1], tablero[i][2])
                    || verificarTresEnRaya(tablero[0][i], tablero[1][i], tablero[2][i])) {
                    victoria();
                    return;
                }
            }
            // Diagonales
            if (verificarTresEnRaya(tablero[0][0], tablero[1][1], tablero[2][2])
                || verificarTresEnRaya(tablero[0][2], tablero[1][1], tablero[2][0])) {
                victoria();
                return;
            }
            // Empate (ronda 9 sin ganador)
            if (ronda == 9) {
                empate();
            }
        }

        private void victoria() {
            String ganador = jugadorAzul ? "Rojo" : "Azul";
            JOptionPane.showMessageDialog(this,
                "El jugador " + ganador + " gana!",
                "Fin de la partida", JOptionPane.INFORMATION_MESSAGE);
            reiniciarJuego();
        }

        private void empate() {
            JOptionPane.showMessageDialog(this,
                "Empate!",
                "Fin de la partida", JOptionPane.INFORMATION_MESSAGE);
            reiniciarJuego();
        }

        private void reiniciarJuego() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    tablero[i][j].setEnabled(true);
                    tablero[i][j].setBackground(null);
                }
            }
            ronda = 0;
            jugadorAzul = true;
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            System.out.println("================================================");
            System.out.println("  JUEGO: TRES EN RAYA (TIC-TAC-TOE)");
            System.out.println("================================================");
            System.out.println("  Jugador AZUL y Jugador ROJO");
            System.out.println("  Haz clic en los botones para jugar.");
            System.out.println("  El juego detecta automaticamente:");
            System.out.println("    - 3 en raya en filas, columnas o diagonales");
            System.out.println("    - Empate si se llenan los 9 espacios");
            System.out.println("  Al finalizar, se reinicia automaticamente.");
            System.out.println();

            new TresEnRaya();
        });
    }
}
