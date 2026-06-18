class Video_3_07_PilaLlamadas {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "3-07 JAVA: La pila de llamadas DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=KS0IEW-iceY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=60";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 3";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // RESUMEN para el examen (CHULETA)
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ====================================================================
          RESUMEN RAPIDO - PILA DE LLAMADAS (TEMA 3 - V7)
        ====================================================================

        --- QUE ES LA PILA DE LLAMADAS (CALL STACK) ---
        Es una estructura de datos (LIFO: Last In, First Out) que usa la
        JVM para gestionar las llamadas a metodos durante la ejecucion.

        - Se aloja en memoria RAM.
        - Cada vez que se invoca un metodo, se crea un REGISTRO DE
          ACTIVACION (stack frame) que se apila encima del anterior.
        - Cuando el metodo termina (return o fin de void), se desapila.
        - El metodo MAIN es el primero en apilarse y el ultimo en
          desapilarse.

        --- REGISTRO DE ACTIVACION (STACK FRAME) ---
        Cada metodo en la pila tiene su propio registro con:
        - Parametros del metodo (valores recibidos).
        - Variables locales del metodo.
        - Direccion de retorno (a donde volver cuando termine).

        Un metodo SOLO puede usar la informacion de su propio registro
        (sus variables locales y parametros). Tambien puede acceder a
        variables globales si las hay.

        --- ORDEN DE EJECUCION ---
        1. Se apila el metodo main (primero en ejecutarse).
        2. Si main llama a metodoA(), se apila metodoA encima.
        3. Si metodoA llama a metodoB(), se apila metodoB encima.
        4. metodoB termina -> se desapila metodoB -> vuelve a metodoA.
        5. metodoA termina -> se desapila metodoA -> vuelve a main.
        6. main termina -> se desapila main -> programa finaliza.

        --- EJEMPLO 1 (SENCILLO) ---
            static int proceso(int n) {
                int s = 0;
                for (int i = 0; i < n; i++) {
                    s += i;
                }
                return s;
            }

            En main: int num = 3; int sum = proceso(num);
            - Pila: [main] -> [proceso(3)] -> return 3 -> [main] -> fin
            - Para n=3: s = 0+1+2 = 3

        --- EJEMPLO 2 (COMPLEJO) ---
            static int proceso1(int n1) {
                int p1 = 1;
                for (int i = 0; i < n1; i++) {
                    p1 += proceso2(i);
                }
                return p1;
            }

            static int proceso2(int n2) {
                int p2 = 1;
                for (int i = 0; i < n2; i++) {
                    p2 += n2;
                }
                return p2;
            }

            En main: int num = 3; int res = proceso1(num);
            - proceso2(0) = 1   (bucle no entra)
            - proceso2(1) = 2   (1 + 1*1 = 2)
            - proceso2(2) = 5   (1 + 2*2 = 5)
            - proceso1(3): p1=1 + 1 + 2 + 5 = 9
            - Resultado: res = 9

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * La pila es LIFO (Last In, First Out).
        * El main es el primer metodo en apilarse.-
        * Cada metodo tiene su propio registro (parametros + locales).
        * Al terminar un metodo, se desapila y se retorna al que llamo.
        * Los registros de activacion se almacenan en RAM.
        * Un metodo NO puede acceder a las locales de otro metodo.
        * Variables globales SI son accesibles desde cualquier metodo.

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
        // EJEMPLO 1: Pila simple - un metodo llama a otro
        // ============================================================

        separador("EJEMPLO 1: Pila simple - metodo proceso(n)");
        System.out.println("  main() apila -> proceso(3) se apila encima");
        System.out.println("  Dentro: bucle suma i desde 0 hasta n-1");
        System.out.println("  proceso(3) termina -> return s -> se desapila");
        System.out.println("  main() continua con el resultado");
        System.out.println();

        int num = 3;
        int sum = proceso(num);
        System.out.println("  num = " + num);
        System.out.println("  sum = proceso(" + num + ") = " + sum);
        System.out.println("  (suma de 0+1+2 = " + sum + ")");
        System.out.println();
        System.out.println("  PILA (orden de ejecucion):");
        System.out.println("    1. Se apila main()");
        System.out.println("    2. main llama a proceso(3) -> se apila proceso");
        System.out.println("    3. proceso devuelve " + sum + " -> se desapila proceso");
        System.out.println("    4. main asigna resultado y continua");
        System.out.println("    5. main termina -> se desapila main -> FIN");
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Pila con llamada anidada (proceso1 -> proceso2)
        // ============================================================

        separador("EJEMPLO 2: Pila anidada - proceso1(llama a proceso2)");
        System.out.println("  main() apila -> proceso1(3) -> proceso2(i) varias veces");
        System.out.println("  Cada llamada a proceso2 crea un nuevo frame en la pila!");
        System.out.println();

        int numb = 3;
        int res = proceso1(numb);
        System.out.println("  numb = " + numb);
        System.out.println("  res = proceso1(" + numb + ") = " + res);
        System.out.println();

        System.out.println("  DESGLOSE de la pila:");
        System.out.println("  proceso2(0): n2=0, bucle no entra, p2=1 -> return 1");
        System.out.println("  proceso2(1): n2=1, bucle 1 vez: p2=1+1=2  -> return 2");
        System.out.println("  proceso2(2): n2=2, bucle 2 veces: p2=1+2+2=5 -> return 5");
        System.out.println("  proceso1(3): p1=1, i=0 -> p1=1+1=2");
        System.out.println("                        i=1 -> p1=2+2=4");
        System.out.println("                        i=2 -> p1=4+5=9 -> return 9");
        System.out.println("  Resultado final: res = 9");
        System.out.println();

        System.out.println("  PILA COMPLETA (orden):");
        System.out.println("    1. Se apila main()");
        System.out.println("    2. main llama a proceso1(3) -> se apila proceso1");
        System.out.println("    3. proceso1(i=0) llama a proceso2(0) -> se apila proceso2");
        System.out.println("    4. proceso2(0) devuelve 1 -> se desapila proceso2");
        System.out.println("    5. proceso1(i=1) llama a proceso2(1) -> se apila proceso2");
        System.out.println("    6. proceso2(1) devuelve 2 -> se desapila proceso2");
        System.out.println("    7. proceso1(i=2) llama a proceso2(2) -> se apila proceso2");
        System.out.println("    8. proceso2(2) devuelve 5 -> se desapila proceso2");
        System.out.println("    9. proceso1(3) devuelve 9 -> se desapila proceso1");
        System.out.println("   10. main asigna 9 a res y termina -> FIN");
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Visualizar la pila paso a paso con prints
        // ============================================================

        separador("EJEMPLO 3: Traza de la pila con prints en cada metodo");
        System.out.println("  Cada metodo imprime cuando empieza y cuando termina.");
        System.out.println("  Asi podemos ver el orden real de ejecucion.");
        System.out.println();

        System.out.println("  --- INICIO DE LA TRAZA ---");
        metodoA();
        System.out.println("  --- FIN DE LA TRAZA ---");
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Calculo factorial recursivo (pila profunda)
        // ============================================================

        separador("EJEMPLO 4: Factorial recursivo - pila mas profunda");
        System.out.println("  La RECURSION es un caso donde la pila crece mucho.");
        System.out.println("  Cada llamada a factorial() se apila hasta llegar al caso base.");
        System.out.println();

        int n = 5;
        int fact = factorial(n);
        System.out.println("  factorial(" + n + ") = " + fact + "  (5! = 5x4x3x2x1 = 120)");
        System.out.println("  La pila llego a tener " + n + " frames apilados!");
        System.out.println("  (factorial(5) -> factorial(4) -> ... -> factorial(1))");
        System.out.println();

        // ============================================================
        // COMPARACION DE RESULTADOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ej 1: proceso(3)                          -> " + proceso(3) + "  (0+1+2)");
        System.out.println("Ej 2: proceso1(3) [con proceso2 anidado]  -> " + proceso1(3) + "  (9)");
        System.out.println("Ej 3: metodoA -> metodoB -> metodoC       -> traza en consola");
        System.out.println("Ej 4: factorial(5)                        -> " + factorial(5) + "  (120)");

        System.out.println();
        System.out.println("===================================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Proximamente...");
        System.out.println("===================================================================");
    }

    // -------------------------------------------------------------
    // METODOS DEL EJEMPLO 1
    // -------------------------------------------------------------

    // Proceso simple: suma i desde 0 hasta n-1
    static int proceso(int n) {
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += i;
        }
        return s;
    }

    // -------------------------------------------------------------
    // METODOS DEL EJEMPLO 2 (anidados)
    // -------------------------------------------------------------

    // proceso1: acumula proceso2(i) para i = 0..n1-1
    static int proceso1(int n1) {
        int p1 = 1;
        for (int i = 0; i < n1; i++) {
            p1 += proceso2(i);
        }
        return p1;
    }

    // proceso2: acumula n2 tantas veces como n2 (empezando en 1)
    static int proceso2(int n2) {
        int p2 = 1;
        for (int i = 0; i < n2; i++) {
            p2 += n2;
        }
        return p2;
    }

    // -------------------------------------------------------------
    // METODOS DEL EJEMPLO 3 (traza)
    // -------------------------------------------------------------

    static void metodoA() {
        System.out.println("    [PILA] -> metodoA() COMIENZA");
        System.out.println("    [PILA] -> metodoA() llama a metodoB()");
        metodoB();
        System.out.println("    [PILA] -> metodoA() TERMINA (se desapila)");
    }

    static void metodoB() {
        System.out.println("    [PILA] -> metodoB() COMIENZA");
        System.out.println("    [PILA] -> metodoB() llama a metodoC()");
        metodoC();
        System.out.println("    [PILA] -> metodoB() TERMINA (se desapila)");
    }

    static void metodoC() {
        System.out.println("    [PILA] -> metodoC() COMIENZA");
        System.out.println("    [PILA] -> metodoC() ejecuta instrucciones");
        System.out.println("    [PILA] -> metodoC() TERMINA (se desapila)");
    }

    // -------------------------------------------------------------
    // METODOS DEL EJEMPLO 4 (recursion)
    // -------------------------------------------------------------

    // Factorial recursivo: n! = n * (n-1)!
    static int factorial(int n) {
        if (n <= 1) {
            return 1;  // Caso base: 1! = 1
        }
        return n * factorial(n - 1);  // Llamada recursiva
    }

    // -------------------------------------------------------------
    // METODO AUXILIAR: separador
    // -------------------------------------------------------------

    public static void separador(String titulo) {
        System.out.println();
        System.out.println("===================================================================");
        System.out.println("  " + titulo);
        System.out.println("===================================================================");
    }
}
