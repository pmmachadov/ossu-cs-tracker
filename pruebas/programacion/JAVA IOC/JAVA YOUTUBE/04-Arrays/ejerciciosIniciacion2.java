public class ejerciciosIniciacion2 {

    public static void main(String[] args) {
        int[][] a = new int[3][];
        a[0] = new int[4];
        a[1] = new int[5];

        for (int f = 0; f < a.length; f++) {
            for (int c = 0; a[f] != null && c < a[f].length; c++) {
                System.out.print(a[f][c] + " ");
            }
            System.out.println();
        }
    }
}
