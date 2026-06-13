/**
 * Video 9 - Tipos de bucles pseudocodigo (MIENTRAS - WHILE) DAM - DAW
 * URL:          https://www.youtube.com/watch?v=gWYWRs9d_ZI&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=9
 * Canal:        Aula en la nube
 *               https://www.youtube.com/@aulaenlanube
 * Video:        Video 9 - Tipos de bucles pseudocodigo (MIENTRAS - WHILE)
 * Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]
 *
 * Resumen basado en la transcripcion del video:
 *   Introduccion a las estructuras de control repetitivas (bucles).
 *   Explica los tres tipos principales: MIENTRAS (WHILE), REPETIR (DO-WHILE)
 *   y PARA (FOR), con el ejercicio de calcular la potencia de un numero
 *   mediante multiplicaciones sucesivas.
 *
 *   El video cubre:
 *   - Concepto de bucle: bloque que se ejecuta mas de una vez segun condicion
 *   - Bucle MIENTRAS: evalua condicion ANTES de ejecutar (0 o mas veces)
 *   - Bucle REPETIR-MIENTRAS: ejecuta al menos 1 vez, condicion al final
 *   - Bucle PARA: version abreviada con inicializacion, condicion e incremento
 *   - Ordinograma (diagrama de flujo) del bucle mientras
 *   - Ejercicio: calcular potencia (base^exponente) con bucle mientras
 *   - Traza de ejecucion detallada
 *   - Error comun: condicion incorrecta (menor en vez de menor o igual)
 *   - Dos soluciones correctas: contador=1 con <=, o contador=0 con <
 *
 * @author       Aula en la nube (YouTube)
 * @version      1.0
 * @since        2026-06-13
 */

class Video_9_Bucles_Mientras {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "Video 9 - Tipos de bucles pseudocodigo (MIENTRAS - WHILE) DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=gWYWRs9d_ZI&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=9";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    // -------------------------------------------------------------
    // Resumen en formato texto
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 9 - TIPOS DE BUCLES PSEUDOCODIGO (MIENTRAS - WHILE)
        ================================================================

        Video:        Video 9 - Estructuras de control repetitivas (bucles)
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]

        --- DEFINICION DE BUCLE ---

        Un bucle es un bloque de codigo que puede ejecutarse mas de una vez.
        Se ejecuta mientras una condicion se cumpla. Cuando la condicion
        deja de cumplirse, se sale del bucle y continua el flujo normal.

        --- TIPOS DE BUCLES ---

        1. MIENTRAS (WHILE) - pre-condicion:
             Mientras (condicion) Hacer
               instrucciones
             FinMientras
           - Evalua la condicion ANTES de ejecutar
           - Puede ejecutarse 0 veces si la condicion es falsa al inicio

        2. REPETIR (DO-WHILE) - post-condicion:
             Repetir
               instrucciones
             Hasta Que (condicion)
           - Ejecuta al menos 1 vez
           - Evalua la condicion DESPUES de ejecutar

        3. PARA (FOR) - version abreviada:
             Para contador <- inicio Hasta fin Hacer
               instrucciones
             FinPara
           - Incluye inicializacion, condicion e incremento en una linea
           - Es una forma abreviada del MIENTRAS

        --- ORDINOGRAMA DEL BUCLE MIENTRAS ---

        [Instrucciones previas]
               |
              v
        [Condicion] ---falso---> [Instrucciones finales]
           |
         verdadero
           |
           v
        [Instrucciones del bucle]
           |
           v
        (vuelve a la condicion)

        --- EJERCICIO: CALCULAR POTENCIA (base^exponente) ---

        Enunciado: Disenar un algoritmo que calcule la potencia de un
        numero dada la base y el exponente (sin usar el operador de
        potencia). Ejemplo: 2^4 = 2*2*2*2 = 16

        --- PRIMERA SOLUCION (INCORRECTA) ---

        Algoritmo CalcularPotencia_Incorrecto
          Definir base, exponente, contador, potencia Como Entero

          Escribir("Introduce base y exponente:")
          Leer(base)
          Leer(exponente)

          potencia <- 1
          contador <- 1

          Mientras (contador < exponente) Hacer
            potencia <- potencia * base
            contador <- contador + 1
          FinMientras

          Escribir(base, " elevado a ", exponente, " = ", potencia)
        FinAlgoritmo

        * Problema: con contador=1 y condicion "<", hace exponente-1
          iteraciones. Para 2^4 solo hace 3 pasadas -> resultado 8 (error)

        --- SEGUNDA SOLUCION (CORRECTA A) - contador=1 con <= ---

        Algoritmo CalcularPotencia
          Definir base, exponente, contador, potencia Como Entero

          Escribir("Introduce base y exponente:")
          Leer(base)
          Leer(exponente)

          potencia <- 1
          contador <- 1

          Mientras (contador <= exponente) Hacer
            potencia <- potencia * base
            contador <- contador + 1
          FinMientras

          Escribir(base, " elevado a ", exponente, " = ", potencia)
        FinAlgoritmo

        --- TRAZA DE EJECUCION (base=2, exponente=4) ---

        | Iter. | base | exp. | contador | potencia | Cond. (cont <= exp) |
        |-------|------|------|----------|----------|---------------------|
        | Inicio|  2   |  4   |    1     |    1     |         -           |
        | 1a    |  2   |  4   |    2     |    2     |    1 <= 4 = true    |
        | 2a    |  2   |  4   |    3     |    4     |    2 <= 4 = true    |
        | 3a    |  2   |  4   |    4     |    8     |    3 <= 4 = true    |
        | 4a    |  2   |  4   |    5     |   16     |    4 <= 4 = true    |
        | Salida|  2   |  4   |    5     |   16     |    5 <= 4 = false   |
        | Resultado: 2^4 = 16                                            |

        --- TERCERA SOLUCION (CORRECTA B) - contador=0 con < ---

        Algoritmo CalcularPotencia_v2
          Definir base, exponente, contador, potencia Como Entero

          Escribir("Introduce base y exponente:")
          Leer(base)
          Leer(exponente)

          potencia <- 1
          contador <- 0

          Mientras (contador < exponente) Hacer
            potencia <- potencia * base
            contador <- contador + 1
          FinMientras

          Escribir(base, " elevado a ", exponente, " = ", potencia)
        FinAlgoritmo

        * Con contador=0 y condicion "<" se hacen exactamente "exponente"
          iteraciones. Es la solucion que mas le gusta al instructor.

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Bucle (iteracion) -> Bloque que se repite segun una condicion

        * Bucle MIENTRAS -> Pre-condicion, 0 o mas veces
          - Importante: la condicion debe volverse falsa en algun momento
          - Si no, se produce un bucle infinito

        * Bucle REPETIR -> Post-condicion, 1 o mas veces
        * Bucle PARA -> Version abreviada con contador

        * Potencia por multiplicaciones sucesivas:
          base^exponente = multiplicar base por si misma exp. veces

        * Cuidado con la condicion del bucle:
          - contador=1, condicion "< exp" -> exp-1 iteraciones (MAL)
          - contador=1, condicion "<=" exp -> exp iteraciones (BIEN)
          - contador=0, condicion "< exp" -> exp iteraciones (BIEN)

        * Cualquier numero elevado a 0 = 1
          (la solucion con contador=0 lo maneja bien: no entra al bucle
           y potencia queda en 1)

        * Contador -> variable que controla las iteraciones
        * Acumulador (potencia) -> guarda el resultado parcial

        * Traza de ejecucion -> Seguir valores de cada variable paso a paso
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
