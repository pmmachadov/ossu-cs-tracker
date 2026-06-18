import java.util.*;

class Video_7_13_TreeSet {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "7-13 JAVA: TreeSet DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=tfeQrUH7L4k&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=154";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-13 - TREESET
        ================================================================

        Video:        7-13 JAVA: TreeSet
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7

        --- RESUMEN (transcripcion) ---

        La clase TreeSet implementa la interfaz Set pero basada en un
        arbol binario de busqueda auto-equilibrado (arbol Red-Black).
        Mantiene los elementos ORDENADOS (orden natural o con Comparator).

        --- CLASE TREESET<E> ---

        Jerarquia:
          Iterable<E>
            +-- Collection<E>
                  +-- Set<E>
                        +-- SortedSet<E>
                              +-- NavigableSet<E>
                                    +-- TreeSet<E>

        Caracteristicas:
          - No permite duplicados (como todos los Set)
          - No permite elementos nulos (NullPointerException)
          - Rendimiento: O(log n) para add, remove, contains
          - Orden ascendente natural o segun Comparator

        --- METODOS ESPECIFICOS (ademas de Collection) ---

        E first()          - Primer elemento (el mas pequenio)
        E last()           - Ultimo elemento (el mas grande)

        E lower(E e)       - Mayor elemento MENOR que e (o null)
        E floor(E e)       - Mayor elemento MENOR O IGUAL que e (o null)
        E ceiling(E e)     - Menor elemento MAYOR O IGUAL que e (o null)
        E higher(E e)      - Menor elemento MAYOR que e (o null)

        E pollFirst()      - Elimina y devuelve el primer elemento
        E pollLast()       - Elimina y devuelve el ultimo elemento

        NavigableSet<E> headSet(E to, boolean inclusive)
        NavigableSet<E> tailSet(E from, boolean inclusive)
        NavigableSet<E> subSet(E from, boolean fInc, E to, boolean tInc)
        NavigableSet<E> descendingSet() - Vista en orden inverso

        --- DECLARACION SEGUN INTERFAZ ---

        Set<String> s = new TreeSet<>();       -> Solo metodos de Set
        TreeSet<String> ts = new TreeSet<>();  -> Todos los metodos

        --- EJEMPLOS DEL VIDEO ---

