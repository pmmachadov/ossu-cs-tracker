class Video_2_12_Secuencias_Escape {

    public static final String TITULO = "2-12 JAVA: Secuencias de escape ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=p7p9f7wKd9Y&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=28";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-12 SECUENCIAS DE ESCAPE EN STRINGS
        ================================================================

        Las secuencias de escape nos permiten:
        - Mover el cursor dentro de la String
        - Usar caracteres especiales que son parte de la sintaxis de Java
        - Insertar caracteres Unicode

        --- TABLA DE SECUENCIAS DE ESCAPE ---

        Secuencia   Significado
        ---------   -----------
        \\n          Salto de linea (new line)
        \\b          Retroceder un caracter (backspace)
        \\t          Tabulacion horizontal (tab)
        \\r          Retorno al inicio de linea (carriage return)
        \\f          Salto de pagina (form feed)
        \\"          Comillas dobles dentro de la String
        \\'          Comillas simples dentro de la String
        \\\\          Barra invertida literal
        \\uXXXX      Caracter Unicode (XXXX en hexadecimal)

        --- EJEMPLOS DEL VIDEO ---

        Variables base:
        String nombre = "Pepe";
        String apellidos = "Martinez Garcia";

        1. nombreCompleto1 = nombre + " " + apellidos
           -> "Pepe Martinez Garcia"  (con espacio)

        2. String nombreCompleto2 = "\\"" + nombre + apellidos + "\\""
           -> "PepeMartinez Garcia"   (entre comillas dobles)
           (OJO: \\" pone una comilla doble literal en la String)

        3. String nombreCompleto3 = "\\"" + nombre + " " + apellidos + "\\""
           -> "Pepe Martinez Garcia"

        4. String nombre2 = nombre + "\\b" + nombre
           -> "PepPepe"
           Explicacion: escribe "Pepe", \\b retrocede una posicion
           (se situa sobre la 2a 'e'), luego escribe "Pepe"
           machacando la ultima 'e' -> "PepPepe"

        5. String apellidos2 = apellidos + "\\r," + nombre
           -> ",Pepenez Garcia"
           Explicacion: escribe "Martinez Garcia", \\r vuelve al
           inicio de linea, luego escribe ",Pepe" machacando las
           primeras letras: "Marti" -> ",Pepe" -> ",Pepenez Garcia"

        6. String apellidos3 = apellidos + "\\b," + nombre
           -> "Martinez Garci,Pepe"
           Explicacion: escribe "Martinez Garcia", \\b retrocede
           un caracter (sobre la 'a' final), luego ",Pepe" sustituye
           esa 'a' por ",Pepe"

        7. String apellidos4 = apellidos + "\\\\," + nombre
           -> "Martinez Garcia\\,Pepe"
           Explicacion: "\\\\" representa una barra invertida literal

        --- CARACTERES UNICODE EN STRINGS ---

        Se usa \\uXXXX donde XXXX son 4 digitos hexadecimales.

        Ejemplos:
        String u1 = "\\u00A9 " + nombre;  // © Pepe  (copyright)
        String u2 = "\\u00AE " + nombre;  // ® Pepe  (marca registrada)
        String u3 = "\\u2605 " + nombre;  // ★ Pepe  (estrella)
        String u4 = "\\u2661 " + nombre;  // ♡ Pepe  (corazon)

        --- TEXT BLOCKS (Java 15+) ---

        Permiten escribir Strings multi-linea de forma sencilla.
        Se abren y cierran con triple comilla doble: \"\"\"

        La linea de apertura/cierre NO debe tener contenido.

        String texto = \"\"\"
                       Linea 1
                       Linea 2
                       Linea 3
                       \"\"\";
        // String con 3 lineas (cada una termina con \\n)

        String texto2 = \"\"\"\\  (OK escribirlo asi)
                       Linea 1

                       Linea 2
                       \"\"\";
        // String con 3 lineas + 1 linea en blanco \\n

        --- EJERCICIO PLANTEADO (sin resolver en video) ---

        String a = "hola";
        String b = new String("Mundo");

        System.out.print(a);
        System.out.print('\\r');
        System.out.print(b);
        // Que imprime?

        System.out.println();
        System.out.print(b + "\\b\\b" + a);
        // Que imprime?

        System.out.println();
        System.out.print("\\t\\t" + a + " \\n" + b);
        // Que imprime?

        ================================================================
          CONCEPTOS CLAVE PARA EL EXAMEN
        ================================================================

        * \\n  -> salta a la siguiente linea
        * \\t  -> tabulacion horizontal
        * \\b  -> retrocede un caracter (cursor hacia atras)
        * \\r  -> vuelve al inicio de la linea (machaca lo escrito)
        * \\"  -> permite escribir comillas dobles dentro de la String
        * \\\\  -> permite escribir una barra invertida literal
        * \\uXXXX -> caracter Unicode por codigo hexadecimal
        * Text blocks (\"\"\") para Strings multi-linea (Java 15+)
        * Las secuencias se interpretan en tiempo de compilacion
        * String tambien se puede crear con new String("texto")
        * En System.out.print() (sin ln) no hay salto de linea al final
        ================================================================
        """;

    public static void main(String[] args) {
        // --- VARIABLES BASE ---
        String nombre = "Pepe";
        String apellidos = "Martinez Garcia";

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

        // --- EJEMPLOS BASICOS ---
        System.out.println("============================================");
        System.out.println("   EJEMPLOS DEL VIDEO");
        System.out.println("============================================");
        System.out.println();

        // Ejemplo: concatenacion basica
        String nombreCompleto1 = nombre + " " + apellidos;
        System.out.println("1. nombre + \" \" + apellidos:");
        System.out.println("   >" + nombreCompleto1 + "<");
        System.out.println();

        // Ejemplo: comillas dobles dentro de String
        String nombreCompleto2 = "\"" + nombre + apellidos + "\"";
        System.out.println("2. \"\\\"\" + nombre + apellidos + \"\\\"\":");
        System.out.println("   >" + nombreCompleto2 + "<");
        System.out.println();

        String nombreCompleto3 = "\"" + nombre + " " + apellidos + "\"";
        System.out.println("3. \"\\\"\" + nombre + \" \" + apellidos + \"\\\"\":");
        System.out.println("   >" + nombreCompleto3 + "<");
        System.out.println();

        // Ejemplo: backspace \\b
        String nombre2 = nombre + "\b" + nombre;
        System.out.println("4. nombre + \"\\\\b\" + nombre:");
        System.out.println("   >" + nombre2 + "<  (la 2a 'e' de Pepe se machaca)");
        System.out.println();

        // Ejemplo: carriage return \\r
        String apellidos2 = apellidos + "\r," + nombre;
        System.out.println("5. apellidos + \"\\\\r,\" + nombre:");
        System.out.println("   >" + apellidos2 + "<  (vuelve al inicio y escribe \",Pepe\")");
        System.out.println();

        // Ejemplo: backspace + coma
        String apellidos3 = apellidos + "\b," + nombre;
        System.out.println("6. apellidos + \"\\\\b,\" + nombre:");
        System.out.println("   >" + apellidos3 + "<  (retrocede y pone \",Pepe\")");
        System.out.println();

        // Ejemplo: barra invertida literal
        String apellidos4 = apellidos + "\\," + nombre;
        System.out.println("7. apellidos + \"\\\\\\\\,\" + nombre:");
        System.out.println("   >" + apellidos4 + "<  (\\\\ se convierte en \\ literal)");
        System.out.println();

        // --- CARACTERES UNICODE ---
        System.out.println("============================================");
        System.out.println("   CARACTERES UNICODE CON \\\\uXXXX");
        System.out.println("============================================");
        System.out.println();

        String u1 = "\u00A9 " + nombre;   // © copyright
        String u2 = "\u00AE " + nombre;   // ® marca registrada
        String u3 = "\u2605 " + nombre;   // ★ estrella
        String u4 = "\u2661 " + nombre;   // ♡ corazon

        System.out.println("   \\u00A9 (copyright): " + u1);
        System.out.println("   \\u00AE (marca reg.): " + u2);
        System.out.println("   \\u2605 (estrella):   " + u3);
        System.out.println("   \\u2661 (corazon):    " + u4);
        System.out.println();

        // --- TEXT BLOCK (Java 15+) ---
        System.out.println("============================================");
        System.out.println("   TEXT BLOCK (triple comilla \"\"\" )");
        System.out.println("============================================");
        System.out.println();

        String texto = """
                       Linea 1 de texto
                       Linea 2 de texto
                       Linea 3 de texto
                       """;
        System.out.println("Text block con 3 lineas:");
        System.out.println("---inicio---");
        System.out.print(texto);
        System.out.println("---fin---");
        System.out.println();

        String textoConBlanco = """
                       Linea 1

                       Linea 2 con espacio arriba
                       """;
        System.out.println("Text block con linea en blanco:");
        System.out.println("---inicio---");
        System.out.print(textoConBlanco);
        System.out.println("---fin---");
        System.out.println();

        // --- EJEMPLO PRACTICO (codigo del video en VSCode) ---
        System.out.println("============================================");
        System.out.println("   EJEMPLO PRACTICO (como en el video)");
        System.out.println("============================================");
        System.out.println();

        String texto1 = "\n\nEsto es una String\ttabulada\n\n";
        System.out.println("texto1 = \"\\\\n\\\\nEsto es una String\\\\ttabulada\\\\n\\\\n\":");
        System.out.println("---inicio---");
        System.out.print(texto1);
        System.out.println("---fin---");
        System.out.println();

        String texto2 = "\n\n\u2605 Frase con estrella\n\u2605 Otra con estrella\n";
        System.out.println("texto2 con estrella Unicode \\\\u2605:");
        System.out.println("---inicio---");
        System.out.print(texto2);
        System.out.println("---fin---");
        System.out.println();

        // Usando char Unicode
        char letraUnicode = '\u2661'; // corazon
        String texto3 = "\n\n" + letraUnicode + " Corazon con char\n" + letraUnicode + " Otro corazon\n";
        System.out.println("texto3 con char Unicode (corazon \\\\u2661):");
        System.out.println("---inicio---");
        System.out.print(texto3);
        System.out.println("---fin---");
        System.out.println();

        // Cambiamos a flecha
        letraUnicode = '\u27A0'; // flecha
        String texto4 = "\n\n" + letraUnicode + " Flecha con char\n" + letraUnicode + " Otra flecha\n";
        System.out.println("texto4 con char Unicode (flecha \\\\u27A0):");
        System.out.println("---inicio---");
        System.out.print(texto4);
        System.out.println("---fin---");
        System.out.println();

        // --- EJERCICIO DEL VIDEO (propuesto) ---
        System.out.println("============================================");
        System.out.println("   EJERCICIO PROPUESTO EN EL VIDEO");
        System.out.println("============================================");
        System.out.println();

        String a = "hola";
        String b = new String("Mundo");

        System.out.println("String a = \"hola\";");
        System.out.println("String b = new String(\"Mundo\");");
        System.out.println();

        System.out.print("System.out.print(a); + '\\\\r' + System.out.print(b);");
        System.out.println();
        System.out.print("  Resultado: >");
        System.out.print(a);
        System.out.print('\r');
        System.out.print(b);
        System.out.println("<");
        System.out.println("  (explicacion: imprime \"hola\", \\r vuelve al inicio,");
        System.out.println("   luego \"Mundo\" machaca -> \"Mundo\")");
        System.out.println();

        System.out.print("System.out.print(b + \"\\\\b\\\\b\" + a);");
        System.out.println();
        System.out.print("  Resultado: >");
        System.out.print(b + "\b\b" + a);
        System.out.println("<");
        System.out.println("  (explicacion: \"Mundo\", \\b\\b retrocede 2 posiciones,");
        System.out.println("   luego \"hola\" machaca \"nd\" -> \"Muhola\")");
        System.out.println();

        System.out.print("System.out.print(\"\\\\t\\\\t\" + a + \" \\\\n\" + b);");
        System.out.println();
        System.out.print("  Resultado: >");
        System.out.print("\t\t" + a + " \n" + b);
        System.out.println("<");
        System.out.println("  (explicacion: dos tabulaciones, \"hola \", salto de linea, \"Mundo\")");
        System.out.println();

        System.out.println();
        mostrarInformacion();
    }

    public static void mostrarInformacion() {
        System.out.println("============================================");
        System.out.println("   RESUMEN DEL VIDEO");
        System.out.println("============================================");
        System.out.println();
        System.out.println(RESUMEN);
    }
}
