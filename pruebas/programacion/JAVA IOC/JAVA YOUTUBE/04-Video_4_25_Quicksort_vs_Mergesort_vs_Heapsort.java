import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;

class Video_4_25_Quicksort_vs_Mergesort_vs_Heapsort {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-25 JAVA: Quicksort vs Mergesort vs Heapsort DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=lIoJOxoUA3Y&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=91";
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
          RESUMEN RAPIDO - QUICKSORT vs MERGESORT vs HEAPSORT (TEMA 4 - V25)
        ====================================================================

        --- LOS 3 ALGORITMOS ---
        Los tres tienen complejidad O(n log n) en el caso promedio.
        Pero en la PRACTICA, Quicksort suele ser el mas rapido.

        --- QUICKSORT ---
        - Complejidad promedio: O(n log n)
        - Peor caso: O(n^2) (muy improbable: array ordenado al reves)
        - NO necesita espacio adicional (ordena in situ)
        - Intercambia SOLO lo necesario -> pocos movimientos en memoria
        - MUY RAPIDO para arrays grandes
        - NO es estable (no mantiene orden relativo de iguales)
        - Tiene version recursiva e iterativa

        --- HEAPSORT ---
        - Complejidad: O(n log n) en TODOS los casos
        - NO necesita espacio adicional (ordena in situ)
        - Hace INTERCAMBIOS aunque el array ya este ordenado
        - LIGERAMENTE superior a Quicksort para arrays MUY pequenos (<=100)
        - Para arrays grandes, peor que Quicksort (mas swaps)
        - NO es estable

        --- MERGESORT ---
        - Complejidad: O(n log n) en TODOS los casos
        - SI necesita espacio adicional (crea arrays auxiliares)
        - El que MAS accesos a memoria hace (escribe en array auxiliar
          y luego vuelve a escribir en el original)
        - Es ESTABLE: mantiene el orden relativo de elementos iguales
        - Bueno cuando importa la estabilidad
        - En la practica, suele ser el mas lento de los tres

        --- RESULTADOS DE LAS PRUEBAS (del video) ---

        Arrays MUY pequenos (10 elementos, 10M arrays):
          Quicksort ~ 1.8s  |  Heapsort ~ 1.5s  |  Mergesort ~ 4.0s
          -> Heapsort ligeramente superior

        Arrays pequenos (100 elementos, 1M arrays):
          Quicksort ~ 28ms  |  Heapsort ~ 26ms  |  Mergesort ~ 70ms
          -> Heapsort ligeramente superior

        Arrays medianos (10.000 elementos, 1K arrays):
          Quicksort ~ 572ms  |  Heapsort ~ 866ms  |  Mergesort ~ 1.1s
          -> Quicksort empieza a distanciarse

        Arrays grandes (100.000 elementos, 100 arrays):
          Quicksort ~ 7s  |  Heapsort ~ 8.5s  |  Mergesort ~ 10.5s

        Arrays muy grandes (1.000.000 elementos, 10 arrays):
          Quicksort ~ 8.3s  |  Heapsort ~ 11s  |  Mergesort ~ 11s

        Arrays enormes (10.000.000 elementos, 1 array):
          Quicksort ~ 9.5s  |  Heapsort ~ 20s  |  Mergesort ~ 14s

        --- CONSEJOS PARA EL EXAMEN ---

        1. COMPLEJIDAD TEORICA vs PRACTICA:
           - Los 3 tienen O(n log n) en teoria.
           - Pero Quicksort es mas rapido en la practica.
           - Motivo: hace MENOS INTERCAMBIOS en memoria.
           - Intercambiar en memoria es MUY costoso.

        2. SECRETO DE QUICKSORT:
           - Solo intercambia cuando es necesario.
           - Heapsort y Mergesort mueven elementos aunque ya esten ordenados.
           - Por eso Quicksort gana aunque tenga O(n^2) en el peor caso.

