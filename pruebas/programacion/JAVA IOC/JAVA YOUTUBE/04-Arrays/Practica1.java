import java.util.Scanner;
import java.util.Arrays; // para usar Arrays.toString()

public class Practica1 {

    static int[] numeros = new int[8];

    public static void main(String[] args) {
        pideNumeros();
        int cantPares = contarPares();
        int[] numInv = invertirNumeros();

        salidaPares(cantPares); // antes se llamaba cantPares
        salidaInvertido(numInv); // pasamos el array, no una variable inexistente
    }

    public static void pideNumeros() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa 8 numeros");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Ingresa Numero " + i);
            numeros[i] = sc.nextInt();
        }
        sc.close();
    }

    public static int contarPares() {
        int contador = 0;
        for (int i = 0; i < numeros.length; i++) {
            // CORREGIDO: se evalúa el valor, no el índice
            if (numeros[i] % 2 == 0) {
                contador++;
            }
        }
        return contador;
    }

    public static int[] invertirNumeros() {
        int[] n = new int[numeros.length];
        for (int i = 0; i < n.length; i++) {
            n[i] = numeros[numeros.length - 1 - i];
        }
        return n;
    }

    // antes se llamaba cantPares, ahora salidaPares para coincidir con la llamada
    public static void salidaPares(int contador) {
        System.out.println("Son " + contador + " numeros pares");
    }

    // ahora recibe un array y lo imprime como lista
    public static void salidaInvertido(int[] n) {
        System.out.println("Array invertido: " + Arrays.toString(n));
    }
}
