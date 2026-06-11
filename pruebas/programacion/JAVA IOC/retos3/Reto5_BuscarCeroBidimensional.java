/**
 * Reto 5 (U3 - Arrays bidimensionales): Modificar el programa de forma
 * que se busque si alguien ha sacado un 0 en un array bidimensional
 * de notas (filas = estudiantes, columnas = asignaturas).
 */
public class Reto5_BuscarCeroBidimensional {
    public static void main(String[] args) {
        int[][] notas = {
            {5, 7, 6, 8},
            {0, 4, 6, 5},
            {8, 9, 7, 10}
        };

        boolean hayCero = false;

        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] == 0) {
                    System.out.println("El estudiante " + (i + 1) + " tiene un 0 en la asignatura " + (j + 1));
                    hayCero = true;
                }
            }
        }

        if (!hayCero) {
            System.out.println("Ningún estudiante ha sacado un 0.");
        }
    }
}
