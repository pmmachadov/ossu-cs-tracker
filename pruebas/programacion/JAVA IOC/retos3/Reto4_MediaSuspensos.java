/**
 * Reto 4 (U3 - Arrays): Modificar el ejemplo de ordenación de forma que,
 * una vez ordenado el array, se calcule la media aritmética sólo de los
 * estudiantes que han suspendido (nota < 5).
 */
public class Reto4_MediaSuspensos {
    public static void main(String[] args) {
        float[] notas = {2.5f, 4.9f, 5.5f, 9.0f, 10.0f, 3.0f, 7.5f};

        // Ordenación por burbuja
        for (int i = 0; i < notas.length - 1; i++) {
            for (int j = 0; j < notas.length - 1 - i; j++) {
                if (notas[j] > notas[j + 1]) {
                    float temp = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = temp;
                }
            }
        }

        System.out.println("Notas ordenadas:");
        for (float n : notas) {
            System.out.print(n + " ");
        }
        System.out.println();

        // Media de los suspensos
        float suma = 0;
        int contadorSuspensos = 0;
        for (float n : notas) {
            if (n < 5.0) {
                suma += n;
                contadorSuspensos++;
            }
        }

        if (contadorSuspensos > 0) {
            float media = suma / contadorSuspensos;
            System.out.println("Media de los suspensos: " + media);
        } else {
            System.out.println("No hay suspensos.");
        }
    }
}
