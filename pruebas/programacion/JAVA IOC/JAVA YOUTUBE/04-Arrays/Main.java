public class Main {
    public static void main(String[] args) {
        cadena("Hola", 0);
    }

    static void cadena(String cad, int n) {
        if (n == 3)
            System.out.println(cad);
        else
            cadena(cad + n, n + 1);
    }
}
