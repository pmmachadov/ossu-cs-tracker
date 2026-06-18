import java.util.ArrayList;
import java.util.Iterator;

class Video_7_03_ImplementarIterable {

    public static final String TITULO = "7-03 JAVA: Implementar la interfaz Iterable DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=rpFq5O9XIAg&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=144";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - IMPLEMENTAR ITERABLE (TEMA 7 - V03)\n"
        + "=========================================================\n\n"
        + "TRES FORMAS DE IMPLEMENTAR ITERABLE:\n\n"
        + "FORMA 1: Delegar en el iterador de ArrayList:\n"
        + "  public Iterator<Alumno> iterator() {\n"
        + "      return alumnos.iterator();\n"
        + "  }\n"
        + "  (Reutiliza el iterador ya implementado por ArrayList)\n\n"
        + "FORMA 2: Clase interna que implementa Iterator:\n"
        + "  private class IteradorGrupo implements Iterator<Alumno> {\n"
        + "      private int posicion = 0;\n"
        + "      public boolean hasNext() { return posicion < alumnos.size(); }\n"
        + "      public Alumno next() { return alumnos.get(posicion++); }\n"
        + "  }\n"
        + "  public Iterator<Alumno> iterator() {\n"
        + "      return new IteradorGrupo();\n"
        + "  }\n\n"
        + "FORMA 3: Clase anonima (sin crear clase interna):\n"
        + "  public Iterator<Alumno> iterator() {\n"
        + "      return new Iterator<Alumno>() {\n"
        + "          private int posicion = 0;\n"
        + "          public boolean hasNext() { return posicion < alumnos.size(); }\n"
        + "          public Alumno next() { return alumnos.get(posicion++); }\n"
        + "      };\n"
        + "  }\n"
        + "  (IMPORTANTE: punto y coma despues de la llave de cierre de la clase anonima)\n\n"
        + "PERSONALIZACION DEL ITERADOR:\n"
        + "- Podemos modificar hasNext() para filtrar elementos\n"
        + "- Ejemplo: solo alumnos que tengan NIA (no nulo)\n"
        + "  public boolean hasNext() {\n"
        + "      while (posicion < alumnos.size() && alumnos.get(posicion).getNia() == null)\n"
        + "          posicion++;\n"
        + "      return posicion < alumnos.size();\n"
        + "  }\n"
        + "- De esta forma, el bucle for-each y el iterador solo recorren alumnos con NIA\n\n"
        + "CLASES DEL EJEMPLO:\n"
        + "  Alumno: nombre, nia (String), edad (int)\n"
        + "  Grupo implements Iterable<Alumno>: nombre, alumnos (ArrayList<Alumno>)\n"
        + "    - agregarAlumno(Alumno)\n"
        + "    - listarAlumnos() (usa el iterador personalizado)\n"
        + "    - iterator() personalizado\n"
        + "  Instituto: Main que prueba todo\n\n"
        + "DIFERENCIA CLAVE:\n"
        + "- for-each sobre Grupo usa el iterador personalizado (filtra NIA)\n"
        + "- for-each sobre alumnos (ArrayList) usa el iterador de ArrayList (sin filtro)\n"
        + "- El metodo listarAlumnos() debe usar el iterador, no el ArrayList directamente\n\n"
        + "CONCEPTOS CLAVE:\n"
        + "- Implementar Iterable permite recorrer una clase con for-each y iteradores\n"
        + "- El metodo iterator() debe devolver un Iterator<T>\n"
        + "- Podemos personalizar hasNext() y next() para filtrar datos\n"
        + "- Clase interna: reutilizable, mas organizada\n"
        + "- Clase anonima: compacta, para un solo uso\n"
        + "- El for-each de Java usa internamente el iterador de la clase\n";

    // ================================================================
    // CLASE ALUMNO
    // ================================================================
    static class Alumno {
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

        public String toString() {
            return "Alumno{nombre='" + nombre + "', nia='" + nia + "', edad=" + edad + "}";
        }
    }

    // ================================================================
    // CLASE GRUPO (implementa Iterable<Alumno>)
    // ================================================================
    static class Grupo implements Iterable<Alumno> {
        private String nombre;
        private ArrayList<Alumno> alumnos;

        Grupo(String nombre) {
            this.nombre = nombre;
            this.alumnos = new ArrayList<>();
        }

        String getNombre() { return nombre; }

        void agregarAlumno(Alumno a) {
            alumnos.add(a);
        }

        // Metodo que lista alumnos usando EL ITERADOR (respeta el filtro)
        void listarAlumnos() {
            Iterator<Alumno> it = iterator();
            while (it.hasNext()) {
                System.out.println("    " + it.next());
            }
        }

        // FORMA 3: Clase anonima (mas compacta)
        // El iterador personalizado: solo devuelve alumnos con NIA no nulo
        public Iterator<Alumno> iterator() {
            return new Iterator<Alumno>() {
                private int posicion = 0;

                public boolean hasNext() {
                    // Saltar alumnos con NIA nulo
                    while (posicion < alumnos.size()
                           && alumnos.get(posicion).getNia() == null) {
                        posicion++;
                    }
                    return posicion < alumnos.size();
                }

                public Alumno next() {
                    return alumnos.get(posicion++);
                }
            };
        }

