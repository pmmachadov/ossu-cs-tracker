/**
 * Video 11 - Bucle REPETIR-MIENTRAS (DO-WHILE) en pseudocodigo DAM - DAW
 * URL:          https://www.youtube.com/watch?v=bRwz1J9hxEg&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=11
 * Canal:        Aula en la nube
 *               https://www.youtube.com/@aulaenlanube
 * Video:        Video 11 - Bucle REPETIR-MIENTRAS (DO-WHILE)
 * Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]
 *
 * Resumen basado en la transcripcion del video:
 *   Se explica la estructura repetitiva REPETIR-MIENTRAS (bucle do-while).
 *   La particularidad es que el cuerpo del bucle se ejecuta AL MENOS UNA VEZ,
 *   porque la condicion se comprueba al final.
 *
 *   Ejercicio resuelto:
 *   Sumar los n primeros numeros naturales, siendo n un numero mayor que 1.
 *   Ej: n=3 -> 3+2+1=6, n=5 -> 5+4+3+2+1=15
 *
 * Conceptos clave para el examen:
 *   - REPETIR-MIENTRAS: bucle de post-condicion (se ejecuta 1 o mas veces)
 *   - Sintaxis: Repetir ... Hasta Que (condicion)  o  Repetir ... Mientras (condicion)
 *   - La condicion se evalua al final, a diferencia del MIENTRAS que evalua al inicio
 *   - Diferencia con MIENTRAS: MIENTRAS puede ejecutarse 0 veces; REPETIR siempre al menos 1
 *   - Contador: variable que se incrementa en cada iteracion
 *   - Acumulador (suma): variable que guarda la suma parcial
 *   - Traza de ejecucion: seguir valores de las variables paso a paso
 *
 * @author       Aula en la nube (YouTube)
 * @version      1.0
 * @since        2026-06-13
 */

class Video_11_Bucle_Repetir_Mientras {

    public static final String TITULO = "Video 11 - Bucle REPETIR-MIENTRAS (DO-WHILE) en pseudocodigo DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=bRwz1J9hxEg&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=11";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 11 - BUCLE REPETIR-MIENTRAS (DO-WHILE)
        ================================================================

        Video:        Video 11 - Bucle REPETIR-MIENTRAS
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]

        --- ESTRUCTURA REPETIR-MIENTRAS ---

        El bucle REPETIR-MIENTRAS tiene la particularidad de que el
        cuerpo del bucle se ejecuta COMO MINIMO UNA VEZ, porque la
        condicion se comprueba al final.

        Sintaxis en pseudocodigo:
            Repetir
              instruccion1
              instruccion2
              ...
            Hasta Que (condicion)

        O tambien:
            Repetir
              instrucciones
            Mientras (condicion)

        En Java: do { instrucciones } while (condicion);

        --- DIFERENCIA CON MIENTRAS ---

        MIENTRAS:      condicion al INICIO -> 0 o mas veces
        REPETIR:       condicion al FINAL  -> 1 o mas veces

        --- EJERCICIO: SUMAR LOS N PRIMEROS NUMEROS NATURALES ---

        Enunciado: Crear un algoritmo que sume los n primeros numeros
        naturales, siendo n un numero mayor que 1.
        Ej: n=3 -> 1+2+3=6, n=5 -> 1+2+3+4+5=15

        Algoritmo CalculaSuma
          Definir n, contador, suma Como Entero

          Escribir("Introduce un numero:")
          Leer(n)

          contador <- 1
          suma <- 0

          Repetir
            suma <- suma + contador
            contador <- contador + 1
          Hasta Que (contador > n)

          Escribir("La suma de los ", n, " primeros numeros es: ", suma)
        FinAlgoritmo

        --- TRAZA DE EJECUCION (n=5) ---

        | Iteracion | contador (ini) | suma (ini) | suma <- suma+cont | cont++ | contador (fin) | Condicion (cont > n) |
        |-----------|----------------|------------|-------------------|--------|----------------|---------------------|
        | Inicio    |       1        |     0      |        -          |   -    |       -        |          -          |
        | 1a        |       1        |     0      |    0+1 = 1        | 1->2   |       2        |    2>5? false       |
        | 2a        |       2        |     1      |    1+2 = 3        | 2->3   |       3        |    3>5? false       |
        | 3a        |       3        |     3      |    3+3 = 6        | 3->4   |       4        |    4>5? false       |
        | 4a        |       4        |     6      |    6+4 = 10       | 4->5   |       5        |    5>5? false       |
        | 5a        |       5        |    10      |   10+5 = 15       | 5->6   |       6        |    6>5? TRUE -> sale|
        | Salida    |       -        |     -      |        -          |   -    |       -        |  Resultado: 15     |

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * REPETIR-MIENTRAS -> bucle de post-condicion (1 o mas veces)
        * La condicion se evalua al FINAL del bucle
        * Diferencia con MIENTRAS:
          - MIENTRAS: condicion al inicio -> puede ejecutarse 0 veces
          - REPETIR: condicion al final -> siempre al menos 1 vez
        * Contador -> variable que se incrementa (cont <- cont + 1)
        * Acumulador (suma) -> variable que acumula total (suma <- suma + valor)
        * Condicion de salida tipica: Hasta Que (contador > n)
        * La traza ayuda a entender cuantas veces se ejecuta el bucle
        * En el ejercicio: si n=5, el bucle da 5 vueltas (contador 1 a 5)
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
