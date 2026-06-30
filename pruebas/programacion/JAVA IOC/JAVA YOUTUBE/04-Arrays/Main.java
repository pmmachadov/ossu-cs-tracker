public class Main {

    static float calculaDiferencia(float[] t, int n) {
        if (n <= 0)
            return -1;

        float max = t[0];
        float min = t[0];

        for (int i = 1; i < n; i++) {
            if (t[i] > max)
                max = t[i];
            if (t[i] < min)
                min = t[i];
        }

        return max - min;
    }

    public static void main(String[] args) {
        System.out.println("Dif: " + calculaDiferencia(new float[] { 20.5f, 21.1f, 19.8f, 22f }, 4));
    }
}
