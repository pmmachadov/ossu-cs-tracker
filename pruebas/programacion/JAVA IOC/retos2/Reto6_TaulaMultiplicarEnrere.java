/**
 * Reto 2 (Sección 3.2 - Bucles while):
 * Un contador tanto puede empezar a contar desde 0 e ir subiendo,
 * como desde el final e ir disminuyendo como una cuenta atrás.
 * Modificar el programa de la tabla de multiplicar para que
 * muestre la tabla en orden descendente (de 10 a 1).
 */
import java.util.Scanner;

public class Reto6_TaulaMultiplicarEnrere {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int numero = lector.nextInt();

        int i = 10;
        System.out.println("Tabla de multiplicar del " + numero + " (inversa):");
        while (i >= 1) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
            i--;
        }

        lector.close();
    }
}
