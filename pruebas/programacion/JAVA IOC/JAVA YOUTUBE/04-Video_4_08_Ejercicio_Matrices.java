class Video_4_08_Ejercicio_Matrices {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-08 JAVA: Ejercicio matrices ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=TuoUO2Nd4tA&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=73";
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
          RESUMEN RAPIDO - EJERCICIO MATRICES: DIAGONAL (TEMA 4 - V8)
        ====================================================================

        --- ENUNCIADO ---
        Crear una matriz NxN de enteros.
        Imprimir una X en la diagonal principal y un guion en el resto.

        --- METODO 1: crearMatriz(int n) ---
        static int[][] crearMatriz(int n) {
            int[][] m = new int[n][n];
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    if (i == j) {
                        m[i][j] = 1;  // X
                    } else {
                        m[i][j] = 0;  // guion
                    }
                }
            }
            return m;
        }

        - La matriz se rellena con 0 (guion) y 1 (X).
        - Diagonal principal: i == j.

        --- METODO 2: imprimirMatriz(int[][] m) con for-each ---
        static void imprimirMatriz(int[][] m) {
            for (int[] fila : m) {
                for (int columna : fila) {
                    if (columna == 1) {
                        System.out.print("X ");
                    } else {
                        System.out.print("- ");
                    }
                }
                System.out.println();
            }
        }

        --- METODO 3: imprimirMatrizInvertida (diagonal inversa) ---
        La X aparece al final de la primera fila y al inicio de la ultima.

        Version con for clasico (recorriendo de derecha a izquierda):
        for (int i = 0; i < m.length; i++) {
            for (int j = m[i].length - 1; j >= 0; j--) {
                if (m[i][j] == 1) System.out.print("X ");
                else System.out.print("- ");
            }
            System.out.println();
        }

        Version con for-each SIN indices (acumulando en String):
        for (int[] fila : m) {
            String linea = "";
            for (int columna : fila) {
                if (columna == 1) linea = "X " + linea;
                else linea = "- " + linea;
            }
            System.out.println(linea);
        }

        --- TRUCO: invertir sin indices ---
        En lugar de recorrer al reves, se va acumulando AL PRINCIPIO
        de la String: linea = "X " + linea;  (en vez de linea += "X ")

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. DIAGONAL PRINCIPAL:
           - i == j  (fila y columna iguales)
           - Recorrido normal: de izquierda a derecha.

        2. DIAGONAL INVERSA (opcional):
           - i + j == n - 1 (para cuando pidan la otra diagonal)
           - O simplemente recorrer de derecha a izquierda.

        3. MATRIZ DE ENTEROS:
           - Aunque visualmente sea X y -, internamente son int (0 y 1).
           - Luego al imprimir se convierte 1 -> "X", 0 -> "-".

        4. RECORRER AL REVES CON FOR:
           - Inicializar j = m[i].length - 1
           - Condicion: j >= 0
           - Decremento: j--

        5. INVERTIR CON FOR-EACH (truco):
           - linea = "X " + linea;  // pone al principio
           - linea = "- " + linea;
           - Al final, linea tiene la fila invertida.

        6. ERRORES TIPICOS:
           - Confundir m[i][j] con m[j][i] (acceder traspuesto).
           - Usar m.length para todo (columnas usa m[i].length).
           - Olvidar que for-each es solo lectura (aqui vale porque solo leemos).
           - Inicializar la String fuera del bucle externo (se acumulan filas).

        7. TRUCOS RAPIDOS:
           - Una sola linea: imprimirMatriz(crearMatriz(4));
           - Para N=4, indices validos: 0..3 en filas y columnas.
           - Diagonal inversa con indices: i + j == n - 1.

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

        int n = 4;

        // ============================================================
        // EJEMPLO 1: Matriz normal (diagonal principal)
        // ============================================================

        separador("EJEMPLO 1: Matriz NxN (N=" + n + ") - Diagonal principal");
        System.out.println("  X en la diagonal, - en el resto:");
        imprimirMatriz(crearMatriz(n));
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Matriz invertida (for clasico)
        // ============================================================

        separador("EJEMPLO 2: Matriz invertida (for clasico)");
        System.out.println("  Recorriendo de derecha a izquierda:");
        imprimirMatrizInvertida(crearMatriz(n));
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Matriz invertida (for-each sin indices)
        // ============================================================

        separador("EJEMPLO 3: Matriz invertida (for-each, sin indices)");
        System.out.println("  Acumulando en String al principio:");
        imprimirMatrizInvertida2(crearMatriz(n));
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Distintos tamanos
        // ============================================================

        separador("EJEMPLO 4: Matriz N=6");
        System.out.println("  Diagonal principal (N=6):");
        imprimirMatriz(crearMatriz(6));
        System.out.println();

        System.out.println("  Diagonal invertida (N=6):");
        imprimirMatrizInvertida(crearMatriz(6));
        System.out.println();

        // ============================================================
        // COMPARACION DE RESULTADOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");
        System.out.println("Ej 1: Diagonal principal (N=4)   -> X en i==j");
        System.out.println("Ej 2: Diagonal invertida (for)   -> X al final de cada fila");
        System.out.println("Ej 3: Diagonal invertida (foreach) -> igual, sin indices");
        System.out.println("Ej 4: N=6                        -> funciona para cualquier N");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODO 1: Crear matriz NxN con X en diagonal (1) y guion (0)
    // -------------------------------------------------------------
    static int[][] crearMatriz(int n) {
        int[][] m = new int[n][n];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i == j) {
                    m[i][j] = 1;  // X
                } else {
                    m[i][j] = 0;  // guion
                }
            }
        }
        return m;
    }

    // -------------------------------------------------------------
    // METODO 2: Imprimir matriz (for-each)
    // -------------------------------------------------------------
    static void imprimirMatriz(int[][] m) {
        for (int[] fila : m) {
            for (int columna : fila) {
                if (columna == 1) {
                    System.out.print("X ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    // -------------------------------------------------------------
    // METODO 3: Imprimir matriz invertida (for clasico, derecha a izq)
    // -------------------------------------------------------------
    static void imprimirMatrizInvertida(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = m[i].length - 1; j >= 0; j--) {
                if (m[i][j] == 1) {
                    System.out.print("X ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    // -------------------------------------------------------------
    // METODO 4: Imprimir matriz invertida (for-each, SIN indices)
    // -------------------------------------------------------------
    static void imprimirMatrizInvertida2(int[][] m) {
        for (int[] fila : m) {
            String linea = "";
            for (int columna : fila) {
                if (columna == 1) {
                    linea = "X " + linea;     // acumula al PRINCIPIO
                } else {
                    linea = "- " + linea;
                }
            }
            System.out.println(linea);
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
