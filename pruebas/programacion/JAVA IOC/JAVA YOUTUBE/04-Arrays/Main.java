// Objetivo: Pedir al usuario una frase completa, separarla en palabras y
// mostrarlas numeradas (1., 2., 3., etc.).

/*
 * PSEUDOCÓDIGO
 *
 * 1. CREAR SCANNER Y PEDIR UNA FRASE AL USUARIO
 * - Leer la línea completa con nextLine()
 *
 * 2. DIVIDIR LA FRASE EN PALABRAS
 * - Usar .split(" ") para crear un array de Strings
 *
 * 3. RECORRER EL ARRAY CON UN BUCLE for (con índice)
 * - Para cada posición i, imprimir: (i+1) + ". " + palabra
 *
 * 4. CERRAR SCANNER
 *
 */

//  Conceptos clave de este ejercicio:
// .split(" "): Divide un String en un array cada vez que encuentra un espacio.
// Bucle for con índice: Usamos i para acceder a cada palabra Y para mostrar el
// número.
// (i + 1): Como los arrays empiezan en 0, sumamos 1 para que la numeración
// empiece en 1.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe una frase: ");

        String[] palabras = sc.nextLine().split(" ");

        for (int i = 0; i < palabras.length; i++) {
            System.out.println((i + 1) + ". " + palabras[i]);
        }

        sc.close();
    }
}
