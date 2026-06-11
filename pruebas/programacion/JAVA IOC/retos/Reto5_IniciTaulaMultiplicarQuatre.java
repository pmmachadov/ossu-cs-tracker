/**
 * Reto 3 (Sección 2.3): Hacer un programa con dos variables que, sin usar
 * ningún literal en ninguna parte excepto para inicializar estas variables,
 * vaya calculando e imprimiendo sucesivamente los 5 primeros valores
 * de la tabla de multiplicar del 4.
 */
public class Reto5_IniciTaulaMultiplicarQuatre {
    public static void main(String[] args) {
        int a = 4;  // único literal para inicializar (el número base)
        int b = 1;  // único literal para inicializar (el multiplicador)

        System.out.println("Tabla de multiplicar del 4 (primeros 5 valores):");
        System.out.println(a + " x " + b + " = " + (a * b));
        b = b + 1;
        System.out.println(a + " x " + b + " = " + (a * b));
        b = b + 1;
        System.out.println(a + " x " + b + " = " + (a * b));
        b = b + 1;
        System.out.println(a + " x " + b + " = " + (a * b));
        b = b + 1;
        System.out.println(a + " x " + b + " = " + (a * b));
    }
}
