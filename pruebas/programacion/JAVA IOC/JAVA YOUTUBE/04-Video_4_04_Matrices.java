class Video_4_04_Matrices {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-04 JAVA: Matrices ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=iWLzt6g6b5o&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=69";
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
          RESUMEN RAPIDO - MATRICES (ARRAYS BIDIMENSIONALES) (TEMA 4 - V4)
        ====================================================================

        --- QUE ES UNA MATRIZ ---
        Array de 2 dimensiones (filas y columnas).
        Se puede ver como una tabla o como un array de arrays.
        - Primer indice  -> FILA
        - Segundo indice -> COLUMNA
        - Ambos indices empiezan en 0.
        - Sintaxis: tipo[][] identificador = new tipo[filas][columnas];

        --- DECLARACION E INICIALIZACION ---
        int[][] m = new int[5][4];   // 5 filas, 4 columnas (valores por defecto 0)
        char[][] letras;             // Solo declaracion (sin inicializar)
        int[][] precios = new int[5][6];    // 5 filas x 6 columnas
        double[][] notas = new double[10][10]; // 10x10
        String[][] datos = new String[10][5];  // 10 filas x 5 columnas

        --- INICIALIZACION CON VALORES (llaves anidadas) ---
        int[][] matriz = {
            {1, 2, 3, 4, 5},    // fila 0
            {6, 7, 8, 9, 10},   // fila 1
            {11, 12, 13, 14, 15} // fila 2
        };
        // Matriz de 3 filas x 5 columnas

        --- ACCEDER A ELEMENTOS ---
        matriz[fila][columna]
        matriz[0][0] -> primer elemento (fila 0, columna 0)
        matriz[2][4] -> ultimo elemento (fila 2, columna 4)
        matriz.length         -> numero de FILAS (3 en el ejemplo)
        matriz[0].length      -> numero de COLUMNAS de la fila 0 (5)
        matriz[fila].length   -> columnas de una fila concreta

        --- MATRICES REGULARES vs IRREGULARES ---
        Regular:  todas las filas tienen el mismo numero de columnas.
        Irregular: cada fila puede tener distinto numero de columnas.
        Ejemplo irregular: int[][] m = { {1,2}, {3,4,5,6}, {7} };

        --- RECORRER UNA MATRIZ (bucle for anidado) ---
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int col = 0; col < matriz[fila].length; col++) {
                System.out.print(matriz[fila][col] + " ");
            }
            System.out.println();  // salto de linea al acabar cada fila
        }

        Salida:
        1 2 3
        4 5 6
        7 8 9

        --- BUCLE EXTERNO vs INTERNO ---
        - Bucle externo (fila): recorre las filas. Da tantas vueltas como filas.
        - Bucle interno (col): recorre las columnas de la fila actual.
          Se crea y destruye por cada fila.
          Usa matriz[fila].length para saber cuantas columnas tiene ESA fila.

        --- PROPIEDAD LENGTH EN MATRICES ---
        matriz.length        -> numero de filas
        matriz[0].length     -> columnas de la fila 0
        matriz[1].length     -> columnas de la fila 1
        matriz[fila].length  -> columnas de la fila 'fila'

        --- ARRAYS DE 3 DIMENSIONES (mencion, poco usados) ---
        int[][][] ventas = new int[4][10][5];
        // 4 ciudades, 10 ventas cada una, 5 años por venta
        // Para recorrerlo: 3 bucles for anidados.

        --- CONCEPTOS CLAVE ---
        * Matriz = array bidimensional = array de arrays.
        * Primer indice = fila, segundo indice = columna.
        * Todo empieza en 0.
        * matriz.length = numero de filas.
        * matriz[fila].length = numero de columnas de esa fila.
        * Para recorrer: for anidado con filas y columnas.
        * Matriz irregular: filas con distinta longitud.
        * Se pueden tener arrays de 3+ dimensiones (poco comunes).

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. DECLARACION:
           - int[][] m = new int[filas][columnas];
           - NO confundir: primero filas, luego columnas.
           - Si solo declaras (int[][] m;) y luego usas -> NullPointerException.

        2. INICIALIZACION CON LLAVES:
           - int[][] m = { {1,2}, {3,4}, {5,6} };
           - Cada fila entre llaves, separadas por comas.
           - El tamaño se deduce automaticamente.

        3. ACCEDER A ELEMENTOS:
           - m[fila][columna]  -> siempre entre corchetes dobles.
           - m[0][0] = primer elemento.
           - m[m.length-1][m[0].length-1] = ultimo elemento.

        4. LENGTH:
           - m.length        -> FILAS (arrays internos)
           - m[0].length     -> COLUMNAS de la fila 0
           - ERROR TIPICO: usar m.length para las columnas (devuelve filas).

        5. RECORRER MATRIZ (patron fijo de examen):
              for (int i = 0; i < m.length; i++) {
                  for (int j = 0; j < m[i].length; j++) {
                      // m[i][j] es el elemento actual
                  }
              }
           - i para filas, j para columnas.
           - El bucle interno usa m[i].length (NO m.length).

        6. MATRICES IRREGULARES:
           - Cada fila puede tener distinto numero de columnas.
           - El mismo patron for anidado funciona porque usa m[i].length.
           - Ej: int[][] m = { {1}, {2,3}, {4,5,6} };

        7. ERRORES COMUNES:
           - ArrayIndexOutOfBoundsException: m[fila][col] con indice fuera.
           - Confundir filas y columnas al declarar o acceder.
           - Usar m.length en vez de m[i].length en el bucle interno.
           - Olvidar que los indices empiezan en 0.

        8. TRUCOS RAPIDOS:
           - Para saber cuantos elementos tiene una matriz: filas * columnas.
           - Para matrices regulares: m.length * m[0].length.
           - Para imprimir bonito: System.out.print() dentro, println() fuera.
           - La i del for externo normalmente se llama "fila" o "i".
           - La j del for interno normalmente se llama "col" o "j".

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
        // EJEMPLO 1: Matriz regular 3x3 con valores
        // ============================================================

        separador("EJEMPLO 1: Matriz regular 3x3");
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("  int[][] matriz = { {1,2,3}, {4,5,6}, {7,8,9} };");
        System.out.println("  Filas: " + matriz.length);
        System.out.println("  Columnas (fila 0): " + matriz[0].length);
        System.out.println("  Contenido:");
        for (int fila = 0; fila < matriz.length; fila++) {
            System.out.print("    ");
            for (int col = 0; col < matriz[fila].length; col++) {
                System.out.print(matriz[fila][col] + " ");
            }
            System.out.println();
        }
        System.out.println("  Primer elemento: matriz[0][0] = " + matriz[0][0]);
        System.out.println("  Ultimo elemento: matriz[2][2] = " + matriz[2][2]);
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Matriz irregular
        // ============================================================

        separador("EJEMPLO 2: Matriz irregular");
        int[][] irregular = {
            {1, 2},
            {3, 4, 5, 6},
            {7}
        };

        System.out.println("  int[][] irregular = { {1,2}, {3,4,5,6}, {7} };");
        System.out.println("  Filas: " + irregular.length);
        for (int i = 0; i < irregular.length; i++) {
            System.out.println("  Columnas fila " + i + ": " + irregular[i].length);
        }
        System.out.println("  Contenido:");
        for (int fila = 0; fila < irregular.length; fila++) {
            System.out.print("    ");
            for (int col = 0; col < irregular[fila].length; col++) {
                System.out.print(irregular[fila][col] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Acceso a elementos individuales
        // ============================================================

        separador("EJEMPLO 3: Acceso a elementos");
        int[][] m = new int[5][4];
        System.out.println("  int[][] m = new int[5][4];  // 5 filas x 4 columnas");
        System.out.println("  m.length = " + m.length + " (filas)");
        System.out.println("  m[0].length = " + m[0].length + " (columnas fila 0)");
        System.out.println("  m[4].length = " + m[4].length + " (columnas fila 4)");
        System.out.println();
        System.out.println("  Asignando valores:");
        m[0][0] = 10;
        m[0][3] = 40;
        m[4][0] = 50;
        m[4][3] = 80;
        System.out.println("  m[0][0] = " + m[0][0] + "  (primera fila, primera columna)");
        System.out.println("  m[0][3] = " + m[0][3] + "  (primera fila, ultima columna)");
        System.out.println("  m[4][0] = " + m[4][0] + "  (ultima fila, primera columna)");
        System.out.println("  m[4][3] = " + m[4][3] + "  (ultima fila, ultima columna)");
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Distintos tipos de matrices
        // ============================================================

        separador("EJEMPLO 4: Distintos tipos");
        char[][] letras = new char[2][3];
        double[][] notas = new double[2][2];
        String[][] datos = new String[2][2];

        System.out.println("  char[][]   letras = new char[2][3];   -> valores por defecto: '\\0'");
        System.out.println("  double[][] notas  = new double[2][2]; -> valores por defecto: 0.0");
        System.out.println("  String[][] datos  = new String[2][2]; -> valores por defecto: null");
        System.out.println();
        System.out.println("  char[0][0] = '" + letras[0][0] + "' (caracter nulo)");
        System.out.println("  double[0][0] = " + notas[0][0]);
        System.out.println("  String[0][0] = " + datos[0][0]);
        System.out.println();

        // ============================================================
        // COMPARACION DE RESULTADOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ej 1: Matriz regular 3x3         -> 3 filas, 3 columnas");
        System.out.println("Ej 2: Matriz irregular           -> filas con 2,4,1 columnas");
        System.out.println("Ej 3: Acceso individual          -> m[fila][col]");
        System.out.println("Ej 4: Tipos: char='\\0', double=0.0, String=null");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Ejemplo practico de matrices en VS Code");
        System.out.println("============================================================");
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
