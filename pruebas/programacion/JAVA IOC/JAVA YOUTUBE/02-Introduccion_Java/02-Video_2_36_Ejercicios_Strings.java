class Video_2_36_Ejercicios_Strings {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "2-36 JAVA: Ejercicios resueltos STRINGS [DAM - DAW]";
    public static final String URL = "https://www.youtube.com/watch?v=D5rLwK2a0H4&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=52";
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
          RESUMEN RAPIDO - EJERCICIOS DE STRINGS (Para el examen)
        ====================================================================

        --- METODOS IMPORTANTES DE STRING ---
        s.length()          -> numero de caracteres
        s.charAt(i)         -> caracter en posicion i (0-based)
        s.trim()            -> quita espacios al principio y final
        s.toLowerCase()     -> convierte a minusculas
        s.equals(otro)      -> compara igualdad (contenido)
        s.substring(i, j)   -> subcadena desde i hasta j-1

        --- EJERCICIO 1: SEPARAR LETRAS CON ESPACIOS ---
        Recorrer String con for:
            for (int i = 0; i < nombre.length(); i++) {
                System.out.print(nombre.charAt(i) + " ");
            }

        Clave: i < nombre.length()  (no <=, para evitar error)

        --- EJERCICIO 2: PALABRA MAS LARGA ---
        Comparar longitudes con .length():
            if (palabra.length() > palabraMax.length()) {
                palabraMax = palabra;
            }

        Clave: empezar palabraMax como "" (cadena vacia).

        --- EJERCICIO 3: CONTAR PALABRAS ---
        Sin usar split(). Solo charAt, trim y length:
            String frase = entrada.nextLine().trim();
            int palabras = 1;
            for (int i = 0; i < frase.length() - 1; i++) {
                if (frase.charAt(i) == ' ' && frase.charAt(i+1) != ' ') {
                    palabras++;
                }
            }

        Claves:
        - .trim() quita espacios al principio/final
        - length()-1 porque comparamos i con i+1
        - Detectar: espacio + letra = nueva palabra
        - Caso especial: frase vacia -> if (frase.equals(""))

        --- EJERCICIO 4: PALINDROMO ---
        Solucion 1 (invertir String):
            String invertida = "";
            for (int i = palabra.length()-1; i >= 0; i--) {
                invertida += palabra.charAt(i);
            }
            if (palabra.equals(invertida)) { /* es palindromo */ }

        Solucion 2 (mas eficiente, sin String auxiliar):
            boolean esPalindromo = true;
            for (int i = 0; i < palabra.length() / 2; i++) {
                if (palabra.charAt(i) != palabra.charAt(palabra.length()-1-i)) {
                    esPalindromo = false;
                    break;
                }
            }

        Claves:
        - toLowerCase() para ignorar mayusculas/minusculas
        - Solucion 2: solo compara hasta mitad (length()/2)
        - Solucion 2: NO necesita String auxiliar
        - break cuando encuentra diferencia

        --- IMPORTANTE PARA EXAMEN ---
        1. String es 0-based: posiciones de 0 a length()-1.
        2. charAt(i) con i = length() da ERROR (fuera de rango).
        3. .trim() imprescindible al leer frases con espacios.
        4. Para recorrer String: for (int i = 0; i < s.length(); i++)
        5. Para invertir: for (int i = s.length()-1; i >= 0; i--)
        6. equals() compara CONTENIDO, == compara REFERENCIAS.
        7. Palindromo: comparar hasta mitad es mas eficiente.
        """;

    // -------------------------------------------------------------
    // METODO PRINCIPAL
    // -------------------------------------------------------------

    public static void main(String[] args) {

        java.util.Scanner entrada = new java.util.Scanner(System.in);

        separador("EJERCICIO 1: SEPARAR LETRAS CON ESPACIOS");
        System.out.println("  Pide una palabra y la muestra con espacios entre letras.");
        System.out.println("  Ejemplo: \"Programacion\" -> \"P r o g r a m a c i o n\"");
        System.out.println();

        separador("EJERCICIO 2: PALABRA MAS LARGA");
        System.out.println("  Pide 5 palabras y muestra la de mayor longitud.");
        System.out.println("  Si hay empate, muestra la primera.");
        System.out.println();

        separador("EJERCICIO 3: CONTAR PALABRAS");
        System.out.println("  Cuenta las palabras de una frase usando solo charAt, trim y length.");
        System.out.println("  Ejemplo: \" hoy  es viernes,  27 de octubre    2022  \" -> 8 palabras");
        System.out.println();

        separador("EJERCICIO 4: PALINDROMO");
        System.out.println("  Determina si una palabra es palindromo.");
        System.out.println("  (Se lee igual al reves: reconocer, anilina, etc.)");
        System.out.println("  Incluye DOS soluciones: invertir + comparar vs comparar mitad.");
        System.out.println();

        // ============================================================
        // EJERCICIO 1: Separar letras con espacios
        // ============================================================

        separador("SOLUCION EJERCICIO 1");
        System.out.println("  Demo con palabra fija: \"Programacion\"");
        String demoPalabra = "Programacion";
        System.out.print("  Resultado: ");
        for (int i = 0; i < demoPalabra.length(); i++) {
            System.out.print(demoPalabra.charAt(i) + " ");
        }
        System.out.println();
        System.out.println("  (Para probar interactivo, descomentar codigo en main)");
        System.out.println();

        // ============================================================
        // EJERCICIO 2: Palabra mas larga (de 5)
        // ============================================================

        separador("SOLUCION EJERCICIO 2");
        System.out.println("  Demo con palabras fijas: casa, mesa, avestruz, sic, Ana");
        String[] palabrasDemo = {"casa", "mesa", "avestruz", "sic", "Ana"};
        String palabraMax = "";
        for (int i = 0; i < palabrasDemo.length; i++) {
            if (palabrasDemo[i].length() > palabraMax.length()) {
                palabraMax = palabrasDemo[i];
            }
        }
        System.out.println("  La palabra mas larga es: " + palabraMax);
        System.out.println();

        // ============================================================
        // EJERCICIO 3: Contar palabras
        // ============================================================

        separador("SOLUCION EJERCICIO 3");
        String fraseDemo = "  hoy es viernes,  27 de octubre    2022  ";
        String frase = fraseDemo.trim();
        System.out.println("  Frase original (con espacios): \"" + fraseDemo + "\"");
        System.out.println("  Frase after trim: \"" + frase + "\"");

        int palabras = 1;
        if (frase.equals("")) {
            palabras = 0;
        } else {
            for (int i = 0; i < frase.length() - 1; i++) {
                if (frase.charAt(i) == ' ' && frase.charAt(i+1) != ' ') {
                    palabras++;
                }
            }
        }
        String palabraTexto = (palabras == 1) ? "palabra" : "palabras";
        System.out.println("  La frase tiene " + palabras + " " + palabraTexto);
        System.out.println();

        // ============================================================
        // EJERCICIO 4: Palindromo (DOS soluciones)
        // ============================================================

        separador("SOLUCION EJERCICIO 4");
        String[] palabrasTest = {"Reconocer", "anilina", "casa", "Aba", "Hola"};

        for (String testPalabra : palabrasTest) {
            System.out.println("  Probando: \"" + testPalabra + "\"");

            // Solucion 1: invertir y comparar
            String pal = testPalabra.toLowerCase();
            String invertida = "";
            for (int i = pal.length() - 1; i >= 0; i--) {
                invertida += pal.charAt(i);
            }
            boolean sol1 = pal.equals(invertida);

            // Solucion 2: comparar desde extremos hasta mitad
            boolean esPalindromo = true;
            for (int i = 0; i < pal.length() / 2; i++) {
                if (pal.charAt(i) != pal.charAt(pal.length() - 1 - i)) {
                    esPalindromo = false;
                    break;
                }
            }

            System.out.println("    Solucion 1 (invertir): " + (sol1 ? "SI" : "NO") + " es palindromo");
            System.out.println("    Solucion 2 (mitad):   " + (esPalindromo ? "SI" : "NO") + " es palindromo");
            System.out.println();
        }

        // ============================================================
        // RESUMEN
        // ============================================================

        separador("COMPARACION DE RESULTADOS");

        System.out.println("Ejercicio 1: Separar letras      -> \"P r o g r a m a c i o n \"");
        System.out.println("Ejercicio 2: Palabra mas larga   -> avestruz");
        System.out.println("Ejercicio 3: Contar palabras     -> 8 palabras");
        System.out.println("Ejercicio 4: Palindromo          -> Reconocer=SI, anilina=SI, casa=NO, Aba=SI, Hola=NO");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Ejercicios de figuras");
        System.out.println("============================================================");

        entrada.close();
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