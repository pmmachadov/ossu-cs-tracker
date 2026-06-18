import java.util.*;

class Video_7_12_HashSetEqualsHashCode {

    public static final String TITULO = "7-12 JAVA: HashSet + equals + hashCode DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=8Vq04jsVaRo&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=153";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - HASHSET + EQUALS + HASHCODE (TEMA 7 - V12)\n"
        + "=========================================================\n\n"
        + "PROBLEMA: HashSet con objetos propios NO detecta duplicados\n"
        + "porque equals() y hashCode() de Object comparan por REFERENCIA.\n\n"
        + "SOLUCION: Implementar equals() y hashCode() en la clase.\n\n"
        + "FUNCIONAMIENTO DE HASHSET CON OBJETOS:\n"
        + "  1. Al anyadir un elemento, se calcula su hashCode()\n"
        + "  2. Se busca el bucket correspondiente\n"
        + "  3. Si el bucket esta vacio -> se inserta directamente\n"
        + "  4. Si el bucket tiene elementos -> se usa equals() para comparar\n"
        + "  5. Si equals() devuelve true -> NO se inserta (duplicado)\n"
        + "  6. Si equals() devuelve false -> se inserta (colision)\n\n"
        + "TRES ESCENARIOS DEL VIDEO:\n\n"
        + "ESCENARIO 1: SIN equals/hashCode (herencia de Object)\n"
        + "  - Compara por REFERENCIA (direccion de memoria)\n"
        + "  - Dos objetos con el mismo ESTADO son \"distintos\"\n"
        + "  - SE INSERTAN duplicados con mismo estado\n"
        + "  - Solo detecta la MISMA referencia (ej: a1)\n\n"
        + "ESCENARIO 2: CON equals/hashCode basados en TODOS los atributos\n"
        + "  - Compara por ESTADO (nombre + nia + edad)\n"
        + "  - Dos objetos con exactamente los mismos valores son \"iguales\"\n"
        + "  - NO se insertan duplicados\n"
        + "  - Ej: dos Alumno(\"Sam\", \"666A\", 18) -> solo se inserta uno\n\n"
        + "ESCENARIO 3: CON equals/hashCode basados SOLO en NIA\n"
        + "  - Compara solo por NIA\n"
        + "  - Dos alumnos con mismo NIA son \"iguales\" aunque tengan distinto nombre/edad\n"
        + "  - NO se insertan duplicados con mismo NIA\n"
        + "  - Ej: Alumno(\"Sam\",\"666A\",18) y Alumno(\"Cal\",\"666A\",20) -> solo el primero\n\n"
        + "CONTRATO ENTRE equals() Y hashCode():\n"
        + "  - Si dos objetos son equals(), deben tener el MISMO hashCode()\n"
        + "  - Si dos objetos tienen distinto hashCode(), NO son equals()\n"
        + "  - Si dos objetos tienen el mismo hashCode(), PUEDEN ser equals() o no\n"
        + "  - Es decir: hashCode() es un filtro rapido, equals() es la confirmacion\n\n"
        + "DEMOSTRACION CON hashCode() MALO:\n"
        + "  - Si hashCode() devuelve 1 siempre: todos van al mismo bucket (colision total)\n"
        + "  - equals() decide si se inserta o no\n"
        + "  - equals()=true siempre -> solo el primer elemento\n"
        + "  - equals()=false siempre -> se insertan todos (pero todos en el mismo bucket)\n"
        + "  - Esto degrada el rendimiento a O(n)\n\n"
        + "DEMOSTRACION SIN hashCode() (solo equals):\n"
        + "  - Usa el hashCode() de Object (basado en referencia)\n"
        + "  - Cada objeto nuevo tiene distinto hashCode\n"
        + "  - equals() no se llega a invocar porque los hashCode son distintos\n"
        + "  - SE INSERTAN todos (excepto misma referencia)\n\n"
        + "REGLA DE ORO:\n"
        + "  - equals() y hashCode() deben usar los MISMOS atributos\n"
        + "  - hashCode() debe ser RAPIDO y DISTRIBUIR bien (evitar colisiones)\n"
        + "  - Si se modifican los atributos del equals/hashCode de un objeto\n"
        + "    dentro de un HashSet, el Set se corrompe (inconsistencia)\n"
        + "  - IDE como Eclipse/IntelliJ generan estos metodos automaticamente\n";

