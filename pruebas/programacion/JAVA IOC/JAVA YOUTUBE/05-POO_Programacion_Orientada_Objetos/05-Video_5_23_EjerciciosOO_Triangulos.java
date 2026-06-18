class Video_5_23_EjerciciosOO_Triangulos {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-23 JAVA: Ejercicios OO - Triangulos DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=kPtYnLHWPtw&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=116";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 5";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // RESUMEN para el examen (CHULETA)
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ====================================================================
          RESUMEN RAPIDO - EJERCICIOS OO: TRIANGULOS (TEMA 5 - V23)
        ====================================================================

        --- CLASE PUNTO (base para los ejercicios) ---
        - Atributos: int x, int y
        - Metodos: getX(), getY(), toString()

        --- EJERCICIO 1: Puntos en distinta posicion ---
        static boolean distintos(Punto p1, Punto p2) {
            return p1.getX() != p2.getX() || p1.getY() != p2.getY();
        }
        - Devuelve true si al menos una coordenada es distinta.
        - Si x e y son iguales en ambos -> false (misma posicion).

        --- EJERCICIO 2: Comparar varios puntos (varargs) ---
        static boolean distintos(Punto... puntos) {
            for (int i = 0; i < puntos.length; i++) {
                for (int j = i + 1; j < puntos.length; j++) {
                    if (puntos[i].getX() == puntos[j].getX()
                        && puntos[i].getY() == puntos[j].getY()) {
                        return false;  // Dos puntos iguales
                    }
                }
            }
            return true;  // Todos distintos
        }
        - Usa varargs (Punto... puntos) para recibir N puntos.
        - Bucle doble anidado para comparar todos contra todos.
        - Si encuentra dos iguales -> false. Si no -> true.

        --- EJERCICIO 3: Distancia entre dos puntos ---
        static double distancia(Punto p1, Punto p2) {
            return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2)
                           + Math.pow(p1.getY() - p2.getY(), 2));
        }
        - Formula: raiz( (x1-x2)^2 + (y1-y2)^2 )

        --- EJERCICIO 4: Area del triangulo (formula de Heron) ---
        static void areaTriangulo(Punto p1, Punto p2, Punto p3) {
            // Calcular lados
            double a = distancia(p1, p2);
            double b = distancia(p2, p3);
            double c = distancia(p3, p1);

            // Semiperimetro
            double s = (a + b + c) / 2;

            // Formula de Heron: area = raiz(s(s-a)(s-b)(s-c))
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

            if (area == 0) {
                System.out.println("Error: los puntos no forman un triangulo");
            } else {
                String tipo = obtenerTipoTriangulo(a, b, c);
                System.out.println("El triangulo es " + tipo + " y su area es " + area);
            }
        }

        --- TIPOS DE TRIANGULO ---
        - Equilatero: los 3 lados iguales
        - Isosceles: 2 lados iguales
        - Escaleno: los 3 lados distintos

        --- FORMULA DE HERON ---
        area = raiz( s * (s-a) * (s-b) * (s-c) )
        donde s = (a + b + c) / 2  (semiperimetro)

        ====================================================================
        """;

    // ================================================================
    // CLASE PUNTO
    // ================================================================
    static class Punto {
        private int x, y;

        Punto(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() { return x; }
        int getY() { return y; }

        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    // ================================================================
    // METODOS ESTATICOS DE LA CLASE PUNTO (ejercicios)
    // ================================================================

    // EJERCICIO 1: Dos puntos en distinta posicion
    static boolean distintos(Punto p1, Punto p2) {
        return p1.getX() != p2.getX() || p1.getY() != p2.getY();
    }

    // EJERCICIO 2: N puntos en posiciones distintas (varargs)
    static boolean distintos(Punto... puntos) {
        for (int i = 0; i < puntos.length; i++) {
            for (int j = i + 1; j < puntos.length; j++) {
                if (puntos[i].getX() == puntos[j].getX()
                    && puntos[i].getY() == puntos[j].getY()) {
                    return false;  // Dos puntos en la misma posicion
                }
            }
        }
        return true;  // Todos los puntos son distintos
    }

    // EJERCICIO 3: Distancia entre dos puntos
    static double distancia(Punto p1, Punto p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2)
                       + Math.pow(p1.getY() - p2.getY(), 2));
    }

    // EJERCICIO 4: Area del triangulo (Heron) + tipo
    static void areaTriangulo(Punto p1, Punto p2, Punto p3) {
        // Comprobar que los tres puntos sean distintos
        if (!distintos(p1, p2, p3)) {
            System.out.println("  Error: Hay puntos repetidos, no forman triangulo");
            return;
        }

        // Calcular los tres lados
        double a = distancia(p1, p2);
        double b = distancia(p2, p3);
        double c = distancia(p3, p1);

        // Semiperimetro
        double s = (a + b + c) / 2;

        // Formula de Heron
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        if (area == 0) {
            System.out.println("  Error: Los puntos no forman un triangulo (area=0)");
            return;
        }

        // Determinar el tipo de triangulo
        String tipo;
        if (a == b && b == c) {
            tipo = "Equilatero";
        } else if (a != b && b != c && a != c) {
            tipo = "Escaleno";
        } else {
            tipo = "Isosceles";
        }

        System.out.println("  Triangulo " + tipo + " y su area es " + area);
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 5 - V23: EJERCICIOS OO - TRIANGULOS");
        System.out.println();

        // ============================================================
        // EJERCICIO 1: Dos puntos en distinta posicion
        // ============================================================
        separador("EJERCICIO 1: Puntos en distinta posicion");

        Punto p1 = new Punto(0, 0);
        Punto p2 = new Punto(1, 0);
        Punto p3 = new Punto(0, 1);
        Punto p4 = new Punto(0, 0);  // Misma posicion que p1

        System.out.println("  p1=" + p1 + ", p2=" + p2
            + " -> distintos? " + distintos(p1, p2) + " (SI)");
        System.out.println("  p1=" + p1 + ", p4=" + p4
            + " -> distintos? " + distintos(p1, p4) + " (NO)");
        System.out.println();

        // ============================================================
        // EJERCICIO 2: N puntos con varargs
        // ============================================================
        separador("EJERCICIO 2: Varios puntos distintos (varargs)");

        Punto p5 = new Punto(0, 0);
        Punto p6 = new Punto(1, 0);
        Punto p7 = new Punto(0, 1);

        System.out.println("  puntos: " + p5 + ", " + p6 + ", " + p7
            + " -> todos distintos? " + distintos(p5, p6, p7) + " (SI)");

        Punto p8 = new Punto(1, 0);  // Repetido con p6
        System.out.println("  puntos: " + p5 + ", " + p6 + ", " + p8
            + " -> todos distintos? " + distintos(p5, p6, p8) + " (NO)");
        System.out.println();

        // ============================================================
        // EJERCICIO 3: Distancia entre dos puntos
        // ============================================================
        separador("EJERCICIO 3: Distancia entre dos puntos");

        System.out.println("  Distancia entre " + p5 + " y " + p6 + " = "
            + distancia(p5, p6) + " (deberia ser 1.0)");
        System.out.println("  Distancia entre " + p5 + " y " + p7 + " = "
            + distancia(p5, p7) + " (deberia ser 1.0)");
        System.out.println("  Distancia entre " + p6 + " y " + p7 + " = "
            + distancia(p6, p7) + " (deberia ser ~1.414)");
        System.out.println();

        // ============================================================
        // EJERCICIO 4: Area del triangulo (Heron)
        // ============================================================
        separador("EJERCICIO 4: Area del triangulo (formula de Heron)");

        // Triangulo isosceles (0,0)-(1,0)-(0,1)
        System.out.println("  Puntos: (0,0), (1,0), (0,1) -> esperado: Isosceles");
        areaTriangulo(new Punto(0, 0), new Punto(1, 0), new Punto(0, 1));
        System.out.println();

        // Triangulo escaleno (0,0)-(2,0)-(0,1)
        System.out.println("  Puntos: (0,0), (2,0), (0,1) -> esperado: Escaleno");
        areaTriangulo(new Punto(0, 0), new Punto(2, 0), new Punto(0, 1));
        System.out.println();

        // Sin triangulo (puntos en diagonal: 0,0  1,1  2,2)
        System.out.println("  Puntos: (0,0), (1,1), (2,2) -> error (en linea recta)");
        areaTriangulo(new Punto(0, 0), new Punto(1, 1), new Punto(2, 2));
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V23: EJERCICIOS OO TRIANGULOS)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS PRACTICADOS:");
        System.out.println("  - Metodos estaticos con objetos como parametros");
        System.out.println("  - Varargs (Punto... puntos)");
        System.out.println("  - Formula de distancia entre dos puntos");
        System.out.println("  - Formula de Heron (area del triangulo)");
        System.out.println("  - Clasificacion de triangulos (equilatero, isosceles, escaleno)");
    }

    // -------------------------------------------------------------
    // METODO AUXILIAR
    // -------------------------------------------------------------
    public static void separador(String titulo) {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("  " + titulo);
        System.out.println("============================================================");
    }
}
