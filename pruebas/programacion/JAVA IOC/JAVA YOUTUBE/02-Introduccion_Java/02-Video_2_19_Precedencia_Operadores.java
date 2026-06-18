class Video_2_19_Precedencia_Operadores {

    public static final String TITULO = "JAVA: Precedencia de operadores \u2615 DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=_GJldn1wQvw&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=35";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-19 PRECEDENCIA DE OPERADORES EN JAVA
        ================================================================

        Video:        JAVA: Precedencia de operadores
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2

        --- TABLA DE PRECEDENCIA (de mayor a menor prioridad) ---

        Grupo  Operadores                        Asociatividad
        -----  ---------------------------------  -------------
          1    () paréntesis                      izquierda
          2    ++ -- + - ~ ! (unarios)            derecha a izquierda
          3    * / %                              izquierda
          4    + -                                izquierda
          5    << >> >>>                          izquierda
          6    < <= > >=                          izquierda
          7    == !=                              izquierda
          8    & (AND bit a bit)                  izquierda
          9    ^ (XOR bit a bit)                  izquierda
         10    | (OR bit a bit)                   izquierda
         11    && (AND lógico)                    izquierda
         12    || (OR lógico)                     izquierda
         13    ? : (ternario)                     derecha a izquierda
         14    = += -= *= /= %= &= ^= |= <<= >>= >>>=  derecha a izquierda

        --- REGLAS IMPORTANTES ---

        * Misma prioridad -> evaluar de izquierda a derecha
        * Los incrementos/decrementos (++ --) se resuelven ANTES
          que cualquier operacion aritmetica, aunque haya parentesis
        * ++var: incrementa primero, luego usa el valor
        * var++: usa el valor primero, luego incrementa
        * Los parentesis tienen maxima prioridad, pero los unarios
          (++, --) se resuelven antes incluso que lo que hay dentro
          de los parentesis
        * Asignacion (= y operadores compuestos) tiene la MENOR prioridad

        --- EJEMPLOS DEL VIDEO ---

        EJEMPLO 1: Incrementos y parentesis
        int n = 2;
        int m = ++n * 3 + 2 + (++n);
        // 1. ++n -> n=3 (preincremento)
        // 2. ++n dentro de () -> n=4
        // 3. 3 * 3 = 9
        // 4. 9 + 2 = 11
        // 5. 11 + 4 = 15
        // Resultado: m = 15 (en el video dice 12 si se evalua mal)

        EJEMPLO 2: Otro caso
        n = 2;
        int x = ++n + 2 + 3 * n++;
        // 1. ++n -> n=3
        // 2. n++ -> se usara n=3, luego n=4
        // 3. 3 * 3 = 9
        // 4. 9 + 3 = 12
        // 5. 12 + 2 = 14
        // Resultado: x = 14, n final = 4

        EJEMPLO 3: Parentesis que cambian el resultado
        n = 2;
        int y = ++n + 2 + 3 * (n++ + 1);
        // 1. ++n global -> n=3
        // 2. Dentro de (): n++ + 1 = 3 + 1 = 4, luego n=4
        // 3. 3 * 4 = 12
        // 4. 12 + 3 = 15
        // 5. 15 + 2 = 17
        // Resultado: y = 17, n final = 4

        --- BLOQUE 1: OPERACIONES CON ENTEROS ---

        int n = 9;
        n = 2 + 3 / 2 * 8 / 4 + 5;
        // 3/2 = 1 (division entera, no 1.5)
        // 1 * 8 = 8
        // 8 / 4 = 2
        // 2 + 2 + 5 = 9
        // Resultado: n = 9

        n = 9;
        n *= 4 + 2 * 3;
        // 2 * 3 = 6
        // 4 + 6 = 10
        // n *= 10  (n = 9 * 10 = 90)
        // Resultado: n = 90

        n += n++ + 3 - n;
        // n++ -> se usa n=90, luego n=91
        // n + 3 - n = 90 + 3 - 91 = 2
        // n += 2 (n = 91 + 2 = 93)
        // Resultado: n = 93 (el video dice 92, version exacta depende del orden)

        --- BLOQUE 2: OPERACIONES CON DOUBLE ---

        double d1 = 1, d2 = 2, d3;
        d3 = d2++ + d1 / d2 * 3 + d1;
        // 1. d2++ -> se usa d2=2, luego d2=3
        // 2. d1 / d2 = 1.0 / 3.0 = 0.333...
        // 3. 0.333... * 3 = 1.0
        // 4. d2++ resultado = 2
        // 5. 2 + 1.0 + 1 = 4.0
        // Resultado: d3 = 4.0

        --- BLOQUE 3: OPERACIONES CON BOOLEANOS ---

        boolean con1 = true, con2 = false, con3 = false;
        int a = 1, b = 2, c = 3;

        // Expresion 1:
        con3 = a++ == b || a == b;
        // 1. a++ == b -> 1 == 2 -> false, a=2
        // 2. a == b -> 2 == 2 -> true
        // 3. false || true -> true
        // Resultado: con3 = true

        // Expresion 2:
        a = 1; b = 2; c = 3;
        con1 = true; con2 = false; con3 = false;
        con3 = a++ == c-- && (con2 ^ con1) || con1;
        // 1. a++ -> se usa a=1, luego a=2
        // 2. c-- -> se usa c=3, luego c=2
        // 3. a++ == c-- -> 1 == 3 -> false
        //    (a=2, c=2 despues de la comparacion)
        // 4. con2 ^ con1 -> false ^ true -> true
        // 5. false && true -> false
        // 6. false || con1 -> false || true -> true
        // Resultado: con3 = true

        // Expresion 3:
        a = 1; b = 2; c = 3;
        con1 = true; con2 = false; con3 = false;
        con3 = !!con2 || (con1 && !(con2 ^ con1) && con2);
        // 1. !!con2 -> !(!false) = !true = false
        // 2. Dentro de ():
        //    a. con2 ^ con1 -> false ^ true -> true
        //    b. !(true) -> false
        //    c. con1 && false && con2 -> true && false && false -> false
        // 3. false || false -> false
        // Resultado: con3 = false

        --- RESUMEN DE PRECEDENCIA ---

        Mas prioridad:
          1. Parentesis ()
          2. Unarios: ++ -- + - ~ !
          3. Multiplicativos: * / %
          4. Aditivos: + -
          5. Desplazamiento: << >> >>>
          6. Relacionales: < <= > >=
          7. Igualdad: == !=
          8. AND bit: &
          9. XOR bit: ^
         10. OR bit: |
         11. AND logico: &&
         12. OR logico: ||
         13. Ternario: ? :
         14. Asignacion: = += -= *= /= %= etc.
        Menos prioridad

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Los unarios (++ --) se evaluan ANTES que todo lo demas
        * Division entera: 3/2 = 1 (trunca decimales)
        * *=, += etc. tienen la menor prioridad: evaluan primero
          todo lo de la derecha, luego asignan
        * Para evitar errores: USA PARENTESIS aunque no hagan falta
        * ++var (pre) y var++ (post) cambian el orden de uso del valor
        * Con misma prioridad: evaluar de izquierda a derecha
        ================================================================
        """;

    public static void main(String[] args) {
        mostrarInformacion();
        System.out.println();
        ejecutarEjemplos();
    }

    // -------------------------------------------------------------
    // Ejemplos practicos del video
    // -------------------------------------------------------------
    public static void ejecutarEjemplos() {
        System.out.println("============================================");
        System.out.println("   EJEMPLOS PRACTICOS DEL VIDEO");
        System.out.println("============================================");

        // ---- EJEMPLO 1 ----
        System.out.println();
        System.out.println("--- EJEMPLO 1: ++n * 3 + 2 + (++n) ---");
        int n = 2;
        int m = ++n * 3 + 2 + (++n);
        System.out.println("int n = 2;");
        System.out.println("int m = ++n * 3 + 2 + (++n);");
        System.out.println("m = " + m + ", n final = " + n);
        System.out.println("Explicacion:");
        System.out.println("  1. ++n global   -> n=3");
        System.out.println("  2. ++n en ()    -> n=4");
        System.out.println("  3. 3 * 3 = 9");
        System.out.println("  4. 9 + 2 = 11");
        System.out.println("  5. 11 + 4 = 15");

        // ---- EJEMPLO 2 ----
        System.out.println();
        System.out.println("--- EJEMPLO 2: ++n + 2 + 3 * n++ ---");
        n = 2;
        int x = ++n + 2 + 3 * n++;
        System.out.println("n = 2;");
        System.out.println("int x = ++n + 2 + 3 * n++;");
        System.out.println("x = " + x + ", n final = " + n);
        System.out.println("Explicacion:");
        System.out.println("  1. ++n          -> n=3");
        System.out.println("  2. n++          -> se usa n=3, luego n=4");
        System.out.println("  3. 3 * 3 = 9");
        System.out.println("  4. 9 + 3 = 12");
        System.out.println("  5. 12 + 2 = 14");

        // ---- EJEMPLO 3 ----
        System.out.println();
        System.out.println("--- EJEMPLO 3: ++n + 2 + 3 * (n++ + 1) ---");
        n = 2;
        int y = ++n + 2 + 3 * (n++ + 1);
        System.out.println("n = 2;");
        System.out.println("int y = ++n + 2 + 3 * (n++ + 1);");
        System.out.println("y = " + y + ", n final = " + n);
        System.out.println("Explicacion:");
        System.out.println("  1. ++n global   -> n=3");
        System.out.println("  2. (n++ + 1)    -> 3 + 1 = 4, luego n=4");
        System.out.println("  3. 3 * 4 = 12");
        System.out.println("  4. 12 + 3 = 15");
        System.out.println("  5. 15 + 2 = 17");

        // ---- BLOQUE 1 ----
        System.out.println();
        System.out.println("--- BLOQUE 1: OPERACIONES CON ENTEROS ---");

        n = 9;
        n = 2 + 3 / 2 * 8 / 4 + 5;
        System.out.println("n = 9;");
        System.out.println("n = 2 + 3 / 2 * 8 / 4 + 5;");
        System.out.println("n = " + n);
        System.out.println("Explicacion: 3/2=1 (entero), 1*8=8, 8/4=2, 2+2+5=9");

        n = 9;
        n *= 4 + 2 * 3;
        System.out.println();
        System.out.println("n = 9;");
        System.out.println("n *= 4 + 2 * 3;");
        System.out.println("n = " + n);
        System.out.println("Explicacion: 2*3=6, 4+6=10, n=9*10=90");

        n = 90;
        n += n++ + 3 - n;
        System.out.println();
        System.out.println("n = 90;");
        System.out.println("n += n++ + 3 - n;");
        System.out.println("n = " + n);
        System.out.println("Explicacion: n++ usa 90 -> n=91, 90+3-91=2, n=91+2=93");

        // ---- BLOQUE 2 ----
        System.out.println();
        System.out.println("--- BLOQUE 2: OPERACIONES CON DOUBLE ---");

        double d1 = 1, d2 = 2, d3;
        d3 = d2++ + d1 / d2 * 3 + d1;
        System.out.println("double d1=1, d2=2, d3;");
        System.out.println("d3 = d2++ + d1 / d2 * 3 + d1;");
        System.out.println("d3 = " + d3 + ", d2 final = " + d2);
        System.out.println("Explicacion: d2++ usa 2 -> d2=3, 1/3*3=1, 2+1+1=4.0");

        // ---- BLOQUE 3 ----
        System.out.println();
        System.out.println("--- BLOQUE 3: OPERACIONES CON BOOLEANOS ---");

        // Expresion 1
        boolean con1 = true, con2 = false, con3 = false;
        int a = 1, b = 2, c = 3;
        con3 = a++ == b || a == b;
        System.out.println("boolean con1=true, con2=false, con3=false;");
        System.out.println("int a=1, b=2, c=3;");
        System.out.println("con3 = a++ == b || a == b;");
        System.out.println("con3 = " + con3 + ", a final = " + a);
        System.out.println("Explicacion: a++==b -> 1==2 false (a=2), a==b -> 2==2 true, false||true=true");

        // Expresion 2
        a = 1; b = 2; c = 3;
        con1 = true; con2 = false; con3 = false;
        con3 = a++ == c-- && (con2 ^ con1) || con1;
        System.out.println();
        System.out.println("a=1; b=2; c=3; con1=true; con2=false; con3=false;");
        System.out.println("con3 = a++ == c-- && (con2 ^ con1) || con1;");
        System.out.println("con3 = " + con3 + ", a=" + a + ", c=" + c);
        System.out.println("Explicacion: a++==c-- -> 1==3 false, con2^con1 -> true, false&&true=false, false||true=true");

        // Expresion 3
        a = 1; b = 2; c = 3;
        con1 = true; con2 = false; con3 = false;
        con3 = !!con2 || (con1 && !(con2 ^ con1) && con2);
        System.out.println();
        System.out.println("a=1; b=2; c=3; con1=true; con2=false; con3=false;");
        System.out.println("con3 = !!con2 || (con1 && !(con2 ^ con1) && con2);");
        System.out.println("con3 = " + con3);
        System.out.println("Explicacion: !!false = false, (con2^con1)=true, !true=false, true&&false&&false=false, false||false=false");
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
