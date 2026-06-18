import java.util.InputMismatchException;
import java.util.Scanner;

class Video_6_13_ThrowYThrows {

    public static final String TITULO = "6-13 JAVA: throw y throws DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=XnQuyV86bOI&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=134";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - THROW Y THROWS (TEMA 6 - V13)\n"
        + "===============================================\n\n"
        + "throw: lanza una excepcion manualmente.\n"
        + "  throw new TipoExcepcion(\"mensaje\");\n\n"
        + "throws: declara que un metodo puede propagar una excepcion.\n"
        + "  tipo metodo(params) throws TipoExcepcion { ... }\n\n"
        + "PROPAGACION DE EXCEPCIONES:\n"
        + "- Si un metodo lanza una excepcion y NO la captura, se propaga\n"
        + "  al metodo que lo invoco (sube en la pila de llamadas).\n"
        + "- Si llega al main y tampoco se captura -> el programa termina.\n\n"
        + "EXCEPCIONES VERIFICADAS (checked):\n"
        + "- Obligan a poner throws en la cabecera del metodo.\n"
        + "- Obligan a que quien invoca use try-catch o throws tambien.\n\n"
        + "EXCEPCIONES NO VERIFICADAS (unchecked):\n"
        + "- NO obligan a poner throws (aunque se puede).\n"
        + "- NO obligan a capturarlas (aunque se puede).\n\n"
        + "DOS OPCIONES PARA UN METODO:\n"
        + "1. Capturar dentro: try-catch dentro del metodo.\n"
        + "2. Propagar con throws: quien invoca decide como manejarla.\n\n"
        + "EJEMPLO:\n"
        + "static void dividir(int n, int m) throws ArithmeticException {\n"
        + "    if (m == 0) throw new ArithmeticException(\"Division por cero\");\n"
        + "    System.out.println(n / m);\n"
        + "}\n\n"
        + "// En el main:\n"
        + "try { dividir(3, 0); }\n"
        + "catch (ArithmeticException e) { ... }";

    // ================================================================
    // METODO: dividir (propaga excepcion con throws)
    // ================================================================
    static void dividir(int n, int m) throws ArithmeticException {
        if (m == 0) {
            throw new ArithmeticException("Division por cero");
        }
        System.out.println("  " + n + " / " + m + " = " + (n / m));
    }

    // ================================================================
    // METODO: validarMinutos (propaga excepcion)
    // ================================================================
    static void validarMinutos(int minutos) throws InputMismatchException {
        if (minutos < 0 || minutos >= 60) {
            throw new InputMismatchException("Valor fuera de rango de 0 a 60");
        }
        System.out.println("  Minutos validos: " + minutos);
    }

    // ================================================================
    // METODO: ejemplo (propaga ArrayIndexOutOfBoundsException)
    // ================================================================
    static void ejemplo(int x, int[] array) throws ArrayIndexOutOfBoundsException {
        if (x < 0 || x >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Posicion no valida");
        }
        System.out.println("  Valor en posicion " + x + ": " + array[x]);
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V13: THROW Y THROWS");
        System.out.println();

        Scanner entrada = new Scanner(System.in);

        // ============================================================
        // PARTE 1: throw basico (sin captura)
        // ============================================================
        System.out.println("=== PARTE 1: THROW sin captura ===");

        System.out.print("  Introduce minutos (0-59): ");
        try {
            int mins = entrada.nextInt();
            if (mins < 0 || mins >= 60) {
                throw new InputMismatchException("Valor fuera de rango de 0 a 60");
            }
            System.out.println("  Minutos introducidos: " + mins);
        } catch (InputMismatchException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // PARTE 2: Metodo con throws (propaga la excepcion)
        // ============================================================
        System.out.println("=== PARTE 2: METODO CON THROWS ===");

        try {
            System.out.println("  Llamando a dividir(3, 0)...");
            dividir(3, 0);  // Propaga ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("  Capturando excepcion en el Main: " + e.getMessage());
        }
        System.out.println("  (El programa continua)");
        System.out.println();

        // ============================================================
        // PARTE 3: Metodo con throws + try-catch dentro
        // ============================================================
        System.out.println("=== PARTE 3: CAPTURA DENTRO DEL METODO ===");

        // Version que captura dentro del metodo (no propaga)
        try {
            dividirConCaptura(3, 0);
        } catch (ArithmeticException e) {
            System.out.println("  Esto no se ejecuta porque ya se capturo dentro");
        }
        System.out.println();

        // ============================================================
        // PARTE 4: Ejemplo con array (posiciones validas)
        // ============================================================
        System.out.println("=== PARTE 4: ARRAY CON THROWS ===");

        int[] nums = {10, 20, 30};

        try {
            ejemplo(0, nums);  // Valido
            ejemplo(5, nums);  // Invalido -> propaga
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 6 - V13: THROW Y THROWS)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - throw: lanza una excepcion manualmente");
        System.out.println("  - throws: declara que un metodo puede propagar");
        System.out.println("  - Las excepciones verificadas OBLIGAN throws");
        System.out.println("  - Las no verificadas NO obligan throws");
        System.out.println("  - Dos opciones: capturar dentro o propagar");
    }

    // ================================================================
    // METODO: dividir con captura DENTRO del metodo
    // ================================================================
    static void dividirConCaptura(int n, int m) {
        try {
            if (m == 0) {
                throw new ArithmeticException("Division por cero");
            }
            System.out.println("  " + n + " / " + m + " = " + (n / m));
        } catch (ArithmeticException e) {
            System.out.println("  Capturando excepcion dentro del metodo: " + e.getMessage());
        }
    }
}
