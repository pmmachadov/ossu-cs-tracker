

class Video_12_Bucle_Para {

    public static final String TITULO = "Video 12 - Bucle PARA (FOR) en pseudocodigo DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=ijz6rAu5Trw&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=12";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 12 - BUCLE PARA (FOR)
        ================================================================

        Video:        Video 12 - Bucle PARA (FOR)
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]

        --- ESTRUCTURA DEL BUCLE PARA ---

        El bucle PARA es una forma abreviada del bucle MIENTRAS.
        En una sola linea se incluyen tres partes separadas por punto y coma:

            Para (inicializacion; condicion; incremento)
              instrucciones
            FinPara

        Equivalencia con MIENTRAS:
            inicializacion
            Mientras (condicion) Hacer
              instrucciones
              incremento
            FinMientras

        Orden de ejecucion:
          1. Inicializacion (se ejecuta UNA SOLA VEZ al entrar)
          2. Se evalua la condicion
          3. Si true -> se ejecutan las instrucciones del cuerpo
          4. Se ejecuta el incremento
          5. Vuelve al paso 2
          6. Si false -> sale del bucle

        --- EJERCICIO: CALCULAR PRODUCTO DE 5 NUMEROS ---

        Enunciado: Disenar un algoritmo que lea cinco valores numericos
        y calcule su producto, utilizando un bucle PARA.

        Solucion 1 (contador empieza en 1, condicion <= 5):

        Algoritmo CalculaProducto1
          Definir num, producto, contador Como Entero
          producto <- 1

          Para (contador <- 1; contador <= 5; contador <- contador + 1)
            Leer(num)
            producto <- producto * num
          FinPara

          Escribir("El producto de los cinco numeros es: ", producto)
        FinAlgoritmo

        Solucion 2 (contador empieza en 0, condicion < 5):

        Algoritmo CalculaProducto2
          Definir num, producto, contador Como Entero
          producto <- 1

          Para (contador <- 0; contador < 5; contador <- contador + 1)
            Leer(num)
            producto <- producto * num
          FinPara

          Escribir("El producto de los cinco numeros es: ", producto)
        FinAlgoritmo

        --- TRAZA DE EJECUCION (Solucion 1, entrada: 3,5,2,7,2) ---

        | Iterac. | contador | condicion (<=5) | num (leido) | producto (inicial=1) |
        |---------|----------|-----------------|-------------|----------------------|
        | Inicio  |    1     |       -         |      -      |          1           |
        | 1a      |    1     |    1<=5 = true  |      3      |    1*3 = 3           |
        | 2a      |    2     |    2<=5 = true  |      5      |    3*5 = 15          |
        | 3a      |    3     |    3<=5 = true  |      2      |   15*2 = 30          |
        | 4a      |    4     |    4<=5 = true  |      7      |   30*7 = 210         |
        | 5a      |    5     |    5<=5 = true  |      2      |  210*2 = 420         |
        | Salida  |    6     |   6<=5 = false  |      -      |  Resultado: 420     |

        --- DIFERENCIA ENTRE LAS DOS SOLUCIONES ---

        Solucion 1: contador = 1; condicion: contador <= 5 (5 vueltas)
        Solucion 2: contador = 0; condicion: contador < 5  (5 vueltas)

        Las dos hacen 5 iteraciones. La solucion 2 es mas habitual
        en programacion (empezar en 0, usar < en vez de <=).

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Bucle PARA (FOR) -> estructura repetitiva con contador
        * Sintaxis: Para (inicializacion; condicion; incremento)
        * Equivalente a MIENTRAS pero mas compacto y legible
        * Se usa cuando se sabe de antemano el numero de iteraciones
        * Inicializacion se ejecuta UNA SOLA VEZ
        * Incremento se ejecuta al FINAL de cada iteracion
        * Dos formas comunes:
          - Para (i=1; i<=N; i++) -> N iteraciones
          - Para (i=0; i<N; i++)  -> N iteraciones (mas usada en Java)
        * Producto acumulado se inicializa a 1 (no a 0)
        * En Java: for (int i=0; i<5; i++) { instrucciones }
        * El PARA es el bucle mas utilizado en programacion
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
