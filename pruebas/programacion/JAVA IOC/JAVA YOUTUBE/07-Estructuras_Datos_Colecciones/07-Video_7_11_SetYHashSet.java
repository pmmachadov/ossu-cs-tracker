import java.util.*;

class Video_7_11_SetYHashSet {

    public static final String TITULO = "7-11 JAVA: Set y HashSet DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=Yzs5MGu_lJY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=152";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - SET Y HASHSET (TEMA 7 - V11)\n"
        + "=========================================================\n\n"
        + "INTERFAZ SET<E>:\n"
        + "- Hereda de Collection<E>\n"
        + "- NO permite elementos DUPLICADOS\n"
        + "- NO introduce metodos propios (usa los de Collection)\n"
        + "- NO tiene get(index) porque no esta indexado\n"
        + "- Depende de equals() y hashCode() para detectar duplicados\n\n"
        + "PRINCIPALES IMPLEMENTACIONES:\n\n"
        + "  HashSet<E>:\n"
        + "    - Estructura: TABLA HASH\n"
        + "    - Orden: NINGUNO (no garantiza orden de insercion)\n"
        + "    - Rendimiento: O(1) constante para add, remove, contains\n"
        + "    - Permite null: SI\n"
        + "    - Ideal: colecciones grandes, busquedas rapidas\n\n"
        + "  LinkedHashSet<E>:\n"
        + "    - Estructura: TABLA HASH + LISTA ENLAZADA\n"
        + "    - Orden: ORDEN DE INSERCION\n"
        + "    - Rendimiento: ligeramente inferior a HashSet\n"
        + "    - Permite null: SI\n"
        + "    - Ideal: cuando se necesita mantener orden de insercion\n\n"
        + "  TreeSet<E>:\n"
        + "    - Estructura: ARBOL BINARIO BALANCEADO\n"
        + "    - Orden: ORDEN NATURAL (Comparable/Comparator)\n"
        + "    - Rendimiento: O(log n)\n"
        + "    - Permite null: NO\n"
        + "    - Ideal: cuando se necesita orden natural\n\n"
        + "DIFERENCIAS CLAVE CON LIST:\n"
        + "  - Set NO tiene get(index), NO tiene set(index, element)\n"
        + "  - Set NO permite duplicados (List si)\n"
        + "  - Set NO garantiza orden (depende de la implementacion)\n"
        + "  - Set usa equals() y hashCode() para detectar duplicados\n\n"
        + "IMPORTANCIA DE equals() Y hashCode():\n"
        + "  - Si no se redefinen, Java compara por REFERENCIA (memoria)\n"
        + "  - Dos objetos con el mismo estado serian \"distintos\"\n"
        + "  - HashSet usa hashCode() para determinar el bucket\n"
        + "  - Luego usa equals() para verificar si ya existe\n"
        + "  - TreeSet NO usa hashCode(), usa compareTo() o Comparator\n\n"
        + "EJEMPLOS DEL VIDEO:\n"
        + "  1) HashSet<Integer> -> elimina duplicados, sin orden\n"
        + "  2) ArrayList<Integer> -> mantiene duplicados, orden insercion\n"
        + "  3) HashSet<String> -> remove(\"String\") funciona, remove(2) no\n"
        + "  4) HashSet<Alumno> -> iterador para modificar elementos\n"
        + "  5) HashSet a partir de ArrayList -> elimina duplicados\n\n"
        + "CONSTRUCTOR ESPECIAL:\n"
        + "  HashSet(Collection<? extends E> c)\n"
        + "  - Crea un HashSet a partir de cualquier Collection\n"
        + "  - Elimina duplicados automaticamente\n"
        + "  - Util: pasar ArrayList a HashSet para limpiar duplicados\n\n"
        + "CONCEPTOS CLAVE:\n"
        + "- Set no tiene indice (no get(index), no set(index, e))\n"
        + "- HashSet no garantiza orden de insercion\n"
        + "- equals() y hashCode() deben ser consistentes\n"
        + "- Modificar objetos dentro de un Set puede romperlo\n"
        + "- Proximo video: equals y hashCode en HashSet con objetos propios\n";

    // ================================================================
    // CLASE ALUMNO (SIN equals/hashCode por ahora)
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

        void setNombre(String nombre) { this.nombre = nombre; }
        void setNia(String nia) { this.nia = nia; }

