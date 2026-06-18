class Video_5_16_ClasesInmutables {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-16 JAVA: Clases inmutables DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=72i5vVL3Sc0&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=109";
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
          RESUMEN RAPIDO - CLASES INMUTABLES (TEMA 5 - V16)
        ====================================================================

        --- QUE ES UNA CLASE INMUTABLE ---
        Es aquella cuyo estado NO puede modificarse una vez creada.
        - Ventajas: seguridad, menos errores, no necesita sincronizacion
          en aplicaciones multi-hilo.
        - Ejemplo en Java: String es inmutable.

        --- COMO CREAR UNA CLASE INMUTABLE ---
        1. Declarar la clase como FINAL (no se puede heredar).
        2. Declarar TODOS los atributos como PRIVATE FINAL.
        3. NO proporcionar setters (ningun metodo que modifique atributos).
        4. Para atributos OBJETO:
           - En el CONSTRUCTOR, crear una COPIA del objeto recibido.
           - En el GETTER, devolver una COPIA del objeto interno.
        5. Para atributos PRIMITIVOS y STRING:
           - Se pueden asignar directamente (String es inmutable por si misma).

        --- STRING: OBJETO INMUTABLE ---
        - Una vez creada, su valor no se puede cambiar.
        - Cualquier operacion (concatenar, mayusculas, etc.) crea una
          NUEVA instancia de String.
        - Dos formas de crear Strings:
          * LITERAL: String s = "Hola";
            -> Se almacena en el STRING POOL (memoria compartida).
            -> Si otra variable tiene el mismo valor, apunta al mismo sitio.
            -> Mas eficiente.
          * CONSTRUCTOR: String s = new String("Hola");
            -> Se almacena en el HEAP (memoria independiente).
            -> Siempre crea un nuevo objeto.
            -> Menos eficiente.

        --- STRING POOL ---
        - Pool de strings donde Java almacena los literales.
        - Si dos variables tienen el mismo literal, comparten memoria.
        - Esto es POSIBLE porque String es inmutable (no se puede modificar).
        - Si no fueran inmutables, cambiar una afectaria a todas.

        --- COMPARACION DE STRINGS ---
        - s1 == s2: compara REFERENCIAS (si apuntan al mismo objeto).
          * Con literales iguales -> true (comparten pool).
          * Con new String() -> false (objetos distintos).
        - s1.equals(s2): compara CONTENIDO.
          * Siempre true si el texto es el mismo.

        --- EJEMPLO: CLASE INMUTABLE ---
        public final class ObjetoInmutable {
            private final int numero;
            private final String texto;
            private final Punto punto;

            public ObjetoInmutable(int n, String s, Punto p) {
                this.numero = n;
                this.texto = s;              // String es inmutable
                this.punto = new Punto(p.x, p.y);  // COPIA del objeto
            }

            public int getNumero() { return numero; }
            public String getTexto() { return texto; }  // String inmutable

            public Punto getPunto() {
                return new Punto(punto.x, punto.y);  // COPIA
            }
        }

        ====================================================================
        """;

    // ================================================================
    // CLASE PUNTO (usada dentro de ObjetoInmutable)
    // ================================================================
    static class Punto {
        int x, y;

        Punto(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void setX(int x) { this.x = x; }
        int getX() { return x; }
        int getY() { return y; }

        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    // ================================================================
    // CLASE INMUTABLE (final + atributos final + sin setters + copias)
    // ================================================================
    static final class ObjetoInmutable {
        private final int numero;
        private final String texto;
        private final Punto punto;

        // Constructor: para objetos, guardamos COPIAS
        ObjetoInmutable(int n, String s, Punto p) {
            this.numero = n;
            this.texto = s;                      // String inmutable, OK
            this.punto = new Punto(p.getX(), p.getY());  // COPIA del punto
        }

        // Getters: para objetos, devolvemos COPIAS
        int getNumero() { return numero; }

        String getTexto() { return texto; }      // String inmutable, OK

        Punto getPunto() {
            return new Punto(punto.getX(), punto.getY());  // COPIA
        }

        // Metodo para mostrar el estado (solo lectura)
        void mostrar() {
            System.out.println("  numero=" + numero
                + ", texto='" + texto + "'"
                + ", punto=" + punto);
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
        System.out.println("TEMA 5 - V16: CLASES INMUTABLES");
        System.out.println();

        // ============================================================
        // PARTE 1: String literal vs new String()
        // ============================================================
        separador("PARTE 1: String literal vs new String()");

        // Con NEW: objetos distintos aunque mismo contenido
        String s1 = new String("Hola mundo");
        String s2 = new String("Hola mundo");

        System.out.println("  Con new String():");
        System.out.println("  s1 == s2 -> " + (s1 == s2)
            + " (referencias distintas, objetos distintos en heap)");
        System.out.println("  s1.equals(s2) -> " + s1.equals(s2)
            + " (mismo contenido)");
        System.out.println();

        // Con LITERAL: comparten el String Pool
        String s3 = "Hola mundo";
        String s4 = "Hola mundo";

        System.out.println("  Con literal:");
        System.out.println("  s3 == s4 -> " + (s3 == s4)
            + " (misma referencia en String Pool)");
        System.out.println("  s3.equals(s4) -> " + s3.equals(s4)
            + " (mismo contenido)");
        System.out.println();

        // ============================================================
        // PARTE 2: Demostrar inmutabilidad de ObjetoInmutable
        // ============================================================
        separador("PARTE 2: Clase inmutable - no se puede modificar");

        Punto pOriginal = new Punto(10, 20);
        ObjetoInmutable obj = new ObjetoInmutable(42, "Hola", pOriginal);

        System.out.println("  Objeto creado:");
        obj.mostrar();
        System.out.println();

        // Intentar modificar el punto ORIGINAL (no afecta a la copia interna)
        pOriginal.setX(999);
        System.out.println("  Modificamos pOriginal.setX(999)");
        System.out.println("  pOriginal ahora: " + pOriginal);
        System.out.println("  obj.getPunto(): " + obj.getPunto()
            + " (NO cambio, fue copia)");
        System.out.println();

        // Intentar modificar el punto devuelto por getter (es una copia)
        Punto pDevuelto = obj.getPunto();
        pDevuelto.setX(777);
        System.out.println("  Modificamos el Punto devuelto por getter:");
        System.out.println("  pDevuelto.setX(777)");
        System.out.println("  obj.getPunto(): " + obj.getPunto()
            + " (NO cambio, getter devuelve copia)");
        System.out.println();

        System.out.println("  El objeto inmutable mantiene su estado original:");
        obj.mostrar();
        System.out.println();

        // ============================================================
        // PARTE 3: Sin setters, atributos final
        // ============================================================
        separador("PARTE 3: Caracteristicas de la clase inmutable");

        System.out.println("  - Clase FINAL: no se puede heredar");
        System.out.println("  - Atributos FINAL: no se pueden reasignar");
        System.out.println("  - Sin SETTERS: no hay metodos que modifiquen");
        System.out.println("  - Constructor hace COPIA del objeto Punto");
        System.out.println("  - Getter devuelve COPIA del Punto interno");
        System.out.println("  - String se asigna directamente (es inmutable)");
        System.out.println("  - int se asigna directamente (primitivo)");
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V16: CLASES INMUTABLES)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CLAVES PARA UNA CLASE INMUTABLE:");
        System.out.println("  1. class + final (no heredable)");
        System.out.println("  2. Atributos private final");
        System.out.println("  3. Sin setters");
        System.out.println("  4. Constructor copia objetos (new Punto(p.x, p.y))");
        System.out.println("  5. Getters devuelven copias de objetos");
        System.out.println("  6. String se puede asignar directamente (ya es inmutable)");
        System.out.println("  7. Tipos primitivos se asignan directamente");
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
