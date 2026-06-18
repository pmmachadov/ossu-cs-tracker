class Video_4_14_Ejercicio_Matriz_Doble {
    static final char LINEA_VERTICAL = '\u2551';
    static final char LINEA_HORIZONTAL = '\u2550';
    static final char ESQUINA_SUP_IZQ = '\u2554';
    static final char ESQUINA_SUP_DER = '\u2557';
    static final char ESQUINA_INF_IZQ = '\u255A';
    static final char ESQUINA_INF_DER = '\u255D';
    static final char SEPARADOR_SUP = '\u2566';
    static final char SEPARADOR_INF = '\u2569';
    static final char SEPARADOR_IZQ = '\u2560';
    static final char SEPARADOR_DER = '\u2563';
    static final char SEPARADOR_CRUZ = '\u256C';
    static final char SEPARADOR_FILAS = '\u25A1';

    static final int BORDE_SUP = 0;
    static final int BORDE_INF = 1;

    // -------------------------------------------------------------
    // Datos del video
    // -------------------------------------------------------------
    public static final String TITULO = "4-14 JAVA: Ejercicio Matriz doble DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=EAu8ZQDIa-8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=79";
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
          RESUMEN RAPIDO - MATRIZ DOBLE CON BORDES (TEMA 4 - V14)
        ====================================================================

        --- ENUNCIADO ---
          Mostrar DOS matrices una al lado de la otra, separadas por
          una cantidad de espacios dada, usando los metodos de bordes
          Unicode del video anterior.

        --- METODO NUEVO ---
          static void mostrarMatricesConBordes(int[][] a, int[][] b, int separacion)
          static String crearStringMatricesConBordes(int[][] a, int[][] b, int separacion)

        --- PROCESO ---
          1. Obtener String de cada matriz con crearStringMatrizConBordes().
          2. Dividir cada String en lineas con split("\\n").
          3. Crear array de String del tamano maximo de ambas.
          4. Por cada linea:
             - Anadir linea de A (si existe)
             - Anadir espacios de relleno (anchoMaxA - longLineaA + separacion)
             - Anadir linea de B (si existe)
          5. Unir todas las lineas con \\n.

        --- METODO AUXILIAR NUEVO ---
          static int obtenerAnchoMaximoLineas(String[] lineas)
          - Recorre el array y devuelve la longitud de la String mas larga.

        --- PUNTOS CLAVE ---
          - Las matrices pueden tener DISTINTA cantidad de filas.
          - Las filas pueden tener DISTINTA longitud (matrices irregulares).
          - El relleno de espacios se calcula por fila:
            espacios = anchoMaximoLineasDeA - lineaActual.length() + separacion
          - Si una matriz tiene menos filas, se deja espacio vacio.

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. REUTILIZACION:
           - Se reutiliza crearStringMatrizConBordes() del video anterior.
           - No se modifican los metodos de bordes existentes.

        2. SPLIT:
           - Las String se dividen en lineas con split("\\n").
           - Cada elemento del array es una linea de la matriz con bordes.

        3. ALINEACION:
           - Para que queden alineadas, se calcula el ancho maximo de A.
           - Por cada fila: anchoMaxA - linea.length() + espacios de separacion.

        4. NULL INICIAL:
           - Al crear String[] hay que inicializar cada elemento con "".
           - Si no, al concatenar da NullPointerException.

        5. ERRORES TIPICOS:
           - No comprobar si la linea existe en A antes de acceder.
           - No comprobar si la linea existe en B antes de acceder.
           - Olvidar inicializar el array de String con valores vacios.
           - Confundir lineas de A con lineas de B en la concatenacion.
           - No calcular correctamente los espacios de relleno.

        6. TRUCOS RAPIDOS:
           - Ternaria para tamano maximo: lineasA.length > lineasB.length ? lineasA : lineasB
           - Concatenar con += para ir anadiendo lineas.
           - Inicializar cada fila con "" antes de concatenar.
           - Un for-each para obtener el ancho maximo de las lineas.

        ====================================================================
        """;

    // -------------------------------------------------------------
    // METODOS REUTILIZADOS (del video anterior, resumidos)
    // -------------------------------------------------------------
    static int digitos(int n) {
        if (n < 10) return 1;
        return 1 + digitos(n / 10);
    }

    static String obtenerBordeArray(int[] arr, int tipoBorde) {
        String borde = "";
        borde += (tipoBorde == BORDE_SUP) ? ESQUINA_SUP_IZQ : ESQUINA_INF_IZQ;
        for (int i = 0; i < arr.length; i++) {
            int lineas = digitos(Math.abs(arr[i])) + 2;
            if (arr[i] < 0) lineas++;
            for (int j = 0; j < lineas; j++) borde += LINEA_HORIZONTAL;
            if (i < arr.length - 1) {
                borde += (tipoBorde == BORDE_SUP) ? SEPARADOR_SUP : SEPARADOR_INF;
            }
        }
        borde += (tipoBorde == BORDE_SUP) ? ESQUINA_SUP_DER : ESQUINA_INF_DER;
        return borde;
    }

    static String obtenerStringEnteros(int[] arr) {
        if (arr.length == 0) return "" + LINEA_VERTICAL;
        String res = "" + LINEA_VERTICAL + " ";
        for (int i = 0; i < arr.length; i++) {
            res += arr[i] + " " + LINEA_VERTICAL + " ";
        }
        return res;
    }

    static int[] posicionarSeparadores(int[] fila) {
        int[] pos = new int[fila.length];
        for (int i = 0; i < fila.length; i++) {
            pos[i] = digitos(Math.abs(fila[i])) + 2;
            if (fila[i] < 0) pos[i]++;
        }
        return pos;
    }

    static int obtenerAnchoFila(int[] posSep) {
        int ancho = 1;
        for (int i = 0; i < posSep.length; i++) ancho += posSep[i] + 1;
        return ancho;
    }

    static char[] establecerSeparadoresInferiores(char[] b, int[] posSep) {
        int c = 1;
        for (int i = 0; i < posSep.length; i++) {
            for (int j = 0; j < posSep[i]; j++) b[c++] = LINEA_HORIZONTAL;
            b[c++] = SEPARADOR_INF;
        }
        return b;
    }

    static char[] establecerSeparadoresSuperiores(char[] b, int[] posSep) {
        int c = 1;
        for (int i = 0; i < posSep.length; i++) {
            for (int j = 0; j < posSep[i]; j++) {
                if (b[c] == 0) b[c] = LINEA_HORIZONTAL; c++;
            }
            if (b[c] == SEPARADOR_INF) b[c] = SEPARADOR_CRUZ;
            else if (b[c] == 0 || b[c] == LINEA_HORIZONTAL) b[c] = SEPARADOR_SUP;
            c++;
        }
        return b;
    }

    static char[] establecerEsquinas(char[] b, int aAct, int aInf) {
        if (aAct == 1 && aInf == 1) { b = new char[2]; b[0] = SEPARADOR_IZQ; b[1] = SEPARADOR_DER; return b; }
        if (aAct > 1 && aInf == 1) { b[1] = SEPARADOR_SUP; b[b.length-1] = ESQUINA_INF_DER; return b; }
        if (aAct == 1 && aInf > 1) { b[1] = SEPARADOR_INF; b[b.length-1] = ESQUINA_SUP_DER; return b; }
        if (aAct > aInf) b[b.length-1] = ESQUINA_INF_DER;
        else if (aAct < aInf) b[b.length-1] = ESQUINA_SUP_DER;
        else b[b.length-1] = SEPARADOR_DER;
        return b;
    }

    static String obtenerBordeIntermedio(int[] fAct, int[] fInf) {
        int[] pI = posicionarSeparadores(fAct), pS = posicionarSeparadores(fInf);
        int aA = obtenerAnchoFila(pI), aI = obtenerAnchoFila(pS), aB = Math.max(aA, aI);
        char[] b = new char[aB]; b[0] = SEPARADOR_IZQ;
        b = establecerSeparadoresInferiores(b, pI);
        b = establecerSeparadoresSuperiores(b, pS);
        b = establecerEsquinas(b, aA, aI);
        String r = ""; for (char ch : b) r += ch; return r;
    }

    static String obtenerParteCentralMatriz(int[][] m) {
        String r = "";
        for (int i = 0; i < m.length; i++) {
            r += obtenerStringEnteros(m[i]) + "\n";
            if (i < m.length - 1) r += obtenerBordeIntermedio(m[i], m[i+1]) + "\n";
        }
        return r;
    }

    static String crearStringMatrizConBordes(int[][] m) {
        if (m.length == 0) return "";
        return obtenerBordeArray(m[0], BORDE_SUP) + "\n"
             + obtenerParteCentralMatriz(m)
             + obtenerBordeArray(m[m.length-1], BORDE_INF);
    }

    static void mostrarMatrizConBordes(int[][] m) {
        System.out.println(crearStringMatrizConBordes(m));
    }
    // -------------------------------------------------------------
    // NUEVOS METODOS PARA ESTE VIDEO
    // -------------------------------------------------------------

    // Obtener ancho maximo de un array de lineas
    static int obtenerAnchoMaximoLineas(String[] lineas) {
        int max = 0;
        for (String linea : lineas) {
            if (linea.length() > max) max = linea.length();
        }
        return max;
    }

    // Crear String con dos matrices una al lado de otra
    static String crearStringMatricesConBordes(int[][] a, int[][] b, int separacion) {
        // Obtener lineas de cada matriz
        String[] lineasA = crearStringMatrizConBordes(a).split("\n");
        String[] lineasB = crearStringMatrizConBordes(b).split("\n");

        // Tamano maximo entre ambas
        int tamano = Math.max(lineasA.length, lineasB.length);
        String[] textoMatrices = new String[tamano];

        // Ancho maximo de las lineas de A
        int anchoMaxA = obtenerAnchoMaximoLineas(lineasA);

        // Recorrer y combinar
        for (int i = 0; i < tamano; i++) {
            textoMatrices[i] = "";

            // Anadir linea de A si existe
            if (i < lineasA.length) {
                textoMatrices[i] += lineasA[i];
            }

            // Calcular espacios de relleno
            int espacios = anchoMaxA - textoMatrices[i].length() + separacion;

            // Anadir espacios
            for (int j = 0; j < espacios; j++) {
                textoMatrices[i] += " ";
            }

            // Anadir linea de B si existe
            if (i < lineasB.length) {
                textoMatrices[i] += lineasB[i];
            }
        }

        // Unir todo
        String resultado = "";
        for (String linea : textoMatrices) {
            resultado += linea + "\n";
        }
        return resultado;
    }

    // Mostrar dos matrices una al lado de otra
    static void mostrarMatricesConBordes(int[][] a, int[][] b, int separacion) {
        System.out.println(crearStringMatricesConBordes(a, b, separacion));

        // Linea separadora entre grupos de matrices
        for (int i = 0; i < 100; i++) {
            System.out.print(SEPARADOR_FILAS);
        }
        System.out.println();
    }

    // -------------------------------------------------------------
    // METODO PRINCIPAL
    // -------------------------------------------------------------
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();

        // Matrices de prueba
        int[][] nums1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] nums2 = {{1,2},{4,5,6,7},{8},{9,10},{11,12,13}};
        int[][] nums3 = {{1,2},{},{8,9},{10}};

        separador("EJEMPLO 1: nums1 y nums2 lado a lado (sep=5)");
        mostrarMatricesConBordes(nums1, nums2, 5);

        separador("EJEMPLO 2: nums2 y nums3 lado a lado (sep=3)");
        mostrarMatricesConBordes(nums2, nums3, 3);

        separador("EJEMPLO 3: nums1 y nums3 (sep=10)");
        mostrarMatricesConBordes(nums1, nums3, 10);

        separador("EJEMPLO 4: nums2 y nums1 (sep=5)");
        mostrarMatricesConBordes(nums2, nums1, 5);

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // separador
    // -------------------------------------------------------------
    public static void separador(String titulo) {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("  " + titulo);
        System.out.println("============================================================");
    }
}
