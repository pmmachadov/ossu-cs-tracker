class Video_2_37_Ejercicios_Figuras {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "2-37 JAVA: Ejercicios resueltos FIGURAS [DAM - DAW]";
    public static final String URL = "https://www.youtube.com/watch?v=8jNcf21kvbk&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=53";
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
          RESUMEN RAPIDO - EJERCICIOS DE FIGURAS (Para el examen)

               *
             * * *
            * * *  *
        ====================================================================

        --- ESTRUCTURA BASICA: BUCLE FOR DOBLE ---
        for (int i = 0; i < altura; i++) {     // filas (externo)
            for (int j = 0; j < base; j++) {   // columnas (interno)
                // pintar asterisco o espacio
            }
            System.out.println();               // salto de linea
        }

        --- EJERCICIO 1: RECTANGULO ---
        Con relleno: siempre pintar asterisco.
        Sin relleno (borde):
            if (i == 0 || i == altura-1 || j == 0 || j == base-1) {
                System.out.print("* ");
            } else {
                System.out.print("  ");
            }

        --- EJERCICIO 2: TRIANGULO RECTANGULO ---
        Con relleno:
            for (int j = 0; j <= i; j++) { ... }  // j <= i!
        Sin relleno:
            if (i == 0 || i == altura-1 || j == 0 || j == i) { ... }

        --- EJERCICIO 3: TRIANGULO EQUILATERO ---
        La base se calcula: base = altura * 2 - 1
        Punto central: centro = base / 2 (o altura - 1)

        Con relleno: pintar asterisco si j entre [centro-i, centro+i]
        Sin relleno: pintar asterisco si j == centro-i || j == centro+i
                     o si i == altura-1 (ultima fila, todo asteriscos)

        --- CLAVES PARA EXAMEN ---
        1. For externo = filas, for interno = columnas.
        2. i == 0 -> primera fila. i == altura-1 -> ultima fila.
        3. j == 0 -> primera columna. j == base-1 -> ultima columna.
        4. Triangulo rectangulo: j <= i (crece con cada fila).
        5. Triangulo equilatero: centro = base/2, rango [centro-i, centro+i].
        6. Siempre System.out.println() al final del for interno.
        7. Sin relleno = solo bordes (primera/ultima fila y columna).
        """;

    // -------------------------------------------------------------
    // METODO PRINCIPAL
    // -------------------------------------------------------------

    public static void main(String[] args) {

        java.util.Scanner entrada = new java.util.Scanner(System.in);

        separador("EJERCICIO 1: RECTANGULO");
        System.out.println("  Dibuja un rectangulo de asteriscos (con y sin relleno).");
        System.out.println("  Se pide base y altura.");
        System.out.println();

        separador("EJERCICIO 2: TRIANGULO RECTANGULO");
        System.out.println("  Dibuja un triangulo rectangulo (con y sin relleno).");
        System.out.println("  Se pide altura.");
        System.out.println();

        separador("EJERCICIO 3: TRIANGULO EQUILATERO");
        System.out.println("  Dibuja un triangulo equilatero (con y sin relleno).");
        System.out.println("  Se pide altura. Base = altura * 2 - 1");
        System.out.println();

        // ============================================================
        // EJERCICIO 1: Rectangulo (con y sin relleno)
        // ============================================================

        separador("SOLUCION EJERCICIO 1");
        int base = 10;
        int altura = 5;
        System.out.println("  Demo: base=" + base + ", altura=" + altura);
        System.out.println();

        System.out.println("  RECTANGULO CON RELLENO:");
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("  RECTANGULO SIN RELLENO (borde):");
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                if (i == 0 || i == altura-1 || j == 0 || j == base-1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();

        // ============================================================
        // EJERCICIO 2: Triangulo rectangulo (con y sin relleno)
        // ============================================================

        separador("SOLUCION EJERCICIO 2");
        int alturaT = 5;
        System.out.println("  Demo: altura=" + alturaT);
        System.out.println();

        System.out.println("  TRIANGULO RECTANGULO CON RELLENO:");
        for (int i = 0; i < alturaT; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("  TRIANGULO RECTANGULO SIN RELLENO:");
        for (int i = 0; i < alturaT; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 || i == alturaT-1 || j == 0 || j == i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();

        // ============================================================
        // EJERCICIO 3: Triangulo equilatero (con y sin relleno)
        // ============================================================

        separador("SOLUCION EJERCICIO 3");
        int altE = 5;
        int baseE = altE * 2 - 1;
        System.out.println("  Demo: altura=" + altE + ", base=" + baseE);
        System.out.println();

        System.out.println("  TRIANGULO EQUILATERO CON RELLENO:");
        for (int i = 0; i < altE; i++) {
            for (int j = 0; j < baseE; j++) {
                int centro = baseE / 2;
                if (j >= centro - i && j <= centro + i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("  TRIANGULO EQUILATERO SIN RELLENO:");
        for (int i = 0; i < altE; i++) {
            for (int j = 0; j < baseE; j++) {
                int centro = baseE / 2;
                if (i == altE-1 || j == centro-i || j == centro+i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ejercicio 1: Rectangulo (base=10, altura=5)  -> con/sin relleno OK");
        System.out.println("Ejercicio 2: Triangulo rectangulo (altura=5) -> con/sin relleno OK");
        System.out.println("Ejercicio 3: Triangulo equilatero (altura=5) -> con/sin relleno OK");
        System.out.println("  (Base = 5*2-1 = 9)");
        System.out.println("  Centro = 9/2 = 4");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  (Fin de los ejercicios del TEMA 2)");
        System.out.println("============================================================");

        entrada.close();
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