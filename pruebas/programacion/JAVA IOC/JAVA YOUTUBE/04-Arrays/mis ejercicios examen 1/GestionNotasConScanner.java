// 3.3 Ficheros(2 ptos)Escribe un programa que:Lea un archivo de texto llamado alumnos.txtdonde cada línea tiene el formato:nombre nota1 nota2 nota3.Ejemplo:Ana 7.5 8.0 6.5 Para cada alumno,calcule la media de sus notas.Escriba en un nuevo archivo resultados.txtel nombre y la media,con el formato:Ana:7.33 Gestione correctamente las excepciones con try-with-resources.

import java.io.*;
import java.util.Scanner;

public class GestionNotasConScanner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new File("alumnos.txt"));
                PrintWriter pw = new PrintWriter("resultados.txt")) {

            while (sc.hasNextLine()) {
                String linea = sc.nextLine().trim();

                if (linea.isEmpty()) {
                    continue;
                }

                Scanner lineaScanner = new Scanner(linea);
                try {
                    String nombre = lineaScanner.next();

                    double suma = 0;
                    int count = 0;

                    while (lineaScanner.hasNextDouble()) {
                        suma += lineaScanner.nextDouble();
                        count++;
                    }

                    double media = (count > 0) ? suma / count : 0.0;

                    pw.printf("%s: %.2f%n", nombre, media);

                } finally {
                    lineaScanner.close();
                }
            }

            System.out.println("Archivo resultados.txt generado correctamente.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: no se encuentra el archivo alumnos.txt");
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: formato incorrecto en las notas");
        }
    }
}

// INICIO

// ABRIR archivo"alumnos.txt" para lectura (br)
// ABRIR archivo "resultados.txt" para escritura (pw)

// MIENTRAS haya una línea en "alumnos.txt" HACER LEER línea

// ELIMINAR espacios al inicio y final de la línea

// SI la línea está vacía ENTONCES CONTINUAR con la siguiente línea

// FIN SI

// DIVIDIR la línea en partes usando espacios → tokens

// TOMAR la primera parte como nombre

// INICIALIZAR suma = 0 y contador = 0

// MIENTRAS queden tokens HACER
// CONVERTIR el siguiente token a número decimal
// SUMAR ese número a suma
// INCREMENTAR contador en 1
// FIN MIENTRAS

// CALCULAR media = suma / contador

// ESCRIBIR en "resultados.txt": nombre + ": " + media (con 2 decimmales)

// FIN MIENTRAS

// MOSTRAR mensaje: "Archivo resultados.txt generado."

// CERRAR automáticamente ambos archivos

// EXCEPCIÓN si "alumnos.txt" no existe:
// MOSTRAR: "Error: no se encuentra alumnos.txt"

// EXCEPCIÓN si hay error de lectura/escritura:
// MOSTRAR: "Error de lectura/escritura: [mensaje del error]"

// EXCEPCIÓN si una nota no es un número válido:
// MOSTRAR: "Error: formato incorrecto en las notas"
// FIN
