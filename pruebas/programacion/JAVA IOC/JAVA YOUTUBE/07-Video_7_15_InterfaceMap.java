import java.util.*;

class Video_7_15_InterfaceMap {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "7-15 JAVA: Interface Map DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=PQcBEX5M23c&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=156";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-15 - INTERFACE MAP
        ================================================================

        Video:        7-15 JAVA: Interface Map
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7

        --- RESUMEN (transcripcion) ---

        La interfaz Map<K,V> forma parte del Java Collections Framework
        pero NO hereda de Collection. Almacena pares CLAVE-VALOR.

        Caracteristicas:
          - Claves (K) UNICAS, valores (V) pueden duplicarse
          - No tiene relacion directa con Collection
          - No implementa Iterable (no se puede recorrer directamente)
          - Para recorrerlo se usa keySet(), values() o entrySet()

        --- IMPLEMENTACIONES PRINCIPALES ---

        HashMap<K,V>:
          - Tabla Hash, sin orden garantizado
          - O(1) constante en operaciones basicas
          - Permite claves nulas (1) y valores nulos
          - La mas rapida, usar por defecto

        LinkedHashMap<K,V>:
          - HashMap + lista enlazada
          - Mantiene orden de insercion
          - Ligeramente mas lento que HashMap

        TreeMap<K,V>:
          - Arbol binario balanceado (Red-Black)
          - Orden natural (Comparable/Comparator)
          - O(log n) en operaciones
          - NO permite claves nulas

        Hashtable<K,V>:
          - Tabla Hash sincronizada (obsoleta desde Java 1.0)
          - NO usar, preferir HashMap

        --- METODOS PRINCIPALES DE MAP ---

        V put(K key, V value)
          - Asocia clave con valor
          - Si clave existe -> REEMPLAZA valor y devuelve el antiguo
          - Si clave no existe -> anyade par y devuelve null

        V get(Object key)
          - Devuelve valor asociado a la clave (null si no existe)

        V remove(Object key)
          - Elimina par clave-valor, devuelve el valor (null si no)

        boolean containsKey(Object key)  - Existe la clave?
        boolean containsValue(Object value) - Existe el valor?

        V getOrDefault(Object key, V defaultValue)
          - Devuelve valor si clave existe, sino defaultValue
          - Muy util para evitar comprobaciones de null

        Set<K> keySet()       - Conjunto de claves
        Collection<V> values() - Coleccion de valores
        Set<Map.Entry<K,V>> entrySet() - Pares clave-valor

        int size()            - Numero de pares
        boolean isEmpty()     - Esta vacio?
        void clear()          - Eliminar todos

        --- RECORRER UN MAP ---

        1. Con entrySet() (recomendado):
           for (Map.Entry<K,V> entry : mapa.entrySet()) {
               K clave = entry.getKey();
               V valor = entry.getValue();
           }

        2. Con keySet():
           for (K clave : mapa.keySet()) {
               V valor = mapa.get(clave);
           }

        3. Con values() (solo valores):
           for (V valor : mapa.values()) { ... }

        --- EJEMPLO: NOTAS DE ALUMNOS ---

        HashMap<String, Double> notas = new HashMap<>();
        notas.put("Tim", 9.7);
        notas.put("Bob", 8.5);
        notas.put("Jon", 7.8);
        notas.put("Bob", 8.8);  // Reemplaza 8.5

        // getOrDefault: si clave existe -> devuelve valor
        notas.put("Bob", notas.getOrDefault("Bob", 0.0) + 1);  // 9.8
        notas.put("Jon", notas.getOrDefault("Cal", 5.0) + 1);  // 6.0

        // Recorrer con entrySet
        for (Map.Entry<String, Double> e : notas.entrySet())
            System.out.println("La nota de " + e.getKey()
                + " es " + e.getValue());

        // Media de notas con values()
        double suma = 0;
        for (double n : notas.values()) suma += n;
        double media = suma / notas.size();

        --- CONCEPTOS CLAVE ---

        - Map NO hereda de Collection
        - Claves unicas, valores duplicables
        - put reemplaza si la clave ya existe
        - getOrDefault evita NullPointerException
        - entrySet() es la forma mas eficiente de recorrer
        - HashMap: mas rapido, sin orden
        - TreeMap: ordenado por clave, mas lento
        - Proximos videos: HashMap, TreeMap en detalle
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // 1. CREAR HASHMAP CON NOTAS DE ALUMNOS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  1. HASHMAP CON NOTAS DE ALUMNOS");
        System.out.println("=========================================");

