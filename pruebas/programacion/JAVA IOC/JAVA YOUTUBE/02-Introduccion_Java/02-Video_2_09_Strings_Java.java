class Video_2_09_Strings_Java {

    public static final String TITULO = "2-9 Strings en Java";
    public static final String URL = "https://www.youtube.com/watch?v=EAEVn9JKP9Q&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=25";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-9 STRINGS EN JAVA
        ================================================================

        Una String es una cadena de texto (bloque de caracteres).
        Puede tener 0 o mas caracteres.
        Siempre entre COMILLAS DOBLES.
        String NO es un tipo primitivo, es un OBJETO.

        --- DECLARACION BASICA ---

        String nombre = "Pepe";
        String apellido = "Martinez";
        String vacia = "";        // cadena vacia
        String espacio = " ";     // espacio en blanco

        --- CONCATENACION CON + ---

        String nombreCompleto = nombre + apellido;
        // "PepeMartinez" (sin espacio)

        String nombreCompleto2 = nombre + " " + apellido;
        // "Pepe Martinez" (con espacio)

        Se puede concatenar tantas veces como sea necesario.

        --- STRING + NUMEROS ---

        String nombre = "Pepe";
        int cantidad = 20;

        String frase = nombre + " tiene " + cantidad + " anos";
        // "Pepe tiene 20 anos"

        --- PELIGRO: CONCATENACION vs SUMA ---

        int cantidad = 20;

        "tiene " + cantidad + 5   -> "tiene 205" (concatena)
        "tiene " + (cantidad + 5) -> "tiene 25"  (suma, parentesis)

        15 + 5 + nombre    -> "20Pepe"   (primero suma 15+5, luego concatena)
        nombre + 15 + 5    -> "Pepe155"  (concatena todo)
        nombre + (15 + 5)  -> "Pepe20"   (primero suma parentesis)

        Resta sin parentesis: nombre + 15 - 5  -> ERROR (no se puede restar a String)
        (15 - 5) + nombre  -> "10Pepe"  (primero resta, luego concatena)

        --- PRIORIDAD DE OPERADORES ---

        *, / y % tienen prioridad sobre + (incluyendo concatenacion):

        "total es " + cantidad * precio
        // Primero se multiplica cantidad*precio, luego se concatena
        // Si cantidad=10, precio=50 -> "total es 500"

        "total es " + cantidad + precio
        // Concatena: "total es 1050"

        --- STRING CON DECIMALES ---

        int cantidad = 10;
        float num = 2.5f;

        "total es " + (cantidad + num)
        // 10 + 2.5 = 12.5 -> "total es 12.5"

        "total es " + (cantidad / 3)
        // Entero / entero = entero: 10/3 = 3 -> "total es 3"

        "total es " + (num / 3)
        // float / entero = float: 2.5/3 = 0.8333 -> "total es 0.8333"

        --- STRING CON OPERACION NUMERICA (error) ---

        String s = cantidad + precio;   // ERROR: resultado es entero, no String
        String s = "" + cantidad + precio;  // OK: "1050" (concatena con cadena vacia)
        String s = "" + (cantidad + precio); // OK: "60" (primero suma)

        --- DIFERENCIA float vs double ---

        float  -> precision de ~7 decimales
        double -> precision de ~16 decimales

        10 / 3 con int     -> 3
        10f / 3 con float  -> 3.3333333
        10.0 / 3 con double -> 3.3333333333333335

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * String se declara con comillas dobles " "
        * Concatenacion con +
        * Si hay texto antes, todo se concatena (no suma)
        * Parentesis ( ) fuerzan operacion numerica
        * *, /, % tienen prioridad sobre +
        * int / int = int (trunca decimales)
        * float / int = float
        * Para guardar resultado numerico en String, usar "" + (operacion)
        * String no es primitivo, es un objeto
        * No se puede restar a una String (error)
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
        System.out.println("Repo:       " + REPO);
        System.out.println();
        System.out.println(RESUMEN);
    }
}
