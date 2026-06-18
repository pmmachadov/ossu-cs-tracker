import java.util.*;

class Video_7_08_ColeccionesCollectionMap {

    public static final String TITULO = "7-08 JAVA: Colecciones - Collection & Map DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=1kXIFVYVp48&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=149";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - COLECCIONES: COLLECTION & MAP (TEMA 7 - V08)\n"
        + "=========================================================\n\n"
        + "JAVA COLLECTIONS FRAMEWORK:\n"
        + "Conjunto de clases e interfaces que facilitan trabajar con colecciones.\n"
        + "Ya no necesitamos implementar estructuras de datos desde cero.\n"
        + "Solo debemos elegir la clase adecuada segun nuestras necesidades.\n\n"
        + "DOS INTERFACES PRINCIPALES:\n"
        + "  1. Collection<E>  (raiz de la jerarquia de colecciones)\n"
        + "  2. Map<K,V>       (pares clave-valor, NO hereda de Collection)\n\n"
        + "JERARQUIA DE COLLECTION:\n"
        + "  Collection<E>\n"
        + "    +-- Set<E>         (sin duplicados)\n"
        + "    |     +-- HashSet<E>       (tabla Hash, rapido, sin orden)\n"
        + "    |     +-- LinkedHashSet<E> (tabla Hash + lista, orden insercion)\n"
        + "    |     +-- TreeSet<E>       (arbol binario balanceado, ordenado)\n"
        + "    |\n"
        + "    +-- List<E>        (con duplicados, indexado)\n"
        + "    |     +-- ArrayList<E>     (array dinamico, acceso rapido por indice)\n"
        + "    |     +-- LinkedList<E>    (lista doblemente enlazada, insercion/eliminacion rapida)\n"
        + "    |     +-- Vector<E>        (similar a ArrayList pero sincronizado)\n"
        + "    |\n"
        + "    +-- Queue<E>       (cola, FIFO)\n"
        + "          +-- LinkedList<E>    (tambien implementa Queue y Deque)\n"
        + "          +-- PriorityQueue<E> (cola con prioridad)\n\n"
        + "JERARQUIA DE MAP:\n"
        + "  Map<K,V>\n"
        + "    +-- HashMap<K,V>         (tabla Hash, rapido, permite nulls)\n"
        + "    +-- LinkedHashMap<K,V>   (HashMap + lista, orden insercion)\n"
        + "    +-- TreeMap<K,V>         (arbol binario balanceado, ordenado)\n"
        + "    +-- Hashtable<K,V>       (tabla Hash sincronizada, NO nulls)\n\n"
        + "METODOS PRINCIPALES DE COLLECTION:\n"
        + "  boolean add(E e)         - Anyade elemento (true si se anyadio)\n"
        + "  boolean remove(Object o) - Elimina elemento (true si existia)\n"
        + "  void clear()             - Elimina todos los elementos\n"
        + "  boolean contains(Object o) - Comprueba si existe\n"
        + "  boolean isEmpty()        - Comprueba si esta vacia\n"
        + "  int size()               - Numero de elementos\n"
        + "  Object[] toArray()       - Convierte a array\n"
        + "  Iterator<E> iterator()   - Obtiene iterador (hereda de Iterable)\n"
        + "  boolean equals(Object o) - Compara colecciones\n"
        + "  int hashCode()           - Hash de la coleccion\n\n"
        + "CARACTERISTICAS POR CLASE:\n"
        + "  | Clase           | Estructura     | Orden     | Duplicados | Nulls |\n"
        + "  |-----------------|----------------|-----------|------------|-------|\n"
        + "  | ArrayList       | Array dinamico | Insercion | Si         | Si    |\n"
        + "  | LinkedList      | Lista enlazada | Insercion | Si         | Si    |\n"
        + "  | HashSet         | Tabla Hash     | Ninguno   | No         | Si    |\n"
        + "  | LinkedHashSet   | Hash + Lista   | Insercion | No         | Si    |\n"
        + "  | TreeSet         | Arbol          | Natural   | No         | No    |\n"
        + "  | HashMap         | Tabla Hash     | Ninguno   | Clave unica| Si    |\n"
        + "  | LinkedHashMap   | Hash + Lista   | Insercion | Clave unica| Si    |\n"
        + "  | TreeMap         | Arbol          | Natural   | Clave unica| No    |\n\n"
        + "CONCEPTOS CLAVE:\n"
        + "- equals() y hashCode() son CRUCIALES para Set y Map (evitar duplicados)\n"
        + "- Map NO hereda de Collection, pero es parte del framework\n"
        + "- Cada implementacion usa una estructura de datos distinta\n"
        + "- Elegir segun la operacion a optimizar (busqueda, insercion, orden)\n"
        + "- Proximos videos: ejemplos practicos de cada implementacion\n";

    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 7 - V08: COLECCIONES JAVA (Collection & Map)");
        System.out.println("Introduccion al Java Collections Framework");
        System.out.println();

