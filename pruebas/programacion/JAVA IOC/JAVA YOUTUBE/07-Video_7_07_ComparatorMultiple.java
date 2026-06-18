import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Video_7_07_ComparatorMultiple {

    public static final String TITULO = "7-07 JAVA: Comparator multiple DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=dRvRFNWk1sw&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=148";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - COMPARATOR MULTIPLE (TEMA 7 - V07)\n"
        + "=========================================================\n\n"
        + "PROBLEMA: Ordenar una coleccion con objetos de DISTINTAS CLASES\n"
        + "          (Alumnos, Docentes, Direccion...) por un atributo comun (nombre)\n\n"
        + "SOLUCION 1: Comparator<Object> con instanceof (MENOS RECOMENDABLE)\n"
        + "  - La coleccion es ArrayList<Object>\n"
        + "  - El compare() usa instanceof para detectar el tipo\n"
        + "  - Hace casting y llama al metodo getNombre() de cada clase\n"
        + "  - Hay que manejar casos nulos\n"
        + "  - PROBLEMA: codigo muy complejo si hay muchas clases\n\n"
        + "SOLUCION 2: Interfaz comun (MAS RECOMENDABLE)\n"
        + "  - Crear una interfaz (ej: PersonaCentroEducativo) con metodo getNombre()\n"
        + "  - Todas las clases la implementan: class Alumno implements PersonaCentroEducativo\n"
        + "  - La coleccion es ArrayList<PersonaCentroEducativo>\n"
        + "  - El Comparator es mucho mas simple:\n"
        + "      public int compare(PersonaCentroEducativo p1, PersonaCentroEducativo p2) {\n"
        + "          return p1.getNombre().compareTo(p2.getNombre());\n"
        + "      }\n"
        + "  - VENTAJA: al anyadir nuevas clases, solo hay que implementar la interfaz\n\n"
        + "INTERFAZ PERSONA_CENTRO_EDUCATIVO:\n"
        + "  public interface PersonaCentroEducativo {\n"
        + "      String getNombre();\n"
        + "  }\n\n"
        + "COMPARATIVA:\n\n"
        + "SOLUCION 1 (Object + instanceof):\n"
        + "  class NombreComparator implements Comparator<Object> {\n"
        + "      public int compare(Object obj1, Object obj2) {\n"
        + "          String nombre1 = null, nombre2 = null;\n"
        + "          if (obj1 instanceof Alumno) nombre1 = ((Alumno) obj1).getNombre();\n"
        + "          else if (obj1 instanceof Docente) nombre1 = ((Docente) obj1).getNombre();\n"
        + "          // ... mas instanceof para cada clase\n"
        + "          if (obj2 instanceof Alumno) nombre2 = ((Alumno) obj2).getNombre();\n"
        + "          else if (obj2 instanceof Docente) nombre2 = ((Docente) obj2).getNombre();\n"
        + "          // Manejar nulos...\n"
        + "          if (nombre1 != null && nombre2 != null)\n"
        + "              return nombre1.compareTo(nombre2);\n"
        + "          if (nombre1 != null) return -1; // nombre2 es nulo -> va al final\n"
        + "          if (nombre2 != null) return 1;  // nombre1 es nulo -> va al final\n"
        + "          return 0; // ambos nulos\n"
        + "      }\n"
        + "  }\n\n"
        + "SOLUCION 2 (Interfaz comun):\n"
        + "  class NombreComparatorCentroEducativo implements Comparator<PersonaCentroEducativo> {\n"
        + "      public int compare(PersonaCentroEducativo p1, PersonaCentroEducativo p2) {\n"
        + "          return p1.getNombre().compareTo(p2.getNombre());\n"
        + "      }\n"
        + "  }\n\n"
        + "CLASES DEL EJEMPLO:\n"
        + "  - PersonaCentroEducativo (interfaz con getNombre())\n"
        + "  - Alumno implements PersonaCentroEducativo (+ otros atributos)\n"
        + "  - Docente implements PersonaCentroEducativo (+ otros atributos)\n"
        + "  - Direccion implements PersonaCentroEducativo (nueva, solo implementa interfaz)\n"
        + "  - NombreComparator (con Object) y NombreComparatorCentroEducativo (con interfaz)\n\n"
        + "CONCEPTOS CLAVE:\n"
        + "- Para ordenar objetos de distintas clases, necesitan un atributo comun\n"
        + "- Usar una interfaz comun es mas limpio que instanceof\n"
        + "- La interfaz obliga a que todas las clases tengan el metodo necesario\n"
        + "- Al anyadir nuevas clases, no hay que modificar el Comparator\n"
        + "- El codigo es mas mantenible y menos propenso a errores\n";

    // ================================================================
    // INTERFAZ COMUN
    // ================================================================
    interface PersonaCentroEducativo {
        String getNombre();
    }

    // ================================================================
    // CLASE ALUMNO (implementa la interfaz + Comparable si se quiere)
    // ================================================================
    static class Alumno implements PersonaCentroEducativo, Comparable<Alumno> {
        private String nombre, nia;
        private int edad;

        Alumno(String nombre, String nia, int edad) {
            this.nombre = nombre;
            this.nia = nia;
            this.edad = edad;
        }

        public String getNombre() { return nombre; }
        String getNia() { return nia; }
        int getEdad() { return edad; }

        public int compareTo(Alumno a) {
            return Integer.compare(this.edad, a.edad);
        }

        public String toString() {
            return "Alumno: " + nombre + " (nia:" + nia + ", " + edad + " anyos)";
        }
    }

    // ================================================================
    // CLASE DOCENTE (implementa la interfaz)
    // ================================================================
    static class Docente implements PersonaCentroEducativo {
        private String nombre, departamento;

        Docente(String nombre, String departamento) {
            this.nombre = nombre;
            this.departamento = departamento;
        }

        public String getNombre() { return nombre; }
        String getDepartamento() { return departamento; }

        public String toString() {
            return "Docente: " + nombre + " (dept: " + departamento + ")";
        }
    }

    // ================================================================
    // CLASE DIRECCION (nueva, implementa la interfaz)
    // ================================================================
    static class Direccion implements PersonaCentroEducativo {
        private String nombre, cargo;

        Direccion(String nombre, String cargo) {
            this.nombre = nombre;
            this.cargo = cargo;
        }

        public String getNombre() { return nombre; }
        String getCargo() { return cargo; }

        public String toString() {
            return "Direccion: " + nombre + " (cargo: " + cargo + ")";
        }
    }

    // ================================================================
    // SOLUCION 1: Comparator<Object> con instanceof
    // ================================================================
    static class NombreComparator implements Comparator<Object> {
        public int compare(Object obj1, Object obj2) {
            String nombre1 = null, nombre2 = null;

            // Obtener nombre de obj1
            if (obj1 instanceof Alumno)
                nombre1 = ((Alumno) obj1).getNombre();
            else if (obj1 instanceof Docente)
                nombre1 = ((Docente) obj1).getNombre();
            else if (obj1 instanceof Direccion)
                nombre1 = ((Direccion) obj1).getNombre();

            // Obtener nombre de obj2
            if (obj2 instanceof Alumno)
                nombre2 = ((Alumno) obj2).getNombre();
            else if (obj2 instanceof Docente)
                nombre2 = ((Docente) obj2).getNombre();
            else if (obj2 instanceof Direccion)
                nombre2 = ((Direccion) obj2).getNombre();

            // Comparar gestionando nulos
            if (nombre1 != null && nombre2 != null)
                return nombre1.compareTo(nombre2);
            if (nombre1 != null) return -1; // nombre2 nulo -> al final
            if (nombre2 != null) return 1;  // nombre1 nulo -> al final
            return 0; // ambos nulos -> iguales
        }
    }

    // ================================================================
    // SOLUCION 2: Comparator<PersonaCentroEducativo> con interfaz
    // ================================================================
    static class NombreComparatorCentroEducativo implements Comparator<PersonaCentroEducativo> {
        public int compare(PersonaCentroEducativo p1, PersonaCentroEducativo p2) {
            return p1.getNombre().compareTo(p2.getNombre());
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 7 - V07: COMPARATOR MULTIPLE");
        System.out.println("Ordenar colecciones con objetos de distintas clases");
        System.out.println();

        // ============================================================
        // SOLUCION 1: Con Object + instanceof
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  SOLUCION 1: Comparator<Object>");
        System.out.println("  (con instanceof)");
        System.out.println("=========================================");
        System.out.println();

        ArrayList<Object> instituto = new ArrayList<>();
        instituto.add(new Alumno("Ada", "111A", 20));
        instituto.add(new Alumno("Pep", "222A", 25));
        instituto.add(new Alumno("Jon", "333A", 21));
        instituto.add(new Docente("Ana", "Informatica"));
        instituto.add(new Docente("Ben", "Matematicas"));
        instituto.add(new Docente("Cal", "Lengua"));

        System.out.println("  Antes de ordenar:");
        for (Object o : instituto)
            System.out.println("    " + o);

        Collections.sort(instituto, new NombreComparator());

        System.out.println("  Despues de ordenar por nombre:");
        for (Object o : instituto)
            System.out.println("    " + o);
        System.out.println("  (Mezclados: Ada, Ana, Ben, Cal, Jon, Pep)");
        System.out.println();

        // ============================================================
        // SOLUCION 2: Con interfaz comun
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  SOLUCION 2: Interfaz comun");
        System.out.println("  (Comparator<PersonaCentroEducativo>)");
        System.out.println("=========================================");
        System.out.println();

        ArrayList<PersonaCentroEducativo> instituto2 = new ArrayList<>();
        instituto2.add(new Alumno("Ada", "111A", 20));
        instituto2.add(new Alumno("Pep", "222A", 25));
        instituto2.add(new Alumno("Jon", "333A", 21));
        instituto2.add(new Docente("Ana", "Informatica"));
        instituto2.add(new Docente("Ben", "Matematicas"));
        instituto2.add(new Docente("Cal", "Lengua"));

        // Anyadir una nueva clase Direccion (solo implementa la interfaz)
        instituto2.add(new Direccion("Kim", "Jefe de Estudios"));

        System.out.println("  Antes de ordenar (incluye Direccion):");
        for (PersonaCentroEducativo p : instituto2)
            System.out.println("    " + p);

        Collections.sort(instituto2, new NombreComparatorCentroEducativo());

        System.out.println("  Despues de ordenar por nombre:");
        for (PersonaCentroEducativo p : instituto2)
            System.out.println("    " + p);
        System.out.println("  (Direccion incluida sin modificar el Comparator!)");
        System.out.println();

        // ============================================================
        // COMPARATIVA DE CODIGO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  COMPARATIVA DE CODIGO");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  SOLUCION 1 (Object + instanceof):");
        System.out.println("    - Codigo mas largo y complejo");
        System.out.println("    - Hay que anyadir un if por cada nueva clase");
        System.out.println("    - Gestion manual de nulos");
        System.out.println("    - Propenso a errores");
        System.out.println();
        System.out.println("  SOLUCION 2 (Interfaz comun):");
        System.out.println("    - Codigo simple y claro");
        System.out.println("    - NO hay que modificar el Comparator al anyadir clases");
        System.out.println("    - La interfaz obliga a tener getNombre()");
        System.out.println("    - Mas mantenible");
        System.out.println();
        System.out.println("  REGLA: Si varias clases comparten un atributo,");
        System.out.println("  crear una INTERFAZ COMUN es casi siempre mejor");
        System.out.println("  que usar instanceof.");

        // ============================================================
        // FIN
        // ============================================================
        System.out.println();
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V07: COMPARATOR MULTIPLE)");
        System.out.println("==============================================================");
    }
}
