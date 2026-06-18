class Video_2_04_Salida_Pantalla_Java {

    public static final String TITULO = "2-4 Salida por pantalla en Java (System.out)";
    public static final String URL = "https://www.youtube.com/watch?v=QRDePHN91UY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=20";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-4 SALIDA POR PANTALLA EN JAVA (System.out)
        ================================================================

        --- METODOS DE SALIDA ---

        System.out.print("texto");      -> imprime SIN salto de linea
        System.out.println("texto");    -> imprime CON salto de linea

        System.out.println("Hola");
        System.out.println("Mundo");
        Salida:
          Hola
          Mundo

        System.out.print("Hola ");
        System.out.print("Mundo");
        Salida:
          Hola Mundo

        --- CONCATENACION CON + ---

        Se usa el operador + para unir textos y variables:

        int resultado = 20;
        System.out.println("El resultado es " + resultado);
        Salida: El resultado es 20

        --- IMPORTANTE: ESPACIOS ---

        Los espacios NO se anaden automaticamente:
        System.out.println("El resultado es" + resultado);
        Salida: El resultado es20

        Si quiero espacio: "El resultado es " (con espacio antes de comillas)

        --- SUMA vs CONCATENACION ---

        int n = 20;
        System.out.println("El resultado es " + n + 5);
        // Lee de izquierda a derecha: hay texto -> todo es texto
        // Salida: El resultado es 205

        System.out.println("El resultado es " + (n + 5));
        // Parentesis primero: n+5 = 25 (suma numerica)
        // Salida: El resultado es 25

        --- OPERACIONES CON VARIABLES ---

        int n = 20, m = 10;

        System.out.println(n + m);
        // Sin texto: suma numerica -> 30

        System.out.println("" + n + m);
        // Hay texto vacio -> concatenacion -> 2010

        System.out.println(n + m + ".");
        // Primero suma (n+m=30), luego concatena con "." -> 30.

        System.out.println("" + n + m + ".");
        // Texto vacio primero -> concatenacion -> 2010.

        --- ATAJO EN VS CODE ---

        Escribir: sout  + Tab
        Se autocompleta: System.out.println();

        --- FORMATEAR CODIGO (indentacion) ---

        En VS Code: Alt + Shift + F
        Para ordenar las llaves y tabulaciones automaticamente.

        --- EJEMPLOS PRACTICOS ---

        class EjemploSalida {
            public static void main(String[] args) {
                int n = 20;
                int m = 10;

                System.out.println("n = " + n);
                System.out.println("m = " + m);
                System.out.println("n + m = " + (n + m));
                System.out.print("Sin salto de linea... ");
                System.out.println("y esto continua en la misma linea");
            }
        }

        Salida:
          n = 20
          m = 10
          n + m = 30
          Sin salto de linea... y esto continua en la misma linea

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * System.out.print()  -> imprime sin salto de linea
        * System.out.println() -> imprime con salto de linea
        * Concatenacion con + -> une texto y variables
        * Si hay texto antes, todo se trata como texto (concatenacion)
        * Parentesis ( ) fuerzan la operacion numerica antes de concatenar
        * Los espacios hay que ponerlos explicitamente
        * sout + Tab en VS Code autocompleta System.out.println()
        * Alt+Shift+F formatea el codigo automaticamente
        ================================================================
        """;

    public static void main(String[] args) {
        mostrarInformacion();
    }

    public static void mostrarInformacion() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("   INFORMACION DEL VIDEO");
        System.out.println("============================================");
        System.out.println("Video:      " + TITULO);
        System.out.println("Canal:      " + CANAL);
        System.out.println("URL Canal:  " + URL_CANAL);
        System.out.println("URL Video:  " + URL);
        System.out.println("Playlist:   " + PLAYLIST);
        System.out.println();
        System.out.println(RESUMEN);
    }
}
