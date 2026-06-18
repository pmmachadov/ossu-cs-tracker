import java.util.ArrayList;
import java.util.Iterator;

class Video_7_04_EjercicioIteradores {

    public static final String TITULO = "7-04 JAVA: Ejercicio Iteradores DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=0pKO9cNG0ns&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=145";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - EJERCICIO ITERADORES (TEMA 7 - V04)\n"
        + "=========================================================\n\n"
        + "ENUNCIADO: Crear un metodo que borre alumnos del grupo cuya edad sea\n"
        + "menor a un valor entero pasado como parametro.\n\n"
        + "TRES SOLUCIONES:\n"
        + "1) FOR-EACH (NO VALIDA - ConcurrentModificationException)\n"
        + "   for (Alumno a : alumnos) {\n"
        + "       if (a.getEdad() < n) alumnos.remove(a);  // ERROR!\n"
        + "   }\n\n"
        + "2) ITERATOR DE ARRAYLIST (SI VALIDA)\n"
        + "   Iterator<Alumno> it = alumnos.iterator();\n"
        + "   while (it.hasNext()) {\n"
        + "       Alumno a = it.next();\n"
        + "       if (a.getEdad() < n) it.remove();\n"
        + "   }\n"
        + "   - Elimina TODOS los alumnos con edad < n (incluye NIA nulo)\n\n"
        + "3) ITERADOR PERSONALIZADO DEL GRUPO (SI VALIDA + FILTRO)\n"
        + "   Iterator<Alumno> it = grupo.iterator();  // iterador propio\n"
        + "   while (it.hasNext()) {\n"
        + "       Alumno a = it.next();\n"
        + "       if (a.getEdad() < n) it.remove();   // requiere remove() en el iterador\n"
        + "   }\n"
        + "   - Solo recorre alumnos con NIA valido, solo los elimina a ellos\n"
        + "   - IMPORTANTE: el iterador personalizado necesita implementar remove()\n"
        + "     con: alumnos.remove(--posicion);\n\n"
        + "COMPARATIVA ITERADORES:\n\n"
        + "ITERADOR ARRAYLIST (alumnos.iterator()):\n"
        + "  - Recorre TODOS los elementos\n"
        + "  - remove() ya implementado\n"
        + "  - Borra cualquier alumno que cumpla la condicion\n\n"
        + "ITERADOR GRUPO (grupo.iterator() - clase anonima):\n"
        + "  - Filtra en hasNext(): solo NIA no nulo\n"
        + "  - Requiere implementar remove() manualmente\n"
        + "  - Borra solo los que cumplan condicion Y tengan NIA\n\n"
        + "ITERADOR GRUPO NORMAL (clase separada IteradorGrupoNormal):\n"
        + "  - Sin filtro, recorre todos\n"
        + "  - Remove() implementado manualmente\n"
        + "  - Equivalente al de ArrayList\n\n"
        + "IMPLEMENTACION DE REMOVE() EN ITERADOR PROPIO:\n"
        + "  public void remove() {\n"
        + "      alumnos.remove(--posicion);\n"
        + "  }\n"
        + "  (posicion se incrementa en next(), por eso hay que decrementar antes)\n\n"
        + "CLASES CREADAS:\n"
        + "  - Alumno: nombre, nia, edad\n"
        + "  - Grupo implements Iterable<Alumno>: nombre, alumnos\n"
        + "    - agregarAlumno(), getAlumnos(), listarAlumnos()\n"
        + "    - eliminarPorEdad(int n): usa iterador de ArrayList\n"
        + "    - eliminarPorEdadConFiltro(int n): usa iterador del grupo (filtra NIA)\n"
        + "    - iterator(): devuelve iterador personalizado (filtra NIA)\n"
        + "  - IteradorGrupoNia (clase separada): iterador que filtra por NIA\n"
        + "  - IteradorGrupoNormal (clase separada): iterador sin filtro\n\n"
        + "CONCEPTOS CLAVE:\n"
        + "- Iterator.remove() necesita implementacion manual en iteradores propios\n"
        + "- remove() borra el ultimo elemento devuelto por next()\n"
        + "- posicion++ en next() -> posicion-- en remove() para borrar el anterior\n"
        + "- Se pueden crear multiples iteradores con distintos comportamientos\n"
        + "- Clase interna vs clase separada: ambas validas, depende del caso\n";

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
    // ITERADOR QUE FILTRA POR NIA (clase separada)
    // ================================================================
    static class IteradorGrupoNia implements Iterator<Alumno> {
        private ArrayList<Alumno> alumnos;
        private int posicion = 0;

        IteradorGrupoNia(ArrayList<Alumno> alumnos) {
            this.alumnos = alumnos;
        }

        public boolean hasNext() {
            // Saltar alumnos con NIA nulo
            while (posicion < alumnos.size() && alumnos.get(posicion).getNia() == null) {
                posicion++;
            }
            return posicion < alumnos.size();
        }

