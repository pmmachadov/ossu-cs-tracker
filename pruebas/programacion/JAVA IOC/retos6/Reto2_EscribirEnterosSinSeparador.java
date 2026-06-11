/**
 * Reto 2 (U6 - Ficheros): Modificar el ejemplo de modo que los valores
 * enteros, en lugar de estar separados por espacios, se escriban
 * uno a continuación del otro sin ningún delimitador.
 *
 * Programa que escribe varios números enteros en un archivo
 * uno detrás de otro (sin espacios) usando PrintWriter.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Reto2_EscribirEnterosSinSeparador {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("EnterosSinFormato.txt"));

            for (int num : numeros) {
                writer.print(num); // Sin espacios ni saltos de línea
            }

            writer.close();
            System.out.println("Archivo 'EnterosSinFormato.txt' creado.");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
