class Video_4_24_Ejercicio_Matriz_Transpuesta {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-24 JAVA: Matriz transpuesta DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=ZyGYo3pIylA&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=89";
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
          RESUMEN RAPIDO - MATRIZ TRANSPUESTA (TEMA 4 - V24)
        ====================================================================

        --- QUE ES LA TRANSPUESTA ---
        Intercambiar filas por columnas.
        Si A tiene dimensiones f x c, su transpuesta tiene c x f.

        Ejemplo:
        Original (2x3):  [3, 4, 9]    Transpuesta (3x2): [3, 6]
                         [6, 5, 0]                        [4, 5]
                                                           [9, 0]

        --- METODO ---
        static void mostrarMatrizTranspuesta(int[][] matriz)
        - Es void porque el enunciado pide MOSTRAR, no devolver.
        - Antes de transponer, VALIDA que la matriz sea regular.

        --- VALIDACION (matriz regular) ---
        for (int i = 0; i < matriz.length - 1; i++) {
            if (matriz[i].length != matriz[i + 1].length) {
                System.out.println("ERROR: No se puede obtener la transpuesta");
                System.out.println("La matriz no es valida");
                return;
            }
        }

        - Compara cada fila con la siguiente.
        - El bucle va hasta length-1 para no salirse del array.
        - Si alguna fila tiene distinto tamano -> error y return.

        --- CREAR LA MATRIZ TRANSPUESTA ---
        int columnas = (matriz.length == 0) ? 0 : matriz[0].length;
        int[][] transpuesta = new int[columnas][matriz.length];

        - Las FILAS de la transpuesta = COLUMNAS de la original
        - Las COLUMNAS de la transpuesta = FILAS de la original
        - Ternaria para evitar ArrayIndexOutOfBounds si matriz vacia.

        --- RELLENAR (indices invertidos) ---
        for (int i = 0; i < transpuesta.length; i++) {
            for (int j = 0; j < transpuesta[i].length; j++) {
                transpuesta[i][j] = matriz[j][i];
            }
            System.out.println(Arrays.toString(transpuesta[i]));
        }

        Clave: transpuesta[i][j] = matriz[j][i]
        - i = fila de transpuesta = columna de original
        - j = columna de transpuesta = fila de original
        - Se imprime cada fila justo despues de llenarla.

        --- CASOS ESPECIALES ---
        1. Matriz irregular: muestra error y sale con return.
        2. Matriz vacia (0 filas): ternaria asigna 0 columnas.
        3. Matriz 1x1: transpuesta = la misma matriz.

        --- CONSEJOS PARA EL EXAMEN ---

        1. EL METODO ES VOID, NO INT[][]:
           - El enunciado pide "mostrar" la transpuesta, no devolverla.
           - Si te preguntan la firma: static void mostrarMatrizTranspuesta(int[][] matriz)
           - Si en otro ejercicio pidieran devolverla, cambiarias el return type a int[][].
           - Pero para este ejercicio concreto: ES VOID.

        2. VALIDACION ANTES DE TRANSPONER:
           - Comprobar SIEMPRE que todas las filas tengan el mismo tamano.
           - Bucle: for (int i = 0; i < matriz.length - 1; i++)
           - El -1 es OBLIGATORIO para no salirse del array.
           - Si falla, System.out.println("ERROR") + return;
           - Si no validas y la matriz es irregular -> ArrayIndexOutOfBounds.

        3. DIMENSIONES INVERTIDAS:
           - transpuesta.length = matriz[0].length (nº de columnas de original)
           - transpuesta[0].length = matriz.length (nº de filas de original)
           - Ejemplo: matriz 2x3 -> transpuesta 3x2
           - Si te preguntan las dimensiones: new int[matriz[0].length][matriz.length]

        4. CLAVE DE LOS INDICES:
           - transpuesta[i][j] = matriz[j][i]
           - i (fila de transpuesta) va de 0 a matriz[0].length-1
           - j (columna de transpuesta) va de 0 a matriz.length-1
           - Es el tipico ejercicio de examen donde confunden indices.

        5. MATRIZ VACIA (0 filas):
           - matriz[0].length daria ArrayIndexOutOfBoundsException.
           - SOLUCION: ternaria (matriz.length == 0) ? 0 : matriz[0].length
           - Si la matriz esta vacia, transpuesta = new int[0][0].

        6. Arrays.toString DENTRO del bucle exterior, NO del interior:
           - Se imprime CADA FILA justo despues de rellenarla.
           - El print dentro del for de i (exterior), no dentro del for de j.
           - Asi sale cada fila completa en una linea.

        7. POSIBLE MEJORA (no obligatoria):
           - En el mensaje de error, poner un \\n al principio para separar
             visualmente la matriz original del mensaje de error.
           - System.out.println("\\nERROR: No se puede obtener la transpuesta");

