class Video_2_20_Clase_Math {

    // ──────────────────────────────────────────────────────────────
    // Datos del video y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "2-20 JAVA: Clase Math ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=4znSjME7tNU&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=36";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────

    public static final String RESUMEN =
        """
        ================================================================
          2-20 CLASE MATH - FUNCIONES MATEMATICAS
        ================================================================

        La clase Math de Java incluye una gran cantidad de funciones
        matematicas que podemos utilizar en nuestros programas.

        El funcionamiento es similar a las funciones de la clase String:
        se escribe "Math." seguido del nombre de la funcion.

        Aunque aun no hemos visto metodos/funciones en profundidad
        (se vera en la unidad 3), podemos usarlos facilmente.

        --- TABLA DE METODOS (1a parte) ---

        Metodo                   Que devuelve      Descripcion
        ------                   -------------     -----------
        round(double)            double            Numero completo mas cercano
        floor(double)            double            Numero completo mas cercano por debajo
        ceil(double)             double            Numero completo mas cercano por arriba
        sqrt(double)             double            Raiz cuadrada
        pow(double a, double b)  double            a elevado a b
        abs(tipo x)              mismo tipo        Valor absoluto (sin signo)
        log(double)              double            Logaritmo natural (base e)

        --- DETALLE DE CADA METODO (1a parte) ---

        1. round(double)
           Devuelve el numero completo (entero) mas cercano.
           El resultado es un double pero siempre termina en .0
           Ej: Math.round(4.7) -> 5.0
               Math.round(4.1) -> 4.0

        2. floor(double)
           Devuelve el numero completo mas cercano por DEBAJO.
           Ej: Math.floor(4.7) -> 4.0
               Math.floor(4.1) -> 4.0

        3. ceil(double)
           Devuelve el numero completo mas cercano por ARRIBA.
           Ej: Math.ceil(4.7)  -> 5.0
               Math.ceil(4.1)  -> 5.0

        4. sqrt(double)
           Devuelve la raiz cuadrada del numero.
           Ej: Math.sqrt(16.0) -> 4.0
               Math.sqrt(2.0)  -> 1.414...

        5. pow(double a, double b)
           Recibe DOS parametros: base y exponente.
           Devuelve a elevado a b.
           Ej: Math.pow(2.0, 3.0) -> 8.0  (2*2*2 = 8)
               Math.pow(2.0, 8.0) -> 256.0

        6. abs(tipo x)
           Devuelve el valor absoluto (sin signo).
           Funciona tanto con enteros como con reales.
           Ej: Math.abs(-5)   -> 5
               Math.abs(-3.7) -> 3.7

        7. log(double)
           Devuelve el logaritmo natural (base e) del valor.
           Ej: Math.log(1.0) -> 0.0
               Math.log(Math.E) -> 1.0

        --- TABLA DE METODOS (2a parte) ---

        Metodo                   Que devuelve      Descripcion
        ------                   -------------     -----------
        random()                 double            Aleatorio entre 0.0 y 1.0
        sin(double)              double            Seno (angulo en radianes)
        cos(double)              double            Coseno (angulo en radianes)
        tan(double)              double            Tangente (angulo en radianes)
        asin(double)             double            Arco seno (devuelve angulo)
        acos(double)             double            Arco coseno (devuelve angulo)
        atan(double)             double            Arco tangente (devuelve angulo)

        --- CONSTANTES ---

        Math.PI    double   Numero pi (3.14159...)
        Math.E     double   Numero e (2.71828...)

        --- EJEMPLOS DEL VIDEO ---

        Ejemplo 1: Potencia
        int n = 2;
        System.out.println(Math.pow(n, 8));
        // n elevado a 8 = 2^8 = 256

        Ejemplo 2: Area del circulo
        double radio = 5;
        double area;
        area = Math.PI * radio * radio;
        // area = pi * r^2 = 78.53981633974483

        Tambien se puede combinar con pow:
        area = Math.PI * Math.pow(radio, 2);
        // Mismo resultado: pi * radio^2

        Ejemplo 3: Redondeo con ceil, floor y round
        // area = 78.53981633974483
        Math.ceil(area)   -> 79.0   (siguiente entero por arriba)
        Math.floor(area)  -> 78.0   (siguiente entero por abajo)
        Math.round(area)  -> 79.0   (entero mas cercano, 78.53 -> 79)

        Ejemplo 4: Raiz cuadrada
        Math.sqrt(area * area)  // raiz de (area^2) = area otra vez
        // Devuelve el mismo valor de area

        Ejemplo 5: Combinacion de funciones
        // sqrt( pow(2, 4) ) = sqrt(16) = 4
        Math.sqrt(Math.pow(2, 4));
        // Primero se evalua Math.pow(2,4)=16, luego sqrt(16)=4

        --- COMBINAR FUNCIONES MATEMATICAS ---

        Se pueden anidar unas dentro de otras:
        Math.sqrt(Math.pow(n, 4));
        // 1. Se evalua Math.pow(n, 4) primero (prioridad parentesis)
        // 2. Luego se evalua Math.sqrt() sobre el resultado

        --- REGLA IMPORTANTE ---

        Siempre se debe escribir "Math." delante del metodo:
        - Math.round(...)
        - Math.sqrt(...)
        - Math.pow(..., ...)

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * round -> redondea al entero mas cercano
        * floor -> redondea hacia ABAJO (suelo)
        * ceil -> redondea hacia ARRIBA (techo)
        * sqrt -> raiz cuadrada
        * pow(base, exp) -> potencia (base^exp)
        * abs -> valor absoluto (quita el signo)
        * random -> aleatorio entre 0.0 y 1.0
        * Math.PI -> constante pi
        * Math.E -> constante e (numero de Euler)
        * Las funciones se pueden combinar / anidar
        * Los parentesis determinan el orden de evaluacion
        * Siempre se usa Math. antes del metodo
        * Las funciones trigonometricas usan radianes, no grados
        ================================================================
        """;

