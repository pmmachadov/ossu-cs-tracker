/**
 * Reto 3 (U6 - Ficheros): Modificar el ejemplo de forma que ahora
 * haga lo siguiente. Por un lado, se crea un archivo "NotaMedia.txt"
 * donde se escribe la nota media de cada estudiante. Por otra parte,
 * se cambia el formato del archivo "Notes.txt" para controlar el
 * número de notas de cada estudiante en lugar de indicarlo directamente.
 *
 * Formato Notes.txt:
 * 3 7.5 8.0 6.5   (primero el número de notas, luego las notas)
 * 2 5.0 9.0
 * 4 6.0 7.0 8.0 5.5
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Reto3_LeerNotes {
    public static void main(String[] args) {
        try {
            File archivo = new File("Notes.txt");
            Scanner lector = new Scanner(archivo);
            PrintWriter writer = new PrintWriter(new FileWriter("NotaMedia.txt"));
            int estudiante = 1;

            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();
                if (linea.isEmpty()) continue;

                String[] partes = linea.split(" ");
                int numNotas = Integer.parseInt(partes[0]);
                double suma = 0;

                for (int i = 1; i <= numNotas && i < partes.length; i++) {
                    suma += Double.parseDouble(partes[i]);
                }

                double media = suma / numNotas;
                writer.println("Estudiante " + estudiante + ": " + media);
                System.out.println("Estudiante " + estudiante + " - Media: " + media);
                estudiante++;
            }

            lector.close();
            writer.close();
            System.out.println("Archivo 'NotaMedia.txt' creado.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo Notes.txt.");
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}
