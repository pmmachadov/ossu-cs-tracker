import java.util.*;

class Video_7_10_LinkedList {

    public static final String TITULO = "7-10 JAVA: LinkedList DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=5MPgf5aGAFo&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=151";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - LINKEDLIST (TEMA 7 - V10)\n"
        + "=========================================================\n\n"
        + "CLASE LINKEDLIST<E>:\n"
        + "- Implementa TRES interfaces al mismo nivel:\n"
        + "    List<E>    -> lista indexada (get, set, add(index))\n"
        + "    Queue<E>   -> cola FIFO (offer, poll, peek)\n"
        + "    Deque<E>   -> cola doble (offerFirst/Last, pollFirst/Last, peekFirst/Last)\n"
        + "- Basada en lista DOBLEMENTE ENLAZADA\n"
        + "- Cada elemento tiene: [anterior | valor | siguiente]\n"
        + "- Permite recorrer en ambas direcciones\n\n"
        + "METODOS DE QUEUE (cola FIFO):\n"
        + "  boolean offer(E e)    - Insertar al final (true/false)\n"
        + "  E poll()              - Eliminar y devolver el primero (null si vacia)\n"
        + "  E peek()              - Ver el primero sin eliminar (null si vacia)\n\n"
        + "METODOS DE DEQUE (cola doble):\n"
        + "  offerFirst(E e)       - Insertar al inicio\n"
        + "  offerLast(E e)        - Insertar al final\n"
        + "  pollFirst()           - Eliminar y devolver primero (null si vacia)\n"
        + "  pollLast()            - Eliminar y devolver ultimo (null si vacia)\n"
        + "  peekFirst()           - Ver primero sin eliminar (null si vacia)\n"
        + "  peekLast()            - Ver ultimo sin eliminar (null si vacia)\n"
        + "  getFirst()            - Obtener primero (EXCEPTION si vacia)\n"
        + "  getLast()             - Obtener ultimo (EXCEPTION si vacia)\n"
        + "  removeFirst()         - Eliminar y devolver primero (EXCEPTION si vacia)\n"
        + "  removeLast()          - Eliminar y devolver ultimo (EXCEPTION si vacia)\n\n"
        + "DIFERENCIA: poll vs remove:\n"
        + "  poll()/pollFirst()    -> devuelve null si vacia\n"
        + "  remove()/removeFirst()-> lanza NoSuchElementException si vacia\n\n"
        + "DECLARACION SEGUN INTERFAZ:\n"
        + "  LinkedList<Alumno> l = new LinkedList<>();  -> TODOS los metodos\n"
        + "  List<Alumno> l = new LinkedList<>();        -> solo metodos de List\n"
        + "  Queue<Alumno> l = new LinkedList<>();        -> solo metodos de Queue\n"
        + "  Deque<Alumno> l = new LinkedList<>();        -> solo metodos de Deque\n"
        + "  (Aunque todas apunten a LinkedList, solo ven los metodos de la interfaz)\n\n"
        + "EJEMPLO DEL VIDEO:\n"
        + "  Secuencia sobre LinkedList<String> (nombres):\n"
        + "  1. add(\"Pep\")              -> [Pep]\n"
        + "  2. add(\"Tom\")              -> [Pep, Tom]\n"
        + "  3. add(\"Jon\")              -> [Pep, Tom, Jon]\n"
        + "  4. add(\"Tim\")              -> [Pep, Tom, Jon, Tim]\n"
        + "  5. add(\"Ada\")              -> [Pep, Tom, Jon, Tim, Ada]\n"
        + "  6. add(\"Sam\")              -> [Pep, Tom, Jon, Tim, Ada, Sam]\n"
        + "  7. set(2, \"Ana\")           -> [Pep, Tom, Ana, Tim, Ada, Sam]\n"
        + "  8. add(2, \"Bill\")          -> [Pep, Tom, Bill, Ana, Tim, Ada, Sam]\n"
        + "  9. pollFirst()             -> elimina Pep -> [Tom, Bill, Ana, Tim, Ada, Sam]\n"
        + "  10. pollLast()             -> elimina Sam -> [Tom, Bill, Ana, Tim, Ada]\n"
        + "  11. offerFirst(\"Jude\")     -> [Jude, Tom, Bill, Ana, Tim, Ada]\n"
        + "  12. offerLast(\"Kim\")       -> [Jude, Tom, Bill, Ana, Tim, Ada, Kim]\n"
        + "  13. removeFirst() -> Jude  -> [Tom, Bill, Ana, Tim, Ada, Kim]\n"
        + "  14. removeLast()  -> Kim   -> [Tom, Bill, Ana, Tim, Ada]\n"
        + "  Resultado final: [Tom, Bill, Ana, Tim, Ada]\n\n"
        + "CONCEPTOS CLAVE:\n"
        + "- LinkedList implementa 3 interfaces: List, Queue, Deque\n"
        + "- El tipo de la variable determina que metodos se ven\n"
        + "- poll/peek devuelven null si vacia; get/remove lanzan excepcion\n"
        + "- Ideal como: lista con insercion/eliminacion frecuente, cola, pila\n"
        + "- Proximo video: Interface Set (sin duplicados)\n";

    // ================================================================
    // CLASE ALUMNO (simplificada)
    // ================================================================
    static class Alumno {
        private String nombre;

        Alumno(String nombre) {
            this.nombre = nombre;
        }

        String getNombre() { return nombre; }

