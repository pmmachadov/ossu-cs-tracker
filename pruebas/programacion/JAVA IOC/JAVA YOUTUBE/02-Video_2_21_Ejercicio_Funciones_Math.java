class Video_2_21_Ejercicio_Funciones_Math {

    // ──────────────────────────────────────────────────────────────
    // Datos del video y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "2-21 JAVA: Ejercicio Funciones matematicas (Math) ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=jKs6kq6z1sI&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=37";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────

    public static final String RESUMEN =
        """
        ================================================================
          2-21 EJERCICIO: FUNCIONES MATEMATICAS (CLASE MATH)
        ================================================================

        Ejemplos practicos de las funciones matematicas de la clase Math
        dentro de Visual Studio Code.

        --- 1. POTENCIA: Math.pow(base, exponente) ---

        int n = 2, m = 4;
        double resultado = Math.pow(n, m);
        // n elevado a m = 2^4 = 16.0

        Muestra por pantalla:
          System.out.println(n + " elevado a " + m + " = " + resultado);
          // Salida: "2 elevado a 4 = 16.0"

        Casting a entero:
          System.out.println(n + " elevado a " + m + " = " + (int) resultado);
          // Salida: "2 elevado a 4 = 16"
          // (int) trunca los decimales, no redondea

        --- 2. RAIZ CUADRADA: Math.sqrt(double) ---

        double raiz = Math.sqrt(resultado);
        // Si resultado = 16.0, raiz = 4.0
        // Si resultado = 625.0, raiz = 25.0

        Con numeros que no tienen raiz exacta:
          double raiz = Math.sqrt(3125.0);  // 55.9017...
          // No hacer casting a int si se quieren ver los decimales

        --- 3. AREA DEL CIRCULO: Math.PI ---

        int radio = 10;
        double area = Math.PI * radio * radio;
        // area = pi * r^2 = 314.159...

        Tambien con Math.pow:
          double area = Math.PI * Math.pow(radio, 2);

        System.out.println("El area de un circulo de radio " + radio + " es: " + area);

        --- 4. REDONDEO: Math.round, Math.ceil, Math.floor ---

        Math.round(area)   -> long   -> entero mas cercano
        Math.ceil(area)    -> double -> numero completo mas proximo por ARRIBA
        Math.floor(area)   -> double -> numero completo mas proximo por ABAJO

        Para area = 314.159...:
          (int) Math.round(area)  -> 314
          (int) Math.ceil(area)   -> 315
          (int) Math.floor(area)  -> 314

        Math.round devuelve long (no necesita casting para int si el valor cabe).
        Math.ceil y Math.floor devuelven double (casting opcional).

        --- 5. NUMEROS ALEATORIOS: Math.random() ---

        Math.random() devuelve un double entre 0.0 (incluido) y 1.0 (excluido).

        Aleatorio entre 0 y 9 (enteros):
          int radio = (int) (Math.random() * 10);
          // Multiplica por 10 -> [0.0, 10.0), casting trunca -> [0, 9]

        Aleatorio entre 1 y 10:
          int radio = (int) (Math.random() * 10) + 1;
          // Tras casting: [0, 9] + 1 -> [1, 10]

        Aleatorio entre 0 y 2 (incluyendo 2):
          int radio = (int) (Math.random() * 3);
          // Multiplica por 3 -> [0.0, 3.0), casting trunca -> [0, 2]

        Aleatorio entre 1 y 3:
          int radio = (int) (Math.random() * 3) + 1;
          // [0, 2] + 1 -> [1, 3]

        --- 6. CASOS ESPECIALES: NaN e Infinity ---

        Raiz cuadrada de numero NEGATIVO:
          Math.sqrt(-2)  -> NaN (Not a Number)

        Division entera entre 0:
          1 / 0  -> ERROR en ejecucion (ArithmeticException)

        Division real entre 0.0:
          1.0 / 0.0  -> Infinity
          -1.0 / 0.0 -> -Infinity

        Comprobaciones con Double:
          Double.isNaN(Math.sqrt(-2))   -> true
          Double.isInfinite(1.0 / 0.0)  -> true

        --- CODIGO COMPLETO DEL VIDEO ---

        // ---------- PROGRAMA COMPLETO ----------
        public static void main(String[] args) {
            int n = 2, m = 4;
            double resultado = Math.pow(n, m);
            System.out.println(n + " elevado a " + m + " = " + resultado);
            System.out.println(n + " elevado a " + m + " = " + (int) resultado);

            double raiz = Math.sqrt(resultado);
            System.out.println("La raiz cuadrada de " + resultado + " es " + raiz);
            System.out.println("La raiz cuadrada de " + (int) resultado + " es " + (int) raiz);

            // Area del circulo
            int radio = 10;
            double area = Math.PI * radio * radio;
            System.out.println("\\nEl area de un circulo de radio " + radio + " es: " + area);
            System.out.println("Area redondeada: " + (int) Math.round(area));
            System.out.println("Area por arriba (ceil): " + (int) Math.ceil(area));
            System.out.println("Area por abajo (floor): " + (int) Math.floor(area));

            // Aleatorio entre 1 y 10
            int radioAleatorio = (int) (Math.random() * 10) + 1;
            double areaAleatoria = Math.PI * Math.pow(radioAleatorio, 2);
            System.out.println("\\nEl area de un circulo de radio " + radioAleatorio + " es: " + areaAleatoria);

            // NaN e Infinity
            System.out.println("\\nLa raiz cuadrada de -2 es un NaN: " + Double.isNaN(Math.sqrt(-2)));
            System.out.println("1.0 / 0.0 = " + (1.0 / 0.0));
            System.out.println("Double.isInfinite(1.0/0.0): " + Double.isInfinite(1.0 / 0.0));
        }

        --- SALIDA DEL PROGRAMA ---

        2 elevado a 4 = 16.0
        2 elevado a 4 = 16
        La raiz cuadrada de 16.0 es 4.0
        La raiz cuadrada de 16 es 4

        El area de un circulo de radio 10 es: 314.1592653589793
        Area redondeada: 314
        Area por arriba (ceil): 315
        Area por abajo (floor): 314

        El area de un circulo de radio 7 es: 153.93804002589985
        (el radio varia porque es aleatorio)

        La raiz cuadrada de -2 es un NaN: true
        1.0 / 0.0 = Infinity
        Double.isInfinite(1.0/0.0): true

        --- CONCEPTOS CLAVE ---

        * Math.pow(base, exp) -> double. Siempre devuelve double.
        * Math.sqrt(double) -> double. Si argumento negativo -> NaN.
        * Math.PI -> constante double (pi).
        * Math.round(double) -> long (entero mas cercano).
        * Math.ceil(double) -> double (redondeo hacia arriba).
        * Math.floor(double) -> double (redondeo hacia abajo).
        * Math.random() -> double entre 0.0 y 1.0 (1.0 excluido).
        * Para aleatorio entero en [min, max]: (int)(Math.random() * (max-min+1)) + min
        * Division entera / 0 -> ArithmeticException (error).
        * Division double / 0.0 -> Infinity (no error).
        * Double.isNaN(valor) -> true si el valor es NaN.
        * Double.isInfinite(valor) -> true si el valor es +/-Infinity.
        * (int) casting trunca decimales (no redondea).
        * La API de Java (java.lang.Math) tiene toda la documentacion.
        ================================================================
        """;

    // ──────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        mostrarInformacion();

        System.out.println();
        System.out.println("============================================");
        System.out.println("   EJECUCION DEL PROGRAMA (VIDEO)");
        System.out.println("============================================");
        System.out.println();

        // ── Variables iniciales ──
        int n = 2, m = 4;
        double resultado = Math.pow(n, m);

        // ── 1. Potencia ──
        System.out.println("--- 1. POTENCIA ---");
        System.out.println(n + " elevado a " + m + " = " + resultado);
        System.out.println(n + " elevado a " + m + " = " + (int) resultado);
        System.out.println();

        // ── 2. Raiz cuadrada ──
        double raiz = Math.sqrt(resultado);
        System.out.println("--- 2. RAIZ CUADRADA ---");
        System.out.println("La raiz cuadrada de " + resultado + " es " + raiz);
        System.out.println("La raiz cuadrada de " + (int) resultado + " es " + (int) raiz);
        System.out.println();

        // ── Cambio a valores no exactos ──
        n = 5; m = 5;
        resultado = Math.pow(n, m);
        raiz = Math.sqrt(resultado);
        System.out.println("--- Prueba con valores no exactos ---");
        System.out.println(n + " elevado a " + m + " = " + resultado);
        System.out.println("Raiz cuadrada de " + resultado + " = " + raiz);
        System.out.println("Raiz cuadrada (sin casting) = " + raiz);
        System.out.println();

        // ── Restauramos valores originales para el resto ──
        n = 2; m = 4;
        resultado = Math.pow(n, m);

        // ── 3. Area del circulo ──
        int radio = 10;
        double area = Math.PI * radio * radio;
        System.out.println("--- 3. AREA DEL CIRCULO ---");
        System.out.println("El area de un circulo de radio " + radio + " es: " + area);
        System.out.println();

        // ── 4. Redondeo ──
        System.out.println("--- 4. REDONDEO ---");
        System.out.println("Area redondeada (Math.round): " + (int) Math.round(area));
        System.out.println("Area por arriba (Math.ceil):  " + (int) Math.ceil(area));
        System.out.println("Area por abajo (Math.floor): " + (int) Math.floor(area));
        System.out.println();

        // ── 5. Aleatorio ──
        System.out.println("--- 5. NUMEROS ALEATORIOS ---");
        for (int i = 0; i < 5; i++) {
            int radioAleatorio = (int) (Math.random() * 10) + 1;  // entre 1 y 10
            double areaAleatoria = Math.PI * Math.pow(radioAleatorio, 2);
            System.out.println("  Radio aleatorio = " + radioAleatorio
                + " -> Area = " + areaAleatoria);
        }
        System.out.println();

        // ── 6. NaN e Infinity ──
        System.out.println("--- 6. CASOS ESPECIALES: NaN E INFINITY ---");
        System.out.println("Math.sqrt(-2) = " + Math.sqrt(-2));
        System.out.println("Double.isNaN(Math.sqrt(-2)): " + Double.isNaN(Math.sqrt(-2)));
        System.out.println();

        System.out.println("1.0 / 0.0 = " + (1.0 / 0.0));
        System.out.println("Double.isInfinite(1.0 / 0.0): " + Double.isInfinite(1.0 / 0.0));
        System.out.println();

        // ── Mostrar valores con/sin casting ──
        System.out.println("--- COMPARATIVA: round (devuelve long), ceil/floor (devuelven double) ---");
        System.out.println("Math.round(area)  = " + Math.round(area) + "  (tipo long)");
        System.out.println("Math.ceil(area)   = " + Math.ceil(area) + "  (tipo double)");
        System.out.println("Math.floor(area)  = " + Math.floor(area) + "  (tipo double)");
        System.out.println("(int)Math.round(area)  = " + (int) Math.round(area) + "  (casting a int)");
        System.out.println("(int)Math.ceil(area)   = " + (int) Math.ceil(area) + "  (casting a int)");
        System.out.println("(int)Math.floor(area)  = " + (int) Math.floor(area) + "  (casting a int)");
        System.out.println();

        System.out.println("--- Division entera vs real entre 0 ---");
        // System.out.println("1 / 0 = " + (1 / 0));  // Esto daria error (ArithmeticException)
        System.out.println("1 / 0     -> ERROR (ArithmeticException) - linea comentada");
        System.out.println("1.0 / 0.0 -> " + (1.0 / 0.0) + "  (Infinity, no error)");
        System.out.println("-1.0 / 0.0 -> " + (-1.0 / 0.0) + "  (-Infinity)");
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
