class Video_2_24_Condiciones_If_Else {

    // ──────────────────────────────────────────────────────────────
    // Datos del video y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "2-24 JAVA: Condiciones if - else ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=lqUz-UQMuiI&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=40";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────

    public static final String RESUMEN =
        """
        ================================================================
          2-24 CONDICIONES IF - ELSE EN JAVA
        ================================================================

        Las estructuras de control alternativas (if/else) evaluan una
        condicion y, dependiendo del resultado (true o false), ejecutan
        unas instrucciones u otras.

        --- CONDICION ---

        La condicion debe ser una expresion de tipo logico que devuelva
        un valor booleano (true o false). En Java, obligatoriamente debe
        devolver un boolean.

        --- ESTRUCTURA SIMPLE (if) ---

            if (condicion) {
                // instrucciones si se cumple
            }

        - Si la condicion es true, se ejecuta el bloque entre llaves.
        - Si es false, se salta ese bloque.
        - Las instrucciones al mismo nivel que el if se ejecutan siempre.

        Ejemplo:
            if (x == 3) {
                System.out.print("x es 3");
                x = 2;
            }
            System.out.println(x);   // Se ejecuta siempre

        --- ESTRUCTURA DOBLE (if-else) ---

            if (condicion) {
                // instrucciones si se cumple
            } else {
                // instrucciones si NO se cumple
            }

        - Si condicion es true -> se ejecuta el bloque del if.
        - Si condicion es false -> se ejecuta el bloque del else.
        - Es obligatorio que se ejecute UNO de los dos bloques.

        Ejemplo:
            if (x == 3) {
                System.out.print("El valor es correcto");
                resultado = 5;
            } else {
                System.out.print("El valor es incorrecto");
                resultado = 27;
            }

        --- ESTRUCTURA ANIDADA ---

        Se pueden anidar tantos if-else como sea necesario, aunque no es
        recomendable tener muchos niveles porque dificulta la lectura.

            if (condicion1) {
                // instrucciones
            } else {
                if (condicion2) {
                    // instrucciones
                } else {
                    // instrucciones
                }
            }

        --- OPCIONALIDAD DE LLAVES ---

        Las llaves {} son OBLIGATORIAS cuando hay MAS DE UNA instruccion.
        Si solo hay UNA instruccion, las llaves se pueden omitir.

        Ejemplo valido (1 instruccion, sin llaves):
            if (x == 3)
                System.out.println("El valor es correcto");

        Ejemplo INVALIDO (2 instrucciones, sin llaves):
            if (x == 3)
                System.out.print("El valor es correcto");
                resultado = 5;   // Esta fuera del if, se ejecuta siempre!

        Esto es porque sin llaves, solo la primera instruccion pertenece al if.
        La segunda instruccion (resultado = 5) esta fuera y se ejecuta siempre.

        --- ERROR COMUN: INSTRUCCION ENTRE IF Y ELSE ---

        Si ponemos una instruccion entre el if y el else sin estar dentro
        de ningun bloque, Java da ERROR de compilacion.

        Ejemplo INCORRECTO (da error):
            if (x == 0)
                x = 2;
                y = 2;          // Esta fuera del if
            else                // ERROR: else sin if correspondiente
                y = 4;

        --- CONCATENAR IF-ELSE (ELSE IF) ---

        Se pueden encadenar condiciones sin anidar profundamente:

            if (a == 1)
                System.out.println("El valor es 1");
            else if (a == 2)
                System.out.println("El valor es 2");
            else if (a == 3)
                System.out.println("El valor es 3");
            else
                System.out.println("El valor es mayor que 3");

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * if(condicion) debe devolver boolean obligatoriamente
        * Las llaves {} son obligatorias si hay mas de 1 instruccion
        * else es opcional, solo si queremos bloque alternativo
        * Sin llaves, solo la primera instruccion pertenece al if/else
        * No puede haber instrucciones sueltas entre if y else
        * Se pueden anidar if-else (aunque no es recomendable abusar)
        * else if permite encadenar condiciones sin anidamiento profundo
        * Las instrucciones al mismo nivel que if se ejecutan siempre
        * Si hay un else, se ejecuta OBLIGATORIAMENTE if O else (no ambos)
        ================================================================
        """;

    // ──────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        mostrarInformacion();

        // ── Ejemplos del video ──
        System.out.println();
        System.out.println("============================================");
        System.out.println("   EJEMPLOS PRACTICOS - IF / ELSE");
        System.out.println("============================================");
        System.out.println();

        // ──────────────────────────────────────────────────────────
        // Ejemplo 1: If simple con 2 instrucciones (con llaves)
        // ──────────────────────────────────────────────────────────
        System.out.println("--- Ejemplo 1: If simple (con llaves) ---");
        int x = 3;
        System.out.println("x = " + x);

        if (x == 3) {
            System.out.print("x es ");    // Se ejecuta (x == 3)
            x = 2;                         // Cambia x a 2
        }
        System.out.println(x);             // Se ejecuta siempre -> 2
        System.out.println("Salida: x es 2");
        System.out.println();

        // ──────────────────────────────────────────────────────────
        // Ejemplo 2: If simple (sin llaves, 1 instruccion)
        // ──────────────────────────────────────────────────────────
        System.out.println("--- Ejemplo 2: If simple (sin llaves) ---");
        x = 3;
        if (x == 3)
            System.out.println("El valor es correcto");  // Solo esta esta dentro del if
        System.out.println();

        // ──────────────────────────────────────────────────────────
        // Ejemplo 3: If-else doble
        // ──────────────────────────────────────────────────────────
        System.out.println("--- Ejemplo 3: If-else ---");
        x = 5;
        System.out.println("x = " + x);
        int resultado;

