class Video_2_22_Precision_Decimales {

    // ──────────────────────────────────────────────────────────────
    // Datos del video y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "2-22 JAVA: Decimales y precision ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=noQbTZdYYZo&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=38";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────

    public static final String RESUMEN =
        """
        ================================================================
          2-22 DECIMALES Y PRECISION EN JAVA
        ================================================================

        Java proporciona dos tipos para almacenar numeros reales
        (con decimales): float y double.

        --- TIPOS EN COMA FLOTANTE ---

        Tipo     Bytes   Bits    Precision       Nombre
        ----     -----   ----    ---------       -----
        float    4       32      7 decimales     Simple precision (binary32)
        double   8       64      16 decimales    Doble precision (binary64)

        --- ESTANDAR IEEE 754 ---

        Java almacena los reales siguiendo el estandar IEEE 754.

        Float (32 bits):
          [1 bit signo] [8 bits exponente] [23 bits mantisa]
          Precision: ~7 digitos decimales significativos

        Double (64 bits):
          [1 bit signo] [11 bits exponente] [52 bits mantisa]
          Precision: ~16 digitos decimales significativos

        --- PROBLEMA: PERDIDA DE PRECISION ---

        En memoria todo se almacena en BINARIO (unos y ceros).

        Los numeros enteros se guardan sin problemas en binario.
        Pero los numeros decimales NO siempre se pueden representar
        de forma exacta en binario.

        Analogia:
          - En decimal, 1/2 = 0,5  ->  se representa bien
          - En decimal, 1/3 = 0,333... -> NO se puede representar
            exactamente (infinitos decimales periodicos)

          - En binario, dividir entre potencias de 2 es facil
          - En binario, dividir entre 10 (como 0,1 o 0,2) genera
            infinitos decimales -> PERDIDA DE PRECISION

        --- EJEMPLO CLASICO: 0.1 + 0.2 ---

        En Java:
          double a = 0.1 + 0.2;
          System.out.println(a);
          // Muestra: 0.30000000000000004
          // El 4 final es la perdida de precision

        Esto ocurre porque 0.1 y 0.2 no se pueden representar
        de forma exacta en binario.

        --- COMPORTAMIENTO CON FLOAT vs DOUBLE ---

        float  f = 0.1f + 0.2f;  // -> 0.3 (descarta decimales no precisos)
        double d = 0.1  + 0.2;   // -> 0.30000000000000004

        El float tiene SOLO 7 decimales de precision, por lo que
        descarta el error y "parece" exacto.
        El double tiene 16 decimales de precision, mostrando el error.

        --- OTRA FORMA DE PERDER PRECISION ---

        Division de enteros asignada a variable real:

          int a = 10, b = 3;
          double c = a / b;
          System.out.println(c);
          // Muestra: 3.0  (NO 3.3333...)

        Explicacion:
          a / b se evalua como division ENTERA (int / int = int)
          El resultado es 3 (se trunca)
          Luego se asigna 3 a double -> 3.0

        Solucion: que al menos uno de los operandos sea real:
          double c = (double) a / b;  // o a / 3.0

        --- RESUMEN ---

        * float  -> 4 bytes, ~7 decimales precision (simple)
        * double -> 8 bytes, ~16 decimales precision (doble)
        * IEEE 754: signo + exponente + mantisa
        * 0.1 + 0.2 NO es exacto en binario
        * float oculta el error por tener menos precision
        * Division entera truncada: int / int -> int
        * Para evitar perdida: usar (double) o literales con decimal
        * Para calculos financieros NO usar float/double (usar BigDecimal)
        ================================================================
        """;

    // ──────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        mostrarInformacion();

        System.out.println();
        System.out.println("============================================");
        System.out.println("   EJEMPLOS DE PRECISION");
        System.out.println("============================================");
        System.out.println();

        // ── 1. Ejemplo clasico: 0.1 + 0.2 ──
        System.out.println("--- 1. 0.1 + 0.2 (perdida de precision) ---");
        System.out.println("0.1 + 0.2 = " + (0.1 + 0.2));
        System.out.println();

