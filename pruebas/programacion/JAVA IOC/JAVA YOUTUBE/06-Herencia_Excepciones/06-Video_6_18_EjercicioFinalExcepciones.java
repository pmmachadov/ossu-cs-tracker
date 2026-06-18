import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Video_6_18_EjercicioFinalExcepciones {

    public static final String TITULO = "6-18 JAVA: Ejercicio Final Excepciones DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=C5O5_tW6jYw&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=139";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - EJERCICIO FINAL EXCEPCIONES (TEMA 6 - V18)\n"
        + "=========================================================\n\n"
        + "PARTE 2: GESTION DE EXCEPCIONES (continuacion del video anterior)\n\n"
        + "A) VALIDAR CLIENTE REPETIDO:\n"
        + "   - ClienteExisteException extends Exception\n"
        + "   - Atributo: private Cliente cliente\n"
        + "   - toString(): \"El cliente de nombre \" + cliente.getNombre() + \" ya existe\"\n"
        + "   - En validarNombre(): while(true) con for-each sobre clientes\n"
        + "   - Si nombre ya existe -> throw new ClienteExisteException(cliente)\n"
        + "   - try-catch dentro del while para capturar y seguir pidiendo\n\n"
        + "B) VALIDAR FECHA DE NACIMIENTO:\n"
        + "   - Metodo validarFechaNacimiento() -> devuelve LocalDate\n"
        + "   - while(true): try { return LocalDate.parse(entrada.nextLine()); }\n"
        + "   - catch (DateTimeParseException e): mensaje \"Formato de fecha no valido\"\n"
        + "   - Formato: aaaa-MM-dd (4 digitos anyo, 2 mes, 2 dia)\n\n"
        + "C) METODO RETIRO -> ABSTRACT, CON EXCEPCION PERSONALIZADA:\n"
        + "   - RetiroNoValidoException extends Exception\n"
        + "   - Constructor: recibe String mensaje\n"
        + "   - toString(): \"Error: no se ha podido realizar el retiro. \" + mensaje\n"
        + "   - Metodo protegido confirmarRetiro(double): codigo comun (saldo -=, add movimiento)\n"
        + "   - public abstract void retiro(double cantidad) throws RetiroNoValidoException\n\n"
        + "   CuentaCorriente.retiro():\n"
        + "     if (cantidad > 300)   -> throw \"Retiro maximo 300 euros\"\n"
        + "     if (cantidad < 10)    -> throw \"Retiro minimo 10 euros\"\n"
        + "     if (cantidad > saldo) -> throw \"Saldo insuficiente\"\n"
        + "     confirmarRetiro(cantidad);\n\n"
        + "   CuentaVivienda.retiro():\n"
        + "     if (cantidad > 500)   -> throw \"Retiro maximo 500 euros\"\n"
        + "     if (cantidad < 10)    -> throw \"Retiro minimo 10 euros\"\n"
        + "     if (cantidad > saldo) -> throw \"Saldo insuficiente\"\n"
        + "     confirmarRetiro(cantidad);\n\n"
        + "   FondoInversion.retiro():\n"
        + "     if (cantidad < 500)                             -> throw \"Retiro minimo 500 euros\"\n"
        + "     if (saldo - cantidad < 3000)                   -> throw \"Debe haber minimo 3000 euros\"\n"
        + "     confirmarRetiro(cantidad);\n"
        + "     calcularInteres();  // Recalcular interes tras el retiro\n\n"
        + "D) METODO INGRESO -> ABSTRACT, CON EXCEPCION PERSONALIZADA:\n"
        + "   - IngresoNoValidoException extends Exception\n"
        + "   - Constructor: recibe String mensaje\n"
        + "   - toString(): \"Error: no se ha podido realizar el ingreso. \" + mensaje\n"
        + "   - Metodo protegido confirmarIngreso(double): codigo comun (saldo +=, add movimiento)\n"
        + "   - public abstract void ingreso(double cantidad) throws IngresoNoValidoException\n\n"
        + "   CuentaCorriente.ingreso():\n"
        + "     if (cantidad < 10) -> throw \"Ingreso minimo 10 euros\"\n"
        + "     confirmarIngreso(cantidad);\n\n"
        + "   CuentaVivienda.ingreso():\n"
        + "     if (cantidad < 10) -> throw \"Ingreso minimo 10 euros\"\n"
        + "     confirmarIngreso(cantidad);\n\n"
        + "   FondoInversion.ingreso():\n"
        + "     if (cantidad < 500) -> throw \"Ingreso minimo 500 euros\"\n"
        + "     confirmarIngreso(cantidad);\n"
        + "     calcularInteres();  // Recalcular interes tras el ingreso\n\n"
        + "E) CONTROLAR MENUS (try-catch con NumberFormatException y excepciones propias):\n"
        + "   - Main: try-catch alrededor del switch, \"Opcion no valida, selecciona 1-4\"\n"
        + "   - validarTipoCuenta(): try-catch, \"Tipo de cuenta no valida, selecciona 1-3\"\n"
        + "   - seleccionarOpcionCuenta(): try-catch, \"Opcion no valida, selecciona 1-4\"\n"
        + "   - seleccionarCuenta(): try-catch, \"Debe seleccionar un numero de cuenta valido\"\n"
        + "   - ingresar(): try-catch (NumberFormatException e IngresoNoValidoException)\n"
        + "   - retirar(): try-catch (NumberFormatException e RetiroNoValidoException)\n"
        + "   - Cambio a Double.parseDouble() para permitir decimales\n\n"
        + "F) VALIDACION ADICIONAL: STRING SIN NUMEROS NI CARACTERES EXTRAÑOS:\n"
        + "   - Metodo validarString() -> devuelve String validada\n"
        + "   - Patron regex: \"[a-zA-Z\u00f1\u00d1\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00fc\u00dc\\\\s]+\"\n"
        + "     (letras minus/mayus, anyadidas: n~, vocales acentuadas, u con dieresis, espacios)\n"
        + "   - Si s.matches(pattern) -> return s; else -> \"Error: solo letras y espacios\"\n"
        + "   - Se usa en crearCliente() para nombre y apellidos\n\n"
        + "CONCEPTOS CLAVE:\n"
        + "- Excepciones verificadas (extends Exception): obligan a try-catch o throws\n"
        + "- Metodos abstractos + excepciones: throws en la declaracion abstracta\n"
        + "- Reutilizacion con confirmarRetiro/confirmarIngreso (metodos protected)\n"
        + "- try-catch en menus: NumberFormatException para entradas no numericas\n"
        + "- try-catch multiple: capturar excepcion propia + NumberFormatException\n"
        + "- Recalculo de interes en FondoInversion tras cada ingreso/retiro\n"
        + "- Validacion con regex matches() para filtrar caracteres del nombre\n"
        + "- Formato de fecha con DateTimeParseException\n";

    // ================================================================
    // EXCEPCIONES PERSONALIZADAS
    // ================================================================
    static class ClienteExisteException extends Exception {
        private Cliente cliente;

        ClienteExisteException(Cliente cliente) {
            this.cliente = cliente;
        }

        public String toString() {
            return "El cliente de nombre " + cliente.getNombre() + " ya existe";
        }
    }

    static class RetiroNoValidoException extends Exception {
        private String mensaje;

        RetiroNoValidoException(String mensaje) {
            this.mensaje = mensaje;
        }

        public String toString() {
            return "Error: no se ha podido realizar el retiro. " + mensaje;
        }
    }

    static class IngresoNoValidoException extends Exception {
        private String mensaje;

        IngresoNoValidoException(String mensaje) {
            this.mensaje = mensaje;
        }

        public String toString() {
            return "Error: no se ha podido realizar el ingreso. " + mensaje;
        }
    }

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
    // CLASE CUENTA (abstracta, con metodos abstractos ingreso/retiro)
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

        // Metodo comun para confirmar retiro (reutilizado por las subclases)
        protected void confirmarRetiro(double cantidad) {
            saldo -= cantidad;
            movimientos.add(new Movimiento(LocalDateTime.now(), cantidad, saldo, (byte) 0));
            System.out.println("  Se han retirado " + cantidad + " euros de la cuenta " + numeroCuenta);
        }

        // Metodo comun para confirmar ingreso (reutilizado por las subclases)
        protected void confirmarIngreso(double cantidad) {
            saldo += cantidad;
            movimientos.add(new Movimiento(LocalDateTime.now(), cantidad, saldo, (byte) 1));
            System.out.println("  Se han ingresado " + cantidad + " euros en la cuenta " + numeroCuenta);
        }

        // Metodos abstractos (cada subclase implementa sus restricciones)
        public abstract void retiro(double cantidad) throws RetiroNoValidoException;
        public abstract void ingreso(double cantidad) throws IngresoNoValidoException;
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
    // Restricciones: retiro max 300, min 10, ingreso min 10
    // ================================================================
    static class CuentaCorriente extends Cuenta {
        CuentaCorriente(int numeroCuenta, Cliente titular) {
            super(numeroCuenta, 0, titular);
        }

        public void retiro(double cantidad) throws RetiroNoValidoException {
            if (cantidad > 300)
                throw new RetiroNoValidoException("Retiro maximo 300 euros");
            if (cantidad < 10)
                throw new RetiroNoValidoException("Retiro minimo 10 euros");
            if (cantidad > saldo)
                throw new RetiroNoValidoException("Saldo insuficiente");
            confirmarRetiro(cantidad);
        }

        public void ingreso(double cantidad) throws IngresoNoValidoException {
            if (cantidad < 10)
                throw new IngresoNoValidoException("Ingreso minimo 10 euros");
            confirmarIngreso(cantidad);
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
    // Restricciones: retiro max 500, min 10, ingreso min 10
    // ================================================================
    static class CuentaVivienda extends Cuenta {
        CuentaVivienda(int numeroCuenta, Cliente titular) {
            super(numeroCuenta, 1000, titular);
        }

        public void retiro(double cantidad) throws RetiroNoValidoException {
            if (cantidad > 500)
                throw new RetiroNoValidoException("Retiro maximo 500 euros");
            if (cantidad < 10)
                throw new RetiroNoValidoException("Retiro minimo 10 euros");
            if (cantidad > saldo)
                throw new RetiroNoValidoException("Saldo insuficiente");
            confirmarRetiro(cantidad);
        }

        public void ingreso(double cantidad) throws IngresoNoValidoException {
            if (cantidad < 10)
                throw new IngresoNoValidoException("Ingreso minimo 10 euros");
            confirmarIngreso(cantidad);
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
    // Restricciones: retiro min 500, saldo final >= 3000, ingreso min 500
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

        public void retiro(double cantidad) throws RetiroNoValidoException {
            if (cantidad < 500)
                throw new RetiroNoValidoException("Retiro minimo 500 euros");
            if (saldo - cantidad < 3000)
                throw new RetiroNoValidoException(
                    "Saldo insuficiente. Deben haber como minimo 3000 euros"
                    + " en el fondo de inversion. El saldo actual es " + saldo + " euros");
            confirmarRetiro(cantidad);
            calcularInteres();
        }

        public void ingreso(double cantidad) throws IngresoNoValidoException {
            if (cantidad < 500)
                throw new IngresoNoValidoException("Ingreso minimo 500 euros");
            confirmarIngreso(cantidad);
            calcularInteres();
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
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V18: EJERCICIO FINAL EXCEPCIONES (PARTE 2)");
        System.out.println("Gestion completa de excepciones en App Sucursal Bancaria");
        System.out.println();

        int opcion;
        do {
            mostrarMenuPrincipal();
            try {
                opcion = Integer.parseInt(entrada.nextLine());
                switch (opcion) {
                    case 1: crearCliente(); break;
                    case 2: crearCuenta(); break;
                    case 3: seleccionarCuenta(); break;
                    case 4: System.out.println("  Saliendo del programa..."); break;
                    default: System.out.println("  Opcion no valida. Selecciona una opcion entre 1 y 4");
                }
            } catch (NumberFormatException e) {
                System.out.println("  ERROR: Opcion no valida. Selecciona una opcion entre 1 y 4");
                opcion = 0; // Para que el bucle continue
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
    // VALIDACION DE STRING (solo letras y espacios)
    // ================================================================
    static String validarString() {
        while (true) {
            String s = entrada.nextLine();
            // Patron: letras minus/mayus incluyendo ñ, vocales acentuadas, ü, y espacios
            if (s.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\\s]+")) {
                return s;
            }
            System.out.println("  ERROR: Solo puedes introducir letras y espacios en blanco");
            System.out.print("  Vuelve a introducirlo: ");
        }
    }

    // ================================================================
    // VALIDAR NOMBRE (no repetido en la lista de clientes)
    // ================================================================
    static String validarNombre() {
        while (true) {
            System.out.print("  Dime el nombre del cliente: ");
            String nombre = validarString();

            // Comprobar si el nombre ya existe
            try {
                for (Cliente c : clientes) {
                    if (c.getNombre().equalsIgnoreCase(nombre)) {
                        throw new ClienteExisteException(c);
                    }
                }
                return nombre; // No existe, nombre valido
            } catch (ClienteExisteException e) {
                System.out.println("  " + e);
            }
        }
    }

    // ================================================================
    // VALIDAR FECHA DE NACIMIENTO
    // ================================================================
    static LocalDate validarFechaNacimiento() {
        while (true) {
            System.out.print("  Dime la fecha de nacimiento (aaaa-MM-dd): ");
            try {
                return LocalDate.parse(entrada.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("  ERROR: El formato de la fecha no es valido.");
                System.out.println("         Debe ser aaaa-MM-dd (4 digitos anyo, 2 mes, 2 dia)");
            }
        }
    }

    // ================================================================
    // OPCION 1: Crear cliente
    // ================================================================
    static void crearCliente() {
        String nombre = validarNombre();

        System.out.print("  Dime los apellidos del cliente: ");
        String apellidos = validarString();

        System.out.print("  Dime la direccion del cliente: ");
        String direccion = entrada.nextLine();

        System.out.print("  Dime la ciudad de residencia: ");
        String ciudad = entrada.nextLine();

        LocalDate fecha = validarFechaNacimiento();

        clientes.add(new Cliente(nombre, apellidos, direccion, ciudad, fecha));
        System.out.println("  Cliente " + nombre + " " + apellidos + " se ha creado correctamente");
    }

    // ================================================================
    // OPCION 2: Crear cuenta (CON SELECCION DE TIPO Y EXCEPCIONES)
    // ================================================================
    static void crearCuenta() {
        if (clientes.isEmpty()) {
            System.out.println("  ERROR: No hay clientes en la sucursal. Primero debes crear uno");
            return;
        }

        Cliente cliente = validarCliente();
        Cuenta cuenta = validarTipoCuenta(cliente);
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
            try {
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
            } catch (NumberFormatException e) {
                System.out.println("  ERROR: Tipo de cuenta no valida. Selecciona una opcion entre 1 y 3");
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

        int numCuenta = 0;
        boolean valido;
        do {
            try {
                System.out.println("  Selecciona un numero de cuenta:");
                for (Cuenta c : cuentas)
                    System.out.println("    " + c);
                System.out.print("  Numero de cuenta: ");
                numCuenta = Integer.parseInt(entrada.nextLine());
                valido = validarCuenta(numCuenta);
                if (!valido) {
                    System.out.println("  ERROR: Debe seleccionar un numero de cuenta valido (1 - " + (contadorCuentas - 1) + ")");
                }
            } catch (NumberFormatException e) {
                System.out.println("  ERROR: Debe seleccionar un numero de cuenta valido");
                valido = false;
            }
        } while (!valido);

        seleccionarOpcionCuenta();
    }

    static boolean validarCuenta(int numCuenta) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta() == numCuenta) {
                cuentaActiva = c;
                return true;
            }
        }
        return false;
    }

    // ---- SUBMENU DE CUENTA ----
    static void seleccionarOpcionCuenta() {
        int opcionCuenta;
        do {
            mostrarMenuCuenta();
            try {
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
                        System.out.println("  Opcion no valida. Selecciona una opcion entre 1 y 4");
                }
            } catch (NumberFormatException e) {
                System.out.println("  ERROR: Opcion no valida. Selecciona una opcion entre 1 y 4");
                opcionCuenta = 0;
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
        try {
            System.out.print("  Cantidad a ingresar: ");
            double cantidad = Double.parseDouble(entrada.nextLine());
            cuentaActiva.ingreso(cantidad);
        } catch (NumberFormatException e) {
            System.out.println("  ERROR: Debes introducir una cantidad numerica valida");
        } catch (IngresoNoValidoException e) {
            System.out.println("  " + e);
        }
    }

    static void retirar() {
        try {
            System.out.print("  Cantidad a retirar: ");
            double cantidad = Double.parseDouble(entrada.nextLine());
            cuentaActiva.retiro(cantidad);
        } catch (NumberFormatException e) {
            System.out.println("  ERROR: Debes introducir una cantidad numerica valida");
        } catch (RetiroNoValidoException e) {
            System.out.println("  " + e);
        }
    }
}
