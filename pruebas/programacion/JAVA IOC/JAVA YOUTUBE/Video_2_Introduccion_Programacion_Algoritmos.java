/**
 * Video 2 - Introducción a la programación y los algoritmos ☕ DAM - DAW
 * URL:          https://www.youtube.com/watch?v=dfEEG4A_Hoo&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=2
 * Canal:        Aula en la nube
 *               https://www.youtube.com/@aulaenlanube
 * Vídeo:        Video 2 - Introducción a la programación y los algoritmos
 * Playlist:     🏆 MEGA Curso JAVA desde 0 [ DAM - DAW ]
 *
 * Resumen:
 *   Segundo vídeo del MEGA Curso JAVA desde 0. En esta ocasión se introduce
 *   el concepto de programación y algoritmos, sentando las bases teóricas
 *   antes de empezar a escribir código Java.
 *
 *   Temas que probablemente cubre:
 *   - ¿Qué es la programación?
 *   - ¿Qué es un algoritmo?
 *   - Características de los algoritmos (precisos, deterministas, finitos)
 *   - Diagramas de flujo y pseudocódigo
 *   - Conceptos básicos: variables, constantes, tipos de datos
 *   - Estructuras de control básicas (secuencia, selección, iteración)
 *   - Primer acercamiento a la lógica de programación
 *
 * Conceptos clave para el examen:
 *   - Algoritmo: conjunto de pasos ordenados y finitos para resolver un problema
 *   - Pseudocódigo: lenguaje informal para describir algoritmos
 *   - Diagrama de flujo: representación gráfica de un algoritmo
 *   - Variable: espacio de memoria que almacena un valor que puede cambiar
 *   - Constante: valor que no cambia durante la ejecución
 *   - Tipo de dato: entero, real, carácter, booleano, etc.
 *   - Estructuras de control: secuencia, selección (if), iteración (while, for)
 *   - Depuración: proceso de encontrar y corregir errores
 *
 * @author       Aula en la nube (YouTube)
 * @version      1.0
 * @since        2026-06-13
 */

public class Video_2_Introduccion_Programacion_Algoritmos {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "Video 2 - Introducción a la programación y los algoritmos ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=dfEEG4A_Hoo&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=2";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "🏆 MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    // ──────────────────────────────────────────────────────────────
    // Resumen en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 2 - INTRODUCCIÓN A LA PROGRAMACIÓN Y LOS ALGORITMOS
        ================================================================

        Vídeo:        Video 2 - Introducción a la programación y los algoritmos ☕
        Canal:        Aula en la nube
        Playlist:     🏆 MEGA Curso JAVA desde 0 [ DAM - DAW ]

        --- RESUMEN ---

        Segundo vídeo del MEGA Curso JAVA desde 0. Se introducen los
        conceptos fundamentales de la programación y los algoritmos,
        sentando las bases teóricas antes de escribir la primera línea
        de código Java.

        Temas que probablemente cubre:
          1. ¿Qué es la programación?
          2. ¿Qué es un algoritmo?
          3. Características de los algoritmos
             (precisos, deterministas, finitos)
          4. Diagramas de flujo y pseudocódigo
          5. Conceptos básicos: variables, constantes, tipos de datos
          6. Estructuras de control básicas
             (secuencia, selección, iteración)
          7. Primer acercamiento a la lógica de programación

        Ideal para quienes empiezan desde cero y necesitan entender
        los fundamentos antes de meterse de lleno en Java.

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        • Algoritmo → Pasos ordenados y finitos para resolver un problema
        • Pseudocódigo → Lenguaje informal para describir algoritmos
        • Diagrama de flujo → Representación gráfica de un algoritmo
        • Variable → Espacio de memoria que almacena un valor mutable
        • Constante → Valor que no cambia durante la ejecución
        • Tipo de dato → entero, real, carácter, booleano
        • Estructuras de control → secuencia, selección (if), iteración (while, for)
        • Depuración → Proceso de encontrar y corregir errores
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