        public Alumno next() {
            return alumnos.get(posicion++);
        }

        public void remove() {
            alumnos.remove(--posicion);  // Borra el elemento que devolvio next()
        }
    }

    // ================================================================
    // ITERADOR SIN FILTRO (clase separada)
    // ================================================================
    static class IteradorGrupoNormal implements Iterator<Alumno> {
        private ArrayList<Alumno> alumnos;
        private int posicion = 0;

        IteradorGrupoNormal(ArrayList<Alumno> alumnos) {
            this.alumnos = alumnos;
        }

        public boolean hasNext() {
            return posicion < alumnos.size();
        }

        public Alumno next() {
            return alumnos.get(posicion++);
        }

        public void remove() {
            alumnos.remove(--posicion);
        }
    }

    // ================================================================
    // CLASE GRUPO
    // ================================================================
    static class Grupo implements Iterable<Alumno> {
        private String nombre;
        private ArrayList<Alumno> alumnos;

        Grupo(String nombre) {
            this.nombre = nombre;
            this.alumnos = new ArrayList<>();
        }

        String getNombre() { return nombre; }
        ArrayList<Alumno> getAlumnos() { return alumnos; }

        void agregarAlumno(Alumno a) {
            alumnos.add(a);
        }

        // Metodo que lista alumnos usando el ITERADOR DEL GRUPO (filtra NIA)
        void listarAlumnos() {
            Iterator<Alumno> it = iterator();
            while (it.hasNext()) {
                System.out.println("    " + it.next());
            }
        }

        // ELIMINAR POR EDAD usando iterador de ARRAYLIST (borra TODOS)
        void eliminarPorEdad(int n) {
            Iterator<Alumno> it = alumnos.iterator();
            while (it.hasNext()) {
                Alumno a = it.next();
                if (a.getEdad() < n) {
                    it.remove();
                }
            }
        }

        // ELIMINAR POR EDAD usando iterador PERSONALIZADO del grupo (solo con NIA)
        void eliminarPorEdadConFiltro(int n) {
            Iterator<Alumno> it = iterator();  // iterador del grupo (filtra NIA)
            while (it.hasNext()) {
                Alumno a = it.next();
                if (a.getEdad() < n) {
                    it.remove();  // Requiere remove() implementado en el iterador
                }
            }
        }

