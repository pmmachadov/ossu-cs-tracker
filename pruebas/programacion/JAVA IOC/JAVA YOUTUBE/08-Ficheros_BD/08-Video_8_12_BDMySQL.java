import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Video 8-12: Bases de datos en JAVA - MySQL (Introduccion)
 *
 * Tema 8: Introduccion a bases de datos relacionales y MySQL.
 * Conexion desde Java a una base de datos MySQL/MariaDB
 * usando JDBC (Java Database Connectivity).
 *
 * URL: https://www.youtube.com/watch?v=9xybdEJmLWc&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=183
 */
class Video_8_12_BDMySQL {

    public static final String TITULO = "8-12 JAVA: Bases de datos - MySQL ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=9xybdEJmLWc&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=183";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // Configuracion de la base de datos
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static final String URL_BD = "jdbc:mysql://localhost:3306/agenda";
    // Formato: jdbc:mysql://IP:PUERTO/NOMBRE_BD
    // Por defecto: localhost:3306

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-12 - BASES DE DATOS EN JAVA: MYSQL
        ================================================================

        --- CONCEPTOS GENERALES ---
        Base de datos: conjunto estructurado de datos interrelacionados
        almacenados digitalmente.

        Componentes principales:
          - TABLAS: estructura principal con columnas (campos) y filas
          - CONSULTAS: para obtener/modificar/borrar informacion
          - MACROS: conjunto de instrucciones automaticas

        --- SGBD (Sistema Gestor de Base de Datos) ---
        Herramienta que conecta los datos con los programas.
        Ej: MySQL, MariaDB, PostgreSQL, Oracle, SQLite.

        --- LENGUAJE SQL ---
        DDL (Data Definition Language): CREATE, ALTER, DROP
        DML (Data Manipulation Language): SELECT, INSERT, UPDATE, DELETE
        DCL (Data Control Language): GRANT, REVOKE
        TCL (Transaction Control Language): COMMIT, ROLLBACK

        --- INSTALACION (XAMPP) ---
        1. Descargar XAMPP desde apachefriends.org
        2. Instalar e iniciar Apache + MySQL desde el panel de control
        3. Acceder a phpMyAdmin desde http://localhost/phpmyadmin

        --- CREACION DE LA BASE DE DATOS (phpMyAdmin) ---
        1. Crear BD: 'agenda' con cotejamiento utf8_spanish_ci
        2. Crear tabla 'contacto' con columnas:
           - id       INT AUTO_INCREMENT PRIMARY KEY
           - nombre   VARCHAR(200)
           - correo   VARCHAR(200)
        3. Insertar datos manualmente en la pestana 'Insertar'

        --- CONEXION DESDE JAVA ---
        Requisito: descargar conector JDBC (mysql-connector-java.jar)
        y anadirlo al classpath del proyecto.

        URL de conexion: jdbc:mysql://localhost:3306/agenda
        DriverManager.getConnection(url, user, password)

        try {
            Connection conn = DriverManager.getConnection(URL, user, pass);
            // operaciones con BD
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // CONEXION A LA BASE DE DATOS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  CONEXION A BASE DE DATOS MYSQL");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  URL:      " + URL_BD);
        System.out.println("  Usuario:  " + USUARIO);
        System.out.println("  Password: " + (PASSWORD.isEmpty() ? "(vacia)" : PASSWORD));
        System.out.println();

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL_BD, USUARIO, PASSWORD);
            System.out.println("  CONEXION EXITOSA a la base de datos 'agenda'");
            System.out.println("  (el servidor MySQL/MariaDB esta funcionando)");
        } catch (SQLException e) {
            System.out.println("  ERROR al conectar: " + e.getMessage());
            System.out.println();
            System.out.println("  Posibles causas:");
            System.out.println("  1. El servidor MySQL no esta iniciado");
            System.out.println("     -> Inicia Apache y MySQL desde XAMPP Control Panel");
            System.out.println("  2. La base de datos 'agenda' no existe");
            System.out.println("     -> Creala desde phpMyAdmin");
            System.out.println("  3. El conector JDBC no esta en el classpath");
            System.out.println("     -> Anade mysql-connector-java.jar al proyecto");
            System.out.println("  4. Puerto incorrecto (por defecto: 3306)");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("  Conexion cerrada correctamente");
                } catch (SQLException e) {
                    System.out.println("  Error al cerrar conexion: " + e.getMessage());
                }
            }
        }
        System.out.println();

        // ============================================================
        // RESUMEN DE LA ESTRUCTURA DE LA BD
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  ESTRUCTURA DE LA BASE DE DATOS");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Base de datos: agenda");
        System.out.println();
        System.out.println("  Tabla: contacto");
        System.out.println("  +-------+--------------+------+-----+---------+----------------+");
        System.out.println("  | Campo | Tipo         | Nulo | Clave | Default | Extra          |");
        System.out.println("  +-------+--------------+------+-----+---------+----------------+");
        System.out.println("  | id    | int(11)      | NO   | PRI  | NULL    | auto_increment |");
        System.out.println("  | nombre| varchar(200) | SI   |      | NULL    |                |");
        System.out.println("  | correo| varchar(200) | SI   |      | NULL    |                |");
        System.out.println("  +-------+--------------+------+-----+---------+----------------+");
        System.out.println();
        System.out.println("  PRIMARY KEY (id) - se auto-incrementa");
        System.out.println();
        System.out.println("  Datos de ejemplo insertados:");
        System.out.println("    (1, 'Pepe', 'pepe@pp.com')");
        System.out.println("    (2, 'Jose', 'jose@jose.com')");
        System.out.println("    (3, 'Ana',  'ana@ana.com')");
        System.out.println();

        // ============================================================
        // INSTRUCCIONES SQL BASICAS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  INSTRUCCIONES SQL BASICAS (DML)");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  INSERT - Insertar datos:");
        System.out.println("    INSERT INTO contacto (nombre, correo)");
        System.out.println("    VALUES ('Pepe', 'pepe@pp.com');");
        System.out.println();
        System.out.println("  SELECT - Consultar datos:");
        System.out.println("    SELECT * FROM contacto;");
        System.out.println("    SELECT nombre, correo FROM contacto;");
        System.out.println("    SELECT * FROM contacto WHERE nombre='Pepe';");
        System.out.println();
        System.out.println("  UPDATE - Modificar datos:");
        System.out.println("    UPDATE contacto SET correo='nuevo@mail.com'");
        System.out.println("    WHERE nombre='Pepe';");
        System.out.println();
        System.out.println("  DELETE - Eliminar datos:");
        System.out.println("    DELETE FROM contacto WHERE nombre='Pepe';");
        System.out.println();

        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V12: BD EN JAVA - INTRODUCCION MYSQL)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - BD: conjunto estructurado de datos interrelacionados");
        System.out.println("  - Tablas: estructura principal (columnas + filas)");
        System.out.println("  - SQL: lenguaje estandar para BD relacionales");
        System.out.println("  - DML: INSERT, SELECT, UPDATE, DELETE");
        System.out.println("  - JDBC: conector Java para acceder a BD");
        System.out.println("  - DriverManager.getConnection() para conectar");
        System.out.println("  - Proximo video: consultar datos con SELECT desde Java");
    }
}