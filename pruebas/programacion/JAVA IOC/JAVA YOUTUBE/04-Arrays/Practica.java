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

    public static void pideNumeros() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce 8 numeros enteros:");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextInt();
        }
    }

    public static int contarPares() {
        int contador = 0;
        for (int i : numeros) {
            if (i % 2 == 0) {
                contador++;
            }
        }
        return contador;
    }

    public static int[] invertirNumeros() {
        int[] num = new int[numeros.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = numeros[numeros.length - 1 - i];
        }
        return num;
    }

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
