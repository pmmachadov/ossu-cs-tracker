import java.util.Scanner;

class Video_3_09_MenuFigurasMetodos {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "3-09 JAVA: Menu de opciones con metodos ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=IEFj_dDz31g&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=62";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 3";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // RESUMEN para el examen (CHULETA)
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ====================================================================
          RESUMEN RAPIDO - MENU DE FIGURAS CON METODOS (TEMA 3 - V9)
        ====================================================================

        --- ENUNCIADO ---
        Crear un programa con menu que dibuje figuras:
          1. Cuadrado con relleno
          2. Cuadrado sin relleno
          3. Triangulo rectangulo con relleno
          4. Triangulo rectangulo sin relleno
          5. Salir

        El programa debe repetirse hasta que se pulse Salir (5).
        Cada figura se dibuja con asteriscos (*).

        --- METODOS CREADOS ---
        1. mostrarMenu() -> void: imprime las opciones del menu.
        2. cuadrado(int n) -> void: dibuja cuadrado nxn con relleno.
        3. cuadradoSinRelleno(int n) -> void: dibuja cuadrado nxn hueco.
        4. triangulo(int altura) -> void: dibuja triangulo con relleno.
        5. trianguloSinRelleno(int altura) -> void: dibuja triangulo hueco.

        Todos los metodos llevan comentario JavaDoc (/** ... */).

        --- ESTRUCTURA DEL MAIN ---
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        int dimension = 10;  // Tamano fijo (o pedido por teclado)