        // Iterador del grupo: clase anonima que filtra por NIA
        public Iterator<Alumno> iterator() {
            return new Iterator<Alumno>() {
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

                public void remove() {
                    alumnos.remove(--posicion);  // NECESARIO para poder borrar
                }
            };
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 7 - V04: EJERCICIO ITERADORES");
        System.out.println("Ampliacion: eliminar alumnos por edad con iteradores");
        System.out.println();

        // ============================================================
        // CREAR GRUPO CON ALUMNOS
        // ============================================================
        Grupo dam = new Grupo("1 DAM");

        // Alumnos CON NIA
        dam.agregarAlumno(new Alumno("Pepe", "1111A", 15));
        dam.agregarAlumno(new Alumno("Tom", "2222B", 17));
        dam.agregarAlumno(new Alumno("Jon", "3333C", 22));
        dam.agregarAlumno(new Alumno("Sam", "4444D", 21));
        dam.agregarAlumno(new Alumno("Tim", "5555E", 18));

        // Alumnos SIN NIA (null)
        dam.agregarAlumno(new Alumno("Cal", null, 14));
        dam.agregarAlumno(new Alumno("Mia", null, 16));
        dam.agregarAlumno(new Alumno("Leo", null, 20));

        // ============================================================
        // 1. FOR-EACH SOBRE GRUPO (usa iterador del grupo -> filtra NIA)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  GRUPO INICIAL: " + dam.getNombre());
        System.out.println("=========================================");
        System.out.println();

        System.out.println("  Alumnos visibles con for-each sobre Grupo:");
        System.out.println("  (Iterador del grupo: solo muestra NIA no nulo)");
        for (Alumno a : dam) {
            System.out.println("    " + a);
        }
        System.out.println();
        System.out.println("  Alumnos TOTALES en el ArrayList:");
        for (Alumno a : dam.getAlumnos()) {
            System.out.println("    " + a);
        }
        System.out.println();

        // ============================================================
        // 2. DEMO: ERROR CON FOR-EACH AL ELIMINAR
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  DEMO: ERROR FOR-EACH AL ELIMINAR");
        System.out.println("=========================================");
        System.out.println();

        Grupo demoError = new Grupo("Demo");
        demoError.agregarAlumno(new Alumno("A", "111", 15));
        demoError.agregarAlumno(new Alumno("B", "222", 17));
        demoError.agregarAlumno(new Alumno("C", "333", 12));

        try {
            for (Alumno a : demoError.getAlumnos()) {
                if (a.getEdad() < 16) {
                    demoError.getAlumnos().remove(a); // ERROR!
                }
            }
        } catch (Exception e) {
            System.out.println("  ERROR: " + e.getClass().getSimpleName());
            System.out.println("  Motivo: modificacion de coleccion durante for-each");
        }
        System.out.println();

        // ============================================================
        // 3. ELIMINAR POR EDAD CON ITERADOR DE ARRAYLIST
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  3. ELIMINAR POR EDAD < 17");
        System.out.println("     (Usando iterador de ARRAYLIST - borra TODOS)");
        System.out.println("=========================================");
        System.out.println();

        Grupo grupo1 = new Grupo("Grupo A");
        grupo1.agregarAlumno(new Alumno("Pepe", "1111A", 15));
        grupo1.agregarAlumno(new Alumno("Tom", "2222B", 17));
        grupo1.agregarAlumno(new Alumno("Cal", null, 14));
        grupo1.agregarAlumno(new Alumno("Jon", "3333C", 22));
        grupo1.agregarAlumno(new Alumno("Sam", "4444D", 21));

        System.out.println("  Antes:");
        for (Alumno a : grupo1.getAlumnos()) {
            System.out.println("    " + a);
        }

        grupo1.eliminarPorEdad(17);

        System.out.println("  Despues de eliminar edad < 17:");
        for (Alumno a : grupo1.getAlumnos()) {
            System.out.println("    " + a);
        }
        System.out.println("  (Elimino a Pepe(15) y Cal(14), incluido Cal con nia=null)");
        System.out.println();

        // ============================================================
        // 4. ELIMINAR POR EDAD CON ITERADOR DEL GRUPO (FILTRA NIA)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  4. ELIMINAR POR EDAD < 18");
        System.out.println("     (Usando iterador del GRUPO - solo con NIA)");
        System.out.println("=========================================");
        System.out.println();

        Grupo grupo2 = new Grupo("Grupo B");
        grupo2.agregarAlumno(new Alumno("Pepe", "1111A", 15));
        grupo2.agregarAlumno(new Alumno("Tom", "2222B", 17));
        grupo2.agregarAlumno(new Alumno("Cal", null, 14));  // NIA null
        grupo2.agregarAlumno(new Alumno("Jon", "3333C", 22));
        grupo2.agregarAlumno(new Alumno("Sam", "4444D", 21));
        grupo2.agregarAlumno(new Alumno("Mia", null, 16));  // NIA null

        System.out.println("  Antes (mostrado con for-each sobre Grupo):");
        for (Alumno a : grupo2) {
            System.out.println("    " + a);
        }

        grupo2.eliminarPorEdadConFiltro(18);

        System.out.println("  Despues de eliminar edad < 18 (con filtro NIA):");
        System.out.println("  (for-each sobre Grupo - solo NIA no nulo):");
        for (Alumno a : grupo2) {
            System.out.println("    " + a);
        }
        System.out.println("  (Total en ArrayList - se ve todo):");
        for (Alumno a : grupo2.getAlumnos()) {
            System.out.println("    " + a);
        }
        System.out.println("  (Pepe y Tom eliminados. Cal y Mia con nia=null NO se eliminaron)");
        System.out.println();

        // ============================================================
        // 5. DEMO: ITERADORES SEPARADOS (clases externas)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  5. ITERADORES COMO CLASES SEPARADAS");
        System.out.println("=========================================");
        System.out.println();

        Grupo grupo3 = new Grupo("Grupo C");
        grupo3.agregarAlumno(new Alumno("Pepe", "1111A", 15));
        grupo3.agregarAlumno(new Alumno("Tom", "2222B", 17));
        grupo3.agregarAlumno(new Alumno("Cal", null, 14));

        System.out.println("  IteradorGrupoNia (filtra NIA):");
        IteradorGrupoNia itNia = new IteradorGrupoNia(grupo3.getAlumnos());
        while (itNia.hasNext()) {
            System.out.println("    " + itNia.next());
        }

        System.out.println("  IteradorGrupoNormal (sin filtro):");
        IteradorGrupoNormal itNormal = new IteradorGrupoNormal(grupo3.getAlumnos());
        while (itNormal.hasNext()) {
            System.out.println("    " + itNormal.next());
        }
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V04: EJERCICIO ITERADORES)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - For-each NO permite modificar la coleccion (ConcurrentModificationException)");
        System.out.println("  - Iterator.remove() es la forma segura de eliminar mientras se recorre");
        System.out.println("  - En iteradores propios, hay que implementar remove() manualmente");
        System.out.println("  - remove() borra el ultimo elemento devuelto por next()");
        System.out.println("  - Por eso: alumnos.remove(--posicion);  // posicion++ en next()");
        System.out.println("  - Se pueden crear multiples iteradores con distinto comportamiento");
        System.out.println("  - Proximo video: interfaces Comparable y Comparator");
    }
}
