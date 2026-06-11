/**
 * Reto 7 (U3 - Strings): Modificar el programa anterior (juego
 * de adivinar) para permitir hasta tres intentos de adivinación.
 */
import java.util.Scanner;

public class Reto7_TresIntentos {
    private static final int VALOR_SECRETO = 4;
    private static final int INTENTOS = 3;

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Adivina el número secreto (entre 0 y 10).");
        System.out.println("Tienes " + INTENTOS + " intentos.");

        boolean acertado = false;
        for (int i = 1; i <= INTENTOS; i++) {
            System.out.print("Intento " + i + ": ");
            int valor = lector.nextInt();

            if (valor == VALOR_SECRETO) {
                System.out.println("¡Acertaste! El número era " + VALOR_SECRETO);
                acertado = true;
                break;
            } else {
                System.out.println("Incorrecto.");
            }
        }

        if (!acertado) {
            System.out.println("Agotaste los intentos. El número era: " + VALOR_SECRETO);
        }

        lector.close();
    }
}
