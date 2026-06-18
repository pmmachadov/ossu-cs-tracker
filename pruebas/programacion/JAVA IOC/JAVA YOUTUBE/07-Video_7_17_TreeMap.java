import java.util.*;

class Video_7_17_TreeMap {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "7-17 JAVA: TreeMap DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=unbN9nF-ifE&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=158";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-17 - TREEMAP
        ================================================================

        Video:        7-17 JAVA: TreeMap
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7

        --- RESUMEN (transcripcion) ---

        TreeMap<K,V> implementa Map usando un ARBOL BINARIO
        AUTO-EQUILIBRADO (Red-Black). Mantiene las claves ORDENADAS.

        Caracteristicas:
          - Claves UNICAS ordenadas (Comparable/Comparator)
          - NO permite claves nulas (NullPointerException)
          - Valores nulos: SI permitidos
          - Rendimiento: O(log n) en put, get, remove
          - Metodos exclusivos por implementar SortedMap y NavigableMap

        --- JERARQUIA ---

        Map<K,V>
          +-- SortedMap<K,V>   (firstKey, lastKey, headMap, tailMap, subMap)
                +-- NavigableMap<K,V> (lowerKey, higherKey, floorKey, ceilingKey,
                     pollFirstEntry, pollLastEntry, descendingMap)
                      +-- TreeMap<K,V>

        --- METODOS DE SORTEDMAP ---

        K firstKey()        - Primera clave (la mas pequenia)
        K lastKey()         - Ultima clave (la mas grande)
        SortedMap<K,V> headMap(K toKey) - Pares con clave < toKey
        SortedMap<K,V> tailMap(K fromKey) - Pares con clave >= fromKey
        SortedMap<K,V> subMap(K from, K to) - Pares con from <= clave < to

        --- METODOS DE NAVIGABLEMAP ---

        K lowerKey(K key)   - Mayor clave ESTRICTAMENTE menor que key
        K floorKey(K key)   - Mayor clave MENOR O IGUAL que key
        K ceilingKey(K key) - Menor clave MAYOR O IGUAL que key
        K higherKey(K key)  - Menor clave ESTRICTAMENTE mayor que key

        Map.Entry<K,V> lowerEntry(K key)    - Par completo (lower)
        Map.Entry<K,V> floorEntry(K key)    - Par completo (floor)
        Map.Entry<K,V> ceilingEntry(K key)  - Par completo (ceiling)
        Map.Entry<K,V> higherEntry(K key)   - Par completo (higher)

        Map.Entry<K,V> pollFirstEntry() - Elimina y devuelve el primer par
        Map.Entry<K,V> pollLastEntry()  - Elimina y devuelve el ultimo par

        NavigableMap<K,V> descendingMap() - Vista en orden descendente

        --- EJEMPLO: NOTAS DE ALUMNOS CON TREEMAP ---

        TreeMap<String, Double> notas = new TreeMap<>();
        notas.put("Paul", 9.8);
        notas.put("Pep",  8.3);
        notas.put("Tom",  7.0);
        notas.put("Sam",  9.6);
        notas.put("Paul", 6.5);  // Reemplaza 9.8
        notas.put("Cal",  9.1);

        // Arbol ordenado: {Cal=9.1, Pep=8.3, Paul=6.5, Sam=9.6, Tom=7.0}

        firstKey() = Cal
        lastKey()  = Tom
        headMap("Sam") -> {Cal=9.1, Pep=8.3, Paul=6.5}  (antes de Sam)
        tailMap("Sam") -> {Sam=9.6, Tom=7.0}             (Sam y despues)
        subMap("Cal","Paul") -> {Cal=9.1, Pep=8.3}       (Cal incluido, Paul NO)

        lowerKey("Paul") = Pep    (anterior a Paul)
        higherKey("Paul") = Sam   (posterior a Paul)
        floorKey("P") = Paul     (si existe, devuelve Paul)
        ceilingKey("Cal") = Cal  (si existe, devuelve Cal)

        pollFirstEntry() -> Cal=9.1 (eliminado)
        pollLastEntry()  -> Tom=7.0 (eliminado)

        --- CONCEPTOS CLAVE ---

        - TreeMap: ordenado por clave, O(log n)
        - NO permite claves nulas
        - SortedMap: firstKey, lastKey, headMap, tailMap, subMap
        - NavigableMap: lowerKey, floorKey, ceilingKey, higherKey
        - pollFirstEntry/pollLastEntry: eliminar y devolver
        - descendingMap: vista en orden inverso (sin modificar original)
        - Para objetos propios: Comparable o Comparator en la clave
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // CREAR TREEMAP CON NOTAS DE ALUMNOS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  TREEMAP CON NOTAS DE ALUMNOS");
        System.out.println("=========================================");

        TreeMap<String, Double> notas = new TreeMap<>();

