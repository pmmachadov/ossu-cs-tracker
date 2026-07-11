/**
 * PracticaArrays.java - Ejercicios para practicar arrays y strings
 *
 * Completa los métodos y ejecuta. ¡A escribir código!
 *
 * Compilar: javac PracticaArrays.java && java PracticaArrays
 */
public class PracticaArrays {

    public static void main(String[] args) {
        int[] numeros = {5, 12, 7, 12, 9, 12, 3, 7, 10, 12};
        String[] frutas = {"manzana", "pera", "platano", "fresa", "mango", "melocoton"};

        System.out.println("=== EJERCICIO 1 ===");
        System.out.println(ej1_sumaArray(numeros));     // -> 89

        System.out.println("=== EJERCICIO 2 ===");
        System.out.println(ej2_valorMasGrande(numeros)); // -> 12

        System.out.println("=== EJERCICIO 3 ===");
        System.out.println(ej3_invertirCadena("Hola")); // -> "aloH"

        System.out.println("=== EJERCICIO 4 ===");
        ej4_mostrarFrutasLargas(frutas, 5); // muestra las que tienen >= 5 letras

        System.out.println("=== EJERCICIO 5 ===");
        System.out.println(ej5_contarApariciones(numeros, 12)); // -> 4
    }

    // EJERCICIO 1: Suma todos los números del array
    static int ej1_sumaArray(int[] arr) {
        // TODO: escribe aquí tu código
        return 0;
    }

    // EJERCICIO 2: Encuentra el valor más grande del array
    static int ej2_valorMasGrande(int[] arr) {
        // TODO: escribe aquí tu código
        return 0;
    }

    // EJERCICIO 3: Invierte una cadena (ej: "Hola" -> "aloH")
    static String ej3_invertirCadena(String texto) {
        // TODO: escribe aquí tu código
        return "";
    }

    // EJERCICIO 4: Muestra las palabras que tienen longitud >= minLongitud
    static void ej4_mostrarFrutasLargas(String[] palabras, int minLongitud) {
        // TODO: escribe aquí tu código
    }

    // EJERCICIO 5: Cuenta cuántas veces aparece 'valorBuscado' en el array
    static int ej5_contarApariciones(int[] arr, int valorBuscado) {
        // TODO: escribe aquí tu código
        return 0;
    }
}
