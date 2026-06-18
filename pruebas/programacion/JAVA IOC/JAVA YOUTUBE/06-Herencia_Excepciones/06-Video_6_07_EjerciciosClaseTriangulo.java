import java.text.DecimalFormat;

class Video_6_07_EjerciciosClaseTriangulo {

    public static final String TITULO = "6-07 JAVA: Ejercicios Clase Triangulo DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=ZyZ6Tbg9HkM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=128";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - EJERCICIOS CLASE TRIANGULO (TEMA 6 - V07)\n"
        + "======================================================\n\n"
        + "METODOS ANIDADOS A LA CLASE TRIANGULO:\n\n"
        + "1. perimetro(): suma de los 3 lados usando Punto2D.distancia()\n\n"
        + "2. esTriangulo(): comprueba si es un triangulo valido.\n"
        + "   - Opcion A: area() > 0\n"
        + "   - Opcion B: pendientes distintas (menos calculos)\n\n"
        + "3. Constantes de tipo: NO_TRIANGULO, EQUILATERO, ISOSCELES, ESCALENO\n"
        + "   - Atributo privado tipo (byte)\n"
        + "   - setTipo(): se invoca en el constructor\n"
        + "   - tipoTriangulo(): devuelve String segun el tipo\n\n"
        + "4. toString() personalizado:\n"
        + "   - Muestra tipo, area, perimetro y los 3 puntos\n"
        + "   - Redondeo a 1 decimal: Math.round(valor * 10) / 10.0\n\n"
        + "REDONDEO:\n"
        + "  double areaRedondeada = Math.round(area * 10) / 10.0;\n"
        + "  Importante: dividir entre 10.0 (double) no 10 (int)\n\n"
        + "PROBLEMA DE PRECISION:\n"
        + "  Al comparar doubles (ej: lados de triangulo equilatero),\n"
        + "  la precision puede fallar. Solucion: redondear antes de comparar.\n"
        + "  Math.round(distancia * 1000) / 1000.0";

    // ================================================================
    // CLASE ABSTRACTA FIGURA2D
    // ================================================================
    abstract static class Figura2D {
        private int numeroLados;

        Figura2D(int n) { numeroLados = n; }
        int getNumeroLados() { return numeroLados; }
        abstract double area();
    }

    // ================================================================
    // CLASE PUNTO2D
    // ================================================================
    static class Punto2D {
        private double x, y;

        Punto2D(double x, double y) { this.x = x; this.y = y; }
        double getX() { return x; }
        double getY() { return y; }

        static boolean distintos(Punto2D p1, Punto2D p2) {
            return p1.x != p2.x || p1.y != p2.y;
        }

        static double distancia(Punto2D p1, Punto2D p2) {
            return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        }

        public String toString() {
            return "[x=" + x + ", y=" + y + "]";
        }
    }

    // ================================================================
    // CLASE TRIANGULO
    // ================================================================
    static class Triangulo extends Figura2D {
        // Constantes de tipo de triangulo
        static final byte NO_TRIANGULO = 0;
        static final byte EQUILATERO = 1;
        static final byte ISOSCELES = 2;
        static final byte ESCALENO = 3;

        private Punto2D p1, p2, p3;
        private byte tipo;

        Triangulo(Punto2D p1, Punto2D p2, Punto2D p3) {
            super(3);
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            setTipo();
        }

        // ---- METODOS DEL EJERCICIO ----

        // 1. Perimetro
        double perimetro() {
            return Punto2D.distancia(p1, p2)
                 + Punto2D.distancia(p2, p3)
                 + Punto2D.distancia(p3, p1);
        }

        // 2. Es triangulo valido? (por area)
        boolean esTriangulo() {
            return area() > 0;
        }

