/**
 * Reto 2 (U4 - Programación modular): Completar el código fuente
 * del esqueleto del ejemplo de registro de temperaturas con
 * la declaración de variables globales y métodos necesarios.
 * (Clase base del registro de temperaturas).
 */
import java.util.Scanner;

public class Reto2_RegistroTemperaturas {
    // Constantes
    private static final int MAX_SETMANES = 52;

    // Variables globales
    private float[] temperaturas = new float[MAX_SETMANES * 7];
    private int dia = 1;
    private int mes = 1;
    private int numTemperaturas = 0;
    private Scanner lector = new Scanner(System.in);
    private boolean fin = false;

    public static void main(String[] args) {
        Reto2_RegistroTemperaturas programa = new Reto2_RegistroTemperaturas();
        programa.inicio();
    }

    public void inicio() {
        while (!fin) {
            mostrarMenu();
            tratarOrden();
        }
        System.out.println("Programa finalizado.");
    }

    public void mostrarMenu() {
        System.out.println("\nBienvenido al registro de temperaturas");
        System.out.println("----------------------------------------");
        System.out.println("[RT] Registrar temperaturas semanales.");
        System.out.println("[MJ] Consultar temperatura media.");
        System.out.println("[DF] Consultar diferencia máxima.");
        System.out.println("[FI] Salir.");
        System.out.print("Opción: ");
    }

    public void tratarOrden() {
        String opcion = lector.nextLine().trim().toUpperCase();

        switch (opcion) {
            case "RT":
                entrarRegistroTemperaturas();
                break;
            case "MJ":
                mostrarTemperaturaMedia();
                break;
            case "DF":
                mostrarDiferenciaMaxima();
                break;
            case "FI":
                fin = true;
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public void entrarRegistroTemperaturas() {
        System.out.print("Escribe las temperaturas de esta semana (7 valores): ");
        for (int i = 0; i < 7; i++) {
            if (lector.hasNextFloat()) {
                temperaturas[numTemperaturas] = lector.nextFloat();
                numTemperaturas++;
            }
        }
        lector.nextLine(); // Limpiar buffer
        actualizarFecha();
        System.out.println("Temperaturas registradas. Fecha actual: " + dia + "/" + mes);
    }

    public void actualizarFecha() {
        dia += 7;
        int diasMes = getDiasMes(mes);
        if (dia > diasMes) {
            dia -= diasMes;
            mes++;
            if (mes > 12) {
                mes = 1;
            }
        }
    }

    public int getDiasMes(int m) {
        if (m == 2) return 28;
        if (m == 4 || m == 6 || m == 9 || m == 11) return 30;
        return 31;
    }

    public void mostrarTemperaturaMedia() {
        if (numTemperaturas == 0) {
            System.out.println("No hay temperaturas registradas.");
            return;
        }
        float suma = 0;
        for (int i = 0; i < numTemperaturas; i++) {
            suma += temperaturas[i];
        }
        float media = suma / numTemperaturas;
        System.out.println("Hasta la fecha " + dia + "/" + mes + " la media ha sido de " + media + " grados.");
    }

    public void mostrarDiferenciaMaxima() {
        if (numTemperaturas == 0) {
            System.out.println("No hay temperaturas registradas.");
            return;
        }
        float max = temperaturas[0];
        float min = temperaturas[0];
        for (int i = 1; i < numTemperaturas; i++) {
            if (temperaturas[i] > max) max = temperaturas[i];
            if (temperaturas[i] < min) min = temperaturas[i];
        }
        float diferencia = max - min;
        System.out.println("Hasta la fecha " + dia + "/" + mes + " la diferencia máxima ha sido de " + diferencia + " grados.");
    }
}
