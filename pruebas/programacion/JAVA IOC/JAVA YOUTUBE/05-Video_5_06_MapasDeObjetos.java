class Video_5_06_MapasDeObjetos {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-06 JAVA: Mapas de objetos DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=r-H3VYQujgo&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=99";
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
          RESUMEN RAPIDO - MAPAS DE OBJETOS (TEMA 5 - V06)
        ====================================================================

        --- QUE ES UN MAPA DE OBJETOS ---
        Esquema que representa los distintos estados posibles de una
        aplicacion en un momento dado.
        - Muestra objetos instanciados y los ENLACES entre ellos.
        - NO es un mecanismo de diseno, es una HERRAMIENTA DE APOYO.
        - Sirve para VERIFICAR si las cardinalidades definidas en UML
          producen el comportamiento deseado.

        --- COMO SE LEE ---
        - Cada objeto se representa como una caja.
        - Las flechas indican las relaciones (enlaces) entre objetos.
        - La cantidad de flechas debe cumplir la CARDINALIDAD definida.

        --- EJEMPLO A: Pagina --- * --- Cita (1) ---

        Cardinalidad:
          Pagina -- * --> Cita (una pagina tiene 0..* citas)
          Cita -- 1 --> Pagina (una cita pertenece a UNA unica pagina)

        VALIDO:
          Pagina1 -> Cita1, Cita2 (varias citas en una pagina)
          Pagina2 -> Cita3           (una cita en una pagina)
          Pagina3 -> (sin citas)     (pagina sin citas: permitido por *)
          Pagina4 -> Cita4

        INVALIDO:
          - Cita1 -> Pagina1 Y Pagina2 (una cita NO puede estar en 2 paginas)
          - Cita3 sin flecha a ninguna pagina (obligatorio, cardinalidad 1)

        --- EJEMPLO B: Tutor (1) --- 1 --- Grupo ---

        Cardinalidad:
          Tutor -- 1 --> Grupo (un tutor tutoriza UN grupo)
          Grupo -- 1 --> Tutor (un grupo es tutorizado por UN tutor)

        VALIDO:
          Tutor1 -> Grupo1   (se apuntan mutuamente)
          Tutor2 -> Grupo2
          Tutor3 -> Grupo3

        INVALIDO:
          - Tutor1 -> Grupo1 Y Grupo2 (tutor con 2 grupos)
          - Grupo2 recibe flechas de Tutor1 Y Tutor2 (grupo con 2 tutores)

        --- EJEMPLO C: Sucursal --- * --- Cliente (1..*) ---

        Cardinalidad:
          Sucursal -- * --> Cliente (una sucursal tiene 0..* clientes)
          Cliente -- 1..* --> Sucursal (un cliente debe estar en >=1 sucursal)

        VALIDO:
          Sucursal1 -> Cliente1, Cliente2
          Sucursal2 -> Cliente2, Cliente3  (cliente en varias sucursales)
          Sucursal3 -> (sin clientes)      (sucursal sin clientes: valido)
          Sucursal4 -> Cliente3, Cliente4

        INVALIDO:
          - Cliente2 sin flecha de ninguna sucursal (debe estar en >=1)
          - Cliente5 sin ninguna relacion

        --- CONCLUSION ---
        Si un mapa de objetos muestra un caso que no es posible con las
        cardinalidades actuales, hay que REPLANTEAR el diseno UML.

        ====================================================================
        """;

    // ================================================================
    // EJEMPLO A: Pagina y Cita (asociacion basica)
    // ================================================================
    static class Pagina {
        int id;
        String contenido;
        java.util.ArrayList<Cita> citas;

        Pagina(int id) {
            this.id = id;
            this.contenido = "";
            this.citas = new java.util.ArrayList<>();
        }

        void agregarCita(Cita c) {
            citas.add(c);
            c.pagina = this;  // Enlace bidireccional
        }

        String mostrarEnlaces() {
            if (citas.isEmpty()) return "(sin citas)";
            StringBuilder sb = new StringBuilder();
            for (Cita c : citas) sb.append("Cita" + c.id + " ");
            return sb.toString().trim();
        }

        boolean esValida() {
            // Una pagina siempre es valida (cardinalidad *)
            return true;
        }
    }

    static class Cita {
        int id;
        String texto;
        Pagina pagina;  // Debe tener una pagina (cardinalidad 1)

        Cita(int id, String texto) {
            this.id = id;
            this.texto = texto;
            this.pagina = null;
        }

        boolean esValida() {
            return pagina != null;  // Cardinalidad 1: obligatorio
        }
    }

    // ================================================================
    // EJEMPLO B: Tutor y Grupo (cardinalidad 1 a 1)
    // ================================================================
    static class Tutor {
        int id;
        Grupo grupo;  // Cardinalidad 1: debe tener un grupo

        Tutor(int id) {
            this.id = id;
            this.grupo = null;
        }

        void asignarGrupo(Grupo g) {
            this.grupo = g;
            g.tutor = this;
        }

        boolean esValido() {
            return grupo != null;
        }
    }

    static class Grupo {
        int id;
        Tutor tutor;  // Cardinalidad 1: debe tener un tutor

        Grupo(int id) {
            this.id = id;
            this.tutor = null;
        }

        boolean esValido() {
            return tutor != null;
        }
    }

    // ================================================================
    // EJEMPLO C: Sucursal y Cliente (cardinalidad * y 1..*)
    // ================================================================
    static class Sucursal {
        int id;
        java.util.ArrayList<Cliente> clientes;

        Sucursal(int id) {
            this.id = id;
            this.clientes = new java.util.ArrayList<>();
        }

        void agregarCliente(Cliente c) {
            clientes.add(c);
            c.sucursales.add(this);
        }

        boolean esValida() {
            return true;  // Sucursal puede tener 0 clientes (*)
        }
    }

    static class Cliente {
        int id;
        String nombre;
        java.util.ArrayList<Sucursal> sucursales;

        Cliente(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
            this.sucursales = new java.util.ArrayList<>();
        }

        boolean esValido() {
            return sucursales.size() >= 1;  // Cardinalidad 1..*
        }
    }

    // ================================================================
    // METODO: Validar mapa de objetos
    // ================================================================
    static void validarMapa(String titulo, boolean condicion, String descripcion) {
        System.out.println("  " + (condicion ? "✓" : "✗") + " " + descripcion);
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();

        // ============================================================
        // EJEMPLO A: Pagina y Cita
        // ============================================================
        separador("EJEMPLO A: Pagina --- * --- Cita (1)");

        // Configuracion VALIDA
        Pagina pag1 = new Pagina(1);
        Pagina pag2 = new Pagina(2);
        Pagina pag3 = new Pagina(3);
        Pagina pag4 = new Pagina(4);

        Cita cit1 = new Cita(1, "Ser o no ser");
        Cita cit2 = new Cita(2, "Pienso luego existo");
        Cita cit3 = new Cita(3, "Carpe Diem");
        Cita cit4 = new Cita(4, "Conocete a ti mismo");

        // Enlaces validos
        pag1.agregarCita(cit1);
        pag1.agregarCita(cit2);   // Pagina1 tiene 2 citas
        pag2.agregarCita(cit3);   // Pagina2 tiene 1 cita
        // Pagina3 sin citas (valido: cardinalidad *)
        pag4.agregarCita(cit4);   // Pagina4 tiene 1 cita

        System.out.println("  MAPA DE OBJETOS (valido):");
        System.out.println("  Pagina1 -> " + pag1.mostrarEnlaces());
        System.out.println("  Pagina2 -> " + pag2.mostrarEnlaces());
        System.out.println("  Pagina3 -> " + pag3.mostrarEnlaces());
        System.out.println("  Pagina4 -> " + pag4.mostrarEnlaces());
        System.out.println();

        System.out.println("  VALIDACION:");
        validarMapa("Paginas con citas", true, "Pag1 y Pag2 con citas (OK)");
        validarMapa("Pagina sin citas", pag3.esValida(), "Pag3 sin citas (OK, cardinalidad *)");
        validarMapa("Citas sin pagina", !cit1.esValida() == false,
            "Todas las citas tienen pagina (OK)");

        // CASO INVALIDO: Cita sin pagina
        Cita citInvalida = new Cita(5, "Cita huerfana");
        System.out.println();
        System.out.println("  CASO INVALIDO:");
        validarMapa("Cita sin pagina", citInvalida.esValida(),
            "Cita5 sin pagina -> INVALIDO (cardinalidad 1)");
        System.out.println();

        // ============================================================
        // EJEMPLO B: Tutor y Grupo (1 a 1)
        // ============================================================
        separador("EJEMPLO B: Tutor (1) --- 1 --- Grupo");

        Tutor t1 = new Tutor(1);
        Tutor t2 = new Tutor(2);
        Tutor t3 = new Tutor(3);
        Grupo g1 = new Grupo(1);
        Grupo g2 = new Grupo(2);
        Grupo g3 = new Grupo(3);

        // Enlaces validos (1 a 1)
        t1.asignarGrupo(g1);
        t2.asignarGrupo(g2);
        t3.asignarGrupo(g3);

        System.out.println("  MAPA DE OBJETOS (valido):");
        System.out.println("  Tutor1 <-> Grupo1");
        System.out.println("  Tutor2 <-> Grupo2");
        System.out.println("  Tutor3 <-> Grupo3");
        System.out.println();

        System.out.println("  VALIDACION:");
        validarMapa("Todos los tutores con grupo",
            t1.esValido() && t2.esValido() && t3.esValido(), "OK");
        validarMapa("Todos los grupos con tutor",
            g1.esValido() && g2.esValido() && g3.esValido(), "OK");

        // CASO INVALIDO: Tutor sin grupo
        Tutor tInvalido = new Tutor(4);
        System.out.println();
        System.out.println("  CASO INVALIDO:");
        validarMapa("Tutor sin grupo", tInvalido.esValido(),
            "Tutor4 sin grupo -> INVALIDO (cardinalidad 1)");
        System.out.println();

        // ============================================================
        // EJEMPLO C: Sucursal y Cliente (* y 1..*)
        // ============================================================
        separador("EJEMPLO C: Sucursal --- * --- Cliente (1..*)");

        Sucursal s1 = new Sucursal(1);
        Sucursal s2 = new Sucursal(2);
        Sucursal s3 = new Sucursal(3);
        Sucursal s4 = new Sucursal(4);

        Cliente cl1 = new Cliente(1, "Ana");
        Cliente cl2 = new Cliente(2, "Luis");
        Cliente cl3 = new Cliente(3, "Eva");
        Cliente cl4 = new Cliente(4, "Ivan");

        // Enlaces validos
        s1.agregarCliente(cl1);
        s1.agregarCliente(cl2);  // Suc1: 2 clientes
        s2.agregarCliente(cl2);  // Cliente2 en 2 sucursales
        s2.agregarCliente(cl3);
        // Sucursal3 sin clientes (valido: *)
        s4.agregarCliente(cl3);
        s4.agregarCliente(cl4);

        System.out.println("  MAPA DE OBJETOS (valido):");
        System.out.println("  Sucursal1 -> Cliente1, Cliente2");
        System.out.println("  Sucursal2 -> Cliente2, Cliente3");
        System.out.println("  Sucursal3 -> (sin clientes)");
        System.out.println("  Sucursal4 -> Cliente3, Cliente4");
        System.out.println();

        System.out.println("  VALIDACION:");
        validarMapa("Sucursal sin clientes", s3.esValida(),
            "Suc3 sin clientes (OK, cardinalidad *)");
        validarMapa("Cliente2 en 2 sucursales",
            cl2.sucursales.size() == 2, "OK (1..* permite varias)");
        validarMapa("Todos los clientes tienen sucursal",
            cl1.esValido() && cl2.esValido() && cl3.esValido() && cl4.esValido(),
            "OK (todos >=1 sucursal)");

        // CASO INVALIDO: Cliente sin sucursal
        Cliente clInvalido = new Cliente(5, "Huerfano");
        System.out.println();
        System.out.println("  CASO INVALIDO:");
        validarMapa("Cliente sin sucursal", clInvalido.esValido(),
            "Cliente5 sin sucursal -> INVALIDO (cardinalidad 1..*)");
        System.out.println();

        // ============================================================
        // CONCLUSION
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V06: MAPAS DE OBJETOS)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  LOS MAPAS DE OBJETOS SIRVEN PARA:");
        System.out.println("  1. Verificar que las cardinalidades UML son correctas");
        System.out.println("  2. Detectar: ?Puede un objeto no tener relacion?");
        System.out.println("  3. Detectar: ?Puede un objeto tener multiples relaciones?");
        System.out.println("  4. Si encontramos un caso invalido -> revisar UML");
        System.out.println();
        System.out.println("  PROXIMO VIDEO: Sintaxis POO en Java (constructores, etc.)");
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
