public class EjerciciosIniciacion {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 1, 1, 0};
        ejercicio1(array, 1);
        String[] palabras = {"a", "aa", "aaa", "bbb", "bbbaaa", "Acc"};
        ejercicio2(palabras);
        ejercicio3(palabras, 'a');
    }

    static void ejercicio3(String[] palabras, char letra) {
        char letraLower = Character.toLowerCase(letra);
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].toLowerCase().charAt(0) == letraLower) {
                System.out.println(palabras[i]);
            }
        }
    }

    static void ejercicio2(String[] palabras) {
        String palabraMax = "";
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].length() > palabraMax.length()) {
                palabraMax = palabras[i];
            }
        }
        System.out.println("La palabra mas larga es " + palabraMax);
    }

    static void ejercicio1(int[] array, int n) {
        int contador = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n)
                contador++;
        }

        if (contador == 0) {
            System.out.println("El valor " + n + " no aparece en el Array.");
        } else {
            System.out.println("El valor " + n + " aparece " + contador + (contador == 1 ? " vez" : " veces") + " en el Array.");
        }
    }
}
