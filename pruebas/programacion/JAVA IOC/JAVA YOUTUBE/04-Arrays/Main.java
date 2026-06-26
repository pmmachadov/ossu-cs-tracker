public class Main {
    public static void main(String[] args) {
        int[] notas = { 5, 8, 6, 9 };

        double media = calcularMedia(notas);

        System.out.println("Tu nota media es: " + media);
    }

    static double calcularMedia(int[] notas) {
        int suma = 0;

        for (int n : notas) {
            suma += n;
        }

        return suma / (double) notas.length;
    }
}
