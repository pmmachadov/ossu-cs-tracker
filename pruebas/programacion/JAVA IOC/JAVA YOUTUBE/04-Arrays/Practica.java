import java.util.Scanner;

public class Practica {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[8];

        mensajeBienvenida();
        for (int i = 0; i < numeros.length; i++) {
            pedirNumero(i + 1);
            numeros[i] = sc.nextInt();
        }

        mostrarPares(contarPares(numeros));
        int[] inv = invertir(numeros);
        mostrarInvertido(inv);
        sc.close();
    }

    static int contarPares(int[] arr) {
        int c = 0;
        for (int v : arr)
            if (v % 2 == 0)
                c++;
        return c;
    }

    static int[] invertir(int[] arr) {
        int[] r = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            r[i] = arr[arr.length - 1 - i];
        return r;
    }

    static void mensajeBienvenida() {
        System.out.println("Introduce 8 números:");
    }

    static void pedirNumero(int orden) {
        System.out.print("Nº " + orden + ": ");
    }

    static void mostrarPares(int cantidad) {
        System.out.println("Pares: " + cantidad);
    }

    static void mostrarInvertido(int[] arr) {
        System.out.print("Invertido: ");
        for (int n : arr)
            System.out.print(n + " ");
    }
}
