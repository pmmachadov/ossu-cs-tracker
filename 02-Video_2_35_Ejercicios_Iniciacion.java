class Video_2_35_Ejercicios_Iniciacion {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "2-35 JAVA: Ejercicios de iniciacion resueltos [DAM - DAW]";
    public static final String URL = "https://www.youtube.com/watch?v=IVIAZN561LU&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=51";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // METODO PRINCIPAL
    // -------------------------------------------------------------

    public static void main(String[] args) {

        java.util.Scanner entrada = new java.util.Scanner(System.in);

        separador("EJERCICIO 1: MAXIMO, MINIMO Y VECES");
        System.out.println("  Se lee una cantidad N, luego N numeros enteros.");
        System.out.println("  Se imprime el maximo, el minimo y las veces que aparece cada uno.");
        System.out.println("  Ejemplo: 5 -> 3, 3, 8, 1, 8 -> Min=1(1 vez), Max=8(2 veces)");
        System.out.println();

        separador("EJERCICIO 2: CONTAR DIGITOS");
        System.out.println("  Dado un entero positivo, determinar cuantos digitos tiene.");
        System.out.println("  SIN usar String. Ejemplo: 12345 -> 5 cifras");
        System.out.println();

        separador("EJERCICIO 3: SUMAR POSITIVOS HASTA 0");
        System.out.println("  Se piden enteros hasta introducir 0.");
        System.out.println("  Se muestra la suma de SOLO los positivos.");
        System.out.println("  Ejemplo: 3,4,5,6,-2,8,0 -> 3+4+5+6+8=26");
        System.out.println();

        separador("EJERCICIO 4: CIFRAS = SUMA DIGITOS");
        System.out.println("  Dada una secuencia acabada en 0, sumar los numeros");
        System.out.println("  donde: numero de cifras == suma de sus digitos.");
        System.out.println("  Ejemplo: 1,-111,5,111,66,201,27,0 -> 1+111+201=313");
        System.out.println();

        // ============================================================
        // EJERCICIO 1: Maximo, minimo y veces
        // ============================================================

        separador("SOLUCION EJERCICIO 1");
        System.out.println("  (Para probarlo con datos reales, descomentar el codigo en main)");
        System.out.println();

        // ============================================================
        // EJERCICIO 2: Contar digitos
        // ============================================================

        separador("SOLUCION EJERCICIO 2");
        probarContarDigitos(12343, entrada);
        probarContarDigitos(10, entrada);
        probarContarDigitos(3, entrada);

        // ============================================================
        // EJERCICIO 3: Sumar positivos hasta 0
        // ============================================================

        separador("SOLUCION EJERCICIO 3");
        System.out.println("  Demo con datos fijos: 3, 4, 5, 6, -2, 8, 0");
        System.out.print("  Resultado: ");
        System.out.println(sumarPositivosDemo());
        System.out.println();

        // ============================================================
        // EJERCICIO 4: Cifras = suma digitos
        // ============================================================

        separador("SOLUCION EJERCICIO 4");
        System.out.println("  Demo con datos fijos: 1, -111, 5, 111, 66, 201, 27, 0");
        System.out.print("  Resultado: ");
        System.out.println(cifrasIgualSumaDemo());
        System.out.println();

        separador("COMPARACION DE RESULTADOS");
        System.out.println("Ejercicio 1: Maximo, minimo y veces   -> ver codigo comentado");
        System.out.println("Ejercicio 2: Contar digitos           -> 12343=5, 10=2, 3=1");
        System.out.println("Ejercicio 3: Sumar positivos hasta 0  -> 3+4+5+6+8=26");
        System.out.println("Ejercicio 4: Cifras = suma digitos    -> 1+111+201=313");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO");
        System.out.println("  Proximo: Ejercicios de Strings");
        System.out.println("============================================================");

        entrada.close();
    }

    // -------------------------------------------------------------
    // EJERCICIO 2: Contar digitos
    // -------------------------------------------------------------

    static void probarContarDigitos(int num, java.util.Scanner sc) {
        int original = num;
        if (num < 0) {
            System.out.println("  " + original + " -> Numero no valido (debe ser positivo)");
            return;
        }
        int cifras = 1;
        while (num > 9) {
            num /= 10;
            cifras++;
        }
        String palabra = (cifras == 1) ? "cifra" : "cifras";
        System.out.println("  El numero " + original + " tiene " + cifras + " " + palabra);
    }

    // -------------------------------------------------------------
    // EJERCICIO 3: Sumar positivos hasta 0 (demo con datos fijos)
    // -------------------------------------------------------------

    static String sumarPositivosDemo() {
        int[] datos = {3, 4, 5, 6, -2, 8, 0};
        int total = 0;
        String textoSuma = "";
        for (int num : datos) {
            if (num == 0) break;
            if (num > 0) {
                total += num;
                textoSuma += num + "+";
            }
        }
        // Quitar el ultimo '+' con \b
        return textoSuma + "\b=" + total;
    }

    // -------------------------------------------------------------
    // EJERCICIO 4: Cifras = suma digitos (demo con datos fijos)
    // -------------------------------------------------------------

    static String cifrasIgualSumaDemo() {
        int[] datos = {1, -111, 5, 111, 66, 201, 27, 0};
        int total = 0;
        String resultado = "";
        for (int num : datos) {
            if (num == 0) break;
            if (num <= 0) continue; // solo positivos

            // Contar cifras y sumar digitos
            int cifras = 1;
            int sumaDigitos = 0;
            int aux = num;

            // Ultimo digito
            sumaDigitos = aux % 10;
            aux /= 10;

            while (aux > 0) {
                cifras++;
                sumaDigitos += aux % 10;
                aux /= 10;
            }

            if (cifras == sumaDigitos) {
                total += num;
                resultado += num + "+";
            }
        }
        return resultado + "\b=" + total;
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
