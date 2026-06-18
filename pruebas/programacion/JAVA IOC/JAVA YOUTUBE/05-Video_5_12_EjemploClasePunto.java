class Video_5_12_EjemploClasePunto {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-12 JAVA: Ejemplo Clase Punto OO DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=gE9D6Yc0cuA&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=105";
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
          RESUMEN RAPIDO - EJEMPLO CLASE PUNTO (TEMA 5 - V12)
        ====================================================================

        --- ESTRUCTURA DE UN METODO ---
        [acceso] [static] [final] tipoRetorno nombreMetodo(par Tipo par, ...) {
            // cuerpo
        }

        - acceso: public, private, protected o (sin)
        - static: opcional, metodo de clase (sin instancia)
        - final: opcional, no se puede sobrescribir (T6)
        - tipoRetorno: obligatorio (void si no devuelve nada)
        - nombreMetodo: camelCase obligatorio
        - parametros: opcionales, separados por comas

        --- CONSTRUCTOR ---
        - Se ejecuta automaticamente al crear una instancia (new).
        - Reserva memoria e inicializa atributos.
        - Mismo nombre que la clase, SIN tipo de retorno.
        - Si no hay ningun constructor, Java pone el CONSTRUCTOR
          POR DEFECTO (sin parametros, valores por defecto).
        - Si hay ALGUN constructor declarado, el por defecto
          DESAPARECE (hay que declararlo explicitamente si se necesita).
        - Sobrecarga de constructores: varios con distintos parametros.

        --- VALORES POR DEFECTO ---
        - int, long, short, byte -> 0
        - double, float -> 0.0
        - boolean -> false
        - char -> '\\\\0'
        - Objetos (String incluido) -> null

        --- CLASE PUNTO ---
        - Atributos: int x, int y (publicos en este ejemplo)
        - Constructores:
          * Punto(int n) -> asigna n a x y a y
          * Punto(int a, int b) -> asigna a a x, b a y
        - Metodo: double calcularDistanciaCentro()
          * Devuelve la distancia desde (0,0) hasta (x,y)
          * Formula: sqrt(x^2 + y^2)  (Teorema de Pitagoras)

        --- VARIABLES LOCALES ---
        - Se declaran DENTRO de un metodo.
        - Solo existen durante la ejecucion del metodo.
        - Al terminar el metodo, desaparecen de memoria.
        - No son visibles desde otros metodos.

        --- BUENA PRACTICA: EVITAR VARIABLES INNECESARIAS ---
        Forma MEJOR (sin variable local):
          return Math.sqrt(x * x + y * y);

        Forma PEOR (con variable local innecesaria):
          double z = Math.sqrt(x * x + y * y);
          return z;

        La primera es mas eficiente (no reserva memoria extra).

        --- SOBRECARGA DE METODOS ---
        - Varios metodos con el MISMO nombre pero DISTINTOS parametros.
        - Se diferencian por numero y/o tipo de parametros.
        - El tipo de retorno NO es suficiente para diferenciarlos.
        - Ej: mostrarDatos() y mostrarDatos(String titulo)

        --- METODOS PRIVADOS ---
        - Un metodo privado solo puede ser llamado desde otros
          metodos de la misma clase.
        - Sirve para "ocultar" logica interna (encapsulacion).
        - Ej: private void mostrarDatos() solo se llama desde
          public void mostrarDatos(String titulo).

        ====================================================================
        """;

    // ================================================================
    // CLASE PUNTO
    // ================================================================
    static class Punto {
        // Atributos publicos (en este ejemplo)
        int x;
        int y;

        // Constructor con un parametro (asigna el mismo a x e y)
        Punto(int n) {
            x = n;
            y = n;
        }

        // Constructor con dos parametros
        Punto(int a, int b) {
            x = a;
            y = b;
        }

        // Metodo privado: solo se llama desde la propia clase
        private void mostrarDatos() {
            System.out.println("  x = " + x + ", y = " + y);
        }

        // Metodo publico sobrecargado: recibe un titulo
        void mostrarDatos(String titulo) {
            System.out.println("  " + titulo);
            mostrarDatos();  // Llama al metodo privado
            System.out.println("  Distancia respecto al centro: "
                + calcularDistanciaCentro());
            System.out.println("  ---");
        }

        // Calcula la distancia desde (0,0) hasta (x,y)
        // Sin variable local innecesaria (buena practica)
        double calcularDistanciaCentro() {
            return Math.sqrt(x * x + y * y);
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 5 - V12: EJEMPLO CLASE PUNTO");
        System.out.println();

        // ============================================================
        // PARTE 1: Constructores con 1 y 2 parametros
        // ============================================================
        separador("PARTE 1: Crear puntos con distintos constructores");

        Punto p1 = new Punto(5);           // x=5, y=5
        Punto p2 = new Punto(1, 3);        // x=1, y=3
        Punto p3 = new Punto(1);           // x=1, y=1

        System.out.println("  p1 = new Punto(5)      -> x=5, y=5");
        System.out.println("  p2 = new Punto(1, 3)   -> x=1, y=3");
        System.out.println("  p3 = new Punto(1)      -> x=1, y=1");
        System.out.println();

        // ============================================================
        // PARTE 2: Mostrar datos con sobrecarga
        // ============================================================
        separador("PARTE 2: Mostrar datos con titulo");

        p1.mostrarDatos("Punto p1:");
        p2.mostrarDatos("Punto p2:");
        p3.mostrarDatos("Punto p3:");
        System.out.println();

        // ============================================================
        // PARTE 3: Distancia al centro
        // ============================================================
        separador("PARTE 3: Distancia al centro (Pitagoras)");

        System.out.println("  La distancia de (3,4) al centro es: "
            + new Punto(3, 4).calcularDistanciaCentro() + " (deberia ser 5.0)");
        System.out.println("  La distancia de (0,0) al centro es: "
            + new Punto(0, 0).calcularDistanciaCentro() + " (deberia ser 0.0)");
        System.out.println("  La distancia de (1,1) al centro es: "
            + new Punto(1, 1).calcularDistanciaCentro() + " (deberia ser ~1.414)");
        System.out.println();

        // ============================================================
        // PARTE 4: Valores por defecto (constructor por defecto)
        // ============================================================
        separador("PARTE 4: Constructor por defecto vs declarado");

        System.out.println("  Si NO hay constructores declarados, Java usa el");
        System.out.println("  constructor por defecto (valores a 0 / null).");
        System.out.println();

        System.out.println("  En esta clase tenemos 2 constructores declarados,");
        System.out.println("  por lo que NO existe el constructor vacio.");
        System.out.println("  La unica forma de crear Punto es con parametros.");
        System.out.println();

        // ============================================================
        // RESUMEN FINAL
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V12: EJEMPLO CLASE PUNTO)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Estructura de un metodo en Java");
        System.out.println("  - Constructor por defecto vs declarados");
        System.out.println("  - Valores por defecto segun tipo");
        System.out.println("  - Variables locales (viven solo en el metodo)");
        System.out.println("  - Buena practica: evitar variables innecesarias");
        System.out.println("  - Sobrecarga de metodos (mismo nombre, distinto params)");
        System.out.println("  - Metodos privados (solo visibles dentro de la clase)");
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
