public class ejerciciosIniciacion2 {

    public static void main(String[] args) {
        int[][] b = new int[3][];
        b[0] = new int[4];
        b[1] = new int[5];

        for (int fila = 0; fila < b.length; fila++) {
            for (int columna = 0; b[fila] != null && columna < b[fila].length; columna++) {
                System.out.print(b[fila][columna] + " ");
            }
            System.out.println();
        }
    }

}
