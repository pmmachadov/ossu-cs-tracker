import java.io.*;
import java.util.Scanner;

/**
 * Video 8-07: Ejercicios resueltos ficheros
 *
 * Tema 8: 5 ejercicios de repaso sobre ficheros de texto
 * y la clase File.
 *
 * URL: https://www.youtube.com/watch?v=JUQcm0pxbHc&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=178
 */
class Video_8_07_EjerciciosFicheros {

    public static final String TITULO = "8-07 JAVA: Ejercicios resueltos ficheros ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=JUQcm0pxbHc&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=178";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-07 - EJERCICIOS RESUELTOS FICHEROS
        ================================================================

        5 ejercicios de repaso sobre ficheros de texto y clase File.

        EJERCICIO 1: listarPorExtension(ruta, extension)
          Lista los archivos de una carpeta filtrados por extension.
          Usa listFiles() con lambda como filtro (programacion funcional).

        EJERCICIO 2: crearArchivos(ruta, n)
          Crea n archivos "nombre1.txt" a "nombreN.txt" en la carpeta.
          Cada archivo contiene "Este es el fichero nombreX.txt".
          Usa BufferedWriter para escritura eficiente.

        EJERCICIO 3: cantidadPalabras(archivo, palabra)
          Cuenta cuantas veces aparece una palabra en un archivo.
          Usa BufferedReader + Scanner + split() + foreach.

        EJERCICIO 4: eliminarPalabras(archivo, palabra)
          Crea un nuevo archivo (original-2.txt) eliminando todas
          las ocurrencias de la palabra. Usa replaceAll() con
          \\\\b para limites de palabra completa.

