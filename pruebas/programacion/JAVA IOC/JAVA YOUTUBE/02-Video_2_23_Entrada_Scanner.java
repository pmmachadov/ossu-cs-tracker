class Video_2_23_Entrada_Scanner {

    // ──────────────────────────────────────────────────────────────
    // Datos del video y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "2-23 JAVA: Entrada de datos - Clase Scanner ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=nvHVzPfdrAQ&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=37";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────

    public static final String RESUMEN =
        """
        ================================================================
          2-23 ENTRADA DE DATOS - CLASE SCANNER
        ================================================================

        La clase Scanner permite leer informacion introducida por teclado
        desde la consola.

        --- CREAR UN OBJETO SCANNER ---

        Para usar Scanner primero hay que importarla:
            import java.util.Scanner;

        Luego se crea un objeto Scanner asociado a la entrada del teclado:
            Scanner entrada = new Scanner(System.in);

        - "entrada" es el nombre del objeto (puede ser cualquier nombre)
        - "System.in" representa la entrada estandar (teclado)
        - Al escribir esto, Java auto-sugiere importar java.util.Scanner

        --- METODOS PRINCIPALES ---

        Metodo                  Que devuelve    Descripcion
        ------                  -------------   -----------
        next()                  String          Lee hasta espacio en blanco
        nextLine()              String          Lee toda la linea (hasta intro)
        nextInt()               int             Lee un numero entero
        nextFloat()             float           Lee un numero decimal (float)
        nextDouble()            double          Lee un numero decimal (double)
        hasNextInt()            boolean         Comprueba si lo siguiente es int
        hasNextDouble()         boolean         Comprueba si lo siguiente es double

        --- DETALLE DE CADA METODO ---

        1. next()
           Lee lo que se ha escrito por teclado hasta encontrar un espacio
           en blanco. Solo captura una palabra.
           Ej: Si escribo "Edu Perez", next() -> "Edu"

        2. nextLine()
           Lee todo lo escrito hasta pulsar INTRO (salto de linea).
           Captura la linea completa, incluyendo espacios.
           Ej: Si escribo "Edu Perez", nextLine() -> "Edu Perez"

        3. nextInt()
           Lee un numero entero desde el teclado.
           Si no se escribe un numero valido, se produce un error en
           ejecucion (InputMismatchException).

        4. nextFloat() / nextDouble()
           Lee un numero decimal (float o double).
           Mismo riesgo: si no se introduce un numero valido, error.

        5. hasNextInt() / hasNextDouble()
           Devuelve true si lo siguiente que se va a leer es un entero
           (o double). Se usa como condicion en bucles para validar
           la entrada antes de leer.

        --- PROBLEMA DEL BUFFER (nextInt + nextLine) ---

        Cuando se usa nextInt() (o nextFloat, nextDouble), el metodo lee
        el numero pero DEJA el salto de linea (\\n) en el buffer.

        Esto provoca que si despues se usa nextLine(), este se encuentra
        el \\n y lo consume inmediatamente, sin esperar a que el usuario
        escriba nada. La variable String se queda vacia.

        Ejemplo problematico:
            System.out.print("Introduzca un numero: ");
            int n = entrada.nextInt();       // Lee el 5, deja \\n
            System.out.print("Introduzca su nombre: ");
            String nombre = entrada.nextLine();  // Lee el \\n -> vacio

        Solucion: limpiar el buffer con un nextLine() extra:
            int n = entrada.nextInt();
            entrada.nextLine();  // Consume el \\n del buffer
            String nombre = entrada.nextLine();  // Ahora funciona

        --- EJEMPLO COMPLETO (codigo del video) ---

        import java.util.Scanner;

        public class Entrada {
            public static void main(String[] args) {
                Scanner entrada = new Scanner(System.in);
                String nombre;
                int n;

                System.out.print("Introduzca un numero entero: ");
                n = entrada.nextInt();
                entrada.nextLine();  // Limpiar buffer

                System.out.println("El cuadrado es: " + Math.pow(n, 2));

                System.out.print("Introduzca su nombre: ");
                nombre = entrada.nextLine();

                System.out.println("Hola " + nombre + "!!");

                entrada.close();  // Cerrar el Scanner (buena practica)
            }
        }

        --- NOMBRE DEL OBJETO SCANNER ---

        El nombre del objeto Scanner es el identificador que se usa para
        llamar a sus metodos. Si se crea como:
            Scanner teclado = new Scanner(System.in);
        Entonces se usa:  teclado.nextInt(), teclado.nextLine(), etc.

        --- CERRAR EL SCANNER ---

        Al final del programa se debe cerrar el Scanner:
            entrada.close();
        Esto libera los recursos asociados. Si no se cierra, Java muestra
        una advertencia (warning), no un error.

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Scanner lectura por teclado: import java.util.Scanner;
        * Crear Scanner: new Scanner(System.in)
        * next() -> lee hasta espacio
        * nextLine() -> lee hasta intro (linea completa)
        * nextInt() -> lee entero
        * nextDouble() -> lee double
        * nextFloat() -> lee float
        * Despues de nextInt() siempre limpiar con nextLine()
        * El \\n del buffer se queda despues de leer numeros
        * hasNextInt() / hasNextDouble() para validar entrada
        * Cerrar Scanner al final: entrada.close()
        * Si no se cierra: warning, no error
        ================================================================
        """;

    // ──────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        mostrarInformacion();

        // ── Ejemplos del video ──
        System.out.println();
        System.out.println("============================================");
        System.out.println("   EJEMPLOS PRACTICOS - CLASE SCANNER");
        System.out.println("============================================");
        System.out.println();

        // Creamos el Scanner
        java.util.Scanner entrada = new java.util.Scanner(System.in);

        // Ejemplo 1: nextInt() con limpieza de buffer
        System.out.println("--- Ejemplo 1: nextInt() + nextLine() ---");
        System.out.print("Introduzca un numero entero: ");
        int n = entrada.nextInt();
        entrada.nextLine();  // Limpiar buffer del intro
        System.out.println("El cuadrado es: " + Math.pow(n, 2));
        System.out.println();

        // Ejemplo 2: nextLine() para leer nombre completo
        System.out.println("--- Ejemplo 2: nextLine() ---");
        System.out.print("Introduzca su nombre: ");
        String nombre = entrada.nextLine();
        System.out.println("Hola " + nombre + "!!");
        System.out.println();

        // Ejemplo 3: next() vs nextLine()
        System.out.println("--- Ejemplo 3: next() vs nextLine() ---");
        System.out.print("Introduzca su nombre y apellido: ");
        String soloNombre = entrada.next();
        String resto = entrada.nextLine();
        System.out.println("next() tomo:     '" + soloNombre + "'");
        System.out.println("nextLine() tomo: '" + resto.trim() + "'");
        System.out.println();

        // Ejemplo 4: nextDouble()
        System.out.println("--- Ejemplo 4: nextDouble() ---");
        System.out.print("Introduzca un numero decimal: ");
        double decimal = entrada.nextDouble();
        entrada.nextLine();  // Limpiar buffer
        System.out.println("El doble es: " + (decimal * 2));
        System.out.println();

        // Cerrar Scanner
        entrada.close();
        System.out.println("Scanner cerrado correctamente.");
    }

    // ──────────────────────────────────────────────────────────────

    public static void mostrarInformacion() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("   INFORMACION DEL VIDEO");
        System.out.println("============================================");
        System.out.println("Video:      " + TITULO);
        System.out.println("Canal:      " + CANAL);
        System.out.println("URL Canal:  " + URL_CANAL);
        System.out.println("URL Video:  " + URL);
        System.out.println("Playlist:   " + PLAYLIST);
        System.out.println("Repo:       " + REPO);
        System.out.println();
        System.out.println(RESUMEN);
    }
}
