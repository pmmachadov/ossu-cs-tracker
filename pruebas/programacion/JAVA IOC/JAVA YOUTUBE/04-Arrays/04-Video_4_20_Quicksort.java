class Video_4_20_Quicksort {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-20 JAVA: Quicksort DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=Xx84_1aWV60&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=85";
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
          RESUMEN RAPIDO - QUICKSORT (TEMA 4 - V20)
        ====================================================================

        --- ALGORITMO QUICKSORT ---
        Algoritmo de ordenacion mas rapido en promedio (O(n log n)).
        Usa la estrategia DIVIDE Y VENCERAS (recursivo).

        --- COMO FUNCIONA ---
        1. Elegir un PIVOTE (normalmente el primer elemento).
        2. Colocar a la izquierda del pivote los MENORES que el.
        3. Colocar a la derecha del pivote los MAYORES que el.
        4. El pivote queda en su posicion definitiva.
        5. Aplicar el mismo proceso a las sublistas izquierda y derecha.

        --- CODIGO ---
        static void quicksort(int[] arr, int izq, int der) {
            int pivote = arr[izq];
            int i = izq, j = der, aux;

            while (i < j) {
                while (arr[i] <= pivote && i < j) i++;
                while (arr[j] > pivote) j--;
                if (i < j) {
                    aux = arr[i];
                    arr[i] = arr[j];
                    arr[j] = aux;
                }
            }

            arr[izq] = arr[j];
            arr[j] = pivote;

            if (izq < j - 1) quicksort(arr, izq, j - 1);
            if (j + 1 < der) quicksort(arr, j + 1, der);
        }

        --- COMPLEJIDAD ---
        - Mejor caso: O(n log n) - pivote en el centro.
        - Caso promedio: O(n log n).
        - Peor caso: O(n^2) - pivote en un extremo (muy raro).
        - MUCHO mas rapido que burbuja (1000x para arrays grandes).

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. RECURSIVIDAD:
           - Quicksort se llama a si mismo para las sublistas.
           - Caso base: sublista con 0 o 1 elementos (no entra en if).

        2. BUCLE WHILE PRINCIPAL:
           - while (i < j) -> mientras no se crucen los indices.
           - i busca MAYOR que pivote (desde izquierda).
           - j busca MENOR o IGUAL que pivote (desde derecha).

        3. INTERCAMBIO:
           - Cuando i < j: intercambiar arr[i] y arr[j].
           - Variable auxiliar para no perder el valor.

        4. COLOCAR PIVOTE:
           - arr[izq] = arr[j];   (mover el ultimo menor al inicio)
           - arr[j] = pivote;      (colocar pivote en su sitio)

        5. ERRORES TIPICOS:
           - No usar variable auxiliar en el intercambio.
           - Olvidar que modifica el array original.
           - Bucle infinito si no se actualizan i o j.
           - No proteger contra ArrayIndexOutOfBounds.
           - Confundir la condicion de los while internos.

        6. TRUCOS RAPIDOS:
           - pivote = arr[izq] (primero elemento).
           - i sube buscando mayores, j baja buscando menores.
           - Cuando i >= j, colocar pivote en posicion j.
           - Llamadas recursivas: (izq, j-1) y (j+1, der).
           - Para arrays ordenados al reves -> peor caso O(n^2).

        ====================================================================
        """;
    // -------------------------------------------------------------
    // METODO QUICKSORT
    // -------------------------------------------------------------
    static void quicksort(int[] arr, int izq, int der) {
        int pivote = arr[izq];
        int i = izq, j = der, aux;

        while (i < j) {
            while (arr[i] <= pivote && i < j) i++;
            while (arr[j] > pivote) j--;

            if (i < j) {
                aux = arr[i];
                arr[i] = arr[j];
                arr[j] = aux;
            }
        }

        arr[izq] = arr[j];
        arr[j] = pivote;

        if (izq < j - 1) quicksort(arr, izq, j - 1);
        if (j + 1 < der) quicksort(arr, j + 1, der);
    }

    // -------------------------------------------------------------
    // BURBUJA (para comparacion de rendimiento)
    // -------------------------------------------------------------
    static void burbuja(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length - i - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    int aux = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = aux;
                }
            }
        }
    }

    // -------------------------------------------------------------
    // GENERAR ARRAY ALEATORIO
    // -------------------------------------------------------------
    static int[] generarArray(int elementos) {
        java.util.Random r = new java.util.Random();
        int[] arr = new int[elementos];
        for (int i = 0; i < elementos; i++) {
            arr[i] = r.nextInt(elementos);
        }
        return arr;
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
        // EJEMPLO 1: Quicksort basico
        // ============================================================
        separador("EJEMPLO 1: Quicksort en array pequeno");
        int[] arr1 = {4, 7, 5, 6, 2, 3, 1, 9, 8};
        System.out.println("  Original: " + java.util.Arrays.toString(arr1));
        quicksort(arr1, 0, arr1.length - 1);
        System.out.println("  Ordenado: " + java.util.Arrays.toString(arr1));
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Array grande aleatorio
        // ============================================================
        separador("EJEMPLO 2: Array aleatorio de 20 elementos");
        int[] arr2 = generarArray(20);
        System.out.println("  Original: " + java.util.Arrays.toString(arr2));
        quicksort(arr2, 0, arr2.length - 1);
        System.out.println("  Ordenado: " + java.util.Arrays.toString(arr2));
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Comparacion de rendimiento
        // ============================================================
        separador("EJEMPLO 3: Burbuja vs Quicksort (100000 elem)");
        int tamano = 100000;
        int[] arrBurbuja = generarArray(tamano);
        int[] arrQuick = arrBurbuja.clone();

        // Medir burbuja
        java.time.Instant inicio = java.time.Instant.now();
        burbuja(arrBurbuja);
        java.time.Instant fin = java.time.Instant.now();
        long tiempoBurbuja = java.time.Duration.between(inicio, fin).toMillis();

        // Medir quicksort
        inicio = java.time.Instant.now();
        quicksort(arrQuick, 0, arrQuick.length - 1);
        fin = java.time.Instant.now();
        long tiempoQuick = java.time.Duration.between(inicio, fin).toMillis();

        System.out.println("  Tiempo Burbuja:  " + tiempoBurbuja + " ms");
        System.out.println("  Tiempo Quicksort: " + tiempoQuick + " ms");
        if (tiempoBurbuja > 0 && tiempoQuick > 0) {
            System.out.println("  Quicksort es " + (tiempoBurbuja / Math.max(tiempoQuick, 1)) + "x mas rapido!");
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Peor caso (array ordenado al reves)
        // ============================================================
        separador("EJEMPLO 4: Peor caso (orden inverso con 50000)");
        int[] arrPeor = new int[50000];
        for (int i = 0; i < arrPeor.length; i++) arrPeor[i] = arrPeor.length - i;
        int[] arrPeorQuick = arrPeor.clone();

        inicio = java.time.Instant.now();
        burbuja(arrPeor);
        fin = java.time.Instant.now();
        long tBurbuja = java.time.Duration.between(inicio, fin).toMillis();

        inicio = java.time.Instant.now();
        quicksort(arrPeorQuick, 0, arrPeorQuick.length - 1);
        fin = java.time.Instant.now();
        long tQuick = java.time.Duration.between(inicio, fin).toMillis();

        System.out.println("  Tiempo Burbuja:  " + tBurbuja + " ms");
        System.out.println("  Tiempo Quicksort: " + tQuick + " ms");
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 4 - COMPLETADO)");
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
