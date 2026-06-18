import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Video 8-02: La clase File (java.io.File)
 *
 * Tema 8: Almacenamiento y acceso a datos en Java
 * La clase File permite manipular archivos y directorios
 * en el sistema de archivos del SO.
 *
 * URL: https://www.youtube.com/watch?v=2GjrBo2SRP8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=173
 */
class Video_8_02_LaClaseFile {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "8-02 JAVA: La clase File ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=2GjrBo2SRP8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=173";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-02 - LA CLASE FILE
        ================================================================

        La clase File (java.io.File) sirve para manipular archivos
        y directorios en el sistema de archivos.

        NO se usa para leer/escribir datos, sino para ACCEDER a la
        informacion del archivo: ruta, tamaño, atributos, permisos...
        Las clases de lectura/escritura reciben una instancia de File.

        --- CONSTRUCTORES PRINCIPALES ---
        File(String ruta)
          - ruta puede ser archivo o carpeta
          - Si no se especifica ruta absoluta, es relativa al directorio
            donde se ejecuta el programa
          Ej: new File("archivo.txt")
              new File("C:/Users/usuario/documento.txt")

        File(String parent, String child)
          - parent: ruta del directorio padre
          - child: nombre del archivo o carpeta hija
          Ej: new File("C:/carpeta", "archivo.txt")

        --- PRINCIPALES MÉTODOS ---
        boolean createNewFile()
          - Crea un archivo vacio
          - Devuelve true si se creó, false si ya existia
          - Lanza IOException (permisos, etc.)
          - OBLIGA a try-catch o propagar la excepcion

        boolean delete()
          - Borra el archivo o directorio
          - Si es un directorio, debe estar VACIO
          - Devuelve true si se borró, false si no

        boolean exists()
          - Indica si el archivo o directorio existe

        String getName()
          - Devuelve el nombre del fichero (sin ruta)

        String getPath()
          - Devuelve la ruta (la que se usó en el constructor)

        String getAbsolutePath()
          - Devuelve la ruta ABSOLUTA completa

        long length()
          - Devuelve el tamaño en bytes (0 si no existe)

        boolean isFile()
          - Devuelve true si es un archivo

        boolean isDirectory()
          - Devuelve true si es un directorio

        File[] listFiles()
          - Devuelve array con los archivos/carpetas de un directorio

        boolean mkdir()
          - Crea un directorio

        boolean mkdirs()
          - Crea un arbol de directorios (todos los padres necesarios)

        --- RUTAS RELATIVAS ---
        "."  = directorio actual
        ".." = directorio padre
        "../../" = subir dos niveles

        --- RUTAS ABSOLUTAS (Windows) ---
        "C:/"  = raiz de la unidad C
        "C:/Users/usuario/" = ruta absoluta completa
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: Acceder a un archivo (existe o no)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 1: ACCEDER A UN FICHERO");
        System.out.println("=========================================");

        // Crear una instancia de File con ruta relativa
        File fichero = new File("ejemplo1.txt");  // en la misma carpeta del proyecto
        System.out.println("  Fichero: " + fichero.getName());
        System.out.println("  Ruta: " + fichero.getPath());
        System.out.println("  Ruta absoluta: " + fichero.getAbsolutePath());

        if (fichero.exists()) {
            System.out.println("  Estado: EL FICHERO EXISTE");
            System.out.println("  Tamaño (bytes): " + fichero.length());
        } else {
            System.out.println("  Estado: EL FICHERO NO EXISTE");
            System.out.println("  Tamaño (bytes): " + fichero.length() + " (no existe)");
        }

        System.out.println("  ¿Es archivo? " + fichero.isFile());
        System.out.println("  ¿Es directorio? " + fichero.isDirectory());
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Acceder a un directorio
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 2: ACCEDER A UN DIRECTORIO");
        System.out.println("=========================================");

        File carpeta = new File("C:/Users");  // ruta absoluta en Windows
        System.out.println("  Carpeta: " + carpeta.getName());
        System.out.println("  Ruta absoluta: " + carpeta.getAbsolutePath());

        if (carpeta.exists()) {
            System.out.println("  Estado: LA CARPETA EXISTE");
            System.out.println("  Tamaño: " + carpeta.length() + " bytes");
        } else {
            System.out.println("  Estado: LA CARPETA NO EXISTE");
        }

        System.out.println("  ¿Es archivo? " + carpeta.isFile());
        System.out.println("  ¿Es directorio? " + carpeta.isDirectory());
        System.out.println();

        // ============================================================
        // EJEMPLO 3: CREAR ARCHIVO (createNewFile)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 3: CREAR UN ARCHIVO");
        System.out.println("=========================================");

