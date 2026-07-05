import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // ========================================================================
        // PARTE 1: API STREAM (Reduce)
        // ========================================================================

        // Arrays.asList crea una lista de tamaño fijo a partir de los valores que le
        // pasamos.
        // List<Integer> usa la clase "envoltorio" Integer porque las colecciones en
        // Java
        // no pueden guardar tipos primitivos (como int), solo objetos.
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        // .stream() convierte la lista en una "cinta transportadora" de datos.
        int sumaCuadradosPares = numeros.stream()

                // .filter() recibe una lambda. "n" es cada número de la cinta.
                // n % 2 == 0 comprueba si es par. Si es par, pasa al siguiente paso.
                .filter(n -> n % 2 == 0)

                // .map() transforma cada elemento. Aquí elevamos al cuadrado (n * n).
                .map(n -> n * n)

                // .reduce() combina todos los elementos en UNO SOLO.
                // 0 es la IDENTIDAD (el acumulador empieza en 0).
                // Integer::sum es un Method Reference (::) que equivale a (a, b) -> a + b.
                .reduce(0, Integer::sum);

        System.out.println("Suma cuadrados pares: " + sumaCuadradosPares);

        // ========================================================================
        // PARTE 2: ANALIZADOR DE TEXTOS (HashMap)
        // ========================================================================

        String texto = "¡Hola, hola! ¿Cómo estás? Estoy bien, muy bien.";

        // HashMap<String, Integer> declara un "diccionario" donde:
        // - String (Clave/Key): Será la palabra.
        // - Integer (Valor/Value): Será la frecuencia (cuántas veces aparece).
        // new HashMap<>() crea el objeto. El <> vacío (Diamond Operator) le dice a Java
        // que infiera los tipos automáticamente basándose en la izquierda del =.
        HashMap<String, Integer> frecuencias = new HashMap<>();

        // Normalizamos a minúsculas para que "Hola" y "hola" cuenten como la misma
        // palabra.
        texto = texto.toLowerCase();

        // split("\\W+") es una Expresión Regular (Regex).
        // \W (W mayúscula) significa "cualquier carácter que NO sea letra, número o
        // guion bajo".
        // El + significa "uno o varios seguidos". Esto borra comas, puntos, signos de
        // interrogación.
        String[] arr = texto.split("\\W+");

        // "for (String str : arr)" es el bucle for-each (for mejorado).
        // Se lee: "Para cada String llamado 'str' dentro del array 'arr'..."
        for (String str : arr) {

            // Comprobamos que la palabra no esté vacía (por si el split genera huecos).
            if (!str.isEmpty()) {

                // getOrDefault(str, 0) busca la palabra. Si no existe, devuelve 0 por defecto.
                // Esto evita tener que hacer un 'if' para comprobar si la palabra ya está en el
                // mapa.
                int conteoActual = frecuencias.getOrDefault(str, 0);

                // .put() guarda o actualiza el par (Clave, Valor).
                frecuencias.put(str, conteoActual + 1);
            }
        }

        System.out.println("\n=== MAPA SIN ORDENAR (HashMap) ===");
        System.out.println(frecuencias); // Se imprimirá, pero el orden es aleatorio.

        // ========================================================================
        // PARTE 3: ORDENACIÓN DEL MAPA POR FRECUENCIA (DE MAYOR A MENOR)
        // ========================================================================

        // entrySet() nos devuelve un "Set" con todos los pares (clave-valor) del mapa.
        // .stream() convierte ese conjunto en una cinta transportadora de pares.
        Map<String, Integer> mapaOrdenado = frecuencias.entrySet().stream()

                // Ordenamos de mayor a menor frecuencia con lambda directa
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))

                // .collect() es la OPERACIÓN TERMINAL. Recoge el stream ordenado y crea un
                // NUEVO mapa.
                .collect(Collectors.toMap(

                        // ARGUMENTO 1: Cómo extraer la nueva CLAVE.
                        // Map.Entry::getKey es un Method Reference (::).
                        // Equivale a: (par) -> par.getKey()
                        Map.Entry::getKey,

                        // ARGUMENTO 2: Cómo extraer el nuevo VALOR.
                        // Map.Entry::getValue equivale a: (par) -> par.getValue()
                        Map.Entry::getValue,

                        // ARGUMENTO 3: Función de FUSIÓN (Merge).
                        // (e1, e2) -> e1 maneja colisiones de claves.
                        // Si llegan dos pares con la MISMA clave, se queda con el primero (e1).
                        (e1, e2) -> e1,

                        // ARGUMENTO 4: Proveedor del Mapa Final (¡CRUCIAL!).
                        // LinkedHashMap::new es un Constructor Reference (::).
                        // Le dice a Java: "Usa un LinkedHashMap".
                        // ¿POR QUÉ? Porque LinkedHashMap SÍ guarda el orden de inserción.
                        // Si usáramos HashMap aquí, perdería el orden que acabamos de hacer con
                        // .sorted().
                        LinkedHashMap::new));

        // 4. IMPRESIÓN FINAL
        System.out.println("\n=== MAPA ORDENADO POR FRECUENCIA (LinkedHashMap) ===");

        // Recorremos el mapa ordenado. entrySet() nos da los pares.
        for (Map.Entry<String, Integer> entrada : mapaOrdenado.entrySet()) {
            // entrada.getKey() devuelve la palabra.
            // entrada.getValue() devuelve la frecuencia.
            System.out.println("Palabra: " + entrada.getKey() + " | Frecuencia: " + entrada.getValue());
        }
    }
}
