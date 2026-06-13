class Video_2_15_Asignaciones_Complejas {

    public static final String TITULO = "JAVA: Asignaciones complejas ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=DIbhR5cdtL0&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=31";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-15 ASIGNACIONES COMPLEJAS EN JAVA
        ================================================================

        --- EJERCICIO 1: Operaciones combinadas con ++ y -- ---

        Variables iniciales:
          int a = 1, b = 2, c = 3;

        Instrucciones (orden de ejecucion):

        1. b = ++c;
           // ++c primero: c pasa de 3 a 4, luego se asigna a b
           // Resultado: a=1, b=4, c=4

        2. a += b++;
           // a = a + b (primero suma, luego incrementa b)
           // a = 1 + 4 = 5, luego b pasa de 4 a 5
           // Resultado: a=5, b=5, c=4

        3. a = a++ + a;
           // CASO ESPECIAL: misma variable en ambos lados
           // Paso 1: se guarda el valor actual de a = 5
           // Paso 2: a++ incrementa a de 5 a 6
           // Paso 3: se suma el valor guardado (5) + a actual (6) = 11
           // Resultado: a=11, b=5, c=4

        4. a -= b--;
           // a = a - b (primero resta, luego decrementa b)
           // a = 11 - 5 = 6, luego b pasa de 5 a 4
           // Resultado: a=6, b=4, c=4

        5. c = a++ - ++b;
           // Primero ++b: b pasa de 4 a 5
           // Luego a++ se usa el valor actual (6), luego se incrementa
           // c = 6 - 5 = 1, luego a pasa de 6 a 7
           // Resultado: a=7, b=5, c=1

        6. c -= ++a;
           // c = c - ++a
           // ++a: a pasa de 7 a 8
           // c = 1 - 8 = -7
           // Resultado: a=8, b=5, c=-7

        7. a -= ++c;
           // a = a - ++c
           // ++c: c pasa de -7 a -6
           // a = 8 - (-6) = 8 + 6 = 14
           // Resultado: a=14, b=5, c=-6

        8. a -= c++;
           // a = a - c (primero resta, luego incrementa c)
           // a = 14 - (-6) = 14 + 6 = 20, luego c pasa de -6 a -5
           // Resultado: a=20, b=5, c=-5

        9. a -= --c;
           // a = a - --c
           // --c: c pasa de -5 a -6
           // a = 20 - (-6) = 20 + 6 = 26
           // Resultado FINAL: a=26, b=5, c=-6

        --- EJERCICIO 2: Casos extremos con una sola variable ---

        En cada caso, a = 1 ANTES de la instruccion (no se ejecutan en serie):

        a = ++a;    // ++a: a=1 -> a=2, luego asigna 2 -> a=2
        a = --a;    // --a: a=1 -> a=0, luego asigna 0 -> a=0
        a = a--;    // Se guarda valor a=1, luego a-- -> a=0, luego asigna
                      el valor guardado (1) -> a=1
        a = a++;    // Se guarda valor a=1, luego a++ -> a=2, luego asigna
                      el valor guardado (1) -> a=1
        a = a + a--;// a + a = 1+1 = 2, luego a-- -> a=0, asigna 2 -> a=2
        a = a + a++;// a + a = 1+1 = 2, luego a++ -> a=2, asigna 2 -> a=2

        --- CASO AVANZADO: Multiples -- en cadena ---

        a = a-- + a--;                     // 1 + 0 = 1, a termina en -1
        a = a-- + a-- + a--;               // 1 + 0 + (-1) = 0, a=-2
        a = a-- + a-- + a-- + a--;         // 1+0+(-1)+(-2) = -2, a=-3
        a = a-- + a-- + a-- + a-- + a--;   // 1+0+(-1)+(-2)+(-3) = -5, a=-4
        a = a-- + a-- + a-- + a-- + a-- + a--; // 1+0+(-1)+(-2)+(-3)+(-4) = -9, a=-5

        EXPLICACION:
        - Cada a-- toma el valor actual de a y LUEGO decrementa
        - El primer a-- usa a=1 y la deja en 0
        - El segundo a-- usa a=0 y la deja en -1
        - Y asi sucesivamente
        - Al final se suma todo y se asigna a la variable a
        - Aunque a haya ido cambiando durante la expresion,
          el resultado final es la suma de los valores que se tomaron

        IMPORTANTE: Estas expresiones son EXTREMADAMENTE confusas
        y NO se deben escribir en codigo real. Sirven unicamente
        para entender como Java evalua las expresiones internamente.

        --- OPERACIONES CON CHAR (incremento/decremento) ---

        char letra = 'A';   // valor ASCII 65

        letra++;            // letra = 66 -> 'B'
        letra += 5;         // letra = 71 -> 'G' (B->C->D->E->F->G)
        letra--;            // letra = 70 -> 'F'
        letra = (char)(letra - 2);  // letra = 68 -> 'D' (con casting)

        NOTA: al hacer operaciones aritmeticas con char, el resultado
        es un int. Hay que usar casting (char) para asignarlo de nuevo.

        Ejemplo final:
          letra = 'F';      // ASCII 70
          letra = (char)(letra + '1');  // '1' ASCII 49
                                        // 70 + 49 = 119 -> 'w' (minuscula)

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * ++variable: incrementa PRIMERO, luego usa el valor
        * variable++: usa el valor PRIMERO, luego incrementa
        * Con la MISMA variable en ambos lados (ej: a = a++ + a):
          1) Se guarda el valor inicial de a
          2) Se evaluan los incrementos/decrementos
          3) Se evalua la expresion con los valores parciales
          4) Se asigna el resultado final
        * Los operadores de pre-incremento/pre-decremento (++a, --a)
          se evaluan ANTES de usar la variable en la expresion
        * Los operadores de post-incremento/post-decremento (a++, a--)
          se evaluan DESPUES de usar el valor actual
        * char se puede incrementar/decrementar como numeros (tabla ASCII)
        * Las operaciones con char requieren casting cuando se usa
          operador abreviado con int (ej: letra = (char)(letra - 2))
        * EVITAR este tipo de expresiones en codigo real:
          son dificiles de leer y de mantener
        * Sirven como ejercicio academico para entender
          el funcionamiento interno de Java
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
