class Video_4_03_Ejercicios_Iniciacion_Arrays {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-03 JAVA: Ejercicios iniciación Arrays ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=QIdiaJcDBHI&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=68";
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
          RESUMEN RAPIDO - EJERCICIOS INICIACION ARRAYS (TEMA 4 - V3)
        ====================================================================

        -- EJERCICIO 1: CONTAR OCURRENCIAS DE UN VALOR --
        static void ejercicio1(int[] array, int n) {
            int contador = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == n) contador++;
            }
            if (contador == 0)
                System.out.println("El valor " + n + " no aparece en el array");
            else
                System.out.println("El valor " + n + " aparece " + contador
                    + (contador == 1 ? " vez" : " veces") + " en el array");
        }

        - Recorrer todo el array comparando cada elemento con n.
        - Si contador == 0 -> mensaje "no aparece".
        - Usar ternaria para singular/plural (vez / veces).

        -- EJERCICIO 2: STRING MAS LARGA --
        static void ejercicio2(String[] palabras) {
            String palabraMax = "";
            for (int i = 0; i < palabras.length; i++) {
                if (palabras[i].length() > palabraMax.length()) {
                    palabraMax = palabras[i];
                }
            }
            System.out.println("La palabra mas larga es \\"" + palabraMax + "\\".");
        }

        - Inicializar palabraMax = "".
        - Si palabras[i].length() > palabraMax.length() -> actualizar.
        - Con > se queda con la PRIMERA mas larga (no la ultima).
        - Mostrar entre comillas dobles con secuencia de escape \\".

        -- EJERCICIO 3: PALABRAS QUE EMPIEZAN POR UNA LETRA --
        static void ejercicio3(String[] palabras, char letra) {
            for (int i = 0; i < palabras.length; i++) {
                if (palabras[i].toLowerCase().charAt(0)
                    == Character.toString(letra).toLowerCase().charAt(0)) {
                    System.out.println(palabras[i]);
                }
            }
        }

        - palabras[i].charAt(0) -> primera letra de cada palabra.
        - Para ignorar mayus/minus: pasar ambos a minuscula con toLowerCase().
        - Character.toString(letra).toLowerCase().charAt(0) para la letra.

        -- EJERCICIO 4: MAXIMOS DE DOS ARRAYS (2 VERSIONES) --

        Version 1 - Tamaño MINIMO (descarta sobrantes):
        static int[] ejercicio4(int[] a, int[] b) {
            int[] c;
            if (a.length > b.length) c = new int[b.length];
            else c = new int[a.length];
            for (int i = 0; i < c.length; i++) {
                if (a[i] > b[i]) c[i] = a[i];
                else c[i] = b[i];
            }
            return c;
        }

        Version 2 - Tamaño MAXIMO (usa valores del mas largo):
        static int[] ejercicio4_2(int[] a, int[] b) {
            int[] c;
            if (a.length > b.length) c = new int[a.length];
            else c = new int[b.length];
            for (int i = 0; i < c.length; i++) {
                if (i >= a.length) c[i] = b[i];        // B es mas largo
                else if (i >= b.length) c[i] = a[i];    // A es mas largo
                else if (a[i] > b[i]) c[i] = a[i];      // mismos indices
                else c[i] = b[i];
            }
            return c;
        }

        - V1: el array resultante tiene el tamaño del mas corto.
        - V2: el array resultante tiene el tamaño del mas largo.
          Cuando un indice no existe en un array, se copia el del otro.

        -- METODO AUXILIAR PARA MOSTRAR ARRAY --
        static void mostrarArray(int[] n) {
            for (int i = 0; i < n.length; i++) {
                System.out.print(n[i] + " ");
            }
            System.out.println();
        }

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. CONTAR OCURRENCIAS (Ej1):
           - NO olvides inicializar contador = 0.
           - Usa if (array[i] == n) -> contador++.
           - Cuidado con el mensaje: singular "vez" / plural "veces".
           - Si contador == 0, mostrar "no aparece".
           - TRUCO: ternaria (contador == 1 ? " vez" : " veces") para ahorrar if-else.

        2. STRING MAS LARGA (Ej2):
           - Inicializar palabraMax = "" (String vacia, no null).
           - Si usas null y haces .length() -> NullPointerException.
           - Comparar con >, NO con >= (asi te quedas con la primera mas larga).
           - Usar palabras[i].length() para obtener la longitud.
           - ERROR TIPICO: confundir length (del array) con length() (del String).

        3. FILTRAR POR PRIMERA LETRA (Ej3):
           - palabras[i].charAt(0) -> primera letra.
           - Para ignorar mayusculas: toLowerCase() en ambos lados.
           - Character.toString(letra).toLowerCase().charAt(0) -> letra a minuscula.
           - Si no conviertes, 'A' != 'a' y fallara.
           - OPCION mas simple: if (palabras[i].toUpperCase().charAt(0) == Character.toUpperCase(letra))

        4. MAXIMOS DE DOS ARRAYS (Ej4):
           - V1 (tamaño minimo): nuevo array con Math.min(a.length, b.length).
           - V2 (tamaño maximo): nuevo array con Math.max(a.length, b.length).
           - En V2, comprobar si i >= a.length o i >= b.length antes de comparar.
           - Si no haces esa comprobacion -> ArrayIndexOutOfBoundsException.
           - RECUERDA: el metodo debe DEVOLVER un array (return c), no imprimirlo.

        5. ERRORES COMUNES EN EXAMEN:
           - ArrayIndexOutOfBoundsException: acceder a array[array.length] (indice fuera).
           - NullPointerException: array no inicializado o palabraMax = null.
           - Confundir length (atributo de array) con length() (metodo de String).
           - Olvidar el return cuando el metodo debe devolver un array.
           - No proteger indices cuando los arrays tienen distinto tamaño.

        6. TRUCOS RAPIDOS:
           - Para el minimo de dos tamaños: Math.min(a.length, b.length)
           - Para el maximo de dos tamaños: Math.max(a.length, b.length)
           - Singular/plural con ternaria: (n == 1 ? "" : "s")
           - Mostrar array: bucle for con print, y un println fuera.
           - Siempre que devuelvas un array, el tipo de retorno lleva corchetes: static int[] metodo()

        ====================================================================
        """;

    // -------------------------------------------------------------
    // METODO PRINCIPAL
    // -------------------------------------------------------------

    public static void main(String[] args) {

        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();

        // ============================================================
        // DATOS DE PRUEBA
        // ============================================================

        int[] array = {1, 2, 3, 4, 1, 1, 0};

        String[] palabras = {"a", "aa", "aaa", "bbb", "Aaaaa", "n", "Nn"};

        int[] arr1 = {4, 8, 15, 1};
        int[] arr2 = {7, 2, 11, 18};
        int[] arrCorto = {4, 8, 15};
        int[] arrLargo = {7, 2, 11, 18, 5, 9};

        // ============================================================
        // EJEMPLO 1: Contar ocurrencias
        // ============================================================

        separador("EJEMPLO 1: Contar ocurrencias");
        System.out.println("  Array: {1, 2, 3, 4, 1, 1, 0}");
        System.out.print("  Buscando el 1: ");
        ejercicio1(array, 1);
        System.out.print("  Buscando el 4: ");
        ejercicio1(array, 4);
        System.out.print("  Buscando el 5: ");
        ejercicio1(array, 5);
        System.out.println();

        // ============================================================
        // EJEMPLO 2: String mas larga
        // ============================================================

        separador("EJEMPLO 2: String mas larga");
        System.out.println("  Palabras: {a, aa, aaa, bbb, Aaaaa, n, Nn}");
        System.out.print("  Resultado: ");
        ejercicio2(palabras);
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Palabras que empiezan por una letra
        // ============================================================

        separador("EJEMPLO 3: Palabras que empiezan por una letra");
        System.out.println("  Palabras: {a, aa, aaa, bbb, Aaaaa, n, Nn}");
        System.out.println("  Letra 'a' (sin importar mayusculas):");
        System.out.print("    ");
        ejercicio3(palabras, 'a');
        System.out.println("  Letra 'n' (sin importar mayusculas):");
        System.out.print("    ");
        ejercicio3(palabras, 'n');
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Maximos de dos arrays (V1 - tamaño minimo)
        // ============================================================

        separador("EJEMPLO 4: Maximos de dos arrays");
        System.out.println("  arr1 = {4, 8, 15, 1}");
        System.out.println("  arr2 = {7, 2, 11, 18}");
        System.out.print("  V1 (tamaño minimo): { ");
        mostrarArray(ejercicio4(arr1, arr2));
        System.out.println("  }");

        // ============================================================
        // EJEMPLO 5: Maximos de dos arrays (V2 - tamaño maximo)
        // ============================================================

        separador("EJEMPLO 5: Maximos con arrays de distinto tamaño");
        System.out.println("  arrCorto = {4, 8, 15} (longitud 3)");
        System.out.println("  arrLargo = {7, 2, 11, 18, 5, 9} (longitud 6)");
        System.out.print("  V1 (tamaño minimo -> descarta sobrantes): { ");
        mostrarArray(ejercicio4(arrCorto, arrLargo));
        System.out.print("  V2 (tamaño maximo -> usa valores del mas largo): { ");
        mostrarArray(ejercicio4_2(arrCorto, arrLargo));

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Mas ejercicios con arrays");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // EJERCICIO 1: Contar ocurrencias de un valor en un array
    // -------------------------------------------------------------
    static void ejercicio1(int[] array, int n) {
        int contador = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("El valor " + n + " no aparece en el array");
        } else {
            System.out.println("El valor " + n + " aparece " + contador
                + (contador == 1 ? " vez" : " veces") + " en el array");
        }
    }

    // -------------------------------------------------------------
    // EJERCICIO 2: Mostrar la String mas larga
    // -------------------------------------------------------------
    static void ejercicio2(String[] palabras) {
        String palabraMax = "";
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].length() > palabraMax.length()) {
                palabraMax = palabras[i];
            }
        }
        System.out.println("La palabra mas larga es \"" + palabraMax + "\".");
    }

    // -------------------------------------------------------------
    // EJERCICIO 3: Mostrar strings cuya primera letra sea un char
    // -------------------------------------------------------------
    static void ejercicio3(String[] palabras, char letra) {
        // Pasamos la letra a minuscula para comparar sin importar mayusculas
        char letraMinus = Character.toString(letra).toLowerCase().charAt(0);
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].toLowerCase().charAt(0) == letraMinus) {
                System.out.print(palabras[i] + " ");
            }
        }
        System.out.println();
    }

    // -------------------------------------------------------------
    // EJERCICIO 4 (V1): Devolver array con maximos (tamaño minimo)
    // -------------------------------------------------------------
    static int[] ejercicio4(int[] a, int[] b) {
        int[] c;
        if (a.length > b.length) {
            c = new int[b.length];
        } else {
            c = new int[a.length];
        }
        for (int i = 0; i < c.length; i++) {
            if (a[i] > b[i]) {
                c[i] = a[i];
            } else {
                c[i] = b[i];
            }
        }
        return c;
    }

    // -------------------------------------------------------------
    // EJERCICIO 4 (V2): Devolver array con maximos (tamaño maximo)
    // -------------------------------------------------------------
    static int[] ejercicio4_2(int[] a, int[] b) {
        int[] c;
        if (a.length > b.length) {
            c = new int[a.length];
        } else {
            c = new int[b.length];
        }
        for (int i = 0; i < c.length; i++) {
            if (i >= a.length) {
                c[i] = b[i];          // B es mas largo, no hay a[i]
            } else if (i >= b.length) {
                c[i] = a[i];          // A es mas largo, no hay b[i]
            } else if (a[i] > b[i]) {
                c[i] = a[i];
            } else {
                c[i] = b[i];
            }
        }
        return c;
    }

    // -------------------------------------------------------------
    // METODO AUXILIAR: mostrarArray
    // -------------------------------------------------------------
    static void mostrarArray(int[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }
    }

    // -------------------------------------------------------------
    // METODO AUXILIAR: separador
    // -------------------------------------------------------------
    public static void separador(String titulo) {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("  " + titulo);
        System.out.println("============================================================");
    }
}
