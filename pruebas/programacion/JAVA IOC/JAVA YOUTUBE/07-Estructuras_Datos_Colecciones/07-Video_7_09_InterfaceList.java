import java.util.*;

class Video_7_09_InterfaceList {

    public static final String TITULO = "7-09 JAVA: Interface List DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=3K1_lj2CABU&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=150";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - INTERFACE LIST (TEMA 7 - V09)\n"
        + "=========================================================\n\n"
        + "INTERFAZ LIST<E>:\n"
        + "- Subinterfaz de Collection<E>\n"
        + - "Coleccion ORDENADA de elementos (por indice)\n"
        + "- Permite elementos DUPLICADOS\n"
        + "- Los elementos estan INDEXADOS (acceso por posicion)\n\n"
        + "IMPLEMENTACIONES PRINCIPALES:\n"
        + "  ArrayList<E>:\n"
        + "    - Basado en array dinamico\n"
        + "    - Acceso rapido por indice: O(1)\n"
        + "    - Insercion/eliminacion en medio: O(n)\n"
        + "    - Ideal para: acceso frecuente por indice\n\n"
        + "  LinkedList<E>:\n"
        + "    - Basado en lista doblemente enlazada\n"
        + "    - Acceso por indice: O(n)\n"
        + "    - Insercion/eliminacion en medio: O(1)\n"
        + "    - Ideal para: insercion/eliminacion frecuente\n"
        + "    - Tambien implementa Queue y Deque\n\n"
        + "  Stack<E> (hereda de Vector):\n"
        + "    - Estructura LIFO (pila)\n"
        + "    - Metodos: push(), pop(), peek(), search()\n"
        + "    - Obsolescente: se recomienda usar Deque en su lugar\n\n"
        + "  Vector<E>:\n"
        + "    - Similar a ArrayList pero SINCRONIZADO\n"
        + "    - Mas lento que ArrayList\n"
        + "    - Poco usado hoy en dia\n\n"
        + "METODOS ESPECIFICOS DE LIST (anyadidos a Collection):\n"
        + "  E get(int index)              - Obtener elemento en posicion\n"
        + "  E set(int index, E element)    - Reemplazar elemento en posicion\n"
        + "  void add(int index, E element) - Insertar en posicion\n"
        + "  E remove(int index)            - Eliminar y devolver elemento\n"
        + "  int indexOf(Object o)          - Indice de 1a aparicion (-1 si no)\n"
        + "  int lastIndexOf(Object o)      - Indice de ultima aparicion\n"
        + "  ListIterator<E> listIterator() - Iterador bidireccional\n\n"
        + "CLASE STACK (Pila - LIFO):\n"
        + "  E push(E item)     - Apilar (insertar en el tope)\n"
        + "  E pop()            - Desapilar (eliminar del tope)\n"
        + "  E peek()           - Ver el tope sin eliminar\n"
        + "  int search(Object o) - Posicion desde el tope (1-based, -1 si no)\n"
        + "  int size()         - Tamaño de la pila\n"
        + "  boolean empty()    - Comprueba si esta vacia\n"
        + "  Complejidad: push/pop/peek = O(1), busqueda = O(n)\n\n"
        + "EJEMPLO CON STACK:\n"
        + "  Stack<Integer> pila = new Stack<>();\n"
        + "  pila.push(1); pila.push(2); pila.push(3);  // [1, 2, 3]\n"
        + "  int elem = pila.pop();  // devuelve 3, pila = [1, 2]\n"
        + "  int tope = pila.peek(); // devuelve 2, pila = [1, 2]\n\n"
        + "CONCEPTOS CLAVE:\n"
        + "- List permite duplicados (a diferencia de Set)\n"
        + "- Elementos indexados desde 0\n"
        + "- ArrayList: rapido lectura, lento modificacion en medio\n"
        + "- LinkedList: lento lectura, rapido modificacion en medio\n"
        + "- Stack: LIFO, operaciones solo en el tope\n"
        + "- ListIterator: permite recorrer en ambas direcciones\n"
        + "- Proximo video: LinkedList en detalle (tambien Queue y Deque)\n";

    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 7 - V09: INTERFACE LIST");
        System.out.println("Metodos especificos de List y clase Stack");
        System.out.println();

        // ============================================================
        // 1. METODOS DE LIST (ArrayList como ejemplo)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  1. METODOS DE LIST (ArrayList)");
        System.out.println("=========================================");
        System.out.println();

        List<String> lista = new ArrayList<>();

        // add (heredado de Collection)
        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.add("D");
        System.out.println("  Lista inicial: " + lista);
        System.out.println();

        // get(int index)
        System.out.println("  get(0) = " + lista.get(0));
        System.out.println("  get(2) = " + lista.get(2));
        System.out.println();

        // set(int index, E element)
        String reemplazado = lista.set(1, "X");
        System.out.println("  set(1, \"X\") reemplazo: " + reemplazado + " -> " + lista);
        System.out.println();

        // add(int index, E element)
        lista.add(2, "Y");
        System.out.println("  add(2, \"Y\") -> " + lista);
        System.out.println();

