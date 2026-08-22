import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1.Sumar 2.Restar 3.Multiplicar 4.Dividir 0.Salir");
            opcion = sc.nextInt();
            if (opcion == 0)
                break;
            System.out.print("a y b: ");
            double a = sc.nextDouble(), b = sc.nextDouble();
            switch (opcion) {
                case 1:
                    System.out.println("Suma: " + (a + b));
                    break;
                case 2:
                    System.out.println("Resta: " + (a - b));
                    break;
                case 3:
                    System.out.println("Prod: " + (a * b));
                    break;
                case 4:
                    if (b == 0)
                        System.out.println("División entre cero");
                    else
                        System.out.println("Div: " + (a / b));
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
}
