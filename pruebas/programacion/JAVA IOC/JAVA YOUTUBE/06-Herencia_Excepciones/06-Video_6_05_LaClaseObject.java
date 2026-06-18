import java.util.ArrayList;

class Video_6_05_LaClaseObject {

    public static final String TITULO = "6-05 JAVA: La clase Object DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=1Uh9RNSkaLM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=126";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - LA CLASE OBJECT (TEMA 6 - V05)\n"
        + "==============================================\n\n"
        + "Object es la SUPERCLASE de TODAS las clases en Java.\n"
        + "- Toda clase hereda implicitamente de Object.\n"
        + "- Proporciona metodos basicos que cualquier objeto tiene.\n\n"
        + "METODOS PRINCIPALES DE OBJECT:\n"
        + "1. toString(): devuelve representacion en String del objeto.\n"
        + "   - Por defecto: nombreClase@hashCode (direccion memoria).\n"
        + "   - Se SOBREESCRIBE para mostrar informacion util.\n\n"
        + "2. equals(Object obj): compara si dos objetos son iguales.\n"
        + "   - Por defecto: compara REFERENCIAS (==).\n"
        + "   - Se SOBREESCRIBE para comparar por CONTENIDO.\n\n"
        + "3. hashCode(): devuelve un entero unico para cada objeto.\n"
        + "   - Relacionado con equals: si equals es true, hashCode igual.\n\n"
        + "4. getClass(): devuelve la clase del objeto.\n"
        + "   - obj.getClass().getName() -> nombre de la clase.\n\n"
        + "5. clone(): crea una copia del objeto.\n\n"
        + "JERARQUIA DE CLASES:\n"
        + "Object -> Animal -> Perro -> Pitbull\n"
        + "Object -> Gato\n"
        + "Un Pitbull ES un Perro, ES un Animal, ES un Object.\n\n"
        + "ArrayList<Object> puede contener CUALQUIER tipo de objeto.\n"
        + "getClass().getName() muestra el nombre real de la clase.\n\n"
        + "SI UNA CLASE NO SOBREESCRIBE toString():\n"
        + "- Usa el de la clase padre mas cercana que lo tenga.\n"
        + "- Si ninguno lo tiene, usa el de Object (direccion memoria).";

    // ================================================================
    // CLASES ANIMAL, PERRO, PITBULL (con toString())
    // ================================================================
    static class Animal {
        public String toString() {
            return "El animal hace ruido";
        }
    }

    static class Perro extends Animal {
        public String toString() {
            return "El perro ladra";
        }
    }

    static class Pitbull extends Perro {
        public String toString() {
            return "El pitbull tiene un ladrido profundo";
        }
    }

    // Clase Gato (para demostrar ArrayList<Object>)
    static class Gato extends Animal {
        public String toString() {
            return "El gato maulla";
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V05: LA CLASE OBJECT");
        System.out.println();

        // ============================================================
        // PARTE 1: toString() polimorfico + getClass()
        // ============================================================
        System.out.println("=== PARTE 1: toString() + getClass() ===");

        ArrayList<Animal> animales = new ArrayList<>();
        animales.add(new Animal());
        animales.add(new Perro());
        animales.add(new Pitbull());

        for (Animal a : animales) {
            System.out.println("  Clase: " + a.getClass().getName());
            System.out.println("    " + a.toString());
        }
        System.out.println();

        // ============================================================
        // PARTE 2: Sin sobrescritura de toString()
        // ============================================================
        System.out.println("=== PARTE 2: Sin toString() -> usa el padre ===");

        class AnimalSinToString extends Animal {
            // NO sobrescribe toString() -> hereda el de Animal
        }

        class PerroSinToString extends AnimalSinToString {
            // NO sobrescribe -> hereda el de AnimalSinToString -> Animal
        }

        System.out.println("  AnimalSinToString: " + new AnimalSinToString());
        System.out.println("  (Usa toString() de Animal: 'El animal hace ruido')");
        System.out.println();

        // ============================================================
        // PARTE 3: ArrayList<Object> (contiene cualquier tipo)
        // ============================================================
        System.out.println("=== PARTE 3: ArrayList<Object> ===");

        ArrayList<Object> objetos = new ArrayList<>();
        objetos.add(new Animal());
        objetos.add(new Perro());
        objetos.add(new Pitbull());
        objetos.add(new Gato());
        objetos.add("Esto es un String");
        objetos.add(42);  // Integer (autoboxing)

        for (Object o : objetos) {
            System.out.println("  [" + o.getClass().getSimpleName() + "]: " + o);
        }
        System.out.println();

        // ============================================================
        // PARTE 4: Metodos de Object
        // ============================================================
        System.out.println("=== PARTE 4: Metodos heredados de Object ===");

        Animal a1 = new Animal();
        Animal a2 = new Animal();

        System.out.println("  a1.toString(): " + a1.toString());
        System.out.println("  a1.hashCode(): " + a1.hashCode());
        System.out.println("  a1.getClass(): " + a1.getClass().getName());
        System.out.println("  a1.equals(a2): " + a1.equals(a2)
            + " (por defecto: compara referencias, son distintas)");
        System.out.println("  a1 == a2: " + (a1 == a2)
            + " (misma referencia? No, son objetos distintos)");
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 6 - V05: LA CLASE OBJECT)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Object es la superclase de TODAS las clases");
        System.out.println("  - toString(), equals(), hashCode(), getClass(), clone()");
        System.out.println("  - getClass().getName() devuelve el nombre real");
        System.out.println("  - ArrayList<Object> acepta cualquier tipo");
        System.out.println("  - Sin sobrescritura, usa el metodo del padre mas proximo");
    }
}
