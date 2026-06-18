class Video_3_03_Ejercicios_Metodos {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "3-03 JAVA: Ejercicios sencillos metodos ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=kKryKJUThhQ&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=56";
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
          RESUMEN RAPIDO - EJERCICIOS DE METODOS (TEMA 3 - V3)
        ====================================================================

        --- EJERCICIO 1: SALUDAR ---
          static void saludar(String nombre) {
              System.out.println("Hola, " + nombre + ", que tal estas?");
          }
          - void: no devuelve nada, solo imprime.
          - Recibe un String y muestra mensaje personalizado.

        --- EJERCICIO 2: CUBO ---
          static int cubo(int n) {
              return n * n * n;
          }
          - Devuelve int (el cubo del numero).
          - n * n * n = n al cubo.

        --- EJERCICIO 3: MULTIPLICAR ---
          static int multiplicar(int a, int b) {
              return a * b;
          }
          - Devuelve int (producto de a y b).
          - Recibe dos parametros enteros.

        --- EJERCICIO 4: TABLA DE MULTIPLICAR ---
          static void tablaMultiplicar(int num) {
              System.out.println("Tabla de multiplicar del " + num);
              for (int i = 1; i <= 10; i++) {
                  System.out.println(i + " x " + num + " = " + multiplicar(i, num));
              }
          }
          - void: no devuelve nada, imprime la tabla.
          - REUTILIZA el metodo multiplicar(i, num) del ejercicio 3.
          - Bucle for de 1 a 10.

        --- EJERCICIO 5: PAR / IMPAR ---
          static boolean esPar(int n) {
              return n % 2 == 0;
          }

          static void mostrarParImpar(int n) {
              if (esPar(n)) {
                  System.out.println(n + " es par");
              } else {
                  System.out.println(n + " es impar");
              }
          }
          - esPar devuelve boolean (true si n%2==0).
          - mostrarParImpar REUTILIZA esPar.
          - Se puede hacer inline con operador ternario.

        --- EJERCICIO 6: MENU DE N OPCIONES ---
          static void menu(int opciones) {
              System.out.println("\\nMenu principal");
              System.out.println("Selecciona una opcion entre 1 y " + opciones);
              for (int i = 1; i < opciones; i++) {
                  System.out.println(i + " - Esta es la opcion " + i);
              }
              System.out.println(opciones + " - Salir\\n");
          }
          - void: imprime el menu.
          - La ultima opcion (opciones) es "Salir".
          - El bucle va de 1 a opciones-1 para las opciones validas.

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Los metodos pueden REUTILIZARSE unos a otros (ej: tablaMultiplicar
          llama a multiplicar, mostrarParImpar llama a esPar).
        * boolean es el tipo de retorno para metodos que responden si/no.
        * void para metodos que solo imprimen y no devuelven nada.
        * Los metodos pueden recibir 0, 1 o varios parametros.
        * Un metodo que llama a otro metodo: se invoca igual que desde main.
        * La tabla de multiplicar usa un for de 1 a 10 (i <= 10).
        * El menu usa for de 1 a opciones-1, y la opcion opciones es Salir.
        * n % 2 == 0 es la formula para saber si un numero es par.
        * Los metodos permiten organizar el codigo y evitar repetirlo.

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
        // EJERCICIO 1: saludar(String)
        // ============================================================

        separador("EJERCICIO 1: saludar(String nombre) - void");

        String nombre = "Pepe";
        saludar(nombre);                    // Usando variable
        System.out.println();

        // ============================================================
        // EJERCICIO 2: cubo(int)
        // ============================================================

        separador("EJERCICIO 2: cubo(int n) - return int");

        int num = 5;
        System.out.println("  El cubo de " + num + " es " + cubo(num));
        System.out.println("  El cubo de 11 es " + cubo(11));
        System.out.println("  El cubo de 7 es " + cubo(7));
        System.out.println();

        // ============================================================
        // EJERCICIO 3: multiplicar(int, int)
        // ============================================================

        separador("EJERCICIO 3: multiplicar(int a, int b) - return int");

        System.out.println("  3 multiplicado por " + num + " = " + multiplicar(3, num));
        System.out.println();

        // ============================================================
        // EJERCICIO 4: tablaMultiplicar(int) - REUTILIZA multiplicar
        // ============================================================

        separador("EJERCICIO 4: tablaMultiplicar(int num) - void");

        tablaMultiplicar(7);
        System.out.println();

        // ============================================================
        // EJERCICIO 5: esPar(int) y mostrarParImpar(int)
        // ============================================================

        separador("EJERCICIO 5: esPar(int) y mostrarParImpar(int)");

        System.out.println("  esPar(5) -> " + esPar(5));
        System.out.println("  esPar(10) -> " + esPar(10));
        mostrarParImpar(5);
        mostrarParImpar(10);
        System.out.println();

        // ============================================================
        // EJERCICIO 6: menu(int opciones)
        // ============================================================

        separador("EJERCICIO 6: menu(int opciones) - void");

        System.out.println("  Menu con 5 opciones:");
        menu(5);
        System.out.println();

        // ============================================================
        // DEMO COMPLETA CON VARIABLES (como en el video)
        // ============================================================

        separador("DEMO COMPLETA");

        String nombreDemo = "Pepe";
        int numDemo = 7;

        saludar(nombreDemo);
        System.out.println("  El cubo de " + numDemo + " es " + cubo(numDemo));
        System.out.println("  3 multiplicado por " + numDemo + " = " + multiplicar(3, numDemo));
        tablaMultiplicar(numDemo);
        mostrarParImpar(numDemo);
        System.out.println("  Menu con " + numDemo + " opciones:");
        menu(numDemo);

        // ============================================================
        // RESUMEN
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ej 1: saludar(\"Pepe\")                          -> Hola Pepe, que tal estas?");
        System.out.println("Ej 2: cubo(5)                                 -> 125");
        System.out.println("Ej 2: cubo(11)                                -> 1331");
        System.out.println("Ej 3: multiplicar(3, 5)                       -> 15");
        System.out.println("Ej 4: tablaMultiplicar(7)                     -> tabla del 7 del 1 al 10");
        System.out.println("Ej 5: esPar(5)                                -> false");
        System.out.println("Ej 5: esPar(10)                               -> true");
        System.out.println("Ej 6: menu(5)                                 -> menu con 5 opciones (4 validas + Salir)");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  (Proximo: mas ejercicios de metodos)");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODOS DE LOS EJERCICIOS
    // -------------------------------------------------------------

    // Ejercicio 1: Saludar (void, recibe String)
    static void saludar(String nombre) {
        System.out.println("  Hola " + nombre + ", que tal estas?");
    }

    // Ejercicio 2: Cubo de un numero (devuelve int)
    static int cubo(int n) {
        return n * n * n;
    }

    // Ejercicio 3: Multiplicar dos numeros (devuelve int)
    static int multiplicar(int a, int b) {
        return a * b;
    }

    // Ejercicio 4: Tabla de multiplicar (void, REUTILIZA multiplicar)
    static void tablaMultiplicar(int num) {
        System.out.println("  Tabla de multiplicar del " + num);
        for (int i = 1; i <= 10; i++) {
            System.out.println("    " + i + " x " + num + " = " + multiplicar(i, num));
        }
    }

    // Ejercicio 5a: Comprobar si un numero es par (devuelve boolean)
    static boolean esPar(int n) {
        return n % 2 == 0;
    }

    // Ejercicio 5b: Mostrar si es par o impar (void, REUTILIZA esPar)
    static void mostrarParImpar(int n) {
        if (esPar(n)) {
            System.out.println("  " + n + " es par");
        } else {
            System.out.println("  " + n + " es impar");
        }
    }

    // Ejercicio 6: Menu de n opciones (void, ultima opcion = Salir)
    static void menu(int opciones) {
        System.out.println("  Menu principal");
        System.out.println("  Selecciona una opcion entre 1 y " + opciones);
        for (int i = 1; i < opciones; i++) {
            System.out.println("    " + i + " - Esta es la opcion " + i);
        }
        System.out.println("    " + opciones + " - Salir");
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
