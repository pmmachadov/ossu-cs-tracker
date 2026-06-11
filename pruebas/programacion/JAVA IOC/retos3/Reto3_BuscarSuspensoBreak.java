/**
 * Reto 3 (U3 - Arrays): Modificar el código del ejemplo para poder ver
 * si hay alguien que haya suspendido la asignatura o no, usando break.
 */
public class Reto3_BuscarSuspensoBreak {
    public static void main(String[] args) {
        float[] notas = {2.5f, 4.9f, 5.5f, 9.0f, 10.0f, 3.0f, 7.5f};
        boolean haySuspenso = false;

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 5.0) {
                haySuspenso = true;
                System.out.println("Alumno en posición " + i + " ha suspendido con: " + notas[i]);
                break; // Salir al encontrar el primer suspenso
            }
        }

        if (!haySuspenso) {
            System.out.println("Ningún alumno ha suspendido.");
        }
    }
}
