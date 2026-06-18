class Video_4_12_Ejercicio_Arrays_Bordes {

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

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-12 JAVA: Ejercicio Arrays con Bordes DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=3b20yV6geXc&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=77";
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
          RESUMEN RAPIDO - ARRAYS CON BORDES UNICODE (TEMA 4 - V12)
        ====================================================================

        --- ENUNCIADO ---
        Imprimir el contenido de un array de enteros dentro de un rectangulo
        con caracteres Unicode, donde cada entero tiene su propia CELDA.
        - Tamano de cada celda = digitos del numero + 2 (espacios izq y der).
        - Celdas separadas por caracteres separadores Unicode.
        - Soportar numeros negativos (contar el signo - como un digito).

        --- CONSTANTES UNICODE (Box Drawing) ---
        ESQUINA_SUP_IZQ = '\u2554'   (esquina sup.izq.)
        ESQUINA_SUP_DER = '\u2557'   (esquina sup.der.)
        ESQUINA_INF_IZQ = '\u255A'   (esquina inf.izq.)
        ESQUINA_INF_DER = '\u255D'   (esquina inf.der.)
        LINEA_HORIZONTAL = '\u2550'  (linea horizontal)
        LINEA_VERTICAL = '\u2551'    (linea vertical)
        SEPARADOR_SUP = '\u2566'     (separador superior entre celdas)
        SEPARADOR_INF = '\u2569'     (separador inferior entre celdas)
        SEPARADOR_IZQ = '\u2560'     (separador izquierdo)
        SEPARADOR_DER = '\u2563'     (separador derecho)

        --- METODO: digitos(int n) [RECURSIVO] ---
        static int digitos(int n) {
            if (n < 10) return 1;
            return 1 + digitos(n / 10);
        }
        - Para negativos: Math.abs(n) antes de llamar.

        --- ESTRUCTURA DEL BORDE SUPERIOR ---
        ESQUINA_SUP_IZQ + (por cada num: HORIZONTAL*(digitos+2) + SEPARADOR_SUP) + ESQUINA_SUP_DER
        - El SEPARADOR_SUP se pone SOLO entre celdas (no al final).

        --- ESTRUCTURA DE LA FILA CENTRAL ---
        LINEA_VERTICAL + espacio + num + espacio + LINEA_VERTICAL + espacio + ...

        --- METODO PRINCIPAL: mostrarArrayConBordes(int[] nums) ---
        1. imprimirBordeSuperiorArray(nums)
        2. imprimirEnterosArray(nums)
        3. imprimirBordeInferiorArray(nums)

        --- METODOS AUXILIARES ---
        - imprimirBordeArray(int[] arr, int tipoBorde)  -> reutiliza logica
        - imprimirBordeSuperiorArray(int[] arr)  -> llama a imprimirBordeArray con SUP
        - imprimirBordeInferiorArray(int[] arr)  -> llama a imprimirBordeArray con INF
        - imprimirEnterosArray(int[] nums)       -> imprime los numeros con bordes verticales

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. DIGITOS DE UN NUMERO:
           - Version RECURSIVA: if (n < 10) return 1; else return 1 + digitos(n/10);
           - Para negativos: Math.abs(n) para contar digitos, +1 para el signo.
           - TRUCO: String.valueOf(Math.abs(n)).length()  (forma mas facil).

        2. CALCULO DE CELDA:
           - Ancho de celda = digitos(num) + 2
           - Si es negativo: ancho = digitos(Math.abs(num)) + 3 (digitos + signo + 2 espacios)

        3. SEPARADORES:
           - SEPARADOR_SUP se pone entre celdas en el borde superior.
           - SEPARADOR_INF se pone entre celdas en el borde inferior.
           - NO se pone separador tras el ultimo numero (ahi va la esquina).

        4. ESTRUCTURA DE CADA FILA:
           - Borde superior: esquina + [lineas + separador] x N-1 + lineas + esquina
           - Fila central:   lineaVertical + espacio + num + espacio + lineaVertical + ...
           - Borde inferior: igual que superior pero con las esquinas inferiores.

        5. ERRORES TIPICOS:
           - No considerar numeros negativos (el signo - ocupa espacio).
           - Poner separador tras el ultimo numero (sobra).
           - Confundir SEPARADOR_SUP con SEPARADOR_INF.
           - Olvidar los espacios antes y despues de cada numero.
           - No alinear bien los bordes superior/inferior con la fila central.

        6. TRUCOS RAPIDOS:
           - Reutilizar el metodo imprimirBordeArray para sup e inf.
           - Math.abs() para calcular digitos de negativos.
           - Un solo bucle for para la fila central: num + espacio + vertical + espacio.
           - System.out.print() para no saltar linea.

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
        // EJEMPLO 1: Array de enteros positivos
        // ============================================================
        separador("EJEMPLO 1: Array de enteros");
        int[] nums = {1, 2, 112, 564, 23, 1, 2323, 2, 3};
        mostrarArrayConBordes(nums);
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Array con negativos
        // ============================================================
        separador("EJEMPLO 2: Array con negativos");
        int[] numsNeg = {1, -30, 520, -4, 12345};
        mostrarArrayConBordes(numsNeg);
        System.out.println();

        // ============================================================
        // COMPARACION
        // ============================================================
        separador("COMPARACION DE RESULTADOS");
        System.out.println("Ej 1: Positivos       -> celdas individuales para cada numero");
        System.out.println("Ej 2: Con negativos   -> el signo - ocupa espacio extra");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODO: Contar digitos de un numero (recursivo, solo positivos)
    // -------------------------------------------------------------
    static int digitos(int n) {
        if (n < 10) {
            return 1;
        }
        return 1 + digitos(n / 10);
    }

    // -------------------------------------------------------------
    // METODO PRINCIPAL: mostrar array con bordes
    // -------------------------------------------------------------
    static void mostrarArrayConBordes(int[] nums) {
        imprimirBordeSuperiorArray(nums);
        imprimirEnterosArray(nums);
        imprimirBordeInferiorArray(nums);
    }

    // -------------------------------------------------------------
    // Imprimir borde (generico: superior o inferior)
    // -------------------------------------------------------------
    static final int BORDE_SUP = 0;
    static final int BORDE_INF = 1;

    static void imprimirBordeArray(int[] arr, int tipoBorde) {
        // Primera esquina
        if (tipoBorde == BORDE_SUP) {
            System.out.print(ESQUINA_SUP_IZQ);
        } else {
            System.out.print(ESQUINA_INF_IZQ);
        }

        // Por cada elemento
        for (int i = 0; i < arr.length; i++) {
            int lineas;
            if (arr[i] < 0) {
                lineas = digitos(Math.abs(arr[i])) + 3; // dig + signo + 2 espacios
            } else {
                lineas = digitos(arr[i]) + 2;           // dig + 2 espacios
            }

            for (int j = 0; j < lineas; j++) {
                System.out.print(LINEA_HORIZONTAL);
            }

            // Separador entre celdas (NO en la ultima)
            if (i < arr.length - 1) {
                if (tipoBorde == BORDE_SUP) {
                    System.out.print(SEPARADOR_SUP);
                } else {
                    System.out.print(SEPARADOR_INF);
                }
            }
        }

        // Ultima esquina
        if (tipoBorde == BORDE_SUP) {
            System.out.println(ESQUINA_SUP_DER);
        } else {
            System.out.println(ESQUINA_INF_DER);
        }
    }

    // -------------------------------------------------------------
    // Imprimir borde superior
    // -------------------------------------------------------------
    static void imprimirBordeSuperiorArray(int[] arr) {
        imprimirBordeArray(arr, BORDE_SUP);
    }

    // -------------------------------------------------------------
    // Imprimir borde inferior
    // -------------------------------------------------------------
    static void imprimirBordeInferiorArray(int[] arr) {
        imprimirBordeArray(arr, BORDE_INF);
    }

    // -------------------------------------------------------------
    // Imprimir los enteros con bordes verticales
    // -------------------------------------------------------------
    static void imprimirEnterosArray(int[] nums) {
        System.out.print(LINEA_VERTICAL + " ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " " + LINEA_VERTICAL + " ");
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
