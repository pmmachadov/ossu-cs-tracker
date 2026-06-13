class Video_2_18_Operadores_Bit {

    public static final String TITULO = "JAVA: Operadores bit a bit en Java \u2615 DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=uSc0-5I0dzU&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=34";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-18 OPERADORES BIT A BIT EN JAVA
        ================================================================

        Video:        JAVA: Operadores bit a bit
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2

        --- OPERADORES A NIVEL DE BITS (BITWISE) ---

        Java permite manipular bits individuales de cualquier tipo entero
        (int, long, short, byte). Los operandos se tratan como valores
        binarios (32 bits para int).

        OPERADORES DISPONIBLES:

        ~   (NOT)         Complemento / Negacion a nivel de bits.
                            Cambia 0 -> 1 y 1 -> 0 en todos los bits.

        &   (AND)         AND bit a bit.
                            1 & 1 = 1, en cualquier otro caso 0.

        |   (OR)          OR bit a bit.
                            0 | 0 = 0, en cualquier otro caso 1.

        ^   (XOR)         XOR bit a bit (OR exclusivo).
                            0 ^ 1 = 1, 1 ^ 0 = 1, 0 ^ 0 = 0, 1 ^ 1 = 0.

        <<                Desplazamiento a la izquierda.
                            Mueve bits a la izquierda, completa con 0s.
                            Equivale a multiplicar por 2^n.

        >>                Desplazamiento a la derecha CON signo.
                            Mueve bits a la derecha, completa con el bit
                            de signo (0 si positivo, 1 si negativo).
                            Equivale a dividir por 2^n.

        >>>               Desplazamiento a la derecha SIN signo.
                            Siempre completa con 0s (no conserva signo).

        --- DECLARAR ENTEROS EN BINARIO Y HEXADECIMAL ---

        int a = 3;            // decimal
        int b = 0b11;         // binario  (prefijo 0b)
        int c = 0x3;          // hexadecimal (prefijo 0x)
        // Los tres almacenan el mismo valor: 3

        --- EJEMPLOS DEL VIDEO ---

        Variables de ejemplo:
          int a = 3;   // binario: ...00000011
          int b = 4;   // binario: ...00000100
          int c = 8;   // binario: ...00001000
          int d = 15;  // binario: ...00001111

        AND (&):
          a & b = 0   // 00000011 & 00000100 = 00000000

        OR (|):
          a | b = 7   // 00000011 | 00000100 = 00000111

        XOR (^):
          a ^ d = 12  // 00000011 ^ 00001111 = 00001100
                      // (coinciden en bits 0,1,5,6,7; difieren en bits 2,3)

        NOT (~):
          ~a = -4     // ~00000011 = 11111100 (32 bits: 30 unos + 2 ceros)
                      // En complemento a 2, ~3 = -4

        OR multiple:
          a | b | c = 15  // 00000011 | 00000100 | 00001000 = 00001111

        AND multiple:
          a & b & c = 0   // Ningun bit esta a 1 en los tres a la vez

        --- DESPLAZAMIENTOS ---

        d = 15; // binario: 00001111

        d >> 1  = 7   // 00000111 (desplaza 1 a la derecha, completa con 0)
        d << 1  = 30  // 00011110 (desplaza 1 a la izquierda, completa con 0)
        d >> 4  = 0   // 00000000 (desplaza 4 a la derecha, todos los bits se pierden)
        d << 4  = 240 // 11110000 (desplaza 4 a la izquierda)

        byte e = (byte) (d << 4);
        // e = -16 porque byte solo tiene 8 bits con signo:
        //   11110000 en byte = el primer bit es 1 -> negativo
        //   complemento a 2: 11110000 = -16
        //   En int el mismo patron 11110000 es 240 (positivo)

        --- DESPLAZAMIENTO CON SIGNO (>>) vs SIN SIGNO (>>>) ---

        int neg1 = -1;   // 32 bits todos a 1: 11111111...11111111
        int neg16 = -16; // 11111111...11110000

        // Con signo (>>): completa con el bit de signo
        neg1 >> 1 = -1     // Todos 1, sigue siendo -1
        neg16 >> 1 = -8    // 11111111...11111000

        // Sin signo (>>>): completa con 0s siempre
        neg1 >>> 1 = 2147483647  // 01111111...11111111 (maximo int positivo, Integer.MAX_VALUE)
        neg16 >>> 1 = 2147483640 // 01111111...11111000

        neg16 >> 24  = -1     // todos unos porque completa con 1s al ser negativo
        neg16 >>> 24 = 255    // 00000000...000011111111 -> 255

        --- OPERADORES DE ASIGNACION CON DESPLAZAMIENTO ---

        int resultado = d >> 1;   // resultado = 7
        a >>= 1;                  // a = a >> 1;
        // Tambien funcionan: <<=, >>=, >>>=

        --- REPRESENTACION DE ENTEROS ---

        IMPORTANTE: Para entender bitwise hay que saber que los enteros
        se almacenan en complemento a 2:

        - El primer bit (mas significativo) indica el signo:
          0 = positivo, 1 = negativo
        - Los numeros negativos se obtienen invirtiendo todos los bits
          del positivo y sumando 1 (~positivo + 1)
        - int:  32 bits, rango [-2147483648, 2147483647]
        - byte: 8 bits, rango [-128, 127]

        El mismo patron binario puede interpretarse como valores
        diferentes segun el tipo:
          byte: 11110000 = -16
          int:  11110000 = 240

        --- TABLA DE OPERADORES BIT A BIT ---

        AND (&):
          0 & 0 = 0
          0 & 1 = 0
          1 & 0 = 0
          1 & 1 = 1

        OR (|):
          0 | 0 = 0
          0 | 1 = 1
          1 | 0 = 1
          1 | 1 = 1

        XOR (^):
          0 ^ 0 = 0
          0 ^ 1 = 1
          1 ^ 0 = 1
          1 ^ 1 = 0

        NOT (~):
          ~0 = 1
          ~1 = 0

        --- RESUMEN DE OPERADORES ---

        Operador  Nombre                Ejemplo        Resultado
        --------  --------------------  -------------  ----------
        ~         NOT bit a bit         ~a             -4
        &         AND bit a bit         a & b          0
        |         OR bit a bit          a | b          7
        ^         XOR bit a bit         a ^ d          12
        <<        desplaza izquierda    d << 1         30
        >>        desplaza dcha signo   neg16 >> 1     -8
        >>>       desplaza dcha sin s.  neg16 >>> 1    2147483640

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * ~ invierte todos los bits: ~x = -(x+1) en complemento a 2
        * & da 1 solo si ambos bits son 1
        * | da 1 si al menos un bit es 1
        * ^ da 1 si los bits son distintos
        * << 1 equivale a multiplicar por 2
        * >> 1 equivale a dividir por 2 (con redondeo hacia abajo)
        * >>> siempre completa con 0s, independientemente del signo
        * El mismo patron binario puede ser positivo en int y negativo en byte
        * Prefijo 0b para binario, 0x para hexadecimal
        * Operadores de asignacion: &=, |=, ^=, <<=, >>=, >>>=
        * Muy util para banderas (flags), mascaras de bits, cifrado
        ================================================================
        """;

    public static void main(String[] args) {
        mostrarInformacion();
        System.out.println();
        mostrarEjemplosByte();
    }

    // -------------------------------------------------------------
    // Resumen practico de la variable byte en Java
    // -------------------------------------------------------------
    public static void mostrarEjemplosByte() {
        System.out.println("============================================");
        System.out.println("   VARIABLE TIPO BYTE EN JAVA");
        System.out.println("============================================");
        System.out.println("Tamano:   8 bits (1 byte)");
        System.out.println("Rango:    [-128, 127]");
        System.out.println();

        // 1. Declaracion basica
        byte b1 = 10;
        byte b2 = -50;
        byte b3 = 127;   // maximo positivo
        byte b4 = -128;  // minimo negativo

        System.out.println("--- Declaracion basica ---");
        System.out.println("byte b1 = 10;         // " + b1);
        System.out.println("byte b2 = -50;        // " + b2);
        System.out.println("byte b3 = 127;        // " + b3 + " (maximo positivo)");
        System.out.println("byte b4 = -128;       // " + b4 + " (minimo negativo)");
        System.out.println();

        // 2. Casting necesario desde int
        System.out.println("--- Casting desde int ---");
        int num = 240;
        byte b5 = (byte) num;
        System.out.println("int  num = 240;                  // binario: 00000000...11110000");
        System.out.println("byte b5 = (byte) num;            // b5 = " + b5);
        System.out.println("Explicacion: 240 en binario = 11110000 (8 bits)");
        System.out.println("  El primer bit es 1 -> negativo");
        System.out.println("  Complemento a 2: 11110000 = -16");
        System.out.println();

        // 3. Mismo binario, distinto valor segun tipo
        System.out.println("--- Mismo binario, distinto tipo ---");
        int    i = 0b11110000;   // 240
        byte   by = (byte) 0b11110000;  // -16
        System.out.println("int  0b11110000 = " + i + "  (32 bits -> positivo)");
        System.out.println("byte 0b11110000 = " + by + " (8 bits -> negativo, bit signo = 1)");
        System.out.println();

        // 4. Promocion a int en operaciones aritmeticas
        System.out.println("--- Promocion a int en operaciones ---");
        byte a = 10, b = 20;
        int suma = a + b;  // a y b se convierten a int antes de sumar
        byte sumaByte = (byte) (a + b);
        System.out.println("byte a = 10, b = 20;");
        System.out.println("int  suma     = a + b;           // " + suma + " (sin casting)");
        System.out.println("byte sumaByte = (byte) (a + b);  // " + sumaByte + " (con casting)");
        System.out.println();

        // 5. Desbordamiento (overflow)
        System.out.println("--- Desbordamiento (overflow) ---");
        byte max = 127;
        byte desbordado = (byte) (max + 1);
        System.out.println("byte max = 127;");
        System.out.println("byte desbordado = (byte) (max + 1);  // " + desbordado);
        System.out.println("Explicacion: 127 + 1 = 128, pero 128 en binario 10000000");
        System.out.println("  Como byte, el primer bit es 1 -> -128");
        System.out.println();

        // 6. Operadores bit a bit con byte
        System.out.println("--- Operadores bit a bit con byte ---");
        byte x = 0b00001111;  // 15
        byte y = 0b00000101;  // 5
        System.out.println("byte x = 0b00001111;  // " + x);
        System.out.println("byte y = 0b00000101;  // " + y);
        // Nota: &, |, ^, ~, <<, >>, >>> promocionan a int
        System.out.println("(x & y)  = " + (x & y) + "   // AND bit a bit");
        System.out.println("(x | y)  = " + (x | y) + "   // OR bit a bit");
        System.out.println("(x ^ y)  = " + (x ^ y) + "   // XOR bit a bit");
        System.out.println("(~x)     = " + (~x) + "  // NOT bit a bit (promociona a int)");
        System.out.println("(x << 2) = " + (x << 2) + "  // desplazar 2 a la izquierda");
        System.out.println("(x >> 1) = " + (x >> 1) + "   // desplazar 1 a la derecha");
        System.out.println();

        // 7. Tabla de valores notables
        System.out.println("--- Valores notables de byte ---");
        System.out.printf("  %-10s  %-10s  %s%n", "Binario", "Byte", "Comentario");
        System.out.printf("  %-10s  %-10d  %s%n", "00000000", (byte)0b00000000, "cero");
        System.out.printf("  %-10s  %-10d  %s%n", "00000001", (byte)0b00000001, "uno");
        System.out.printf("  %-10s  %-10d  %s%n", "01111111", (byte)0b01111111, "max positivo");
        System.out.printf("  %-10s  %-10d  %s%n", "10000000", (byte)0b10000000, "min negativo");
        System.out.printf("  %-10s  %-10d  %s%n", "11111111", (byte)0b11111111, "-1");
        System.out.printf("  %-10s  %-10d  %s%n", "11110000", (byte)0b11110000, "-16 (ej. video)");
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
