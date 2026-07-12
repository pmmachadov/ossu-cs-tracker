public class Practica2 {
    public static void main(String[] args) {
        String cad = "AB";
        for (int i = 0; i < 2; i++) {
            cad += cad + 1 + 2;
        }
        System.out.println("Cad es: " + cad + " y tiene " + cad.length() + " caracteres");
    }
}
