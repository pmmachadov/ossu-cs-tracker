import java.util.InputMismatchException;
import java.util.Scanner;

class Video_6_14_ThrowsMultiple {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "6-14 JAVA: throws multiple DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=TjhbybnfCcs&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=135";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 6-14 - THROWS MULTIPLE
        ================================================================

        Video:        6-14 JAVA: throws multiple
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6

        --- RESUMEN (transcripcion) ---

        Un metodo puede propagar VARIOS tipos de excepcion separados
        por comas en la clausula throws.

          tipo metodo(params) throws Exc1, Exc2, Exc3 { ... }

        --- CAPTURA EN EL MAIN ---

        Se pueden tener VARIOS catch, cada uno para un tipo.
        El orden IMPORTA: primero las mas especificas, luego Exception.

        ORDEN CORRECTO:
          catch (ArrayIndexOutOfBoundsException e) { }
          catch (InputMismatchException e) { }
          catch (Exception e) { }  // Captura cualquier otra

        ORDEN INCORRECTO (error de compilacion):
          catch (Exception e) { }     // Capturaria TODO
          catch (InputMismatchException e) { }  // NUNCA se ejecuta

        --- EXCEPCIONES NO VERIFICADAS ---

        - No es obligatorio poner throws (aunque se puede).
        - No es obligatorio capturarlas (aunque se debe si queremos
          que el programa no termine).

        --- ESTRUCTURA DEL PROGRAMA ---

        static int obtenerDatos(int[] array)
            throws ArrayIndexOutOfBoundsException, InputMismatchException {
            // pide posicion por teclado
            // si posicion no valida -> throw ArrayIndexOutOfBoundsException
            // si entrada no es entero -> InputMismatchException
        }

        do {
            try { pos = obtenerDatos(array); ...; salir = true; }
            catch (ArrayIndexOutOfBoundsException e) { ... }
            catch (InputMismatchException e) { ... }
        } while (!salir);

        El bucle se repite hasta que la entrada sea valida.

        --- CONCEPTOS CLAVE ---

        - throws separa excepciones con comas
        - Orden en catch: de mas especifica a mas general
        - Exception al final captura cualquier otra
        - Si el orden es incorrecto -> error de compilacion
        - Las no verificadas (RuntimeException) no obligan a throws
        - El bucle do-while permite reintentar hasta entrada valida
        ================================================================
        """;

    // ================================================================
    // METODO CON THROWS MULTIPLE
    // ================================================================
    static int obtenerDatos(int[] array)
            throws ArrayIndexOutOfBoundsException, InputMismatchException {

        Scanner sc = new Scanner(System.in);
        System.out.print("  Dime una posicion entre 0 y "
            + (array.length - 1) + ": ");
        int n = sc.nextInt();

        if (n < 0 || n >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Indice no valido");
        }

        return n;
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        int[] array = {15, 2, 8, 19, 3};
        boolean salir = false;

        System.out.println("  Array: {15, 2, 8, 19, 3}");
        System.out.println("  (indices validos: 0 a 4)");
        System.out.println();

        do {
            try {
                int pos = obtenerDatos(array);
                System.out.println("  array[" + pos + "] = " + array[pos]);
                salir = true;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("  Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("  Error: Numero no valido");
                new Scanner(System.in).nextLine();
            } catch (Exception e) {
                System.out.println("  Error desconocido: " + e.getMessage());
            }
        } while (!salir);

        System.out.println("  Programa terminado correctamente");
    }
}