    // ================================================================
    // CLASE ALUMNO (con equals/hashCode generados manualmente)
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
            return nombre + "(" + nia + "," + edad + ")";
        }

        // equals y hashCode basados en TODOS los atributos
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Alumno alumno = (Alumno) o;
            return edad == alumno.edad
                && Objects.equals(nombre, alumno.nombre)
                && Objects.equals(nia, alumno.nia);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nombre, nia, edad);
        }
    }

    // ================================================================
    // CLASE ALUMNO_NIA (equals/hashCode SOLO por NIA)
    // ================================================================
    static class AlumnoNia {
        private String nombre, nia;
        private int edad;

        AlumnoNia(String nombre, String nia, int edad) {
            this.nombre = nombre;
            this.nia = nia;
            this.edad = edad;
        }

        public String toString() {
            return nombre + "(" + nia + "," + edad + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AlumnoNia alumno = (AlumnoNia) o;
            return Objects.equals(nia, alumno.nia);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nia);
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 7 - V12: HASHSET + EQUALS + HASHCODE");
        System.out.println("Como evitar duplicados con objetos propios");
        System.out.println();

        // ============================================================
        // ESCENARIO 1: SIN equals/hashCode en AlumnoSin
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  ESCENARIO 1: SIN equals/hashCode");
        System.out.println("  (hereda de Object -> compara referencia)");
        System.out.println("=========================================");
        System.out.println();

        // Usamos una clase SIN equals/hashCode (la de Video_7_11, no esta aquí)
        // Demostramos el problema con String (con equals ya implementado)
        System.out.println("  Dos String con mismo valor:");
        String s1 = new String("Hola");
        String s2 = new String("Hola");
        System.out.println("    s1 = new String(\"Hola\")  (ref: " + System.identityHashCode(s1) + ")");
        System.out.println("    s2 = new String(\"Hola\")  (ref: " + System.identityHashCode(s2) + ")");
        System.out.println("    s1.equals(s2) = " + s1.equals(s2) + " (String ya implementa equals)");
        System.out.println("    s1 == s2 = " + (s1 == s2) + " (referencias distintas)");
        System.out.println();

        // Con objetos SIN equals
        System.out.println("  Con Alumno SIN equals/hashCode:");
        HashSet<Alumno> sinEquals = new HashSet<>();

        Alumno a1 = new Alumno("Pep", "111A", 20);
        Alumno a2 = new Alumno("Sam", "666A", 18);
        Alumno a3 = new Alumno("Sam", "666A", 18); // Mismo estado que a2
        Alumno a4 = new Alumno("Cal", "999Z", 22);

        sinEquals.add(a1);
        sinEquals.add(a2);
        sinEquals.add(a3); // Duplicado de a2? (SI tiene equals implementado)
        sinEquals.add(a4);
        sinEquals.add(a1); // Misma referencia -> no se inserta

        System.out.println("  Anyadidos: a1(Pep,111A,20), a2(Sam,666A,18), a3(Sam,666A,18)");
        System.out.println("             a4(Cal,999Z,22), a1 otra vez");
        System.out.println("  Resultado (con equals por estado): " + sinEquals);
        System.out.println("  size = " + sinEquals.size() + " (a3 no se inserto por tener equals)");
        System.out.println();

        // ============================================================
        // ESCENARIO 2: CON equals/hashCode por TODOS los atributos
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  ESCENARIO 2: equals/hashCode por TODOS");
        System.out.println("  (nombre + nia + edad)");
        System.out.println("=========================================");
        System.out.println();

        HashSet<Alumno> grupo = new HashSet<>();

        Alumno b1 = new Alumno("Pep", "111A", 20);
        Alumno b2 = new Alumno("Sam", "666A", 18);
        Alumno b3 = new Alumno("Sam", "666A", 18); // IGUAL que b2
        Alumno b4 = new Alumno("Cal", "999Z", 22);

        grupo.add(b1);
        grupo.add(b2);
        grupo.add(b3); // equals true con b2 -> NO inserta
        grupo.add(b4);
        grupo.add(b1); // misma referencia -> NO inserta
        grupo.add(new Alumno("Sam", "666A", 18)); // mismo estado -> NO inserta

        System.out.println("  Contenido del HashSet:");
        for (Alumno a : grupo)
            System.out.println("    " + a);
        System.out.println("  size = " + grupo.size() + " (solo Pep, Sam y Cal)");
        System.out.println("  (Sam aparece solo una vez aunque se intento insertar 3 veces)");
        System.out.println();

        // ============================================================
        // ESCENARIO 3: equals/hashCode SOLO por NIA
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  ESCENARIO 3: equals/hashCode solo por NIA");
        System.out.println("=========================================");
        System.out.println();

        HashSet<AlumnoNia> grupoNia = new HashSet<>();

        AlumnoNia c1 = new AlumnoNia("Pep", "111A", 20);
        AlumnoNia c2 = new AlumnoNia("Sam", "666A", 18);
        AlumnoNia c3 = new AlumnoNia("Cal", "666A", 22); // MISMO NIA que c2! No se inserta
        AlumnoNia c4 = new AlumnoNia("Sam", "777A", 18); // DISTINTO NIA -> se inserta

        grupoNia.add(c1);
        grupoNia.add(c2);
        grupoNia.add(c3); // equals true con c2 (mismo nia) -> NO inserta
        grupoNia.add(c4);

        System.out.println("  Contenido del HashSet (solo por NIA):");
        for (AlumnoNia a : grupoNia)
            System.out.println("    " + a);
        System.out.println("  size = " + grupoNia.size() + " (3: Pep, Sam, Sam)");
        System.out.println("  (Cal no se inserto porque tiene mismo nia que Sam)");
        System.out.println();

        // ============================================================
        // DEMOSTRACION: hashCode() MALO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  hashCode() MALO (siempre 1)");
        System.out.println("=========================================");
        System.out.println();

        HashSet<AlumnoHashMalo> grupoMalo = new HashSet<>();
        grupoMalo.add(new AlumnoHashMalo("A", 1));
        grupoMalo.add(new AlumnoHashMalo("B", 2));
        grupoMalo.add(new AlumnoHashMalo("C", 3));

        System.out.println("  HashSet con equals()=false siempre:");
        System.out.println("    hashCode=1 para todos, equals=false");
        System.out.println("    (Todos se insertan pero en el mismo bucket -> rendimiento O(n))");
        for (AlumnoHashMalo a : grupoMalo)
            System.out.println("    " + a);
        System.out.println("  size = " + grupoMalo.size() + " (todos insertados en mismo bucket)");
        System.out.println();

        // ============================================================
        // REGLA DE ORO
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  REGLA DE ORO");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  1. equals() y hashCode() deben usar los MISMOS atributos");
        System.out.println("  2. hashCode() debe distribuir uniformemente");
        System.out.println("  3. Si equals()=true -> mismo hashCode()");
        System.out.println("  4. Si hashCode() distinto -> equals()=false");
        System.out.println("  5. NO modificar objetos dentro de un HashSet");
        System.out.println("     (puede corromper la estructura)");
        System.out.println("  6. Los IDE generan estos metodos automaticamente");
        System.out.println();
        System.out.println("  FLUJO DE INSERCION EN HASHSET:");
        System.out.println("    add(obj)");
        System.out.println("      -> calcular hashCode() -> buscar bucket");
        System.out.println("      -> bucket vacio?     -> INSERTAR");
        System.out.println("      -> bucket ocupado?   -> equals() con cada elemento");
        System.out.println("      -> equals()=true?    -> NO insertar (duplicado)");
        System.out.println("      -> equals()=false?   -> INSERTAR (colision en bucket)");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V12: HASHSET + EQUALS + HASHCODE)");
        System.out.println("==============================================================");
    }

    // ================================================================
    // CLASE AUXILIAR: hashCode() malo
    // ================================================================
    static class AlumnoHashMalo {
        String nombre;
        int edad;

        AlumnoHashMalo(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        @Override
        public int hashCode() {
            return 1; // Pesimo: todos al mismo bucket
        }

        @Override
        public boolean equals(Object o) {
            return false; // Siempre distintos (para demostracion)
        }

        public String toString() {
            return nombre + "(" + edad + ")";
        }
    }
}