        // ============================================================
        // DEMOSTRACION DE METODOS DE COLLECTION
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  METODOS DE LA INTERFAZ COLLECTION");
        System.out.println("=========================================");
        System.out.println();

        Collection<String> coleccion = new ArrayList<>();

        System.out.println("  Crear coleccion vacia:");
        System.out.println("    isEmpty() = " + coleccion.isEmpty());
        System.out.println("    size()    = " + coleccion.size());
        System.out.println();

        // add
        System.out.println("  add(\"A\"): " + coleccion.add("A") + " -> " + coleccion);
        System.out.println("  add(\"B\"): " + coleccion.add("B") + " -> " + coleccion);
        System.out.println("  add(\"C\"): " + coleccion.add("C") + " -> " + coleccion);
        System.out.println("  size()    = " + coleccion.size());
        System.out.println("  isEmpty() = " + coleccion.isEmpty());
        System.out.println();

        // contains
        System.out.println("  contains(\"A\") = " + coleccion.contains("A"));
        System.out.println("  contains(\"Z\") = " + coleccion.contains("Z"));
        System.out.println();

        // remove
        System.out.println("  remove(\"B\"): " + coleccion.remove("B") + " -> " + coleccion);
        System.out.println("  remove(\"Z\"): " + coleccion.remove("Z") + " -> " + coleccion);
        System.out.println("  size() despues = " + coleccion.size());
        System.out.println();

        // toArray
        Object[] array = coleccion.toArray();
        System.out.println("  toArray(): " + Arrays.toString(array));
        System.out.println();

        // clear
        coleccion.clear();
        System.out.println("  clear() -> isEmpty() = " + coleccion.isEmpty());
        System.out.println();

        // ============================================================
        // JERARQUIA DE COLECCIONES (diagrama grafico)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  DIAGRAMA DEL JAVA COLLECTIONS FRAMEWORK");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Collection<E> (interfaz raiz)");
        System.out.println("    |");
        System.out.println("    +-- Set<E>          (sin duplicados)");
        System.out.println("    |     +-- HashSet<E>        (tabla Hash, sin orden)");
        System.out.println("    |     +-- LinkedHashSet<E>  (Hash + lista, orden insercion)");
        System.out.println("    |     +-- TreeSet<E>        (arbol, orden natural)");
        System.out.println("    |");
        System.out.println("    +-- List<E>         (con duplicados, indexado)");
        System.out.println("    |     +-- ArrayList<E>      (array dinamico)");
        System.out.println("    |     +-- LinkedList<E>     (lista doblemente enlazada)");
        System.out.println("    |     +-- Vector<E>         (array sincronizado)");
        System.out.println("    |");
        System.out.println("    +-- Queue<E>        (cola FIFO)");
        System.out.println("          +-- LinkedList<E>     (tambien Queue/Deque)");
        System.out.println("          +-- PriorityQueue<E>  (cola con prioridad)");
        System.out.println();
        System.out.println("  Map<K,V> (NO hereda de Collection)");
        System.out.println("    +-- HashMap<K,V>         (tabla Hash, permite nulls)");
        System.out.println("    +-- LinkedHashMap<K,V>   (HashMap + lista, orden insercion)");
        System.out.println("    +-- TreeMap<K,V>         (arbol, orden natural)");
        System.out.println("    +-- Hashtable<K,V>       (HashMap sincronizado, NO nulls)");
        System.out.println();

