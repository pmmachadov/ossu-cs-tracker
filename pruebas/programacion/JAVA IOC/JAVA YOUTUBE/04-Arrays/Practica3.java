public class Practica3 {
    public static void main(String[] args) {
        int a = 1, b = 2;

        if (++a > b++) {
            a += 5;
        } else {
            b += 5;
        }

        System.out.println(a + " y " + b);
    }
}