        // FORMA 2: Usar clase interna (comentada como alternativa)
        /*
        private class IteradorGrupo implements Iterator<Alumno> {
            private int posicion = 0;
            public boolean hasNext() {
                while (posicion < alumnos.size()
                       && alumnos.get(posicion).getNia() == null) {
                    posicion++;
                }
                return posicion < alumnos.size();
            }
            public Alumno next() {
                return alumnos.get(posicion++);
            }
        }

        public Iterator<Alumno> iterator() {
            return new IteradorGrupo();
        }
        */

        // FORMA 1: Delegar en ArrayList (comentada)
        /*
        public Iterator<Alumno> iterator() {
            return alumnos.iterator();
        }
        */
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 7 - V03: IMPLEMENTAR INTERFAZ ITERABLE");
        System.out.println("Tres formas de implementar Iterable en una clase propia");
        System.out.println();

        // Crear grupo y anyadir alumnos
        Grupo dam = new Grupo("1 DAM");

        // Alumnos con NIA
        dam.agregarAlumno(new Alumno("Pepe", "1111A", 20));
        dam.agregarAlumno(new Alumno("Tom", "2222B", 19));
        dam.agregarAlumno(new Alumno("Jon", "3333C", 22));
        dam.agregarAlumno(new Alumno("Sam", "4444D", 21));
        dam.agregarAlumno(new Alumno("Tim", "5555E", 18));

        // Alumno SIN NIA (null)
        dam.agregarAlumno(new Alumno("Cal", null, 25));

        System.out.println("=========================================");
        System.out.println("  GRUPO: " + dam.getNombre());
        System.out.println("=========================================");
        System.out.println();

        // ============================================================
        // 1. RECORRIDO CON ITERADOR EXPLICITO
        // ============================================================
        System.out.println("  1. RECORRIDO CON ITERADOR EXPLICITO:");
        System.out.println("     (Filtrado: solo alumnos con NIA)");
        System.out.println();

        Iterator<Alumno> it = dam.iterator();
        while (it.hasNext()) {
            System.out.println("    " + it.next());
        }
        System.out.println();

        // ============================================================
        // 2. RECORRIDO CON FOR-EACH (usa el iterador de Grupo)
        // ============================================================
        System.out.println("  2. RECORRIDO CON FOR-EACH SOBRE GRUPO:");
        System.out.println("     (Usa el iterador de Grupo -> filtra NIA)");
        System.out.println();

        for (Alumno a : dam) {
            System.out.println("    " + a);
        }
        System.out.println();

        // ============================================================
        // 3. RECORRIDO CON listarAlumnos() (metodo que usa iterador)
        // ============================================================
        System.out.println("  3. METODO listarAlumnos() del Grupo:");
        System.out.println("     (Internamente usa el iterador)");
        System.out.println();

        dam.listarAlumnos();
        System.out.println();

        // ============================================================
        // 4. DIFERENCIA: for-each DIRECTAMENTE sobre ArrayList
        // ============================================================
        System.out.println("  4. DIFERENCIA: FOR-EACH SOBRE ARRAYLIST DIRECTAMENTE:");
        System.out.println("     (Usa el iterador de ArrayList -> NO filtra NIA)");
        System.out.println();

        // Esto NO se puede hacer porque alumnos es privado
        // Pero internamente el iterador de ArrayList devuelve TODOS los alumnos
        System.out.println("     (Si recorrieramos el ArrayList directamente,");
        System.out.println("      se mostraria Cal aunque tenga nia=null)");
        System.out.println();

        // ============================================================
        // DEMOSTRACION: GETTER PUBLICO (hipotetico)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  RESUMEN DE LAS 3 FORMAS DE ITERATOR()");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  FORMA 1: DELEGAR EN ARRAYLIST");
        System.out.println("    return alumnos.iterator();");
        System.out.println("    (Simple, pero sin personalizacion)");
        System.out.println();
        System.out.println("  FORMA 2: CLASE INTERNA");
        System.out.println("    private class IteradorGrupo implements Iterator<Alumno> {");
        System.out.println("        private int posicion = 0;");
        System.out.println("        public boolean hasNext() { ... }");
        System.out.println("        public Alumno next() { ... }");
        System.out.println("    }");
        System.out.println("    return new IteradorGrupo();");
        System.out.println("    (Reutilizable, mas organizada)");
        System.out.println();
        System.out.println("  FORMA 3: CLASE ANONIMA (usada en este ejemplo)");
        System.out.println("    return new Iterator<Alumno>() {");
        System.out.println("        private int posicion = 0;");
        System.out.println("        public boolean hasNext() { ... }");
        System.out.println("        public Alumno next() { ... }");
        System.out.println("    };  // <-- PUNTO Y COMA OBLIGATORIO");
        System.out.println("    (Compacta, ideal para un solo uso)");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V03: IMPLEMENTAR ITERABLE)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Implementar Iterable<T> permite usar for-each en una clase");
        System.out.println("  - El metodo iterator() debe devolver Iterator<T>");
        System.out.println("  - Personalizar hasNext() permite filtrar elementos");
        System.out.println("  - El for-each sobre Grupo usa el iterador de Grupo");
        System.out.println("  - El for-each sobre ArrayList usa el iterador de ArrayList");
        System.out.println("  - Proximo video: interfaces Comparable y Comparator");
    }
}
