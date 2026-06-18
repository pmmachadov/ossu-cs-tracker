import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Video 8-11: Ficheros con java.nio
 *
 * Tema 8: Lectura/escritura de ficheros de texto y binarios
 * usando las clases del paquete java.nio (Path, Files,
 * FileChannel, ByteBuffer).
 *
 * URL: https://www.youtube.com/watch?v=s8Ea7478mmA&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=182
 */
class Video_8_11_FicherosJavaNIO {

    public static final String TITULO = "8-11 JAVA: Ficheros con java.nio ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=s8Ea7478mmA&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=182";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-11 - FICHEROS CON JAVA.NIO
        ================================================================

        java.nio proporciona clases para trabajar con ficheros
        de forma mas eficiente que java.io.

        --- FICHEROS DE TEXTO ---
        Path (java.nio.file.Path):
          Similar a File pero de java.nio.
          Paths.get("ruta") -> crea un Path

        Files (java.nio.file.Files):
          Files.write(path, lineas, charset)  -> escribe lista a texto
          Files.readAllLines(path, charset)   -> lee todas las lineas

        --- FICHEROS BINARIOS (Canales y Buffers) ---
        FileChannel:
          canal bidireccional para leer/escribir datos
          Se obtiene de FileOutputStream o FileInputStream

        ByteBuffer:
          buffer de bytes con capacidad fija
          ByteBuffer.allocate(tamano)

        METODOS DEL BUFFER:
          putInt(int)    -> escribe un entero en el buffer
          getInt()       -> lee un entero del buffer
          flip()         -> prepara buffer para lectura (pos=0, lim=posActual)
          hasRemaining() -> true si quedan datos en el buffer
          position(n)    -> establece la posicion de lectura
          limit(n)       -> establece el limite de lectura

        CANAL:
          channel.write(buffer)  -> escribe buffer al fichero
          channel.read(buffer)   -> lee fichero al buffer

        --- try-with-resources ---
        try (Recurso r = new Recurso()) { ... }
        Cierra automaticamente el recurso al salir del bloque.
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: TEXTO - ESCRIBIR con java.nio.file.Files
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 1: ESCRIBIR TEXTO (java.nio)");
        System.out.println("=========================================");

        List<String> lineas = Arrays.asList(
                "Primera linea del fichero",
                "Segunda linea del fichero",
                "Tercera linea del fichero"
        );