        File nuevo = new File("nuevo_archivo.txt");
        try {
            boolean creado = nuevo.createNewFile();  // requiere try-catch
            if (creado) {
                System.out.println("  Archivo creado: " + nuevo.getAbsolutePath());
            } else {
                System.out.println("  El archivo YA EXISTIA: " + nuevo.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("  ERROR al crear archivo: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 4: CREAR DIRECTORIO (mkdir / mkdirs)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 4: CREAR DIRECTORIOS");
        System.out.println("=========================================");

        File directorio = new File("mi_directorio");
        if (directorio.mkdir()) {
            System.out.println("  Directorio creado: " + directorio.getName());
        } else {
            System.out.println("  El directorio ya existe o no se pudo crear");
        }

        // mkdirs crea todos los padres necesarios
        File arbol = new File("padre/hijo/nieto");
        if (arbol.mkdirs()) {
            System.out.println("  Arbol de directorios creado: " + arbol.getPath());
        } else {
            System.out.println("  El arbol ya existe o no se pudo crear");
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 5: LISTAR ARCHIVOS DE UN DIRECTORIO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 5: LISTAR ARCHIVOS");
        System.out.println("=========================================");

        File directorioActual = new File(".");
        System.out.println("  Contenido del directorio actual:");
        System.out.println("    " + directorioActual.getAbsolutePath());
        System.out.println();

        File[] archivos = directorioActual.listFiles();
        if (archivos != null) {
            for (File f : archivos) {
                String tipo = f.isDirectory() ? "[DIR]" : "[FILE]";
                System.out.printf("    %s %-30s %d bytes%n", tipo, f.getName(), f.length());
            }
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 6: RUTAS RELATIVAS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 6: RUTAS RELATIVAS");
        System.out.println("=========================================");

        // Directorio actual
        File actual = new File(".");
        System.out.println("  '.' -> " + actual.getAbsolutePath());

        // Directorio padre
        File padre = new File("..");
        System.out.println("  '..' -> " + padre.getAbsolutePath());

        // Subir dos niveles y entrar a una carpeta
        File subirBajar = new File("../../imgs");
        System.out.println("  '../../imgs' -> " + subirBajar.getAbsolutePath());

        // Archivo en subdirectorio
        File archivoSub = new File("imgs/img_default.jpg");
        System.out.println("  'imgs/img_default.jpg' -> " + archivoSub.getAbsolutePath());

        System.out.println();

        // ============================================================
        // EJEMPLO 7: USAR CONSTRUCTOR CON DOS PARAMETROS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 7: CONSTRUCTOR File(parent, child)");
        System.out.println("=========================================");

        File directorioRaiz = new File(".");
        File archivoEnRaiz = new File(directorioRaiz, "archivo_en_raiz.txt");
        System.out.println("  File(\\\".\\\", \\\"archivo_en_raiz.txt\\\"):");
        System.out.println("    " + archivoEnRaiz.getAbsolutePath());
        System.out.println();

        // ============================================================
        // EJEMPLO 8: BORRAR ARCHIVO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 8: BORRAR ARCHIVO");
        System.out.println("=========================================");

        if (nuevo.exists()) {
            boolean borrado = nuevo.delete();
            System.out.println("  ¿Archivo '" + nuevo.getName() + "' borrado? " + borrado);
        } else {
            System.out.println("  El archivo '" + nuevo.getName() + "' ya no existe");
        }
        System.out.println();

        // ============================================================
        // RESUMEN DE LA CLASE FILE
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  METODOS DE LA CLASE FILE");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  CONSTRUCTORES:");
        System.out.println("    File(String ruta)");
        System.out.println("    File(String parent, String child)");
        System.out.println();
        System.out.println("  METODOS PRINCIPALES:");
        System.out.printf("    %-25s %s%n", "createNewFile()", "crea archivo vacio (IOException)");
        System.out.printf("    %-25s %s%n", "delete()", "borra archivo/directorio (debe estar vacio)");
        System.out.printf("    %-25s %s%n", "exists()", "comprueba si existe");
        System.out.printf("    %-25s %s%n", "getName()", "nombre del fichero");
        System.out.printf("    %-25s %s%n", "getPath()", "ruta del constructor");
        System.out.printf("    %-25s %s%n", "getAbsolutePath()", "ruta absoluta completa");
        System.out.printf("    %-25s %s%n", "length()", "tamano en bytes");
        System.out.printf("    %-25s %s%n", "isFile()", "true si es archivo");
        System.out.printf("    %-25s %s%n", "isDirectory()", "true si es directorio");
        System.out.printf("    %-25s %s%n", "listFiles()", "File[] con el contenido del directorio");
        System.out.printf("    %-25s %s%n", "mkdir()", "crea un directorio");
        System.out.printf("    %-25s %s%n", "mkdirs()", "crea arbol de directorios");
        System.out.println();

        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V02: LA CLASE FILE)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - File representa archivos y directorios, NO lee/escribe datos");
        System.out.println("  - createNewFile() lanza IOException (try-catch obligatorio)");
        System.out.println("  - delete() solo borra directorios VACIOS");
        System.out.println("  - mkdir() crea 1 directorio, mkdirs() crea arbol completo");
        System.out.println("  - '.' = carpeta actual, '..' = carpeta padre");
        System.out.println("  - Proximo video: crear/borrar archivos y listar directorios");
    }
}
