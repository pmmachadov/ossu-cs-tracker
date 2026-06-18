class Video_5_13_This {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-13 JAVA: this DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=HxvLFdLys8g&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=106";
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
          RESUMEN RAPIDO - this (TEMA 5 - V13)
        ====================================================================

        --- this ---
        Palabra reservada que hace referencia a la INSTANCIA ACTUAL.
        - Se usa para diferenciar ATRIBUTOS de PARAMETROS con el mismo nombre.
        - Esta definido IMPLICITAMENTE en todos los metodos y constructores.
        - Sintaxis: this.nombreAtributo

        --- USO 1: Diferenciar atributo de parametro ---
        class Punto {
            int x, y;

            Punto(int x, int y) {
                this.x = x;  // this.x = atributo de la clase
                this.y = y;  // y = parametro del constructor
            }
        }

        Sin this, tendriamos que usar nombres distintos (int a, int b).

        --- USO 2: Llamar a OTRO constructor de la misma clase ---
        class Cliente {
            String nombre;
            long dni;
            long telefono;

            Cliente(String nombre, long dni) {
                this.nombre = nombre;
                this.dni = dni;
            }

            Cliente(String nombre, long dni, long telefono) {
                this(nombre, dni);   // Llama al constructor de arriba
                this.telefono = telefono;
            }
        }

        REGLA IMPORTANTE:
        - this() para llamar a otro constructor debe ser la PRIMERA
          instruccion del constructor.
        - Asi reutilizamos codigo entre constructores.

        --- USO 3: Pasar la instancia actual como parametro ---
        metodo(this);  // Pasa el objeto actual a otro metodo

        --- this en METODOS ---
        Tambien se usa en metodos:
          void setX(int x) {
              this.x = x;  // this.x = atributo, x = parametro
          }

        --- GENERACION AUTOMATICA EN VS CODE ---
        - Click derecho -> Source Action -> Generate constructor
        - Click derecho -> Generate getters/setters
        - Click derecho -> Generate toString()
        - Todo el codigo generado usa this automaticamente.

        --- toString() GENERADO ---
        public String toString() {
            return "Punto{x=\" + x + \", y=\" + y + \"}";
        }

        ====================================================================
        """;

    // ================================================================
    // CLASE PUNTO (con this)
    // ================================================================
    static class Punto {
        int x;
        int y;
        String nombre;

        // Constructor 1: un parametro (x e y iguales)
        Punto(int x) {
            this.x = x;
            this.y = x;
            this.nombre = null;  // Sin nombre
        }

        // Constructor 2: dos parametros
        Punto(int x, int y) {
            this.x = x;
            this.y = y;
            this.nombre = null;
        }

        // Constructor 3: dos parametros + nombre
        // REUTILIZA el constructor 2 con this(x, y)
        Punto(int x, int y, String nombre) {
            this(x, y);           // Llama al constructor Punto(int, int)
            this.nombre = nombre;
        }

        // Constructor 4: un entero + nombre
        // REUTILIZA el constructor 1 con this(x)
        Punto(int x, String nombre) {
            this(x);              // Llama al constructor Punto(int)
            this.nombre = nombre;
        }

        // Metodo que usa this para diferenciar atributo de parametro
        void setX(int x) {
            this.x = x;
        }

        void setY(int y) {
            this.y = y;
        }

        void setNombre(String nombre) {
            this.nombre = nombre;
        }

        int getX() { return x; }
        int getY() { return y; }
        String getNombre() { return nombre; }

        // Mostrar datos con comprobacion de null
        void mostrarDatos() {
            if (this.nombre == null) {
                System.out.print("  El punto NO tiene nombre. ");
            } else {
                System.out.print("  Punto de nombre '" + this.nombre + "': ");
            }
            System.out.println("x=" + x + ", y=" + y
                + " | Distancia al centro: " + calcularDistanciaCentro());
        }

        double calcularDistanciaCentro() {
            return Math.sqrt(x * x + y * y);
        }
    }

    // ================================================================
    // CLASE CLIENTE (ejemplo con this() entre constructores)
    // ================================================================
    static class Cliente {
        String nombre;
        long dni;
        long telefono;

        // Constructor con 2 parametros
        Cliente(String nombre, long dni) {
            this.nombre = nombre;
            this.dni = dni;
            this.telefono = 0;  // Sin telefono por defecto
        }

        // Constructor con 3 parametros
        // REUTILIZA el constructor de 2 parametros
        Cliente(String nombre, long dni, long telefono) {
            this(nombre, dni);   // Primera instruccion: llama al otro constructor
            this.telefono = telefono;
        }

        void mostrarDatos() {
            System.out.println("  Cliente: " + nombre + ", DNI: "
                + dni + ", Telefono: " + telefono);
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
        System.out.println("TEMA 5 - V13: LA PALABRA RESERVADA this");
        System.out.println();

        // ============================================================
        // PARTE 1: this en constructores (atributo vs parametro)
        // ============================================================
        separador("PARTE 1: Diferenciar atributo de parametro");

        System.out.println("  Los constructores usan this.x = x para distinguir");
        System.out.println("  el atributo de la clase del parametro del metodo.");
        System.out.println();

        Punto p1 = new Punto(2);            // x=2, y=2, nombre=null
        Punto p2 = new Punto(1, 3);         // x=1, y=3, nombre=null
        Punto p3 = new Punto(1, 1, "p3");   // x=1, y=1, nombre="p3"

        p1.mostrarDatos();
        p2.mostrarDatos();
        p3.mostrarDatos();
        System.out.println();

        // ============================================================
        // PARTE 2: this() para reutilizar constructores
        // ============================================================
        separador("PARTE 2: this() llama a otro constructor");

        System.out.println("  El constructor Punto(int x, int y, String nombre)");
        System.out.println("  llama a this(x, y) como primera instruccion,");
        System.out.println("  luego asigna this.nombre = nombre.");
        System.out.println();

        Punto p4 = new Punto(5, "p4");      // Usa this(5) + asigna nombre
        p4.mostrarDatos();
        System.out.println();

        // ============================================================
        // PARTE 3: Ejemplo Cliente con this()
        // ============================================================
        separador("PARTE 3: Cliente con this() entre constructores");

        Cliente c1 = new Cliente("Ana", 12345678L);
        Cliente c2 = new Cliente("Luis", 87654321L, 666555444L);

        System.out.println("  Cliente con 2 parametros (sin telefono):");
        c1.mostrarDatos();
        System.out.println("  Cliente con 3 parametros (con telefono):");
        c2.mostrarDatos();
        System.out.println();

        System.out.println("  El segundo constructor hizo this(nombre, dni)");
        System.out.println("  para reutilizar la logica del primero.");
        System.out.println();

        // ============================================================
        // PARTE 4: this en metodos (setters)
        // ============================================================
        separador("PARTE 4: this en setters");

        System.out.println("  Los setters tambien usan this para diferenciar:");
        System.out.println("    void setX(int x) { this.x = x; }");
        System.out.println();

        p1.setX(10);
        p1.setY(20);
        p1.setNombre("p1-modificado");
        p1.mostrarDatos();
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V13: this)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  USOS DE this:");
        System.out.println("  1. this.atributo -> atributo de la instancia");
        System.out.println("  2. this(parametros) -> llama a otro constructor");
        System.out.println("  3. implicitamente en todos los metodos");
        System.out.println();
        System.out.println("  REGLA: this() debe ser la PRIMERA instruccion");
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
