import java.util.ArrayList;

class Video_5_21_ClaseInmutableConArrayList {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-21 JAVA: Clase inmutable con ArrayList de objetos DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=ua7OoQKsdRQ&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=114";
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
          RESUMEN RAPIDO - CLASE INMUTABLE CON ARRAYLIST (TEMA 5 - V21)
        ====================================================================

        --- PROBLEMA CON ARRAYLIST EN CLASES INMUTABLES ---
        ArrayList es un OBJETO mutable (referencia).
        Si una clase inmutable tiene un ArrayList, hay que:
        1. Devolver COPIA en el getter (nuevo ArrayList)
        2. Guardar COPIA en el constructor
        3. Si los elementos son MUTABLES -> DEEP COPY

        --- CASO 1: Punto INMUTABLE (shallow copy suficiente) ---
        Constructor:
          this.listaPuntos = new ArrayList<>(original);
        Getter:
          return new ArrayList<>(listaPuntos);

        El constructor de ArrayList(List) hace shallow copy.
        Pero como Punto es inmutable, los elementos no se modifican.
        Si alguien anade/elimina de la copia, no afecta al original.

        --- CASO 2: Punto MUTABLE (deep copy necesaria) ---
        Constructor y Getter deben usar un metodo obtenerCopia()
        que cree NUEVOS objetos Punto para cada elemento.

        --- METODO obtenerCopia() para ArrayList ---
        static ArrayList<Punto> obtenerCopia(ArrayList<Punto> original) {
            ArrayList<Punto> copia = new ArrayList<>();
            for (int i = 0; i < original.size(); i++) {
                Punto p = original.get(i);
                copia.add(new Punto(p.getX(), p.getY()));  // Nuevo objeto
            }
            return copia;
        }

        --- COMPARATIVA ---
        Metodo       | Punto inmutable | Punto mutable
        -----------------|-----------------|---------------
        Constructor  | new ArrayList<>(original)  | obtenerCopia(original)
        Getter       | new ArrayList<>(lista)     | obtenerCopia(lista)
        Seguridad    | SI (no se modifican)       | SI (deep copy)

        --- ERRORES COMUNES ---
        1. Devolver this.listaPuntos directamente -> se modifica la interna
        2. Usar clone() en ArrayList -> devuelve Object, no es seguro
        3. No crear nuevas instancias de Punto -> se modifican internos
        4. Hacer lista.add() sobre la copia del getter -> OK, es copia

