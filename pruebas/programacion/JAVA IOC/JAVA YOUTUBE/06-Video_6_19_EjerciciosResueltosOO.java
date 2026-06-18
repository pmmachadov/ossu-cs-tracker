import java.util.ArrayList;

class Video_6_19_EjerciciosResueltosOO {

    public static final String TITULO = "6-19 JAVA: Ejercicios resueltos OO DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=RZG7SQOZn3w&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=140";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - EJERCICIOS RESUELTOS OO (TEMA 6 - V19)\n"
        + "=========================================================\n\n"
        + "PRACTICA 1: SISTEMA DE GESTION DE NOMINAS\n"
        + "=========================================================\n\n"
        + "JERARQUIA DE CLASES:\n"
        + "  Trabajador (abstracta)\n"
        + "    - Atributos: dni, nombre, salarioBase\n"
        + "    - Metodo abstracto: calcularSalarioFinal()\n"
        + "    |\n"
        + "    +-- Informatico (abstracta)\n"
        + "    |     - Atributo adicional: titulacion\n"
        + "    |     |\n"
        + "    |     +-- Analista\n"
        + "    |     |     - calcularSalarioFinal(): salarioBase + salarioBase * 0.30\n"
        + "    |     |     - toString(): \"Analista: [dni - nombre - salarioBase - salarioFinal]\"\n"
        + "    |     |\n"
        + "    |     +-- Programador\n"
        + "    |           - calcularSalarioFinal(): salarioBase + salarioBase * 0.15\n"
        + "    |           - toString(): \"Programador: [dni - nombre - salarioBase - salarioFinal]\"\n"
        + "    |\n"
        + "    +-- Gestion (abstracta)\n"
        + "          - Atributo adicional: antiguedad (anyos)\n"
        + "          |\n"
        + "          +-- Administrativo\n"
        + "          |     - calcularSalarioFinal(): salarioBase + antiguedad * 20\n"
        + "          |     - toString(): \"Administrativo: [dni - nombre - salarioBase - salarioFinal]\"\n"
        + "          |\n"
        + "          +-- Auxiliar\n"
        + "                - calcularSalarioFinal(): salarioBase + 100\n"
        + "                - toString(): \"Auxiliar: [dni - nombre - salarioBase - salarioFinal]\"\n\n"
        + "CLASE EMPRESA:\n"
        + "  - Atributos: cif, nombre, trabajadores (ArrayList<Trabajador>)\n"
        + "  - Constructor: recibe cif y nombre, inicializa lista vacia\n"
        + "  - Metodo: addTrabajador(Trabajador t)\n"
        + "  - Getters: getCif(), getNombre(), getTrabajadores()\n\n"
        + "MAIN (prueba):\n"
        + "  - Crear empresa con cif y nombre\n"
        + "  - Anyadir 2 trabajadores de cada tipo (Analista, Programador, Administrativo, Auxiliar)\n"
        + "  - Recorrer con for-each y toString() -> polimorfismo\n"
        + "  - Cada trabajador muestra su tipo y salario final calculado segun su clase\n\n"
        + "=========================================================\n"
        + "PRACTICA 2: SISTEMA DE GESTION DE EMPLEADOS\n"
        + "=========================================================\n\n"
        + "CLASE EMPLEADO (abstracta):\n"
        + "  - Atributos: nombre, apellidos, dni, salario\n"
        + "  - Metodo abstracto: calcularSalario()\n"
        + "  - toString(): muestra nombre + apellidos + dni\n\n"
        + "CLASES DERIVADAS:\n"
        + "  EmpleadoPorHoras:\n"
        + "    - Atributos: horasTrabajadas, tarifaPorHora\n"
        + "    - calcularSalario(): horasTrabajadas * tarifaPorHora\n"
        + "    - toString(): super.toString() + \" Salario: \" + calcularSalario()\n\n"
        + "  EmpleadoFijo:\n"
        + "    - Atributo: salarioMensual\n"
        + "    - calcularSalario(): return salario (o return salarioMensual)\n"
        + "    - toString(): super.toString() + \" Salario: \" + calcularSalario()\n\n"
        + "CLASE EMPRESA:\n"
        + "  - Atributos: empleados (ArrayList<Empleado>)\n"
        + "  - Metodo: agregarEmpleado(Empleado e)\n"
        + "  - Metodo: eliminarEmpleado(String dni) throws EmpleadoNoEncontradoException\n"
        + "    - Recorre la lista con for-each\n"
        + "    - Si encuentra el dni -> remueve y return\n"
        + "    - Si termina el bucle sin encontrar -> lanza excepcion\n\n"
        + "EXCEPCION PERSONALIZADA:\n"
        + "  EmpleadoNoEncontradoException extends Exception\n"
        + "  - Constructor: recibe String mensaje, llama a super(mensaje)\n"
        + "  - Uso: throw new EmpleadoNoEncontradoException(\"Error al eliminar: empleado con dni \" + dni + \" no encontrado\")\n\n"
        + "MAIN (prueba):\n"
        + "  - Crear empresa, anyadir empleados de ambos tipos\n"
        + "  - Mostrar lista inicial\n"
        + "  - Intentar eliminar empleados existentes y no existentes\n"
        + "  - Capturar EmpleadoNoEncontradoException con try-catch\n"
        + "  - Mostrar lista final para comprobar resultado\n\n"
        + "CONCEPTOS CLAVE:\n"
        + "- Herencia multiple en cadena: Trabajador -> Informatico -> Analista/Programador\n"
        + "- Clases abstractas intermedias (Informatico y Gestion son abstractas)\n"
        + "- Polimorfismo: for-each sobre Trabajador, cada uno ejecuta su toString()\n"
        + "- Metodo abstracto calcularSalarioFinal() implementado en cada hoja\n"
        + "- Excepcion personalizada con mensaje descriptivo\n"
        + "- Cada operacion de eliminacion debe ir en su propio try-catch\n"
        + "- Opcional: se puede eliminar el atributo salario y calcularlo en super()\n";

