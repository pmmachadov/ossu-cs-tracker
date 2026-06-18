import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Video 8-05: PrintWriter y Scanner para ficheros de texto
 *
 * Tema 8: Clases mas versatiles que FileReader/FileWriter
 * para leer y escribir datos formateados en ficheros de texto.
 *
 * URL: https://www.youtube.com/watch?v=ajcnc2O4f_A&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=176
 */
class Video_8_05_PrintWriterYScanner {

    public static final String TITULO = "8-05 JAVA: PrintWriter y Scanner ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=ajcnc2O4f_A&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=176";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-05 - PRINTWRITER Y SCANNER
        ================================================================

        Clases para trabajar con ficheros de texto de forma mas
        versatil que FileReader/FileWriter.

        --- PRINTWRITER (escritura) ---
        Subclase de Writer. Mas versatil que FileWriter.
        Permite imprimir representaciones de varios tipos de datos.

        Constructores:
          PrintWriter(Writer out)
            -> Recibe un FileWriter, BufferedWriter, etc.
          PrintWriter(String fileName)
            -> Directamente el nombre del archivo (crea FileWriter internamente)
          PrintWriter(File file)
            -> Recibe un objeto File

        Por defecto: si el archivo existe, TRUNCA el contenido a 0.
        Para APPEND: pasar FileWriter con append=true al constructor.

        Metodos:
          print(String s)         -> escribe String sin salto de linea
          println(String s)       -> escribe String con salto de linea
          print(int n)            -> escribe entero
          println(int n)          -> escribe entero con salto
          print(double d)         -> escribe double
          print(float f)          -> escribe float
          printf(String format, Object... args) -> formato
          close()                 -> cierra el flujo

        --- SCANNER (lectura) ---
        Clase para analizar y leer datos desde varias fuentes.

        Constructores:
          Scanner(File source)        -> lee desde un archivo
          Scanner(String source)      -> lee desde una cadena
          Scanner(InputStream source) -> System.in (teclado)

        Metodos:
          hasNextLine()   -> true si quedan lineas
          nextLine()      -> devuelve la siguiente linea completa
          hasNext()       -> true si quedan tokens
          next()          -> devuelve el siguiente token (String)
          hasNextInt()    -> true si el siguiente token es entero
          nextInt()       -> devuelve el siguiente token como int
          hasNextDouble() -> true si el siguiente token es double
          close()         -> cierra el scanner
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: PRINTWRITER (escritura basica)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 1: PRINTWRITER (escritura)");
        System.out.println("=========================================");

