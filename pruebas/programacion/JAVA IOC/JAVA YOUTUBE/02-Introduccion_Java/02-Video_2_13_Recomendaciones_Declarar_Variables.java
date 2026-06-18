class Video_2_13_Recomendaciones_Declarar_Variables {

    public static final String TITULO = "2-13 JAVA: Recomendaciones al declarar variables ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=5EaHrvmoLEk&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=29";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-13 RECOMENDACIONES AL DECLARAR VARIABLES
        ================================================================

        --- 1. BUENA ELECCION DEL NOMBRE DE VARIABLE ---

        Elegir identificadores significativos mejora la legibilidad.

        MAL:   int a = 3; int b = 5; int c = a * b;  // area?
        BIEN:  int base = 3; int altura = 5; int area = base * altura;

        --- REGLAS BASICAS ---

        * Nombres SIGNIFICATIVOS (que describan lo que almacenan)
        * Primera letra en MINUSCULA (las mayusculas son para clases/objetos)
        * Variables: camelCase o snake_case (a gusto personal)
        * Constantes: TODO_MAYUSCULAS con guion bajo

        --- EJEMPLOS NO RECOMENDADOS ---

        int CANTIDAD = 3;
        // TODO en mayusculas -> parece una constante, no una variable

        String Canal = "Aula en la nube";
        // Primera letra mayuscula -> parece una clase

        String nombrecompleto = "Pepe Martinez";
        // No diferencia donde empieza la 2a palabra

        String j = "Jose Perez";
        // 'j' no identifica lo que guarda

        --- FORMA RECOMENDADA ---

        int cantidad         = 3;
        String canal         = "Aula en la nube";
        String nombreCompleto = "Pepe Martinez";  // camelCase
        String nombre_completo = "Pepe Martinez"; // snake_case
        String nombrePersona  = "Jose Perez";

        ================================================================
          2. CONSTANTES EN JAVA (final)
        ================================================================

        Las constantes son valores fijos que NO se pueden modificar
        durante la ejecucion del programa.

        Se declaran con la palabra reservada 'final' ANTES del tipo:

        final float PI = 3.14f;
        // PI no podra cambiar de valor nunca

        final String NOMBRE_CANAL = "Aula en la nube";
        // Tampoco se puede modificar

        --- CONVENCION ---

        Las constantes se escriben SIEMPRE EN MAYUSCULAS.
        Si tienen mas de una palabra, se separan con guion bajo.

        final int IVA = 21;
        final double GRAVEDAD = 9.81;
        final String NOMBRE_EMPRESA = "MiEmpresa";

        ================================================================
          3. VALORES POR DEFECTO DE VARIABLES
        ================================================================

        Cuando se declara una variable SIN asignarle valor,
        Java le asigna internamente un valor por defecto.

        Tipo        Valor por defecto
        ----        -----------------
        byte        0
        short       0
        int         0
        long        0L
        float       0.0f
        double      0.0d
        char        '\\u0000' (caracter nulo)
        boolean     false
        String      null (objeto nulo)

        IMPORTANTE:
        Aunque Java asigne valor por defecto, NO se puede usar
        una variable local sin inicializar (da error de compilacion).
        Los valores por defecto SOLO se aplican en arrays, atributos
        de clase, etc.

        ================================================================
          4. COMENTARIOS EN JAVA
        ================================================================

        Los comentarios NO se ejecutan, solo son informativos.
        Sirven para explicar el codigo a otras personas o a uno mismo.

        --- TIPOS DE COMENTARIOS ---

        1. Comentario de una linea:  //

           // Esto es un comentario de una linea
           int x = 5;  // comentario al final de la linea

        2. Comentario multilinea:  /* ... */

           /* Esto es un comentario
              que ocupa varias lineas
              y termina aqui */

        3. Comentario de documentacion (JavaDoc):  /** ... */

           /** Este comentario genera documentacion automatica
            *  con la herramienta javadoc.
            *  @param x descripcion del parametro
            *  @return descripcion del valor devuelto
            */
           public int metodo(int x) { ... }

        --- RECOMENDACIONES SOBRE COMENTARIOS ---

        * Al aprender: usar muchos comentarios (esta bien al principio)
        * Avanzando: evitar abusar, el codigo debe explicarse solo
        * Buen codigo: se entiende SIN comentarios
        * Comentar metodos, NO cada linea
        * Usar JavaDoc para documentar clases y metodos publicos

        ================================================================
          REGLAS GENERALES DE BUENAS PRACTICAS
        ================================================================

        * Elegir nombres descriptivos (aunque sean largos)
        * Primera letra de variable en MINUSCULA
        * Constantes en MAYUSCULAS con guion bajo
        * camelCase para variables con varias palabras
        * No repetir nombres de variables
        * Inicializar variables antes de usarlas
        * Codigo legible sin necesidad de comentarios
        * Usar comentarios solo cuando sea necesario
        ================================================================
        """;

    public static void main(String[] args) {
        // ============================================================
        //   INFORMACION DEL VIDEO
        // ============================================================
        System.out.println();
        System.out.println("============================================");
        System.out.println("   INFORMACION DEL VIDEO");
        System.out.println("============================================");
        System.out.println("Video:      " + TITULO);
        System.out.println("Canal:      " + CANAL);
        System.out.println("URL Canal:  " + URL_CANAL);
        System.out.println("URL Video:  " + URL);
        System.out.println("Playlist:   " + PLAYLIST);
        System.out.println("Repo:       " + REPO);
        System.out.println();

        // ============================================================
        //   VARIABLES MAL DECLARADAS (ejemplos del video)
        // ============================================================
        System.out.println("============================================");
        System.out.println("   EJEMPLOS: MALAS PRACTICAS");
        System.out.println("============================================");
        System.out.println();

        // MAL: mayusculas -> parece constante
        // int CANTIDAD = 3;

        // MAL: primera letra mayuscula -> parece clase
        // String Canal = "Aula en la nube";

        // MAL: sin separacion entre palabras
        // String nombrecompleto = "Pepe Martinez";

        // MAL: nombre poco descriptivo
        // String j = "Jose Perez";

        System.out.println("  int CANTIDAD = 3;          // MAL: parece constante");
        System.out.println("  String Canal = \"...\";     // MAL: parece clase");
        System.out.println("  String nombrecompleto      // MAL: sin separacion");
        System.out.println("  String j = \"Jose\";        // MAL: no descriptivo");
        System.out.println();

        // ============================================================
        //   VARIABLES BIEN DECLARADAS
        // ============================================================
        System.out.println("============================================");
        System.out.println("   EJEMPLOS: BUENAS PRACTICAS");
        System.out.println("============================================");
        System.out.println();

        int cantidad = 3;
        String canal = "Aula en la nube";
        String nombreCompleto = "Pepe Martinez";   // camelCase
        String nombre_completo = "Pepe Martinez";  // snake_case
        String nombrePersona = "Jose Perez";

        System.out.println("  int cantidad = 3;");
        System.out.println("  String canal = \"Aula en la nube\";");
        System.out.println("  String nombreCompleto = \"Pepe Martinez\";  // camelCase");
        System.out.println("  String nombrePersona = \"Jose Perez\";");
        System.out.println();

        // ============================================================
        //   CONSTANTES (final)
        // ============================================================
        System.out.println("============================================");
        System.out.println("   CONSTANTES (final)");
        System.out.println("============================================");
        System.out.println();

        final float PI = 3.14f;
        final String NOMBRE_CANAL = "Aula en la nube";
        final int IVA = 21;
        final double GRAVEDAD = 9.81;

        System.out.println("  final float  PI          = 3.14f;");
        System.out.println("  final String NOMBRE_CANAL = \"Aula en la nube\";");
        System.out.println("  final int    IVA         = 21;");
        System.out.println("  final double GRAVEDAD    = 9.81;");
        System.out.println();

        // Si intentamos modificar una constante, da ERROR:
        // PI = 3.1416f;  // ERROR: cannot assign a value to final variable

        // ============================================================
        //   VALORES POR DEFECTO
        // ============================================================
        System.out.println("============================================");
        System.out.println("   VALORES POR DEFECTO");
        System.out.println("============================================");
        System.out.println();

        System.out.println("  Tipo        Valor por defecto");
        System.out.println("  ----        -----------------");
        System.out.println("  byte        0");
        System.out.println("  short       0");
        System.out.println("  int         0");
        System.out.println("  long        0L");
        System.out.println("  float       0.0f");
        System.out.println("  double      0.0d");
        System.out.println("  char        '\\u0000' (caracter nulo)");
        System.out.println("  boolean     false");
        System.out.println("  String      null");
        System.out.println();

        // ============================================================
        //   COMENTARIOS EN JAVA
        // ============================================================
        System.out.println("============================================");
        System.out.println("   TIPOS DE COMENTARIOS");
        System.out.println("============================================");
        System.out.println();

        // Esto es un comentario de una linea (usando //)

        /* Esto es un comentario
           multilinea. Todo lo que
           este aqui dentro no se ejecuta */

        /**
         * Este es un comentario de documentacion (JavaDoc).
         * Sirve para generar documentacion automatica con javadoc.
         */

        System.out.println("  1. // comentario de una linea");
        System.out.println("  2. /* ... */ comentario multilinea");
        System.out.println("  3. /** ... */ comentario JavaDoc");
        System.out.println();

        // ============================================================
        //   MOSTRAR RESUMEN
        // ============================================================
        System.out.println("============================================");
        System.out.println("   RESUMEN DEL VIDEO");
        System.out.println("============================================");
        System.out.println();
        System.out.println(RESUMEN);
    }
}
