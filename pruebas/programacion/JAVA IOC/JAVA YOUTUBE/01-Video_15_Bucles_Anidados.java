

class Video_15_Bucles_Anidados {

    public static final String TITULO = "Video 15 - Bucles anidados en pseudocodigo DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=V-WDyYJqPnY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=15";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 15 - BUCLES ANIDADOS
        ================================================================

        Video:        Video 15 - Bucles anidados (seguimiento)
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]

        --- ALGORITMO BASE (bucles anidados) ---

        Algoritmo BuclesAnidados
          Definir i, j Como Entero
          i <- 4

          Mientras (i >= 0) Hacer         // bucle EXTERNO: 5 iteraciones (4,3,2,1,0)
            j <- i
            Mientras (j >= 0) Hacer       // bucle INTERNO: escribe desde j hasta 0
              Escribir(j)
              j <- j - 1
            FinMientras
            Escribir(salto_de_linea)      // salta a siguiente fila
            i <- i - 1
          FinMientras
        FinAlgoritmo

        --- SALIDA DEL ALGORITMO BASE ---

        i=4:  4 3 2 1 0
        i=3:  3 2 1 0
        i=2:  2 1 0
        i=1:  1 0
        i=0:  0

        Explicacion:
        - El bucle EXTERNO se ejecuta para i = 4, 3, 2, 1, 0 (5 vueltas)
        - En CADA vuelta del externo, se ejecuta el bucle INTERNO completo
        - El interno escribe desde el valor actual de i hasta 0
        - Despues del interno, se hace un salto de linea y se decrementa i

        --- MODIFICACION 1: i > 0 (externo cambia) ---

        Condicion externa: Mientras (i > 0)
        - El bucle externo da 4 iteraciones (i=4,3,2,1)
        - Desaparece la ultima linea (solo 0)
        Salida:
          4 3 2 1 0
          3 2 1 0
          2 1 0
          1 0

        --- MODIFICACION 2: j > 0 (interno cambia) ---

        Condicion interna: Mientras (j > 0)
        - Cada bucle interno da una vuelta menos (no imprime el 0)
        - Pero el externo sigue dando 5 vueltas, por lo que hay 5 saltos de linea
        Salida:
          4 3 2 1
          3 2 1
          2 1
          1

          (una linea vacia al final)

        --- MODIFICACION 3: i > 0 Y j > 0 (ambos cambian) ---

        - Externo: 4 iteraciones (i=4,3,2,1)
        - Interno en cada una: no imprime el 0
        Salida:
          4 3 2 1
          3 2 1
          2 1
          1

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Bucle anidado -> un bucle DENTRO de otro bucle
        * El bucle INTERNO se ejecuta COMPLETO por cada iteracion del EXTERNO
        * El externo controla las FILAS; el interno controla las COLUMNAS
        * Para hacer la traza:
          1. Fijarse en la iteracion actual del bucle externo
          2. Ejecutar el bucle interno completo para ese valor
          3. Anotar la salida generada
          4. Pasar a la siguiente iteracion del externo
        * Cambiar >= por > elimina la ultima iteracion (cuando la variable es 0)
        * Importante: el salto de linea se ejecuta SIEMPRE al terminar el interno
        * Los bucles anidados son muy usados para recorrer matrices/tablas
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
