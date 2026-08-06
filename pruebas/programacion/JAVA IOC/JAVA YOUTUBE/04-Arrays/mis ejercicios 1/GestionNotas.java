// 3.3 Ficheros(2 ptos)Escribe un programa que:Lea un archivo de texto llamado alumnos.txtdonde cada línea tiene el formato:nombre nota1 nota2 nota3.Ejemplo:Ana 7.5 8.0 6.5 Para cada alumno,calcule la media de sus notas.Escriba en un nuevo archivo resultados.txtel nombre y la media,con el formato:Ana:7.33 Gestione correctamente las excepciones con try-with-resources.

import java.io.*;
import java.util.StringTokenizer;

public class GestionNotas {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("alumnos.txt"));
                PrintWriter pw = new PrintWriter("resultados.txt")) {

            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty())
                    continue;

                StringTokenizer st = new StringTokenizer(linea);
                String nombre = st.nextToken();
                double suma = 0;
                int count = 0;

                while (st.hasMoreTokens()) {
                    suma += Double.parseDouble(st.nextToken());
                    count++;
                }
                double media = suma / count;
                pw.printf("%s: %.2f%n", nombre, media);
            }
            System.out.println("Archivo resultados.txt generado.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: no se encuentra alumnos.txt");
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: formato incorrecto en las notas");
        }
    }
}
