/**
 * Reto 7 (Sección 2.5): Realizar un programa que muestre por pantalla
 * la multiplicación de tres números reales entrados por teclado.
 */
import java.util.Scanner;

public class Reto9_MultiplicarEntradaTeclat {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Vamos a multiplicar tres números reales.");
        System.out.print("Escribe el primer número: ");
        double primerReal = lector.nextDouble();

        System.out.print("Escribe el segundo número: ");
        double segonReal = lector.nextDouble();

        System.out.print("Escribe el tercer número: ");
        double tercerReal = lector.nextDouble();

        double resultado = primerReal * segonReal * tercerReal;

        System.out.println("La multiplicación de los valores es " + resultado + ".");

        lector.close();
    }
}
