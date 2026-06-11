/**
 * Reto 3 (Sección 3.3 - Bucles con condición):
 * El uso de contadores y acumuladores no es excluyente.
 * Realizar un programa que calcule la división entera y el módulo
 * usando restas sucesivas (bucle while). El usuario introduce
 * el dividendo y el divisor, y el programa muestra el cociente
 * y el resto (módulo).
 */
import java.util.Scanner;

public class Reto7_ModulIDivisio {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("¿Cuál será el dividendo? ");
        int dividendo = lector.nextInt();

        System.out.print("¿Cuál será el divisor? ");
        int divisor = lector.nextInt();

        int cociente = 0;

        // Bucle: restamos el divisor al dividendo hasta que no se pueda más
        while (dividendo >= divisor) {
            System.out.println("Bucle: por ahora el dividendo vale " + dividendo);
            dividendo = dividendo - divisor;
            cociente++;
        }

        // Al salir del bucle:
        // - "cociente" tiene el cociente de la división entera
        // - "dividendo" tiene el módulo (resto)
        System.out.println("La división es " + cociente + ".");
        System.out.println("El módulo es " + dividendo + ".");

        lector.close();
    }
}
