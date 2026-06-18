class Video_5_14_Static {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-14 JAVA: static - metodos y variables DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=iaTOo8k7icg&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=107";
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
          RESUMEN RAPIDO - static (TEMA 5 - V14)
        ====================================================================

        --- static ---
        La palabra reservada static indica que pertenece a la CLASE,
        no a una instancia concreta.

        --- ATRIBUTOS ESTATICOS (variables de clase) ---
        - Son COMPARTIDOS por todas las instancias.
        - Solo hay UNA COPIA del atributo, no una por objeto.
        - Se accede a traves del NOMBRE DE LA CLASE: Punto.puntos
        - Se pueden usar aunque NO haya ninguna instancia creada.
        - Se puede considerar una variable GLOBAL de la clase.
        - Uso tipico: contar cuantas instancias se han creado.

        --- METODOS ESTATICOS ---
        - Son metodos de CLASE, no de instancia.
        - Se invocan con: NombreClase.metodo()  (no instancia.metodo())
        - SOLO pueden acceder a ATRIBUTOS ESTATICOS.
        - NO pueden usar this (this es la instancia actual).
        - NO es necesario crear una instancia para usarlos.
        - Ej: Math.sqrt(), Integer.parseInt() son metodos estaticos.

        --- REGLA IMPORTANTE ---
        - Un metodo ESTATICO NO puede acceder a atributos NO estaticos.
        - Un metodo NO estatico SI puede acceder a atributos estaticos.
        - Un metodo estatico NO puede usar this.

        --- static + final (CONSTANTES) ---
        - Se usa static final para crear CONSTANTES.
        - Convencion: el nombre se escribe en MAYUSCULAS.
        - Se deben inicializar en la declaracion.
        - No se pueden modificar despues.
        - Ej: public static final double PI = 3.1416;
        - Acceso: NombreClase.PI

        --- final EN CLASES Y METODOS ---
        - final class: no se puede heredar (no puede tener hijas).
        - final method: no se puede sobrescribir en subclases.
        - final variable: constante, no se puede reasignar.

        --- EJEMPLO: CONTADOR DE INSTANCIAS ---
        class Punto {
            private static int cantidadPuntos = 0;

            Punto() {
                cantidadPuntos++;  // Cada new incrementa
            }

            public static int getCantidadPuntos() {
                return cantidadPuntos;
            }
        }

        Uso: Punto.getCantidadPuntos();  // Sin necesidad de instancia

        --- CUANDO USAR STATIC ---
        - Cuando el metodo/atributo es independiente de cualquier instancia.
        - Metodos de utilidad (Math, Arrays, Collections).
        - Contadores globales compartidos entre instancias.
        - Constantes (static final).

        ====================================================================
        """;

    // ================================================================
    // CLASE PUNTO (con atributo y metodo estatico)
    // ================================================================
    static class Punto {
        int x;
        int y;
        String nombre;

        // ATRIBUTO ESTATICO: compartido por todas las instancias
        private static int cantidadPuntos = 1;  // Empieza en 1

        // Constructor 1: un parametro
        Punto(int x) {
            this.x = x;
            this.y = x;
            this.nombre = null;
            cantidadPuntos += 3;
        }

        // Constructor 2: dos parametros
        Punto(int x, int y) {
            this.x = x;
            this.y = y;
            this.nombre = null;
            cantidadPuntos += 2;
        }

        // Constructor 3: dos parametros + nombre
        Punto(int x, int y, String nombre) {
            this(x, y);            // Llama al constructor 2 (cantidadPuntos += 2)
            this.nombre = nombre;
            cantidadPuntos += 1;   // Total += 3
        }

        // Constructor 4: un entero + nombre
        Punto(int x, String nombre) {
            this(x);               // Llama al constructor 1 (cantidadPuntos += 3)
            this.nombre = nombre;
            cantidadPuntos += 4;   // Total += 7
        }

        // METODO ESTATICO: se invoca con Punto.getPuntos()
        static void getPuntos() {
            System.out.println("  Puntos = " + cantidadPuntos);
        }

        void mostrarDatos() {
            if (nombre == null) {
                System.out.print("  Punto sin nombre: ");
            } else {
                System.out.print("  Punto '" + nombre + "': ");
            }
            System.out.println("x=" + x + ", y=" + y);
        }
    }

    // ================================================================
    // CLASE CONSTANTES (static final)
    // ================================================================
    static class Constantes {
        // Constantes (static final) -> mayusculas por convencion
        public static final float PI = 3.1416f;
        public static final float E = 2.7183f;

        // Metodo estatico final
        public static final void mostrarConstantes() {
            System.out.println("  PI = " + PI);
            System.out.println("  E  = " + E);
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
        System.out.println("TEMA 5 - V14: METODOS Y ATRIBUTOS STATIC");
        System.out.println();

        // ============================================================
        // PARTE 1: static - contador de instancias
        // ============================================================
        separador("PARTE 1: Atributo estatico (contador de instancias)");

        System.out.println("  Cada constructor incrementa cantidadPuntos");
        System.out.println("  de forma DISTINTA segun su logica.");
        System.out.println();

        // Mostrar puntos inicial (sin instancias aun)
        // Se invoca con el NOMBRE DE LA CLASE, no con una instancia
        System.out.println("  Puntos antes de crear objetos:");
        Punto.getPuntos();  // 1 (valor inicial)
        System.out.println();

        Punto p1 = new Punto(2, "p1");   // Constructor 4: += 7
        Punto p2 = new Punto(1, 3, "p2"); // Constructor 3: += 3
        Punto p3 = new Punto(2, "p3");   // Constructor 4: += 7

        p1.mostrarDatos();
        p2.mostrarDatos();
        p3.mostrarDatos();
        System.out.println();

        System.out.println("  Puntos totales (tras crear 3 instancias):");
        Punto.getPuntos();
        System.out.println();

        // Explicacion: 1 (inicial) + 7 (p1) + 3 (p2) + 7 (p3) = 18
        System.out.println("  Explicacion: 1(inicio)+7(p1)+3(p2)+7(p3) = 18");
        System.out.println("  El atributo cantidadPuntos es COMPARTIDO");
        System.out.println("  por todas las instancias de Punto.");
        System.out.println();

        // ============================================================
        // PARTE 2: Constantes (static final)
        // ============================================================
        separador("PARTE 2: Constantes con static final");

        System.out.println("  Acceso a constantes sin crear instancia:");
        System.out.println("  Constantes.PI = " + Constantes.PI);
        System.out.println("  Constantes.E  = " + Constantes.E);
        System.out.println();

        System.out.println("  Metodo estatico mostrarConstantes():");
        Constantes.mostrarConstantes();
        System.out.println();

        // ============================================================
        // PARTE 3: Lo que NO se puede hacer con static
        // ============================================================
        separador("PARTE 3: Reglas de static");

        System.out.println("  - Metodo estatico NO puede acceder a this");
        System.out.println("  - Metodo estatico NO puede acceder a atributos");
        System.out.println("    de instancia (x, y, nombre)");
        System.out.println("  - Metodo NO estatico SI puede acceder a");
        System.out.println("    atributos estaticos (cantidadPuntos)");
        System.out.println();
        System.out.println("  Los metodos estaticos se llaman con CLASE.metodo()");
        System.out.println("  Los metodos de instancia se llaman con OBJ.metodo()");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V14: STATIC)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - static = de la CLASE, no de la INSTANCIA");
        System.out.println("  - Atributo estatico: compartido por todos los objetos");
        System.out.println("  - Metodo estatico: se accede con Clase.metodo()");
        System.out.println("  - static + final = constante (nombre en MAYUSCULAS)");
        System.out.println("  - Un metodo estatico NO puede usar this");
        System.out.println("  - Un metodo estatico NO puede acceder a atributos no static");
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
