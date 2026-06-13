/**
 * Video 7 - Instrucciones en pseudocodigo DAM - DAW
 * URL:          https://www.youtube.com/watch?v=taSJeALBVGk&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=7
 * Canal:        Aula en la nube
 *               https://www.youtube.com/@aulaenlanube
 * Video:        Video 7 - Instrucciones en pseudocodigo
 * Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]
 *
 * Resumen:
 *   Septimo video del curso. Se centra en las instrucciones en pseudocodigo
 *   como paso previo a la programacion en Java: tipos de instrucciones,
 *   sintaxis, estructuras secuenciales, condicionales y ejemplos practicos.
 *
 *   Temas que probablemente cubre:
 *   - Que es una instruccion (sentencia) en pseudocodigo
 *   - Instrucciones de asignacion: variable <- expresion
 *   - Instrucciones de entrada/salida: Leer(), Escribir()
 *   - Instrucciones condicionales: Si-Entonces-Sino
 *   - Instrucciones iterativas: Mientras, Repetir, Para
 *   - Estructura secuencial: instrucciones en orden
 *   - Bloques de instrucciones (dentro de condicionales/bucles)
 *   - Ejemplos completos de algoritmos en pseudocodigo
 *   - Paso de pseudocodigo a codigo Java
 *
 * Conceptos clave para el examen:
 *   - Instruccion (sentencia): orden basica que ejecuta el ordenador
 *   - Pseudocodigo: lenguaje informal con palabras clave en espanol
 *   - Instruccion de asignacion: variable <- expresion (flecha hacia la variable)
 *     Ejemplo: edad <- 18, suma <- suma + valor
 *   - Instruccion de entrada: Leer(variable) - captura dato del teclado
 *   - Instruccion de salida: Escribir(expresion) - muestra en pantalla
 *   - Instruccion condicional: Si (condicion) Entonces ... Sino ... FinSi
 *   - Instruccion iterativa Mientras: Mientras (condicion) Hacer ... FinMientras
 *   - Instruccion iterativa Repetir: Repetir ... Hasta Que (condicion)
 *   - Instruccion iterativa Para: Para variable <- inicio Hasta fin Hacer ... FinPara
 *   - Bloque de instrucciones: conjunto de instrucciones dentro de una estructura
 *   - Indentacion: fundamental en pseudocodigo para leer bloques
 *   - Palabras clave tipicas: Algoritmo, FinAlgoritmo, Leer, Escribir,
 *     Si, Entonces, Sino, FinSi, Mientras, Hacer, FinMientras,
 *     Repetir, Hasta Que, Para, Hasta, FinPara
 *   - Estructura de un algoritmo en pseudocodigo:
 *     Algoritmo Nombre
 *       // comentarios
 *       Instrucciones...
 *     FinAlgoritmo
 *   - Anidamiento: instrucciones dentro de otras instrucciones
 *
 * @author       Aula en la nube (YouTube)
 * @version      1.0
 * @since        2026-06-13
 */

public class Video_7_Instrucciones_Pseudocodigo {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "Video 7 - Instrucciones en pseudocodigo DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=taSJeALBVGk&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=7";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    // -------------------------------------------------------------
    // Resumen en formato texto
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 7 - INSTRUCCIONES EN PSEUDOCODIGO
        ================================================================

        Video:        Video 7 - Instrucciones en pseudocodigo
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]

        --- RESUMEN ---

        Septimo video del curso. Explica las instrucciones en pseudocodigo:
        asignacion, E/S, condicionales e iterativas, con ejemplos practicos
        y la estructura general de un algoritmo.

        Temas que probablemente cubre:
          1. Instrucciones de asignacion: variable <- expresion
          2. Instrucciones de entrada/salida: Leer(), Escribir()
          3. Instruccion condicional: Si-Entonces-Sino
          4. Instrucciones iterativas: Mientras, Repetir, Para
          5. Estructura secuencial
          6. Bloques e indentacion
          7. Ejemplos completos en pseudocodigo
          8. Paso de pseudocodigo a Java

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Instruccion (sentencia) -> Orden basica que ejecuta el ordenador
        * Pseudocodigo -> Lenguaje informal con palabras clave en espanol

        * Estructura general de un algoritmo en pseudocodigo:
            Algoritmo NombreDelAlgoritmo
              // comentarios con doble barra
              Definir variable1, variable2 Como Tipo
              Leer(variable1)
              variable2 <- variable1 * 2
              Escribir(variable2)
            FinAlgoritmo

        * Instrucciones basicas:
          - Asignacion:  variable <- valor o expresion
          - Entrada:     Leer(variable)
          - Salida:      Escribir(expresion o texto entre comillas)

        * Instruccion condicional:
            Si (condicion) Entonces
              instrucciones_si_verdadero
            Sino
              instrucciones_si_falso
            FinSi

        * Instruccion Mientras (pre-condicion):
            Mientras (condicion) Hacer
              instrucciones
            FinMientras

        * Instruccion Repetir (post-condicion, al menos una vez):
            Repetir
              instrucciones
            Hasta Que (condicion)

        * Instruccion Para (bucle con contador):
            Para variable <- inicio Hasta fin Hacer
              instrucciones
            FinPara

        * Palabras clave principales:
          Algoritmo, FinAlgoritmo, Definir, Como, Leer, Escribir,
          Si, Entonces, Sino, FinSi, Mientras, Hacer, FinMientras,
          Repetir, Hasta, Que, Para, FinPara

        * Indentacion -> Sangria para visualizar bloques (obligatoria)
        * Anidamiento -> Instrucciones dentro de otras instrucciones
        * Comentarios -> // texto (no se ejecutan, solo explican)
        * Paso a Java: pseudocodigo se traduce directamente a sintaxis Java
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
