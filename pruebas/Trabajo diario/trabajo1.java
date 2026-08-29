import java.util.Scanner;

public class ArraysUtils {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[8];

        for (int indice = 0; indice < nums.length; indice++) {
            nums[indice] = scanner.nextInt();
        }

        System.out.println("Pares: " + contarPares(nums));
        System.out.println("Mayor: " + mayor(nums) + " Menor: " + menor(nums));

        int[] invertidos = invertir(nums);
        System.out.println("Invertido: " + java.util.Arrays.toString(invertidos));
    }

    static int contarPares(int[] numeros) {
        int contadorPares = 0;
        for (int valor : numeros) {
            if (valor % 2 == 0) {
                contadorPares++;
            }
        }
        return contadorPares;
    }

    static int mayor(int[] numeros) {
        int maximo = numeros[0];
        for (int valor : numeros) {
            if (valor > maximo) {
                maximo = valor;
            }
        }
        return maximo;
    }

    static int menor(int[] numeros) {
        int minimo = numeros[0];
        for (int valor : numeros) {
            if (valor < minimo) {
                minimo = valor;
            }
        }
        return minimo;
    }

    static int[] invertir(int[] numeros) {
        int[] invertido = new int[numeros.length];
        for (int indice = 0; indice < numeros.length; indice++) {
            invertido[indice] = numeros[numeros.length - 1 - indice];
        }
        return invertido;
    }
}