        ====================================================================
        """;

    // -------------------------------------------------------------
    // METODO: mostrarMatrizTranspuesta
    // -------------------------------------------------------------
    static void mostrarMatrizTranspuesta(int[][] matriz) {

        // Validar que todas las filas tengan la misma cantidad de elementos
        // (matriz regular). Si no, no se puede transponer.
        for (int i = 0; i < matriz.length - 1; i++) {
            if (matriz[i].length != matriz[i + 1].length) {
                System.out.println("\nERROR: No se puede obtener la transpuesta");
                System.out.println("La matriz no es valida");
                return;
            }
        }

        // Crear la matriz transpuesta con las dimensiones invertidas.
        // Si la matriz esta vacia (0 filas), usamos 0 columnas.
        int columnas = (matriz.length == 0) ? 0 : matriz[0].length;
        int[][] transpuesta = new int[columnas][matriz.length];

        // Rellenar la transpuesta intercambiando indices:
        // transpuesta[fila][col] = matriz[col][fila]
        for (int i = 0; i < transpuesta.length; i++) {
            for (int j = 0; j < transpuesta[i].length; j++) {
                transpuesta[i][j] = matriz[j][i];
            }
            // Imprimir la fila completa nada mas terminarla
            System.out.println("  " + java.util.Arrays.toString(transpuesta[i]));
        }
    }

    // -------------------------------------------------------------
    // METODO AUXILIAR: mostrar matriz
    // -------------------------------------------------------------
    static void mostrarMatriz(int[][] matriz) {
        if (matriz.length == 0) {
            System.out.println("  [matriz vacia - 0 filas]");
            return;
        }
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("  F" + i + ": " + java.util.Arrays.toString(matriz[i]));
        }
    }

    // -------------------------------------------------------------
    // METODO PRINCIPAL
    // -------------------------------------------------------------
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: Matriz regular 3x2 (como en la presentacion)
        // ============================================================
        separador("EJEMPLO 1: Matriz regular 3 columnas x 2 filas (numMax=9)");
        int[][] nums = Video_4_22_Generador_Matrices.generarMatriz(3, 2, 9);
        System.out.println("  Matriz original (" + nums.length + " filas x " + nums[0].length + " col):");
        mostrarMatriz(nums);
        System.out.println();
        System.out.println("  Matriz transpuesta (" + nums[0].length + " filas x " + nums.length + " col):");
        mostrarMatrizTranspuesta(nums);
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Matriz mas grande 5x3
        // ============================================================
        separador("EJEMPLO 2: Matriz 5 columnas x 3 filas (numMax=99)");
        int[][] nums2 = Video_4_22_Generador_Matrices.generarMatriz(5, 3, 99);
        System.out.println("  Matriz original (" + nums2.length + " filas x " + nums2[0].length + " col):");
        mostrarMatriz(nums2);
        System.out.println();
        System.out.println("  Matriz transpuesta (" + nums2[0].length + " filas x " + nums2.length + " col):");
        mostrarMatrizTranspuesta(nums2);
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Matriz IRREGULAR (error)
        // ============================================================
        separador("EJEMPLO 3: Matriz irregular (deberia dar error)");
        int[][] irregular = {
            {3, 4, 9},
            {6, 5}
        };
        System.out.println("  Matriz original:");
        mostrarMatriz(irregular);
        System.out.println();
        System.out.println("  Intentando transponer...");
        mostrarMatrizTranspuesta(irregular);
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Matriz CUADRADA (1x1)
        // ============================================================
        separador("EJEMPLO 4: Matriz 1x1 (la transpuesta es si misma)");
        int[][] uno = {{42}};
        System.out.println("  Matriz original:");
        mostrarMatriz(uno);
        System.out.println();
        System.out.println("  Matriz transpuesta:");
        mostrarMatrizTranspuesta(uno);
        System.out.println();

        // ============================================================
        // EJEMPLO 5: Matriz VACIA (0 filas)
        // ============================================================
        separador("EJEMPLO 5: Matriz vacia (0 filas)");
        int[][] vacia = new int[0][];
        System.out.println("  Matriz original:");
        mostrarMatriz(vacia);
        System.out.println();
        System.out.println("  Matriz transpuesta:");
        mostrarMatrizTranspuesta(vacia);
        System.out.println();

        // ============================================================
        // EJEMPLO 6: Matriz 2x4 (comprobacion visual de columnas -> filas)
        // ============================================================
        separador("EJEMPLO 6: Matriz 4 columnas x 2 filas (numMax=20)");
        int[][] nums3 = Video_4_22_Generador_Matrices.generarMatriz(4, 2, 20);
        System.out.println("  Matriz original (" + nums3.length + " filas x " + nums3[0].length + " col):");
        mostrarMatriz(nums3);
        System.out.println();
        System.out.println("  Matriz transpuesta (" + nums3[0].length + " filas x " + nums3.length + " col):");
        System.out.println("  (La fila 0 de original -> columna 0 de transpuesta)");
        mostrarMatrizTranspuesta(nums3);
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 4 - V24: MATRIZ TRANSPUESTA)");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODO AUXILIAR
    // -------------------------------------------------------------
    public static void separador(String titulo) {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("  " + titulo);
        System.out.println("============================================================");
    }
}
