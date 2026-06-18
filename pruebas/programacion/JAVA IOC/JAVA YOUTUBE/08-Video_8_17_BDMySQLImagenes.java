import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 * Video 8-17: MySQL en JAVA - Imagenes
 *
 * Tema 8: Almacenar imagenes en base de datos MySQL.
 * Dos enfoques: ruta del archivo (VARCHAR) y binario (BLOB).
 *
 * URL: https://www.youtube.com/watch?v=ZU53wH-BNfA&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=188
 */
class Video_8_17_BDMySQLImagenes {

    public static final String TITULO = "8-17 JAVA: MySQL - Imagenes ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=ZU53wH-BNfA&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=188";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-17 - MYSQL EN JAVA: IMAGENES
        ================================================================

        Almacenar imagenes en una base de datos MySQL desde Java.

        --- DOS ENFOQUES ---
        1. RUTA (VARCHAR): guardar la ruta del archivo de imagen
           - Ocupa poco espacio
           - La imagen debe existir en el sistema de archivos

        2. BINARIO (BLOB): guardar los bytes de la imagen
           - Ocupa mas espacio
           - La imagen viaja con la BD (portable)
           - Se usa setBytes() en PreparedStatement
           - Files.readAllBytes(Paths.get(ruta)) para convertir

        --- TABLA CONTACTO (agenda2) ---
        CREATE TABLE contacto (
            nombre        VARCHAR(100),
            correo        VARCHAR(100) PRIMARY KEY,
            telefono      INT,
            imagen        VARCHAR(200),      -- ruta de la imagen
            binario_imagen MEDIUMBLOB         -- binario de la imagen
        );

