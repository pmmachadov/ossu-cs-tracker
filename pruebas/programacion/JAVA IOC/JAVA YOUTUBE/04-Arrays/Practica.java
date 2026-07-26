import java.util.Scanner;

public class Practica {

    static int[] numeros = new int[8];

    public static void main(String[] args) {
        pideNumeros();
        int cantidadPares = contarPares();
        int[] invertido = invertirNumeros();
        salidaNumerosPares(cantidadPares);
        salidaArrayInvertido(invertido);
    }

    // Entrada: Pide 8 números enteros por teclado y los almacena en un array.
    public static void pideNumeros() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce 8 numeros enteros:");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextInt();
        }
        sc.close();
    }

    // contarPares: Recorre el array y devuelve la cantidad de números pares.
    public static int contarPares() {
        int contador = 0;
        for (int i : numeros) {
            if (i % 2 == 0) {
                contador++;
            }
        }
        return contador;
    }

    // invertir: Crea un nuevo array con los elementos en orden inverso al original.
    public static int[] invertirNumeros() {
        int[] num = new int[numeros.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = numeros[numeros.length - 1 - i];
        }
        return num;
    }

    // Salida: Muestra el número de pares y el array invertido.
    public static void salidaNumerosPares(int contador) {
        System.out.println("Existen " + contador + " numeros pares.");
    }

    public static void salidaArrayInvertido(int[] num) {
        System.out.print("Array invertido: ");
        for (int n : num) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
