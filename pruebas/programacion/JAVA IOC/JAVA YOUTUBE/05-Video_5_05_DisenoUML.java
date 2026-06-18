class Video_5_05_DisenoUML {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-05 JAVA: Diseno orientado a objetos en UML DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=XTqP4R0MXHw&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=98";
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
          RESUMEN RAPIDO - DISENO UML (TEMA 5 - V05)
        ====================================================================

        --- QUE ES UML ---
        Unified Modeling Language: lenguaje grafico para modelar
        programas orientados a objetos.
        - Estandar para especificar, visualizar y documentar.
        - Muestra clases, atributos, metodos y relaciones.

        --- ESTRUCTURA DE UNA CLASE EN UML ---
        +------------------+
        |    Persona       |  <-- Nombre de la clase
        +------------------+
        | - nombre: String |  <-- Atributos (tipo despues de :)
        | - edad: int      |
        | - dni: String    |
        +------------------+
        | + obtenerDatos() |  <-- Metodos (parametros y retorno)
        | + getEdad(): int |
        +------------------+

        - Atributos: nombreAtributo: TipoDato
        - Metodos: + nombreMetodo(param: Tipo): TipoRetorno
        - void si no devuelve nada
        - Parentesis vacios si no recibe parametros

        --- RELACIONES ENTRE CLASES ---

        1. ASOCIACION:
           - Relacion basica: un objeto puede llamar a metodos de otro.
           - Se representa con una flecha (navegabilidad).
           - La clase ORIGEN tiene una instancia de la clase DESTINO.
           - Se especifica CARDINALIDAD en cada extremo.

        2. CARDINALIDAD:
           1         -> exactamente 1
           0..1      -> 0 o 1
           2,4       -> 2 o 4 (valores discretos)
           1..5      -> entre 1 y 5
           1..*      -> 1 o mas
           *         -> cualquier valor (0, 1, 2, ...)

           Ejemplo: CuentaBancaria ---- 1 --> Persona
                    * (una persona puede tener 0..* cuentas)
                    1 (una cuenta pertenece a 1 unica persona)

        3. NAVEGABILIDAD:
           - Flecha indica quien puede llamar a quien.
           - CuentaBancaria -> Persona: Cuenta llama a metodos de Persona.
           - Sin flecha = bidireccional (ambas se llaman).

        4. AGREGACION (rombo BLANCO):
           - "Puede contener" / "tiene"
           - El objeto contenedor PUEDE existir sin los componentes.
           - Ej: Pagina puede contener Citas (o no tener ninguna).
           - Rombo en el extremo del contenedor.

        5. COMPOSICION (rombo NEGRO):
           - "Es parte de"
           - El objeto contenedor NO puede existir sin los componentes.
           - Los componentes solo pertenecen a un unico contenedor.
           - Ej: Agenda esta compuesta por Paginas.
           - Una agenda sin paginas no tiene sentido.

        6. ASOCIACION REFLEXIVA:
           - Una clase se relaciona consigo misma.
           - Ej: Cliente puede recomendar a otro Cliente.
           - La flecha apunta a la misma clase.

        --- IMPLEMENTACION EN JAVA ---
        Cardinalidad 1: atributo simple de la clase destino.
        Cardinalidad *: ArrayList<ClaseDestino> (coleccion dinamica).
        - La clase ORIGEN tiene el/los atributos.
        - Para cardinalidad indeterminada se usa ArrayList.

        --- PRINCIPIO DE COHESION ---
        - Una clase debe tener un proposito claro y especifico.
        - Solo debe incluir atributos y metodos esenciales
          para cumplir su funcion.
        - No mezclar responsabilidades de distintas clases.

        ====================================================================
        """;

    // ================================================================
    // CLASE PERSONA (para UML: atributos + metodos)
    // ================================================================
    static class Persona {
        private String nombre;
        private int edad;
        private String dni;
        private String ciudad;
        private String profesion;

        Persona(String nombre, int edad, String dni) {
            this.nombre = nombre;
            this.edad = edad;
            this.dni = dni;
            this.ciudad = "Sin ciudad";
            this.profesion = "Sin profesion";
        }

        String getNombre() { return nombre; }
        int getEdad() { return edad; }

        void obtenerDatos() {
            System.out.println("    Nombre: " + nombre);
            System.out.println("    Edad: " + edad);
            System.out.println("    DNI: " + dni);
            System.out.println("    Ciudad: " + ciudad);
            System.out.println("    Profesion: " + profesion);
        }

        void cambiarProfesion(String p) { this.profesion = p; }
        void modificarCiudadResidencia(String c) { this.ciudad = c; }
    }

    // ================================================================
    // CLASE CUENTA BANCARIA (asociacion 1 -> Persona)
    // ================================================================
    static class CuentaBancaria {
        private int id;
        private double saldo;
        private Persona propietario;  // Cardinalidad 1: un atributo
        private String tipo;

        CuentaBancaria(int id, Persona propietario) {
            this.id = id;
            this.saldo = 0;
            this.propietario = propietario;
            this.tipo = "Corriente";
        }

        void verSaldo() {
            System.out.println("  Saldo cuenta " + id + ": " + saldo + " euros");
        }

        void ingresar(double n) { if (n > 0) saldo += n; }

        void retirar(double n) {
            if (n > 0 && saldo >= n) saldo -= n;
            else System.out.println("  ERROR: No hay suficiente saldo");
        }

        // Desde CuentaBancaria podemos llamar a metodos de Persona
        void mostrarDatos() {
            System.out.println("  === CUENTA " + id + " ===");
            System.out.println("  Propietario:");
            if (propietario != null) propietario.obtenerDatos();
            verSaldo();
        }
    }

    // ================================================================
    // CLASE PAGINA (agregacion: puede contener Citas)
    // ================================================================
    static class Pagina {
        private int numero;
        private String contenido;
        private java.util.ArrayList<Cita> citas;  // Cardinalidad *

        Pagina(int numero) {
            this.numero = numero;
            this.contenido = "";
            this.citas = new java.util.ArrayList<>();
        }

        void agregarCita(Cita c) { citas.add(c); }

        void mostrarPagina() {
            System.out.println("  Pagina " + numero + ": " + contenido);
            System.out.println("  Citas en esta pagina (" + citas.size() + "):");
            for (Cita c : citas) {
                System.out.println("    - \"" + c.getTexto() + "\" (Autor: " + c.getAutor() + ")");
            }
        }
    }

    // -------------------------------------------------------------
    static class Cita {
        private String texto;
        private String autor;

        Cita(String texto, String autor) {
            this.texto = texto;
            this.autor = autor;
        }

        String getTexto() { return texto; }
        String getAutor() { return autor; }
    }

    // ================================================================
    // CLASE AGENDA (composicion: formada por Paginas)
    // ================================================================
    static class Agenda {
        private String propietario;
        private java.util.ArrayList<Pagina> paginas;  // Composicion

        Agenda(String propietario, int numPaginas) {
            this.propietario = propietario;
            this.paginas = new java.util.ArrayList<>();
            // La agenda se crea CON paginas (composicion)
            for (int i = 1; i <= numPaginas; i++) {
                paginas.add(new Pagina(i));
            }
        }

        Pagina getPagina(int num) {
            for (Pagina p : paginas) {
                if (p.numero == num) return p;
            }
            return null;
        }

        void mostrarAgenda() {
            System.out.println("  Agenda de " + propietario
                + " (" + paginas.size() + " paginas)");
        }
    }

    // ================================================================
    // CLASE CLIENTE (asociacion reflexiva)
    // ================================================================
    static class Cliente {
        private String nombre;
        private Cliente recomendadoPor;  // Cardinalidad 0..1
        private java.util.ArrayList<Cliente> recomendados;  // Cardinalidad *

        Cliente(String nombre) {
            this.nombre = nombre;
            this.recomendadoPor = null;
            this.recomendados = new java.util.ArrayList<>();
        }

        void recomendar(Cliente c) {
            recomendados.add(c);
            c.recomendadoPor = this;
        }

        void mostrarInfo() {
            System.out.println("  Cliente: " + nombre);
            System.out.println("  Recomendado por: "
                + (recomendadoPor != null ? recomendadoPor.nombre : "nadie"));
            System.out.println("  Ha recomendado a: " + recomendados.size() + " clientes");
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
        System.out.println("TEMA 5 - V05: DISENO ORIENTADO A OBJETOS EN UML");
        System.out.println();

        // ============================================================
        // EJEMPLO 1: Asociacion simple (CuentaBancaria -> Persona)
        // ============================================================
        separador("EJEMPLO 1: ASOCIACION (Cardinalidad 1 -> Persona)");

        Persona p1 = new Persona("Pepe", 40, "202020A");
        Persona p2 = new Persona("Marta", 25, "303030B");

        CuentaBancaria c1 = new CuentaBancaria(1, p1);
        CuentaBancaria c2 = new CuentaBancaria(2, p2);

        // Una persona puede tener MULTIPLES cuentas (cardinalidad *)
        CuentaBancaria c3 = new CuentaBancaria(3, p1);

        c1.ingresar(500);
        c2.ingresar(300);
        c3.ingresar(200);

        c1.mostrarDatos();
        System.out.println();
        c2.mostrarDatos();
        System.out.println();
        System.out.println("  Pepe tiene 2 cuentas (cardinalidad * en Persona)");
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Agregacion (Pagina puede contener Citas)
        // ============================================================
        separador("EJEMPLO 2: AGREGACION (Pagina puede contener Citas)");

        Pagina pag = new Pagina(1);
        pag.contenido = "Introduccion a la POO";
        pag.agregarCita(new Cita("La programacion es pensar", "Edsger Dijkstra"));
        pag.agregarCita(new Cita("Primero resuelve el problema", "Brian Kernighan"));

        pag.mostrarPagina();
        System.out.println("  (La pagina EXISTE aunque no tenga citas - agregacion)");
        System.out.println();

        // ============================================================
        // EJEMPLO 3: Composicion (Agenda compuesta por Paginas)
        // ============================================================
        separador("EJEMPLO 3: COMPOSICION (Agenda formada por Paginas)");

        Agenda agenda = new Agenda("Luis", 3);
        agenda.mostrarAgenda();
        System.out.println("  (La agenda NO existe sin paginas - composicion)");
        System.out.println("  Las paginas son 'parte de' la agenda.");
        System.out.println();

        // ============================================================
        // EJEMPLO 4: Asociacion reflexiva (Cliente recomienda a Cliente)
        // ============================================================
        separador("EJEMPLO 4: ASOCIACION REFLEXIVA (Cliente -> Cliente)");

        Cliente ana = new Cliente("Ana");
        Cliente carlos = new Cliente("Carlos");
        Cliente bea = new Cliente("Bea");

        ana.recomendar(carlos);   // Ana recomienda a Carlos
        ana.recomendar(bea);      // Ana recomienda a Bea

        ana.mostrarInfo();
        System.out.println();
        carlos.mostrarInfo();
        System.out.println();

        // ============================================================
        // CONCEPTOS CLAVE
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V05: DISENO UML)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  TIPOS DE RELACIONES UML:");
        System.out.println("  1. ASOCIACION: flecha + cardinalidad");
        System.out.println("  2. AGREGACION: rombo BLANCO (puede contener)");
        System.out.println("  3. COMPOSICION: rombo NEGRO (es parte de)");
        System.out.println("  4. REFLEXIVA: flecha hacia si misma");
        System.out.println();
        System.out.println("  CARDINALIDAD: 1, 0..1, *, 1..*, etc.");
        System.out.println("  NAVEGABILIDAD: direccion de la flecha");
        System.out.println("  COHESION: cada clase con un proposito claro");
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
