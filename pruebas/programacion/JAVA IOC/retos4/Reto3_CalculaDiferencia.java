/**
 * Reto 3 (U4 - Programación modular): Codificar el método calculaDiferencia.
 * Este método busca los valores máximo y mínimo entre las temperaturas
 * registradas y devuelve su diferencia.
 */
public class Reto3_CalculaDiferencia {

    /**
     * Calcula la diferencia entre la temperatura máxima y mínima.
     * @param temps Array de temperaturas
     * @param numTemps Número de temperaturas registradas
     * @return Diferencia entre máxima y mínima, o -1 si no hay datos
     */
    public static float calculaDiferencia(float[] temps, int numTemps) {
        if (numTemps <= 0) {
            return -1;
        }

        float max = temps[0];
        float min = temps[0];

        for (int i = 1; i < numTemps; i++) {
            if (temps[i] > max) max = temps[i];
            if (temps[i] < min) min = temps[i];
        }

        return max - min;
    }

    public static void main(String[] args) {
        float[] temperaturas = {20.5f, 21.1f, 19.8f, 22.0f, 20.0f, 18.5f, 21.5f};
        float diferencia = calculaDiferencia(temperaturas, temperaturas.length);
        System.out.println("La diferencia máxima es: " + diferencia + " grados.");
    }
}
