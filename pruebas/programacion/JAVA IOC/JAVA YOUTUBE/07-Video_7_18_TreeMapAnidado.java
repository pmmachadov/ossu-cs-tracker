import java.util.*;

class Video_7_18_TreeMapAnidado {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "7-18 JAVA: TreeMap anidado DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=H3_Wuis_Ipg&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=159";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-18 - TREEMAP ANIDADO
        ================================================================

        Video:        7-18 JAVA: TreeMap anidado
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7

        --- RESUMEN (transcripcion) ---

        TreeMap con objetos propios como clave y estructuras complejas
        como valor. Dos ejemplos:

        1) TreeMap<Alumno, ArrayList<Double>>: notas de cada alumno
        2) TreeMap<Alumno, HashMap<String, ArrayList<Double>>>: notas
           separadas por modulo (mapa anidado)

        --- CLASE ALUMNO ---

        Implementa Comparable<Alumno> con compareTo() que:
          - Compara NIA primero: si mismo nia -> 0 (no inserta)
          - Si distinto nia: ordena por edad
          - Si misma edad: ordena por nombre
          - Si mismo nombre y edad: ordena por nia (desempate)

        --- EJEMPLO 1: NOTAS POR ALUMNO ---

        TreeMap<Alumno, ArrayList<Double>> notasDam = new TreeMap<>();

        void agregarNota(TreeMap<Alumno, ArrayList<Double>> map,
                          Alumno a, double nota) {
            ArrayList<Double> notas = map.getOrDefault(a, new ArrayList<>());
            notas.add(nota);
            map.put(a, notas);
        }

        - getOrDefault: si alumno existe -> devuelve sus notas
        - getOrDefault: si alumno NO existe -> devuelve lista vacia
        - Se anyade la nota a la lista
        - put reemplaza la lista del alumno (o la inserta si es nuevo)
        - Si dos alumnos tienen el mismo NIA, la nota se asigna al
          primero (el que ya esta en el mapa)

        --- EJEMPLO 2: MAPA ANIDADO (notas por modulo) ---

        TreeMap<Alumno, HashMap<String, ArrayList<Double>>> notasCompleto;

        Estructura:
          Alumno (clave)
            +-- HashMap<String, ArrayList<Double>> (valor)
                  +-- "Programacion" -> [8.5, 9.0]
                  +-- "Base de Datos" -> [7.5]
                  +-- "Sistemas"      -> [6.0, 8.5]

        void agregarNota(Map<Alumno, HashMap<String, ArrayList<Double>>> map,
                          Alumno a, String modulo, double nota) {
            // 1. Obtener o crear el mapa interno del alumno
            HashMap<String, ArrayList<Double>> notasAlumno = map.get(a);
            if (notasAlumno == null) {
                notasAlumno = new HashMap<>();
                map.put(a, notasAlumno);
            }
            // 2. Obtener o crear la lista de notas del modulo
            ArrayList<Double> notasModulo = notasAlumno.get(modulo);
            if (notasModulo == null) {
                notasModulo = new ArrayList<>();
                notasAlumno.put(modulo, notasModulo);
            }
            // 3. Anyadir la nota
            notasModulo.add(nota);
        }

        --- RECORRIDO DEL MAPA ANIDADO ---

        for (Map.Entry<Alumno, HashMap<String, ArrayList<Double>>> entry
                : map.entrySet()) {
            Alumno a = entry.getKey();
            HashMap<String, ArrayList<Double>> notas = entry.getValue();
            System.out.println("Alumno: " + a.getNombre() + " (" + a.getNia() + ")");
            for (Map.Entry<String, ArrayList<Double>> modEntry
                    : notas.entrySet()) {
                System.out.println("  " + modEntry.getKey()
                    + ": " + modEntry.getValue());
            }
        }

        --- CONCEPTOS CLAVE ---

        - TreeMap ordena por clave usando Comparable/Comparator
        - getOrDefault devuelve valor o default (evita nulls)
        - Mapa anidado: valor de un mapa es otro mapa
        - Si dos claves son "iguales" (compareTo=0), la segunda
          NO se inserta y las operaciones afectan a la primera
        - Recorrido con entrySet anidado para mapas de 2 niveles
        - La clave del mapa debe implementar correctamente compareTo
        ================================================================
        """;

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

        // compareTo: nia -> edad -> nombre -> nia
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
    // METODOS AUXILIARES
    // ================================================================

    // Anyade nota a un alumno en el TreeMap (Ejemplo 1)
    static void agregarNota(TreeMap<Alumno, ArrayList<Double>> map,
                             Alumno a, double nota) {
        ArrayList<Double> notas = map.getOrDefault(a, new ArrayList<>());
        notas.add(nota);
        map.put(a, notas);
    }

    // Anyade nota a un alumno en un modulo especifico (Ejemplo 2)
    static void agregarNotaAnidado(
            TreeMap<Alumno, HashMap<String, ArrayList<Double>>> map,
            Alumno a, String modulo, double nota) {

        // 1. Obtener o crear mapa interno del alumno
        HashMap<String, ArrayList<Double>> notasAlumno = map.get(a);
        if (notasAlumno == null) {
            notasAlumno = new HashMap<>();
            map.put(a, notasAlumno);
        }
        // 2. Obtener o crear lista de notas del modulo
        ArrayList<Double> notasModulo = notasAlumno.get(modulo);
        if (notasModulo == null) {
            notasModulo = new ArrayList<>();
            notasAlumno.put(modulo, notasModulo);
        }
        // 3. Anyadir la nota
        notasModulo.add(nota);
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: TreeMap<Alumno, ArrayList<Double>>
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 1: NOTAS POR ALUMNO");
        System.out.println("=========================================");

        TreeMap<Alumno, ArrayList<Double>> notasDam = new TreeMap<>();

        Alumno a1 = new Alumno("Pep", "111A", 20);
        Alumno a2 = new Alumno("Jon", "222B", 18);
        Alumno a3 = new Alumno("Sam", "333C", 21);
        Alumno a4 = new Alumno("Bill", "444D", 19);
        Alumno a5 = new Alumno("Cal", "111A", 22);  // mismo nia que a1

        agregarNota(notasDam, a1, 9.2);
        agregarNota(notasDam, a1, 7.5);
        agregarNota(notasDam, a2, 8.1);
        agregarNota(notasDam, a2, 9.0);
        agregarNota(notasDam, a3, 7.5);
        agregarNota(notasDam, a4, 8.2);

        // Cal tiene mismo nia que Pep -> la nota se asigna a Pep
        agregarNota(notasDam, a5, 10.0);
        System.out.println("  (Cal con mismo nia que Pep -> nota 10 asignada a Pep)");

        System.out.println("  Notas de alumnos (ordenados por edad):");
        for (Map.Entry<Alumno, ArrayList<Double>> e : notasDam.entrySet()) {
            System.out.println("    " + e.getKey().getNombre()
                + " (" + e.getKey().getEdad() + " anyos): " + e.getValue());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 2: TreeMap<Alumno, HashMap<String, ArrayList<Double>>>
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 2: MAPA ANIDADO (notas por modulo)");
        System.out.println("=========================================");

        TreeMap<Alumno, HashMap<String, ArrayList<Double>>> notasCompleto
            = new TreeMap<>();

        Alumno pep = new Alumno("Pep", "111A", 20);
        Alumno tom = new Alumno("Tom", "222B", 21);
        Alumno sam = new Alumno("Sam", "333C", 22);

        // Pep: 2 en Programacion, 1 en BD, 1 en Sistemas
        agregarNotaAnidado(notasCompleto, pep, "Programacion", 8.5);
        agregarNotaAnidado(notasCompleto, pep, "Programacion", 9.0);
        agregarNotaAnidado(notasCompleto, pep, "Base de Datos", 7.5);
        agregarNotaAnidado(notasCompleto, pep, "Sistemas", 6.0);

        // Tom: 1 en Programacion, 2 en BD, 1 en Sistemas
        agregarNotaAnidado(notasCompleto, tom, "Programacion", 7.0);
        agregarNotaAnidado(notasCompleto, tom, "Base de Datos", 9.0);
        agregarNotaAnidado(notasCompleto, tom, "Base de Datos", 8.0);
        agregarNotaAnidado(notasCompleto, tom, "Sistemas", 7.5);

        // Sam: 1 en Programacion, 1 en BD, 2 en Sistemas
        agregarNotaAnidado(notasCompleto, sam, "Programacion", 6.5);
        agregarNotaAnidado(notasCompleto, sam, "Base de Datos", 8.0);
        agregarNotaAnidado(notasCompleto, sam, "Sistemas", 7.0);
        agregarNotaAnidado(notasCompleto, sam, "Sistemas", 8.5);

        // Mostrar datos anidados
        for (Map.Entry<Alumno, HashMap<String, ArrayList<Double>>> entry
                : notasCompleto.entrySet()) {
            Alumno a = entry.getKey();
            HashMap<String, ArrayList<Double>> modulos = entry.getValue();
            System.out.println("  Alumno: " + a.getNombre()
                + " (" + a.getNia() + ", " + a.getEdad() + " anyos)");
            for (Map.Entry<String, ArrayList<Double>> modEntry
                    : modulos.entrySet()) {
                System.out.println("    " + modEntry.getKey()
                    + ": " + modEntry.getValue());
            }
            System.out.println();
        }

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V18: TREEMAP ANIDADO)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - TreeMap con objetos propios como clave");
        System.out.println("  - getOrDefault para valores por defecto");
        System.out.println("  - Mapa anidado: mapa dentro de mapa");
        System.out.println("  - entrySet() doble para recorrer mapas anidados");
        System.out.println("  - compareTo controla orden y unicidad de claves");
        System.out.println("  - Claves con mismo NIA se consideran iguales");
    }
}
