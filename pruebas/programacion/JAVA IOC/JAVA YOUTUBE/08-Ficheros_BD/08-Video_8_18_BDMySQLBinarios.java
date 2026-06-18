import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Random;

/**
 * Video 8-18: MySQL en JAVA - Binarios
 *
 * Tema 8: Descargar imagenes/binarios desde la BD al sistema
 * de archivos. Cargar archivos desde carpetas para crear
 * contactos en la BD. Almacenar cualquier tipo de archivo
 * como BLOB en MySQL.
 *
 * URL: https://www.youtube.com/watch?v=wZ1PsCQAlsI&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=189
 */
class Video_8_18_BDMySQLBinarios {

    public static final String TITULO = "8-18 JAVA: MySQL - Binarios ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=wZ1PsCQAlsI&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=189";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-18 - MYSQL EN JAVA: BINARIOS
        ================================================================

        Gestion de archivos binarios (imagenes, PDFs, TXT...) en BD.

        --- DESCARGAR BINARIOS DE LA BD ---
        1. SELECT imagen, binario_imagen FROM contacto
        2. Blob blob = rs.getBlob("binario_imagen")
        3. byte[] bytes = blob.getBytes(1, (int) blob.length())
        4. FileOutputStream fos = new FileOutputStream(ruta)
        5. fos.write(bytes)
        6. fos.close()

        --- CARGAR ARCHIVOS DE UNA CARPETA A LA BD ---
        1. File carpeta = new File(ruta)
        2. File[] archivos = carpeta.listFiles()
        3. Por cada archivo .jpg (o cualquier extension):
           - Generar contacto aleatorio
           - Cambiar su ruta de imagen por la del archivo
           - insertarContactoBD(conn, contacto)

        --- METODO AUXILIAR esJPG(File) ---
        Comprueba si un archivo tiene extension .jpg
        (se puede adaptar a cualquier extension)

