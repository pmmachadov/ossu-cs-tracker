/**
 * Reto 3 (U5 - Packages): Modificar el ejemplo del registro de
 * temperaturas de forma que la clase RegistroTemperaturas pertenezca
 * al package unidad5.apartado1.reto3 y la clase CalculsArrayReals
 * en el package utilitats.arrays.
 *
 * Nota: Colocar en carpeta unidad5/apartado1/reto3/ para compilar.
 */
package unidad5.apartado1.reto3;

import utilitats.arrays.CalculsArrayReals;

public class Reto3_RegistroTemperaturas {
    private static final int MAX_SETMANES = 52;
    private float[] temperaturas = new float[MAX_SETMANES * 7];
    private int numTemperaturas = 0;

    public void agregarTemperatura(float temp) {
        if (numTemperaturas < temperaturas.length) {
            temperaturas[numTemperaturas] = temp;
            numTemperaturas++;
        }
    }

    public float getMedia() {
        return CalculsArrayReals.calcularMedia(temperaturas, numTemperaturas);
    }

    public static void main(String[] args) {
        Reto3_RegistroTemperaturas reg = new Reto3_RegistroTemperaturas();
        reg.agregarTemperatura(20.5f);
        reg.agregarTemperatura(21.0f);
        reg.agregarTemperatura(19.5f);

        System.out.println("Media de temperaturas: " + reg.getMedia());
    }
}
