import java.io.*;
import java.util.StringTokenizer;

public class Practica1 {
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
            System.out.println("No se encuentra alumnos.txt");

        } catch (IOException e) {
            System.out.println("Error de lectura o escritura");
        } catch (NumberFormatException e) {
            System.out.println("Formato incorrecto en las notas");
        }
    }
}
