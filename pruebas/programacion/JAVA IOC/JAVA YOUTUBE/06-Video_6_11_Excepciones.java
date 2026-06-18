import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

class Video_6_11_Excepciones {

    public static final String TITULO = "6-11 JAVA: Excepciones DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=lWC9rt0vBek&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=132";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - EXCEPCIONES (TEMA 6 - V11)\n"
        + "===========================================\n\n"
        + "EXCEPCION: situacion excepcional que se produce durante la ejecucion.\n"
        + "- Java lanza un objeto de tipo Throwable cuando ocurre un error.\n\n"
        + "JERARQUIA DE CLASES:\n"
        + "Object -> Throwable -> Error (problemas graves, no recuperables)\n"
        + "                     -> Exception -> RuntimeException (NO verificadas)\n"
        + "                                   -> IOException (SI verificadas)\n\n"
        + "EXCEPCIONES VERIFICADAS (checked):\n"
        + "- Se deben manejar OBLIGATORIAMENTE en compilacion.\n"
        + "- Ej: FileNotFoundException, IOException, MalformedURLException\n"
        + "- Se manejan con try-catch o propagando con throws.\n\n"
        + "EXCEPCIONES NO VERIFICADAS (unchecked):\n"
        + "- NO es obligatorio manejarlas en compilacion.\n"
        + "- Ej: ArithmeticException, ArrayIndexOutOfBoundsException,\n"
        + "     NullPointerException, NumberFormatException\n"
        + "- Pueden provocar que el programa termine si no se capturan.\n\n"
        + "EJEMPLOS DE EXCEPCIONES:\n"
        + "- ArithmeticException: division por cero\n"
        + "- ArrayIndexOutOfBoundsException: indice fuera del array\n"
        + "- NullPointerException: operacion sobre objeto null\n"
        + "- FileNotFoundException: archivo no encontrado (VERIFICADA)\n\n"
        + "PREVENCION CON CODIGO (sin try-catch):\n"
        + "if (divisor != 0) { cociente = dividendo / divisor; }\n"
        + "else { System.out.println(\"Error: division por cero\"); }\n\n"
        + "CAPTURA CON TRY-CATCH:\n"
        + "try {\n"
        + "    // codigo que puede lanzar excepcion\n"
        + "} catch (TipoExcepcion e) {\n"
        + "    // codigo de recuperacion\n"
        + "}\n\n"
        + "ERROR vs EXCEPCION:\n"
        + "- Error: problemas graves (OutOfMemoryError, StackOverflowError)\n"
        + "- Exception: problemas recuperables (FileNotFoundException)";

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V11: EXCEPCIONES");
        System.out.println();

        // ============================================================
        // PARTE 1: Prevencion con codigo (sin try-catch)
        // ============================================================
        System.out.println("=== PARTE 1: PREVENCION CON CODIGO ===");

        int dividendo = 10;
        int divisor = 0;

        // Forma SIN control (provocaria ArithmeticException)
        // int cociente = dividendo / divisor;  // ESTO ROMPE

        // Forma CON control (prevencion)
        if (divisor != 0) {
            int cociente = dividendo / divisor;
            System.out.println("  Cociente: " + cociente);
        } else {
            System.out.println("  Error: No se puede dividir por cero");
        }
        System.out.println("  (El programa continua despues del error)");
        System.out.println();

        // ============================================================
        // PARTE 2: Excepcion NO verificada con try-catch
        // ============================================================
        System.out.println("=== PARTE 2: TRY-CATCH (division por cero) ===");

        try {
            int resultado = 10 / 0;  // ArithmeticException
            System.out.println("  Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("  Error capturado: " + e.getMessage());
            System.out.println("  (Division por cero capturada con try-catch)");
        }
        System.out.println("  El programa continua sin problemas");
        System.out.println();

        // ============================================================
        // PARTE 3: ArrayIndexOutOfBoundsException
        // ============================================================
        System.out.println("=== PARTE 3: ArrayIndexOutOfBounds ===");

        try {
            int[] nums = new int[3];  // indices 0, 1, 2
            int num = nums[3];         // indice 3 NO existe
            System.out.println("  Valor: " + num);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  Error capturado: " + e.getMessage());
            System.out.println("  (Indice de array fuera de rango)");
        }
        System.out.println();

        // ============================================================
        // PARTE 4: Excepcion VERIFICADA (FileNotFoundException)
        // ============================================================
        System.out.println("=== PARTE 4: EXCEPCION VERIFICADA ===");

        try {
            FileReader file = new FileReader("archivo_inexistente.txt");
            System.out.println("  Archivo abierto correctamente");
        } catch (FileNotFoundException e) {
            System.out.println("  Error: Archivo no encontrado");
            System.out.println("  (Esta excepcion ES verificada, obligatorio try-catch)");
        }
        System.out.println("  El programa continua");
        System.out.println();

        // ============================================================
        // PARTE 5: NullPointerException
        // ============================================================
        System.out.println("=== PARTE 5: NullPointerException ===");

        String texto = null;
        try {
            int longitud = texto.length();  // NullPointerException
            System.out.println("  Longitud: " + longitud);
        } catch (NullPointerException e) {
            System.out.println("  Error: No se puede llamar a .length() sobre null");
        }
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 6 - V11: EXCEPCIONES)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  TIPOS DE EXCEPCIONES:");
        System.out.println("  - Verificadas (checked): obligatorio manejarlas");
        System.out.println("  - No verificadas (unchecked): opcional manejarlas");
        System.out.println();
        System.out.println("  JERARQUIA:");
        System.out.println("  Throwable -> Error (grave, no recuperable)");
        System.out.println("            -> Exception -> RuntimeException (unchecked)");
        System.out.println("                        -> IOException (checked)");
        System.out.println();
        System.out.println("  EJEMPLOS: ArithmeticException, ArrayIndexOutOfBounds,");
        System.out.println("  NullPointerException, FileNotFoundException");
    }
}
