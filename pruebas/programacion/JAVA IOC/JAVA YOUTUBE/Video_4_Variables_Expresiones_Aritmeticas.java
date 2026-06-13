/**
 * Video 4 - Variables y expresiones aritmeticas DAM - DAW
 * URL:          https://www.youtube.com/watch?v=pgF8U9WxPts&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=4
 * Canal:        Aula en la nube
 *               https://www.youtube.com/@aulaenlanube
 * Video:        Video 4 - Variables y expresiones aritmeticas
 * Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]
 *
 * Resumen:
 *   Cuarto video del curso. Se introducen las variables, los tipos de datos,
 *   las expresiones aritmeticas y las instrucciones basicas en pseudocodigo
 *   como paso previo a Java.
 *
 *   Temas que probablemente cubre:
 *   - Datos: concepto, tipos (numericos, logicos, caracteres)
 *   - Variables: declaracion, inicializacion, asignacion
 *   - Expresiones aritmeticas: operandos, operadores, precedencia
 *   - Instrucciones: secuenciales, de asignacion, de E/S
 *   - Operadores aritmeticos: +, -, *, /, modulo (%)
 *   - Jerarquia de operadores (precedencia)
 *   - Ejemplos de algoritmos con calculos aritmeticos
 *
 * Conceptos clave para el examen:
 *   - Dato: valor elemental que el ordenador procesa (numeros, texto, booleanos)
 *   - Tipos de datos: enteros (int), reales (double), booleanos (boolean), caracter (char)
 *   - Variable: espacio de memoria con nombre y tipo para almacenar datos
 *   - Declaracion de variable: especificar tipo y nombre (ej: int edad)
 *   - Inicializacion: dar un valor por primera vez a una variable
 *   - Asignacion: cambiar el valor de una variable (ej: edad = 18)
 *   - Expresion: combinacion de operandos y operadores que produce un valor
 *   - Expresion aritmetica: usa operadores matematicos (+, -, *, /, %)
 *   - Instruccion (sentencia): orden que ejecuta el ordenador
 *   - Tipos de instrucciones: asignacion, E/S (Leer/Escribir), condicional, iterativa
 *   - Instruccion de asignacion: variable = expresion
 *   - Instruccion de entrada: leer variable desde teclado
 *   - Instruccion de salida: mostrar resultado por pantalla
 *   - Precedencia de operadores: parentesis > multiplicacion/division/modulo > suma/resta
 *   - Contador: variable que incrementa en un valor constante (cont = cont + 1)
 *   - Acumulador: variable que acumula valores (suma = suma + valor)
 *
 * @author       Aula en la nube (YouTube)
 * @version      1.0
 * @since        2026-06-13
 */

public class Video_4_Variables_Expresiones_Aritmeticas {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "Video 4 - Variables y expresiones aritmeticas DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=pgF8U9WxPts&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=4";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    // -------------------------------------------------------------
    // Resumen en formato texto
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 4 - VARIABLES Y EXPRESIONES ARITMETICAS
        ================================================================

        Video:        Video 4 - Variables y expresiones aritmeticas
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]

        --- RESUMEN ---

        Cuarto video del curso. Se introducen variables, tipos de datos,
        expresiones aritmeticas e instrucciones basicas en pseudocodigo.

        Temas que probablemente cubre:
          1. Datos: concepto y tipos (numericos, logicos, caracteres)
          2. Variables: declaracion, inicializacion, asignacion
          3. Expresiones aritmeticas: operandos + operadores
          4. Instrucciones: secuenciales, asignacion, E/S
          5. Operadores: +, -, *, /, modulo (%)
          6. Jerarquia de operadores (precedencia)
          7. Ejemplos de algoritmos con calculos

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Dato -> Valor elemental que procesa el ordenador
          - Numericos: enteros (int), reales (double)
          - Logicos: booleano (true/false)
          - Caracteres: char (letras, digitos, simbolos)

        * Variable -> Espacio de memoria con nombre y tipo
          - Declaracion: tipo + nombre (ej: int edad)
          - Inicializacion: primer valor (ej: int edad = 0)
          - Asignacion: cambiar valor (ej: edad = 18)
          - Tipos segun uso: contadores, acumuladores, auxiliares

        * Expresion -> Combinacion de operandos y operadores
        * Expresion aritmetica -> Usa operadores matematicos
          - Operadores: +, -, *, /, % (modulo o resto)
          - Precedencia: () > *, /, % > +, -
          - Asociatividad: izquierda a derecha

        * Instruccion (sentencia) -> Orden que ejecuta el ordenador
          - Instruccion de asignacion: variable = expresion
          - Instruccion de entrada: Leer(variable)
          - Instruccion de salida: Escribir(expresion)
          - Instrucciones de control: condicionales y bucles

        * Contador -> variable = variable + 1 (incremento constante)
        * Acumulador -> variable = variable + valor (suma valores)
        * Intercambio (swap) -> usar variable auxiliar temporal
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
