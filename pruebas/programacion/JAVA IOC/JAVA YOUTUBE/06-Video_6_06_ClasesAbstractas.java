class Video_6_06_ClasesAbstractas {

    public static final String TITULO = "6-06 JAVA: Clases abstractas DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=FL7yrY9bU3Q&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=127";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - CLASES ABSTRACTAS (TEMA 6 - V06)\n"
        + "================================================\n\n"
        + "CLASE ABSTRACTA:\n"
        + "- Clase que NO se puede instanciar directamente.\n"
        + "- Sirve como PLANTILLA para otras clases.\n"
        + - Debe tener al menos un metodo abstracto (aunque puede tener otros)."
        + "- Se declara con: public abstract class NombreClase\n\n"
        + "METODO ABSTRACTO:\n"
        + "- Solo tiene CABECERA (sin llaves, sin cuerpo).\n"
        + "- Se declara con: public abstract TipoRetorno nombre(params);\n"
        + "- Las clases hijas ESTAN OBLIGADAS a implementarlo.\n"
        + "- Define QUE se debe hacer, no COMO.\n\n"
        + "REGLAS:\n"
        + "- Una clase abstracta PUEDE tener constructor.\n"
        + "- El constructor solo se llama con super() desde una subclase.\n"
        + "- Una subclase puede ser abstracta si no implementa todos los metodos.\n"
        + "- Si una subclase no implementa todos los metodos abstractos -> tambien abstracta.\n\n"
        + "EJEMPLO:\n"
        + "abstract class Figura2D {\n"
        + "    private int numeroLados;\n"
        + "    Figura2D(int n) { numeroLados = n; }\n"
        + "    public abstract double area();\n"
        + "}\n\n"
        + "class Triangulo extends Figura2D {\n"
        + "    private Punto2D p1, p2, p3;\n"
        + "    Triangulo(Punto2D a, Punto2D b, Punto2D c) {\n"
        + "        super(3);  // triangulo tiene 3 lados\n"
        + "        this.p1 = a; this.p2 = b; this.p3 = c;\n"
        + "    }\n"
        + "    public double area() {  // OBLIGATORIO implementar\n"
        + "        // Formula de Heron con punto2D.distancia()\n"
        + "    }\n"
        + "}\n\n"
        + "DIFERENCIA CON INTERFACE:\n"
        + "- Clase abstracta: puede tener metodos concretos y atributos.\n"
        + "- Interface: solo metodos abstractos (Java 8+ permite default).";

    // ================================================================
    // CLASE ABSTRACTA FIGURA2D
    // ================================================================
    abstract static class Figura2D {
        private int numeroLados;

        // Constructor (solo accesible via super() desde subclase)
        Figura2D(int numeroLados) {
            this.numeroLados = numeroLados;
        }

        int getNumeroLados() { return numeroLados; }

        // METODO ABSTRACTO (sin cuerpo)
        abstract double area();
    }

    // ================================================================
    // CLASE PUNTO2D (con doubles para mayor precision)
    // ================================================================
    static class Punto2D {
        private double x, y;

        Punto2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double getX() { return x; }
        double getY() { return y; }

        // Metodo estatico: distancia entre dos puntos
        static double distancia(Punto2D p1, Punto2D p2) {
            return Math.sqrt(Math.pow(p1.x - p2.x, 2)
                           + Math.pow(p1.y - p2.y, 2));
        }

        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    // ================================================================
    // CLASE TRIANGULO (hereda de Figura2D)
    // ================================================================
    static class Triangulo extends Figura2D {
        private Punto2D p1, p2, p3;

        Triangulo(Punto2D p1, Punto2D p2, Punto2D p3) {
            super(3);  // Triangulo tiene 3 lados
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
        }

        // Implementacion OBLIGATORIA del metodo abstracto area()
        double area() {
            double a = Punto2D.distancia(p1, p2);
            double b = Punto2D.distancia(p2, p3);
            double c = Punto2D.distancia(p3, p1);
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        void mostrarInfo() {
            System.out.println("  Triangulo con vertices: "
                + p1 + ", " + p2 + ", " + p3);
            System.out.println("  Lados: " + getNumeroLados());
            System.out.println("  Area: " + area());
        }
    }

    // ================================================================
    // CLASE RECTANGULO (hereda de Figura2D)
    // ================================================================
    static class Rectangulo extends Figura2D {
        private double base, altura;

        Rectangulo(double base, double altura) {
            super(4);  // Rectangulo tiene 4 lados
            this.base = base;
            this.altura = altura;
        }

        double area() {
            return base * altura;
        }

        void mostrarInfo() {
            System.out.println("  Rectangulo: base=" + base + ", altura=" + altura);
            System.out.println("  Lados: " + getNumeroLados());
            System.out.println("  Area: " + area());
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V06: CLASES ABSTRACTAS");
        System.out.println();

        // ============================================================
        // Demostracion de clases abstractas
        // ============================================================
        System.out.println("=== NO se puede instanciar Figura2D ===");
        System.out.println("  Figura2D f = new Figura2D(3);  // ERROR! Clase abstracta");
        System.out.println();

        // ============================================================
        // Triangulo
        // ============================================================
        System.out.println("=== TRIANGULO (hereda de Figura2D) ===");
        Punto2D a = new Punto2D(0, 0);
        Punto2D b = new Punto2D(3, 0);
        Punto2D c = new Punto2D(0, 4);

        Triangulo t = new Triangulo(a, b, c);
        t.mostrarInfo();
        System.out.println("  (Area = 6.0 porque es un triangulo rectangulo 3-4-5)");
        System.out.println();

        // ============================================================
        // Rectangulo
        // ============================================================
        System.out.println("=== RECTANGULO (hereda de Figura2D) ===");
        Rectangulo r = new Rectangulo(5, 3);
        r.mostrarInfo();
        System.out.println();

        // ============================================================
        // Polimorfismo con clase abstracta
        // ============================================================
        System.out.println("=== POLIMORFISMO CON CLASE ABSTRACTA ===");
        Figura2D[] figuras = {t, r};
        for (Figura2D f : figuras) {
            System.out.println("  Figura con " + f.getNumeroLados() + " lados: area = " + f.area());
        }
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 6 - V06: CLASES ABSTRACTAS)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Clase abstracta: no se puede instanciar");
        System.out.println("  - Metodo abstracto: solo cabecera, sin cuerpo");
        System.out.println("  - Las subclases DEBEN implementar metodos abstractos");
        System.out.println("  - Sirve como plantilla para otras clases");
        System.out.println("  - Polimorfismo funciona igual que con clases normales");
        System.out.println("  - Constructor existe pero solo via super()");
    }
}
