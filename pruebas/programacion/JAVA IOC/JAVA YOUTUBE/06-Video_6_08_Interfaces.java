class Video_6_08_Interfaces {

    public static final String TITULO = "6-08 JAVA: Interfaces DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=yqfOawJPE3M&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=129";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - INTERFACES (TEMA 6 - V08)\n"
        + "==========================================\n\n"
        + "INTERFAZ: coleccion de metodos abstractos y constantes.\n"
        + "- Similar a una clase abstracta, pero TODOS los metodos son abstractos.\n"
        + - Soluciona la falta de herencia multiple en Java."
        + "- Se define con: interface Nombre { ... }\n"
        + "- Se implementa con: class Clase implements Interfaz { ... }\n\n"
        + "CARACTERISTICAS:\n"
        + "- Todos los metodos son public y abstract (no hace falta indicarlo).\n"
        + "- Todos los atributos son public static final (constantes).\n"
        + "- Una clase puede implementar VARIAS interfaces (separadas por comas).\n"
        + "- Una interfaz puede EXTENDER otra interfaz.\n"
        + "- Java 8+ permite metodos default con implementacion.\n\n"
        + "EJEMPLO:\n"
        + "interface Forma {\n"
        + "    void dibujar();\n"
        + "    double area();\n"
        + "}\n\n"
        + "class Rectangulo implements Forma {\n"
        + "    private double ancho, largo;\n"
        + "    Rectangulo(double a, double l) { ancho = a; largo = l; }\n"
        + "    public void dibujar() { System.out.println(\"Rectangulo dibujado\"); }\n"
        + "    public double area() { return ancho * largo; }\n"
        + "}\n\n"
        + "IMPLEMENTACION MULTIPLE:\n"
        + "interface Color { String getColor(); }\n"
        + "class Cuadrado implements Forma, Color { ... }\n\n"
        + "COMPARATIVA:\n"
        + "- Clase abstracta: puede tener metodos concretos y atributos.\n"
        + "- Interface: solo metodos abstractos (salvo default) y constantes.\n"
        + "- Java no permite herencia multiple de clases, pero SI de interfaces.";

    // ================================================================
    // INTERFAZ FORMA
    // ================================================================
    interface Forma {
        void dibujar();    // public abstract implicito
        double area();     // public abstract implicito
    }

    // ================================================================
    // INTERFAZ COLOR
    // ================================================================
    interface Color {
        String getColor(); // public abstract implicito
    }

    // ================================================================
    // CLASE RECTANGULO (implementa Forma)
    // ================================================================
    static class Rectangulo implements Forma {
        private double ancho, largo;

        Rectangulo(double ancho, double largo) {
            this.ancho = ancho;
            this.largo = largo;
        }

        public void dibujar() {
            System.out.println("  Rectangulo dibujado (" + ancho + "x" + largo + ")");
        }

        public double area() {
            return ancho * largo;
        }
    }

    // ================================================================
    // CLASE CIRCULO (implementa Forma)
    // ================================================================
    static class Circulo implements Forma {
        private double radio;

        Circulo(double radio) {
            this.radio = radio;
        }

        public void dibujar() {
            System.out.println("  Circulo dibujado (radio=" + radio + ")");
        }

        public double area() {
            return Math.PI * radio * radio;
        }
    }

    // ================================================================
    // CLASE CUADRADO (implementa DOS interfaces: Forma y Color)
    // ================================================================
    static class Cuadrado implements Forma, Color {
        private double lado;
        private String color;

        Cuadrado(double lado, String color) {
            this.lado = lado;
            this.color = color;
        }

        public void dibujar() {
            System.out.println("  Cuadrado dibujado (lado=" + lado + ")");
        }

        public double area() {
            return lado * lado;
        }

        public String getColor() {
            return color;
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V08: INTERFACES");
        System.out.println();

        // ============================================================
        // EJEMPLO 1: Polimorfismo con interfaces
        // ============================================================
        System.out.println("=== POLIMORFISMO CON INTERFACES ===");
        Forma[] formas = {
            new Rectangulo(4, 5),
            new Circulo(3),
            new Cuadrado(2, "Rojo")
        };

        for (Forma f : formas) {
            f.dibujar();
            System.out.println("  Area: " + f.area());
            System.out.println();
        }

        // ============================================================
        // EJEMPLO 2: Implementacion multiple
        // ============================================================
        System.out.println("=== IMPLEMENTACION MULTIPLE ===");
        Cuadrado cuad = new Cuadrado(10, "Azul");
        cuad.dibujar();
        System.out.println("  Area: " + cuad.area());
        System.out.println("  Color: " + cuad.getColor());
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Referencia de interfaz
        // ============================================================
        System.out.println("=== REFERENCIA DE INTERFAZ ===");
        Forma fRef = new Circulo(5);
        fRef.dibujar();
        System.out.println("  Area: " + fRef.area());
        System.out.println();

        Color cRef = new Cuadrado(3, "Verde");
        System.out.println("  Color del cuadrado: " + cRef.getColor());
        System.out.println();

        // ============================================================
        // COMPARATIVA
        // ============================================================
        System.out.println("=== COMPARATIVA ===");
        System.out.println("  Clase abstracta vs Interface:");
        System.out.println("  - Abstracta: metodos abstractos + concretos, atributos");
        System.out.println("  - Interface: solo metodos abstractos + constantes");
        System.out.println("  - Java: herencia simple de clases, multiple de interfaces");
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 6 - V08: INTERFACES)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - interface: coleccion de metodos abstractos");
        System.out.println("  - implements: una clase implementa una interfaz");
        System.out.println("  - Una clase puede implementar VARIAS interfaces");
        System.out.println("  - Una interfaz puede EXTENDER otra interfaz");
        System.out.println("  - Todos los metodos son public abstract");
        System.out.println("  - Todos los atributos son public static final");
        System.out.println("  - Polimorfismo funciona igual que con clases");
    }
}
