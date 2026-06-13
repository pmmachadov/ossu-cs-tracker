class Video_2_17_Operadores_Logicos {

    public static final String TITULO = "JAVA: Operadores l\u00f3gicos \u2615 DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=Z06XfYcrDN4&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=33";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-17 OPERADORES LOGICOS EN JAVA
        ================================================================

        Video:        JAVA: Operadores logicos
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2

        --- OPERADORES LOGICOS ---

        Los operadores logicos permiten COMBINAR condiciones.
        El resultado de una expresion logica es SIEMPRE boolean (true/false).

        OPERADORES DISPONIBLES EN JAVA:

        !   (NOT)         Negacion logica. Invierte el valor booleano.
                            true  -> false
                            false -> true

        &&  (AND)         Conjuncion logica (Y logico).
                            Devuelve true UNICAMENTE si ambas expresiones son true.
                            En cualquier otro caso devuelve false.

        ||  (OR)          Disyuncion logica (O logico).
                            Devuelve true si AL MENOS UNA expresion es true.
                            Solo devuelve false cuando TODAS son false.

        ^   (XOR)         Disyuncion exclusiva (O exclusivo).
                            Devuelve true si las expresiones tienen DISTINTO valor.
                            Devuelve false si ambas tienen el MISMO valor.

        --- TABLAS DE VERDAD ---

        AND (&&):
          true  && true  = true
          true  && false = false
          false && true  = false
          false && false = false

        OR (||):
          true  || true  = true
          true  || false = true
          false || true  = true
          false || false = false

        NOT (!):
          !true  = false
          !false = true

        XOR (^):
          true  ^ true  = false
          true  ^ false = true
          false ^ true  = true
          false ^ false = false

        --- PRIORIDAD DE OPERADORES (de mayor a menor) ---

        1. Parentesis ()
        2. Negacion (!)
        3. AND (&&)
        4. OR (||)
        5. XOR (^)

        --- EJEMPLOS DEL VIDEO ---

        Variables de ejemplo:
          int precio1 = 10, precio2 = 20, precio3 = 30;

        boolean caro = precio1 >= 30;                // false (10 >= 30)
        boolean barato = precio1 >= 0 && precio1 <= 10;  // true (10 >= 0 y 10 <= 10)
        boolean rango = precio1 >= 10 && precio1 < 10;   // false (condicion imposible)

        boolean iguales = precio1 == precio2 && precio2 == precio3;  // false
        boolean distintos = precio1 != precio2 && precio1 != precio3 && precio3 != precio2;  // true

        // Maximos
        boolean max1 = precio1 >= precio2 && precio1 >= precio3;  // false
        boolean max2 = precio2 >= precio1 && precio2 >= precio3;  // false
        boolean max3 = precio3 >= precio1 && precio3 >= precio2;  // true

        // Alguno es caro (OR)
        boolean algunoCaro = precio1 > 30 || precio2 >= 30 || precio3 >= 30;  // true

        // Alguno es distinto (comprobar si NO son todos iguales)
        boolean algunDistinto = precio1 != precio2 || precio1 != precio3;  // true

        // Combinacion AND + OR
        boolean combinada = (precio2 > precio1) || (precio1 == precio2 && precio1 == precio3);
        // Primero se resuelve el AND: precio1 == precio2 && precio1 == precio3 -> false
        // Luego OR: true || false -> true

        --- EJEMPLOS ADICIONALES CON VARIABLES BOOLEANAS ---

        int a = 1, b = 2;
        boolean condicion1 = true;
        boolean condicion2 = false;

        // AND
        boolean r1 = condicion1 && condicion2;            // false

        // OR
        boolean r2 = condicion1 || condicion2;            // true

        // AND con expresion relacional
        boolean r3 = condicion1 && a < b;                 // true (true && true)

        // AND con condicion false
        boolean r4 = condicion2 && a < b;                 // false

        // AND con negacion
        boolean r5 = condicion1 && !condicion2;           // true (true && true)
        boolean r6 = !(condicion1 && condicion2);         // true (!(true && false) = !false = true)

        boolean r7 = !(condicion1 && true);               // false (!true)

        // XOR
        boolean r8 = condicion1 ^ condicion2;             // true (true ^ false, son distintas)
        boolean r9 = condicion1 ^ (a != b);               // false (true ^ true, son iguales)
        boolean r10 = !condicion1 ^ !(a != b);            // false (false ^ false, son iguales)
        boolean r11 = !(condicion1 ^ (a != b));           // true (!(true ^ true) = !false)

        --- SENTENCIA if CON OPERADORES LOGICOS ---

        Ejemplo del video (pseudocodigo a Java):

        // Si (a == 3 && b > 5) o (a == 7 && b >= 4)
        if ((a == 3 && b > 5) || (a == 7 && b >= 4)) {
            System.out.println("Se cumple la condicion");
        }

        Nota: La expresion "b no es menor que 4" equivale a !(b < 4) o b >= 4.

        --- EVALUACION EN CORTOCIRCUITO (short-circuit) ---

        && : si la primera condicion es false, la segunda NO se evalua
        || : si la primera condicion es true, la segunda NO se evalua

        Esto es importante para evitar errores:

        int[] arr = null;
        // if (arr != null && arr.length > 0)  // SEGURO: no evalua arr.length si arr es null
        // if (arr.length > 0 && arr != null)  // ERROR: NullPointerException

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Operadores logicos: ! (NOT), && (AND), || (OR), ^ (XOR)
        * Siempre devuelven boolean (true/false)
        * AND: solo true si ambas son true
        * OR:  solo false si ambas son false
        * NOT: invierte el valor booleano
        * XOR: true si son distintas, false si son iguales
        * Prioridad: ! > && > || > ^
        * Usar parentesis para claridad y para forzar orden
        * Short-circuit: && y || no evaluan el segundo operando si no hace falta
        * Condiciones imposibles: ej. x >= 10 && x < 10 (siempre false)
        * Para comparar si tres valores son iguales:
          precio1 == precio2 && precio2 == precio3
        * Para comparar si tres valores son distintos:
          precio1 != precio2 && precio1 != precio3 && precio2 != precio3
        * Para saber si alguno es distinto (no todos iguales):
          precio1 != precio2 || precio1 != precio3
        * XOR (^) se usa poco pero aparece en examenes
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
