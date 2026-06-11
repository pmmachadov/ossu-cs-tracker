/**
 * Reto 4 (Sección 3.3 - Bucles do-while):
 * Aplicar la comprobación de rango con un bucle do-while.
 * Pedir al usuario un número de mes (1-12) y mostrar
 * los días que tiene ese mes, repitiendo la pregunta
 * hasta que el valor sea correcto.
 */
import java.util.Scanner;

public class Reto8_ValorMesFitat {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int mes;

        // Bucle do-while: pedir al menos una vez hasta que el valor sea correcto
        do {
            System.out.print("Introduce un número de mes [1-12]: ");
            mes = lector.nextInt();

            if ((mes < 1) || (mes > 12)) {
                System.out.println("Valor incorrecto. Debe ser entre 1 y 12.");
            }
        } while ((mes < 1) || (mes > 12));

        System.out.print("Los días de este mes son... ");
        if (mes == 2) {
            System.out.println("28 o 29!");
        } else if ((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11)) {
            System.out.println("30!");
        } else {
            System.out.println("31!");
        }

        System.out.println("Dato correcta. Has escrito " + mes + ".");
        lector.close();
    }
}
