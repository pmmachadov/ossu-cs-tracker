class Video_3_02_Declaracion_Metodos {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "3-02 JAVA: Declaracion de metodos ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=dmZUegjUUDQ&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=55";
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
          RESUMEN RAPIDO - DECLARACION DE METODOS (TEMA 3 - V2)
        ====================================================================

        --- CABECERA DE UN METODO ---
            static tipo_retorno nombreMetodo(lista_parametros)

        - static: de momento siempre, permite llamar sin instancia.
        - tipo_retorno: int, double, boolean, void, String, etc.
        - nombreMetodo: identificador (como variable).
        - lista_parametros: (tipo nombre, tipo nombre, ...) o vacio.

        --- TABLA DE LA CABECERA ---
        Las 4 partes de la cabecera de un metodo:

        --- TABLA DE LA CABECERA ---
        <table>
          <caption>Partes de la cabecera de un metodo</caption>
          <tr>
            <th>Acceso</th><th>Tipo retorno</th><th>Identificador</th><th>Lista de parametros</th>
          </tr>
          <tr style=\"background:#ffcdd2\">
            <td>static</td><td>boolean</td><td>areaRectangulo</td><td>(double base, double altura)</td>
          </tr>
          <tr style=\"background:#c8e6c9\">
            <td>static</td><td>double</td><td>areaRectangulo</td><td>(double base, double altura)</td>
          </tr>
          <tr>
            <td>static</td><td>int</td><td>suma</td><td>(int a, int b)</td>
          </tr>
        </table>

        * La fila en ROJO (boolean areaRectangulo) esta MAL porque el area
          de un rectangulo debe devolver un numero (double), no un booleano.
        * La fila en VERDE (double areaRectangulo) es la CORRECTA.

        --- EJEMPLOS DE CABECERAS ---
                -> MAL: devuelve boolean, deberia ser double (area)

            static double areaRectangulo(double base, double altura)
                -> BIEN: devuelve double

            static int suma(int a, int b)
                -> BIEN: devuelve int, recibe dos ints

        --- RETURN ---
        * Devuelve el resultado del metodo.
        * El tipo del return DEBE coincidir con el tipo_retorno.
        * Al ejecutar return, el metodo TERMINA (da igual lo que haya
          despues).
        * Puede ser un valor constante (return 5), una variable
          (return x), o una expresion (return 5 * 2).

        --- VOID ---
        * void significa que el metodo NO devuelve nada.
        * No se puede poner return con valor (return 3 da error).
        * SI se puede poner return; (solo punto y coma) para salir
          anticipadamente.

        --- PARAMETROS FORMALES ---
        * Los parametros de la cabecera se llaman FORMALES (no tienen
          valor real todavia).
        * Cuando invocamos el metodo, les pasamos los valores reales
          (ARGUMENTOS).
        * Los parametros formales funcionan como VARIABLES LOCALES
          dentro del metodo.
        * NO se deben volver a declarar dentro del metodo (da error).

        --- METODOS SIN PARAMETROS ---
        * Los parentesis VAN SIEMPRE, aunque esten vacios.
        * Ej: static void mostrarMenu()

        --- INVOCACION DE METODOS ---
        * Un metodo NO se ejecuta solo, hay que invocarlo.
        * Sintaxis: nombreMetodo(valor1, valor2, ...)
        * Los parametros deben coincidir en TIPO y ORDEN con la
          cabecera.

        --- COMPATIBILIDAD DE TIPOS ---
        * Se puede pasar un tipo MENOS preciso a un parametro MAS
          preciso: int -> double (SI, sin perdida).
        * Al reves: double -> int (NO, perdida de precision, requiere
          CASTING explicito: (int) variable).

        --- GUARDAR EL RETORNO ---
        * El valor devuelto por un metodo se puede guardar en una
          variable del mismo tipo (o compatible).
        * Ej: double r = areaCuadrado(a);  // a es int, areaCuadrado
          recibe double

        --- CONDICIONES CON RETURN ---
        * Si un metodo tiene condiciones (if), TODOS los caminos
          deben tener return.
        * Ej: si a==b -> return suma; sino -> return 0;
        * Si falta un return en algun camino, ERROR de compilacion.

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * La cabecera de un metodo tiene 4 partes: Acceso (static),
          Tipo retorno, Identificador, Lista de parametros.
        * static -> permite llamar al metodo sin crear un objeto.
        * El tipo de retorno DEBE coincidir con lo que devuelve return.
        * boolean areaRectangulo(double, double) esta MAL (area no es
          booleano). La version correcta es double areaRectangulo(...).
        * return TERMINA el metodo en el acto.
        * void: metodo que NO devuelve nada. Solo se permite return;
          (sin valor).
        * Parametros formales -> los de la cabecera (sin valor real).
        * Los parametros formales son variables LOCALES del metodo.
        * NO se redeclaran dentro del metodo (da error).
        * Al invocar: mismo TIPO y mismo ORDEN que en la cabecera.
        * int -> double: conversion automatica (sin perdida).
        * double -> int: requiere CASTING explicito (int) variable.
        * Un metodo NO se ejecuta solo, hay que invocarlo.
        * Los parentesis van SIEMPRE, incluso vacios.
        * El retorno de un metodo se puede guardar en una variable
          del mismo tipo (o compatible).
        * Condiciones con return: TODOS los caminos deben devolver algo.

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
        // EJEMPLO 1: Metodo suma con int
        // ============================================================

        separador("EJEMPLO 1: METODO suma(int, int) - return basico");

        int num1 = 2;
        int num2 = 4;
        int num3 = suma(num1, num2);  // Invocacion con num1=2, num2=4

        System.out.println("  num1 = " + num1 + ", num2 = " + num2);
        System.out.println("  suma(num1, num2) = " + num3 + "  (2+4=6)");
        System.out.println();

        // ============================================================
        // EJEMPLO 2: suma con variable local dentro del metodo
        // ============================================================

        separador("EJEMPLO 2: suma con variable local 'resultado'");

        int resultadoSuma = sumaConVariable(7, 3);
        System.out.println("  sumaConVariable(7, 3) = " + resultadoSuma);
        System.out.println("  (dentro del metodo: int resultado = a + b; return resultado;)");
        System.out.println();

        // ============================================================
        // EJEMPLO 3: sumaCondicionada (return condicional)
        // ============================================================

        separador("EJEMPLO 3: sumaCondicionada - return condicional");

        System.out.println("  sumaCondicionada(5, 5) = " + sumaCondicionada(5, 5) + "  (son iguales -> suma)");
        System.out.println("  sumaCondicionada(5, 3) = " + sumaCondicionada(5, 3) + "  (son distintos -> 0)");
        System.out.println("  (OJO: todos los caminos deben tener return!)");
        System.out.println();

        // ============================================================
        // EJEMPLO 4: areaCuadrado con int
        // ============================================================

        separador("EJEMPLO 4: areaCuadrado(int) - return lado * lado");

        System.out.println("  areaCuadrado(3) = " + areaCuadrado(3));          // 9
        System.out.println("  areaCuadrado(num3) = " + areaCuadrado(num3) + "  (num3=6 -> 36)");

        // Llamada con expresion
        int expresion = (num3 * 4) / 5;  // (6*4)/5 = 24/5 = 4 (enteros descarta decimales)
        System.out.println("  areaCuadrado((num3*4)/5) = " + areaCuadrado(expresion) + "  (expresion=" + expresion + ")");
        System.out.println();

        // ============================================================
        // EJEMPLO 5: areaCuadrado con double
        // ============================================================

        separador("EJEMPLO 5: areaCuadrado(double) - compatibilidad de tipos");

        double lado = 3.0;
        // System.out.println("  areaCuadrado(lado) = " + areaCuadrado(lado));
        // ^ ESO DARIA ERROR: double -> int (perdida de precision), requiere casting
        System.out.println("  areaCuadrado((int) lado) = " + areaCuadrado((int) lado) + "  (con casting explicito)");
        System.out.println();

        // ============================================================
        // EJEMPLO 6: areaCuadradoDouble - version con double
        // ============================================================

        separador("EJEMPLO 6: areaCuadrado(double) -> double");

        int a = 10;
        double r = areaCuadradoDouble(a);  // int -> double: SI, sin perdida
        System.out.println("  areaCuadradoDouble(" + a + ") = " + r);
        System.out.println("  (a es int, parametro es double -> conversion automatica)");
        System.out.println();

        // ============================================================
        // EJEMPLO 7: Metodo void con return
        // ============================================================

        separador("EJEMPLO 7: void con return; (salida anticipada)");

        System.out.print("  prueba() con x=1  -> ");
        prueba();       // Solo imprime "prueba" (return corta antes)
        System.out.println();

        // ============================================================
        // EJEMPLO 8: areaRectangulo - cabecera correcta vs incorrecta
        // ============================================================

        separador("EJEMPLO 8: areaRectangulo - tipo de retorno correcto");

        System.out.println("  areaRectangulo(5.0, 3.0) = " + areaRectangulo(5.0, 3.0) + "  (5*3=15.0)");
        System.out.println("  (Devuelve double, NO boolean. El video mostraba un");
        System.out.println("   ejemplo incorrecto boolean para areaRectangulo)");
        System.out.println();

        // ============================================================
        // EJEMPLO 9: perimetroCuadrado
        // ============================================================

        separador("EJEMPLO 9: perimetroCuadrado");

        System.out.println("  perimetroCuadrado(5.0) = " + perimetroCuadrado(5.0) + "  (5*4=20.0)");
        System.out.println();

        // ============================================================
        // EJEMPLO 10: mostrarMenu (void sin parametros)
        // ============================================================

        separador("EJEMPLO 10: void mostrarMenu() - metodo sin parametros");

        mostrarMenu();  // No devuelve nada, solo imprime
        System.out.println();

        // ============================================================
        // RESUMEN DE TODOS LOS EJEMPLOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ej 1: suma(int, int)               -> " + suma(2, 4) + " (2+4=6)");
        System.out.println("Ej 2: sumaConVariable(int, int)    -> " + sumaConVariable(7, 3) + " (7+3=10)");
        System.out.println("Ej 3: sumaCondicionada(5,5)        -> " + sumaCondicionada(5, 5) + " (iguales)");
        System.out.println("Ej 3: sumaCondicionada(5,3)        -> " + sumaCondicionada(5, 3) + " (distintos)");
        System.out.println("Ej 4: areaCuadrado(3)              -> " + areaCuadrado(3) + " (3*3=9)");
        System.out.println("Ej 5: areaCuadrado((int)3.0)       -> " + areaCuadrado((int) 3.0) + " (casting)");
        System.out.println("Ej 6: areaCuadradoDouble(10)       -> " + areaCuadradoDouble(10) + " (int->double)");
        System.out.println("Ej 7: prueba()                     -> imprime con return corto");
        System.out.println("Ej 8: areaRectangulo(5.0,3.0)      -> " + areaRectangulo(5.0, 3.0));
        System.out.println("Ej 9: perimetroCuadrado(5.0)       -> " + perimetroCuadrado(5.0));
        System.out.println("Ej10: mostrarMenu()                -> imprime menu sin retorno");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Ejercicios de metodos en Java");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODOS DEL EJEMPLO
    // -------------------------------------------------------------

    // Ejemplo 1: Suma basica con return directo
    static int suma(int a, int b) {
        return a + b;
    }

    // Ejemplo 2: Suma con variable local
    static int sumaConVariable(int a, int b) {
        int resultado = a + b;
        return resultado;
    }

    // Ejemplo 3: Suma condicionada (solo suma si son iguales)
    static int sumaCondicionada(int a, int b) {
        if (a == b) {
            return a + b;   // Si son iguales, devuelve suma
        }
        return 0;           // Si no, devuelve 0 (OBLIGATORIO: todos los caminos)
    }

    // Ejemplo 4: Area de cuadrado con int (devuelve int)
    static int areaCuadrado(int lado) {
        return lado * lado;
    }

    // Ejemplo 6: Area de cuadrado con double (devuelve double)
    static double areaCuadradoDouble(double lado) {
        return lado * lado;
    }

    // Ejemplo 7: void con return anticipado
    static void prueba() {
        System.out.print("prueba ");
        int x = 1;
        if (x == 1) {
            return;     // Sale del metodo aqui si x==1
        }
        System.out.print("prueba final");  // No se ejecuta si x==1
    }

    // Ejemplo 8: Area rectangulo (tipo correcto: double)
    static double areaRectangulo(double base, double altura) {
        return base * altura;
    }

    // Ejemplo 9: Perimetro cuadrado
    static double perimetroCuadrado(double lado) {
        return lado * 4;
    }

    // Ejemplo 10: Metodo void sin parametros
    static void mostrarMenu() {
        System.out.println("  === MENU ===");
        System.out.println("  1. Opcion A");
        System.out.println("  2. Opcion B");
        System.out.println("  3. Salir");
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
