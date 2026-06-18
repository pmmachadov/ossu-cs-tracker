class Video_6_02_EjemploHerencia_PersonaEstudiante {

    public static final String TITULO = "6-02 JAVA: Ejemplo Herencia - Persona y Estudiante DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=SF4GBfn_VmE&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=123";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - EJEMPLO HERENCIA: PERSONA Y ESTUDIANTE (TEMA 6 - V02)\n"
        + "=============================================================\n\n"
        + "CLASE PERSONA (superclase):\n"
        + "- private String nombre\n"
        + "- private int edad\n"
        + "- Constructor con nombre y edad\n"
        + "- public String getNombre()\n"
        + "- toString()\n\n"
        + "CLASE ESTUDIANTE (subclase):\n"
        + "- extends Persona\n"
        + "- int creditos (nuevo atributo)\n"
        + "- Constructor: super(nombre, edad) + creditos = 60 (por defecto)\n"
        + "- Puede heredar getNombre() de Persona\n"
        + "- Puede sobrescribir mostrarDatos()\n\n"
        + "POLIMORFISMO:\n"
        + "- Si Persona tiene mostrarDatos() y Estudiante tambien,\n"
        + "  se ejecuta UNO u OTRO segun el tipo real del objeto.\n"
        + "- Persona p = new Estudiante(...); p.mostrarDatos() -> metodo de Estudiante\n\n"
        + "MODIFICADORES DE ACCESO EN HERENCIA:\n"
        + "- private: NO accesible desde la subclase\n"
        + "- protected: SI accesible desde la subclase\n"
        + "- public: SI accesible desde cualquier sitio\n"
        + "- Para acceder a un atributo private del padre: usar getter publico\n\n"
        + "SUPER en metodos:\n"
        + "- super.mostrarDatos() dentro de Estudiante llama al metodo de Persona\n"
        + "- Permite REUTILIZAR codigo del padre y anadir comportamiento especifico\n\n"
        + "ESTRUCTURA:\n"
        + "class Persona {\n"
        + "    private String nombre;\n"
        + "    private int edad;\n"
        + "    Persona(String n, int e) { ... }\n"
        + "    void mostrarDatos() { System.out.println(\"Nombre: \" + nombre); }\n"
        + "}\n\n"
        + "class Estudiante extends Persona {\n"
        + "    int creditos;\n"
        + "    Estudiante(String n, int e) {\n"
        + "        super(n, e);\n"
        + "        creditos = 60;\n"
        + "    }\n"
        + "    void mostrarDatos() {\n"
        + "        super.mostrarDatos();\n"
        + "        System.out.println(\"Creditos: \" + creditos);\n"
        + "    }\n"
        + "}";

    // ================================================================
    // CLASE PERSONA (superclase)
    // ================================================================
    static class Persona {
        private String nombre;
        private int edad;

        Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre() {
            return nombre;
        }

        void mostrarDatos() {
            System.out.println("  Nombre: " + nombre);
            System.out.println("  Edad: " + edad);
        }
    }

    // ================================================================
    // CLASE ESTUDIANTE (subclase)
    // ================================================================
    static class Estudiante extends Persona {
        private int creditos;

        // Constructor: solo nombre y edad, creditos por defecto = 60
        Estudiante(String nombre, int edad) {
            super(nombre, edad);    // Llama al constructor de Persona
            this.creditos = 60;     // Por defecto
        }

        // Constructor con creditos personalizado
        Estudiante(String nombre, int edad, int creditos) {
            super(nombre, edad);
            this.creditos = creditos;
        }

        int getCreditos() { return creditos; }

        // SOBREESCRITURA: llama al padre con super y anade info
        void mostrarDatos() {
            super.mostrarDatos();   // Reutiliza el metodo de Persona
            System.out.println("  Estudiante matriculado de " + creditos + " creditos");
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V02: HERENCIA - PERSONA Y ESTUDIANTE");
        System.out.println();

        // ============================================================
        // EJEMPLO 1: Acceso a metodo heredado (getNombre de Persona)
        // ============================================================
        System.out.println("=== EJEMPLO 1: Metodo heredado ===");
        Persona p = new Persona("Marta Gomez", 20);
        Estudiante e = new Estudiante("Luis Garcia", 20);

        System.out.println("  Persona.getNombre(): " + p.getNombre());
        System.out.println("  Estudiante.getNombre() (heredado): " + e.getNombre());
        System.out.println("  (Estudiante hereda getNombre() de Persona)");
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Polimorfismo - mostrarDatos() distinto segun clase
        // ============================================================
        System.out.println("=== EJEMPLO 2: Polimorfismo ===");
        System.out.println("  p.mostrarDatos() -> metodo de Persona:");
        p.mostrarDatos();
        System.out.println();

        System.out.println("  e.mostrarDatos() -> metodo de Estudiante (con super):");
        e.mostrarDatos();
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Estudiante con creditos personalizados
        // ============================================================
        System.out.println("=== EJEMPLO 3: Creditos personalizados ===");
        Estudiante e2 = new Estudiante("Ana Lopez", 22, 90);
        e2.mostrarDatos();
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Referencia de Persona apuntando a Estudiante
        // ============================================================
        System.out.println("=== EJEMPLO 4: Polimorfismo con referencia ===");
        Persona ref = new Estudiante("Carlos Ruiz", 19, 75);
        ref.mostrarDatos();  // Ejecuta el metodo de ESTUDIANTE
        System.out.println("  (La referencia es Persona, pero el objeto es Estudiante)");
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 6 - V02: PERSONA Y ESTUDIANTE)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - extends Persona en Estudiante");
        System.out.println("  - super(nombre, edad) en constructor");
        System.out.println("  - super.mostrarDatos() reutiliza codigo del padre");
        System.out.println("  - Polimorfismo: mismo metodo, distinto comportamiento");
        System.out.println("  - Referencia de padre puede apuntar a objeto hijo");
    }
}
