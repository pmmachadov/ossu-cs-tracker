class Video_3_08_EjercicioPilaLlamadas {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "3-08 JAVA: Ejercicio pila de llamadas ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=4mjBa6oQN14&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=61";
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
          RESUMEN RAPIDO - EJERCICIO PILA DE LLAMADAS (TEMA 3 - V8)
        ====================================================================

        --- PROBLEMA ---
        Dado:
          static int proceso1(int a) {
              int x = 0;
              for (int i = 0; i <= a; i += 2) {
                  x += proceso2(i, i + 1);
              }
              return x;
          }

          static int proceso2(int a, int b) {
              int y = 1;
              for (int j = 0; j < a + b; j++) {
                  y++;
              }
              return y;
          }

          MAIN:
          int x = proceso1(4);
          System.out.println(x);

        --- RESOLUCION (x FINAL = 18) ---

        main: x = proceso1(4)
          proceso1(4): a=4, x=0, i de 0 a 4 (paso 2): 3 vueltas

          Vuelta 1 (i=0):
            x += proceso2(0, 1)
              proceso2(0,1): a=0,b=1, y=1, j<1 (1 vuelta): y=2
              return 2
            x = 0 + 2 = 2
            i += 2 => i=2

          Vuelta 2 (i=2):
            x += proceso2(2, 3)
              proceso2(2,3): a=2,b=3, y=1, j<5 (5 vueltas): y=6
              return 6
            x = 2 + 6 = 8
            i += 2 => i=4

          Vuelta 3 (i=4):
            x += proceso2(4, 5)
              proceso2(4,5): a=4,b=5, y=1, j<9 (9 vueltas): y=10
              return 10
            x = 8 + 10 = 18
            i += 2 => i=6

          return 18

        main: x = 18 -> System.out.println(18)

        --- CLAVES PARA RESOLVER ---
        * proceso2(a,b) = 1 + (a + b)  [empieza en 1, suma 1 por cada iteracion]
        * proceso2(0,1) = 1 + 1 = 2
        * proceso2(2,3) = 1 + 5 = 6
        * proceso2(4,5) = 1 + 9 = 10
        * proceso1(4) = 0 + 2 + 6 + 10 = 18

        --- USO DEL DEPURADOR ---
        * Poner breakpoint en la llamada proceso1(4).
        * Step Into (F11) para entrar en cada metodo.
        * Observar el Call Stack: se apilan main -> proceso1 -> proceso2.
        * Usar Step Over (F10) para avanzar sin entrar en metodos.
        * Ver variables locales en cada frame de la pila.

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * La PILA DE LLAMADAS (call stack) es una estructura LIFO
          (Last In, First Out) en memoria RAM.
        * El metodo main es el primero en apilarse y el ultimo en
          desapilarse.
        * Cada metodo crea un REGISTRO DE ACTIVACION (stack frame)
          con sus propias variables locales y parametros.
        * Cuando un metodo llama a otro, el nuevo metodo se APILA
          encima. Cuando termina (return), se DESAPILA.
        * Cada registro de activacion es INDEPENDIENTE. Un metodo
          NO puede acceder a las variables locales de otro metodo
          (solo a las suyas y a las globales si las hay).
        * El orden de ejecucion sigue la pila: el ultimo metodo
          apilado es el primero en ejecutarse y terminar.
        * Al desapilar, se retorna el control al metodo que hizo
          la llamada, justo donde se quedo.
        * Ejemplo de este video: main -> proceso1 -> proceso2 (x3).
          La pila llego a tener 3 niveles.
        * proceso2(a,b) es una funcion simple: devuelve 1 + (a + b).
          Cada vez que proceso1 llama a proceso2, se apila una nueva
          llamada con sus propios parametros.
        * El DEPURADOR permite ver en tiempo real la pila de llamadas
          y los valores de las variables en cada frame.
        * Sin caso base o condicion de parada en recursion ->
          StackOverflowError (desbordamiento de pila).
        * La pila tiene tamaño limitado; demasiadas llamadas anidadas
          la desbordan.

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
        // EJERCICIO: proceso1(4) -> proceso2(i, i+1)
        // ============================================================

        separador("EJERCICIO: Averiguar el valor final de X");
        System.out.println("  Codigo exacto del video:");
        System.out.println("    int x = proceso1(4);");
        System.out.println("    System.out.println(x);");
        System.out.println();

        // ============================================================
        // LLAMADA PRINCIPAL
        // ============================================================

        separador("EJECUCION");
        System.out.println("  Llamando a proceso1(4)...");
        System.out.println();

        int x = proceso1(4);

        System.out.println("  RESULTADO: x = " + x);
        System.out.println();

        // ============================================================
        // DESGLOSE PASO A PASO (TRAZA)
        // ============================================================

        separador("TRAZA DETALLADA - PILA DE LLAMADAS");
        System.out.println("  proceso1(4): a=4, x=0, i de 0 a 4 (paso 2): 3 vueltas");
        System.out.println();

        // Vuelta 1
        System.out.println("  Vuelta 1: i=0");
        System.out.println("    x += proceso2(0, 1)");
        int r1 = proceso2(0, 1);
        System.out.println("      proceso2(0,1) => " + r1 + "  (1 vuelta, y=1+1=2)");
        System.out.println("    x = 0 + " + r1 + " = " + (0 + r1));
        System.out.println();

        // Vuelta 2
        System.out.println("  Vuelta 2: i=2");
        System.out.println("    x += proceso2(2, 3)");
        int r2 = proceso2(2, 3);
        System.out.println("      proceso2(2,3) => " + r2 + "  (5 vueltas, y=1+5=6)");
        int parcial2 = r1 + r2;
        System.out.println("    x = " + r1 + " + " + r2 + " = " + parcial2);
        System.out.println();

        // Vuelta 3
        System.out.println("  Vuelta 3: i=4");
        System.out.println("    x += proceso2(4, 5)");
        int r3 = proceso2(4, 5);
        System.out.println("      proceso2(4,5) => " + r3 + "  (9 vueltas, y=1+9=10)");
        int parcial3 = parcial2 + r3;
        System.out.println("    x = " + parcial2 + " + " + r3 + " = " + parcial3);
        System.out.println();

        // Resultado final
        System.out.println("  RESULTADO FINAL: proceso1(4) = " + x);
        System.out.println("  System.out.println(x) => " + x);
        System.out.println();

        // ============================================================
        // RESUMEN DE LA PILA
        // ============================================================

        separador("RESUMEN DE LA PILA DE LLAMADAS");
        System.out.println("  Estado de la pila durante la ejecucion:");
        System.out.println();
        System.out.println("  1. main() se apila primero");
        System.out.println("  2. main llama a proceso1(4) -> se apila proceso1");
        System.out.println("     - En proceso1: a=4, x=0");
        System.out.println("  3. proceso1 llama a proceso2(0,1) -> se apila proceso2");
        System.out.println("     - proceso2 termina, devuelve 2 -> se desapila");
        System.out.println("     - x pasa a 2");
        System.out.println("  4. proceso1 llama a proceso2(2,3) -> se apila proceso2");
        System.out.println("     - proceso2 termina, devuelve 6 -> se desapila");
        System.out.println("     - x pasa a 8");
        System.out.println("  5. proceso1 llama a proceso2(4,5) -> se apila proceso2");
        System.out.println("     - proceso2 termina, devuelve 10 -> se desapila");
        System.out.println("     - x pasa a 18");
        System.out.println("  6. proceso1 return 18 -> se desapila proceso1");
        System.out.println("  7. main asigna x=18 -> System.out.println(18)");
        System.out.println("  8. main termina -> se desapila main -> FIN");
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Ejercicios de repaso Tema 3");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODOS DEL EJERCICIO
    // -------------------------------------------------------------

    // proceso1: recibe un entero 'a', itera i=0..a (paso 2)
    // y acumula x += proceso2(i, i+1)
    static int proceso1(int a) {
        int x = 0;
        for (int i = 0; i <= a; i += 2) {
            x += proceso2(i, i + 1);
        }
        return x;
    }

    // proceso2: recibe a y b, itera j=0..a+b-1, incrementa y
    // Formula: y = 1 + (a + b)
    static int proceso2(int a, int b) {
        int y = 1;
        for (int j = 0; j < a + b; j++) {
            y++;
        }
        return y;
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

