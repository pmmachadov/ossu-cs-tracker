class Video_5_08_EjemploClaseCirculo {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-08 JAVA: Ejemplo clase Circulo DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=FL3qVam0T78&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=101";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 5";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // RESUMEN para el examen (CHULETA)
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ====================================================================
          RESUMEN RAPIDO - EJEMPLO CLASE CIRCULO (TEMA 5 - V08)
        ====================================================================

        --- CLASE CIRCULO (repaso practico) ---
        - Atributos privados: double radio, String color, int centroX, int centroY.
        - Metodos: getRadio, setRadio, getColor, setColor, area, toString/mostrarDatos.
        - Uso de SETTER con VALIDACION para evitar radios negativos.

        --- SETTER CON VALIDACION (2 formas) ---
        Forma 1: si negativo, poner a 0
          public void setRadio(double nuevoRadio) {
              if (nuevoRadio >= 0) {
                  radio = nuevoRadio;
              } else {
                  radio = 0;
              }
          }

        Forma 2: si negativo, NO modificar (mejor)
          public void setRadio(double nuevoRadio) {
              if (nuevoRadio >= 0) {
                  radio = nuevoRadio;
              }
              // si es negativo, no hace nada, conserva el valor anterior
          }

        --- SOBRECARGA DE CONSTRUCTORES ---
        Podemos tener varios constructores con distintos parametros:
        - Circulo() -> valores por defecto (radio=50, color=Negro, centro=100,100)
        - Circulo(double r) -> solo radio, color=Blanco, centro=0,0
        - Circulo(double r, String c, int x, int y) -> todos los valores

        Para evitar duplicar validacion, el constructor puede LLAMAR al setter:
          Circulo(double r) {
              setRadio(r);  // Usa el mismo setter con validacion
              color = "Blanco";
              centroX = 0;
              centroY = 0;
          }

        --- VALORES POR DEFECTO ---
        Si un atributo primitivo NO se asigna, tiene valor por defecto:
        - int, long -> 0
        - double, float -> 0.0
        - boolean -> false
        - Objetos (String incluido) -> null

        Importante: si el constructor no asigna radio y el setter no lo
        modifica porque es negativo, el radio queda a 0.0 (por defecto).

        --- METODOS SOBRE LA INSTANCIA ---
        - this.radio se refiere al atributo de la instancia actual.
        - Los metodos trabajan con los datos de la instancia que los invoca.
        - Si c1 tiene radio=50, c1.area() usa 50.
        - Si c2 tiene radio=125, c2.area() usa 125.
        - Cada instancia tiene su propio estado.

        --- INTERACCION ENTRE INSTANCIAS ---
        Podemos usar el getter de una instancia como parametro de otra:
          c2.setRadio(c1.getRadio());
        Esto copia el radio de c1 a c2.

        --- METODO mostrarDatos() vs toString() ---
        - toString(): devuelve String, se puede usar en concatenacion.
        - mostrarDatos(): void, imprime directamente con System.out.
        - Ambos son validos, depende de lo que necesitemos.

        ====================================================================
        """;

    // ================================================================
    // CLASE CIRCULO
    // ================================================================
    static class Circulo {
        private double radio;
        private String color;
        private int centroX;
        private int centroY;

        // Constructor vacio (valores por defecto)
        Circulo() {
            radio = 50;
            color = "Negro";
            centroX = 100;
            centroY = 100;
        }

        // Constructor con un parametro (radio)
        // Llama al setter para validar
        Circulo(double r) {
            setRadio(r);       // Usa el setter con validacion
            color = "Blanco";
            centroX = 0;
            centroY = 0;
        }

        // Constructor con todos los parametros
        Circulo(double r, String c, int x, int y) {
            setRadio(r);
            color = c;
            centroX = x;
            centroY = y;
        }

        // GETTERS
        double getRadio() { return radio; }
        String getColor() { return color; }
        int getCentroX() { return centroX; }
        int getCentroY() { return centroY; }

        // SETTERS (con validacion)
        void setRadio(double nuevoRadio) {
            if (nuevoRadio >= 0) {
                radio = nuevoRadio;
            }
            // Si es negativo, NO modifica (conserva el valor anterior)
        }

        void setColor(String nuevoColor) { color = nuevoColor; }
        void setCentro(int x, int y) { centroX = x; centroY = y; }

        // OTROS METODOS
        double area() {
            return radio * radio * Math.PI;
        }

        void mostrarDatos() {
            System.out.println("  Circulo de radio " + radio
                + ", color " + color
                + ", centro (" + centroX + "," + centroY + ")"
                + " y su area es: " + area());
        }

        public String toString() {
            return "Circulo de radio " + radio
                + ", color " + color
                + ", centro (" + centroX + "," + centroY + ")";
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 5 - V08: EJEMPLO PRACTICO CLASE CIRCULO");
        System.out.println();

        // ============================================================
        // PARTE 1: Constructor vacio + setter con validacion
        // ============================================================
        separador("PARTE 1: Setter con validacion (radio negativo)");

        Circulo c1 = new Circulo();
        System.out.println("  c1 creado con constructor vacio (radio=50)");
        System.out.println("  " + c1.toString());
        System.out.println();

        System.out.println("  Intentando setRadio(-2.9) -> NO modifica:");
        c1.setRadio(-2.9);
        System.out.println("  Radio actual: " + c1.getRadio() + " (sigue siendo 50)");
        System.out.println();

        System.out.println("  setRadio(35) -> modifica:");
        c1.setRadio(35);
        System.out.println("  Radio actual: " + c1.getRadio() + " (cambiado a 35)");
        System.out.println();

        // ============================================================
        // PARTE 2: Constructor con radio + validacion
        // ============================================================
        separador("PARTE 2: Constructor con radio (validacion incluida)");

        Circulo c2 = new Circulo(125);
        System.out.println("  c2 = new Circulo(125)");
        c2.mostrarDatos();
        System.out.println();

        Circulo cNegativo = new Circulo(-50);
        System.out.println("  cNegativo = new Circulo(-50) -> radio no asignado");
        System.out.println("  Radio de cNegativo: " + cNegativo.getRadio()
            + " (0.0 por defecto, ya que el setter no lo modifico)");
        System.out.println();

        // ============================================================
        // PARTE 3: Dos instancias independientes
        // ============================================================
        separador("PARTE 3: Varias instancias, estados independientes");

        Circulo c3 = new Circulo(10, "Azul", 25, 30);
        Circulo c4 = new Circulo();

        System.out.println("  c3 = new Circulo(10, \"Azul\", 25, 30)");
        System.out.println("  c4 = new Circulo() (por defecto)");
        System.out.println();

        // Cada una con su propio estado y area
        System.out.println("  c3:");
        c3.mostrarDatos();
        System.out.println("  c4:");
        c4.mostrarDatos();
        System.out.println();

        // ============================================================
        // PARTE 4: Interaccion entre instancias
        // ============================================================
        separador("PARTE 4: Copiar valor de una instancia a otra");

        System.out.println("  c4.setRadio(c3.getRadio()) -> copia radio de c3 a c4");
        c4.setRadio(c3.getRadio());
        System.out.println("  c3 radio: " + c3.getRadio() + " | c4 radio: " + c4.getRadio());
        System.out.println();

        System.out.println("  c3 y c4 ahora tienen el mismo radio,");
        System.out.println("  pero siguen siendo objetos DISTINTOS.");
        System.out.println("  c3.mostrarDatos():");
        c3.mostrarDatos();
        System.out.println("  c4.mostrarDatos():");
        c4.mostrarDatos();
        System.out.println();

        // ============================================================
        // PARTE 5: mostrarDatos() con area incluida
        // ============================================================
        separador("PARTE 5: Metodo mostrarDatos() con area");

        System.out.println("  El metodo mostrarDatos() ahora incluye el area:");
        System.out.println("  c1 (radio=35):");
        c1.mostrarDatos();
        System.out.println("  c2 (radio=125):");
        c2.mostrarDatos();
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V08: EJEMPLO CLASE CIRCULO)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS PRACTICOS:");
        System.out.println("  - Setter con validacion (2 formas)");
        System.out.println("  - Constructor llama al setter para reutilizar logica");
        System.out.println("  - Valores por defecto si no se asigna (0.0, null)");
        System.out.println("  - Cada instancia tiene su propio estado");
        System.out.println("  - Interaccion entre instancias (get/set entre objetos)");
        System.out.println("  - Sobrecarga de constructores");
    }

    // -------------------------------------------------------------
    // METODO AUXILIAR
    // -------------------------------------------------------------
    public static void separador(String titulo) {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("  " + titulo);
        System.out.println("============================================================");
    }
}
