import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CALCULADORA SENCILLA ===");
        System.out.print("Ingresa el primer número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Ingresa el segundo número: ");
        double num2 = scanner.nextDouble();

        System.out.println("Selecciona la operación:");
        System.out.println("1 - Sumar (+)");
        System.out.println("2 - Restar (-)");
        System.out.println("3 - Multiplicar (*)");
        System.out.println("4 - Dividir (/)");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        double resultado;
        boolean operacionValida = true;

        switch (opcion) {
            case 1:
                resultado = num1 + num2;
                System.out.println("Resultado: " + num1 + " + " + num2 + " = " + resultado);
                break;
            case 2:
                resultado = num1 - num2;
                System.out.println("Resultado: " + num1 + " - " + num2 + " = " + resultado);
                break;
            case 3:
                resultado = num1 * num2;
                System.out.println("Resultado: " + num1 + " * " + num2 + " = " + resultado);
                break;
            case 4:
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.println("Resultado: " + num1 + " / " + num2 + " = " + resultado);
                } else {
                    System.out.println("Error: No se puede dividir entre cero.");
                    operacionValida = false;
                }
                break;
            default:
                System.out.println("Opción no válida.");
                operacionValida = false;
                break;
        }

        scanner.close();
    }
}
