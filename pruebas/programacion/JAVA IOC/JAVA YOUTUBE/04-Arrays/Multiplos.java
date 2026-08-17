import java.util.Scanner;

public class Multiplos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n: ");
        int n = sc.nextInt();
        int suma = 0;
        for (int i = 1; i < n; i++)
            if (i % 3 == 0 || i % 5 == 0)
                suma += i;
        System.out.println("Suma: " + suma);
    }
}
p