        // remove(int index)
        String eliminado = lista.remove(3);
        System.out.println("  remove(3) elimino: " + eliminado + " -> " + lista);
        System.out.println();

        // indexOf(Object o)
        System.out.println("  indexOf(\"A\") = " + lista.indexOf("A"));
        System.out.println("  indexOf(\"Z\") = " + lista.indexOf("Z"));
        System.out.println();

        // lastIndexOf(Object o)
        lista.add("A");
        System.out.println("  Despues de anyadir otra \"A\": " + lista);
        System.out.println("  indexOf(\"A\")    = " + lista.indexOf("A"));
        System.out.println("  lastIndexOf(\"A\") = " + lista.lastIndexOf("A"));
        System.out.println();

        // ============================================================
        // 2. LISTA CON DUPLICADOS (diferencia con Set)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  2. LIST PERMITE DUPLICADOS");
        System.out.println("=========================================");
        System.out.println();

        List<String> duplicados = new ArrayList<>();
        duplicados.add("A");
        duplicados.add("B");
        duplicados.add("A");
        duplicados.add("C");
        duplicados.add("A");
        System.out.println("  List con duplicados: " + duplicados);
        System.out.println("  (A aparece 3 veces)");
        System.out.println("  indexOf(\"A\")    = " + duplicados.indexOf("A")
            + " (primera)");
        System.out.println("  lastIndexOf(\"A\") = " + duplicados.lastIndexOf("A")
            + " (ultima)");
        System.out.println();

        // ============================================================
        // 3. CLASE STACK (Pila - LIFO)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  3. CLASE STACK (Pila LIFO)");
        System.out.println("=========================================");
        System.out.println();

        Stack<Integer> pila = new Stack<>();

        // push
        System.out.println("  push(1) " + pila.push(1) + " -> " + pila);
        System.out.println("  push(2) " + pila.push(2) + " -> " + pila);
        System.out.println("  push(3) " + pila.push(3) + " -> " + pila);
        System.out.println("  size() = " + pila.size());
        System.out.println();

        // peek (ver tope sin eliminar)
        System.out.println("  peek() = " + pila.peek() + " (pila sigue igual: " + pila + ")");
        System.out.println();

        // pop (eliminar tope)
        int elemento = pila.pop();
        System.out.println("  pop() devuelve: " + elemento + " -> pila ahora: " + pila);
        System.out.println();

        // search
        System.out.println("  search(1) = " + pila.search(1)
            + " (posicion desde el tope, 1-based)");
        System.out.println("  search(5) = " + pila.search(5) + " (no existe)");
        System.out.println();

        // empty
        System.out.println("  empty() = " + pila.empty());
        System.out.println();

        // ============================================================
        // 4. DEMOSTRACION: PILA DE LLAMADAS (uso real)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  4. SIMULACION: PILA DE LLAMADAS");
        System.out.println("=========================================");
        System.out.println();

        Stack<String> llamadas = new Stack<>();
        llamadas.push("main()");
        llamadas.push("funcionA()");
        llamadas.push("funcionB()");
        llamadas.push("funcionC()");

        System.out.println("  Pila de llamadas: " + llamadas);
        System.out.println("  (La ultima en entrar es la primera en resolverse)");
        System.out.println();

        while (!llamadas.empty()) {
            String func = llamadas.pop();
            System.out.println("  Resolviendo: " + func);
        }
        System.out.println("  Todas las funciones resueltas. empty() = " + llamadas.empty());
        System.out.println();

        // ============================================================
        // COMPARATIVA ARRAYLIST vs LINKEDLIST
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  COMPARATIVA: ArrayList vs LinkedList");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Operacion          | ArrayList | LinkedList");
        System.out.println("  -------------------+-----------+------------");
        System.out.println("  get(indice)        | O(1)      | O(n)");
        System.out.println("  add(al final)      | O(1)      | O(1)");
        System.out.println("  add(medio)         | O(n)      | O(1)");
        System.out.println("  remove(medio)      | O(n)      | O(1)");
        System.out.println("  Buscar elemento    | O(n)      | O(n)");
        System.out.println();
        System.out.println("  USAR ArrayList cuando:");
        System.out.println("    - Acceso frecuente por indice");
        System.out.println("    - Mas lecturas que modificaciones");
        System.out.println();
        System.out.println("  USAR LinkedList cuando:");
        System.out.println("    - Insercion/eliminacion frecuente en medio");
        System.out.println("    - Se necesita cola/cola doble (Queue/Deque)");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V09: INTERFACE LIST)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - List: ordenada, indexada, permite duplicados");
        System.out.println("  - ArrayList: O(1) acceso, O(n) insercion media");
        System.out.println("  - LinkedList: O(n) acceso, O(1) insercion media");
        System.out.println("  - Stack: LIFO, push/pop/peek O(1)");
        System.out.println("  - Stack hoy obsoleto: mejor usar Deque");
        System.out.println("  - Proximo video: LinkedList como Queue/Deque");
    }
}