        ====================================================================
        """;

    // ================================================================
    // CLASE PUNTO MUTABLE (con setters)
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
    // CLASE INMUTABLE CON ARRAYLIST (SHALLOW COPY - solo si Punto es inmutable)
    // ================================================================
    static final class ObjetoInmutableShallowList {
        private final ArrayList<Punto> listaPuntos;

        // Constructor con shallow copy
        ObjetoInmutableShallowList(ArrayList<Punto> original) {
            this.listaPuntos = new ArrayList<>(original);
        }

        // Getter con shallow copy
        ArrayList<Punto> getListaPuntos() {
            return new ArrayList<>(listaPuntos);
        }

        int size() { return listaPuntos.size(); }

        void mostrar() {
            System.out.println("  Lista interna: " + listaPuntos);
        }
    }

    // ================================================================
    // CLASE INMUTABLE CON ARRAYLIST (DEEP COPY - Punto mutable)
    // ================================================================
    static final class ObjetoInmutableDeepList {
        private final ArrayList<Punto> listaPuntos;

        // Constructor con deep copy
        ObjetoInmutableDeepList(ArrayList<Punto> original) {
            this.listaPuntos = obtenerCopia(original);
        }

        // Getter con deep copy
        ArrayList<Punto> getListaPuntos() {
            return obtenerCopia(this.listaPuntos);
        }

        int size() { return listaPuntos.size(); }

        void mostrar() {
            System.out.println("  Lista interna (deep): " + listaPuntos);
        }

        // Metodo auxiliar: deep copy del ArrayList
        private static ArrayList<Punto> obtenerCopia(ArrayList<Punto> original) {
            ArrayList<Punto> copia = new ArrayList<>();
            for (int i = 0; i < original.size(); i++) {
                Punto p = original.get(i);
                copia.add(new Punto(p.getX(), p.getY()));
            }
            return copia;
        }
    }

    // ================================================================
    // CLASE INMUTABLE CON ARRAYLIST (SIN copia - para demostrar el error)
    // ================================================================
    static final class ObjetoInmutableSinCopia {
        private final ArrayList<Punto> listaPuntos;

        ObjetoInmutableSinCopia(ArrayList<Punto> original) {
            this.listaPuntos = original;  // MAL: guarda la misma referencia
        }

        ArrayList<Punto> getListaPuntos() {
            return listaPuntos;  // MAL: devuelve la referencia interna
        }

        int size() { return listaPuntos.size(); }

        void mostrar() {
            System.out.println("  Lista interna (sin copia): " + listaPuntos);
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
        System.out.println("TEMA 5 - V21: CLASE INMUTABLE CON ARRAYLIST");
        System.out.println();

        // ============================================================
        // PARTE 1: SIN copia -> NO es inmutable
        // ============================================================
        separador("PARTE 1: SIN copia en constructor/getter -> NO es inmutable");

        ArrayList<Punto> original = new ArrayList<>();
        original.add(new Punto(0, 0));
        original.add(new Punto(1, 1));
        original.add(new Punto(2, 2));

        ObjetoInmutableSinCopia objMal = new ObjetoInmutableSinCopia(original);

        System.out.print("  Antes: ");
        objMal.mostrar();

        // Modificar desde fuera (anadir a la lista original)
        original.add(new Punto(9, 9));
        System.out.print("  Despues de add a original: ");
        objMal.mostrar();
        System.out.println("  (SE modifico! misma referencia)");
        System.out.println();

        // Anadir via getter
        objMal.getListaPuntos().add(new Punto(8, 8));
        System.out.print("  Despues de add via getter: ");
        objMal.mostrar();
        System.out.println("  (SE modifico! getter devuelve referencia interna)");
        System.out.println();

        // ============================================================
        // PARTE 2: Shallow copy + Punto mutable -> NO es suficiente
        // ============================================================
        separador("PARTE 2: Shallow copy + Punto mutable -> NO es suficiente");

        ArrayList<Punto> original2 = new ArrayList<>();
        Punto p0 = new Punto(0, 0);
        original2.add(p0);
        original2.add(new Punto(1, 1));
        original2.add(new Punto(2, 2));

        ObjetoInmutableShallowList objShallow = new ObjetoInmutableShallowList(original2);

        System.out.println("  Lista original: " + original2);
        System.out.print("  Objeto shallow: ");
        objShallow.mostrar();
        System.out.println();

        // Modificar el punto original (misma referencia en shallow copy)
        p0.setX(999);
        System.out.println("  p0.setX(999)");
        System.out.print("  Objeto shallow: ");
        objShallow.mostrar();
        System.out.println("  (SE modifico! shallow copy comparte los puntos)");
        System.out.println();

        // ============================================================
        // PARTE 3: Deep copy + Punto mutable -> SI es inmutable
        // ============================================================
        separador("PARTE 3: Deep copy + Punto mutable -> SI es inmutable");

        ArrayList<Punto> original3 = new ArrayList<>();
        Punto p0b = new Punto(0, 0);
        original3.add(p0b);
        original3.add(new Punto(1, 1));
        original3.add(new Punto(2, 2));

        ObjetoInmutableDeepList objDeep = new ObjetoInmutableDeepList(original3);

        System.out.println("  Lista original: " + original3);
        System.out.print("  Objeto deep:    ");
        objDeep.mostrar();
        System.out.println();

        // Modificar el punto original (NO afecta)
        p0b.setX(999);
        System.out.println("  p0b.setX(999)");
        System.out.print("  Objeto deep:    ");
        objDeep.mostrar();
        System.out.println("  (NO se modifico! deep copy creo nuevos puntos)");
        System.out.println();

        // Intentar add via getter (NO afecta)
        objDeep.getListaPuntos().add(new Punto(8, 8));
        System.out.println("  objDeep.getListaPuntos().add((8,8))");
        System.out.println("  size interno: " + objDeep.size() + " (sigue siendo 3)");
        System.out.println();

        // Intentar modificar via getter indexado
        objDeep.getListaPuntos().get(0).setX(777);
        System.out.print("  objDeep.getListaPuntos().get(0).setX(777): ");
        objDeep.mostrar();
        System.out.println("  (NO cambio! getter devuelve copia de todo)");
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V21: CLASE INMUTABLE CON ARRAYLIST)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CLAVES PARA INMUTABILIDAD CON ARRAYLIST:");
        System.out.println("  - Constructor: new ArrayList<>(original)  [shallow]");
        System.out.println("  - Getter: new ArrayList<>(lista)         [shallow]");
        System.out.println("  - Si los elementos son mutables: DEEP COPY");
        System.out.println("  - Deep copy: crear nuevos objetos en bucle");
        System.out.println("  - Nunca devolver this.listaPuntos directamente");
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
