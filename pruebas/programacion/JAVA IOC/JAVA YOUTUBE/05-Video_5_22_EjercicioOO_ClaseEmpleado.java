class Video_5_22_EjercicioOO_ClaseEmpleado {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-22 JAVA: Ejercicios OO - Clase Empleado DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=Xhe6GA7wa9o&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=115";
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
          RESUMEN RAPIDO - EJERCICIO OO: CLASE EMPLEADO (TEMA 5 - V22)
        ====================================================================

        --- ENUNCIADO ---
        Empresa de informatica que necesita registrar empleados.
        Atributos: nombre (String), permanencia (int, en anos), salario (double)
        Metodos:
        - Constructores: con y sin parametros
        - mostrarClasificacion(): segun permanencia
        - mostrarDatos(): todos los datos del empleado
        - subirSalario(double porcentaje): incrementa el salario

        --- CLASIFICACION SEGUN PERMANENCIA ---
        - Permanencia >= 18 -> Senior
        - Permanencia > 3 y < 18 -> Intermedio
        - Permanencia <= 3 -> Principiante

        --- VALIDACION EN SETTERS ---
        - Permanencia negativa -> pone a 0
        - Salario negativo -> pone a 0
        - Los constructores llaman a los setters (no asignan directamente)
          para reutilizar la logica de validacion.

        --- METODO subirSalario ---
        void subirSalario(double porcentaje) {
            double incremento = salario * porcentaje / 100;
            setSalario(salario + incremento);
        }

        Ejemplo: si salario=2000 y porcentaje=10
          -> incremento = 2000 * 10 / 100 = 200
          -> nuevo salario = 2000 + 200 = 2200

        --- GENERACION AUTOMATICA EN VS CODE ---
        - Click en nombre de clase -> bombilla -> Generate Constructor
        - Click en nombre de clase -> bombilla -> Generate Getters and Setters
        - El IDE genera el codigo con this automaticamente.

        ====================================================================
        """;

    // ================================================================
    // CLASE EMPLEADO
    // ================================================================
    static class Empleado {
        // Atributos
        private String nombre;
        private int permanencia;
        private double salario;

        // Constructor vacio
        Empleado() {
            // Valores por defecto: nombre=null, permanencia=0, salario=0.0
        }

        // Constructor con parametros (reutiliza setters)
        Empleado(String nombre, int permanencia, double salario) {
            this.nombre = nombre;
            setPermanencia(permanencia);
            setSalario(salario);
        }

        // GETTERS
        String getNombre() { return nombre; }
        int getPermanencia() { return permanencia; }
        double getSalario() { return salario; }

        // SETTERS (con validacion)
        void setNombre(String nombre) { this.nombre = nombre; }

        void setPermanencia(int permanencia) {
            if (permanencia < 0) {
                this.permanencia = 0;
            } else {
                this.permanencia = permanencia;
            }
        }

        void setSalario(double salario) {
            if (salario < 0) {
                this.salario = 0;
            } else {
                this.salario = salario;
            }
        }

        // ---- METODOS DEL EJERCICIO ----

        // Mostrar clasificacion segun permanencia
        void mostrarClasificacion() {
            System.out.print("  El empleado " + nombre + " es ");
            if (permanencia >= 18) {
                System.out.println("Senior");
            } else if (permanencia > 3) {
                System.out.println("Intermedio");
            } else {
                System.out.println("Principiante");
            }
        }

        // Mostrar todos los datos
        void mostrarDatos() {
            System.out.println("  Nombre: " + nombre);
            System.out.println("  Permanencia: " + permanencia + " anos");
            System.out.println("  Salario: " + salario + " euros");
        }

        // Subir salario en un porcentaje
        void subirSalario(double porcentaje) {
            double incremento = salario * porcentaje / 100;
            setSalario(salario + incremento);
            System.out.println("  Salario de " + nombre
                + " incrementado un " + porcentaje + "% -> nuevo salario: " + salario);
        }
    }

    // ================================================================
    // METODO PRINCIPAL (AppEmpleado)
    // ================================================================
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 5 - V22: EJERCICIO OO - CLASE EMPLEADO");
        System.out.println();

        // ============================================================
        // Crear empleados
        // ============================================================
        separador("CREAR EMPLEADOS");

        Empleado e1 = new Empleado();                       // Constructor vacio
        Empleado e2 = new Empleado("Pep", 19, 2000);       // Senior
        Empleado e3 = new Empleado("Tom", 1, 1000);        // Principiante
        Empleado e4 = new Empleado("John", 5, 1500);       // Intermedio

        System.out.println("  Empleados creados:");
        System.out.println("  e1: (vacio) -> nombre=null, permanencia=0, salario=0");
        System.out.println("  e2: Pep, 19 anos, 2000 euros");
        System.out.println("  e3: Tom, 1 ano, 1000 euros");
        System.out.println("  e4: John, 5 anos, 1500 euros");
        System.out.println();

        // ============================================================
        // Mostrar datos de cada empleado
        // ============================================================
        separador("DATOS DE LOS EMPLEADOS");

        System.out.println("  --- e1 (vacio) ---");
        e1.mostrarDatos();
        System.out.println();

        System.out.println("  --- e2 (Pep) ---");
        e2.mostrarDatos();
        System.out.println();

        System.out.println("  --- e3 (Tom) ---");
        e3.mostrarDatos();
        System.out.println();

        System.out.println("  --- e4 (John) ---");
        e4.mostrarDatos();
        System.out.println();

        // ============================================================
        // Mostrar clasificacion
        // ============================================================
        separador("CLASIFICACION POR PERMANENCIA");

        e1.mostrarClasificacion();
        e2.mostrarClasificacion();
        e3.mostrarClasificacion();
        e4.mostrarClasificacion();
        System.out.println();

        // ============================================================
        // Subir salarios
        // ============================================================
        separador("SUBIR SALARIOS");

        e1.subirSalario(100);   // 0 * 100% = 0 (sigue siendo 0)
        e2.subirSalario(10);    // 2000 + 10% = 2200
        e3.subirSalario(20);    // 1000 + 20% = 1200
        e4.subirSalario(50);    // 1500 + 50% = 2250
        System.out.println();

        // ============================================================
        // Mostrar datos finales
        // ============================================================
        separador("DATOS FINALES TRAS SUBIR SALARIOS");

        System.out.println("  --- e1 (vacio, 100%) ---");
        e1.mostrarDatos();
        System.out.println();

        System.out.println("  --- e2 (Pep, +10%) ---");
        e2.mostrarDatos();
        System.out.println();

        System.out.println("  --- e3 (Tom, +20%) ---");
        e3.mostrarDatos();
        System.out.println();

        System.out.println("  --- e4 (John, +50%) ---");
        e4.mostrarDatos();
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V22: EJERCICIO OO EMPLEADO)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS PRACTICADOS:");
        System.out.println("  - Creacion de clase con atributos privados");
        System.out.println("  - Constructores (vacio y con parametros)");
        System.out.println("  - Getters y setters con validacion");
        System.out.println("  - Metodos de instancia (mostrarClasificacion, subirSalario)");
        System.out.println("  - Reutilizar setters en el constructor");
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
