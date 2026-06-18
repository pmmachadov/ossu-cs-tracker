import java.util.ArrayList;
import java.util.Objects;

class Video_6_10_EqualsYHashCode {

    public static final String TITULO = "6-10 JAVA: equals y hashCode DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=D3DBfrWnBJo&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=131";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - equals y hashCode (TEMA 6 - V10)\n"
        + "================================================\n\n"
        + "equals(): compara si dos objetos son iguales por CONTENIDO.\n"
        + "- Por defecto (Object): compara REFERENCIAS (==).\n"
        + "- Se SOBREESCRIBE para comparar por estado interno.\n\n"
        + "hashCode(): devuelve un entero unico basado en el estado del objeto.\n"
        + "- Si equals() es true -> hashCode() debe ser el mismo.\n"
        + "- Usado por colecciones basadas en hash (HashMap, HashSet).\n\n"
        + "CONTRATO equals-hashCode:\n"
        + "1. Si dos objetos son equals -> mismo hashCode.\n"
        + "2. Si dos objetos tienen mismo hashCode -> pueden o no ser equals.\n"
        + "3. Si se sobrescribe equals, DEBE sobrescribirse hashCode.\n\n"
        + "IMPLEMENTACION TIPICA DE equals:\n"
        + "public boolean equals(Object obj) {\n"
        + "    if (obj == null) return false;\n"
        + "    if (obj == this) return true;  // misma referencia\n"
        + "    if (getClass() != obj.getClass()) return false;  // mismo tipo\n"
        + "    Punto2D otro = (Punto2D) obj;  // casting\n"
        + "    return x == otro.x && y == otro.y;  // comparar campos\n"
        + "}\n\n"
        + "IMPLEMENTACION TIPICA DE hashCode:\n"
        + "public int hashCode() {\n"
        + "    final int prime = 31;\n"
        + "    int result = 1;\n"
        + "    result = prime * result + x;\n"
        + "    result = prime * result + y;\n"
        + "    return result;\n"
        + "}\n\n"
        + "GENERACION AUTOMATICA:\n"
        + "- VS Code: boton derecho -> Source Action -> Generate hashCode() and equals()\n\n"
        + "EFECTO EN ARRAYLIST:\n"
        + "- remove(objeto) usa equals() para encontrar el elemento.\n"
        + "- Sin equals sobreescrito: NO encuentra el objeto aunque tenga mismos datos.\n"
        + "- Con equals sobreescrito: lo encuentra y lo borra.";

    // ================================================================
    // CLASE PUNTO2D (con equals y hashCode)
    // ================================================================
    static class Punto2D {
        private int x, y;

        Punto2D(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() { return x; }
        int getY() { return y; }

        // equals generado automaticamente (VS Code)
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            Punto2D other = (Punto2D) obj;
            return x == other.x && y == other.y;
        }

        // hashCode generado automaticamente (VS Code)
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V10: equals y hashCode");
        System.out.println();

        // ============================================================
        // PARTE 1: Comparacion con equals SOBREESCRITO
        // ============================================================
        System.out.println("=== PARTE 1: equals() sobreescrito ===");

        Punto2D p1 = new Punto2D(0, 0);
        Punto2D p2 = new Punto2D(0, 0);
        Punto2D p3 = new Punto2D(0, 0);
        Punto2D p4 = p1;  // Misma referencia

        System.out.println("  p1.equals(p2): " + p1.equals(p2)
            + " (mismo contenido -> true)");
        System.out.println("  p1.equals(p4): " + p1.equals(p4)
            + " (misma referencia -> true)");
        System.out.println();

        // ============================================================
        // PARTE 2: hashCode
        // ============================================================
        System.out.println("=== PARTE 2: hashCode() ===");
        System.out.println("  p1.hashCode(): " + p1.hashCode());
        System.out.println("  p2.hashCode(): " + p2.hashCode());
        System.out.println("  p3.hashCode(): " + p3.hashCode());
        System.out.println("  (Los 3 iguales porque tienen el mismo estado)");
        System.out.println();

        Punto2D p5 = new Punto2D(1, 2);
        System.out.println("  p5 (1,2).hashCode(): " + p5.hashCode());
        System.out.println("  (Distinto porque tiene distinto estado)");
        System.out.println();

        // ============================================================
        // PARTE 3: ArrayList.remove() con equals
        // ============================================================
        System.out.println("=== PARTE 3: remove() con equals() ===");

        ArrayList<Punto2D> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);

        System.out.println("  Lista antes de remove: " + lista);
        System.out.println("  (4 elementos: p1, p2, p3, p4)");

        // remove con new Punto2D (distinta instancia, mismo contenido)
        boolean borrado = lista.remove(new Punto2D(0, 0));
        System.out.println("  remove(new Punto2D(0,0)): " + borrado
            + " (LO encuentra gracias a equals())");
        System.out.println("  Lista despues: " + lista + " (3 elementos)");
        System.out.println("  p4 sigue existiendo: " + p4 + " (misma referencia que p1)");
        System.out.println();

        // ============================================================
        // PARTE 4: Sin equals sobreescrito (simulacion)
        // ============================================================
        System.out.println("=== PARTE 4: SIN equals (simulado) ===");
        System.out.println("  Si NO hubieramos sobrescrito equals:");
        System.out.println("  p1.equals(p2) -> false (compara referencias)");
        System.out.println("  remove(new Punto2D(0,0)) -> false (no lo encuentra)");
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 6 - V10: equals y hashCode)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - equals: compara contenido de objetos");
        System.out.println("  - hashCode: entero unico basado en el estado");
        System.out.println("  - equals=true -> mismo hashCode (CONTRATO)");
        System.out.println("  - ArrayList.remove() usa equals()");
        System.out.println("  - Sin equals: remove(new Punto()) no funciona");
        System.out.println("  - Generacion automatica en VS Code");
    }
}
