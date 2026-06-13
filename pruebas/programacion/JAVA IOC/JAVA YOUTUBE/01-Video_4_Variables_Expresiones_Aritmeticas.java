

class Video_4_Variables_Expresiones_Aritmeticas {

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
