public class Main {

    public static void main(String[] args) {

        int a = 1, b = 2;
        if (++a == b)
            a++;
        for (int i = 0; i < a; i += 2) {
            a += i;
            i++;
        }

    }
}
