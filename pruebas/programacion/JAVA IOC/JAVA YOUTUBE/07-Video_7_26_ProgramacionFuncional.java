import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Video_7_26_ProgramacionFuncional {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "7-26 JAVA: Programación funcional ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=pip5g8KfNUo&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=167";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-26 - PROGRAMACIÓN FUNCIONAL (API STREAM)
        ================================================================

        Video:        7-26 JAVA: Programación funcional
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7

        --- RESUMEN (transcripción) ---

        La API de Stream se introdujo en Java 8, junto con las interfaces
        funcionales, expresiones lambda y métodos referenciados.
        Permite procesar datos de forma funcional.

        Stream = secuencia de elementos que se procesan en paralelo o
        de forma secuencial. Proporciona métodos para filtrar,
        transformar y convertir colecciones y tipos de datos.

        --- COMPONENTES PRINCIPALES ---

        1. OPERACIONES INTERMEDIAS
           Transforman un Stream en otro Stream.
           Son PEREZOSAS (lazy): no se ejecutan hasta que se invoca
           una operación terminal.

        2. OPERACIONES TERMINALES
           Producen un resultado a partir del Stream:
           nueva colección, nuevo tipo de dato, o ejecución de acciones.

        --- OPERACIONES INTERMEDIAS ---

        filter(Predicate<T>)
          Filtra elementos según una condición (lambda o method reference).
          Ej: .filter(nombre -> nombre.length() > 3)

        map(Function<T,R>)
          Transforma cada elemento del Stream aplicando una función.
          Ej: .map(String::toUpperCase)

        flatMap(Function<T, Stream<R>>)
          Aplana un Stream de colecciones en un Stream de elementos
          individuales. Útil cuando hay colecciones dentro de colecciones.

        distinct()
          Elimina elementos duplicados del Stream.

        sorted()
          Ordena los elementos según su orden natural (Comparable).

        sorted(Comparator<T>)
          Ordena los elementos según un Comparator proporcionado.

        takeWhile(Predicate<T>)
          Toma elementos del Stream MIENTRAS se cumpla la condición.
          Al dejar de cumplirse, para (como un while).

        dropWhile(Predicate<T>)
          Elimina elementos del Stream MIENTRAS se cumpla la condición.
          Al dejar de cumplirse, conserva el resto.

        --- OPERACIONES TERMINALES ---

        forEach(Consumer<T>)
          Ejecuta una acción por cada elemento del Stream.
          Ej: .forEach(System.out::println)

        reduce(identidad, BinaryOperator<T>)
          Combina los elementos del Stream en un único valor.
          La identidad es el valor inicial del acumulador.
          Ej: .reduce(0, Integer::sum)

        collect(Collector<T,A,R>)
          Transforma y acumula elementos en una colección/objeto.
          Ej: .collect(Collectors.toList())

        min(Comparator<T>) / max(Comparator<T>)
          Devuelve el elemento mínimo/máximo según un Comparator.

        count()
          Cuenta el número de elementos del Stream.

        anyMatch(Predicate<T>)
        allMatch(Predicate<T>)
        noneMatch(Predicate<T>)
          Evalúa si alguno/todos/ninguno cumplen una condición.

        --- EJEMPLO 1: FILTRAR + MAP + SORT + COLLECT ---

        List<String> nombres = Arrays.asList("Ana", "Carlos", "Antonio", "David", "Eva");

        List<String> filtrados = nombres.stream()
            .filter(n -> n.length() > 3)    // "Ana" y "Eva" eliminados
            .map(String::toUpperCase)       // CARLOS, ANTONIO, DAVID
            .sorted()                       // ANTONIO, CARLOS, DAVID
            .collect(Collectors.toList());  // [ANTONIO, CARLOS, DAVID]

        --- EJEMPLO 2: FILTRAR + MAP + REDUCE (suma cuadrados pares) ---

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4);

        int sumaCuadradosPares = numeros.stream()
            .filter(n -> n % 2 == 0)       // 2, 4
            .map(n -> n * n)                // 4, 16
            .reduce(0, Integer::sum);       // 0 + 4 + 16 = 20

        --- EJEMPLO 3: FILTRAR + MAP + REDUCE con STRINGS ---

        List<String> palabras = Arrays.asList("a", "ab", "abc", "abcd");

        String frase = palabras.stream()
            .filter(p -> p.length() > 2)    // "abc", "abcd"
            .map(p -> p + "_")              // "abc_", "abcd_"
            .reduce("Frase: ", String::concat); // "Frase: abc_abcd_"

        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: FILTER + MAP + SORTED + COLLECT
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 1 - FILTER + MAP + SORT + COLLECT");
        System.out.println("=========================================");

        List<String> nombres = Arrays.asList("Ana", "Carlos", "Antonio", "David", "Eva");

        List<String> nombresFiltrados = nombres.stream()
                .filter(nombre -> nombre.length() > 3)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("  Original: " + nombres);
        System.out.println("  Filtrados (>3 chars, mayus, ordenado): " + nombresFiltrados);
        System.out.println();

        // MISMO EJEMPLO pero con forEach como terminal
        System.out.print("  Con forEach: ");
        nombres.stream()
                .filter(n -> n.length() > 3)
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        // MISMO EJEMPLO pero con forEach lambda personalizada
        System.out.print("  Con lambda personalizada: ");
        nombres.stream()
                .filter(x -> x.length() > 3)
                .map(String::toUpperCase)
                .sorted()
                .forEach(nombre -> System.out.print(nombre + ", "));
        System.out.println();
        System.out.println();

        // ============================================================
        // EJEMPLO 2: FILTER (pares) + MAP (cuadrado) + REDUCE (suma)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 2 - PARES AL CUADRADO + REDUCE");
        System.out.println("=========================================");

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4);

        int sumaCuadradosPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);

        System.out.println("  Números: " + numeros);
        System.out.println("  Pares al cuadrado: 2^2 + 4^2 = " + sumaCuadradosPares);
        System.out.println();

        // Con 5 y 6
        List<Integer> numeros2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        int suma2 = numeros2.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);

        System.out.println("  Números: " + numeros2);
        System.out.println("  Pares al cuadrado: 2^2 + 4^2 + 6^2 = " + suma2);
        System.out.println();

        // ============================================================
        // EJEMPLO 3: FILTER + MAP + REDUCE con STRINGS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 3 - STREAMS CON STRINGS");
        System.out.println("=========================================");

        List<String> palabras = Arrays.asList("a", "ab", "abc", "abcd");

        System.out.println("  Palabras original: " + palabras);

        // Filtrar longitud > 1, añadir "_", concatenar con reduce
        String frase = palabras.stream()
                .filter(p -> p.length() > 1)
                .map(p -> p + "_")
                .reduce("Frase: ", String::concat);

        System.out.println("  Longitud > 1 + '_' + concat: " + frase);
        System.out.println();

        // Filtrar longitud > 2
        String frase2 = palabras.stream()
                .filter(p -> p.length() > 2)
                .map(p -> p + "_")
                .reduce("Frase: ", String::concat);

        System.out.println("  Longitud > 2 + '_' + concat: " + frase2);
        System.out.println();

        // ============================================================
        // RESUMEN VISUAL DE OPERACIONES
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  OPERACIONES STREAM API - RESUMEN");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  INTERMEDIAS (lazy):");
        System.out.println("    - filter(Predicate)    -> filtra elementos");
        System.out.println("    - map(Function)        -> transforma elementos");
        System.out.println("    - flatMap(Function)    -> aplana colecciones");
        System.out.println("    - distinct()           -> elimina duplicados");
        System.out.println("    - sorted()             -> ordena natural");
        System.out.println("    - sorted(Comparator)   -> ordena con comparador");
        System.out.println("    - takeWhile(Predicate) -> toma mientras cumpla");
        System.out.println("    - dropWhile(Predicate) -> elimina mientras cumpla");
        System.out.println();
        System.out.println("  TERMINALES:");
        System.out.println("    - forEach(Consumer)    -> accion por elemento");
        System.out.println("    - reduce(id, BinaryOp) -> combina en un valor");
        System.out.println("    - collect(Collector)   -> recolecta en coleccion");
        System.out.println("    - min/max(Comparator)  -> minimo/maximo");
        System.out.println("    - count()              -> cuenta elementos");
        System.out.println("    - anyMatch/allMatch/noneMatch -> evaluan condicion");
        System.out.println();
        System.out.println("  LAS OPERACIONES INTERMEDIAS SON PEREZOSAS");
        System.out.println("  -> No se ejecutan hasta que hay una terminal");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V26: PROGRAMACION FUNCIONAL / STREAMS)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Stream API: programacion funcional en Java (desde 8)");
        System.out.println("  - Operaciones intermedias: filter, map, sorted, distinct...");
        System.out.println("  - Operaciones terminales: collect, reduce, forEach, count...");
        System.out.println("  - Las intermedias son LAZY (se ejecutan al final)");
        System.out.println("  - Proximo video: mas ejemplos de Stream API");
    }
}
