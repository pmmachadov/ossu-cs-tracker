/**
 * Reto 5 (U5 - Clase Arrays): Crear una clase que pertenezca al
 * package unidad5.apartado1.retos, que inicialice un array de enteros
 * con valores aleatorios entre 1 y 10, y luego para cada valor
 * escrito entre las posiciones 0 a 4, busque si éste se encuentra
 * en alguna de las posiciones restantes. Utilizar métodos de la
 * clase Arrays.
 */
package unidad5.apartado1.retos;

import java.util.Arrays;
import java.util.Random;

public class Reto5_ArraysUtils {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[10];

        // Inicializar con valores aleatorios entre 1 y 10
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10) + 1;
        }

        System.out.println("Array completo: " + Arrays.toString(array));

        // Para cada valor en posiciones 0 a 4, buscar en el resto
        for (int i = 0; i < 5; i++) {
            int valor = array[i];
            // Crear subarray desde i+1 hasta el final
            int[] resto = Arrays.copyOfRange(array, i + 1, array.length);
            int pos = Arrays.binarySearch(resto, valor);

            // binarySearch requiere array ordenado
            Arrays.sort(resto);
            boolean encontrado = Arrays.binarySearch(resto, valor) >= 0;

            System.out.println("Valor " + valor + " en posición " + i
                + " -> " + (encontrado ? "Encontrado" : "No encontrado") + " en el resto.");
        }
    }
}
