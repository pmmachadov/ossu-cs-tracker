class Video_7_01_EstructurasDeDatos {

    public static final String TITULO = "7-01 JAVA: Estructuras de datos DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=4Wqiackpdgk&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=142";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - ESTRUCTURAS DE DATOS (TEMA 7 - V01)\\n"
        + "=========================================================\\n\\n"
        + "INDICE DEL TEMA 7:\\n"
        + "1. Estructuras de datos\\n"
        + "2. Interfaces Iterator y Comparable\\n"
        + "3. Colecciones en Java (Set, List, Map)\\n"
        + "4. Clases y paquetes\\n"
        + "5. Documentacion oficial de Java (API)\\n"
        + "6. Introduccion a programacion funcional (expresiones lambda)\\n\\n"
        + "ESTRUCTURAS DE DATOS:\\n"
        + "=========================================================\\n\\n"
        + "1. PILA (Stack) - LIFO (Last In, First Out):\\n"
        + "   - Push: agregar elemento al tope\\n"
        + "   - Pop: eliminar elemento del tope\\n"
        + "   - El ultimo en entrar es el primero en salir\\n"
        + "   - Ejemplo: pila de llamadas a funciones (recursividad)\\n"
        + "   - Ejemplo: evaluacion de expresiones aritmeticas\\n"
        + "   - Operaciones: O(1) constantes en insercion y eliminacion\\n"
        + "   - Secuencia ejemplo: push(1), push(2), push(3), pop() -> elimina 3\\n"
        + "     push(4), pop() -> elimina 4 -> pila queda [1, 2]\\n\\n"
        + "2. COLA (Queue) - FIFO (First In, First Out):\\n"
        + "   - Encolar: agregar elemento al final\\n"
        + "   - Desencolar: eliminar elemento del principio\\n"
        + "   - El primero en entrar es el primero en salir\\n"
        + "   - Ejemplo: cola de impresion, gestion de tareas SO\\n"
        + "   - Ejemplo: colas de prioridad (procesos del sistema)\\n"
        + "   - Operaciones: O(1) constantes en insercion y eliminacion\\n"
        + "   - Secuencia: encolar(1), encolar(2), encolar(3), desencolar() -> elimina 1\\n"
        + "     encolar(4), desencolar() -> elimina 2 -> cola queda [3, 4]\\n\\n"
        + "3. LISTA (List):\\n"
        + "   - Coleccion ordenada de elementos\\n"
        + "   - Cada elemento (nodo) tiene: valor + puntero al siguiente\\n"
        + "   - Lista enlazada simple: un puntero al siguiente nodo\\n"
        + "   - Lista doblemente enlazada: puntero al siguiente y al anterior\\n"
        + "   - Permite insertar y eliminar en CUALQUIER posicion\\n"
        + "   - Ejemplo: ArrayList (implementacion con array dinamico)\\n"
        + "   - Ejemplo: LinkedList (implementacion con nodos enlazados)\\n\\n"
        + "4. ARBOL (Tree):\\n"
        + "   - Nodos conectados por aristas\\n"
        + "   - Nodo raiz: no tiene padres\\n"
        + "   - Nodos hoja: no tienen hijos\\n"
        + "   - Arbol binario: cada nodo tiene maximo 2 hijos\\n"
        + "   - Arbol binario de busqueda (BST):\\n"
        + "       - Hijo izquierdo: valor MENOR que el padre\\n"
        + "       - Hijo derecho: valor MAYOR que el padre\\n"
        + "   - Importante: el ORDEN de insercion afecta al balance\\n"
        + "   - Arbol balanceado: altura minima -> busqueda eficiente\\n"
        + "   - Arbol desbalanceado: puede degenerar en lista enlazada\\n"
        + "   - Ejemplo mismo conjunto = arboles de distinta altura:\\n"
        + "     {1,2,3,4,5,6,7} -> balanceado (altura 3) vs desbalanceado (altura 7)\\n\\n"
        + "5. GRAFO (Graph):\\n"
        + "   - Nodos conectados por aristas (sin restriccion de jerarquia)\\n"
        + "   - Dirigido: las aristas tienen direccion (flechas)\\n"
        + "   - No dirigido: las aristas son bidireccionales (lineas)\\n"
        + "   - Ponderado: las aristas tienen un peso/coste asociado\\n"
        + "   - No ponderado: las aristas solo indican conexion\\n"
        + "   - Ejemplo: redes sociales, mapas de carreteras, internet\\n\\n"
        + "6. TABLA HASH (Hash Table / HashMap):\\n"
        + "   - Acceso MUY RAPIDO a los elementos (coste O(1) ideal)\\n"
        + "   - Funcion Hash: transforma clave de busqueda en posicion\\n"
        + "   - Buckets: cada posicion de la tabla es una lista enlazada\\n"
        + "   - Colision: dos elementos distintos generan el mismo Hash\\n"
        + "   - Una buena funcion Hash debe:\\n"
        + "       - Ser uniforme: distribuir elementos aleatoriamente\\n"
        + "       - Minimizar colisiones\\n"
        + "       - Ser rapida de calcular\\n"
        + "   - Mala funcion Hash: si solo usa longitud del String\\n"
        + "     todos los strings de 10 caracteres -> mismo bucket\\n"
        + "   - Importante: relacion con hashCode() de Object\\n"
        + "   - Se usa en: bases de datos, busquedas rapidas, HashMap\\n\\n"
        + "COLECCIONES EN JAVA (vistazo general):\\n"
        + "- Interfaz List: ArrayList, LinkedList\\n"
        + "- Interfaz Set: HashSet, TreeSet (sin duplicados)\\n"
        + "- Interfaz Map: HashMap, TreeMap (clave-valor)\\n"
        + "- Cada una usa una estructura de datos interna diferente\\n"
        + "- La eleccion depende del tipo de operacion a optimizar\\n";

    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 7 - V01: ESTRUCTURAS DE DATOS");
        System.out.println("Introduccion a las estructuras de datos en computacion");
        System.out.println();

        // ============================================================
        // 1. EJEMPLO CONCEPTUAL: PILA (LIFO)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  1. PILA (LIFO - Last In, First Out)");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Operaciones: push() y pop() siempre sobre el tope");
        System.out.println();
        System.out.println("  Secuencia ejemplo:");
        System.out.println("    pila vacia: []");
        System.out.println("    push(1)   -> [1]");
        System.out.println("    push(2)   -> [1, 2] <- tope");
        System.out.println("    push(3)   -> [1, 2, 3] <- tope");
        System.out.println("    pop()     -> elimina 3 -> [1, 2] <- tope");
        System.out.println("    push(4)   -> [1, 2, 4] <- tope");
        System.out.println("    pop()     -> elimina 4 -> [1, 2] <- tope");
        System.out.println();
        System.out.println("  Uso tipico: pila de llamadas de funciones,");
        System.out.println("    evaluacion de expresiones aritmeticas,");
        System.out.println("    algoritmo de busqueda en profundidad (DFS)");
        System.out.println();

        // ============================================================
        // 2. EJEMPLO CONCEPTUAL: COLA (FIFO)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  2. COLA (FIFO - First In, First Out)");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Operaciones: encolar() al final, desencolar() del principio");
        System.out.println();
        System.out.println("  Secuencia ejemplo:");
        System.out.println("    cola vacia: []");
        System.out.println("    encolar(1) -> [1] <- frente");
        System.out.println("    encolar(2) -> [1, 2]");
        System.out.println("    encolar(3) -> [1, 2, 3]");
        System.out.println("    desencolar() -> elimina 1 -> [2, 3] <- frente ahora 2");
        System.out.println("    encolar(4) -> [2, 3, 4]");
        System.out.println("    desencolar() -> elimina 2 -> [3, 4]");
        System.out.println();
        System.out.println("  Uso tipico: cola de impresion, gestion de tareas SO,");
        System.out.println("    algoritmo de busqueda en anchura (BFS)");
        System.out.println();

        // ============================================================
        // 3. EJEMPLO CONCEPTUAL: LISTA ENLAZADA
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  3. LISTA ENLAZADA");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Cada elemento (nodo): [valor | puntero -> siguiente]");
        System.out.println();
        System.out.println("  Lista simple: [\"Pepe\"] -> [\"Tom\"] -> [\"John\"] -> null");
        System.out.println();
        System.out.println("  Insertar \"Cal\" en posicion 2:");
        System.out.println("    [\"Pepe\"] -> [\"Tom\"] -> [\"John\"] -> null");
        System.out.println("    [\"Pepe\"] -> [\"Cal\"] -> [\"Tom\"] -> [\"John\"] -> null");
        System.out.println();
        System.out.println("  Eliminar \"Tom\" (posicion 2):");
        System.out.println("    [\"Pepe\"] -> [\"Cal\"] -> [\"Tom\"] -> [\"John\"] -> null");
        System.out.println("    [\"Pepe\"] -> [\"Cal\"] -> [\"John\"] -> null");
        System.out.println();
        System.out.println("  Lista doblemente enlazada: puntero anterior + siguiente");
        System.out.println("  Permite recorrer en ambas direcciones");
        System.out.println();

        // ============================================================
        // 4. EJEMPLO CONCEPTUAL: ARBOL BINARIO DE BUSQUEDA
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  4. ARBOL BINARIO DE BUSQUEDA (BST)");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Propiedad: izquierda < padre < derecha");
        System.out.println();
        System.out.println("  Arbol balanceado (altura 3) con {4,2,5,1,3,6,7}:");
        System.out.println("           4");
        System.out.println("         /   \\");
        System.out.println("        2     5");
        System.out.println("       / \\     \\");
        System.out.println("      1   3     6");
        System.out.println("               \\");
        System.out.println("                7");
        System.out.println();
        System.out.println("  Mismos datos pero desbalanceado (altura 5):");
        System.out.println("    7");
        System.out.println("   /");
        System.out.println("  6");
        System.out.println(" /");
        System.out.println("5");
        System.out.println(" \\");
        System.out.println("  4");
        System.out.println("   \\");
        System.out.println("    3");
        System.out.println("     \\");
        System.out.println("      2");
        System.out.println("       \\");
        System.out.println("        1");
        System.out.println();
        System.out.println("  La altura afecta a la eficiencia de las busquedas.");
        System.out.println("  Arboles balanceados: O(log n). Desbalanceados: O(n).");
        System.out.println();

        // ============================================================
        // 5. EJEMPLO CONCEPTUAL: GRAFO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  5. GRAFO");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Grafo NO dirigido y NO ponderado:");
        System.out.println("      6 --- 5");
        System.out.println("      |     |");
        System.out.println("      4 --- 11");
        System.out.println("  (se puede ir de 6 a 5 y de 5 a 6)");
        System.out.println();
        System.out.println("  Grafo DIRIGIDO y PONDERADO:");
        System.out.println("      6 --5--> 5");
        System.out.println("      |        ^");
        System.out.println("      |3       |4");
        System.out.println("      v        |");
        System.out.println("      4 --2--> 11");
        System.out.println("  (cada arista tiene direccion y coste)");
        System.out.println();
        System.out.println("  Uso tipico: redes sociales, GPS/mapas,");
        System.out.println("    internet, algoritmos de rutas");
        System.out.println();

        // ============================================================
        // 6. EJEMPLO CONCEPTUAL: TABLA HASH
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  6. TABLA HASH");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Funcion Hash: clave -> posicion en la tabla");
        System.out.println();
        System.out.println("  Tabla con 1024 buckets:");
        System.out.println("    \"Pepe Garcia\"  -> hash=334  -> bucket[334]");
        System.out.println("    \"Tom Torres\"   -> hash=128  -> bucket[128]");
        System.out.println("    \"Cal Drogo\"    -> hash=536  -> bucket[536]");
        System.out.println("    \"Kim Dotcom\"   -> hash=536  -> COLISION con Cal!");
        System.out.println("    bucket[536] -> [\"Cal Drogo\"] -> [\"Kim Dotcom\"]");
        System.out.println();
        System.out.println("  Buena funcion Hash: distribuye uniformemente.");
        System.out.println("  Mala funcion Hash (ej: longitud del String):");
        System.out.println("    \"1234567890\" -> 10 -> bucket[10]");
        System.out.println("    \"ABCDEFGHIJ\" -> 10 -> bucket[10] (COLISION)");
        System.out.println("    \"abcdefghij\" -> 10 -> bucket[10] (COLISION)");
        System.out.println("    \"!@#$%^&*()\" -> 10 -> bucket[10] (COLISION)");
        System.out.println("    -> LOS 4 EN EL MISMO BUCKET! Pesimo rendimiento");
        System.out.println();
        System.out.println("  Acceso ideal: O(1) constante (con buena funcion Hash)");
        System.out.println("  Acceso pesimo: O(n) lineal (con colisiones masivas)");
        System.out.println();

        // ============================================================
        // RESUMEN COMPARATIVO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  COMPARATIVA DE ESTRUCTURAS");
        System.out.println("=========================================");
        System.out.println();
        System.out.printf("  %-20s %-30s %-20s%n", "ESTRUCTURA", "ACCESO/LECTURA", "INSERCION/ELIMINACION");
        System.out.printf("  %-20s %-30s %-20s%n", "-------------------", "------------------------------", "--------------------");
        System.out.printf("  %-20s %-30s %-20s%n", "Pila (Stack)", "Solo el tope (O(1))", "Solo el tope (O(1))");
        System.out.printf("  %-20s %-30s %-20s%n", "Cola (Queue)", "Solo frente/final (O(1))", "Solo frente/final (O(1))");
        System.out.printf("  %-20s %-30s %-20s%n", "Lista (ArrayList)", "Por indice (O(1))", "Al final (O(1))");
        System.out.printf("  %-20s %-30s %-20s%n", "Lista (LinkedList)", "Recorrer (O(n))", "En cualquier sitio (O(1))");
        System.out.printf("  %-20s %-30s %-20s%n", "Arbol (BST)", "Busqueda (O(log n))", "Insercion (O(log n))");
        System.out.printf("  %-20s %-30s %-20s%n", "Tabla Hash", "Por clave (O(1) ideal)", "Insercion (O(1) ideal)");
        System.out.printf("  %-20s %-30s %-20s%n", "Grafo", "Recorrido completo", "Anyadir nodo/arista");
        System.out.println();
        System.out.println("  NO HAY UNA ESTRUCTURA PERFECTA PARA TODO.");
        System.out.println("  La eleccion depende del tipo de operacion a optimizar.");
        System.out.println();

        // ============================================================
        // INDICE DEL TEMA 7
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  PROXIMOS VIDEOS DEL TEMA 7:");
        System.out.println("==============================================================");
        System.out.println("  V02: Interfaces Iterator y Comparable");
        System.out.println("  V03: Colecciones en Java (Set, List, Map)");
        System.out.println("  V04: Clases y paquetes");
        System.out.println("  V05: Documentacion oficial de Java (API)");
        System.out.println("  V06: Programacion funcional y expresiones lambda");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V01: ESTRUCTURAS DE DATOS)");
        System.out.println("==============================================================");
    }
}
