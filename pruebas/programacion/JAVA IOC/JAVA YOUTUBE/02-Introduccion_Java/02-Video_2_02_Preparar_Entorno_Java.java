class Video_2_02_Preparar_Entorno_Java {

    public static final String TITULO = "2-2 Preparar el entorno para programar en Java DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=Q_2j8aYnmYk&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=18";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-2 PREPARAR EL ENTORNO PARA PROGRAMAR EN JAVA
        ================================================================

        --- QUE SE NECESITA ---

        Para EJECUTAR programas Java:  JRE (Java Runtime Environment)
        Para DESARROLLAR programas Java: JDK (Java Development Kit)
                                         + Editor (VS Code)

        --- JRE (Java Runtime Environment) ---

        * Incluye la JVM (Java Virtual Machine)
        * Incluye el compilador JIT (Just in Time)
        * Necesario para EJECUTAR programas Java
        * Descarga: https://www.java.com/download/

        --- JDK (Java Development Kit) ---

        * Incluye JRE + herramientas de desarrollo (compilador javac, etc.)
        * Necesario para CREAR programas Java
        * Versiones:
          - JDK 19: ultima version (sept 2022)
          - JDK 17: LTS (Long Time Support) -> actualizaciones hasta sept 2024
            (RECOMENDADA para el curso)
        * Descarga: https://www.oracle.com/java/technologies/downloads/
        * Seleccionar: Java 17 LTS -> Windows x64 Installer

        --- INSTALACION JDK 17 ---

        1. Descargar el .exe
        2. Ejecutar como administrador
        3. Asistente de instalacion: Siguiente -> Siguiente -> Cerrar

        --- VISUAL STUDIO CODE ---

        * Editor gratuito y de codigo abierto
        * Compatible con muchos lenguajes (incluyendo Java)
        * Modular: extensiones/plugins
        * Descarga: https://code.visualstudio.com/download

        --- INSTALACION VS CODE ---

        1. Descargar el .exe
        2. Ejecutar el asistente
        3. Opciones recomendadas:
           - Anadir "Open with Code" al menu contextual
           - Asociar .java con VS Code
        4. Abrir VS Code

        --- CONFIGURAR VS CODE PARA JAVA ---

        1. Abrir VS Code
        2. Ctrl+Shift+P -> cambiar idioma a ingles (opcional)
        3. Icono de extensiones (o Ctrl+Shift+X)
        4. Buscar: "Java"
        5. Instalar: "Extension Pack for Java" (de Microsoft)
           (incluye: Language Support, Debugger, Maven, Test Runner, etc.)
        6. Crear carpeta "curso-java" o similar
        7. Click derecho sobre la carpeta -> "Open with Code"

        --- ESQUEMA DE CAPAS ---

        JDK (kit de desarrollo)
          |-- JRE (entorno de ejecucion)
                |-- JVM (maquina virtual)
                      |-- JIT (compilador Just in Time)

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * JRE: solo para EJECUTAR programas Java
        * JDK: para DESARROLLAR (incluye compilador y JRE)
        * JDK 17 LTS: version recomendada (soporte largo)
        * VS Code: editor recomendado para el curso
        * Extension Pack for Java: extension necesaria en VS Code
        * Para usar un programa Java: solo necesito JRE
        * Para crear programas Java: necesito JDK + editor
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
