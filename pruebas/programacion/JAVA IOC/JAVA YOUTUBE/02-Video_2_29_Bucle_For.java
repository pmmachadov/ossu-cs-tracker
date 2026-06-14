class Video_2_29_Bucle_For {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "2-29 JAVA: Bucle FOR [DAM - DAW]";
    public static final String URL = "https://www.youtube.com/watch?v=06SuspX0TG0&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=45";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ================================================================
    //   ╔══════════════════════════════════════════════════════════╗
    //   ║  RESUMEN PARA EXAMEN - BUCLE FOR EN JAVA               ║
    //   ║  (lo mas importante, ahorrate el video)                ║
    //   ╚══════════════════════════════════════════════════════════╝
    // ================================================================
    //
    //  SINTAXIS:
    //     for (inicializacion; condicion; modificacion) {
    //         // codigo que se repite
    //     }
    //
    //  ORDEN DE EJECUCION (MEMORIZAR):
    //     1. inicializacion  ─── se ejecuta UNA SOLA VEZ
    //     2. condicion       ─── si true -> entra, si false -> SALTA
    //     3. cuerpo          ─── el codigo entre llaves
    //     4. modificacion    ─── suele ser i++ / i-- / i+=2
    //     5. VUELVE al paso 2
    //
    //  ╔══════════════════════════════════════════════════════════╗
    //  ║  TABLA RAPIDA: CANTIDAD DE ITERACIONES                  ║
    //  ╠══════════════════════════════════════════════════════════╣
    //  ║  for(i=0; i<10; i++)   -> 0..9   -> 10 iteraciones     ║
    //  ║  for(i=1; i<=10; i++)  -> 1..10  -> 10 iteraciones     ║
    //  ║  for(i=0; i<=10; i++)  -> 0..10  -> 11 iteraciones     ║
    //  ║  for(i=1; i<10; i++)   -> 1..9   ->  9 iteraciones     ║
    //  ╚══════════════════════════════════════════════════════════╝
    //
    //  REGLA DE ORO:
    //     - i < N   da N iteraciones  (i=0..N-1)
    //     - i <= N  da N+1 iteraciones (i=0..N)
    //     - El bucle termina CUANDO LA CONDICION ES FALSE
    //
    //  EQUIVALENCIA FOR <-> WHILE:
    //     for (int i=0; i<10; i++) { ... }
    //     es lo mismo que:
    //         int i=0;
    //         while (i<10) { ...; i++; }
    //
    //  SCOPE (ambito):
    //     La variable declarada en el for SOLO existe dentro
    //     de sus llaves. Fuera NO se puede usar.
    //
    //  SIN LLAVES:
    //     Si el for tiene UNA SOLA instruccion, se pueden
    //     omitir las llaves (igual que con if).
    //
    //  MULTIPLES EXPRESIONES con ",":
    //     for (int j=1, i=5; i>j; j+=2, i++) { }
    //       - inicio: j=1, i=5  (dos variables)
    //       - modif:  j+=2, i++ ( dos expresiones)
    //
    //  ╔══════════════════════════════════════════════════════════╗
    //  ║  TRUCOS PARA EL EXAMEN                                  ║
    //  ╠══════════════════════════════════════════════════════════╣
    //  ║  - La inicializacion SOLO se ejecuta UNA vez           ║
    //  ║  - La condicion se evalua CADA VEZ (antes de entrar)   ║
    //  ║  - La modificacion se ejecuta al FINAL de cada vuelta  ║
    //  ║  - Si pones i++ en vez de ++i da igual (ambos suman 1) ║
    //  ║  - Cuidado: las instrucciones DENTRO pueden cambiar    ║
    //  ║    la variable del for y alterar las iteraciones       ║
    //  ╚══════════════════════════════════════════════════════════╝
    // ================================================================

    public static final String RESUMEN =
        """
        ================================================================
          2-29 BUCLE FOR EN JAVA
        ================================================================

        SINTAXIS:
            for (inicializacion; condicion; modificacion) {
                // cuerpo del bucle
            }

        ORDEN DE EJECUCION (MEMORIZAR para examen):
            1. inicializacion - se ejecuta UNA SOLA VEZ
            2. condicion      - si true -> entra, si false -> SALTA
            3. cuerpo         - el codigo entre llaves
            4. modificacion   - normalmente i++ / i-- / i+=2
            5. VUELVE al paso 2

        TABLA RAPIDA DE ITERACIONES:
            for(i=0; i<10; i++)   -> 0..9   -> 10 iteraciones
            for(i=1; i<=10; i++)  -> 1..10  -> 10 iteraciones
            for(i=0; i<=10; i++)  -> 0..10  -> 11 iteraciones
            for(i=1; i<10; i++)   -> 1..9   ->  9 iteraciones

        REGLA DE ORO:
            - i < N   da N iteraciones  (valores i=0..N-1)
            - i <= N  da N+1 iteraciones (valores i=0..N)
            - El bucle termina CUANDO LA CONDICION ES FALSE

        SCOPE (ambito):
            La variable declarada en el for SOLO existe dentro
            de sus llaves. Fuera NO se puede usar.

        SIN LLAVES:
            Si el for tiene UNA SOLA instruccion, se pueden
            omitir las llaves (igual que con if).

        MULTIPLES EXPRESIONES CON COMA:
            for (int j = 1, i = 1; j <= 4; j++) { }
            for (int j = 1; j <= 10; j++, j += 2) { }
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
        // RESUMEN RAPIDO PARA EXAMEN (se imprime al ejecutar)
        // ============================================================

        separador("RESUMEN PARA EXAMEN (CHULETA)");
        System.out.println();
        System.out.println("SINTAXIS:");
        System.out.println("  for (inicializacion; condicion; modificacion) {");
        System.out.println("      // cuerpo");
        System.out.println("  }");
        System.out.println();
        System.out.println("ORDEN DE EJECUCION (MEMORIZAR):");
        System.out.println("  1. inicializacion  --- una sola vez");
        System.out.println("  2. condicion       --- si true->entra, false->SALTA");
        System.out.println("  3. cuerpo");
        System.out.println("  4. modificacion");
        System.out.println("  5. VUELVE al paso 2");
        System.out.println();
        System.out.println("TABLA RAPIDA DE ITERACIONES:");
        System.out.println("  for(i=0; i<10; i++)   -> 0..9   -> 10 iteraciones");
        System.out.println("  for(i=1; i<=10; i++)  -> 1..10  -> 10 iteraciones");
        System.out.println("  for(i=0; i<=10; i++)  -> 0..10  -> 11 iteraciones");
        System.out.println("  for(i=1; i<10; i++)   -> 1..9   ->  9 iteraciones");
        System.out.println();
        System.out.println("REGLA: i < N   -> N iteraciones (0 a N-1)");
        System.out.println("       i <= N  -> N+1 iteraciones (0 a N)");
        System.out.println("       El bucle termina CUANDO CONDICION ES FALSE");
        System.out.println();
        System.out.println("SCOPE: variable del for solo existe dentro de sus { }");
        System.out.println();
        System.out.println("SIN LLAVES: si solo hay 1 instruccion, se pueden omitir");
        System.out.println();
        System.out.println("MULTIPLES EXPRESIONES con \",\":");
        System.out.println("  for (int j=1, i=5; i>j; j+=2, i++) { }");
        System.out.println();

        // ============================================================
        // EJEMPLO 1: For (J=10; J>0; J-=2) con J+=1 dentro
        //   Explicacion paso a paso del video:
        //   - J=10, J+=1 -> J=11, imprime 11, J-=2 -> J=9
        //   - J=9,  J+=1 -> J=10, imprime 10, J-=2 -> J=8
        //   - J=8,  J+=1 -> J=9,  imprime 9,  J-=2 -> J=7
        //   ... hasta J=2, J+=1 -> J=3, imprime 3, J-=2 -> J=1
        //   - J=1,  J+=1 -> J=2,  imprime 2,  J-=2 -> J=0 -> sale
        // ============================================================

        separador("EJEMPLO 1: for (int J=10; J>0; J-=2) con J+=1 dentro");
        System.out.println("Salida esperada: 11 10 9 8 7 6 5 4 3 2");

        System.out.print("Salida real:     ");
        for (int J = 10; J > 0; J -= 2) {
            J += 1;
            System.out.print(J + " ");
        }
        System.out.println();
        System.out.println("Explicacion: el J+=1 de dentro se ejecuta ANTES de imprimir,");
        System.out.println("luego J-=2 de la cabecera. Por eso empieza en 11 y acaba en 2.");
        System.out.println();

        // ============================================================
        // EJEMPLO 2: for (J = 0; J < 3; J++)
        //   Ejemplo paso a paso del video:
        //   Paso 1: J=0 (inicializacion, una sola vez)
        //   Paso 2: J<3? 0<3 true -> entra
        //   Paso 3: print(J) -> 0
        //   Paso 4: J++ -> J=1
        //   Paso 5: J<3? 1<3 true -> entra
        //   Paso 3: print(J) -> 1
        //   Paso 4: J++ -> J=2
        //   Paso 5: J<3? 2<3 true -> entra
        //   Paso 3: print(J) -> 2
        //   Paso 4: J++ -> J=3
        //   Paso 5: J<3? 3<3 false -> TERMINA
        // ============================================================

        separador("EJEMPLO 2: for (J = 0; J < 3; J++)");
        System.out.println("Salida esperada: 0 1 2");
        System.out.print("Salida real:     ");
        for (int J = 0; J < 3; J++) {
            System.out.print(J + " ");
        }
        System.out.println("  (3 iteraciones: J=0, J=1, J=2)");
        System.out.println();

        // ============================================================
        // EJEMPLO 3: for (J = 3; J >= 0; J--)
        //   J=3 -> J>=0 true -> print(3) -> J-- -> J=2
        //   J=2 -> J>=0 true -> print(2) -> J-- -> J=1
        //   J=1 -> J>=0 true -> print(1) -> J-- -> J=0
        //   J=0 -> J>=0 true -> print(0) -> J-- -> J=-1
        //   J=-1 -> J>=0 false -> TERMINA
        // ============================================================

        separador("EJEMPLO 3: for (J = 3; J >= 0; J--)");
        System.out.println("Salida esperada: 3 2 1 0");
        System.out.print("Salida real:     ");
        for (int J = 3; J >= 0; J--) {
            System.out.print(J + " ");
        }
        System.out.println("  (4 iteraciones: J=3, J=2, J=1, J=0)");
        System.out.println();

        // ============================================================
        // EJEMPLO 4: for (J = 10; J > 4; J -= 2)
        //   J=10 -> 10>4 true -> print(10) -> J-=2 -> J=8
        //   J=8  -> 8>4  true -> print(8)  -> J-=2 -> J=6
        //   J=6  -> 6>4  true -> print(6)  -> J-=2 -> J=4
        //   J=4  -> 4>4  false -> TERMINA (el 4 NO se imprime)
        // ============================================================

        separador("EJEMPLO 4: for (J = 10; J > 4; J -= 2)");
        System.out.println("Salida esperada: 10 8 6");
        System.out.print("Salida real:     ");
        for (int J = 10; J > 4; J -= 2) {
            System.out.print(J + " ");
        }
        System.out.println("  (3 iteraciones: J=10, J=8, J=6)");
        System.out.println();

        // ============================================================
        // EJEMPLO 5: for (i = 0; i < 10; i++)  -> 10 iteraciones
        //   Valores: 0,1,2,3,4,5,6,7,8,9
        // ============================================================

        separador("EJEMPLO 5: for (i = 0; i < 10; i++)  -- 10 ITERACIONES");
        System.out.println("Valores de i: del 0 al 9 (10 valores)");
        System.out.print("Salida: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        // ============================================================
        // EJEMPLO 6: for (i = 1; i <= 10; i++)  -> 10 iteraciones
        //   Valores: 1,2,3,4,5,6,7,8,9,10
        // ============================================================

        separador("EJEMPLO 6: for (i = 1; i <= 10; i++)  -- 10 ITERACIONES");
        System.out.println("Valores de i: del 1 al 10 (10 valores)");
        System.out.print("Salida: ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        // ============================================================
        // EJEMPLO 7: for (i = 0; i <= 10; i++)  -> 11 iteraciones
        //   Valores: 0,1,2,3,4,5,6,7,8,9,10
        //   Diferencia clave: <= incluye el 10
        // ============================================================

        separador("EJEMPLO 7: for (i = 0; i <= 10; i++)  -- 11 ITERACIONES");
        System.out.println("Valores de i: del 0 al 10 (11 valores)");
        System.out.print("Salida: ");
        for (int i = 0; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        // ============================================================
        // EJEMPLO 8: for (i = 1; i < 10; i++)  -> 9 iteraciones
        //   Valores: 1,2,3,4,5,6,7,8,9
        // ============================================================

        separador("EJEMPLO 8: for (i = 1; i < 10; i++)  -- 9 ITERACIONES");
        System.out.println("Valores de i: del 1 al 9 (9 valores)");
        System.out.print("Salida: ");
        for (int i = 1; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        // ============================================================
        // EJEMPLO 9: for (J = 10; J > 0; J -= 2)
        //   SIN LLAVES (una sola instruccion, valido)
        //   Valores: 10,8,6,4,2
        // ============================================================

        separador("EJEMPLO 9: for (J = 10; J > 0; J -= 2)  -- una instruccion");
        System.out.println("Salida esperada: 10 8 6 4 2");
        System.out.print("Salida real:     ");
        for (int J = 10; J > 0; J -= 2)
            System.out.print(J + " ");   // <-- sin llaves, solo 1 instruccion
        System.out.println("  (sin llaves, una sola instruccion)");
        System.out.println();

        // ============================================================
        // EJEMPLO 10: for (J = 10; J >= 0; J -= 2)
        //   Igual que el 9 pero con >=, asi que imprime tambien el 0
        //   Valores: 10,8,6,4,2,0
        // ============================================================

        separador("EJEMPLO 10: for (J = 10; J >= 0; J -= 2)");
        System.out.println("Salida esperada: 10 8 6 4 2 0");
        System.out.print("Salida real:     ");
        for (int J = 10; J >= 0; J -= 2) {
            System.out.print(J + " ");
        }
        System.out.println("  (incluye el 0 por el >=)");
        System.out.println();

        // ============================================================
        // EJEMPLO 11: for (J = 1; 10 > J; J += 2)
        //   Incremento de 2 en 2, condicion 10 > J
        //   J=1 -> 10>1 true -> print(1) -> J+=2 -> J=3
        //   J=3 -> 10>3 true -> print(3) -> J+=2 -> J=5
        //   J=5 -> 10>5 true -> print(5) -> J+=2 -> J=7
        //   J=7 -> 10>7 true -> print(7) -> J+=2 -> J=9
        //   J=9 -> 10>9 true -> print(9) -> J+=2 -> J=11
        //   J=11 -> 10>11 false -> TERMINA
        // ============================================================

        separador("EJEMPLO 11: for (J = 1; 10 > J; J += 2)");
        System.out.println("Salida esperada: 1 3 5 7 9");
        System.out.print("Salida real:     ");
        for (int J = 1; 10 > J; J += 2) {
            System.out.print(J + " ");
        }
        System.out.println("  (incremento de 2 en 2)");
        System.out.println();

        // ============================================================
        // EJEMPLO 12: for (J = 0; J <= 10; J += 2)
        //   Numeros pares del 0 al 10 inclusive
        // ============================================================

        separador("EJEMPLO 12: for (J = 0; J <= 10; J += 2)");
        System.out.println("Salida esperada: 0 2 4 6 8 10");
        System.out.print("Salida real:     ");
        for (int J = 0; J <= 10; J += 2) {
            System.out.print(J + " ");
        }
        System.out.println("  (pares hasta 10 inclusive)");
        System.out.println();

        // ============================================================
        // EJEMPLO 13: Equivalencia FOR <-> WHILE
        //   Demostracion de que hacen exactamente lo mismo
        // ============================================================

        separador("EJEMPLO 13: EQUIVALENCIA FOR <-> WHILE");

        System.out.print("Con FOR:    ");
        for (int J = 10; J > 0; J -= 2) {
            System.out.print(J + " ");
        }

        System.out.println();
        System.out.print("Con WHILE:  ");
        int J = 10;
        while (J > 0) {
            System.out.print(J + " ");
            J -= 2;
        }
        System.out.println();
        System.out.println("  (ambos dan el mismo resultado)");
        System.out.println();

        // ============================================================
        // EJEMPLO 14: Multiples variables en inicio (con coma)
        //   for (int j = 1, i = 1; j <= 4; j++)
        //   i siempre vale 1 (no se modifica)
        //   j=1 -> 1+1=2 | j=2 -> 2+1=3 | j=3 -> 3+1=4 | j=4 -> 4+1=5
        // ============================================================

        separador("EJEMPLO 14: DOS VARIABLES EN INICIALIZACION");
        System.out.println("for (int j = 1, i = 1; j <= 4; j++)  -> j + i (i=1 fijo)");
        System.out.print("Salida: ");
        for (int j = 1, i = 1; j <= 4; j++) {
            System.out.print((j + i) + " ");
        }
        System.out.println("  (j=1..4, i siempre 1)");
        System.out.println();

        // ============================================================
        // EJEMPLO 15: Multiples expresiones en modificacion (con coma)
        //   for (int j = 1; j <= 10; j++, j += 2)
        //   j++ y luego j+=2 => incremento total de 3 cada vez
        //   j=1 -> 1<=10 -> print(1) -> j=2 (j++), j=4 (j+=2)
        //   j=4 -> 4<=10 -> print(4) -> j=5, j=7
        //   j=7 -> 7<=10 -> print(7) -> j=8, j=10
        //   j=10 -> 10<=10 -> print(10) -> j=11, j=13
        //   j=13 -> 13<=10 false -> TERMINA
        // ============================================================

        separador("EJEMPLO 15: DOS EXPRESIONES EN MODIFICACION");
        System.out.println("for (int j = 1; j <= 10; j++, j += 2)  -> incrementa 3 cada vez");
        System.out.print("Salida: ");
        for (int j = 1; j <= 10; j++, j += 2) {
            System.out.print(j + " ");
        }
        System.out.println("  (j=1,4,7,10)");
        System.out.println();

        // ============================================================
        // EJEMPLO 16: Multiples en inicio y en modificacion
        //   for (int j = 1, i = 5; i > j; j += 2, i++)
        //   j=1,i=5: 5>1 true -> print(1) -> j=3,i=6
        //   j=3,i=6: 6>3 true -> print(3) -> j=5,i=7
        //   j=5,i=7: 7>5 true -> print(5) -> j=7,i=8
        //   j=7,i=8: 8>7 true -> print(7) -> j=9,i=9
        //   j=9,i=9: 9>9 false -> TERMINA
        // ============================================================

        separador("EJEMPLO 16: VARIAS EN INICIO Y EN MODIFICACION");
        System.out.println("for (int j = 1, i = 5; i > j; j += 2, i++)");
        System.out.print("Salida: ");
        for (int j = 1, i = 5; i > j; j += 2, i++) {
            System.out.print(j + " ");
        }
        System.out.println("  (j=1,3,5,7)");
        System.out.println();

        // ============================================================
        // EJEMPLO 17: Scope de variable
        //   La variable declarada en el for NO existe fuera
        // ============================================================

        separador("EJEMPLO 17: SCOPE DE LA VARIABLE DEL FOR");
        System.out.println("La variable 'k' declarada en el for SOLO existe");
        System.out.println("dentro de sus llaves. Fuera no es visible.");
        System.out.println();
        for (int k = 0; k < 3; k++) {
            System.out.println("  Dentro del for: k = " + k);
        }
        // System.out.println(k);  // <-- ERROR: k no existe aqui
        System.out.println("  Fuera del for:  k ya no existe (scope perdido)");
        System.out.println();

        // ============================================================
        // COMPARACION FINAL DE TODOS LOS EJEMPLOS
        // ============================================================

        separador("COMPARACION DE RESULTADOS (TODOS LOS EJEMPLOS)");

        System.out.println("Ejemplo 1:  for(J=10; J>0; J-=2) con J+=1 dentro  -> 11 10 9 8 7 6 5 4 3 2");
        System.out.println("Ejemplo 2:  for(J=0;  J<3;  J++)                 -> 0 1 2");
        System.out.println("Ejemplo 3:  for(J=3;  J>=0; J--)                 -> 3 2 1 0");
        System.out.println("Ejemplo 4:  for(J=10; J>4;  J-=2)               -> 10 8 6");
        System.out.println("Ejemplo 5:  for(i=0;  i<10; i++)                 -> 0..9      (10 iteraciones)");
        System.out.println("Ejemplo 6:  for(i=1;  i<=10;i++)                 -> 1..10     (10 iteraciones)");
        System.out.println("Ejemplo 7:  for(i=0;  i<=10;i++)                 -> 0..10     (11 iteraciones)");
        System.out.println("Ejemplo 8:  for(i=1;  i<10; i++)                 -> 1..9      (9 iteraciones)");
        System.out.println("Ejemplo 9:  for(J=10; J>0;  J-=2) 1 instr       -> 10 8 6 4 2");
        System.out.println("Ejemplo 10: for(J=10; J>=0; J-=2)               -> 10 8 6 4 2 0");
        System.out.println("Ejemplo 11: for(J=1;  10>J; J+=2)               -> 1 3 5 7 9");
        System.out.println("Ejemplo 12: for(J=0;  J<=10;J+=2)               -> 0 2 4 6 8 10");
        System.out.println("Ejemplo 13: Equivalencia for <-> while           -> mismo resultado");
        System.out.println("Ejemplo 14: for(j=1,i=1; j<=4; j++)             -> 2 3 4 5");
        System.out.println("Ejemplo 15: for(j=1; j<=10; j++,j+=2)           -> 1 4 7 10");
        System.out.println("Ejemplo 16: for(j=1,i=5; i>j; j+=2,i++)         -> 1 3 5 7");
        System.out.println("Ejemplo 17: Scope de variable del for           -> solo existe dentro");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Ejercicios de bucle FOR en VS Code");
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
