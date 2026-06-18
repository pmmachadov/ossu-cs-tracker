class Video_2_30_Ejemplos_Bucle_For {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "2-30 JAVA: Ejemplos bucle FOR [DAM - DAW]";
    public static final String URL = "https://www.youtube.com/watch?v=XcxhYxAXCL0&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=46";
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
          RESUMEN RAPIDO - BUCLE FOR (Ejemplos practicos)
        ====================================================================

        Sintaxis basica:
            for (int i = 0; i < N; i++) { ... }

        --- Variaciones utiles (EXAMEN) ---

        for (int i = 0; i <= 100; i += 10)  -> 0, 10, 20, ..., 100
        for (int i = 0; i <  10; i++)       -> 0..9      (10 vueltas)
        for (int i = 0; i <= 10; i++)       -> 0..10     (11 vueltas)

        --- BUCLE INFINITO (CUIDADO) ---
            for (int i = 0; i < 10; J += i) { ... }
            Si la variable de la condicion (i) nunca se modifica,
            el bucle NO TERMINA NUNCA -> programa bloqueado.
            Solucion: Ctrl+C para detenerlo.

        --- VARIABLE CONTADOR CON OTRO INCREMENTO ---
            for (int j = 3; j < 10; j += j)  -> j=3, j=6, j=9
            for (int j = 1; j <= 100; j += 10) -> 1, 11, 21, ..., 91

        --- PEDIR N NUMEROS POR TECLADO ---
            Scanner entrada = new Scanner(System.in);
            int cantidadNumeros = 5;  // o pedirlo con entrada.nextInt()

            for (int i = 1; i <= cantidadNumeros; i++) {
                System.out.print("Dime un numero " + i + " de " + cantidadNumeros + ": ");
                int num = entrada.nextInt();
            }

        --- CALCULAR MEDIA DE N NUMEROS ---
            double suma = 0;
            for (int i = 1; i <= cantidadNumeros; i++) {
                System.out.print("Dime un numero " + i + " de " + cantidadNumeros + ": ");
                suma += entrada.nextInt();
            }
            double media = suma / cantidadNumeros;
            System.out.println("La media es: " + media);

        --- MUY IMPORTANTE PARA EXAMEN ---
            1. La variable del for SOLO existe dentro del bucle (scope).
            2. Si la condicion nunca cambia -> bucle INFINITO.
            3. Para numerar desde 1: for (int i = 1; i <= N; i++)
            4. Para sumar acumulados: variable += valor;
            5. Para mostrar en una linea: System.out.print() sin ln.
            6. entrada.close() para cerrar Scanner.
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
        // EJEMPLO 1: For basico de 0 a 9 (10 vueltas)
        //   for (int i = 0; i < 10; i++)
        // ============================================================

        separador("EJEMPLO 1: for (i=0; i < 10; i++)  -> 0..9");
        System.out.print("Salida: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println("  (10 iteraciones: i=0..9)");
        System.out.println();

        // ============================================================
        // EJEMPLO 2: For de 0 a 10 (11 vueltas, con <=)
        //   for (int i = 0; i <= 10; i++)
        // ============================================================

        separador("EJEMPLO 2: for (i=0; i <= 10; i++)  -> 0..10");
        System.out.print("Salida: ");
        for (int i = 0; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println("  (11 iteraciones: incluye el 10)");
        System.out.println();

        // ============================================================
        // EJEMPLO 3: For de 0 a 100 de 10 en 10
        //   for (int i = 0; i <= 100; i += 10)
        // ============================================================

        separador("EJEMPLO 3: for (i=0; i <= 100; i+=10)  -> 0, 10, 20, ..., 100");
        System.out.print("Salida: ");
        for (int i = 0; i <= 100; i += 10) {
            System.out.print(i + " ");
        }
        System.out.println("  (de 10 en 10 hasta 100)");
        System.out.println();

        // ============================================================
        // EJEMPLO 4: For con print (todo en una linea)
        // ============================================================

        separador("EJEMPLO 4: for (i=0; i < 10; i++) con print (sin ln)");
        System.out.print("Salida (todo en una linea): ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        // ============================================================
        // EJEMPLO 5: For con otra variable como incremento
        //   for (int j = 3; j < 10; j += j)
        //   j empieza en 3, se suma a si mismo: 3, 6, 9, (12 sale)
        // ============================================================

        separador("EJEMPLO 5: for (int j=3; j < 10; j += j)  -> 3, 6, 9");
        System.out.print("Salida: ");
        for (int j = 3; j < 10; j += j) {
            System.out.print(j + " ");
        }
        System.out.println("  (j se duplica: 3+3=6, 6+6=12>10 -> sale)");
        System.out.println();

        // ============================================================
        // EJEMPLO 6: BUCLE INFINITO (CUIDADO!)
        //   for (int i = 0; i < 10; j += i)
        //   i NUNCA se modifica -> bucle infinito!
        //   En el video se muestra y se para con Ctrl+C
        //   Aqui lo simulamos con un contador de seguridad
        // ============================================================

        separador("EJEMPLO 6: BUCLE INFINITO (simulado con seguridad)");
        System.out.println("  ADVERTENCIA: Si la variable de condicion nunca cambia,");
        System.out.println("  el bucle no termina -> programa bloqueado.");
        System.out.println("  En el video: for (int i=0; i<10; J += i)  -> i siempre 0!");
        System.out.println("  Solucion en terminal: Ctrl+C");
        System.out.println();
        System.out.println("  Simulacion controlada (solo 5 iteraciones):");
        int contadorSeguro = 0;
        for (int i = 0; i < 10; contadorSeguro++) {
            System.out.println("    Iteracion " + contadorSeguro + ": i=" + i + " (nunca cambia!)");
            if (contadorSeguro >= 4) {
                System.out.println("  -> Cortado por seguridad (bucle infinito real no pararia)");
                break;
            }
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 7: Pedir 5 numeros por teclado con for
        //   Scanner + for para pedir N valores
        // ============================================================

        separador("EJEMPLO 7: PEDIR 5 NUMEROS POR TECLADO");
        java.util.Scanner entrada = new java.util.Scanner(System.in);

        int cantidadNumeros = 5;
        System.out.println("(Introduce " + cantidadNumeros + " numeros)");
        for (int i = 1; i <= cantidadNumeros; i++) {
            System.out.print("  Dime un numero " + i + " de " + cantidadNumeros + ": ");
            int num = entrada.nextInt();
            // Aqui se podria usar el num para algo
        }
        System.out.println("  Gracias por introducir los " + cantidadNumeros + " numeros.");
        System.out.println();

        // ============================================================
        // EJEMPLO 8: Calcular la media de 5 numeros
        //   Acumular suma con += y dividir al final
        // ============================================================

        separador("EJEMPLO 8: CALCULAR LA MEDIA DE 5 NUMEROS");
        System.out.println("(Introduce " + cantidadNumeros + " numeros para calcular la media)");
        double suma = 0;
        for (int i = 1; i <= cantidadNumeros; i++) {
            System.out.print("  Dime un numero " + i + " de " + cantidadNumeros + ": ");
            suma += entrada.nextInt();
        }
        double media = suma / cantidadNumeros;
        System.out.println("  La suma es: " + suma);
        System.out.println("  La media es: " + media);
        System.out.println();

        // ============================================================
        // EJEMPLO 9: Pedir cantidad de numeros DINAMICA
        //   Primero preguntar cuantos numeros quiere introducir
        // ============================================================

        separador("EJEMPLO 9: PEDIR CANTIDAD DINAMICA DE NUMEROS");
        System.out.print("  Cuantos numeros quieres introducir? ");
        int cantidadDinamica = entrada.nextInt();

        double sumaDinamica = 0;
        for (int i = 1; i <= cantidadDinamica; i++) {
            System.out.print("  Dime un numero " + i + " de " + cantidadDinamica + ": ");
            sumaDinamica += entrada.nextInt();
        }
        double mediaDinamica = sumaDinamica / cantidadDinamica;
        System.out.println("  La suma es: " + sumaDinamica);
        System.out.println("  La media es: " + mediaDinamica);

        entrada.close();

        // ============================================================
        // COMPARACION DE TODOS LOS EJEMPLOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ejemplo 1: for(i=0; i<10; i++)              -> 0..9 (10 iteraciones)");
        System.out.println("Ejemplo 2: for(i=0; i<=10; i++)             -> 0..10 (11 iteraciones)");
        System.out.println("Ejemplo 3: for(i=0; i<=100; i+=10)          -> 0,10,20,...,100");
        System.out.println("Ejemplo 4: for con print (sin ln)           -> todo en una linea");
        System.out.println("Ejemplo 5: for(j=3; j<10; j+=j)             -> 3, 6, 9");
        System.out.println("Ejemplo 6: BUCLE INFINITO (i nunca cambia)  -> Ctrl+C");
        System.out.println("Ejemplo 7: Pedir 5 numeros con for          -> interactivo");
        System.out.println("Ejemplo 8: Media de 5 numeros               -> suma/5");
        System.out.println("Ejemplo 9: Cantidad dinamica de numeros     -> el usuario decide");
        System.out.println();
        System.out.println("============================================================");
        System.out.println("  CLAVES PARA EL EXAMEN:");
        System.out.println("  - La variable del for SOLO vive dentro del bucle");
        System.out.println("  - Si la condicion nunca se modifica -> bucle INFINITO");
        System.out.println("  - i++  vs  i+=10  -> incremento variable");
        System.out.println("  - <  vs  <=  -> cambia el numero de iteraciones");
        System.out.println("  - Scanner + for -> pedir N datos por teclado");
        System.out.println("  - suma += num; -> acumular valores");
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
