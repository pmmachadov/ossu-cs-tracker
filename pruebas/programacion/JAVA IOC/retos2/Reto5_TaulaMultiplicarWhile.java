/**
 * Reto 1 (Sección 3.2 - Bucles while):
 * En muchos casos, el número de repeticiones no será fijo.
 * Pedir un número por teclado y mostrar su tabla de multiplicar
 * desde el 1 hasta el 10 usando un bucle while.
 */
import java.util.Scanner;

public class Reto5_TaulaMultiplicarWhile {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int numero = lector.nextInt();

        int i = 1;
        System.out.println("Tabla de multiplicar del " + numero + ":");
        while (i <= 10) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
            i++;
        }

        lector.close();
    }
}
