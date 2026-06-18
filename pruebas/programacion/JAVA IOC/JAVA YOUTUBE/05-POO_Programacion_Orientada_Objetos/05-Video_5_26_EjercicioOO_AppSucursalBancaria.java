import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class Video_5_26_EjercicioOO_AppSucursalBancaria {

    public static final String TITULO = "5-26 JAVA: Ejercicios OO - App Sucursal Bancaria DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=dNh6j0zs6J8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=119";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 5";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        "RESUMEN RAPIDO - APP SUCURSAL BANCARIA (TEMA 5 - V26)\n"
        + "====================================================\n\n"
        + "MENU PRINCIPAL:\n"
        + "1. Crear cliente    2. Crear cuenta\n"
        + "3. Mantenimiento    4. Salir\n\n"
        + "SUBMENU DE CUENTA:\n"
        + "1. Ingresar dinero    2. Retirar dinero\n"
        + "3. Ver datos          4. Volver al menu principal\n\n"
        + "VALIDACIONES:\n"
        + "- No se pueden crear cuentas sin clientes\n"
        + "- No se puede hacer mantenimiento sin cuentas\n"
        + "- Para crear cuenta se selecciona cliente por nombre\n"
        + "- Para mantenimiento se selecciona cuenta por numero\n"
        + "- El nombre del cliente debe coincidir exactamente\n"
        + "- El numero de cuenta debe existir\n\n"
        + "FLUJO TIPICO:\n"
        + "1. Crear clientes   2. Crear cuentas asignando a clientes\n"
        + "3. Seleccionar cuenta -> submenu\n"
        + "4. Ingresar/retirar/ver datos\n"
        + "5. Volver -> Salir";

    // ================================================================
    // VARIABLES ESTATICAS (compartidas por todos los metodos)
    // ================================================================
    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Cuenta> cuentas = new ArrayList<>();
    static Cuenta cuentaActiva = null;
    static int contadorCuentas = 1;

    // ================================================================
    // CLASE CLIENTE
    // ================================================================
    static class Cliente {
        private String nombre, apellidos, direccion, localidad;
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
        String nombreCompleto() { return nombre + " " + apellidos; }
        String direccionCompleta() { return direccion + ", " + localidad; }
    }

    // ================================================================
    // CLASE CUENTA (con clase interna Movimiento)
    // ================================================================
    static class Cuenta {
        private int numeroCuenta;
        private double saldo;
        private Cliente titular;
        private ArrayList<Movimiento> movimientos;

        Cuenta(int numeroCuenta, double saldo, Cliente titular) {
            this.numeroCuenta = numeroCuenta;
            this.saldo = saldo;
            this.titular = titular;
            this.movimientos = new ArrayList<>();
        }

        int getNumeroCuenta() { return numeroCuenta; }

        void ingresar(double cantidad) {
            if (cantidad <= 0) {
                System.out.println("  ERROR: No se puede ingresar una cantidad negativa");
                return;
            }
            saldo += cantidad;
            movimientos.add(new Movimiento(LocalDateTime.now(), cantidad, Movimiento.INGRESO));
            System.out.println("  Se han ingresado " + cantidad + " euros en la cuenta " + numeroCuenta);
        }

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
            movimientos.add(new Movimiento(LocalDateTime.now(), cantidad, Movimiento.RETIRO));
            System.out.println("  Se han retirado " + cantidad + " euros de la cuenta " + numeroCuenta);
        }

        String obtenerMovimientos() {
            StringBuilder s = new StringBuilder();
            for (Movimiento m : movimientos) {
                s.append("    ").append(m.toString()).append("\n");
            }
            return s.toString();
        }

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
                + ", titular=" + titular.nombreCompleto() + "}";
        }

        // ---- CLASE INTERNA MOVIMIENTO ----
        private class Movimiento {
            static final byte INGRESO = 0;
            static final byte RETIRO = 1;

            private LocalDateTime fechaHora;
            private double importe;
            private double saldoFinal;
            private byte tipo;

            Movimiento(LocalDateTime fechaHora, double importe, byte tipo) {
                this.fechaHora = fechaHora;
                this.importe = importe;
                this.tipo = tipo;
                this.saldoFinal = saldo;
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
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 5 - V26: APP SUCURSAL BANCARIA");
        System.out.println("Aplicacion interactiva con dos menues");
        System.out.println();

        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1: crearCliente(); break;
                case 2: crearCuenta(); break;
                case 3: seleccionarCuenta(); break;
                case 4: System.out.println("  Fin del programa"); break;
                default: System.out.println("  Opcion no valida. Selecciona una opcion entre 1 y 4");
            }
        } while (opcion != 4);

        entrada.close();
    }

    // ---- MENU PRINCIPAL ----
    static void mostrarMenuPrincipal() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("  SUCURSAL BANCARIA - MENU PRINCIPAL");
        System.out.println("========================================");
        System.out.println("  1. Crear cliente");
        System.out.println("  2. Crear cuenta");
        System.out.println("  3. Mantenimiento de cuenta");
        System.out.println("  4. Salir");
        System.out.println("========================================");
        System.out.print("  Seleccione una opcion: ");
    }

    // ---- OPCION 1: Crear cliente ----
    static void crearCliente() {
        System.out.print("  Dime el nombre del cliente: ");
        String nombre = entrada.nextLine();
        System.out.print("  Dime los apellidos: ");
        String apellidos = entrada.nextLine();
        System.out.print("  Dime la direccion: ");
        String direccion = entrada.nextLine();
        System.out.print("  Dime la ciudad de residencia: ");
        String ciudad = entrada.nextLine();
        System.out.print("  Dime la fecha de nacimiento (aaaa-MM-dd): ");
        String fechaStr = entrada.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr);

        clientes.add(new Cliente(nombre, apellidos, direccion, ciudad, fecha));
        System.out.println("  Cliente " + nombre + " " + apellidos + " se ha creado correctamente");
    }

    // ---- OPCION 2: Crear cuenta ----
    static void crearCuenta() {
        if (clientes.isEmpty()) {
            System.out.println("  ERROR: No hay clientes en la sucursal. Primero debes crear uno");
            return;
        }

        String nombre;
        Cliente cliente;
        do {
            System.out.println("  Dime el nombre del cliente que quiere abrir una cuenta:");
            for (Cliente c : clientes)
                System.out.println("    " + c.getNombre());
            System.out.print("  Nombre: ");
            nombre = entrada.nextLine();
            cliente = validarCliente(nombre);
            if (cliente == null)
                System.out.println("  ERROR: No existe un cliente con ese nombre");
        } while (cliente == null);

        cuentas.add(new Cuenta(contadorCuentas++, 0, cliente));
        System.out.println("  La cuenta a nombre de " + cliente.nombreCompleto()
            + " se ha creado correctamente");
    }

    static Cliente validarCliente(String nombre) {
        for (Cliente c : clientes)
            if (c.getNombre().equalsIgnoreCase(nombre)) return c;
        return null;
    }

    // ---- OPCION 3: Mantenimiento de cuenta ----
    static void seleccionarCuenta() {
        if (cuentas.isEmpty()) {
            System.out.println("  ERROR: No hay ninguna cuenta en la sucursal. Primero debes crear alguna");
            return;
        }

        int numCuenta;
        do {
            System.out.println("  Selecciona un numero de cuenta:");
            for (Cuenta c : cuentas)
                System.out.println("    " + c);
            System.out.print("  Numero de cuenta: ");
            numCuenta = Integer.parseInt(entrada.nextLine());
        } while (!validarCuenta(numCuenta));

        seleccionarOpcionCuenta();
    }

    static boolean validarCuenta(int numCuenta) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta() == numCuenta) {
                cuentaActiva = c;
                return true;
            }
        }
        System.out.println("  ERROR: No existe ninguna cuenta con ese numero");
        return false;
    }

    // ---- SUBMENU DE CUENTA ----
    static void seleccionarOpcionCuenta() {
        int opcionCuenta;
        do {
            mostrarMenuCuenta();
            opcionCuenta = Integer.parseInt(entrada.nextLine());
            switch (opcionCuenta) {
                case 1: ingresar(); break;
                case 2: retirar(); break;
                case 3: System.out.println(); cuentaActiva.verDatos(); break;
                case 4: System.out.println("  Volviendo al menu principal"); break;
                default: System.out.println("  Opcion no valida");
            }
        } while (opcionCuenta != 4);
    }

    static void mostrarMenuCuenta() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("  MENU DE CUENTA - " + cuentaActiva.getNumeroCuenta());
        System.out.println("========================================");
        System.out.println("  1. Ingresar dinero");
        System.out.println("  2. Retirar dinero");
        System.out.println("  3. Ver datos de la cuenta");
        System.out.println("  4. Volver al menu principal");
        System.out.println("========================================");
        System.out.print("  Seleccione una opcion: ");
    }

    static void ingresar() {
        System.out.print("  Cantidad a ingresar: ");
        double cantidad = Double.parseDouble(entrada.nextLine());
        cuentaActiva.ingresar(cantidad);
    }

    static void retirar() {
        System.out.print("  Cantidad a retirar: ");
        double cantidad = Double.parseDouble(entrada.nextLine());
        cuentaActiva.retirar(cantidad);
    }
}
