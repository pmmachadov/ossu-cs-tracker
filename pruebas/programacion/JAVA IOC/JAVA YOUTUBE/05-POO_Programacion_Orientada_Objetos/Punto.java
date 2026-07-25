public class Punto {
    public int x;
    public int y;

    public Punto(int n) {
        this.x = n;
        this.y = n;
    }

    public Punto(int a, int b) {
        this.x = a;
        this.y = b;
    }

    public double calcularDistanciaCentro() {
        return Math.sqrt(x * x + y * y);
    }

    public void mostrarDatos() {
        System.out.println("Punto(" + x + ", " + y + ")");
    }
}
