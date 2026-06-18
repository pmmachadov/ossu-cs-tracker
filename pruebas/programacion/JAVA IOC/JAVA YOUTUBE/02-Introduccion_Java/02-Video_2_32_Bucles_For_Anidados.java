class Video_2_32_Bucles_For_Anidados {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "2-32 JAVA: Bucles FOR anidados [DAM - DAW]";
    public static final String URL = "https://www.youtube.com/watch?v=UNbB2ItfccQ&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=48";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // RESUMEN para el examen (CHULETA)
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ====================================================================
          RESUMEN RAPIDO - BUCLES FOR ANIDADOS (IMPORTANTE para examen)
        ====================================================================

        --- ESTRUCTURA ---

            for (int j = 0; j < N; j++) {         // bucle EXTERNO
                for (int i = 0; i < M; i++) {     // bucle INTERNO
                    // codigo que se ejecuta N x M veces
                }
            }

        --- ORDEN DE EJECUCION ---
            1. Entra al bucle externo (j=0)
            2. Ejecuta COMPLETO el bucle interno (i=0,1,...,M-1)
            3. Incrementa j (j=1)
            4. Vuelve a ejecutar COMPLETO el bucle interno
            5. ... repetir hasta que j llegue a N

            El bucle interno se completa ENTERO por cada iteracion
            del bucle externo.

        --- CALCULAR ITERACIONES TOTALES ---
            Vueltas totales = N (externo) x M (interno)

        --- REGLAS PARA EXAMEN ---
            1. El bucle interno se REPITE varias veces (no una sola).
            2. El bucle externo controla CUANTAS VECES se ejecuta
               el bucle interno.
            3. Si hay instrucciones FUERA del interno pero DENTRO
               del externo, se ejecutan N veces (no N x M).
            4. Sin llaves en el externo: solo tiene UNA instruccion
               (el for interno), es valido pero no recomendado.
            5. Cuidado con variables que se modifican dentro:
               pueden cambiar el numero de iteraciones.

        --- EJEMPLOS TIPICOS ----
            for(j=0; j<100; j++)      // externo: 100 vueltas
                for(i=0; i<10; i++)   // interno: 10 vueltas
                    cantidad++;       // total: 100x10=1000

            for(j=1; j<100; j++)      // externo: 99 vueltas
                for(i=1; i<10; i++)   // interno: 9 vueltas
                    cantidad++;       // total: 99x9=891

            for(j=0; j<100; j++)      // externo: 100 vueltas
                for(i=0; i<=10; i++)  // interno: 11 vueltas (<=)
                    cantidad++;       // total: 100x11=1100

            for(j=1; j<=100; j++)     // externo: 100 vueltas (empieza en 1)
                for(i=1; i<10; i++)   // interno: 9 vueltas
                    cantidad++;       // total: 100x9=900

        --- INCREMENTOS DISTINTOS DE 1 ---
            for(j=0; j<=100; j+=2)        // 51 vueltas (0,2,4,...,100)
            for(i=0; i<=10; i+=3)         // 4 vueltas (0,3,6,9)
            for(j=0; j<=100; j+=2)        // externo: 51
                for(i=0; i<=10; i+=3)      // interno: 4
                    cantidad += 2;          // total: 51x4x2 + suma externo

        --- IMPORTANTE (EXAMEN) ---
            1. Siempre dibujar una tabla de seguimiento para no perderse.
            2. Si variables externas (a,b,c) se modifican dentro,
               el numero de iteraciones CAMBIA.
            3. j empieza en 0 -> j < N  -> N vueltas
            4. j empieza en 1 -> j <= N -> N vueltas
            5. j empieza en 0 -> j <= N -> N+1 vueltas
            6. j empieza en 1 -> j < N  -> N-1 vueltas
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
        // EJEMPLO 1: For anidado basico
        //   for (j=0; j < a; j++)    a=4 -> externo 4 vueltas
        //     for (i=0; i < b; i++)  b=3 -> interno 3 vueltas
        //     Imprime valor de i (0,1,2) cuatro veces
        // ============================================================

        separador("EJEMPLO 1: for anidado (j=0..3, i=0..2)");
        int a = 4, b = 3;
        System.out.println("a=" + a + ", b=" + b);
        System.out.println("Esperado: 0,1,2  (4 veces, una por cada iteracion de j)");
        System.out.print("Real:     ");
        for (int j = 0; j < a; j++) {
            System.out.print("[j=" + j + "]: ");
            for (int i = 0; i < b; i++) {
                System.out.print(i + " ");
            }
            System.out.print("| ");
        }
        System.out.println();
        System.out.println("Total iteraciones internas: " + (a * b));
        System.out.println();

        // ============================================================
        // EJEMPLO 2: For anidado (j=1..3, i=1..2) - imprime j
        //   a=3, b=2, externo 3 vueltas, interno 2 vueltas
        //   Imprime valor de j (1,1,2,2,3,3)
        // ============================================================

        separador("EJEMPLO 2: for anidado con j en print (a=3, b=2)");
        a = 3; b = 2;
        System.out.println("a=" + a + ", b=" + b);
        System.out.println("Esperado: 1,1,2,2,3,3");
        System.out.print("Real:     ");
        for (int j = 1; j <= a; j++) {
            for (int i = 1; i <= b; i++) {
                System.out.print(j + " ");
            }
        }
        System.out.println();
        System.out.println("Total iteraciones: " + (a * b));
        System.out.println();

        // ============================================================
        // EJEMPLO 3-6: Ejemplos de calcular cantidad de vueltas
        // ============================================================

        separador("EJEMPLO 3: for(j=0; j<100; j++) / for(i=0; i<10; i++)");
        int cantidad = 0;
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 10; i++) {
                cantidad++;
            }
        }
        System.out.println("  cantidad = " + cantidad + "  (100 x 10 = 1000)");
        System.out.println();

        separador("EJEMPLO 4: for(j=1; j<100; j++) / for(i=1; i<10; i++)");
        cantidad = 0;
        for (int j = 1; j < 100; j++) {
            for (int i = 1; i < 10; i++) {
                cantidad++;
            }
        }
        System.out.println("  cantidad = " + cantidad + "  (99 x 9 = 891)");
        System.out.println();

        separador("EJEMPLO 5: for(j=0; j<100; j++) / for(i=0; i<=10; i++)");
        cantidad = 0;
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i <= 10; i++) {
                cantidad++;
            }
        }
        System.out.println("  cantidad = " + cantidad + "  (100 x 11 = 1100)");
        System.out.println();

        separador("EJEMPLO 6: for(j=1; j<=100; j++) / for(i=1; i<10; i++)");
        cantidad = 0;
        for (int j = 1; j <= 100; j++) {
            for (int i = 1; i < 10; i++) {
                cantidad++;
            }
        }
        System.out.println("  cantidad = " + cantidad + "  (100 x 9 = 900)");
        System.out.println();

        // ============================================================
        // EJEMPLO 7: incrementos con += dentro del bucle interno y externo
        //   externo: 100 vueltas, interno: 10 vueltas
        //   cantidad += 2 dentro del interno (100x10x2=2000)
        //   cantidad++ dentro del externo (100)
        //   Total: 2100
        // ============================================================

        separador("EJEMPLO 7: externo 100, interno 10, cantidad+=2 y cantidad++");
        cantidad = 0;
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 10; i++) {
                cantidad += 2;  // 100 x 10 x 2 = 2000
            }
            cantidad++;  // 100
        }
        System.out.println("  cantidad = " + cantidad + "  (2000 + 100 = 2100)");
        System.out.println();

        // ============================================================
        // EJEMPLO 8: incrementos con += en externo e interno
        //   externo: 10 vueltas (j=0..9)
        //   interno: 10 vueltas (i=0,2,4,...,18) con i+=2
        //   cantidad += 3 dentro del interno (10x10x3=300)
        //   cantidad += 4 dentro del externo (10x4=40)
        //   Total: 340
        // ============================================================

        separador("EJEMPLO 8: externo 10, interno i+=2, cant+=3 y cant+=4");
        cantidad = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 20; i += 2) {  // i = 0,2,4,...,18 -> 10 vueltas
                cantidad += 3;
            }
            cantidad += 4;
        }
        System.out.println("  cantidad = " + cantidad + "  (300 + 40 = 340)");
        System.out.println();

        // ============================================================
        // EJEMPLO 9: for sin llaves en externo (solo interno)
        //   Ambos dan el mismo resultado:
        //   for(j...) for(i...) -> valido (externo tiene 1 instruccion)
        // ============================================================

        separador("EJEMPLO 9: for externo SIN llaves");
        System.out.println("  Es valido: el externo solo tiene 1 instruccion (el for interno)");
        cantidad = 0;
        for (int j = 0; j < 3; j++)
            for (int i = 0; i < 2; i++)
                cantidad++;
        System.out.println("  cantidad = " + cantidad + "  (3 x 2 = 6)");
        System.out.println();

        // ============================================================
        // EJEMPLO 10: Seguimiento completo (a=5, b=2, c=3)
        //   El bucle modifica a, b y c dentro, afectando las iteraciones
        //   Resultado final: a=7, b=0, c=6
        // ============================================================

        separador("EJEMPLO 10: SEGUIMIENTO (a=5, b=2, c=3)");
        int A = 5, B = 2, C = 3;
        System.out.println("Valores iniciales: a=" + A + ", b=" + B + ", c=" + C);
        System.out.println("for (int j=1; j <= a; j++)");
        System.out.println("  for (int i=1; i <= b; i++)");
        System.out.println("    c = a++;");
        System.out.println("    b--;");
        System.out.println();

        for (int j = 1; j <= A; j++) {
            for (int i = 1; i <= B; i++) {
                C = A++;   // C toma el valor de A, luego A se incrementa
                B--;       // B disminuye en 1
                System.out.println("  j=" + j + ", i=" + i + " -> a=" + A + ", b=" + B + ", c=" + C);
            }
        }
        System.out.println("  (j llega a 8 porque a=7 >= 7 en ultima iteracion)");
        System.out.println("Valores finales: a=" + A + ", b=" + B + ", c=" + C);
        System.out.println();

        // ============================================================
        // RESUMEN DE TODOS LOS EJEMPLOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ejemplo 1:  anidado basico (a=4, b=3)           -> 0,1,2 x4      total: 12");
        System.out.println("Ejemplo 2:  anidado imprime j (a=3, b=2)       -> 1,1,2,2,3,3  total: 6");
        System.out.println("Ejemplo 3:  j<100, i<10                         -> cantidad=1000");
        System.out.println("Ejemplo 4:  j=1..99, i=1..9                    -> cantidad=891");
        System.out.println("Ejemplo 5:  j<100, i<=10                       -> cantidad=1100");
        System.out.println("Ejemplo 6:  j<=100, i=1..9                     -> cantidad=900");
        System.out.println("Ejemplo 7:  cant+=2 interno, cant++ externo    -> cantidad=2100");
        System.out.println("Ejemplo 8:  i+=2, cant+=3 int, cant+=4 ext    -> cantidad=340");
        System.out.println("Ejemplo 9:  for sin llaves en externo          -> cantidad=6");
        System.out.println("Ejemplo 10: seguimiento a=5,b=2,c=3            -> a=7,b=0,c=6");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Llaves y ambito de variables en Java");
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
