public class trabajo1 {

    public static void main(String[] args) {
        int n = 6;
        int resultado = fib(n);
        System.out.println("fib(" + n + ") = " + resultado);
    }

    public static int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        
        // Marco en espera del primer sumando
        int fib1 = fib(n - 1);
        
        // Marco en espera del segundo sumando
        int fib2 = fib(n - 2);
        
        // Suma de retornos antes de desapilar
        int total = fib1 + fib2;
        return total;
    }
}