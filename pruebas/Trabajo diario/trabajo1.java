public class trabajo1 {
    public static void main(String[] args) {
        int[][] m = new int[3][3];
        int diagP = 0, diagS = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m[i][j] = i * j;
                if (i == j) {
                    diagP += m[i][j];
                }
                if (i + j == 2) {
                    diagS += m[i][j];
                }
            }
        }

        System.out.println("Diagonal principal: " + diagP);
        System.out.println("Diagonal secundaria: " + diagS);
    }
}