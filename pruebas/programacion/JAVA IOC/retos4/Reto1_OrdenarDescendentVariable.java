/**
 * Reto 1 (U4 - Programación modular): Modificar el programa de ejemplo
 * de ordenación de forma que, después de mostrar la lista ordenada,
 * en una nueva línea, diga cuántos de los valores son inferiores
 * a la mitad del mayor valor almacenado.
 * Aplicar diseño descendente declarando e invocando nuevos métodos.
 */
import java.util.Scanner;

public class Reto1_OrdenarDescendentVariable {
    private int[] listaEnters = null;
    private Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        Reto1_OrdenarDescendentVariable programa = new Reto1_OrdenarDescendentVariable();
        programa.inicio();
    }

    public void inicio() {
        leerLista();
        ordenarLista();
        mostrarLista();
        contarInferioresMitadMayor();
    }

    public void leerLista() {
        System.out.println("Escribe una lista de valores enteros y pulsa retorno.");
        System.out.println("El primer valor indica el tamaño de la secuencia.");
        leerMida();
        leerValores();
    }

    public void leerMida() {
        System.out.print("Tamaño: ");
        int tamaño = lector.nextInt();
        listaEnters = new int[tamaño];
        lector.nextLine();
    }

    public void leerValores() {
        int index = 0;
        while (index < listaEnters.length) {
            System.out.print("Valor " + (index + 1) + ": ");
            listaEnters[index] = lector.nextInt();
            index++;
        }
        lector.nextLine();
    }

    public void ordenarLista() {
        for (int i = 0; i < listaEnters.length - 1; i++) {
            for (int j = 0; j < listaEnters.length - 1 - i; j++) {
                if (listaEnters[j] > listaEnters[j + 1]) {
                    int temp = listaEnters[j];
                    listaEnters[j] = listaEnters[j + 1];
                    listaEnters[j + 1] = temp;
                }
            }
        }
    }

    public void mostrarLista() {
        System.out.println("Lista ordenada:");
        for (int valor : listaEnters) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    /**
     * Nuevo método: cuenta cuántos valores son inferiores a la mitad
     * del mayor valor almacenado.
     */
    public void contarInferioresMitadMayor() {
        if (listaEnters.length == 0) return;

        int mayor = listaEnters[listaEnters.length - 1];
        double mitad = mayor / 2.0;
        int contador = 0;

        for (int valor : listaEnters) {
            if (valor < mitad) {
                contador++;
            }
        }

        System.out.println("Valores inferiores a la mitad del mayor (" + mitad + "): " + contador);
    }
}
