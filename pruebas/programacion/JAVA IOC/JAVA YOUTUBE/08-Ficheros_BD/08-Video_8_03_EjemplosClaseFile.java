import java.io.File;
import java.io.IOException;

/**
 * Video 8-03: Ejemplos clase File
 *
 * Tema 8: Crear, borrar y listar archivos y directorios
 * con la clase File de java.io.
 *
 * URL: https://www.youtube.com/watch?v=0tN_yrTwLPY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=174
 */
class Video_8_03_EjemplosClaseFile {

    public static final String TITULO = "8-03 JAVA: Ejemplos clase File ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=0tN_yrTwLPY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=174";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-03 - EJEMPLOS CLASE FILE
        ================================================================

        Ejemplos practicos con la clase File:
        1. Crear un archivo (createNewFile)
        2. Crear un directorio (mkdir)
        3. Borrar un archivo (delete)
        4. Listar archivos con list() -> String[]
        5. Listar archivos con listFiles() -> File[]
        6. Listar archivos recursivamente en subcarpetas
        7. Listar archivos y carpetas recursivamente

        METODOS USADOS:
        - createNewFile(): crea archivo vacio (IOException!)
        - mkdir(): crea un directorio
        - delete(): borra archivo/directorio vacio
        - exists(): comprueba si existe
        - list(): devuelve String[] con nombres
        - listFiles(): devuelve File[] con objetos File
        - isFile() / isDirectory(): comprueba el tipo
        - getName() / length() / getPath()
        - getAbsolutePath(): ruta absoluta completa
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: CREAR ARCHIVO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 1: CREAR ARCHIVO (createNewFile)");
        System.out.println("=========================================");

        File archivo = new File("nuevo_archivo.txt");
        try {
            if (archivo.createNewFile()) {
                System.out.println("  Archivo creado: " + archivo.getName());
            } else {
                System.out.println("  El archivo YA EXISTE: " + archivo.getName());
            }
        } catch (IOException e) {
            System.out.println("  ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 2: CREAR DIRECTORIO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 2: CREAR DIRECTORIO (mkdir)");
        System.out.println("=========================================");

        File directorio = new File("nuevo_directorio");
        if (directorio.mkdir()) {
            System.out.println("  Directorio creado: " + directorio.getName());
        } else {
            System.out.println("  No se pudo crear el directorio (ya existe?)");
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 3: BORRAR ARCHIVO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 3: BORRAR ARCHIVO (delete)");
        System.out.println("=========================================");

        File archivoBorrar = new File("archivo_para_eliminar.txt");
        if (archivoBorrar.delete()) {
            System.out.println("  Archivo eliminado: " + archivoBorrar.getName());
        } else {
            System.out.println("  No se pudo eliminar el archivo (no existe?)");
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 4: LISTAR ARCHIVOS CON list() -> String[]
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 4: LISTAR ARCHIVOS (list)");
        System.out.println("=========================================");

        File dirActual = new File(".");
        String[] archivos = dirActual.list();
        if (archivos != null && archivos.length > 0) {
            System.out.println("  Contenido de la carpeta actual:");
            for (String a : archivos) {
                System.out.println("    " + a);
            }
        } else {
            System.out.println("  No hay archivos en la carpeta");
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 5: LISTAR ARCHIVOS CON listFiles() -> File[]
        // Mostrando nombre y tamaño
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 5: LISTAR ARCHIVOS (listFiles)");
        System.out.println("=========================================");

        listarArchivosConTamano(".");
        System.out.println();

        // ============================================================
        // EJEMPLO 6: LISTAR RECURSIVAMENTE (solo archivos)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 6: LISTAR RECURSIVAMENTE");
        System.out.println("  (solo archivos, incluye subcarpetas)");
        System.out.println("=========================================");

        listarArchivosRecursivo(new File("."));
        System.out.println();

        // ============================================================
        // EJEMPLO 7: LISTAR RECURSIVAMENTE (archivos y carpetas)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 7: LISTAR RECURSIVAMENTE");
        System.out.println("  (archivos Y carpetas)");
        System.out.println("=========================================");

        listarArchivosYCarpetas(new File("."), "");
        System.out.println();

        // ============================================================
        // DEMO: CREAR + BORRAR
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  DEMO: CREAR + BORRAR ARCHIVO");
        System.out.println("=========================================");

        File demo = new File("demo_borrar.txt");
        try {
            if (demo.createNewFile()) {
                System.out.println("  1. Creado: " + demo.getName());
            }
            if (demo.delete()) {
                System.out.println("  2. Borrado: " + demo.getName());
            }
            // Comprobar que ya no existe
            System.out.println("  3. ¿Existe? " + demo.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        // ============================================================
        // DEMO: mkdirs (crear arbol de directorios)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  DEMO: mkdirs (arbol de directorios)");
        System.out.println("=========================================");

        File arbol = new File("padre/hijo/nieto");
        if (arbol.mkdirs()) {
            System.out.println("  Arbol creado: " + arbol.getAbsolutePath());
        } else {
            System.out.println("  El arbol ya existe");
        }
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V03: EJEMPLOS CLASE FILE)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - createNewFile() requiere try-catch (IOException)");
        System.out.println("  - delete() borra archivos, pero carpetas SOLO si estan vacias");
        System.out.println("  - list() devuelve String[] de nombres");
        System.out.println("  - listFiles() devuelve File[] con toda la informacion");
        System.out.println("  - Para listar todo el arbol -> recursividad");
        System.out.println("  - Proximo video: modificar contenido de archivos de texto");
    }

    // ================================================================
    // MÉTODO: Listar archivos con nombre y tamaño
    // ================================================================
    static void listarArchivosConTamano(String ruta) {
        File carpeta = new File(ruta);
        if (!carpeta.isDirectory()) {
            System.out.println("  La ruta '" + ruta + "' no es una carpeta");
            return;
        }
        File[] archivos = carpeta.listFiles();
        if (archivos == null || archivos.length == 0) {
            System.out.println("  No hay archivos en '" + ruta + "'");
            return;
        }
        System.out.println("  Archivos en '" + ruta + "':");
        for (File f : archivos) {
            if (f.isFile()) {  // solo archivos, no carpetas
                System.out.println("    " + f.getName() + " - " + f.length() + " bytes");
            }
        }
    }

    // ================================================================
    // MÉTODO: Listar archivos recursivamente (solo archivos)
    // ================================================================
    static void listarArchivosRecursivo(File carpeta) {
        if (!carpeta.isDirectory()) return;

        File[] archivos = carpeta.listFiles();
        if (archivos == null) return;

        for (File f : archivos) {
            if (f.isFile()) {
                // getPath() muestra ruta relativa desde la ubicacion actual
                System.out.println("    " + f.getPath());
            } else if (f.isDirectory()) {
                listarArchivosRecursivo(f);  // llamada recursiva
            }
        }
    }

    // ================================================================
    // MÉTODO: Listar archivos Y carpetas recursivamente
    // ================================================================
    static void listarArchivosYCarpetas(File carpeta, String prefijo) {
        if (!carpeta.isDirectory()) return;

        File[] archivos = carpeta.listFiles();
        if (archivos == null) return;

        for (File f : archivos) {
            // Mostrar archivo o carpeta
            System.out.println("    " + prefijo + f.getName());

            if (f.isDirectory()) {
                // Listar recursivamente con sangria
                listarArchivosYCarpetas(f, prefijo + "  ");
            }
        }
    }
}
