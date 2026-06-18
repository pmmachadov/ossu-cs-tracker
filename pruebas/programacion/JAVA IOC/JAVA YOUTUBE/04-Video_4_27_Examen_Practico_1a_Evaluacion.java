import java.util.Arrays;
import java.util.Scanner;

class Video_4_27_Examen_Practico_1a_Evaluacion {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "4-27 DAM - DAW: Examen JAVA Resuelto - PRACTICO 1a Evaluacion";
    public static final String URL = "https://www.youtube.com/watch?v=-w_PxsBWjgU&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=93";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 4";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // RESUMEN para el examen (CHULETA)
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ====================================================================
          RESUMEN RAPIDO - EXAMEN PRACTICO 1a EVALUACION (TEMA 4 - V27)
        ====================================================================

        --- ESTRUCTURA ---
        - Duracion: 2 horas
        - Material: CUALQUIERA (apuntes, libros, PDFs, USB)
        - Prohibido: acceso a Internet
        - Puntuacion total: 7.5 puntos
        - Menu (plantilla dada): 1.5 puntos
        - Cada ejercicio: 1.5 puntos

        --- MENU (plantilla proporcionada antes del examen) ---
        Se reutiliza un menu con switch que ya viene hecho:
        - Bucle do-while con opcion String
        - Switch con opciones "1" a "5"
        - Default: opcionNoValida()
        - Opcion 5: salir()

        --- EJERCICIO 1: FIGURA NUMERICA (1.5 puntos) ---
        static void ejercicio1(int n)
        - n debe estar entre 1 y 9, si no -> mensaje de error
        - Dibuja una figura cuadrada de lado = n*2-1
        - Empieza en n, decrece hasta 1, luego crece hasta n
        Ejemplo n=3:  3 2 1 2 3
                      3 2 1 2 3
                      3 2 1 2 3
                      3 2 1 2 3
                      3 2 1 2 3

        Logica:
        int lado = n * 2 - 1;
        for (int i = 0; i < lado; i++) {
            int numActual = n;
            for (int j = 0; j < lado; j++) {
                System.out.print(numActual + " ");
                if (j < n - 1) numActual--;
                else numActual++;
            }
            System.out.println();
        }

        --- EJERCICIO 2: MODIFICAR STRING (1.5 puntos) ---
        static void ejercicio2(String s)
        - Cambiar 'a'/'A'/'á'/'Á' por '4'
        - Cambiar 'e'/'E'/'é'/'É' por '3'
        - Cambiar 'i'/'I'/'í'/'Í' por '1'
        - Cambiar 'o'/'O'/'ó'/'Ó' por '0'
        - Cambiar espacio ' ' por '_'
        - Solo usar charAt() y length() (prohibido replace())
        - Usar switch con cases para mayusculas, minusculas y acentos
        - Si letra no coincide -> mantener la original
        Ejemplo: "Examen de Programacion" -> "3x4m3n_d3_Pr0gr4m4c10n"

        --- EJERCICIO 3: ARRAY SIN DUPLICADOS (1.5 puntos) ---
        static int[] ejercicio3(int[] nums)
        - Devuelve un NUEVO array con los elementos unicos
        - El array resultado debe tener el TAMANO EXACTO
        - Usa metodo auxiliar repetido() para comprobar si un
          elemento ya existe en el array de distintos

        Logica:
        1. Crear array distintos con nums[0]
        2. Recorrer nums desde i=1
        3. Si nums[i] NO esta en distintos -> expandir array
           - Crear aux = new int[distintos.length + 1]
           - Copiar distintos a aux
           - Anadir nums[i] al final de aux
           - Copiar aux a distintos
        4. Devolver distintos

        --- EJERCICIO 4: NUMERO OCTAL (recursivo, 1.5 puntos) ---
        static void ejercicio4(int n)
        - Comprobar si un numero esta en octal (solo digitos 0-7)
        - Si n < 0 -> mensaje: negativos no analizados
        - Caso base: n < 8 -> esta en octal
        - Si n % 10 > 7 -> no esta en octal
        - Si no: ejercicio4(n / 10) -> elimina ultimo digito y sigue

        Ejemplos:
        ejercicio4(1770) -> "Esta en octal"
        ejercicio4(1778) -> "NO esta en octal" (tiene un 8)
        ejercicio4(-5)   -> "Numeros negativos no se analizan"

