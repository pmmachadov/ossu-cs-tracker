class Video_2_06_Declarar_Variables_Numericas {

    public static final String TITULO = "2-6 Declarar variables numericas en Java";
    public static final String URL = "https://www.youtube.com/watch?v=9OpBxj5kYss&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=22";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-6 DECLARAR VARIABLES NUMERICAS EN JAVA
        ================================================================

        --- FORMA BASICA DE DECLARAR ---

        tipo identificador;
        tipo identificador = valor;

        Ejemplos:
          int num;              // declara variable sin valor inicial
          int cantidad = 5;     // declara e inicializa a 5
          int cantidad = 5 + 4; // primero evalua la expresion (9), luego asigna

        --- EVALUACION DE EXPRESIONES ---

        Primero se resuelve la expresion a la DERECHA del =, luego se asigna:

        int cantidad = 5 + 2;   // cantidad = 7
        int precio = 10;
        precio = 5;             // ahora precio = 5 (el 10 se pierde)

        int precioFinal = cantidad * precio;  // 7 * 5 = 35
        precioFinal = precioFinal + 10;        // 35 + 10 = 45

        * Primero se resuelve la derecha, luego se asigna a la izquierda
        * No confundir: precioFinal = precioFinal + 10 es valido

        --- DECLARAR VARIAS VARIABLES DEL MISMO TIPO ---

        int a = 5, b = 10;        // a=5, b=10
        short c = -1, d, e = 4;   // d no tiene valor inicial
        int f, g;                 // ninguna tiene valor inicial

        * Se separan con comas
        * El tipo se pone UNA SOLA VEZ
        * Punto y coma al final

        --- REGLAS PARA NOMBRES DE VARIABLES (identificadores) ---

        - Deben comenzar con: letra, _ (guion bajo) o $ (dolar)
        - No pueden comenzar con numeros
        - Despues del primer caracter se pueden usar numeros
        - Case sensitive: edad, Edad, EDAD son distintas
        - No espacios en blanco
        - No simbolos de operadores (+, -, *, /, %)
        - No palabras reservadas de Java (int, double, class, etc.)
        - Se recomienda usar nombres significativos (no a, b, c)
        - Se recomienda usar minusculas para variables

        Palabras reservadas (no usar como identificadores):
        abstract, assert, boolean, break, byte, case, catch, char,
        class, const, continue, default, do, double, else, enum,
        extends, final, finally, float, for, goto, if, implements,
        import, instanceof, int, interface, long, native, new,
        package, private, protected, public, return, short, static,
        strictfp, super, switch, synchronized, this, throw, throws,
        transient, try, void, volatile, while

        --- VARIABLES CON DECIMALES: float y double ---

        float  -> 4 bytes, menor precision (obligatorio poner F al final)
        double -> 8 bytes, mayor precision (la D es opcional)

        Ejemplos float:
          float f1 = 1.0f;
          float f2 = 5.4f;
          float f3 = 12e6f;       // 12 millones (12 * 10^6)
          float f4 = 0.55e-2f;    // 0.0055 (dividir entre 100)
          float f5 = -5.44e-2f;   // -0.0544

        Ejemplos double:
          double d1 = 2.0;
          double d2 = 4.001;
          double d3 = 1.51e-3;    // 0.00151
          double d4 = 2.11e8;     // 211.000.000
          double d5 = -1.1e-3;    // -0.0011

        --- NOTACION EXPONENCIAL (e) ---

        eN  = multiplicar por 10^N  (anadir N ceros, mover coma a derecha)
        e-N = dividir entre 10^N     (mover coma a izquierda)

        Ejemplos:
          12e6   = 12 * 10^6   = 12.000.000
          0.55e-2 = 0.55 / 100 = 0.0055
          2.11e8 = 2.11 * 10^8 = 211.000.000

        --- GUION BAJO EN NUMEROS (mejorar legibilidad) ---

        int mil = 1_000;           // 1000
        int millon = 1_000_000;    // 1000000
        double d = 1_000.012;      // 1000.012

        * El guion bajo no afecta al valor
        * Mejora la lectura de numeros grandes
        * No se puede poner junto al punto decimal

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Declaracion: tipo + identificador + (opcional) = valor + ;
        * Primero se evalua la derecha del =, luego se asigna
        * Para reasignar NO se vuelve a poner el tipo
        * Varias variables del mismo tipo: int a=1, b=2, c=3;
        * float OBLIGA a poner F al final del valor
        * double: la D es opcional
        * eN = x10^N, e-N = /10^N
        * Guion bajo _ mejora legibilidad (1_000_000 = 1 millon)
        * Identificadores: letra/_, luego letras/numeros/_
        * Case sensitive, sin espacios, sin operadores
        * No usar palabras reservadas
        * Usar nombres significativos
        ================================================================
        """;

    public static void main(String[] args) {
        mostrarInformacion();
    }

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
