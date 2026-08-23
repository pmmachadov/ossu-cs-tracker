public class Main {
    static boolean esPrimo(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int encontrados = 0, n = 2;
        while (encontrados < 10) {
            if (esPrimo(n)) {
                System.out.println(n);
                encontrados++;
            }
            n++;
        }
    }
}

