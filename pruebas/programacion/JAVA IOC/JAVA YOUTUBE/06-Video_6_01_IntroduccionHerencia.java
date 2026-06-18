class Video_6_01_IntroduccionHerencia {

    public static final String TITULO = "6-01 JAVA: Introduccion a la Herencia DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=ElXzrqK2BSc&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=122";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - INTRODUCCION A LA HERENCIA (TEMA 6 - V01)\n"
        + "=============================================================\n\n"
        + "HERENCIA: capacidad de una clase de heredar comportamiento de otra.\n"
        + "- Reutilizacion de codigo.\n"
        + "- La clase hija hereda TODO de la clase padre.\n"
        + "- Puede anadir atributos y metodos propios.\n"
        + "- Puede SOBREESCRIBIR metodos (override).\n\n"
        + "PALABRAS RESERVADAS:\n"
        + "- extends: indica herencia. class Hija extends Padre { }\n"
        + "- protected: visibilidad intermedia (public + herencia, pero no externo)\n"
        + "- super: referencia a la clase padre.\n"
        + "  * super() -> llama al constructor del padre (PRIMERA INSTRUCCION)\n"
        + "  * super.metodo() -> llama a un metodo del padre\n"
        + "  * super.atributo -> accede a un atributo del padre\n\n"
        + "REGLA IMPORTANTE:\n"
        + "- super() debe ser la PRIMERA instruccion del constructor hijo.\n"
        + "- super.metodo() y super.atributo pueden usarse en cualquier orden.\n\n"
        + "TIPOS DE VISIBILIDAD:\n"
        + "- private: solo visible dentro de la clase.\n"
        + "- protected: visible en la clase, subclases y mismo paquete.\n"
        + "- public: visible desde cualquier clase.\n"
        + "- (sin): visible dentro del mismo paquete.\n\n"
        + "SOBREESCRITURA (override):\n"
        + "- La clase hija puede redefinir un metodo del padre.\n"
        + "- Mismo nombre, mismos parametros, mismo tipo de retorno.\n"
        + "- Desde el hijo se puede llamar al padre con super.metodo().\n\n"
        + "EJEMPLO:\n"
        + "class Padre {\n"
        + "    String nombre;\n"
        + "    Padre(String n) { nombre = n; }\n"
        + "    void mostrarInfo() { System.out.println(\"Padre: \" + nombre); }\n"
        + "}\n\n"
        + "class Hija extends Padre {\n"
        + "    int edad;\n"
        + "    Hija(int e, String n) {\n"
        + "        super(n);  // llama al constructor de Padre\n"
        + "        this.edad = e;\n"
        + "    }\n"
        + "    void mostrarInfo() {\n"
        + "        super.mostrarInfo();  // llama al metodo del padre\n"
        + "        System.out.println(\"Hija tiene \" + edad + \" anos\");\n"
        + "    }\n"
        + "}";

    // ================================================================
    // CLASE PADRE (superclase)
    // ================================================================
    static class Padre {
        String nombre;

        Padre(String nombre) {
            this.nombre = nombre;
        }

        void mostrarInfo() {
            System.out.println("  Padre: " + nombre);
        }
    }

    // ================================================================
    // CLASE HIJA (subclase)
    // ================================================================
    static class Hija extends Padre {
        String nombre;  // Atributo propio (oculta el del padre)
        int edad;

        Hija(int edad, String nombrePadre, String nombreHija) {
            super(nombrePadre);           // Llama al constructor de Padre
            this.nombre = nombreHija;     // Atributo de Hija
            this.edad = edad;
        }

        // SOBREESCRITURA: mismo nombre que en Padre
        void mostrarInfo() {
            System.out.println("  Hija: " + nombre + ", edad: " + edad + " anos");
        }

        void mostrarInfoCompleto() {
            super.mostrarInfo();          // Llama al metodo del padre
            mostrarInfo();                // Llama al metodo propio
        }

        void mostrarPadreYPropio() {
            System.out.println("  Padre (via super.nombre): " + super.nombre);
            System.out.println("  Hija (via this.nombre): " + this.nombre);
        }
    }

    // ================================================================
    // CLASE HIJA SIMPLE (solo hereda, sin atributos extra)
    // ================================================================
    static class HijaSimple extends Padre {
        int edad;

        HijaSimple(int edad, String nombre) {
            super(nombre);   // Llama al constructor del padre
            this.edad = edad;
        }

        void mostrarInfo() {
            super.mostrarInfo();
            System.out.println("  Edad: " + edad);
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V01: INTRODUCCION A LA HERENCIA");
        System.out.println();

        // ============================================================
        // EJEMPLO 1: Clase hija simple (solo hereda)
        // ============================================================
        System.out.println("=== EJEMPLO 1: HijaSimple (hereda + edad) ===");
        Padre p = new Padre("Pepe");
        HijaSimple h = new HijaSimple(5, "Pepe");

        System.out.println("  Instancia de Padre:");
        p.mostrarInfo();
        System.out.println("  Instancia de HijaSimple:");
        h.mostrarInfo();
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Hija con atributo propio + super()
        // ============================================================
        System.out.println("=== EJEMPLO 2: Hija con nombre propio ===");
        Hija h1 = new Hija(5, "Pepe", "Marta");

        System.out.println("  h1.mostrarInfoCompleto():");
        h1.mostrarInfoCompleto();
        System.out.println();

        System.out.println("  h1.mostrarPadreYPropio():");
        h1.mostrarPadreYPropio();
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Polimorfismo basico (clase padre ref a hija)
        // ============================================================
        System.out.println("=== EJEMPLO 3: Polimorfismo ===");
        Padre ref = new Hija(10, "Luis", "Ana");
        ref.mostrarInfo();  // Llama al metodo de Hija (polimorfismo)
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 6 - V01: INTRODUCCION A LA HERENCIA)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - extends: heredar de otra clase");
        System.out.println("  - super(): llamar al constructor del padre");
        System.out.println("  - super.metodo(): llamar metodo del padre");
        System.out.println("  - super.atributo: acceder atributo del padre");
        System.out.println("  - protected: visibilidad para subclases");
        System.out.println("  - Sobreescritura: mismo metodo con distinto comportamiento");
        System.out.println("  - Polimorfismo: referencia de padre apunta a hija");
    }
}
