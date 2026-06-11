/**
 * Reto 4 (Sección 2.3): Hacer dos programas:
 * - Uno que muestre por pantalla la tabla de multiplicar del 3.
 * - Otro que muestre la tabla de multiplicar del 5.
 * Ambos usando una constante para el número de la tabla.
 *
 * Este programa unifica ambos mostrando la tabla del 3 y del 5.
 */
public class Reto6_TablaTresYCinco {
    private static final int TABLA = 3;  // constante para la tabla

    public static void main(String[] args) {
        System.out.println("Tabla de multiplicar del " + TABLA + ":");
        System.out.println(TABLA + " x 1 = " + (TABLA * 1));
        System.out.println(TABLA + " x 2 = " + (TABLA * 2));
        System.out.println(TABLA + " x 3 = " + (TABLA * 3));
        System.out.println(TABLA + " x 4 = " + (TABLA * 4));
        System.out.println(TABLA + " x 5 = " + (TABLA * 5));
        System.out.println(TABLA + " x 6 = " + (TABLA * 6));
        System.out.println(TABLA + " x 7 = " + (TABLA * 7));
        System.out.println(TABLA + " x 8 = " + (TABLA * 8));
        System.out.println(TABLA + " x 9 = " + (TABLA * 9));
        System.out.println(TABLA + " x 10 = " + (TABLA * 10));
    }
}
