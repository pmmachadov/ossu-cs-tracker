class Video_4_11_Ejercicio_String_Bordes {

    // -------------------------------------------------------------
    // Constantes Unicode para bordes
    // -------------------------------------------------------------
    static final char LINEA_VERTICAL = '\u2551';
    static final char LINEA_HORIZONTAL = '\u2550';
    static final char ESQUINA_SUP_IZQ = '\u2554';
    static final char ESQUINA_SUP_DER = '\u2557';
    static final char ESQUINA_INF_IZQ = '\u255A';
    static final char ESQUINA_INF_DER = '\u255D';
    static final char SEPARADOR_IZQ = '\u2560';
    static final char SEPARADOR_DER = '\u2563';

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-11 JAVA: Ejercicio String con bordes \u2615 DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=03CCpdROuMo&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=76";
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
          RESUMEN RAPIDO - STRING CON BORDES UNICODE (TEMA 4 - V11)
        ====================================================================

        --- ENUNCIADO ---
        Disenar un metodo que imprima una String en MAYUSCULAS dentro de
        un rectangulo con caracteres Unicode (box drawing).
        - Letras separadas por un espacio.
        - 2 espacios de separacion izquierda y derecha.
        - Multiples lineas separadas por \\n.

        --- CONSTANTES UNICODE (Box Drawing) ---
        static final char ESQUINA_SUP_IZQ = '\\u2554';  // esquina superior izquierda
        static final char ESQUINA_SUP_DER = '\\u2557';  // esquina superior derecha
        static final char ESQUINA_INF_IZQ = '\\u255A';  // esquina inferior izquierda
        static final char ESQUINA_INF_DER = '\\u255D';  // esquina inferior derecha
        static final char LINEA_HORIZONTAL = '\\u2550';  // linea horizontal doble
        static final char LINEA_VERTICAL = '\\u2551';    // linea vertical doble

        --- METODO PRINCIPAL: mostrarTextoConBordes(String texto) ---
        1. Pasarlo a mayusculas: texto = texto.toUpperCase();
        2. Dividir en lineas:   String[] lineas = texto.split("\\\\n");
        3. Obtener ancho maximo: ancho = max length de todas las lineas
        4. Imprimir borde superior: ESQUINA_SUP_IZQ + (ancho*2+3)*LINEA_HORIZONTAL + ESQUINA_SUP_DER
        5. Por cada linea:
           - LINEA_VERTICAL + "  "
           - Por cada letra: if (j < lineas[i].length()) -> letra + " "  else -> "  "
           - " " + LINEA_VERTICAL
        6. Imprimir borde inferior: ESQUINA_INF_IZQ + (ancho*2+3)*LINEA_HORIZONTAL + ESQUINA_INF_DER

        --- CALCULO DEL ANCHO DEL BORDE ---
        ancho = longitud de la linea mas larga
        lineas horizontales = ancho * 2 + 3
        (cada letra ocupa 2: letra+espacio, +3 por los 2 espacios izq y 1 extra del ultimo)

        --- REFACTORIZACION RECOMENDADA ---
        - imprimirBordeSuperior(int ancho)
        - imprimirBordeInferior(int ancho)
        - imprimirLineas(String[] lineas, int ancho)
        - obtenerAnchoMaximo(String[] lineas)
        - mostrarTextoConBordes(String texto)  -> metodo principal

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. CARACTERES UNICODE:
           - \\u2554 -> ╔, \\u2557 -> ╗, \\u255A -> ╚, \\u255D -> ╝
           - \\u2550 -> ═, \\u2551 -> ║
           - Se pueden cambiar por caracteres simples (+ - |) si no funciona Unicode.

        2. ESTRUCTURA DEL BORDE SUPERIOR/INFERIOR:
           - 1 esquina + (ancho*2+3) lineas horizontales + 1 esquina
           - Ejemplo: ╔═══════════════╗

        3. ESTRUCTURA DE CADA LINEA:
           - ║ + 2 espacios + letras separadas por espacio + 1 espacio + ║
           - Si una linea es mas corta, rellenar con espacios hasta el ancho maximo.

        4. METODO SPLIT:
           - texto.split("\\\\n")  -> divide por saltos de linea
           - Cada elemento del array es una linea del texto.

        5. TOUPPERCASE():
           - texto.toUpperCase() ANTES de dividir en lineas.

        6. ERRORES TIPICOS:
           - No calcular bien el ancho del borde (ancho*2+3).
           - Olvidar el espacio extra al final de cada linea.
           - No poner toString() en char para concatenar con String.
           - No proteger indices cuando una linea es mas corta que el maximo.
           - Poner toUpperCase() DESPUES de split (no afecta a las lineas).

        7. TRUCOS RAPIDOS:
           - La linea mas larga determina el ancho del borde.
           - Rellenar con espacios las lineas cortas.
           - Usar print() para no saltar linea en cada caracter.
           - Metodos cortos y con nombres significativos.

        ====================================================================
        """;

    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: Una sola linea
        // ============================================================
        separador("EJEMPLO 1: Una sola linea");
        mostrarTextoConBordes("Hoy es jueves 1 de diciembre de 2022");
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Multiples lineas
        // ============================================================
        separador("EJEMPLO 2: Multiples lineas");
        String texto = "Programacion en Java\nTema 4\nEstamos haciendo ejercicios de repaso";
        mostrarTextoConBordes(texto);
        System.out.println();

        // ============================================================
        // COMPARACION
        // ============================================================
        separador("COMPARACION DE RESULTADOS");
        System.out.println("Ej 1: Una linea    -> borde uniforme alrededor");
        System.out.println("Ej 2: Multiples    -> borde se adapta a la linea mas larga");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODO PRINCIPAL: mostrar texto con bordes
    // -------------------------------------------------------------
    static void mostrarTextoConBordes(String texto) {
        // Pasar a mayusculas
        texto = texto.toUpperCase();

        // Dividir en lineas
        String[] lineas = texto.split("\\\\n");

        // Obtener ancho maximo
        int ancho = obtenerAnchoMaximo(lineas);

        // Imprimir bordes y contenido
        imprimirBordeSuperior(ancho);
        imprimirLineas(lineas, ancho);
        imprimirBordeInferior(ancho);
    }

    // -------------------------------------------------------------
    // Obtener la longitud de la linea mas larga
    // -------------------------------------------------------------
    static int obtenerAnchoMaximo(String[] lineas) {
        int max = 0;
        for (String linea : lineas) {
            if (linea.length() > max) {
                max = linea.length();
            }
        }
        return max;
    }

    // -------------------------------------------------------------
    // Imprimir borde superior
    // -------------------------------------------------------------
    static void imprimirBordeSuperior(int ancho) {
        System.out.print(ESQUINA_SUP_IZQ);
        for (int i = 0; i < ancho * 2 + 3; i++) {
            System.out.print(LINEA_HORIZONTAL);
        }
        System.out.println(ESQUINA_SUP_DER);
    }

    // -------------------------------------------------------------
    // Imprimir borde inferior
    // -------------------------------------------------------------
    static void imprimirBordeInferior(int ancho) {
        System.out.print(ESQUINA_INF_IZQ);
        for (int i = 0; i < ancho * 2 + 3; i++) {
            System.out.print(LINEA_HORIZONTAL);
        }
        System.out.println(ESQUINA_INF_DER);
    }

    // -------------------------------------------------------------
    // Imprimir las lineas del texto con bordes laterales
    // -------------------------------------------------------------
    static void imprimirLineas(String[] lineas, int ancho) {
        for (int i = 0; i < lineas.length; i++) {
            System.out.print(LINEA_VERTICAL + "  ");
            for (int j = 0; j < ancho; j++) {
                if (j < lineas[i].length()) {
                    System.out.print(lineas[i].charAt(j) + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println(" " + LINEA_VERTICAL);
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