class Video_2_08_Char_Boolean_ASCII_Unicode {

    public static final String TITULO = "2-8 Char, boolean, ASCII y Unicode en Java";
    public static final String URL = "https://www.youtube.com/watch?v=mAi5o9rsJS4&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=24";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-8 CHAR, BOOLEAN, ASCII Y UNICODE EN JAVA
        ================================================================

        --- BOOLEAN ---

        boolean activo = true;
        boolean parar = false;

        * Solo dos valores: true o false
        * Ocupa 1 bit (la variable mas barata en memoria)
        * NO se ponen entre comillas (son palabras reservadas)
        * Se puede asignar el resultado de una expresion logica:

          boolean seguir = (3 > 5);   // false
          boolean parar = (7 != 6);   // true

        --- CHAR (caracter) ---

        char letra = 'A';
        char simbolo = '*';

        * Guarda UN SOLO caracter
        * Siempre entre COMILLAS SIMPLES (' ')
        * Internamente se almacena como un numero entero (codigo ASCII/Unicode)
        * Se puede operar con char como si fuera un numero:

          char letra = 'A';           // ASCII 65
          letra = (char)(letra + 1);  // ahora es 'B' (ASCII 66)
          letra = (char)(letra + 3);  // 'B' + 3 = 'E'

        * Asignacion directa con numero (codigo ASCII):
          char c = 65;     // 'A'
          char d = 100;    // 'd' (minucula)

        --- TABLA ASCII ---

        * 7 bits = 128 combinaciones (0 a 127)
        * Subconjunto dentro de Unicode
        * Valores clave:

          'A' = 65    'B' = 66    ...    'Z' = 90
          'a' = 97    'b' = 98    ...    'z' = 122
          '0' = 48    '1' = 49    ...    '9' = 57
          ' ' = 32 (espacio)

        --- UNICODE ---

        * Estandar que amplia ASCII con muchisimos caracteres
        * Incluye caracteres de todos los idiomas, simbolos, emojis, etc.
        * Char en Java ocupa 2 bytes (16 bits = 65536 combinaciones)
        * Unicode sigue evolucionando (se anaden nuevos caracteres)
        * Web de consulta: https://unicode-table.com/

        Para insertar un caracter Unicode en Java:
          char pi = '\\u03C0';       // simbolo π
          char copy = '\\u00A9';     // copyright ©
          char reg = '\\u00AE';      // marca registrada ®
          char estrella = '\\u2605'; // estrella ★
          char corazon = '\\u2661';  // corazon ♡
          char inf = '\\u221E';      // infinito ∞

        * Se escribe: \\u + 4 digitos hexadecimales
        * Da igual mayusculas o minusculas en los digitos hex

        --- EJEMPLO: CHAR COMO NUMERO ---

        char letra = 'A';
        System.out.println(letra);         // A
        System.out.println((int)letra);    // 65 (casting a int para ver codigo)
        letra++;                           // letra = 'B'
        System.out.println(letra);         // B

        --- EJERCICIO: DECLARACIONES VALIDAS ---

        Cuales son validas?
        a) int base = 4; altura = 6;                    // NO (falta int en altura)
        b) int a-2 = 5;                                  // NO (guion no permitido)
        c) boolean b = "true";                           // NO (con comillas es String)
        d) int area = 4, perimetro;                      // SI
        e) int num = 10.5;                               // NO (decimal en entero)
        f) int 2a = 10;                                  // NO (empieza con numero)

        a) int area = 4, perimetro;                      // SI
        b) int a_2 = 5;                                  // SI (guion bajo SI vale)
        c) boolean b = False;                             // NO (False en mayuscula, debe ser false)
        d) int perimetro = 10                             // NO (falta punto y coma)
        e) float f2 = 10.5;                              // NO (float necesita F: 10.5f)
        f) double d2 = 10.0012;                          // SI (D opcional)
        g) byte num = 128;                               // NO (byte maximo 127)

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * boolean: true / false (sin comillas, palabras reservadas)
        * char: un solo caracter, con comillas simples ' '
        * Internamente char se almacena como numero (codigo ASCII/Unicode)
        * ASCII: 7 bits, 'A'=65, 'a'=97, '0'=48
        * Unicode: \\u + 4 digitos hex
        * Char en Java = 2 bytes (16 bits) por Unicode
        * Se puede operar con char como numero (sumar, restar)
        * Para ver el codigo numerico: (int) char
        * Palabras reservadas (true, false) en minuscula
        * float necesita F, double D opcional
        * byte: maximo 127, minimo -128
        * Identificadores: no empezar con numero, no guion (-)
        * Guion bajo _ SI permitido en identificadores
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
