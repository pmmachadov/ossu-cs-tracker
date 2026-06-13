class Video_2_07_Sistema_Hexadecimal {

    public static final String TITULO = "2-7 El sistema hexadecimal en Java";
    public static final String URL = "https://www.youtube.com/watch?v=9P8M1V0XnVo&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=23";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-7 EL SISTEMA HEXADECIMAL EN JAVA
        ================================================================

        --- SISTEMA HEXADECIMAL (base 16) ---

        * 16 valores por digito: 0-9 y A-F (A=10, B=11, C=12, D=13, E=14, F=15)
        * Muy usado en computacion porque 2 digitos hex = 1 byte (8 bits = 256 combinaciones)
        * En Java se escribe con prefijo 0x

        Correspondencia tipos:
          byte  (1 byte)  = 2 digitos hex (00 a FF)
          short (2 bytes) = 4 digitos hex (0000 a FFFF)
          int   (4 bytes) = 8 digitos hex (00000000 a FFFFFFFF)
          long  (8 bytes) = 16 digitos hex

        --- DECLARAR VARIABLES EN HEXADECIMAL ---

        byte num1 = 0x02;    // 2 en decimal
        byte num2 = 0x0B;    // 11 en decimal (B=11)
        byte num3 = 0x12;    // 18 en decimal (1*16 + 2 = 18)

        int num4 = 0xFF;     // 255 en decimal (int, no byte)
        int num5 = 0x80;     // 128 en decimal

        --- COMPLEMENTO A2 (numeros negativos) ---

        Java usa complemento a2 para almacenar enteros.
        El primer bit (mas a la izquierda) indica el signo:
          0 -> positivo
          1 -> negativo

        Para obtener el negativo de un numero:
          1. Invertir todos los bits (cambiar 0 por 1 y viceversa)
          2. Sumar 1 al resultado

        Ejemplos:
          0x01 = 1      -> complemento a2: 0xFF = -1
          0x03 = 3      -> complemento a2: 0xFD = -3
          0x10 = 16     -> complemento a2: 0xF0 = -16

        Rango de valores (byte, 8 bits):
          Positivos: 0x00 a 0x7F (0 a 127)
          Negativos: 0x80 a 0xFF (-128 a -1)
          Donde 0x7F = 127 (maximo), 0x80 = -128 (minimo)

        --- CASTING EN BYTE ---

        En Java NO hay literales de tipo byte; todos los literales son int.
        Para asignar un valor hexadecimal a un byte hay que hacer CASTING:

        byte b = (byte) 0xFF;    // -1 (sin casting daria error)
        byte b = (byte) 0x80;    // -128 (valor minimo)

        Sin casting, 0xFF en un int es 255, pero en byte es -1.

        --- BINARIO EN JAVA (0b) ---

        Tambien se puede escribir en binario con prefijo 0b:

        byte b = (byte) 0b11110000;  // 0xF0 = -16
        byte b = (byte) 0b00001111;  // 0x0F = 15

        --- TABLA: 4 BITS -> 1 DIGITO HEX ---

        Binario  | Hex | Decimal
        0000     |  0  |   0
        0001     |  1  |   1
        0010     |  2  |   2
        0011     |  3  |   3
        0100     |  4  |   4
        0101     |  5  |   5
        0110     |  6  |   6
        0111     |  7  |   7
        1000     |  8  |   8
        1001     |  9  |   9
        1010     |  A  |  10
        1011     |  B  |  11
        1100     |  C  |  12
        1101     |  D  |  13
        1110     |  E  |  14
        1111     |  F  |  15

        --- CONVERSIONES RAPIDAS ---

        0x0F = 15
        0x10 = 16  (siguiente al 0x0F)
        0x20 = 32
        0x7F = 127 (maximo positivo en byte)
        0x80 = 128 (en int) o -128 (en byte con casting)
        0xFF = 255 (en int) o -1   (en byte con casting)

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Hexadecimal: base 16, digitos 0-9 y A-F
        * Prefijo en Java: 0x (ej: 0xFF)
        * 2 digitos hex = 1 byte
        * Complemento a2: invertir bits + sumar 1
        * Primer bit = 1 -> numero negativo
        * No hay literales byte en Java -> usar casting (byte)
        * 0x7F = ultimo positivo, 0x80 = primer negativo (minimo)
        * 0xFF = -1 en byte, 255 en int
        * Se puede escribir en binario con 0b
        * Letras en hex: mayusculas o minusculas, da igual
        * MUY IMPORTANTE para entender como Java almacena numeros
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
