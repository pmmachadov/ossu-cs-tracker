public class Main {

    static class Calculo {
        static float calcularMedia(float[] temperaturas, int cantidad) {
            float sumaTemperaturas = 0;
            for (int indice = 0; indice < cantidad; indice++) {
                sumaTemperaturas += temperaturas[indice];
            }
            return sumaTemperaturas / cantidad;
        }
    }

    public static void main(String[] args) {
        float[] temperaturas = { 20.5f, 21.0f, 19.5f };

        float mediaCalculada = Calculo.calcularMedia(temperaturas, 3);

        System.out.println("Media: " + mediaCalculada);
    }
}
