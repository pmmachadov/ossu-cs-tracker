class Video_4_15_String_Args {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-15 JAVA: El famoso String[] args DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=4Dnxv_dtfQ0&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=80";
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
          RESUMEN RAPIDO - STRING[] ARGS (TEMA 4 - V15)
        ====================================================================

        --- QUE ES String[] args ---
        Es el array de Strings que recibe el metodo main como parametro.
        Contiene los ARGUMENTOS pasados al programa desde la terminal.

        public static void main(String[] args) { ... }
        - public: accesible desde fuera
        - static: pertenece a la clase, no a una instancia
        - void: no devuelve nada
        - String[] args: array de Strings con los argumentos

        --- COMO SE PASA ---
        java NombreClase arg1 arg2 arg3
        - args[0] = "arg1"
        - args[1] = "arg2"
        - args.length = cantidad de argumentos

        --- EJEMPLO 1: Imprimir argumentos ---
        public static void main(String[] args) {
            System.out.print("Hola");
            for (int i = 0; i < args.length; i++) {
                System.out.print(" " + args[i]);
            }
            System.out.println(", ?Que tal estas?");
        }

        Si se ejecuta: java HolaMundo Pepe Garcia
        Salida: Hola Pepe Garcia, ?Que tal estas?

        --- EJEMPLO 2: Args con Integer.parseInt ---
        public static void main(String[] args) {
            if (args.length > 1) {
                int veces = Integer.parseInt(args[1]);
                for (int i = 0; i < veces; i++) {
                    System.out.println("Hola " + args[0]);
                }
            } else {
                System.out.println("Hola mundo simple");
            }
        }

        Si se ejecuta: java HolaMundo Pepe 3
        Salida: Hola Pepe (3 veces, cada una en una linea)

        --- PUNTOS CLAVE ---
        - args.length == 0 si no se pasan argumentos.
        - Los argumentos se separan por ESPACIOS.
        - Si un argumento tiene espacios, se pone entre comillas dobles.
        - args[0] es el PRIMER argumento despues del nombre de la clase.
        - Integer.parseInt(args[n]) convierte String a int (puede lanzar excepcion).

        ====================================================================

        --- CONSEJOS PARA EL EXAMEN ---

        1. SINTAXIS EQUIVALENTE:
           - String[] args   (mas comun)
           - String args[]   (tambien valido)

        2. COMPILACION Y EJECUCION:
           - Compilar: javac HolaMundo.java  -> genera HolaMundo.class
           - Ejecutar: java HolaMundo arg1 arg2
           - Los argumentos van DESPUES del nombre de la clase.

        3. ARGS.LENGTH:
           - Si no hay args -> args.length == 0
           - Siempre comprobar args.length antes de acceder a args[i].

        4. INTEGER.PARSEINT:
           - Convierte un String a int.
           - Si el String no es un numero -> NumberFormatException.
           - Ejemplo: Integer.parseInt("3") -> 3
           - Ejemplo: Integer.parseInt("Pepe") -> ERROR!

        5. ERRORES TIPICOS:
           - Acceder a args[0] sin comprobar args.length > 0.
           - NumberFormatException al intentar convertir texto a numero.
           - Poner los argumentos ANTES del nombre de la clase.
           - Olvidar recompilar tras cambios (java usa el .class, no el .java).

        6. TRUCOS RAPIDOS:
           - Usar args.length > 0 para saber si hay argumentos.
           - Usar fori para recorrer todos los argumentos.
           - Integer.parseInt() para convertir argumentos numericos.
           - Los argumentos SIEMPRE son Strings, aunque sean numeros.

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
        // EJEMPLO 1: Mostrar argumentos recibidos
        // ============================================================
        separador("EJEMPLO 1: Argumentos recibidos");
        System.out.println("  Cantidad de args: " + args.length);
        if (args.length > 0) {
            System.out.println("  Args recibidos:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("    args[" + i + "] = \"" + args[i] + "\"");
            }
        } else {
            System.out.println("  (No se recibieron argumentos)");
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Saludo personalizado con args
        // ============================================================
        separador("EJEMPLO 2: Saludo personalizado");
        System.out.print("  Hola");
        for (int i = 0; i < args.length; i++) {
            System.out.print(" " + args[i]);
        }
        System.out.println(", ?Que tal estas?");
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Si hay 2+ args, repetir mensaje N veces
        // ============================================================
        separador("EJEMPLO 3: Repetir con Integer.parseInt");
        if (args.length > 1) {
            try {
                int veces = Integer.parseInt(args[1]);
                System.out.println("  Repitiendo '\" + args[0] + "' \" + veces + \" veces:\");
                for (int i = 0; i < veces; i++) {
                    System.out.println("    Hola " + args[0]);
                }
            } catch (NumberFormatException e) {
                System.out.println("  ERROR: '\" + args[1] + "' no es un numero valido");
                System.out.println("  Uso: java Video_4_15_String_Args nombre numero");
            }
        } else {
            System.out.println("  Hola mundo simple (args.length <= 1)");
        }
        System.out.println();

        // ============================================================
        // DEMO: Explicacion de args
        // ============================================================
        separador("DEMO: Como pasar argumentos");
        System.out.println("  Para probar este programa con argumentos:");
        System.out.println("  1. Compilar: javac 04-Video_4_15_String_Args.java");
        System.out.println("  2. Ejecutar con args:");
        System.out.println("     java Video_4_15_String_Args Pepe 3");
        System.out.println("     java Video_4_15_String_Args Hola Mundo Java");
        System.out.println("     java Video_4_15_String_Args (sin args)");
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
