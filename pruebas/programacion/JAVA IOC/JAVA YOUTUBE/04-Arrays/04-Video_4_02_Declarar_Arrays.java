class Video_4_02_Declarar_Arrays {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-02 JAVA: Declarar Arrays ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=iXrWbslAPxs&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=67";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 4";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // RESUMEN para el examen (CHULETA)
    // -------------------------------------------------------------
    public static final String RESUMEN = """
                                           ====================================================================
                                             RESUMEN RAPIDO - DECLARAR ARRAYS (TEMA 4 - V2)
                                           ====================================================================

                                           --- INICIALIZACION DIRECTA CON VALORES ---
                                           Se pueden declarar e inicializar arrays directamente con llaves {},
                                           SIN usar 'new' ni especificar el tamaño (se deduce automaticamente).

                                           int[] notas = {6, 7, 8, 1, 10, 5};
                                             -> Array de 6 enteros. Longitud automatica: notas.length = 6

                                           String[] nombres = {"Juan", "Maria", "Pedro"};
                                             -> Array de 3 Strings. Longitud automatica: nombres.length = 3

                                           --- REGLAS DE LA INICIALIZACION DIRECTA ---
                                           * Los valores van entre llaves { } separados por comas.
                                           * Los Strings deben ir entre comillas dobles.
                                           * El tipo del array debe coincidir con los valores.
                                           * NO se puede usar en dos lineas separadas (declaracion e inicializacion por separado SOLO con 'new').

                                           --- RECORRER ARRAYS (bucle for clasico) ---
                                           int[] notas = {6, 7, 8, 1, 10, 5};
                                           for (int i = 0; i < notas.length; i++) {
                                               System.out.println(notas[i]);
                                           }
                                           * Siempre: i empieza en 0, termina en length-1.
                                           * notas.length es el numero de elementos.
                                           * notas[notas.length - 1] es el ultimo elemento.
                                           * Si accedes a notas[notas.length] -> ArrayIndexOutOfBoundsException

                                           --- MOSTRAR ARRAYS EN UNA LINEA ---
                                           for (int i = 0; i < notas.length; i++) {
                                               System.out.print(\"[\" + notas[i] + \"] \");
                                           }
                                           -> Salida: [6] [7] [8] [1] [10] [5]

                                           --- METODO QUE MUESTRA UN ARRAY ---
                                           static void mostrarArray(int[] n) {
                                               for (int i = 0; i < n.length; i++) {
                                                   System.out.print(\"[\" + n[i] + \"] \");
                                               }
                                               System.out.println();
                                           }

                                           --- METODO QUE DEVUELVE UN ARRAY ---
                                           static int[] crearArray(int elementos) {
                                               int[] array = new int[elementos];
                                               Random r = new Random();
                                               for (int i = 0; i < array.length; i++) {
                                                   array[i] = r.nextInt(100);  // aleatorio entre 0 y 99
                                               }
                                               return array;
                                           }
                                           * Para devolver un array: indicar tipo + corchetes en la firma (int[]).
                                           * Se puede pasar como parametro a otro metodo directamente:
                                             mostrarArray(crearArray(10));

                                           --- CLASE RANDOM ---
                                           import java.util.Random;
                                           Random r = new Random();
                                           r.nextInt()       -> entero aleatorio (rango completo)
                                           r.nextInt(100)    -> entero entre 0 y 99 (100 NO incluido)
                                           r.nextInt(min, max) -> entero entre min y max-1

                                           --- PERSONALIZAR METODOS CON PARAMETROS ---
                                           static int[] crearArray(int elementos, int max) {
                                               int[] array = new int[elementos];
                                               Random r = new Random();
                                               for (int i = 0; i < array.length; i++) {
                                                   array[i] = r.nextInt(max);  // entre 0 y max-1
                                               }
                                               return array;
                                           }

                                           --- MOSTRAR ARRAY CON SEPARADOR PERSONALIZADO ---
                                           static void mostrarArray(int[] n, String separador) {
                                               for (int i = 0; i < n.length - 1; i++) {
                                                   System.out.print(n[i] + separador);
                                               }
                                               System.out.println(n[n.length - 1]);  // ultimo sin separador
                                           }
                                           * El ultimo elemento se muestra FUERA del bucle para evitar separador al final.
                                           * El separador puede ser cualquier String: \" - \", \" | \", \"--\", etc.
                                           *
                                           *
                                           * import java.util.Random;
                                           *
                                           * ------------------------------

                          import java.util.Random;

            public class pruebasJAVA {
                public static void main(String[] args) {
                    int[] array = crearArray(10);
                    mostrarArray(array);
                }

                public static int[] crearArray(int elementos) {
                    int[] array = new int[elementos];
                    Random r = new Random();
                    for (int i = 0; i < array.length; i++) {
                        array[i] = r.nextInt(100);
                    }
                    return array;
                }

                static void mostrarArray(int[] n) {
                    for (int i = 0; i < n.length; i++) {
                        System.out.println("[" + n[i] + "]");
                    }
                }
            }


                        * ------------------------------


                                           --- CONSEJOS ---
                                           * Inicializacion directa con { } es mas rapida que new + asignar uno a uno.
                                           * Para arrays grandes o con valores aleatorios, usar new y llenar con bucle.
                                           * Los metodos que trabajan con arrays suelen recibir el array como parametro.
                                           * Se puede encadenar: mostrarArray(crearArray(10, 100));

                                           ====================================================================
                                           """;

    // -------------------------------------------------------------
    // METODO PRINCIPAL
    // -------------------------------------------------------------

    public static void main(String[] args) {

        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: Inicializacion directa con llaves (enteros)
        // ============================================================

        separador("EJEMPLO 1: Inicializacion directa int[]");
        int[] notas = { 6, 7, 8, 1, 10, 5 };
        System.out.println("  int[] notas = {6, 7, 8, 1, 10, 5};");
        System.out.println("  Longitud: " + notas.length + " elementos");
        System.out.print("  Contenido: ");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i] + " ");
        }
        System.out.println();
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Inicializacion directa con Strings
        // ============================================================

        separador("EJEMPLO 2: Inicializacion directa String[]");
        String[] nombres = { "Juan", "Maria", "Pedro" };
        System.out.println("  String[] nombres = {\"Juan\", \"Maria\", \"Pedro\"};");
        System.out.println("  Longitud: " + nombres.length + " elementos");
        System.out.print("  Contenido: ");
        for (int i = 0; i < nombres.length; i++) {
            System.out.print("[" + nombres[i] + "] ");
        }
        System.out.println();
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Mostrar array entre corchetes
        // ============================================================

        separador("EJEMPLO 3: Mostrar array formateado");
        int[] arr = { 1, 2, 5, 8, 9, 15, 24, 8 };
        System.out.println("  int[] arr = {1, 2, 5, 8, 9, 15, 24, 8};");
        System.out.print("  arr = ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i] + "] ");
        }
        System.out.println();
        System.out.println("  Longitud: " + arr.length);
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Metodo mostrarArray()
        // ============================================================

        separador("EJEMPLO 4: Metodo mostrarArray(int[])");
        int[] valores = { 10, 20, 30, 40, 50 };
        System.out.println("  int[] valores = {10, 20, 30, 40, 50};");
        System.out.print("  mostrarArray(valores) -> ");
        mostrarArray(valores);
        System.out.println();

        // ============================================================
        // EJEMPLO 5: Metodo crearArray() con Random
        // ============================================================

        separador("EJEMPLO 5: Metodo crearArray(int elementos)");
        System.out.println("  int[] aleatorios = crearArray(10);  // 10 elementos entre 0 y 99");
        int[] aleatorios = crearArray(10);
        System.out.print("  Resultado: ");
        mostrarArray(aleatorios);
        System.out.println();

        // ============================================================
        // EJEMPLO 6: Crear array con valor maximo
        // ============================================================

        separador("EJEMPLO 6: crearArray(int elementos, int max)");
        System.out.println("  int[] nums = crearArray(10, 3);  // 10 elementos entre 0 y 2");
        int[] nums = crearArray(10, 3);
        System.out.print("  Resultado (0..2): ");
        mostrarArray(nums);
        System.out.println();

        // ============================================================
        // EJEMPLO 7: Array de 100 elementos entre 0 y 999
        // ============================================================

        separador("EJEMPLO 7: Array grande (100 elementos, max 1000)");
        int[] grande = crearArray(100, 1000);
        System.out.println("  int[] grande = crearArray(100, 1000);  // 100 elementos entre 0 y 999");
        System.out.print("  Primeros 10: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(grande[i] + " ");
        }
        System.out.println("...");
        System.out.println("  Longitud: " + grande.length);
        System.out.println();

        // ============================================================
        // EJEMPLO 8: Llamada encadenada
        // ============================================================

        separador("EJEMPLO 8: Llamada encadenada");
        System.out.println("  mostrarArray(crearArray(10, 100));  // 10 elementos entre 0 y 99");
        System.out.print("  Resultado: ");
        mostrarArray(crearArray(10, 100));
        System.out.println();

        // ============================================================
        // EJEMPLO 9: Array con separador personalizado
        // ============================================================

        separador("EJEMPLO 9: mostrarArray con separador personalizado");
        int[] datos = { 5, 10, 15, 20, 25 };
        System.out.println("  int[] datos = {5, 10, 15, 20, 25};");
        System.out.print("  Con separador \" - \": ");
        mostrarArray(datos, " - ");
        System.out.print("  Con separador \" | \": ");
        mostrarArray(datos, " | ");
        System.out.print("  Con separador \"--\": ");
        mostrarArray(datos, "--");
        System.out.println();

        // ============================================================
        // EJEMPLO 10: Demostracion de ArrayIndexOutOfBounds
        // ============================================================

        separador("EJEMPLO 10: ArrayIndexOutOfBounds (DEMO)");
        System.out.println("  int[] demo = {1, 2, 3};  // indices: 0, 1, 2");
        System.out.println("  System.out.println(demo[3]);  // ERROR! Indice 3 no existe");
        System.out.println("  (Comentado para no romper la ejecucion)");
        System.out.println("  // demo[3] -> ArrayIndexOutOfBoundsException");
        System.out.println();

        // ============================================================
        // COMPARACION DE RESULTADOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ej 1: Inicializacion directa int[]       -> notas = {6,7,8,1,10,5}, length=6");
        System.out.println("Ej 2: Inicializacion directa String[]    -> nombres = {Juan, Maria, Pedro}");
        System.out.println("Ej 3: Mostrar con [corchetes]            -> [1] [2] [5] [8] [9] [15] [24] [8]");
        System.out.println("Ej 4: Metodo mostrarArray(int[])         -> reutilizable para cualquier array");
        System.out.println("Ej 5: crearArray(10) con Random          -> 10 aleatorios entre 0 y 99");
        System.out.println("Ej 6: crearArray(10, 3)                  -> 10 aleatorios entre 0 y 2");
        System.out.println("Ej 7: crearArray(100, 1000)              -> 100 aleatorios entre 0 y 999");
        System.out.println("Ej 8: Llamada encadenada                 -> mostrarArray(crearArray(10, 100))");
        System.out.println("Ej 9: Separador personalizado            -> ' - ', ' | ', '--'");
        System.out.println("Ej 10: ArrayIndexOutOfBoundsException    -> error si indice >= length");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Ejercicios con arrays en Java");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODOS AUXILIARES
    // -------------------------------------------------------------

    // Metodo que muestra un array de enteros entre corchetes
    public static void mostrarArray(int[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.print("[" + n[i] + "] ");
        }
        System.out.println();
    }

    // Metodo que crea un array con valores aleatorios (0..99)
    public static int[] crearArray(int elementos) {
        int[] array = new int[elementos];
        java.util.Random r = new java.util.Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(100); // aleatorio entre 0 y 99
        }
        return array;
    }

    // Metodo que crea un array con valores aleatorios (0..max-1)
    public static int[] crearArray(int elementos, int max) {
        int[] array = new int[elementos];
        java.util.Random r = new java.util.Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(max); // aleatorio entre 0 y max-1
        }
        return array;
    }

    // Metodo que muestra un array con un separador personalizado
    // El ultimo elemento se muestra sin separador al final
    public static void mostrarArray(int[] n, String separador) {
        for (int i = 0; i < n.length - 1; i++) {
            System.out.print(n[i] + separador);
        }
        System.out.println(n[n.length - 1]); // ultimo elemento sin separador
    }

    public static void separador(String titulo) {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("  " + titulo);
        System.out.println("============================================================");
    }
}
