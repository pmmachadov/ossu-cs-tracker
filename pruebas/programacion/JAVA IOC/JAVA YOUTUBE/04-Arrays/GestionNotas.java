/*3.3 Ficheros(2 ptos)Escribe un programa que:

Lea un archivo de texto llamado alumnos.txt donde cada línea tiene el formato:nombre nota1 nota2 nota3.

Ejemplo:Ana 7.5 8.0 6.5 Para cada alumno,calcule la media de sus notas.Escriba en un nuevo archivo resultados.txt el nombre y la media,

con el formato:Ana:7.33
Gestione correctamente las excepciones con try-with-resources.
*/

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class GestionNotas {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new File("alumnos.txt"));
                PrintWriter pw = new PrintWriter("resultados.txt")) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine().trim();
                if (linea.isEmpty())
                    continue;
                String[] partes = linea.split(" ");
                String nombre = partes[0];
                double suma = 0;
                int count = 0;
                for (int i = 1; i < partes.length; i++) {
                    suma += Double.parseDouble(partes[i]);
                    count++;
                }
                double media = suma / count;
                pw.printf(Locale.ROOT, "%s: %.2f%n", nombre, media);
            }
            System.out.println("Archivo resultados.txt generado.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: no se encuentra alumnos.txt");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