        // put: anyadir o reemplazar
        notas.put("Paul", 9.8);
        notas.put("Pep",  8.3);
        notas.put("Tom",  7.0);
        notas.put("Sam",  9.6);

        // put con clave existente -> reemplaza y devuelve valor anterior
        Double valorAnterior = notas.put("Paul", 6.5);
        System.out.println("  put(Paul, 6.5) -> valor anterior: " + valorAnterior);

        notas.put("Cal",  9.1);

        System.out.println("  TreeMap ordenado: " + notas);
        System.out.println("  (Claves ordenadas alfabeticamente)");
        System.out.println();

        // ============================================================
        // METODOS DE SORTEDMAP
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  METODOS DE SORTEDMAP");
        System.out.println("=========================================");

        System.out.println("  firstKey() = " + notas.firstKey() + " (primera clave)");
        System.out.println("  lastKey()  = " + notas.lastKey() + " (ultima clave)");
        System.out.println();

        System.out.println("  headMap(\"Sam\") = " + notas.headMap("Sam")
            + "  (claves < Sam)");
        System.out.println("  tailMap(\"Sam\") = " + notas.tailMap("Sam")
            + "  (claves >= Sam)");
        System.out.println("  subMap(\"Cal\", \"Paul\") = " + notas.subMap("Cal", "Paul")
            + "  (Cal <= clave < Paul)");
        System.out.println();

        // ============================================================
        // METODOS DE NAVIGABLEMAP
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  METODOS DE NAVIGABLEMAP");
        System.out.println("=========================================");

        System.out.println("  lowerKey(\"Paul\")  = " + notas.lowerKey("Paul")
            + "   (anterior a Paul)");
        System.out.println("  higherKey(\"Paul\") = " + notas.higherKey("Paul")
            + "  (posterior a Paul)");
        System.out.println("  lowerKey(\"Cal\")   = " + notas.lowerKey("Cal")
            + "   (anterior a Cal -> null)");
        System.out.println("  higherKey(\"Tom\")  = " + notas.higherKey("Tom")
            + "   (posterior a Tom -> null)");
        System.out.println();

        System.out.println("  floorKey(\"P\")     = " + notas.floorKey("P")
            + "   (menor o igual a P)");
        System.out.println("  ceilingKey(\"K\")   = " + notas.ceilingKey("K")
            + "  (mayor o igual a K)");
        System.out.println("  floorKey(\"Paul\")  = " + notas.floorKey("Paul")
            + "   (menor o igual a Paul)");
        System.out.println("  ceilingKey(\"Cal\") = " + notas.ceilingKey("Cal")
            + "  (mayor o igual a Cal)");
        System.out.println();

        // ============================================================
        // POLLFIRST Y POLLLAST
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  POLLFIRST Y POLLLAST");
        System.out.println("=========================================");

        TreeMap<String, Double> copia = new TreeMap<>(notas);
        System.out.println("  Antes: " + copia);

        Map.Entry<String, Double> primero = copia.pollFirstEntry();
        Map.Entry<String, Double> ultimo = copia.pollLastEntry();

        System.out.println("  pollFirstEntry() -> " + primero.getKey()
            + "=" + primero.getValue() + " (eliminado)");
        System.out.println("  pollLastEntry()  -> " + ultimo.getKey()
            + "=" + ultimo.getValue() + " (eliminado)");
        System.out.println("  Despues: " + copia);
        System.out.println();

        // ============================================================
        // DESCENDING MAP
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  DESCENDING MAP");
        System.out.println("=========================================");

        NavigableMap<String, Double> descendente = notas.descendingMap();
        System.out.println("  Original:    " + notas);
        System.out.println("  Descendente: " + descendente);
        System.out.println("  (Vista en orden inverso, sin modificar original)");
        System.out.println();

        // ============================================================
        // PUT DEVUELVE VALOR ANTERIOR
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  PUT DEVUELVE VALOR ANTERIOR");
        System.out.println("=========================================");

        TreeMap<String, Double> demo = new TreeMap<>();
        demo.put("A", 1.0);

        Double anterior = demo.put("A", 9.0);
        System.out.println("  put(A, 9.0) -> valor anterior: " + anterior + " (era 1.0)");

        Double nuevo = demo.put("X", 5.0);
        System.out.println("  put(X, 5.0) -> valor anterior: " + nuevo + " (null, clave nueva)");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V17: TREEMAP)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - TreeMap: ordenado por clave, O(log n)");
        System.out.println("  - NO permite claves nulas");
        System.out.println("  - firstKey/lastKey: extremos del mapa");
        System.out.println("  - headMap/tailMap/subMap: submapas");
        System.out.println("  - lowerKey/floorKey/ceilingKey/higherKey");
        System.out.println("  - pollFirstEntry/pollLastEntry: eliminar extremos");
        System.out.println("  - descendingMap: vista inversa");
    }
}
