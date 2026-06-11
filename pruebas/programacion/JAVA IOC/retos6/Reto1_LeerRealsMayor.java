/**
 * Reto 1 (U6 - Ficheros): Realizar un programa que lea sucesivamente
 * 15 valores de tipo real desde un archivo llamado "Reals.txt".
 * El programa debe mostrar cuál de los valores dentro del archivo
 * es el mayor.
 *
 * Formato del archivo Reals.txt (un valor por línea o separados por espacios):
 * 12.5 8.3 15.7 6.2 9.1 11.4 14.8 3.5 10.2 7.9 13.6 5.1 16.3 4.8 2.9
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reto1_LeerRealsMayor {
    public static void main(String[] args) {
        try {
            File archivo = new File("Reals.txt");
            Scanner lector = new Scanner(archivo);

            double mayor = Double.MIN_VALUE;
            int contador = 0;

            while (lector.hasNextDouble() && contador < 15) {
                double valor = lector.nextDouble();
                if (valor > mayor) {
                    mayor = valor;
                }
                contador++;
            }
            lector.close();

            if (contador > 0) {
                System.out.println("Se leyeron " + contador + " valores.");
                System.out.println("El mayor valor es: " + mayor);
            } else {
                System.out.println("No se encontraron valores en el archivo.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo Reals.txt.");
            System.out.println("Crea el archivo en el directorio del proyecto.");
        }
    }
}
