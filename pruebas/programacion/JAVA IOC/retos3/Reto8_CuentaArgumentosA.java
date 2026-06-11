/**
 * Reto 8 (U3 - Strings): Hacer un programa que, en una serie de
 * cadenas de texto pasadas como argumentos en el método principal,
 * cuente cuántas contienen el carácter 'a'.
 */
public class Reto8_CuentaArgumentosA {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No se pasaron argumentos.");
            return;
        }

        int contador = 0;
        for (String s : args) {
            if (s.contains("a") || s.contains("A")) {
                contador++;
            }
        }

        System.out.println("Total de argumentos: " + args.length);
        System.out.println("Argumentos que contienen 'a': " + contador);
    }
}
