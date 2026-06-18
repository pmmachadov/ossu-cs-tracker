class Video_4_21_Busqueda_Binaria {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-21 JAVA: Busqueda binaria (recursiva) DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=YswFFA5Tx_8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=86";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 4";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // RESUMEN para el examen (CHULETA)
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ====================================================================
          RESUMEN RAPIDO - BUSQUEDA BINARIA (TEMA 4 - V21)
        ====================================================================

        --- ALGORITMO DE BUSQUEDA BINARIA ---
        Busca un elemento en un array ORDENADO de forma MUY eficiente.
        Usa la estrategia DIVIDE Y VENCERAS (recursivo).

        --- COMO FUNCIONA ---
        1. Colocarse en el MEDIO del array (mitad = (inf + sup) / 2).
        2. Si el elemento del medio es el buscado -> ENCONTRADO (true).
        3. Si el buscado es MENOR -> buscar en la mitad IZQUIERDA.
        4. Si el buscado es MAYOR -> buscar en la mitad DERECHA.
        5. Si inf > sup -> NO ENCONTRADO (false).

        --- COMPLEJIDAD ---
        - O(log n) -> MUY eficiente. Con 1M de elementos solo hace ~20 pasos.
        - Busqueda lineal seria O(n) -> 1M pasos.
        - REQUISITO: el array debe estar ORDENADO.

        --- CODIGO ---
        static boolean busquedaBinaria(int[] nums, int buscado, int inf, int sup) {
            if (inf > sup) {
                return false;  // Caso base: no queda nada que buscar
            }

            int mitad = (inf + sup) / 2;

            if (nums[mitad] < buscado) {           // Buscar en derecha
                return busquedaBinaria(nums, buscado, mitad + 1, sup);
            } else if (nums[mitad] > buscado) {    // Buscar en izquierda
                return busquedaBinaria(nums, buscado, inf, mitad - 1);
            } else {                                 // Encontrado
                return true;
            }
        }

        --- METODO INTERMEDIO (solo requiere array y buscado) ---
        static void mostrarBusquedaBinaria(int[] nums, int buscado) {
            if (busquedaBinaria(nums, buscado, 0, nums.length - 1)) {
                System.out.println("El numero " + buscado + " esta en el array.");
            } else {
                System.out.println("El numero " + buscado + " NO esta en el array.");
            }
        }

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. REQUISITO IMPRESCINDIBLE:
           - El array tiene que estar ORDENADO. Si no, el algoritmo NO funciona.
           - Si el array no esta ordenado, usa primero Quicksort o Burbuja.

        2. CASOS:
           - inf > sup -> false (no encontrado).
           - nums[mitad] == buscado -> true (encontrado).
           - nums[mitad] < buscado -> buscar en derecha (mitad+1, sup).
           - nums[mitad] > buscado -> buscar en izquierda (inf, mitad-1).

        3. CALCULO DE LA MITAD:
           - mitad = (inf + sup) / 2
           - Si suma par: resultado exacto.
           - Si suma impar: trunca (division de enteros), ej: (0+7)/2 = 3.

        4. LLAMADAS RECURSIVAS:
           - Derecha: busquedaBinaria(nums, buscado, mitad + 1, sup)
           - Izquierda: busquedaBinaria(nums, buscado, inf, mitad - 1)
           - El +1 y -1 son CRUCIALES para no caer en bucle infinito.

        5. METODO INTERMEDIO:
           - La llamada inicial debe ser (nums, buscado, 0, nums.length - 1).
           - Los parametros inf=0 y sup=length-1 inicializan los limites.
           - Se suele crear un metodo mostrarBusquedaBinaria que llame internamente.

        6. ERRORES TIPICOS:
           - Olvidar que el array debe estar ORDENADO.
           - No poner el +1 o -1 en las llamadas recursivas (bucle infinito).
           - Confundir < y > en las comparaciones.
           - Olvidar el caso base inf > sup (StackOverflowError).
           - Usar length en vez de length-1 como indice superior inicial.
           - Poner if (inf >= sup) en vez de if (inf > sup) - se salta el ultimo elemento.

        7. TRUCOS RAPIDOS:
           - Siempre tres caminos: <, >, == (else).
           - Si buscas y no encuentras, inf acaba siendo > sup.
           - La mitad se recalcula en CADA llamada recursiva.
           - Para arrays de 8 elementos, maximo 4 llamadas recursivas.
           - Si el elemento esta justo en el medio, solo 1 llamada.

        ====================================================================
        """;

    // -------------------------------------------------------------
    // METODO BUSQUEDA BINARIA (recursivo)
    // -------------------------------------------------------------
    static boolean busquedaBinaria(int[] nums, int buscado, int inf, int sup) {
        if (inf > sup) {
            return false;
        }

        int mitad = (inf + sup) / 2;

        if (nums[mitad] < buscado) {
            return busquedaBinaria(nums, buscado, mitad + 1, sup);
        } else if (nums[mitad] > buscado) {
            return busquedaBinaria(nums, buscado, inf, mitad - 1);
        } else {
            return true;
        }
    }

    // -------------------------------------------------------------
    // VERSION CON DEBUG (muestra los indices en cada llamada)
    // -------------------------------------------------------------
    static boolean busquedaBinariaDebug(int[] nums, int buscado, int inf, int sup) {
        System.out.println("  Llamada: inf=" + inf + ", sup=" + sup);

        if (inf > sup) {
            System.out.println("  -> inf > sup, NO encontrado");
            return false;
        }

        int mitad = (inf + sup) / 2;
        System.out.println("  -> mitad=" + mitad + " (nums[mitad]=" + nums[mitad] + ")");

        if (nums[mitad] < buscado) {
            System.out.println("  -> " + nums[mitad] + " < " + buscado + ", buscar en DERECHA");
            return busquedaBinariaDebug(nums, buscado, mitad + 1, sup);
        } else if (nums[mitad] > buscado) {
            System.out.println("  -> " + nums[mitad] + " > " + buscado + ", buscar en IZQUIERDA");
            return busquedaBinariaDebug(nums, buscado, inf, mitad - 1);
        } else {
            System.out.println("  -> " + nums[mitad] + " == " + buscado + " ENCONTRADO!");
            return true;
        }
    }

    // -------------------------------------------------------------
    // METODO INTERMEDIO (muestra resultado)
    // -------------------------------------------------------------
    static void mostrarBusquedaBinaria(int[] nums, int buscado) {
        System.out.print("  Buscando " + buscado + ": ");
        if (busquedaBinaria(nums, buscado, 0, nums.length - 1)) {
            System.out.println("El numero " + buscado + " ESTA en el array.");
        } else {
            System.out.println("El numero " + buscado + " NO esta en el array.");
        }
    }

    // -------------------------------------------------------------
    // GENERAR ARRAY ORDENADO
    // -------------------------------------------------------------
    static int[] generarArrayOrdenado(int elementos) {
        int[] arr = new int[elementos];
        for (int i = 0; i < elementos; i++) {
            arr[i] = i + 1;  // 1, 2, 3, ..., n
        }
        return arr;
    }

    // -------------------------------------------------------------
    // METODO PRINCIPAL
    // -------------------------------------------------------------
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: Busqueda basica (elemento existe y no existe)
        // ============================================================
        separador("EJEMPLO 1: Busqueda basica");
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("  Array: " + java.util.Arrays.toString(nums));
        System.out.println();
        mostrarBusquedaBinaria(nums, 4);
        mostrarBusquedaBinaria(nums, 9);
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Debug paso a paso
        // ============================================================
        separador("EJEMPLO 2: Debug - Buscar 9 en array 1..8");
        System.out.println("  Array: " + java.util.Arrays.toString(nums));
        System.out.println();
        System.out.print("  Resultado: ");
        boolean encontrado = busquedaBinariaDebug(nums, 9, 0, nums.length - 1);
        System.out.println("  Resultado final: " + encontrado);
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Busqueda en array grande
        // ============================================================
        separador("EJEMPLO 3: Array grande (1..1000)");
        int[] numsGrande = generarArrayOrdenado(1000);

        // Buscar elemento que existe (cerca del final)
        java.time.Instant inicio = java.time.Instant.now();
        boolean encontrado1 = busquedaBinaria(numsGrande, 999, 0, numsGrande.length - 1);
        java.time.Instant fin = java.time.Instant.now();
        System.out.println("  Buscar 999: " + (encontrado1 ? "ENCONTRADO" : "NO ENCONTRADO")
            + " (tiempo: " + java.time.Duration.between(inicio, fin).toNanos() + " ns)");

        // Buscar elemento que NO existe
        inicio = java.time.Instant.now();
        boolean encontrado2 = busquedaBinaria(numsGrande, 1500, 0, numsGrande.length - 1);
        fin = java.time.Instant.now();
        System.out.println("  Buscar 1500: " + (encontrado2 ? "ENCONTRADO" : "NO ENCONTRADO")
            + " (tiempo: " + java.time.Duration.between(inicio, fin).toNanos() + " ns)");
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Busqueda lineal VS binaria (comparacion)
        // ============================================================
        separador("EJEMPLO 4: Lineal vs Binaria (array 1.000.000)");
        int[] numsMega = generarArrayOrdenado(1000000);
        int buscar = 999999;  // Buscar el penultimo

        // Busqueda lineal
        inicio = java.time.Instant.now();
        boolean lineal = false;
        for (int n : numsMega) {
            if (n == buscar) { lineal = true; break; }
        }
        fin = java.time.Instant.now();
        long tiempoLineal = java.time.Duration.between(inicio, fin).toNanos();

        // Busqueda binaria
        inicio = java.time.Instant.now();
        boolean binaria = busquedaBinaria(numsMega, buscar, 0, numsMega.length - 1);
        fin = java.time.Instant.now();
        long tiempoBinaria = java.time.Duration.between(inicio, fin).toNanos();

        System.out.println("  Busqueda lineal:  " + (lineal ? "ENCONTRADO" : "NO") + " - " + tiempoLineal + " ns");
        System.out.println("  Busqueda binaria: " + (binaria ? "ENCONTRADO" : "NO") + " - " + tiempoBinaria + " ns");
        if (tiempoBinaria > 0) {
            System.out.println("  La binaria es " + (tiempoLineal / tiempoBinaria) + "x mas rapida!");
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 5: IMPORTANTE - Sin ordenar NO funciona
        // ============================================================
        separador("EJEMPLO 5: Sin ordenar NO funciona (DEMOSTRACION)");
        int[] desordenado = {8, 3, 5, 1, 7, 2, 6, 4};
        System.out.println("  Array DESORDENADO: " + java.util.Arrays.toString(desordenado));
        System.out.println("  Buscando el 4 en array desordenado...");
        System.out.print("  Resultado: ");
        // Con debug se ve que falla porque parte mal por estar desordenado
        boolean resultado = busquedaBinariaDebug(desordenado, 4, 0, desordenado.length - 1);
        System.out.println("  Resultado final: " + resultado + " (FALLO porque array no estaba ordenado)");
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 4 - V21: BUSQUEDA BINARIA)");
        System.out.println("============================================================");
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
