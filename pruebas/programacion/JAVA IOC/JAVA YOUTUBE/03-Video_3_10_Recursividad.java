class Video_3_10_Recursividad {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "3-10 JAVA: Recursividad ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=hFOkonKc1V4&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=63";
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
          RESUMEN RAPIDO - RECURSIVIDAD (TEMA 3 - V10)
        ====================================================================

        --- QUE ES LA RECURSIVIDAD ---
        Un metodo RECURSIVO es aquel que se llama a SI MISMO.
        Es una alternativa a los bucles (iteracion).

        --- PARTES DE UN METODO RECURSIVO ---
        1. CASO BASE: condicion que DETIENE la recursion.
           - Es la solucion mas simple posible.
           - Sin caso base -> recursion infinita -> StackOverflowError.
        2. CASO GENERAL (recursivo): el metodo se llama a si mismo
           con un problema MAS PEQUENO (n-1, n/2, etc.).
           - Cada llamada debe acercarse al caso base.

        --- EJEMPLO: FACTORIAL ---
        n! = n * (n-1) * (n-2) * ... * 1
        Caso base: 0! = 1
        Caso general: n! = n * (n-1)!

        Codigo:
          static int factorial(int n) {
              if (n == 0) {
                  return 1;          // Caso base
              } else {
                  return n * factorial(n - 1);  // Caso general
              }
          }

        --- TRAZA: factorial(4) = 24 ---
        APILADO (llamadas):
          factorial(4) -> 4 * factorial(3)
            factorial(3) -> 3 * factorial(2)
              factorial(2) -> 2 * factorial(1)
                factorial(1) -> 1 * factorial(0)
                  factorial(0) -> return 1  (CASO BASE)

        DESAPILADO (retornos):
                  factorial(0) = 1
                factorial(1) = 1 * 1 = 1
              factorial(2) = 2 * 1 = 2
            factorial(3) = 3 * 2 = 6
          factorial(4) = 4 * 6 = 24

        PILA: main -> fact(4) -> fact(3) -> fact(2) -> fact(1) -> fact(0)
        La pila llego a tener 6 niveles (main + 5 factoriales).

        --- CARACTERISTICAS IMPORTANTES ---
        * La recursion usa INTENSIVAMENTE la pila de llamadas.
        * Cada llamada recursiva APILA un nuevo frame en la pila.
        * Si la recursion es muy profunda -> StackOverflowError.
        * Sin caso base -> recursion infinita -> StackOverflowError.
        * La llamada recursiva debe ser sobre un problema MAS SENCILLO
          (normalmente n-1, n/2, etc.).
        * La recursion suele expresar soluciones complejas de forma
          MAS SIMPLE que la iteracion (bucles).
        * Pero NO siempre es mas eficiente: usa mas memoria (pila).

        --- RECURSIVIDAD VS ITERACION ---
        Iterativo: for/while, misma variable, no apila.
        Recursivo: se llama a si mismo, apila frames, puede agotar
        la pila si es muy profunda.

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Metodo recursivo = metodo que se llama a si mismo.
        * Siempre debe tener: CASO BASE + CASO GENERAL.
        * Caso base: detiene la recursion (ej: n == 0 -> return 1).
        * Caso general: llama con problema menor (ej: n * fact(n-1)).
        * Sin caso base -> StackOverflowError (desbordamiento de pila).
        * Cada llamada recursiva apila un nuevo frame en la call stack.
        * factorial(4) = 4 * 3 * 2 * 1 * 1 = 24.
        * El desapilado va en orden inverso al apilado (LIFO).
        * La recursion puede sustituir a los bucles.
        * Es mas legible pero menos eficiente en memoria.

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
        // EJEMPLO 1: Factorial recursivo
        // ============================================================

        separador("EJEMPLO 1: factorial(4) - Recursividad");
        System.out.println("  Demostracion de recursion con factorial.");
        System.out.println("  n! = n * (n-1)!");
        System.out.println("  Caso base: 0! = 1");
        System.out.println();

        int f = factorial(4);
        System.out.println("  factorial(4) = " + f + "  (4*3*2*1*1 = 24)");
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Varios factoriales
        // ============================================================

        separador("EJEMPLO 2: Factoriales de 0 a 6");
        for (int i = 0; i <= 6; i++) {
            System.out.println("  factorial(" + i + ") = " + factorial(i));
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Traza paso a paso (como en el video)
        // ============================================================

        separador("EJEMPLO 3: Traza de la pila - factorial(4)");
        System.out.println("  APILADO (llamadas recursivas):");
        System.out.println("    factorial(4) -> 4 * factorial(3)");
        System.out.println("      factorial(3) -> 3 * factorial(2)");
        System.out.println("        factorial(2) -> 2 * factorial(1)");
        System.out.println("          factorial(1) -> 1 * factorial(0)");
        System.out.println("            factorial(0) -> return 1  (CASO BASE)");
        System.out.println();
        System.out.println("  DESAPILADO (retornos):");
        System.out.println("            factorial(0) = 1");
        System.out.println("          factorial(1) = 1 * 1 = 1");
        System.out.println("        factorial(2) = 2 * 1 = 2");
        System.out.println("      factorial(3) = 3 * 2 = 6");
        System.out.println("    factorial(4) = 4 * 6 = 24");
        System.out.println();

        // ============================================================
        // EJEMPLO 4: factorial con variable local (como video)
        // ============================================================

        separador("EJEMPLO 4: factorialConVariable(4)");
        System.out.println("  Version del video con variable local 'r'");
        System.out.println("  para ver mejor la pila de llamadas.");
        System.out.println();

        int resultado = factorialConVariable(4);
        System.out.println("  factorialConVariable(4) = " + resultado);
        System.out.println();

        // ============================================================
        // EJEMPLO 5: Suma recursiva 1..n
        // ============================================================

        separador("EJEMPLO 5: sumaRecursiva(10)");
        System.out.println("  Suma de 1 hasta n de forma recursiva.");
        System.out.println("  Caso base: n == 1 -> return 1");
        System.out.println("  Caso general: n + sumaRecursiva(n-1)");
        System.out.println();

        System.out.println("  sumaRecursiva(10) = " + sumaRecursiva(10) + "  (1+2+...+10 = 55)");
        System.out.println();

        // ============================================================
        // EJEMPLO 6: Riesgo de StackOverflow
        // ============================================================

        separador("EJEMPLO 6: StackOverflowError (DEMO)");
        System.out.println("  La recursion sin caso base ->");
        System.out.println("  StackOverflowError.");
        System.out.println();
        System.out.println("  Codigo peligroso (COMENTADO por seguridad):");
        System.out.println("    static int recursionInfinita() {");
        System.out.println("        return recursionInfinita();");
        System.out.println("    }");
        System.out.println("  -> Se llena la pila hasta desbordarla.");
        System.out.println("  Nota: No ejecutamos esto para no colgar.");
        System.out.println();

        // ============================================================
        // COMPARACION DE RESULTADOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ej 1: factorial(4)                    = " + factorial(4));
        System.out.println("Ej 2: factorial(0) a factorial(6)     = 1,1,2,6,24,120,720");
        System.out.println("Ej 4: factorialConVariable(4)         = " + factorialConVariable(4));
        System.out.println("Ej 5: sumaRecursiva(10)               = " + sumaRecursiva(10));
        System.out.println("Ej 6: recursion sin caso base         = StackOverflowError");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Triangulo recursivo en Java");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODOS RECURSIVOS
    // -------------------------------------------------------------

    // Factorial recursivo (version simple)
    static int factorial(int n) {
        if (n == 0) {
            return 1;               // Caso base
        } else {
            return n * factorial(n - 1);  // Caso general
        }
    }

    // Factorial recursivo CON variable local (version del video)
    // Sirve para visualizar mejor la pila de llamadas
    static int factorialConVariable(int n) {
        int r;
        if (n == 0) {
            r = 1;                  // Caso base
        } else {
            r = n * factorialConVariable(n - 1);  // Caso general
        }
        return r;
    }

    // Suma recursiva de 1 hasta n
    static int sumaRecursiva(int n) {
        if (n == 1) {
            return 1;               // Caso base
        } else {
            return n + sumaRecursiva(n - 1);  // Caso general
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
