/**
 * Reto 2 (Sección 2.2 - Estructuras de selección):
 * Modificar el programa "Adivina" para que, en lugar de un único
 * valor secreto, lo haya dos. Para ganar, basta con acertar uno
 * de los dos. La condición lógica será más compleja (usar ||).
 */
import java.util.Scanner;

public class Reto2_DosSecretos {
    private static final int VALOR_SECRETO_UNO = 4;
    private static final int OTRO_VALOR_DOS = 7;

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Empezamos el juego.");
        System.out.print("Adivina el valor entero, entre 0 y 10: ");
        int valorUsuario = lector.nextInt();

        // Si acierta UNO de los dos secretos, gana
        if ((VALOR_SECRETO_UNO == valorUsuario) || (OTRO_VALOR_DOS == valorUsuario)) {
            System.out.println("¡Exacto! Era " + valorUsuario + ".");
        } else {
            System.out.println("¡Es un error!");
        }

        System.out.println("Hemos terminado el juego.");
        lector.close();
    }
}
