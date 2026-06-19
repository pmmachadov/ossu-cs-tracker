import java.util.Random;

public class pruebasJAVA {
    public static void main(String[] args) {
        int[] array = crearArray(10);
        mostrarArray(array);
    }

    public static int[] crearArray(int recibido) {
        int[] array = new int[recibido];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(100);
        }
        return array;
    }

    static void mostrarArray(int[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.println("[" + n[i] + "]");
        }
    }
}
