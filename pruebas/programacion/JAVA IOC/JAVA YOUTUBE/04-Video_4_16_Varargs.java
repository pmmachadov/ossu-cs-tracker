class Video_4_16_Varargs {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-16 JAVA: Varargs DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=8nBfF4pQKLY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=81";
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
          RESUMEN RAPIDO - VARARGS (TEMA 4 - V16)
        ====================================================================

        --- QUE SON LOS VARARGS ---
        Parametros de LONGITUD VARIABLE que permiten invocar un metodo
        con cualquier cantidad de argumentos (0, 1, o mas).
        Internamente se transforman en un ARRAY.

        --- SINTAXIS ---
        tipo... nombreParametro
        Ejemplo: static void mostrar(int... nums) { ... }

        - Los tres puntos (...) van DESPUES del tipo y ANTES del nombre.
        - Solo puede haber UN varargs por metodo.
        - El varargs debe ser el ULTIMO parametro (si hay mas).

        --- COMO FUNCIONA ---
        mostrar();           // nums.length == 0
        mostrar(1);          // nums.length == 1, nums[0] = 1
        mostrar(1, 2, 3);    // nums.length == 3, nums = {1,2,3}

        Dentro del metodo se trata como un array normal:
          for (int i = 0; i < nums.length; i++) { ... }

        --- EJEMPLO 1: Varargs de enteros ---
        static void mostrarEnteros(int... nums) {
            System.out.println("Hay " + nums.length + " enteros: ");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }

        --- EJEMPLO 2: Varargs de Strings en main ---
        // El metodo main podria escribirse con varargs:
        public static void main(String... args) { ... }

        --- PUNTOS CLAVE ---
        - Varargs = array. Se puede usar length, indices, for-each.
        - Se puede invocar con 0, 1, o N argumentos.
        - Tambien se puede pasar un array directamente.
        - Solo un varargs por metodo y debe ser el ultimo parametro.

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. SINTAXIS CORRECTA:
           - int... nums  (bien)
           - int ...nums  (bien, con espacio)
           - int...nums   (bien, sin espacio)
           - int[] nums   (array normal, NO varargs)

        2. VARARGS VS ARRAY:
           - Con varargs: llamada metodo(1, 2, 3)
           - Con array:   int[] arr = {1,2,3}; metodo(arr)
           - Varargs acepta ambas formas de llamada.

        3. RESTRICCIONES:
           - Solo UN varargs por metodo.
           - Debe ser el ULTIMO parametro.
           - Correcto: metodo(String s, int... nums)
           - Incorrecto: metodo(int... nums, String s)

        4. DENTRO DEL METODO:
           - nums.length = cantidad de argumentos.
           - nums[0], nums[1], ... para acceder.
           - Se puede usar for-each: for (int n : nums)

        5. ERRORES TIPICOS:
           - Poner el varargs antes de otro parametro.
           - Tener mas de un varargs en el mismo metodo.
           - Esperar que varargs sea distinto de array (son lo mismo).
           - Olvidar que se puede llamar con 0 argumentos (length = 0).

        6. TRUCOS RAPIDOS:
           - Varargs simplifica llamadas con varios parametros.
           - Internamente es un array: usa .length y los indices.
           - Para pasar un array existente: metodo(miArray)
           - Para pasar nada: metodo()

        ====================================================================
        """;
    // -------------------------------------------------------------
    // METODO 1: Varargs de enteros
    // -------------------------------------------------------------
    static void mostrarEnteros(int... nums) {
        System.out.print("Hay " + nums.length + " enteros: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    // -------------------------------------------------------------
    // METODO 2: Varargs de Strings (similar a String[] args)
    // -------------------------------------------------------------
    static void mostrarStrings(String... args) {
        if (args.length > 0) {
            System.out.println("Hola mundo con " + args.length + " args:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("  args[" + i + "] = \"" + args[i] + "\"");
            }
        } else {
            System.out.println("Hola mundo sin args");
        }
    }

    // -------------------------------------------------------------
    // METODO PRINCIPAL
    // -------------------------------------------------------------
    public static void main(String... args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: Varargs de enteros - sin parametros
        // ============================================================
        separador("EJEMPLO 1: mostrarEnteros() - sin parametros");
        mostrarEnteros();
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Varargs de enteros - con varios valores
        // ============================================================
        separador("EJEMPLO 2: mostrarEnteros(1, 2, 3)");
        mostrarEnteros(1, 2, 3);
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Varargs con variables y expresiones
        // ============================================================
        separador("EJEMPLO 3: mostrarEnteros con expresiones");
        int a = 2, b = 3;
        mostrarEnteros(b, a++, a * b, ++b);
        System.out.println("  Nota: a++ pasa el valor y luego incrementa,");
        System.out.println("        ++b incrementa y luego pasa el valor.");
        System.out.println("  a=" + a + ", b=" + b + " (despues de la llamada)");
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Varargs de Strings
        // ============================================================
        separador("EJEMPLO 4: mostrarStrings con args del main");
        mostrarStrings(args);
        System.out.println();

        // ============================================================
        // EJEMPLO 5: Varargs con array existente
        // ============================================================
        separador("EJEMPLO 5: Pasar array directamente a varargs");
        int[] arrayExistente = {10, 20, 30, 40, 50};
        System.out.println("  int[] arr = {10, 20, 30, 40, 50};");
        System.out.print("  mostrarEnteros(arr): ");
        mostrarEnteros(arrayExistente);
        System.out.println();

        // ============================================================
        // DEMO: main con varargs
        // ============================================================
        separador("DEMO: main(String... args) con varargs");
        System.out.println("  El main tambien puede usar varargs:");
        System.out.println("  public static void main(String... args)");
        System.out.println("  Es equivalente a String[] args.");
        System.out.println("  Si ejecutas con argumentos se mostraran arriba.");
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
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
