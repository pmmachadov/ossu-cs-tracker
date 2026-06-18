class Video_4_18_Copiar_Clonar_Arrays {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-18 JAVA: Copiar y clonar Arrays DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=AXcdQEt_LEs&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=83";
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
          RESUMEN RAPIDO - COPIAR Y CLONAR ARRAYS (TEMA 4 - V18)
        ====================================================================

        --- ARRAYS SON OBJETOS ---
        En Java, los arrays son OBJETOS. Al asignarlos, se copia la
        REFERENCIA (direccion de memoria), NO los datos.

        int[] nums = {1, 2, 3, 4, 5};
        int[] copia = nums;    // NO es una copia independiente
        copia[0] = 0;          // MODIFICA TAMBIEN nums!

        --- COPIA POR REFERENCIA ---
        int[] original = {1, 2, 3};
        int[] ref = original;   // ref y original apuntan al MISMO objeto
        ref[0] = 99;            // original[0] tambien es 99

        --- CLONADO (COPIA INDEPENDIENTE) ---
        Todos los objetos en Java tienen el metodo clone().
        Crea una copia exacta pero en OTRA direccion de memoria.

        int[] original = {1, 2, 3, 4, 5};
        int[] clon = original.clone();  // COPIA INDEPENDIENTE
        clon[0] = 0;                    // SOLO modifica clon
        // original sigue siendo {1, 2, 3, 4, 5}

        --- ARRAYS.COPYOF() ---
        static int[] copyOf(int[] original, int newLength)
        int[] copia = Arrays.copyOf(original, original.length);

        --- ARRAYS.COPYOFRANGE() ---
        static int[] copyOfRange(int[] original, int from, int to)
        int[] copia = Arrays.copyOfRange(original, 1, 4);  // indices 1,2,3

        --- SYSTEM.ARRAYCOPY() ---
        static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        int[] origen = {1, 2, 3, 4, 5};
        int[] destino = new int[5];
        System.arraycopy(origen, 0, destino, 0, 5);  // copia todo

        System.arraycopy(origen, 1, destino, 3, 3);  // desde indice 1, copia 3 elem en pos 3

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. COPIA POR REFERENCIA:
           - int[] b = a;  -> b y a son el MISMO array.
           - Modificar b[0] modifica tambien a[0].
           - Se usa el mismo espacio de memoria.

        2. CLONADO (clone()):
           - int[] b = a.clone();  -> b es COPIA INDEPENDIENTE.
           - Modificar b[0] NO afecta a a[0].
           - Ocupa un espacio de memoria distinto.

        3. ARRAYS.COPYOF():
           - Crea un nuevo array copiando los elementos.
           - Se puede especificar una longitud distinta.
           - Si newLength > original -> rellena con valores por defecto.

        4. SYSTEM.ARRAYCOPY():
           - Metodo mas potente: copia PARTE de un array.
           - Parametros: (src, srcPos, dest, destPos, length)
           - El array destino DEBE existir y tener espacio suficiente.
           - No crea el array destino, solo copia datos.

        5. ERRORES TIPICOS:
           - Pensar que int[] b = a hace una copia independiente.
           - No importar java.util.Arrays (para copyOf).
           - ArrayIndexOutOfBounds en arraycopy si destino no tiene espacio.
           - Olvidar que clone() devuelve Object (hay que hacer cast con arrays de objetos).
           - Confundir Arrays.copyOf() con System.arraycopy().

        6. TRUCOS RAPIDOS:
           - clone() y copyOf() son equivalentes para copiar arrays completos.
           - System.arraycopy() para copiar rangos dentro de arrays existentes.
           - Arrays.copyOfRange() para crear nuevo array con un rango.
           - Los arrays de tipos primitivos se clonan sin cast.
           - Para saber si dos arrays son el mismo objeto: if (a == b)

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
        // EJEMPLO 1: Copia por referencia
        // ============================================================
        separador("EJEMPLO 1: Copia por referencia");
        int[] nums = {1, 2, 3, 4, 5};
        int[] copiaRef = nums;
        System.out.println("  nums:      " + java.util.Arrays.toString(nums));
        System.out.println("  copiaRef = nums (misma referencia)");
        copiaRef[0] = 0;
        System.out.println("  copiaRef[0] = 0:");
        System.out.println("  nums:      " + java.util.Arrays.toString(nums));
        System.out.println("  copiaRef:  " + java.util.Arrays.toString(copiaRef));
        System.out.println("  Son el mismo objeto? " + (nums == copiaRef));
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Clonado (copia independiente)
        // ============================================================
        separador("EJEMPLO 2: Clonado con clone()");
        int[] primos = {2, 3, 5, 7, 11, 13, 17, 19, 23};
        int[] copiaClon = primos.clone();
        System.out.println("  primos (original): " + java.util.Arrays.toString(primos));
        copiaClon[0] = 0;  // Modificamos solo el clon
        System.out.println("  copiaClon[0] = 0 (solo afecta al clon):");
        System.out.println("  primos:             " + java.util.Arrays.toString(primos));
        System.out.println("  copiaClon:          " + java.util.Arrays.toString(copiaClon));
        System.out.println("  Son el mismo objeto? " + (primos == copiaClon));
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Arrays.copyOf()
        // ============================================================
        separador("EJEMPLO 3: Arrays.copyOf()");
        int[] original = {10, 20, 30, 40, 50};
        int[] copiaCompleta = java.util.Arrays.copyOf(original, original.length);
        int[] copiaMasCorta = java.util.Arrays.copyOf(original, 3);
        int[] copiaMasLarga = java.util.Arrays.copyOf(original, 7);
        System.out.println("  original:       " + java.util.Arrays.toString(original));
        System.out.println("  copyOf(len=5):  " + java.util.Arrays.toString(copiaCompleta));
        System.out.println("  copyOf(len=3):  " + java.util.Arrays.toString(copiaMasCorta));
        System.out.println("  copyOf(len=7):  " + java.util.Arrays.toString(copiaMasLarga));
        System.out.println();

        // ============================================================
        // EJEMPLO 4: System.arraycopy()
        // ============================================================
        separador("EJEMPLO 4: System.arraycopy()");
        int[] src = {1, 2, 3, 4, 5, 6, 7};
        int[] dest = new int[7];
        System.arraycopy(src, 0, dest, 0, 7);
        System.out.println("  Copia completa con arraycopy:");
        System.out.println("  src:  " + java.util.Arrays.toString(src));
        System.out.println("  dest: " + java.util.Arrays.toString(dest));

        // Copiar parte: desde indice 1 de src, 3 elementos, en pos 3 de dest
        int[] src2 = {1, 2, 3, 4, 5, 6, 7};
        int[] dest2 = new int[7];
        System.arraycopy(src2, 1, dest2, 3, 3);
        System.out.println("  Copia parcial (src[1..3] -> dest[3..5]):");
        System.out.println("  src2:  " + java.util.Arrays.toString(src2));
        System.out.println("  dest2: " + java.util.Arrays.toString(dest2));
        System.out.println();

        // ============================================================
        // EJEMPLO 5: Mostrar direcciones de memoria
        // ============================================================
        separador("EJEMPLO 5: Direcciones de memoria");
        System.out.println("  primos (original):  " + primos);
        System.out.println("  copiaClon:           " + copiaClon);
        System.out.println("  copiaRef:            " + copiaRef);
        System.out.println("  (primos y copiaRef apuntan al mismo espacio)");
        System.out.println();

        // ============================================================
        // COMPARACION
        // ============================================================
        separador("COMPARACION DE RESULTADOS");
        System.out.println("Copia referencia:  mismo objeto, modificar uno afecta al otro");
        System.out.println("Clone():           copia independiente, distinto espacio memoria");
        System.out.println("Arrays.copyOf():   copia con longitud opcional");
        System.out.println("System.arraycopy(): copia parte de un array en otro existente");

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
