import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * Video 8-14: MySQL en JAVA - INSERT
 *
 * Tema 8: Insertar datos en una base de datos MySQL desde Java
 * usando INSERT con PreparedStatement parametrizado.
 *
 * URL: https://www.youtube.com/watch?v=z-DFvBJcJzs&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=185
 */
class Video_8_14_BDMySQLInsert {

    public static final String TITULO = "8-14 JAVA: MySQL - INSERT ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=z-DFvBJcJzs&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=185";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-14 - MYSQL EN JAVA: INSERT
        ================================================================

        Insertar datos en una base de datos MySQL desde Java.

        --- SQL INSERT ---
        INSERT INTO contacto (nombre, correo) VALUES (?, ?);

        Los interrogantes (?) son PARAMETROS que se sustituyen
        con setString(), setInt(), etc. Esto evita la inyeccion SQL.

        --- PROCESO EN JAVA ---
        1. Connection conn = DriverManager.getConnection(...)
        2. String sql = "INSERT INTO contacto (nombre, correo) VALUES (?, ?)"
        3. PreparedStatement stmt = conn.prepareStatement(sql)
        4. stmt.setString(1, nombre)  -> primer parametro
        5. stmt.setString(2, correo)  -> segundo parametro
        6. int filas = stmt.executeUpdate()  -> devuelve filas afectadas
        7. if (filas > 0) -> insertado correctamente

        --- METODOS ---
        setString(indice, String)   -> para VARCHAR / TEXT
        setInt(indice, int)         -> para INT
        setDouble(indice, double)   -> para DOUBLE / FLOAT
        setBoolean(indice, boolean) -> para BOOLEAN / TINYINT
        setNull(indice, tipo)       -> para NULL

        executeUpdate() -> devuelve int (filas afectadas)
          - INSERT: 1 si se inserto, 0 si no
          - UPDATE: numero de filas modificadas
          - DELETE: numero de filas eliminadas

