import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Video 8-04: FileReader y FileWriter
 *
 * Tema 8: Flujos de caracteres para lectura y escritura
 * de archivos de texto en Java.
 *
 * URL: https://www.youtube.com/watch?v=iuRM-VRgOEM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=175
 */
class Video_8_04_FileReaderYFileWriter {

    public static final String TITULO = "8-04 JAVA: FileReader y FileWriter ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=iuRM-VRgOEM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=175";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-04 - FILEREADER Y FILEWRITER
        ================================================================

        Flujos (Streams) en Java: secuencia de datos para leer
        o escribir en ficheros.

        --- TIPOS DE FLUJOS ---
        Segun direccion:
          - Input Stream:  lectura de datos
          - Output Stream: escritura de datos

        Segun tipo de dato:
          - Flujos de BYTES:   unidad = 1 byte  (ficheros binarios)
          - Flujos de CHAR:    unidad = 2 bytes (ficheros de texto)

        --- CLASES DE BYTES ---
        InputStream (abstracta):
          FileInputStream, BufferedInputStream,
          DataInputStream, ObjectInputStream

        OutputStream (abstracta):
          FileOutputStream, BufferedOutputStream,
          DataOutputStream, ObjectOutputStream

        --- CLASES DE CARACTERES ---
        Reader (abstracta):
          FileReader, BufferedReader, InputStreamReader

        Writer (abstracta):
          FileWriter, BufferedWriter, OutputStreamWriter

        --- FILEWRITER ---
        Sirve para ESCRIBIR en ficheros de texto.

        Constructores:
          FileWriter(String nombre)
            -> SOBREESCRIBE el contenido si el archivo existe
          FileWriter(String nombre, boolean append)
            -> Si append=true, AGREGA al final del archivo

        Metodos:
          write(String str)   -> escribe una cadena
          write(int c)        -> escribe un caracter
          write(char[] cbuf)  -> escribe un array de caracteres
          close()             -> cierra el flujo (OBLIGATORIO!)

        --- FILEREADER ---
        Sirve para LEER ficheros de texto.

        Constructor:
          FileReader(String nombre)

        Metodos:
          read()  -> lee un caracter, devuelve int (Unicode)
                     o -1 si se llego al final del archivo
          close() -> cierra el flujo

        Bucle tipico de lectura:
          int caracter;
          while ((caracter = fileReader.read()) != -1) {
              System.out.print((char) caracter);
          }
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        String nombreFichero = "fichero.txt";
        String texto = "Este es un ejemplo de uso de FileWriter en Java";

        // ============================================================
        // EJEMPLO 1: ESCRIBIR (FileWriter - modo overwrite)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 1: ESCRIBIR (FileWriter)");
        System.out.println("=========================================");

