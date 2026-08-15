public class Practica1 {

    public static void main(String[] args) {
        imprimirTriangulo(5);
    }

    public static void imprimirTriangulo(int filas) {

        for (int i = 1; i <= filas; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}
