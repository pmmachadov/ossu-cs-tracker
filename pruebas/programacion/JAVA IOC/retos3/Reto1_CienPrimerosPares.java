/**
 * Reto 1 (U3 - Arrays): Hacer un programa que inicialice proceduralmente
 * un array con los 100 primeros números pares (Nota: el 0 es par).
 */
public class Reto1_CienPrimerosPares {
    public static void main(String[] args) {
        int[] pares = new int[100];

        for (int i = 0; i < pares.length; i++) {
            pares[i] = i * 2;
        }

        System.out.println("Los 100 primeros números pares:");
        for (int i = 0; i < pares.length; i++) {
            System.out.print(pares[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}
