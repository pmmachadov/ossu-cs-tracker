/**
 * Reto 3 (Sección 2.3 - Selección múltiple):
 * Modificar los ejemplos de "Adivina" y "Evaluación Simplificado"
 * para que comprueben que el valor introducido se encuentra dentro
 * del rango de valores correcto (entre 0 y 10 para la nota,
 * y entre 0 y 10 para el juego de adivinar).
 */
import java.util.Scanner;

public class Reto3_ControlValores {
    private static final int VALOR_SECRETO = 4;

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // --- PARTE 1: Adivina con control de rango ---
        System.out.println("=== JUEGO ADIVINA ===");
        System.out.print("Adivina el valor entero, entre 0 y 10: ");
        int valorUsuario = lector.nextInt();

        if ((valorUsuario < 0) || (valorUsuario > 10)) {
            System.out.println("Error: el valor debe estar entre 0 y 10.");
        } else if (VALOR_SECRETO == valorUsuario) {
            System.out.println("¡Exacto! Era " + VALOR_SECRETO + ".");
        } else {
            System.out.println("¡Es un error!");
        }

        // --- PARTE 2: Evaluación con control de rango ---
        System.out.println("\n=== EVALUACIÓN ===");
        System.out.print("¿Qué nota has sacado? ");
        float nota = lector.nextFloat();

        if ((nota >= 9) && (nota <= 10)) {
            System.out.println("Tu nota final es Excelente.");
        } else if ((nota >= 6.5) && (nota < 9)) {
            System.out.println("Tu nota final es Notable.");
        } else if ((nota >= 5) && (nota < 6.5)) {
            System.out.println("Tu nota final es Aprobado.");
        } else if ((nota >= 0) && (nota < 5)) {
            System.out.println("Tu nota final es Suspendido.");
        } else {
            System.out.println("¡El valor escrito no está entre 0 y 10!");
        }

        System.out.println("Hemos terminado.");
        lector.close();
    }
}
