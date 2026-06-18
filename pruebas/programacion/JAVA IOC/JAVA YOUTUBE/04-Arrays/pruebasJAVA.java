import java.util.Random;

public class pruebasJAVA {

    int elementos = 100;

    public static void main(String[] args) {
        int[] array = crearArray(10);
        mostrarArray(array);
    }

    static void mostrarArray(int[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.println("[" + n[i] + "]");
        }
    }

    public static int[] crearArray(int elementos) {
        int[] array = new int[elementos];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(1000);
        }
        return array;
    }
}
