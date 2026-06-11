/**
 * Reto 10 (U3 - Strings): Hacer un programa que muestre por pantalla
 * cada una de las palabras individuales que forman una frase,
 * usando el método split.
 */
import java.util.Scanner;

public class Reto10_MostrarPalabras {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Introduce una frase: ");
        String frase = lector.nextLine();

        String[] palabras = frase.split(" ");

        System.out.println("Palabras de la frase:");
        for (int i = 0; i < palabras.length; i++) {
            System.out.println((i + 1) + ". " + palabras[i]);
        }

        lector.close();
    }
}
