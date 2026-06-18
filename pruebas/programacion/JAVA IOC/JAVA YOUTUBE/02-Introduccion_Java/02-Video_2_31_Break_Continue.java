class Video_2_31_Break_Continue {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "2-31 JAVA: Break y Continue [DAM - DAW]";
    public static final String URL = "https://www.youtube.com/watch?v=G1myD-SF3d8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=47";
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
          RESUMEN RAPIDO - BREAK y CONTINUE
        ====================================================================

        --- BREAK ---
            Termina el bucle por completo. El programa sigue
            ejecutando la instruccion siguiente al bucle.

            for (int i = 1; i <= 10; i++) {
                if (i == 8) {
                    break;   // <-- aqui se sale del bucle
                }
                System.out.println("Vuelta " + i);
            }
            System.out.println("Terminado");
            // Salida: Vuelta 1..7, y luego "Terminado"
            // La vuelta 8 NO imprime "Terminada vuelta 8"

        --- CONTINUE ---
            Termina la iteracion ACTUAL. No ejecuta el resto del
            cuerpo del bucle, pero SIGUE con la siguiente iteracion
            (incremento + condicion).

            for (int i = 1; i <= 10; i++) {
                if (i == 8) {
                    continue;  // <-- salta el resto de esta iteracion
                }
                System.out.println("Terminada vuelta " + i);
            }
            // Salida: Terminada vuelta 1..7, 9, 10
            // La vuelta 8 NO aparece, pero el bucle continua

        --- DIFERENCIA CLAVE (EXAMEN) ---
            break  -> se SALE del bucle (no ejecuta nada mas)
            continue -> se SALTA esa iteracion (pero el bucle sigue)

        --- ETIQUETAS (labels) ---
            Se puede poner una etiqueta antes del bucle y usar
            break etiqueta o continue etiqueta para saltar ahi.

            salir:
            for (int i = 1; i <= 10; i++) {
                if (i == 8) {
                    i++;
                    break salir;  // salta a la linea despues de salir:
                }
                System.out.println("Vuelta " + i);
            }

            NO RECOMENDADO para principiantes (parece GOTO).

        --- FOR SIN PARTES OBLIGATORIAS ---
            Todas las partes del for son OPCIONALES, pero los
            punto y coma (;) son OBLIGATORIOS.

            int n = 0;
            for (; ; ) {         // bucle infinito (sin condicion)
                if (n == 5) break;
                System.out.print(n + " ");
                n++;
            }
            // Salida: 0 1 2 3 4

            Equivale a:
            for (int n = 0; n != 5; n++) {
                System.out.print(n + " ");
            }

        --- IMPORTANTE PARA EXAMEN ---
            1. break TERMINA el bucle, continue SALTA una iteracion.
            2. continue solo afecta a la iteracion actual.
            3. break sirve para salir de bucles infinitos.
            4. Las etiquetas existen pero NO las uses en examenes.
            5. Las partes del for son opcionales (; son obligatorios).
            6. for(;;) es un bucle infinito: necesita break dentro.
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
        // EJEMPLO 1: BREAK - sale del bucle cuando i == 8
        // ============================================================

        separador("EJEMPLO 1: BREAK (cuando i == 8, sale del bucle)");
        System.out.println("Esperado: Vuelta 1..7, luego 'Terminado'");
        System.out.print("Real:     ");

        System.out.println("Empezamos...");
        for (int i = 1; i <= 10; i++) {
            System.out.println("  Vuelta " + i);
            if (i == 8) {
                break;   // el bucle termina aqui
            }
            System.out.println("  Terminada vuelta " + i);
        }
        System.out.println("  Terminado");
        System.out.println();

        // ============================================================
        // EJEMPLO 2: CONTINUE - salta iteracion i == 8
        // ============================================================

        separador("EJEMPLO 2: CONTINUE (cuando i == 8, salta iteracion)");
        System.out.println("Esperado: Vuelta 1..7, 9, 10 (falta 8)");
        System.out.print("Real:     ");

        System.out.println("Empezamos...");
        for (int i = 1; i <= 10; i++) {
            System.out.println("  Vuelta " + i);
            if (i == 8) {
                continue; // salta el resto del cuerpo, pero el bucle sigue
            }
            System.out.println("  Terminada vuelta " + i);
        }
        System.out.println("  Terminado");
        System.out.println();

        // ============================================================
        // EJEMPLO 3: ETIQUETA con break (break salir)
        //   Cuando i == 8, incrementa i a 9 y salta a la etiqueta
        //   Por tanto faltan las Vuelta 8 y Vuelta 9
        // ============================================================

        separador("EJEMPLO 3: ETIQUETA con break (break salir)");
        System.out.println("Esperado: Faltan Vuelta 8 y Vuelta 9");
        System.out.print("Real:     ");

        System.out.println("Empezamos...");
        salir:
        for (int i = 1; i <= 10; i++) {
            System.out.println("  Vuelta " + i);
            if (i == 8) {
                i++;        // i pasa a 9
                break salir; // salta a la linea despues de 'salir:'
            }
            System.out.println("  Terminada vuelta " + i);
        }
        System.out.println("  Terminado");
        System.out.println();

        // ============================================================
        // EJEMPLO 4: for SIN ninguna parte (for(;;) + break)
        //   Equivale a for (int n = 0; n != 5; n++)
        // ============================================================

        separador("EJEMPLO 4: for(;;) sin partes + break");
        System.out.println("Esperado: 0 1 2 3 4");
        System.out.print("Real:     ");

        int n = 0;
        for (; ; ) {          // bucle infinito (sin inicializacion, condicion ni incremento)
            if (n == 5) break; // condicion de salida
            System.out.print(n + " ");
            n++;
        }
        System.out.println(" (Terminado)");
        System.out.println();

        // ============================================================
        // EJEMPLO 5: for SIN inicializacion (variable declarada fuera)
        // ============================================================

        separador("EJEMPLO 5: for sin inicializacion");
        System.out.print("Real:     ");
        int m = 0;
        for (; m < 5; m++) {
            System.out.print(m + " ");
        }
        System.out.println(" (Terminado)");
        System.out.println();

        // ============================================================
        // EJEMPLO 6: for SIN inicializacion ni modificacion
        // ============================================================

        separador("EJEMPLO 6: for sin inicializacion ni modificacion");
        System.out.print("Real:     ");
        int p = 0;
        for (; p < 5; ) {
            System.out.print(p + " ");
            p++;
        }
        System.out.println(" (Terminado, pero desestructurado)");
        System.out.println();

        // ============================================================
        // RESUMEN DE TODOS LOS EJEMPLOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ejemplo 1: break  (i=8 sale)    -> Vuelta 1..7, Terminado");
        System.out.println("Ejemplo 2: continue (i=8 salta) -> Vuelta 1..7, 9, 10, Terminado");
        System.out.println("Ejemplo 3: break salir           -> Faltan Vuelta 8 y 9 (salta a etiqueta)");
        System.out.println("Ejemplo 4: for(;;) + break       -> 0 1 2 3 4");
        System.out.println("Ejemplo 5: for sin inicializ.    -> 0 1 2 3 4");
        System.out.println("Ejemplo 6: for sin inici. ni mod -> 0 1 2 3 4 (desestructurado)");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Bucles anidados");
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
