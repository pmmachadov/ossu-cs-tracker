public class PrimerosPrimos {

    public static void main(String[] args) {
        int[] primos = primerosPrimos(3);
        for (int p : primos) {
            System.out.println(p);
        }
    }

    // Devuelve los n primeros numeros primos (2, 3, 5, 7, ...)
    static int[] primerosPrimos(int n) {
        int[] primos = new int[n];
        int encontrados = 0;
        int candidato = 2;
        while (encontrados < n) {
            if (esPrimo(candidato)) {
                primos[encontrados] = candidato;
                encontrados++;
            }
            candidato++;
        }
        return primos;
    }

    static boolean esPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
