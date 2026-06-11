/**
 * Reto 4 (U5 - Constructores): Modificar el programa anterior para
 * mostrar por pantalla dos valores reales aleatorios de modo que
 * la clase Random se inicie con un parámetro de tipo long (semilla).
 * Formar parte del package unidad5.apartado1.retos.
 * Ejecutarlo varias veces y observar la diferencia.
 */
package unidad5.apartado1.retos;

import java.util.Random;

public class Reto4_NumerosAleatorios {
    public static void main(String[] args) {
        // Con semilla fija: siempre genera los mismos números
        Random randConSemilla = new Random(12345L);
        System.out.println("Con semilla fija (12345):");
        System.out.println("Valor 1: " + randConSemilla.nextDouble());
        System.out.println("Valor 2: " + randConSemilla.nextDouble());

        // Sin semilla: genera números diferentes cada vez
        Random randSinSemilla = new Random();
        System.out.println("\nSin semilla (aleatorio real):");
        System.out.println("Valor 1: " + randSinSemilla.nextDouble());
        System.out.println("Valor 2: " + randSinSemilla.nextDouble());

        System.out.println("\n--- Pregunta del reto ---");
        System.out.println("Con semilla fija: siempre salen los mismos números (determinista).");
        System.out.println("Sin semilla: salen números diferentes cada ejecución.");
    }
}
