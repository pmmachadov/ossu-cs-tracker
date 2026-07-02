import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r1 = new Random();

        for (int i = 0; i < 5; i++) {
            int a = r1.nextInt(100);
            System.out.println(a);
        }

        Random r2 = new Random(42);

        for (int i = 0; i < 5; i++) {
            int a = r2.nextInt(100);
            System.out.println(a);
        }
    }
}
