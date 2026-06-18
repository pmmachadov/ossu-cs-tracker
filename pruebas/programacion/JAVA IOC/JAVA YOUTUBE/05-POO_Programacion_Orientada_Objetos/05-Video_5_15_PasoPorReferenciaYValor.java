class Video_5_15_PasoPorReferenciaYValor {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-15 JAVA: Paso por referencia y por valor DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=BugfoJ-ZM6U&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=108";
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
          RESUMEN RAPIDO - PASO POR REFERENCIA Y POR VALOR (TEMA 5 - V15)
        ====================================================================

        --- REGLA FUNDAMENTAL ---
        En Java, los parametros se pasan SIEMPRE por VALOR.
        Pero el "valor" que se pasa depende del tipo:

        TIPOS PRIMITIVOS (int, double, char, boolean...):
          - Se pasa una COPIA del valor.
          - NO se puede modificar la variable original.
          - El metodo trabaja con una copia local.

        OBJETOS (String, arrays, clases propias...):
          - Se pasa una COPIA de la REFERENCIA al objeto.
          - Se puede MODIFICAR el objeto (cambiar atributos).
          - NO se puede REASIGNAR el objeto (hacer que apunte a otro).
          - Ambos (original y parametro) apuntan al MISMO objeto.

        --- EJEMPLO PRACTICO ---
        static void modificarPunto(Punto p) {
            p.setX(999);   // MODIFICA el objeto original
        }

        static void modificarEntero(int n) {
            n = 999;        // NO modifica la variable original
        }

        static void modificarString(String s) {
            s = "Modificada"; // NO modifica el String original
        }

        --- STRINGS: CASO ESPECIAL ---
        - String es un OBJETO, pero es INMUTABLE.
        - Se pasa la referencia, pero no se puede cambiar su valor.
        - Al hacer s = "nuevo", se CREA un nuevo objeto String.
        - La referencia original NO se modifica.
        - COMPORTAMIENTO: parece paso por valor, pero es paso por referencia
          + inmutabilidad.

        --- REASIGNACION VS MODIFICACION ---
        MODIFICAR (SI afecta al original):
          p.setX(999);     // Cambia el estado interno del objeto

        REASIGNAR (NO afecta al original):
          p = new Punto(); // p ahora apunta a OTRO objeto
          n = 999;         // Solo cambia la copia local

        --- RESUMEN VISUAL ---
        Primitivo:  [num] --copia--> [n]  (no se afectan)
        Objeto:    [p1] --ref--> [p] -> modificando p afecta a p1
        String:    [nom] --ref--> [s] -> s = "x" crea nuevo objeto

        --- POR QUE ES IMPORTANTE ---
        - Entenderlo evita bugs dificiles de encontrar.
        - Saber cuando una funcion modifica o no el objeto original.
        - Las Strings al ser inmutables se comportan como primitivos.

        ====================================================================
        """;

    // ================================================================
    // CLASE PUNTO (para el ejemplo)
    // ================================================================
    static class Punto {
        int x, y;
        String nombre;

        Punto(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void setX(int x) { this.x = x; }
        int getX() { return x; }
        int getY() { return y; }

        void mostrar() {
            System.out.println("  Punto: x=" + x + ", y=" + y);
        }
    }

    // ================================================================
    // METODOS DEL EJEMPLO
    // ================================================================

    // 1. PASO POR REFERENCIA (objeto): SE modifica el original
    static void modificarPunto(Punto p) {
        p.setX(999);  // MODIFICA la instancia original
    }

    // 2. PASO POR VALOR (primitivo): NO modifica el original
    static void modificarEntero(int n) {
        n = 999;  // Solo modifica la copia local
    }

    // 3. PASO "ESPECIAL" (String inmutable): NO modifica el original
    static void modificarString(String s) {
        s = "String modificada";  // Crea NUEVO objeto String
    }

    // 4. REASIGNACION de objeto: NO afecta al original
    static void reasignarPunto(Punto p) {
        p = new Punto(888, 888);  // p ahora apunta a OTRO objeto
    }

    // 5. MODIFICACION a traves de una segunda referencia
    static void modificarPuntoConInterna(Punto p) {
        Punto p2 = p;      // p2 apunta al MISMO objeto que p
        p2.setX(555);      // Modifica el objeto (tambien el original)
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 5 - V15: PASO POR REFERENCIA Y POR VALOR");
        System.out.println();

        // ============================================================
        // PARTE 1: Objeto (referencia) vs Primitivo (valor)
        // ============================================================
        separador("PARTE 1: Objeto vs Primitivo");

        Punto p1 = new Punto(1, 1);
        int num = 1;
        String nombre = "String inmutable";

        System.out.println("  VALORES ANTES:");
        System.out.println("  p1.x = " + p1.getX());
        System.out.println("  num = " + num);
        System.out.println("  nombre = " + nombre);
        System.out.println();

        modificarPunto(p1);
        modificarEntero(num);
        modificarString(nombre);

        System.out.println("  VALORES DESPUES:");
        System.out.println("  p1.x = " + p1.getX() + " (SE modifico! -> 999)");
        System.out.println("  num = " + num + " (NO se modifico -> 1)");
        System.out.println("  nombre = " + nombre + " (NO se modifico -> 'Inmutable')");
        System.out.println();

        System.out.println("  CONCLUSION:");
        System.out.println("  - Objeto: se paso la referencia, se modifico el original");
        System.out.println("  - Primitivo: se paso copia, NO se modifica el original");
        System.out.println("  - String: paso referencia, pero es INMUTABLE -> no cambio");
        System.out.println();

        // ============================================================
        // PARTE 2: Reasignacion (no afecta) vs Modificacion (si afecta)
        // ============================================================
        separador("PARTE 2: Reasignar vs Modificar");

        Punto p2 = new Punto(10, 10);
        System.out.println("  p2.x antes de reasignarPunto: " + p2.getX());
        reasignarPunto(p2);
        System.out.println("  p2.x despues de reasignarPunto: "
            + p2.getX() + " (NO cambio, sigue siendo 10)");
        System.out.println("  (reasignar p = new Punto() dentro del metodo");
        System.out.println("   solo afecta a la copia local de la referencia)");
        System.out.println();

        Punto p3 = new Punto(100, 100);
        System.out.println("  p3.x antes de modificarPuntoConInterna: " + p3.getX());
        modificarPuntoConInterna(p3);
        System.out.println("  p3.x despues de modificarPuntoConInterna: "
            + p3.getX() + " (SI cambio a 555)");
        System.out.println("  (p2 = p copia la referencia, ambas apuntan al mismo objeto)");
        System.out.println();

        // ============================================================
        // RESUMEN FINAL
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V15: PASO POR REF/VALOR)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  REGLA DE ORO:");
        System.out.println("  - Primitivo: copia del valor -> NO se modifica original");
        System.out.println("  - Objeto: copia de la referencia -> SE puede modificar");
        System.out.println("  - String: es objeto pero inmutable -> NO se modifica");
        System.out.println();
        System.out.println("  PROXIMO VIDEO: Inmutabilidad en Java");
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
