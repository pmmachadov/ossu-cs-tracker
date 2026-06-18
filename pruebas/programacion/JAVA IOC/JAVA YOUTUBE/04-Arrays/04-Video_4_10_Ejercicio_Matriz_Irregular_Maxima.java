class Video_4_10_Ejercicio_Matriz_Irregular_Maxima {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-10 JAVA: Ejercicio matriz irregular maxima ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=3VFKuMH5Qg0&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=75";
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
          RESUMEN RAPIDO - MATRIZ IRREGULAR MAXIMA (TEMA 4 - V10)
        ====================================================================

        --- ENUNCIADO ---
        Dadas dos matrices IRREGULARES (distintas filas y/o columnas),
        generar una matriz con el MAXIMO de cada posicion.
        Si una posicion solo existe en una matriz, se copia ese valor.

        --- LOGICA PRINCIPAL ---
        1. La matriz resultante tendra tantas FILAS como la mas larga.
        2. Cada fila tendra tantas COLUMNAS como la fila mas larga de esa posicion.
        3. Luego se rellena comparando elemento a elemento.

        --- METODO: crearMatrizMaxima(int[][] a, int[][] b) ---
        static int[][] crearMatrizMaxima(int[][] a, int[][] b) {
            // 1. Determinar numero de filas (el maximo de ambas)
            int filas = Math.max(a.length, b.length);
            int[][] c = new int[filas][];

            // 2. Determinar columnas por fila
            for (int i = 0; i < filas; i++) {
                if (i >= b.length) {               // caso 1: fila solo en A
                    c[i] = new int[a[i].length];
                } else if (i >= a.length) {         // caso 2: fila solo en B
                    c[i] = new int[b[i].length];
                } else {                             // caso 3: fila en ambas
                    c[i] = new int[Math.max(a[i].length, b[i].length)];
                }
            }

            // 3. Rellenar con maximos
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < c[i].length; j++) {
                    if (i >= b.length) {                         // solo A
                        c[i][j] = a[i][j];
                    } else if (i >= a.length) {                  // solo B
                        c[i][j] = b[i][j];
                    } else if (j >= b[i].length) {               // A tiene mas columnas
                        c[i][j] = a[i][j];
                    } else if (j >= a[i].length) {               // B tiene mas columnas
                        c[i][j] = b[i][j];
                    } else {                                      // ambas tienen columna
                        c[i][j] = Math.max(a[i][j], b[i][j]);
                    }
                }
            }
            return c;
        }

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. CASOS A CONSIDERAR (5 en total):
           - Fila solo en A: i >= b.length
           - Fila solo en B: i >= a.length
           - Fila en ambas, columna solo en A: j >= b[i].length
           - Fila en ambas, columna solo en B: j >= a[i].length
           - Fila y columna en ambas: comparar normalmente

        2. ORDEN DE LAS CONDICIONES:
           - Primero comprobar si la FILA existe (i >= length).
           - Luego si la COLUMNA existe (j >= length).
           - Al final, si ambas existen, comparar.

        3. MATH.MAX():
           - Para filas: Math.max(a.length, b.length)
           - Para columnas: Math.max(a[i].length, b[i].length)
           - Para el maximo de dos valores: Math.max(a[i][j], b[i][j])

        4. ERRORES TIPICOS:
           - No comprobar si la fila existe antes de acceder a b[i].length.
           - ArrayIndexOutOfBoundsException por no proteger indices.
           - Crear matriz con new int[filas][columnas] fijo (falla si irregulares).
           - Olvidar el caso de fila/columna que solo existe en una matriz.

        5. TRUCOS RAPIDOS:
           - Math.max() evita if-else para maximos.
           - new int[filas][] + luego new int[a[i].length] para irregulares.
           - El orden de los if-elseifs importa: del mas restrictivo al menos.
           - Si no hay elemento en una matriz, se copia el de la otra (no se compara).

        ====================================================================
        """;

    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: Matrices irregulares de distinto tamano
        // ============================================================
        separador("EJEMPLO 1: Matrices irregulares");
        int[][] a = {{1, 2, 1}, {7, 5}, {7, 8}};
        int[][] b = {{5, 6}, {4, 5, 2}, {1, 8}, {1, 1, 2}};
        System.out.println("  Matriz A: " + java.util.Arrays.deepToString(a));
        System.out.println("  Matriz B: " + java.util.Arrays.deepToString(b));
        System.out.println("  Maximos:");
        for (int[] fila : crearMatrizMaxima(a, b)) {
            System.out.println("    " + java.util.Arrays.toString(fila));
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Con fila vacia en una matriz
        // ============================================================
        separador("EJEMPLO 2: Con fila vacia");
        int[][] c = {{1, 2, 3}, {4, 5}, {7, 8}};
        int[][] d = {{5, 6}, {4, 5, 2}, {}, {1, 1, 2}};
        System.out.println("  Matriz C: " + java.util.Arrays.deepToString(c));
        System.out.println("  Matriz D: " + java.util.Arrays.deepToString(d));
        System.out.println("  Maximos:");
        for (int[] fila : crearMatrizMaxima(c, d)) {
            System.out.println("    " + java.util.Arrays.toString(fila));
        }
        System.out.println();

        // ============================================================
        // COMPARACION
        // ============================================================
        separador("COMPARACION DE RESULTADOS");
        System.out.println("Ej 1: A(3 filas) vs B(4 filas)  -> maxima 4 filas");
        System.out.println("Ej 2: Con fila vacia en D       -> se copia la de C");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODO PRINCIPAL: crear matriz con maximos (irregulares)
    // -------------------------------------------------------------
    static int[][] crearMatrizMaxima(int[][] a, int[][] b) {
        int filas = Math.max(a.length, b.length);
        int[][] c = new int[filas][];

        for (int i = 0; i < filas; i++) {
            if (i >= b.length) {
                c[i] = new int[a[i].length];
            } else if (i >= a.length) {
                c[i] = new int[b[i].length];
            } else {
                c[i] = new int[Math.max(a[i].length, b[i].length)];
            }
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < c[i].length; j++) {
                if (i >= b.length) {
                    c[i][j] = a[i][j];
                } else if (i >= a.length) {
                    c[i][j] = b[i][j];
                } else if (j >= b[i].length) {
                    c[i][j] = a[i][j];
                } else if (j >= a[i].length) {
                    c[i][j] = b[i][j];
                } else {
                    c[i][j] = Math.max(a[i][j], b[i][j]);
                }
            }
        }
        return c;
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