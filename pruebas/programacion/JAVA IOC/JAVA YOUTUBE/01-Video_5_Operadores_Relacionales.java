

class Video_5_Operadores_Relacionales {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "Video 5 - Introduccion a la programacion: operadores relacionales DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=98m39gc3YpM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=5";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    // -------------------------------------------------------------
    // Resumen en formato texto
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 5 - OPERADORES RELACIONALES
        ================================================================

        Video:        Video 5 - Operadores relacionales
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ]

        --- RESUMEN ---

        Quinto video del curso. Introduce los operadores relacionales
        (comparacion) y logicos, fundamentales para crear condiciones
        en los algoritmos.

        Temas que probablemente cubre:
          1. Operadores relacionales: >, <, >=, <=, ==, !=
          2. Expresiones relacionales -> resultado booleano
          3. Diferencia entre = (asignar) y == (comparar)
          4. Condiciones simples y compuestas
          5. Operadores logicos: Y (AND), O (OR), NO (NOT)
          6. Tablas de verdad
          7. Precedencia combinada de operadores
          8. Evaluacion en cortocircuito

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Operador relacional -> Compara dos valores
          - >  mayor que
          - <  menor que
          - >= mayor o igual que
          - <= menor o igual que
          - == igual que (comparacion)
          - != distinto de

        * Expresion relacional -> Devuelve true o false
        * Condicion -> Expresion usada en decisiones (if)

        * Operadores logicos (combinan condiciones):
          - Y (AND) -> verdad solo si ambas son verdad
          - O (OR)  -> verdad si al menos una es verdad
          - NO (NOT) -> invierte el valor booleano

        * Tablas de verdad:
          - true Y true = true   | true O true = true   | NO true = false
          - true Y false = false | true O false = true  | NO false = true
          - false Y true = false | false O true = true
          - false Y false = false| false O false = false

        * Precedencia (de mayor a menor):
          1. Parentesis ()
          2. Aritmeticos (+, -, *, /, %)
          3. Relacionales (>, <, >=, <=, ==, !=)
          4. NO (NOT)
          5. Y (AND)
          6. O (OR)

        * Evaluacion en cortocircuito:
          - En AND, si la primera condicion es false, la segunda no se evalua
          - En OR, si la primera condicion es true, la segunda no se evalua

        * Cuidado: = es asignacion, == es comparacion
        * Tipico: if (nota >= 5) -> "Aprobado" else "Suspenso"
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
