import java.util.*;

class Video_7_16_HashMap {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "7-16 JAVA: HashMap DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=eplBXJarh1A&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=157";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-16 - HASHMAP
        ================================================================

        Video:        7-16 JAVA: HashMap
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7

        --- RESUMEN (transcripcion) ---

        HashMap<K,V> implementa Map usando una TABLA HASH.
        Es la implementacion mas rapida (O(1) constante).
        No garantiza orden de insercion.

        Caracteristicas:
          - Claves unicas, valores duplicables
          - Permite 1 clave nula y multiples valores nulos
          - No tiene metodos exclusivos (usa los de Map)
          - O(1) en put, get, remove (con buena funcion Hash)
          - No garantiza orden al iterar

        --- EJEMPLO 1: CONTAR LETRAS ---

        HashMap<Character, Integer> letras = new HashMap<>();
        String texto = "Cadena de ejemplo con caracteres...";

        for (char c : texto.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                letras.put(c, letras.getOrDefault(c, 0) + 1);
            }
        }

        // getOrDefault: si la clave NO existe -> devuelve 0
        // getOrDefault: si la clave SI existe -> devuelve el valor actual
        // Se suma 1 para incrementar el contador
        // put reemplaza el valor si la clave ya existe

        --- EJEMPLO 2: CONTAR PALABRAS ---

        HashMap<String, Integer> frecPalabras = new HashMap<>();
        String[] palabras = texto.toLowerCase().split("\\\\s+");

        for (String p : palabras) {
            frecPalabras.put(p, frecPalabras.getOrDefault(p, 0) + 1);
        }

        // split("\\\\s+") divide por uno o mas espacios en blanco
        // Incluye espacios, tabulaciones, saltos de linea

        --- EJEMPLO 3: LIMPIAR CARACTERES ESPECIALES ---

        1. Reemplazar \\\\n por espacios: texto.replaceAll("\\\\\\\\n", " ")
        2. Eliminar lo que no sean letras ni espacios:
           texto.replaceAll("[^a-zA-Z\\\\\\\\u00f1\\\\\\\\u00d1\\\\\\\\u00e1\\\\\\\\u00e9...\\\\s]", "")
        3. split("\\\\s+") para obtener palabras
        4. IMPORTANTE: orden de las operaciones
           - Primero reemplazar \\\\n por espacios
           - Luego eliminar caracteres no letra
           - Si se invierte, las palabras pueden quedar unidas

        --- RECORRER MAP CON ENTRYSET ---

        for (Map.Entry<Character, Integer> e : letras.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

        --- CONCEPTOS CLAVE ---

        - HashMap: tabla Hash, O(1), sin orden
        - getOrDefault(clave, defaultValue) -> evita nulls
        - put(clave, getOrDefault(clave, 0) + 1) -> incrementar contador
        - isLetter() para filtrar solo letras
        - split("\\\\s+") para dividir por espacios
        - replaceAll() para limpiar caracteres especiales
        - entrySet() para recorrer pares clave-valor
        - Orden al limpiar texto: primero \\\\n -> espacios, luego eliminar resto
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: CONTAR LETRAS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 1: CONTAR LETRAS");
        System.out.println("=========================================");

        String texto = "Cadena de ejemplo!!! Con caracteres \\nespeciales, n\u00fameros 2023 y m\u00e1s.";
        System.out.println("  Texto original: " + texto);
        System.out.println();

        HashMap<Character, Integer> letras = new HashMap<>();

        for (char c : texto.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                letras.put(c, letras.getOrDefault(c, 0) + 1);
            }
        }

        System.out.println("  Frecuencia de letras:");
        for (Map.Entry<Character, Integer> e : letras.entrySet())
            System.out.println("    " + e.getKey() + ": " + e.getValue());
        System.out.println();

        // ============================================================
        // EJEMPLO 2: CONTAR PALABRAS (basico)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 2: CONTAR PALABRAS");
        System.out.println("=========================================");

        String texto2 = "Hoy es un d\u00eda de sol de primavera de 2023";
        System.out.println("  Texto: " + texto2);

        HashMap<String, Integer> frecPalabras = new HashMap<>();
        String[] palabras = texto2.toLowerCase().split("\\s+");

        for (String p : palabras) {
            frecPalabras.put(p, frecPalabras.getOrDefault(p, 0) + 1);
        }

        System.out.println("  Frecuencia de palabras:");
        for (Map.Entry<String, Integer> e : frecPalabras.entrySet())
            System.out.println("    " + e.getKey() + ": " + e.getValue());
        System.out.println("  (La palabra \"de\" aparece 3 veces)");
        System.out.println();

        // ============================================================
        // EJEMPLO 3: LIMPIAR CARACTERES ESPECIALES
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 3: LIMPIAR CARACTERES");
        System.out.println("=========================================");

        String textoSucio = "\u00a1Hoy es un ejemplo!!!\nCon caracteres 2023 especiales.\nFin.";
        System.out.println("  Texto sucio: " + textoSucio);
        System.out.println();

        // Proceso de limpieza
        String textoLimpio = textoSucio
            .toLowerCase()
            .replaceAll("\\n", " ")           // 1. saltos de linea -> espacios
            .replaceAll("[^a-zA-Z\\u00f1\\u00d1\\u00e1\\u00e9\\u00ed\\u00f3\\u00fa\\u00c1\\u00c9\\u00cd\\u00d3\\u00da\\u00fc\\u00dc\\s]", ""); // 2. eliminar no letras

        System.out.println("  Texto limpio: " + textoLimpio);
        System.out.println();

        HashMap<String, Integer> frecLimpia = new HashMap<>();
        for (String p : textoLimpio.split("\\s+")) {
            if (!p.isEmpty()) {
                frecLimpia.put(p, frecLimpia.getOrDefault(p, 0) + 1);
            }
        }

        System.out.println("  Frecuencia (limpia):");
        for (Map.Entry<String, Integer> e : frecLimpia.entrySet())
            System.out.println("    " + e.getKey() + ": " + e.getValue());
        System.out.println("  (Sin caracteres especiales ni numeros)");
        System.out.println();

        // ============================================================
        // DEMO: ORDEN DE LIMPIEZA (IMPORTANTE)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  IMPORTANTE: ORDEN DE LIMPIEZA");
        System.out.println("=========================================");
        System.out.println("  CORRECTO: 1. \\\\n -> espacio  2. eliminar no letras");
        System.out.println("  Cuando se invierte: las palabras quedan UNIDAS");
        System.out.println();

        // Orden INCORRECTO
        String mal = textoSucio.toLowerCase()
            .replaceAll("[^a-zA-Z\\u00f1\\u00d1\\u00e1\\u00e9\\u00ed\\u00f3\\u00fa\\u00c1\\u00c9\\u00cd\\u00d3\\u00da\\u00fc\\u00dc\\s]", "")
            .replaceAll("\\n", " ");
        System.out.println("  ORDEN INCORRECTO (eliminar luego \\\\n):");
        System.out.println("  \"" + mal + "\"");
        System.out.println("  (ejemplo y fin aparecen juntos!)");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V16: HASHMAP)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - HashMap: tabla Hash, O(1), sin orden");
        System.out.println("  - getOrDefault(clave, default) para evitar nulls");
        System.out.println("  - put(clave, getOrDefault + 1) para incrementar contadores");
        System.out.println("  - Character.isLetter() para filtrar letras");
        System.out.println("  - split(\"\\\\s+\") para dividir por espacios");
        System.out.println("  - replaceAll() para limpiar caracteres");
        System.out.println("  - Orden de limpieza: \\\\n primero, luego no letras");
    }
}
