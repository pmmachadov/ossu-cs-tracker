class Video_2_34_Casting_Parse {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "2-34 JAVA: Casting y Parse [DAM - DAW]";
    public static final String URL = "https://www.youtube.com/watch?v=b6RWMp7vOe8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=50";
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
          RESUMEN RAPIDO - CASTING Y PARSE
        ====================================================================

        --- CASTING (conversion explicita entre tipos compatibles) ---

        Sintaxis: (tipo) expresion

        Ejemplos:
            double resultado = Math.pow(2, 3);  // 8.0 (double)
            int n = (int) resultado;             // 8 (casting a int)

            char letra = 'a';
            int valorASCII = (int) letra;        // 97 (tabla ASCII)

        --- CUIDADO CON CASTING ---
        Si conviertes un char numerico a int:
            char c = '2';    // el caracter '2', no el numero 2
            int n = (int) c; // n = 50 (valor ASCII de '2')
        Para obtener el numero real: Character.getNumericValue(c) -> 2

        --- PARSE (String a tipo primitivo) ---

        Se usan las CLASES ENVOLTURA (wrapper classes):

            String texto = "123";
            int num = Integer.parseInt(texto);     // String -> int
            double d = Double.parseDouble("12.35"); // String -> double
            boolean b = Boolean.parseBoolean("true"); // String -> boolean
            long l = Long.parseLong("123456");      // String -> long
            byte by = Byte.parseByte("12");          // String -> byte
            short s = Short.parseShort("123");       // String -> short
            float f = Float.parseFloat("12.5");      // String -> float

        --- CHAR A STRING ---
            char letra = 'a';
            String s = Character.toString(letra);   // "a"

        --- CHAR A INT (valor numerico real) ---
            char c = '5';
            int n = Character.getNumericValue(c);   // 5 (no 53!)

        --- IMPORTANTE PARA EXAMEN ---
        1. Casting: (tipo) para convertir entre tipos compatibles.
        2. Parse: Integer.parseInt() para String -> int.
        3. Clases envoltura: Integer, Double, Boolean, Character, etc.
        4. Cuidado: (int) '2' da 50 (ASCII), no 2.
        5. Character.getNumericValue() para char numerico -> int real.
        6. Math.pow() siempre devuelve double, necesita casting.
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
        // EJEMPLO 1: CASTING basico (Math.pow devuelve double)
        // ============================================================

        separador("EJEMPLO 1: CASTING - Math.pow(a, b)");

        int a = 3, b = 3;
        double resultadoDouble = Math.pow(a, b);
        System.out.println("  Math.pow(" + a + ", " + b + ") = " + resultadoDouble + " (double)");

        int c = (int) Math.pow(a, b);  // casting explicito
        System.out.println("  (int) Math.pow(" + a + ", " + b + ") = " + c + " (int)");
        System.out.println();

        // ============================================================
        // EJEMPLO 2: CASTING char a int (valor ASCII)
        // ============================================================

        separador("EJEMPLO 2: CASTING char -> int (valor ASCII)");

        char letra = 'a';
        int valorASCII = (int) letra;
        System.out.println("  (int) '" + letra + "' = " + valorASCII + " (codigo ASCII)");
        System.out.println("  (int) 'A' = " + (int) 'A');
        System.out.println("  (int) '0' = " + (int) '0');
        System.out.println("  (int) '2' = " + (int) '2' + "  (CUIDADO: no es 2!)");
        System.out.println();

        // ============================================================
        // EJEMPLO 3: CUIDADO con casting de char numerico
        // ============================================================

        separador("EJEMPLO 3: CUIDADO - char '2' a int");

        char numChar = '2';
        int mal = (int) numChar;           // 50 (ASCII)
        int bien = Character.getNumericValue(numChar); // 2 (real)

        System.out.println("  char numChar = '" + numChar + "'");
        System.out.println("  (int) numChar = " + mal + "  (VALOR ASCII! Mal)");
        System.out.println("  Character.getNumericValue(numChar) = " + bien + "  (BIEN)");
        System.out.println();

        // ============================================================
        // EJEMPLO 4: PARSE - String a int
        // ============================================================

        separador("EJEMPLO 4: PARSE - String a int (Integer.parseInt)");

        String textoNum = "123";
        int numero = Integer.parseInt(textoNum);
        System.out.println("  Integer.parseInt(\"" + textoNum + "\") = " + numero);
        System.out.println("  (es un int real: " + (numero + 1) + " si sumamos 1)");
        System.out.println();

        // ============================================================
        // EJEMPLO 5: PARSE - String a double
        // ============================================================

        separador("EJEMPLO 5: PARSE - String a double (Double.parseDouble)");

        String real = "12.35";
        double d = Double.parseDouble(real);
        System.out.println("  Double.parseDouble(\"" + real + "\") = " + d);
        System.out.println("  " + d + " * 2 = " + (d * 2));
        System.out.println();

        // ============================================================
        // EJEMPLO 6: PARSE - String a boolean
        // ============================================================

        separador("EJEMPLO 6: PARSE - String a boolean (Boolean.parseBoolean)");

        String boolStr = "true";
        boolean condicion = Boolean.parseBoolean(boolStr);
        System.out.println("  Boolean.parseBoolean(\"" + boolStr + "\") = " + condicion);
        if (condicion) {
            System.out.println("  -> La condicion es VERDADERA");
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 7: CHAR a STRING con Character.toString
        // ============================================================

        separador("EJEMPLO 7: CHAR a STRING");

        char let = 'a';
        String frase = Character.toString(let);
        System.out.println("  Character.toString('" + let + "') = \"" + frase + "\"");
        System.out.println();

        // ============================================================
        // EJEMPLO 8: CHAR numerico -> String -> int (dos pasos)
        // ============================================================

        separador("EJEMPLO 8: CHAR '2' -> String -> int");

        char num = '2';
        String txt = Character.toString(num);
        int val = Integer.parseInt(txt);
        System.out.println("  char num = '" + num + "'");
        System.out.println("  Character.toString(num) = \"" + txt + "\"");
        System.out.println("  Integer.parseInt(txt) = " + val);
        System.out.println("  (Ahora si es el numero 2: " + val + " elevado a 3 = " + (int)Math.pow(val, 3) + ")");
        System.out.println();

        // ============================================================
        // EJEMPLO 9: Otros parse (long, float, byte, short)
        // ============================================================

        separador("EJEMPLO 9: OTROS PARSE (long, float, byte, short)");

        long longVal = Long.parseLong("123456789");
        System.out.println("  Long.parseLong(\"123456789\") = " + longVal);

        float floatVal = Float.parseFloat("12.5");
        System.out.println("  Float.parseFloat(\"12.5\") = " + floatVal);

        byte byteVal = Byte.parseByte("12");
        System.out.println("  Byte.parseByte(\"12\") = " + byteVal);

        short shortVal = Short.parseShort("123");
        System.out.println("  Short.parseShort(\"123\") = " + shortVal);
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ejemplo 1: Casting (int) Math.pow(3,3)       -> 27");
        System.out.println("Ejemplo 2: (int) 'a' = 97                   -> valor ASCII");
        System.out.println("Ejemplo 3: (int) '2' = 50, getNumeric=2    -> CUIDADO!");
        System.out.println("Ejemplo 4: Integer.parseInt(\"123\")         -> 123");
        System.out.println("Ejemplo 5: Double.parseDouble(\"12.35\")     -> 12.35");
        System.out.println("Ejemplo 6: Boolean.parseBoolean(\"true\")    -> true");
        System.out.println("Ejemplo 7: Character.toString('a')          -> \"a\"");
        System.out.println("Ejemplo 8: char '2' -> String -> int       -> 2");
        System.out.println("Ejemplo 9: Long, Float, Byte, Short.parse  -> OK");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Ejercicios");
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