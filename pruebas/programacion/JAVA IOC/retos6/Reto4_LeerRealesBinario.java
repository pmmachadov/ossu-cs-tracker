/**
 * Reto 4 (U6 - Ficheros binarios): Hacer un programa que lea un archivo
 * orientado a byte que contenga una secuencia de valores reales
 * cualquiera. Hay que mostrarlos por pantalla ordenados de más grande
 * a menor. Antes deberá crear el archivo binario con datos de prueba.
 */
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Reto4_LeerRealesBinario {
    private static final String ARCHIVO = "Reales.dat";

    public static void main(String[] args) {
        crearArchivoEjemplo();
        leerYOrdenar();
    }

    /** Crea un archivo binario de ejemplo con valores reales. */
    public static void crearArchivoEjemplo() {
        double[] datos = {15.5, 3.2, 8.7, 12.1, 6.4, 10.0, 1.5, 9.8};

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(ARCHIVO))) {
            for (double d : datos) {
                dos.writeDouble(d);
            }
            System.out.println("Archivo '" + ARCHIVO + "' creado con datos de ejemplo.");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    /** Lee el archivo binario y muestra los valores ordenados de mayor a menor. */
    public static void leerYOrdenar() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(ARCHIVO))) {
            // Leer todos los doubles
            double[] valores = new double[dis.available() / 8];
            for (int i = 0; i < valores.length; i++) {
                valores[i] = dis.readDouble();
            }

            // Ordenar de mayor a menor
            Arrays.sort(valores);
            Double[] wrapper = new Double[valores.length];
            for (int i = 0; i < valores.length; i++) {
                wrapper[i] = valores[i];
            }
            Arrays.sort(wrapper, Collections.reverseOrder());

            System.out.println("Valores ordenados de mayor a menor:");
            for (double d : wrapper) {
                System.out.println(d);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
