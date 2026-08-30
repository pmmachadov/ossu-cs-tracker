public class trabajo1 {

    public static void main(String[] args) {
        int a = 48;
        int b = 18;
        int resultado = mcd(a, b);
        System.out.println("MCD(" + a + ", " + b + ") = " + resultado);
    }

    public static int mcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return mcd(b, a % b);
    }
}