        String fichero = "ejemplo.txt";
        PrintWriter pw = null;
        try {
            // PrintWriter recibe un FileWriter
            pw = new PrintWriter(new FileWriter(fichero));

            pw.print("Esto es un texto");            // sin salto de linea
            pw.print(" nueva palabra");               // se pega a lo anterior
            pw.println(" esto es un texto con salto"); // con salto de linea
            pw.println(3.1416);                       // double
            pw.println("Linea adicional");

            // Stream API + PrintWriter: filtrar y escribir en fichero
            Arrays.stream(new int[]{1, 2, 3, 4, 10})
                    .filter(n -> n > 2)
                    .map(n -> n * 2)
                    .forEach(pw::println);  // escribe 6, 8, 20 cada uno en una linea

            pw.close();
            System.out.println("  Escrito en '" + fichero + "' correctamente");
        } catch (IOException e) {
            System.out.println("  Error de E/S: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 2: PRINTWRITER MODO APPEND
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 2: PRINTWRITER (APPEND)");
        System.out.println("=========================================");

        try (PrintWriter pwAppend = new PrintWriter(new FileWriter("ejemplo.txt", true))) {
            pwAppend.println("--- Anadido al final ---");
            pwAppend.println("Linea anadida con append=true");
            System.out.println("  Contenido anadido al final de 'ejemplo.txt'");
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 3: PRINTWRITER CON CONSTRUCTOR DIRECTO (String)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 3: PRINTWRITER (constructor directo)");
        System.out.println("=========================================");

        // PrintWriter(String) es mas corto, crea FileWriter internamente
        try (PrintWriter pwDirecto = new PrintWriter("directo.txt")) {
            pwDirecto.println("Escrito con PrintWriter(String)");
            pwDirecto.println("Segunda linea");
            pwDirecto.printf("Numero: %d, Double: %.2f%n", 42, 3.1416);
            System.out.println("  Escrito en 'directo.txt'");
        } catch (FileNotFoundException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 4: SCANNER LEER LINEA A LINEA
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 4: SCANNER (leer por lineas)");
        System.out.println("=========================================");

        Scanner sc = null;
        try {
            sc = new Scanner(new File("ejemplo.txt"));
            System.out.println("  Contenido de 'ejemplo.txt':");
            while (sc.hasNextLine()) {
                System.out.println("    " + sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("  No se pudo encontrar el archivo");
        } finally {
            if (sc != null) sc.close();
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 5: ESCRIBIR 1..1000 Y LUEGO LEERLOS CON SCANNER
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 5: ESCRIBIR + LEER ENTEROS");
        System.out.println("=========================================");

        String nombreFichero = "fichero_enteros.txt";

        // ESCRIBIR: numeros del 1 al 1000, 100 por linea
        try (PrintWriter pwr = new PrintWriter(nombreFichero)) {
            for (int i = 1; i <= 1000; i++) {
                pwr.print(i + " ");
                if (i % 100 == 0) {
                    pwr.println();  // salto de linea cada 100 numeros
                }
            }
            System.out.println("  Escritos 1000 enteros en '" + nombreFichero + "'");
        } catch (FileNotFoundException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // LEER: los enteros escritos
        try (Scanner scanner = new Scanner(new File(nombreFichero))) {
            System.out.println("  Leyendo enteros (mostrando solo algunos):");
            int count = 0;
            while (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                if (valor <= 10 || valor > 990 || (valor % 100 == 0)) {
                    System.out.print(valor + " ");
                }
                count++;
            }
            System.out.println();
            System.out.println("  Total enteros leidos: " + count);
        } catch (FileNotFoundException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 6: SCANNER CON TOKENS NO ENTEROS
        // (saltar palabras, leer solo enteros)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 6: SCANNER + hasNextInt()");
        System.out.println("  (saltar tokens no enteros)");
        System.out.println("=========================================");

        // Creamos un fichero con enteros y palabras mezclados
        try (PrintWriter pwMix = new PrintWriter("mezclado.txt")) {
            for (int i = 1; i <= 20; i++) {
                pwMix.print(i + " ");
                if (i % 5 == 0) {
                    pwMix.print("saltar ");
                    pwMix.println();
                }
            }
            System.out.println("  Creado 'mezclado.txt' con numeros y palabras");
        } catch (FileNotFoundException e) {
            System.out.println("  Error: " + e.getMessage());
        }

        // Leer solo los enteros usando hasNextInt()
        try (Scanner scMix = new Scanner(new File("mezclado.txt"))) {
            System.out.print("  Solo enteros: ");
            while (scMix.hasNext()) {
                if (scMix.hasNextInt()) {
                    System.out.print(scMix.nextInt() + " ");
                } else {
                    scMix.next();  // descartar token no entero
                }
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // RESUMEN COMPARATIVO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  COMPARATIVA: FileWriter vs PrintWriter");
        System.out.println("=========================================");
        System.out.println();
        System.out.printf("  %-20s %-25s %-25s%n", "CARACTERISTICA", "FileWriter", "PrintWriter");
        System.out.printf("  %-20s %-25s %-25s%n", "---------------", "-----------", "-----------");
        System.out.printf("  %-20s %-25s %-25s%n", "write(String)", "Si", "No directo");
        System.out.printf("  %-20s %-25s %-25s%n", "print/println", "No", "Si (varios tipos)");
        System.out.printf("  %-20s %-25s %-25s%n", "print(int)", "No", "Si");
        System.out.printf("  %-20s %-25s %-25s%n", "print(double)", "No", "Si");
        System.out.printf("  %-20s %-25s %-25s%n", "printf", "No", "Si");
        System.out.printf("  %-20s %-25s %-25s%n", "Auto-flush", "No", "Configurable");
        System.out.println();
        System.out.println("  SCANNER vs FileReader:");
        System.out.println("  - Scanner: metodos hasNextInt(), nextLine(), etc.");
        System.out.println("  - FileReader: solo read() devuelve int Unicode");
        System.out.println("  - Scanner es mas comodo para analizar datos formateados");

        System.out.println();

        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V05: PRINTWRITER Y SCANNER)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - PrintWriter: print/println para varios tipos de datos");
        System.out.println("  - Scanner: hasNextInt(), nextInt(), hasNextLine(), nextLine()");
        System.out.println("  - Append: new PrintWriter(new FileWriter(\"f\", true))");
        System.out.println("  - hasNextInt() para evitar InputMismatchException");
        System.out.println("  - PrintWriter(String) constructor directo (mas corto)");
        System.out.println("  - Proximo video: BufferedReader y BufferedWriter");
    }
}
