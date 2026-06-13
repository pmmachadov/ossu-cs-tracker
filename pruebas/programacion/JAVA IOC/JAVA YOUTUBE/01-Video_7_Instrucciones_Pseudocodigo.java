/**
 * Video 7 - Instrucciones en pseudocodigo DAM - DAW
 * URL:          https://www.youtube.com/watch?v=taSJeALBVGk&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=7
 * Canal:        Aula en la nube
 *               https://www.youtube.com/@aulaenlanube
 * Video:        Video 7 - Instrucciones en pseudocodigo
 * Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]
 *
 * Resumen basado en la transcripcion del video:
 *   Clasificacion de los distintos tipos de instrucciones en pseudocodigo:
 *   declarativas, primitivas (entrada, salida, asignacion) y de control.
 *   Se explica la sintaxis de cada una con ejemplos.
 *
 *   Ejercicios resueltos:
 *   1) Algoritmo que dada una distancia en millas marinas, la escribe en metros
 *      (1 milla marina = 1852 metros)
 *   2) Algoritmo que dado precio y porcentaje de descuento, escribe el precio pagado
 *
 * Conceptos clave para el examen:
 *   - Instrucciones declarativas: declarar variables/constantes con nombre y tipo
 *   - Instrucciones primitivas: leer (entrada), escribir (salida), asignacion
 *   - Instrucciones de control: alteran el orden de ejecucion (SI, MIENTRAS, etc.)
 *   - Leer(): primitiva de entrada, guarda datos desde teclado en variables
 *   - Escribir(): primitiva de salida, muestra datos por pantalla
 *   - Asignacion: guarda el resultado de una expresion en una variable
 *   - Concatenacion con +: se pueden unir textos y variables en Escribir()
 *   - Indentacion (tabulacion): obligatoria para claridad del codigo
 *   - Palabras clave en mayusculas: Algoritmo, Definir, Leer, Escribir, etc.
 *
 * @author       Aula en la nube (YouTube)
 * @version      1.0
 * @since        2026-06-13
 */

class Video_7_Instrucciones_Pseudocodigo {

    public static final String TITULO = "Video 7 - Instrucciones en pseudocodigo DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=taSJeALBVGk&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=7";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 7 - INSTRUCCIONES EN PSEUDOCODIGO
        ================================================================

        Video:        Video 7 - Tipos de instrucciones en pseudocodigo
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]

        --- CLASIFICACION DE INSTRUCCIONES ---

        1. DECLARATIVAS -> Declarar variables y constantes
           Formato: Definir nombreVariable, ... Como Tipo
           Tipos: Entero, Real, Texto, Booleano
           Ej: Definir base, altura, area Como Entero

        2. PRIMITIVAS -> Se ejecutan de forma inmediata
           a) Entrada: Leer(variable) - captura datos desde teclado
           b) Salida: Escribir(expresion) - muestra por pantalla
           c) Asignacion: variable <- expresion o valor constante

        3. CONTROL -> Alteran el orden de ejecucion
           - Alternativas: Si-Entonces-Sino
           - Repetitivas: Mientras, Repetir, Para

        --- CONCATENACION EN Escribir() ---
        Se usa el operador + para unir texto literal y variables:
        Escribir("El resultado de la suma es " + resultado)
        - Lo que va entre comillas se muestra literal
        - La variable se sustituye por su valor

        --- EJERCICIO 1: MILLAS MARINAS A METROS ---

        Algoritmo CalcularMillas
          Definir millas, metros Como Entero
          Escribir("Introduce el numero de millas:")
          Leer(millas)
          metros <- millas * 1852
          Escribir("Metros: " + metros)
        FinAlgoritmo

        Entrada: 3
        Proceso: 3 * 1852 = 5556
        Salida: Metros: 5556

        --- EJERCICIO 2: PRECIO CON DESCUENTO ---

        Algoritmo CalcularDescuento
          Definir tarifa, porcentaje, precioPagado Como Entero
          Escribir("Introduce tarifa y porcentaje:")
          Leer(tarifa, porcentaje)
          precioPagado <- tarifa - (tarifa * porcentaje / 100)
          Escribir("El precio a pagar es: " + precioPagado)
        FinAlgoritmo

        Entrada: tarifa=1000, porcentaje=15
        Proceso: 1000 - (1000*15/100) = 1000 - 150 = 850
        Salida: El precio a pagar es: 850

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Instrucciones declarativas -> Definir variables con nombre y tipo
        * Leer() -> entrada de datos desde teclado
        * Escribir() -> salida de datos por pantalla
        * Asignacion (<-) -> guardar valor o expresion en variable
        * Concatenacion con + -> unir texto y variables en Escribir()
        * Palabras clave en MAYUSCULAS en pseudocodigo
        * Indentacion obligatoria para claridad
        * 1 milla marina = 1852 metros
        * Descuento: precioFinal = precioOriginal - (precioOriginal * %descuento / 100)
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
