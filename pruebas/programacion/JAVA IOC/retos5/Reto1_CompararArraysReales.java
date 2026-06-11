/**
 * Reto 1 (U5 - Métodos): Hacer un programa que, dados dos arrays
 * de valores reales, le diga cuál tiene una media más alta.
 */
public class Reto1_CompararArraysReales {

    public static double calcularMedia(double[] array) {
        if (array.length == 0) return 0;
        double suma = 0;
        for (double v : array) {
            suma += v;
        }
        return suma / array.length;
    }

    public static void main(String[] args) {
        double[] array1 = {5.5, 6.0, 7.2, 8.1, 9.0};
        double[] array2 = {4.5, 5.0, 6.5, 7.0, 8.5};

        double media1 = calcularMedia(array1);
        double media2 = calcularMedia(array2);

        System.out.println("Media del array 1: " + media1);
        System.out.println("Media del array 2: " + media2);

        if (media1 > media2) {
            System.out.println("El array 1 tiene la media más alta.");
        } else if (media2 > media1) {
            System.out.println("El array 2 tiene la media más alta.");
        } else {
            System.out.println("Ambos arrays tienen la misma media.");
        }
    }
}
