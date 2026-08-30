public class trabajo1 {
 public static void main(String[] args) {
 int a = 3;
 int b = 5;
 int c = metodo(a, b);
 System.out.println(a + " " + b + " " + c);
 }
 static int metodo(int x, int y) {
 x = x + 2;
 y = y + 1;
 return x * y;
 }
}