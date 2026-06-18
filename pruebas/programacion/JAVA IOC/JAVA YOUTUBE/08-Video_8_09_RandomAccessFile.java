import java.io.*;

/**
 * Video 8-09: RandomAccessFile
 *
 * Tema 8: Acceso aleatorio a ficheros binarios.
 * Permite leer/escribir datos en cualquier posicion
 * sin necesidad de recorrer secuencialmente.
 *
 * URL: https://www.youtube.com/watch?v=ZusJ9y_bEe8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=180
 */
class Video_8_09_RandomAccessFile {

    public static final String TITULO = "8-09 JAVA: RandomAccessFile ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=ZusJ9y_bEe8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=180";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-09 - RANDOMACCESSFILE
        ================================================================

        Dos tipos de acceso a ficheros:

        ACCESO SECUENCIAL (hasta ahora):
          - Los datos se leen/escriben en orden
          - Para acceder al dato N, hay que leer los N-1 anteriores
          - FileInputStream / FileOutputStream (binario)
          - FileReader / FileWriter (texto)

        ACCESO ALEATORIO (RandomAccessFile):
          - Permite acceder DIRECTAMENTE a cualquier posicion
          - Los datos se almacenan en registros de TAMAÑO FIJO conocido
          - seek(pos) mueve el puntero a la posicion deseada

        --- CONSTRUCTOR ---
        RandomAccessFile(String nombre, String modo)
          Modos:
            "r"  -> solo lectura
            "rw" -> lectura y escritura
            "rws" -> lectura/escritura + sincronizacion

        --- METODOS PRINCIPALES ---
        seek(long pos)     -> mueve el puntero a la posicion en bytes
        getFilePointer()   -> devuelve la posicion actual del puntero
        length()           -> tamano del archivo en bytes

        writeInt(int)      -> escribe entero (4 bytes)
        readInt()          -> lee entero (4 bytes)
        writeUTF(String)   -> escribe String (UTF-8)
        readUTF()          -> lee String (UTF-8)
        writeDouble(double)-> escribe double (8 bytes)
        readDouble()       -> lee double (8 bytes)
        close()            -> cierra el archivo

        --- REGLA IMPORTANTE ---
        Para acceder al entero n-esimo:
          seek((n-1) * 4)   porque cada entero ocupa 4 bytes

        Para acceder al double n-esimo:
          seek((n-1) * 8)   porque cada double ocupa 8 bytes

        Si se lee en una posicion NO alineada con el tamano
        del tipo de dato, se obtendran datos basura.

        --- RECOMENDACION ---
        RandomAccessFile trabaja a nivel de bytes.
        NO recomendado para ficheros de texto con UTF-8
        (caracteres de tamano variable).
        Recomendado para binarios con registros de TAMAÑO FIJO.
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        String ficheroEnteros = "enteros_raf.dat";

        // ============================================================
        // EJEMPLO 1: ESCRIBIR 10 ENTEROS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 1: ESCRIBIR 10 ENTEROS");
        System.out.println("=========================================");

