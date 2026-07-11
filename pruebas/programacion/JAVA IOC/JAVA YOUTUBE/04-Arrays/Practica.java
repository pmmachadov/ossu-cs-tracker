import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practica {
    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        int sumaCuadradosPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);

        System.out.println("Suma cuadrados pares: " + sumaCuadradosPares);

        String texto = "¡Hola, hola! ¿Cómo estás? Estoy bien, muy bien.";

        HashMap<String, Integer> frecuencias = new HashMap<>();

        texto = texto.toLowerCase();

        String[] arr = texto.split("\\W+");

        for (String str : arr) {
            if (!str.isEmpty()) {
                int conteoActual = frecuencias.getOrDefault(str, 0);
                frecuencias.put(str, conteoActual + 1);
            }
        }

        System.out.println("\n=== MAPA SIN ORDENAR (HashMap) ===");
        System.out.println(frecuencias);

        Map<String, Integer> mapaOrdenado = frecuencias.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        System.out.println("\n=== MAPA ORDENADO POR FRECUENCIA (LinkedHashMap) ===");

        for (Map.Entry<String, Integer> entrada : mapaOrdenado.entrySet()) {
            System.out.println("Palabra: " + entrada.getKey() + " | Frecuencia: " + entrada.getValue());
        }
    }
}
