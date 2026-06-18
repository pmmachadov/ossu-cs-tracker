

class Video_2_Introduccion_Programacion_Algoritmos {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "Video 2 - Introduccion a la programacion y los algoritmos DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=dfEEG4A_Hoo&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=2";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // Resumen en formato texto
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 2 - INTRODUCCION A LA PROGRAMACION Y LOS ALGORITMOS
        ================================================================

        Video:        Video 2 - Introduccion a la programacion y los algoritmos
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]

        --- RESUMEN ---

        Segundo video del MEGA Curso JAVA desde 0. Se introducen los
        conceptos fundamentales de la programacion y los algoritmos,
        sentando las bases teoricas antes de escribir la primera linea
        de codigo Java.

        Temas que probablemente cubre:
          1. Que es la programacion?
          2. Que es un algoritmo?
          3. Caracteristicas de los algoritmos
             (precisos, deterministas, finitos)
          4. Diagramas de flujo y pseudocodigo
          5. Conceptos basicos: variables, constantes, tipos de datos
          6. Estructuras de control basicas
             (secuencia, seleccion, iteracion)
          7. Primer acercamiento a la logica de programacion

        Ideal para quienes empiezan desde cero y necesitan entender
        los fundamentos antes de meterse de lleno en Java.

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Programa -> Conjunto de instrucciones que ejecuta un ordenador
        * Algoritmo -> Pasos ordenados y finitos para resolver un problema
        * Lenguaje de programacion -> Idioma formal para escribir programas
        * Codigo fuente -> Texto escrito en un lenguaje de programacion
        * Compilacion -> Traduccion de codigo fuente a codigo maquina
        * Interpretacion -> Ejecucion linea por linea sin compilar
        * Pseudocodigo -> Lenguaje informal para describir algoritmos
        * Diagrama de flujo -> Representacion grafica de un algoritmo
        * Variable -> Espacio de memoria que almacena un valor mutable
        * Constante -> Valor que no cambia durante la ejecucion
        * Tipo de dato -> entero, real, caracter, booleano
        * Estructuras de control -> secuencia, seleccion (if), iteracion (while, for)
        * Depuracion (debugging) -> Proceso de encontrar y corregir errores
        ================================================================
        """;

    // -------------------------------------------------------------
    // Metodo principal
    // -------------------------------------------------------------
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