    // ──────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        mostrarInformacion();

        // ── Ejemplos del video ──
        System.out.println();
        System.out.println("============================================");
        System.out.println("   EJEMPLOS PRACTICOS - CLASE MATH");
        System.out.println("============================================");
        System.out.println();

        // Ejemplo 1: Potencia
        int n = 2;
        System.out.println("Ejemplo 1: Math.pow(" + n + ", 8) = " + Math.pow(n, 8));
        System.out.println();

        // Ejemplo 2: Area del circulo
        double radio = 5;
        double area = Math.PI * radio * radio;
        System.out.println("Ejemplo 2: Area del circulo con radio = " + radio);
        System.out.println("  area = Math.PI * radio * radio = " + area);
        System.out.println("  area = Math.PI * Math.pow(radio, 2) = " + (Math.PI * Math.pow(radio, 2)));
        System.out.println();

        // Ejemplo 3: Redondeo
        System.out.println("Ejemplo 3: Redondeo de area = " + area);
        System.out.println("  Math.ceil(area)  = " + Math.ceil(area));
        System.out.println("  Math.floor(area) = " + Math.floor(area));
        System.out.println("  Math.round(area) = " + Math.round(area));
        System.out.println();

        // Ejemplo 4: Raiz cuadrada
        System.out.println("Ejemplo 4: Raiz cuadrada");
        System.out.println("  Math.sqrt(area * area) = " + Math.sqrt(area * area));
        System.out.println();

        // Ejemplo 5: Combinacion de funciones
        System.out.println("Ejemplo 5: Combinacion de funciones");
        System.out.println("  Math.sqrt(Math.pow(2, 4)) = " + Math.sqrt(Math.pow(2, 4)));
        System.out.println("  (Explicacion: primero pow(2,4)=16, luego sqrt(16)=4)");
        System.out.println();

        // Ejemplos adicionales: round/floor/ceil con diferentes valores
        System.out.println("--- Pruebas de redondeo con diferentes valores ---");
        double[] valores = {4.7, 4.1, 4.5, -4.7, -4.1};
        for (double v : valores) {
            System.out.printf("  Math.round(%.1f) = %5.1f | Math.floor(%.1f) = %5.1f | Math.ceil(%.1f) = %5.1f%n",
                v, Math.round(v), v, Math.floor(v), v, Math.ceil(v));
        }
        System.out.println();

        // abs
        System.out.println("--- Valor absoluto ---");
        System.out.println("  Math.abs(-5)   = " + Math.abs(-5));
        System.out.println("  Math.abs(5)    = " + Math.abs(5));
        System.out.println("  Math.abs(-3.7) = " + Math.abs(-3.7));
        System.out.println();

        // Constantes
        System.out.println("--- Constantes ---");
        System.out.println("  Math.PI = " + Math.PI);
        System.out.println("  Math.E  = " + Math.E);
        System.out.println();

        // random
        System.out.println("--- Numero aleatorio ---");
        System.out.println("  Math.random() (entre 0.0 y 1.0) = " + Math.random());
        System.out.println("  Math.random() (entre 0.0 y 1.0) = " + Math.random());
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
