class Video_3_11_TrianguloRecursivo {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "3-11 JAVA: Triangulo recursivo ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=EWj58e5NxjI&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=64";
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
          RESUMEN RAPIDO - TRIANGULO RECURSIVO (TEMA 3 - V11)
        ====================================================================

        --- ENUNCIADO ---
        Dibujar un triangulo rectangulo de asteriscos usando un metodo
        recursivo (sin bucles for/while).

        Solucion 1: metodo tree(int a, int b, int n) con 3 parametros.
        Solucion 2 (MEJOR): dos metodos, triangulo(int n) y
        filaTriangulo(int n), la pila crece menos.

        --- SOLUCION 1: tree(a, b, n) ---
        Simula un bucle for doble con recursividad:
        - a = contador de fila (altura actual)
        - b = contador de columna (base actual)
        - n = altura total del triangulo

        Codigo:
          static void tree(int a, int b, int n) {
              if (a > b) {
                  System.out.print("*");
                  tree(a, b + 1, n);     // Siguiente columna
              } else {
                  System.out.println();    // Salto de linea
                  if (n > a + 1) {
                      tree(a + 1, 0, n); // Siguiente fila
                  }
              }
          }

        Llamada inicial: tree(0, 0, 3)

        TRAZA tree(0,0,3):
          (0,0,3): else -> println, n>0+1? si -> tree(1,0,3)
          (1,0,3): if(1>0) -> print *, tree(1,1,3)
          (1,1,3): else -> println, n>1+1? si -> tree(2,0,3)
          (2,0,3): if(2>0) -> print *, tree(2,1,3)
          (2,1,3): if(2>1) -> print *, tree(2,2,3)
          (2,2,3): else -> println, n>2+1? si -> tree(3,0,3)
          (3,0,3): if(3>0) -> print *, tree(3,1,3)
          (3,1,3): if(3>1) -> print *, tree(3,2,3)
          (3,2,3): if(3>2) -> print *, tree(3,3,3)
          (3,3,3): else -> println, n>3+1? NO -> FIN

        Pila maxima: 10 llamadas (para altura 3).

        --- SOLUCION 2 (MEJOR): triangulo(n) + filaTriangulo(n) ---
        Separa en dos metodos recursivos:
        - triangulo(n): controla las FILAS (se llama a si mismo con n-1)
        - filaTriangulo(n): controla las COLUMNAS (imprime asteriscos)

        Codigo:
          static void triangulo(int n) {
              if (n > 0) {
                  triangulo(n - 1);       // Primero filas anteriores
                  filaTriangulo(n);       // Luego imprime esta fila
              }
          }

          static void filaTriangulo(int n) {
              if (n > 0) {
                  System.out.print("*");
                  filaTriangulo(n - 1);  // Siguiente columna
              } else {
                  System.out.println();   // Salto de linea
              }
          }

        Llamada inicial: triangulo(3)

        TRAZA triangulo(3):
          triangulo(3) --> triangulo(2) --> triangulo(1) --> triangulo(0)
          (caso base n=0, no hace nada, retorna)

          triangulo(1): filaTriangulo(1)
            -> print *, filaTriangulo(0) -> println

          triangulo(2): filaTriangulo(2)
            -> print *, filaTriangulo(1) -> print *, filaTriangulo(0) -> println

          triangulo(3): filaTriangulo(3)
            -> print *, fT(2) -> print *, fT(1) -> print *, fT(0) -> println

        Pila maxima: 6 llamadas (para altura 3) - mucho mejor!

        --- COMPARACION ---
        Solucion 1 (tree): pila = 10 llamadas para altura 3.
        Solucion 2 (triangulo+fila): pila = 6 llamadas para altura 3.
        Para altura 10, la diferencia es enorme!

        La solucion 2 es mejor porque las llamadas a filaTriangulo
        se resuelven y desapilan antes de pasar a la siguiente fila.

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * La recursion puede simular bucles for anidados.
        * Se usan PARAMETROS como contadores (a=filas, b=columnas).
        * Caso base: cuando se completa la fila o se llega a la altura.
        * Dos estrategias: un metodo con 3 params vs dos metodos.
        * La solucion con DOS metodos es mas eficiente (menos pila).
        * La recursion consume memoria RAM (pila de llamadas).
        * Menos llamadas anidadas -> menos memoria -> mejor rendimiento.

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
        // SOLUCION 1: Metodo tree(a, b, n) - 3 parametros
        // ============================================================

        separador("SOLUCION 1: tree(a, b, n) - triangulo recursivo con 3 params");
        System.out.println("  tree(0, 0, 3):");
        System.out.println();
        tree(0, 0, 3);
        System.out.println();

        // ============================================================
        // SOLUCION 2: triangulo(n) + filaTriangulo(n) - MAS EFICIENTE
        // ============================================================

        separador("SOLUCION 2: triangulo(3) + filaTriangulo(n) - MAS EFICIENTE");
        System.out.println("  triangulo(3):");
        System.out.println();
        triangulo(3);
        System.out.println();

