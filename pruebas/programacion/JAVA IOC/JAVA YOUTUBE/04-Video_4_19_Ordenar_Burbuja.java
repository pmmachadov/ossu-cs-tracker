class Video_4_19_Ordenar_Burbuja {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-19 JAVA: Ordenar Arrays - Burbuja DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=7qvFbFzmqBk&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=84";
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
          RESUMEN RAPIDO - ORDENAR ARRAYS: BURBUJA (TEMA 4 - V19)
        ====================================================================

        --- ALGORITMO DE LA BURBUJA (Bubble Sort) ---
        Compara pares de elementos ADYACENTES y los intercambia si estan
        en el orden incorrecto. El elemento mas grande "flota" hacia el final.

        --- CODIGO ---
        static int[] burbuja(int[] vector) {
            for (int i = 0; i < vector.length; i++) {
                for (int j = 0; j < vector.length - i - 1; j++) {
                    if (vector[j] > vector[j + 1]) {
                        int aux = vector[j];
                        vector[j] = vector[j + 1];
                        vector[j + 1] = aux;
                    }
                }
            }
            return vector;
        }

        --- EXPLICACION ---
        - Bucle EXTERNO (i): numero de pasadas. Tantos como elementos.
        - Bucle INTERNO (j): recorre y compara pares.
          Condicion: j < vector.length - i - 1
          * -1: porque comparamos j con j+1 (evitar salirnos)
          * -i: porque al final de cada pasada, el ultimo ya esta ordenado
        - If: si vector[j] > vector[j+1] -> intercambiar con variable auxiliar.

        --- PROCESO PASO A PASO ---
        Array inicial: {6, 5, 3, 1, 8, 7, 2, 4}

        Pasada 1: 6 y 5 -> cambian. 6 y 3 -> cambian. 6 y 1 -> cambian.
                  6 y 8 -> NO. 8 y 7 -> cambian. 8 y 2 -> cambian.
                  8 y 4 -> cambian. Resultado: 8 al final.

        Pasada 2: igual pero sin contar el ultimo (ya ordenado).
        ... asi hasta ordenar todo.

        --- COMPLEJIDAD ---
        - Peor caso: O(n^2) - array ordenado al reves.
        - Mejor caso: O(n) - array ya ordenado (con optimizacion).
        - No es eficiente para arrays grandes.

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. CONDICION DEL BUCLE INTERNO:
           - j < vector.length - i - 1
           - El -1 es por comparar j con j+1 (no salirnos del array).
           - El -i es porque los ultimos i elementos ya estan ordenados.

        2. INTERCAMBIO CON AUXILIAR:
           int aux = vector[j];
           vector[j] = vector[j + 1];
           vector[j + 1] = aux;
           - Si no guardas el valor en aux, lo pierdes al sobrescribir.

        3. ORDENACION ASCENDENTE O DESCENDENTE:
           - Ascendente (menor a mayor): if (vector[j] > vector[j+1])
           - Descendente (mayor a menor): if (vector[j] < vector[j+1])
           - Un solo cambio en la comparacion.

        4. OPTIMIZACION:
           - Si en una pasada no hay intercambios, el array ya esta ordenado.
           - Se puede anadir un boolean para salir antes.

        5. ERRORES TIPICOS:
           - ArrayIndexOutOfBounds por no poner -1 en el bucle interno.
           - No usar variable auxiliar y perder el valor al intercambiar.
           - Confundir el orden de la comparacion (> o <).
           - Olvidar que modifica el array original (se pasa por referencia).
           - Poner vector.length - i sin -1 (todavia puede salirse).

        6. TRUCOS RAPIDOS:
           - Burbuja = dos bucles for anidados + if + intercambio.
           - Si ordenas de menor a mayor, los grandes van a la derecha.
           - Para debug, imprime el array tras cada intercambio.
           - Para arrays ya ordenados, burbuja no hace intercambios.

        ====================================================================
        """;

    // -------------------------------------------------------------
    // METODO BURBUJA
    // -------------------------------------------------------------
    static int[] burbuja(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length - i - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    int aux = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = aux;
                }
            }
        }
        return vector;
    }

    // -------------------------------------------------------------
    // BURBUJA CON DEBUG (muestra cada cambio)
    // -------------------------------------------------------------
    static int[] burbujaDebug(int[] vector) {
        System.out.println("  INICIO: " + java.util.Arrays.toString(vector));
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length - i - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    int aux = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = aux;
                    System.out.println("  Cambio: " + java.util.Arrays.toString(vector));
                }
            }
        }
        return vector;
    }

    // -------------------------------------------------------------
    // BURBUJA DESCENDENTE (mayor a menor)
    // -------------------------------------------------------------
    static int[] burbujaDescendente(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length - i - 1; j++) {
                if (vector[j] < vector[j + 1]) {  // < en vez de >
                    int aux = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = aux;
                }
            }
        }
        return vector;
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
        // EJEMPLO 1: Array desordenado
        // ============================================================
        separador("EJEMPLO 1: Burbuja basica");
        int[] arr1 = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println("  Original: " + java.util.Arrays.toString(arr1));
        burbuja(arr1);
        System.out.println("  Ordenado: " + java.util.Arrays.toString(arr1));
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Burbuja descendente
        // ============================================================
        separador("EJEMPLO 2: Burbuja descendente");
        int[] arr2 = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println("  Original:    " + java.util.Arrays.toString(arr2));
        burbujaDescendente(arr2);
        System.out.println("  Descendente: " + java.util.Arrays.toString(arr2));
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Array ya ordenado
        // ============================================================
        separador("EJEMPLO 3: Array ya ordenado");
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        System.out.println("  Original: " + java.util.Arrays.toString(arr3));
        burbujaDebug(arr3);
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Peor caso (orden inverso)
        // ============================================================
        separador("EJEMPLO 4: Peor caso (orden inverso)");
        int[] arr4 = {6, 5, 4, 3, 2, 1};
        System.out.println("  Original: " + java.util.Arrays.toString(arr4));
        burbujaDebug(arr4);
        System.out.println();

        // ============================================================
        // EJEMPLO 5: Burbuja en String
        // ============================================================
        separador("EJEMPLO 5: Burbuja con Strings");
        String[] palabras = {"perro", "gato", "abeja", "delfin", "caballo"};
        System.out.println("  Original: " + java.util.Arrays.toString(palabras));
        for (int i = 0; i < palabras.length; i++) {
            for (int j = 0; j < palabras.length - i - 1; j++) {
                if (palabras[j].compareTo(palabras[j+1]) > 0) {
                    String aux = palabras[j];
                    palabras[j] = palabras[j+1];
                    palabras[j+1] = aux;
                }
            }
        }
        System.out.println("  Ordenado: " + java.util.Arrays.toString(palabras));
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
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
