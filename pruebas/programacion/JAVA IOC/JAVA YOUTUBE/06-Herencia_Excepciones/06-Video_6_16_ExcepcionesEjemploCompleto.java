import java.util.InputMismatchException;
import java.util.Scanner;

class Video_6_16_ExcepcionesEjemploCompleto {

    public static final String TITULO = "6-16 JAVA: Excepciones - Ejemplo completo DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=KDxzgJ-HRQY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=137";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 6-16 - EXCEPCIONES: EJEMPLO COMPLETO
        ================================================================

        Video:        6-16 JAVA: Excepciones - Ejemplo completo
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 6

        --- RESUMEN (transcripcion) ---

        Dos enfoques para validar coordenadas de un Punto usando
        excepciones personalizadas.

        --- ENFOQUE 1: METODO SEPARADO ---

        Metodo nuevoPunto() que pide x e y por teclado y propaga
        excepcion si las coordenadas son negativas.

        --- ENFOQUE 2: EXCEPCION DESDE EL CONSTRUCTOR ---

        El constructor de Punto(int x, int y) valida y lanza
        PuntoNoValidoException. Cualquier creacion debe estar
        dentro de un try-catch.

        --- ORDEN CORRECTO EN EL CONSTRUCTOR ---

        1. Asignar this.x = x; this.y = y;  (PRIMERO)
        2. Comprobar if (x < 0 || y < 0)    (DESPUES)
        Si se invierte, los valores seran 0 por defecto.

        --- PROPAGACION EN CADENA ---

        Punto(int x, int y, String nombre) { this(x, y); ... }
        Si this(x,y) lanza, el constructor de 3 parametros propaga.
        throws PuntoNoValidoException en ambos constructores.

        --- VENTAJA ---

        El mensaje de error se define en UN SOLO LUGAR (toString de la
        excepcion). Si se cambia el formato, se cambia en un unico sitio.

        --- CONCEPTOS CLAVE ---

        - Excepcion en constructor: throws en la cabecera
        - Propagacion en cadena entre constructores (this -> this)
        - Orden: primero asignar atributos, luego validar
        - Excepcion personalizada: mensaje en un solo lugar
        - Cada llamada al constructor en su propio try-catch
        ================================================================
        """;

    // ================================================================
    // CLASE PUNTO
    // ================================================================
    static class Punto {
        private int x, y;
        private String nombre;

        Punto(int x, int y) throws PuntoNoValidoException {
            this.x = x;
            this.y = y;
            validar();
        }

        Punto(int x, int y, String nombre) throws PuntoNoValidoException {
            this(x, y);
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
            this.punto = ponto;
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
        System.out.println(CONTENIDO);
        System.out.println();

        System.out.println("=== PARTE 1: CONSTRUCTOR CON EXCEPCION ===");
        try {
            Punto p1 = new Punto(3, 5);
            System.out.println("  Punto creado: " + p1);
            Punto p2 = new Punto(-1, 1, "invalido");
            System.out.println("  Esto no se imprime");
        } catch (PuntoNoValidoException e) {
            System.out.println("  " + e.toString());
        }
        System.out.println("  (El programa continua)");
        System.out.println();

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
