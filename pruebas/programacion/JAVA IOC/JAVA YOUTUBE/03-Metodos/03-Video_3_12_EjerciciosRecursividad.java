class Video_3_12_EjerciciosRecursividad {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "3-12 JAVA: Ejercicios resueltos recursividad ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=2_BAUlOufLQ&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=65";
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
          RESUMEN RAPIDO - EJERCICIOS RECURSIVIDAD (TEMA 3 - V12)
        ====================================================================

        --- EJERCICIO 1: CONTAR DIGITOS ---
        int digitos(int n)  [n > 0]
        Caso base: n == 0 -> return 0
        Caso general: return 1 + digitos(n / 10)
        Logica: dividir entre 10 quita el ultimo digito.
        Ej: digitos(144) = 3

        --- EJERCICIO 2: POTENCIA ---
        int potencia(int base, int exp)  [exp >= 0]
        Caso base: exp == 0 -> return 1
        Caso general: return base * potencia(base, exp - 1)
        Ej: potencia(2, 4) = 16

        --- EJERCICIO 3: INVERTIR NUMERO ---
        void invertir(int n)  [imprime por pantalla]
        Caso base: n >= 0 && n < 10 -> System.out.println(n)
        Caso general:
          System.out.print(n % 10);   // Imprime ultimo digito
          invertir(n / 10);           // Quita ultimo digito
        Ej: invertir(145) -> imprime 541

        --- EJERCICIO 4: ES BINARIO ---
        boolean esBinario(int n)
        Caso base (1 digito):
          if (n == 0 || n == 1) return true
          else return false
        Caso general:
          if (n % 10 == 0 || n % 10 == 1)
              return esBinario(n / 10)  // Siguiente digito
          else
              return false
        Ej: esBinario(1011) = true, esBinario(123) = false

        --- EJERCICIO 5: CONVERTIR A BINARIO ---
        int convertirBinario(int n)
        Caso base: n == 0 || n == 1 -> return n
        Caso general: return (n % 2) + 10 * convertirBinario(n / 2)

        Version void (imprime):
        void imprimirBinario(int n)
          if (n > 1) imprimirBinario(n / 2);
          System.out.print(n % 2);

        Ej: convertirBinario(15) = 1111

        --- EJERCICIO 6: PALABRA ORDENADA ALFABETICAMENTE ---
        boolean palabraOrdenada(String cad)
        (convierte a minusculas antes)
        Caso base: cad.length() <= 1 -> return true
        Caso general:
          if (cad.charAt(0) <= cad.charAt(1))
              return palabraOrdenada(cad.substring(1))
          else
              return false

        --- EJERCICIO 7: SUMA 1..N ---
        // Version decreciente (mas facil):
        void sumaDecreciente(int n, int total)
          if (n == 1)
              System.out.println("1 = " + (total + 1));
          else {
              System.out.print(n + " + ");
              sumaDecreciente(n - 1, total + n);
          }

        // Version creciente (como pide enunciado):
        void sumaCreciente(int cont, int n, int total)
          if (cont < n) {
              System.out.print(cont + " + ");
              sumaCreciente(cont + 1, n, total + cont);
          } else {
              System.out.println(cont + " = " + (total + cont));
          }

        Metodos auxiliares: mostrarSumaCreciente(n) y
        mostrarSumaDecreciente(n) llaman a los recursivos
        con parametros inicializados.

        Ej: suma 1+2+3+4 = 10

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
        // EJERCICIO 1: Contar digitos
        // ============================================================

        separador("EJERCICIO 1: Contar digitos");
        int num1 = 1224;
        int cantDigitos = digitos(num1);
        System.out.println("  El numero " + num1 + " tiene " + cantDigitos
            + (cantDigitos > 1 ? " digitos." : " digito."));
        System.out.println("  digitos(5)   = " + digitos(5));
        System.out.println("  digitos(14)  = " + digitos(14));
        System.out.println("  digitos(121) = " + digitos(121));
        System.out.println("  digitos(1224) = " + digitos(1224));
        System.out.println();

        // ============================================================
        // EJERCICIO 2: Potencia
        // ============================================================

        separador("EJERCICIO 2: Potencia");
        System.out.println("  potencia(2, 4) = " + potencia(2, 4) + "  (2^4 = 16)");
        System.out.println("  potencia(3, 0) = " + potencia(3, 0) + "  (3^0 = 1)");
        System.out.println("  potencia(5, 3) = " + potencia(5, 3) + "  (5^3 = 125)");
        System.out.println();

        // ============================================================
        // EJERCICIO 3: Invertir numero
        // ============================================================

        separador("EJERCICIO 3: Invertir numero");
        System.out.print("  invertir(145)  = ");
        invertir(145);
        System.out.print("  invertir(5421) = ");
        invertir(5421);
        System.out.print("  invertir(7)    = ");
        invertir(7);
        System.out.println();

        // ============================================================
        // EJERCICIO 4: Es binario
        // ============================================================

        separador("EJERCICIO 4: Comprobar si es binario");
        mostrarEsBinario(1011);
        mostrarEsBinario(123);
        mostrarEsBinario(0);
        mostrarEsBinario(111);
        mostrarEsBinario(102);
        System.out.println();

        // ============================================================
        // EJERCICIO 5: Convertir a binario
        // ============================================================

        separador("EJERCICIO 5: Convertir a binario");
        System.out.println("  convertirBinario(15) = " + convertirBinario(15) + "  (15 en binario es 1111)");
        System.out.println("  convertirBinario(8)  = " + convertirBinario(8) + "  (8 en binario es 1000)");
        System.out.println("  convertirBinario(4)  = " + convertirBinario(4) + "  (4 en binario es 100)");
        System.out.println("  convertirBinario(2)  = " + convertirBinario(2) + "  (2 en binario es 10)");
        System.out.print("  imprimirBinario(15)  = ");
        imprimirBinario(15);
        System.out.println();
        System.out.println();

        // ============================================================
        // EJERCICIO 6: Palabra ordenada alfabeticamente
        // ============================================================

        separador("EJERCICIO 6: Palabra ordenada alfabeticamente");
        mostrarPalabraOrdenada("abcde");
        mostrarPalabraOrdenada("abcdfe");
        mostrarPalabraOrdenada("ABcDeF");
        mostrarPalabraOrdenada("az");
        mostrarPalabraOrdenada("za");
        System.out.println();

        // ============================================================
        // EJERCICIO 7: Suma 1..n (creciente y decreciente)
        // ============================================================

        separador("EJERCICIO 7: Suma de 1 a n");
        System.out.println("  Suma decreciente (n=4):");
        System.out.print("    ");
        mostrarSumaDecreciente(4);
        System.out.println("  Suma creciente (n=4):");
        System.out.print("    ");
        mostrarSumaCreciente(4);
        System.out.println("  Suma decreciente (n=8):");
        System.out.print("    ");
        mostrarSumaDecreciente(8);
        System.out.println("  Suma creciente (n=8):");
        System.out.print("    ");
        mostrarSumaCreciente(8);

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Fin del TEMA 3 - MEGA Curso JAVA");
        System.out.println("============================================================");
    }

    // -------------------------------------------------------------
    // EJERCICIO 1: Contar digitos de un numero
    // -------------------------------------------------------------
    static int digitos(int n) {
        if (n == 0) {
            return 0;                   // Caso base
        } else {
            return 1 + digitos(n / 10); // Cuenta el digito y sigue
        }
    }

    // Metodo auxiliar para mostrar el resultado
    static void mostrarDigitos(int n) {
        int cant = digitos(n);
        System.out.println("  El numero " + n + " tiene " + cant
            + (cant > 1 ? " digitos." : " digito."));
    }

    // -------------------------------------------------------------
    // EJERCICIO 2: Potencia (base^exponente)
    // -------------------------------------------------------------
    static int potencia(int base, int exp) {
        if (exp == 0) {
            return 1;                   // Caso base: cualquier numero^0 = 1
        } else {
            return base * potencia(base, exp - 1);  // Caso general
        }
    }

    // -------------------------------------------------------------
    // EJERCICIO 3: Invertir numero (imprime por pantalla)
    // -------------------------------------------------------------
    static void invertir(int n) {
        if (n >= 0 && n < 10) {
            System.out.println(n);      // Caso base: un solo digito
        } else {
            System.out.print(n % 10);   // Imprime ultimo digito
            invertir(n / 10);           // Quita ultimo digito y sigue
        }
    }

    // -------------------------------------------------------------
    // EJERCICIO 4: Comprobar si un numero es binario
    // -------------------------------------------------------------
    static boolean esBinario(int n) {
        // Caso base: un solo digito
        if (n >= 0 && n < 10) {
            return (n == 0 || n == 1);
        }
        // Caso general: comprobar ultimo digito y seguir
        if (n % 10 == 0 || n % 10 == 1) {
            return esBinario(n / 10);
        } else {
            return false;
        }
    }

    static void mostrarEsBinario(int n) {
        System.out.println("  " + n + " es " + (esBinario(n) ? "" : "NO ") + "binario");
    }

    // -------------------------------------------------------------
    // EJERCICIO 5: Convertir a binario
    // -------------------------------------------------------------
    // Devuelve el numero binario como entero
    static int convertirBinario(int n) {
        if (n == 0 || n == 1) {
            return n;                   // Caso base
        } else {
            return (n % 2) + 10 * convertirBinario(n / 2);
        }
    }

    // Version void: imprime directamente el binario (mas simple)
    static void imprimirBinario(int n) {
        if (n > 1) {
            imprimirBinario(n / 2);
        }
        System.out.print(n % 2);
    }

    // Metodo auxiliar con formato
    static void mostrarBinario(int n) {
        System.out.print("  El numero " + n + " en binario es ");
        imprimirBinario(n);
        System.out.println(".");
    }

    // -------------------------------------------------------------
    // EJERCICIO 6: Palabra ordenada alfabeticamente
    // -------------------------------------------------------------
    static boolean palabraOrdenada(String cad) {
        cad = cad.toLowerCase();  // Ignorar mayusculas
        // Caso base: 0 o 1 letras -> ordenada
        if (cad.length() <= 1) {
            return true;
        }
        // Caso general: comparar primera con segunda
        if (cad.charAt(0) <= cad.charAt(1)) {
            return palabraOrdenada(cad.substring(1));
        } else {
            return false;
        }
    }

    static void mostrarPalabraOrdenada(String palabra) {
        System.out.println("  \"" + palabra + "\" "
            + (palabraOrdenada(palabra) ? "SI" : "NO")
            + " esta ordenada alfabeticamente");
    }

    // -------------------------------------------------------------
    // EJERCICIO 7: Suma 1..n
    // -------------------------------------------------------------

    // Version DECRECIENTE: n + (n-1) + ... + 1
    static void sumaDecreciente(int n, int total) {
        if (n == 1) {
            System.out.println("1 = " + (total + 1));
        } else {
            System.out.print(n + " + ");
            sumaDecreciente(n - 1, total + n);
        }
    }

    static void mostrarSumaDecreciente(int n) {
        sumaDecreciente(n, 0);
    }

    // Version CRECIENTE: 1 + 2 + ... + n
    static void sumaCreciente(int cont, int n, int total) {
        if (cont < n) {
            System.out.print(cont + " + ");
            sumaCreciente(cont + 1, n, total + cont);
        } else {
            System.out.println(cont + " = " + (total + cont));
        }
    }

    static void mostrarSumaCreciente(int n) {
        sumaCreciente(1, n, 0);
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

