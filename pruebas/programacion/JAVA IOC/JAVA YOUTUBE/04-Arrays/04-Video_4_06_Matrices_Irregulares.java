class Video_4_06_Matrices_Irregulares {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-06 JAVA: Matrices irregulares ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=lVM9KB3iDQo&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=71";
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
          RESUMEN RAPIDO - MATRICES IRREGULARES (TEMA 4 - V6)
        ====================================================================

        --- QUE SON ---
        Matrices donde cada fila puede tener DISTINTA cantidad de elementos.
        No todas las filas tienen el mismo numero de columnas.

        --- DECLARACION CON VALORES ---
        int[][] b = {
            {1, 2, 3},        // fila 0: 3 elementos
            {4, 5, 6, 7},     // fila 1: 4 elementos
            {8, 9}            // fila 2: 2 elementos
        };

        b.length        -> 3 (filas)
        b[0].length     -> 3
        b[1].length     -> 4
        b[2].length     -> 2

        --- FILA VACIA (array de longitud 0) ---
        int[][] b = {
            {1, 2, 3},
            {4, 5, 6, 7},
            {},              // fila 2: array VACIO (longitud 0, pero existe)
            {9, 7}
        };
        b[2].length -> 0 (no da error, es un array valido de 0 elementos)

        --- INICIALIZACION MANUAL (peligro: null) ---
        int[][] b = new int[4][];    // solo se indica numero de filas
        b[0] = new int[3];           // fila 0: array de 3 enteros (todos 0)
        b[1] = new int[4];           // fila 1: array de 4 enteros (todos 0)
        // b[2] NO se inicializa -> vale null
        b[3] = new int[2];           // fila 3: array de 2 enteros (todos 0)

        IMPORTANTE:
        - b[2] es null (no se ha creado el array)
        - b[2].length  -> NullPointerException (ERROR!)
        - Hay que comprobar b[i] != null antes de acceder

        --- RECORRER MATRIZ IRREGULAR (con null check) ---
        for (int i = 0; i < b.length; i++) {
            if (b[i] != null) {                    // <-- OBLIGATORIO si hay null
                for (int j = 0; j < b[i].length; j++) {
                    System.out.print(b[i][j] + " ");
                }
            }
            System.out.println();   // salto de linea aunque la fila sea null/vacia
        }

        --- ASIGNAR VALORES EN MATRIZ IRREGULAR ---
        int[][] b = new int[5][];
        for (int i = 0; i < b.length; i++) {
            b[i] = new int[i + 1];   // fila 0: 1 elem, fila 1: 2 elems...
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = j + 1;     // 1, 12, 123, 1234...
            }
        }

        --- TRUCO: CONTADOR CON MODULO (numeros 1-9 sin 0) ---
        int contador = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = (++contador) % 10;  // 1..9,0,1..9,0...
            }
        }
        // Para evitar el 0:
        b[i][j] = (++contador) % 10 == 0 ? (++contador) % 10 : contador % 10;

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. DISTINCION CLAVE:
           - Matriz regular: todas las filas tienen el mismo length.
           - Matriz irregular: cada fila puede tener distinto length.
           - El codigo para recorrer AMBAS es el mismo: b[i].length

        2. NULL vs ARRAY VACIO:
           - {} es un array VACIO (length 0, pero existe).
           - No inicializar una fila -> null (no existe).
           - b[i].length sobre null -> NullPointerException.
           - Siempre comprobar: if (b[i] != null) antes de usar b[i].length

        3. ERRORES TIPICOS EN EXAMEN:
           - Acceder a b[0][3] cuando la fila 0 solo tiene 3 elementos (indice 0..2)
           - No comprobar null en matrices inicializadas manualmente.
           - ArrayIndexOutOfBoundsException por asumir que todas las filas miden igual.
           - NullPointerException por acceder a .length de una fila no inicializada.

        4. TRUCOS RAPIDOS:
           - Para crear matriz triangular: b[i] = new int[i+1];
           - Para rellenar en diagonal creciente: b[i][j] = j+1;
           - Para secuencia 1..9 sin cero: ternaria con ++contador % 10
           - El bucle for anidado sirve para matrices regulares E irregulares.
           - b.length = numero de filas (arrays internos).

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
        // EJEMPLO 1: Matriz irregular con valores literales
        // ============================================================

        separador("EJEMPLO 1: Matriz irregular con valores");
        int[][] b = {
            {1, 2, 3},
            {4, 5, 6, 7},
            {8, 9}
        };
        System.out.println("  Matriz: { {1,2,3}, {4,5,6,7}, {8,9} }");
        System.out.println("  Filas: " + b.length);
        System.out.println("  b[0].length = " + b[0].length + " | b[1].length = " + b[1].length + " | b[2].length = " + b[2].length);
        System.out.println("  Contenido:");
        mostrarMatriz(b);
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Matriz con fila vacia {}
        // ============================================================

        separador("EJEMPLO 2: Matriz con fila vacia {}");
        int[][] b2 = {
            {1, 2, 3},
            {4, 5, 6, 7},
            {},              // array vacio (length 0, pero existe)
            {9, 7}
        };
        System.out.println("  Filas: " + b2.length);
        System.out.println("  b2[2].length = " + b2[2].length + " (array vacio, no null)");
        System.out.println("  Contenido:");
        mostrarMatriz(b2);
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Inicializacion manual (con null)
        // ============================================================

        separador("EJEMPLO 3: Inicializacion manual (con null)");
        int[][] b3 = new int[4][];
        b3[0] = new int[3];   // fila 0: 3 elementos (todos 0)
        b3[1] = new int[4];   // fila 1: 4 elementos (todos 0)
        // b3[2] NO se inicializa -> null
        b3[3] = new int[2];   // fila 3: 2 elementos (todos 0)
        System.out.println("  b3[0] = new int[3] (inicializado)");
        System.out.println("  b3[1] = new int[4] (inicializado)");
        System.out.println("  b3[2] = null (NO inicializado)");
        System.out.println("  b3[3] = new int[2] (inicializado)");
        System.out.println("  Contenido (con comprobacion de null):");
        mostrarMatrizNull(b3);
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Crear matriz triangular con valores
        // ============================================================

        separador("EJEMPLO 4: Matriz triangular (i+1 columnas por fila)");
        int[][] triangulo = new int[5][];
        for (int i = 0; i < triangulo.length; i++) {
            triangulo[i] = new int[i + 1];
            for (int j = 0; j < triangulo[i].length; j++) {
                triangulo[i][j] = j + 1;
            }
        }
        System.out.println("  Matriz triangular 5 filas (i+1 columnas, valores j+1):");
        mostrarMatriz(triangulo);
        System.out.println();

        // ============================================================
        // EJEMPLO 5: Contador con modulo (1..9 sin 0)
        // ============================================================

        separador("EJEMPLO 5: Contador con modulo (1-9 sin cero)");
        int[][] mod = new int[5][];
        int contador = 0;
        for (int i = 0; i < mod.length; i++) {
            mod[i] = new int[i + 1];
            for (int j = 0; j < mod[i].length; j++) {
                int valor = (++contador) % 10;
                mod[i][j] = (valor == 0) ? (++contador) % 10 : valor;
            }
        }
        System.out.println("  Valores 1..9 sin que aparezca el 0:");
        mostrarMatriz(mod);

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Ejercicios con matrices");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODO: mostrarMatriz (sin null check)
    // -------------------------------------------------------------
    static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("  Fila " + i + ": ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // -------------------------------------------------------------
    // METODO: mostrarMatrizNull (con comprobacion de null)
    // -------------------------------------------------------------
    static void mostrarMatrizNull(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("  Fila " + i + ": ");
            if (matriz[i] != null) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
            } else {
                System.out.print("(null)");
            }
            System.out.println();
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
