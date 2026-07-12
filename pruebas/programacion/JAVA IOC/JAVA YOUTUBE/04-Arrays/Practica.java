import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Práctica: Pipeline de Streams para contar frecuencia de palabras.
 *
 * Toma un texto, lo separa en palabras, cuenta cuántas veces aparece cada una
 * y las ordena de mayor a menor frecuencia usando 100% Stream API.
 */
public class Practica {

    public static void main(String[] args) {

        // 1. TEXTO DE ENTRADA
        String texto = "¡Hola, hola! ¿Cómo estás? Estoy bien, muy bien. Hola mundo, mundo hola.";

        // 2. PIPELINE COMPLETO DE STREAM (SIN BUCLES FOR)
        // El objetivo es pasar de un String a un Map<String, Long> ordenado por frecuencia.
        //
        // .split("\\W+") crea un array de Strings.
        // "\\W+" es la Regex que separa por cualquier cosa que NO sea letra/número.
        // Arrays.stream() convierte ese array en nuestra "cinta transportadora".
        //
        // PASO A: AGRUPAR Y CONTAR (El equivalente al HashMap manual)
        // Collectors.groupingBy() es el "GROUP BY" de SQL pero en Java.
        //   - ARGUMENTO 1: Clasificador (La Clave del Mapa)
        //     Function.identity() devuelve el elemento sin modificarlo.
        //     Equivale a la lambda: palabra -> palabra.
        //   - ARGUMENTO 2: Reductor (El Valor del Mapa)
        //     Collectors.counting() cuenta cuántos elementos hay en cada grupo.
        //
        // PASO B: ORDENAR EL MAPA
        // Los Mapas no se pueden ordenar directamente.
        // Truco: Convertimos sus pares (entrySet) en UN NUEVO Stream.
        // Map.Entry.comparingByValue() compara pares usando su VALOR (la frecuencia).
        // Comparator.reverseOrder() invierte el orden para que sea DESCENDENTE.
        //
        // PASO C: RECOLECTAR EN UN MAPA QUE CONSERVE EL ORDEN
        // Si usamos Collectors.toMap() normal, Java crea un HashMap y PERDEMOS el orden.
        // Por eso usamos la versión de 4 argumentos con LinkedHashMap::new
        // que SÍ guarda el orden de inserción.
        Map<String, Long> mapaOrdenado = Arrays.stream(texto.split("\\W+"))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        // 3. IMPRESIÓN DEL RESULTADO
        System.out.println("=== FRECUENCIA ORDENADA (100% STREAM) ===");
        for (Map.Entry<String, Long> entrada : mapaOrdenado.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue() + " veces");
        }
    }
}
