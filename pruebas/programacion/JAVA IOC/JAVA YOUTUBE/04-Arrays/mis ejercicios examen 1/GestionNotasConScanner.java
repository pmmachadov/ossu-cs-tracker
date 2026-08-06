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

// INICIO INTENTAR

// ABRIR archivo"alumnos.txt"
// para lectura
// como entrada

// ABRIR archivo"resultados.txt"
// para escritura
// como salida

// MIENTRAS exista
// una línea
// siguiente en
// entrada HACER
// LEER línea
// de entrada
// ELIMINAR espacios
// en blanco
// alrededor

// SI
// la línea
// está vacía

// ENTONCES
// CONTINUAR (saltar al siguiente ciclo)
// FIN SI

// CREAR un lector auxiliar para la línea
// INTENTAR
// LEER el nombre desde el lector auxiliar

// suma ← 0.0
// contador ← 0

// MIENTRAS el lector auxiliar tenga un siguiente número real HACER
// valor ← LEER siguiente número real
// suma ← suma + valor
// contador ← contador + 1
// FIN MIENTRAS

// SI contador > 0 ENTONCES
// media ← suma / contador
// SINO
// media ← 0.0
// FIN SI

// ESCRIBIR en salida: nombre, ":", media formateada con 2 decimales, salto de
// línea
// FINALMENTE
// CERRAR el lector auxiliar
// FIN INTENTAR
// FIN MIENTRAS

// MOSTRAR "Archivo resultados.txt generado correctamente."

// ATRAPAR excepción de tipo FileNotFoundException
// MOSTRAR "Error: no se encuentra el archivo alumnos.txt"
// ATRAPAR excepción de tipo IOException
// MOSTRAR "Error de lectura/escritura: " seguido del mensaje de la excepción
// ATRAPAR excepción de tipo NumberFormatException
// MOSTRAR "Error: formato incorrecto en las notas"
// FIN INTENTAR
// FIN
