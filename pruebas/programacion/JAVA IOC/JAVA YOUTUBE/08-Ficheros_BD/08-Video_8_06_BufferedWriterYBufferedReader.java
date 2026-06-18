import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Video 8-06: BufferedWriter y BufferedReader
 *
 * Tema 8: Clases con buffer para lectura/escritura eficiente
 * de ficheros de texto.
 *
 * URL: https://www.youtube.com/watch?v=LeLR8C8FsUE&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=177
 */
class Video_8_06_BufferedWriterYBufferedReader {

    public static final String TITULO = "8-06 JAVA: BufferedWriter y BufferedReader ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=LeLR8C8FsUE&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=177";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-06 - BUFFEREDWRITER Y BUFFEREDREADER
        ================================================================

        Clases que envuelven a FileReader/FileWriter añadiendo
        un BUFFER para mejorar la eficiencia.

        --- ¿QUE ES UN BUFFER? ---
        Es un espacio de memoria intermedio que acumula datos antes
        de escribirlos/leerlos del disco.

        Sin buffer: cada escritura va directamente al disco (muchas ops)
        Con buffer: se acumula hasta llenar el buffer y se escribe de golpe

        Ejemplo: escribir 3.5 KB de datos con buffer de 1 KB:
        - Sin buffer: muchas escrituras (1 cada 2 bytes aprox)
        - Con buffer: solo 4 escrituras (1 KB + 1 KB + 1 KB + 0.5 KB)

        --- CONSTRUCTORES ---
        BufferedWriter(Writer out)   -> envuelve FileWriter, etc.
        BufferedReader(Reader in)    -> envuelve FileReader, etc.

        --- BUFFEREDWRITER (escritura) ---
        write(String s)   -> escribe una cadena
        write(int c)      -> escribe un CARACTER (valor Unicode)
        newLine()         -> escribe un salto de linea
        flush()           -> vacia el buffer forzando la escritura

        --- BUFFEREDREADER (lectura) ---
        readLine()   -> devuelve String con la linea completa
                         o null si se llego al final del archivo
        read()       -> lee un caracter, devuelve int (Unicode)
                         o -1 si fin de archivo

        --- EJERCICIO 1: crearLineas(String, int) ---
        Crea un archivo con N lineas, cada una:
          "Esta es la linea 1"
          "Esta es la linea 2"
          ...

        --- EJERCICIO 2: contarPalabras(String) ---
        Cuenta las palabras de un archivo usando BufferedReader
        + split() o Stream API.
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // EJERCICIO 1: CREAR LINEAS CON BUFFEREDWRITER
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJERCICIO 1: crearLineas()");
        System.out.println("=========================================");
        crearLineas("archivo.txt", 10);
        System.out.println();

        // ============================================================
        // EJERCICIO 2: CONTAR PALABRAS CON BUFFEREDREADER
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJERCICIO 2: contarPalabras()");
        System.out.println("=========================================");
        contarPalabras("archivo.txt");
        System.out.println();

