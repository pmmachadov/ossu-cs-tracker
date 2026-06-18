class Video_4_13_Ejercicio_Matrices_Bordes {

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
}    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-13 JAVA: Ejercicio Matrices con Bordes DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=JvqSCs2ZDW8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=78";
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
          RESUMEN RAPIDO - MATRICES CON BORDES UNICODE (TEMA 4 - V13)
        ====================================================================

        --- ENUNCIADO ---
        Ampliar el ejercicio de arrays con bordes para MATRICES (2D),
        incluyendo matrices regulares, irregulares y filas vacias.

        --- NUEVAS CONSTANTES UNICODE ---
        SEPARADOR_IZQ = '\\u2560'   (╠) - separador izquierdo entre filas
        SEPARADOR_DER = '\\u2563'   (╣) - separador derecho
        SEPARADOR_CRUZ = '\\u256C'  (╬) - cruz cuando coinciden sup e inf

        --- METODOS PRINCIPALES ---
        - crearStringArrayConBordes(int[] arr)     -> String
        - mostrarArrayConBordes(int[] arr)         -> void
        - crearStringMatrizConBordes(int[][] m)    -> String
        - mostrarMatrizConBordes(int[][] m)        -> void

        --- PUNTOS CLAVE ---
        1. Refactorizar: metodos ahora devuelven String en vez de imprimir.
        2. Borde superior: con obtenerBordeArray(fila, BORDE_SUP).
        3. Borde inferior: con obtenerBordeArray(ultimaFila, BORDE_INF).
        4. Parte central: recorrer filas con:
           - obtenerStringEnteros(fila) + barra n
           - Si no es ultima: obtenerBordeIntermedio(fila, fila+1) + barra n
        5. Borde intermedio mas complejo:
           - Posicionar separadores de ambas filas.
           - Calcular ancho maximo.
           - Crear char[] y poner SEPARADOR_IZQ al inicio.
           - Establecer separadores inferiores (lineas + SEP).
           - Establecer separadores superiores (cruz si coincide).
           - Establecer esquinas segun tamanos.
        6. Filas vacias: casos especiales en esquinas.

        --- METODOS DE APOYO ---
        - posicionarSeparadores(int[] fila) -> int[] posiciones
        - obtenerAnchoFila(int[] posSep)    -> int
        - establecerSeparadoresInf(char[], int[]) -> char[]
        - establecerSeparadoresSup(char[], int[]) -> char[]
        - establecerEsquinas(char[], int, int) -> char[]
        - digitos(int n) -> int (recursivo)

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. REFACTORIZACION A STRING:
           - Todos los metodos que antes hacian print ahora devuelven String.
           - Facilita componer matrices una al lado de otra.
           - Metodo mostrarX() llama a crearStringX() y hace print.

        2. BORDE INTERMEDIO:
           - Es la parte mas dificil del ejercicio.
           - Primero separadores inferiores (fila actual).
           - Luego separadores superiores (fila debajo).
           - Si coinciden -> SEPARADOR_CRUZ.
           - Esquinas: dependen de que fila es mas larga.

        3. POSICIONAR SEPARADORES:
           - Cada separador esta tras cada celda.
           - Tamaño celda = digitos(Math.abs(num)) + 2
           - Si negativo: +1 adicional por el signo.
           - El primer separador (izquierdo) no se cuenta.

        4. FILAS VACIAS:
           - Una fila vacia tiene ancho 1 (solo SEPARADOR_IZQ).
           - Tres casos: ambas vacias, solo arriba, solo abajo.
           - Cada caso tiene su logica de esquinas.

        5. ERRORES TIPICOS:
           - ArrayIndexOutOfBounds al acceder a char[] sin suficiente tamaño.
           - No considerar filas vacias en las esquinas.
           - Confundir SEPARADOR_SUP con SEPARADOR_INF.
           - Olvidar que el ultimo separador es la esquina o SEPARADOR_DER.
           - No inicializar char[] correctamente (caracter nulo).
           - No incrementar contador de posicion en cada paso.

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

        // Matriz regular
        separador("EJEMPLO 1: Matriz regular");
        int[][] nums1 = {{1,2,3},{4,5,6},{7,8,9}};
        mostrarMatrizConBordes(nums1);
        System.out.println();

        // Matriz irregular
        separador("EJEMPLO 2: Matriz irregular");
        int[][] nums2 = {{1,2},{4,5,6,7},{8},{9,10},{11,12,13}};
        mostrarMatrizConBordes(nums2);
        System.out.println();

        // Matriz con filas vacias
        separador("EJEMPLO 3: Matriz con filas vacias");
        int[][] nums3 = {{1,2},{},{8,9},{10}};
        mostrarMatrizConBordes(nums3);
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("============================================================");
    }
    static final int BORDE_SUP = 0;
    static final int BORDE_INF = 1;

    // -------------------------------------------------------------
    // digitos (recursivo)
    // -------------------------------------------------------------
    static int digitos(int n) {
        if (n < 10) return 1;
        return 1 + digitos(n / 10);
    }

    // -------------------------------------------------------------
    // obtenerBordeArray (generico sup/inf)
    // -------------------------------------------------------------
    static String obtenerBordeArray(int[] arr, int tipoBorde) {
        String borde = "";
        if (tipoBorde == BORDE_SUP) borde += ESQUINA_SUP_IZQ;
        else borde += ESQUINA_INF_IZQ;

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

    // -------------------------------------------------------------
    // obtenerStringEnteros
    // -------------------------------------------------------------
    static String obtenerStringEnteros(int[] arr) {
        if (arr.length == 0) return "" + LINEA_VERTICAL;
        String res = "" + LINEA_VERTICAL + " ";
        for (int i = 0; i < arr.length; i++) {
            res += arr[i] + " " + LINEA_VERTICAL + " ";
        }
        return res;
    }

    // -------------------------------------------------------------
    // crearStringArrayConBordes
    // -------------------------------------------------------------
    static String crearStringArrayConBordes(int[] arr) {
        if (arr.length == 0) return "";
        String res = "";
        res += obtenerBordeArray(arr, BORDE_SUP) + "\n";
        res += obtenerStringEnteros(arr) + "\n";
        res += obtenerBordeArray(arr, BORDE_INF);
        return res;
    }

    // -------------------------------------------------------------
    // mostrarArrayConBordes
    // -------------------------------------------------------------
    static void mostrarArrayConBordes(int[] arr) {
        System.out.println(crearStringArrayConBordes(arr));
    }

    // -------------------------------------------------------------
    // posicionarSeparadores
    // -------------------------------------------------------------
    static int[] posicionarSeparadores(int[] fila) {
        int[] pos = new int[fila.length];
        for (int i = 0; i < fila.length; i++) {
            pos[i] = digitos(Math.abs(fila[i])) + 2;
            if (fila[i] < 0) pos[i]++;
        }
        return pos;
    }
    // -------------------------------------------------------------
    // obtenerAnchoFila
    // -------------------------------------------------------------
    static int obtenerAnchoFila(int[] posSep) {
        int ancho = 1;
        for (int i = 0; i < posSep.length; i++) {
            ancho += posSep[i] + 1;
        }
        return ancho;
    }

    // -------------------------------------------------------------
    // establecerSeparadoresInferiores
    // -------------------------------------------------------------
    static char[] establecerSeparadoresInferiores(char[] borde, int[] posSep) {
        int cont = 1;
        for (int i = 0; i < posSep.length; i++) {
            for (int j = 0; j < posSep[i]; j++) {
                borde[cont++] = LINEA_HORIZONTAL;
            }
            borde[cont++] = SEPARADOR_INF;
        }
        return borde;
    }

    // -------------------------------------------------------------
    // establecerSeparadoresSuperiores
    // -------------------------------------------------------------
    static char[] establecerSeparadoresSuperiores(char[] borde, int[] posSep) {
        int cont = 1;
        for (int i = 0; i < posSep.length; i++) {
            for (int j = 0; j < posSep[i]; j++) {
                if (borde[cont] == 0) borde[cont] = LINEA_HORIZONTAL;
                cont++;
            }
            if (borde[cont] == SEPARADOR_INF) {
                borde[cont] = SEPARADOR_CRUZ;
            } else if (borde[cont] == 0 || borde[cont] == LINEA_HORIZONTAL) {
                borde[cont] = SEPARADOR_SUP;
            }
            cont++;
        }
        return borde;
    }

    // -------------------------------------------------------------
    // establecerEsquinas
    // -------------------------------------------------------------
    static char[] establecerEsquinas(char[] borde, int anchoAct, int anchoInf) {
        if (anchoAct == 1 && anchoInf == 1) {
            borde = new char[2];
            borde[0] = SEPARADOR_IZQ; borde[1] = SEPARADOR_DER;
            return borde;
        } else if (anchoAct > 1 && anchoInf == 1) {
            borde[1] = SEPARADOR_SUP;
            borde[borde.length - 1] = ESQUINA_INF_DER;
            return borde;
        } else if (anchoAct == 1 && anchoInf > 1) {
            borde[1] = SEPARADOR_INF;
            borde[borde.length - 1] = ESQUINA_SUP_DER;
            return borde;
        }
        if (anchoAct > anchoInf) {
            borde[borde.length - 1] = ESQUINA_INF_DER;
        } else if (anchoAct < anchoInf) {
            borde[borde.length - 1] = ESQUINA_SUP_DER;
        } else {
            borde[borde.length - 1] = SEPARADOR_DER;
        }
        return borde;
    }

    // -------------------------------------------------------------
    // obtenerBordeIntermedio
    // -------------------------------------------------------------
    static String obtenerBordeIntermedio(int[] filaAct, int[] filaInf) {
        int[] posInf = posicionarSeparadores(filaAct);
        int[] posSup = posicionarSeparadores(filaInf);
        int anchoAct = obtenerAnchoFila(posInf);
        int anchoInf = obtenerAnchoFila(posSup);
        int anchoBorde = (anchoAct > anchoInf) ? anchoAct : anchoInf;

        char[] borde = new char[anchoBorde];
        borde[0] = SEPARADOR_IZQ;
        borde = establecerSeparadoresInferiores(borde, posInf);
        borde = establecerSeparadoresSuperiores(borde, posSup);
        borde = establecerEsquinas(borde, anchoAct, anchoInf);

        String res = "";
        for (char c : borde) res += c;
        return res;
    }

    // -------------------------------------------------------------
    // obtenerParteCentralMatriz
    // -------------------------------------------------------------
    static String obtenerParteCentralMatriz(int[][] m) {
        String res = "";
        for (int i = 0; i < m.length; i++) {
            res += obtenerStringEnteros(m[i]) + "\n";
            if (i < m.length - 1) {
                res += obtenerBordeIntermedio(m[i], m[i+1]) + "\n";
            }
        }
        return res;
    }

    // -------------------------------------------------------------
    // crearStringMatrizConBordes
    // -------------------------------------------------------------
    static String crearStringMatrizConBordes(int[][] m) {
        if (m.length == 0) return "";
        String res = "";
        res += obtenerBordeArray(m[0], BORDE_SUP) + "\n";
        res += obtenerParteCentralMatriz(m);
        res += obtenerBordeArray(m[m.length-1], BORDE_INF);
        return res;
    }

    // -------------------------------------------------------------
    // mostrarMatrizConBordes
    // -------------------------------------------------------------
    static void mostrarMatrizConBordes(int[][] m) {
        System.out.println(crearStringMatrizConBordes(m));
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