    // ================================================================
    // PRACTICA 1: SISTEMA DE GESTION DE NOMINAS
    // ================================================================

    // ---- TRABAJADOR (abstracta) ----
    static abstract class Trabajador {
        protected String dni;
        protected String nombre;
        protected double salarioBase;

        Trabajador(String dni, String nombre, double salarioBase) {
            this.dni = dni;
            this.nombre = nombre;
            this.salarioBase = salarioBase;
        }

        public abstract double calcularSalarioFinal();
    }

    // ---- INFORMATICO (abstracta) ----
    static abstract class Informatico extends Trabajador {
        protected String titulacion;

        Informatico(String dni, String nombre, double salarioBase, String titulacion) {
            super(dni, nombre, salarioBase);
            this.titulacion = titulacion;
        }
    }

    // ---- ANALISTA (herencia: Trabajador -> Informatico -> Analista) ----
    static class Analista extends Informatico {
        Analista(String dni, String nombre, double salarioBase, String titulacion) {
            super(dni, nombre, salarioBase, titulacion);
        }

        public double calcularSalarioFinal() {
            return salarioBase + salarioBase * 0.30;
        }

        public String toString() {
            return "Analista: [" + dni + " - " + nombre + " - " + salarioBase
                + " - " + calcularSalarioFinal() + "]";
        }
    }

    // ---- PROGRAMADOR (herencia: Trabajador -> Informatico -> Programador) ----
    static class Programador extends Informatico {
        Programador(String dni, String nombre, double salarioBase, String titulacion) {
            super(dni, nombre, salarioBase, titulacion);
        }

        public double calcularSalarioFinal() {
            return salarioBase + salarioBase * 0.15;
        }

        public String toString() {
            return "Programador: [" + dni + " - " + nombre + " - " + salarioBase
                + " - " + calcularSalarioFinal() + "]";
        }
    }

    // ---- GESTION (abstracta) ----
    static abstract class Gestion extends Trabajador {
        protected int antiguedad;

        Gestion(String dni, String nombre, double salarioBase, int antiguedad) {
            super(dni, nombre, salarioBase);
            this.antiguedad = antiguedad;
        }
    }

    // ---- ADMINISTRATIVO (herencia: Trabajador -> Gestion -> Administrativo) ----
    static class Administrativo extends Gestion {
        Administrativo(String dni, String nombre, double salarioBase, int antiguedad) {
            super(dni, nombre, salarioBase, antiguedad);
        }

