class Video_2_27_Operador_Ternario {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "2-27 JAVA: El operador ternario [DAM - DAW]";
    public static final String URL = "https://www.youtube.com/watch?v=gE6LpyYgdQY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=43";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------

    public static final String RESUMEN =
        """
        ================================================================
          2-27 EL OPERADOR TERNARIO EN JAVA
        ================================================================

        El operador ternario (? :) permite expresar condiciones de forma
        abreviada en una sola linea. Asigna un valor u otro a una variable
        dependiendo de si una condicion es true o false.

        --- SINTAXIS ---

            variable = (condicion) ? valor_si_true : valor_si_false;

        - condicion: debe devolver un boolean.
        - valor_si_true: se asigna si la condicion es true.
        - valor_si_false: se asigna si la condicion es false.

        --- EQUIVALENCIA CON IF-ELSE ---

        Ternario:
            x = (a == 10) ? b * 2 : a;

        Equivalente con if-else:
            if (a == 10) {
                x = b * 2;
            } else {
                x = a;
            }

        --- TERNARIAS ANIDADAS (NO RECOMENDADO) ---

        Se pueden anidar ternarias, pero dificulta la lectura:

            x = (a == 10) ? ((b == 10) ? 100 : 1) : a;

        Esto equivale a un AND: x = 100 solo si a==10 Y b==10

        Tambien se puede anidar en la parte falsa:

            x = (a == 10) ? 20 : (b == 10) ? 100 : a;

        Esto equivale a un OR: x = 100 si a==10 O b==10

        --- TERNARIA CON TRES CONDICIONES (OR logico) ---

            condicion = (a == 3) ? true : (b == 3) ? true : (c == 3);

        Es como escribir: (a == 3 || b == 3 || c == 3)

        --- USO PRACTICO: SINGULAR/PLURAL ---

        int cantidad = 1;
        String texto = "La letra a ha aparecido " + cantidad + " "
            + (cantidad == 1 ? "vez" : "veces");

  --- RECORDAR ---

            //caso 1
int a = 1, b = 2, c = 3;
int resultado = a++ == 2 && c > b++ ? a += b :
                a > 0 && a == b ? a += c :
                a == c ? a++ : a--;

//caso 2
a = 1; b = 2; c = 3;
resultado = a++ == 1 && a > b++ ? a += b :
            a > 0 && a == b ? a += c :
            a == c ? a++ : a--;

//caso 3
a = 1; b = 2; c = 3;
resultado = a++ == 1 && a > b++ ? a += b :
            a > 0 && a == b ? a += c :
            b == c ? a++ : a--;



        --- PRECAUCION ---

        * Las ternarias simples son utiles y legibles.
        * Las ternarias anidadas NO son recomendables (codigo dificil de leer).
        * Para casos complejos, mejor usar if-else con operadores logicos.
        * Cuidado con ++ y -- dentro de las condiciones de la ternaria.
        ================================================================
        """;

    // -------------------------------------------------------------