        --- INSERT CON BINARIO ---
        byte[] binario = Files.readAllBytes(Paths.get(ruta));
        String sql = "INSERT INTO contacto VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, correo);
        stmt.setInt(3, telefono);
        stmt.setString(4, rutaImagen);
        stmt.setBytes(5, binario);   // para BLOB
        stmt.executeUpdate();
        ================================================================
        """;

    // ================================================================
    // CLASE CONTACTO
    // ================================================================
    static class Contacto {
        private String nombre;
        private String correo;
        private int telefono;
        private String rutaImagen;

        public Contacto(String nombre, String correo, int telefono, String rutaImagen) {
            this.nombre = nombre;
            this.correo = correo;
            this.telefono = telefono;
            this.rutaImagen = rutaImagen;
        }

        public String getNombre() { return nombre; }
        public String getCorreo() { return correo; }
        public int getTelefono() { return telefono; }
        public String getRutaImagen() { return rutaImagen; }

        public void mostrarDatos() {
            String borde = "+" + "-".repeat(50) + "+";
            System.out.println(borde);
            System.out.printf("| %-20s %-27s |%n", "Nombre:", nombre);
            System.out.printf("| %-20s %-27s |%n", "Correo:", correo);
            System.out.printf("| %-20s %-27d |%n", "Telefono:", telefono);
            System.out.printf("| %-20s %-27s |%n", "Imagen:", rutaImagen);
            System.out.println(borde);
        }
    }

    // ================================================================
    // CONEXION
    // ================================================================
    static class ConexionBD {
        private static final String USUARIO = "root";
        private static final String PASSWORD = "";
        private static final String URL = "jdbc:mysql://localhost:3306/";
        public static Connection conectar(String nombreBD) throws SQLException {
            return DriverManager.getConnection(URL + nombreBD, USUARIO, PASSWORD);
        }
    }

    // ================================================================
    // GENERADOR NOMBRES
    // ================================================================
    static class GeneradorNombres {
        private static final String[] NOMBRES = {"Pepe", "Ana", "Juan", "Maria", "Luis", "Elena", "Carlos", "Sofia", "Gonzalo", "Raul", "Blanca", "Pablo", "Laura", "Irene", "Bruno"};
        private static final String[] APELLIDOS = {"Garcia", "Lopez", "Martinez", "Gonzalez", "Rodriguez", "Fernandez", "Gil", "Sierra", "Calvo", "Torres", "Diaz", "Marin"};
        private static final Random RANDOM = new Random();

        public static String generarNombreCompleto() {
            return NOMBRES[RANDOM.nextInt(NOMBRES.length)]
                + " " + APELLIDOS[RANDOM.nextInt(APELLIDOS.length)];
        }

        public static String generarCorreo(String nombre) {
            return nombre.toLowerCase().replace(" ", "_") + "@aulaenlanube.com";
        }
    }

    // ================================================================
    // METODOS
    // ================================================================

    static final String RUTA_IMAGEN_DEFECTO = "aulaenlanube/tema8/imagenes/default.jpg";

    static Contacto generarContactoAleatorio() {
        String nombre = GeneradorNombres.generarNombreCompleto();
        String correo = GeneradorNombres.generarCorreo(nombre);
        int telefono = 600_000_000 + new Random().nextInt(99_999_999);
        return new Contacto(nombre, correo, telefono, RUTA_IMAGEN_DEFECTO);
    }

    static void insertarContactoBD(Connection conn, Contacto contacto) {
        try {
            // Convertir imagen a binario
            byte[] binarioImagen = Files.readAllBytes(Paths.get(contacto.getRutaImagen()));

            String sql = "INSERT INTO contacto VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, contacto.getNombre());
            stmt.setString(2, contacto.getCorreo());
            stmt.setInt(3, contacto.getTelefono());
            stmt.setString(4, contacto.getRutaImagen());
            stmt.setBytes(5, binarioImagen);  // BLOB

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("  Contacto '" + contacto.getNombre() + "' insertado correctamente");
            }
            stmt.close();
        } catch (IOException e) {
            System.out.println("  Error al leer la imagen: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("  Error SQL: " + e.getMessage());
        }
    }

    static void mostrarDatosContactosBD(Connection conn) {
        String sql = "SELECT nombre, correo, telefono, imagen FROM contacto";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("  Contactos en la BD:");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                int telefono = rs.getInt("telefono");
                String imagen = rs.getString("imagen");

                Contacto c = new Contacto(nombre, correo, telefono, imagen);
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

            // ============================================================
            // INSERTAR CONTACTO CON IMAGEN (ruta + binario)
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  INSERTAR CONTACTO CON IMAGEN");
            System.out.println("=========================================");

            Contacto contacto = generarContactoAleatorio();
            insertarContactoBD(conn, contacto);
            System.out.println();

            // ============================================================
            // INSERTAR VARIOS CONTACTOS
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  INSERTAR VARIOS CONTACTOS");
            System.out.println("=========================================");

            for (int i = 0; i < 3; i++) {
                Contacto c = generarContactoAleatorio();
                insertarContactoBD(conn, c);
            }
            System.out.println();

            // ============================================================
            // MOSTRAR DATOS DE LOS CONTACTOS
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  MOSTRAR DATOS DE LOS CONTACTOS");
            System.out.println("=========================================");

            mostrarDatosContactosBD(conn);
            System.out.println();

        } catch (SQLException e) {
            System.out.println("  ERROR SQL: " + e.getMessage());
            System.out.println();
            System.out.println("  Asegurate de haber creado la BD 'agenda2'");
            System.out.println("  con la tabla 'contacto' que incluya:");
            System.out.println("    - nombre VARCHAR(100)");
            System.out.println("    - correo VARCHAR(100) PRIMARY KEY");
            System.out.println("    - telefono INT");
            System.out.println("    - imagen VARCHAR(200)");
            System.out.println("    - binario_imagen MEDIUMBLOB");
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
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V17: MYSQL IMAGENES DESDE JAVA)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Dos formas: ruta (VARCHAR) o binario (BLOB)");
        System.out.println("  - Files.readAllBytes(Paths.get(ruta)) -> byte[]");
        System.out.println("  - setBytes(indice, byte[]) para BLOB");
        System.out.println("  - BLOB tipos: TINYBLOB, BLOB, MEDIUMBLOB, LONGBLOB");
        System.out.println("  - MEDIUMBLOB suficiente para imagenes tipicas");
        System.out.println("  - BD agenda2 con contacto + imagen + binario");
    }
}
