class Video_5_07_IntroduccionPOOJava {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-07 JAVA: Introduccion a la POO (sintaxis) DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=rlNf7toQST8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=100";
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
          RESUMEN RAPIDO - INTRODUCCION A LA POO EN JAVA (TEMA 5 - V07)
        ====================================================================

        --- JAVA Y LA POO ---
        Java es un lenguaje FUERTEMENTE orientado a objetos.
        - Un programa en Java consiste en construir clases.
        - Las clases son las FABRICAS de objetos.
        - Dos tipos de clases:
          1. Clases que definen TIPOS DE DATO (Coche, Persona, Circulo)
          2. Clase con el MAIN (el programa que se ejecuta)

        --- ESTRUCTURA BASICA DE UNA CLASE ---
        public class Circulo {
            // 1. ATRIBUTOS (variables de instancia)
            private double radio;
            private String color;
            private int centroX, centroY;

            // 2. CONSTRUCTORES
            public Circulo() { ... }

            // 3. GETTERS Y SETTERS
            public double getRadio() { return radio; }
            public void setRadio(double nuevoRadio) { ... }

            // 4. OTROS METODOS
            public double area() { ... }
            public String toString() { ... }
        }

        --- MODIFICADORES DE ACCESO ---
        public:    visible desde CUALQUIER clase.
        private:   visible SOLO dentro de la propia clase.
        protected: visible desde el mismo paquete + subclases (se vera en T6).
        (sin):     visible desde el mismo PAQUETE (package-private).

        Se pueden aplicar a: clases, atributos, metodos y constructores.

        Para CLASES solo hay dos opciones:
        - public: puede usarse desde cualquier parte.
        - (sin): solo dentro del mismo paquete.

        --- ATRIBUTOS (variables de instancia) ---
        - Representan el ESTADO del objeto.
        - Se declaran: [ambito] [tipo] [identificador];
        - Normalmente PRIVATE para encapsular.
        - Ej: private double radio;

        --- CONSTRUCTOR ---
        - Metodo especial para CREAR instancias (new).
        - Mismo nombre que la clase, SIN tipo de retorno.
        - Puede tener parametros o estar vacio.
        - Puede haber VARIOS constructores (sobrecarga).
        - Se invoca con new: Circulo c1 = new Circulo();

        --- GETTERS y SETTERS ---
        - GETTER: obtiene el valor de un atributo privado.
          public double getRadio() { return radio; }
        - SETTER: modifica el valor de un atributo privado.
          public void setRadio(double r) { this.radio = r; }
        - Pueden tener VALIDACION (ej: no permitir radios negativos).
        - No todos los atributos necesitan getter y setter.
        - Buena practica: poner los MINIMOS necesarios.

        --- OTROS METODOS ---
        - Operaciones adicionales sobre la instancia.
        - Ej: area() calcula el area usando el radio.
        - Ej: toString() devuelve una representacion en String del objeto.

        --- CLASIFICACION DE METODOS ---
        1. CONSTRUCTORES: crear objetos (new)
        2. MODIFICADORES (setters): modificar el estado
        3. CONSULTORES (getters): obtener el estado
        4. METODOS DE CLASE: cualquier otra operacion

        ====================================================================
        """;

    // ================================================================
    // CLASE CIRCULO (ejemplo del video)
    // ================================================================
    static class Circulo {
        // ATRIBUTOS (privados -> encapsulados)
        private double radio;
        private String color;
        private int centroX;
        private int centroY;

        // CONSTRUCTOR (sin parametros -> valores por defecto)
        Circulo() {
            radio = 50;
            color = "Negro";
            centroX = 100;
            centroY = 100;
        }

        // CONSTRUCTOR (con parametros)
        Circulo(double radio, String color, int centroX, int centroY) {
            this.radio = radio;
            this.color = color;
            this.centroX = centroX;
            this.centroY = centroY;
        }

        // GETTERS
        double getRadio() {
            return radio;
        }

        String getColor() {
            return color;
        }

        int getCentroX() {
            return centroX;
        }

        int getCentroY() {
            return centroY;
        }

        // SETTERS
        void setRadio(double nuevoRadio) {
            if (nuevoRadio >= 0) {
                radio = nuevoRadio;
            } else {
                radio = 0;
                System.out.println("  ERROR: Radio negativo. Se establece a 0.");
            }
        }

        void setColor(String nuevoColor) {
            color = nuevoColor;
        }

        void setCentro(int x, int y) {
            centroX = x;
            centroY = y;
        }

        // OTROS METODOS
        double area() {
            return radio * radio * Math.PI;
        }

        // toString: representacion en String del objeto
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
        System.out.println("TEMA 5 - V07: SINTAXIS POO EN JAVA");
        System.out.println("=====================================");
        System.out.println();

        // ============================================================
        // PARTE 1: Crear objeto con constructor por defecto
        // ============================================================
        separador("PARTE 1: Constructor por defecto");

        Circulo c1 = new Circulo();
        System.out.println("  Circulo c1 = new Circulo();");
        System.out.println("  " + c1.toString());
        System.out.println("  Area: " + c1.area());
        System.out.println();

        // ============================================================
        // PARTE 2: Usar setter para modificar
        // ============================================================
        separador("PARTE 2: Uso de setters");

        System.out.println("  c1.setRadio(2.9);");
        c1.setRadio(2.9);
        System.out.println("  " + c1.toString());
        System.out.println("  Area: " + c1.area());
        System.out.println();

        // ============================================================
        // PARTE 3: Setter con validacion (radio negativo)
        // ============================================================
        separador("PARTE 3: Setter con validacion");

        System.out.println("  Intentando radio negativo (-5):");
        c1.setRadio(-5);
        System.out.println("  Radio actual: " + c1.getRadio() + " (se puso a 0)");
        System.out.println();

        // ============================================================
        // PARTE 4: Constructor con parametros
        // ============================================================
        separador("PARTE 4: Constructor con parametros");

        Circulo c2 = new Circulo(10.5, "Rojo", 50, 75);
        System.out.println("  Circulo c2 = new Circulo(10.5, \"Rojo\", 50, 75);");
        System.out.println("  " + c2.toString());
        System.out.println("  Area: " + c2.area());
        System.out.println();

        // ============================================================
        // PARTE 5: Modificadores de acceso
        // ============================================================
        separador("PARTE 5: Modificadores de acceso (encapsulacion)");

        System.out.println("  Los atributos son PRIVATE:");
        System.out.println("  c1.radio -> ERROR (no visible)");
        System.out.println("  c1.getRadio() -> " + c1.getRadio() + " (OK, getter publico)");
        System.out.println();

        System.out.println("  Si fueran PUBLIC, cualquiera podria modificarlos:");
        System.out.println("  c1.radio = -100;  (posible pero incorrecto)");
        System.out.println("  Con setter validado: c1.setRadio(-100) -> se pone a 0");
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V07: INTRODUCCION POO JAVA)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  RESUMEN DE LA CLASE:");
        System.out.println("  - Atributos private (encapsulacion)");
        System.out.println("  - Constructor(es) para crear instancias");
        System.out.println("  - Getters para consultar valores");
        System.out.println("  - Setters para modificar (con validacion posible)");
        System.out.println("  - Metodos adicionales (area, toString, etc.)");
        System.out.println("  - Clase con MAIN para ejecutar el programa");
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
