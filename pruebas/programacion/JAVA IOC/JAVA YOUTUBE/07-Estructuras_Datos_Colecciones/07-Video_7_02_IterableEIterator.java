import java.util.ArrayList;
import java.util.Iterator;

class Video_7_02_IterableEIterator {

    public static final String TITULO = "7-02 JAVA: Iterable e Iterator DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=zBE4fx9QyoY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=143";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - ITERABLE E ITERATOR (TEMA 7 - V02)\n"
        + "=========================================================\n\n"
        + "PROGRAMACION GENERICA:\n"
        + "- Permite definir clases/interfaces/metodos que trabajan con TIPOS GENERICOS\n"
        + "- Ejemplo: ArrayList<String>, ArrayList<Persona> -> mismo codigo, distinto tipo\n"
        + "- Se representa con <T> (type) o <E> (element) entre angulos\n"
        + "- El tipo concreto se sustituye en tiempo de compilacion\n\n"
        + "INTERFAZ ITERABLE<T>:\n"
        + "- Una unica clase que implementa esta interfaz puede ser recorrida con iteradores\n"
        + - "Unico metodo abstracto: Iterator<T> iterator()\n"
        + "- Devuelve un objeto Iterator capaz de recorrer la coleccion\n"
        + "- Todas las colecciones de Java (ArrayList, HashSet, etc.) ya lo implementan\n\n"
        + "INTERFAZ ITERATOR<T>:\n"
        + "- Metodos principales:\n"
        + "  1. boolean hasNext(): devuelve true si quedan elementos por recorrer\n"
        + "  2. T next(): devuelve el siguiente elemento y avanza el iterador\n"
        + "     - Si no hay elementos, lanza NoSuchElementException\n"
        + "  3. void remove(): elimina el ultimo elemento devuelto por next()\n"
        + "     - Debe llamarse DESPUES de next(), si no -> IllegalStateException\n"
        + "     - No se pueden hacer dos removes seguidos sin next intermedio\n\n"
        + "JERARQUIA DE COLECCIONES:\n"
        + "  Iterable<T> (interfaz raiz)\n"
        + "    +-- Collection<T> (hereda de Iterable)\n"
        + "          +-- List<T>       (ArrayList, LinkedList)\n"
        + "          +-- Set<T>        (HashSet, TreeSet)\n"
        + "          +-- Queue<T>      (PriorityQueue, LinkedList)\n"
        + "  Todas implementan iterator() gracias a Iterable\n\n"
        + "FOR-EACH vs ITERATOR:\n"
        + "- El for-each usa internamente un iterador (azucar sintactico)\n"
        + "- PROBLEMA: for-each NO permite modificar la coleccion mientras se recorre\n"
        + "  -> ConcurrentModificationException\n"
        + "- SOLUCION: usar Iterator EXPLICITAMENTE para eliminar elementos\n"
        + "  Iterator.remove() esta disenado para modificacion segura\n\n"
        + "EJEMPLOS DEL VIDEO:\n"
        + "1) Iterator basico:\n"
        + "   ArrayList<String> ciudades = ...;\n"
        + "   Iterator<String> it = ciudades.iterator();\n"
        + "   it.remove(); // ERROR: IllegalStateException (no hay next previo)\n"
        + "   String s = it.next(); // Obtiene \"New York\"\n"
        + "   it.remove(); // Elimina \"New York\"\n"
        + "   while (it.hasNext()) { System.out.print(it.next() + \" \"); }\n"
        + "   // Muestra: Tokio Paris\n\n"
        + "2) Eliminar con for-each (FALLA):\n"
        + "   for (String c : clientes) {\n"
        + "       if (c.equals(\"Tony Perez\")) clientes.remove(c);\n"
        + "       System.out.println(c);\n"
        + "   }\n"
        + "   // ERROR: ConcurrentModificationException\n\n"
        + "3) Eliminar con Iterator (CORRECTO):\n"
        + "   Iterator<String> it = clientes.iterator();\n"
        + "   while (it.hasNext()) {\n"
        + "       String c = it.next();\n"
        + "       if (c.equals(\"Tony Perez\")) it.remove();\n"
        + "       System.out.println(c); // Muestra TODOS (incluso el borrado)\n"
        + "   }\n"
        + "   // El elemento se elimina de la coleccion, pero c aun lo tiene\n\n"
        + "4) Eliminar multiples elementos con Iterator:\n"
        + "   if (c.charAt(0) == 'T') it.remove(); // Elimina todos los que empiecen por 'T'\n\n"
        + "CONCEPTOS CLAVE:\n"
        + "- Iterable: la interfaz que permite obtener un iterador\n"
        + "- Iterator: el objeto que realmente recorre la coleccion\n"
        + "- hasNext() + next() = patron clasico para recorrer\n"
        + "- remove() solo despues de next()\n"
        + "- Iterator permite modificar la coleccion mientras se recorre (for-each NO)\n"
        + "- Las colecciones Java ya tienen iterator() implementado\n";

    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 7 - V02: ITERABLE E ITERATOR");
        System.out.println("Recorrer colecciones con iteradores");
        System.out.println();

        // ============================================================
        // 1. ITERADOR BASICO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  1. ITERADOR BASICO");
        System.out.println("=========================================");
        System.out.println();

        ArrayList<String> ciudades = new ArrayList<>();
        ciudades.add("New York");
        ciudades.add("Tokio");
        ciudades.add("Paris");

        System.out.println("  Coleccion inicial: " + ciudades);
        System.out.println();

        // Creamos el iterador a partir de la coleccion
        Iterator<String> it = ciudades.iterator();

