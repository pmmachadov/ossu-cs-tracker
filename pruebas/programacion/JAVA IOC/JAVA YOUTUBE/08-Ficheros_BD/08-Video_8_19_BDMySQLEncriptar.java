import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Video 8-19: MySQL en JAVA - Encriptar datos (BCrypt)
 *
 * Tema 8: Almacenar contraseñas de forma segura en una base de datos
 * usando el algoritmo BCrypt. NUNCA almacenar contraseñas en texto plano.
 *
 * URL: https://www.youtube.com/watch?v=POAbMRr9vkw&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=190
 */
class Video_8_19_BDMySQLEncriptar {

    public static final String TITULO = "8-19 JAVA: MySQL - Encriptar datos ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=POAbMRr9vkw&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=190";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-19 - MYSQL EN JAVA: ENCRIPTAR DATOS
        ================================================================

        Almacenar contraseñas de forma segura usando BCrypt.

        NUNCA almacenar contraseñas en texto plano en la BD.
        Siempre encriptarlas antes de guardarlas.

        --- BCrypt ---
        Algoritmo de encriptacion de un solo sentido (hash).
        Descargar: https://mvnrepository.com/artifact/org.mindrot/jbcrypt
        Archivo: jbcrypt-0.4.jar
        Anadir al classpath como se hace con el conector MySQL.

        --- METODOS ---
        BCrypt.hashpw(password, BCrypt.gensalt())
          -> Genera el hash de la contraseña
          -> gensalt() genera una sal aleatoria

        BCrypt.checkpw(password, passwordEncriptada)
          -> Verifica si la contraseña coincide con el hash
          -> Devuelve boolean

        --- TABLA USUARIO (BD usuarios) ---
        correo VARCHAR(200) PRIMARY KEY
        pwd   VARCHAR(200)   -> almacena el HASH, no la contrasena real

        --- PROCESO DE REGISTRO ---
        1. Recibir correo y contrasena del usuario
        2. Encriptar: BCrypt.hashpw(contrasena, BCrypt.gensalt())
        3. INSERT INTO usuario VALUES (correo, hash)

        --- PROCESO DE LOGIN ---
        1. Recibir correo y contrasena del usuario
        2. SELECT pwd FROM usuario WHERE correo = ?
        3. BCrypt.checkpw(contrasena, hashObtenido)
        4. Si true -> login correcto
        5. Si false -> contrasena incorrecta
        ================================================================
        """;

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
    // INSERTAR USUARIO (con contrasena encriptada)
    // ================================================================
    static void insertarUsuario(Connection conn, String correo, String pwd) {
        // Encriptar la contrasena con BCrypt
        String pwdEncriptada = BCrypt.hashpw(pwd, BCrypt.gensalt());

        String sql = "INSERT INTO usuario VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.setString(2, pwdEncriptada);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("  Usuario con correo '" + correo + "' insertado correctamente");
                System.out.println("  Hash almacenado: " + pwdEncriptada.substring(0, 30) + "...");
            }
        } catch (SQLException e) {
            System.out.println("  Error al insertar usuario: " + e.getMessage());
            if (e.getErrorCode() == 1062) {
                System.out.println("  (El correo '" + correo + "' ya existe en la BD)");
            }
        }
    }

    // ================================================================
    // VERIFICAR CONTRASENA (login)
    // ================================================================
    static boolean verificarPwd(Connection conn, String correo, String pwd) {
        String sql = "SELECT pwd FROM usuario WHERE correo = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Obtener la contrasena encriptada de la BD
                    String pwdEncriptada = rs.getString("pwd");

                    // Verificar si la contrasena proporcionada coincide
                    if (BCrypt.checkpw(pwd, pwdEncriptada)) {
                        System.out.println("  Login correcto para '" + correo + "'");
                        return true;
                    } else {
                        System.out.println("  Contrasena incorrecta para '" + correo + "'");
                        return false;
                    }
                } else {
                    System.out.println("  No existe ningun usuario con correo '" + correo + "'");
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("  Error SQL: " + e.getMessage());
            return false;
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
            conn = ConexionBD.conectar("usuarios");
            System.out.println("  Conectado a BD 'usuarios'");
            System.out.println();

            // ============================================================
            // REGISTRO: insertar usuarios con contrasena encriptada
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  REGISTRO DE USUARIOS");
            System.out.println("=========================================");

            insertarUsuario(conn, "pepe@pepe.com", "pepe123");
            insertarUsuario(conn, "tom@tom.com", "tom456");
            insertarUsuario(conn, "ana@ana.com", "ana789");
            System.out.println();

            // Intentar insertar un correo duplicado
            System.out.println("  Intentando insertar correo duplicado:");
            insertarUsuario(conn, "pepe@pepe.com", "otraPass");
            System.out.println();

            // ============================================================
            // LOGIN: verificar contrasenas
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  LOGIN DE USUARIOS");
            System.out.println("=========================================");

            // Caso 1: Login correcto
            System.out.print("  Tom: ");
            verificarPwd(conn, "tom@tom.com", "tom456");

            // Caso 2: Contrasena incorrecta
            System.out.print("  Tom: ");
            verificarPwd(conn, "tom@tom.com", "wrongPass");

            // Caso 3: Usuario no existe
            System.out.print("  Unknown: ");
            verificarPwd(conn, "noexiste@mail.com", "cualquierPass");
            System.out.println();

            // ============================================================
            // DEMO: MOSTRAR QUE EL HASH ES DIFERENTE CADA VEZ
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  DEMO: BCrypt genera hash distinto");
            System.out.println("  (aunque la contrasena sea la misma)");
            System.out.println("=========================================");

            String password = "MiClave123";
            System.out.println("  Contrasena original: " + password);

            String hash1 = BCrypt.hashpw(password, BCrypt.gensalt());
            String hash2 = BCrypt.hashpw(password, BCrypt.gensalt());

            System.out.println("  Hash 1: " + hash1);
            System.out.println("  Hash 2: " + hash2);
            System.out.println("  Son diferentes: " + !hash1.equals(hash2));
            System.out.println("  checkpw(hash1): " + BCrypt.checkpw(password, hash1));
            System.out.println("  checkpw(hash2): " + BCrypt.checkpw(password, hash2));
            System.out.println();

        } catch (SQLException e) {
            System.out.println("  ERROR SQL: " + e.getMessage());
            System.out.println();
            System.out.println("  Asegurate de haber creado la BD 'usuarios'");
            System.out.println("  con la tabla 'usuario':");
            System.out.println("    - correo VARCHAR(200) PRIMARY KEY");
            System.out.println("    - pwd VARCHAR(200)");
            System.out.println();
            System.out.println("  Y anadir jbcrypt-0.4.jar al classpath");
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
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V19: MYSQL ENCRIPTAR DATOS)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - NUNCA almacenar contrasenas en texto plano");
        System.out.println("  - BCrypt: hash de un solo sentido + sal");
        System.out.println("  - hashpw(password, gensalt()) -> hash");
        System.out.println("  - checkpw(password, hash) -> boolean");
        System.out.println("  - Mismo password genera hash DISTINTO cada vez");
        System.out.println("  - checkpw verifica correctamente aunque el hash sea diferente");
        System.out.println("  - BD usuarios con tabla usuario (correo PK, pwd hash)");
    }
}
