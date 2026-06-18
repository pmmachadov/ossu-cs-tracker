import java.util.ArrayList;

class Video_5_24_EjercicioOO_Grafico2D {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-24 JAVA: Ejercicios OO - Clase Grafico 2D DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=zdw-0PBgU-g&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=117";
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
          RESUMEN RAPIDO - EJERCICIO OO: GRAFICO 2D (TEMA 5 - V24)
        ====================================================================

        --- ENUNCIADO ---
        Clase GraficoLineas2D que representa un grafico con puntos 2D.
        - Unico atributo: ArrayList<Punto> puntos
        - Restricciones:
          1. x >= 0 e y >= 0 (coordenadas positivas)
          2. Ningun punto repetido (misma posicion)
          3. Al avanzar en la lista, x debe ser >= que la x anterior
             (el grafico avanza hacia la derecha o se mantiene)

        --- CONSTRUCTORES ---
        GraficoLineas2D() -> inicializa lista vacia
        GraficoLineas2D(ArrayList<Punto> lista) -> usa setPuntos()

        --- METODOS ---
        agregarPunto(Punto p):
          - Si lista vacia: anade el punto directamente.
          - Si no: comprueba que p sea positivo, distinto del ultimo,
            y que p.x >= ultimo.x. Si cumple, lo anade.

        eliminarPunto():
          - Si lista no vacia: elimina el ultimo (size()-1).

        setPuntos(ArrayList<Punto> lista):
          - Valida toda la lista. Si es valida, la asigna.

        --- METODO VALIDAR PUNTOS (2 versiones) ---
        Version 1 (anidada, menos legible):
          - Muchos if-else anidados.
          - Funciona pero es dificil de leer.

        Version 2 (recomendada, mas legible):
          - Si lista vacia -> true.
          - Si primer punto no es positivo -> false.
          - Bucle desde i=1 comparando actual con anterior.
          - Cada iteracion: positivo? distinto? x actual >= x anterior?

        --- CLASE PUNTO (usada en el ejercicio) ---
        Atributos: int x, int y, String nombre
        Constructor: Punto(int x, int y, String nombre)

