public class EjerciciosIniciacion {

    public static void main(String[] args) {

        int[][] matriz = new int[5][10];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = fila;
                System.out.print(matriz[fila][columna] + " ");
            }
            System.out.println();
        }
    }
}
