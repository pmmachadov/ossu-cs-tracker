class Video_4_05_Recorrer_Matrices {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-05 JAVA: Recorrer Matrices ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=kU1chyIQU7o&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=70";
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
          RESUMEN RAPIDO - RECORRER MATRICES (TEMA 4 - V5)
        ====================================================================

        --- ESTRUCTURA BASICA PARA RECORRER UNA MATRIZ ---
        int[][] matriz = {{1, 4, 5}, {6, 7, 2}, {8, 3, 8}};

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int col = 0; col < matriz[fila].length; col++) {
                System.out.print(matriz[fila][col] + " ");
            }
            System.out.println();  // salto de linea tras cada fila
        }

        --- BUCLE EXTERNO (filas) ---
        - Inicializa fila = 0
        - Condicion: fila < matriz.length -> numero de filas
        - Incremento: fila++
        - Da tantas vueltas como filas tenga la matriz

        --- BUCLE INTERNO (columnas) ---
        - Inicializa col = 0
        - Condicion: col < matriz[fila].length -> longitud de la fila ACTUAL
        - Incremento: col++
        - Da tantas vueltas como elementos tenga la fila actual

        --- ACCESO A CADA ELEMENTO ---
        matriz[fila][col]  -> primer indice = fila, segundo indice = columna

        --- CLAVES IMPORTANTES ---
        * matriz.length        -> numero de filas
        * matriz[fila].length  -> numero de columnas de la fila 'fila'
        * La condicion del bucle interno usa matriz[fila].length
          para funcionar con matrices IRREGULARES (cada fila con distinto tamaño).
        * Si usas un numero fijo (ej: 3) y la matriz es irregular -> error.

        --- ASIGNAR VALORES ---
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int col = 0; col < matriz[fila].length; col++) {
                matriz[fila][col] = fila + col;  // ejemplo
            }
        }

        --- EJEMPLOS DE ASIGNACION ---
        matriz[fila][col] = fila;         // toda la fila al mismo valor
        matriz[fila][col] = col;          // progresion 0..n-1 por fila
        matriz[fila][col] = fila + col;   // suma de indices
        matriz[fila][col] = (fila + col) % 10;  // un solo digito (modulo)

        --- MATRIZ REGULAR vs IRREGULAR ---
        - Regular: todas las filas tienen la misma longitud.
          int[][] regular = new int[4][10];  // 4 filas, 10 columnas cada una
        - Irregular: cada fila puede tener distinta longitud.
          int[][] irregular = {{1,2}, {3,4,5}, {6}};
        - El codigo con matriz[fila].length funciona para AMBAS.

        --- CONSEJOS PARA EL EXAMEN ---

        1. BUCLE DOBLE:
           - Externo: filas (matriz.length)
           - Interno: columnas de la fila actual (matriz[fila].length)
           - Si usas un numero fijo en el interno y la matriz es irregular -> ERROR.

        2. ASIGNAR VALORES:
           - Usa el mismo bucle doble pero con asignacion en vez de print.
           - No olvides que primero debes crear la matriz con new int[filas][cols].

        3. MATRIZ SIN INICIALIZAR (new int[f][c]):
           - enteros -> 0
           - doubles -> 0.0
           - boolean -> false
           - String/objetos -> null

        4. ERRORES TIPICOS:
           - ArrayIndexOutOfBoundsException: si te pasas en fila o columna.
           - Confundir filas con columnas: primero fila, luego columna.
           - Poner matriz.length en el bucle interno (eso da filas, no columnas).
           - Olvidar que length es atributo, no metodo (sin parentesis).

        5. TRUCOS RAPIDOS:
           - Para imprimir matriz con formato tabla:
             for (int[] fila : matriz) {
                 for (int valor : fila) {
                     System.out.print(valor + " ");
                 }
                 System.out.println();
             }
           - Si la matriz es grande, usa %3d (printf) para alinear columnas.
           - Para recorrer en orden inverso: for (int i = m.length-1; i >= 0; i--)

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
        // EJEMPLO 1: Recorrer matriz con valores literales
        // ============================================================

        separador("EJEMPLO 1: Recorrer matriz 3x3 con valores literales");
        int[][] matriz = {{1, 4, 5}, {6, 7, 2}, {8, 3, 8}};

        System.out.println("  int[][] matriz = {{1, 4, 5}, {6, 7, 2}, {8, 3, 8}};");
        System.out.println("  matriz.length = " + matriz.length + " filas");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("  Fila " + i + " (" + matriz[i].length + " cols): ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Matriz irregular
        // ============================================================

        separador("EJEMPLO 2: Matriz IRREGULAR");
        int[][] irregular = {{1, 2}, {3, 4, 5}, {6}};
        System.out.println("  int[][] irregular = {{1, 2}, {3, 4, 5}, {6}};");
        for (int i = 0; i < irregular.length; i++) {
            System.out.print("  Fila " + i + " (" + irregular[i].length + " cols): ");
            for (int j = 0; j < irregular[i].length; j++) {
                System.out.print(irregular[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Crear matriz con new int[][] y asignar valores
        // ============================================================

        separador("EJEMPLO 3: Matriz 4x10 - Asignar valores con bucle doble");
        int[][] matriz2 = new int[4][10];

        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                matriz2[i][j] = (i + j) % 10;  // diagonal con modulo 10
            }
        }

        for (int i = 0; i < matriz2.length; i++) {
            System.out.print("  Fila " + i + ": ");
            for (int j = 0; j < matriz2[i].length; j++) {
                System.out.print(matriz2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Distintas formas de asignar valores
        // ============================================================

        separador("EJEMPLO 4: Distintas asignaciones");

        int[][] demo = new int[4][5];

        // Asignar: matriz[fila][col] = fila
        for (int i = 0; i < demo.length; i++) {
            for (int j = 0; j < demo[i].length; j++) {
                demo[i][j] = i;
            }
        }
        System.out.println("  matriz[f][c] = fila:");
        mostrarMatriz(demo);

        // Asignar: matriz[fila][col] = col
        for (int i = 0; i < demo.length; i++) {
            for (int j = 0; j < demo[i].length; j++) {
                demo[i][j] = j;
            }
        }
        System.out.println("  matriz[f][c] = columna:");
        mostrarMatriz(demo);

        // Asignar: matriz[fila][col] = fila + col
        for (int i = 0; i < demo.length; i++) {
            for (int j = 0; j < demo[i].length; j++) {
                demo[i][j] = i + j;
            }
        }
        System.out.println("  matriz[f][c] = fila + columna:");
        mostrarMatriz(demo);

        // ============================================================
        // EJEMPLO 5: For-each para recorrer matriz
        // ============================================================

        separador("EJEMPLO 5: For-each (for mejorado)");
        System.out.println("  for (int[] fila : matriz) {");
        System.out.println("      for (int valor : fila) {");
        System.out.println("          System.out.print(valor + \" \");");
        System.out.println("      }");
        System.out.println("  }");
        System.out.println();
        System.out.println("  Matriz {{1,4,5},{6,7,2},{8,3,8}} con for-each:");
        for (int[] fila : matriz) {
            System.out.print("  ");
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Matrices irregulares");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODO AUXILIAR: mostrarMatriz
    // -------------------------------------------------------------
    static void mostrarMatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.print("  ");
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
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
