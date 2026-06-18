class Video_2_11_Ejercicio_String_Funciones {

    public static final String TITULO = "2-11 JAVA: Ejercicio String y funciones ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=FNjyxclZmDQ&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=27";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-11 EJERCICIO: STRING Y FUNCIONES
        ================================================================

        Ejercicio de repaso de las funciones/métodos de String vistos
        en el video anterior.

        --- ENUNCIADO ---

        Dadas las siguientes declaraciones de variables, determina
        qué valor se guardará en cada una:

        String nombre = "Pepe";
        String apellidos = "Martinez Garcia";
        String nombreCompleto = nombre + apellidos;
        int longitud = nombre.length();
        int longitud2 = "245".length();
        char letra = apellidos.charAt(3);
        String cadena1 = nombreCompleto.substring(0, 4);
        String cadena2 = " Hola ".trim();
        String cadena3_bien = cadena1.substring(3, 4);
        String cadena3_vacia = cadena1.substring(3, 3);   // caso extra
        // String cadena3_error = cadena1.substring(4, 3); // ERROR
        String cadena4 = (cadena2 + cadena2).toLowerCase();
        int posicion1 = cadena4.indexOf("o");
        int posicion2 = cadena4.indexOf("hola");
        int posicion3 = cadena4.indexOf("Hola");

        ================================================================
          SOLUCION PASO A PASO
        ================================================================

        --- 1. String nombre = "Pepe" ---
        Contenido: "Pepe"

        --- 2. String apellidos = "Martinez Garcia" ---
        Contenido: "Martinez Garcia"

        --- 3. String nombreCompleto = nombre + apellidos ---
        nombre + apellidos -> "Pepe" + "Martinez Garcia"
        Resultado: "PepeMartinez Garcia"
        (Sin espacio entre nombre y apellidos:
         ultima letra de nombre = 'e', primera de apellidos = 'M')

        --- 4. int longitud = nombre.length() ---
        "Pepe".length() -> 4 caracteres
        Resultado: 4
        (length() empieza desde 1, a diferencia de charAt que empieza en 0)

        --- 5. int longitud2 = "245".length() ---
        "245" es un literal String con 3 caracteres ('2','4','5')
        Resultado: 3

        --- 6. char letra = apellidos.charAt(3) ---
        apellidos = "Martinez Garcia"
        Indices (charAt empieza en 0):
          0 -> M
          1 -> a
          2 -> r
          3 -> t  <-- este
          4 -> i
          ...
        Resultado: 't'

        --- 7. String cadena1 = nombreCompleto.substring(0, 4) ---
        nombreCompleto = "PepeMartinez Garcia"
        substring(0, 4): desde indice 0 hasta 4 (sin incluir 4)
          0 -> P
          1 -> e
          2 -> p
          3 -> e
          4 -> M (NO incluido)
        Resultado: "Pepe"

        --- 8. String cadena2 = " Hola ".trim() ---
        " Hola " -> trim() elimina espacios al inicio y final
        Resultado: "Hola"

        --- 9. String cadena3_bien = cadena1.substring(3, 4) ---
        cadena1 = "Pepe"
        substring(3, 4): desde indice 3 hasta 4 (sin incluir 4)
          0 -> P
          1 -> e
          2 -> p
          3 -> e  (desde aqui)
          4 -> ?  (hasta aqui sin incluir)
        Resultado: "e"   (la segunda 'e' de Pepe)

        --- 9b. String cadena3_vacia = cadena1.substring(3, 3) ---
        substring(3, 3): inicio = fin -> cadena VACIA
        Resultado: ""

        --- 9c. cadena1.substring(4, 3) ---
        Si inicio > fin -> ERROR (StringIndexOutOfBoundsException)
        Porque se accede primero a posicion 4 que no existe.

        --- 10. String cadena4 = (cadena2 + cadena2).toLowerCase() ---
        cadena2 = "Hola"
        cadena2 + cadena2 = "Hola" + "Hola" = "HolaHola"
        .toLowerCase() -> "holahola"
        Resultado: "holahola"

        --- 11. int posicion1 = cadena4.indexOf("o") ---
        cadena4 = "holahola"
        indexOf("o") busca la PRIMERA aparicion de 'o'
          0 -> h
          1 -> o  <-- primera 'o'
        Resultado: 1

        --- 12. int posicion2 = cadena4.indexOf("hola") ---
        cadena4 = "holahola"
        indexOf("hola") busca la subcadena "hola"
        Empieza en indice 0: 'h','o','l','a' -> "hola" encontrado
        Resultado: 0

        --- 13. int posicion3 = cadena4.indexOf("Hola") ---
        cadena4 = "holahola"
        indexOf("Hola") busca "Hola" con H mayuscula
        "holahola" todo en minusculas -> NO encuentra "Hola"
        Resultado: -1  (indica que no se encontro)

        ================================================================
          TABLA RESUMEN
        ================================================================

        Variable              Tipo          Valor guardado
        --------              ----          -------------
        nombre                String        "Pepe"
        apellidos             String        "Martinez Garcia"
        nombreCompleto        String        "PepeMartinez Garcia"
        longitud              int           4
        longitud2             int           3
        letra                 char          't'
        cadena1               String        "Pepe"
        cadena2               String        "Hola"
        cadena3_bien          String        "e"
        cadena3_vacia         String        ""
        cadena4               String        "holahola"
        posicion1             int           1
        posicion2             int           0
        posicion3             int           -1

        ================================================================
          CONCEPTOS CLAVE PARA EL EXAMEN
        ================================================================

        * charAt(int pos): indice empieza en 0
        * length(): cuenta desde 1 (numero total de caracteres)
        * substring(inicio, fin): fin NO incluido
        * substring(i, i): cadena VACIA
        * substring(inicio > fin): ERROR
        * trim(): elimina espacios solo al inicio y final
        * toLowerCase(): convierte toda la cadena a minusculas
        * indexOf(String): devuelve PRIMERA posicion donde aparece
          (-1 si no la encuentra)
        * indexOf es CASE SENSITIVE: "hola" != "Hola"
        * Concatenacion con + une sin espacios adicionales
        * Todos los metodos de String devuelven NUEVA cadena,
          no modifican la original
        ================================================================
        """;

    public static void main(String[] args) {
        // --- EJECUCION DEL EJERCICIO ---
        String nombre = "Pepe";
        String apellidos = "Martinez Garcia";
        String nombreCompleto = nombre + apellidos;
        int longitud = nombre.length();
        int longitud2 = "245".length();
        char letra = apellidos.charAt(3);
        String cadena1 = nombreCompleto.substring(0, 4);
        String cadena2 = " Hola ".trim();
        String cadena3_bien = cadena1.substring(3, 4);
        String cadena3_vacia = cadena1.substring(3, 3);
        String cadena4 = (cadena2 + cadena2).toLowerCase();
        int posicion1 = cadena4.indexOf("o");
        int posicion2 = cadena4.indexOf("hola");
        int posicion3 = cadena4.indexOf("Hola");

        // --- SALIDA ---
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

        System.out.println("============================================");
        System.out.println("   EJECUCION DEL EJERCICIO");
        System.out.println("============================================");
        System.out.println();
        System.out.printf("%-25s -> %-10s = %s%n", "String nombre", "\"Pepe\"", nombre);
        System.out.printf("%-25s -> %-10s = %s%n", "String apellidos", "\"Martinez Garcia\"", apellidos);
        System.out.printf("%-25s -> %-10s = %s%n", "String nombreCompleto", "nombre+apellidos", nombreCompleto);
        System.out.printf("%-25s -> %-10s = %d%n", "int longitud", "nombre.length()", longitud);
        System.out.printf("%-25s -> %-10s = %d%n", "int longitud2", "\"245\".length()", longitud2);
        System.out.printf("%-25s -> %-10s = %s%n", "char letra", "apellidos.charAt(3)", "'" + letra + "'");
        System.out.printf("%-25s -> %-10s = %s%n", "String cadena1", "nCompleto.substring(0,4)", "\"" + cadena1 + "\"");
        System.out.printf("%-25s -> %-10s = %s%n", "String cadena2", "\" Hola \".trim()", "\"" + cadena2 + "\"");
        System.out.printf("%-25s -> %-10s = %s%n", "String cadena3_bien", "cadena1.substring(3,4)", "\"" + cadena3_bien + "\"");
        System.out.printf("%-25s -> %-10s = %s%n", "String cadena3_vacia", "cadena1.substring(3,3)", "\"" + cadena3_vacia + "\"");
        System.out.printf("%-25s -> %-10s = %s%n", "String cadena4", "(cad2+cad2).toLowerCase()", "\"" + cadena4 + "\"");
        System.out.printf("%-25s -> %-10s = %d%n", "int posicion1", "cad4.indexOf(\"o\")", posicion1);
        System.out.printf("%-25s -> %-10s = %d%n", "int posicion2", "cad4.indexOf(\"hola\")", posicion2);
        System.out.printf("%-25s -> %-10s = %d%n", "int posicion3", "cad4.indexOf(\"Hola\")", posicion3);

        System.out.println();
        mostrarInformacion();
    }

    public static void mostrarInformacion() {
        System.out.println("============================================");
        System.out.println("   RESUMEN DEL VIDEO");
        System.out.println("============================================");
        System.out.println();
        System.out.println(RESUMEN);
    }
}