        // ── 2. double vs float ──
        System.out.println("--- 2. double vs float ---");
        double a = 0.1 + 0.2;
        float  f = 0.1f + 0.2f;
        System.out.println("double a = 0.1 + 0.2 -> " + a);
        System.out.println("float  f = 0.1f + 0.2f -> " + f);
        System.out.println("  (float tiene menos precision, descarta el error)");
        System.out.println();

        // ── 3. Float sumado y guardado en double ──
        System.out.println("--- 3. Suma de floats guardada en double ---");
        double dDeFlotantes = 0.1f + 0.2f;
        System.out.println("double dDeFlotantes = 0.1f + 0.2f -> " + dDeFlotantes);
        System.out.println("  (hereda la imprecision de los floats)");
        System.out.println();

        // ── 4. Division entera truncada ──
        System.out.println("--- 4. Division entera truncada ---");
        int x = 10, y = 3;
        double c = x / y;
        System.out.println("int x = 10, y = 3;");
        System.out.println("double c = x / y -> " + c);
        System.out.println("  (x / y es int / int = 3, luego se asigna 3.0)");
        System.out.println();

        // ── 5. Division con casteo correcto ──
        System.out.println("--- 5. Division con casteo correcto ---");
        double cBien = (double) x / y;
        System.out.println("double cBien = (double) x / y -> " + cBien);
        System.out.println("  (casteo a double antes de dividir)");
        System.out.println();

        // ── 6. Comparativa completa ──
        System.out.println("--- 6. COMPARATIVA COMPLETA ---");
        System.out.println();
        System.out.printf("%-40s %s%n", "Expresion", "Resultado");
        System.out.printf("%-40s %s%n", "--------", "---------");
        System.out.printf("%-40s %.20f%n", "0.1 + 0.2", 0.1 + 0.2);
        System.out.printf("%-40s %.20f%n", "0.1f + 0.2f", 0.1f + 0.2f);
        System.out.printf("%-40s %.20f%n", "(double)(0.1f + 0.2f)", (double)(0.1f + 0.2f));
        System.out.printf("%-40s %.20f%n", "10 / 3 (entero)", (double)(10 / 3));
        System.out.printf("%-40s %.20f%n", "(double)10 / 3", (double)10 / 3);
        System.out.printf("%-40s %.20f%n", "10.0 / 3", 10.0 / 3);
        System.out.printf("%-40s %.20f%n", "10f / 3f", 10f / 3f);
        System.out.println();

        // ── 7. Mostrando mas decimales ──
        System.out.println("--- 7. Diferencias con mas decimales ---");
        System.out.printf("0.1 + 0.2 (%%%.20f) = %.20f%n", 0.1 + 0.2, 0.1 + 0.2);
        System.out.printf("0.1f + 0.2f (%%%.20f) = %.20f%n", 0.1f + 0.2f, 0.1f + 0.2f);
        System.out.println("  (el float se queda en 0.3, el double muestra el error)");
        System.out.println();

        // ── 8. Mas alla de la precision ──
        System.out.println("--- 8. IEEE 754: limite de representacion ---");
        System.out.println("Float.MAX_VALUE  = " + Float.MAX_VALUE);
        System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE);
        System.out.println("Float.MIN_VALUE  = " + Float.MIN_VALUE);
        System.out.println("Double.MIN_VALUE = " + Double.MIN_VALUE);
        System.out.println();

        System.out.println("--- Fin de los ejemplos ---");
        System.out.println("  NOTA: Para calculos financieros usar BigDecimal,");
        System.out.println("  no float/double, por la perdida de precision.");
    }

    // ──────────────────────────────────────────────────────────────

    public static void mostrarInformacion() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("   INFORMACION DEL VIDEO");
        System.out.println("============================================");
        System.out.println("Video:      " + TITULO);
        System.out.println("Canal:      " + CANAL);
        System.out.println("URL Canal:  " + URL_CANAL);
        System.out.println("URL Video:  " + URL);
        System.out.println("Playlist:   " + PLAYLIST);
        System.out.println("Repo:       " + REPO);
        System.out.println();
        System.out.println(RESUMEN);
    }
}
