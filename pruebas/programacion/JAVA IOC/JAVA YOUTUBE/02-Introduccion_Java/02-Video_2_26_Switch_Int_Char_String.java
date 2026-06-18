class Video_2_26_Switch_Int_Char_String {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "2-26 JAVA: switch (con int, char y String) [DAM - DAW]";
    public static final String URL = "https://www.youtube.com/watch?v=AV5hyYaJIw8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=42";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------

    public static final String RESUMEN =
        """
        ================================================================
          2-26 SWITCH (con int, char y String) EN JAVA
        ================================================================

        El switch permite evaluar una expresion y ejecutar diferentes
        bloques de codigo segun el valor que devuelva. Es una alternativa
        mas limpia que muchos if-else encadenados.

        --- SINTAXIS BASICA ---

            switch (expresion) {
                case valor1:
                    // instrucciones
                    break;
                case valor2:
                    // instrucciones
                    break;
                default:
                    // instrucciones por defecto
            }

        - La expresion puede devolver un int, char, String, enum, etc.
        - Cada case tiene un valor fijo que se compara con la expresion.
        - break sale del switch; si no se pone, continua al siguiente case
          (efecto "fall through").
        - default es opcional: se ejecuta si ningun case coincide.

        --- TIPOS DE DATOS QUE PUEDE EVALUAR SWITCH ---

        * int (y byte, short, char se promocionan a int)
        * String (a partir de Java 7)
        * char
        * enum
        * Integer, Character, etc. (wrapper classes)

        --- EXPRESION CON OPERACION ---

        La expresion puede ser una operacion, por ejemplo x * 10:

            switch (x * 10) {
                case 10: ...
                case 30: ...
                case 40: ...
            }

        --- MULTIPLES INSTRUCCIONES EN UN CASE ---

        No hacen falta llaves {} dentro de un case. Simplemente se ponen
        las instrucciones una tras otra y se cierra con break:

            case 40:
                System.out.println("El valor de X es 4");
                System.out.println("Instruccion adicional");
                break;

        --- FALL THROUGH (SIN BREAK) ---

        Si un case no tiene break, la ejecucion "cae" al siguiente case
        hasta encontrar un break o llegar al final del switch.

        Esto se usa para que varios cases compartan el mismo codigo:

            case 1:
            case 2:
            case 3:
                System.out.println("El valor de X estaba entre 1 y 3");
                break;

        --- DEFAULT ---

        Se ejecuta cuando ningun case coincide con el valor de la expresion.
        No necesita break al final, aunque ponerlo no afecta.

        --- SWITCH CON char ---

            char letra = 'A';
            switch (letra) {
                case 'A': ...
                case 'B': ...
            }

        --- IGNORAR MAYUSCULAS/MINUSCULAS ---

        Se puede usar Character.toLowerCase() o Character.toUpperCase()
        para normalizar la entrada antes del switch:

            char letra = Character.toLowerCase(letraOriginal);
            switch (letra) {
                case 'a': ...  // Tanto 'A' como 'a' entran aqui
                case 'b': ...
            }

        --- SWITCH CON String ---

            String palabra = "opcion1";
            switch (palabra.toLowerCase()) {
                case "opcion1": ...
                case "opcion2": ...
            }

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * switch evalua una expresion y ejecuta el case correspondiente
        * break es necesario para evitar "fall through"
        * El fall through se puede usar INTENCIONADAMENTE para agrupar cases
        * default es opcional, para valores no contemplados
        * Los cases pueden tener varias instrucciones sin llaves
        * Los valores de los cases deben ser constantes (literales)
        * switch acepta int, char, String, enum y sus wrappers
        * Para ignorar mayusculas: toLowerCase() o toUpperCase()
        * No es necesario break al final del switch (tras default)
        ================================================================
        """;

    // -------------------------------------------------------------

    public static void main(String[] args) {
        mostrarInformacion();

        System.out.println();
        System.out.println("============================================");
        System.out.println("   EJEMPLOS PRACTICOS - SWITCH");
        System.out.println("============================================");
        System.out.println();

        // --- Ejemplo 1: switch con expresion x * 10 ---
        System.out.println("--- Ejemplo 1: switch con x * 10 ---");
        int x = 3;
        switch (x * 10) {
            case 10:
                System.out.println("El valor de X es 1");
                break;
            case 30:
                System.out.println("El valor de X es 3");
                break;
            case 40:
                System.out.println("El valor de X es 4");
                System.out.println("Instruccion adicional");
                break;
            case 50:
                System.out.println("El valor de X es 5");
                break;
            case 60:
                System.out.println("El valor de X es 6");
                break;
        }
        System.out.println("(x = " + x + ", x*10 = " + (x*10) + ")");
        System.out.println();

        // --- Ejemplo 2: switch con default ---
        System.out.println("--- Ejemplo 2: switch con default ---");
        x = 7;
        switch (x * 10) {
            case 30:
                System.out.println("El valor de X es 3");
                break;
            case 50:
                System.out.println("El valor de X es 5");
                break;
            case 60:
                System.out.println("El valor de X es 6");
                break;
            default:
                System.out.println("El valor de X no era 3, 5 ni 6");
        }
        System.out.println("(x = " + x + ")");
        System.out.println();

        // --- Ejemplo 3: fall through (varios cases sin break) ---
        System.out.println("--- Ejemplo 3: Fall through (varios cases) ---");
        x = 2;
        switch (x) {
            case 1:
            case 2:
            case 3:
                System.out.println("El valor de X estaba entre 1 y 3");
                break;
            case 4:
            case 5:
                System.out.println("El valor de X era 4 o 5");
                break;
            case 6:
                System.out.println("El valor de X era 6");
                x = 10;
                System.out.println("Operaciones auxiliares completadas");
                break;
            default:
                System.out.println("El valor de X no estaba entre 1 y 6");
        }
        System.out.println("(x final = " + x + ")");
        System.out.println();

        // --- Ejemplo 4: sin break (fall through completo) ---
        System.out.println("--- Ejemplo 4: Sin break (continua hasta encontrar uno) ---");
        x = 3;
        switch (x) {
            case 1:
            case 2:
            case 3:
                System.out.println("El valor de X estaba entre 1 y 3");
                // Sin break: continua al siguiente case
            case 4:
            case 5:
                System.out.println("El valor de X era 4 o 5");
                // Sin break: continua
            case 6:
                System.out.println("El valor de X era 6");
                break;  // Aqui sale
            default:
                System.out.println("Valor no contemplado");
        }
        System.out.println("(x = " + x + ")");
        System.out.println();

        // --- Ejemplo 5: switch con char ---
        System.out.println("--- Ejemplo 5: switch con char ---");
        char letra = 'A';
        switch (letra) {
            case 'A':
                System.out.println("Letra A mayuscula");
                break;
            case 'a':
                System.out.println("Letra A minuscula");
                break;
            case 'B':
                System.out.println("Letra B mayuscula");
                break;
            case 'b':
                System.out.println("Letra B minuscula");
                break;
            default:
                System.out.println("Letra no es A ni B");
        }
        System.out.println();

        // --- Ejemplo 6: char con toLowerCase ---
        System.out.println("--- Ejemplo 6: char con toLowerCase (ignorar mayusculas) ---");
        letra = 'B';
        switch (Character.toLowerCase(letra)) {
            case 'a':
                System.out.println("Letra A (mayuscula o minuscula)");
                break;
            case 'b':
                System.out.println("Letra B (mayuscula o minuscula)");
                break;
            default:
                System.out.println("Letra no es A ni B");
        }
        System.out.println();

        // --- Ejemplo 7: switch con String y toUpperCase ---
        System.out.println("--- Ejemplo 7: switch con String (menu opciones) ---");
        String palabra = "opcion1";
        switch (palabra.toUpperCase()) {
            case "OPCION1":
                System.out.println("Opcion 1 seleccionada");
                break;
            case "OPCION2":
                System.out.println("Opcion 2 seleccionada");
                break;
            default:
                System.out.println("Opcion por defecto");
        }
        System.out.println();

        // --- Ejemplo 8: String con opcion inexistente ---
        System.out.println("--- Ejemplo 8: String con opcion inexistente (default) ---");
        palabra = "opcion3";
        switch (palabra.toUpperCase()) {
            case "OPCION1":
                System.out.println("Opcion 1 seleccionada");
                break;
            case "OPCION2":
                System.out.println("Opcion 2 seleccionada");
                break;
            default:
                System.out.println("Opcion por defecto (opcion no valida)");
        }
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
