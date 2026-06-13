class Video_2_05_Tipos_Variables_Java {

    public static final String TITULO = "2-5 Tipos de variables en Java";
    public static final String URL = "https://www.youtube.com/watch?v=dy1qD-jwcIs&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=21";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-5 TIPOS DE VARIABLES EN JAVA
        ================================================================

        --- CONCEPTOS BASICOS ---

        * Variable: espacio de memoria con un nombre para almacenar datos
        * Java es de TIPADO FUERTE: hay que declarar el tipo de cada variable
        * El tipo de dato determina cuanto espacio de memoria se reserva
        * Los datos se almacenan internamente en binario (bits 0 y 1)
        * 1 byte = 8 bits
        * Con N bits tengo 2^N combinaciones

        --- TIPOS NUMERICOS ENTEROS ---

        Tipo   | Tamano |      Rango                      | Uso tipico
        -------|--------|---------------------------------|-------------------
        byte   | 1 byte |  -128 a 127                      | Valores muy peq.
        short  | 2 bytes|  -32.768 a 32.767                | Valores pequenos
        int    | 4 bytes|  -2^31 a 2^31-1                  | El MAS usado
               |        |  (-2.147.483.648 a 2.147.483.647)|
        long   | 8 bytes|  -2^63 a 2^63-1                  | Valores muy grandes

        * El rango se calcula: mitad para negativos, mitad para positivos + cero
        * Ej: byte (8 bits = 256 combinaciones): -128 a 127
        * int es el tipo mas usado para enteros en Java

        --- TIPOS NUMERICOS DECIMALES (coma flotante) ---

        Tipo   | Tamano | Precision | Uso tipico
        -------|--------|-----------|-------------------
        float  | 4 bytes| ~7 digitos| Menos precision
        double | 8 bytes| ~15 digitos| Mas precision (el MAS usado)

        * Siguen el estandar IEEE 754 para aritmetica en coma flotante
        * double es el mas usado para decimales en Java

        --- OTROS TIPOS NUMERICOS (objetos, no primitivos) ---

        BigInteger  -> numeros enteros arbitrariamente grandes
        BigDecimal  -> decimales con maxima precision

        --- TIPOS NO NUMERICOS ---

        Tipo     | Tamano  | Valores          | Uso
        ---------|---------|------------------|------------------
        char     | 2 bytes | Un solo caracter | Letras, simbolos, digitos
                 |         | (unicode)        | Ej: 'A', '7', '@'
        boolean  | 1 bit   | true o false     | Condiciones logicas
        String   | variable| Cadenas de texto | Textos (NO es primitivo,
                 |         |                  | es un objeto)

        * char sigue el estandar Unicode (incluye ASCII)
        * boolean ocupa solo 1 bit (true = 1, false = 0)
        * String no es primitivo, es un objeto, pero se usa como basico

        --- REPRESENTACION INTERNA DEL NUMERO 3 ---

        byte  (1 byte):  00000011
        short (2 bytes): 00000000 00000011
        int   (4 bytes): 00000000 00000000 00000000 00000011
        long  (8 bytes): 00000000 00000000 ... 00000011 (62 ceros + 2 unos)

        * Se desperdicia memoria si guardamos numeros pequenos en tipos grandes
        * En la practica se usa int para enteros y double para decimales

        --- DECLARACION DE VARIABLES ---

        tipo identificador;
        int edad;
        double precio;
        String nombre;
        boolean activo;

        --- DIFERENCIA CON OTROS LENGUAJES ---

        Java (tipado fuerte):  int cantidad = 10;
        JavaScript (tipado debil): var cantidad = 10;

        En Java hay que indicar SIEMPRE el tipo de la variable.

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Tipado fuerte: Java obliga a declarar el tipo de cada variable
        * byte (1B), short (2B), int (4B), long (8B) -> enteros
        * float (4B), double (8B) -> decimales
        * char (2B, unicode) -> un solo caracter
        * boolean (1 bit) -> true/false
        * String -> cadena de texto (objeto, no primitivo)
        * int y double son los tipos mas usados
        * El tamano en memoria afecta al rango de valores posibles
        * Con N bits tengo 2^N valores distintos
        * Bits -> Bytes (8 bits) -> Combinaciones -> Representar valores
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
