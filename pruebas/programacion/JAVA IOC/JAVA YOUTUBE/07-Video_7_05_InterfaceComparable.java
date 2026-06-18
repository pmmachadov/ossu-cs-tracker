import java.util.ArrayList;
import java.util.Collections;

class Video_7_05_InterfaceComparable {

    public static final String TITULO = "7-05 JAVA: Interface Comparable DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=R_gV5wpBwNQ&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=146";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - INTERFACE COMPARABLE (TEMA 7 - V05)\n"
        + "=========================================================\n\n"
        + "PROBLEMA: Java no sabe como ordenar objetos propios (Alumno, Persona...)\n"
        + "SOLUCION: Implementar la interfaz Comparable<T> en la clase\n\n"
        + "INTERFAZ COMPARABLE<T>:\n"
        + "  Unico metodo abstracto: int compareTo(T otro)\n"
        + "  Devuelve:\n"
        + "    - Negativo: this es MENOR que otro (this va antes)\n"
        + "    - Cero:     this es IGUAL que otro\n"
        + "    - Positivo: this es MAYOR que otro (this va despues)\n\n"
        + "METODOS AUXILIARES PARA COMPARAR:\n"
        + "  - Integer.compare(int a, int b): compara enteros (-1, 0, 1)\n"
        + "  - String.compareTo(String otra): orden lexicografico\n"
        + "  - Resta: a.getEdad() - this.getEdad() (para orden inverso)\n\n"
        + "EJEMPLO: Alumno implements Comparable<Alumno>\n\n"
        + "  ORDEN POR EDAD (menor a mayor) y luego por nombre:\n"
        + "  public int compareTo(Alumno a) {\n"
        + "      int resultado = Integer.compare(this.edad, a.edad);\n"
        + "      if (resultado == 0)\n"
        + "          resultado = this.nombre.compareTo(a.nombre);\n"
        + "      return resultado;\n"
        + "  }\n\n"
        + "  ORDEN POR NOMBRE (alfabetico) y luego por edad:\n"
        + "  public int compareTo(Alumno a) {\n"
        + "      int resultado = this.nombre.compareTo(a.nombre);\n"
        + "      if (resultado == 0)\n"
        + "          resultado = Integer.compare(this.edad, a.edad);\n"
        + "      return resultado;\n"
        + "  }\n\n"
        + "  ORDEN INVERSO por edad (mayor a menor) usando resta:\n"
        + "  public int compareTo(Alumno a) {\n"
        + "      int resultado = a.edad - this.edad;  // resta INVERTIDA\n"
        + "      if (resultado == 0)\n"
        + "          resultado = this.nombre.compareTo(a.nombre);\n"
        + "      return resultado;\n"
        + "  }\n\n"
        + "ORDENAR COLECCIONES:\n"
        + "  Collections.sort(lista);\n"
        + "  - Requiere que la lista implemente la interfaz List\n"
        + "  - Requiere que los elementos implementen Comparable\n"
        + "  - Ordena la lista IN SITU (modifica la original)\n"
        + "  - Si se anyaden nuevos elementos, hay que volver a ordenar\n\n"
        + "EJEMPLO COMPLETO:\n"
        + "  ArrayList<Alumno> alumnos = new ArrayList<>();\n"
        + "  alumnos.add(new Alumno(\"Pep\", \"111A\", 15));\n"
        + "  alumnos.add(new Alumno(\"Tom\", \"222B\", 17));\n"
        + "  alumnos.add(new Alumno(\"Jon\", \"333C\", 14));\n"
        + "  Collections.sort(alumnos);  // Ordena por edad\n"
        + "  // Resultado: Jon(14), Pep(15), Tom(17)\n\n"
        + "CONCEPTOS CLAVE:\n"
        + "- Comparable: orden NATURAL de la clase (solo una forma)\n"
        + "- Comparator: orden ALTERNATIVO (varias formas, proximo video)\n"
        + "- compareTo() debe ser consistente con equals() (recomendado)\n"
        + "- Collections.sort() solo funciona con List\n"
        + "- Integer.compare() es mas seguro que la resta (evita overflow)\n"
        + "- Orden inverso: invertir los operandos en la comparacion\n";

    // ================================================================
    // CLASE ALUMNO (implementa Comparable<Alumno>)
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

        // compareTo: ordena por EDAD (menor a mayor) y luego por NOMBRE
        public int compareTo(Alumno a) {
            // Primero comparar por edad
            int resultado = Integer.compare(this.edad, a.edad);
            // Si misma edad, ordenar por nombre alfabeticamente
            if (resultado == 0)
                resultado = this.nombre.compareTo(a.nombre);
            return resultado;
        }

