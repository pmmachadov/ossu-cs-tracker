import java.util.Arrays;
import java.util.Scanner;

class Video_6_09_TiposEnumerados {

    public static final String TITULO = "6-09 JAVA: Tipos enumerados DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=AkjbCun5kA8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=130";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - TIPOS ENUMERADOS (TEMA 6 - V09)\n"
        + "==============================================\n\n"
        + "ENUM: tipo especial que define un conjunto fijo de constantes.\n"
        + "- Se declara con: enum Nombre { VALOR1, VALOR2, ... }\n"
        + "- No se puede instanciar con new, se accede con Tipo.VALOR\n"
        + "- Todos los enum heredan de java.lang.Enum\n\n"
        + "METODOS AUTOMATICOS:\n"
        + "  values(): devuelve un array con todos los valores del enum\n"
        + "  valueOf(String): convierte un String a enum (si coincide exactamente)\n"
        + "  toString(): devuelve el nombre de la constante\n\n"
        + "ENUM CON ATRIBUTOS:\n"
        + "  enum Mes {\n"
        + "      ENERO(31), FEBRERO(28), ...;\n"
        + "      private final int dias;\n"
        + "      Mes(int d) { this.dias = d; }\n"
        + "      int getDias() { return dias; }\n"
        + "  }\n\n"
        + "RECORRER UN ENUM:\n"
        + "  for (DiaSemana d : DiaSemana.values()) { ... }\n"
        + "  Arrays.toString(DiaSemana.values())\n\n"
        + "CONVERTIR STRING A ENUM:\n"
        + "  String s = entrada.nextLine().toUpperCase();\n"
        + "  Mes mesActual = Mes.valueOf(s);\n"
        + "  // Si s no coincide con ningun valor -> excepcion\n\n"
        + "IMPORTANTE:\n"
        + "- Los valores se escriben en MAYUSCULAS por convencion.\n"
        + "- valueOf() distingue mayusculas/minusculas.\n"
        + "- Se puede usar toUpperCase() para normalizar la entrada.\n"
        + "- Si el String no es valido, lanza IllegalArgumentException.";

    // ================================================================
    // ENUM: DIAS DE LA SEMANA
    // ================================================================
    enum DiaSemana {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }

    // ================================================================
    // ENUM: MESES DEL ANO (con atributo dias)
    // ================================================================
    enum Mes {
        ENERO(31), FEBRERO(28), MARZO(31), ABRIL(30),
        MAYO(31), JUNIO(30), JULIO(31), AGOSTO(31),
        SEPTIEMBRE(30), OCTUBRE(31), NOVIEMBRE(30), DICIEMBRE(31);

        private final int dias;

        Mes(int dias) {
            this.dias = dias;
        }

        int getDias() {
            return dias;
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V09: TIPOS ENUMERADOS");
        System.out.println();

        // ============================================================
        // PARTE 1: Declaracion y uso basico
        // ============================================================
        System.out.println("=== PARTE 1: USO BASICO ===");
        DiaSemana diaActual = DiaSemana.JUEVES;
        Mes mesActual = Mes.ENERO;

        System.out.println("  diaActual = " + diaActual);
        System.out.println("  mesActual = " + mesActual);
        System.out.println();

        // ============================================================
        // PARTE 2: Recorrer todos los valores de un enum
        // ============================================================
        System.out.println("=== PARTE 2: RECORRER ENUM ===");

        // Con for-each
        System.out.print("  Dias de la semana: ");
        for (DiaSemana d : DiaSemana.values()) {
            System.out.print(d + " ");
        }
        System.out.println();

        // Con Arrays.toString
        System.out.println("  Meses del ano: " + Arrays.toString(Mes.values()));
        System.out.println();

        // ============================================================
        // PARTE 3: Enum con atributos (dias por mes)
        // ============================================================
        System.out.println("=== PARTE 3: ENUM CON ATRIBUTOS ===");

        for (Mes m : Mes.values()) {
            System.out.println("  " + m + " tiene " + m.getDias() + " dias");
        }
        System.out.println();

        // ============================================================
        // PARTE 4: valueOf() - convertir String a enum
        // ============================================================
        System.out.println("=== PARTE 4: valueOf() ===");

        // Conversion directa
        Mes mesPorNombre = Mes.valueOf("FEBRERO");
        System.out.println("  Mes.valueOf(\"FEBRERO\") = " + mesPorNombre);
        System.out.println("  " + mesPorNombre + " tiene " + mesPorNombre.getDias() + " dias");
        System.out.println();

        // ============================================================
        // PARTE 5: valueOf() con entrada de teclado (conversion)
        // ============================================================
        System.out.println("=== PARTE 5: valueOf() con entrada ===");
        System.out.println("  (Simulacion de entrada de teclado)");

        Scanner sc = new Scanner(System.in);
        System.out.print("  Introduce un mes (en mayusculas): ");
        String entrada = sc.nextLine().toUpperCase();  // Normalizar a mayusculas

        try {
            Mes mesInput = Mes.valueOf(entrada);
            System.out.println("  " + mesInput + " tiene " + mesInput.getDias() + " dias");
        } catch (IllegalArgumentException e) {
            System.out.println("  ERROR: '" + entrada + "' no es un mes valido");
        }
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 6 - V09: TIPOS ENUMERADOS)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - enum: conjunto fijo de valores constantes");
        System.out.println("  - values(): todos los valores del enum");
        System.out.println("  - valueOf(): String -> enum");
        System.out.println("  - Los enum pueden tener atributos y metodos");
        System.out.println("  - toUpperCase() para normalizar entrada");
        System.out.println("  - Sin exception handling, valueOf() lanza error si no coincide");
    }
}
