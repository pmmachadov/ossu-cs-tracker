import java.util.Scanner;

public class Practica {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[8];
        System.out.println("Introduce 8 números:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Nº " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }

        System.out.println("Pares: " + contarPares(numeros));
        int[] inv = invertir(numeros);
        System.out.print("Invertido: ");
        for (int n : inv)
            System.out.print(n + " ");
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
}
