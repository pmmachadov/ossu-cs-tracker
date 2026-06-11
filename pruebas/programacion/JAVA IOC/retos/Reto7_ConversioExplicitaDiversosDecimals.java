/**
 * Reto 5 (Sección 2.4): Experimentar qué pasa si en el programa anterior
 * se inicializa la variable real "Largo" con un valor con varios decimales
 * y se asigna a un entero largo. Luego probar asignando un valor superior
 * al rango de los enteros (por ejemplo, 3000000000.0).
 */
public class Reto7_ConversioExplicitaDiversosDecimals {
    public static void main(String[] args) {
        double realLargo = 3000000000.0;

        // Conversión explícita (cast) de double a long
        long enterLlarg = (long) realLargo;

        System.out.println("Valor real original: " + realLargo);
        System.out.println("Valor convertido a long: " + enterLlarg);

        // Probar con un valor con decimales
        double realConDecimales = 1234.56789;
        long enterTruncado = (long) realConDecimales;
        System.out.println("\nReal con decimales: " + realConDecimales);
        System.out.println("Convertido a long (truncado): " + enterTruncado);
    }
}
