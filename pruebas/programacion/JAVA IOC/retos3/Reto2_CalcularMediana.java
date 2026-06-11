/**
 * Reto 2 (U3 - Arrays): Modificar el código del recorrido para que,
 * en lugar de la media, calcule la mediana (valor central)
 * de una serie de notas.
 */
import java.util.Scanner;
import java.util.Arrays;

public class Reto2_CalcularMediana {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        float[] notas = new float[10];

        System.out.println("Introduce 10 notas:");
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = lector.nextFloat();
        }

        // Ordenar para encontrar la mediana
        Arrays.sort(notas);
        float mediana;
        if (notas.length % 2 == 0) {
            mediana = (notas[notas.length / 2 - 1] + notas[notas.length / 2]) / 2;
        } else {
            mediana = notas[notas.length / 2];
        }

        System.out.println("La mediana de las notas es: " + mediana);
        lector.close();
    }
}
