class Video_6_03_SobrescrituraDeMetodos {

    public static final String TITULO = "6-03 JAVA: Sobrescritura de metodos DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=EqiUftNakIs&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=124";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - SOBRESCRITURA DE METODOS (TEMA 6 - V03)\n"
        + "============================================================\n\n"
        + "SOBRESCRITURA (OVERRIDE): redefinir un metodo heredado en la subclase.\n"
        + "- Mismo nombre, mismos parametros, mismo tipo de retorno.\n"
        + "- Si cambian los parametros -> es SOBRECARGA, no sobrescritura.\n"
        + "- El metodo NO debe ser private en el padre.\n\n"
        + "TIPOS:\n"
        + "1. COMPLETA: se reescribe todo el metodo (sin llamar al padre).\n"
        + "2. PARCIAL: se llama al padre con super.metodo() y se anade codigo.\n\n"
        + "toString() - EL METODO MAS SOBREESCRITO:\n"
        + "- Todas las clases heredan de Object, que tiene toString().\n"
        + "- Persona puede sobrescribir toString() de Object.\n"
        + "- Estudiante y Profesor pueden sobrescribir toString() de Persona.\n"
        + "- System.out.println(objeto) llama automaticamente a toString().\n\n"
        + "JERARQUIA:\n"
        + "Object -> Persona (override toString)\n"
        + "        -> Estudiante extends Persona (override parcial de toString)\n"
        + "        -> Profesor extends Persona (override parcial de toString)\n\n"
        + "CADENA DE LLAMADAS:\n"
        + "- Estudiante.toString() -> super.toString() (Persona) -> informacion base\n"
        + "                        -> anade creditos\n"
        + "- Profesor.toString()  -> super.toString() (Persona) -> informacion base\n"
        + "                        -> anade departamento\n\n"
        + "GENERACION AUTOMATICA EN VS CODE:\n"
        + "- Bombilla -> Generate toString()\n"
        + "- Bombilla -> Generate Constructor (con super automatico)\n"
        + "- Se puede modificar para que llame a super.toString() si se desea parcial";

    // ================================================================
    // CLASE PERSONA (superclase, sobrescribe toString de Object)
    // ================================================================
    static class Persona {
        private String nombre;
        private int edad;

        Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        Persona() {} // necesario para algunos constructores generados

        public String getNombre() { return nombre; }
        public int getEdad() { return edad; }

        // SOBREESCRITURA COMPLETA de Object.toString()
        public String toString() {
            return "Nombre: " + nombre + ", Edad: " + edad;
        }
    }

    // ================================================================
    // CLASE ESTUDIANTE (sobrescribe toString de Persona)
    // ================================================================
    static class Estudiante extends Persona {
        private int creditos;

        // Constructor con 2 parametros (creditos por defecto)
        Estudiante(String nombre, int edad) {
            super(nombre, edad);
            this.creditos = 60;
        }

        // Constructor con 3 parametros (creditos personalizados)
        Estudiante(String nombre, int edad, int creditos) {
            super(nombre, edad);
            this.creditos = creditos;
        }

        // SOBREESCRITURA PARCIAL: llama al padre con super.toString()
        public String toString() {
            return super.toString() + ", Creditos: " + creditos;
        }
    }

    // ================================================================
    // CLASE PROFESOR (sobrescribe toString de Persona)
    // ================================================================
    static class Profesor extends Persona {
        private String departamento;

        Profesor(String nombre, int edad, String departamento) {
            super(nombre, edad);
            this.departamento = departamento;
        }

        // SOBREESCRITURA PARCIAL
        public String toString() {
            return super.toString() + ", Dep: " + departamento;
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V03: SOBRESCRITURA DE METODOS (toString)");
        System.out.println();

        // ============================================================
        // Demostracion: sobrescritura de toString()
        // ============================================================
        System.out.println("=== toString() segun la clase ===");

        Persona p = new Persona("Luis Garcia", 20);
        Estudiante e = new Estudiante("Luis Garcia", 20);
        Estudiante e2 = new Estudiante("Ana Lopez", 22, 100);
        Profesor pr = new Profesor("Juan Perez", 45, "Informatica");

        // System.out.println(objeto) llama a toString() automaticamente
        System.out.println("  Persona:  " + p);
        System.out.println("  Estudiante (60 cred): " + e);
        System.out.println("  Estudiante (100 cred): " + e2);
        System.out.println("  Profesor: " + pr);
        System.out.println();

        // ============================================================
        // Llamada explicita vs implicita
        // ============================================================
        System.out.println("=== Llamada explicita vs implicita ===");
        System.out.println("  p.toString(): " + p.toString());
        System.out.println("  p (implicito): " + p);
        System.out.println("  (Ambos hacen lo mismo)");
        System.out.println();

        // ============================================================
        // Jerarquia de llamadas
        // ============================================================
        System.out.println("=== JERARQUIA DE LLAMADAS ===");
        System.out.println("  Estudiante.toString() -> super.toString() (Persona)");
        System.out.println("                        -> anade creditos");
        System.out.println("  Profesor.toString()  -> super.toString() (Persona)");
        System.out.println("                        -> anade departamento");
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 6 - V03: SOBRESCRITURA DE METODOS)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Sobrescritura completa: se reescribe todo");
        System.out.println("  - Sobrescritura parcial: super.metodo() + codigo extra");
        System.out.println("  - toString(): el metodo mas sobrescrito en Java");
        System.out.println("  - System.out.println(objeto) llama a toString()");
        System.out.println("  - Object -> Persona -> Estudiante/Profesor");
        System.out.println("  - Sobrecarga != Sobrescritura (distintos parametros)");
    }
}