        Path ficheroTexto = Paths.get("archivo_nio.txt");
        try {
            Files.write(ficheroTexto, lineas, StandardCharsets.UTF_8);
            System.out.println("  Escritas " + lineas.size() + " lineas en 'archivo_nio.txt'");
        } catch (IOException e) {
            System.out.println("  Error al escribir: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 2: TEXTO - LEER con java.nio.file.Files
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 2: LEER TEXTO (java.nio)");
        System.out.println("=========================================");

        try {
            List<String> lineasLeidas = Files.readAllLines(ficheroTexto, StandardCharsets.UTF_8);
            System.out.println("  Contenido de 'archivo_nio.txt':");
            for (String linea : lineasLeidas) {
                System.out.println("    " + linea);
            }
        } catch (IOException e) {
            System.out.println("  Error al leer: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 3: BINARIO - ESCRIBIR con FileChannel + ByteBuffer
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 3: BINARIO - ESCRIBIR");
        System.out.println("  (FileChannel + ByteBuffer)");
        System.out.println("=========================================");

        try (FileOutputStream fos = new FileOutputStream("integers.bin");
             FileChannel canal = fos.getChannel()) {

            // Crear buffer para 4 enteros (4 * 4 = 16 bytes)
            ByteBuffer buffer = ByteBuffer.allocate(16);

            // Escribir enteros 0, 1, 2, 3 en el buffer
            for (int i = 0; i < 4; i++) {
                buffer.putInt(i);
            }

            // flip() prepara el buffer para escritura
            // posicion = 0, limite = posicion actual
            buffer.flip();

            // Escribir el buffer al fichero a traves del canal
            canal.write(buffer);

            System.out.println("  Escritos 4 enteros (0-3) en 'integers.bin'");
            System.out.println("  Tamano: 4 * 4 = 16 bytes");
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 4: BINARIO - LEER con FileChannel + ByteBuffer
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 4: BINARIO - LEER");
        System.out.println("=========================================");

        try (FileInputStream fis = new FileInputStream("integers.bin");
             FileChannel canal = fis.getChannel()) {

            // Crear buffer para 4 enteros
            ByteBuffer buffer = ByteBuffer.allocate(16);

            // Leer datos del fichero al buffer
            canal.read(buffer);

            // flip() prepara para leer (pos=0, lim=posActual)
            buffer.flip();

            System.out.print("  Enteros leidos: ");
            while (buffer.hasRemaining()) {
                int valor = buffer.getInt();
                System.out.print(valor + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 5: MANIPULACION DE POSICION Y LIMITE
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 5: position() y limit()");
        System.out.println("=========================================");

        try (FileInputStream fis = new FileInputStream("integers.bin");
             FileChannel canal = fis.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(16);
            canal.read(buffer);

            // Leer solo los ultimos 2 enteros (posicion=8)
            buffer.position(8);
            System.out.print("  position(8): ");
            while (buffer.hasRemaining()) {
                System.out.print(buffer.getInt() + " ");
            }
            System.out.println("  (enteros 2 y 3)");

        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }

        // Leer con limit()
        try (FileInputStream fis = new FileInputStream("integers.bin");
             FileChannel canal = fis.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(16);
            canal.read(buffer);

            // Limitar a solo 8 bytes (2 enteros)
            buffer.limit(8);
            buffer.position(0);
            System.out.print("  limit(8): ");
            while (buffer.hasRemaining()) {
                System.out.print(buffer.getInt() + " ");
            }
            System.out.println("  (solo enteros 0 y 1)");

        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 6: MODIFICAR DATOS EN EL BUFFER
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 6: MODIFICAR BUFFER");
        System.out.println("=========================================");

        try (FileOutputStream fos = new FileOutputStream("modificado.bin");
             FileChannel canal = fos.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(16);

            // Escribir 0, 1, 2, 3
            for (int i = 0; i < 4; i++) buffer.putInt(i);

            // Modificar: escribir 5 en posicion 8 (tercer entero)
            buffer.putInt(8, 5);  // putInt(index, value)

            // Anadir un 7 al final
            buffer.position(12);
            buffer.putInt(7);

            buffer.flip();
            canal.write(buffer);

            System.out.println("  Escritos: [0, 1, 5, 7] en 'modificado.bin'");
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  RESUMEN: java.nio");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  TEXTO:");
        System.out.println("    Path p = Paths.get(\"archivo.txt\")");
        System.out.println("    Files.write(p, lista, StandardCharsets.UTF_8)");
        System.out.println("    Files.readAllLines(p, StandardCharsets.UTF_8)");
        System.out.println();
        System.out.println("  BINARIO (canales + buffers):");
        System.out.println("    FileOutputStream -> FileChannel");
        System.out.println("    ByteBuffer.allocate(tamano)");
        System.out.println("    buffer.putInt(x) / buffer.getInt()");
        System.out.println("    buffer.flip(): prepara buffer (pos=0, lim=posActual)");
        System.out.println("    canal.write(buffer) / canal.read(buffer)");
        System.out.println("    buffer.hasRemaining(): quedan datos?");
        System.out.println();
        System.out.println("  try-with-resources:");
        System.out.println("    try (Recurso r = new Recurso()) { ... }");
        System.out.println("    Cierra automaticamente al salir del bloque");

        System.out.println();
        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V11: FICHEROS CON JAVA.NIO)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Path / Files: alternativa moderna a File");
        System.out.println("  - FileChannel: canal bidireccional (leer y escribir)");
        System.out.println("  - ByteBuffer: buffer con capacidad fija");
        System.out.println("  - flip(): cambia de escritura a lectura (pos=0)");
        System.out.println("  - position(n) / limit(n): control manual");
        System.out.println("  - try-with-resources: cierre automatico");
        System.out.println("  - Fin del bloque de ficheros. Proximo: BD en Java");
    }
}
