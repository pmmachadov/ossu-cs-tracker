import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

class Video_6_20_EjerciciosFinalesOO {

    public static final String TITULO = "6-20 JAVA: Ejercicios finales OO DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=8vur2nVczn0&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=141";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - EJERCICIOS FINALES OO (TEMA 6 - V20)\n"
        + "=========================================================\n\n"
        + "PRACTICA 3: SISTEMA DE GESTION DE BIBLIOTECA\n"
        + "=========================================================\n\n"
        + "CLASES:\n"
        + "  Persona: nombre, apellido, fechaNacimiento (LocalDate)\n"
        + "  Autor extends Persona: generoLiterario (enum GeneroLiterario)\n"
        + "    - GeneroLiterario: POETICO, NARRATIVO, DRAMATICO, DIDACTICO, LIRICO\n"
        + "    - Opcion mejorada: atributo nombre (String) para mostrar con acentos\n"
        + "  Libro: titulo, autor (Autor), editorial, fechaPublicacion (LocalDate), isbn, precio\n"
        + "  Biblioteca: ArrayList<Libro>\n"
        + "    - agregarLibro(Libro)\n"
        + "    - eliminarLibro(String isbn) throws LibroNoEncontradoException\n"
        + "      (mejor usar ISBN que titulo, ya que es unico)\n"
        + "    - for-each con remove() y return para evitar ConcurrentModificationException\n"
        + "  LibroNoEncontradoException extends Exception\n"
        + "    - Constructor recibe String, usa super(mensaje)\n"
        + "    - getMessage() para obtener el mensaje\n\n"
        + "=========================================================\n"
        + "PRACTICA 4: SISTEMA DE GESTION DE EVENTOS DEPORTIVOS\n"
        + "=========================================================\n\n"
        + "INTERFACES Y CLASES PRINCIPALES:\n"
        + "  Interfaz Ganador:\n"
        + "    - ArrayList<Participante> obtenerGanador()\n"
        + "    - (devuelve lista por si hay multiples ganadores como en un equipo)\n\n"
        + "  EventoDeportivo (abstracta) implements Ganador:\n"
        + "    - nombre, fecha, lugar, participantes (ArrayList<Participante>)\n"
        + "    - inscribirParticipante(Participante p)\n"
        + "    - metodo abstracto: mostrarGanador() -> personaliza la salida\n\n"
        + "  Carrera extends EventoDeportivo:\n"
        + "    - distancia (double, en km)\n"
        + "    - obtenerGanador(): devuelve participante con menor tiempo (Duration)\n"
        + "    - mostrarGanador(): \"El ganador de [nombre] ha sido [nombre] [apellido]\"\n\n"
        + "  TorneoFutbol extends EventoDeportivo:\n"
        + "    - equipos (ArrayList<Equipo>)\n"
        + "    - inscribirEquipo(Equipo)\n"
        + "    - obtenerGanador(): devuelve participantes del equipo con mas puntos\n"
        + "    - mostrarGanador(): \"Los ganadores del torneo han sido: [lista]\"\n\n"
        + "CLASES AUXILIARES:\n"
        + "  Participante:\n"
        + "    - nombre, apellido, edad\n"
        + "    - Constructor puede lanzar excepciones si datos no validos\n"
        + "    - toString(): \"Participante [nombre]\" o personalizado\n\n"
        + "  ParticipanteCarrera extends Participante:\n"
        + "    - tiempo (Duration)\n"
        + "    - toString(): anyade tiempo en horas y minutos\n\n"
        + "  Equipo:\n"
        + "    - nombre, jugadores (ArrayList<Participante>), puntos\n"
        + "    - agregarJugador(Participante)\n"
        + "    - eliminarJugador(Participante) throws JugadorNoEncontradoException\n"
        + "    - toString(): muestra equipo y lista de jugadores\n\n"
        + "EXCEPCIONES:\n"
        + "  - LibroNoEncontradoException\n"
        + "  - JugadorNoEncontradoException\n"
        + "  - ParticipanteNoValidoException (con constantes byte: NOMBRE, APELLIDO, EDAD)\n"
        + "  - O mejor: excepciones separadas:\n"
        + "      ParticipanteNombreNoValidoException\n"
        + "      ParticipanteApellidoNoValidoException\n"
        + "      ParticipanteEdadNoValidaException\n\n"
        + "CONCEPTOS CLAVE:\n"
        + "- Interfaces: Ganador con metodo obtenerGanador()\n"
        + "- Clase abstracta EventoDeportivo que implementa la interfaz\n"
        + "- Herencia: Carrera y TorneoFutbol extienden EventoDeportivo\n"
        + "- Polimorfismo: ArrayList<Participante> para ganador individual o equipo\n"
        + "- Duration para medir tiempos en carrera\n"
        + "- Enum con atributo adicional (nombre con acentos)\n"
        + "- Excepciones: varias opciones (una con constantes vs varias clases)\n"
        + "- remove() en for-each: return inmediato tras eliminar\n"
        + "- Constructor vacio en excepcion para mensaje por defecto\n";

