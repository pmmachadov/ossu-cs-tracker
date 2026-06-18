

class Video_3_Representacion_Algoritmos {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "Video 3 - Representacion de algoritmos DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=b003s0CJ2KU&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=3";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

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
