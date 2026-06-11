/**
 * Reto 6 (U5 - javadoc): Intentar ejecutar el javadoc desde el
 * entorno de desarrollo para generar documentación a partir
 * de comentarios con formato javadoc.
 *
 * Para generar javadoc desde consola:
 *   javadoc -d doc Reto6_Documentacion.java
 *
 * @author Estudiante
 * @version 1.0
 */
public class Reto6_Documentacion {

    /** Número máximo de elementos permitidos. */
    public static final int MAX_ELEMENTOS = 100;

    /**
     * Calcula la suma de dos números enteros.
     *
     * @param a Primer operando
     * @param b Segundo operando
     * @return La suma de a y b
     */
    public static int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Método principal de prueba.
     *
     * @param args Argumentos de línea de comandos (no usados)
     */
    public static void main(String[] args) {
        System.out.println("Ejemplo de documentación javadoc.");
        System.out.println("Suma: " + sumar(5, 3));
        System.out.println("\nEjecuta: javadoc -d doc Reto6_Documentacion.java");
    }
}
