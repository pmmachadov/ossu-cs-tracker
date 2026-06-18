import java.util.InputMismatchException;
import java.util.Scanner;

class Video_6_16_ExcepcionesEjemploCompleto {

    public static final String TITULO = "6-16 JAVA: Excepciones - Ejemplo completo DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=KDxzgJ-HRQY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=137";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - EXCEPCIONES EJEMPLO COMPLETO (TEMA 6 - V16)\n"
        + "=========================================================\n\n"
        + "DOS ENFOQUES PARA VALIDAR COORDENADAS DE UN PUNTO:\n\n"
        + "ENFOQUE 1: Metodo separado nuevoPunto() que propaga excepcion.\n"
        + "- Pide x e y por teclado.\n"
        + "- Si x<0 o y<0 -> lanza PuntoNoValidoException.\n"
        + "- Si entrada no numerica -> InputMismatchException.\n\n"
        + "ENFOQUE 2: Excepcion lanzada desde el CONSTRUCTOR de Punto.\n"
        + "- El constructor de Punto(int x, int y) valida y lanza.\n"
        + "- Cualquier creacion de Punto debe estar en try-catch.\n\n"
        + "ORDEN CORRECTO EN EL CONSTRUCTOR:\n"
        + "1. Asignar this.x = x; this.y = y;  (PRIMERO)\n"
        + "2. Comprobar if (x < 0 || y < 0)    (DESPUES)\n"
        + "Si se invierte el orden, los valores seran 0 por defecto.\n\n"
        + "VENTAJA DE LA EXCEPCION PERSONALIZADA:\n"
        + "- El mensaje de error se define UN SOLO LUGAR (toString de la excepcion).\n"
        + "- Si se quiere cambiar el formato, se cambia en un unico sitio.\n"
        + "- No repetir mensajes en cada catch del programa.\n\n"
        + "PROPAGACION EN CADENA:\n"
        + "- Punto(int x, int y, String nombre) { this(x, y); ... }\n"
        + "- Si this(x,y) lanza, el constructor de 3 parametros propaga.\n"
        + "- throws PuntoNoValidoException en ambos constructores.";

    // ================================================================
    // CLASE PUNTO
    // ================================================================
    static class Punto {
        private int x, y;
        private String nombre;

        // Constructor 2 enteros (valida y lanza excepcion desde el constructor)
        Punto(int x, int y) throws PuntoNoValidoException {
            this.x = x;
            this.y = y;
            validar();
        }

        // Constructor 2 enteros + nombre
        Punto(int x, int y, String nombre) throws PuntoNoValidoException {
            this(x, y);  // Llama al constructor de arriba (puede propagar)
            this.nombre = nombre;
        }

        private void validar() throws PuntoNoValidoException {
            if (x < 0 || y < 0) {
                throw new PuntoNoValidoException(this);
            }
        }

        int getX() { return x; }
        int getY() { return y; }
        String getNombre() { return nombre; }

        public String toString() {
            return "Punto[x=" + x + ", y=" + y + "]";
        }
    }

    // ================================================================
    // EXCEPCION PERSONALIZADA
    // ================================================================
    static class PuntoNoValidoException extends Exception {
        private Punto punto;

        PuntoNoValidoException(Punto punto) {
            this.punto = ponto;  // Error intencional para mostrar
        }

        public String toString() {
            return "Las coordenadas (" + punto.getX() + ","
                + punto.getY() + ") no son validas";
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 6 - V16: EXCEPCIONES - EJEMPLO COMPLETO");
        System.out.println();

        // ============================================================
        // PARTE 1: Constructor con excepcion verificada
        // ============================================================
        System.out.println("=== PARTE 1: CONSTRUCTOR CON EXCEPCION ===");

        try {
            Punto p1 = new Punto(3, 5);
            System.out.println("  Punto creado: " + p1);

            Punto p2 = new Punto(-1, 1, "invalido");  // Debe lanzar excepcion
            System.out.println("  Esto no se imprime");
        } catch (PuntoNoValidoException e) {
            System.out.println("  " + e.toString());
        }
        System.out.println("  (El programa continua)");
        System.out.println();

        // ============================================================
        // PARTE 2: Varias instancias en distintos catch
        // ============================================================
        System.out.println("=== PARTE 2: VARIAS INSTANCIAS ===");

        try {
            Punto p1 = new Punto(1, -1, "p1");
            System.out.println("  p1 creado (no se imprime)");
        } catch (PuntoNoValidoException e) {
            System.out.println("  " + e.toString());
        }

        try {
            Punto p2 = new Punto(-5, -5);
            System.out.println("  p2 creado (no se imprime)");
        } catch (PuntoNoValidoException e) {
            System.out.println("  " + e.toString());
        }

        try {
            Punto p3 = new Punto(10, 20, "valido");
            System.out.println("  " + p3 + " creado correctamente");
        } catch (PuntoNoValidoException e) {
            System.out.println("  " + e.toString());
        }
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 6 - V16: EXCEPCIONES COMPLETO)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Excepcion en constructor: throws en la cabecera");
        System.out.println("  - Propagacion en cadena entre constructores");
        System.out.println("  - Orden: primero asignar, luego validar");
        System.out.println("  - Excepcion personalizada: mensaje en un solo lugar");
        System.out.println("  - Cada llamada al constructor debe ir en try-catch");
    }
}
