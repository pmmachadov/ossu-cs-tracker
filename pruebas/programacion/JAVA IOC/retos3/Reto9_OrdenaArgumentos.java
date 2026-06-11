/**
 * Reto 9 (U3 - Strings): Usando el método compareTo, ordenar
 * un array de cadenas de texto alfabéticamente.
 */
public class Reto9_OrdenaArgumentos {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No se pasaron argumentos.");
            return;
        }

        // Ordenación por burbuja usando compareTo
        for (int i = 0; i < args.length - 1; i++) {
            for (int j = 0; j < args.length - 1 - i; j++) {
                if (args[j].compareTo(args[j + 1]) > 0) {
                    String temp = args[j];
                    args[j] = args[j + 1];
                    args[j + 1] = temp;
                }
            }
        }

        System.out.println("Argumentos ordenados alfabéticamente:");
        for (String s : args) {
            System.out.println(s);
        }
    }
}
