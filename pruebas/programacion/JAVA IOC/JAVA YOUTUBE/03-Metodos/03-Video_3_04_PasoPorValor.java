class Video_3_04_PasoPorValor {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "3-04 JAVA: Paso por valor ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=pWf9Q95NFtY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=57";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 3";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // RESUMEN para el examen (CHULETA)
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ====================================================================
          RESUMEN RAPIDO - PASO POR VALOR (TEMA 3 - V4)
        ====================================================================

        --- QUE ES EL PASO POR VALOR ---
        En Java, cuando pasamos una variable como parametro a un metodo,
        lo que realmente enviamos es una COPIA del valor de esa variable.

        El metodo recibe una copia, NO la variable original.
        Si dentro del metodo modificamos el parametro, la variable
        original NO se modifica.

        --- POR QUE NO EXISTEN PUNTEROS EN JAVA ---
        En C/C++ existen los punteros: variables que apuntan a una
        direccion de memoria. En Java los punteros NO existen como
        tipo de dato explicito, pero cuando trabajamos con objetos
        internamente se usan referencias (punteros "escondidos").

        Con tipos primitivos (int, double, char, boolean, etc.):
          - Se pasa una COPIA del valor.
          - La variable original NUNCA se modifica desde el metodo.

        Con objetos:
          - Se pasa una COPIA de la referencia (direccion de memoria).
          - El objeto original SI se puede modificar desde el metodo.
          - Pero la referencia en si (a que objeto apunta) no se puede
            cambiar desde el metodo (seguiremos viendo esto en POO).

        --- EJEMPLO CLASICO ---
            int numb = 5;
            int doble = doble(numb);  // Se pasa una copia del 5

            static int doble(int a) {
                a = a * 2;     // a = 10, pero numb sigue siendo 5
                return a;      // devuelve 10
            }

            Resultado: numb = 5, doble = 10

        --- VARIABLES CON MISMO NOMBRE ---
        Es valido que el parametro del metodo se llame igual que la
        variable del main (ambas "numb"). Son variables DISTINTAS
        porque tienen ambitos diferentes:
          - La variable del main pertenece al ambito del main.
          - El parametro formal pertenece al ambito del metodo.
          - Son independientes, aunque se llamen igual.

        --- TAMBIEN VALIDO: METODO CON MISMO NOMBRE ---
        Un metodo y una variable pueden llamarse igual (ej: "doble").
        El compilador distingue porque los metodos llevan parentesis:
          - doble     -> variable
          - doble()   -> metodo

        --- EL MAIN DESGLOSADO ---
        public static void main(String[] args)

        - public:    accesible desde cualquier parte.
        - static:    se puede llamar sin crear un objeto.
        - void:      no devuelve nada.
        - main:      nombre del metodo (punto de entrada).
        - String[]:  array de strings (parametros de linea de comandos).
        - args:      nombre del parametro (los argumentos al ejecutar).

        La JVM (Java Virtual Machine) busca el metodo main y lo ejecuta
        como punto de inicio de la aplicacion.

        --- PARAMETROS POR CONSOLA ---
        java MiClase arg1 arg2 arg3
        -> args[0] = "arg1", args[1] = "arg2", args[2] = "arg3"

        Se puede recorrer args con un bucle para procesar los parametros.

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Paso por valor: se envia una COPIA del valor, NO la variable.
        * Modificar el parametro dentro del metodo NO afecta al original.
        * Java NO tiene punteros explicitos (como C/C++), pero los
          objetos se pasan por referencia implícitamente.
        * Con primitivos: la original NUNCA se modifica.
        * Un metodo y una variable pueden llamarse igual (parentesis
          los distingue).
        * public static void main(String[] args): punto de entrada.
        * args contiene los argumentos de linea de comandos.
        * La JVM ejecuta el main automaticamente al iniciar.

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
        // EJEMPLO 1: Paso por valor con tipos primitivos
        // ============================================================

        separador("EJEMPLO 1: Paso por valor - copia del valor");
        System.out.println("  Explicacion: Al pasar una variable a un metodo,");
        System.out.println("  Java envia una COPIA del valor, no la variable.");
        System.out.println();

        int numb = 10;
        System.out.println("  Antes de llamar al metodo:");
        System.out.println("    numb = " + numb + "  (variable original)");

        int doble = doble(numb);  // Se pasa una copia del valor de numb (10)

        System.out.println("  Despues de llamar a doble(numb):");
        System.out.println("    numb = " + numb + "   (NO ha cambiado, sigue siendo 10)");
        System.out.println("    doble = " + doble + "  (resultado del metodo: 10*2=20)");
        System.out.println();
        System.out.println("  |=> Dentro del metodo doble(), numb se multiplica por 2,");
        System.out.println("  |   pero eso solo afecta a la COPIA local del metodo.");
        System.out.println("  |   La variable original del main NO se modifica.");
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Mismo nombre de variable (ambito diferente)
        // ============================================================

        separador("EJEMPLO 2: Parametro con el mismo nombre que la variable del main");
        System.out.println("  El parametro del metodo puede llamarse igual que la");
        System.out.println("  variable del main. Son variables DISTINTAS con");
        System.out.println("  ambitos diferentes.");
        System.out.println();

        int num = 5;
        int resultado = metodoMismoNombre(num);  // Se pasa una copia de num=5

        System.out.println("  Variable del main: num = " + num);
        System.out.println("  Resultado del metodo: resultado = " + resultado);
        System.out.println("  (Dentro del metodo, num es un parametro formal,");
        System.out.println("   independiente del num del main)");
        System.out.println();

        // ============================================================
        // EJEMPLO 3: El metodo NO modifica la variable original
        // ============================================================

        separador("EJEMPLO 3: Verificacion - el original nunca cambia");
        System.out.println("  Demostracion: aunque multipliquemos dentro del metodo,");
        System.out.println("  la variable original permanece intacta.");
        System.out.println();

        int valorOriginal = 7;
        System.out.println("  valorOriginal antes = " + valorOriginal);

        int result = multiplicarPorDiez(valorOriginal);
        System.out.println("  result = " + result + " (7*10=70)");

        System.out.println("  valorOriginal despues = " + valorOriginal + " (sigue siendo 7)");
        System.out.println();
        System.out.println("  CONCLUSION: La variable original JAMAS se modifica");
        System.out.println("  cuando pasamos tipos primitivos por valor.");
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Metodo y variable con el mismo nombre
        // ============================================================

        separador("EJEMPLO 4: Metodo y variable con el mismo nombre");
        System.out.println("  Un metodo y una variable pueden llamarse igual.");
        System.out.println("  El compilador los distingue por los parentesis.");
        System.out.println();

        // Variable llamada 'doble'
        int dobleVariable = 100;
        // Metodo llamado 'doble(int)'
        int dobleMetodo = doble(dobleVariable);

        System.out.println("  Variable 'doble' (nombre de variable) = " + dobleVariable);
        System.out.println("  Metodo doble(" + dobleVariable + ") devuelve = " + dobleMetodo);
        System.out.println("  (El compilador sabe que doble() con parentesis es el metodo)");
        System.out.println();

        // ============================================================
        // EJEMPLO 5: Entendiendo el Main
        // ============================================================

        separador("EJEMPLO 5: El metodo main(String[] args)");
        System.out.println("  Desglose de la cabecera del main:");
        System.out.println("    public  -> accesible desde cualquier clase");
        System.out.println("    static  -> se ejecuta sin crear un objeto");
        System.out.println("    void    -> no devuelve nada");
        System.out.println("    main    -> nombre del metodo (punto de entrada)");
        System.out.println("    String[] args -> parametros de linea de comandos");
        System.out.println();

        // Mostrar argumentos si los hay
        System.out.println("  Argumentos recibidos: " + args.length);
        if (args.length > 0) {
            System.out.println("  Lista de argumentos:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("    args[" + i + "] = " + args[i]);
            }
        } else {
            System.out.println("  (No se pasaron argumentos al ejecutar)");
        }
        System.out.println();
        System.out.println("  NOTA: Para pasar argumentos, ejecutar:");
        System.out.println("    java Video_3_04_PasoPorValor.java hola mundo 123");
        System.out.println();

        // ============================================================
        // EJEMPLO 6: Comparacion paso por valor vs por referencia
        // ============================================================

        separador("EJEMPLO 6: Paso por valor en otros lenguajes (concepto)");
        System.out.println("  En C/C++ existen los PUNTEROS:");
        System.out.println("    - Un puntero almacena una direccion de memoria.");
        System.out.println("    - Se puede modificar la variable ORIGINAL desde");
        System.out.println("      una funcion usando el puntero (paso por referencia).");
        System.out.println();
        System.out.println("  En JAVA NO existen punteros explicitos:");
        System.out.println("    - Con primitivos: solo paso por valor.");
        System.out.println("    - Con objetos: se pasa la referencia por valor");
        System.out.println("      (esto lo veremos en POO).");
        System.out.println();
        System.out.println("  Ventaja de Java: mas seguro, menos errores.");
        System.out.println("  Ventaja de C/C++: mas control sobre la memoria,");
        System.out.println("  util para sistemas operativos.");
        System.out.println();

        // ============================================================
        // RESUMEN DE TODOS LOS EJEMPLOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ej 1: doble(10)                  -> " + doble(10) + " (10*2=20)");
        System.out.println("Ej 2: metodoMismoNombre(5)       -> " + metodoMismoNombre(5) + " (5*2=10)");
        System.out.println("Ej 3: multiplicarPorDiez(7)      -> " + multiplicarPorDiez(7) + " (7*10=70)");
        System.out.println("Ej 4: doble(100)                 -> " + doble(100) + " (100*2=200)");
        System.out.println();
        System.out.println("  Todos los ejemplos demuestran lo mismo:");
        System.out.println("  La variable original NUNCA se modifica.");
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Variables locales y globales en Java");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODOS DEL EJEMPLO
    // -------------------------------------------------------------

    // Ejemplo 1: Metodo doble - paso por valor
    // Recibe una copia del valor, la modifica internamente,
    // pero NO afecta a la variable original
    static int doble(int a) {
        a = a * 2;      // Modifica la COPIA local
        return a;       // Devuelve el resultado (el original no cambia)
    }

    // Ejemplo 2: Parametro con el mismo nombre que la variable del main
    // Es valido: el ambito del metodo es diferente al del main
    static int metodoMismoNombre(int num) {
        num = num * 2;  // Esta 'num' es el parametro formal, no la del main
        return num;
    }

    // Ejemplo 3: Multiplicar por 10
    static int multiplicarPorDiez(int valor) {
        valor = valor * 10;  // Solo modifica la copia local
        return valor;
    }

    // -------------------------------------------------------------
    // METODO AUXILIAR: separador
    // -------------------------------------------------------------

    public static void separador(String titulo) {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("  " + titulo);
        System.out.println("============================================================");
    }
}