        3. PRUEBAS EN EL VIDEO:
           - Se usa Instant.now() y Duration.between() para medir nanosegundos.
           - Los arrays son CLONADOS para que todos ordenen los mismos datos.
           - DecimalFormat(\"#,###\") para formatear numeros grandes con separadores.

        4. CUANDO USAR CADA UNO:
           - Quicksort: casi siempre (arrays grandes/medianos).
           - Heapsort: arrays MUY pequenos (<= 100 elementos).
           - Mergesort: cuando se necesita ESTABILIDAD.
           - Tambien Mergesort es bueno para ordenar datos enlazados (listas).

        5. QUICKSORT ITERATIVO vs RECURSIVO:
           - El iterativo usa una pila (Stack) en lugar de recursion.
           - En la practica, el recursivo suele ser mas rapido.
           - El iterativo evita el riesgo de StackOverflow con arrays enormes.

        6. GENERADOR DEL VIDEO:
           - GeneradorArrays.generarArray(int elementos)
           - Crea array con enteros entre 0 y elementos-1.
           - Se importa del paquete aulaenlanube.tema4.generadores.

        ====================================================================
        """;

    // -------------------------------------------------------------
    // METODO: test de rendimiento
    // -------------------------------------------------------------
    static void test(int cantidadPruebas, int elementosArray) {

        int[] array1, array2, array3;
        long tiempoQuicksort = 0, tiempoHeapsort = 0, tiempoMergesort = 0;
        Instant inicio, fin;

        for (int i = 0; i < cantidadPruebas; i++) {

            array1 = generarArray(elementosArray, elementosArray);
            array2 = array1.clone();
            array3 = array1.clone();

            // quicksort
            inicio = Instant.now();
            quicksort(array1, 0, array1.length - 1);
            fin = Instant.now();
            tiempoQuicksort += Duration.between(inicio, fin).toNanos();

            // heapsort
            inicio = Instant.now();
            heapSort(array2);
            fin = Instant.now();
            tiempoHeapsort += Duration.between(inicio, fin).toNanos();

            // mergesort
            inicio = Instant.now();
            mergeSort(array3, 0, array3.length - 1);
            fin = Instant.now();
            tiempoMergesort += Duration.between(inicio, fin).toNanos();
        }

        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("  Duracion total de quicksort  en ordenar " + df.format(cantidadPruebas)
            + " Arrays de " + df.format(elementosArray) + " elementos: "
            + (tiempoQuicksort / 1_000_000) + "ms");
        System.out.println("  Duracion total de heapsort   en ordenar " + df.format(cantidadPruebas)
            + " Arrays de " + df.format(elementosArray) + " elementos: "
            + (tiempoHeapsort / 1_000_000) + "ms");
        System.out.println("  Duracion total de mergesort  en ordenar " + df.format(cantidadPruebas)
            + " Arrays de " + df.format(elementosArray) + " elementos: "
            + (tiempoMergesort / 1_000_000) + "ms");
    }

    // -------------------------------------------------------------
    // METODO: Quicksort (recursivo)
    // -------------------------------------------------------------
    static void quicksort(int A[], int izq, int der) {
        int pivote = A[izq];
        int i = izq;
        int j = der;
        int aux;

        while (i < j) {
            while (A[i] <= pivote && i < j)
                i++;
            while (A[j] > pivote)
                j--;
            if (i < j) {
                aux = A[i];
                A[i] = A[j];
                A[j] = aux;
            }
        }
        A[izq] = A[j];
        A[j] = pivote;
        if (izq < j - 1)
            quicksort(A, izq, j - 1);
        if (j + 1 < der)
            quicksort(A, j + 1, der);
    }

    // -------------------------------------------------------------
    // METODO: Heapsort
    // -------------------------------------------------------------
    static void heapSort(int[] array) {
        buildMaxHeap(array);

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i);
        }
    }

    static void buildMaxHeap(int[] array) {
        int firstNonLeaf = (array.length - 1) / 2;
        for (int i = firstNonLeaf; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }
    }

    static void adjustHeap(int[] array, int root, int heapSize) {
        int leftChild = 2 * root + 1;
        if (leftChild < heapSize) {
            int rightChild = 2 * root + 2;
            if (rightChild < heapSize) {
                if (array[rightChild] > array[leftChild]) {
                    leftChild = rightChild;
                }
            }
            if (array[leftChild] > array[root]) {
                swap(array, root, leftChild);
                adjustHeap(array, leftChild, heapSize);
            }
        }
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // -------------------------------------------------------------
    // METODO: Mergesort
    // -------------------------------------------------------------
    static void mergeSort(int[] list, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int mid = (start + end) / 2;
        int[] left = java.util.Arrays.copyOfRange(list, start, mid);
        int[] right = java.util.Arrays.copyOfRange(list, mid, end);

        mergeSort(left, 0, left.length);
        mergeSort(right, 0, right.length);

        int i = 0, j = 0, k = start;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                list[k] = left[i];
                i++;
            } else {
                list[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            list[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            list[k] = right[j];
            j++;
            k++;
        }
    }

    // -------------------------------------------------------------
    // METODO AUXILIAR: generar array aleatorio
    // -------------------------------------------------------------
    static int[] generarArray(int elementos, int numMax) {
        java.util.Random r = new java.util.Random();
        int[] array = new int[elementos];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(numMax + 1);
        }
        return array;
    }

    // -------------------------------------------------------------
    // METODO PRINCIPAL
    // -------------------------------------------------------------
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("COMPLEJIDAD DE LOS 3 ALGORITMOS: O(n log n) en promedio");
        System.out.println("Quicksort peor caso O(n^2) - muy improbable");
        System.out.println();

        // Pequenas pruebas para no saturar (ajusta segun tu PC)
        // ============================================================
        // PRUEBA 1: Arrays muy pequenos (10 elementos)
        // ============================================================
        separador("PRUEBA 1: 10.000 arrays de 10 elementos");
        test(10_000, 10);
        System.out.println();

        // ============================================================
        // PRUEBA 2: Arrays pequenos (100 elementos)
        // ============================================================
        separador("PRUEBA 2: 1.000 arrays de 100 elementos");
        test(1_000, 100);
        System.out.println();

        // ============================================================
        // PRUEBA 3: Arrays medianos (1.000 elementos)
        // ============================================================
        separador("PRUEBA 3: 100 arrays de 1.000 elementos");
        test(100, 1_000);
        System.out.println();

        // ============================================================
        // PRUEBA 4: Arrays grandes (10.000 elementos)
        // ============================================================
        separador("PRUEBA 4: 10 arrays de 10.000 elementos");
        test(10, 10_000);
        System.out.println();

        // ============================================================
        // PRUEBA 5: Arrays muy grandes (100.000 elementos)
        // ============================================================
        separador("PRUEBA 5: 1 array de 100.000 elementos");
        test(1, 100_000);
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 4 - V25: QUICKSORT vs MERGESORT vs HEAPSORT)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("CONCLUSIONES DEL VIDEO:");
        System.out.println("- Quicksort gana en casi todos los casos (arrays grandes)");
        System.out.println("- Heapsort ligeramente mejor SOLO para arrays <= 100 elementos");
        System.out.println("- Mergesort util cuando se necesita ESTABILIDAD");
        System.out.println("- Secreto de Quicksort: intercambia SOLO lo necesario");
        System.out.println("- Heapsort y Mergesort mueven muchos mas elementos en memoria");
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