        FileWriter fw = null;
        try {
            // Constructor SIN append -> sobreescribe
            fw = new FileWriter(nombreFichero);
            fw.write(texto);
            fw.close();
            System.out.println("  Escrito en '" + nombreFichero + "': " + texto);
            System.out.println("  [MODO OVERWRITE: el contenido anterior se ha borrado]");
        } catch (IOException e) {
            System.out.println("  Error al escribir en el fichero");
            e.printStackTrace();
        } finally {
            try { if (fw != null) fw.close(); } catch (IOException e) {}
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 2: LEER (FileReader)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 2: LEER (FileReader)");
        System.out.println("=========================================");

        FileReader fr = null;
        try {
            fr = new FileReader(nombreFichero);
            System.out.print("  Contenido del archivo '" + nombreFichero + "': ");

            int caracter;
            while ((caracter = fr.read()) != -1) {
                System.out.print((char) caracter);
            }
            fr.close();
            System.out.println();
        } catch (IOException e) {
            System.out.println();
            System.out.println("  Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try { if (fr != null) fr.close(); } catch (IOException e) {}
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 3: ESCRIBIR EN MODO APPEND
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 3: APPEND (anadir al final)");
        System.out.println("=========================================");

        try (FileWriter fwAppend = new FileWriter(nombreFichero, true)) {
            // \n para salto de linea antes de anadir
            fwAppend.write("\n" + texto);
            System.out.println("  Anadido al final de '" + nombreFichero + "': " + texto);
        } catch (IOException e) {
            System.out.println("  Error al escribir en modo append");
            e.printStackTrace();
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 4: LEER DESPUES DE APPEND
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 4: LEER (tras append)");
        System.out.println("=========================================");

        leerFichero(nombreFichero);
        System.out.println();

        // ============================================================
        // EJEMPLO 5: LEER MOSTRANDO VALORES UNICODE (sin casting a char)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 5: LEER (valores Unicode)");
        System.out.println("=========================================");

        try (FileReader frUnicode = new FileReader(nombreFichero)) {
            System.out.print("  Valores Unicode: ");
            int c;
            int count = 0;
            while ((c = frUnicode.read()) != -1 && count < 15) {
                System.out.print(c + " ");
                count++;
            }
            System.out.println("...");
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 6: ESCRIBIR VARIAS LINEAS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 6: ESCRIBIR VARIAS LINEAS");
        System.out.println("=========================================");

        String[] lineas = {
            "Linea 1: Hola mundo",
            "Linea 2: Trabajando con ficheros",
            "Linea 3: FileWriter y FileReader",
            "Linea 4: Curso Java - Tema 8"
        };

        try (FileWriter fwLineas = new FileWriter("lineas.txt")) {
            for (String linea : lineas) {
                fwLineas.write(linea + "\n");
            }
            System.out.println("  Escritas " + lineas.length + " lineas en 'lineas.txt'");
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // Leer las lineas
        System.out.println("  Contenido de 'lineas.txt':");
        leerFichero("lineas.txt");
        System.out.println();

        // ============================================================
        // RESUMEN DE LA JERARQUIA DE CLASES
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  JERARQUIA DE FLUJOS (java.io)");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  FLUJOS DE BYTES (binarios):");
        System.out.println("    InputStream (abstract)");
        System.out.println("      +-- FileInputStream");
        System.out.println("      +-- BufferedInputStream");
        System.out.println("      +-- DataInputStream");
        System.out.println("      +-- ObjectInputStream");
        System.out.println();
        System.out.println("    OutputStream (abstract)");
        System.out.println("      +-- FileOutputStream");
        System.out.println("      +-- BufferedOutputStream");
        System.out.println("      +-- DataOutputStream");
        System.out.println("      +-- ObjectOutputStream");
        System.out.println();
        System.out.println("  FLUJOS DE CARACTERES (texto):");
        System.out.println("    Reader (abstract)");
        System.out.println("      +-- FileReader        <-- ESTE VIDEO");
        System.out.println("      +-- BufferedReader");
        System.out.println("      +-- InputStreamReader");
        System.out.println();
        System.out.println("    Writer (abstract)");
        System.out.println("      +-- FileWriter        <-- ESTE VIDEO");
        System.out.println("      +-- BufferedWriter");
        System.out.println("      +-- OutputStreamWriter");
        System.out.println();

        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V04: FILEREADER Y FILEWRITER)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - FileWriter: escribe caracteres en ficheros de texto");
        System.out.println("  - FileReader: lee caracteres de ficheros de texto");
        System.out.println("  - read() devuelve int (Unicode) o -1 si fin de fichero");
        System.out.println("  - (char) casting convierte el int Unicode a caracter");
        System.out.println("  - append=true: anade al final, sin append: sobreescribe");
        System.out.println("  - SIEMPRE cerrar el flujo (close() o try-with-resources)");
        System.out.println("  - Proximo video: PrintWriter y Scanner para ficheros de texto");
    }

    // ================================================================
    // MÉTODO AUXILIAR: leer fichero y mostrar su contenido
    // ================================================================
    static void leerFichero(String nombreFichero) {
        try (FileReader fr = new FileReader(nombreFichero)) {
            System.out.print("    ");
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("    Error al leer '" + nombreFichero + "': " + e.getMessage());
        }
    }
}
