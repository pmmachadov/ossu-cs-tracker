class Video_4_22_Generador_Matrices {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-22 JAVA: Generadores de matrices DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=CPXwJ0Top90&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=87";
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
          RESUMEN RAPIDO - GENERADORES DE MATRICES (TEMA 4 - V22)
        ====================================================================

        --- QUE HACEN ---
        Crean matrices aleatorias (cuadradas, regulares o irregulares)
        para poder hacer comprobaciones rapidas en ejercicios de matrices.

        --- METODO PRINCIPAL (matriz irregular) ---
        static int[][] generarMatriz(int anchoMin, int anchoMax,
                                      int altoMin, int altoMax, int numMax)
        
        - anchoMin: minimo de columnas por fila (0 = puede haber filas vacias)
        - anchoMax: maximo de columnas por fila
        - altoMin:  minimo de filas (0 = puede no tener filas)
        - altoMax:  maximo de filas
        - numMax:   valor maximo de cada elemento (entre 0 y numMax inclusive)

        --- SANITIZACION ---
        - Si hay negativos -> se convierten a 0
        - Si min > max -> se igualan (min = max)

        --- CLAVE DEL nextInt ---
        r.nextInt(min, max + 1)  -> genera entre min y max INCLUSIVE
        r.nextInt(numMax + 1)    -> genera entre 0 y numMax INCLUSIVE

        --- CODIGO ---
        import java.util.Random;
        
        static int[][] generarMatriz(int anchoMin, int anchoMax,
                                      int altoMin, int altoMax, int numMax) {
            if (anchoMin < 0) anchoMin = 0;
            if (anchoMax < 0) anchoMax = 0;
            if (altoMin < 0) altoMin = 0;
            if (altoMax < 0) altoMax = 0;
            if (anchoMin > anchoMax) anchoMin = anchoMax;
            if (altoMin > altoMax) altoMin = altoMax;

            Random r = new Random();
            int[][] matriz = new int[r.nextInt(altoMin, altoMax + 1)][];
            for (int i = 0; i < matriz.length; i++) {
                int col = r.nextInt(anchoMin, anchoMax + 1);
                matriz[i] = new int[col];
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz[i][j] = r.nextInt(numMax + 1);
                }
            }
            return matriz;
        }

        --- SOBRECARGA 1: matriz CUADRADA (Ejercicio 1) ---
        static int[][] generarMatriz(int lado, int numMax) {
            return generarMatriz(lado, lado, lado, lado, numMax);
        }

        --- SOBRECARGA 2: matriz REGULAR (ancho x alto) ---
        static int[][] generarMatriz(int ancho, int alto, int numMax) {
            return generarMatriz(ancho, ancho, alto, alto, numMax);
        }

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. nextInt NO incluye el limite superior:
           - r.nextInt(max) genera entre 0 y max-1
           - Para incluir el max: r.nextInt(max + 1)
           - Para incluir min y max: r.nextInt(min, max + 1)

        2. Matriz irregular = new int[filas][] + cada fila con su new int[columnas]

        3. La matriz cuadrada (Ejercicio 1) es un CASO PARTICULAR de la irregular:
           - anchoMin = anchoMax = altoMin = altoMax = lado
           - Se resuelve con sobrecarga (1 linea de codigo)

        4. SANITIZACION siempre primero:
           - Negativos a 0 para evitar excepcion NegativeArraySizeException
           - Si min > max se igualan para evitar excepcion IllegalArgumentException

        ====================================================================
        """;

    // -------------------------------------------------------------
    // METODO PRINCIPAL: generador de matriz IRREGULAR
    // -------------------------------------------------------------
    static int[][] generarMatriz(int anchoMin, int anchoMax, int altoMin, int altoMax, int numMax) {

        // Sanitizar negativos -> 0
        if (anchoMin < 0) anchoMin = 0;
        if (anchoMax < 0) anchoMax = 0;
        if (altoMin < 0) altoMin = 0;
        if (altoMax < 0) altoMax = 0;

        // Si min > max, igualarlos
        if (anchoMin > anchoMax) anchoMin = anchoMax;
        if (altoMin > altoMax) altoMin = altoMax;

        Random r = new Random();

        // Crear matriz con numero aleatorio de filas
        int[][] matriz = new int[r.nextInt(altoMin, altoMax + 1)][];

        // Por cada fila: crear sus columnas y rellenar con aleatorios
        for (int i = 0; i < matriz.length; i++) {
            int col = r.nextInt(anchoMin, anchoMax + 1);
            matriz[i] = new int[col];
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = r.nextInt(numMax + 1);
            }
        }

        return matriz;
    }

    // -------------------------------------------------------------
    // SOBRECARGA 1: matriz CUADRADA (Ejercicio 1)
    // -------------------------------------------------------------
    static int[][] generarMatriz(int lado, int numMax) {
        return generarMatriz(lado, lado, lado, lado, numMax);
    }

    // -------------------------------------------------------------
    // SOBRECARGA 2: matriz REGULAR (ancho x alto)
    // -------------------------------------------------------------
    static int[][] generarMatriz(int ancho, int alto, int numMax) {
        return generarMatriz(ancho, ancho, alto, alto, numMax);
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
        // EJEMPLO 1: Matriz irregular
        // ============================================================
        separador("EJEMPLO 1: Matriz irregular (anchoMin=0, anchoMax=5, altoMin=0, altoMax=5, numMax=9)");
        int[][] nums = generarMatriz(0, 5, 0, 5, 9);
        System.out.println("  " + nums.length + " filas generadas:");
        mostrarMatriz(nums);
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Matriz cuadrada (Ejercicio 1)
        // ============================================================
        separador("EJEMPLO 2: Matriz cuadrada 5x5 (numMax=9)");
        int[][] cuadrada = generarMatriz(5, 9);
        System.out.println("  " + cuadrada.length + " filas x " + cuadrada[0].length + " columnas:");
        mostrarMatriz(cuadrada);
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Matriz regular
        // ============================================================
        separador("EJEMPLO 3: Matriz regular 10x3 (numMax=20)");
        int[][] regular = generarMatriz(10, 3, 20);
        System.out.println("  " + regular.length + " filas x " + regular[0].length + " columnas:");
        mostrarMatriz(regular);
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Sanitizacion (negativos)
        // ============================================================
        separador("EJEMPLO 4: Sanitizacion - anchoMin=-1, anchoMax=-5 (se convierten a 0)");
        int[][] negativos = generarMatriz(-1, -5, 1, 3, 9);
        System.out.println("  " + negativos.length + " filas generadas (cada fila debe tener 0 columnas):");
        mostrarMatriz(negativos);
        System.out.println();

        // ============================================================
        // EJEMPLO 5: Minimo mayor que maximo
        // ============================================================
        separador("EJEMPLO 5: Correccion - anchoMin=8, anchoMax=3 (se igualan a 3)");
        int[][] invertido = generarMatriz(8, 3, 1, 2, 9);
        System.out.println("  " + invertido.length + " filas, cada fila con 3 columnas:");
        mostrarMatriz(invertido);
        System.out.println();

        // ============================================================
        // EJEMPLO 6: Siempre misma cantidad (min = max)
        // ============================================================
        separador("EJEMPLO 6: anchoMin=anchoMax=4, altoMin=altoMax=2 -> 2x4 siempre");
        int[][] fija = generarMatriz(4, 4, 2, 2, 100);
        System.out.println("  " + fija.length + " filas x " + fija[0].length + " columnas (valores 0-100):");
        mostrarMatriz(fija);
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 4 - V22: GENERADORES DE MATRICES)");
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