        // Metodo 1: Uso basico de next() y hasNext()
        System.out.println("  Recorrido con iterador (hasNext + next):");
        System.out.print("    ciudades: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.println("  (No se puede recorrer dos veces el mismo iterador)");
        System.out.println();

        // Metodo 2: next() + remove() (necesitamos un nuevo iterador)
        System.out.println("  Demostracion de next() + remove():");
        ArrayList<String> ciudades2 = new ArrayList<>();
        ciudades2.add("New York");
        ciudades2.add("Tokio");
        ciudades2.add("Paris");
        System.out.println("  Antes: " + ciudades2);

        Iterator<String> it2 = ciudades2.iterator();
        it2.next(); // Obtiene "New York"
        it2.remove(); // Elimina "New York" (es el ultimo devuelto por next)
        System.out.println("  Despues de next() + remove(): " + ciudades2);
        System.out.println();

        // ============================================================
        // 2. ERROR CON FOR-EACH AL ELIMINAR
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  2. ERROR CON FOR-EACH AL ELIMINAR");
        System.out.println("=========================================");
        System.out.println();

        ArrayList<String> clientesForEach = new ArrayList<>();
        clientesForEach.add("Pepe Garcia");
        clientesForEach.add("Tony Perez");
        clientesForEach.add("Marta Gomez");
        clientesForEach.add("Sara Martinez");

        System.out.println("  Coleccion inicial: " + clientesForEach);
        System.out.println();
        System.out.println("  Intentando eliminar 'Tony Perez' con for-each...");
        System.out.println("  (Esto lanza ConcurrentModificationException)");
        System.out.println();

        boolean mostrarError = true;
        if (mostrarError) {
            try {
                for (String c : clientesForEach) {
                    if (c.equals("Tony Perez")) {
                        clientesForEach.remove(c); // ERROR!
                    }
                    System.out.println("    " + c);
                }
            } catch (Exception e) {
                System.out.println("  ERROR: " + e.getClass().getSimpleName()
                    + " - No se puede modificar la coleccion mientras se recorre con for-each");
            }
        }
        System.out.println();

        // ============================================================
        // 3. SOLUCION CON ITERADOR EXPLICITO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  3. SOLUCION: ITERADOR EXPLICITO");
        System.out.println("=========================================");
        System.out.println();

        ArrayList<String> clientesOk = new ArrayList<>();
        clientesOk.add("Pepe Garcia");
        clientesOk.add("Tony Perez");
        clientesOk.add("Marta Gomez");
        clientesOk.add("Sara Martinez");

        System.out.println("  Coleccion inicial: " + clientesOk);
        System.out.println();

        Iterator<String> clientesIterator = clientesOk.iterator();

        // Mostramos todos los elementos (incluso el que se va a eliminar)
        System.out.println("  Recorriendo y eliminando 'Tony Perez' con Iterator:");
        while (clientesIterator.hasNext()) {
            String cliente = clientesIterator.next();
            if (cliente.equals("Tony Perez")) {
                clientesIterator.remove(); // ELIMINACION SEGURA
            }
            System.out.println("    " + cliente); // Muestra TODOS (el String aun existe)
        }

        System.out.println();
        System.out.println("  Coleccion final: " + clientesOk);
        System.out.println("  (Tony Perez ya no esta en la coleccion, pero se mostro en pantalla)");
        System.out.println();

        // ============================================================
        // 4. ELIMINAR MULTIPLES ELEMENTOS CON ITERADOR
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  4. ELIMINAR MULTIPLES CON ITERADOR");
        System.out.println("=========================================");
        System.out.println();

        ArrayList<String> varios = new ArrayList<>();
        varios.add("Pepe Garcia");
        varios.add("Tony Perez");
        varios.add("Marta Gomez");
        varios.add("Tom Martinez");
        varios.add("Sara Martinez");

        System.out.println("  Coleccion inicial: " + varios);
        System.out.println("  Eliminando clientes cuyo nombre empieza por 'T'...");
        System.out.println();

        Iterator<String> itVarios = varios.iterator();
        while (itVarios.hasNext()) {
            String cliente = itVarios.next();
            if (cliente.charAt(0) == 'T') {
                itVarios.remove(); // Elimina Tony y Tom
            }
            System.out.println("    " + cliente);
        }

        System.out.println();
        System.out.println("  Coleccion final: " + varios);
        System.out.println("  (Tony Perez y Tom Martinez eliminados correctamente)");
        System.out.println();

        // ============================================================
        // DEMOSTRACION: JERARQUIA DE COLECCIONES
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  JERARQUIA DE COLECCIONES (resumen)");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Iterable<T>  (interfaz raiz)");
        System.out.println("    |-- metodo: Iterator<T> iterator()");
        System.out.println("    |");
        System.out.println("    +-- Collection<T>");
        System.out.println("          |");
        System.out.println("          +-- List<T>       (ArrayList, LinkedList)");
        System.out.println("          +-- Set<T>        (HashSet, TreeSet)");
        System.out.println("          +-- Queue<T>      (PriorityQueue, ...)");
        System.out.println();
        System.out.println("  TODAS las colecciones Java implementan Iterable.");
        System.out.println("  Por tanto, todas tienen el metodo iterator().");
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V02: ITERABLE E ITERATOR)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Iterable<T>: interfaz que permite obtener un iterador");
        System.out.println("  - Iterator<T>: interfaz con hasNext(), next(), remove()");
        System.out.println("  - For-each usa iterador internamente (azucar sintactico)");
        System.out.println("  - For-each NO permite modificar la coleccion");
        System.out.println("    (ConcurrentModificationException)");
        System.out.println("  - Iterator.remove() permite eliminacion segura");
        System.out.println("  - remove() solo despues de next() (IllegalStateException si no)");
        System.out.println("  - Proximo video: crear una clase desde cero que implemente Iterable");
    }
}
