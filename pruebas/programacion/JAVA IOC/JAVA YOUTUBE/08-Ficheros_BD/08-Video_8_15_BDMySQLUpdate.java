import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * Video 8-15: MySQL en JAVA - UPDATE
 *
 * Tema 8: Modificar datos existentes en una base de datos
 * MySQL desde Java usando UPDATE con PreparedStatement.
 *
 * URL: https://www.youtube.com/watch?v=4XWBdh1PWo0&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=186
 */
class Video_8_15_BDMySQLUpdate {

    public static final String TITULO = "8-15 JAVA: MySQL - UPDATE ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=4XWBdh1PWo0&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=186";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-15 - MYSQL EN JAVA: UPDATE
        ================================================================

        Modificar datos existentes en una tabla MySQL desde Java.

        --- SQL UPDATE ---
        UPDATE contacto SET nombre = ? WHERE nombre = ?
        UPDATE contacto SET edad = ? WHERE nombre LIKE ?
        UPDATE contacto SET nombre = ?, edad = ? WHERE correo = ?

        SIN WHERE -> MODIFICA TODAS LAS FILAS (cuidado!)

        --- PROCESO EN JAVA ---
        1. Connection conn = ConexionBD.conectar("agenda")
        2. String sql = "UPDATE contacto SET nombre = ? WHERE nombre = ?"
        3. PreparedStatement stmt = conn.prepareStatement(sql)
        4. stmt.setString(1, "nuevoNombre")   // primer ?
        5. stmt.setString(2, "nombreViejo")   // segundo ?
        6. int filas = stmt.executeUpdate()   // filas modificadas
        7. conn.close()

        --- METODO ---
        executeUpdate() devuelve int:
          - 0: no se modifico ninguna fila
          - 1: se modifico una fila
          - N: se modificaron N filas

        --- PRECAUCION ---
        Siempre usar WHERE para evitar modificar todos los registros.
        ================================================================
        """;

    // ================================================================
    // CLASE AUXILIAR CONEXION
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
    // CLASE GENERADOR NOMBRES
    // ================================================================
    static class GeneradorNombres {
        private static final String[] NOMBRES = {"Pepe", "Ana", "Juan", "Maria", "Luis", "Elena", "Carlos", "Sofia", "Guillermo", "Irene", "Jaime", "Bruno", "Ines", "Jimena", "Pablo", "Laura", "Ivan", "John", "Jose"};
        private static final String[] APELLIDOS = {"Garcia", "Lopez", "Martinez", "Gonzalez", "Rodriguez", "Fernandez", "Alvarez", "Calvo", "Asins", "Eras", "Luna", "Marin", "Torres", "Diaz"};
        private static final Random RANDOM = new Random();
        public static String generarNombreCompleto() {
            return NOMBRES[RANDOM.nextInt(NOMBRES.length)]
                + " " + APELLIDOS[RANDOM.nextInt(APELLIDOS.length)];
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
            // EJEMPLO 1: UPDATE basico (cambiar nombre por nombre)
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 1: UPDATE nombre");
            System.out.println("=========================================");
            System.out.println("  UPDATE contacto SET nombre = ? WHERE nombre = ?");
            System.out.println("  (Cambiar 'Pepe' a 'pp2')");
            System.out.println();

            String sql1 = "UPDATE contacto SET nombre = ? WHERE nombre = ?";
            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, "pp2");      // nuevo nombre
            stmt1.setString(2, "Pepe");     // condicion

            int filas1 = stmt1.executeUpdate();
            if (filas1 > 0) {
                System.out.println("  Se modificaron " + filas1 + " contacto(s)");
            } else {
                System.out.println("  No se modifico ningun contacto");
            }
            stmt1.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 2: UPDATE con LIKE (patron)
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 2: UPDATE con LIKE");
            System.out.println("=========================================");
            System.out.println("  UPDATE contacto SET edad = ? WHERE nombre LIKE ?");
            System.out.println("  (Poner edad=25 a los que empiezan por 'J')");
            System.out.println();

            String sql2 = "UPDATE contacto SET edad = ? WHERE nombre LIKE ?";
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1, 25);
            stmt2.setString(2, "J%");

            int filas2 = stmt2.executeUpdate();
            System.out.println("  Se modificaron " + filas2 + " contacto(s) con edad=25");
            stmt2.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 3: UPDATE sin WHERE (TODOS los registros)
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 3: UPDATE sin WHERE");
            System.out.println("=========================================");
            System.out.println("  UPDATE contacto SET edad = ?");
            System.out.println("  (SIN WHERE -> modifica TODOS)");
            System.out.println();

            String sql3 = "UPDATE contacto SET edad = ?";
            PreparedStatement stmt3 = conn.prepareStatement(sql3);
            stmt3.setInt(1, 18);

            int filas3 = stmt3.executeUpdate();
            System.out.println("  Se modificaron " + filas3 + " contacto(s) (todos a edad=18)");
            stmt3.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 4: UPDATE multiples columnas
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 4: UPDATE multiples columnas");
            System.out.println("=========================================");
            System.out.println("  (Varios campos en un solo UPDATE)");
            System.out.println();

            String nombreAleat = GeneradorNombres.generarNombreCompleto();
            String sql4 = "UPDATE contacto SET nombre = ?, edad = ? WHERE correo = ?";
            PreparedStatement stmt4 = conn.prepareStatement(sql4);
            stmt4.setString(1, nombreAleat);
            stmt4.setInt(2, 30);
            stmt4.setString(3, "ana@ana.com");

            int filas4 = stmt4.executeUpdate();
            if (filas4 > 0) {
                System.out.println("  Contacto con correo 'ana@ana.com' actualizado:");
                System.out.println("    Nombre: " + nombreAleat + ", Edad: 30");
            }
            stmt4.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 5: UPDATE con nombre aleatorio para todos
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 5: UPDATE todos con nombre aleatorio");
            System.out.println("=========================================");
            System.out.println("  (mismo nombre para todos porque se genera una vez)");
            System.out.println();

            String nombreUnico = GeneradorNombres.generarNombreCompleto();
            String sql5 = "UPDATE contacto SET nombre = ?, edad = ?";
            PreparedStatement stmt5 = conn.prepareStatement(sql5);
            stmt5.setString(1, nombreUnico);
            stmt5.setInt(2, 25);

            int filas5 = stmt5.executeUpdate();
            System.out.println("  Todos los contactos actualizados:");
            System.out.println("    Nombre: " + nombreUnico + ", Edad: 25");
            System.out.println("  (total: " + filas5 + " registros)");
            stmt5.close();
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
        System.out.println();

        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V15: MYSQL UPDATE DESDE JAVA)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - UPDATE: modificar datos existentes");
        System.out.println("  - SET: indica que campo(s) modificar");
        System.out.println("  - WHERE: condicion para no modificar todo");
        System.out.println("  - SIN WHERE -> se modifican TODAS las filas");
        System.out.println("  - executeUpdate() devuelve filas afectadas");
        System.out.println("  - Se pueden actualizar varios campos a la vez");
        System.out.println("  - Proximo video: DELETE (eliminar datos)");
    }
}
