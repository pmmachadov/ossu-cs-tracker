/**
 * Reto 6 (Sección 2.5): Realizar un programa que muestre por pantalla
 * la tabla de verdad de la disyunción lógica (OR).
 * Muestra A, B y (A || B) para todas las combinaciones.
 */
public class Reto8_TaulaVeritatDisjuncio {
    public static void main(String[] args) {
        System.out.println("A\tB\t(A || B)");
        System.out.println("false\tfalse\t" + (false || false));
        System.out.println("false\ttrue\t" + (false || true));
        System.out.println("true\tfalse\t" + (true || false));
        System.out.println("true\ttrue\t" + (true || true));
    }
}