        // ============================================================
        // RESUMEN COMPARATIVO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  TABLA COMPARATIVA");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  " + String.format("%-20s %-15s %-10s %-15s", "CLASE", "ESTRUCTURA", "ORDEN", "DUP/CLAVES"));
        System.out.println("  " + String.format("%-20s %-15s %-10s %-15s", "--------------------", "---------------", "----------", "---------------"));
        System.out.println("  " + String.format("%-20s %-15s %-10s %-15s", "ArrayList", "Array dinamico", "Insercion", "Duplicados ok"));
        System.out.println("  " + String.format("%-20s %-15s %-10s %-15s", "LinkedList", "Lista enlazada", "Insercion", "Duplicados ok"));
        System.out.println("  " + String.format("%-20s %-15s %-10s %-15s", "HashSet", "Tabla Hash", "Ninguno", "No duplicados"));
        System.out.println("  " + String.format("%-20s %-15s %-10s %-15s", "LinkedHashSet", "Hash + Lista", "Insercion", "No duplicados"));
        System.out.println("  " + String.format("%-20s %-15s %-10s %-15s", "TreeSet", "Arbol", "Natural", "No duplicados"));
        System.out.println("  " + String.format("%-20s %-15s %-10s %-15s", "HashMap", "Tabla Hash", "Ninguno", "Clave unica"));
        System.out.println("  " + String.format("%-20s %-15s %-10s %-15s", "TreeMap", "Arbol", "Natural", "Clave unica"));
        System.out.println();

        // ============================================================
        // EFICIENCIA (notacion Big-O)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EFICIENCIA (Big-O)");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Clase           | Lectura   | Insercion | Eliminacion");
        System.out.println("  ----------------+-----------+-----------+------------");
        System.out.println("  ArrayList       | O(1)      | O(1)*     | O(n)");
        System.out.println("  LinkedList      | O(n)      | O(1)      | O(1)");
        System.out.println("  HashSet         | O(1)      | O(1)      | O(1)");
        System.out.println("  TreeSet         | O(log n)  | O(log n)  | O(log n)");
        System.out.println("  HashMap         | O(1)      | O(1)      | O(1)");
        System.out.println("  TreeMap         | O(log n)  | O(log n)  | O(log n)");
        System.out.println();
        System.out.println("  * ArrayList: insercion al final O(1), en medio O(n)");
        System.out.println();

        // ============================================================
        // CONSEJOS PARA ELEGIR
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  COMO ELEGIR LA COLECCION ADECUADA");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  NECESITO...                           -> USAR");
        System.out.println("  -------------------------------------   ------");
        System.out.println("  Acceder por indice                    -> ArrayList");
        System.out.println("  Insertar/eliminar en cualquier sitio  -> LinkedList");
        System.out.println("  Sin duplicados, sin orden             -> HashSet");
        System.out.println("  Sin duplicados, orden insercion       -> LinkedHashSet");
        System.out.println("  Sin duplicados, orden natural         -> TreeSet");
        System.out.println("  Clave->valor, sin orden               -> HashMap");
        System.out.println("  Clave->valor, orden insercion         -> LinkedHashMap");
        System.out.println("  Clave->valor, orden natural           -> TreeMap");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V08: COLECCIONES)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  RESUMEN:");
        System.out.println("  - Collection: List (duplicados), Set (unicos), Queue");
        System.out.println("  - Map: pares clave-valor (NO hereda de Collection)");
        System.out.println("  - equals() y hashCode() esenciales para Set y Map");
        System.out.println("  - Proximos videos: ejemplos de cada coleccion");
    }
}