    public static void main(String[] args) {
        mostrarInformacion();

        System.out.println();
        System.out.println("============================================");
        System.out.println("   EJEMPLOS PRACTICOS - OPERADOR TERNARIO");
        System.out.println("============================================");
        System.out.println();

        // --- Ejemplo 1: Ternaria basica ---
        System.out.println("--- Ejemplo 1: Ternaria basica ---");
        int a = 10, b = 20;
        int x = (a == 10) ? b * 2 : a;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("x = (a == 10) ? b * 2 : a  =>  x = " + x);
        System.out.println("(Explicacion: a es 10 -> true -> b*2 = " + (b*2) + ")");
        System.out.println();

        // --- Ejemplo 2: Ternaria con condicion false ---
        System.out.println("--- Ejemplo 2: Ternaria con condicion false ---");
        a = 1; b = 20;
        x = (a == 10) ? b * 2 : a;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("x = (a == 10) ? b * 2 : a  =>  x = " + x);
        System.out.println("(Explicacion: a no es 10 -> false -> a = " + a + ")");
        System.out.println();

        // --- Ejemplo 3: Ternaria anidada en parte true (AND) ---
        System.out.println("--- Ejemplo 3: Ternaria anidada (AND) ---");
        a = 10; b = 10;
        x = (a == 10) ? ((b == 10) ? 100 : 1) : a;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("x = (a==10) ? ((b==10) ? 100 : 1) : a  =>  x = " + x);
        System.out.println("(AND: a==10 Y b==10 -> 100)");
        System.out.println();

        // --- Ejemplo 4: Ternaria anidada en parte true (AND, falla b) ---
        System.out.println("--- Ejemplo 4: AND con b != 10 ---");
        a = 10; b = 5;
        x = (a == 10) ? ((b == 10) ? 100 : 1) : a;
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("x = (a==10) ? ((b==10) ? 100 : 1) : a  =>  x = " + x);
        System.out.println("(AND: a==10 pero b!=10 -> 1)");
        System.out.println();

        // --- Ejemplo 5: Ternaria anidada en parte false (OR) ---
        System.out.println("--- Ejemplo 5: Ternaria anidada (OR) ---");
        a = 1; b = 10;
        x = (a == 10) ? 20 : ((b == 10) ? 100 : a);
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("x = (a==10) ? 20 : ((b==10) ? 100 : a)  =>  x = " + x);
        System.out.println("(OR: a!=10 pero b==10 -> 100)");
        System.out.println();

        // --- Ejemplo 6: Ternaria con tres condiciones (OR) ---
        System.out.println("--- Ejemplo 6: Ternaria con 3 condiciones (OR) ---");
        a = 1; b = 2; int c = 3;
        boolean condicion = (a == 3) ? true : (b == 3) ? true : (c == 3);
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        System.out.println("condicion = (a==3) ? true : (b==3) ? true : (c==3)");
        System.out.println("Resultado: " + condicion);
        System.out.println("(OR: c == 3 -> true)");
        System.out.println();

        // --- Ejemplo 7: Ternaria para singular/plural ---
        System.out.println("--- Ejemplo 7: Singular/plural con ternaria ---");
        int cantidad = 1;
        String texto = "La letra a ha aparecido " + cantidad + " "
            + (cantidad == 1 ? "vez" : "veces");
        System.out.println("Frase (cantidad=1): " + texto);
        cantidad = 4;
        texto = "La letra a ha aparecido " + cantidad + " "
            + (cantidad == 1 ? "vez" : "veces");
        System.out.println("Frase (cantidad=4): " + texto);
        System.out.println();

        // --- Ejemplo 8: Ternaria simple con entero ---
        System.out.println("--- Ejemplo 8: Asignacion con ternaria simple ---");
        a = 1;
        a = (a != 0) ? 2 : 3;
        System.out.println("a = (a != 0) ? 2 : 3  =>  a = " + a);
        System.out.println();

        // --- Ejemplo 9: Ternaria comparando dos variables ---
        System.out.println("--- Ejemplo 9: Comparar dos variables ---");
        a = 2; c = 3;
        int bVar = (a == c) ? 2 : 1;
        System.out.println("a = " + a + ", c = " + c);
        System.out.println("b = (a == c) ? 2 : 1  =>  b = " + bVar);
        System.out.println("(a != c -> false -> 1)");
        System.out.println();

        // --- Ejemplo 10: Ternaria en asignacion de boolean ---
        System.out.println("--- Ejemplo 10: Asignar boolean con ternaria ---");
        a = 1;
        boolean cond = (a == 1) ? true : false;
        System.out.println("a = " + a);
        System.out.println("cond = (a == 1) ? true : false  =>  " + cond);
        if (cond) {
            System.out.println("(Entra al if porque cond es true)");
        }
        System.out.println();

        // --- Ejemplo 11: Ternaria equivalente a if-else ---
        System.out.println("--- Ejemplo 11: Equivalencia ternaria vs if-else ---");
        a = 10; b = 20;
        int resultadoTernario = (a == 10) ? b * 2 : a;
        int resultadoIf;
        if (a == 10) {
            resultadoIf = b * 2;
        } else {
            resultadoIf = a;
        }
        System.out.println("Ternario: " + resultadoTernario);
        System.out.println("If-else:  " + resultadoIf);
        System.out.println("(Son iguales: " + (resultadoTernario == resultadoIf) + ")");
    }

    // -------------------------------------------------------------

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
