class Video_4_09_Ejercicio_Matriz_Maxima {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-09 JAVA: Ejercicio matriz maxima ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=aX1-dcCMP7A&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=74";
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
          RESUMEN RAPIDO - EJERCICIO MATRIZ MAXIMA (TEMA 4 - V9)
        ====================================================================

        --- ENUNCIADO ---
        Recibir dos matrices y generar una tercera con el MAXIMO de cada posicion.
        Si las matrices NO son del mismo tamano -> mensaje de error.

        --- METODO 1: matricesIguales(int[][] a, int[][] b) ---
        static boolean matricesIguales(int[][] a, int[][] b) {
            if (a.length != b.length) return false;       // distintas filas
            for (int i = 0; i < a.length; i++) {
                if (a[i].length != b[i].length) return false;  // distinta columna
            }
            return true;
        }

        --- METODO 2: matrizMaxima(int[][] a, int[][] b) ---
        static int[][] matrizMaxima(int[][] a, int[][] b) {
            if (!matricesIguales(a, b)) return null;     // no se puede comparar

            int[][] c = new int[a.length][];
            for (int i = 0; i < a.length; i++) {
                c[i] = new int[a[i].length];             // mismo tamano que fila i
                for (int j = 0; j < a[i].length; j++) {
                    if (a[i][j] > b[i][j]) {
                        c[i][j] = a[i][j];               // maximo es de A
                    } else {
                        c[i][j] = b[i][j];               // maximo es de B (o igual)
                    }
                }
            }
            return c;
        }

        --- METODO 3: mostrarMatrizMaxima(int[][] a, int[][] b) ---
        static void mostrarMatrizMaxima(int[][] a, int[][] b) {
            int[][] c = matrizMaxima(a, b);
            if (c != null) {
                for (int[] fila : c) {
                    System.out.println(Arrays.toString(fila));
                }
            } else {
                System.out.println("Error: las matrices no son iguales");
            }
        }

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. COMPARAR TAMANOS:
           - Primero: a.length == b.length (mismas filas)
           - Segundo: a[i].length == b[i].length (mismos elementos por fila)
           - Si alguna condicion falla -> return false (o return null)

        2. CREAR MATRIZ RESULTANTE:
           - int[][] c = new int[a.length][];     // solo filas
           - c[i] = new int[a[i].length];         // columnas de cada fila
           - Asi funciona aunque las filas tengan distinto tamano.

        3. COMPARAR ELEMENTO A ELEMENTO:
           - if (a[i][j] > b[i][j]) -> c[i][j] = a[i][j]
           - else -> c[i][j] = b[i][j]
           - Si son iguales, da igual cual se guarde.

        4. CONTROL DE NULL:
           - Si las matrices no son iguales, devolver null.
           - Quien llame al metodo debe comprobar: if (c != null)
           - Si no controlas null -> NullPointerException.

        5. ERRORES TIPICOS:
           - No devolver la matriz c (olvidar el return c).
           - Crear c como new int[a.length][a[0].length] (falla si filas irregulares).
           - No comprobar todas las filas, solo la primera.
           - No proteger contra null al imprimir.
           - Confundir a.length (filas) con a[i].length (columnas).

        6. TRUCOS RAPIDOS:
           - import java.util.Arrays para Arrays.toString().
           - El metodo que devuelve matriz puede devolver null como "error".
           - Separar la logica: un metodo para comparar tamanos, otro para calcular.
           - For-each para imprimir, for clasico para modificar/crear.

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
        // EJEMPLO 1: Matrices del mismo tamano
        // ============================================================

        separador("EJEMPLO 1: Matrices del mismo tamano");
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8}};
        int[][] b = {{1, 5, 6}, {7, 1, 2}, {7, 8}};

        System.out.println("  Matriz A: " + java.util.Arrays.deepToString(a));
        System.out.println("  Matriz B: " + java.util.Arrays.deepToString(b));
        System.out.println("  Maximos:");
        mostrarMatrizMaxima(a, b);
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Matrices DISTINTAS (error)
        // ============================================================

        separador("EJEMPLO 2: Matrices DISTINTAS (error controlado)");
        int[][] c = {{1, 2}, {3, 4}};
        int[][] d = {{1, 2, 3}, {3, 4}};

        System.out.println("  Matriz C: " + java.util.Arrays.deepToString(c));
        System.out.println("  Matriz D: " + java.util.Arrays.deepToString(d));
        System.out.print("  Resultado: ");
        mostrarMatrizMaxima(c, d);
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Matrices iguales pero con valores variados
        // ============================================================

        separador("EJEMPLO 3: Otra comparacion");
        int[][] e = {{10, 20}, {30, 40, 50}, {60}};
        int[][] f = {{15, 5}, {25, 45, 55}, {1}};

        System.out.println("  Matriz E: " + java.util.Arrays.deepToString(e));
        System.out.println("  Matriz F: " + java.util.Arrays.deepToString(f));
        System.out.println("  Maximos:");
        mostrarMatrizMaxima(e, f);
        System.out.println();

        // ============================================================
        // COMPARACION DE RESULTADOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");
        System.out.println("Ej 1: Mismas filas y columnas    -> matriz con maximos");
        System.out.println("Ej 2: Distinto tamano            -> 'Error: las matrices no son iguales'");
        System.out.println("Ej 3: Otra comparacion           -> matriz con maximos");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (continuara con matrices desiguales)");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODO 1: Comprobar si dos matrices tienen el mismo tamano
    // -------------------------------------------------------------
    static boolean matricesIguales(int[][] a, int[][] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i].length != b[i].length) {
                return false;
            }
        }
        return true;
    }

    // -------------------------------------------------------------
    // METODO 2: Devolver matriz con los maximos (o null si no son iguales)
    // -------------------------------------------------------------
    static int[][] matrizMaxima(int[][] a, int[][] b) {
        if (!matricesIguales(a, b)) {
            return null;
        }

        int[][] c = new int[a.length][];
        for (int i = 0; i < a.length; i++) {
            c[i] = new int[a[i].length];
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > b[i][j]) {
                    c[i][j] = a[i][j];
                } else {
                    c[i][j] = b[i][j];
                }
            }
        }
        return c;
    }

    // -------------------------------------------------------------
    // METODO 3: Mostrar matriz maxima (con control de null)
    // -------------------------------------------------------------
    static void mostrarMatrizMaxima(int[][] a, int[][] b) {
        int[][] c = matrizMaxima(a, b);
        if (c != null) {
            for (int[] fila : c) {
                System.out.println("    " + java.util.Arrays.toString(fila));
            }
        } else {
            System.out.println("Error: las matrices no son iguales");
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