        EJERCICIO 5: encriptar/desencriptar (Cifrado Cesar)
          Desplaza cada caracter del archivo segun un desplazamiento.
          Un metodo procesarArchivo() controla si encripta o
          desencripta mediante un booleano.
        ================================================================
        """;

    private static final int DESPLAZAMIENTO = 3;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        System.out.println("=========================================");
        System.out.println("  EJERCICIO 1: listarPorExtension()");
        System.out.println("=========================================");
        listarPorExtension(".", "txt");
        System.out.println();

        System.out.println("=========================================");
        System.out.println("  EJERCICIO 2: crearArchivos()");
        System.out.println("=========================================");
        crearArchivos(".", 5);
        System.out.println();

        System.out.println("=========================================");
        System.out.println("  EJERCICIO 3: cantidadPalabras()");
        System.out.println("=========================================");
        cantidadPalabras("archivo.txt", "programacion");
        System.out.println();

        System.out.println("=========================================");
        System.out.println("  EJERCICIO 4: eliminarPalabras()");
        System.out.println("=========================================");
        eliminarPalabras("archivo.txt", "SD");
        System.out.println();

        System.out.println("=========================================");
        System.out.println("  EJERCICIO 5: encriptar/desencriptar");
        System.out.println("=========================================");
        encriptar("fichero.txt", "fichero_encriptado.txt");
        desencriptar("fichero_encriptado.txt", "fichero_desencriptado.txt");
        System.out.println();
    }

    // ================================================================
    // EJERCICIO 1: Listar archivos por extension
    // ================================================================
    static void listarPorExtension(String ruta) {
        listarPorExtension(ruta, "txt");
    }

    static void listarPorExtension(String ruta, String extension) {
        File carpeta = new File(ruta);
        if (!carpeta.isDirectory()) {
            System.out.println("  La ruta '" + ruta + "' no es una carpeta valida");
            return;
        }

        // listFiles() con lambda como filtro (programacion funcional)
        File[] archivos = carpeta.listFiles(f ->
                f.isFile() && f.getName().toLowerCase().endsWith("." + extension.toLowerCase()));

        if (archivos == null || archivos.length == 0) {
            System.out.println("  No se encontraron archivos con extension '" + extension + "'");
            return;
        }

        System.out.println("  Archivos ." + extension + " en '" + ruta + "':");
        for (File f : archivos) {
            System.out.println("    " + f.getName());
        }
    }

    // ================================================================
    // EJERCICIO 2: Crear N archivos con contenido
    // ================================================================
    static void crearArchivos(String ruta, int n) {
        // Validar que la ruta sea un directorio
        if (!new File(ruta).isDirectory()) {
            System.out.println("  La ruta '" + ruta + "' no es valida");
            return;
        }

        for (int i = 1; i <= n; i++) {
            String nombreFichero = ruta + File.separator + "nombre" + i + ".txt";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero))) {
                bw.write("Este es el fichero nombre" + i + ".txt");
                System.out.println("  Creado: " + nombreFichero);
            } catch (IOException e) {
                System.out.println("  Error al crear " + nombreFichero + ": " + e.getMessage());
            }
        }
        System.out.println("  Creados " + n + " archivos");
    }

    // ================================================================
    // EJERCICIO 3: Contar ocurrencias de una palabra
    // ================================================================
    static void cantidadPalabras(String archivo, String palabra) {
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo));
             Scanner sc = new Scanner(br)) {

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                // Dividir la linea en palabras y comparar cada una
                String[] palabras = linea.split("\\s+");
                for (String palabraActual : palabras) {
                    if (palabraActual.equals(palabra)) {
                        contador++;
                    }
                }
            }
            System.out.println("  La palabra '" + palabra + "' aparece " + contador
                    + " veces en '" + archivo + "'");
        } catch (FileNotFoundException e) {
            System.out.println("  Archivo no encontrado: " + archivo);
        } catch (IOException e) {
            System.out.println("  Error al leer el archivo: " + archivo);
        }
    }

    // ================================================================
    // EJERCICIO 4: Eliminar ocurrencias de una palabra
    // ================================================================
    static void eliminarPalabras(String nombreArchivo, String palabra) {
        File archivoEntrada = new File(nombreArchivo);

        if (!archivoEntrada.exists() || !archivoEntrada.isFile()) {
            System.out.println("  El archivo '" + nombreArchivo + "' no existe o no es valido");
            return;
        }

        // Nombre del archivo de salida: reemplazar .txt por -2.txt
        String nombreSalida = nombreArchivo.replace(".txt", "-2.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(nombreSalida));
             Scanner sc = new Scanner(br)) {

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                // \\\\b = limite de palabra completa (word boundary)
                // Elimina solo palabras exactas, no subcadenas
                String lineaLimpia = linea.replaceAll("\\b" + palabra + "\\b", "");
                bw.write(lineaLimpia);
                bw.newLine();
            }

            System.out.println("  Creado '" + nombreSalida + "' sin la palabra '" + palabra + "'");
        } catch (IOException e) {
            System.out.println("  Error al procesar el archivo: " + e.getMessage());
        }
    }

    // ================================================================
    // EJERCICIO 5: Encriptar/Desencriptar (Cifrado Cesar)
    // ================================================================
    static void encriptar(String entrada, String salida) {
        procesarArchivo(entrada, salida, true);
    }

    static void desencriptar(String entrada, String salida) {
        procesarArchivo(entrada, salida, false);
    }

    static void procesarArchivo(String rutaEntrada, String rutaSalida, boolean encriptar) {
        File archivo = new File(rutaEntrada);

        if (!archivo.exists() || !archivo.isFile()) {
            System.out.println("  El fichero '" + rutaEntrada + "' no existe o no es valido");
            return;
        }

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaSalida))) {

            int datos;
            while ((datos = lector.read()) != -1) {
                char c = (char) datos;
                // Si encriptar=true -> sumar desplazamiento
                // Si encriptar=false -> restar desplazamiento
                if (encriptar) {
                    c += DESPLAZAMIENTO;
                } else {
                    c -= DESPLAZAMIENTO;
                }
                escritor.write(c);
            }

            System.out.println("  " + (encriptar ? "Encriptado" : "Desencriptado")
                    + ": '" + rutaEntrada + "' -> '" + rutaSalida + "'");
        } catch (FileNotFoundException e) {
            System.out.println("  Error: archivo '" + rutaEntrada + "' no encontrado");
        } catch (IOException e) {
            System.out.println("  Error al procesar el archivo: " + e.getMessage());
        }
    }
}
