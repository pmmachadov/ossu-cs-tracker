class Video_5_09_EjemploClaseTelevisor {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-09 JAVA: Ejemplo clase Televisor DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=bU0p5XVOM_4&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=102";
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
          RESUMEN RAPIDO - EJEMPLO CLASE TELEVISOR (TEMA 5 - V09)
        ====================================================================

        --- CLASE TELEVISOR ---
        Un unico atributo: private int canal.
        Metodos:
        - Televisor()      -> constructor (canal = 0 por defecto)
        - subirCanal()     -> canal++
        - bajarCanal()     -> canal--
        - getCanal()       -> return canal

        --- VALORES POR DEFECTO ---
        Cuando se crea un objeto con new, si no se inicializan los
        atributos, toman el valor por defecto del tipo:
        - int, long, short, byte -> 0
        - double, float          -> 0.0
        - boolean                -> false
        - char                   -> '\\0'
        - Objetos (String etc)   -> null

        Por eso, al hacer new Televisor(), canal empieza en 0.

        --- DECLARAR vs INSTANCIAR ---
        Televisor tv;            // Solo declara variable (tv = null)
        tv = new Televisor();    // Crea la instancia (tv apunta al objeto)

        O en una linea:
        Televisor tv = new Televisor();

        Si solo declaramos sin new, la variable es null y no podemos
        usar sus metodos (NullPointerException).

        --- REFERENCIAS (punteros) ---
        - tv no es el objeto, es una REFERENCIA al objeto.
        - Apunta a una direccion de memoria donde esta el objeto.
        - Varias variables pueden apuntar al MISMO objeto.

        --- FUNCIONAMIENTO SUBIR/BAJAR CANAL ---
        Televisor tv = new Televisor();  // canal = 0
        tv.subirCanal();                  // canal = 1
        System.out.println(tv.getCanal()); // muestra 1
        tv.bajarCanal();                   // canal = 0
        System.out.println(tv.getCanal()); // muestra 0

        --- ASIGNAR VALOR POR DEFECTO EN CONSTRUCTOR ---
        Podemos inicializar en el constructor para que no empiece en 0:
        Televisor() {
            canal = 1;   // Ahora empieza en el canal 1
        }

        --- ESTRUCTURA TIPICA DE UNA CLASE ---
        class Televisor {
            // Atributos
            private int canal;

            // Constructor
            public Televisor() { ... }

            // Metodos
            public void subirCanal() { canal++; }
            public void bajarCanal() { canal--; }
            public int getCanal() { return canal; }
        }

        --- CLASE APLICACION (main) ---
        public class AplicacionTV {
            public static void main(String[] args) {
                Televisor tv = new Televisor();
                tv.subirCanal();
                System.out.println(tv.getCanal());
            }
        }

        ====================================================================
        """;

    // ================================================================
    // CLASE TELEVISOR
    // ================================================================
    static class Televisor {
        // Atributo privado
        private int canal;

        // Constructor (inicializa canal a 1 en vez de 0)
        Televisor() {
            canal = 1;  // Valor por defecto personalizado
        }

        // Metodos
        void subirCanal() {
            canal++;
        }

        void bajarCanal() {
            canal--;
        }

        int getCanal() {
            return canal;
        }
    }

    // ================================================================
    // METODO PRINCIPAL (AplicacionTV)
    // ================================================================
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 5 - V09: EJEMPLO CLASE TELEVISOR");
        System.out.println();

        // ============================================================
        // PARTE 1: Declarar vs Instanciar
        // ============================================================
        separador("PARTE 1: Declarar vs Instanciar");

        Televisor tv;  // Solo declaracion (null)
        System.out.println("  Televisor tv;  -> tv es null (variable declarada)");
        System.out.println("  tv = new Televisor(); -> se crea la instancia");
        tv = new Televisor();
        System.out.println("  Ahora tv apunta a un objeto en memoria.");
        System.out.println("  canal inicial: " + tv.getCanal() + " (por defecto = 1)");
        System.out.println();

        // ============================================================
        // PARTE 2: Subir y bajar canal
        // ============================================================
        separador("PARTE 2: Subir y bajar canal");

        System.out.println("  tv.subirCanal() -> canal++");
        tv.subirCanal();
        System.out.println("  Canal seleccionado es el: " + tv.getCanal());
        System.out.println();

        System.out.println("  tv.bajarCanal() -> canal--");
        tv.bajarCanal();
        System.out.println("  Canal seleccionado es el: " + tv.getCanal());
        System.out.println();

        // ============================================================
        // PARTE 3: Secuencia completa como en el video
        // ============================================================
        separador("PARTE 3: Secuencia del video");

        Televisor tv2 = new Televisor();
        System.out.println("  tv2 = new Televisor()  (canal empieza = " + tv2.getCanal() + ")");

        tv2.subirCanal();
        System.out.println("  tv2.subirCanal()");
        System.out.println("  Canal seleccionado es el: " + tv2.getCanal());

        tv2.bajarCanal();
        System.out.println("  tv2.bajarCanal()");
        System.out.println("  Canal seleccionado es el: " + tv2.getCanal());
        System.out.println();

        // ============================================================
        // PARTE 4: Referencias (dos variables apuntan al mismo objeto)
        // ============================================================
        separador("PARTE 4: Referencias compartidas");

        Televisor a = new Televisor();
        Televisor b = a;  // b apunta al MISMO objeto que a
        System.out.println("  Televisor a = new Televisor();");
        System.out.println("  Televisor b = a;  (b apunta al mismo objeto que a)");
        System.out.println();

        a.subirCanal();  // a sube canal -> afecta al objeto
        System.out.println("  a.subirCanal()");
        System.out.println("  a.getCanal() = " + a.getCanal());
        System.out.println("  b.getCanal() = " + b.getCanal() + " (mismo objeto!)");
        System.out.println();

        // ============================================================
        // PARTE 5: Dos instancias independientes
        // ============================================================
        separador("PARTE 5: Dos instancias independientes");

        Televisor t1 = new Televisor();
        Televisor t2 = new Televisor();

        t1.subirCanal();
        t1.subirCanal();
        t2.subirCanal();

        System.out.println("  t1: subir 2 veces -> canal = " + t1.getCanal());
        System.out.println("  t2: subir 1 vez  -> canal = " + t2.getCanal());
        System.out.println("  (Cada instancia tiene su propio estado)");
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V09: EJEMPLO CLASE TELEVISOR)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Valores por defecto de tipos primitivos");
        System.out.println("  - Declarar (null) vs Instanciar (new)");
        System.out.println("  - Las variables son REFERENCIAS al objeto");
        System.out.println("  - Dos variables pueden apuntar al mismo objeto");
        System.out.println("  - Cada new crea un objeto independiente");
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
