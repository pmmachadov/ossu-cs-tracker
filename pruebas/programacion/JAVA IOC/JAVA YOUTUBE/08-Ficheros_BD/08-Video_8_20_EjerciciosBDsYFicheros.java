import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Video 8-20: Java - Ejercicios BDs y ficheros
 *
 * Tema 8: Ejercicios finales combinando ficheros y base de datos
 * usando la base de datos de ejemplo "World" de MySQL.
 *
 * URL: https://www.youtube.com/watch?v=4m8tpgLhdVE&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=191
 */
class Video_8_20_EjerciciosBDsYFicheros {

    public static final String TITULO = "8-20 JAVA: Ejercicios BDs y ficheros ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=4m8tpgLhdVE&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=191";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-20 - EJERCICIOS BDS Y FICHEROS
        ================================================================

        Ejercicios combinando ficheros y base de datos.
        Base de datos: World (descargar de dev.mysql.com/doc/index-other.html)

        Tablas de la BD World:
          - City:    ID, Name, CountryCode, District, Population
          - Country: Code, Name, Continent, Region, Population...
          - CountryLanguage: CountryCode, Language, IsOfficial, Percentage

        EJERCICIO 1: mostrarCiudadesPais(conn, codigoPais)
          SELECT name, population FROM city WHERE countrycode = ?
          Muestra por consola: "Ciudad (poblacion)"

        EJERCICIO 2: crearFicheroCiudadesPais(conn, codigoPais)
          Misma consulta pero escribe los datos en un fichero
          llamado {codigoPais}.txt usando BufferedWriter

        EJERCICIO 3: crearFicherosCiudadesPaises(conn)
          SELECT code FROM country
          Llama a crearFicheroCiudadesPais para cada codigo
          Crea un fichero por cada pais con sus ciudades
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
    // EJERCICIO 1: Mostrar ciudades de un pais por consola
    // ================================================================
    static void mostrarCiudadesPais(Connection conn, String codigoPais) {
        String sql = "SELECT name, population FROM city WHERE countrycode = ?";
        System.out.println("  Ciudades con countrycode = '" + codigoPais + "':");

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigoPais);

            try (ResultSet rs = stmt.executeQuery()) {
                boolean hayResultados = false;
                while (rs.next()) {
                    String nombre = rs.getString("name");
                    int poblacion = rs.getInt("population");
                    System.out.println("    " + nombre + " (" + poblacion + ")");
                    hayResultados = true;
                }
                if (!hayResultados) {
                    System.out.println("    (no se encontraron ciudades)");
                }
            }
        } catch (SQLException e) {
            System.out.println("  Error SQL: " + e.getMessage());
        }
    }

    // ================================================================
    // EJERCICIO 2: Crear fichero con ciudades de un pais
    // ================================================================
    static void crearFicheroCiudadesPais(Connection conn, String codigoPais) {
        String sql = "SELECT name, population FROM city WHERE countrycode = ?";
        String nombreFichero = codigoPais + ".txt";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigoPais);

            try (ResultSet rs = stmt.executeQuery();
                 BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero))) {

                int ciudades = 0;
                while (rs.next()) {
                    String nombre = rs.getString("name");
                    int poblacion = rs.getInt("population");
                    bw.write(nombre + " (" + poblacion + ")");
                    bw.newLine();
                    ciudades++;
                }
                System.out.println("  Creado '" + nombreFichero + "' con " + ciudades + " ciudades");
            }
        } catch (SQLException | IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
    }

    // ================================================================
    // EJERCICIO 3: Crear fichero por cada pais
    // ================================================================
    static void crearFicherosCiudadesPaises(Connection conn) {
        String sql = "SELECT code FROM country";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            int total = 0;
            while (rs.next()) {
                String codigo = rs.getString("code");
                crearFicheroCiudadesPais(conn, codigo);
                total++;
            }
            System.out.println("  Total paises procesados: " + total);
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
            conn = ConexionBD.conectar("world");
            System.out.println("  Conectado a BD 'world'");
            System.out.println();

            // ============================================================
            // EJERCICIO 1: Mostrar ciudades de un pais
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJERCICIO 1: Mostrar ciudades");
            System.out.println("=========================================");

            mostrarCiudadesPais(conn, "NLD");  // Holanda
            System.out.println();

            mostrarCiudadesPais(conn, "ESP");  // Espana
            System.out.println();

            mostrarCiudadesPais(conn, "COL");  // Colombia
            System.out.println();

            // ============================================================
            // EJERCICIO 2: Crear fichero con ciudades de un pais
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJERCICIO 2: Crear fichero por pais");
            System.out.println("=========================================");

            crearFicheroCiudadesPais(conn, "NLD");  // -> NLD.txt
            crearFicheroCiudadesPais(conn, "ESP");  // -> ESP.txt
            crearFicheroCiudadesPais(conn, "COL");  // -> COL.txt
            System.out.println();

            // ============================================================
            // EJERCICIO 3: Crear fichero para CADA pais
            // ============================================================
            System.out.println("=========================================");
            System.out.println("  EJERCICIO 3: Ficheros para TODOS");
            System.out.println("=========================================");
            System.out.println("  (generando ~239 ficheros, uno por pais)");
            System.out.println();

            // COMENTADO para no generar 239 ficheros sin querer
            // crearFicherosCiudadesPaises(conn);

            System.out.println("  (descomentar crearFicherosCiudadesPaises(conn)");
            System.out.println("   para generar todos los ficheros)");
            System.out.println();

        } catch (SQLException e) {
            System.out.println("  ERROR SQL: " + e.getMessage());
            System.out.println();
            System.out.println("  Asegurate de:");
            System.out.println("  1. Tener MySQL en marcha");
            System.out.println("  2. Importar BD 'world' desde phpMyAdmin");
            System.out.println("     (https://dev.mysql.com/doc/index-other.html)");
            System.out.println("  3. Descargar world.sql e importarlo");
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
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V20: EJERCICIOS BDS Y FICHEROS)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - BD World con tablas City, Country, CountryLanguage");
        System.out.println("  - SELECT con WHERE countrycode = ?");
        System.out.println("  - Escribir resultados a fichero con BufferedWriter");
        System.out.println("  - SELECT code FROM country para obtener todos los paises");
        System.out.println("  - Llamar a crearFicheroCiudadesPais para cada codigo");
    }
}
