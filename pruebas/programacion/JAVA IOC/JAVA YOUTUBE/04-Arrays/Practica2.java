import java.util.Scanner;

public class Practica2 {

    static int[] numeros = new int[8];

    public static void main(String[] args) {
        pideNumeros();
        int cantidadPares = contarPares();
        int[] numInvertidos = invertirNumeros();
        salidaNumerosPares(cantidadPares);
        salidaArrayInvertido(numInvertidos);
    }

    // Entrada: Pide 8 números enteros por teclado y los almacena en un array.
    public static void pideNumeros() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige 8 números:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }
        sc.close();
    }

    // contarPares: Recorre el array y devuelve la cantidad de números pares.
    public static int contarPares() {
        int contador = 0;
        for (int i : numeros) {
            if (i % 2 == 0) { // Corregido: verifica si el número es par
                contador++;
            }
        }
        return contador;
    }

    // invertir: Crea un nuevo array con los elementos en orden inverso al original.
    public static int[] invertirNumeros() {

        int[] n = new int[numeros.length];

        for (int i = 0; i < n.length; i++) {
            n[i] = numeros[numeros.length - 1 - i];
        }
        return n;
    }

    // Salida: Muestra el número de pares
    public static void salidaNumerosPares(int contador) {
        System.out.println("Existen " + contador + " números pares.");
    }

    // Salida: Array invertido
    public static void salidaArrayInvertido(int[] array) {
        System.out.print("Array invertido: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
