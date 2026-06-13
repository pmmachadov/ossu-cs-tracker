/**
 * Video 6 - Introduccion a la programacion: operadores logicos DAM - DAW
 * URL:          https://www.youtube.com/watch?v=GwwRkMo012Y&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=6
 * Canal:        Aula en la nube
 *               https://www.youtube.com/@aulaenlanube
 * Video:        Video 6 - Operadores logicos
 * Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]
 *
 * Resumen:
 *   Sexto video del curso. Profundiza en los operadores logicos (AND, OR, NOT),
 *   sus tablas de verdad, propiedades y aplicaciones en condiciones compuestas.
 *
 *   Temas que probablemente cubre:
 *   - Repaso de operadores logicos: AND (Y), OR (O), NOT (NO)
 *   - Tablas de verdad detalladas
 *   - Condiciones compuestas con multiples operadores
 *   - Evaluacion en cortocircuito (short-circuit)
 *   - Leyes de De Morgan
 *   - Prioridad y uso de parentesis en expresiones logicas
 *   - Ejemplos practicos: rangos de valores, validaciones, logica inversa
 *   - Diferencia entre condiciones mutuamente excluyentes y solapadas
 *
 * Conceptos clave para el examen:
 *   - Operador logico AND (Y): verdad solo si ambas condiciones son verdaderas
 *   - Operador logico OR (O): verdad si al menos una condicion es verdadera
 *   - Operador logico NOT (NO): invierte el valor booleano
 *   - Tabla de verdad AND: V^V=V, V^F=F, F^V=F, F^F=F
 *   - Tabla de verdad OR: VvV=V, VvF=V, FvV=V, FvF=F
 *   - Tabla de verdad NOT: ~V=F, ~F=V
 *   - Evaluacion en cortocircuito (short-circuit):
 *     AND: si la primera condicion es false, la segunda no se evalua
 *     OR: si la primera condicion es true, la segunda no se evalua
 *   - Leyes de De Morgan:
 *     NOT (A AND B) = (NOT A) OR (NOT B)
 *     NOT (A OR B) = (NOT A) AND (NOT B)
 *   - Propiedades: conmutativa, asociativa, distributiva, elemento neutro
 *   - Prioridad: NOT > AND > OR (usar parentesis para cambiar)
 *   - Rango: if (x > 0 AND x < 100) es equivalente a x en (0,100)
 *   - Condiciones excluyentes vs incluyentes con OR
 *
 * @author       Aula en la nube (YouTube)
 * @version      1.0
 * @since        2026-06-13
 */

public class Video_6_Operadores_Logicos {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "Video 6 - Introduccion a la programacion: operadores logicos DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=GwwRkMo012Y&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=6";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    // -------------------------------------------------------------
    // Resumen en formato texto
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 6 - OPERADORES LOGICOS
        ================================================================

        Video:        Video 6 - Operadores logicos
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]

        --- RESUMEN ---

        Sexto video del curso. Profundiza en los operadores logicos,
        sus tablas de verdad, propiedades y aplicaciones practicas
        en condiciones compuestas.

        Temas que probablemente cubre:
          1. Operadores logicos: AND (Y), OR (O), NOT (NO)
          2. Tablas de verdad detalladas
          3. Condiciones compuestas con multiples operadores
          4. Evaluacion en cortocircuito (short-circuit)
          5. Leyes de De Morgan
          6. Prioridad y uso de parentesis
          7. Ejemplos: rangos, validaciones, logica inversa
          8. Condiciones excluyentes vs solapadas

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * AND (Y / && en Java) -> Verdad solo si ambas son verdaderas
        * OR  (O / || en Java) -> Verdad si al menos una es verdadera
        * NOT (NO / ! en Java) -> Invierte el valor booleano

        * Tablas de verdad:
          - true  AND true  = true   | true  OR true  = true  | NOT true  = false
          - true  AND false = false  | true  OR false = true  | NOT false = true
          - false AND true  = false  | false OR true  = true
          - false AND false = false  | false OR false = false

        * Evaluacion en cortocircuito:
          - AND: si la primera condicion es false, la segunda NO se evalua
          - OR:  si la primera condicion es true, la segunda NO se evalua
          - Ventaja: evita errores y mejora rendimiento

        * Leyes de De Morgan (muy importante para examenes):
          - NOT (A AND B) = (NOT A) OR (NOT B)
            Ej: "No es mayor de edad y tiene carnet" equivale a
                "Es menor de edad O no tiene carnet"
          - NOT (A OR B) = (NOT A) AND (NOT B)

        * Prioridad de operadores (de mayor a menor):
          1. Parentesis ()
          2. NOT
          3. AND
          4. OR

        * Propiedades de los operadores logicos:
          - Conmutativa: A AND B = B AND A
          - Asociativa: (A AND B) AND C = A AND (B AND C)
          - Distributiva: A AND (B OR C) = (A AND B) OR (A AND C)
          - Elemento neutro: A AND true = A; A OR false = A

        * Ejemplo tipico de rango:
          if (x > 0 AND x < 100) -> x esta entre 1 y 99
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
