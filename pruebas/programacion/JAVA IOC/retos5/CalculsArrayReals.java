/**
 * Clase auxiliar para Reto 3 (U5).
 * Package: utilitats.arrays
 * Proporciona métodos estáticos para operaciones con arrays de reales.
 */
package utilitats.arrays;

public class CalculsArrayReals {

    /**
     * Calcula la media de los primeros n valores del array.
     * @param array Array de valores reales
     * @param n Número de valores a considerar
     * @return Media aritmética
     */
    public static float calcularMedia(float[] array, int n) {
        if (n <= 0) return 0;
        float suma = 0;
        for (int i = 0; i < n; i++) {
            suma += array[i];
        }
        return suma / n;
    }

    /**
     * Encuentra el valor máximo del array.
     * @param array Array de valores reales
     * @return Valor máximo
     */
    public static float encontrarMaximo(float[] array) {
        float max = array[0];
        for (float v : array) {
            if (v > max) max = v;
        }
        return max;
    }

    /**
     * Encuentra el valor mínimo del array.
     * @param array Array de valores reales
     * @return Valor mínimo
     */
    public static float encontrarMinimo(float[] array) {
        float min = array[0];
        for (float v : array) {
            if (v < min) min = v;
        }
        return min;
    }
}
