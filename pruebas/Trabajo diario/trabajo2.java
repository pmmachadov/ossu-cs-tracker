public class trabajo2 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println("=== INICIO DEL DEBUG DE FACTORIAL ===");
        int resultado = fact(n);
        System.out.println("=== FIN: Resultado final de fact(" + n + ") = " + resultado + " ===");
    }

    static int fact(int n) {
        System.out.println("-> Entrando a fact(" + n + ")");
        
        if (n <= 1) {
            System.out.println("   [Caso Base alcanzado] n = " + n + " -> devuelve 1");
            return 1;
        }

        int subResultado = fact(n - 1);
        int total = n * subResultado;
        
        System.out.println("<- Retornando de fact(" + n + "): " + n + " * fact(" + (n - 1) + ") [" + subResultado + "] = " + total);
        return total;
    }
}