        ====================================================================
        """;

    // ================================================================
    // CLASE PUNTO
    // ================================================================
    static class Punto {
        int x, y;
        String nombre;

        Punto(int x, int y, String nombre) {
            this.x = x;
            this.y = y;
            this.nombre = nombre;
        }

        int getX() { return x; }
        int getY() { return y; }
        String getNombre() { return nombre; }

        public String toString() {
            return nombre;
        }
    }

    // ================================================================
    // CLASE GRAFICO LINEAS 2D
    // ================================================================
    static class GraficoLineas2D {
        private ArrayList<Punto> puntos;

        // Constructor vacio
        GraficoLineas2D() {
            this.puntos = new ArrayList<>();
        }

        // Constructor con lista (reutiliza setter)
        GraficoLineas2D(ArrayList<Punto> lista) {
            this();                    // Inicializa lista vacia
            setPuntos(lista);          // Si no es valida, se queda vacia
        }

        // ---- METODOS AUXILIARES ----

        // Comprueba si un punto tiene coordenadas positivas
        private boolean esPositivo(Punto p) {
            return p.getX() >= 0 && p.getY() >= 0;
        }

        // ---- AGREGAR PUNTO ----
        void agregarPunto(Punto p) {
            // Si la lista esta vacia, se anade directamente
            if (puntos.isEmpty()) {
                puntos.add(p);
                System.out.println("  Primer punto agregado correctamente");
                return;
            }

            // Si no esta vacia, comprobar con el ultimo punto
            Punto ultimo = puntos.get(puntos.size() - 1);

            if (esPositivo(p)
                && (p.getX() != ultimo.getX() || p.getY() != ultimo.getY())
                && p.getX() >= ultimo.getX()) {

                puntos.add(p);
                System.out.println("  Punto " + p + " agregado correctamente");
            } else {
                System.out.println("  ERROR: No se ha podido agregar el punto " + p);
            }
        }

        // ---- ELIMINAR ULTIMO PUNTO ----
        void eliminarPunto() {
            if (!puntos.isEmpty()) {
                Punto eliminado = puntos.remove(puntos.size() - 1);
                System.out.println("  Punto " + eliminado + " eliminado correctamente");
            } else {
                System.out.println("  ERROR: No se ha podido eliminar, la lista esta vacia");
            }
        }

        // ---- SETTER CON VALIDACION ----
        void setPuntos(ArrayList<Punto> nuevosPuntos) {
            if (validarPuntos(nuevosPuntos)) {
                this.puntos = new ArrayList<>(nuevosPuntos);
                System.out.println("  Lista de puntos modificada correctamente");
            } else {
                System.out.println("  ERROR: No se ha podido modificar la lista de puntos");
            }
        }

        // ---- VALIDAR PUNTOS (Version 2 - recomendada) ----
        private boolean validarPuntos(ArrayList<Punto> lista) {
            // Si esta vacia, es valida
            if (lista.isEmpty()) {
                return true;
            }

            // El primer punto debe ser positivo
            if (!esPositivo(lista.get(0))) {
                return false;
            }

            // A partir del segundo punto, comprobar con el anterior
            for (int i = 1; i < lista.size(); i++) {
                Punto actual = lista.get(i);
                Punto anterior = lista.get(i - 1);

                if (!esPositivo(actual)
                    || (actual.getX() == anterior.getX() && actual.getY() == anterior.getY())
                    || actual.getX() < anterior.getX()) {
                    return false;
                }
            }

            return true;
        }

        // ---- MOSTRAR GRAFICO ----
        void mostrarGrafico() {
            System.out.println("  Grafico (puntos):");
            for (Punto p : puntos) {
                System.out.println("    " + p);
            }
        }

        int size() { return puntos.size(); }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 5 - V24: EJERCICIO OO - GRAFICO 2D");
        System.out.println();

        // ============================================================
        // PARTE 1: Agregar puntos validos
        // ============================================================
        separador("PARTE 1: Agregar puntos validos");

        GraficoLineas2D grafico = new GraficoLineas2D();
        Punto p1 = new Punto(1, 1, "p1");
        Punto p2 = new Punto(2, 2, "p2");
        Punto p3 = new Punto(3, 3, "p3");
        Punto p4 = new Punto(4, 4, "p4");
        Punto p5 = new Punto(5, 5, "p5");

        grafico.agregarPunto(p1);
        grafico.agregarPunto(p2);
        grafico.agregarPunto(p3);
        grafico.agregarPunto(p4);
        grafico.agregarPunto(p5);
        System.out.println();
        grafico.mostrarGrafico();
        System.out.println();

        // ============================================================
        // PARTE 2: Agregar punto invalido (x menor que el ultimo)
        // ============================================================
        separador("PARTE 2: Agregar punto invalido (x menor)");

        // Intentar agregar p2 (x=2) despues de p5 (x=5)
        grafico.agregarPunto(p2);
        System.out.println();

        // ============================================================
        // PARTE 3: Eliminar el ultimo punto
        // ============================================================
        separador("PARTE 3: Eliminar ultimo punto");

        grafico.eliminarPunto();
        System.out.println("  Ahora podemos agregar p2 (x=2 >= ultimo.x=4):");
        grafico.agregarPunto(p2);
        System.out.println();
        grafico.mostrarGrafico();
        System.out.println();

        // ============================================================
        // PARTE 4: Constructor con lista invalida
        // ============================================================
        separador("PARTE 4: Constructor con lista invalida");

        ArrayList<Punto> listaInvalida = new ArrayList<>();
        listaInvalida.add(p1);  // (1,1)
        listaInvalida.add(p3);  // (3,3)
        listaInvalida.add(p2);  // (2,2) -> x menor que el anterior (3>2? NO)

        GraficoLineas2D grafico2 = new GraficoLineas2D(listaInvalida);
        System.out.println("  Grafico2 tiene " + grafico2.size()
            + " puntos (lista invalida, se quedo vacio)");
        grafico2.mostrarGrafico();
        System.out.println();

        // ============================================================
        // PARTE 5: Constructor con lista valida
        // ============================================================
        separador("PARTE 5: Constructor con lista valida");

        ArrayList<Punto> listaValida = new ArrayList<>();
        listaValida.add(new Punto(0, 0, "a"));
        listaValida.add(new Punto(1, 2, "b"));
        listaValida.add(new Punto(3, 1, "c"));

        GraficoLineas2D grafico3 = new GraficoLineas2D(listaValida);
        grafico3.mostrarGrafico();
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V24: EJERCICIO OO GRAFICO 2D)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS PRACTICADOS:");
        System.out.println("  - ArrayList de objetos con restricciones");
        System.out.println("  - Validacion de coordenadas (x>=0, y>=0)");
        System.out.println("  - Validacion de orden (x no decreciente)");
        System.out.println("  - Validacion de unicidad (sin puntos repetidos)");
        System.out.println("  - Dos formas de validar (anidada vs lineal)");
        System.out.println("  - this() para llamar al constructor vacio");
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
