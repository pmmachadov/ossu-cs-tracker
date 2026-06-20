public class Main {
    public static void main(String[] args) {
        String[] palabras = {"hola", "adios", "casa", "arbol"};
        ejercicio3(palabras, 'a');
    }

    static void ejercicio3(String[] palabras, char letra) {
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].charAt(0) == letra) {
                System.out.println(palabras[i]);
            }
        }
    }
}