import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class Video_7_25_MetodosReferenciados {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "7-25 JAVA: Method reference ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=6Fq7dUFiUYM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=166";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-25 - MÉTODOS REFERENCIADOS (METHOD REFERENCE)
        ================================================================

        Video:        7-25 JAVA: Method reference
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7

        --- RESUMEN (transcripción) ---

        Los métodos referenciados son una alternativa a las expresiones lambda.
        En lugar de programar la expresión, hacemos referencia a un método
        ya existente (de ahí su nombre).

        --- VENTAJAS ---
        1. Más legibles: sintaxis más concisa, el nombre del método indica su función.
        2. Reutilización de código: al referenciar un método ya probado y optimizado.
        3. Facilitan la refactorización: cambios en el método se reflejan en todos los usos.
        4. Interoperabilidad con interfaces funcionales y API Stream.

        --- 4 TIPOS DE METHOD REFERENCE ---

        1. REFERENCIA A MÉTODO ESTÁTICO
           Sintaxis: Clase::metodoEstatico
           Ejemplo: Integer::parseInt

        2. REFERENCIA A MÉTODO DE INSTANCIA (objeto concreto)
           Sintaxis: objeto::metodoInstancia
           Ejemplo: (variable String) string::length

        3. REFERENCIA A MÉTODO DE INSTANCIA (objeto arbitrario)
           Sintaxis: Clase::metodoInstancia
           Ejemplo: String::length   (Clase con mayúscula)

        4. REFERENCIA A CONSTRUCTOR
           Sintaxis: Clase::new
           Ejemplo: Persona::new

        --- EJEMPLO: FOR EACH ---

        List<String> nombres = Arrays.asList("Pep", "Tom", "John");

        // Con lambda:
        nombres.forEach(nombre -> System.out.println(nombre));

        // Con method reference (más legible):
        nombres.forEach(System.out::println);

        --- EJEMPLO: CALCULADORA CON METHOD REFERENCE ---

        Usando la misma interfaz funcional Calculadora del video anterior:

        @FunctionalInterface
        interface Calculadora {
            int operacion(int a, int b);
        }

        // Method references a métodos estáticos de esta misma clase:
        Calculadora suma = Video_7_25_MetodosReferenciados::suma;
        Calculadora resta = Video_7_25_MetodosReferenciados::resta;
        Calculadora mult  = Video_7_25_MetodosReferenciados::multiplicacion;
        Calculadora div   = Video_7_25_MetodosReferenciados::division;
        Calculadora cuadSuma = Video_7_25_MetodosReferenciados::cuadradoSuma;
        Calculadora compleja = Video_7_25_MetodosReferenciados::calculoComplejo;

        // Los métodos deben tener la misma firma que el método abstracto:
        static int suma(int a, int b) { return a + b; }
        static int division(int a, int b) { return a / b; }
        // etc.

        --- EJEMPLO: INTERFAZ Function<T,R> ---

        Interfaz funcional del paquete java.util.function.
        Recibe un tipo T y devuelve un tipo R. Método: apply(T)

        Function<String, Integer> longitudCadena = String::length;
        // String::length es method reference tipo 3 (objeto arbitrario)

        int longitud = longitudCadena.apply("Hola mundo");
        // longitud = 10

        Function<Integer, Integer> cuadrado = x -> x * x;
        // Con lambda (pues no hay método existente para elevar al cuadrado)

        int cuadradoLongitud = cuadrado.apply(longitud);
        // cuadradoLongitud = 100

        --- DIFERENCIA LAMBDA vs METHOD REFERENCE ---

        Lambda:  (params) -> { expresion }
        Method ref: Clase::metodo

        Usar lambda cuando:
        - El código es simple y se usa una sola vez
        - No existe un método ya creado que haga lo que necesitamos

        Usar method reference cuando:
        - Ya existe un método con la funcionalidad deseada
        - Queremos código más legible y reutilizable
        - El método tiene un nombre significativo

        ================================================================
        """;

    // ================================================================
    // INTERFAZ FUNCIONAL
    // ================================================================
    @FunctionalInterface
    interface Calculadora {
        int operacion(int a, int b);
    }

    // ================================================================
    // MÉTODOS ESTÁTICOS REFERENCIABLES
    // ================================================================
    static int suma(int a, int b) {
        return a + b;
    }

    static int resta(int a, int b) {
        return a - b;
    }

    static int multiplicacion(int a, int b) {
        return a * b;
    }

    static int division(int a, int b) {
        return a / b;
    }

    static int cuadradoSuma(int a, int b) {
        return (int) Math.pow(a + b, 2);
    }

    static int calculoComplejo(int a, int b) {
        a += b;
        b += a;
        return a * b;
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        final int A = 3, B = 5;

        // ============================================================
        // EJEMPLO 1: METHOD REFERENCES CON CALCULADORA
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  METHOD REFERENCES: CALCULADORA");
        System.out.println("=========================================");

        Calculadora suma = Video_7_25_MetodosReferenciados::suma;
        Calculadora resta = Video_7_25_MetodosReferenciados::resta;
        Calculadora multiplicacion = Video_7_25_MetodosReferenciados::multiplicacion;
        Calculadora division = Video_7_25_MetodosReferenciados::division;
        Calculadora cuadSuma = Video_7_25_MetodosReferenciados::cuadradoSuma;
        Calculadora compleja = Video_7_25_MetodosReferenciados::calculoComplejo;

        System.out.println("  A = " + A + ", B = " + B);
        System.out.println("  a + b = " + suma.operacion(A, B));
        System.out.println("  a - b = " + resta.operacion(A, B));
        System.out.println("  a * b = " + multiplicacion.operacion(A, B));
        System.out.println("  a / b = " + division.operacion(A, B));
        System.out.println("  (a+b)^2 = " + cuadSuma.operacion(A, B));
        System.out.println("  compleja = " + compleja.operacion(A, B));
        System.out.println();

        // ============================================================
        // EJEMPLO 2: FOR EACH CON METHOD REFERENCE
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  FOR EACH CON METHOD REFERENCE");
        System.out.println("=========================================");

        List<String> nombres = Arrays.asList("Pep", "Tom", "John");
        System.out.print("  ");
        nombres.forEach(System.out::println);
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Function<T,R> CON METHOD REFERENCE
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  Function<T,R> CON METHOD REFERENCE");
        System.out.println("=========================================");

        // Method reference tipo 3: String::length (objeto arbitrario de tipo String)
        Function<String, Integer> longitudCadena = String::length;
        String texto = "Hola mundo";
        int longitud = longitudCadena.apply(texto);
        System.out.println("  Longitud de '" + texto + "': " + longitud);

        // Lambda (no hay método existente para elevar al cuadrado)
        Function<Integer, Integer> cuadrado = x -> x * x;
        int cuadradoLongitud = cuadrado.apply(longitud);
        System.out.println("  Cuadrado de longitud: " + cuadradoLongitud);

        System.out.println("  Longitud^2 = " + longitud + "^2 = " + cuadradoLongitud);
        System.out.println();

        // Con otro texto
        String texto2 = "Hola";
        int long2 = longitudCadena.apply(texto2);
        int cuad2 = cuadrado.apply(long2);
        System.out.println("  Longitud de '" + texto2 + "': " + long2 + ", cuadrado: " + cuad2);
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V25: MÉTODOS REFERENCIADOS)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Method reference: alternativa concisa a lambda");
        System.out.println("  - 4 tipos: static, instance, arbitrary object, constructor");
        System.out.println("  - Sintaxis: Clase::metodo  o  objeto::metodo");
        System.out.println("  - Function<T,R>: recibe T, devuelve R, metodo apply()");
        System.out.println("  - Mas legible y reutilizable que lambda");
        System.out.println("  - Proximo video: API Stream");
    }
}
