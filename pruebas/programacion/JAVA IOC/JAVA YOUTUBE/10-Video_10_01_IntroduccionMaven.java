

class Video_10_01_IntroduccionMaven {

    public static final String TITULO = "10-1 Introduccion a Maven DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=fDZ-wT3b2Nw&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=210";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 10 (JavaFX)";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          10-1 INTRODUCCION A MAVEN
        ================================================================

        --- ¿QUE ES MAVEN? ---

        * Herramienta de gestion de proyectos para Java
        * Gestion de dependencias automatica
        * Gestion de plugins
        * Automatiza la construccion y despliegue del proyecto
        * Conceptos clave: pom.xml, dependencias, ciclo de vida

        --- ARCHIVO POM.XML ---

        * Corazon de la configuracion de Maven
        * Formato XML
        * Contiene: nombre del proyecto, version, dependencias, plugins...

        Estructura basica:
          <?xml version="1.0" encoding="UTF-8"?>
          <project>
              <modelVersion>4.0.0</modelVersion>
              <groupId>com.aula</groupId>           // Dominio invertido
              <artifactId>mi-aplicacion</artifactId> // Nombre del artefacto
              <version>1.0</version>                 // Version del proyecto
              <packaging>jar</packaging>             // Tipo de empaquetado (defecto: jar)
              <properties>                           // Propiedades de configuracion
                  <maven.compiler.source>17</maven.compiler.source>
                  <maven.compiler.target>17</maven.compiler.target>
              </properties>
              <dependencies>                         // Dependencias del proyecto
                  <dependency>
                      <groupId>mysql</groupId>
                      <artifactId>mysql-connector-java</artifactId>
                      <version>8.0.33</version>
                  </dependency>
              </dependencies>
          </project>

        --- ESTRUCTURA DE CARPETAS DE UN PROYECTO MAVEN ---

        nombre-proyecto/
        |-- pom.xml
        |-- src/
        |   |-- main/
        |   |   |-- java/        -> Codigo fuente (.java)
        |   |   |   |-- com/
        |   |   |       |-- aula/
        |   |   |           |-- MiClase.java
        |   |   |-- resources/   -> Archivos de configuracion, imagenes, etc.
        |   |-- test/
        |       |-- java/        -> Codigo de pruebas (JUnit, etc.)
        |       |   |-- com/
        |       |       |-- aula/
        |       |           |-- MiClaseTest.java
        |       |-- resources/   -> Recursos para los tests
        |-- target/              -> Archivos compilados (.class, .jar)

        * src/main/java: codigo fuente de la aplicacion
        * src/main/resources: recursos de la aplicacion
        * src/test/java: codigo para pruebas/test
        * src/test/resources: recursos para pruebas
        * target: archivos compilados (se genera automaticamente)

        --- GESTION DE DEPENDENCIAS ---

        * Una de las caracteristicas clave de Maven
        * Se especifican en el pom.xml con <dependency>
        * Maven descarga automaticamente las librerias
        * Las incluye en el classpath automaticamente
        * No es necesario configurar VS Code manualmente

        Ejemplo de dependencia (conector MySQL):
          <dependency>
              <groupId>mysql</groupId>
              <artifactId>mysql-connector-java</artifactId>
              <version>8.0.33</version>
          </dependency>

        * Si la version tiene vulnerabilidades, VS Code/Maven lo indica
        * Se puede hacer Quick Fix para actualizar a la version recomendada

        --- REPOSITORIOS ---

        * Definen de donde Maven descarga las dependencias
        * Repositorio por defecto: repo.maven.apache.org/maven2
        * Se pueden anadir repositorios personalizados:
            <repositories>
                <repository>
                    <id>mi-repo</id>
                    <url>https://.../</url>
                </repository>
            </repositories>

        --- CICLO DE VIDA DE MAVEN (FASES) ---

        1. validate  -> Valida que el proyecto es correcto y toda la
                        informacion esta disponible
        2. compile   -> Compila el codigo fuente (src/main/java)
        3. test      -> Ejecuta las pruebas sobre el codigo compilado
                        (src/test/java)
        4. package   -> Empaqueta el codigo compilado en formato
                        distribuible (.jar por defecto)
        5. install   -> Instala el paquete en el repositorio LOCAL
                        para usarlo como dependencia en otros proyectos
        6. deploy    -> Copia el paquete final a un repositorio REMOTO
                        para compartirlo con otros desarrolladores
        7. clean     -> Elimina todos los archivos compilados de la
                        carpeta target

        * En VS Code (extension Maven for Java): estos comandos aparecen
          como opciones en el panel de Maven, sin necesidad de escribir
          comandos manualmente

        --- EJEMPLO PRACTICO DEL VIDEO ---

        1. Descargar Maven de apache.org (binario .zip)
        2. Descomprimir en una carpeta (ej: C:\\Users\\usuario\\apache-maven-3.9.4)
        3. Configurar la ruta del ejecutable mvn.cmd en VS Code:
           Settings -> Maven -> Executable Path
        4. Crear proyecto: Ctrl+Shift+P -> Create Java Project -> Maven
        5. Elegir "Create from archetype" o "Create basic Maven project"
        6. Indicar groupId (ej: com.aula) y artifactId (ej: demo-maven)
        7. Estructura creada automaticamente con pom.xml, src/main, src/test

        --- USAR DEPENDENCIA ENTRE PROYECTOS MAVEN ---

        * Si el Proyecto A tiene install (en repositorio local):
            mvn install
        * En el pom.xml del Proyecto B se anade:
            <dependency>
                <groupId>com.aula</groupId>
                <artifactId>demo-maven</artifactId>
                <version>1.0</version>
            </dependency>
        * El Proyecto B puede usar las clases del Proyecto A
        * Las dependencias transitivas (ej: mysql-connector) se heredan
          automaticamente

        --- NOTA IMPORTANTE ---
        * Si falta la dependencia del conector MySQL, NO da error
          de compilacion, sino ERROR EN TIEMPO DE EJECUCION
        * La JVM intenta cargar el driver de MySQL en tiempo de ejecucion
        * Si no encuentra la implementacion: SQLException
          "No suitable driver found"
        * Esto ocurre porque java.sql.* son interfaces del JDK,
          pero la implementacion concreta (mysql-connector) es una
          dependencia externa

        ================================================================
        """;

    public static void main(String[] args) {
        mostrarInformacion();
    }

    public static void mostrarInformacion() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("   INFORMACION DEL VIDEO");
        System.out.println("============================================");
        System.out.println("Video:      " + TITULO);
        System.out.println("Canal:      " + CANAL);
        System.out.println("URL Canal:  " + URL_CANAL);
        System.out.println("URL Video:  " + URL);
        System.out.println("Playlist:   " + PLAYLIST);
        System.out.println();
        System.out.println(RESUMEN);
    }
}
