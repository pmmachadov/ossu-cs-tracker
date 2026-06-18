class Video_7_23_ClasesYPaquetes {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "7-23 JAVA: Clases y paquetes DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=CzLI7DzzQhM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=164";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-23 - CLASES Y PAQUETES
        ================================================================

        Video:        7-23 JAVA: Clases y paquetes
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7

        --- RESUMEN (transcripcion) ---

        Como reutilizar codigo en otros proyectos mediante paquetes.
        Los paquetes agrupan clases relacionadas y evitan conflictos
        de nombres. Se exportan a un archivo JAR que puede importarse
        en cualquier otro proyecto de Java.

        --- PAQUETES ---

        Un paquete es una agrupacion de clases relacionadas.
        Caracteristicas:
          - Proporciona un espacio de nombres unico
          - Evita conflictos con clases del mismo nombre
          - Controla la visibilidad (public, private, protected)
          - Organiza el codigo jerarquicamente

        Declaracion (primera linea del archivo):
          package aula.generadores.arrays;

        Convencion:
          - Nombres en minusculas
          - Siguen estructura de carpetas
          - Ej: com.miempresa.miproyecto.modulo

        --- ESTRUCTURA DE CARPETAS ---

        Proyecto: mi_paquete/
          +-- aula/
                +-- bordes/
                |     +-- Bordes.java  (package aula.bordes)
                +-- generadores/
                      +-- arrays/
                      |     +-- GeneradorArrays.java (package aula.generadores.arrays)
                      +-- matrices/
                            +-- GeneradorMatrices.java (package aula.generadores.matrices)

        --- CREACION DE UN JAR ---

        1. Crear la estructura de carpetas
        2. Escribir clases con su correspondiente package
        3. Desde Java Projects (VSCode): boton export -> genera .jar
        4. El .jar contiene todas las clases compiladas

        --- IMPORTACION DEL JAR EN OTRO PROYECTO ---

        1. Crear nuevo proyecto
        2. Java Projects -> Configure Classpath -> Add
        3. Seleccionar el archivo .jar
        4. Ya se pueden importar las clases:
             import aula.bordes.Bordes;
             import aula.generadores.arrays.*;
             import aula.generadores.matrices.GeneradorMatrices;

        --- USO DE CLASES DEL PAQUETE ---

        // Usando import
        import aula.bordes.Bordes;
        Bordes.mostrarTextoConBordes("Hola");

        // Sin import (ruta completa)
        aula.generadores.arrays.GeneradorArrays.generarArray(10);

        // Metodos deben ser PUBLIC para usarse desde otros proyectos
        // Si son solo static (sin public) -> solo visible en el mismo paquete

        --- MODIFICADORES DE ACCESO ---

        public:    Accesible desde cualquier clase
        protected: Accesible desde el mismo paquete + subclases
        (default): Accesible desde el mismo paquete
        private:   Solo desde la misma clase

        --- CONFLICTOS DE NOMBRES ---

        Si se crea una clase con el mismo nombre que una de la API
        (ej: Integer dentro del paquete aula), se debe usar la ruta
        completa para desambiguar:

        java.lang.Integer num = java.lang.Integer.valueOf(5);
        aula.Integer numPropio = new aula.Integer();

        --- REUTILIZACION DE CODIGO ---

        - Empaquetar metodos utiles en clases dentro de paquetes
        - Exportar a JAR
        - Importar en cualquier proyecto
        - Ejemplo: la clase Bordes (mostrar texto/matriz con bordes)
          y los generadores de arrays/matrices creados en el Tema 4

        --- CONCEPTOS CLAVE ---

        - package: agrupa clases relacionadas
        - import: trae clases de otros paquetes
        - JAR: archivo que empaqueta clases compiladas
        - public: necesario para usar desde otros proyectos
        - Los paquetes siguen la estructura de carpetas
        - Evitan conflictos de nombres
        - Permiten reutilizar codigo entre proyectos
        - Proximo video: introduccion a programacion funcional
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        System.out.println("=========================================");
        System.out.println("  DEMO: EJEMPLO DE PAQUETES");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Los paquetes se crean con estructura de");
        System.out.println("  carpetas. Este archivo demuestra el");
        System.out.println("  concepto aunque no se puede ejecutar");
        System.out.println("  como paquete real en un solo archivo.");
        System.out.println();

        System.out.println("  Para crear paquetes reutilizables:");
        System.out.println("  1. Crear carpeta raiz del paquete");
        System.out.println("  2. Crear subcarpetas (aula/bordes/, etc.)");
        System.out.println("  3. En cada .java: package ruta.del.paquete;");
        System.out.println("  4. Exportar a JAR (Java Projects -> export)");
        System.out.println("  5. Importar JAR en otro proyecto");
        System.out.println("  6. Usar: import aula.bordes.Bordes;");
        System.out.println();

        // ============================================================
        // EJEMPLO DE CONFLICTO DE NOMBRES
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  CONFLICTOS DE NOMBRES");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Si creas una clase Integer en tu paquete:");
        System.out.println("    aula.Integer");
        System.out.println("  Para usar el Integer de Java:");
        System.out.println("    java.lang.Integer num = 5;");
        System.out.println("  Para usar el Integer del paquete:");
        System.out.println("    aula.Integer miInt = new aula.Integer();");
        System.out.println();

        // ============================================================
        // MODIFICADORES DE ACCESO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  MODIFICADORES DE ACCESO");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  public:    Todo el mundo");
        System.out.println("  protected: Mismo paquete + subclases");
        System.out.println("  (default): Mismo paquete");
        System.out.println("  private:   Solo la misma clase");
        System.out.println();
        System.out.println("  Para reutilizar metodos en otros");
        System.out.println("  proyectos: deben ser public.");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V23: CLASES Y PAQUETES)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - package: organiza clases en carpetas");
        System.out.println("  - import: trae clases de otros paquetes");
        System.out.println("  - JAR: archivo con clases compiladas");
        System.out.println("  - public para acceder desde fuera");
        System.out.println("  - Conflictos: usar ruta completa");
        System.out.println("  - Reutilizacion de codigo entre proyectos");
    }
}
