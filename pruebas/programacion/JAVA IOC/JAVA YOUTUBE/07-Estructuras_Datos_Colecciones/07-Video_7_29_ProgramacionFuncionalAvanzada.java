import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Video_7_29_ProgramacionFuncionalAvanzada {

    public static final String TITULO = "7-29 JAVA: Programación funcional avanzada ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=cTGPgMMKxZk&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=170";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-29 - PROGRAMACIÓN FUNCIONAL AVANZADA
        ================================================================

        --- 1. PARALLEL STREAM ---
        Reemplazar .stream() por .parallelStream() para ejecutar
        operaciones en PARALELO usando multiples procesadores.
        Java divide el trabajo en subprocesos automaticamente.

        Ejemplo con 100 millones de elementos:
        - .parallelStream() -> ~7 segundos
        - .stream()         -> ~77 segundos

        --- 2. COLLECT (operacion terminal avanzada) ---
        collect(Collector) permite recoleccion mutable:
        - Acumular en colecciones, objetos, o aplicar combinacion.

        --- 3. Collectors.toMap() ---
        Convierte Stream en un Map<K,V>.
        Parametros:
          - keyMapper:  funcion para generar la clave
          - valueMapper: funcion para generar el valor
          - mergeFunction: que hacer si dos valores tienen la misma clave
          - mapFactory: tipo de Map a crear (ej: LinkedHashMap::new)

        --- 4. Collectors.groupingBy() ---
        Agrupa elementos del Stream como GROUP BY en SQL.
        Parametros:
          - classifier: funcion de clasificacion (crea grupos)
          - downstream: collector para los valores de cada grupo
          Ej: .collect(Collectors.groupingBy(Function.identity(),
                            Collectors.counting()))

        --- EJEMPLO: FRECUENCIA DE PALABRAS ---
        String texto = "Esto es un ejemplo ejemplo palabra palabra palabra";

        1. groupingBy + counting -> mapa {palabra -> frecuencia}
        2. entrySet().stream()   -> stream de pares clave-valor
        3. sorted por valor (reversed) -> de mayor a menor frecuencia
        4. collect(toMap) con LinkedHashMap -> mantiene orden

        ================================================================
        """;

    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // EJEMPLO: FRECUENCIA DE PALABRAS CON GROUPINGBY + TOMAP
        // ============================================================
        System.out.println("=== FRECUENCIA DE PALABRAS ===");
        String texto = "Esto es un ejemplo ejemplo palabra palabra palabra";
        System.out.println("  Texto: '" + texto + "'");
        System.out.println();

        // SOLUCION 1: groupingBy + toMap con LinkedHashMap
        Map<String, Long> palabrasOrden = Arrays.stream(texto.split("\\\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        System.out.println("  Solucion 1 (LinkedHashMap): " + palabrasOrden);
        System.out.println();

        // SOLUCION 2: groupingBy + forEach para insertar en LinkedHashMap
        Map<String, Long> conteoPalabras = Arrays.stream(texto.split("\\\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        LinkedHashMap<String, Long> palabrasOrdenadas = new LinkedHashMap<>();
        conteoPalabras.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> palabrasOrdenadas.put(entry.getKey(), entry.getValue()));

        System.out.println("  Solucion 2 (forEach put):");
        palabrasOrdenadas.forEach((palabra, cantidad) ->
                System.out.println("    Palabra: '" + palabra + "', Cantidad: " + cantidad));
        System.out.println();

        // ============================================================
        // DEMO: CON MAYUSCULAS/MINUSCULAS
        // ============================================================
        System.out.println("=== DEMO: ignorar mayusculas ===");
        String textoMix = "Esto es un Ejemplo ejemplo Palabra palabra palabra";
        System.out.println("  Texto: '" + textoMix + "'");
        System.out.println();

        // Usando lambda para normalizar con toLowerCase en el keyMapper
        Map<String, Long> palabrasNorm = Arrays.stream(textoMix.split("\\\\s+"))
                .collect(Collectors.groupingBy(
                        palabra -> palabra.toLowerCase(),  // normalizar clave
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        System.out.println("  Normalizado: " + palabrasNorm);
        System.out.println();

        // ============================================================
        // DEMO: PARALLEL STREAM (simulado con datos pequenos)
        // ============================================================
        System.out.println("=== PARALLEL STREAM (demo) ===");
        List<String> palabras = Arrays.asList("Ana", "Carlos", "Antonio", "David", "Eva");

        List<String> resultadoParalelo = palabras.parallelStream()
                .filter(n -> n.length() > 3)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("  Con parallelStream: " + resultadoParalelo);
        System.out.println();

        // ============================================================
        // RESUMEN COLECTIVOS AVANZADOS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  COLECTIVOS AVANZADOS - RESUMEN");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Collectors.toMap():");
        System.out.println("    - keyMapper:   Map.Entry::getKey");
        System.out.println("    - valueMapper: Map.Entry::getValue");
        System.out.println("    - mergeFunction: (e1, e2) -> e1 (resuelve conflictos)");
        System.out.println("    - mapFactory:  LinkedHashMap::new");
        System.out.println();
        System.out.println("  Collectors.groupingBy():");
        System.out.println("    - classifier: Function.identity() (agrupa por palabra)");
        System.out.println("    - downstream: Collectors.counting() (cuenta apariciones)");
        System.out.println();
        System.out.println("  parallelStream():");
        System.out.println("    - Usa multiples procesadores");
        System.out.println("    - Mucho mas rapido para grandes volumenes de datos");
        System.out.println();

        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V29: PROGRAMACION FUNCIONAL AVANZADA)");
        System.out.println("================================================================");
    }
}
