import java.util.*;

class Video_7_19_TreeMapAvanzado {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "7-19 JAVA: TreeMap avanzado DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=Q4s1RMSXzX8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=160";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-19 - TREEMAP AVANZADO
        ================================================================

        Video:        7-19 JAVA: TreeMap avanzado
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7

        --- RESUMEN (transcripcion) ---

        Implementacion alternativa al mapa anidado del video anterior.
        En lugar de usar HashMap<String, ArrayList<Double>> como valor
        (propenso a errores tipograficos), se crean dos clases auxiliares:
        un tipo enumerado Modulo y una clase Calificacion.

        --- PROBLEMA DEL MAPA ANIDADO CON STRINGS ---

        HashMap<String, ArrayList<Double>> como valor interno:
          - Si se escribe mal el modulo ("Programacion" vs "Programaci\u00f3n")
            se crean dos entradas distintas sin aviso
          - Mayusculas/minusculas crean modulos duplicados
          - Dificulta la legibilidad del codigo

        --- SOLUCION: TIPO ENUMERADO MODULO ---

        enum Modulo {
            PROGRAMACION("PRG", "Programacion"),
            BASES_DATOS("BBDD", "Base de Datos"),
            SISTEMAS("SIS", "Sistemas Informaticos"),
            LENGUAJES("LDM", "Lenguajes de Marcas"),
            ENTORNOS("ED", "Entornos de Desarrollo");

            private String abreviatura;
            private String nombre;

            Modulo(String abreviatura, String nombre) {
                this.abreviatura = abreviatura;
                this.nombre = nombre;
            }

            String getAbreviatura() { return abreviatura; }
            String getNombre() { return nombre; }
        }

        Ventajas:
          - Solo se pueden usar los modulos definidos
          - El IDE autocompleta con Modulo.PROGRAMACION, etc.
          - No hay errores tipograficos
          - Se puede obtener abreviatura y nombre completo

        --- CLASE CALIFICACION ---

        class Calificacion {
            private Modulo modulo;
            private ArrayList<Double> notas;

            Calificacion(Modulo modulo) {
                this.modulo = modulo;
                this.notas = new ArrayList<>();
            }

            Modulo getModulo() { return modulo; }
            ArrayList<Double> getNotas() { return notas; }
        }

        --- MAPA PRINCIPAL ---

        TreeMap<Alumno, ArrayList<Calificacion>> notasAlumnos;

        Cada alumno tiene una lista de Calificacion, y cada
        Calificacion tiene un Modulo (enum) y una lista de notas.

        --- METODO AGREGAR NOTA ---

        static void agregarNota(Alumno alumno, Modulo modulo, double nota) {
            // 1. Obtener calificaciones del alumno (o crear lista vacia)
            ArrayList<Calificacion> califAlumno = notasAlumnos.get(alumno);
            if (califAlumno == null) {
                califAlumno = new ArrayList<>();
                notasAlumnos.put(alumno, califAlumno);
            }
            // 2. Buscar si ya existe calificacion para ese modulo
            Calificacion calif = null;
            for (Calificacion c : califAlumno) {
                if (c.getModulo() == modulo) {
                    calif = c;
                    break;
                }
            }
            // 3. Si no existe, crear nueva calificacion
            if (calif == null) {
                calif = new Calificacion(modulo);
                califAlumno.add(calif);
            }
            // 4. Anyadir la nota
            calif.getNotas().add(nota);
        }

        --- RECORRIDO CON DOBLE FOR-EACH ---

        for (Map.Entry<Alumno, ArrayList<Calificacion>> entry
                : notasAlumnos.entrySet()) {
            Alumno a = entry.getKey();
            ArrayList<Calificacion> calificaciones = entry.getValue();

            // Mostrar alumno
            for (Calificacion c : calificaciones) {
                // c.getModulo().getNombre() -> "Programacion"
                // c.getNotas() -> [8.5, 9.0]
            }
        }

        --- CONCEPTOS CLAVE ---

