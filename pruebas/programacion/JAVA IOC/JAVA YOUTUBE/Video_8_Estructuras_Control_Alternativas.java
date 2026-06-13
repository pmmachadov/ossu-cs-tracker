/**
 * Video 8 - Estructuras de control alternativas pseudocodigo (SI - IFS) DAM - DAW
 * URL:          https://www.youtube.com/watch?v=tldDbZ9MSoA&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=8
 * Canal:        Aula en la nube
 *               https://www.youtube.com/@aulaenlanube
 * Video:        Video 8 - Estructuras de control alternativas (SI - IFS)
 * Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]
 *
 * Resumen basado en la transcripcion del video:
 *   Se explican las estructuras de control de tipo alternativo (condicionales):
 *   SI simple, SI-SINO (doble), y SI anidados. Se recalca la importancia de
 *   la indentacion (tabulacion) del codigo dentro de cada estructura.
 *
 *   Ejercicios resueltos:
 *   1) Determinar si un numero es par o impar (usando MOD)
 *   2) Determinar si un numero N es divisible por M
 *   3) Leer dos valores X e Y, determinar si son iguales y si no, cual es mayor
 *
 * Conceptos clave para el examen:
 *   - Estructura de control: evalua una expresion logica y segun el resultado
 *     ejecuta unas instrucciones u otras
 *   - Indentacion (tabulacion): obligatoria, el codigo dentro de una estructura
 *     debe ir tabulado para saber que instrucciones pertenecen a cada condicion
 *   - SI simple: si condicion verdadera -> ejecuta instrucciones; si no, las salta
 *   - SI-SINO (doble): si verdad -> bloque verdad; si falso -> bloque sino
 *   - SI anidados: un SI dentro de otro SI (o dentro de un SINO)
 *   - MOD (resto): operador para obtener el resto de una division entera
 *   - Concatenacion con coma: se puede concatenar texto y variables separando con comas
 *   - Operador = en pseudocodigo: se usa = para comparar (en Java es ==)
 *
 * @author       Aula en la nube (YouTube)
 * @version      1.0
 * @since        2026-06-13
 */

public class Video_8_Estructuras_Control_Alternativas {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "Video 8 - Estructuras de control alternativas pseudocodigo (SI - IFS) DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=tldDbZ9MSoA&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=8";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    // -------------------------------------------------------------
    // Resumen en formato texto
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 8 - ESTRUCTURAS DE CONTROL ALTERNATIVAS (SI - IFS)
        ================================================================

        Video:        Video 8 - Estructuras de control alternativas (SI)
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]

        --- RESUMEN (transcripcion) ---

        Se explican las estructuras de control alternativas: SI simple,
        SI-SINO (doble) y SI anidados. La indentacion es obligatoria
        para saber que instrucciones pertenecen a cada condicion.

        Tres tipos de estructuras alternativas:
          - Simple: solo ejecuta codigo si la condicion es verdadera
          - Doble (SI-SINO): ejecuta un bloque si verdad, otro si falso
          - Anidada: un SI dentro de otro SI o dentro de un SINO

        --- ESTRUCTURAS EN PSEUDOCODIGO ---

        * SI simple:
            Si (condicion) Entonces
              instruccion1
              instruccion2
            FinSi
            instruccion3   <- se ejecuta siempre

        * SI-SINO (doble):
            Si (condicion) Entonces
              instruccion1
              instruccion2
            Sino
              instruccion3
            FinSi
            instruccion4   <- se ejecuta siempre

        * SI anidados:
            Si (condicion1) Entonces
              instrucciones_si_verdadero
            Sino
              Si (condicion2) Entonces
                instrucciones_si_cond2_verdad
              Sino
                instrucciones_si_ambas_falsas
              FinSi
            FinSi

        --- EJERCICIO 1: NUMERO PAR O IMPAR ---

        Algoritmo ParOImpar
          Definir num Como Entero
          Escribir("Introduce un numero:")
          Leer(num)

          Si (num MOD 2 = 0) Entonces
            Escribir("El numero ", num, " es par")
          Sino
            Escribir("El numero ", num, " es impar")
          FinSi
        FinAlgoritmo

        * Explicacion: MOD 2 devuelve el resto de dividir entre 2
          - Si resto = 0 -> numero par
          - Si resto = 1 -> numero impar

        --- EJERCICIO 2: NUMERO DIVISIBLE POR OTRO ---

        Algoritmo Divisible
          Definir n, m Como Entero
          Escribir("Introduce n y m:")
          Leer(n)
          Leer(m)

          Si (n MOD m = 0) Entonces
            Escribir("El numero ", n, " es divisible entre ", m)
          Sino
            Escribir("El numero ", n, " no es divisible entre ", m)
          FinSi
        FinAlgoritmo

        * Explicacion: si n MOD m = 0 -> division exacta -> divisible

        --- EJERCICIO 3: IGUALDAD Y MAYOR DE DOS NUMEROS ---

        Algoritmo CompararNumeros
          Definir num1, num2 Como Entero
          Escribir("Introduce dos numeros:")
          Leer(num1)
          Leer(num2)

          Si (num1 = num2) Entonces
            Escribir(num1, " = ", num2)
          Sino
            Si (num1 > num2) Entonces
              Escribir(num1, " es mayor que ", num2)
            Sino
              Escribir(num1, " es menor que ", num2)
            FinSi
          FinSi
        FinAlgoritmo

        * Explicacion: SI anidado dentro de SINO
          - Primero comprueba si son iguales
          - Si no lo son, comprueba cual es mayor

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Estructura de control -> evalua expresion logica y ejecuta
          instrucciones segun el resultado (verdadero/falso)

        * Indentacion (tabulacion) -> OBLIGATORIA en pseudocodigo
          El codigo dentro de SI, SINO, MIENTRAS, etc. debe ir tabulado

        * SI simple -> solo ejecuta si la condicion es verdadera
        * SI-SINO -> ejecuta un bloque u otro segun la condicion
        * SI anidados -> condiciones dentro de condiciones

        * MOD (resto de division entera) -> util para saber si un
          numero es divisible por otro (resto = 0)

        * Concatenacion con comas -> se pueden concatenar textos
          y variables: Escribir("texto", variable, "otro texto")

        * Pseudocodigo usa = para comparar (en Java seria ==)
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
