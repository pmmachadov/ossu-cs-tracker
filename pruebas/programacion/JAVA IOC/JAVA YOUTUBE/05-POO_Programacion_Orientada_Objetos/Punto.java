class Punto {
    private double x;
    private double y;

    public Punto(double x) {
        this.x = x;
        this.y = 0;
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calcularDistanciaCentro() {
        double z;
        z = Math.sqrt((x * x) + (y * y));
        return z;
    }

    private void mostrarDatos() {
        System.out.println("X=" + x);
        System.out.println("Y=" + y);
        System.out.println("La distancia respecto al centro es: " + calcularDistanciaCentro());
        System.out.println("-----------------------------");
    }

    public void mostrarDatos(String s) {
        System.out.println(s);
        mostrarDatos();
    }
}
