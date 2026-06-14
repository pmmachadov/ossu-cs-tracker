class Video_3_01_Metodos {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "3-01 JAVA: Metodos [DAM - DAW]";
    public static final String URL = "https://www.youtube.com/watch?v=wFw1AEDM_TM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=54";
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
          RESUMEN RAPIDO - METODOS EN JAVA (TEMA 3)
        ====================================================================

        --- DEFINICION ---
        Un metodo es un subprograma que realiza una tarea especifica.
        Se usa para evitar repetir codigo.

        --- SINTAXIS ---
            static tipo_retorno nombreMetodo(tipo param1, tipo param2, ...) {
                // cuerpo del metodo
                return valor;
            }

        --- PARTES ---
        1. static: de momento siempre lo ponemos.
        2. tipo_retorno: int, double, boolean, String, void, etc.
        3. nombreMetodo: identificador (como variable).
        4. parametros: lista de (tipo nombre, ...) separados por comas.
        5. return: devuelve el valor y TERMINA el metodo.
        6. void: el metodo NO devuelve nada (no lleva return con valor).

        --- EJEMPLO ---
            static int suma(int a, int b) {
                int resultado = a + b;
                return resultado;
            }

        --- INVOCACION ---
            int c = suma(valor1, valor2);
            // Los parametros se PASAN POR VALOR (copia)

        --- TIPOS DE RETORNO ---
        - int, double, long, float, byte, short, char, boolean
        - String y otros objetos
        - void (no devuelve nada)

        --- METODOS SIN PARAMETROS ---
            static void mostrarMenu() {
                System.out.println("1. Opcion A");
                System.out.println("2. Opcion B");
            }

        --- IMPORTANTE PARA EXAMEN ---
        1. Los parametros se pasan POR COPIA (paso por valor).
        2. Si el metodo no es void, OBLIGATORIO usar return.
        3. return TERMINA la ejecucion del metodo.
        4. El metodo debe ser invocado para ejecutarse.
        5. Un metodo puede llamar a OTRO metodo.
        6. Las variables declaradas dentro del metodo son LOCALES.
        7. static se usa porque main es static (TEMA 3).
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
        // EJEMPLO 1: Metodo suma con int
        // ============================================================

        separador("EJEMPLO 1: METODO suma(int, int)");

        int valor1 = 5;
        int valor2 = 3;
        int resultadoSuma = suma(valor1, valor2);

        System.out.println("  sumar(" + valor1 + ", " + valor2 + ") = " + resultadoSuma);
        System.out.println("  (Paso por valor: se pasan copias de " + valor1 + " y " + valor2 + ")");
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Metodo con double
        // ============================================================

        separador("EJEMPLO 2: METODO multiplicar(double, double)");

        double x = 2.5;
        double y = 4.0;
        double resultadoMult = multiplicar(x, y);

        System.out.println("  multiplicar(" + x + ", " + y + ") = " + resultadoMult);
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Metodo boolean
        // ============================================================

        separador("EJEMPLO 3: METODO esPar(int)");

        int num = 7;
        System.out.println("  esPar(" + num + ") = " + esPar(num) + "  (7 no es par)");
        System.out.println("  esPar(10) = " + esPar(10) + "  (10 es par)");
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Metodo void (no devuelve nada)
        // ============================================================

        separador("EJEMPLO 4: METODO void mostrarMensaje(String)");

        mostrarMensaje("Bienvenidos al TEMA 3 - Metodos en Java!");
        System.out.println();

        // ============================================================
        // EJEMPLO 5: Metodo sin parametros
        // ============================================================

        separador("EJEMPLO 5: METODO sin parametros");

        String menu = obtenerMenu();
        System.out.println(menu);
        System.out.println();

        // ============================================================
        // RESUMEN DE EJEMPLOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ejemplo 1: suma(int, int)           -> " + suma(1, 2) + " (1+2=3)");
        System.out.println("Ejemplo 2: multiplicar(double, dbl) -> " + multiplicar(3.0, 1.5) + " (3x1.5=4.5)");
        System.out.println("Ejemplo 3: esPar(int)               -> true si par, false si impar");
        System.out.println("Ejemplo 4: void mostrarMensaje()    -> imprime un mensaje");
        System.out.println("Ejemplo 5: String obtenerMenu()     -> devuelve un String");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Parametros y ambito en metodos");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODOS DEL EJEMPLO
    // -------------------------------------------------------------

    // Ejemplo 1: Suma de dos enteros
    static int suma(int a, int b) {
        int resultado = a + b;
        return resultado;
    }

    // Ejemplo 2: Multiplicacion de doubles
    static double multiplicar(double a, double b) {
        return a * b;
    }

    // Ejemplo 3: Comprobar si un numero es par
    static boolean esPar(int n) {
        return n % 2 == 0;
    }

    // Ejemplo 4: Metodo void (no devuelve nada)
    static void mostrarMensaje(String msg) {
        System.out.println("  >>> " + msg + " <<<");
    }

    // Ejemplo 5: Metodo sin parametros que devuelve un String
    static String obtenerMenu() {
        return "  === MENU ===\n  1. Opcion A\n  2. Opcion B\n  3. Salir";
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