/**
 * Video 3 - Representacion de algoritmos DAM - DAW
 * URL:          https://www.youtube.com/watch?v=b003s0CJ2KU&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=3
 * Canal:        Aula en la nube
 *               https://www.youtube.com/@aulaenlanube
 * Video:        Video 3 - Representacion de algoritmos
 * Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]
 *
 * Resumen:
 *   Tercer video del MEGA Curso JAVA desde 0. Se centra en las distintas
 *   formas de representar algoritmos antes de codificarlos en Java.
 *
 *   Temas que probablemente cubre:
 *   - Que es un algoritmo (repaso)
 *   - Diagramas de flujo: simbolos, reglas, ejemplos
 *   - Pseudocodigo: estructura y convenciones
 *   - Variables: declaracion, asignacion, tipos basicos
 *   - Constantes en pseudocodigo
 *   - Operadores basicos (aritmeticos, relacionales, logicos)
 *   - Paso de algoritmo a pseudocodigo y viceversa
 *
 * Conceptos clave para el examen:
 *   - Algoritmo: conjunto de pasos ordenados y finitos para resolver un problema
 *   - Diagrama de flujo: representacion grafica de un algoritmo usando simbolos
 *     estandar (inicio/fin, proceso, decision, entrada/salida, conectores)
 *   - Pseudocodigo: lenguaje hibrido entre lenguaje natural y codigo de
 *     programacion para describir algoritmos
 *   - Variable: espacio de memoria identificado por un nombre que almacena
 *     un valor que puede cambiar durante la ejecucion
 *   - Tipos de variables segun su uso: de trabajo (contadores, acumuladores),
 *     de intercambio (swap), logicas (booleanas)
 *   - Declaracion de variables: tipo + nombre (ej: entero edad)
 *   - Asignacion: dar valor a una variable (ej: edad <- 18)
 *   - simbolos de diagramas de flujo: ovalo (terminal), rectangulo (proceso),
 *     rombo (decision), paralelogramo (E/S), circulo (conector)
 *   - Normas de pseudocodigo: indentacion, claridad, palabras clave en mayusculas
 *   - Entrada/Salida en pseudocodigo: Leer(), Escribir()
 *
 * @author       Aula en la nube (YouTube)
 * @version      1.0
 * @since        2026-06-13
 */

public class Video_3_Representacion_Algoritmos {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "Video 3 - Representacion de algoritmos DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=b003s0CJ2KU&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=3";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    // -------------------------------------------------------------
    // Resumen en formato texto
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 3 - REPRESENTACION DE ALGORITMOS
        ================================================================

        Video:        Video 3 - Representacion de algoritmos
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]

        --- RESUMEN ---

        Tercer video del curso. Se enfoca en las formas de representar
        algoritmos: diagramas de flujo y pseudocodigo, paso a paso,
        con ejemplos practicos.

        Temas que probablemente cubre:
          1. Repaso de algoritmo: pasos ordenados y finitos
          2. Diagramas de flujo: simbolos y reglas
          3. Pseudocodigo: estructura y convenciones
          4. Variables: declaracion, asignacion, tipos basicos
          5. Constantes en pseudocodigo
          6. Operadores basicos (aritmeticos, relacionales, logicos)
          7. Conversion entre algoritmo, diagrama y pseudocodigo

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Algoritmo -> Conjunto de pasos ordenados y finitos
        * Diagrama de flujo -> Representacion grafica del algoritmo
          - Ovalo: Inicio / Fin
          - Rectangulo: Proceso / operacion
          - Rombo: Decision / condicion
          - Paralelogramo: Entrada / Salida
          - Circulo: Conector
        * Pseudocodigo -> Lenguaje hibrido informal para describir algoritmos
          - Palabras clave en mayusculas (SI, MIENTRAS, LEER)
          - Indentacion para claridad
          - Leer() para entrada de datos
          - Escribir() para salida de datos
        * Variable -> Espacio de memoria con nombre y tipo
          - Se declara: tipo nombre (ej: entero edad)
          - Se asigna: edad <- 18
          - Tipos: contadores, acumuladores, de intercambio, logicas
        * Constante -> Valor fijo que no cambia
        * Operadores:
          - Aritmeticos: +, -, *, /, %
          - Relacionales: >, <, >=, <=, =, <>
          - Logicos: Y, O, NO
        * Diferencia clave: algoritmo es la idea, diagrama y pseudocodigo
          son formas de representarlo
        ================================================================
        """;

    // -------------------------------------------------------------
    // Metodo principal
    // -------------------------------------------------------------
    public static void main(String[] args) {
        mostrarInformacion();
    }

    /**
     * Muestra por consola la informacion y resumen del video.
     */
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