        --- IMPORTANTE ---
        - Si la clave primaria se repite -> SQLException
        - Los parametros evitan inyeccion SQL
        - Los indices empiezan en 1
        ================================================================
        """;

    // ================================================================
    // CLASE AUXILIAR ConexionBD
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
    // CLASE AUXILIAR GeneradorNombres
    // ================================================================
    static class GeneradorNombres {
        private static final String[] NOMBRES = {
            "Pepe", "Ana", "Juan", "Maria", "Luis", "Elena", "Carlos",
            "Sofia", "Miguel", "Laura", "Jose", "Irene", "Bruno", "Ines"
        };
        private static final String[] APELLIDOS = {
            "Garcia", "Lopez", "Martinez", "Rodriguez", "Fernandez",
            "Gonzalez", "Sanchez", "Perez", "Martin", "Alvarez",
            "Asins", "Luna", "Eras", "Calvo", "Marin"
        };
        private static final Random RANDOM = new Random();

        public static String generarNombreCompleto() {
            return NOMBRES[RANDOM.nextInt(NOMBRES.length)]
                + " " + APELLIDOS[RANDOM.nextInt(APELLIDOS.length)];
        }

        public static String generarCorreo(String nombreCompleto) {
            return nombreCompleto.toLowerCase().replace(" ", "_")
                + "@aulaenlanube.com";
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
            System.out.println("  Conectado a la BD 'agenda'");
            System.out.println();

            // ============================================================
            // EJEMPLO 1: INSERTAR UN CONTACTO SIMPLE
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 1: INSERTAR CONTACTO");
            System.out.println("=========================================");

            String nombre = "Pepe";
            String correo = "pp2@pp.com";

            String sql1 = "INSERT INTO contacto (nombre, correo) VALUES (?, ?)";
            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, nombre);
            stmt1.setString(2, correo);

            int filas1 = stmt1.executeUpdate();
            if (filas1 > 0) {
                System.out.println("  Contacto '" + nombre + "' insertado correctamente");
            }
            stmt1.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 2: INSERTAR CON GENERADOR ALEATORIO
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 2: INSERTAR ALEATORIO");
            System.out.println("=========================================");

            String nombreAleatorio = GeneradorNombres.generarNombreCompleto();
            String correoAleatorio = GeneradorNombres.generarCorreo(nombreAleatorio);

            String sql2 = "INSERT INTO contacto (nombre, correo) VALUES (?, ?)";
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setString(1, nombreAleatorio);
            stmt2.setString(2, correoAleatorio);

            int filas2 = stmt2.executeUpdate();
            if (filas2 > 0) {
                System.out.println("  Contacto '" + nombreAleatorio + "' insertado correctamente");
                System.out.println("  Correo: " + correoAleatorio);
            }
            stmt2.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 3: INSERTAR CON EDAD (columna extra)
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 3: INSERTAR CON EDAD");
            System.out.println("=========================================");

            // Si la tabla tiene columna 'edad' INT
            String nombre3 = GeneradorNombres.generarNombreCompleto();
            String correo3 = GeneradorNombres.generarCorreo(nombre3);
            int edad = 20;

            String sql3 = "INSERT INTO contacto (nombre, correo, edad) VALUES (?, ?, ?)";
            PreparedStatement stmt3 = conn.prepareStatement(sql3);
            stmt3.setString(1, nombre3);
            stmt3.setString(2, correo3);
            stmt3.setInt(3, edad);

            int filas3 = stmt3.executeUpdate();
            if (filas3 > 0) {
                System.out.println("  Contacto '" + nombre3 + "' insertado con edad " + edad);
            }
            stmt3.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 4: INSERTAR SIN ESPECIFICAR CAMPOS
            // (se insertan en el orden de la tabla)
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 4: INSERT sin parentesis");
            System.out.println("  (ORDER: nombre, correo, edad)");
            System.out.println("=========================================");

            String nombre4 = GeneradorNombres.generarNombreCompleto();
            String correo4 = GeneradorNombres.generarCorreo(nombre4);
            int edad4 = 22;

            // Sin parentesis de campos -> orden natural de la tabla
            String sql4 = "INSERT INTO contacto VALUES (?, ?, ?)";
            PreparedStatement stmt4 = conn.prepareStatement(sql4);
            stmt4.setString(1, nombre4);
            stmt4.setString(2, correo4);
            stmt4.setInt(3, edad4);

            int filas4 = stmt4.executeUpdate();
            if (filas4 > 0) {
                System.out.println("  Contacto '" + nombre4 + "' insertado (orden tabla)");
            }
            stmt4.close();
            System.out.println();

            // ============================================================
            // EJEMPLO 5: INSERTAR VARIOS CONTACTOS (bucle)
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJEMPLO 5: INSERTAR VARIOS");
            System.out.println("=========================================");

            String sql5 = "INSERT INTO contacto (nombre, correo, edad) VALUES (?, ?, ?)";
            PreparedStatement stmt5 = conn.prepareStatement(sql5);

            int insertados = 0;
            for (int i = 1; i <= 5; i++) {
                String nom = GeneradorNombres.generarNombreCompleto();
                String corr = GeneradorNombres.generarCorreo(nom);
                int ed = 18 + new Random().nextInt(30);

                stmt5.setString(1, nom);
                stmt5.setString(2, corr);
                stmt5.setInt(3, ed);

                try {
                    int f = stmt5.executeUpdate();
                    if (f > 0) {
                        insertados++;
                        System.out.println("    " + insertados + ". " + nom + " (" + ed + " anos)");
                    }
                } catch (SQLException e) {
                    // Si el correo ya existe (clave primaria duplicada)
                    System.out.println("    (duplicado: " + corr + ")");
                }
            }
            stmt5.close();
            System.out.println("  Total insertados: " + insertados);
            System.out.println();

        } catch (SQLException e) {
            System.out.println("  ERROR SQL: " + e.getMessage());
            System.out.println("  Codigo: " + e.getErrorCode());
            if (e.getErrorCode() == 1062) {
                System.out.println("  (Clave primaria duplicada - el correo ya existe)");
            }
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
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V14: MYSQL INSERT DESDE JAVA)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - INSERT INTO tabla (campos) VALUES (?, ?)");
        System.out.println("  - Parametros ? evitan inyeccion SQL");
        System.out.println("  - setString(indice, valor) para sustituir parametros");
        System.out.println("  - executeUpdate(): ejecuta INSERT/UPDATE/DELETE");
        System.out.println("  - executeUpdate() devuelve filas afectadas (int)");
        System.out.println("  - Clave primaria duplicada -> SQLException (cod 1062)");
        System.out.println("  - Proximo video: UPDATE y DELETE desde Java");
    }
}
