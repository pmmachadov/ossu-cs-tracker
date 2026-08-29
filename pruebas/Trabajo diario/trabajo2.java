import java.util.Scanner;

public class trabajo2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[8];
        System.out.println("Por favor introduce 8 numeros:");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

   
    }

    static int contarPares(int[] n) {
        int contador = 0;
        for (int v : n) {
            if (v % 2 == 0) {
                contador++;
            }
        }
        return contador;
    }

    static int mayor(int[] numeros) {
        int mayor = numeros[0];

        for (int v : numeros) {
            if (v > mayor) {
                mayor = v;
            }
        }
        return mayor;
    }

    static int menor(int[] numeros) {
        int menor = numeros[0];

        for (int v : numeros) {
            if (v < menor) {
                menor = v;
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

// Pide 8 números por teclado y guárdalos en un array.
// Implementa métodos para:
// (1) contar cuántos son pares,
// (2) calcular el mayor y el menor, y
// (3) invertir el array.
// Muestra el resultado.
