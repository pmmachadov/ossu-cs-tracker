class Video_2_33_Llaves_Scope_Indentado {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "2-33 JAVA: Llaves, Scope e indentado [DAM - DAW]";
    public static final String URL = "https://www.youtube.com/watch?v=2EJ45xrbR7Y&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=49";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // RESUMEN para el examen (CHULETA)
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ====================================================================
          RESUMEN RAPIDO - LLAVES, SCOPE E INDENTADO
        ====================================================================

        --- SCOPE (AMBITO DE VARIABLES) ---

        Una variable declarada entre llaves { } SOLO existe dentro
        de esas llaves. Fuera de ellas, la variable NO es visible.

        --- SCOPE EN BUCLES FOR ---
        La variable declarada en la cabecera del for SOLO existe
        dentro del bucle.

        --- MISMO NOMBRE EN DISTINTOS AMBITOS ---
        Se puede declarar variables con el mismo nombre si estan
        en ambitos distintos (no se ven entre si).

        --- AMBITOS ANIDADOS ---
        Desde un ambito interno se ven las variables del externo.
        Al reves NO: desde fuera no se ven las de dentro.

        --- INDENTADO ---
        1. Kernighan & Ritchie (K&R): llave apertura en misma linea.
           Estilo POR DEFECTO en VS Code (Alt+Shift+F).
        2. Allman: llaves SIEMPRE solas en su linea.

        --- IMPORTANTE PARA EXAMEN ---
        1. Las llaves definen el ambito de las variables.
        2. Variable declarada dentro de { } NO existe fuera.
        3. En un for, la variable de la cabecera solo existe dentro.
        4. Se puede reutilizar el mismo nombre en ambitos distintos.
        5. Alt+Shift+F en Windows para auto-indentar VS Code.
        """;

    // -------------------------------------------------------------
    // METODO PRINCIPAL
    // -------------------------------------------------------------

    public static void main(String[] args) {

        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();

        // EJEMPLO 1: Scope basico con llaves
        separador("EJEMPLO 1: SCOPE BASICO CON LLAVES");

        {
            int a = 1, b = 2, c = 3;
            System.out.println("  Dentro del bloque: a=" + a + ", b=" + b + ", c=" + c);
            a++;
            b += c;

            {   // bloque anidado
                int d = a;
                System.out.println("  Dentro del bloque anidado: d=" + d);
            }
        }
        System.out.println("  (Fuera del bloque: a, b, c, d ya no existen)");
        System.out.println();

        // EJEMPLO 2: Scope en bucles for
        separador("EJEMPLO 2: SCOPE EN BUCLE FOR");

        for (int j = 0; j < 3; j++) {
            System.out.println("  Dentro del for: j = " + j);
        }
        System.out.println("  (Fuera del for: j ya no existe)");
        System.out.println();

        // EJEMPLO 3: Mismo nombre en distintos ambitos
        separador("EJEMPLO 3: MISMO NOMBRE EN DISTINTOS AMBITOS");

        for (int j = 0; j < 3; j++) {
            System.out.println("  Primer for: j = " + j);
        }

        for (int j = 0; j < 3; j++) {
            System.out.println("  Segundo for: j = " + j);
        }

        int j = 3;
        System.out.println("  Fuera de los bucles: j = " + j);
        System.out.println();

        // EJEMPLO 4: For anidado - ambitos
        separador("EJEMPLO 4: FOR ANIDADO - AMBITOS");

        int d = 4;
        for (int j2 = 0; j2 < d; j2++) {
            for (int i = 0; i < d; i++) {
                // Aqui se ven j2 e i
            }
        }
        System.out.println("  For anidado ejecutado correctamente.");
        System.out.println("  d = " + d + " (visible fuera)");
        System.out.println();

        // EJEMPLO 5: Variable declarada DENTRO del bloque del for
        separador("EJEMPLO 5: VARIABLE DECLARADA DENTRO DEL FOR");

        for (int i = 0; i < 3; i++) {
            int x = i * 2;
            System.out.println("  i=" + i + ", x=" + x);
        }
        System.out.println("  (x declarada dentro del for, no existe fuera)");
        System.out.println();

        // EJEMPLO 6: Variable declarada ANTES del for
        separador("EJEMPLO 6: VARIABLE DECLARADA ANTES DEL FOR");

        int j2;
        for (j2 = 0; j2 < 3; j2++) {
            System.out.println("  j2 = " + j2);
        }
        System.out.println("  Fuera del for: j2 = " + j2 + " (aun existe!)");
        System.out.println();

        // EJEMPLO 7: Reutilizar nombre tras llaves
        separador("EJEMPLO 7: REUTILIZAR NOMBRE TRAS LLAVES");

        {
            int y = 10;
            System.out.println("  Dentro del bloque: y = " + y);
        }

        int y = 20;
        System.out.println("  Fuera del bloque: y = " + y);
        System.out.println();

        // DEMOSTRACION DE INDENTADO
        separador("DEMOSTRACION DE INDENTADO");

        System.out.println("  Estilo KERNIGHAN & RITCHIE (K&R):");
        System.out.println("    for (...) {       // llave en la misma linea");
        System.out.println("        // codigo");
        System.out.println("    }");
        System.out.println();
        System.out.println("  Estilo ALLMAN (alternativo):");
        System.out.println("    for (...)");
        System.out.println("    {                 // llave sola en su linea");
        System.out.println("        // codigo");
        System.out.println("    }");
        System.out.println();
        System.out.println("  En VS Code: Alt+Shift+F para auto-indentar (K&R por defecto)");
        System.out.println();

        // RESUMEN
        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ejemplo 1: Scope basico con llaves          -> variables solo existen dentro");
        System.out.println("Ejemplo 2: Scope en bucle for               -> j solo existe dentro del for");
        System.out.println("Ejemplo 3: Mismo nombre en distintos for    -> valido, ambitos diferentes");
        System.out.println("Ejemplo 4: For anidado - ambitos            -> j2 visible, i solo dentro");
        System.out.println("Ejemplo 5: Variable declarada dentro del for -> x solo existe ahi dentro");
        System.out.println("Ejemplo 6: Variable declarada ANTES del for -> j2 existe fuera");
        System.out.println("Ejemplo 7: Reutilizar nombre tras llaves    -> valido porque desaparecio");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Conversion de tipos (casting) en Java");
        System.out.println("============================================================");
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