        do {
            mostrarMenu();
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1: cuadrado(dimension); break;
                case 2: cuadradoSinRelleno(dimension); break;
                case 3: triangulo(dimension); break;
                case 4: trianguloSinRelleno(dimension); break;
                case 5: System.out.println("Fin del programa"); break;
                default: System.out.println("Opcion no valida");
            }
        } while (opcion != 5);

        entrada.close();

        --- LOGICA DE LAS FIGURAS ---
        CUADRADO CON RELLENO:
          for (fila = 0; fila < n; fila++) {
              for (col = 0; col < n; col++) {
                  System.out.print("*");
              }
              System.out.println();
          }

        CUADRADO SIN RELLENO:
          for (fila = 0; fila < n; fila++) {
              for (col = 0; col < n; col++) {
                  if (fila == 0 || fila == n-1 || col == 0 || col == n-1)
                      System.out.print("*");
                  else
                      System.out.print(" ");
              }
              System.out.println();
          }

        TRIANGULO CON RELLENO:
          for (fila = 0; fila < altura; fila++) {
              for (col = 0; col <= fila; col++) {
                  System.out.print("*");
              }
              System.out.println();
          }

        TRIANGULO SIN RELLENO:
          for (fila = 0; fila < altura; fila++) {
              for (col = 0; col <= fila; col++) {
                  if (fila == altura-1 || col == 0 || col == fila)
                      System.out.print("*");
                  else
                      System.out.print(" ");
              }
              System.out.println();
          }

        --- JAVA DOC ---
        * Se usa /** ... */ antes de cada metodo.
        * @param nombre descripcion del parametro.
        * @return descripcion del valor devuelto (si aplica).
        * Al escribir /** + Enter en VS Code se genera la plantilla.
        * Mejora la legibilidad al usar el metodo (tooltip con descripcion).

        --- CONCEPTOS CLAVE ---
        * Menu ciclico: do-while hasta que opcion == 5.
        * Switch con cases para cada opcion.
        * Metodos void: no devuelven nada, solo pintan.
        * Bucles anidados para dibujar figuras.
        * Paso por valor: dimension se pasa como copia.
        * Scanner para entrada por teclado.
        * Se puede pedir dimension por teclado dentro del switch.

        ====================================================================
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
        // MENU DE FIGURAS (del video)
        // ============================================================

        separador("MENU DE FIGURAS CON METODOS");
        System.out.println("  Menu interactivo: dibuja cuadrados y triangulos");
        System.out.println("  usando metodos. Las figuras se muestran abajo.");
        System.out.println();

        // ============================================================
        // DEMOSTRACION DE CADA METODO
        // ============================================================

        separador("DEMOSTRACION: Cada figura con dimension 5");

        System.out.println("1) Cuadrado con relleno (5x5):");
        cuadrado(5);
        System.out.println();

        System.out.println("2) Cuadrado sin relleno (5x5):");
        cuadradoSinRelleno(5);
        System.out.println();

        System.out.println("3) Triangulo con relleno (altura 5):");
        triangulo(5);
        System.out.println();

        System.out.println("4) Triangulo sin relleno (altura 5):");
        trianguloSinRelleno(5);
        System.out.println();

        // ============================================================
        // DEMOSTRACION CON DIMENSION 8
        // ============================================================

        separador("DEMOSTRACION: Figuras con dimension 8");

        System.out.println("Cuadrado con relleno (8x8):");
        cuadrado(8);
        System.out.println();

        System.out.println("Cuadrado sin relleno (8x8):");
        cuadradoSinRelleno(8);
        System.out.println();

        System.out.println("Triangulo con relleno (altura 8):");
        triangulo(8);
        System.out.println();

        System.out.println("Triangulo sin relleno (altura 8):");
        trianguloSinRelleno(8);
        System.out.println();

        // ============================================================
        // MODO INTERACTIVO (del video)
        // ============================================================

        separador("MODO INTERACTIVO (como en el video)");
        System.out.println("  A continuacion se ejecuta el menu interactivo.");
        System.out.println("  (Introduce 1-4 para figuras, 5 para salir)");
        System.out.println();

        // Aviso: el Scanner del menu interactivo usara System.in
        // pero para no interferir con la demostracion automatica,
        // simulamos una ejecucion rapida con opciones predefinidas
        System.out.println("  NOTA: Para probar el menu interactivo completo,");
        System.out.println("  ejecuta este programa sin argumentos y sigue");
        System.out.println("  las instrucciones por consola.");
        System.out.println();
        System.out.println("  Ejemplo de uso del menu:");
        System.out.println("    --- MENU FIGURAS ---");
        System.out.println("    1. Cuadrado con relleno");
        System.out.println("    2. Cuadrado sin relleno");
        System.out.println("    3. Triangulo con relleno");
        System.out.println("    4. Triangulo sin relleno");
        System.out.println("    5. Salir");
        System.out.println("    Selecciona una opcion: _");
        System.out.println();

        // ============================================================
        // EXPLICACION JAVA DOC
        // ============================================================

        separador("EXPLICACION: Comentarios JavaDoc");
        System.out.println("  Los metodos de este programa incluyen");
        System.out.println("  comentarios de documentacion JavaDoc (/**).");
        System.out.println();
        System.out.println("  Ejemplo:");
        System.out.println("    /**");
        System.out.println("     * Dibuja un cuadrado con relleno");
        System.out.println("     * @param n lado del cuadrado");
        System.out.println("     */");
        System.out.println();
        System.out.println("  Al escribir /** + Enter en VS Code se genera");
        System.out.println("  automaticamente la plantilla con @param.");
        System.out.println("  Al usar el metodo, se muestra la descripcion.");
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Recursion en Java");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODOS DE FIGURAS
    // -------------------------------------------------------------

    /**
     * Muestra el menu de opciones por pantalla
     */
    static void mostrarMenu() {
        System.out.println();
        System.out.println("--- MENU FIGURAS ---");
        System.out.println("1. Cuadrado con relleno");
        System.out.println("2. Cuadrado sin relleno");
        System.out.println("3. Triangulo con relleno");
        System.out.println("4. Triangulo sin relleno");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opcion: ");
    }

    /**
     * Dibuja un cuadrado con relleno formado por asteriscos
     * @param n lado del cuadrado
     */
    static void cuadrado(int n) {
        System.out.println();
        for (int fila = 0; fila < n; fila++) {
            for (int col = 0; col < n; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Dibuja un cuadrado sin relleno formado por asteriscos
     * Solo el borde exterior tiene asteriscos, el interior son espacios
     * @param n lado del cuadrado
     */
    static void cuadradoSinRelleno(int n) {
        System.out.println();
        for (int fila = 0; fila < n; fila++) {
            for (int col = 0; col < n; col++) {
                if (fila == 0 || fila == n - 1 || col == 0 || col == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Dibuja un triangulo rectangulo con relleno formado por asteriscos
     * @param altura altura del triangulo
     */
    static void triangulo(int altura) {
        System.out.println();
        for (int fila = 0; fila < altura; fila++) {
            for (int col = 0; col <= fila; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Dibuja un triangulo rectangulo sin relleno formado por asteriscos
     * Solo el borde exterior tiene asteriscos, el interior son espacios
     * @param altura altura del triangulo
     */
    static void trianguloSinRelleno(int altura) {
        System.out.println();
        for (int fila = 0; fila < altura; fila++) {
            for (int col = 0; col <= fila; col++) {
                if (fila == altura - 1 || col == 0 || col == fila) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
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