        if (x == 3) {
            System.out.println("El valor es correcto");
            resultado = 5;
        } else {
            System.out.println("El valor es incorrecto");
            resultado = 27;
        }
        System.out.println("Resultado = " + resultado);
        System.out.println();

        // ──────────────────────────────────────────────────────────
        // Ejemplo 4: If-else con 1 instruccion cada uno
        // ──────────────────────────────────────────────────────────
        System.out.println("--- Ejemplo 4: If-else 1 instruccion (sin llaves) ---");
        x = 3;
        if (x == 3)
            System.out.println("x es 3, correcto");
        else
            System.out.println("x no es 3, incorrecto");
        System.out.println();

        // ──────────────────────────────────────────────────────────
        // Ejemplo 5: Estructura anidada
        // ──────────────────────────────────────────────────────────
        System.out.println("--- Ejemplo 5: If-else anidado ---");
        x = 2;
        int y = 1;

        if (x == 0) {
            x = 2;
            y = 2;
        } else {
            if (x == 2) {
                x = 3;
                y = 3;
            } else {
                x = 4;
                y = 4;
            }
        }
        System.out.println("x = " + x + ", y = " + y);  // x=3, y=3
        System.out.println();

        // ──────────────────────────────────────────────────────────
        // Ejemplo 6: Else if encadenado
        // ──────────────────────────────────────────────────────────
        System.out.println("--- Ejemplo 6: Else if encadenado ---");
        int a = 2;
        System.out.println("a = " + a);

        if (a == 1)
            System.out.println("El valor es 1");
        else if (a == 2)
            System.out.println("El valor es 2");
        else if (a == 3)
            System.out.println("El valor es 3");
        else
            System.out.println("El valor es mayor que 3");
        System.out.println();

        // ──────────────────────────────────────────────────────────
        // Ejemplo 7: Peligro de omitir llaves con 2 instrucciones
        // ──────────────────────────────────────────────────────────
        System.out.println("--- Ejemplo 7: Sin llaves con 2 instrucciones (ERROR LOGICO) ---");
        x = 20;
        resultado = 0;

        if (x == 3)
            System.out.println("El valor es correcto");   // Dentro del if
            resultado = 5;  // FUERA del if (no hay llaves) - se ejecuta SIEMPRE

        // resultado = 5 se ejecuto porque esta fuera, aunque x=20!
        System.out.println("x = " + x + ", resultado = " + resultado);
        System.out.println("(resultado deberia ser 0, pero es 5 porque la asignacion");
        System.out.println(" esta fuera del if al no haber llaves)");
        System.out.println();

        // ──────────────────────────────────────────────────────────
        // Ejemplo 8: Demostracion completa del video (ej izquierda - x es 32)
        // ──────────────────────────────────────────────────────────
        System.out.println("--- Ejemplo 8: Seguimiento x es 32 ---");
        x = 3;
        if (x == 3) {
            System.out.print("x es ");  // Imprime "x es " (sin salto)
            x = 2;                       // x pasa a 2
        } else {
            System.out.print("x no es 3 ");
            x = 1;
        }
        System.out.println(x);           // Imprime 2
        System.out.println("Salida esperada: x es 2");
        System.out.println();

        // ──────────────────────────────────────────────────────────
        // Ejemplo 9: Demostracion (ej derecha - x no es 31)
        // ──────────────────────────────────────────────────────────
        System.out.println("--- Ejemplo 9: Seguimiento x no es 31 ---");
        x = 5;
        if (x == 3) {
            System.out.print("x es ");
            x = 2;
        } else {
            System.out.print("x no es 3 ");  // Se ejecuta
            x = 1;                            // x pasa a 1
        }
        System.out.println(x);                // Imprime 1
        System.out.println("Salida esperada: x no es 3 1");
        System.out.println();

        // ──────────────────────────────────────────────────────────
        // Ejemplo 10: Ejercicio resuelto del video
        // ──────────────────────────────────────────────────────────
        System.out.println("--- Ejemplo 10: Ejercicio resuelto ---");
        x = 0;
        y = 1;

        // Primer bloque
        if (x == 0) {
            x = 2;
            y = 2;
        }
        System.out.println("Tras primer if: x = " + x + ", y = " + y);  // x=2, y=2

        // Segundo bloque (anidado)
        x = 0;
        y = 1;
        if (x == 1) {
            x = 2;
            y = 2;
        } else {
            if (x == 2) {
                x = 3;
                y = 3;
            } else {
                x = 4;
                y = 4;
            }
        }
        System.out.println("Tras if anidado: x = " + x + ", y = " + y);  // x=4, y=4
        System.out.println();

        // ──────────────────────────────────────────────────────────
        // Ejemplo 11: Sin llaves en if-else anidado
        // ──────────────────────────────────────────────────────────
        System.out.println("--- Ejemplo 11: Sin llaves en anidado (atencion) ---");
        x = 0;
        y = 1;

        if (x == 0)    // true -> entra
            x = 2;     // Solo esta instruccion pertenece al if
        else
            if (x == 2)
                y = 3;  // No se ejecuta (entramos al if de arriba)
            else
                y = 4;

        // x = 4 se ejecuta SIEMPRE porque esta al mismo nivel que el if
        x = 4;
        System.out.println("x = " + x + ", y = " + y);  // x=4, y=1
        System.out.println();

        System.out.println("============================================");
        System.out.println("   FIN DE EJEMPLOS");
        System.out.println("============================================");
    }

    // ──────────────────────────────────────────────────────────────

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
