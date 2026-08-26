import java.util.Scanner;

/**
 * ArraysUtils2 — Ejercicio con entrada por teclado (Scanner):
 * lee 8 números y calcula cuántos son pares, el mayor, el menor
 * y el array invertido.
 */
public class ArraysUtils2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Elige 8 numeros:");
        int[] numeros = new int[8];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextInt();
        }
        sc.close();

        System.out.println("Pares: " + pares(numeros));
        System.out.println("Mayor: " + mayor(numeros));
        System.out.println("Menor: " + menor(numeros));

        int[] alReves = invertir(numeros);
        System.out.println("Invertido: " + formatear(alReves));
    }

    /** Devuelve cuántos números pares hay en el array. */
    public static int pares(int[] numeros) {
        int numerosPares = 0;
        for (int i : numeros) {
            if (i % 2 == 0) {
                numerosPares++;
            }
        }
        return numerosPares;
    }

    /** Devuelve el valor máximo del array (excepción si está vacío). */
    public static int mayor(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }
        int mayor = numeros[0];
        for (int valor : numeros) {
            if (valor > mayor) {
                mayor = valor;
            }
        }
        return mayor;
    }

    /** Devuelve el valor mínimo del array (excepción si está vacío). */
    public static int menor(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }
        int menor = numeros[0];
        for (int valor : numeros) {
            if (valor < menor) {
                menor = valor;
            }
        }
        return menor;
    }

    /** Devuelve un nuevo array con los elementos en orden inverso. */
    public static int[] invertir(int[] numeros) {
        int[] invertido = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            invertido[i] = numeros[numeros.length - 1 - i];
        }
        return invertido;
    }

    /** Formatea un array como "6 15 8" (sin corchetes ni espacio final). */
    public static String formatear(int[] numeros) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numeros.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(numeros[i]);
        }
        return sb.toString();
    }
}
