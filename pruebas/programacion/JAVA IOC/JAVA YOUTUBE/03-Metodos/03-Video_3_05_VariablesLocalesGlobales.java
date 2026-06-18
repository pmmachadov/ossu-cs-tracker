class Video_3_05_VariablesLocalesGlobales {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "3-05 JAVA: Variables locales y globales ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=I17uuWAMe88&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=58";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 3";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // Variable GLOBAL
    // -------------------------------------------------------------
    static int num = 2;  // Variable global (static), accesible desde cualquier metodo

    // -------------------------------------------------------------
    // RESUMEN para el examen (CHULETA)
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ====================================================================
          RESUMEN RAPIDO - VARIABLES LOCALES Y GLOBALES (TEMA 3 - V5)
        ====================================================================

        --- VARIABLE LOCAL ---
        - Se declara DENTRO de un metodo.
        - Solo es accesible dentro de ese metodo (su ambito es el metodo).
        - Los PARAMETROS formales de un metodo TAMBIEN son variables locales.
        - Al terminar el metodo, la variable local se destruye.

        --- VARIABLE GLOBAL ---
        - Se declara DENTRO de la clase, pero FUERA de cualquier metodo.
        - Para nuestro nivel: usar static (se explicara en POO).
        - Es accesible desde CUALQUIER metodo de la clase (static).
        - Da igual si se declara antes o despues de los metodos (Java la
          hace visible igualmente).
        - Mantiene su valor durante toda la ejecucion (no se destruye al
          salir de un metodo).

        --- REGLA: SOMBRA (SHADOWING) ---
        Si una variable LOCAL tiene el MISMO NOMBRE que una variable GLOBAL,
        la variable local SOBRESCRIBE (hace sombra) a la global dentro de
        ese ambito. La global queda "oculta" hasta que salimos del metodo.

        --- IMPORTANTE ---
        - Las variables del Main tambien son LOCALES (el main es un metodo).
        - Las variables globales se ponen con static por ahora.
        - static permite que los metodos static accedan a la variable.
        - No importa el ORDEN: la global puede estar al final del archivo
          y los metodos la ven igual.

        --- EJEMPLO 1 (DEL VIDEO): ---
            static int x;          // GLOBAL

            static int cubo(int z) {
                int x = z * z * z; // LOCAL (hace sombra a la global)
                return x;          // Devuelve el cubo (x local)
            }

            public static void main(String[] args) {
                int p = 10;                        // LOCAL del main
                // z = 100;  <-- ERROR: z no existe aqui (es del metodo cubo)
                x = cubo(p);                       // Asigna 1000 a la x GLOBAL
                System.out.println(x);             // 1000
            }

        --- EJEMPLO 2 (DEL VIDEO) - solo global y parametro: ---
            static int numb = 5;   // GLOBAL

            static int cubo(int numb) {   // 'numb' es PARAMETRO (local)
                int x = numb * numb * numb;
                return x;
            }

            public static void main(String[] args) {
                numb = cubo(numb - 1);
                // numb-1 = 4 -> cubo(4) = 64 -> numb global = 64
                System.out.println(numb);  // 64
            }

        --- EJEMPLO 3 (DEL VIDEO) - tres variables 'numb': ---
            static int numb = 5;          // GLOBAL (1)

            static int cubo(int numb) {   // PARAMETRO local (2)
                int x = numb * numb * numb;
                return x;
            }

            public static void main(String[] args) {
                int numb = 10;             // LOCAL del main (3) -> sombrea a global
                numb = cubo(numb);        // cubo(10) = 1000 -> numb local = 1000
                System.out.println(numb); // 1000 (la local, no la global)
            }

        --- EJEMPLO VISUAL STUDIO (num global = 2) ---
        Caso A: num local = 10 en main
          -> Usa num local (10), doble(10) = 20
          -> num global sigue siendo 2 (no se toca)

        Caso B: SIN num local en main, solo global
          -> Usa num global (2), doble(2) = 4
          -> num global = 2 (sigue igual, paso por valor)

        Caso C: SIN doble local, solo metodo
          -> doble(num) donde num global = 2
          -> Se pasa copia, parametro formal se modifica, global NO cambia
          -> num = 2, doble = 4

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Variable local: declarada dentro de un metodo. Solo vive ahi.
        * Variable global: declarada en la clase, fuera de metodos. Con static.
        * Los parametros formales son variables LOCALES del metodo.
        * Sombra (shadowing): si local y global tienen el mismo nombre,
          la local prevalece dentro del metodo.
        * Las globales static son visibles desde cualquier metodo static.
        * No importa donde se declare la global (antes o despues de los
          metodos).
        * La variable global NO se modifica al pasar por valor a un metodo
          (solo se modifica si se asigna directamente desde el main).

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
        // Recordatorio: estado inicial de la variable global
        // ============================================================
        separador("ESTADO INICIAL");
        System.out.println("  Variable global num = " + num);
        System.out.println("  (Declarada al inicio de la clase con static int num = 2)");
        System.out.println();

        // ============================================================
        // EJEMPLO 1: Variable local SOMBREA a la global
        // ============================================================

        separador("EJEMPLO 1: Variable local con el mismo nombre que la global");
        System.out.println("  En el main declaramos int num = 10 (local).");
        System.out.println("  Esta variable local HACE SOMBRA a la global num=2.");
        System.out.println("  Ahora dentro del main, 'num' se refiere a la local.");
        System.out.println();

        int num = 10;  // Variable LOCAL del main (sombrea a la global)
        int dobleVar = doble(num);

        System.out.println("  num (local) = " + num + "     (la variable local del main)");
        System.out.println("  doble(num)  = " + dobleVar + "   (10*2=20)");
        System.out.println("  Variable global num sigue siendo = " + Video_3_05_VariablesLocalesGlobales.num);
        System.out.println("  (la global no se ha tocado; la local la ocultaba)");
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Usando SOLO la variable global (sin local)
        // ============================================================

        separador("EJEMPLO 2: Usando la variable global (sin local en el main)");
        System.out.println("  Ahora VOLVEMOS a usar la variable global num.");
        System.out.println("  Nota: la variable local 'num' de arriba ya ha terminado");
        System.out.println("  su ambito? No exactamente, pero aqui accedemos con");
        System.out.println("  el nombre de clase: Video_3_05_VariablesLocalesGlobales.num");
        System.out.println("  para referirnos a la global explicitamente.");
        System.out.println();

        // Restablecemos la global a 2 (puede haberse modificado en otros ejemplos)
        Video_3_05_VariablesLocalesGlobales.num = 2;
        int dobleGlobal = doble(Video_3_05_VariablesLocalesGlobales.num);

        System.out.println("  num global = " + Video_3_05_VariablesLocalesGlobales.num + "      (la global)");
        System.out.println("  doble(num global) = " + dobleGlobal + "   (2*2=4)");
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Modificando la variable global desde el main
        // ============================================================

        separador("EJEMPLO 3: Asignando un valor a la global desde el main");
        System.out.println("  La variable GLOBAL se puede modificar directamente:");
        System.out.println("    Video_3_05_VariablesLocalesGlobales.num = cubo(4);");
        System.out.println();

        Video_3_05_VariablesLocalesGlobales.num = cubo(4);  // 4*4*4 = 64
        System.out.println("  Variable global num = " + Video_3_05_VariablesLocalesGlobales.num + "  (4 al cubo = 64)");
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Variables locales con el mismo nombre (parametro)
        // ============================================================

        separador("EJEMPLO 4: Parametro formal con mismo nombre que global (shadowing)");
        System.out.println("  El metodo cubo() recibe un int llamado 'num'.");
        System.out.println("  Ese parametro num hace sombra a la global num.");
        System.out.println("  Pero solo DENTRO del metodo cubo().");
        System.out.println();

        // Restablecemos global a 5
        Video_3_05_VariablesLocalesGlobales.num = 5;
        System.out.println("  num global ANTES = " + Video_3_05_VariablesLocalesGlobales.num);

        int resultado = cubo(Video_3_05_VariablesLocalesGlobales.num - 1);  // cubo(4) = 64
        System.out.println("  cubo(num global - 1) = cubo(4) = " + resultado);
        System.out.println("  NOTA: Dentro de cubo(), el parametro 'num' (que vale 4)");
        System.out.println("  hace sombra a la global. La variable x es local del metodo.");
        System.out.println("  La global num NO se modifica por el paso por valor.");
        System.out.println();

        // ============================================================
        // EJEMPLO 5: Demostracion de que la global es accesible desde
        //            cualquier metodo, incluso declarada al final
        // ============================================================

        separador("EJEMPLO 5: Las globales son visibles desde cualquier metodo");
        System.out.println("  Las variables globales static se ven desde todos");
        System.out.println("  los metodos static, sin importar donde se declaren");
        System.out.println("  (incluso si estan al final del archivo).");
        System.out.println("  Prueba: metodo usarVariableGlobal() accede a num:");
        System.out.println();

        usarVariableGlobal();
        System.out.println();

        // ============================================================
        // EJEMPLO 6: Acceso a la variable global con nombreClase.variable
        // ============================================================

        separador("EJEMPLO 6: Acceso con nombre de clase");
        System.out.println("  Se puede acceder a la global de forma explicita:");
        System.out.println("    Video_3_05_VariablesLocalesGlobales.num = 100;");
        System.out.println("  Esto es util cuando hay una variable local que");
        System.out.println("  hace sombra a la global y necesitamos la global.");
        System.out.println();

        int num = 999;  // LOCAL que sombrea a la global
        System.out.println("  Variable local num = " + num + "   (oculta a la global)");
        System.out.println("  Variable global num = " + Video_3_05_VariablesLocalesGlobales.num + "   (accedida con nombre de clase)");
        System.out.println("  (Son variables distintas!)");
        System.out.println();

        // ============================================================
        // EJEMPLO 7: La variable global NO se modifica paso por valor
        // ============================================================

        separador("EJEMPLO 7: Paso por valor con variable global");
        System.out.println("  Aunque pasemos la global a un metodo, se pasa una");
        System.out.println("  COPIA. Dentro del metodo se modifica la copia,");
        System.out.println("  la global NO cambia.");
        System.out.println();

        Video_3_05_VariablesLocalesGlobales.num = 2;
        System.out.println("  global num antes de doble() = " + Video_3_05_VariablesLocalesGlobales.num);

        int res = doble(Video_3_05_VariablesLocalesGlobales.num);
        System.out.println("  resultado del metodo = " + res + "   (2*2=4 dentro)");
        System.out.println("  global num despues de doble() = " + Video_3_05_VariablesLocalesGlobales.num + "   (sigue siendo 2!)");
        System.out.println("  (Paso por valor: la copia se modifica, el original no)");
        System.out.println();

        // ============================================================
        // RESUMEN DE TODOS LOS EJEMPLOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        Video_3_05_VariablesLocalesGlobales.num = 2;  // Reset global

        System.out.println("Ej 1: num local=10, doble(10)             -> " + doble(10) + "  (local sombrea a global)");
        System.out.println("Ej 2: doble(num global=2)                 -> " + doble(2) + "  (global sin sombra)");
        System.out.println("Ej 3: cubo(4) en global                   -> " + cubo(4) + "  (64)");
        System.out.println("Ej 4: cubo(global-1) con parametro 'num'  -> " + cubo(4) + "  (parametro sombrea)");
        System.out.println("Ej 5: usarVariableGlobal()                -> accede a num=" + Video_3_05_VariablesLocalesGlobales.num);
        System.out.println("Ej 6: num local=999, global por clase     -> local=999, global=" + Video_3_05_VariablesLocalesGlobales.num);
        System.out.println("Ej 7: doble(global) no modifica global    -> resultado=" + doble(Video_3_05_VariablesLocalesGlobales.num) + ", global=" + Video_3_05_VariablesLocalesGlobales.num);

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Sobrecarga de metodos en Java");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // METODOS DEL EJEMPLO
    // -------------------------------------------------------------

    // Metodo doble: paso por valor, recibe copia
    static int doble(int a) {
        a = a * 2;      // Modifica la copia local
        return a;
    }

    // Metodo cubo: el parametro se llama 'num' (igual que la global -> sombra)
    // Dentro declara variable local x (tambien podria llamarse num y sombrear aun mas)
    static int cubo(int num) {  // 'num' es parametro formal (local)
        int x = num * num * num;  // x es local del metodo
        return x;
    }

    // Metodo que accede a la variable global
    static void usarVariableGlobal() {
        System.out.println("  Dentro de usarVariableGlobal():");
        System.out.println("    Variable global num = " + num);
        System.out.println("    (accedo directamente porque no hay otra 'num' aqui)");
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
