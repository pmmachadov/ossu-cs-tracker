import java.util.Scanner;

public class MainCarrito {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Elige 8 numeros");
        int[] numeros = new int[8];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextInt();
        }
        sc.close();

        System.out.println("Pares: " + pares(numeros));
        System.out.println("Mayor: " + mayor(numeros));
        System.out.println("Menor: " + menor(numeros));

        int[] alReves = invertir();

        System.out.print("Invertido");
        for (int v : alReves) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    static int pares(int[] numeros) {
        int numerosPares = 0;
        for (int i : numeros) {
            if (i % 2 == 0) {
                numerosPares++;
            }
        }
        return numerosPares;
    }

    static int mayor(int[] numeros) {
        int mayor = numeros[0];
        for (int valor : numeros) {
            if (valor > mayor) {
                mayor = valor;
            }
        }
        return mayor;
    }

    static int menor(int[] numeros) {
        int menor = numeros[0];
        for (int valor : numeros) {
            if (valor < menor) {
                menor = valor;
            }

        }
        return menor;
    }

    static int[] invertir(int[] numeros) {
        int[] invertido = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            invertido[i] = numeros[numeros.length - 1 - i];
        }
        return invertido;
    }
}