        // 3. Establecer el tipo (se llama desde el constructor)
        private void setTipo() {
            if (!esTriangulo()) {
                tipo = NO_TRIANGULO;
                return;
            }

            // Redondeamos a 3 decimales para evitar problemas de precision
            double a = Math.round(Punto2D.distancia(p1, p2) * 1000) / 1000.0;
            double b = Math.round(Punto2D.distancia(p2, p3) * 1000) / 1000.0;
            double c = Math.round(Punto2D.distancia(p3, p1) * 1000) / 1000.0;

            if (a == b && b == c) {
                tipo = EQUILATERO;
            } else if (a != b && b != c && a != c) {
                tipo = ESCALENO;
            } else {
                tipo = ISOSCELES;
            }
        }

        // 4. Tipo de triangulo como String
        String tipoTriangulo() {
            switch (tipo) {
                case EQUILATERO: return "Equilatero";
                case ISOSCELES:  return "Isosceles";
                case ESCALENO:   return "Escaleno";
                default:         return "No triangulo";
            }
        }

        // 5. Area (implementacion del metodo abstracto)
        double area() {
            double aVal = Punto2D.distancia(p1, p2);
            double bVal = Punto2D.distancia(p2, p3);
            double cVal = Punto2D.distancia(p3, p1);
            double s = (aVal + bVal + cVal) / 2;
            return Math.sqrt(s * (s - aVal) * (s - bVal) * (s - cVal));
        }

        // 6. toString() con redondeo a 1 decimal
        public String toString() {
            if (!esTriangulo()) {
                return "Triangulo no valido";
            }

            double areaRedon = Math.round(area() * 10) / 10.0;
            double perimRedon = Math.round(perimetro() * 10) / 10.0;

            return "Triangulo es de tipo " + tipoTriangulo().toLowerCase()
                + " de area " + areaRedon + " y perimetro " + perimRedon
                + "\nSus puntos son: " + p1 + ", " + p2 + ", " + p3;
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V07: EJERCICIOS CLASE TRIANGULO");
        System.out.println();

        // ============================================================
        // EJEMPLO 1: No triangulo (puntos en misma coordenada)
        // ============================================================
        System.out.println("=== 1. NO TRIANGULO (puntos iguales) ===");
        Punto2D p1 = new Punto2D(0, 0);
        Punto2D p2 = new Punto2D(0, 0);
        Punto2D p3 = new Punto2D(0, 0);

        Triangulo t1 = new Triangulo(p1, p2, p3);
        System.out.println("  " + t1);
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Triangulo Isosceles (0,0)-(1,0)-(0,1)
        // ============================================================
        System.out.println("=== 2. ISOSCELES ===");
        p2 = new Punto2D(1, 0);
        p3 = new Punto2D(0, 1);

        t1 = new Triangulo(p1, p2, p3);
        System.out.println("  " + t1);
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Triangulo Escaleno (0,0)-(1,0)-(0,2)
        // ============================================================
        System.out.println("=== 3. ESCALENO ===");
        p3 = new Punto2D(0, 2);

        t1 = new Triangulo(p1, p2, p3);
        System.out.println("  " + t1);
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Triangulo Equilatero (con redondeo de precision)
        // ============================================================
        System.out.println("=== 4. EQUILATERO ===");
        double altura = 0.5 * Math.sqrt(3);
        p2 = new Punto2D(1, 0);
        p3 = new Punto2D(0.5, altura);

        t1 = new Triangulo(p1, p2, p3);
        System.out.println("  " + t1);
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 6 - V07: EJERCICIOS TRIANGULO)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS PRACTICADOS:");
        System.out.println("  - Perimetro (suma de distancias)");
        System.out.println("  - Validacion de triangulo (area > 0)");
        System.out.println("  - Constantes con tipos de triangulo (byte)");
        System.out.println("  - Clasificacion: equilatero, isosceles, escaleno");
        System.out.println("  - Redondeo de doubles (Math.round)");
        System.out.println("  - Problemas de precision con doubles");
        System.out.println("  - toString() con informacion completa");
    }
}