        HashMap<String, Double> notasAlumnos = new HashMap<>();

        // put: anyadir o reemplazar
        notasAlumnos.put("Tim", 9.7);
        notasAlumnos.put("Bob", 8.5);
        notasAlumnos.put("Jon", 7.8);

        System.out.println("  Despues de 3 puts: " + notasAlumnos);

        // put con clave existente -> reemplaza
        Double anterior = notasAlumnos.put("Bob", 8.8);
        System.out.println("  put(Bob, 8.8) -> valor anterior: " + anterior);
        System.out.println("  Ahora: " + notasAlumnos);

        // put con getOrDefault: si Bob existe, suma 1
        notasAlumnos.put("Bob", notasAlumnos.getOrDefault("Bob", 0.0) + 1);
        System.out.println("  put(Bob, getOrDefault+1) -> Bob ahora: " + notasAlumnos.get("Bob"));

        // put con getOrDefault: Cal NO existe -> usa default 5.0
        notasAlumnos.put("Jon", notasAlumnos.getOrDefault("Cal", 5.0) + 1);
        System.out.println("  put(Jon, getOrDefault(Cal,5)+1) -> Jon ahora: " + notasAlumnos.get("Jon"));

        // put con getOrDefault sobre clave existente
        notasAlumnos.put("Cal", notasAlumnos.getOrDefault("Bob", 5.0));
        System.out.println("  put(Cal, getOrDefault(Bob,5)) -> Cal ahora: " + notasAlumnos.get("Cal"));

        // put reemplazando valor con getOrDefault de clave que no existe
        notasAlumnos.put("Cal", notasAlumnos.getOrDefault("Sam", 0.0));
        System.out.println("  put(Cal, getOrDefault(Sam,0)) -> Cal ahora: " + notasAlumnos.get("Cal"));
        System.out.println();

        // ============================================================
        // 2. RECORRER MAP CON ENTRYSET
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  2. RECORRER CON ENTRYSET");
        System.out.println("=========================================");

        for (Map.Entry<String, Double> par : notasAlumnos.entrySet()) {
            System.out.println("  La nota de " + par.getKey()
                + " es " + par.getValue());
        }
        System.out.println();

        // ============================================================
        // 3. KEYSET Y VALUES
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  3. KEYSET Y VALUES");
        System.out.println("=========================================");

        // keySet
        System.out.println("  Alumnos (keySet): " + notasAlumnos.keySet());

        // values
        System.out.print("  Notas (values):   ");
        for (double n : notasAlumnos.values())
            System.out.print(n + "  ");
        System.out.println();
        System.out.println();

        // ============================================================
        // 4. MEDIA DE NOTAS CON VALUES()
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  4. MEDIA DE NOTAS");
        System.out.println("=========================================");

        double sumaNotas = 0;
        for (double nota : notasAlumnos.values())
            sumaNotas += nota;

        double media = sumaNotas / notasAlumnos.size();
        System.out.printf("  Suma: %.1f, Alumnos: %d, Media: %.2f%n",
            sumaNotas, notasAlumnos.size(), media);
        System.out.println();

        // ============================================================
        // 5. COMPARATIVA: HashMap vs LinkedHashMap vs TreeMap
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  5. COMPARATIVA DE IMPLEMENTACIONES");
        System.out.println("=========================================");

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("C", 3); hm.put("A", 1); hm.put("B", 2);
        System.out.println("  HashMap:      " + hm + "  (sin orden)");

        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("C", 3); lhm.put("A", 1); lhm.put("B", 2);
        System.out.println("  LinkedHashMap: " + lhm + "  (orden insercion)");

        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("C", 3); tm.put("A", 1); tm.put("B", 2);
        System.out.println("  TreeMap:       " + tm + "  (orden natural clave)");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V15: INTERFACE MAP)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Map<K,V>: pares clave-valor, clave unica");
        System.out.println("  - HashMap: O(1), sin orden");
        System.out.println("  - LinkedHashMap: O(1), orden insercion");
        System.out.println("  - TreeMap: O(log n), orden natural");
        System.out.println("  - put() reemplaza si clave existe");
        System.out.println("  - getOrDefault() evita nulls");
        System.out.println("  - entrySet() para recorrer eficientemente");
    }
}