        public double calcularSalarioFinal() {
            return salarioBase + antiguedad * 20;
        }

        public String toString() {
            return "Administrativo: [" + dni + " - " + nombre + " - " + salarioBase
                + " - " + calcularSalarioFinal() + "]";
        }
    }

    // ---- AUXILIAR (herencia: Trabajador -> Gestion -> Auxiliar) ----
    static class Auxiliar extends Gestion {
        Auxiliar(String dni, String nombre, double salarioBase, int antiguedad) {
            super(dni, nombre, salarioBase, antiguedad);
        }

        public double calcularSalarioFinal() {
            return salarioBase + 100;
        }

        public String toString() {
            return "Auxiliar: [" + dni + " - " + nombre + " - " + salarioBase
                + " - " + calcularSalarioFinal() + "]";
        }
    }

    // ---- EMPRESA (para nomina) ----
    static class EmpresaNominas {
        private String cif;
        private String nombre;
        private ArrayList<Trabajador> trabajadores;

        EmpresaNominas(String cif, String nombre) {
            this.cif = cif;
            this.nombre = nombre;
            this.trabajadores = new ArrayList<>();
        }

        void addTrabajador(Trabajador t) {
            trabajadores.add(t);
        }

        String getCif() { return cif; }
        String getNombre() { return nombre; }
        ArrayList<Trabajador> getTrabajadores() { return trabajadores; }
    }

    // ================================================================
    // PRACTICA 2: SISTEMA DE GESTION DE EMPLEADOS
    // ================================================================

    // ---- EXCEPCION PERSONALIZADA ----
    static class EmpleadoNoEncontradoException extends Exception {
        EmpleadoNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }

    // ---- EMPLEADO (abstracta) ----
    static abstract class Empleado {
        protected String nombre, apellidos, dni;
        protected double salario;

        Empleado(String nombre, String apellidos, String dni, double salario) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.dni = dni;
            this.salario = salario;
        }

        public abstract double calcularSalario();

        String getDni() { return dni; }

