/**
  * Video 1 - Presentación MEGA Curso JAVA desde 0 ☕ DAM - DAW
 * URL:          https://www.youtube.com/watch?v=NFDjCN4r_68&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu
 * Canal:        Aula en la nube
 *               https://www.youtube.com/@aulaenlanube
 * Vídeo:        Video 1 - Presentación del MEGA Curso JAVA desde 0
 * Playlist:     🏆 MEGA Curso JAVA desde 0 [ DAM - DAW ]
 *
 * Resumen:
 *   Esta es una lista de reproducción con un curso completo de Java desde cero,
 *   orientado a los ciclos formativos de DAM (Desarrollo de Aplicaciones Multiplataforma)
 *   y DAW (Desarrollo de Aplicaciones Web).
 *
 *   El vídeo de presentación da inicio al curso, que cubre Java desde nivel
 *   principiante absoluto. El canal "Aula en la nube" se especializa en cursos
 *   de programación para Formación Profesional.
 *
 * Posibles temas del curso:
 *   - Fundamentos de Java (variables, tipos de datos, operadores)
 *   - Estructuras de control (condicionales, bucles)
 *   - Programación orientada a objetos (clases, herencia, polimorfismo, interfaces)
 *   - Colecciones y estructuras de datos
 *   - Entrada / Salida y ficheros
 *   - Bases de datos (JDBC)
 *   - Interfaces gráficas (Swing / JavaFX)
 *   - Conceptos avanzados (Java EE, etc.)
 *
 * Conceptos clave para el examen:
 *   - DAM: Desarrollo de Aplicaciones Multiplataforma
 *   - DAW: Desarrollo de Aplicaciones Web
 *   - JDK (Java Development Kit): kit de desarrollo, incluye JRE + herramientas
 *   - JRE (Java Runtime Environment): entorno de ejecucion, incluye JVM + librerias
 *   - JVM (Java Virtual Machine): maquina virtual que ejecuta el bytecode
 *   - Bytecode: codigo intermedio .class, independiente de la plataforma
 *   - javac: compilador de Java (.java -> .class)
 *   - java: lanzador que inicia la JVM y ejecuta el programa
 *   - POO (Programacion Orientada a Objetos): paradigma central de Java
 *   - Write Once, Run Away (WORA): filosofia multiplataforma de Java
 *   - Ciclo de desarrollo: editar -> compilar (javac) -> ejecutar (java)
 *
 * @author       Aula en la nube (YouTube)
 * @version      1.0
 * @since        2026-06-13
 */

class Video_1_Presentacion_MEGA_Curso_Java_Desde_0 {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "Video 1 - Presentación MEGA Curso JAVA desde 0 ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=NFDjCN4r_68&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "🏆 MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    // ──────────────────────────────────────────────────────────────
    // Resumen en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String RESUMEN =
        """
        ================================================================
          MEGA CURSO JAVA DESDE 0  [ DAM - DAW ]
        ================================================================

        Vídeo:        Video 1 - Presentación MEGA Curso JAVA desde 0 ☕
        Canal:        Aula en la nube
        Playlist:     🏆 MEGA Curso JAVA desde 0 [ DAM - DAW ]

        --- RESUMEN ---

        Esta es una lista de reproducción con un curso completo de Java
        desde cero, orientado a los ciclos formativos de DAM (Desarrollo
        de Aplicaciones Multiplataforma) y DAW (Desarrollo de Aplicaciones
        Web).

        El vídeo de presentación da inicio al curso, que cubre Java desde
        nivel principiante absoluto. El canal "Aula en la nube" se
        especializa en cursos de programación para Formación Profesional.

        Posibles temas del curso:
          1. Fundamentos de Java (variables, tipos de datos, operadores)
          2. Estructuras de control (condicionales, bucles)
          3. Programación orientada a objetos (clases, herencia,
             polimorfismo, interfaces)
          4. Colecciones y estructuras de datos
          5. Entrada / Salida y ficheros
          6. Bases de datos (JDBC)
          7. Interfaces gráficas (Swing / JavaFX)
          8. Conceptos avanzados (Java EE, etc.)

        Perfecto si estás cursando DAM o DAW y necesitas aprender Java
        desde cero, o si quieres reforzar conceptos para tus estudios
        de Formación Profesional.

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        • DAM   -> Desarrollo de Aplicaciones Multiplataforma
        • DAW   -> Desarrollo de Aplicaciones Web
        • JDK   -> Java Development Kit (compilador + JRE + herramientas)
        • JRE   -> Java Runtime Environment (JVM + librerias)
        • JVM   -> Java Virtual Machine (ejecuta bytecode)
        • Bytecode -> Codigo .class independiente de plataforma
        • javac -> Compilador: .java -> .class
        • java  -> Lanzador: inicia JVM y ejecuta el programa
        • POO   -> Programacion Orientada a Objetos
        • Ciclo de desarrollo: editar (.java) -> compilar (javac) -> ejecutar (java)
        • Write once, run anywhere (WORA)
        ================================================================
        """;

    // ──────────────────────────────────────────────────────────────
    // Método principal
    // ──────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        mostrarInformacion();
    }

    /**
     * Muestra por consola la información del vídeo, la playlist y el resumen.
     */
    public static void mostrarInformacion() {
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║   INFORMACIÓN DEL VÍDEO                        ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.println("Vídeo:      " + TITULO);
        System.out.println("Canal:      " + CANAL);
        System.out.println("URL Canal:  " + URL_CANAL);
        System.out.println("URL Vídeo:  " + URL);
        System.out.println("Playlist:   " + PLAYLIST);
        System.out.println();
        System.out.println(RESUMEN);
    }
}