        public String toString() {
            return nombre + "(" + nia + "," + edad + ")";
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 7 - V11: SET Y HASHSET");
        System.out.println("Colecciones sin duplicados");
        System.out.println();

        // ============================================================
        // 1. HASHSET DE ENTEROS (elimina duplicados)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  1. HASHSET DE ENTEROS");
        System.out.println("=========================================");
        System.out.println();

        HashSet<Integer> nums = new HashSet<>();
        nums.add(5);
        nums.add(8);
        nums.add(2);
        nums.add(3);
        nums.add(3);  // Duplicado! No se anyade
        nums.add(4);
        nums.add(5);  // Duplicado! No se anyade

        System.out.println("  HashSet<Integer> nums: " + nums);
        System.out.println("  (Sin orden, sin duplicados: {2,3,4,5,8})");
        System.out.println("  size = " + nums.size() + " (se anyadieron 7, pero 2 duplicados)");
        System.out.println();

        // contains
        System.out.println("  contains(1) = " + nums.contains(1) + " (no existe)");
        System.out.println("  contains(5) = " + nums.contains(5) + " (existe)");
        System.out.println();

        // ============================================================
        // 2. ARRAYLIST CON DUPLICADOS (comparacion)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  2. ARRAYLIST CON DUPLICADOS");
        System.out.println("=========================================");
        System.out.println();

        ArrayList<Integer> numsList = new ArrayList<>();
        numsList.add(5);
        numsList.add(8);
        numsList.add(2);
        numsList.add(3);
        numsList.add(3);  // Duplicado! SI se anyade
        numsList.add(4);
        numsList.add(5);  // Duplicado! SI se anyade

        System.out.println("  ArrayList<Integer> numsList: " + numsList);
        System.out.println("  (Orden insercion, CON duplicados)");
        System.out.println("  size = " + numsList.size() + " (7 elementos)");
        System.out.println();

        // ============================================================
        // 3. HASHSET A PARTIR DE ARRAYLIST (elimina duplicados)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  3. HASHSET DESDE ARRAYLIST");
        System.out.println("=========================================");
        System.out.println();

        HashSet<Integer> nums2 = new HashSet<>(numsList);
        System.out.println("  ArrayList original: " + numsList + " (7 elementos)");
        System.out.println("  HashSet desde ArrayList: " + nums2 + " (sin duplicados)");
        System.out.println("  Util: pasar a HashSet para limpiar duplicados!");
        System.out.println();

        // ============================================================
        // 4. HASHSET DE STRINGS (remove y get)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  4. HASHSET DE STRINGS");
        System.out.println("=========================================");
        System.out.println();

        HashSet<String> nombres = new HashSet<>();
        nombres.add("Pep");
        nombres.add("Tom");
        nombres.add("Cal");
        nombres.add("Jon");
        nombres.add("Tom");  // Duplicado!
        nombres.add("Pep");  // Duplicado!

        System.out.println("  HashSet<String> nombres: " + nombres);
        System.out.println("  (Sin orden, sin duplicados)");
        System.out.println();

        // Set NO tiene get(index) -> error de compilacion
        // String s = nombres.get(2);  // ERROR! Set no tiene get por indice

        // remove con String (funciona)
        nombres.remove("Tom");
        System.out.println("  Despues de remove(\"Tom\"): " + nombres);
        System.out.println();

        // remove con int (no borra nada, porque no hay String "2")
        nombres.remove(2);  // Compila pero no hace nada (remove(Object))
        System.out.println("  Despues de remove(2) (no hace nada): " + nombres);
        System.out.println();

        // ============================================================
        // 5. HASHSET DE ALUMNOS CON ITERADOR
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  5. HASHSET DE ALUMNOS CON ITERADOR");
        System.out.println("=========================================");
        System.out.println();

        HashSet<Alumno> grupo = new HashSet<>();
        grupo.add(new Alumno("Pep", "111A", 20));
        grupo.add(new Alumno("Tom", "222B", 22));
        grupo.add(new Alumno("Jon", "333C", 21));

        System.out.println("  HashSet<Alumno> inicial:");
        for (Alumno a : grupo)
            System.out.println("    " + a);
        System.out.println();

        // Modificar con iterador (cuidado: cambiar atributos del equals/hashCode rompe el Set)
        System.out.println("  Modificando todos los nombres a \"AAA\" con iterador...");
        Iterator<Alumno> it = grupo.iterator();
        while (it.hasNext()) {
            Alumno a = it.next();
            a.setNombre("AAA");  // Modifica el nombre (no el nia)
        }

        System.out.println("  Despues de modificar (todos se llaman AAA):");
        for (Alumno a : grupo)
            System.out.println("    " + a);
        System.out.println();

        // ============================================================
        // COMPARATIVA HASHSET vs TREESET vs LINKEDHASHSET
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  COMPARATIVA: HashSet vs TreeSet vs LinkedHashSet");
        System.out.println("=========================================");
        System.out.println();

        // HashSet
        HashSet<String> hs = new HashSet<>();
        hs.add("C"); hs.add("A"); hs.add("B"); hs.add("D");
        System.out.println("  HashSet:      " + hs + "  (sin orden)");

        // LinkedHashSet
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("C"); lhs.add("A"); lhs.add("B"); lhs.add("D");
        System.out.println("  LinkedHashSet: " + lhs + "  (orden insercion)");

        // TreeSet
        TreeSet<String> ts = new TreeSet<>();
        ts.add("C"); ts.add("A"); ts.add("B"); ts.add("D");
        System.out.println("  TreeSet:       " + ts + "  (orden natural)");
        System.out.println();

        // ============================================================
        // EFICIENCIA (Big-O)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EFICIENCIA (Big-O)");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Operacion     | HashSet | LinkedHashSet | TreeSet");
        System.out.println("  --------------+---------+---------------+---------");
        System.out.println("  add()         | O(1)    | O(1)          | O(log n)");
        System.out.println("  remove()      | O(1)    | O(1)          | O(log n)");
        System.out.println("  contains()    | O(1)    | O(1)          | O(log n)");
        System.out.println("  orden         | no      | insercion     | natural");
        System.out.println("  permite null  | si      | si            | no");
        System.out.println();
        System.out.println("  Para colecciones GRANDES (millones):");
        System.out.println("    HashSet es siempre la opcion mas rapida");
        System.out.println("    TreeSet es mas lento pero mantiene orden");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V11: SET Y HASHSET)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Set: sin duplicados, sin get(index)");
        System.out.println("  - HashSet: O(1), sin orden, permite null");
        System.out.println("  - LinkedHashSet: O(1), orden insercion");
        System.out.println("  - TreeSet: O(log n), orden natural, no permite null");
        System.out.println("  - equals() y hashCode() son ESENCIALES");
        System.out.println("  - Proximo video: equals y hashCode con objetos propios");
    }
}