        public String toString() {
            return nombre + " " + apellidos + " - DNI: " + dni;
        }
    }

    // ---- EMPLEADO POR HORAS ----
    static class EmpleadoPorHoras extends Empleado {
        private int horasTrabajadas;
        private double tarifaPorHora;

        EmpleadoPorHoras(String nombre, String apellidos, String dni,
                         double salario, int horasTrabajadas, double tarifaPorHora) {
            super(nombre, apellidos, dni, salario);
            this.horasTrabajadas = horasTrabajadas;
            this.tarifaPorHora = tarifaPorHora;
        }

        // Alternativa: calcular salario en el super
        // EmpleadoPorHoras(...) { super(..., horasTrabajadas * tarifaPorHora); ... }

        public double calcularSalario() {
            // return salario;  // si se calcula en el super
            return horasTrabajadas * tarifaPorHora;
        }

        int getHorasTrabajadas() { return horasTrabajadas; }
        double getTarifaPorHora() { return tarifaPorHora; }

        public String toString() {
            return super.toString() + " - Salario: " + calcularSalario();
        }
    }

    // ---- EMPLEADO FIJO ----
    static class EmpleadoFijo extends Empleado {
        private double salarioMensual;

        EmpleadoFijo(String nombre, String apellidos, String dni,
                     double salario, double salarioMensual) {
            super(nombre, apellidos, dni, salario);
            this.salarioMensual = salarioMensual;
        }

        public double calcularSalario() {
            return salario;  // O return salarioMensual;
        }

        double getSalarioMensual() { return salarioMensual; }

        public String toString() {
            return super.toString() + " - Salario: " + calcularSalario();
        }
    }

    // ---- EMPRESA (para empleados) ----
    static class EmpresaEmpleados {
        private ArrayList<Empleado> empleados;

        EmpresaEmpleados() {
            this.empleados = new ArrayList<>();
        }

        void agregarEmpleado(Empleado e) {
            empleados.add(e);
        }

        void eliminarEmpleado(String dni) throws EmpleadoNoEncontradoException {
            for (Empleado e : empleados) {
                if (e.getDni().equals(dni)) {
                    empleados.remove(e);
                    return;
                }
            }
            throw new EmpleadoNoEncontradoException(
                "Error al eliminar: empleado con dni " + dni + " no encontrado");
        }

        ArrayList<Empleado> getEmpleados() { return empleados; }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V19: EJERCICIOS RESUELTOS OO");
        System.out.println("Practica 1: Sistema de Gestion de Nominas");
        System.out.println("Practica 2: Sistema de Gestion de Empleados");
        System.out.println();

        // ============================================================
        // PRACTICA 1: SISTEMA DE GESTION DE NOMINAS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  PRACTICA 1: SISTEMA DE NOMINAS");
        System.out.println("=========================================");
        System.out.println();

        EmpresaNominas empresa = new EmpresaNominas("B12345678", "Tecnologias SL");

        // Anyadir 2 trabajadores de cada tipo
        empresa.addTrabajador(new Analista("111A", "Ana Lopez", 1500, "Ingenieria Informatica"));
        empresa.addTrabajador(new Analista("222B", "Carlos Ruiz", 1800, "Ingenieria Software"));
        empresa.addTrabajador(new Programador("333C", "Maria Garcia", 1100, "FP Desarrollo Apps"));
        empresa.addTrabajador(new Programador("444D", "Luis Martin", 1200, "FP Desarrollo Web"));
        empresa.addTrabajador(new Administrativo("555E", "Sofia Perez", 1300, 5));
        empresa.addTrabajador(new Administrativo("666F", "Pedro Sanchez", 1250, 3));
        empresa.addTrabajador(new Auxiliar("777G", "Laura Diaz", 1100, 2));
        empresa.addTrabajador(new Auxiliar("888H", "Jorge Fernandez", 1050, 1));

        System.out.println("  Empresa: " + empresa.getNombre() + " (CIF: " + empresa.getCif() + ")");
        System.out.println("  Listado de trabajadores:");
        for (Trabajador t : empresa.getTrabajadores()) {
            System.out.println("    " + t);
        }
        System.out.println();

        // ============================================================
        // PRACTICA 2: SISTEMA DE GESTION DE EMPLEADOS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  PRACTICA 2: SISTEMA DE EMPLEADOS");
        System.out.println("=========================================");
        System.out.println();

        EmpresaEmpleados emp = new EmpresaEmpleados();

        // Anyadir empleados
        emp.agregarEmpleado(new EmpleadoPorHoras("Juan", "Gomez", "111A", 0, 40, 10));
        emp.agregarEmpleado(new EmpleadoFijo("Maria", "Lopez", "222B", 1800, 1800));

        // Mostrar lista inicial
        System.out.println("  Empleados iniciales:");
        for (Empleado e : emp.getEmpleados())
            System.out.println("    " + e);
        System.out.println();

        // Intentar eliminar empleados (con try-catch individual)
        System.out.println("  Intentando eliminar empleado con dni 1111 (no existe)...");
        try {
            emp.eliminarEmpleado("1111");
            System.out.println("    Eliminado correctamente");
        } catch (EmpleadoNoEncontradoException e) {
            System.out.println("    " + e.getMessage());
        }

        System.out.println("  Intentando eliminar empleado con dni 111A (existe)...");
        try {
            emp.eliminarEmpleado("111A");
            System.out.println("    Eliminado correctamente");
        } catch (EmpleadoNoEncontradoException e) {
            System.out.println("    " + e.getMessage());
        }

        // Mostrar lista final
        System.out.println();
        System.out.println("  Empleados tras eliminaciones:");
        for (Empleado e : emp.getEmpleados())
            System.out.println("    " + e);
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("=========================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 6 - V19: EJERCICIOS RESUELTOS OO)");
        System.out.println("=========================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Herencia en cadena: Trabajador -> Informatico -> Analista");
        System.out.println("  - Clases abstractas intermedias (Informatico, Gestion)");
        System.out.println("  - Polimorfismo: for-each con toString() de cada subclase");
        System.out.println("  - Salario final segun tipo de trabajador");
        System.out.println("  - Excepcion personalizada con getMessage()");
        System.out.println("  - Cada eliminacion con su propio try-catch");
        System.out.println("  - Opcion: calcular salario en super() para simplificar");
    }
}
