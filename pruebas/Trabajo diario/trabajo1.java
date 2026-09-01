// Programa de prueba principal
public class trabajo1 {
    public static void main(String[] args) {
        Rectangulo r = new Rectangulo(4, 6);
        Rectangulo c = new Rectangulo(5);

        System.out.println(r + " área: " + r.area());
        System.out.println(c + " perímetro: " + c.perimetro());
    }
}

class Rectangulo {
    private double ancho;
    private double alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public Rectangulo(double lado) {
        this(lado, lado);  // cuadrado
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double area() {
        return ancho * alto;
    }

    public double perimetro() {
        return 2 * (ancho + alto);
    }

    @Override
    public String toString() {
        return ancho + "x" + alto;
    }
}
