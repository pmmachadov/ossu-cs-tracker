import java.util.*;

class Video_7_14_TreeSetAvanzado {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "7-14 JAVA: TreeSet avanzado DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=UPYECuGiePc&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=155";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-14 - TREESET AVANZADO
        ================================================================

        Video:        7-14 JAVA: TreeSet avanzado
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7

        --- RESUMEN (transcripcion) ---

        TreeSet con objetos propios (Alumno). El orden se define mediante
        la interfaz Comparable (compareTo) o mediante un Comparator externo.
        Si compareTo devuelve 0, el elemento NO se inserta (es duplicado).

        --- COMPARABLE EN LA CLASE ---

        La clase Alumno implementa Comparable<Alumno>.
        compareTo() define el orden natural y la unicidad en TreeSet.
        Si dos objetos tienen compareTo() = 0, se consideran IGUALES
        y NO se inserta el segundo (aunque equals() diga otra cosa).

        --- TRES IMPLEMENTACIONES DE compareTo() ---

        1. ORDEN POR EDAD + NOMBRE (sin nia):
           int r = Integer.compare(this.edad, a.edad);
           if (r == 0) r = this.nombre.compareTo(a.nombre);
           return r;
           -> Permite insertar alumnos con mismo nia pero distinta edad/nombre.

        2. SOLO POR EDAD:
           return Integer.compare(this.edad, a.edad);
           -> No permite alumnos con la misma edad (se consideran iguales).

        3. POR NIA (primero), luego EDAD y NIA otra vez:
           int r = this.nia.compareTo(a.nia);
           if (r != 0) {  // nias distintos -> ordenar por edad
               r = Integer.compare(this.edad, a.edad);
               if (r == 0) r = this.nia.compareTo(a.nia);  // misma edad -> por nia
           }
           return r;
           -> NO permite nias duplicados, ordena por edad y luego nia.

        --- PRIORIDAD DEL COMPARATOR EXTERNO ---

        Al crear el TreeSet se puede pasar un Comparator:
          TreeSet<Alumno> ts = new TreeSet<>(new AlumnoPorEdadComparator());
        Este Comparator tiene PRIORIDAD sobre el compareTo() de la clase.
        El compareTo() solo se usa si NO se proporciona Comparator.

        --- COMPARATOR COMO CLASE SEPARADA ---

        class AlumnoPorEdadComparator implements Comparator<Alumno> {
            public int compare(Alumno a1, Alumno a2) {
                if (a1.getNia().equals(a2.getNia())) return 0;
                int r = Integer.compare(a1.getEdad(), a2.getEdad());
                if (r == 0) r = a1.getNia().compareTo(a2.getNia());
                return r;
            }
        }

        --- CONCEPTOS CLAVE ---

        - TreeSet usa compareTo/compare, NO equals/hashCode para unicidad
        - Si compareTo devuelve 0 -> elemento NO se inserta
        - Comparator externo tiene prioridad sobre Comparable
        - CompareTo debe ser consistente con equals (buena practica)
        - Para evitar nias duplicados: comparar nia primero en compareTo
        - Orden multiple: edad -> nombre -> nia como desempate final
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

        // compareTo: primero por NIA (unicidad), luego edad, luego nia (desempate)
        public int compareTo(Alumno a) {
            int r = this.nia.compareTo(a.nia);
            if (r != 0) {  // nias distintos
                r = Integer.compare(this.edad, a.edad);
                if (r == 0)
                    r = this.nia.compareTo(a.nia);
            }
            return r;
        }

        public String toString() {
            return nombre + "(" + nia + "," + edad + ")";
        }
    }

    // ================================================================
    // COMPARATOR EXTERNO (por edad + nia)
    // ================================================================
    static class AlumnoPorEdadComparator implements Comparator<Alumno> {
        public int compare(Alumno a1, Alumno a2) {
            // Si mismo nia -> iguales (no insertar)
            if (a1.getNia().equals(a2.getNia())) return 0;
            // Ordenar por edad
            int r = Integer.compare(a1.getEdad(), a2.getEdad());
            // Si misma edad, ordenar por nia
            if (r == 0) r = a1.getNia().compareTo(a2.getNia());
            return r;
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // 1. TREESET CON COMPARABLE (por nia + edad)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  1. TREESET CON COMPARABLE (nia+edad)");
        System.out.println("=========================================");

        TreeSet<Alumno> alumnos = new TreeSet<>();

        Alumno a1 = new Alumno("Pep", "222A", 25);
        Alumno a2 = new Alumno("Sam", "555A", 18);
        Alumno a3 = new Alumno("Paul", "666A", 18);
        Alumno a4 = new Alumno("Cal", "666A", 20);  // mismo nia que Paul
        Alumno a5 = new Alumno("Tim", "777A", 20);
        Alumno a6 = new Alumno("Pep", "222A", 25);  // mismo nia que a1

        alumnos.add(a1);
        System.out.println("  add(Pep 222A 25):       " + alumnos);
        alumnos.add(a2);
        System.out.println("  add(Sam 555A 18):       " + alumnos);
        alumnos.add(a3);
        System.out.println("  add(Paul 666A 18):      " + alumnos);
        alumnos.add(a4);
        System.out.println("  add(Cal 666A 20):       " + alumnos + " (NO insertado, nia repetido)");
        alumnos.add(a5);
        System.out.println("  add(Tim 777A 20):       " + alumnos);
        alumnos.add(a6);
        System.out.println("  add(Pep 222A 25):       " + alumnos + " (NO insertado, nia repetido)");
        System.out.println();

        // ============================================================
        // 2. TREESET CON COMPARATOR EXTERNO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  2. TREESET CON COMPARATOR EXTERNO");
        System.out.println("=========================================");

        TreeSet<Alumno> alumnosComp = new TreeSet<>(new AlumnoPorEdadComparator());

        alumnosComp.add(a1);
        alumnosComp.add(a2);
        alumnosComp.add(a3);
        alumnosComp.add(a4);  // mismo nia que Paul -> no inserta
        alumnosComp.add(a5);
        alumnosComp.add(a6);  // mismo nia que a1 -> no inserta

        System.out.println("  TreeSet con AlumnoPorEdadComparator:");
        for (Alumno a : alumnosComp)
            System.out.println("    " + a);
        System.out.println("  (Ordenado por edad, luego nia. Sin duplicados de nia)");
        System.out.println();

        // ============================================================
        // 3. COMPARACION: compareTo vs Comparator
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  3. COMPARACION: Comparable vs Comparator");
        System.out.println("=========================================");
        System.out.println("  Comparable en Alumno:   nia -> edad -> nia");
        System.out.println("  Comparator externo:     nia -> edad -> nia (misma logica)");
        System.out.println();
        System.out.println("  REGLA: Comparator externo SIEMPRE tiene prioridad");
        System.out.println("  sobre Comparable de la clase.");
        System.out.println("  Si se pasa Comparator en el constructor de TreeSet,");
        System.out.println("  el compareTo() de la clase NO se usa.");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V14: TREESET AVANZADO)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - TreeSet usa compareTo/compare, no equals/hashCode");
        System.out.println("  - compareTo=0 significa duplicado (no se inserta)");
        System.out.println("  - Comparator externo tiene prioridad sobre Comparable");
        System.out.println("  - Para evitar nias duplicados: comparar nia primero");
        System.out.println("  - Orden multiple: edad, nombre, nia como desempate");
    }
}
