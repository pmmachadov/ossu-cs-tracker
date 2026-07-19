public class Punto {

    public int x;
    public int y;
    String nombre;

    public Punto(int a) {
        x = a;
        y = a;
        nombre = "Constructor con 1 parametro";
    }

    public Punto(int a, int b) {
        x = a;
        y = b;
        nombre = "Constructor con 2 parametros";

    }

    public Punto() {
        x = 0;
        y = 0;
    }

    public double calcularDistanciaCentro() {
        return Math.sqrt(x * x + y * y);
    }

    public void mostrarDatos() {
        System.out.println(x);
        System.out.println(y);
        System.out.println(nombre);

    }
}
