import java.util.Scanner;

public class Practica2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[8];

        System.out.println("Introduce 8 numeros:");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextInt();
        }

        int contador = 0;
        for (int x : numeros) {
            if (x % 2 == 0) {
                contador++;
            }
        }

        int[] invertido = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            invertido[i] = numeros[numeros.length - 1 - i];
        }

        System.out.println("Cantidad de pares: " + contador);
        System.out.print("Array invertido: ");
        for (int i = 0; i < invertido.length; i++) {
            System.out.print(invertido[i] + " ");
        }
        System.out.println();
    }
}
