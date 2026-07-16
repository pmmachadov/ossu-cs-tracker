class Video_4_26_Examen_Test_1a_Evaluacion {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-26 DAM - DAW: Examen JAVA Resuelto - TEST 1a Evaluacion";
    public static final String URL = "https://www.youtube.com/watch?v=pUBBuTAd0Co&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=92";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 4";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // RESUMEN para el examen (CHULETA)
    // -------------------------------------------------------------
    public static final String RESUMEN = """
            ====================================================================
              RESUMEN RAPIDO - EXAMEN TEST 1a EVALUACION (TEMA 4 - V26)
            ====================================================================

            --- ESTRUCTURA DEL EXAMEN ---
            - Parte 1: TEST (10 preguntas, 30 minutos, SIN apuntes, 2.5 puntos)
            - Parte 2: Practico (2 horas, CON apuntes, 7.5 puntos)
            - Unico material permitido en el test: tabla ASCII

            --- PREGUNTA 1: POST-INCREMENTO ---
            int a = 1;
            a = a++;
            Resultado: a = 1

            Explicacion: a = a++ primero asigna el valor actual (1) y luego
            incrementa. Como la asignacion guarda el valor ANTES de incrementar,
            a termina siendo 1.

            --- PREGUNTA 2: CONCATENACION STRING + INT ---
            String cad = "AA";
            char letra = 'a';
            int num = 1;
            cad = cad + letra;     // "AAa"
            cad = cad + 'A';       // "AAaA"
            cad = cad + num;       // "AAaA1"
            cad += 1 + 2;          // "AAaA13"  (1+2=3, se concatena como String)
            Resultado: "AAaA13"

            Clave: 1+2 se suma primero (3) y luego se concatena al String.

            --- PREGUNTA 3: BUCLE CON STRING Y LENGTH ---
            String cad = "AB";
            for (int i = 0; i < 2; i++) {
                cad = cad + 1 + 2;  // sin parentesis -> concatena "1" y "2"
            }
            System.out.println(cad + " y tiene " + cad.length() + " caracteres");
            Resultado: "AB1212 y tiene 14 caracteres"

            Clave: 1+2 sin parentesis en String se concatena como "1"+"2", no se suma.

            --- PREGUNTA 4: TABLA ASCII + CARACTERES ---
            char letra = 50;        // '2' en ASCII
            letra *= 2;             // 100 -> 'd' en ASCII
            for (int i = 0; i < 5; i++) {
                letra++;            // 101='e', 102='f', 103='g', 104='h', 105='i'
                System.out.print(letra);
            }
            System.out.println(": letra final = " + letra + 1);
            Resultado: "efghi: letra final = i1"

            Clave: letra+1 al final concatena porque hay un String antes.

            --- PREGUNTA 5: BARRA r (CARRIAGE RETURN) ---
            String cad = "Hola";
            for (int i = 0; i < 4; i++) {
                cad += "\\r" + i;     // \\r vuelve al principio de linea
            }
            Resultado: "3ola"

            Explicacion: \\r mueve el cursor al principio. Cada iteracion
            sobrescribe el primer caracter.
            - Tras i=0: "\\r0" + "Hola" -> "0ola"
            - Tras i=1: "\\r1" + "0ola" -> "1ola"
            - Tras i=2: "\\r2" + "1ola" -> "2ola"
            - Tras i=3: "\\r3" + "2ola" -> "3ola"





































            --- PREGUNTA 6: PRE-INCREMENTO + BUCLE ---
            int a = 1, b = 2;
            if (++a > b++) {
                a++;
            }
            for (int i = 0; i < a; i++) {
                a = i;
                if (a == i) break;
            }
            Resultado: a = 3
























            --- PREGUNTA 7: IFs ANIDADOS + OPERADORES ---
            int x = 1, y = 5, z = 10;
            if (!false) { }         // siempre true, no hace nada
            x += y;                 // x = 6
            x--;                    // x = 5
            if (x == y) y += x;     // 5==5 -> y = 10
            if (!(x != y && y == z)) { }    // !(true && true) = false
            if (x == y);            // punto y coma -> if vacio
            z -= y;                 // z = 0
            x += x;                 // x = 10
            Resultado: x=10, y=10, z=0

            Clave: if(x == y); con punto y coma NO ejecuta la siguiente linea.
























            --- PREGUNTA 8: BUCLES ANIDADOS ---
            int a = 0;
            for (int i = 1; i < 10; i++)       // 9 vueltas
                for (int j = 1; j < 50; j++)   // 49 vueltas
                    a += 2;                     // 9 * 49 * 2 = 882
            Resultado: a = 882

            --- PREGUNTA 9: RECURSIVIDAD ---
            static void cadena(String cad, int n) {
                if (n == 3) {
                    System.out.println(cad);
                } else {
                    cadena(cad + n, n + 1);
                }
            }
            // Invocacion: cadena("Hola", 0);
            Traza:
            cadena("Hola", 0) -> cadena("Hola0", 1)
            cadena("Hola0", 1) -> cadena("Hola01", 2)
            cadena("Hola01", 2) -> cadena("Hola012", 3)
            cadena("Hola012", 3) -> n==3 -> print("Hola012")
            Resultado: "Hola012"

            --- PREGUNTA 10: OPERADOR TERNARIO ---
            int a = 1, b = 1;
            a = (a != b) ? a + b : a - b;  // a != b? false -> a - b = 0
            Resultado: a = 0

            --- DISTRIBUCION PUNTUACION ---
            Test: 2.5 puntos (25%)
            Practico: 7.5 puntos (75%)
            Total: 10 puntos

            ====================================================================
            """;

    // -------------------------------------------------------------
    // METODO: Resolver cada pregunta del test
    // -------------------------------------------------------------
    static void pregunta1() {
        System.out.println("\n--- PREGUNTA 1: Post-incremento ---");
        int a = 1;
        a = a++;
        System.out.println("int a = 1; a = a++; -> a = " + a);
        System.out.println("(Explicacion: primero asigna el valor actual (1), luego incrementa)");
    }

    static void pregunta2() {
        System.out.println("\n--- PREGUNTA 2: Concatenacion String + int ---");
        String cad = "AA";
        char letra = 'a';
        int num = 1;
        cad = cad + letra;
        cad = cad + 'A';
        cad = cad + num;
        cad += 1 + 2;
        System.out.println("cad = \"AA\"; cad = cad + 'a'; cad = cad + 'A'; cad = cad + 1; cad += 1+2;");
        System.out.println("Resultado: " + cad + "  (clave: 1+2 se suma primero = 3)");
    }

    static void pregunta3() {
        System.out.println("\n--- PREGUNTA 3: Bucle con String y length ---");
        String cad = "AB";
        for (int i = 0; i < 2; i++) {
            cad = cad + 1 + 2;
        }
        System.out.println("cad = \"AB\"; for(i=0;i<2;i++) cad = cad + 1 + 2;");
        System.out.println("Resultado: " + cad + " y tiene " + cad.length() + " caracteres");
        System.out.println("(Clave: 1+2 sin parentesis concatena \"1\"+\"2\", no suma)");
    }

    static void pregunta4() {
        System.out.println("\n--- PREGUNTA 4: Tabla ASCII + caracteres ---");
        char letra = 50; // '2' en ASCII
        letra *= 2; // 100 -> 'd'
        System.out.print("char letra=50; letra*=2; for(5 veces) letra++; -> ");
        for (int i = 0; i < 5; i++) {
            letra++;
            System.out.print(letra);
        }
        System.out.println(": letra final = " + letra + 1);
        System.out.println("(Clave: 50*2=100='d', luego e,f,g,h,i)");
    }

    static void pregunta5() {
        System.out.println("\n--- PREGUNTA 5: Barra r (carriage return) ---");
        String cad = "Hola";
        for (int i = 0; i < 4; i++) {
            cad += "\r" + i;
        }
        System.out.println("cad = \"Hola\"; for(i=0;i<4;i++) cad += \"\\\\r\" + i;");
        System.out.println("Resultado (en consola se ve como): \"" + cad + "\"");
        System.out.println("(\\\\r vuelve al principio y sobrescribe)");
    }

    static void pregunta6() {
        System.out.println("\n--- PREGUNTA 6: Pre-incremento + bucle + break ---");
        int a = 1, b = 2;
        if (++a > b++) {
            a++;
        }
        System.out.println("  Tras if: a=" + a + ", b=" + b);
        for (int i = 0; i < a; i++) {
            a = i;
            System.out.println("  i=" + i + ", a=" + a);
            if (a == i)
                break;
        }
        System.out.println("Resultado: a = " + a);
    }

    static void pregunta7() {
        System.out.println("\n--- PREGUNTA 7: Ifs anidados + operadores logicos ---");
        int x = 1, y = 5, z = 10;
        if (!false) {
        }
        x += y;
        x--;
        if (x == y)
            y += x;
        if (!(x != y && y == z)) {
        }
        if (x == y)
            ; // punto y coma -> if vacio
        z -= y;
        x += x;
        System.out.println("Resultado: x=" + x + ", y=" + y + ", z=" + z);
        System.out.println("(Clave: if(x==y); con punto y coma NO ejecuta la sig. linea)");
    }

    static void pregunta8() {
        System.out.println("\n--- PREGUNTA 8: Bucles anidados ---");
        int a = 0;
        for (int i = 1; i < 10; i++)
            for (int j = 1; j < 50; j++)
                a += 2;
        System.out.println("for(i=1;i<10;i++) for(j=1;j<50;j++) a+=2;");
        System.out.println("Resultado: a = " + a + "  (9*49*2 = 882)");
    }

    static void pregunta9() {
        System.out.println("\n--- PREGUNTA 9: Recursividad ---");
        System.out.print("cadena(\"Hola\", 0) -> ");
        cadena("Hola", 0);
        System.out.println("(Traza: Hola0 -> Hola01 -> Hola012 -> print)");
    }

    static void cadena(String cad, int n) {
        if (n == 3) {
            System.out.println(cad);
        } else {
            cadena(cad + n, n + 1);
        }
    }

    static void pregunta10() {
        System.out.println("\n--- PREGUNTA 10: Operador ternario ---");
        int a = 1, b = 1;
        a = (a != b) ? a + b : a - b;
        System.out.println("int a=1,b=1; a = (a!=b) ? a+b : a-b;");
        System.out.println("Resultado: a = " + a + "  (a==b -> a-b = 0)");
    }

    // -------------------------------------------------------------
    // METODO PRINCIPAL
    // -------------------------------------------------------------
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("EXAMEN 1a EVALUACION - DAM/DAW");
        System.out.println("Parte 1: TEST (30 min, sin apuntes, 2.5 puntos)");
        System.out.println("Parte 2: Practico (2h, con apuntes, 7.5 puntos)");
        System.out.println();

        separador("RESOLUCION DEL TEST (10 preguntas)");

        pregunta1();
        pregunta2();
        pregunta3();
        pregunta4();
        pregunta5();
        pregunta6();
        pregunta7();
        pregunta8();
        pregunta9();
        pregunta10();

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 4 - V26: EXAMEN TEST 1a EVALUACION)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("NOTAS:");
        System.out.println("- Este test se hace SIN apuntos (solo tabla ASCII)");
        System.out.println("- 30 minutos para 10 preguntas");
        System.out.println("- Cada pregunta vale 0.25 puntos (total 2.5)");
        System.out.println("- La parte practica vale 7.5 puntos");
        System.out.println("- Total examen: 10 puntos");
    }

    // -------------------------------------------------------------
    // METODO AUXILIAR
    // -------------------------------------------------------------
    public static void separador(String titulo) {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("  " + titulo);
        System.out.println("============================================================");
    }
}
