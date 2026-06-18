class Video_4_01_Arrays {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-01 JAVA: Arrays ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=9CQZ1HpXroc&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=66";
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
          RESUMEN RAPIDO - ARRAYS (TEMA 4 - V1)
        ====================================================================

        --- QUE ES UN ARRAY ---
        Coleccion de tamaño FIJO que contiene variables del MISMO TIPO.
        - El tamaño se fija al crearlo y NO se puede modificar.
        - Primer indice: 0
        - Ultimo indice: longitud - 1
        - Acceder a un indice fuera del rango -> ArrayIndexOutOfBoundsException

        --- DECLARACION E INICIALIZACION ---
        int[] notas = new int[8];  // Array de 8 enteros (valores por defecto: 0)
        int notas[] = new int[8];  // Otra forma (corchetes tras el nombre)

        Declarar sin inicializar:
          int[] notas;  // Solo declaracion
          notas = new int[8];  // Inicializacion posterior

        --- TIPOS DE ARRAYS ---
        int[] nums = new int[5];        // Enteros -> por defecto 0
        double[] vals = new double[3];  // Doubles -> por defecto 0.0
        boolean[] flags = new boolean[4]; // Booleanos -> por defecto false
        char[] letras = new char[6];    // Chars -> por defecto '\0' (nulo)
        String[] palabras = new String[3]; // Objetos -> por defecto null

        --- RECORRER UN ARRAY (bucle for tipico) ---
        int[] notas = new int[5];

        // Asignar valores
        for (int i = 0; i < notas.length; i++) {
            notas[i] = i * 2;  // notas = {0, 2, 4, 6, 8}
        }

        // Mostrar valores
        for (int i = 0; i < notas.length; i++) {
            System.out.println(notas[i]);
        }

        --- PROPIEDAD LENGTH ---
        notas.length -> devuelve el tamaño del array (numero de elementos).
        notas[notas.length - 1] -> ultimo elemento del array.

        --- VALORES POR DEFECTO ---
        int, short, byte, long -> 0
        float, double -> 0.0
        boolean -> false
        char -> '\0' (caracter nulo)
        Objetos (incluido String) -> null

        --- ERROR COMUN: ArrayIndexOutOfBoundsException ---
        int[] arr = new int[5];
        arr[5] = 10;  // ERROR! indices validos: 0..4

        --- CONCEPTOS CLAVE ---
        * Array = coleccion de tamaño fijo, mismo tipo.
        * Primer indice = 0.
        * Ultimo indice = array.length - 1.
        * array.length = numero de elementos.
        * Bucle for tipico: for (int i = 0; i < arr.length; i++)
        * ArrayIndexOutOfBoundsException si indice fuera de rango.
        * Valores por defecto si no se inicializan.
        * Se puede declarar sin inicializar (int[] arr;).

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
        // EJEMPLO 1: Declaracion, valores por defecto
        // ============================================================

        separador("EJEMPLO 1: Array de enteros - valores por defecto");
        int[] array = new int[10];
        System.out.println("  Array de 10 enteros SIN inicializar:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("    array[" + i + "] = " + array[i]);
        }
        System.out.println("  (Todos a 0, valor por defecto de int)");
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Asignar valores y mostrar
        // ============================================================

        separador("EJEMPLO 2: Asignar valores y mostrar");
        int[] notas = new int[5];
        for (int i = 0; i < notas.length; i++) {
            notas[i] = i * 2;  // 0, 2, 4, 6, 8
        }

        System.out.println("  notas[i] = i * 2  (para i=0..4):");
        for (int i = 0; i < notas.length; i++) {
            System.out.println("    notas[" + i + "] = " + notas[i]);
        }
        System.out.println("  notas.length = " + notas.length);
        System.out.println("  Ultimo elemento: notas[" + (notas.length - 1) + "] = " + notas[notas.length - 1]);
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Distintos tipos de arrays
        // ============================================================

        separador("EJEMPLO 3: Arrays de distintos tipos");
        int[] enteros = new int[3];
        double[] dobles = new double[3];
        boolean[] booleanos = new boolean[3];
        char[] caracteres = new char[3];
        String[] cadenas = new String[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("  enteros[" + i + "] = " + enteros[i]
                + " | dobles[" + i + "] = " + dobles[i]
                + " | booleanos[" + i + "] = " + booleanos[i]
                + " | caracteres[" + i + "] = '" + caracteres[i] + "'"
                + " | cadenas[" + i + "] = " + cadenas[i]);
        }
        System.out.println("  (Cada tipo tiene su valor por defecto)");
        System.out.println();

        // ============================================================
        // EJEMPLO 4: ArrayIndexOutOfBoundsException
        // ============================================================

        separador("EJEMPLO 4: ArrayIndexOutOfBoundsException (DEMO)");
        System.out.println("  int[] arr = new int[5];");
        System.out.println("  arr[5] = 10;  // ERROR! Indices validos: 0..4");
        System.out.println("  (Comentado para no romper la ejecucion)");
        System.out.println("  // arr[5] = 10; -> ArrayIndexOutOfBoundsException");
        System.out.println();

        // ============================================================
        // EJEMPLO 5: Declaracion con valores iniciales
        // ============================================================

        separador("EJEMPLO 5: Declaracion con valores iniciales");
        int[] valores = {10, 20, 30, 40, 50};
        System.out.println("  int[] valores = {10, 20, 30, 40, 50};");
        for (int i = 0; i < valores.length; i++) {
            System.out.println("    valores[" + i + "] = " + valores[i]);
        }
        System.out.println("  Longitud automatica: " + valores.length);
        System.out.println();

        // ============================================================
        // EJEMPLO 6: Recorrer con for-each
        // ============================================================

        separador("EJEMPLO 6: Bucle for-each (for mejorado)");
        System.out.print("  valores = { ");
        for (int v : valores) {
            System.out.print(v + " ");
        }
        System.out.println("}");
        System.out.println("  Sintaxis: for (tipo variable : array)");
        System.out.println("  No permite modificar elementos, solo leer.");
        System.out.println();

        // ============================================================
        // COMPARACION DE RESULTADOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ej 1: Array valores por defecto (int)     -> todos 0");
        System.out.println("Ej 2: notas[i] = i*2                     -> 0,2,4,6,8");
        System.out.println("Ej 3: Tipos: int=0, double=0.0, bool=fa" + "lse, char='\\0', String=null");
        System.out.println("Ej 4: ArrayIndexOutOfBoundsException     -> error si indice >= length");
        System.out.println("Ej 5: Inicializacion directa             -> valores dados");
        System.out.println("Ej 6: Bucle for-each                     -> solo lectura");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Ejercicios con arrays en Java");
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
