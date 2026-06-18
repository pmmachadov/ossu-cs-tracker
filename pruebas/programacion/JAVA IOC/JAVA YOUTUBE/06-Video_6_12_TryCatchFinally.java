import java.util.InputMismatchException;
import java.util.Scanner;

class Video_6_12_TryCatchFinally {

    public static final String TITULO = "6-12 JAVA: try - catch - finally DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=1I5Wxy6ZFbw&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=133";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - TRY-CATCH-FINALLY (TEMA 6 - V12)\n"
        + "==============================================\n\n"
        + "TRY: bloque que contiene codigo que puede lanzar excepciones.\n"
        + "CATCH: bloque que captura y maneja una excepcion especifica.\n"
        + "FINALLY: bloque que se ejecuta SIEMPRE (haya o no excepcion).\n\n"
        + "SINTAXIS:\n"
        + "try {\n"
        + "    // codigo que puede lanzar excepcion\n"
        + "} catch (TipoExcepcion1 e) {\n"
        + "    // manejar excepcion tipo 1\n"
        + "} catch (TipoExcepcion2 e) {\n"
        + "    // manejar excepcion tipo 2\n"
        + "} finally {\n"
        + "    // codigo que se ejecuta siempre\n"
        + "}\n\n"
        + "FLUJO DE EJECUCION:\n"
        + "1. Sin excepcion: try -> finally (el catch se salta)\n"
        + "2. Con excepcion capturada: try (hasta el error) -> catch -> finally\n"
        + "3. Con excepcion NO capturada: try (hasta el error) -> finally -> el programa termina\n\n"
        + "METODOS UTILES DE EXCEPCION:\n"
        + "- getMessage(): devuelve el mensaje descriptivo del error\n"
        + "- printStackTrace(): imprime la pila de llamadas completa\n\n"
        + "VARIOS CATCH:\n"
        + "- Se pueden tener tantos catch como se necesiten.\n"
        + - El orden importa: primero los mas especificos, luego los generales."
        + "- Si no se sabe la excepcion exacta: catch (Exception e)\n\n"
        + "EJEMPLOS DE EXCEPCIONES:\n"
        + "- ArithmeticException: division por cero\n"
        + "- InputMismatchException: Scanner recibe tipo incorrecto\n"
        + "- NumberFormatException: Integer.parseInt() con texto no numerico\n\n"
        + "FINALLY SIN CATCH:\n"
        + "- Se puede tener try-finally sin catch.\n"
        + "- El finally se ejecuta incluso si la excepcion no se captura.\n"
        + "- Sirve para liberar recursos (cerrar archivos, conexiones).";

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V12: TRY-CATCH-FINALLY");
        System.out.println();

        Scanner entrada = new Scanner(System.in);

        // ============================================================
        // PARTE 1: Un solo catch
        // ============================================================
        System.out.println("=== PARTE 1: TRY-CATCH simple ===");

        try {
            int num = Integer.parseInt("Hola");  // NumberFormatException
            System.out.println("  Numero: " + num);
        } catch (NumberFormatException e) {
            System.out.println("  Error: Formato del numero incorrecto");
            System.out.println("  getMessage(): " + e.getMessage());
        }
        System.out.println("  (El programa continua)");
        System.out.println();

        // ============================================================
        // PARTE 2: Varios catch
        // ============================================================
        System.out.println("=== PARTE 2: VARIOS CATCH ===");

        System.out.print("  Introduce un numero entero: ");
        try {
            int num1 = entrada.nextInt();
            int num2 = Integer.parseInt("Hola");  // NumberFormatException
            int resultado = 100 / num1;
            System.out.println("  Resultado: " + resultado);
        } catch (InputMismatchException e) {
            System.out.println("  Error: No has introducido un entero valido");
        } catch (ArithmeticException e) {
            System.out.println("  Error: Division por cero");
            System.out.println("  getMessage(): " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("  Error: Formato del numero incorrecto");
            e.printStackTrace();
        }
        System.out.println("  Programa ha terminado con normalidad");
        System.out.println();

        // ============================================================
        // PARTE 3: Finally
        // ============================================================
        System.out.println("=== PARTE 3: FINALLY ===");

        try {
            int a = 1 / 0;  // ArithmeticException
            System.out.println("  Esto no se ejecuta");
        } catch (ArithmeticException e) {
            System.out.println("  Error capturado: " + e.getMessage());
        } finally {
            System.out.println("  FINALLY: Esto se ejecuta SIEMPRE");
        }
        System.out.println("  (Programa continua despues del try-catch-finally)");
        System.out.println();

        // ============================================================
        // PARTE 4: Finally SIN catch (excepcion no capturada)
        // ============================================================
        System.out.println("=== PARTE 4: FINALLY sin catch adecuado ===");

        try {
            int a = 1 / 0;  // ArithmeticException
            System.out.println("  Esto no se ejecuta");
        } catch (InputMismatchException e) {
            System.out.println("  Este catch NO captura ArithmeticException");
        } finally {
            System.out.println("  FINALLY: Se ejecuta incluso sin catch adecuado");
        }
        // El programa termina aqui porque la excepcion no fue capturada
        System.out.println("  (Esta linea NO se ejecuta porque la excepcion no fue capturada)");
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 6 - V12: TRY-CATCH-FINALLY)");
        System.out.println("============================================================");
    }
}
