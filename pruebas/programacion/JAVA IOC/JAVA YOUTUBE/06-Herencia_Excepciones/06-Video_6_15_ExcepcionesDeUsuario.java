import java.util.ArrayList;

class Video_6_15_ExcepcionesDeUsuario {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "6-15 JAVA: Excepciones de usuario DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=QdYBKihDzog&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=136";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 6-15 - EXCEPCIONES DE USUARIO
        ================================================================

        Video:        6-15 JAVA: Excepciones de usuario
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6

        --- RESUMEN (transcripcion) ---

        Podemos crear nuestras PROPIAS excepciones heredando de
        Exception (verificada) o RuntimeException (no verificada).

        --- CREAR EXCEPCIONES PROPIAS ---

        clase ExcepcionPropia extends Exception {  // verificada
          // atributos personalizados
          // constructores
          // toString() personalizado
        }

        clase ExcepcionPropia extends RuntimeException {  // no verificada
          // mismo formato
        }

        --- DIFERENCIAS ---

        VERIFICADA (extends Exception):
          - Obliga a poner throws en el metodo.
          - Obliga a try-catch donde se invoca.
          - El compilador NO deja ejecutar si no se maneja.

        NO VERIFICADA (extends RuntimeException):
          - No obliga a throws.
          - No obliga a try-catch.
          - Si no se captura, el programa termina en ejecucion.

        --- ESTRUCTURA TIPICA ---

        class ClienteExisteException extends Exception {
            private Cliente cliente;
            ClienteExisteException(Cliente c) { this.cliente = c; }
            public String toString() {
                return "El cliente de nombre " + cliente.getNombre() + " ya existe";
            }
        }

        --- EJEMPLO: METODO nuevoCliente() ---

        static void nuevoCliente(String nombre, ArrayList<Cliente> clientes)
            throws ClienteExisteException {
            for (Cliente c : clientes) {
                if (c.getNombre().equals(nombre)) {
                    throw new ClienteExisteException(c);
                }
            }
            clientes.add(new Cliente(nombre));
        }

        --- DOS FORMAS DE CAPTURAR ---

        1. Capturar en el Main (propagando con throws).
        2. Capturar dentro del propio metodo (try-catch interno).
           - Ventaja: si se llama al metodo varias veces,
             cada llamada tiene su propio try-catch independiente.

        --- CONCEPTOS CLAVE ---

        - extends Exception -> verificada (obligatoria)
        - extends RuntimeException -> no verificada (opcional)
        - Atributos personalizados en la excepcion
        - toString() personalizado para el mensaje
        - Dos estrategias: capturar en quien llama o en el propio metodo
        - La captura interna permite que cada llamada sea independiente
        ================================================================
        """;

    // ================================================================
    // CLASE CLIENTE
    // ================================================================
    static class Cliente {
        private String nombre;

        Cliente(String nombre) {
            this.nombre = nombre;
        }

        String getNombre() { return nombre; }

        public String toString() {
            return "Cliente{nombre=" + nombre + "}";
        }
    }

    // ================================================================
    // EXCEPCION PERSONALIZADA (VERIFICADA)
    // ================================================================
    static class ClienteExisteException extends Exception {
        private Cliente cliente;

        ClienteExisteException(Cliente cliente) {
            this.cliente = cliente;
        }

        public String toString() {
            return "El cliente de nombre " + cliente.getNombre() + " ya existe";
        }

        void mostrarDatos() {
            System.out.println("  Error: El cliente de nombre "
                + cliente.getNombre() + " ya existe");
        }
    }

    // ================================================================
    // METODO: nuevoCliente (propaga la excepcion)
    // ================================================================
    static void nuevoCliente(String nombre, ArrayList<Cliente> clientes)
            throws ClienteExisteException {

        for (Cliente c : clientes) {
            if (c.getNombre().equals(nombre)) {
                throw new ClienteExisteException(c);
            }
        }

        clientes.add(new Cliente(nombre));
        System.out.println("  Cliente dado de alta correctamente");
    }

    // ================================================================
    // METODO: nuevoCliente CON captura interna
    // ================================================================
    static void nuevoClienteConCaptura(String nombre, ArrayList<Cliente> clientes) {
        try {
            for (Cliente c : clientes) {
                if (c.getNombre().equals(nombre)) {
                    throw new ClienteExisteException(c);
                }
            }
            clientes.add(new Cliente(nombre));
            System.out.println("  Cliente dado de alta correctamente");
        } catch (ClienteExisteException e) {
            e.mostrarDatos();
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // PARTE 1: Captura en el Main (propagacion con throws)
        // ============================================================
        System.out.println("=== PARTE 1: CAPTURA EN EL MAIN (throws) ===");

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Pep"));
        clientes.add(new Cliente("Tom"));
        clientes.add(new Cliente("Kal"));

        System.out.println("  Clientes iniciales: " + clientes);

        try {
            nuevoCliente("Tom", clientes);
            nuevoCliente("Eddy", clientes);
        } catch (ClienteExisteException e) {
            System.out.println("  Error: " + e.toString());
        }

        System.out.println("  Clientes finales: " + clientes + " (siguen siendo 3)");
        System.out.println();

        // ============================================================
        // PARTE 2: Captura DENTRO del metodo (cada llamada independiente)
        // ============================================================
        System.out.println("=== PARTE 2: CAPTURA DENTRO DEL METODO ===");

        ArrayList<Cliente> clientes2 = new ArrayList<>();
        clientes2.add(new Cliente("Pep"));
        clientes2.add(new Cliente("Tom"));
        clientes2.add(new Cliente("Kal"));

        System.out.println("  Clientes iniciales: " + clientes2);

        nuevoClienteConCaptura("Tom", clientes2);
        nuevoClienteConCaptura("Eddy", clientes2);

        System.out.println("  Clientes finales: " + clientes2 + " (4: Pep, Tom, Kal, Eddy)");
    }
}
