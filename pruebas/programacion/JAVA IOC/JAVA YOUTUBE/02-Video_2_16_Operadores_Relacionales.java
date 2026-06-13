class Video_2_16_Operadores_Relacionales {

    public static final String TITULO = "JAVA: Operadores relacionales ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=nJUURIe3Nc0&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=32";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-16 OPERADORES RELACIONALES EN JAVA
        ================================================================

        --- OPERADORES RELACIONALES ---

        >   Mayor que
        <   Menor que
        >=  Mayor o igual que
        <=  Menor o igual que
        ==  Igual a (compara valores numericos/primitivos)
        !=  Distinto de

        IMPORTANTE: El resultado de cualquier expresion relacional
        es SIEMPRE un valor BOOLEANO (true o false).

        --- SINTAXIS BASICA ---

        int a = 5;
        boolean esCinco = (a == 5);   // true

        int x = 0, y = 1;
        boolean iguales = (x == y);   // false (0 != 1)

        --- PRIORIDAD DE OPERADORES ---

        Las operaciones aritmeticas (+, -, *, /) tienen MAYOR prioridad
        que las relaciones (<, >, ==, !=).

        int precio1 = 10, precio2 = 30;

        boolean barato = precio1 > precio2;   // false (10 > 30 es falso)

        // Suma primero, luego compara:
        boolean igualUno = (precio1 + precio2 == 40);   // true
        boolean igualDos =  precio1 + precio2 == 40;    // true (misma prioridad)

        // ERROR: comparacion booleana + numero
        // boolean error = (40 == precio1) + precio2;  // NO COMPILA

        --- COMPARAR STRINGS: equals() ---

        Para Strings NO se usa == (compara referencias, no valores).
        Se usa el metodo .equals():

        String nombre1 = "Pepe";   // con P mayuscula
        String nombre2 = "Jose";   // con J mayuscula
        String nombre3 = "pepe";   // con p minuscula

        boolean iguales1 = nombre1.equals(nombre2);  // false (Pepe != Jose)
        boolean iguales2 = nombre1.equals(nombre3);  // false (Pepe != pepe)
        boolean iguales3 = nombre1.equalsIgnoreCase(nombre3);  // true

        equalsIgnoreCase() compara sin distinguir mayusculas/minusculas.

        --- COMPARACION DE NUMEROS CON DIFERENTES TIPOS ---

        int    precio1 = 1;
        float  precio1f = 1.0f;
        double precio1d = 1.0;

        boolean r1 = precio1 == precio1f;   // true (int vs float, mismo valor)
        boolean r2 = precio1 == precio1d;   // true (int vs double, mismo valor)
        boolean r3 = precio1f == precio1d;  // true (float vs double, mismo valor)
        boolean r4 = precio2 == 2.0 + 1.0;  // true (3 == 3.0 double)

        --- PRECISION EN DIVISIONES: int vs float vs double ---

        int precio1 = 1;

        // Division de enteros -> resultado entero (se trunca)
        boolean r5 = precio1 / 10 == 0.1;   // false:
        // precio1/10 = 0 (entero), 0 != 0.1

        // Division con float -> pierde precision en binario
        boolean r6 = precio1 / 10f == 0.1;  // false:
        // 0.1 en binario NO es exacto, pequena perdida de precision

        // Division con double -> mismo tipo en ambos lados
        boolean r7 = precio1 / 10.0 == 0.1; // true:
        // ambos son double, la comparacion es precisa

        // Division entera comparada como entero
        boolean r8 = 0.1 > precio1 / 10;    // true:
        // precio1/10 = 0, 0.1 > 0

        --- PRECISION DE float vs double ---

        float  tiene precision de ~7 decimales
        double tiene precision de ~16 decimales

        float nuevo = 2 / 3;       // 0 (division enteros)
        float nuevo = 2f / 3f;     // 0.6666667 (7 decimales)

        boolean r9 = nuevo == 2.0f / 3.0f;     // true (mismo tipo, mismo valor)
        boolean r10 = nuevo == 0.6666667f;       // true (7 decimales exactos)
        boolean r11 = nuevo == 0.6666666f;       // false (ultimo digito distinto)
        boolean r12 = nuevo == 0.66666667f;      // true (se redondea al mas cercano)

        boolean r13 = nuevo == 0.66666667d;      // false (float vs double, dif precision)

        double d1 = 2.0 / 3.0;       // 0.6666666666666666 (16 decimales)
        boolean r14 = d1 == 2.0 / 3.0;   // true (mismo tipo, mismo valor)

        --- RESUMEN DE PRECISION ---

        * int / int    -> int (se trunca la parte decimal)
        * float / float -> float (~7 decimales)
        * double / double -> double (~16 decimales)
        * Si mezclas tipos, el "mas grande" prevalece:
          int + float -> float
          int + double -> double
          float + double -> double
        * Comparar float con double puede dar false aunque
          matematicamente sean iguales (diferente precision)
        * 0.1 en binario no es exacto, causa pequenas diferencias
        * 0.1 literal en Java es double; para float hay que poner 0.1f

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Operadores: >, <, >=, <=, ==, !=
        * Siempre devuelven boolean (true/false)
        * Strings se comparan con .equals() o .equalsIgnoreCase()
        * == en Strings compara REFERENCIAS, no valores
        * Division entera trunca: 1/10 = 0
        * float tiene ~7 decimales de precision
        * double tiene ~16 decimales de precision
        * No comparar float con double directamente
        * 0.1 en binario es periodico -> perdida de precision
        * Prioridad: aritmetica > relacional
        * (parentesis) para forzar orden de evaluacion
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
