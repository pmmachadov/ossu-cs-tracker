class Video_2_14_Operadores_Matematicos {

    public static final String TITULO = "JAVA: Operadores matematicos ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=4NIgC5ArKTI&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=30";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-14 OPERADORES MATEMATICOS EN JAVA
        ================================================================

        --- OPERADORES MATEMATICOS BASICOS ---

        +    Suma (tambien concatena Strings)
        -    Resta
        *    Multiplicacion
        /    Division
        %    Modulo (resto de la division)

        Se pueden usar con literales (2, 4) o con variables:
          int resultado = 3 + b;   // literal + variable

        --- RESTRICCIONES POR TIPO ---

        * int   -> se puede sumar, restar, multiplicar, dividir
        * String -> se puede concatenar con +
        * No se puede multiplicar dos Strings
        * No se puede sumar un booleano con un char
        * No se puede restar Strings

        --- OPERADORES ABREVIADOS (asignacion compuesta) ---

        +=   a += 2  -> a = a + 2
        -=   a -= 2  -> a = a - 2
        *=   a *= 2  -> a = a * 2
        /=   a /= 2  -> a = a / 2
        %=   a %= 2  -> a = a % 2

        --- INCREMENTO Y DECREMENTO ---

        ++   a++ o ++a  -> incrementa en 1
        --   a-- o --a  -> decrementa en 1

        a = a + 1  es equivalente a  a += 1  es equivalente a  a++

        --- DIFERENCIA: ++ DETRAS vs ++ DELANTE ---

        int c = 5;
        int b = c++;   // b = 5, c = 6  (primero asigna, luego incrementa)
        int b = ++c;   // b = 6, c = 6  (primero incrementa, luego asigna)

        IMPORTANTE:
        - c++ : se usa el valor actual de c y DESPUES se incrementa
        - ++c : se incrementa PRIMERO y luego se usa el nuevo valor

        --- EJEMPLOS BASICOS ---

        int a = 3, b = 2;
        float f1 = 3.0f, f2 = 2.0f;

        System.out.println("3 + 2 = " + a + b);
        // CONCATENA: "3 + 2 = 32" (porque hay texto antes, todo es texto)

        System.out.println("3 + 2 = " + (a + b));
        // SUMA: parentesis fuerzan operacion numerica -> "3 + 2 = 5"

        System.out.println(a + " + " + b + " = " + (a + b));
        // "3 + 2 = 5"

        System.out.println(a + " - " + b + " = " + (a - b));
        // "3 - 2 = 1"

        System.out.println(a + " * " + b + " = " + (a * b));
        // "3 * 2 = 6"

        System.out.println(a + " / " + b + " = " + (a / b));
        // "3 / 2 = 1"  (enteros: 3/2 = 1, se trunca la parte decimal)

        --- DIVISION CON DECIMALES ---

        System.out.println(f1 + " / " + f2 + " = " + (f1 / f2));
        // "3.0 / 2.0 = 1.5"  (float/float = float)

        System.out.println(a + " / " + f2 + " = " + (a / f2));
        // "3 / 2.0 = 1.5"  (int/float = float, el float tiene prioridad)

        --- OPERADOR MODULO (%) ---

        System.out.println(a + " % " + b + " = " + (a % b));
        // "3 % 2 = 1"  (resto de 3/2 = 1)

        System.out.println(b + " % " + a + " = " + (b % a));
        // "2 % 3 = 2"  (2/3 cabe 0, resto 2)

        El modulo tambien funciona con reales:
          System.out.println(f1 % f2);  // 3.0 % 2.0 = 1.0

        --- PRIORIDAD EN ASIGNACION COMPUESTA ---

        IMPORTANTE: En operaciones con asignacion compuesta (+=, -=, *=, etc.),
        la parte DERECHA del igual tiene maxima prioridad,
        como si estuviera entre parentesis.

        Ejemplo:
          b *= a + b;   // equivale a: b = b * (a + b)
          // Primero se suma a + b, luego se multiplica por b

        NO es:
          b = b * a + b;  // INCORRECTO! Esto multiplicaria primero

        --- EJERCICIO RESUELTO (operaciones abreviadas) ---

        Variables iniciales:
          int a = 3, b = 2, c = 1;

        Instrucciones (orden de ejecucion):

        1. a += b;           // a = a + b = 3 + 2 = 5
        2. c += a;           // c = c + a = 1 + 5 = 6
        3. b += a + b;       // b = b + (a + b) = 2 + (5 + 2) = 9
        4. c -= a;           // c = c - a = 6 - 5 = 1
        5. c *= a / 2;       // c = c * (a / 2) = 1 * (5/2=2) = 2
        6. b %= 5;           // b = b % 5 = 9 % 5 = 4
        7. b /= c;           // b = b / c = 4 / 2 = 2
        8. b *= a + b;       // b = b * (a + b) = 2 * (5 + 2) = 14
        9. a /= b - c * 5;   // a = a / (b - c * 5) = 5 / (14 - 2*5) = 5 / (14 - 10) = 5 / 4 = 1

        Valores finales:
          a = 1
          b = 14
          c = 2

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Operadores: +, -, *, /, %
        * Concatenacion con +: si hay texto antes, todo es texto
        * Parentesis ( ) fuerzan evaluacion numerica
        * Division enteros: resultado entero (se trunca)
        * Si hay float/double en la expresion, el resultado es real
        * Asignacion compuesta: +=, -=, *=, /=, %=
        * La parte derecha del = tiene prioridad total
        * a++ -> usa el valor, luego incrementa
        * ++a -> incrementa primero, luego usa el valor
        * Con enteros, 3/2 = 1 (no redondea, trunca)
        * Con floats, 3.0/2.0 = 1.5
        * Modulo: resto de la division entera
        * Recomendacion: crear ejercicios propios y depurarlos en VS Code
          para entender el funcionamiento interno de Java
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
