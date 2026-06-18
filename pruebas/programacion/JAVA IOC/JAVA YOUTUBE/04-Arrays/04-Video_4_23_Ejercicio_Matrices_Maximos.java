class Video_4_23_Ejercicio_Matrices_Maximos {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-23 JAVA: Ejercicios matrices DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=5nWAU7WwhoM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=88";
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
          RESUMEN RAPIDO - EJERCICIOS MATRICES: MAXIMOS (TEMA 4 - V23)
        ====================================================================

        --- EJERCICIO 3: Maximo de cada columna y de cada fila ---

        Se pide disenar dos metodos a partir de una matriz de enteros:

        1. maximosColumnas(int[][] matriz) -> int[]
           - Devuelve un array con el maximo de CADA COLUMNA
           - El array tendra tantos elementos como la FILA MAS ANCHA
           - Funciona incluso con matrices IRREGULARES

        2. maximosFilas(int[][] matriz) -> int[]
           - Devuelve un array con el maximo de CADA FILA
           - El array tendra tantos elementos como FILAS tenga la matriz

        --- CODIGO: maximo de cada columna ---
        static int[] maximosColumnas(int[][] matriz) {
            // 1. Buscar la fila mas ancha
            int anchoMax = 0;
            for (int[] fila : matriz) {
                if (fila.length > anchoMax) {
                    anchoMax = fila.length;
                }
            }

            // 2. Inicializar array con el minimo valor entero
            int[] arrayMaximos = new int[anchoMax];
            for (int i = 0; i < arrayMaximos.length; i++) {
                arrayMaximos[i] = Integer.MIN_VALUE;
            }

            // 3. Recorrer la matriz y actualizar maximos por columna
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    if (matriz[i][j] > arrayMaximos[j]) {
                        arrayMaximos[j] = matriz[i][j];
                    }
                }
            }

            return arrayMaximos;
        }

        --- CODIGO: maximo de cada fila ---
        static int[] maximosFilas(int[][] matriz) {
            int[] arrayMaximos = new int[matriz.length];

            for (int i = 0; i < matriz.length; i++) {
                int maxFila = Integer.MIN_VALUE;
                for (int j = 0; j < matriz[i].length; j++) {
                    if (matriz[i][j] > maxFila) {
                        maxFila = matriz[i][j];
                    }
                }
                arrayMaximos[i] = maxFila;
            }

            return arrayMaximos;
        }

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. PROBLEMA DE LOS VALORES NEGATIVOS:
           - Al crear un array de int con new, todos los valores son 0.
           - Si TODOS los elementos de la matriz son negativos, el maximo
             seria 0 (incorrecto).
           - SOLUCION: inicializar con Integer.MIN_VALUE en vez de confiar
             en el valor por defecto 0.

        2. MATRICES IRREGULARES en maximosColumnas:
           - No todas las filas tienen la misma longitud.
           - Primero hay que buscar la FILA MAS ANCHA (for-each).
           - El array resultado tendra ese tamano.

        3. CLAVE del bucle anidado:
           - i recorre FILAS (matriz.length)
           - j recorre COLUMNAS de la fila actual (matriz[i].length)
           - arrayMaximos[j] guarda el maximo de la columna j

        4. DIFERENCIA entre los dos metodos:
           - Columnas: array del tamano de la fila mas ancha
           - Filas: array del tamano del numero de filas (= matriz.length)

        ====================================================================
        """;

    // -------------------------------------------------------------
    // METODO: maximo de cada COLUMNA
    // -------------------------------------------------------------
    static int[] maximosColumnas(int[][] matriz) {
        // Buscar la fila mas ancha (para matrices irregulares)
        int anchoMax = 0;
        for (int[] fila : matriz) {
            if (fila.length > anchoMax) {
                anchoMax = fila.length;
            }
        }

        // Inicializar con el valor minimo (por si todos son negativos)
        int[] arrayMaximos = new int[anchoMax];
        for (int i = 0; i < arrayMaximos.length; i++) {
            arrayMaximos[i] = Integer.MIN_VALUE;
        }

        // Recorrer la matriz y actualizar maximos por cada columna
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > arrayMaximos[j]) {
                    arrayMaximos[j] = matriz[i][j];
                }
            }
        }

        return arrayMaximos;
    }

    // -------------------------------------------------------------
    // METODO: maximo de cada FILA
    // -------------------------------------------------------------
    static int[] maximosFilas(int[][] matriz) {
        int[] arrayMaximos = new int[matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            int maxFila = Integer.MIN_VALUE;
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maxFila) {
                    maxFila = matriz[i][j];
                }
            }
            arrayMaximos[i] = maxFila;
        }

        return arrayMaximos;
    }

    // -------------------------------------------------------------
    // METODO AUXILIAR: mostrar matriz
    // -------------------------------------------------------------
    static void mostrarMatriz(int[][] matriz) {
        if (matriz.length == 0) {
            System.out.println("  [matriz vacia - 0 filas]");
            return;
        }
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("  F" + i + ": " + java.util.Arrays.toString(matriz[i]));
        }
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
        // EJEMPLO 1: Matriz regular 5x3 (del video)
        // ============================================================
        separador("EJEMPLO 1: Matriz regular 5x3 (numMax=9)");
        int[][] nums = Video_4_22_Generador_Matrices.generarMatriz(5, 3, 9);
        System.out.println("  Matriz original (" + nums.length + " filas x " + nums[0].length + " col):");
        mostrarMatriz(nums);
        System.out.println();

        int[] maxCols = maximosColumnas(nums);
        int[] maxFils = maximosFilas(nums);
        System.out.println("  Maximos de cada columna: " + java.util.Arrays.toString(maxCols));
        System.out.println("  Maximos de cada fila:    " + java.util.Arrays.toString(maxFils));
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Matriz irregular (para probar que funciona)
        // ============================================================
        separador("EJEMPLO 2: Matriz irregular (anchoMin=3, anchoMax=8, altoMin=5, altoMax=9, numMax=99)");
        int[][] irregular = Video_4_22_Generador_Matrices.generarMatriz(3, 8, 5, 9, 99);
        System.out.println("  Matriz irregular (" + irregular.length + " filas):");
        mostrarMatriz(irregular);
        System.out.println();

        int[] maxColsIrreg = maximosColumnas(irregular);
        int[] maxFilsIrreg = maximosFilas(irregular);
        System.out.println("  Maximos de cada columna: " + java.util.Arrays.toString(maxColsIrreg)
            + " (tamano=" + maxColsIrreg.length + ", = fila mas ancha)");
        System.out.println("  Maximos de cada fila:    " + java.util.Arrays.toString(maxFilsIrreg)
            + " (tamano=" + maxFilsIrreg.length + ", = num filas)");
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Todos negativos (prueba del Integer.MIN_VALUE)
        // ============================================================
        separador("EJEMPLO 3: Matriz con todos negativos");
        int[][] negativos = {
            {-5, -3, -8},
            {-2, -9, -1},
            {-7, -4, -6}
        };
        System.out.println("  Matriz:");
        mostrarMatriz(negativos);
        System.out.println();

        int[] maxColsNeg = maximosColumnas(negativos);
        int[] maxFilsNeg = maximosFilas(negativos);
        System.out.println("  Maximos de cada columna: " + java.util.Arrays.toString(maxColsNeg));
        System.out.println("  Maximos de cada fila:    " + java.util.Arrays.toString(maxFilsNeg));
        System.out.println("  (Gracias a Integer.MIN_VALUE, los maximos son correctos)");
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Una fila mas ancha que las demas
        // ============================================================
        separador("EJEMPLO 4: Matriz con fila de distinto ancho");
        int[][] desigual = {
            {1, 2, 3, 4, 5},
            {9, 8, 7},
            {6}
        };
        System.out.println("  Matriz:");
        mostrarMatriz(desigual);
        System.out.println();
        System.out.println("  La fila mas ancha es la 0 (5 elementos)");

        int[] maxColsDes = maximosColumnas(desigual);
        int[] maxFilsDes = maximosFilas(desigual);
        System.out.println("  Maximos de cada columna: " + java.util.Arrays.toString(maxColsDes));
        System.out.println("  Maximos de cada fila:    " + java.util.Arrays.toString(maxFilsDes));
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 4 - V23: EJERCICIOS MATRICES - MAXIMOS)");
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