        public String toString() {
            return nombre;
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 7 - V10: LINKEDLIST");
        System.out.println("Lista doblemente enlazada como List, Queue y Deque");
        System.out.println();

        // ============================================================
        // DEMOSTRACION PASO A PASO (igual que en el video)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  DEMOSTRACION PASO A PASO");
        System.out.println("=========================================");
        System.out.println();

        LinkedList<Alumno> lista = new LinkedList<>();

        // 1-6: add (Collection) -> anyade al final
        lista.add(new Alumno("Pep"));   // 1
        lista.add(new Alumno("Tom"));   // 2
        lista.add(new Alumno("Jon"));   // 3
        lista.add(new Alumno("Tim"));   // 4
        lista.add(new Alumno("Ada"));   // 5
        lista.add(new Alumno("Sam"));   // 6
        System.out.println("  1-6. add x6:      " + lista);

        // 7. set (List) -> reemplazar en posicion
        Alumno reemplazado = lista.set(2, new Alumno("Ana"));
        System.out.println("  7. set(2, Ana):    " + lista + " (reemplazo: " + reemplazado + ")");

        // 8. add(index, element) (List) -> insertar en posicion
        lista.add(2, new Alumno("Bill"));
        System.out.println("  8. add(2, Bill):   " + lista);

        // 9. pollFirst (Deque) -> eliminar primero
        Alumno eliminado1 = lista.pollFirst();
        System.out.println("  9. pollFirst():    " + lista + " (elimino: " + eliminado1 + ")");

        // 10. pollLast (Deque) -> eliminar ultimo
        Alumno eliminado2 = lista.pollLast();
        System.out.println("  10. pollLast():    " + lista + " (elimino: " + eliminado2 + ")");

        // 11. offerFirst (Deque) -> insertar al inicio
        lista.offerFirst(new Alumno("Jude"));
        System.out.println("  11. offerFirst(Jude): " + lista);

        // 12. offerLast (Deque) -> insertar al final
        lista.offerLast(new Alumno("Kim"));
        System.out.println("  12. offerLast(Kim):   " + lista);

        // 13. removeFirst (Deque) -> eliminar y devolver primero (EXCEPTION si vacia)
        Alumno primero = lista.removeFirst();
        System.out.println("  13. removeFirst(): " + lista + " (devuelve: " + primero + ")");

        // 14. removeLast (Deque) -> eliminar y devolver ultimo (EXCEPTION si vacia)
        Alumno ultimo = lista.removeLast();
        System.out.println("  14. removeLast():  " + lista + " (devuelve: " + ultimo + ")");

        System.out.println();

        // ============================================================
        // DECLARACION SEGUN INTERFAZ
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  DECLARACION SEGUN INTERFAZ");
        System.out.println("=========================================");
        System.out.println();

        System.out.println("  LinkedList<Alumno> lista = new LinkedList<>();");
        System.out.println("    -> Ve metodos de List, Queue y Deque");
        System.out.println();
        System.out.println("  List<Alumno> lista = new LinkedList<>();");
        System.out.println("    -> Solo ve metodos de List y Collection");
        System.out.println("    -> NO ve offer, poll, peek, offerFirst, etc.");
        System.out.println();
        System.out.println("  Queue<Alumno> lista = new LinkedList<>();");
        System.out.println("    -> Solo ve metodos de Queue (offer, poll, peek)");
        System.out.println("    -> NO ve get(index), set(index, ...), add(index, ...)");
        System.out.println();
        System.out.println("  Deque<Alumno> lista = new LinkedList<>();");
        System.out.println("    -> Solo ve metodos de Deque y Queue");
        System.out.println("    -> NO ve get(index), set(index, ...)");
        System.out.println();

        // ============================================================
        // DIFERENCIA: poll vs remove
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  DIFERENCIA: poll vs remove/get");
        System.out.println("=========================================");
        System.out.println();

        LinkedList<String> vacia = new LinkedList<>();
        System.out.println("  LinkedList<String> vacia = new LinkedList<>();");
        System.out.println();

        // pollFirst con lista vacia -> null
        System.out.println("  vacia.pollFirst() = " + vacia.pollFirst() + " (null, no lanza exception)");
        System.out.println("  vacia.peekFirst() = " + vacia.peekFirst() + " (null, no lanza exception)");
        System.out.println();

        // removeFirst con lista vacia -> excepcion
        try {
            vacia.removeFirst();
        } catch (NoSuchElementException e) {
            System.out.println("  vacia.removeFirst() -> LANZA NoSuchElementException");
        }
        System.out.println();

        // ============================================================
        // LINKEDLIST COMO PILA (LIFO) con Deque
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  LINKEDLIST COMO PILA (LIFO) usando Deque");
        System.out.println("=========================================");
        System.out.println();

        Deque<String> pila = new LinkedList<>();

        pila.push("A");   // Equivale a addFirst()
        pila.push("B");
        pila.push("C");
        System.out.println("  Pila despues de push A, B, C: " + pila);

        String tope = pila.pop();  // Equivale a removeFirst()
        System.out.println("  pop() = " + tope + " -> pila: " + pila);
        System.out.println("  peek() = " + pila.peek() + " (sin eliminar) -> pila: " + pila);
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V10: LINKEDLIST)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - LinkedList implementa List, Queue y Deque");
        System.out.println("  - El tipo de la variable determina los metodos visibles");
        System.out.println("  - poll/peek -> null si vacia (seguro)");
        System.out.println("  - get/remove -> NoSuchElementException si vacia");
        System.out.println("  - Deque permite usar LinkedList como pila (LIFO)");
        System.out.println("  - Proximo video: Interface Set (sin duplicados)");
    }
}
