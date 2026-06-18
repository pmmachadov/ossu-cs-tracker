import java.util.ArrayList;

class Video_5_18_ArrayList {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-18 JAVA: ArrayList DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=7IPH-Tbtb74&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=111";
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
          RESUMEN RAPIDO - ARRAYLIST (TEMA 5 - V18)
        ====================================================================

        --- QUE ES UN ARRAYLIST ---
        Coleccion DINAMICA de objetos. A diferencia de los arrays:
        - NO necesita un tamano fijo al crearlo.
        - Se puede ANADIR y ELIMINAR elementos en tiempo de ejecucion.
        - El tamano se ajusta automaticamente.

        --- IMPORTACION ---
        import java.util.ArrayList;

        --- DECLARACION ---
        ArrayList<String> lista = new ArrayList<>();
        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<Punto> puntos = new ArrayList<>();

        Usar CLASES ENVOLTORIO para tipos primitivos:
        - int -> Integer
        - double -> Double
        - boolean -> Boolean
        - char -> Character

        --- METODOS PRINCIPALES ---

        add(elemento)           -> Anade al final
        add(indice, elemento)    -> Inserta en posicion (desplaza)
        get(indice)             -> Obtiene elemento
        set(indice, elemento)   -> Sustituye elemento
        remove(indice)          -> Elimina por posicion
        remove(objeto)          -> Elimina por objeto (primera aparicion)
        size()                  -> Numero de elementos
        indexOf(objeto)         -> Posicion del objeto (-1 si no)
        lastIndexOf(objeto)     -> Posicion de la ultima aparicion
        contains(objeto)        -> true/false si existe
        isEmpty()               -> true si esta vacia
        clear()                 -> Elimina todo
        toArray()               -> Convierte a array
        clone()                 -> Clona la lista

        --- RECORRER UN ARRAYLIST ---
        // Con for tipico
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }

        // Con for-each
        for (String s : lista) {
            System.out.println(s);
        }

        // Con toString (imprime toda la lista)
        System.out.println(lista);  // [elem1, elem2, elem3]

        --- EJEMPLO CON OBJETOS PROPIOS ---
        ArrayList<Punto> puntos = new ArrayList<>();
        puntos.add(new Punto(1, 2));
        puntos.add(new Punto(1, 1));
        puntos.add(new Punto(1, 3));

        Punto p = puntos.get(2);  // Tercer punto
        p.mostrarDatos();

        --- DIFERENCIA CON ARRAYS ---
        Array:  int[] arr = new int[5];  arr.length (atributo)
        ArrayList: ArrayList<Integer> list = new ArrayList<>();  list.size() (metodo)

        ====================================================================
        """;

    // ================================================================
    // CLASE PUNTO (para ejemplos con ArrayList)
    // ================================================================
    static class Punto {
        int x, y;

        Punto(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() { return x; }
        int getY() { return y; }

        void mostrarDatos() {
            System.out.println("  Punto: x=" + x + ", y=" + y);
        }

        public String toString() {
            return "P(" + x + "," + y + ")";
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
        System.out.println("TEMA 5 - V18: ARRAYLIST");
        System.out.println();

        // ============================================================
        // PARTE 1: ArrayList de Strings
        // ============================================================
        separador("PARTE 1: ArrayList de Strings (lista de paises)");

        ArrayList<String> listaPaises = new ArrayList<>();

        // Anadir elementos
        listaPaises.add("Espana");
        listaPaises.add("Francia");
        listaPaises.add("Portugal");
        System.out.println("  Despues de 3 adds: " + listaPaises);

        // Insertar en una posicion
        listaPaises.add(1, "Italia");
        System.out.println("  Despues de add(1, \"Italia\"): " + listaPaises);
        System.out.println();

        // Obtener elemento
        String pais = listaPaises.get(3);
        System.out.println("  listaPaises.get(3) = " + pais);
        System.out.println();

        // Eliminar por indice
        listaPaises.remove(2);  // Elimina "Francia"
        System.out.println("  Despues de remove(2): " + listaPaises);

        // Eliminar por objeto
        listaPaises.remove("Portugal");
        System.out.println("  Despues de remove(\"Portugal\"): " + listaPaises);
        System.out.println();

        // Modificar elemento
        listaPaises.set(1, "Alemania");
        System.out.println("  Despues de set(1, \"Alemania\"): " + listaPaises);
        System.out.println();

        // ============================================================
        // PARTE 2: ArrayList de objetos Punto
        // ============================================================
        separador("PARTE 2: ArrayList de objetos Punto");

        ArrayList<Punto> puntos = new ArrayList<>();
        Punto p1 = new Punto(1, 2);
        Punto p2 = new Punto(1, 1);
        Punto p3 = new Punto(1, 3);
        Punto p4 = new Punto(3, 3);

        puntos.add(p1);
        puntos.add(p2);
        puntos.add(p3);
        System.out.println("  Lista inicial: " + puntos);

        puntos.add(1, p4);  // Insertar p4 en posicion 1
        System.out.println("  Despues de add(1, p4): " + puntos);

        puntos.remove(2);    // Elimina el tercero (p2)
        System.out.println("  Despues de remove(2): " + puntos);

        puntos.remove(p1);   // Elimina p1 por objeto
        System.out.println("  Despues de remove(p1): " + puntos);
        System.out.println();

        // Acceder a un elemento y llamar a sus metodos
        System.out.print("  puntos.get(1): ");
        puntos.get(1).mostrarDatos();
        System.out.println();

        // ============================================================
        // PARTE 3: Recorrer ArrayList
        // ============================================================
        separador("PARTE 3: Recorrer ArrayList");

        ArrayList<String> frutas = new ArrayList<>();
        frutas.add("Manzana");
        frutas.add("Pera");
        frutas.add("Naranja");
        frutas.add("Platano");

        System.out.println("  Con for tipico (size() + get()):");
        for (int i = 0; i < frutas.size(); i++) {
            System.out.println("    frutas[" + i + "] = " + frutas.get(i));
        }
        System.out.println();

        System.out.println("  Con for-each:");
        for (String f : frutas) {
            System.out.println("    " + f);
        }
        System.out.println();

        System.out.println("  Con toString():");
        System.out.println("    " + frutas.toString());
        System.out.println();

        // ============================================================
        // PARTE 4: Metodos adicionales
        // ============================================================
        separador("PARTE 4: Metodos utiles");

        System.out.println("  contains(\"Pera\"): " + frutas.contains("Pera"));
        System.out.println("  contains(\"Sandia\"): " + frutas.contains("Sandia"));
        System.out.println("  indexOf(\"Naranja\"): " + frutas.indexOf("Naranja"));
        System.out.println("  indexOf(\"Sandia\"): " + frutas.indexOf("Sandia"));
        System.out.println("  isEmpty(): " + frutas.isEmpty());
        System.out.println("  size(): " + frutas.size());
        System.out.println();

        // clear
        frutas.clear();
        System.out.println("  Despues de clear():");
        System.out.println("  isEmpty(): " + frutas.isEmpty());
        System.out.println("  size(): " + frutas.size());
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V18: ARRAYLIST)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  METODOS DE ARRAYLIST:");
        System.out.println("  add(e)         add(i, e)    get(i)");
        System.out.println("  set(i, e)      remove(i)    remove(e)");
        System.out.println("  size()         indexOf(e)   contains(e)");
        System.out.println("  isEmpty()      clear()      toString()");
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