        // ============================================================
        // DEMO: BUFFEREDWRITER CON write(int) -> UNICODE
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  DEMO: BufferedWriter.write(int)");
        System.out.println("  (write(97) escribe 'a', write(169) escribe (c))");
        System.out.println("=========================================");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("unicode_demo.txt"))) {
            bw.write("Codigos Unicode: ");
            bw.write(97);   // 'a'
            bw.write(98);   // 'b'
            bw.write(99);   // 'c'
            bw.newLine();
            bw.write(169);  // simbolo copyright
            bw.write(174);  // simbolo registered
            bw.newLine();
            System.out.println("  Escrito en 'unicode_demo.txt'");
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        // Leer para comprobar
        try (BufferedReader br = new BufferedReader(new FileReader("unicode_demo.txt"))) {
            System.out.println("  Contenido:");
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("    " + linea);
            }
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // DEMO: BUFFEREDREADER.read()
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  DEMO: BufferedReader.read()");
        System.out.println("=========================================");
        try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {
            System.out.print("  Primeros 20 caracteres: ");
            int c;
            int count = 0;
            while ((c = br.read()) != -1 && count < 20) {
                System.out.print((char) c);
                count++;
            }
            System.out.println();
            System.out.println("  (leidos " + count + " caracteres)");
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // DEMO: FLUSH() - forzar escritura del buffer
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  DEMO: flush()");
        System.out.println("=========================================");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("flush_demo.txt"))) {
            bw.write("Este texto se escribe con flush()");
            bw.flush();  // fuerza la escritura inmediata
            System.out.println("  flush() ejecutado: datos escritos en disco");
            bw.newLine();
            bw.write("Segunda linea (se escribe al cerrar)");
            System.out.println("  Segunda linea escrita (aun en buffer)");
            // Al salir del try-with-resources se cierra y hace flush automatico
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // CREAR FICHERO CON MUCHAS LINEAS (100)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  CREAR 100 LINEAS Y CONTAR PALABRAS");
        System.out.println("=========================================");
        crearLineas("cien_lineas.txt", 100);
        contarPalabras("cien_lineas.txt");
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  RESUMEN BUFFEREDWRITER / BUFFEREDREADER");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  BUFFEREDWRITER:");
        System.out.println("    - Envuelve a FileWriter anadiendo buffer");
        System.out.println("    - write(String): escribe cadena");
        System.out.println("    - write(int): escribe un CARACTER (valor Unicode)");
        System.out.println("    - newLine(): salto de linea");
        System.out.println("    - flush(): vacia el buffer al disco");
        System.out.println("    - Al cerrar, se cierra automaticamente el FileWriter");
        System.out.println();
        System.out.println("  BUFFEREDREADER:");
        System.out.println("    - Envuelve a FileReader anadiendo buffer");
        System.out.println("    - readLine(): String o null si EOF");
        System.out.println("    - read(): int (Unicode) o -1 si EOF");
        System.out.println("    - Bucle tipico: while ((linea=br.readLine()) != null)");
        System.out.println("    - Al cerrar, se cierra automaticamente el FileReader");
        System.out.println();
        System.out.println("  VENTAJA DEL BUFFER:");
        System.out.println("    - Minimiza accesos a disco (mucho mas rapido)");
        System.out.println("    - Para archivos grandes, la diferencia es ABISMAL");

        System.out.println();
        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V06: BUFFEREDWRITER Y BUFFEREDREADER)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - BufferedWriter/BufferedReader: ANYADEN BUFFER a FileWriter/Reader");
        System.out.println("  - readLine() devuelve String o null si EOF");
        System.out.println("  - write(int) escribe un CARACTER, NO un entero (codigo Unicode)");
        System.out.println("  - newLine() portable (no depende del SO)");
        System.out.println("  - flush() fuerza escritura del buffer al disco");
        System.out.println("  - Al cerrar el buffer, se cierra el flujo interno automaticamente");
        System.out.println("  - Proximo video: ejercicios de repaso + ficheros binarios");
    }

    // ================================================================
    // EJERCICIO 1: CREAR LINEAS CON BUFFEREDWRITER
    // ================================================================
    static void crearLineas(String nombreFichero, int numLineas) {
        try {
            FileWriter fw = new FileWriter(nombreFichero);
            BufferedWriter bw = new BufferedWriter(fw);
            // NOTA: Tambien se puede hacer en una linea:
            // BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero));

            for (int i = 1; i <= numLineas; i++) {
                bw.write("Esta es la linea " + i);
                bw.newLine();  // salto de linea portable
            }

            bw.close();  // al cerrar bw se cierra automaticamente fw tambien
            System.out.println("  '" + nombreFichero + "' creado con " + numLineas + " lineas");
        } catch (IOException e) {
            System.out.println("  Error al crear o escribir en archivo");
            e.printStackTrace();
        }
    }

    // ================================================================
    // EJERCICIO 2: CONTAR PALABRAS CON BUFFEREDREADER
    // ================================================================
    static void contarPalabras(String nombreArchivo) {
        try {
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(fr);

            int palabras = 0;
            String linea;

            // readLine() devuelve String o null si fin de archivo
            while ((linea = br.readLine()) != null) {
                // Contar palabras de la linea usando split
                if (!linea.trim().isEmpty()) {
                    // Solucion con split + length
                    // palabras += linea.split("\\\\s+").length;

                    // Solucion con Stream API (programacion funcional)
                    palabras += Arrays.stream(linea.split("\\\\s+")).count();
                }
            }

            br.close();  // cierra automaticamente fr
            System.out.println("  El archivo '" + nombreArchivo + "' contiene " + palabras + " palabras");
        } catch (IOException e) {
            System.out.println("  Error al leer el archivo");
            e.printStackTrace();
        }
    }
}
