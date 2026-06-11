/**
 * Reto 4 (U4 - Programación modular): Codificar el método mostrarDiferencia.
 * Este método muestra por pantalla la diferencia de temperatura calculada
 * y la fecha actual formateada con el mes en texto.
 */
public class Reto4_MostrarDiferencia {

    private static final String[] NOMBRES_MES = {
        "", "enero", "febrero", "marzo", "abril", "mayo", "junio",
        "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
    };

    public static void mostrarDiferencia(float diferencia, int dia, int mes) {
        if (diferencia < 0) {
            System.out.println("No hay temperaturas registradas.");
            return;
        }
        System.out.println("Hasta la fecha " + dia + " de " + NOMBRES_MES[mes]
            + " la diferencia máxima ha sido de " + diferencia + " grados.");
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        float diferencia = 3.5f;
        mostrarDiferencia(diferencia, 8, 1);
    }
}
