import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Video_7_27_EjemplosProgramacionFuncional {

    public static final String TITULO = "7-27 JAVA: Ejemplos programación funcional ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=veV_KRiloBY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=168";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-27 - EJEMPLOS PROGRAMACIÓN FUNCIONAL (STREAMS)
        ================================================================

        Continuacion de ejemplos de la API Stream usando flatMap,
        takeWhile, dropWhile, peek, count, reduce con lambdas.

        --- EJEMPLOS CON LISTA DE LISTAS ---

        Se crean 4 listas (1-10, 11-20, 21-30, 31-40) y una listaFinal
        que las contiene (List<List<Integer>>).

        EJEMPLO 1: flatMap + filter + map + collect
        - flatMap(Collection::stream) -> aplana las 4 listas en 1-40
        - filter(n % 10 == 0)         -> 10, 20, 30, 40
        - map(n / 10)                 -> 1, 2, 3, 4
        - collect(toList())           -> [1, 2, 3, 4]

        EJEMPLO 2: flatMap + filter + map + count (casting)
        - Similar pero con count() -> devuelve long, se castea a int

        EJEMPLO 3: flatMap + filter + map + reduce con lambda
        - reduce(0, (acumulado, n) -> acumulado + n * 2)
        - Acumula cada elemento multiplicado por 2
        - 1*2 + 2*2 + 3*2 + 4*2 = 20

        EJEMPLO 4: takeWhile (tomar mientras cumpla condicion)
        - takeWhile(n -> n < 20) -> [1..19]

        EJEMPLO 5: dropWhile (eliminar mientras cumpla condicion)
        - dropWhile(n -> n < 20) -> [20..40]

        EJEMPLO 6: takeWhile con pares
        - takeWhile(n -> n % 2 == 0) -> [] (vacio, primer elemento es impar)

        EJEMPLO 7: dropWhile con pares
        - dropWhile(n -> n % 2 == 0) -> [1..40] (no borra ninguno)

        --- PEEK (operacion intermedia de depuracion) ---
        .peek(n -> System.out.print(n + " "))
        Sirve para ver el estado del Stream en cada paso.

        DIFERENCIA filter vs takeWhile:
        - filter: evalua TODOS los elementos
        - takeWhile: para cuando la condicion deja de cumplirse (como while)
        - dropWhile: elimina mientras se cumpla, luego conserva el resto
        ================================================================
        """;

    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // Listas anidadas
        List<Integer> lista1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> lista2 = List.of(11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        List<Integer> lista3 = List.of(21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
        List<Integer> lista4 = List.of(31, 32, 33, 34, 35, 36, 37, 38, 39, 40);
        List<List<Integer>> listaFinal = List.of(lista1, lista2, lista3, lista4);

        // EJEMPLO 1: flatMap + filter + map + collect
        System.out.println("=== EJEMPLO 1: flatMap + filter + map + collect ===");
        List<Integer> listaFiltrada = listaFinal.stream()
                .flatMap(List::stream)
                .filter(n -> n % 10 == 0)
                .map(n -> n / 10)
                .collect(Collectors.toList());
        System.out.println("  Resultado: " + listaFiltrada); // [1, 2, 3, 4]
        System.out.println();

        // EJEMPLO 2: flatMap + filter + map + count (con peek)
        System.out.println("=== EJEMPLO 2: count (con peek para depurar) ===");
        int cantidad = (int) listaFinal.stream()
                .flatMap(List::stream)
                .peek(n -> System.out.print(" " + n))
                .filter(n -> n % 10 == 0)
                .peek(n -> System.out.print(" [f:" + n + "]"))
                .map(n -> n / 10)
                .peek(n -> System.out.print(" (m:" + n + ")"))
                .count();
        System.out.println();
        System.out.println("  Cantidad: " + cantidad); // 4
        System.out.println();

        // EJEMPLO 3: reduce con lambda personalizada
        System.out.println("=== EJEMPLO 3: reduce con lambda (acumulado + n*2) ===");
        int total = listaFinal.stream()
                .flatMap(List::stream)
                .filter(n -> n % 10 == 0)
                .map(n -> n / 10)
                .reduce(0, (acumulado, n) -> acumulado + n * 2);
        System.out.println("  Total (1*2 + 2*2 + 3*2 + 4*2): " + total); // 20
        System.out.println();

        // EJEMPLO 4: takeWhile
        System.out.println("=== EJEMPLO 4: takeWhile(n < 20) ===");
        List<Integer> menores = listaFinal.stream()
                .flatMap(List::stream)
                .takeWhile(n -> n < 20)
                .toList();
        System.out.println("  Menores que 20: " + menores); // [1..19]
        System.out.println();

        // EJEMPLO 5: dropWhile
        System.out.println("=== EJEMPLO 5: dropWhile(n < 20) ===");
        List<Integer> mayores = listaFinal.stream()
                .flatMap(List::stream)
                .dropWhile(n -> n < 20)
                .toList();
        System.out.println("  Desde 20 en adelante: " + mayores); // [20..40]
        System.out.println();

        // EJEMPLO 6: takeWhile con pares (primer elemento impar -> vacio)
        System.out.println("=== EJEMPLO 6: takeWhile(n % 2 == 0) ===");
        List<Integer> ninguno = listaFinal.stream()
                .flatMap(List::stream)
                .takeWhile(n -> n % 2 == 0)
                .toList();
        System.out.println("  Pares (con takeWhile): " + ninguno); // [] (el 1 es impar)
        System.out.println();

        // EJEMPLO 7: dropWhile con pares (primer elemento impar -> no borra)
        System.out.println("=== EJEMPLO 7: dropWhile(n % 2 == 0) ===");
        List<Integer> todos = listaFinal.stream()
                .flatMap(List::stream)
                .dropWhile(n -> n % 2 == 0)
                .toList();
        System.out.println("  Todos (con dropWhile): " + todos); // [1..40]
        System.out.println();

        // DEMO: lista1 solo pares para ver takeWhile/dropWhile
        System.out.println("=== DEMO: lista1 con solo pares [2,4,6,8,10] ===");
        List<Integer> lista1Pares = List.of(2, 4, 6, 8, 10);
        List<List<Integer>> listaFinalPares = List.of(lista1Pares, lista2, lista3, lista4);

        List<Integer> takePares = listaFinalPares.stream()
                .flatMap(List::stream)
                .takeWhile(n -> n % 2 == 0)
                .toList();
        System.out.println("  takeWhile(par): " + takePares); // [2,4,6,8,10] (para al llegar al 11)

        List<Integer> dropPares = listaFinalPares.stream()
                .flatMap(List::stream)
                .dropWhile(n -> n % 2 == 0)
                .toList();
        System.out.println("  dropWhile(par): " + dropPares); // [11..40]
        System.out.println();

        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V27: EJEMPLOS PROGRAMACION FUNCIONAL)");
    }
}
