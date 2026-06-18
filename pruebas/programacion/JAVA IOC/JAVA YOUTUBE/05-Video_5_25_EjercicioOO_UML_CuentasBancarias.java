import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Video_5_25_EjercicioOO_UML_CuentasBancarias {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-25 JAVA: Ejercicios OO + UML - Cuentas bancarias DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=NJs-Jss3ZBs&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=118";
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
          RESUMEN RAPIDO - UML + CUENTAS BANCARIAS (TEMA 5 - V25)
        ====================================================================

        --- UML: DIAGRAMA DE CLASES ---
        Cliente (sin referencia a Cuenta):
          - nombre, apellidos, direccion, localidad, fechaNacimiento
          - nombreCompleto(), direccionCompleta()

        Cuenta (asociacion 1 -> Cliente):
          - numeroCuenta, saldo, titular (Cliente)
          - movimientos (ArrayList<Movimiento>)  <<composicion>>
          - ingresar(), retirar(), verDatos()

        Movimiento (clase INTERNA privada de Cuenta):
          - fechaHora (LocalDateTime), importe, saldoFinal, tipo
          - INGRESO (0), RETIRO (1)  (constantes static final byte)

        --- RELACIONES UML ---
        Cuenta -- 1 --> Cliente  (asociacion, navegabilidad hacia Cliente)
        Cuenta <>-- * --> Movimiento  (composicion, rombo negro)

        --- CLASE INTERNA PRIVADA ---
        - La clase Movimiento se declara DENTRO de Cuenta, como PRIVATE.
        - Solo Cuenta puede crear instancias de Movimiento.
        - Movimiento puede acceder a los atributos de Cuenta (ej: saldo).
        - Esto garantiza la composicion: movimiento sin cuenta no existe.

        --- METODOS ingreso() y retiro() ---
        - Comprueban que cantidad > 0.
        - retiro() ademas comprueba saldo suficiente.
        - Si es valido, modifican saldo y anaden un nuevo Movimiento.
        - El constructor de Movimiento NO recibe el saldo final,
          lo obtiene directamente de Cuenta.saldo (clase interna).

        --- LOCALDATE Y LOCALDATETIME ---
        - LocalDate.of(agno, mes, dia) -> crear una fecha
        - LocalDateTime.now() -> fecha y hora actual
        - DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM) -> formato

        ====================================================================
        """;

    // ================================================================
    // CLASE CLIENTE
    // ================================================================
    static class Cliente {
        private String nombre;
        private String apellidos;
        private String direccion;
        private String localidad;
        private LocalDate fechaNacimiento;

        Cliente(String nombre, String apellidos, String direccion,
                String localidad, LocalDate fechaNacimiento) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.direccion = direccion;
            this.localidad = localidad;
            this.fechaNacimiento = fechaNacimiento;
        }

        String getNombre() { return nombre; }
        String getApellidos() { return apellidos; }
        String getDireccion() { return direccion; }
        String getLocalidad() { return localidad; }
        LocalDate getFechaNacimiento() { return fechaNacimiento; }

        String nombreCompleto() {
            return nombre + " " + apellidos;
        }

        String direccionCompleta() {
            return direccion + ", " + localidad;
        }
    }

    // ================================================================
    // CLASE CUENTA (con clase interna Movimiento)
    // ================================================================
    static class Cuenta {
        private int numeroCuenta;
        private double saldo;
        private Cliente titular;
        private ArrayList<Movimiento> movimientos;

        // Constructor
        Cuenta(int numeroCuenta, double saldo, Cliente titular) {
            this.numeroCuenta = numeroCuenta;
            this.saldo = saldo;
            this.titular = titular;
            this.movimientos = new ArrayList<>();
        }

        // Getters
        int getNumeroCuenta() { return numeroCuenta; }
        double getSaldo() { return saldo; }
        Cliente getTitular() { return titular; }

        // Ingresar dinero
        void ingresar(double cantidad) {
            if (cantidad <= 0) {
                System.out.println("  ERROR: No se puede ingresar una cantidad negativa");
                return;
            }
            saldo += cantidad;
            movimientos.add(new Movimiento(LocalDateTime.now(),
                cantidad, Movimiento.INGRESO));
            System.out.println("  Ingresados " + cantidad + " euros en cuenta " + numeroCuenta);
        }

        // Retirar dinero
        void retirar(double cantidad) {
            if (cantidad <= 0) {
                System.out.println("  ERROR: No se puede retirar una cantidad negativa");
                return;
            }
            if (cantidad > saldo) {
                System.out.println("  ERROR: No hay suficiente saldo en cuenta " + numeroCuenta);
                return;
            }
            saldo -= cantidad;
            movimientos.add(new Movimiento(LocalDateTime.now(),
                cantidad, Movimiento.RETIRO));
            System.out.println("  Retirados " + cantidad + " euros de cuenta " + numeroCuenta);
        }

        // Obtener movimientos como String
        String obtenerMovimientos() {
            StringBuilder s = new StringBuilder();
            for (Movimiento m : movimientos) {
                s.append("    ").append(m.toString()).append("\n");
            }
            return s.toString();
        }

        // Ver datos completos
        void verDatos() {
            System.out.println("  Numero de cuenta: " + numeroCuenta);
            System.out.println("  Titular: " + titular.nombreCompleto()
                + ", domicilio en " + titular.direccionCompleta());
            System.out.println("  Saldo actual: " + saldo + " euros");
            if (!movimientos.isEmpty()) {
                System.out.println("  Movimientos:\n" + obtenerMovimientos());
            }
        }

        public String toString() {
            return "Cuenta{numero=" + numeroCuenta
                + ", titular=" + titular.nombreCompleto()
                + ", saldo=" + saldo + "}";
        }

        // ============================================================
        // CLASE INTERNA PRIVADA: Movimiento
        // ============================================================
        private class Movimiento {
            // Constantes estaticas para el tipo
            static final byte INGRESO = 0;
            static final byte RETIRO = 1;

            private LocalDateTime fechaHora;
            private double importe;
            private double saldoFinal;
            private byte tipo;

            // Constructor: NO recibe saldoFinal, lo obtiene de Cuenta.saldo
            Movimiento(LocalDateTime fechaHora, double importe, byte tipo) {
                this.fechaHora = fechaHora;
                this.importe = importe;
                this.tipo = tipo;
                this.saldoFinal = saldo;  // Accede al saldo de Cuenta!
            }

            public String toString() {
                String tipoStr = (tipo == INGRESO) ? "INGRESO" : "RETIRO";
                DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDateTime(
                    java.time.format.FormatStyle.MEDIUM);
                return tipoStr + " | " + fechaHora.format(fmt)
                    + " | Importe: " + importe
                    + " | Saldo final: " + saldoFinal;
            }
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
        System.out.println("TEMA 5 - V25: UML + CUENTAS BANCARIAS");
        System.out.println();

        // ============================================================
        // Crear clientes
        // ============================================================
        separador("CREAR CLIENTES");

        Cliente c1 = new Cliente("Pepe", "Martinez",
            "Calle Estacion 22", "Valencia",
            LocalDate.of(2000, 1, 1));
        Cliente c2 = new Cliente("Marta", "Garcia",
            "Calle Mayor 25", "Madrid",
            LocalDate.of(2002, 2, 2));

        System.out.println("  Cliente 1: " + c1.nombreCompleto());
        System.out.println("  Cliente 2: " + c2.nombreCompleto());
        System.out.println();

        // ============================================================
        // Crear cuentas
        // ============================================================
        separador("CREAR CUENTAS");

        Cuenta cuenta1 = new Cuenta(111, 1000, c1);
        Cuenta cuenta2 = new Cuenta(222, 2000, c2);

        System.out.println("  Cuenta 1: " + cuenta1);
        System.out.println("  Cuenta 2: " + cuenta2);
        System.out.println();

        // ============================================================
        // Operaciones cuenta 1
        // ============================================================
        separador("OPERACIONES CUENTA 1");

        cuenta1.ingresar(100);
        cuenta1.ingresar(500);
        cuenta1.retirar(120);
        System.out.println();

        // ============================================================
        // Operaciones cuenta 2
        // ============================================================
        separador("OPERACIONES CUENTA 2");

        cuenta2.ingresar(1000);
        cuenta2.retirar(4000);  // No debe poder (solo hay 3000)
        cuenta2.retirar(1000);
        System.out.println();

        // ============================================================
        // Ver datos completos
        // ============================================================
        separador("DATOS COMPLETOS DE LAS CUENTAS");

        System.out.println("  --- Cuenta 1 (Pepe Martinez) ---");
        cuenta1.verDatos();
        System.out.println();

        System.out.println("  --- Cuenta 2 (Marta Garcia) ---");
        cuenta2.verDatos();
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V25: UML + CUENTAS BANCARIAS)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS PRACTICADOS:");
        System.out.println("  - Traducir UML a codigo Java");
        System.out.println("  - Asociacion entre clases (Cuenta -> Cliente)");
        System.out.println("  - Composicion (Cuenta contiene Movimientos)");
        System.out.println("  - Clase interna privada (Movimiento)");
        System.out.println("  - LocalDate y LocalDateTime");
        System.out.println("  - Clase interna accede a atributos de la externa");
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
