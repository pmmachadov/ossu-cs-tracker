class Video_2_10_Clase_String_Metodos {

    public static final String TITULO = "2-10 JAVA: Clase String ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=443VORsWj2M&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=26";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-10 CLASE STRING - METODOS MAS UTILIZADOS
        ================================================================

        Metodos/Funciones de String:
        Sirven para obtener informacion o transformar una cadena.
        NUNCA modifican el String original, devuelven una nueva.

        --- TABLA DE METODOS ---

        Metodo                Que devuelve          Descripcion
        ------                -------------         -----------
        length()              int                   Longitud (num caracteres)
        charAt(int pos)       char                  Caracter en posicion
        toUpperCase()         String                Copia en MAYUSCULAS
        toLowerCase()         String                Copia en minusculas
        substring(int i,int f) String               Subcadena [i, f)
        replace(char v,char n) String               Reemplazar caracter
        trim()                String                Elimina espacios inicio/fin
        startsWith(String)    boolean               Empieza por...
        endsWith(String)      boolean               Termina por...
        indexOf(String)       int                   Posicion de subcadena (1era)
        lastIndexOf(String)   int                   Posicion de subcadena (ultima)
        concat(String)        String                Concatena (se usa poco)
        equals(String)        boolean               Compara cadenas (con mayus/minus)
        equalsIgnoreCase(Str) boolean               Compara sin importar mayus/minus
        compareTo(String)     int                   Orden alfabetico (lexicografico)

        --- DETALLE DE CADA METODO ---

        1. length()
           Devuelve la longitud (numero de caracteres) de la String.
           Cuenta espacios en blanco.
           Ej: "curso Java".length() -> 10

        2. charAt(int index)
           Devuelve el caracter en la posicion 'index'.
           El indice EMPIEZA EN 0.
           Rango valido: de 0 a length()-1.
           Si el indice no existe -> ERROR (StringIndexOutOfBoundsException).
           Ej: "curso Java".charAt(0) -> 'c'
               "curso Java".charAt(4) -> 'o'

        3. toUpperCase()
           Devuelve una NUEVA String con todos los caracteres en mayuscula.
           La original NO se modifica.
           Ej: "curso Java".toUpperCase() -> "CURSO JAVA"

        4. toLowerCase()
           Devuelve una NUEVA String con todos los caracteres en minuscula.
           La original NO se modifica.
           Ej: "Curso Java".toLowerCase() -> "curso java"

        5. substring(int inicio, int fin)
           Devuelve una subcadena desde 'inicio' hasta 'fin' (sin incluir fin).
           Otra version: substring(int inicio) -> desde inicio hasta el final.
           Ej: "curso Java".substring(0, 5) -> "curso"
               "curso Java".substring(6)    -> "Java"

        6. replace(char viejo, char nuevo)
           Reemplaza todas las apariciones de un caracter por otro.
           Devuelve una NUEVA String.
           Ej: "curso Java".replace('a', 'e') -> "curso Jeve"

        7. trim()
           Elimina espacios en blanco al inicio y al final de la String.
           Los espacios intermedios NO se eliminan.
           Ej: "  hola mundo  ".trim() -> "hola mundo"

        8. startsWith(String prefijo)
           Devuelve true si la cadena empieza con el prefijo indicado.
           Ej: "curso Java".startsWith("cur") -> true
               "curso Java".startsWith("java") -> false

        9. endsWith(String sufijo)
           Devuelve true si la cadena termina con el sufijo indicado.
           Ej: "curso Java".endsWith("Java") -> true

        10. indexOf(String subcadena)
            Devuelve la posicion (indice) de la PRIMERA aparicion.
            Si no existe, devuelve -1.
            Ej: "curso Java".indexOf("Java") -> 6

        11. lastIndexOf(String subcadena)
            Devuelve la posicion de la ULTIMA aparicion.
            Ej: "curso Java Java".lastIndexOf("Java") -> 11

        12. concat(String)
            Concatena (une) dos cadenas. Poco usado porque + es mas comodo.
            Ej: "curso".concat(" Java") -> "curso Java"

        13. equals(String)
            Compara si dos cadenas son exactamente iguales (incluye mayus/minus).
            Devuelve boolean (true/false).
            Ej: "Java".equals("Java") -> true
                "Java".equals("java") -> false

        14. equalsIgnoreCase(String)
            Compara cadenas sin importar mayusculas/minusculas.
            Ej: "Java".equalsIgnoreCase("java") -> true

        15. compareTo(String)
            Compara cadenas por orden lexicografico (alfabetico).
            Devuelve un valor numerico:
              - Negativo si la 1a cadena es menor (va antes alfabeticamente)
              - Cero si son iguales
              - Positivo si la 1a cadena es mayor (va despues)
            Ej: "a".compareTo("b") -> negativo (a < b)
                "a".compareTo("a") -> 0
                "b".compareTo("a") -> positivo (b > a)

        --- REGLA IMPORTANTE ---

        Todo lo que esta entre COMILLAS DOBLES en Java es un String.
        Se pueden llamar metodos directamente sobre literales:

        "prueba".length()   -> 6
        "hola".toUpperCase() -> "HOLA"

        --- EJEMPLO PRACTICO (codigo del video) ---

        String cadena = "curso Java";

        // length()
        int longitud = cadena.length();     // 10
        System.out.println(cadena + " tiene " + longitud + " caracteres");

        // charAt() - indice empieza en 0
        char primeraLetra = cadena.charAt(0); // 'c'
        char ultimaLetra = cadena.charAt(cadena.length() - 1); // 'a'

        // Combinar length() + charAt() para ultima letra SIEMPRE
        // cadena.charAt(cadena.length() - 1)  -> ultimo caracter

        // toUpperCase() y toLowerCase()
        String mayusculas = cadena.toUpperCase(); // "CURSO JAVA"
        String minusculas = cadena.toLowerCase(); // "curso java"

        // substring()
        String sub = cadena.substring(0, 5);      // "curso"

        // trim()
        String conEspacios = "  hola  ";
        String sinEspacios = conEspacios.trim();  // "hola"  (sin espacios)

        // Llamar metodos directamente sobre literales
        "  texto  ".trim();   // "texto"

        // compareTo() - orden alfabetico (lexicografico)
        // Devuelve int: negativo si 1a < 2a, 0 si igual, positivo si 1a > 2a
        String pal1 = "amigo";
        String pal2 = "amor";
        String pal3 = "barca";
        String pal4 = "amigo";

        int res;

        res = pal1.compareTo(pal2);
        // "amigo" vs "amor": a=a, m=m, i vs o -> i(105)-o(111) = -6
        // "amigo" va ANTES que "amor" -> NEGATIVO

        res = pal2.compareTo(pal1);
        // "amor" vs "amigo": o(111)-i(105) = 6 -> POSITIVO
        // "amor" va DESPUES que "amigo"

        res = pal1.compareTo(pal4);
        // "amigo" vs "amigo" -> IGUALES -> 0

        res = pal1.compareTo(pal3);
        // "amigo" vs "barca": a(97)-b(98) = -1 -> NEGATIVO
        // "amigo" va antes (empieza por 'a', barca por 'b')

        // Util para ordenar alfabeticamente
        String a = "perro", b = "gato", c = "ave";
        // Orden: ave(1), gato(2), perro(3)
        // c.compareTo(b) -> negativo (ave < gato)  ✓
        // c.compareTo(a) -> negativo (ave < perro) ✓
        // b.compareTo(a) -> negativo (gato < perro) ✓

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---  

        * Metodos de String NO modifican el original, crean copia nueva
        * charAt indice empieza en 0 (no en 1)
        * Ultimo indice valido = length() - 1
        * length() devuelve int (numero de caracteres)
        * charAt(pos) devuelve char (un solo caracter)
        * substring(inicio, fin) -> fin NO incluido
        * toUpperCase() / toLowerCase() -> nueva String
        * trim() -> elimina espacios solo al inicio y final
        * startsWith() / endsWith() -> devuelven boolean
        * indexOf() / lastIndexOf() -> devuelven int (posicion o -1)
        * equals() -> compara contenido (no usar == con Strings)
        * compareTo() -> para ordenar alfabeticamente
        * Se pueden aplicar metodos directamente sobre literales String
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