    // ================================================================
    // PRACTICA 3: SISTEMA DE GESTION DE BIBLIOTECA
    // ================================================================

    // ---- GENERO LITERARIO (enum con nombre) ----
    enum GeneroLiterario {
        POETICO("Poetico"),
        NARRATIVO("Narrativo"),
        DRAMATICO("Dramatico"),
        DIDACTICO("Didactico"),
        LIRICO("Lirico");

        private final String nombre;

        GeneroLiterario(String nombre) {
            this.nombre = nombre;
        }

        String getNombre() { return nombre; }
    }

    // ---- PERSONA ----
    static class Persona {
        protected String nombre, apellido;
        protected LocalDate fechaNacimiento;

        Persona(String nombre, String apellido, LocalDate fechaNacimiento) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.fechaNacimiento = fechaNacimiento;
        }

        String getNombre() { return nombre; }
        String getApellido() { return apellido; }
        LocalDate getFechaNacimiento() { return fechaNacimiento; }

        public String toString() {
            return "Persona [" + nombre + " " + apellido + ", "
                + fechaNacimiento + "]";
        }
    }

    // ---- AUTOR (hereda de Persona) ----
    static class Autor extends Persona {
        private GeneroLiterario generoLiterario;

        Autor(String nombre, String apellido, LocalDate fechaNacimiento,
              GeneroLiterario generoLiterario) {
            super(nombre, apellido, fechaNacimiento);
            this.generoLiterario = generoLiterario;
        }

        GeneroLiterario getGeneroLiterario() { return generoLiterario; }
        void setGeneroLiterario(GeneroLiterario generoLiterario) {
            this.generoLiterario = generoLiterario;
        }

        public String toString() {
            return "Autor [Genero: " + generoLiterario.getNombre()
                + "] " + nombre + " " + apellido;
        }
    }

    // ---- LIBRO ----
    static class Libro {
        private String titulo;
        private Autor autor;
        private String editorial;
        private LocalDate fechaPublicacion;
        private String isbn;
        private double precio;

        Libro(String titulo, Autor autor, String editorial,
              LocalDate fechaPublicacion, String isbn, double precio) {
            this.titulo = titulo;
            this.autor = autor;
            this.editorial = editorial;
            this.fechaPublicacion = fechaPublicacion;
            this.isbn = isbn;
            this.precio = precio;
        }

        String getIsbn() { return isbn; }
        String getTitulo() { return titulo; }
        Autor getAutor() { return autor; }

        public String toString() {
            return titulo + " | " + autor.getNombre() + " " + autor.getApellido()
                + " | " + editorial + " | " + fechaPublicacion
                + " | ISBN: " + isbn + " | " + precio + " euros";
        }
    }

    // ---- EXCEPCION ----
    static class LibroNoEncontradoException extends Exception {
        LibroNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }

    // ---- BIBLIOTECA ----
    static class Biblioteca {
        private ArrayList<Libro> libros;

        Biblioteca() {
            this.libros = new ArrayList<>();
        }

        void agregarLibro(Libro l) {
            libros.add(l);
        }

        void eliminarLibro(String isbn) throws LibroNoEncontradoException {
            for (Libro l : libros) {
                if (l.getIsbn().equals(isbn)) {
                    libros.remove(l);
                    System.out.println("  Libro con ISBN " + isbn + " eliminado correctamente");
                    return;
                }
            }
            throw new LibroNoEncontradoException(
                "Libro con ISBN " + isbn + " no encontrado en la biblioteca");
        }

        void mostrarBiblioteca() {
            for (Libro l : libros)
                System.out.println("    " + l);
        }
    }

    // ================================================================
    // PRACTICA 4: SISTEMA DE GESTION DE EVENTOS DEPORTIVOS
    // ================================================================

    // ---- INTERFAZ GANADOR ----
    interface Ganador {
        ArrayList<Participante> obtenerGanador();
    }

    // ---- EXCEPCIONES DE PARTICIPANTE ----
    static class ParticipanteNoValidoException extends Exception {
        static final byte NOMBRE = 0;
        static final byte APELLIDO = 1;
        static final byte EDAD = 2;

        private byte tipoError;

        ParticipanteNoValidoException(byte tipoError) {
            this.tipoError = tipoError;
        }

        public String toString() {
            switch (tipoError) {
                case NOMBRE:  return "El nombre del participante no es valido";
                case APELLIDO: return "El apellido del participante no es valido";
                case EDAD:    return "La edad del participante no es valida. No puede ser menor de 14 años";
                default:      return "Participante no valido";
            }
        }
    }

    // Alternativa: excepciones separadas (mas legible)
    static class ParticipanteNombreNoValidoException extends Exception {
        ParticipanteNombreNoValidoException() {
            super("El nombre del participante no es valido");
        }
        ParticipanteNombreNoValidoException(String mensaje) {
            super(mensaje);
        }
    }

    static class ParticipanteApellidoNoValidoException extends Exception {
        ParticipanteApellidoNoValidoException() {
            super("El apellido del participante no es valido");
        }
        ParticipanteApellidoNoValidoException(String mensaje) {
            super(mensaje);
        }
    }

    static class ParticipanteEdadNoValidaException extends Exception {
        ParticipanteEdadNoValidaException() {
            super("La edad del participante no es valida. No puede ser menor de 14 años");
        }
        ParticipanteEdadNoValidaException(String mensaje) {
            super(mensaje);
        }
    }

    static class JugadorNoEncontradoException extends Exception {
        JugadorNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }

    // ---- PARTICIPANTE ----
    static class Participante {
        protected String nombre, apellido;
        protected int edad;

        Participante(String nombre, String apellido, int edad)
                throws ParticipanteNombreNoValidoException,
                       ParticipanteApellidoNoValidoException,
                       ParticipanteEdadNoValidaException {
            if (nombre == null || nombre.trim().isEmpty())
                throw new ParticipanteNombreNoValidoException();
            if (apellido == null || apellido.trim().isEmpty())
                throw new ParticipanteApellidoNoValidoException();
            if (edad < 14)
                throw new ParticipanteEdadNoValidaException();

            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
        }

        String getNombre() { return nombre; }
        String getApellido() { return apellido; }
        int getEdad() { return edad; }

        public String toString() {
            return nombre + " " + apellido + " (" + edad + " anyos)";
        }
    }

    // ---- PARTICIPANTE CARRERA (hereda de Participante) ----
    static class ParticipanteCarrera extends Participante {
        private Duration tiempo;

        ParticipanteCarrera(String nombre, String apellido, int edad)
                throws ParticipanteNombreNoValidoException,
                       ParticipanteApellidoNoValidoException,
                       ParticipanteEdadNoValidaException {
            super(nombre, apellido, edad);
            this.tiempo = Duration.ZERO;
        }

        void setTiempo(Duration tiempo) { this.tiempo = tiempo; }
        Duration getTiempo() { return tiempo; }

        public String toString() {
            long horas = tiempo.toHours();
            long minutos = tiempo.toMinutes() % 60;
            return super.toString() + " - Tiempo: " + horas + "h " + minutos + "m";
        }
    }

    // ---- EQUIPO ----
    static class Equipo {
        private String nombre;
        private ArrayList<Participante> jugadores;
        private int puntos;

        Equipo(String nombre) {
            this.nombre = nombre;
            this.jugadores = new ArrayList<>();
            this.puntos = 0;
        }

        String getNombre() { return nombre; }
        int getPuntos() { return puntos; }
        void setPuntos(int puntos) { this.puntos = puntos; }
        ArrayList<Participante> getJugadores() { return jugadores; }

        void agregarJugador(Participante p) {
            jugadores.add(p);
        }

        void eliminarJugador(Participante p) throws JugadorNoEncontradoException {
            if (!jugadores.remove(p))
                throw new JugadorNoEncontradoException(
                    "El jugador " + p.getNombre() + " " + p.getApellido()
                    + " no se encuentra en el equipo " + nombre);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Equipo: ").append(nombre).append(" (Puntos: ").append(puntos).append(")\n");
            sb.append("  Jugadores:\n");
            for (Participante p : jugadores)
                sb.append("    - ").append(p.getNombre()).append("\n");
            return sb.toString();
        }
    }

    // ---- EVENTO DEPORTIVO (abstracta) ----
    static abstract class EventoDeportivo implements Ganador {
        protected String nombre;
        protected LocalDate fecha;
        protected String lugar;
        protected ArrayList<Participante> participantes;

        EventoDeportivo(String nombre, LocalDate fecha, String lugar) {
            this.nombre = nombre;
            this.fecha = fecha;
            this.lugar = lugar;
            this.participantes = new ArrayList<>();
        }

        void inscribirParticipante(Participante p) {
            participantes.add(p);
        }

        String getNombre() { return nombre; }

        public abstract void mostrarGanador();
    }

    // ---- CARRERA ----
    static class Carrera extends EventoDeportivo {
        private double distancia; // km

        Carrera(String nombre, LocalDate fecha, String lugar, double distancia) {
            super(nombre, fecha, lugar);
            this.distancia = distancia;
        }

        double getDistancia() { return distancia; }
        void setDistancia(double distancia) { this.distancia = distancia; }

        public ArrayList<Participante> obtenerGanador() {
            ArrayList<Participante> ganadores = new ArrayList<>();
            ParticipanteCarrera ganador = null;

            for (Participante p : participantes) {
                if (p instanceof ParticipanteCarrera) {
                    ParticipanteCarrera pc = (ParticipanteCarrera) p;
                    if (ganador == null || pc.getTiempo().compareTo(ganador.getTiempo()) < 0)
                        ganador = pc;
                }
            }
            if (ganador != null)
                ganadores.add(ganador);
            return ganadores;
        }

        public void mostrarGanador() {
            ArrayList<Participante> gan = obtenerGanador();
            if (!gan.isEmpty()) {
                Participante p = gan.get(0);
                System.out.println("  El ganador de " + nombre + " ha sido "
                    + p.getNombre() + " " + p.getApellido());
            }
        }
    }

    // ---- TORNEO DE FUTBOL ----
    static class TorneoFutbol extends EventoDeportivo {
        private ArrayList<Equipo> equipos;

        TorneoFutbol(String nombre, LocalDate fecha, String lugar) {
            super(nombre, fecha, lugar);
            this.equipos = new ArrayList<>();
        }

        ArrayList<Equipo> getEquipos() { return equipos; }

        void inscribirEquipo(Equipo e) {
            equipos.add(e);
        }

        public ArrayList<Participante> obtenerGanador() {
            ArrayList<Participante> ganadores = new ArrayList<>();
            Equipo ganador = null;

            for (Equipo e : equipos) {
                if (ganador == null || e.getPuntos() > ganador.getPuntos())
                    ganador = e;
            }
            if (ganador != null)
                ganadores.addAll(ganador.getJugadores());
            return ganadores;
        }

        public void mostrarGanador() {
            ArrayList<Participante> gan = obtenerGanador();
            System.out.print("  Los ganadores del torneo " + nombre + " han sido: ");
            for (int i = 0; i < gan.size(); i++) {
                System.out.print(gan.get(i).getNombre() + " " + gan.get(i).getApellido());
                if (i < gan.size() - 1)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V20: EJERCICIOS FINALES OO");
        System.out.println("Practica 3: Sistema de Gestion de Biblioteca");
        System.out.println("Practica 4: Sistema de Gestion de Eventos Deportivos");
        System.out.println();

        // ============================================================
        // PRACTICA 3: BIBLIOTECA
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  PRACTICA 3: BIBLIOTECA");
        System.out.println("=========================================");
        System.out.println();

        Autor autor = new Autor("Edu", "Torregrosa",
            LocalDate.of(1980, 5, 15), GeneroLiterario.DIDACTICO);

        Libro libro1 = new Libro("Programacion en Java", autor, "Anaya",
            LocalDate.of(2020, 3, 10), "978-84-123456-0-1", 29.95);
        Libro libro2 = new Libro("Programacion en C", autor, "Anaya",
            LocalDate.of(2021, 7, 22), "978-84-123456-0-2", 34.50);

        Biblioteca biblio = new Biblioteca();
        biblio.agregarLibro(libro1);
        biblio.agregarLibro(libro2);

        System.out.println("  Libros en la biblioteca:");
        biblio.mostrarBiblioteca();
        System.out.println();

        System.out.println("  Eliminando libro con ISBN 978-84-123456-0-1...");
        try {
            biblio.eliminarLibro("978-84-123456-0-1");
        } catch (LibroNoEncontradoException e) {
            System.out.println("  ERROR: " + e.getMessage());
        }

        System.out.println();
        System.out.println("  Intentando eliminar el mismo libro otra vez...");
        try {
            biblio.eliminarLibro("978-84-123456-0-1");
        } catch (LibroNoEncontradoException e) {
            System.out.println("  ERROR: " + e.getMessage());
        }

        System.out.println();
        System.out.println("  Libros restantes en la biblioteca:");
        biblio.mostrarBiblioteca();
        System.out.println();

        // ============================================================
        // PRACTICA 4: EVENTOS DEPORTIVOS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  PRACTICA 4: EVENTOS DEPORTIVOS");
        System.out.println("=========================================");
        System.out.println();

        // ---- CARRERA ----
        System.out.println("  --- CARRERA: MARATON DE VALENCIA ---");
        Carrera carrera = new Carrera("Maraton de Valencia",
            LocalDate.of(2025, 3, 15), "Valencia", 42.195);

        try {
            ParticipanteCarrera p1 = new ParticipanteCarrera("Pepe", "Gomez", 25);
            p1.setTiempo(Duration.ofHours(2).plusMinutes(40));
            carrera.inscribirParticipante(p1);

            ParticipanteCarrera p2 = new ParticipanteCarrera("John", "Perez", 40);
            p2.setTiempo(Duration.ofHours(2).plusMinutes(25));
            carrera.inscribirParticipante(p2);

            ParticipanteCarrera p3 = new ParticipanteCarrera("Ana", "Lopez", 30);
            p3.setTiempo(Duration.ofHours(3).plusMinutes(10));
            carrera.inscribirParticipante(p3);

            ParticipanteCarrera p4 = new ParticipanteCarrera("Luis", "Ruiz", 28);
            p4.setTiempo(Duration.ofHours(2).plusMinutes(55));
            carrera.inscribirParticipante(p4);

        } catch (ParticipanteNombreNoValidoException
                | ParticipanteApellidoNoValidoException
                | ParticipanteEdadNoValidaException e) {
            System.out.println("  ERROR: " + e.getMessage());
        }

        carrera.mostrarGanador();
        System.out.println();

        // ---- TORNEO DE FUTBOL ----
        System.out.println("  --- TORNEO DE FUTBOL: LIGA LOCAL ---");
        TorneoFutbol torneo = new TorneoFutbol("Liga Local",
            LocalDate.of(2025, 6, 1), "Ciudad Deportiva");

        Equipo valencia = new Equipo("Valencia CF");
        Equipo barcelona = new Equipo("FC Barcelona");

        try {
            valencia.agregarJugador(new Participante("Pepe", "Gomez", 25));
            valencia.agregarJugador(new Participante("Tom", "Garcia", 22));
            barcelona.agregarJugador(new Participante("Ana", "Lopez", 30));
            barcelona.agregarJugador(new Participante("Maria", "Sanchez", 27));
        } catch (ParticipanteNombreNoValidoException
                | ParticipanteApellidoNoValidoException
                | ParticipanteEdadNoValidaException e) {
            System.out.println("  ERROR: " + e.getMessage());
        }

        valencia.setPuntos(20);
        barcelona.setPuntos(15);

        torneo.inscribirEquipo(valencia);
        torneo.inscribirEquipo(barcelona);

        torneo.mostrarGanador();
        System.out.println();

        // ---- PRUEBA DE EXCEPCIONES DE PARTICIPANTE ----
        System.out.println("  --- PRUEBA DE EXCEPCIONES ---");

        try {
            // Participante con edad < 14
            Participante malParticipante = new Participante("Nino", "Peque", 12);
            System.out.println("  Creado: " + malParticipante);
        } catch (ParticipanteEdadNoValidaException e) {
            System.out.println("  " + e.getMessage());
        } catch (ParticipanteNombreNoValidoException
                | ParticipanteApellidoNoValidoException e) {
            System.out.println("  " + e.getMessage());
        }

        try {
            // Participante con nombre vacio
            Participante malParticipante = new Participante("", "Apellido", 20);
            System.out.println("  Creado: " + malParticipante);
        } catch (ParticipanteNombreNoValidoException e) {
            System.out.println("  " + e.getMessage());
        } catch (ParticipanteApellidoNoValidoException
                | ParticipanteEdadNoValidaException e) {
            System.out.println("  " + e.getMessage());
        }

        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("=========================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 6 - V20: EJERCICIOS FINALES OO)");
        System.out.println("=========================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Interfaces: Ganador con metodo obtenerGanador()");
        System.out.println("  - Clase abstracta EventoDeportivo que implementa interfaz");
        System.out.println("  - Herencia: Carrera y TorneoFutbol extienden EventoDeportivo");
        System.out.println("  - ParticipanteCarrera con Duration para medir tiempo");
        System.out.println("  - Enum GeneroLiterario con atributo adicional nombre");
        System.out.println("  - Excepciones: multiples clases vs una clase con constantes");
        System.out.println("  - remove() en for-each con return inmediato");
        System.out.println("  - Polimorfismo: ArrayList<Participante> como ganador");
    }
}
