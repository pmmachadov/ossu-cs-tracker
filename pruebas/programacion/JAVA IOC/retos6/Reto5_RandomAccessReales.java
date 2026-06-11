/**
 * Reto 5 (U6 - RandomAccessFile): Hacer un programa que, dado un archivo
 * orientado a byte que contiene cualquier secuencia de valores reales,
 * los muestre por pantalla en orden inverso usando RandomAccessFile.
 */
import java.io.IOException;
import java.io.RandomAccessFile;

public class Reto5_RandomAccessReales {
    private static final String ARCHIVO = "RealesInverso.dat";

    public static void main(String[] args) {
        crearArchivoEjemplo();
        leerEnOrdenInverso();
    }

    /** Crea un archivo binario de ejemplo. */
    public static void crearArchivoEjemplo() {
        double[] datos = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8};

        try (RandomAccessFile raf = new RandomAccessFile(ARCHIVO, "rw")) {
            for (double d : datos) {
                raf.writeDouble(d);
            }
            System.out.println("Archivo '" + ARCHIVO + "' creado.");
        } catch (IOException e) {
            System.out.println("Error al crear: " + e.getMessage());
        }
    }

    /** Lee y muestra los valores en orden inverso usando RandomAccessFile. */
    public static void leerEnOrdenInverso() {
        try (RandomAccessFile raf = new RandomAccessFile(ARCHIVO, "r")) {
            long numBytes = raf.length();
            int numDoubles = (int) (numBytes / 8);

            System.out.println("Valores en orden inverso:");
            for (int i = numDoubles - 1; i >= 0; i--) {
                raf.seek(i * 8L); // Cada double son 8 bytes
                double valor = raf.readDouble();
                System.out.println(valor);
            }

        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }
}
