import java.io.*;

/**
 * Video 8-08: Ficheros binarios (DataOutputStream / DataInputStream)
 *
 * Tema 8: Escritura y lectura de tipos primitivos en ficheros
 * binarios usando DataOutputStream y DataInputStream.
 *
 * URL: https://www.youtube.com/watch?v=ov2EoNfxIdA&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=179
 */
class Video_8_08_FicherosBinarios {

    public static final String TITULO = "8-08 JAVA: Ficheros binarios ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=ov2EoNfxIdA&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=179";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-08 - FICHEROS BINARIOS
        ================================================================

        Los ficheros binarios almacenan datos directamente en binario
        (secuencias de bits), sin conversion a caracteres.

        Ventajas:
          - Mas compacto y eficiente (sin conversion)
          - El hardware entiende binario directamente

        Desventajas:
          - No legible por humanos
          - Puede ser incompatible entre lenguajes/SO

        --- CLASES PRINCIPALES ---
        DataOutputStream  -> escribir tipos primitivos en binario
        DataInputStream   -> leer tipos primitivos desde binario
        FileOutputStream  -> flujo de bytes de salida
        FileInputStream   -> flujo de bytes de entrada

        --- METODOS DATAOUTPUTSTREAM ---
        writeBoolean(boolean)  -> 1 byte
        writeByte(int)         -> 1 byte
        writeInt(int)          -> 4 bytes
        writeLong(long)        -> 8 bytes
        writeFloat(float)      -> 4 bytes
        writeDouble(double)    -> 8 bytes
        writeUTF(String)       -> 2 bytes (longitud) + N bytes (caracteres)

        --- METODOS DATAINPUTSTREAM ---
        readBoolean()  readByte()  readInt()  readLong()
        readFloat()    readDouble()  readUTF()

        IMPORTANTE: leer en el MISMO ORDEN que se escribio.

        --- CODIFICACION UTF-8 ---
        writeUTF(String) almacena primero 2 bytes con la longitud,
        luego cada caracter se codifica segun su valor Unicode:
          - < 0x0080 (128): 1 byte
          - 0x0080 - 0x07FF: 2 bytes
          - >= 0x0800: 3 bytes