        1) TreeSet<Integer>:
           anyadir: 5, 3, 1, 9, 2, 8, 7, 5 (5 repetido!)
           ordenado: [1, 2, 3, 5, 7, 8, 9]
           ceiling(4) = 5    floor(4) = 3
           ceiling(5) = 5    floor(5) = 5
           lower(8)  = 7     higher(2) = 3
           pollFirst() = 1   pollLast() = 9
           resultado: [2, 3, 5, 7, 8]

        2) TreeSet<String>:
           anyadir: Pep, Tom, Sam, Ben
           ordenado: [Ben, Pep, Sam, Tom]
           higher("Pep") = Sam

        --- CONCEPTOS CLAVE ---

        - TreeSet mantiene orden CONSTANTEMENTE (al anyadir/eliminar)
        - Orden natural para tipos primitivos (Integer, String...)
        - Para objetos propios: implementar Comparable o usar Comparator
        - Mas lento que HashSet (O(log n) vs O(1)) pero mantiene orden
        - No permite null -> NullPointerException al insertar
        - Los metodos higher/lower/floor/ceiling solo en TreeSet (no en Set)
        ================================================================
        """;

    // ──────────────────────────────────────────────────────────────
    // Método principal
    // ──────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // 1. TREESET DE ENTEROS (orden natural, sin duplicados)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  1. TREESET DE ENTEROS");
        System.out.println("=========================================");
        System.out.println();

        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(5);
        numeros.add(3);
        numeros.add(1);
        numeros.add(9);
        numeros.add(2);
        numeros.add(8);
        numeros.add(7);
        numeros.add(5);  // Duplicado! No se anyade

        System.out.println("  TreeSet<Integer>: " + numeros);
        System.out.println("  (Ordenado: 1, 2, 3, 5, 7, 8, 9)");
        System.out.println("  size = " + numeros.size() + " (el segundo 5 no se inserto)");
        System.out.println();

        // ============================================================
        // 2. METODOS DE NAVEGACION
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  2. METODOS DE NAVEGACION");
        System.out.println("=========================================");
        System.out.println();

        System.out.println("  TreeSet: " + numeros);
        System.out.println();

        // first y last
        System.out.println("  first() = " + numeros.first() + " (elemento mas pequenio)");
        System.out.println("  last()  = " + numeros.last() + " (elemento mas grande)");
        System.out.println();

        // lower y floor (menores)
        System.out.println("  lower(4)   = " + numeros.lower(4) + "   (mayor elemento MENOR que 4)");
        System.out.println("  floor(4)   = " + numeros.floor(4) + "   (mayor elemento MENOR O IGUAL que 4)");
        System.out.println("  floor(5)   = " + numeros.floor(5) + "   (mayor elemento MENOR O IGUAL que 5)");
        System.out.println();

        // ceiling y higher (mayores)
        System.out.println("  ceiling(4) = " + numeros.ceiling(4) + " (menor elemento MAYOR O IGUAL que 4)");
        System.out.println("  ceiling(5) = " + numeros.ceiling(5) + " (menor elemento MAYOR O IGUAL que 5)");
        System.out.println("  higher(5)  = " + numeros.higher(5) + " (menor elemento MAYOR que 5)");
        System.out.println();

        // lower y higher especificos
        System.out.println("  lower(8)   = " + numeros.lower(8) + "   (mayor elemento MENOR que 8)");
        System.out.println("  higher(2)  = " + numeros.higher(2) + "  (menor elemento MAYOR que 2)");
        System.out.println();

        // ============================================================
        // 3. POLLFIRST Y POLLLAST
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  3. POLLFIRST Y POLLLAST");
        System.out.println("=========================================");
        System.out.println();

        TreeSet<Integer> copia = new TreeSet<>(numeros);
        System.out.println("  Antes: " + copia);

        int primero = copia.pollFirst();
        int ultimo = copia.pollLast();
        System.out.println("  pollFirst() = " + primero + " (eliminado)");
        System.out.println("  pollLast()  = " + ultimo + " (eliminado)");
        System.out.println("  Despues: " + copia);
        System.out.println();

        // ============================================================
        // 4. TREESET DE STRINGS (orden alfabetico)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  4. TREESET DE STRINGS");
        System.out.println("=========================================");
        System.out.println();

        TreeSet<String> nombres = new TreeSet<>();
        nombres.add("Pep");
        nombres.add("Tom");
        nombres.add("Sam");
        nombres.add("Ben");

        System.out.println("  TreeSet<String>: " + nombres);
        System.out.println("  (Orden alfabetico: Ben, Pep, Sam, Tom)");
        System.out.println();

        // higher con strings
        System.out.println("  higher(\"Pep\") = " + nombres.higher("Pep") + " (despues de Pep alfabeticamente)");
        System.out.println("  lower(\"Sam\")  = " + nombres.lower("Sam") + " (antes de Sam)");
        System.out.println();

        // ============================================================
        // 5. DECLARACION: Set vs TreeSet
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  5. DECLARACION: Set vs TreeSet");
        System.out.println("=========================================");
        System.out.println();

        // Con Set -> solo metodos de Collection + Set
        Set<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(1);
        set.add(2);
        System.out.println("  Set<Integer> set = new TreeSet<>():");
        System.out.println("    set = " + set + " (ordenado internamente)");
        // set.higher(2);  // ERROR! Set no tiene higher
        System.out.println("    set.higher(2) -> ERROR de compilacion (no es metodo de Set)");
        System.out.println();

        // Con TreeSet -> todos los metodos
        TreeSet<Integer> treeSet = new TreeSet<>(set);
        System.out.println("  TreeSet<Integer> treeSet = new TreeSet<>(set):");
        System.out.println("    treeSet = " + treeSet);
        System.out.println("    treeSet.higher(2) = " + treeSet.higher(2) + " (SI disponible)");
        System.out.println();

        // ============================================================
        // 6. NULL NO PERMITIDO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  6. NULL NO PERMITIDO");
        System.out.println("=========================================");
        System.out.println();

        try {
            TreeSet<String> testNull = new TreeSet<>();
            testNull.add("A");
            testNull.add(null);  // NullPointerException!
        } catch (NullPointerException e) {
            System.out.println("  TreeSet.add(null) -> NullPointerException!");
        }
        System.out.println();

        // ============================================================
        // COMPARATIVA: HashSet vs TreeSet
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  COMPARATIVA: HashSet vs TreeSet");
        System.out.println("=========================================");
        System.out.println();

        HashSet<Integer> hs = new HashSet<>();
        hs.add(5); hs.add(3); hs.add(1); hs.add(9); hs.add(2);

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(5); ts.add(3); ts.add(1); ts.add(9); ts.add(2);

        System.out.println("  HashSet: " + hs + "  (sin orden)");
        System.out.println("  TreeSet: " + ts + "  (ordenado)");
        System.out.println();
        System.out.println("  Caracteristica  | HashSet    | TreeSet");
        System.out.println("  ----------------+------------+-----------");
        System.out.println("  Estructura      | Tabla Hash | Arbol");
        System.out.println("  Orden           | No         | Si (natural)");
        System.out.println("  Rendimiento     | O(1)       | O(log n)");
        System.out.println("  Permite null    | Si         | No");
        System.out.println("  Navegacion      | No         | Si (higher, lower...)");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V13: TREESET)");
        System.out.println("==============================================================");
    }
}
