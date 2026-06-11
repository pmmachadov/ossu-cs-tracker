/**
 * Reto 1 (Sección 2.2 - Estructuras de selección):
 * Modificar el programa de ejemplo del descuento para que,
 * en lugar de hacer un descuento del 8% si la compra es >= 100€,
 * aplique una penalización de 2€ si la compra es < 30€.
 */
import java.util.Scanner;

public class Reto1_Penalitzacio {
    private static final float PENALIZACION = 2;
    private static final float COMPRA_MIN = 30;

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("¿Cuál es el precio del producto en euros? ");
        float precio = lector.nextFloat();

        // Estructura de selección doble
        if (precio < COMPRA_MIN) {
            precio = precio + PENALIZACION;
            System.out.println("Se aplica penalización por compra inferior a " + COMPRA_MIN + "€.");
        } else {
            System.out.println("Compra mínima alcanzada. Sin penalización.");
        }

        System.out.println("El precio final por pagar es de " + precio + " euros.");
        lector.close();
    }
}
