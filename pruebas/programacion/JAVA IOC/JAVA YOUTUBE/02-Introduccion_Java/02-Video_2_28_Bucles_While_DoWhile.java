class Video_2_28_Bucles_While_DoWhile {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "2-28 JAVA: Bucle WHILE y DO-WHILE [DAM - DAW]";
    public static final String URL = "https://www.youtube.com/watch?v=qao5b2S9y0g&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=44";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------

    public static final String RESUMEN =
        """
        ================================================================
          2-28 BUCLE WHILE Y DO-WHILE EN JAVA
        ================================================================

        Los bucles son estructuras de control repetitivas que ejecutan
        un bloque de instrucciones mientras se cumple una condicion.
        En el momento que la condicion deja de cumplirse, el bucle termina.

        --- TIPOS DE BUCLES EN JAVA ---
            * while
            * do-while
            * for (es una forma abreviada de escribir el bucle while)

        ================================================================
          BUCLE WHILE
        ================================================================

        SINTAXIS:
            while (condicion) {
                // instrucciones del cuerpo del bucle
            }

        FUNCIONAMIENTO:
            1. Se evalua la condicion (debe devolver un boolean).
            2. Si es true, se ejecutan todas las instrucciones dentro
               de las llaves.
            3. Al llegar a la ultima instruccion, se vuelve a evaluar
               la condicion.
            4. Si sigue siendo true, se repite el proceso.
            5. Cuando la condicion devuelve false, se sale del bucle
               y se continua con la instruccion siguiente a las llaves.

        IMPORTANTE:
            - Las instrucciones dentro del bucle deben modificar la
              condicion en algun momento, para que el bucle no sea infinito.
            - Puede que el cuerpo del bucle NO se ejecute NUNCA si la
              condicion inicial es false.

        ================================================================
          BUCLE DO-WHILE
        ================================================================

        SINTAXIS:
            do {
                // instrucciones del cuerpo del bucle
            } while (condicion);    // <-- IMPORTANTE: punto y coma al final

        FUNCIONAMIENTO:
            1. Se ejecutan las instrucciones del cuerpo del bucle.
            2. Al llegar a while, se evalua la condicion.
            3. Si es true, se vuelve al do (primera instruccion).
            4. Si es false, se sale del bucle.

        DIFERENCIA CON WHILE:
            - En do-while, el cuerpo del bucle se ejecuta SIEMPRE
              al menos una vez, porque la condicion se evalua al final.
            - En while, si la condicion inicial es false, el cuerpo
              no se ejecuta nunca.

        ================================================================
          EJEMPLOS DEL VIDEO
        ================================================================

        Ejemplo 1: a=0, b=1 con while (b += a primero, luego a++)
            Resultado: a=4, b=7

        Ejemplo 2: a=0, b=1 con do-while (mismo orden)
            Resultado: a=4, b=7

        Ejemplo 3: a=0, b=1 con while (a++ primero, luego b += a)
            Resultado: a=4, b=11

        Ejemplo 4: Pedir numeros hasta que se introduzca un 0
            - Con while: el codigo pide el primer numero antes del bucle
                         y vuelve a pedir dentro del bucle (codigo duplicado)
            - Con do-while: el codigo se escribe una sola vez dentro del do

        ================================================================
        """;

    // -------------------------------------------------------------
    // METODO PRINCIPAL
    // -------------------------------------------------------------

    public static void main(String[] args) {

        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: While - a=0, b=1 (primero b+=a, luego a++)
        // ============================================================

        separador("EJEMPLO 1: WHILE (b += a, luego a++)");

        int a = 0;
        int b = 1;

        while (a < 4) {
            b += a;   // b = b + a
            a++;      // a = a + 1
        }

        System.out.println("Resultado: a = " + a + ", b = " + b);
        // a=4, b=7

        // ============================================================
        // EJEMPLO 2: Do-while - a=0, b=1 (mismo orden que ejemplo 1)
        // ============================================================

        separador("EJEMPLO 2: DO-WHILE (b += a, luego a++)");

        a = 0;
        b = 1;

        do {
            b += a;
            a++;
        } while (a < 4);

        System.out.println("Resultado: a = " + a + ", b = " + b);
        // a=4, b=7

        // ============================================================
        // EJEMPLO 3: While - a=0, b=1 (primero a++, luego b+=a)
        // ============================================================

        separador("EJEMPLO 3: WHILE (a++ primero, luego b += a)");

        a = 0;
        b = 1;

        while (a < 4) {
            a++;      // a se incrementa primero
            b += a;   // luego se suma a b
        }

        System.out.println("Resultado: a = " + a + ", b = " + b);
        // a=4, b=11

        // ============================================================
        // EJEMPLO 4: Do-while - a=0, b=1 (a++ primero, luego b+=a)
        // ============================================================

        separador("EJEMPLO 4: DO-WHILE (a++ primero, luego b += a)");

        a = 0;
        b = 1;

        do {
            a++;
            b += a;
        } while (a < 4);

        System.out.println("Resultado: a = " + a + ", b = " + b);
        // a=4, b=11

        // ============================================================
        // EJEMPLO 5: Pedir numeros hasta 0 - CON WHILE
        // ============================================================

        separador("EJEMPLO 5: PEDIR NUMEROS HASTA 0 (CON WHILE)");

        java.util.Scanner teclado = new java.util.Scanner(System.in);

        System.out.print("Introduce un numero distinto de 0 para seguir en el bucle: ");
        int num = teclado.nextInt();

        while (num != 0) {
            System.out.print("Introduce un numero distinto de 0 para seguir en el bucle: ");
            num = teclado.nextInt();
        }

        System.out.println("Has introducido un 0. Bucle terminado.");
        System.out.println("(Nota: con while el codigo del mensaje se repite 2 veces)");

        // ============================================================
        // EJEMPLO 6: Pedir numeros hasta 0 - CON DO-WHILE (mas limpio)
        // ============================================================

        separador("EJEMPLO 6: PEDIR NUMEROS HASTA 0 (CON DO-WHILE)");

        int numero;

        do {
            System.out.print("Introduce un numero distinto de 0 para seguir en el bucle: ");
            numero = teclado.nextInt();
        } while (numero != 0);

        System.out.println("Has introducido un 0. Bucle terminado.");
        System.out.println("(Con do-while el codigo se escribe una sola vez)");

        // ============================================================
        // EJEMPLO 7: Sumar numeros hasta 0 con do-while
        // ============================================================

        separador("EJEMPLO 7: SUMAR NUMEROS HASTA 0 (CON DO-WHILE)");

        int valor;
        int total = 0;

        do {
            System.out.print("Introduce un numero (0 para terminar): ");
            valor = teclado.nextInt();
            total += valor;   // Se suma incluso el 0, pero no afecta
        } while (valor != 0);

        System.out.println("La suma total es: " + total);

        teclado.close();

        // ============================================================
        // RESUMEN DE CADA EJEMPLO
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ejemplo 1 (while, b+=a luego a++):       a=4, b=7");
        System.out.println("Ejemplo 2 (do-while, b+=a luego a++):    a=4, b=7");
        System.out.println("Ejemplo 3 (while, a++ luego b+=a):       a=4, b=11");
        System.out.println("Ejemplo 4 (do-while, a++ luego b+=a):    a=4, b=11");
        System.out.println();
        System.out.println("CONCLUSION: El orden de las instrucciones dentro del bucle");
        System.out.println("cambia el resultado final. La diferencia entre while y");
        System.out.println("do-while es que do-while ejecuta el cuerpo al menos una vez.");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Siguiente: Bucle FOR");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODO AUXILIAR: separador
    // -------------------------------------------------------------

    public static void separador(String titulo) {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("  " + titulo);
        System.out.println("============================================================");
    }
}
