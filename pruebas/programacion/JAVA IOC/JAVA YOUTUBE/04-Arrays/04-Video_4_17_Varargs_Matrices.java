class Video_4_17_Varargs_Matrices {

    // -------------------------------------------------------------
    // Constantes Unicode para bordes
    // -------------------------------------------------------------
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
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-17 JAVA: Varargs con matrices DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=ZbcMPoJcJQ8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=82";
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
          RESUMEN RAPIDO - VARARGS CON MATRICES (TEMA 4 - V17)
        ====================================================================

        --- ENUNCIADO ---
        Ampliar el metodo de matrices lado a lado para que acepte una
        CANTIDAD INDETERMINADA de matrices usando VARARGS.

        --- NUEVA FIRMA ---
        static void mostrarMatricesConBordes(int separacion, int[][]... matrices)
        static String crearStringMatricesConBordes(int separacion, int[][]... matrices)

        - separacion: espacios entre cada matriz
        - matrices: varargs (0, 1, 2, ... N matrices)

        --- PROCESO ---
        1. Por cada matriz, obtener String con crearStringMatrizConBordes().
        2. Dividir cada String en lineas con split("\\n").
        3. Guardar en String[][] lineasMatrices.
        4. Calcular cual matriz tiene MAS lineas (lineasMax).
        5. Crear String[] resultado con tamanio = lineasMax.
        6. Por cada fila i:
           - Inicializar anchoAcumulado = 0
           - Por cada matriz j:
             - Si existe linea en matriz j: anadir a resultado[i]
             - Calcular anchoMax de matriz j
             - Actualizar anchoAcumulado += anchoMax + separacion
             - Calcular espacios = anchoAcumulado - resultado[i].length()
             - Anadir espacios
           - Anadir \\n
        7. Devolver String concatenada.

        --- PUNTOS CLAVE ---
        - Se usa String[][] para almacenar las lineas de cada matriz.
        - El varargs (int[][]... matrices) va SIEMPRE al final.
        - La separacion es el primer parametro.
        - El ancho acumulado se va sumando por cada matriz procesada.
        - Los espacios se calculan como: anchoAcumulado - longActual

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. VARARGS CON MATRICES:
           - Sintaxis: int[][]... matrices
           - Es un array de matrices (int[][][] internamente).
           - Debe ser el ULTIMO parametro.

        2. ESTRUCTURA DE DATOS:
           - String[][] lineasMatrices = new String[matrices.length][];
           - Cada elemento es un String[] con las lineas de esa matriz.
           - int[] cantLineasMatrices = new int[matrices.length];

        3. CALCULO DE ESPACIOS:
           - Se acumula: anchoAcumulado += anchoMax + separacion
           - Se calcula: espacios = anchoAcumulado - textoMatrices[i].length()
           - Si la fila actual es la mas ancha, resto = 0, solo queda separacion.

        4. FILAS FALTANTES:
           - Si una matriz tiene menos filas, no se anade texto.
           - Pero SIGUE acumulando ancho (para mantener la alineacion).
           - Si no, las siguientes matrices se desalinearian.

        5. ERRORES TIPICOS:
           - No poner la separacion como primer parametro.
           - Olvidar que varargs debe ir al final.
           - No acumular el ancho cuando una fila no existe en la matriz.
           - Confundir indices i (fila) y j (matriz).
           - Olvidar inicializar textoMatrices[i] como "" antes de concatenar.

        6. TRUCOS RAPIDOS:
           - String[][] para almacenar multiples resultados de split.
           - Un bucle para convertir y contar lineas.
           - Otro bucle para montar cada fila.
           - Otro bucle interno para recorrer matrices en cada fila.

        ====================================================================
        """;
    // -------------------------------------------------------------
    // METODOS REUTILIZADOS (version resumida)
    // -------------------------------------------------------------
    static int digitos(int n) {
        if (n < 10) return 1;
        return 1 + digitos(n / 10);
    }
    static String obtenerBordeArray(int[] arr, int tipoBorde) {
        String b = ""; b += (tipoBorde == BORDE_SUP) ? ESQUINA_SUP_IZQ : ESQUINA_INF_IZQ;
        for (int i = 0; i < arr.length; i++) {
            int l = digitos(Math.abs(arr[i])) + 2; if (arr[i] < 0) l++;
            for (int j = 0; j < l; j++) b += LINEA_HORIZONTAL;
            if (i < arr.length - 1) b += (tipoBorde == BORDE_SUP) ? SEPARADOR_SUP : SEPARADOR_INF;
        }
        b += (tipoBorde == BORDE_SUP) ? ESQUINA_SUP_DER : ESQUINA_INF_DER; return b;
    }
    static String obtenerStringEnteros(int[] arr) {
        if (arr.length == 0) return "" + LINEA_VERTICAL;
        String r = "" + LINEA_VERTICAL + " ";
        for (int i = 0; i < arr.length; i++) r += arr[i] + " " + LINEA_VERTICAL + " ";
        return r;
    }
    static int[] posicionarSeparadores(int[] f) {
        int[] p = new int[f.length];
        for (int i = 0; i < f.length; i++) { p[i] = digitos(Math.abs(f[i])) + 2; if (f[i] < 0) p[i]++; }
        return p;
    }
    static int obtenerAnchoFila(int[] p) { int a = 1; for (int i = 0; i < p.length; i++) a += p[i] + 1; return a; }
    static char[] estabInf(char[] b, int[] p) { int c = 1; for (int i = 0; i < p.length; i++) { for (int j = 0; j < p[i]; j++) b[c++] = LINEA_HORIZONTAL; b[c++] = SEPARADOR_INF; } return b; }
    static char[] estabSup(char[] b, int[] p) {
        int c = 1;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i]; j++) { if (b[c] == 0) b[c] = LINEA_HORIZONTAL; c++; }
            if (b[c] == SEPARADOR_INF) b[c] = SEPARADOR_CRUZ; else if (b[c] == 0 || b[c] == LINEA_HORIZONTAL) b[c] = SEPARADOR_SUP; c++;
        } return b;
    }
    static char[] estabEsq(char[] b, int aA, int aI) {
        if (aA == 1 && aI == 1) { b = new char[2]; b[0] = SEPARADOR_IZQ; b[1] = SEPARADOR_DER; return b; }
        if (aA > 1 && aI == 1) { b[1] = SEPARADOR_SUP; b[b.length-1] = ESQUINA_INF_DER; return b; }
        if (aA == 1 && aI > 1) { b[1] = SEPARADOR_INF; b[b.length-1] = ESQUINA_SUP_DER; return b; }
        if (aA > aI) b[b.length-1] = ESQUINA_INF_DER; else if (aA < aI) b[b.length-1] = ESQUINA_SUP_DER; else b[b.length-1] = SEPARADOR_DER;
        return b;
    }
    static String obtenerBordeIntermedio(int[] fA, int[] fI) {
        int[] pI = posicionarSeparadores(fA), pS = posicionarSeparadores(fI);
        int aA = obtenerAnchoFila(pI), aI = obtenerAnchoFila(pS), aB = Math.max(aA, aI);
        char[] b = new char[aB]; b[0] = SEPARADOR_IZQ;
        b = estabInf(b, pI); b = estabSup(b, pS); b = estabEsq(b, aA, aI);
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
        return obtenerBordeArray(m[0], BORDE_SUP) + "\n" + obtenerParteCentralMatriz(m) + obtenerBordeArray(m[m.length-1], BORDE_INF);
    }
    static int obtenerAnchoMaximoLineas(String[] lineas) {
        int max = 0; for (String l : lineas) { if (l.length() > max) max = l.length(); } return max;
    }

    // -------------------------------------------------------------
    // NUEVO: Varargs de matrices
    // -------------------------------------------------------------
    static String crearStringMatricesConBordes(int separacion, int[][]... matrices) {
        String[][] lineasMatrices = new String[matrices.length][];
        int[] cantLineasMatrices = new int[matrices.length];
        int lineasMax = 0;

        for (int i = 0; i < matrices.length; i++) {
            lineasMatrices[i] = crearStringMatrizConBordes(matrices[i]).split("\n");
            cantLineasMatrices[i] = lineasMatrices[i].length;
            if (cantLineasMatrices[i] > lineasMax) lineasMax = cantLineasMatrices[i];
        }

        String[] textoMatrices = new String[lineasMax];
        for (int i = 0; i < lineasMax; i++) textoMatrices[i] = "";

        for (int i = 0; i < lineasMax; i++) {
            int anchoAcumulado = 0;
            for (int j = 0; j < matrices.length; j++) {
                if (i < cantLineasMatrices[j]) {
                    textoMatrices[i] += lineasMatrices[j][i];
                }
                int anchoMax = obtenerAnchoMaximoLineas(lineasMatrices[j]);
                anchoAcumulado += anchoMax + separacion;
                int espacios = anchoAcumulado - textoMatrices[i].length();
                for (int k = 0; k < espacios; k++) {
                    textoMatrices[i] += " ";
                }
            }
        }

        String resultado = "";
        for (String linea : textoMatrices) resultado += linea + "\n";
        return resultado;
    }

    static void mostrarMatricesConBordes(int separacion, int[][]... matrices) {
        System.out.println(crearStringMatricesConBordes(separacion, matrices));
        for (int i = 0; i < 100; i++) System.out.print(SEPARADOR_FILAS);
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

        int[][] nums1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] nums2 = {{1,2},{4,5,6,7},{8},{9,10},{11,12,13}};
        int[][] nums3 = {{1,2},{},{8,9},{10}};
        int[][] nums4 = {{14,9,18},{0,17},{14,10},{4,19,4}};

        separador("EJEMPLO 1: Una sola matriz");
        mostrarMatricesConBordes(5, nums1);

        separador("EJEMPLO 2: Dos matrices");
        mostrarMatricesConBordes(5, nums1, nums2);

        separador("EJEMPLO 3: Tres matrices");
        mostrarMatricesConBordes(5, nums1, nums2, nums3);

        separador("EJEMPLO 4: Cuatro matrices (como en la presentacion)");
        mostrarMatricesConBordes(5, nums1, nums2, nums3, nums4);

        separador("EJEMPLO 5: Sin matrices (no se imprime nada)");
        mostrarMatricesConBordes(5);

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 4)");
        System.out.println("============================================================");
    }

    public static void separador(String titulo) {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("  " + titulo);
        System.out.println("============================================================");
    }
}
