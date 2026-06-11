/**
 * Reto 4 (Sección 2.4 - Control de errores de entrada):
 * Aplicar el mismo tipo de control sobre los datos de entrada
 * al ejemplo del cálculo del descuento. Verificar que el usuario
 * introduce un número válido y que el descuento no supere un máximo.
 */
import java.util.Scanner;

public class Reto4_ControlErrorsEntrada {
    private static final float DESCUENTO = 8;
    private static final float COMPRA_MIN = 100;
    private static final float DESC_MAXIM = 10;

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("¿Cuál es el precio del producto en euros? ");

        // Control de tipo: comprobar que se ha introducido un número válido
        boolean tipoCorrecto = lector.hasNextFloat();

        if (tipoCorrecto) {
            float precio = lector.nextFloat();

            if (precio > 0) {
                if (precio >= COMPRA_MIN) {
                    float descuentoFet = precio * DESCUENTO / 100;

                    // Control: el descuento no puede superar el máximo
                    if (descuentoFet > DESC_MAXIM) {
                        descuentoFet = DESC_MAXIM;
                    }

                    precio = precio - descuentoFet;
                    System.out.println("Se ha aplicado un descuento de " + descuentoFet + " euros.");
                } else {
                    System.out.println("Compra inferior a " + COMPRA_MIN + "€. Sin descuento.");
                }

                System.out.println("El precio final por pagar es de " + precio + " euros.");
            } else {
                System.out.println("Precio incorrecto. Es negativo.");
            }
        } else {
            System.out.println("El valor introducido no es un número válido.");
        }

        lector.close();
    }
}
