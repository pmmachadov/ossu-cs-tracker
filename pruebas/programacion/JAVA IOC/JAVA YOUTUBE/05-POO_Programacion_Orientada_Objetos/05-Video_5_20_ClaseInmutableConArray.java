import java.util.Arrays;

class Video_5_20_ClaseInmutableConArray {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-20 JAVA: Clase inmutable con Array de objetos DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=5CX4PiQUP5k&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=113";
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
          RESUMEN RAPIDO - CLASE INMUTABLE CON ARRAY (TEMA 5 - V20)
        ====================================================================

        --- PROBLEMA ---
        Si una clase inmutable tiene un array de objetos MUTABLES,
        los getters y constructores deben hacer COPIA EN PROFUNDIDAD
        (deep copy), no solo copia superficial (shallow copy).

        --- SHALLOW COPY (copia superficial) ---
        - Solo copia las REFERENCIAS del array.
        - El nuevo array apunta a los MISMOS objetos.
        - Si esos objetos son mutables, se pueden modificar.
        - Metodo: arrays.copyOf(), clone(), o Arrays.copyOfRange()

        --- DEEP COPY (copia en profundidad) ---
        - Crea un NUEVO array y NUEVOS objetos para cada posicion.
        - Los objetos originales y los copiados son independientes.
        - Se necesita un metodo auxiliar que cree nuevas instancias.

        --- CASO 1: Punto INMUTABLE (sin setters) ---
        Si la clase Punto es inmutable, con shallow copy es SUFICIENTE:
        - constructor: this.puntos = puntos.clone();
        - getter: return puntos.clone();
        - Aunque clone() hace shallow copy, los elementos son inmutables.
        - No se pueden modificar los puntos internos (no hay setters).
        - Pero se podria REASIGNAR una posicion: getPuntos()[0] = new Punto(9,9).

        Para evitar incluso la reasignacion, se necesita deep copy.

        --- CASO 2: Punto MUTABLE (con setters) ---
        Si Punto tiene setters, shallow copy NO es suficiente:
        - clone() copia las referencias, los puntos son los MISMOS.
        - Desde fuera: getPuntos()[0].setX(999) modifica el interno.
        - Solucion: DEEP COPY (crear nuevos objetos punto uno a uno).

        --- METODO obtenerCopia() (deep copy) ---
        static Punto[] obtenerCopia(Punto[] original) {
            Punto[] copia = new Punto[original.length];
            for (int i = 0; i < original.length; i++) {
                copia[i] = new Punto(original[i].getX(), original[i].getY());
            }
            return copia;
        }

        Este metodo se usa tanto en el CONSTRUCTOR como en el GETTER.

        --- RESULTADO ---
        ObjetoInmutable obj = new ObjetoInmutable(arrayOriginal);
        obj.getPuntos()[0].setX(999);  // NO afecta al array interno
        // Porque getPuntos() devuelve una COPIA de los objetos.

