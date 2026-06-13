/**
 * Video 10 - Ejercicio bucle mientras en pseudocodigo DAM - DAW
 * URL:          https://www.youtube.com/watch?v=P73Sa4dzvoc&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=10
 * Canal:        Aula en la nube
 *               https://www.youtube.com/@aulaenlanube
 * Video:        Video 10 - Ejercicio bucle mientras en pseudocodigo
 * Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]
 *
 * Resumen basado en la transcripcion del video:
 *   Ejercicio practico: disenar un algoritmo que lea dos numeros enteros
 *   a y b, y calcule su multiplicacion mediante SUMAS SUCESIVAS (sin usar
 *   el operador de multiplicacion). Se utiliza el bucle MIENTRAS.
 *
 *   El video explica:
 *   - Declaracion de variables: num1, num2, producto, contador
 *   - Inicializacion de producto y contador a 0
 *   - Bucle MIENTRAS con condicion num2 > contador
 *   - En cada iteracion: producto = producto + num1, contador++
 *   - Traza de ejecucion paso a paso con tabla de valores
 *   - Mejora: comprobar si num1 = 0 para evitar iteraciones innecesarias
 *   - Importancia de entender la condicion del bucle y el incremento
 *     del contador para evitar bucles infinitos
 *
 * Conceptos clave para el examen:
 *   - Sumas sucesivas: multiplicar a*b = sumar "a" repetidamente "b" veces
 *   - Bucle MIENTRAS: estructura iterativa de pre-condicion
 *   - Contador: variable que se incrementa en cada iteracion
 *   - Acumulador (producto): variable que guarda el resultado parcial
 *   - Condicion del bucle define cuantas iteraciones se ejecutan
 *   - Cuidado con la condicion: > vs >= cambia el numero de iteraciones
 *   - Optimizacion: evitar iteraciones innecesarias (ej: num1 = 0)
 *   - Traza de ejecucion: tabla con valores de cada variable en cada paso
 *
 * @author       Aula en la nube (YouTube)
 * @version      1.0
 * @since        2026-06-13
 */

public class Video_10_Ejercicio_Bucle_Mientras {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "Video 10 - Ejercicio bucle mientras en pseudocodigo DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=P73Sa4dzvoc&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=10";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    // -------------------------------------------------------------
    // Resumen en formato texto
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 10 - EJERCICIO BUCLE MIENTRAS EN PSEUDOCODIGO
        ================================================================

        Video:        Video 10 - Ejercicio: multiplicacion por sumas sucesivas
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]

        --- ENUNCIADO ---

        Disenar un algoritmo que lea dos numeros enteros a y b, y calcule
        su multiplicacion mediante sumas sucesivas (sin usar el operador
        de multiplicacion), utilizando un bucle MIENTRAS.

        --- SOLUCION ---

        Algoritmo CalculaProducto
          Definir num1, num2, producto, contador Como Entero

          Escribir("Introduce numero 1 y numero 2:")
          Leer(num1)
          Leer(num2)

          producto <- 0
          contador <- 0

          Mientras (num2 > contador) Hacer
            producto <- producto + num1
            contador <- contador + 1
          FinMientras

          Escribir(num1, " * ", num2, " = ", producto)
        FinAlgoritmo

        --- TRAZA DE EJECUCION (num1=5, num2=4) ---

        | Iteracion | num1 | num2 | contador | producto | Condicion (num2>cont) |
        |-----------|------|------|----------|----------|----------------------|
        | Inicio    |  5   |  4   |    0     |    0     |         -            |
        | 1a        |  5   |  4   |    1     |    5     |     4>0 = true      |
        | 2a        |  5   |  4   |    2     |   10     |     4>1 = true      |
        | 3a        |  5   |  4   |    3     |   15     |     4>2 = true      |
        | 4a        |  5   |  4   |    4     |   20     |     4>3 = true      |
        | Salida    |  5   |  4   |    4     |   20     |     4>4 = false     |
        | Resultado | 5 * 4 = 20                                          |

        --- MEJORA: EVITAR ITERACIONES INNECESARIAS ---

        Si num1 es 0, el resultado sera 0 directamente. Se puede optimizar:

        Algoritmo CalculaProductoMejorado
          Definir num1, num2, producto, contador Como Entero

          Escribir("Introduce numero 1 y numero 2:")
          Leer(num1)
          Leer(num2)

          producto <- 0
          contador <- 0

          Si (num1 <> 0) Entonces
            Mientras (num2 > contador) Hacer
              producto <- producto + num1
              contador <- contador + 1
            FinMientras
          FinSi

          Escribir(num1, " * ", num2, " = ", producto)
        FinAlgoritmo

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Sumas sucesivas -> a * b = sumar "a" repetidamente "b" veces
          Ejemplo: 5*4 = 5+5+5+5 = 20

        * Bucle MIENTRAS -> condicion se evalua ANTES de cada iteracion
          - Si num2=4 y contador empieza en 0: se ejecutan 4 veces
          - La condicion (num2 > contador) determina las iteraciones
          - Cuidado con > vs >=: cambia el numero de pasadas

        * Contador -> variable que cuenta las iteraciones (cont <- cont + 1)
        * Acumulador (producto) -> guarda el resultado parcial

        * Traza de ejecucion -> tabla con valores de cada variable paso a paso
          - Herramienta clave para entender y depurar algoritmos

        * Optimizacion del codigo:
          - Detectar casos especiales (num1=0) evita iteraciones innecesarias
          - Hace el algoritmo mas eficiente

        * Error comun:
          - Olvidar incrementar el contador -> bucle infinito
          - Confundir > con >= (una iteracion de mas o de menos)
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