        try (RandomAccessFile raf = new RandomAccessFile(ficheroEnteros, "rw")) {
            for (int i = 0; i < 10; i++) {
                raf.writeInt(i);
            }
            System.out.println("  Escritos 10 enteros (0-9) en '" + ficheroEnteros + "'");
            System.out.println("  Tamano: " + raf.length() + " bytes (10 * 4 = 40)");
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 2: LEER EL SEXTO ENTERO (indice 5) CON seek()
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 2: LEER 6ø ENTERO (seek(20))");
        System.out.println("=========================================");

        try (RandomAccessFile raf = new RandomAccessFile(ficheroEnteros, "r")) {
            // El sexto entero (indice 5) empieza en byte 5*4 = 20
            int pos = 5 * 4;  // saltar 5 enteros * 4 bytes
            raf.seek(pos);

            int sexto = raf.readInt();
            System.out.println("  seek(" + pos + ") -> readInt() = " + sexto);
            System.out.println("  (sexto entero, valor esperado: 5)");
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 3: LEER VARIOS ENTEROS CON seek()
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 3: LEER ENTEROS POR POSICION");
        System.out.println("=========================================");

        try (RandomAccessFile raf = new RandomAccessFile(ficheroEnteros, "r")) {
            System.out.println("  Posicion -> Valor");
            for (int i = 0; i < 10; i++) {
                raf.seek(i * 4L);  // cada entero empieza en i*4
                int valor = raf.readInt();
                System.out.println("    seek(" + (i * 4) + ") -> " + valor);
            }
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 4: LEER EN POSICION NO ALINEADA (basura)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 4: LECTURA NO ALINEADA (basura)");
        System.out.println("=========================================");

        try (RandomAccessFile raf = new RandomAccessFile(ficheroEnteros, "r")) {
            System.out.println("  Posiciones alineadas (multiplos de 4):");
            for (int i = 0; i <= 36; i += 4) {
                raf.seek(i);
                System.out.print("    " + i + " -> " + raf.readInt());
                if (i == 20) System.out.print("  <-- sexto entero");
                System.out.println();
            }

            System.out.println();
            System.out.println("  Posiciones NO alineadas (basura):");
            raf.seek(1);
            System.out.println("    seek(1)  -> " + raf.readInt() + " (bytes 1-4 mezclados)");
            raf.seek(2);
            System.out.println("    seek(2)  -> " + raf.readInt() + " (bytes 2-5 mezclados)");
            raf.seek(3);
            System.out.println("    seek(3)  -> " + raf.readInt() + " (bytes 3-6 mezclados)");
            raf.seek(19);
            System.out.println("    seek(19) -> " + raf.readInt() + " (bytes 19-22: parte del 4 y parte del 5)");
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 5: TRABAJAR CON EL ARCHIVO DEL VIDEO ANTERIOR
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 5: LEER STRING CON seek()");
        System.out.println("  (archivo ejemplo.dat del video anterior)");
        System.out.println("=========================================");

        // Creamos un archivo con la misma estructura que en el video 8-08
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("ejemplo_raf.dat"))) {
            dos.writeBoolean(true);   // 1 byte
            dos.writeUTF("Pepe");     // 2 (longitud) + 4 chars = 6 bytes
            dos.writeInt(1);          // 4 bytes
            dos.writeDouble(7.8);     // 8 bytes
            System.out.println("  Creado 'ejemplo_raf.dat' (19 bytes)");
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }

        // Leer con RandomAccessFile
        try (RandomAccessFile raf = new RandomAccessFile("ejemplo_raf.dat", "r")) {
            // Leer boolean en posicion 0
            raf.seek(0);
            boolean b = raf.readBoolean();
            System.out.println("  seek(0)  -> readBoolean(): " + b);

            // Leer String en posicion 1 (tras el boolean)
            raf.seek(1);
            String s = raf.readUTF();
            System.out.println("  seek(1)  -> readUTF(): \"" + s + "\"");

            // Leer int en posicion 7 (1 boolean + 2 length + 4 chars = 7)
            raf.seek(7);
            int i = raf.readInt();
            System.out.println("  seek(7)  -> readInt(): " + i);

            // Leer double en posicion 11 (1+6+4 = 11)
            raf.seek(11);
            double d = raf.readDouble();
            System.out.println("  seek(11) -> readDouble(): " + d);

            System.out.println();
            System.out.println("  Estructura del archivo:");
            System.out.println("    Byte 0:       boolean (1 byte)");
            System.out.println("    Bytes 1-2:    longitud String (2 bytes)");
            System.out.println("    Bytes 3-6:    caracteres String (4 bytes)");
            System.out.println("    Bytes 7-10:   int (4 bytes)");
            System.out.println("    Bytes 11-18:  double (8 bytes)");
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 6: MODIFICAR UN ENTERO EN MEDIO DEL ARCHIVO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 6: MODIFICAR UN ENTERO");
        System.out.println("=========================================");

        try (RandomAccessFile raf = new RandomAccessFile(ficheroEnteros, "rw")) {
            // Cambiar el entero en posicion 3 (indice 3, valor 3) por 999
            raf.seek(3 * 4L);
            int antes = raf.readInt();
            System.out.println("  Valor anterior en posicion 3: " + antes);

            // Volver a la misma posicion y escribir (seek otra vez)
            raf.seek(3 * 4L);
            raf.writeInt(999);
            System.out.println("  Escrito 999 en posicion 3");

            // Leer para comprobar
            raf.seek(3 * 4L);
            System.out.println("  Nuevo valor: " + raf.readInt());

            // Restaurar el valor original
            raf.seek(3 * 4L);
            raf.writeInt(3);
            System.out.println("  Restaurado a: " + 3);
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  RESUMEN: RandomAccessFile");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  RandomAccessFile(String nombre, String modo)");
        System.out.println("    modo = \"r\" (lectura) / \"rw\" (lect+escrit)");
        System.out.println();
        System.out.println("  seek(pos): mueve el puntero a la posicion");
        System.out.println("  getFilePointer(): posicion actual del puntero");
        System.out.println("  length(): tamano del archivo en bytes");
        System.out.println();
        System.out.println("  Acceso a enteros: cada int = 4 bytes");
        System.out.println("    seek((n-1)*4) -> readInt() lee el n-esimo entero");
        System.out.println();
        System.out.println("  Acceso a doubles: cada double = 8 bytes");
        System.out.println("    seek((n-1)*8) -> readDouble() lee el n-esimo double");
        System.out.println();
        System.out.println("  IMPORTANTE: leer en posiciones ALINEADAS");
        System.out.println("  (multiplos del tamano del tipo de dato)");
        System.out.println();
        System.out.println("  NO recomendado para texto con UTF-8");
        System.out.println("  (caracteres de tamano variable)");

        System.out.println();
        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V09: RANDOMACCESSFILE)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - RandomAccessFile: acceso DIRECTO a cualquier posicion");
        System.out.println("  - seek(pos): mueve el puntero (pos en bytes desde el inicio)");
        System.out.println("  - Cada tipo ocupa un tamano FIJO: int=4, double=8, long=8");
        System.out.println("  - seek((n-1)*4) para leer el n-esimo entero");
        System.out.println("  - Leer en posicion no alineada -> datos basura");
        System.out.println("  - No usar con texto UTF-8 (tamano variable)");
        System.out.println("  - Proximo video: serializacion de objetos");
    }
}