        public String toString() {
            return nombre + " (" + edad + " anyos)";
        }
    }

    // ================================================================
    // CLASE ALUMNO2 (misma estructura pero orden por NOMBRE primero)
    // ================================================================
    static class AlumnoNombre implements Comparable<AlumnoNombre> {
        private String nombre;
        private int edad;

        AlumnoNombre(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        String getNombre() { return nombre; }
        int getEdad() { return edad; }

        // compareTo: ordena por NOMBRE (alfabetico) y luego por EDAD
        public int compareTo(AlumnoNombre a) {
            int resultado = this.nombre.compareTo(a.nombre);
            if (resultado == 0)
                resultado = Integer.compare(this.edad, a.edad);
            return resultado;
        }

        public String toString() {
            return nombre + " (" + edad + " anyos)";
        }
    }

    // ============================================================
    // MAIN
    // ============================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 7 - V05: INTERFACE COMPARABLE");
        System.out.println("Ordenar colecciones con Comparable");
        System.out.println();

        // ============================================================
        // 1. String.compareTo() - ejemplo basico
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  1. METODO String.compareTo()");
        System.out.println("=========================================");
        System.out.println();

        String s1 = "bbb", s2 = "aaa";

        int resultado = s1.compareTo(s2);
        System.out.println("  s1=\"" + s1 + "\".compareTo(s2=\"" + s2 + "\") = " + resultado);
        System.out.println("  (Negativo: s1 < s2 -> \"bbb\" va antes que \"aaa\"?)");
        System.out.println("  En realidad: \"aaa\" < \"bbb\" -> compareTo devuelve POSITIVO");
        System.out.println("  Resultado: " + resultado + " -> s1 > s2");
        System.out.println();

        s2 = "aaa";
        resultado = s1.compareTo(s2);
        System.out.println("  s1=\"" + s1 + "\".compareTo(s2=\"" + s2 + "\") = " + resultado);
        System.out.println("  (Positivo: s1 > s2)");
        System.out.println();

        s1 = "aaa"; s2 = "aaa";
        resultado = s1.compareTo(s2);
        System.out.println("  s1=\"" + s1 + "\".compareTo(s2=\"" + s2 + "\") = " + resultado);
        System.out.println("  (Cero: s1 == s2)");
        System.out.println();

        // ============================================================
        // 2. Comparable con Alumno (orden por EDAD)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  2. ORDENAR ALUMNOS POR EDAD");
        System.out.println("=========================================");
        System.out.println();

        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Pep", "111A", 15));
        alumnos.add(new Alumno("Tom", "222B", 17));
        alumnos.add(new Alumno("Jon", "333C", 14));

        System.out.println("  Antes de ordenar:");
        for (Alumno a : alumnos)
            System.out.println("    " + a);

        Collections.sort(alumnos);

        System.out.println("  Despues de Collections.sort():");
        for (Alumno a : alumnos)
            System.out.println("    " + a);
        System.out.println("  (Ordenado por edad: Jon(14), Pep(15), Tom(17))");
        System.out.println();

        // ============================================================
        // 3. Anyadir nuevo alumno y reordenar
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  3. ANYADIR ALUMNO Y REORDENAR");
        System.out.println("=========================================");
        System.out.println();

        alumnos.add(new Alumno("Ben", "444D", 14));

        System.out.println("  Despues de anyadir Ben(14) (SIN reordenar):");
        for (Alumno a : alumnos)
            System.out.println("    " + a);

        Collections.sort(alumnos);

        System.out.println("  Despues de reordenar:");
        for (Alumno a : alumnos)
            System.out.println("    " + a);
        System.out.println("  (Ben y Jon tienen 14, se ordenan por nombre: Ben antes que Jon)");
        System.out.println();

        // ============================================================
        // 4. ORDEN POR NOMBRE (con AlumnoNombre)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  4. ORDENAR POR NOMBRE (AlumnoNombre)");
        System.out.println("=========================================");
        System.out.println();

        ArrayList<AlumnoNombre> alumnosNom = new ArrayList<>();
        alumnosNom.add(new AlumnoNombre("Pep", 15));
        alumnosNom.add(new AlumnoNombre("Tom", 17));
        alumnosNom.add(new AlumnoNombre("Ana", 14));
        alumnosNom.add(new AlumnoNombre("Ana", 17));

        System.out.println("  Antes de ordenar:");
        for (AlumnoNombre a : alumnosNom)
            System.out.println("    " + a);

        Collections.sort(alumnosNom);

        System.out.println("  Despues de ordenar por nombre (y edad si同名):");
        for (AlumnoNombre a : alumnosNom)
            System.out.println("    " + a);
        System.out.println("  (Ana 14 antes que Ana 17, luego Pep, luego Tom)");
        System.out.println();

        // ============================================================
        // 5. ORDEN INVERSO (mayor a menor edad) con RESTA
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  5. ORDEN INVERSO POR EDAD");
        System.out.println("     (usando resta en compareTo)");
        System.out.println("=========================================");
        System.out.println();

        // Creamos otra clase o simplemente mostramos el concepto
        System.out.println("  Formula para orden inverso:");
        System.out.println("    int resultado = a.edad - this.edad;");
        System.out.println("    (resta invertida: parametro - this)");
        System.out.println();
        System.out.println("  Equivalente con Integer.compare:");
        System.out.println("    int resultado = Integer.compare(a.edad, this.edad);");
        System.out.println("    (invertir los argumentos)");
        System.out.println();

        // ============================================================
        // RESULTADO FINAL
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  RESUMEN: compareTo()");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  int compareTo(T otro)");
        System.out.println("    Devuelve NEGATIVO: this < otro (this va antes)");
        System.out.println("    Devuelve CERO:     this == otro");
        System.out.println("    Devuelve POSITIVO: this > otro (this va despues)");
        System.out.println();
        System.out.println("  Metodos auxiliares:");
        System.out.println("    Integer.compare(a, b)    -> seguro, evita overflow");
        System.out.println("    String.compareTo(otra)   -> orden lexicografico");
        System.out.println("    resta (a.edad - b.edad)  -> simple pero riesgoso");
        System.out.println();
        System.out.println("  Collections.sort(lista):");
        System.out.println("    - Requiere List y Comparable");
        System.out.println("    - Ordena la lista in situ");
        System.out.println("    - Solo hay UNA forma de ordenar con Comparable");
        System.out.println();
        System.out.println("  Proximo video: Interface Comparator (multiples ordenes)");

        // ============================================================
        // FIN
        // ============================================================
        System.out.println();
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V05: INTERFACE COMPARABLE)");
        System.out.println("==============================================================");
    }
}
