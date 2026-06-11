/**
 * Reto 5 (Sección 3.4 - Bucle for):
 * Como ocurre con los programas basados en la sentencia while,
 * el contador de una sentencia for no tiene por qué incrementarse
 * de uno en uno. Realizar la suma de múltiplos de 3 usando
 * la sentencia for, incrementando el contador de 3 en 3.
 */
import java.util.Scanner;

public class Reto9_SumarMultiplesTresFor {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("¿Hasta qué valor quieres sumar múltiplos de 3? ");
        int limite = lector.nextInt();

        int resultado = 0;

        // Bucle for incrementando de 3 en 3
        for (int i = 0; i <= limite; i = i + 3) {
            System.out.println("Añadimos " + i + "...");
            resultado = resultado + i;
        }

        System.out.println("El resultado final es " + resultado + ".");
        lector.close();
    }
}
