import java.util.Random;

class Video_5_17_ArraysDeObjetos {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-17 JAVA: Arrays de objetos DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=LAgn2SC9O8E&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=110";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 5";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // RESUMEN para el examen (CHULETA)
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ====================================================================
          RESUMEN RAPIDO - ARRAYS DE OBJETOS (TEMA 5 - V17)
        ====================================================================

        --- ARRAYS DE OBJETOS ---
        - Un array NO esta limitado a tipos primitivos.
        - Se puede crear un array de CUALQUIER tipo de objeto.
        - Sintaxis: Punto[] puntos = new Punto[5];
        - Esto crea un array de 5 REFERENCIAS a Punto.
        - CADA elemento del array es un puntero, no un objeto.

        --- INICIALIZACION ---
        - Al crear el array, TODOS los elementos son null.
        - Hay que crear CADA objeto explicitamente:
          puntos[0] = new Punto(1, 2);
          puntos[1] = new Punto(3, 4);
          ...

        - O en un bucle:
          for (int i = 0; i < puntos.length; i++) {
              puntos[i] = new Punto(i, i*2);
          }

        --- REFERENCIAS COMPARTIDAS ---
        - Si asignamos la MISMA referencia a varias posiciones:
          Punto p = new Punto(10, 20);
          puntos[0] = p;
          puntos[1] = p;  // Misma instancia!
          - Modificar p afecta a TODAS las posiciones.
          - Todos los elementos apuntan al MISMO objeto.

        --- RECORRER UN ARRAY DE OBJETOS ---
        for (int i = 0; i < puntos.length; i++) {
            System.out.println(puntos[i].getX()); // puntos[i] es un objeto
        }

        for (Punto p : puntos) {  // for-each
            System.out.println(p.getX());
        }

        --- EJEMPLO: MAXIMA DISTANCIA AL CENTRO ---
        Punto[] puntos = new Punto[5];
        // Llenar con aleatorios...

        double max = 0;
        for (Punto p : puntos) {
            double d = p.calcularDistanciaCentro();
            if (d > max) max = d;
        }
        System.out.println("Distancia maxima: " + max);

        --- COMPORTAMIENTO EN MEMORIA ---
        puntos  -->  [ref0] --> Punto{x=1, y=2}
                      [ref1] --> Punto{x=3, y=4}
                      [ref2] --> null
                      [ref3] --> Punto{x=5, y=6}
                      [ref4] --> null

        - puntos es una REFERENCIA al array.
        - Cada posicion es una REFERENCIA a un objeto Punto.
        - Si dos posiciones tienen la misma referencia,
          apuntan al MISMO objeto en memoria.

        ====================================================================
        """;

    // ================================================================
    // CLASE PUNTO
    // ================================================================
    static class Punto {
        int x, y;

        Punto(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void setX(int x) { this.x = x; }
        int getX() { return x; }
        int getY() { return y; }

        double calcularDistanciaCentro() {
            return Math.sqrt(x * x + y * y);
        }

        void mostrarDatos() {
            System.out.println("  Punto: x=" + x + ", y=" + y
                + " | Distancia al centro: " + calcularDistanciaCentro());
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 5 - V17: ARRAYS DE OBJETOS");
        System.out.println();

        Random rnd = new Random();

        // ============================================================
        // PARTE 1: Crear array de objetos y llenarlo
        // ============================================================
        separador("PARTE 1: Array de 5 puntos aleatorios");

        Punto[] puntos = new Punto[5];

        System.out.println("  Al crear el array, todos los elementos son null:");
        System.out.println("  puntos[0] = " + puntos[0]);
        System.out.println("  puntos[1] = " + puntos[1]);
        System.out.println();

        // Llenar el array con puntos aleatorios
        for (int i = 0; i < puntos.length; i++) {
            int x = rnd.nextInt(100);
            int y = rnd.nextInt(100);
            puntos[i] = new Punto(x, y);
            System.out.print("  puntos[" + i + "] creado: ");
            puntos[i].mostrarDatos();
        }
        System.out.println();

        // ============================================================
        // PARTE 2: Encontrar la maxima distancia al centro
        // ============================================================
        separador("PARTE 2: Maxima distancia al centro");

        double max = 0;
        for (Punto p : puntos) {
            double d = p.calcularDistanciaCentro();
            if (d > max) max = d;
        }
        System.out.println("  La distancia maxima al centro es: " + max);
        System.out.println();

        // ============================================================
        // PARTE 3: Referencias compartidas (el mismo objeto en varias posiciones)
        // ============================================================
        separador("PARTE 3: Referencias compartidas (mismo objeto)");

        Punto[] mismoPunto = new Punto[5];
        Punto pReferencia = new Punto(10, 10);

        for (int i = 0; i < mismoPunto.length; i++) {
            mismoPunto[i] = pReferencia;  // TODAS apuntan al MISMO objeto
        }

        System.out.println("  Todas las posiciones apuntan al MISMO objeto:");
        for (int i = 0; i < mismoPunto.length; i++) {
            System.out.println("  mismoPunto[" + i + "]: x="
                + mismoPunto[i].getX() + ", y=" + mismoPunto[i].getY());
        }
        System.out.println();

        // Modificamos el original -> afecta a TODAS las posiciones
        pReferencia.setX(999);
        System.out.println("  Despues de pReferencia.setX(999):");
        for (int i = 0; i < mismoPunto.length; i++) {
            System.out.println("  mismoPunto[" + i + "].x = "
                + mismoPunto[i].getX() + " (TODOS cambiaron!)");
        }
        System.out.println();

        // ============================================================
        // PARTE 4: For-each con objetos
        // ============================================================
        separador("PARTE 4: For-each recorriendo objetos");

        System.out.println("  Recorriendo puntos con for-each:");
        int idx = 0;
        for (Punto p : puntos) {
            System.out.print("  puntos[" + idx + "]: ");
            p.mostrarDatos();
            idx++;
        }
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V17: ARRAYS DE OBJETOS)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Array de objetos = array de REFERENCIAS");
        System.out.println("  - Cada posicion empieza en null");
        System.out.println("  - Hay que crear cada objeto con new");
        System.out.println("  - Si dos posiciones tienen la misma referencia,");
        System.out.println("    apuntan al MISMO objeto");
        System.out.println("  - Modificar el objeto afecta a todas las referencias");
    }

    // -------------------------------------------------------------
    // METODO AUXILIAR
    // -------------------------------------------------------------
    public static void separador(String titulo) {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("  " + titulo);
        System.out.println("============================================================");
    }
}
