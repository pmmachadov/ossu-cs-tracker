/**
 * Video 13 - Ejercicios de repaso: bucles, condicionales y acumuladores DAM - DAW
 * URL:          https://www.youtube.com/watch?v=3FIomL6wFFM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=13
 * Canal:        Aula en la nube
 *               https://www.youtube.com/@aulaenlanube
 * Video:        Video 13 - Ejercicios de repaso
 * Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]
 *
 * Resumen basado en la transcripcion del video:
 *   Tres ejercicios de repaso para asimilar bucles, condicionales y acumuladores.
 *
 *   Ejercicios:
 *   1) Sumar los numeros pares entre 1 y 10 (2+4+6+8+10=30). Dos soluciones:
 *      - Con SI + MIENTRAS (recorre 1..10, comprueba MOD)
 *      - Mas eficiente: MIENTRAS con incremento de 2 en 2 (sin IF)
 *   2) Leer puntuaciones hasta cero, multiplicando por 0.3 si estan entre
 *      2000-3000, o por 0.2 si no, acumulando el total
 *   3) Calcular el factorial de un numero (ej: 5! = 5*4*3*2*1 = 120)
 *
 * Conceptos clave para el examen:
 *   - Acumulador: variable que acumula resultados (suma, producto, total)
 *   - Eficiencia: evitar iteraciones/condiciones innecesarias
 *   - Incremento de 2 en 2 para saltar pares/impares
 *   - AND (Y) para rangos: condicion1 Y condicion2
 *   - Factorial: producto de todos los enteros desde N hasta 1
 *   - Decremento: contador = contador - 1 (para recorrer hacia atras)
 *   - Bucle PARA como alternativa al MIENTRAS
 *
 * @author       Aula en la nube (YouTube)
 * @version      1.0
 * @since        2026-06-13
 */

public class Video_13_Ejercicios_Repaso {

    public static final String TITULO = "Video 13 - Ejercicios de repaso: bucles, condicionales y acumuladores DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=3FIomL6wFFM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=13";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 13 - EJERCICIOS DE REPASO
        ================================================================

        Video:        Video 13 - Ejercicios de repaso
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]

        --- EJERCICIO 1: SUMAR NUMEROS PARES DEL 1 AL 10 ---

        Solucion A (con SI dentro del bucle, menos eficiente):

        Algoritmo CalculaSumaPares1
          Definir contador, suma Como Entero
          contador <- 2
          suma <- 0

          Mientras (contador <= 10) Hacer
            Si (contador MOD 2 = 0) Entonces
              suma <- suma + contador
            FinSi
            contador <- contador + 1
          FinMientras

          Escribir("La suma de los pares es: ", suma)
        FinAlgoritmo

        Solucion B (incremento de 2 en 2, mas eficiente):

        Algoritmo CalculaSumaPares2
          Definir contador, suma Como Entero
          contador <- 2
          suma <- 0

          Mientras (contador <= 10) Hacer
            suma <- suma + contador
            contador <- contador + 2
          FinMientras

          Escribir("La suma de los pares es: ", suma)
        FinAlgoritmo

        Solucion C (con bucle PARA):

        Algoritmo CalculaSumaPares3
          Definir contador, suma Como Entero
          suma <- 0

          Para (contador <- 2; contador <= 10; contador <- contador + 2)
            suma <- suma + contador
          FinPara

          Escribir("La suma de los pares es: ", suma)
        FinAlgoritmo

        Resultado: 2+4+6+8+10 = 30

        --- EJERCICIO 2: PUNTUACIONES CON DESCUENTO ---

        Leer puntuaciones hasta cero. Si la puntuacion esta entre 2000 y 3000
        (ambas incluidas), se multiplica por 0.3; si no, por 0.2. Se acumula
        el total.

        Algoritmo CalcularPuntuacion
          Definir puntuacion, total Como Entero
          total <- 0

          Escribir("Introduce puntuaciones (0 para terminar):")
          Leer(puntuacion)

          Mientras (puntuacion <> 0) Hacer
            Si (puntuacion >= 2000 Y puntuacion <= 3000) Entonces
              total <- total + puntuacion * 0.3
            Sino
              total <- total + puntuacion * 0.2
            FinSi
            Leer(puntuacion)
          FinMientras

          Escribir("La puntuacion total es: ", total)
        FinAlgoritmo

        Ejemplo: 1000 -> 1000*0.2 = 200, total=200
                 2000 -> 2000*0.3 = 600, total=800
                 3000 -> 3000*0.3 = 900, total=1700
                 0    -> termina
        Resultado: 1700

        --- EJERCICIO 3: FACTORIAL DE UN NUMERO ---

        El factorial de N (N!) es el producto de todos los enteros desde N
        hasta 1. Ej: 5! = 5*4*3*2*1 = 120

        Solucion A (con MIENTRAS y contador decreciente):

        Algoritmo Factorial
          Definir num, contador, factorial Como Entero
          Escribir("Introduce un numero:")
          Leer(num)
          factorial <- 1
          contador <- num

          Mientras (contador >= 1) Hacer
            factorial <- factorial * contador
            contador <- contador - 1
          FinMientras

          Escribir("El factorial de ", num, " es: ", factorial)
        FinAlgoritmo

        Solucion B (evitando la multiplicacion por 1):

        Algoritmo FactorialMejorado
          Definir num, contador, factorial Como Entero
          Escribir("Introduce un numero:")
          Leer(num)
          factorial <- 1
          contador <- num

          Mientras (contador > 1) Hacer
            factorial <- factorial * contador
            contador <- contador - 1
          FinMientras

          Escribir("El factorial de ", num, " es: ", factorial)
        FinAlgoritmo

        Solucion C (con bucle PARA):

        Algoritmo FactorialPara
          Definir num, contador, factorial Como Entero
          Escribir("Introduce un numero:")
          Leer(num)
          factorial <- 1

          Para (contador <- num; contador > 1; contador <- contador - 1)
            factorial <- factorial * contador
          FinPara

          Escribir("El factorial de ", num, " es: ", factorial)
        FinAlgoritmo

        Traza para num=5:
        | Iterac. | contador | factorial (ini=1) | factorial*cont | decremento |
        |---------|----------|-------------------|----------------|------------|
        | Inicio  |    5     |        1          |       -        |     -      |
        | 1a      |    5     |        1          |    1*5 = 5     |  5->4      |
        | 2a      |    4     |        5          |    5*4 = 20    |  4->3      |
        | 3a      |    3     |       20          |   20*3 = 60    |  3->2      |
        | 4a      |    2     |       60          |   60*2 = 120   |  2->1      |
        | Salida  |    1     |      120          |  (cond false)  |     -      |

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Eficiencia en bucles: evitar condicionales innecesarios dentro
          del bucle (ej: incrementar de 2 en 2 en vez de comprobar MOD)
        * Acumulador: variable que guarda sumas o productos parciales
        * Producto acumulado se inicializa a 1 (no a 0)
        * Rango con AND: (x >= min Y x <= max)
        * Factorial: N! = N * (N-1) * (N-2) * ... * 1
        * Decremento: contador = contador - 1 (recorrer hacia atras)
        * La ultima multiplicacion por 1 es innecesaria
        * Bucle PARA es equivalente a MIENTRAS pero mas compacto
        * La clave para aprender a programar es practicar y resolver
          problemas propios, no solo ver soluciones de otros
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
