/**
 * Reto 2 (U5 - Packages): Generar un proyecto con un package llamado
 * unidad5.apartado1.reto2. Hacer que dentro de este package se incluyan
 * las clases del ejemplo del registro de las notas y ejecutarlo.
 *
 * Nota: Este archivo debe estar en la carpeta unidad5/apartado1/reto2/
 * para que el package funcione correctamente.
 */
package unidad5.apartado1.reto2;

import java.util.Scanner;

public class Reto2_RegistroNotas {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        float[] notas = new float[10];

        System.out.println("Introduce 10 notas:");
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = lector.nextFloat();
        }

        float suma = 0;
        for (float n : notas) {
            suma += n;
        }
        float media = suma / notas.length;

        System.out.println("La media de las notas es: " + media);
        lector.close();
    }
}