        ====================================================================
        """;

    // ================================================================
    // CLASE PUNTO MUTABLE (tiene setters)
    // ================================================================
    static class Punto {
        private int x, y;

        Punto(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void setX(int x) { this.x = x; }
        void setY(int y) { this.y = y; }
        int getX() { return x; }
        int getY() { return y; }

        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    // ================================================================
    // CLASE INMUTABLE CON ARRAY (deep copy)
    // ================================================================
    static final class ObjetoInmutableArray {
        private final Punto[] puntos;

        // Constructor con DEEP COPY
        ObjetoInmutableArray(Punto[] original) {
            this.puntos = obtenerCopia(original);
        }

        // Getter con DEEP COPY
        Punto[] getPuntos() {
            return obtenerCopia(this.puntos);
        }

        // Metodo auxiliar: deep copy del array de puntos
        private static Punto[] obtenerCopia(Punto[] original) {
            Punto[] copia = new Punto[original.length];
            for (int i = 0; i < original.length; i++) {
                // Creamos NUEVOS objetos Punto (no copiamos referencias)
                copia[i] = new Punto(original[i].getX(), original[i].getY());
            }
            return copia;
        }

        void mostrar() {
            System.out.println("  Puntos internos: " + Arrays.toString(puntos));
        }
    }

    // ================================================================
    // CLASE INMUTABLE CON ARRAY (shallow copy - SOLO si Punto es inmutable)
    // ================================================================
    static final class ObjetoInmutableShallow {
        private final Punto[] puntos;

        ObjetoInmutableShallow(Punto[] original) {
            this.puntos = original.clone();  // Shallow copy
        }

        Punto[] getPuntos() {
            return puntos.clone();  // Shallow copy
        }

        void mostrar() {
            System.out.println("  Puntos internos (shallow): " + Arrays.toString(puntos));
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
        System.out.println("TEMA 5 - V20: CLASE INMUTABLE CON ARRAY");
        System.out.println();

        // ============================================================
        // PARTE 1: Shallow copy + Punto mutable (NO ES INMUTABLE)
        // ============================================================
        separador("PARTE 1: Shallow copy + Punto mutable -> NO es inmutable");

        Punto[] original = {
            new Punto(0, 0),
            new Punto(1, 1),
            new Punto(2, 2)
        };

        ObjetoInmutableShallow objShallow = new ObjetoInmutableShallow(original);

        System.out.println("  Array original: " + Arrays.toString(original));
        System.out.print("  Objeto shallow: ");
        objShallow.mostrar();
        System.out.println();

        // Modificar el original -> tambien afecta al objeto (mismos puntos)
        original[0].setX(999);
        System.out.println("  original[0].setX(999)");
        System.out.print("  Objeto shallow: ");
        objShallow.mostrar();
        System.out.println("  (Se modifico! shallow copy comparte las referencias)");
        System.out.println();

        // ============================================================
        // PARTE 2: Deep copy + Punto mutable (SI es inmutable)
        // ============================================================
        separador("PARTE 2: Deep copy + Punto mutable -> SI es inmutable");

        Punto[] original2 = {
            new Punto(0, 0),
            new Punto(1, 1),
            new Punto(2, 2)
        };

        ObjetoInmutableArray objDeep = new ObjetoInmutableArray(original2);

        System.out.println("  Array original: " + Arrays.toString(original2));
        System.out.print("  Objeto deep:    ");
        objDeep.mostrar();
        System.out.println();

        // Modificar el original -> NO afecta al objeto (deep copy)
        original2[0].setX(999);
        System.out.println("  original2[0].setX(999)");
        System.out.print("  Objeto deep:    ");
        objDeep.mostrar();
        System.out.println("  (NO se modifico! deep copy creo nuevos objetos)");
        System.out.println();

        // Intentar modificar a traves del getter
        System.out.println("  Intentando modificar via getter:");
        objDeep.getPuntos()[0].setX(777);
        System.out.print("  Objeto deep:    ");
        objDeep.mostrar();
        System.out.println("  (NO se modifico! getter devuelve copia)");
        System.out.println();

        // Intentar reasignar una posicion via getter
        System.out.println("  Intentando reasignar posicion via getter:");
        objDeep.getPuntos()[0] = new Punto(5, 5);
        System.out.print("  Objeto deep:    ");
        objDeep.mostrar();
        System.out.println("  (NO cambio! getter devuelve array copia)");
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V20: CLASE INMUTABLE CON ARRAY)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  SHALLOW COPY vs DEEP COPY:");
        System.out.println("  - Shallow: copia las referencias, mismo objetos");
        System.out.println("  - Deep: crea nuevos objetos, independientes");
        System.out.println();
        System.out.println("  PARA CLASE INMUTABLE CON ARRAY:");
        System.out.println("  - Constructor: deep copy del array");
        System.out.println("  - Getter: deep copy del array interno");
        System.out.println("  - Si los elementos son inmutables: shallow basta");
        System.out.println("  - Si los elementos son mutables: deep copy obligatorio");
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