        - Usar enum en lugar de String evita errores tipograficos
        - Clase Calificacion encapsula modulo + notas
        - TreeMap ordena alumnos por su compareTo()
        - Tres partes en agregarNota:
          1. Crear alumno si no existe
          2. Buscar calificacion del modulo
          3. Crear calificacion o anyadir nota a la existente
        - Ultimo video de colecciones del Tema 7
        ================================================================
        """;

    // ================================================================
    // TIPO ENUMERADO MODULO
    // ================================================================
    enum Modulo {
        PROGRAMACION("PRG", "Programacion"),
        BASES_DATOS("BBDD", "Base de Datos"),
        SISTEMAS("SIS", "Sistemas Informaticos"),
        LENGUAJES("LDM", "Lenguajes de Marcas"),
        ENTORNOS("ED", "Entornos de Desarrollo");

        private String abreviatura;
        private String nombre;

        Modulo(String abreviatura, String nombre) {
            this.abreviatura = abreviatura;
            this.nombre = nombre;
        }

        String getAbreviatura() { return abreviatura; }
        String getNombre() { return nombre; }
    }

    // ================================================================
    // CLASE CALIFICACION
    // ================================================================
    static class Calificacion {
        private Modulo modulo;
        private ArrayList<Double> notas;

        Calificacion(Modulo modulo) {
            this.modulo = modulo;
            this.notas = new ArrayList<>();
        }

        Modulo getModulo() { return modulo; }
        ArrayList<Double> getNotas() { return notas; }
    }

    // ================================================================
    // CLASE ALUMNO
    // ================================================================
    static class Alumno implements Comparable<Alumno> {
        private String nombre, nia;
        private int edad;

        Alumno(String nombre, String nia, int edad) {
            this.nombre = nombre;
            this.nia = nia;
            this.edad = edad;
        }

        String getNombre() { return nombre; }
        String getNia() { return nia; }
        int getEdad() { return edad; }

        public int compareTo(Alumno a) {
            int r = this.nia.compareTo(a.nia);
            if (r != 0) {
                r = Integer.compare(this.edad, a.edad);
                if (r == 0) {
                    r = this.nombre.compareTo(a.nombre);
                    if (r == 0) r = this.nia.compareTo(a.nia);
                }
            }
            return r;
        }

        public String toString() {
            return nombre + "(" + nia + "," + edad + ")";
        }
    }

    // ================================================================
    // VARIABLES ESTATICAS
    // ================================================================
    static TreeMap<Alumno, ArrayList<Calificacion>> notasAlumnos
        = new TreeMap<>();

    // ================================================================
    // METODO AGREGAR NOTA
    // ================================================================
    static void agregarNota(Alumno alumno, Modulo modulo, double nota) {
        // 1. Obtener o crear lista de calificaciones del alumno
        ArrayList<Calificacion> califAlumno = notasAlumnos.get(alumno);
        if (califAlumno == null) {
            califAlumno = new ArrayList<>();
            notasAlumnos.put(alumno, califAlumno);
        }

        // 2. Buscar si ya existe calificacion para ese modulo
        Calificacion calif = null;
        for (Calificacion c : califAlumno) {
            if (c.getModulo() == modulo) {
                calif = c;
                break;
            }
        }

        // 3. Si no existe calificacion para el modulo, crearla
        if (calif == null) {
            calif = new Calificacion(modulo);
            califAlumno.add(calif);
        }

        // 4. Anyadir la nota
        calif.getNotas().add(nota);
    }

    // ================================================================
    // METODO MOSTRAR DATOS
    // ================================================================
    static void mostrarDatos() {
        System.out.println("  Notas de los alumnos:");
        System.out.println();

        for (Map.Entry<Alumno, ArrayList<Calificacion>> entry
                : notasAlumnos.entrySet()) {

            Alumno a = entry.getKey();
            ArrayList<Calificacion> calificaciones = entry.getValue();

            System.out.println("  Alumno: " + a.getNombre()
                + " (" + a.getNia() + ", " + a.getEdad() + " anyos)");

            for (Calificacion c : calificaciones) {
                String nombreMod = c.getModulo().getNombre();
                ArrayList<Double> notas = c.getNotas();
                System.out.println("    " + nombreMod + ": " + notas);
            }
            System.out.println();
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // CREAR ALUMNOS Y ANYADIR NOTAS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  ANYADIENDO NOTAS A ALUMNOS");
        System.out.println("=========================================");

        Alumno pep = new Alumno("Pep", "111A", 20);
        Alumno tom = new Alumno("Tom", "222B", 21);
        Alumno sam = new Alumno("Sam", "333C", 22);

        // Pep: 2 en Programacion, 1 en BD, 1 en Sistemas
        agregarNota(pep, Modulo.PROGRAMACION, 8.5);
        agregarNota(pep, Modulo.PROGRAMACION, 9.0);
        agregarNota(pep, Modulo.BASES_DATOS, 7.5);
        agregarNota(pep, Modulo.SISTEMAS, 6.0);

        // Tom: 1 en Programacion, 2 en BD, 1 en Sistemas
        agregarNota(tom, Modulo.PROGRAMACION, 7.0);
        agregarNota(tom, Modulo.BASES_DATOS, 9.0);
        agregarNota(tom, Modulo.BASES_DATOS, 8.0);
        agregarNota(tom, Modulo.SISTEMAS, 7.5);

        // Sam: 1 en Programacion, 1 en BD, 2 en Sistemas
        agregarNota(sam, Modulo.PROGRAMACION, 6.5);
        agregarNota(sam, Modulo.BASES_DATOS, 8.0);
        agregarNota(sam, Modulo.SISTEMAS, 7.0);
        agregarNota(sam, Modulo.SISTEMAS, 8.5);

        // Modulo nuevo (LENGUAJES) para Pep
        agregarNota(pep, Modulo.LENGUAJES, 7.9);

        mostrarDatos();

        // ============================================================
        // DEMO: CAMBIO DE EDAD AFECTA ORDEN
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  CAMBIO DE EDAD -> CAMBIA EL ORDEN");
        System.out.println("=========================================");
        System.out.println("  (Simulando Pep con 24 anyos en lugar de 20)");
        System.out.println();

        TreeMap<Alumno, ArrayList<Calificacion>> copia
            = new TreeMap<>(notasAlumnos);

        // Simular cambio de edad creando nuevo alumno
        Alumno pepMayor = new Alumno("Pep", "111A", 24);
        copia.put(pepMayor, copia.remove(
            new Alumno("Pep", "111A", 20)));

        for (Map.Entry<Alumno, ArrayList<Calificacion>> entry
                : copia.entrySet()) {
            Alumno a = entry.getKey();
            System.out.println("  " + a.getNombre() + " (" + a.getEdad() + " anyos)");
        }
        System.out.println("  (Pep ahora es el ultimo por tener 24 anyos)");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V19: TREEMAP AVANZADO)");
        System.out.println("  FIN DE LA PARTE TEORICA DE COLECCIONES");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Enum Modulo evita errores con Strings");
        System.out.println("  - Clase Calificacion encapsula modulo + notas");
        System.out.println("  - TreeMap ordena por edad (compareTo de Alumno)");
        System.out.println("  - Tres pasos en agregarNota: alumno, modulo, nota");
        System.out.println("  - Recorrido con entrySet + for-each anidado");
    }
}
