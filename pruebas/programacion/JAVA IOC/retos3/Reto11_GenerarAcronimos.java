/**
 * Reto 11 (U3 - Strings): Realizar un programa que genere automáticamente
 * acrónimos. Partiendo de una frase determinada, debe mostrar por pantalla
 * el texto compuesto por las iniciales de cada palabra individual
 * que forma la frase.
 */
import java.util.Scanner;

public class Reto11_GenerarAcronimos {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Introduce una frase: ");
        String frase = lector.nextLine();

        String[] palabras = frase.split(" ");
        StringBuilder acronimo = new StringBuilder();

        for (String p : palabras) {
            if (!p.isEmpty()) {
                acronimo.append(Character.toUpperCase(p.charAt(0)));
            }
        }

        System.out.println("Acrónimo: " + acronimo.toString());
        lector.close();
    }
}
