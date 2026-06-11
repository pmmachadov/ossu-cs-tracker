/**
 * Reto 12 (U3 - Strings): Hacer un programa que calcule la división entre
 * dos valores reales, haciendo que el resultado se repita un número
 * determinado de veces usando argumentos del método principal.
 * El primer argumento es el texto a escribir y el segundo el número
 * de veces (valor entero).
 */
public class Reto12_RepetirDivision {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java Reto12_RepetirDivision <num1> <num2>");
            return;
        }

        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[1]);

        if (num2 == 0) {
            System.out.println("Error: No se puede dividir entre cero.");
            return;
        }

        double resultado = num1 / num2;
        System.out.println(num1 + " / " + num2 + " = " + resultado);
    }
}
