class Video_7_20_APIDeJava {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "7-20 JAVA: API de Java DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=q3TCmzpaiIk&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=161";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-20 - API DE JAVA
        ================================================================

        Video:        7-20 JAVA: API de Java
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7

        --- RESUMEN (transcripcion) ---

        API = Application Programming Interface.
        Conjunto de clases y metodos ya programados que podemos
        utilizar en nuestras aplicaciones para no tener que
        programarlo todo desde cero.

        --- PARA QUE SIRVE UNA API ---

        - Actua como puente entre componentes de software
        - Simplifica el intercambio de informacion
        - Proporciona clases y metodos ya testeados
        - Ahorra tiempo y esfuerzo de desarrollo
        - Permite centrarse en la logica de la aplicacion
        - Favorece la reutilizacion del codigo

        --- DOCUMENTACION OFICIAL DE JAVA ---

        Enlace: https://docs.oracle.com/en/java/javase/XX/docs/api/
        (XX = version del JDK)

        JDK 8: Documentacion clasica en 3 paneles (paquetes, clases, detalle)
        JDK 20+: Documentacion moderna con busqueda y modulos

        Estructura de la documentacion:
          1. Modulos (java.base, java.sql, etc.)
          2. Paquetes (java.lang, java.util, java.io, etc.)
          3. Clases e interfaces
          4. Arbol de herencia
          5. Constructores
          6. Metodos

        --- PRINCIPALES PAQUETES DE JAVA ---

        java.lang:
          - Clases fundamentales: Object, String, Math, System
          - Clases envoltura: Integer, Double, Boolean, Character
          - Importado automaticamente (no necesita import)

        java.util:
          - Colecciones: ArrayList, HashMap, HashSet, TreeMap, etc.
          - Fecha/hora antiguo: Date, Calendar (obsoletos)
          - Utilidades: Random, Scanner, Arrays, Collections

        java.time:
          - Nueva API de fecha/hora (Java 8+)
          - LocalDate, LocalTime, LocalDateTime, Duration
          - Mas completa y facil de usar que Date/Calendar

        java.io / java.nio:
          - Entrada y salida de datos (ficheros)
          - File, FileInputStream, BufferedReader, etc.

        java.net:
          - Redes y comunicaciones
          - URL, Socket, HttpURLConnection

        java.awt / javax.swing:
          - Interfaz grafica de usuario (GUI)
          - Ventanas, botones, eventos

        java.sql:
          - Base de datos (JDBC)
          - Connection, Statement, ResultSet

        java.security:
          - Seguridad, cifrado, firmas digitales

        --- COMO LEER LA API ---

        Para cada clase, la documentacion muestra:
          1. Modulo y paquete al que pertenece
          2. Arbol de herencia (extends)
          3. Interfaces que implementa (implements)
          4. Subclases directas
          5. Descripcion de la clase
          6. Constructores disponibles
          7. Metodos con descripcion, parametros y valor de retorno

        --- IMPORTACION DE CLASES ---

        Import especifico (recomendado):
          import java.util.ArrayList;

        Import de paquete (comodin):
          import java.util.*;

        --- OTRAS APIS Y FRAMEWORKS ---

        Spring:    Framework para desarrollo de aplicaciones
        Hibernate: ORM para bases de datos relacionales
        JavaFX:    GUI moderna (separado del JDK desde Java 11)
        Maven:     Gestion de proyectos y dependencias
        ElasticSearch: Busqueda y analisis distribuido

        --- CONCEPTOS CLAVE ---

        - API = clases + metodos ya programados y testeados
        - Documentacion oficial en docs.oracle.com
        - java.lang importado automaticamente
        - java.util: colecciones y utilidades
        - java.time: fecha/hora moderna (LocalDate, etc.)
        - javadoc: herramienta para generar documentacion
        - Import especifico sobre comodin (buena practica)
        - Existen muchas APIs de terceros (Spring, Hibernate...)
        - Proximo video: ejemplos practicos de uso de la API
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // DEMO SENCILLA: USO DE CLASES DE LA API
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  DEMO: CLASES DE LA API DE JAVA");
        System.out.println("=========================================");

        // java.lang.String
        System.out.println("  java.lang.String (import automatico):");
        String texto = "Hola, API de Java!";
        System.out.println("    Longitud: " + texto.length());
        System.out.println("    Mayusculas: " + texto.toUpperCase());
        System.out.println();

        // java.util.Random
        System.out.println("  java.util.Random (numeros aleatorios):");
        java.util.Random rnd = new java.util.Random();
        System.out.println("    Entero aleatorio: " + rnd.nextInt(100));
        System.out.println();

        // java.time.LocalDate
        System.out.println("  java.time.LocalDate (fecha actual):");
        System.out.println("    Hoy: " + java.time.LocalDate.now());
        System.out.println();

        // java.util.Arrays
        System.out.println("  java.util.Arrays (utilidades arrays):");
        int[] nums = {5, 2, 8, 1, 9};
        java.util.Arrays.sort(nums);
        System.out.println("    Array ordenado: "
            + java.util.Arrays.toString(nums));
        System.out.println();

        // ============================================================
        // ESTRUCTURA DE LA DOCUMENTACION
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  ESTRUCTURA DE LA DOCUMENTACION API");
        System.out.println("=========================================");
        System.out.println("  Para cada clase, la API muestra:");
        System.out.println("  1. Modulo (java.base, java.sql...)");
        System.out.println("  2. Paquete (java.lang, java.util...)");
        System.out.println("  3. Arbol de herencia (quien es su padre)");
        System.out.println("  4. Interfaces implementadas");
        System.out.println("  5. Subclases directas");
        System.out.println("  6. Constructores disponibles");
        System.out.println("  7. Metodos con descripcion");
        System.out.println();
        System.out.println("  Ejemplo: java.lang.String");
        System.out.println("    - Hereda de Object");
        System.out.println("    - Implementa: Serializable, Comparable, CharSequence");
        System.out.println("    - Metodos: length(), charAt(), substring(), etc.");
        System.out.println("    - Enlace: docs.oracle.com -> java.lang.String");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V20: API DE JAVA)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - API = clases y metodos listos para usar");
        System.out.println("  - Documentacion oficial en docs.oracle.com");
        System.out.println("  - java.lang se importa automaticamente");
        System.out.println("  - Usar import especifico (no comodin)");
        System.out.println("  - Proximo video: ejemplos de uso de la API");
    }
}
