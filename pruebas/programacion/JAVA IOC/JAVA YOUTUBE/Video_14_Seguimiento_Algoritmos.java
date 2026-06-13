/**
 * Video 14 - Ejercicios de seguimiento de algoritmos DAM - DAW
 * URL:          https://www.youtube.com/watch?v=rH60985e4PM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=14
 * Canal:        Aula en la nube
 *               https://www.youtube.com/@aulaenlanube
 * Video:        Video 14 - Ejercicios de seguimiento de algoritmos
 * Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]
 *
 * Resumen basado en la transcripcion del video:
 *   Actividades de seguimiento de algoritmos (traza). Se deben determinar
 *   los valores finales de las variables tras ejecutar cada algoritmo,
 *   usando bucles, condicionales, operadores aritmeticos, relacionales y logicos.
 *   Muy util para asimilar el funcionamiento de las estructuras de control.
 *
 * @author       Aula en la nube (YouTube)
 * @version      1.0
 * @since        2026-06-13
 */

public class Video_14_Seguimiento_Algoritmos {

    public static final String TITULO = "Video 14 - Ejercicios de seguimiento de algoritmos DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=rH60985e4PM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=14";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 14 - EJERCICIOS DE SEGUIMIENTO DE ALGORITMOS
        ================================================================

        Video:        Video 14 - Seguimiento de algoritmos (traza)
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]

        Explicacion: Actividades donde se debe hacer la traza (seguimiento
        paso a paso) de algoritmos con bucles, condicionales y operadores,
        para determinar los valores finales de las variables.

        --- ALGORITMO 1 ---

        a <- 2
        b <- 2
        Mientras (a > 0) Hacer
          a--
          b++
        FinMientras
        Mientras (b > 0) Hacer
          a++
          b--
        FinMientras
        b <- b + a
        a <- a * b

        Valores finales: a = 16, b = 4

        --- ALGORITMO 2 ---

        a <- 1; b <- 0; c <- 0
        Si (b <> c O a <> b Y a = b) Entonces
          a <- 2
          c <- 5
        FinSi
        Si (c MOD a = 0) Entonces
          c <- c + a
        FinSi
        a <- a * 2
        b <- b - 2
        c <- c / 2

        Valores finales: a = 2, b = -2, c = 0

        --- ALGORITMO 3 ---

        a <- 5; b <- 3; c <- 2
        Mientras (a > c) Hacer
          b <- b * c
          c++
          a--
        FinMientras
        a <- a + b
        c <- c - a

        Valores finales: a = 21, b = 18, c = -17

        --- ALGORITMO 4 ---

        a <- 5; b <- 3; c <- 2
        Mientras (a > c) Hacer
          Si (a = b O a >= c + b) Entonces
            b <- b * c
            c++
          Sino
            c++
          FinSi
        FinMientras
        a <- a MOD b
        c <- c / a

        Valores finales: a = 5, b = 6, c = 1

        --- ALGORITMO 5 ---

        a <- 0; b <- 0; c <- 0
        Mientras (a < 5) Hacer
          Si (a MOD 2 = 0) Entonces
            a++
            b++
            a++
          FinSi
        FinMientras
        a <- a + b
        c <- a + b + c

        Valores finales: a = 9, b = 3, c = 12

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Traza (seguimiento) -> ir apuntando valor de cada variable
          en cada linea del algoritmo, paso a paso

        * Prioridad de operadores logicos: NOT > AND > OR
          - Resolver AND antes que OR cuando no hay parentesis

        * Operadores abreviados:
          a++ equivale a a <- a + 1
          a-- equivale a a <- a - 1
          a += b equivale a a <- a + b
          a *= b equivale a a <- a * b
          a MOD b -> resto de division entera

        * Division entera: 1/2 = 0 (no decimal, se trunca)

        * Bucle while con doble condicion interna:
          - Primero evaluar condicion del while
          - Luego ejecutar cuerpo completo (incluyendo if internos)
          - Volver a evaluar condicion del while

        * Tip: hacer tabla con columnas por variable y
          una fila por cada linea/modificacion
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
