/**
 * Reto 2 (Sección 2.2): Crear el siguiente programa que usa un entero
 * muy grande (3000000000). Observar qué ocurre exactamente y luego
 * intentar arreglar el problema.
 */
public class Reto4_TresMilMillones {
    public static void main(String[] args) {
        // Este literal 3000000000 excede el rango de int (2.147.483.648)
        // Solución: usar long (añadiendo L al final)
        System.out.println(3000000000L);
    }
}
