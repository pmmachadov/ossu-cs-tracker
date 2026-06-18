import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class Video_6_17_EjercicioFinalHerencia {

    public static final String TITULO = "6-17 JAVA: Ejercicio Final Herencia DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=N_h8K_-roRM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=138";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 6-17 - EJERCICIO FINAL HERENCIA
        ================================================================

        Video:        6-17 JAVA: Ejercicio Final Herencia
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6

        --- RESUMEN (transcripcion) ---

        Refactorizacion de la App Sucursal Bancaria usando herencia.
        Clase Cuenta pasa a ser abstracta con tres subclases.

        --- 1. CLASE CUENTA -> ABSTRACT ---

        Se declara public abstract class Cuenta.
        Atributos: numeroCuenta, saldo, titular, movimientos -> todos PROTECTED.
        Metodo verDatos() -> ABSTRACT (cada subclase implementa su formato).
        Metodos ingreso() y retiro() se dejaran como abstractos en el
        siguiente video (excepciones).

        --- 2. TRES SUBCLASES ---

        a) CuentaCorriente:
           - Constructor: super(numCuenta, 0, titular) -> SALDO INICIAL = 0
           - toString(): "Cuenta Corriente " + super.toString()

        b) CuentaVivienda:
           - Constructor: super(numCuenta, 1000, titular) -> SALDO INICIAL = 1000
           - toString(): "Cuenta Vivienda " + super.toString()

        c) FondoInversion:
           - Atributo adicional: private double interes
           - Constructor: super(numCuenta, 5000, titular) -> SALDO INICIAL = 5000
           - Metodo privado calcularInteres():
               if (saldo >= 100000) -> 5%
               else if (saldo >= 50000) -> 4%
               else -> 2%
           - toString(): "Fondo Inversion " + super.toString()

        --- 3. METODOS ABSTRACTOS ---

        public abstract void verDatos()  (implementado en cada subclase)
        public abstract void ingreso()   (pendiente, proximo video)
        public abstract void retiro()    (pendiente, proximo video)

        --- 4. MODIFICACIONES EN AppSucursalBancaria ---

        - Al crear cuenta se pregunta el tipo
        - Nuevo metodo: validarCuenta(Cliente) -> Cuenta
        - Menu tipo: 1. Corriente, 2. Vivienda, 3. Fondo Inversion
        - Switch con return en cada caso

        --- 5. TOSTRING POR SUBCLASE ---

        Cada subclase antepone su tipo: "Cuenta Corriente [1 - Pepe]"

        --- CONCEPTOS CLAVE ---

        - Clase abstracta: no instanciable, sirve como tipo comun
        - Polimorfismo: Cuenta c = new FondoInversion(...)
        - Protected visible para subclases
        - super() llama al constructor padre
        - Orden de condiciones en calcularInteres: de mayor a menor
        - Saldo inicial segun tipo: 0 / 1000 / 5000
        ================================================================
        """;

    // ================================================================
    // VARIABLES ESTATICAS
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
    // CLASE CUENTA -> AHORA ABSTRACTA
    // ================================================================
    static abstract class Cuenta {
        protected int numeroCuenta;
        protected double saldo;
        protected Cliente titular;
        protected ArrayList<Movimiento> movimientos;

        Cuenta(int numeroCuenta, double saldo, Cliente titular) {
            this.numeroCuenta = numeroCuenta;
            this.saldo = saldo;
            this.titular = titular;
            this.movimientos = new ArrayList<>();
        }

        int getNumeroCuenta() { return numeroCuenta; }
        double getSaldo() { return saldo; }
        Cliente getTitular() { return titular; }
        protected String getMovimientos() {
            StringBuilder sb = new StringBuilder();
            for (Movimiento m : movimientos)
                sb.append("\n    ").append(m);
            return sb.toString();
        }

        void ingresar(double cantidad) {
            if (cantidad <= 0) {
                System.out.println("  ERROR: No se puede ingresar una cantidad negativa");
                return;
            }
            saldo += cantidad;
            movimientos.add(new Movimiento(LocalDateTime.now(), cantidad, saldo, (byte) 1));
            System.out.println("  Se han ingresado " + cantidad + " euros en la cuenta " + numeroCuenta);
        }

        void retirar(double cantidad) {
            if (cantidad <= 0) {
                System.out.println("  ERROR: No se puede retirar una cantidad negativa");
                return;
            }
            if (saldo < cantidad) {
                System.out.println("  ERROR: No hay suficiente saldo en cuenta " + numeroCuenta);
                return;
            }
            saldo -= cantidad;
            movimientos.add(new Movimiento(LocalDateTime.now(), cantidad, saldo, (byte) 0));
            System.out.println("  Se han retirado " + cantidad + " euros de la cuenta " + numeroCuenta);
        }

        // METODO ABSTRACTO: cada subclase implementa su propio formato
        public abstract void verDatos();

        public String toString() {
            return "[" + numeroCuenta + " - " + titular.nombreCompleto() + "]";
        }

        // ================================================================
        // CLASE INTERNA MOVIMIENTO
        // ================================================================
        static class Movimiento {
            private LocalDateTime fechaHora;
            private double importe;
            private double saldoFinal;
            private byte tipo; // 1 = ingreso, 0 = retiro

            Movimiento(LocalDateTime fechaHora, double importe, double saldoFinal, byte tipo) {
                this.fechaHora = fechaHora;
                this.importe = importe;
                this.saldoFinal = saldoFinal;
                this.tipo = tipo;
            }

            public String toString() {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String tipoStr = (tipo == 1) ? "INGRESO" : "RETIRO";
                return "[" + dtf.format(fechaHora) + "] " + tipoStr
                    + " - Importe: " + importe + " - Saldo final: " + saldoFinal;
            }
        }
    }

    // ================================================================
    // CUENTA CORRIENTE (saldo inicial = 0)
    // ================================================================
    static class CuentaCorriente extends Cuenta {
        CuentaCorriente(int numeroCuenta, Cliente titular) {
            super(numeroCuenta, 0, titular);
        }

        public void verDatos() {
            System.out.println("========================================");
            System.out.println("  Numero de cuenta: " + numeroCuenta + " - Cuenta Corriente");
            System.out.println("  Titular: " + titular.nombreCompleto());
            System.out.println("  Domicilio: " + titular.direccionCompleta());
            System.out.println("  Saldo actual: " + saldo + " euros");
            System.out.println("  Movimientos:" + getMovimientos());
            System.out.println("========================================");
        }

        public String toString() {
            return "Cuenta Corriente " + super.toString();
        }
    }

    // ================================================================
    // CUENTA VIVIENDA (saldo inicial = 1000)
    // ================================================================
    static class CuentaVivienda extends Cuenta {
        CuentaVivienda(int numeroCuenta, Cliente titular) {
            super(numeroCuenta, 1000, titular);
        }

        public void verDatos() {
            System.out.println("========================================");
            System.out.println("  Numero de cuenta: " + numeroCuenta + " - Cuenta Vivienda");
            System.out.println("  Titular: " + titular.nombreCompleto());
            System.out.println("  Domicilio: " + titular.direccionCompleta());
            System.out.println("  Saldo actual: " + saldo + " euros");
            System.out.println("  Movimientos:" + getMovimientos());
            System.out.println("========================================");
        }

        public String toString() {
            return "Cuenta Vivienda " + super.toString();
        }
    }

    // ================================================================
    // FONDO DE INVERSION (saldo inicial = 5000, con interes)
    // ================================================================
    static class FondoInversion extends Cuenta {
        private double interes;

        FondoInversion(int numeroCuenta, Cliente titular) {
            super(numeroCuenta, 5000, titular);
            calcularInteres();
        }

        double getInteres() { return interes; }

        private void calcularInteres() {
            if (saldo >= 100000)
                interes = 5;
            else if (saldo >= 50000)
                interes = 4;
            else
                interes = 2;
        }

        public void verDatos() {
            System.out.println("========================================");
            System.out.println("  Numero de cuenta: " + numeroCuenta + " - Fondo de Inversion");
            System.out.println("  Titular: " + titular.nombreCompleto());
            System.out.println("  Domicilio: " + titular.direccionCompleta());
            System.out.println("  Saldo actual: " + saldo + " euros");
            System.out.println("  Interes anual: " + interes + "%");
            System.out.println("  Movimientos:" + getMovimientos());
            System.out.println("========================================");
        }

        public String toString() {
            return "Fondo Inversion " + super.toString();
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = Integer.parseInt(entrada.nextLine());
            switch (opcion) {
                case 1: crearCliente(); break;
                case 2: crearCuenta(); break;
                case 3: seleccionarCuenta(); break;
                case 4: System.out.println("  Saliendo del programa..."); break;
                default: System.out.println("  Opcion no valida");
            }
        } while (opcion != 4);
    }

    // ================================================================
    // MENU PRINCIPAL
    // ================================================================
    static void mostrarMenuPrincipal() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("  MENU PRINCIPAL - SUCURSAL BANCARIA");
        System.out.println("========================================");
        System.out.println("  1. Crear cliente");
        System.out.println("  2. Crear cuenta");
        System.out.println("  3. Mantenimiento de cuenta");
        System.out.println("  4. Salir");
        System.out.println("========================================");
        System.out.print("  Seleccione una opcion: ");
    }

    // ================================================================
    // OPCION 1: Crear cliente
    // ================================================================
    static void crearCliente() {
        System.out.print("  Dime el nombre del cliente: ");
        String nombre = entrada.nextLine();
        System.out.print("  Dime los apellidos del cliente: ");
        String apellidos = entrada.nextLine();
        System.out.print("  Dime la direccion del cliente: ");
        String direccion = entrada.nextLine();
        System.out.print("  Dime la ciudad de residencia: ");
        String ciudad = entrada.nextLine();
        System.out.print("  Dime la fecha de nacimiento (aaaa-MM-dd): ");
        String fechaStr = entrada.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr);

        clientes.add(new Cliente(nombre, apellidos, direccion, ciudad, fecha));
        System.out.println("  Cliente " + nombre + " " + apellidos + " se ha creado correctamente");
    }

    // ================================================================
    // OPCION 2: Crear cuenta (AHORA CON SELECCION DE TIPO)
    // ================================================================
    static void crearCuenta() {
        if (clientes.isEmpty()) {
            System.out.println("  ERROR: No hay clientes en la sucursal. Primero debes crear uno");
            return;
        }

        // 1. Obtener cliente valido
        Cliente cliente = validarCliente();

        // 2. Obtener cuenta del tipo seleccionado
        Cuenta cuenta = validarTipoCuenta(cliente);

        // 3. Anyadir la cuenta a la lista
        cuentas.add(cuenta);
        System.out.println("  La cuenta a nombre de " + cliente.nombreCompleto()
            + " se ha creado correctamente");
    }

    static Cliente validarCliente() {
        String nombre;
        Cliente cliente;
        do {
            System.out.println("  Dime el nombre del cliente que quiere abrir una cuenta:");
            for (Cliente c : clientes)
                System.out.println("    " + c.getNombre());
            System.out.print("  Nombre: ");
            nombre = entrada.nextLine();
            cliente = null;
            for (Cliente c : clientes) {
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    cliente = c;
                    break;
                }
            }
            if (cliente == null)
                System.out.println("  ERROR: No existe un cliente con ese nombre");
        } while (cliente == null);
        return cliente;
    }

    static Cuenta validarTipoCuenta(Cliente cliente) {
        while (true) {
            System.out.println("  Que tipo de cuenta quieres crear?");
            System.out.println("    1. Cuenta Corriente");
            System.out.println("    2. Cuenta Vivienda");
            System.out.println("    3. Fondo de Inversion");
            System.out.print("  Opcion: ");
            int opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1:
                    return new CuentaCorriente(contadorCuentas++, cliente);
                case 2:
                    return new CuentaVivienda(contadorCuentas++, cliente);
                case 3:
                    return new FondoInversion(contadorCuentas++, cliente);
                default:
                    System.out.println("  Opcion no valida. Elige 1, 2 o 3");
            }
        }
    }

    // ================================================================
    // OPCION 3: Mantenimiento de cuenta
    // ================================================================
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
                case 3:
                    System.out.println();
                    cuentaActiva.verDatos();
                    break;
                case 4:
                    System.out.println("  Volviendo al menu principal");
                    break;
                default:
                    System.out.println("  Opcion no valida");
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