        --- BYTES EN BRUTO ---
        FileInputStream.read() lee byte a byte, devuelve int (0-255)
        o -1 si fin de archivo.
        ================================================================
        """;

    public static final String NOMBRE_FICHERO = "ejemplo.dat";

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: ESCRIBIR tipos primitivos en binario
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 1: ESCRIBIR DATOS BINARIOS");
        System.out.println("=========================================");

        boolean aprobado = true;
        String nombre = "Pep";
        int convocatoria = 1;
        double nota = 7.8;

        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(NOMBRE_FICHERO))) {

            dos.writeBoolean(aprobado);
            dos.writeUTF(nombre);
            dos.writeInt(convocatoria);
            dos.writeDouble(nota);

            System.out.println("  Escritos en '" + NOMBRE_FICHERO + "':");
            System.out.println("    boolean: " + aprobado);
            System.out.println("    String:  " + nombre);
            System.out.println("    int:     " + convocatoria);
            System.out.println("    double:  " + nota);
        } catch (IOException e) {
            System.out.println("  Error al escribir: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 2: LEER tipos primitivos (mismo orden)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 2: LEER DATOS BINARIOS");
        System.out.println("=========================================");

        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(NOMBRE_FICHERO))) {

            boolean leidoBool = dis.readBoolean();
            String leidoStr = dis.readUTF();
            int leidoInt = dis.readInt();
            double leidoDouble = dis.readDouble();

            System.out.println("  Leidos de '" + NOMBRE_FICHERO + "':");
            System.out.println("    boolean: " + leidoBool);
            System.out.println("    String:  " + leidoStr);
            System.out.println("    int:     " + leidoInt);
            System.out.println("    double:  " + leidoDouble);
        } catch (IOException e) {
            System.out.println("  Error al leer: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 3: LEER BYTES EN BRUTO (sin DataInputStream)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 3: BYTES EN BRUTO (0-255)");
        System.out.println("=========================================");

        File f = new File(NOMBRE_FICHERO);
        System.out.println("  Tamano del archivo: " + f.length() + " bytes");
        System.out.print("  Bytes: ");

        try (FileInputStream fis = new FileInputStream(NOMBRE_FICHERO)) {
            int num;
            int count = 0;
            while ((num = fis.read()) != -1) {
                System.out.print(num + " ");
                count++;
                if (count % 20 == 0) System.out.println();
            }
            System.out.println();
            System.out.println("  Total bytes leidos: " + count);
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 4: BUFFERED (con BufferedOutputStream)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 4: CON BUFFER");
        System.out.println("=========================================");

        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("buffer_ejemplo.dat")))) {

            for (int i = 1; i <= 1000; i++) {
                dos.writeInt(i);
            }
            System.out.println("  Escritos 1000 enteros en 'buffer_ejemplo.dat'");
            System.out.println("  (BufferedOutputStream mejora la eficiencia)");
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }

        // Leerlos para comprobar
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("buffer_ejemplo.dat")))) {

            int suma = 0;
            for (int i = 1; i <= 1000; i++) {
                suma += dis.readInt();
            }
            System.out.println("  Suma de los 1000 enteros leidos: " + suma);
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 5: CODIFICACION UTF (caracteres de distinto tamano)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 5: CODIFICACION UTF");
        System.out.println("=========================================");

        // Caracteres con distintos valores Unicode
        char c1 = 86;    // 'V' (codigo 86, < 128 -> 1 byte)
        char c2 = 159;   // caracter especial (entre 128 y 2047 -> 2 bytes)
        char c3 = 1000;  // caracter especial (>= 2048 -> 3 bytes)

        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("codificacion.dat"))) {

            dos.writeUTF("V" + c1);   // 2+2=4 bytes (longitud+2charsx1byte)
            dos.writeUTF("V" + c2);   // 2+1+2=5 bytes
            dos.writeUTF("V" + c3);   // 2+1+3=6 bytes

            System.out.println("  Escritas 3 cadenas con codificacion UTF");
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }

        // Leer bytes en bruto para ver el tamano
        File fCod = new File("codificacion.dat");
        System.out.println("  Tamano del archivo: " + fCod.length() + " bytes");
        System.out.print("  Bytes: ");
        try (FileInputStream fis = new FileInputStream(fCod)) {
            int b;
            while ((b = fis.read()) != -1) {
                System.out.print(b + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 6: ESCRIBIR VARIOS TIPOS Y VER ESTRUCTURA
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 6: ESTRUCTURA DEL ARCHIVO");
        System.out.println("=========================================");

        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("estructura.dat"))) {

            dos.writeBoolean(true);           // 1 byte
            dos.writeUTF("Pepe");             // 2 (longitud) + 4 chars = 6 bytes
            dos.writeInt(1);                  // 4 bytes
            dos.writeDouble(7.8);             // 8 bytes
            // Total: 1 + 6 + 4 + 8 = 19 bytes
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }

        File fEst = new File("estructura.dat");
        System.out.println("  Tamano esperado: 19 bytes");
        System.out.println("  Tamano real: " + fEst.length() + " bytes");
        System.out.println();
        System.out.println("  Estructura:");
        System.out.println("    Byte 1:        boolean (1=true, 0=false)");
        System.out.println("    Bytes 2-3:     longitud String (2 bytes)");
        System.out.println("    Bytes 4-7:     caracteres String (4 bytes)");
        System.out.println("    Bytes 8-11:    int (4 bytes)");
        System.out.println("    Bytes 12-19:   double (8 bytes)");
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  RESUMEN: FICHEROS BINARIOS");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  ESCRITURA: FileOutputStream -> DataOutputStream");
        System.out.println("    .writeBoolean() .writeUTF() .writeInt() .writeDouble()");
        System.out.println();
        System.out.println("  LECTURA: FileInputStream -> DataInputStream");
        System.out.println("    .readBoolean() .readUTF() .readInt() .readDouble()");
        System.out.println();
        System.out.println("  BUFFER: envolver con BufferedOutputStream/InputStream");
        System.out.println("    new DataOutputStream(new BufferedOutputStream(new FileOutputStream(...)))");
        System.out.println();
        System.out.println("  BYTES EN BRUTO: FileInputStream.read() -> int (0-255) o -1");
        System.out.println("  writeUTF(String): 2 bytes longitud + N bytes caracteres");
        System.out.println("  LEER EN EL MISMO ORDEN QUE SE ESCRIBIO");
        System.out.println();

        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V08: FICHEROS BINARIOS)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - DataOutputStream/DataInputStream: escribir/leer primitivos");
        System.out.println("  - writeUTF: 2 bytes de longitud + chars (1-3 bytes c/u)");
        System.out.println("  - read() del FileInputStream: devuelve int entre 0 y 255");
        System.out.println("  - LEER EN EL MISMO ORDEN que se escribio (esencial)");
        System.out.println("  - BufferedOutputStream para mejorar eficiencia");
        System.out.println("  - Proximo video: serializacion de objetos (ObjectOutputStream)");
    }
}
