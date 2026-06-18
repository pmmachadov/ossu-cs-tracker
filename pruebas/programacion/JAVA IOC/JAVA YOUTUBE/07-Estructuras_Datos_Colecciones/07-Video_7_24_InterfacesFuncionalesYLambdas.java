import java.time.LocalTime;

class Video_7_24_InterfacesFuncionalesYLambdas {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "7-24 JAVA: Interfaces funcionales y lambdas DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=w-mff14ooOg&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=165";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-24 - INTERFACES FUNCIONALES Y LAMBDAS
        ================================================================

        Video:        7-24 JAVA: Interfaces funcionales y lambdas
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7

        --- RESUMEN (transcripcion) ---

        Introduccion a la programacion funcional en Java.
        Interfaces funcionales + expresiones lambda.

        --- INTERFAZ FUNCIONAL ---

        Una interfaz funcional tiene UN SOLO metodo abstracto.
        Se puede anotar con @FunctionalInterface (opcional pero recomendado).

        Ejemplo:
          @FunctionalInterface
          interface Calculadora {
              int operacion(int a, int b);
          }

          @FunctionalInterface
          interface Saludador {
              void saludo();
          }

        --- EXPRESIONES LAMBDA ---

        Sintaxis: (parametros) -> { cuerpo }

        Reglas:
          - 0 parametros:       () -> expresion
          - 1 parametro:         x -> expresion  (sin parentesis)
          - 2+ parametros:    (x, y) -> expresion
          - Cuerpo simple:        -> expresion (sin llaves, sin return)
          - Cuerpo multiple:      -> { expr1; expr2; return valor; }
          - Si devuelve valor:    -> valor (implicito) o return explicito

        Ejemplos de lambdas:
          () -> 5                        // devuelve 5
          x -> x * x                     // cuadrado
          (x, y) -> x + y                // suma
          x -> { x *= 2; return x / 2; } // multiple
          (x, y) -> { x *= 2; return x / y; }
          (x, y, z) -> x + y * z

        --- EJEMPLO: CALCULADORA CON LAMBDAS ---

        Calculadora suma = (a, b) -> a + b;
        Calculadora resta = (a, b) -> a - b;
        Calculadora mult  = (a, b) -> a * b;
        Calculadora div   = (a, b) -> a / b;
        Calculadora cuadSuma = (a, b) -> (int)Math.pow(a + b, 2);

        // Uso:
        int r = suma.operacion(3, 5);  // 8

        // Lambda con varias instrucciones:
        Calculadora compleja = (a, b) -> {
            a += b;       // a = 8
            b += a;       // b = 13
            return a * b; // 104
        };

        --- EJEMPLO: SALUDADOR CON LAMBDAS ---

        Saludador saludoSimple = () -> System.out.println("Hola mundo");
        Saludador saludoHora = () -> System.out.println(
            "Hola son las " + LocalTime.now().getHour()
            + ":" + LocalTime.now().getMinute());

        saludoSimple.saludo();  // "Hola mundo"
        saludoHora.saludo();    // "Hola son las HH:mm"

        --- LAS LAMBDAS SON INSTANCIAS ---

        Las expresiones lambda crean instancias de clases anonimas
        que implementan la interfaz funcional. Tienen acceso a los
        metodos de Object (toString, equals, hashCode...).

        --- METODOS REFERENCIADOS (avance) ---

        En lugar de escribir la lambda, se puede hacer referencia
        a un metodo existente:
          Calculadora refSuma = Integer::sum;  // metodo referenciado

        --- CONCEPTOS CLAVE ---

        - @FunctionalInterface: 1 solo metodo abstracto
        - Lambda: funcion anonima (parametros) -> { cuerpo }
        - Las lambdas implementan interfaces funcionales
        - Sin parentesis para 1 parametro, sin llaves para 1 instruccion
        - return implicito si el cuerpo es una sola expresion
        - Las lambdas son objetos (instancias de la interfaz)
        - Proximo video: metodos referenciados
        ================================================================
        """;

    // ================================================================
    // INTERFACES FUNCIONALES
    // ================================================================
    @FunctionalInterface
    interface Calculadora {
        int operacion(int a, int b);
    }

    @FunctionalInterface
    interface Saludador {
        void saludo();
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        int A = 3, B = 5;

        // ============================================================
        // LAMBDAS PARA CALCULADORA
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  LAMBDAS: CALCULADORA");
        System.out.println("=========================================");

        Calculadora suma = (a, b) -> a + b;
        Calculadora resta = (a, b) -> a - b;
        Calculadora multiplicacion = (a, b) -> a * b;
        Calculadora division = (a, b) -> a / b;
        Calculadora cuadSuma = (a, b) -> (int) Math.pow(a + b, 2);

        // Lambda con varias instrucciones
        Calculadora compleja = (a, b) -> {
            a += b;
            b += a;
            return a * b;
        };

        System.out.println("  A = " + A + ", B = " + B);
        System.out.println("  a + b = " + suma.operacion(A, B));
        System.out.println("  a - b = " + resta.operacion(A, B));
        System.out.println("  a * b = " + multiplicacion.operacion(A, B));
        System.out.println("  a / b = " + division.operacion(A, B));
        System.out.println("  (a+b)^2 = " + cuadSuma.operacion(A, B));
        System.out.println("  compleja = " + compleja.operacion(A, B));
        System.out.println();

        // ============================================================
        // LAMBDAS PARA SALUDADOR
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  LAMBDAS: SALUDADOR");
        System.out.println("=========================================");

        Saludador saludoSimple = () -> System.out.println("  Hola mundo");
        Saludador saludoHora = () -> System.out.println(
            "  Hola son las " + LocalTime.now().getHour()
            + ":" + LocalTime.now().getMinute());

        saludoSimple.saludo();
        saludoHora.saludo();
        System.out.println();

        // ============================================================
        // DEMO: CAMBIO DE VALORES
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  CAMBIO DE VALORES (A=8, B=2)");
        System.out.println("=========================================");

        int A2 = 8, B2 = 2;
        System.out.println("  A = " + A2 + ", B = " + B2);
        System.out.println("  a + b = " + suma.operacion(A2, B2));
        System.out.println("  a - b = " + resta.operacion(A2, B2));
        System.out.println("  a * b = " + multiplicacion.operacion(A2, B2));
        System.out.println("  (a+b)^2 = " + cuadSuma.operacion(A2, B2));
        System.out.println("  compleja = " + compleja.operacion(A2, B2));
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V24: INTERFACES FUNCIONALES Y LAMBDAS)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - @FunctionalInterface: 1 metodo abstracto");
        System.out.println("  - Lambda: (params) -> { cuerpo }");
        System.out.println("  - Sin parentesis para 1 param, sin llaves para 1 instr");
        System.out.println("  - return implicito en expresion simple");
        System.out.println("  - Las lambdas son instancias de la interfaz");
        System.out.println("  - Proximo video: metodos referenciados");
    }
}
