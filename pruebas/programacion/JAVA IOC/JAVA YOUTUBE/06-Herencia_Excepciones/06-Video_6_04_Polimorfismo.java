import java.util.ArrayList;

class Video_6_04_Polimorfismo {

    public static final String TITULO = "6-04 JAVA: Polimorfismo DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=c53SKnJe7Dw&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=125";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - POLIMORFISMO (TEMA 6 - V04)\n"
        + "==============================================\n\n"
        + "DEFINICION: capacidad de una clase hija de redefinir metodos del padre.\n"
        + "Un mismo metodo se comporta distinto segun el tipo real del objeto.\n\n"
        + "DOS TIPOS DE POLIMORFISMO:\n"
        + "1. POLIMORFISMO DE SOBRECARGA (overloading):\n"
        + "   - Mismo nombre de metodo, DISTINTOS PARAMETROS.\n"
        + "   - Se resuelve en tiempo de compilacion.\n"
        + "   - Ej: suma(int, int), suma(double, double), suma(int, int, int)\n\n"
        + "2. POLIMORFISMO DE SOBRESCRITURA (overriding):\n"
        + "   - Mismo nombre, MISMOS PARAMETROS, distinto comportamiento.\n"
        + "   - Se resuelve en tiempo de ejecucion.\n"
        + "   - Ej: Animal.hacerRuido(), Perro.hacerRuido(), Pitbull.hacerRuido()\n\n"
        + "EJEMPLO CLASICO: Animal -> Perro -> Pitbull\n"
        + "ArrayList<Animal> animales = new ArrayList<>();\n"
        + "animales.add(new Animal());\n"
        + "animales.add(new Perro());\n"
        + "animales.add(new Pitbull());\n\n"
        + "for (Animal a : animales) {\n"
        + "    a.hacerRuido();  // Cada uno ejecuta SU metodo\n"
        + "}\n\n"
        + "REGLA IMPORTANTE:\n"
        + "- Una variable de tipo padre puede apuntar a objeto hijo.\n"
        + "- Pero NO al reves: Perro p = new Animal() NO compila.\n"
        + "- ArrayList<Animal> puede contener Perro y Pitbull (son Animal).\n"
        + "- ArrayList<Perro> NO puede contener un Animal (no todo animal es perro).";

    // ================================================================
    // CLASES ANIMAL, PERRO, PITBULL
    // ================================================================
    static class Animal {
        void hacerRuido() {
            System.out.println("  El animal hace ruido");
        }
    }

    static class Perro extends Animal {
        void hacerRuido() {
            System.out.println("  El perro ladra");
        }
    }

    static class Pitbull extends Perro {
        void hacerRuido() {
            System.out.println("  El pitbull tiene un ladrido profundo");
        }
    }

    // ================================================================
    // CLASE CON SOBRECARGA (polimorfismo de sobrecarga)
    // ================================================================
    static class Calculadora {
        // Sobrecarga: mismo nombre, distintos parametros
        int suma(int a, int b) {
            return a + b;
        }

        double suma(double a, double b) {
            return a + b;
        }

        int suma(int a, int b, int c) {
            return a + b + c;
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V04: POLIMORFISMO");
        System.out.println();

        // ============================================================
        // PARTE 1: Polimorfismo de SOBRECARGA (overloading)
        // ============================================================
        System.out.println("=== PARTE 1: POLIMORFISMO DE SOBRECARGA ===");
        Calculadora calc = new Calculadora();
        System.out.println("  suma(int, int): " + calc.suma(2, 3));
        System.out.println("  suma(double, double): " + calc.suma(2.5, 3.7));
        System.out.println("  suma(int, int, int): " + calc.suma(2, 3, 4));
        System.out.println("  (Mismo nombre, distintos parametros -> distinto comportamiento)");
        System.out.println();

        // ============================================================
        // PARTE 2: Polimorfismo de SOBRESCRITURA (overriding)
        // ============================================================
        System.out.println("=== PARTE 2: POLIMORFISMO DE SOBRESCRITURA ===");

        ArrayList<Animal> animales = new ArrayList<>();
        animales.add(new Animal());
        animales.add(new Perro());
        animales.add(new Pitbull());

        System.out.println("  ArrayList<Animal> con 3 tipos distintos:");
        for (Animal a : animales) {
            a.hacerRuido();  // Cada uno ejecuta SU metodo
        }
        System.out.println("  (La referencia es Animal, pero el objeto real determina el metodo)");
        System.out.println();

        // ============================================================
        // PARTE 3: Herencia sin sobrescritura (hereda del padre mas cercano)
        // ============================================================
        System.out.println("=== PARTE 3: Sin sobrescritura (hereda del padre) ===");

        // Creamos clases locales para este ejemplo
        class PerroSinOverride extends Animal {
            // NO sobrescribe hacerRuido() -> hereda el de Animal
        }

        class PitbullConOverride extends PerroSinOverride {
            void hacerRuido() {
                System.out.println("  Pitbull (hereda de PerroSinOverride que no sobreescribe)");
            }
        }

        ArrayList<Animal> lista2 = new ArrayList<>();
        lista2.add(new Animal());
        lista2.add(new PerroSinOverride());
        lista2.add(new PitbullConOverride());

        System.out.println("  PerroSinOverride NO tiene hacerRuido() -> usa el de Animal:");
        for (Animal a : lista2) {
            a.hacerRuido();
        }
        System.out.println("  PitbullConOverride SI tiene hacerRuido() -> usa el suyo");
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 6 - V04: POLIMORFISMO)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  DOS TIPOS DE POLIMORFISMO:");
        System.out.println("  1. SOBRECARGA: mismo nombre, distintos parametros");
        System.out.println("  2. SOBRESCRITURA: mismo metodo, distinto comportamiento");
        System.out.println();
        System.out.println("  CLAVES:");
        System.out.println("  - La referencia puede ser del padre, el objeto del hijo");
        System.out.println("  - El metodo ejecutado depende del TIPO REAL del objeto");
        System.out.println("  - ArrayList<Animal> puede contener Perro y Pitbull");
        System.out.println("  - Si el hijo no sobrescribe, usa el metodo del padre");
    }
}
