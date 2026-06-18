class Video_3_06_SobrecargaMetodos {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "3-06 JAVA: Sobrecarga de metodos ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=n92sGOeWPFY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=59";
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
          RESUMEN RAPIDO - SOBRECARGA DE METODOS (TEMA 3 - V6)
        ====================================================================

        --- QUE ES LA SOBRECARGA (OVERLOADING) ---
        Es la capacidad de tener VARIOS metodos con el MISMO nombre
        pero con DISTINTOS parametros (diferente tipo o cantidad).

        El compilador decide cual ejecutar segun los argumentos que
        pasemos en la llamada.

        --- REGLAS DE LA SOBRECARGA ---
        Para que dos metodos con el mismo nombre sean validos:

        1. Deben diferenciarse en el NUMERO de parametros.
        2. O en el TIPO de al menos UN parametro.
        3. El tipo de RETORNO NO cuenta para diferenciarlos.
        4. Si tienen los MISMOS parametros (mismo tipo y cantidad),
           da igual que el retorno sea distinto -> ERROR de compilacion.

        --- CASO ESPECIAL: SIN PARAMETROS ---
        NO se pueden tener dos metodos con el mismo nombre y SIN
        parametros, aunque el tipo de retorno sea diferente.
        Java no sabria cual llamar.
        Ej: static String saludar() y static void saludar() -> ERROR.

        --- CASO: MISMOS PARAMETROS, DISTINTO RETORNO ---
        Tener:
          static int suma(int a, int b) { return a + b; }
          static void suma(int a, int b) { System.out.println(a+b); }
        -> ERROR de compilacion (mismos parametros).

        Solucion: cambiar tipo de al menos un parametro.
          static int suma(int a, int b) { return a + b; }
          static void suma(double a, double b) { System.out.println(a+b); }
        -> AHORA SI FUNCIONA.

        --- PROMOCION DE TIPOS ---
        Java puede hacer conversiones automaticas:
        - int -> double: SI (sin perdida).
        - Si hay suma(int, int) y suma(double, double):
          llamar suma(1, 2) -> usa suma(int, int).
          llamar suma(1.0, 2) -> usa suma(double, double) (int a double).

        Si pasamos un char a un metodo int, Java convierte el char a
        su codigo ASCII/Unicode (ej: 'a' = 97).

        --- EJEMPLOS VALIDOS ---
          static String saludar()
          static String saludar(String nombre)
          static String saludar(String nombre, String ciudad)

        --- EJEMPLOS INVALIDOS ---
          static String saludar() y static void saludar()
            -> ERROR: mismos parametros (ninguno)

          static int suma(int a, int b) y static void suma(int a, int b)
            -> ERROR: mismos parametros

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Sobrecarga = varios metodos con mismo nombre, distintos params.
        * No se puede sobrecargar SOLO por el tipo de retorno.
        * Sin parametros -> solo UN metodo con ese nombre.
        * Al menos un parametro debe ser diferente (tipo o cantidad).
        * Java elige el metodo segun los argumentos en la llamada.
        * int -> double: conversion automatica si no hay match exacto.
        * char en metodo int: se convierte a su valor ASCII.

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
        // EJEMPLO 1: Sobrecarga basica con saludar
        // ============================================================

        separador("EJEMPLO 1: Sobrecarga del metodo saludar()");
        System.out.println("  Tenemos 3 metodos 'saludar':");
        System.out.println("    1. saludar()                          -> sin parametros");
        System.out.println("    2. saludar(String nombre)             -> 1 parametro String");
        System.out.println("    3. saludar(String nombre, String ciudad) -> 2 parametros String");
        System.out.println();

        System.out.println("  saludar()                          = \"" + saludar() + "\"");
        System.out.println("  saludar(\"Pepe\")                    = \"" + saludar("Pepe") + "\"");
        System.out.println("  saludar(\"Pepe\", \"Xativa\")          = \"" + saludar("Pepe", "Xativa") + "\"");
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Mostrar resultados por pantalla
        // ============================================================

        separador("EJEMPLO 2: Mostrando saludar() con System.out.println");
        System.out.println("    " + saludar());
        System.out.println("    " + saludar("Pepe"));
        System.out.println("    " + saludar("Pepe", "Xativa"));
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Asignar retorno a variable
        // ============================================================

        separador("EJEMPLO 3: Guardar retorno en variable");
        String texto = saludar("Maria");
        System.out.println("  String texto = saludar(\"Maria\");");
        System.out.println("  System.out.println(texto);");
        System.out.println("  Resultado: " + texto);
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Sobrecarga suma int vs double
        // ============================================================

        separador("EJEMPLO 4: Sobrecarga suma(int,int) y suma(double,double)");
        System.out.println("  suma(1, 2)          = " + suma(1, 2) + "        (int + int -> devuelve int)");
        System.out.print("  suma(1.0, 2.0)      = ");
        suma(1.0, 2.0);
        System.out.println("                     (double+double -> imprime y devuelve void)");
        System.out.print("  suma(1.0, 2)        = ");
        suma(1.0, 2);
        System.out.println("                     (double+int -> usa suma double)");
        System.out.println("  suma('a', 3)        = " + suma('a', 3) + "       (char+int -> 'a'=97, 97+3=100)");
        System.out.println();

        // ============================================================
        // EJEMPLO 5: Demostracion retorno no diferencia
        // ============================================================

        separador("EJEMPLO 5: El tipo de retorno NO diferencia");
        System.out.println("  Dos metodos con mismos parametros pero distinto");
        System.out.println("  retorno dan ERROR de compilacion.");
        System.out.println();
        System.out.println("  static int suma(int a, int b)     { return a+b; }");
        System.out.println("  static void suma(int a, int b)    { System.out.println(a+b); }");
        System.out.println("  -> ERROR: ambiguedad (mismos parametros)");
        System.out.println();
        System.out.println("  Solucion: cambiar tipo de parametro:");
        System.out.println("  static void suma(double a, double b) { ... }");
        System.out.println("  -> AHORA SI funciona (parametro double != int)");
        System.out.println();

        // ============================================================
        // EJEMPLO 6: suma(void) con double
        // ============================================================

        separador("EJEMPLO 6: Usando suma(double, double) - imprime resultado");
        System.out.print("  suma(3.0, 4.0) -> ");
        suma(3.0, 4.0);
        System.out.println();

        // ============================================================
        // EJEMPLO 7: char como parametro int
        // ============================================================

        separador("EJEMPLO 7: char se convierte a su valor ASCII");
        System.out.println("  En Java, un char se puede pasar a un parametro int.");
        System.out.println("  El char se convierte a su codigo numerico Unicode.");
        System.out.println();
        System.out.println("  suma('a', 3)   = " + suma('a', 3) + "   ('a' = 97, 97+3=100)");
        System.out.println("  suma('A', 3)   = " + suma('A', 3) + "   ('A' = 65, 65+3=68)");
        System.out.println("  suma('0', 3)   = " + suma('0', 3) + "   ('0' = 48, 48+3=51)");
        System.out.println();

        // ============================================================
        // EJEMPLO 8: Mas sobrecarga (tres tipos de presentar)
        // ============================================================

        separador("EJEMPLO 8: Otros ejemplos de sobrecarga");
        System.out.println("  Presentar(\"Juan\")       = \"" + presentar("Juan") + "\"");
        System.out.println("  Presentar(\"Juan\", 25)   = \"" + presentar("Juan", 25) + "\"");
        System.out.println("  Presentar(\"Juan\", \"ES\") = \"" + presentar("Juan", "ES") + "\"");
        System.out.println();

        // ============================================================
        // COMPARACION DE RESULTADOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ej 1: saludar()                        -> \"" + saludar() + "\"");
        System.out.println("Ej 1: saludar(\"Pepe\")                  -> \"" + saludar("Pepe") + "\"");
        System.out.println("Ej 1: saludar(\"Pepe\", \"Xativa\")        -> \"" + saludar("Pepe", "Xativa") + "\"");
        System.out.println("Ej 4: suma(1, 2)                       -> " + suma(1, 2));
        System.out.println("Ej 4: suma(1.0, 2.0)                  -> imprime por pantalla (void)");
        System.out.println("Ej 7: suma('a', 3)                    -> " + suma('a', 3));
        System.out.println("Ej 8: presentar(\"Juan\")               -> \"" + presentar("Juan") + "\"");
        System.out.println("Ej 8: presentar(\"Juan\", 25)           -> \"" + presentar("Juan", 25) + "\"");
        System.out.println("Ej 8: presentar(\"Juan\", \"ES\")         -> \"" + presentar("Juan", "ES") + "\"");

        System.out.println();
        System.out.println("========================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Pila de llamadas en Java");
        System.out.println("========================================================");
    }

    // -------------------------------------------------------------
    // METODOS SOBRECARGADOS: saludar
    // -------------------------------------------------------------

    // Version 1: sin parametros
    static String saludar() {
        return "Hola, que tal estas?";
    }

    // Version 2: con un parametro String
    static String saludar(String nombre) {
        return "Hola " + nombre + ", como estas?";
    }

    // Version 3: con dos parametros String
    static String saludar(String nombre, String ciudad) {
        return "Hola " + nombre + ", que tal por " + ciudad + "?";
    }

    // -------------------------------------------------------------
    // METODOS SOBRECARGADOS: suma
    // -------------------------------------------------------------

    // Version int: devuelve int (NO imprime)
    static int suma(int a, int b) {
        return a + b;
    }

    // Version double: imprime el resultado (void)
    // Si tuviera (int a, int b) daria ERROR con la de arriba
    // Al cambiar a (double a, double b) ya son diferentes -> VALIDO
    static void suma(double a, double b) {
        System.out.print(a + b);
    }

    // -------------------------------------------------------------
    // METODOS SOBRECARGADOS: presentar
    // -------------------------------------------------------------

    // Version solo con nombre
    static String presentar(String nombre) {
        return "Me llamo " + nombre;
    }

    // Version con nombre y edad
    static String presentar(String nombre, int edad) {
        return "Me llamo " + nombre + " y tengo " + edad + " anios";
    }

    // Version con nombre e idioma (String, String)
    static String presentar(String nombre, String idioma) {
        if (idioma.equals("ES")) {
            return "Hola, soy " + nombre;
        } else {
            return "Hello, I am " + nombre;
        }
    }

    // -------------------------------------------------------------
    // METODO AUXILIAR: separador
    // -------------------------------------------------------------

    public static void separador(String titulo) {
        System.out.println();
        System.out.println("========================================================");
        System.out.println("  " + titulo);
        System.out.println("========================================================");
    }
}