        // ============================================================
        // DEMO: Ambas soluciones con diferentes alturas
        // ============================================================

        separador("COMPARACION: tree(0,0,5) vs triangulo(5)");

        System.out.println("  tree(0,0,5) - triangulo altura 5:");
        tree(0, 0, 5);
        System.out.println();

        System.out.println("  triangulo(5) - triangulo altura 5 (MAS EFICIENTE):");
        triangulo(5);
        System.out.println();

        // ============================================================
        // TRAZA DETALLADA DE tree(0,0,3)
        // ============================================================

        separador("TRAZA: Pila de llamadas de tree(0,0,3)");
        System.out.println("  APILADO (orden de llamadas):");
        System.out.println("    1. tree(0,0,3) -> println() -> tree(1,0,3)");
        System.out.println("    2. tree(1,0,3) -> print(*) -> tree(1,1,3)");
        System.out.println("    3. tree(1,1,3) -> println() -> tree(2,0,3)");
        System.out.println("    4. tree(2,0,3) -> print(*) -> tree(2,1,3)");
        System.out.println("    5. tree(2,1,3) -> print(*) -> tree(2,2,3)");
        System.out.println("    6. tree(2,2,3) -> println() -> tree(3,0,3)");
        System.out.println("    7. tree(3,0,3) -> print(*) -> tree(3,1,3)");
        System.out.println("    8. tree(3,1,3) -> print(*) -> tree(3,2,3)");
        System.out.println("    9. tree(3,2,3) -> print(*) -> tree(3,3,3)");
        System.out.println("   10. tree(3,3,3) -> println() -> FIN");
        System.out.println("  Pila maxima: 10 niveles");
        System.out.println();

        // ============================================================
        // TRAZA DETALLADA DE triangulo(3)
        // ============================================================

        separador("TRAZA: Pila de llamadas de triangulo(3) + filaTriangulo(n)");
        System.out.println("  APILADO:");
        System.out.println("    triangulo(3) -> triangulo(2) -> triangulo(1) -> triangulo(0) [base]");
        System.out.println("  DESAPILADO (resolviendo):");
        System.out.println("    triangulo(0): fin -> desapila");
        System.out.println("    triangulo(1): filaTriangulo(1) -> print(*) -> fT(0) -> println()");
        System.out.println("    triangulo(2): filaTriangulo(2) -> print(*) -> fT(1) -> print(*) -> fT(0) -> println()");
        System.out.println("    triangulo(3): filaTriangulo(3) -> print(*) -> fT(2) -> print(*) -> fT(1) -> print(*) -> fT(0) -> println()");
        System.out.println("  Pila maxima: 6 niveles (vs 10 de tree)");
        System.out.println();

        // ============================================================
        // COMPARACION DE RESULTADOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Sol 1: tree(0,0,3)      -> triangulo de altura 3 (10 llamadas en pila)");
        System.out.println("Sol 2: triangulo(3)     -> triangulo de altura 3 (6 llamadas en pila)");
        System.out.println("Sol 1: tree(0,0,5)      -> triangulo de altura 5");
        System.out.println("Sol 2: triangulo(5)     -> triangulo de altura 5");
        System.out.println();
        System.out.println("  La solucion 2 es MAS EFICIENTE: menos llamadas anidadas,");
        System.out.println("  menor uso de la pila, mejor para alturas grandes.");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Ejercicios de recursion en Java");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // SOLUCION 1: tree(a, b, n) - 3 parametros
    // Simula bucle for doble con parametros recursivos
    // -------------------------------------------------------------

    static void tree(int a, int b, int n) {
        if (a > b) {
            System.out.print("*");
            tree(a, b + 1, n);      // Siguiente columna (imprime asteriscos)
        } else {
            System.out.println();    // Salto de linea
            if (n > a + 1) {
                tree(a + 1, 0, n);  // Siguiente fila (cambia de fila)
            }
        }
    }

    // -------------------------------------------------------------
    // SOLUCION 2: triangulo(n) + filaTriangulo(n)
    // MAS EFICIENTE: separa el control de filas y columnas
    // -------------------------------------------------------------

    // triangulo: controla las FILAS. Se llama recursivamente con n-1
    // y luego imprime la fila actual con filaTriangulo
    static void triangulo(int n) {
        if (n > 0) {
            triangulo(n - 1);       // Primero resuelve filas anteriores
            filaTriangulo(n);       // Luego imprime la fila actual
        }
        // Caso base implicito: n == 0 -> no hace nada
    }

    // filaTriangulo: controla las COLUMNAS de una fila
    // Imprime '*' n veces, luego un salto de linea
    static void filaTriangulo(int n) {
        if (n > 0) {
            System.out.print("*");
            filaTriangulo(n - 1);   // Siguiente columna
        } else {
            System.out.println();    // Salto de linea al terminar la fila
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
