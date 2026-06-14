class Video_4_07_Arrays_Foreach {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-07 JAVA: Arrays con foreach ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=Yiywcodl-w0&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=72";
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
          RESUMEN RAPIDO - ARRAYS CON FOREACH (TEMA 4 - V7)
        ====================================================================

        --- SINTAXIS BASICA (for-each o for mejorado) ---
        for (tipo variable : array) {
            // usar variable (contiene el elemento actual)
        }

        Ejemplo con array de enteros:
          int[] numeros = {1, 4, 5, 6, 7, 3, 2, 8};
          for (int n : numeros) {
              System.out.print(n + " ");
          }
          // Imprime: 1 4 5 6 7 3 2 8

        --- CARACTERISTICAS DEL FOR-EACH ---
        - No necesitas indice, condicion ni incremento.
        - Automaticamente recorre TODOS los elementos.
        - La variable toma el valor de cada elemento en cada iteracion.
        - Solo lectura: NO puedes modificar el array original.
        - Termina cuando se acaban los elementos.

        --- ARRAYS.TOSTRING() ---
        import java.util.Arrays;
        System.out.println(Arrays.toString(array));
        // Formato: [elem1, elem2, elem3, ...]

        --- FOR-EACH EN MATRICES (2D) ---
        int[][] matriz = {{1,4,5}, {6,7,8}, {3,8}};

        // Opcion 1: dos for-each anidados
        for (int[] fila : matriz) {
            for (int columna : fila) {
                System.out.print(columna + " ");
            }
            System.out.println();
        }

        // Opcion 2: for-each + Arrays.toString()
        for (int[] fila : matriz) {
            System.out.println(Arrays.toString(fila));
        }

        --- ARRAYS.DEEPTOSSTRING() PARA MATRICES ---
        System.out.println(Arrays.deepToString(matriz));
        // Formato: [[elem1, elem2], [elem3, elem4], ...]
        // Imprime TODOS los elementos de la matriz en una sola linea.

        --- COMPARATIVA: for clasico vs for-each ---
        for (int i = 0; i < arr.length; i++) {   // for clasico
            System.out.println(arr[i]);           // TIENE indice
        }

        for (int n : arr) {                       // for-each
            System.out.println(n);                // NO tiene indice
        }

        --- CUANDO USAR CADA UNO ---
        USAR for-each cuando:
        - Solo necesitas LEER los elementos.
        - Quieres codigo mas limpio y corto.
        - No necesitas el indice.

        USAR for clasico cuando:
        - Necesitas MODIFICAR elementos del array.
        - Necesitas el INDICE (i) para algo.
        - Solo quieres recorrer una PARTE del array.

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. FOR-EACH:
           - Sintaxis: for (Tipo var : array)
           - NO lleva punto y coma tras los parentesis.
           - La variable NO es el indice, es el VALOR del elemento.
           - NO puedes modificar el array original con for-each.
           - No sabes en que indice estas (no tienes i).

        2. ARRAYS.TOSTRING():
           - Importar: import java.util.Arrays;
           - Devuelve String con formato [e1, e2, e3]
           - Solo para arrays de 1 dimension.
           - Para matrices usa Arrays.deepToString().

        3. MATRICES CON FOR-EACH:
           - El for-each externo da filas (int[] fila).
           - El for-each interno da columnas (int columna).
           - O usa Arrays.toString(fila) en el externo.

        4. ERRORES TIPICOS:
           - Escribir for (int n : array) { n = 5; } -> NO modifica el array.
           - Usar Arrays.toString() en matriz -> imprime [[I@...] (referencias).
           - Olvidar import java.util.Arrays.
           - Poner punto y coma tras el for-each: for (int n : arr); -> bucle vacio.

        5. TRUCOS RAPIDOS:
           - Arrays.toString() para imprimir arrays rapidamente.
           - Arrays.deepToString() para imprimir matrices.
           - For-each es SOLO LECTURA.
           - Si necesitas el indice, usa for clasico.

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
        // EJEMPLO 1: For-each en array de 1 dimension
        // ============================================================

        separador("EJEMPLO 1: For-each en array simple");
        int[] array = {1, 4, 5, 6, 7, 3, 2, 8};
        System.out.print("  for (int n : array) -> ");
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Arrays.toString()
        // ============================================================

        separador("EJEMPLO 2: Arrays.toString()");
        int[] numeros = {10, 20, 30, 40};
        System.out.println("  Arrays.toString(numeros) = " + java.util.Arrays.toString(numeros));
        System.out.println();

        // ============================================================
        // EJEMPLO 3: For-each en matriz (dos for-each anidados)
        // ============================================================

        separador("EJEMPLO 3: For-each en matriz (anidados)");
        int[][] matriz = {{1, 4, 5}, {6, 7, 8}, {3, 8}};
        System.out.println("  Matriz:");
        for (int[] fila : matriz) {
            System.out.print("    ");
            for (int columna : fila) {
                System.out.print(columna + " ");
            }
            System.out.println();
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 4: For-each + Arrays.toString() en matriz
        // ============================================================

        separador("EJEMPLO 4: For-each + Arrays.toString(fila)");
        System.out.println("  Matriz por filas:");
        for (int[] fila : matriz) {
            System.out.println("    " + java.util.Arrays.toString(fila));
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 5: Arrays.deepToString()
        // ============================================================

        separador("EJEMPLO 5: Arrays.deepToString()");
        System.out.println("  deepToString(matriz) = " + java.util.Arrays.deepToString(matriz));
        System.out.println();

        // ============================================================
        // DEMO: For-each NO permite modificar
        // ============================================================

        separador("DEMO: For-each NO modifica el array original");
        int[] original = {1, 2, 3};
        System.out.println("  Array original: " + java.util.Arrays.toString(original));
        for (int n : original) {
            n = 99;  // Esto NO modifica el array
        }
        System.out.println("  Despues de for-each (n = 99): " + java.util.Arrays.toString(original));
        System.out.println("  (El array NO cambio porque n es una copia)");
        System.out.println();

        // ============================================================
        // COMPARACION DE RESULTADOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");
        System.out.println("Ej 1: For-each simple              -> " + java.util.Arrays.toString(array));
        System.out.println("Ej 2: Arrays.toString()            -> " + java.util.Arrays.toString(numeros));
        System.out.println("Ej 3: For-each anidados            -> cada fila en una linea");
        System.out.println("Ej 4: For-each + toString(fila)    -> " + java.util.Arrays.deepToString(matriz));
        System.out.println("Ej 5: Arrays.deepToString()        -> " + java.util.Arrays.deepToString(matriz));
        System.out.println("Demo: Modificar con for-each       -> NO funciona (solo lectura)");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("============================================================");
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
