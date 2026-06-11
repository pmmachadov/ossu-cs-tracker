/**
 * Reto 6 (U3 - Strings): Hacer un programa que muestre por pantalla
 * una cadena de texto, pero escrita del revés.
 * Ejemplo: "¡Hola, mundo!" -> "!odnum ,aloH¡"
 */
import java.util.Scanner;

public class Reto6_CadenaReves {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Introduce una cadena de texto: ");
        String texto = lector.nextLine();

        System.out.print("Texto al revés: ");
        for (int i = texto.length() - 1; i >= 0; i--) {
            System.out.print(texto.charAt(i));
        }
        System.out.println();

        lector.close();
    }
}