        --- ALMACENAR CUALQUIER TIPO DE ARCHIVO ---
        Cualquier archivo (PDF, TXT, JPG, PNG...) se puede
        guardar como BLOB en la BD y luego descargarlo.
        La extension se guarda en el campo "imagen" (ruta).
        ================================================================
        """;

    // ================================================================
    // CLASES AUXILIARES
    // ================================================================

    static class ConexionBD {
        private static final String USUARIO = "root";
        private static final String PASSWORD = "";
        private static final String URL = "jdbc:mysql://localhost:3306/";
        public static Connection conectar(String nombreBD) throws SQLException {
            return DriverManager.getConnection(URL + nombreBD, USUARIO, PASSWORD);
        }
    }

    static class Contacto {
        private String nombre, correo, rutaImagen;
        private int telefono;

        public Contacto(String nombre, String correo, int telefono, String rutaImagen) {
            this.nombre = nombre; this.correo = correo;
            this.telefono = telefono; this.rutaImagen = rutaImagen;
        }
        public String getNombre() { return nombre; }
        public String getCorreo() { return correo; }
        public int getTelefono() { return telefono; }
        public String getRutaImagen() { return rutaImagen; }
        public void setRutaImagen(String ruta) { this.rutaImagen = ruta; }

        public void mostrarDatos() {
            String borde = "+" + "-".repeat(50) + "+";
            System.out.println(borde);
            System.out.printf("| %-20s %-27s |%n", "Nombre:", nombre);
            System.out.printf("| %-20s %-27s |%n", "Correo:", correo);
            System.out.printf("| %-20s %-27d |%n", "Telefono:", telefono);
            System.out.printf("| %-20s %-27s |%n", "Archivo:", rutaImagen);
            System.out.println(borde);
        }
    }

    static class GeneradorNombres {
        private static final String[] NOMBRES = {"Pepe","Ana","Juan","Maria","Luis","Elena","Carlos","Sofia","Gonzalo","Raul","Blanca","Pablo","Laura","Irene","Bruno","Diego","Miguel","Mark","Maria"};
        private static final String[] APELLIDOS = {"Garcia","Lopez","Martinez","Gonzalez","Rodriguez","Fernandez","Gil","Sierra","Calvo","Torres","Diaz","Marin","Rovira","Blanco","Luna","Montero"};
        private static final Random RANDOM = new Random();
        public static String generarNombreCompleto() {
            return NOMBRES[RANDOM.nextInt(NOMBRES.length)]
                + " " + APELLIDOS[RANDOM.nextInt(APELLIDOS.length)];
        }
        public static String generarCorreo(String nombre) {
            return nombre.toLowerCase().replace(" ", "_") + "@aulaenlanube.com";
        }
    }

    static final String RUTA_IMAGEN_DEFECTO = "aulaenlanube/tema8/imagenes/default.jpg";

    static Contacto generarContactoAleatorio() {
        String nombre = GeneradorNombres.generarNombreCompleto();
        String correo = GeneradorNombres.generarCorreo(nombre);
        int telefono = 600_000_000 + new Random().nextInt(99_999_999);
        return new Contacto(nombre, correo, telefono, RUTA_IMAGEN_DEFECTO);
    }

    // ================================================================
    // INSERTAR CONTACTO EN BD
    // ================================================================
    static void insertarContactoBD(Connection conn, Contacto contacto) {
        try {
            byte[] binario = Files.readAllBytes(Paths.get(contacto.getRutaImagen()));
            String sql = "INSERT INTO contacto VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, contacto.getNombre());
            stmt.setString(2, contacto.getCorreo());
            stmt.setInt(3, contacto.getTelefono());
            stmt.setString(4, contacto.getRutaImagen());
            stmt.setBytes(5, binario);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("  Contacto '" + contacto.getNombre() + "' insertado correctamente");
            }
            stmt.close();
        } catch (IOException e) {
            System.out.println("  Error al leer archivo: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("  Error SQL: " + e.getMessage() + " (correo duplicado?)");
        }
    }

    // ================================================================
    // DESCARGAR BINARIOS DESDE LA BD AL SISTEMA DE ARCHIVOS
    // ================================================================
    static void descargarImagenesContactosBD(Connection conn) {
        String sql = "SELECT imagen, binario_imagen FROM contacto";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            int descargados = 0;
            while (rs.next()) {
                // Obtener el BLOB de la BD
                Blob blob = rs.getBlob("binario_imagen");
                if (blob == null) continue;

                // Convertir BLOB a byte[]
                byte[] bytes = blob.getBytes(1, (int) blob.length());

                // Obtener la ruta donde guardar el archivo
                String ruta = rs.getString("imagen");

                // Crear directorios padres si no existen
                File archivo = new File(ruta);
                archivo.getParentFile().mkdirs();

                // Escribir el binario al sistema de archivos
                try (FileOutputStream fos = new FileOutputStream(archivo)) {
                    fos.write(bytes);
                    descargados++;
                }
            }
            System.out.println("  Descargados " + descargados + " archivos de la BD");
        } catch (SQLException | IOException e) {
            System.out.println("  Error al descargar: " + e.getMessage());
        }
    }

    // ================================================================
    // CARGAR ARCHIVOS DESDE UNA CARPETA A LA BD
    // ================================================================
    static void cargarImagenesContactosBD(Connection conn, String rutaCarpeta) {
        File carpeta = new File(rutaCarpeta);

        if (!carpeta.isDirectory()) {
            System.out.println("  La ruta '" + rutaCarpeta + "' no es una carpeta valida");
            return;
        }

        File[] archivos = carpeta.listFiles();
        if (archivos == null || archivos.length == 0) {
            System.out.println("  No hay archivos en la carpeta");
            return;
        }

        int cargados = 0;
        for (File archivo : archivos) {
            // Solo archivos (no subcarpetas) y con extension .jpg
            if (archivo.isFile() && esJPG(archivo)) {
                Contacto contacto = generarContactoAleatorio();
                contacto.setRutaImagen(archivo.getPath());
                insertarContactoBD(conn, contacto);
                cargados++;
            }
        }
        System.out.println("  Cargados " + cargados + " contactos desde la carpeta");
    }

    // ================================================================
    // METODO AUXILIAR: comprobar extension .jpg
    // ================================================================
    static boolean esJPG(File archivo) {
        String nombre = archivo.getName();
        // Si el nombre tiene menos de 4 chars, no puede tener .jpg
        if (nombre.length() < 4) return false;
        // Obtener los ultimos 4 caracteres y comparar con ".jpg"
        String extension = nombre.substring(nombre.length() - 4);
        return extension.equalsIgnoreCase(".jpg");
    }

    // ================================================================
    // MOSTRAR DATOS DE LOS CONTACTOS
    // ================================================================
    static void mostrarDatosContactosBD(Connection conn) {
        String sql = "SELECT nombre, correo, telefono, imagen FROM contacto";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("  Contactos en la BD:");
            while (rs.next()) {
                Contacto c = new Contacto(
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getInt("telefono"),
                    rs.getString("imagen"));
                c.mostrarDatos();
            }
        } catch (SQLException e) {
            System.out.println("  Error SQL: " + e.getMessage());
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        Connection conn = null;
        try {
            conn = ConexionBD.conectar("agenda2");
            System.out.println("  Conectado a BD 'agenda2'");
            System.out.println();

            // 1. DESCARGAR binarios de la BD al sistema de archivos
            System.out.println("=========================================");
            System.out.println("  1. DESCARGAR ARCHIVOS DE LA BD");
            System.out.println("=========================================");
            descargarImagenesContactosBD(conn);
            System.out.println();

            // 2. CARGAR archivos desde una carpeta a la BD
            System.out.println("=========================================");
            System.out.println("  2. CARGAR ARCHIVOS A LA BD");
            System.out.println("=========================================");
            cargarImagenesContactosBD(conn,
                "aulaenlanube/tema8/imagenes/imgs");
            System.out.println();

            // 3. MOSTRAR contactos
            System.out.println("=========================================");
            System.out.println("  3. MOSTRAR CONTACTOS");
            System.out.println("=========================================");
            mostrarDatosContactosBD(conn);
            System.out.println();

        } catch (SQLException e) {
            System.out.println("  ERROR SQL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("  Conexion cerrada");
                } catch (SQLException e) {
                    System.out.println("  Error al cerrar: " + e.getMessage());
                }
            }
        }

        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V18: MYSQL BINARIOS DESDE JAVA)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - BLOB.getBytes(1, length) -> byte[]");
        System.out.println("  - FileOutputStream.write(bytes) -> guardar en disco");
        System.out.println("  - listFiles() -> recorrer archivos de una carpeta");
        System.out.println("  - Cualquier archivo se puede guardar como BLOB");
        System.out.println("  - La extension del archivo se conserva en la ruta");
        System.out.println("  - Se pueden recuperar archivos borrados desde la BD");
        System.out.println("  - FIN DEL CURSO (TEMA 8 COMPLETO)");
    }
}