        ====================================================================
        """;

    // -------------------------------------------------------------
    // METODOS DEL MENU (plantilla dada en el examen)
    // -------------------------------------------------------------

    // Opcion 1: Figura numerica
    static void ejercicio1(int n) {
        if (n < 1 || n > 9) {
            System.out.println("ERROR: El numero debe estar entre 1 y 9");
            return;
        }

        int lado = n * 2 - 1;

        for (int i = 0; i < lado; i++) {
            int numActual = n;
            for (int j = 0; j < lado; j++) {
                System.out.print(numActual + " ");
                if (j < n - 1) {
                    numActual--;
                } else {
                    numActual++;
                }
            }
            System.out.println();
        }
    }

    // Opcion 2: Modificar String
    static void ejercicio2(String s) {
        String nueva = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                // 'a' en todas sus formas -> 4
                case 'a': case 'A': case 'á': case 'Á': case 'à': case 'À':
                case 'ä': case 'Ä': case 'â': case 'Â':
                    nueva += '4';
                    break;
                // 'e' en todas sus formas -> 3
                case 'e': case 'E': case 'é': case 'É': case 'è': case 'È':
                case 'ë': case 'Ë': case 'ê': case 'Ê':
                    nueva += '3';
                    break;
                // 'i' en todas sus formas -> 1
                case 'i': case 'I': case 'í': case 'Í': case 'ì': case 'Ì':
                case 'ï': case 'Ï': case 'î': case 'Î':
                    nueva += '1';
                    break;
                // 'o' en todas sus formas -> 0
                case 'o': case 'O': case 'ó': case 'Ó': case 'ò': case 'Ò':
                case 'ö': case 'Ö': case 'ô': case 'Ô':
                    nueva += '0';
                    break;
                // espacio -> _
                case ' ':
                    nueva += '_';
                    break;
                // cualquier otra letra -> se mantiene igual
                default:
                    nueva += c;
                    break;
            }
        }

        System.out.println("String original: " + s);
        System.out.println("String modificada: " + nueva);
    }

    // Opcion 3: Array sin duplicados
    static int[] ejercicio3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // Empezamos con el primer elemento
        int[] distintos = new int[]{nums[0]};

        for (int i = 1; i < nums.length; i++) {
            // Si el elemento actual NO esta en el array de distintos
            if (!repetido(nums[i], distintos)) {
                // Crear array con un elemento mas
                int[] aux = new int[distintos.length + 1];

                // Copiar los elementos actuales
                for (int j = 0; j < distintos.length; j++) {
                    aux[j] = distintos[j];
                }

                // Anadir el nuevo elemento al final
                aux[aux.length - 1] = nums[i];

                // Copiar de vuelta a distintos
                distintos = new int[aux.length];
                for (int j = 0; j < aux.length; j++) {
                    distintos[j] = aux[j];
                }
            }
        }

        return distintos;
    }

    // Metodo auxiliar: comprueba si un entero existe en un array
    static boolean repetido(int n, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (n == array[i]) {
                return true;
            }
        }
        return false;
    }

    // Opcion 4: Numero octal (recursivo)
    static void ejercicio4(int n) {
        if (n < 0) {
            System.out.println("Numeros negativos no se analizan");
        } else if (n < 8) {
            System.out.println("El numero " + n + " esta en octal");
        } else if (n % 10 > 7) {
            System.out.println("El numero " + n + " NO esta en octal");
        } else {
            ejercicio4(n / 10);
        }
    }

    // Opcion 5: Salir
    static void salir() {
        System.out.println("Ha sido un honor servirle. Hasta la proxima!");
    }

    // Mensaje de opcion no valida
    static void opcionNoValida() {
        System.out.println("ERROR: Debe seleccionar una opcion entre 1 y 5");
    }

    // Mostrar menu
    static void mostrarMenu() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("  EXAMEN 1a EVALUACION - DAM/DAW");
        System.out.println("========================================");
        System.out.println("  1. Dibujar figura");
        System.out.println("  2. Modificar String");
        System.out.println("  3. Array sin duplicados");
        System.out.println("  4. Octal");
        System.out.println("  5. Salir");
        System.out.println("========================================");
        System.out.print("  Seleccione una opcion: ");
    }

    // -------------------------------------------------------------
    // METODO PRINCIPAL
    // -------------------------------------------------------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("EXAMEN PRACTICO 1a EVALUACION - DAM/DAW");
        System.out.println("2 horas - Con apuntes (sin Internet) - 7.5 puntos");
        System.out.println("Menu (plantilla): 1.5 ptos | Cada ejercicio: 1.5 ptos");
        System.out.println();

        do {
            mostrarMenu();
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("\n--- EJERCICIO 1: Figura numerica (n=3) ---");
                    ejercicio1(3);
                    System.out.println("\n--- EJERCICIO 1: Figura numerica (n=5) ---");
                    ejercicio1(5);
                    System.out.println("\n--- EJERCICIO 1: n=11 (error) ---");
                    ejercicio1(11);
                    break;
                case "2":
                    System.out.println("\n--- EJERCICIO 2: Modificar String ---");
                    ejercicio2("Examen de Programacion");
                    System.out.println();
                    ejercicio2("Habia una vez un arbol");
                    break;
                case "3":
                    System.out.println("\n--- EJERCICIO 3: Array sin duplicados ---");
                    int[] nums = {1, 2, 3, 1, 12, 3, 1, 2, 4, 5};
                    System.out.println("Array original: " + Arrays.toString(nums));
                    int[] sinDuplicados = ejercicio3(nums);
                    System.out.println("Sin duplicados: " + Arrays.toString(sinDuplicados));
                    break;
                case "4":
                    System.out.println("\n--- EJERCICIO 4: Octal (recursivo) ---");
                    ejercicio4(1770);    // octal
                    ejercicio4(1778);    // no octal (tiene 8)
                    ejercicio4(7);       // octal (1 digito)
                    ejercicio4(8);       // no octal
                    ejercicio4(-5);      // negativo
                    break;
                case "5":
                    salir();
                    break;
                default:
                    opcionNoValida();
                    break;
            }
        } while (!opcion.equals("5"));

        scanner.close();
    }
}
