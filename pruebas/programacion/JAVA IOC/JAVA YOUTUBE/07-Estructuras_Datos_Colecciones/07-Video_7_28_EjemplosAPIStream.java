import java.util.*;
import java.util.stream.Collectors;

class Video_7_28_EjemplosAPIStream {

    public static final String TITULO = "7-28 JAVA: Ejemplos API Stream ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=liBESrRvJNM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=169";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-28 - EJEMPLOS API STREAM (Strings y Constructor Ref)
        ================================================================

        EJEMPLO 4: Palabras unicas en un String
          String texto = "Ejemplo ejemplo texto texto texto";
          Arrays.stream(texto.split("\\\\s+"))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
          -> Set con {"ejemplo", "texto"} -> size = 2

        EJEMPLO 4b: Ordenar palabras alfabeticamente
          Arrays.stream(texto.split("\\\\s+"))
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.joining(" - "));

        EJEMPLO 5: Ordenar palabras por longitud (de mas a menos)
          .sorted(Comparator.comparingInt(String::length).reversed())

        EJEMPLO 6: Ordenar palabras por cantidad de letras 'a'
          Comparator<String> comp = (p1, p2) -> {
              int a1 = (int) p1.chars().filter(c -> c=='a'||c=='A').count();
              int a2 = (int) p2.chars().filter(c -> c=='a'||c=='A').count();
              return Integer.compare(a1, a2);
          };

        EJEMPLO 7: Filtrar solo palabras con 'a' y ordenar por cantidad
          .map(String::toLowerCase)
          .filter(p -> p.contains("a"))
          .sorted(comparador)

        EJEMPLO 8: Constructor reference con clase Trabajador
          class Trabajador { String nombre; int edad; double salario; }
          Function<String, Trabajador> refConstructor = Trabajador::new;
          nombres.stream()
                .map(refConstructor)
                .sorted(Comparator.comparing(Trabajador::getEdad))
                .collect(Collectors.toList());

        CLASE Trabajador:
          - Constructor(String nombre): asigna nombre, edad aleatoria 18-65
          - Getters: getNombre(), getEdad(), getSalario()
          - toString(): [nombre=XXX, edad=YY, salario=ZZ]
        ================================================================
        """;

    // ================================================================
    // CLASE TRABAJADOR (interna para el ejemplo)
    // ================================================================
    static class Trabajador {
        private String nombre;
        private int edad;
        private double salario;

        public Trabajador(String nombre) {
            this.nombre = nombre;
            this.edad = new Random().nextInt(18, 66);
            this.salario = new Random().nextDouble(20000, 60000);
        }

        public String getNombre() { return nombre; }
        public int getEdad() { return edad; }
        public double getSalario() { return salario; }

        @Override
        public String toString() {
            return String.format("[nombre=%s, edad=%d, salario=%.0f]", nombre, edad, salario);
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Palabras unicas en un String
        // ============================================================
        System.out.println("=== EJEMPLO 4: PALABRAS UNICAS ===");
        String texto = "Ejemplo ejemplo texto texto texto";
        Set<String> palabrasUnicas = Arrays.stream(texto.split("\\s+"))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
        System.out.println("  Texto: " + texto);
        System.out.println("  Palabras unicas: " + palabrasUnicas);
        System.out.println("  Numero: " + palabrasUnicas.size()); // 2
        System.out.println();

        // ============================================================
        // EJEMPLO 4b: Ordenar palabras alfabeticamente
        // ============================================================
        System.out.println("=== EJEMPLO 4b: PALABRAS ORDENADAS ALFABETICAMENTE ===");
        texto = "Ejemplo de ordenamiento alfabetico utilizando la API Stream de Java";
        String ordenadas = Arrays.stream(texto.split("\\s+"))
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.joining(" - "));
        System.out.println("  Texto: " + texto);
        System.out.println("  Ordenadas: " + ordenadas);
        System.out.println();

        // ============================================================
        // EJEMPLO 5: Ordenar palabras por longitud (de mas a menos)
        // ============================================================
        System.out.println("=== EJEMPLO 5: PALABRAS POR LONGITUD ===");
        String texto5 = "Voy a aprobar programacion con buena nota";
        List<String> porLongitud = Arrays.stream(texto5.split("\\s+"))
                .distinct()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
        System.out.println("  Texto: " + texto5);
        System.out.println("  Por longitud (mas a menos): " + porLongitud);
        System.out.println();

        // ============================================================
        // EJEMPLO 6: Ordenar palabras por cantidad de 'a'
        // ============================================================
        System.out.println("=== EJEMPLO 6: PALABRAS POR CANTIDAD DE 'A' ===");
        String texto6 = "Ordenar palabras segun la cantidad de veces que aparece la letra a";
        Comparator<String> compPorA = (p1, p2) -> {
            int a1 = (int) p1.chars().filter(c -> c == 'a' || c == 'A').count();
            int a2 = (int) p2.chars().filter(c -> c == 'a' || c == 'A').count();
            return Integer.compare(a1, a2);
        };
        List<String> ordenadasPorA = Arrays.stream(texto6.split("\\s+"))
                .sorted(compPorA)
                .collect(Collectors.toList());
        System.out.println("  Texto: " + texto6);
        System.out.println("  Ordenadas por #a: " + ordenadasPorA);
        System.out.println();

        // ============================================================
        // EJEMPLO 7: Solo palabras con 'a', ordenadas por cantidad
        // ============================================================
        System.out.println("=== EJEMPLO 7: SOLO PALABRAS CON 'A' ===");
        List<String> soloConA = Arrays.stream(texto6.split("\\s+"))
                .map(String::toLowerCase)
                .filter(p -> p.contains("a"))
                .sorted(compPorA)
                .collect(Collectors.toList());
        System.out.println("  Solo con 'a': " + soloConA);
        System.out.println();

        // ============================================================
        // EJEMPLO 8: Constructor reference + Comparator
        // ============================================================
        System.out.println("=== EJEMPLO 8: CONSTRUCTOR REFERENCE + COMPARATOR ===");
        List<String> nombres = Arrays.asList("Tom", "John", "Kal", "Ana");

        List<Trabajador> trabajadores = nombres.stream()
                .map(Trabajador::new)  // Constructor reference
                .sorted(Comparator.comparing(Trabajador::getEdad))
                .collect(Collectors.toList());

        System.out.println("  Nombres: " + nombres);
        System.out.println("  Trabajadores ordenados por edad:");
        trabajadores.forEach(t -> System.out.println("    " + t));
        System.out.println();

        // Ordenados por nombre
        System.out.println("  Ordenados por nombre:");
        nombres.stream()
                .map(Trabajador::new)
                .sorted(Comparator.comparing(Trabajador::getNombre))
                .forEach(t -> System.out.println("    " + t));
        System.out.println();

        System.out.println("================================================================");
        System.out.println("  FIN (TEMA 7 - V28: EJEMPLOS API STREAM)");
    }
}
