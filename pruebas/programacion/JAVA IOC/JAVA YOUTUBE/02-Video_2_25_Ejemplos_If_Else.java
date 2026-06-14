class Video_2_25_Ejemplos_If_Else {

    // ──────────────────────────────────────────────────────────────
    // Datos del video y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "2-25 JAVA: Ejemplos if - else ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=ZXXvJ9reA0w&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=41";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────

    public static final String RESUMEN =
        """
        ================================================================
          2-25 EJEMPLOS IF - ELSE EN JAVA (VS Code)
        ================================================================

        Este video repasa las condiciones if/else del video anterior
        pero con ejemplos practicos dentro de Visual Studio Code.

        --- ESTRUCTURA BASICA ---

        Se declaran dos variables (x, y) y se usan condiciones:

            int x = 1, y = 2;

            if (x == 1) {
                System.out.println("x vale 1");
            } else {
                System.out.println("x no vale 1");
            }

        - Si la condicion es true -> se ejecuta el bloque del if.
        - Si es false -> se ejecuta el bloque del else.
        - Con if-else, OBLIGATORIAMENTE se ejecuta uno de los dos.

        --- ANIDAR CONDICIONES EN EL ELSE ---

        Dentro de un else se puede poner otro if-else:

            if (x == 1) {
                System.out.println("x vale 1");
            } else if (x == 2) {
                System.out.println("x vale 2");
            } else {
                System.out.println("x es mayor que 2");
            }

        Esto permite tener 3 o mas opciones posibles.

        --- OPCIONALIDAD DE LLAVES ---

        Se pueden quitar las llaves {} cuando el bloque tiene
        SOLO UNA instruccion (un solo punto y coma).

        En el ejemplo anterior, cada if/else tiene una sola
        instruccion, por lo que se puede simplificar:

            if (x == 1)
                System.out.println("x vale 1");
            else if (x == 2)
                System.out.println("x vale 2");
            else
                System.out.println("x es mayor que 2");

        Incluso se puede poner el else if en la misma linea.

        --- IFS INDEPENDIENTES AL MISMO NIVEL ---

        Varios if al mismo nivel se evaluan independientemente:

            if (x == 1) System.out.println("x vale 1");
            if (y == 2) System.out.println("y vale 2");

        - Si x=1 e y=2, se muestran los dos mensajes.
        - Si solo se cumple una condicion, solo esa se ejecuta.
        - Si no se cumple ninguna, no se muestra nada.

        --- IFS ANIDADOS (NO RECOMENDADO) ---

        En lugar de usar operadores logicos, se pueden anidar:

            if (x == 1) {
                if (y == 2) {
                    System.out.println("x=1, y=2");
                }
            }

        Esto solo se ejecuta si AMBAS condiciones son true.
        Es PREFERIBLE usar operadores logicos (&&):

            if (x == 1 && y == 2)
                System.out.println("x=1, y=2");

        --- USAR VARIABLES BOOLEANAS ---

        Se puede guardar una condicion en una variable boolean
        y usarla directamente en el if:

            boolean condicion = (x == 1 && y == 2);
            if (condicion)
                System.out.println("Se cumple la condicion");

        --- EXPRESIONES COMPLEJAS COMO CONDICION ---

        Dentro del if se pueden poner expresiones que devuelvan
        un boolean, no solo comparaciones simples:

        Ejemplo: comprobar suma
            if (x + y == 3)
                System.out.println("x + y = 3");

        --- INCREMENTO DENTRO DE LA CONDICION (ATENCION) ---

        Si se usa ++ dentro de la condicion, hay que tener cuidado:

            if (x + y++ == 3)  // Primero evalua x+y, luego incrementa y

        - x + y se evalua primero (con el valor actual de y).
        - Luego se incrementa y (post-incremento).
        - El resultado de la suma se compara con 3.

        Con pre-incremento:
            if (x + ++y == 3)  // Primero incrementa y, luego evalua x+y

        - Primero se incrementa y.
        - Luego se evalua x + y con el nuevo valor.

        --- CONCEPTOS CLAVE ---

        * If-else: se ejecuta OBLIGATORIAMENTE if o else
        * Sin llaves, solo la primera instruccion pertenece al if
        * Varios if al mismo nivel son independientes entre si
        * Preferir && para combinar condiciones en vez de anidar
        * Se puede guardar la condicion en una variable boolean
        * Cuidado con ++ dentro de la condicion del if
        * Todo lo que devuelva boolean vale como condicion
        ================================================================
        """;

    // ──────────────────────────────────────────────────────────────

    public static void main(String[] args) {
        mostrarInformacion();

        System.out.println();
        System.out.println("============================================");
        System.out.println("   EJEMPLOS PRACTICOS - IF / ELSE EN VS CODE");
        System.out.println("============================================");
        System.out.println();

        // ── Ejemplo 1: If simple ──
        System.out.println("--- Ejemplo 1: If simple ---");
        int x = 1, y = 2;
        if (x == 1) {
            System.out.println("x vale 1");
        }
        System.out.println("(x = " + x + ", y = " + y + ")");
        System.out.println();

        // ── Ejemplo 2: If con condicion falsa ──
        System.out.println("--- Ejemplo 2: If con condicion false (no muestra nada) ---");
        x = 1;
        if (x == 2) {
            System.out.println("x vale 2 (NO deberia verse)");
        }
        System.out.println("(No se ha mostrado nada porque x != 2)");
        System.out.println();

        // ── Ejemplo 3: If-else ──
        System.out.println("--- Ejemplo 3: If-else ---");
        x = 5;
        if (x == 1) {
            System.out.println("x vale 1");
        } else {
            System.out.println("x no vale 1");
        }
        System.out.println();

        // ── Ejemplo 4: If anidado en else (else if) ──
        System.out.println("--- Ejemplo 4: If-else anidado (tres opciones) ---");
        x = 2;
        if (x == 1) {
            System.out.println("x vale 1");
        } else if (x == 2) {
            System.out.println("x vale 2");
        } else {
            System.out.println("x es mayor que 2");
        }
        System.out.println();

        // ── Ejemplo 5: Sin llaves (1 instruccion) ──
        System.out.println("--- Ejemplo 5: Sin llaves (1 instruccion por bloque) ---");
        x = 3;
        if (x == 1)
            System.out.println("x vale 1");
        else if (x == 2)
            System.out.println("x vale 2");
        else
            System.out.println("x es mayor que 2");
        System.out.println();

        // ── Ejemplo 6: Else if en la misma linea ──
        System.out.println("--- Ejemplo 6: Else if en la misma linea ---");
        x = 1;
        if (x == 1)
            System.out.println("x vale 1");
        else if (x == 2)
            System.out.println("x vale 2");
        else
            System.out.println("x es mayor que 2");
        System.out.println();

        // ── Ejemplo 7: Ifs independientes al mismo nivel ──
        System.out.println("--- Ejemplo 7: Ifs independientes al mismo nivel ---");
        x = 1; y = 2;
        if (x == 1) System.out.println("x vale 1");
        if (y == 2) System.out.println("y vale 2");
        System.out.println("(Se muestran las dos porque ambas condiciones son true)");
        System.out.println();

        // ── Ejemplo 8: Ifs independientes (solo uno se cumple) ──
        System.out.println("--- Ejemplo 8: Ifs independientes (solo y se cumple) ---");
        x = 2; y = 2;
        if (x == 1) System.out.println("x vale 1");
        if (y == 2) System.out.println("y vale 2");
        System.out.println("(Solo se muestra 'y vale 2' porque x=2)");
        System.out.println();

        // ── Ejemplo 9: Ifs independientes (ninguno se cumple) ──
        System.out.println("--- Ejemplo 9: Ifs independientes (ninguno se cumple) ---");
        x = 3; y = 3;
        if (x == 1) System.out.println("x vale 1");
        if (y == 2) System.out.println("y vale 2");
        System.out.println("(No se muestra nada porque ninguna condicion es true)");
        System.out.println();

        // ── Ejemplo 10: Ifs anidados (NO recomendado) ──
        System.out.println("--- Ejemplo 10: Ifs anidados ---");
        x = 1; y = 2;
        if (x == 1) {
            if (y == 2) {
                System.out.println("x=1, y=2 (anidado)");
            }
        }
        System.out.println();

        // ── Ejemplo 11: If con operador && (recomendado) ──
        System.out.println("--- Ejemplo 11: If con && (mejor que anidar) ---");
        x = 1; y = 2;
        if (x == 1 && y == 2)
            System.out.println("x=1, y=2 (con &&)");
        System.out.println();

        // ── Ejemplo 12: If con variable boolean ──
        System.out.println("--- Ejemplo 12: If con variable boolean ---");
        x = 1; y = 2;
        boolean condicion = (x == 1 && y == 2);
        System.out.println("condicion = " + condicion);
        if (condicion)
            System.out.println("Se cumple la condicion");
        System.out.println();

        // ── Ejemplo 13: Expresion aritmetica como condicion ──
        System.out.println("--- Ejemplo 13: x + y == 3 como condicion ---");
        x = 1; y = 2;
        if (x + y == 3)
            System.out.println("x + y = 3 (se cumple)");
        System.out.println();

        // ── Ejemplo 14: Post-incremento dentro de condicion ──
        System.out.println("--- Ejemplo 14: Post-incremento (y++) dentro de condicion ---");
        x = 1; y = 2;
        if (x + y++ == 3) {
            System.out.println("x + y++ == 3 es TRUE");
        } else {
            System.out.println("x + y++ == 3 es FALSE");
        }
        System.out.println("Despues de evaluar: x = " + x + ", y = " + y);
        System.out.println("(y se incremento DESPUES de evaluar la suma)");
        System.out.println();

        // ── Ejemplo 15: Pre-incremento dentro de condicion ──
        System.out.println("--- Ejemplo 15: Pre-incremento (++y) dentro de condicion ---");
        x = 1; y = 2;
        if (x + ++y == 3) {
            System.out.println("x + ++y == 3 es TRUE");
        } else {
            System.out.println("x + ++y == 3 es FALSE");
        }
        System.out.println("Despues de evaluar: x = " + x + ", y = " + y);
        System.out.println("(y se incremento ANTES de evaluar la suma)");
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
