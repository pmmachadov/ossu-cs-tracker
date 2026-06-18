import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * Video 8-16: MySQL en JAVA - DELETE
 *
 * Tema 8: Eliminar datos de una base de datos MySQL desde Java
 * usando DELETE con PreparedStatement.
 *
 * URL: https://www.youtube.com/watch?v=z2UOpGsHslU&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=187
 */
class Video_8_16_BDMySQLDelete {

    public static final String TITULO = "8-16 JAVA: MySQL - DELETE ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=z2UOpGsHslU&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=187";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-16 - MYSQL EN JAVA: DELETE
        ================================================================

        Eliminar datos de una tabla MySQL desde Java.

        --- SQL DELETE ---
        DELETE FROM contacto WHERE nombre = ?;
        DELETE FROM contacto;  (SIN WHERE -> BORRA TODOS)

        --- PROCESO EN JAVA ---
        1. String sql = "DELETE FROM contacto WHERE nombre = ?"
        2. PreparedStatement stmt = conn.prepareStatement(sql)
        3. stmt.setString(1, valor)
        4. int filas = stmt.executeUpdate()
        5. filas = numero de filas eliminadas

        --- PRECAUCION ---
        SIN WHERE -> se borran TODOS los registros de la tabla.
        Siempre usar WHERE a menos que se quiera vaciar la tabla.
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
    // GENERADOR
    // ================================================================
    static class GeneradorNombres {
        private static final String[] NOMBRES = {"Adriana", "Gabriela", "Alejandra", "Ines", "Diana", "Sofia", "Laura", "Elena", "Maria", "Ana", "Luis", "Juan", "Pepe", "Carlos", "Pablo"};
        private static final String[] APELLIDOS = {"Rico", "Sierra", "Santos", "Hernandez", "Garcia", "Lopez", "Martinez", "Gonzalez", "Fernandez", "Torres", "Diaz", "Calvo"};
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
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        Connection conn = null;

        try {
            conn = ConexionBD.conectar("agenda");
            System.out.println("  Conectado a BD 'agenda'");
            System.out.println();

            // ============================================================
            // EJEMPLO 1: DELETE con WHERE (por nombre)
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 1: DELETE por nombre");
            System.out.println("=========================================");

            String sql1 = "DELETE FROM contacto WHERE nombre = ?";
            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, "pp2");

            int filas1 = stmt1.executeUpdate();
            if (filas1 > 0) {
                System.out.println("  Se borraron " + filas1 + " contacto(s) con nombre 'pp2'");
            } else {
                System.out.println("  No se encontraron contactos con nombre 'pp2'");
            }
            stmt1.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 2: DELETE con WHERE (nombre vacio)
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 2: DELETE nombre vacio");
            System.out.println("=========================================");

            String sql2 = "DELETE FROM contacto WHERE nombre = ?";
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setString(1, "");

            int filas2 = stmt2.executeUpdate();
            if (filas2 > 0) {
                System.out.println("  Se borraron " + filas2 + " contacto(s) con nombre vacio");
            }
            stmt2.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 3: DELETE con condicion numerica (edad > x)
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 3: DELETE por edad > 23");
            System.out.println("=========================================");

            String sql3 = "DELETE FROM contacto WHERE edad > ?";
            PreparedStatement stmt3 = conn.prepareStatement(sql3);
            stmt3.setInt(1, 23);

            int filas3 = stmt3.executeUpdate();
            if (filas3 > 0) {
                System.out.println("  Se borraron " + filas3 + " contacto(s) con edad > 23");
            }
            stmt3.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 4: DELETE con condicion (edad = 18)
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 4: DELETE por edad = 18");
            System.out.println("=========================================");

            String sql4 = "DELETE FROM contacto WHERE edad = ?";
            PreparedStatement stmt4 = conn.prepareStatement(sql4);
            stmt4.setInt(1, 18);

            int filas4 = stmt4.executeUpdate();
            if (filas4 > 0) {
                System.out.println("  Se borraron " + filas4 + " contacto(s) con edad = 18");
            }
            stmt4.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 5: INSERTAR NUEVOS CONTACTOS (repoblar)
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 5: Repoblar BD con contactos");
            System.out.println("=========================================");

            String sqlInsert = "INSERT INTO contacto (nombre, correo, edad) VALUES (?, ?, ?)";
            PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);

            Random rnd = new Random();
            int insertados = 0;
            for (int i = 0; i < 10; i++) {
                String nombre = GeneradorNombres.generarNombreCompleto();
                String correo = GeneradorNombres.generarCorreo(nombre);
                int edad = 18 + rnd.nextInt(7); // 18 a 24

                stmtInsert.setString(1, nombre);
                stmtInsert.setString(2, correo);
                stmtInsert.setInt(3, edad);

                try {
                    stmtInsert.executeUpdate();
                    insertados++;
                    System.out.println("    " + nombre + " (" + edad + " anos)");
                } catch (SQLException e) {
                    // correo duplicado
                }
            }
            stmtInsert.close();
            System.out.println("  Total insertados: " + insertados);
            System.out.println();

            // ============================================================
            // EJEMPLO 6: DELETE SIN WHERE (BORRA TODO)
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 6: DELETE sin WHERE");
            System.out.println("  (BORRA TODOS los contactos)");
            System.out.println("=========================================");

            // COMENTADO PARA NO VACIAR LA BD SIN QUERER
            /*
            String sqlTodo = "DELETE FROM contacto";
            PreparedStatement stmtTodo = conn.prepareStatement(sqlTodo);
            int filasTodo = stmtTodo.executeUpdate();
            System.out.println("  Se borraron " + filasTodo + " contacto(s) (TODOS)");
            stmtTodo.close();
            */

            System.out.println("  (comentado para evitar borrado accidental)");
            System.out.println("  Para borrar todos, descomentar el codigo");
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
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V16: MYSQL DELETE DESDE JAVA)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - DELETE FROM: eliminar datos de una tabla");
        System.out.println("  - WHERE: condicion para borrar filas especificas");
        System.out.println("  - SIN WHERE: se borran TODOS los registros");
        System.out.println("  - executeUpdate(): devuelve filas eliminadas");
        System.out.println("  - Operadores: =, >, <, >=, <=, LIKE, etc.");
        System.out.println("  - Siempre verificar el WHERE antes de ejecutar");
        System.out.println("  - Fin del curso (tema 8 completo)");
    }
}
