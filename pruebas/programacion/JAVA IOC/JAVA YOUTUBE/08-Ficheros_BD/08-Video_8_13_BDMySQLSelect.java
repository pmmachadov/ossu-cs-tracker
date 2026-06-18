import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Video 8-13: MySQL en JAVA - SELECT
 *
 * Tema 8: Consultar datos de una base de datos MySQL/MariaDB
 * desde Java usando JDBC y la instruccion SELECT de SQL.
 *
 * URL: https://www.youtube.com/watch?v=5eMr5hX--Wk&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=184
 */
class Video_8_13_BDMySQLSelect {

    public static final String TITULO = "8-13 JAVA: MySQL - SELECT ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=5eMr5hX--Wk&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=184";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-13 - MYSQL EN JAVA: SELECT
        ================================================================

        Consultar datos de una base de datos MySQL desde Java
        usando la instruccion SELECT de SQL.

        --- PROCESO ---
        1. Conectar a la BD (DriverManager.getConnection)
        2. Crear la consulta SQL (String)
        3. Preparar la instruccion (connection.prepareStatement(sql))
        4. Ejecutar la consulta (preparedStatement.executeQuery())
        5. Analizar el resultado (ResultSet.next())
        6. Obtener los datos (resultSet.getString("campo"))
        7. Cerrar la conexion

        --- CLASES UTILIZADAS ---
        Connection:   conexion con la BD
        PreparedStatement: instruccion SQL preparada
        ResultSet:   resultado de la consulta (tabla virtual)
        ResultSet.next(): avanza a la siguiente fila (true/false)
        ResultSet.getString("campo"): obtiene el valor de una columna

        --- SQL SELECT ---
        SELECT nombre, correo FROM contacto;
        SELECT * FROM contacto;
        SELECT nombre FROM contacto WHERE condicion;

        --- LIKE (patrones) ---
        WHERE nombre LIKE 'J%'   -> empieza por J
        WHERE nombre LIKE '%a%'  -> contiene a
        WHERE nombre LIKE '%'    -> todos
        WHERE nombre LIKE '___'  -> exactamente 3 caracteres
        WHERE nombre LIKE 'J__'  -> 3 chars empezando por J
        ( % = cualquier secuencia, _ = un solo caracter )
        ================================================================
        """;

    // ================================================================
    // CLASE AUXILIAR PARA LA CONEXION
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
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        Connection conn = null;

        try {
            // 1. Conectar a la base de datos 'agenda'
            conn = ConexionBD.conectar("agenda");
            System.out.println("  Conectado a la BD 'agenda'");
            System.out.println();

            // ============================================================
            // EJEMPLO 1: SELECT basico (todos los contactos)
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 1: SELECT nombre, correo");
            System.out.println("=========================================");

            String sql1 = "SELECT nombre, correo FROM contacto";
            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            ResultSet rs1 = stmt1.executeQuery();

            System.out.println("  Contactos:");
            while (rs1.next()) {
                String nombre = rs1.getString("nombre");
                String correo = rs1.getString("correo");
                System.out.println("    " + nombre + " <" + correo + ">");
            }
            rs1.close();
            stmt1.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 2: SELECT con WHERE (empieza por J)
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 2: WHERE nombre LIKE 'J%'");
            System.out.println("=========================================");

            String sql2 = "SELECT nombre, correo FROM contacto WHERE nombre LIKE 'J%'";
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            ResultSet rs2 = stmt2.executeQuery();

            System.out.println("  Contactos cuyo nombre empieza por J:");
            while (rs2.next()) {
                System.out.println("    " + rs2.getString("nombre")
                    + " <" + rs2.getString("correo") + ">");
            }
            rs2.close();
            stmt2.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 3: SELECT con WHERE (contiene 'a')
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 3: WHERE nombre LIKE '%a%'");
            System.out.println("=========================================");

            String sql3 = "SELECT nombre, correo FROM contacto WHERE nombre LIKE '%a%'";
            PreparedStatement stmt3 = conn.prepareStatement(sql3);
            ResultSet rs3 = stmt3.executeQuery();

            System.out.println("  Contactos cuyo nombre contiene 'a':");
            while (rs3.next()) {
                System.out.println("    " + rs3.getString("nombre")
                    + " <" + rs3.getString("correo") + ">");
            }
            rs3.close();
            stmt3.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 4: SELECT con WHERE (nombre exacto)
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 4: WHERE nombre = 'Pepe'");
            System.out.println("=========================================");

            String sql4 = "SELECT nombre, correo FROM contacto WHERE nombre = 'Pepe'";
            PreparedStatement stmt4 = conn.prepareStatement(sql4);
            ResultSet rs4 = stmt4.executeQuery();

            if (rs4.next()) {
                System.out.println("  Contacto encontrado:");
                System.out.println("    " + rs4.getString("nombre")
                    + " <" + rs4.getString("correo") + ">");
            } else {
                System.out.println("  No se encontro ningun contacto con nombre 'Pepe'");
            }
            rs4.close();
            stmt4.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 5: SELECT solo correos
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 5: SELECT solo correo");
            System.out.println("=========================================");

            String sql5 = "SELECT correo FROM contacto";
            PreparedStatement stmt5 = conn.prepareStatement(sql5);
            ResultSet rs5 = stmt5.executeQuery();

            System.out.println("  Correos electronicos:");
            while (rs5.next()) {
                System.out.println("    " + rs5.getString("correo"));
            }
            rs5.close();
            stmt5.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 6: SELECT con nombre de 3 letras
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 6: WHERE nombre LIKE '___'");
            System.out.println("  (exactamente 3 caracteres)");
            System.out.println("=========================================");

            String sql6 = "SELECT nombre, correo FROM contacto WHERE nombre LIKE '___'";
            PreparedStatement stmt6 = conn.prepareStatement(sql6);
            ResultSet rs6 = stmt6.executeQuery();

            System.out.println("  Contactos con nombre de 3 letras:");
            while (rs6.next()) {
                System.out.println("    " + rs6.getString("nombre")
                    + " <" + rs6.getString("correo") + ">");
            }
            rs6.close();
            stmt6.close();
            System.out.println();

        } catch (SQLException e) {
            System.out.println("  ERROR SQL: " + e.getMessage());
            System.out.println("  Codigo: " + e.getErrorCode());
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
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V13: MYSQL SELECT DESDE JAVA)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - SELECT: consultar datos de la BD");
        System.out.println("  - PreparedStatement: instruccion SQL parametrizable");
        System.out.println("  - executeQuery(): ejecuta SELECT, devuelve ResultSet");
        System.out.println("  - ResultSet.next(): avanza a la siguiente fila");
        System.out.println("  - ResultSet.getString(\"campo\"): obtiene el valor");
        System.out.println("  - LIKE: patrones con % (cualquier cadena) y _ (1 char)");
        System.out.println("  - Proximo video: INSERT (anadir datos desde Java)");
    }
}