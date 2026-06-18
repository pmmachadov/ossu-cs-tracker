import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Video_7_06_InterfaceComparator {

    public static final String TITULO = "7-06 JAVA: Interface Comparator DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=5ch7D89vpL0&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=147";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - INTERFACE COMPARATOR (TEMA 7 - V06)\n"
        + "=========================================================\n\n"
        + "COMPARABLE vs COMPARATOR:\n"
        + "  Comparable: orden NATURAL de la clase (unico, se modifica la clase)\n"
        + "  Comparator: orden ALTERNATIVO (multiples, NO se modifica la clase)\n\n"
        + "INTERFAZ COMPARATOR<T>:\n"
        + "  Metodo abstracto: int compare(T o1, T o2)\n"
        + "  Devuelve:\n"
        + "    - Negativo: o1 < o2 (o1 va antes)\n"
        + "    - Cero:     o1 == o2\n"
        + "    - Positivo: o1 > o2 (o1 va despues)\n\n"
        + "TRES FORMAS DE USAR COMPARATOR:\n\n"
        + "FORMA 1: Clase separada que implementa Comparator<T>\n"
        + "  class AlumnoPorEdadComparator implements Comparator<Alumno> {\n"
        + "      public int compare(Alumno a1, Alumno a2) {\n"
        + "          int r = Integer.compare(a1.getEdad(), a2.getEdad());\n"
        + "          if (r == 0) r = a1.getNombre().compareTo(a2.getNombre());\n"
        + "          return r;\n"
        + "      }\n"
        + "  }\n"
        + "  Uso: Collections.sort(lista, new AlumnoPorEdadComparator());\n\n"
        + "FORMA 2: Clase anonima (sin crear clase separada)\n"
        + "  Collections.sort(alumnos, new Comparator<Alumno>() {\n"
        + "      public int compare(Alumno a1, Alumno a2) {\n"
        + "          return a1.getNia().compareTo(a2.getNia());\n"
        + "      }\n"
        + "  });\n\n"
        + "FORMA 3: Metodo separado que encapsula el comparator\n"
        + "  void ordenarPorEdad(ArrayList<Alumno> alumnos) {\n"
        + "      Collections.sort(alumnos, new Comparator<Alumno>() {\n"
        + "          public int compare(Alumno a1, Alumno a2) {\n"
        + "              if (a1.getEdad() > a2.getEdad()) return 1;\n"
        + "              if (a1.getEdad() < a2.getEdad()) return -1;\n"
        + "              return a1.getNombre().compareTo(a2.getNombre());\n"
        + "          }\n"
        + "      });\n"
        + "  }\n\n"
        + "ORDEN INVERSO:\n"
        + "  Para invertir el orden, cambiar > por < (y viceversa)\n"
        + "  O usar: Collections.sort(lista, Collections.reverseOrder());\n\n"
        + "CLASES DEL EJEMPLO:\n"
        + "  Alumno: nombre, nia, edad (SIN implements Comparable)\n"
        + "  AlumnoPorEdadComparator: ordena por edad + nombre\n"
        + "  AlumnoPorNiaComparator: ordena por nia (alfabetico)\n"
        + "  Main: demuestra las 3 formas de usar Comparator\n\n"
        + "CONCEPTOS CLAVE:\n"
        + "- Comparator NO modifica la clase original\n"
        + "- Se pueden crear tantos comparadores como se necesiten\n"
        + "- Collections.sort(lista, comparator) acepta un Comparator\n"
        + "- Clase anonima: util cuando solo se necesita una vez\n"
        + "- Metodo separado: reutilizable y encapsulado\n"
        + "- Proximo video: Comparator comparando objetos de distintas clases\n";

    // ================================================================
    // CLASE ALUMNO (SIN implements Comparable)
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
            return nombre + " (nia:" + nia + ", " + edad + " anyos)";
        }
    }

    // ================================================================
    // FORMA 1: CLASES SEPARADAS QUE IMPLEMENTAN COMPARATOR
    // ================================================================

    // Comparador por EDAD (menor a mayor) + nombre si empate
    static class AlumnoPorEdadComparator implements Comparator<Alumno> {
        public int compare(Alumno a1, Alumno a2) {
            int resultado = Integer.compare(a1.getEdad(), a2.getEdad());
            if (resultado == 0)
                resultado = a1.getNombre().compareTo(a2.getNombre());
            return resultado;
        }
    }

    // Comparador por NIA (orden alfabetico)
    static class AlumnoPorNiaComparator implements Comparator<Alumno> {
        public int compare(Alumno a1, Alumno a2) {
            return a1.getNia().compareTo(a2.getNia());
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 7 - V06: INTERFACE COMPARATOR");
        System.out.println("Multiples formas de ordenar colecciones");
        System.out.println();

        // ============================================================
        // CREAR LISTA DE ALUMNOS
        // ============================================================
        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Pep", "222A", 25));
        alumnos.add(new Alumno("Tom", "111A", 20));
        alumnos.add(new Alumno("Jon", "444A", 21));
        alumnos.add(new Alumno("Tim", "333A", 19));

        System.out.println("=========================================");
        System.out.println("  LISTA ORIGINAL");
        System.out.println("=========================================");
        for (Alumno a : alumnos)
            System.out.println("  " + a);
        System.out.println();

        // ============================================================
        // FORMA 1: CLASE SEPARADA
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  FORMA 1: CLASE SEPARADA");
        System.out.println("=========================================");
        System.out.println();

        // Ordenar por EDAD
        ArrayList<Alumno> copia1 = new ArrayList<>(alumnos);
        Collections.sort(copia1, new AlumnoPorEdadComparator());

        System.out.println("  Ordenado por EDAD (AlumnoPorEdadComparator):");
        for (Alumno a : copia1)
            System.out.println("    " + a);
        System.out.println("  (Tim 19, Tom 20, Jon 21, Pep 25)");
        System.out.println();

        // Ordenar por NIA
        ArrayList<Alumno> copia2 = new ArrayList<>(alumnos);
        Collections.sort(copia2, new AlumnoPorNiaComparator());

        System.out.println("  Ordenado por NIA (AlumnoPorNiaComparator):");
        for (Alumno a : copia2)
            System.out.println("    " + a);
        System.out.println("  (Tom 111A, Pep 222A, Tim 333A, Jon 444A)");
        System.out.println();

        // ============================================================
        // FORMA 2: CLASE ANONIMA
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  FORMA 2: CLASE ANONIMA DIRECTA");
        System.out.println("=========================================");
        System.out.println();

        ArrayList<Alumno> copia3 = new ArrayList<>(alumnos);

        // Clase anonima inline
        Collections.sort(copia3, new Comparator<Alumno>() {
            public int compare(Alumno a1, Alumno a2) {
                return Integer.compare(a1.getEdad(), a2.getEdad());
            }
        });

        System.out.println("  Ordenado por EDAD (clase anonima):");
        for (Alumno a : copia3)
            System.out.println("    " + a);
        System.out.println("  (Sin desempate por nombre)");
        System.out.println();

        // ============================================================
        // FORMA 3: METODO SEPARADO CON If/Else
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  FORMA 3: METODO SEPARADO + IF/ELSE");
        System.out.println("=========================================");
        System.out.println();

        ArrayList<Alumno> copia4 = new ArrayList<>(alumnos);
        ordenarPorEdad(copia4);

        System.out.println("  Ordenado por EDAD (metodo con if/else):");
        for (Alumno a : copia4)
            System.out.println("    " + a);
        System.out.println("  (Usando > / < en lugar de Integer.compare)");
        System.out.println();

        // ============================================================
        // ORDEN INVERSO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  ORDEN INVERSO (mayor a menor edad)");
        System.out.println("=========================================");
        System.out.println();

        ArrayList<Alumno> copia5 = new ArrayList<>(alumnos);
        ordenarPorEdadInverso(copia5);

        System.out.println("  Ordenado por EDAD INVERSA (mayor a menor):");
        for (Alumno a : copia5)
            System.out.println("    " + a);
        System.out.println("  (Pep 25, Jon 21, Tom 20, Tim 19)");
        System.out.println();

        // ============================================================
        // COMPARATIVA COMPARABLE vs COMPARATOR
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  COMPARATIVA: COMPARABLE vs COMPARATOR");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  COMPARABLE:");
        System.out.println("    - Se implementa en la clase original");
        System.out.println("    - Un unico orden natural");
        System.out.println("    - Collections.sort(lista)");
        System.out.println();
        System.out.println("  COMPARATOR:");
        System.out.println("    - Clase separada (o anonima)");
        System.out.println("    - NO modifica la clase original");
        System.out.println("    - Multiples ordenes posibles");
        System.out.println("    - Collections.sort(lista, comparator)");
        System.out.println();
        System.out.println("  VENTAJA de Comparator:");
        System.out.println("    - Flexibilidad: crear N comparadores");
        System.out.println("    - No tocar codigo existente");
        System.out.println("    - Puede comparar objetos de distintas clases");
        System.out.println("      (proximo video)");

        // ============================================================
        // FIN
        // ============================================================
        System.out.println();
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V06: INTERFACE COMPARATOR)");
        System.out.println("==============================================================");
    }

    // ================================================================
    // METODO SEPARADO: ordenar por edad (con if/else)
    // ================================================================
    static void ordenarPorEdad(ArrayList<Alumno> alumnos) {
        Collections.sort(alumnos, new Comparator<Alumno>() {
            public int compare(Alumno a1, Alumno a2) {
                if (a1.getEdad() > a2.getEdad()) return 1;
                if (a1.getEdad() < a2.getEdad()) return -1;
                // Misma edad -> ordenar por nombre
                return a1.getNombre().compareTo(a2.getNombre());
            }
        });
    }

    // ================================================================
    // METODO SEPARADO: orden inverso (mayor a menor)
    // ================================================================
    static void ordenarPorEdadInverso(ArrayList<Alumno> alumnos) {
        Collections.sort(alumnos, new Comparator<Alumno>() {
            public int compare(Alumno a1, Alumno a2) {
                // Invertir > por < para orden inverso
                if (a1.getEdad() < a2.getEdad()) return 1;
                if (a1.getEdad() > a2.getEdad()) return -1;
                return a1.getNombre().compareTo(a2.getNombre());
            }
        });
    }
}
