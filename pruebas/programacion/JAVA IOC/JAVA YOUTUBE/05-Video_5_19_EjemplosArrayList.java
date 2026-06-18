import java.util.ArrayList;

class Video_5_19_EjemplosArrayList {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-19 JAVA: Ejemplos ArrayList DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=N--60I7OyIs&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=112";
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
          RESUMEN RAPIDO - EJEMPLOS ARRAYLIST (TEMA 5 - V19)
        ====================================================================

        --- REPASO: Metodos de ArrayList ---
        add(objeto)         -> Anade al final
        add(indice, objeto) -> Inserta en posicion (desplaza)
        remove(indice)      -> Elimina por posicion
        remove(objeto)      -> Elimina por instancia (misma referencia)
        get(indice)         -> Obtiene elemento
        size()              -> Cantidad de elementos

        --- toString() en ArrayList ---
        - ArrayList.toString() llama a toString() de CADA elemento.
        - Si sobreescribimos toString() en nuestra clase,
          se usara automaticamente al imprimir la lista.
        - Salida tipica: [ elem1, elem2, elem3 ]

        --- BORRAR POR CONTENIDO (no por referencia) ---
        - remove(objeto) usa el metodo equals() del objeto.
        - Si NO sobreescribimos equals(), compara REFERENCIAS.
        - new Punto(1,2) NO es la misma referencia que otro new Punto(1,2).
        - Para borrar por contenido, crear metodo propio:

        static void borrarPunto(ArrayList<Punto> lista, int x, int y, String nom) {
            for (Punto p : lista) {
                if (p.getX() == x && p.getY() == y
                    && p.getNombre().equals(nom)) {
                    lista.remove(p);
                    return;  // Importante: salir para evitar ConcurrentModification
                }
            }
        }

        --- CUIDADO: for-each + remove ---
        - No se puede modificar una lista mientras se recorre con for-each.
        - Si se encuentra el elemento, hacer remove() y SALIR (return).
        - Si no se sale, dara ConcurrentModificationException.

        --- TIP: LLaves en if ---
        - Si un if tiene varias instrucciones, usar SIEMPRE llaves {}.
        - Si no, solo la primera linea pertenece al if.

        --- RESPUESTA A LA PREGUNTA DEL VIDEO ---
        ?Por que no borraba aunque creabamos un new Punto con los mismos datos?
        Porque el metodo remove(objeto) de ArrayList usa equals(),
        y si no hemos sobreescrito equals() en Punto, usa el de Object,
        que compara REFERENCIAS. Dos objetos con los mismos datos
        pero creados con new son instancias DISTINTAS.

        Solucion temporal del video: crear metodo borrarPunto() que
        compara los atributos manualmente.

        ====================================================================
        """;

    // ================================================================
    // CLASE PUNTO (con atributo nombre y toString)
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

    // -------------------------------------------------------------
    // METODO AUXILIAR: borrar punto por contenido (no por referencia)
    // -------------------------------------------------------------
    static void borrarPunto(ArrayList<Punto> lista, Punto punto) {
        for (Punto p : lista) {
            if (p.getX() == punto.getX()
                && p.getY() == punto.getY()
                && p.getNombre().equals(punto.getNombre())) {

                lista.remove(p);
                return;  // Importante: salir del metodo tras borrar
            }
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
        System.out.println("TEMA 5 - V19: EJEMPLOS ARRAYLIST");
        System.out.println();

        // ============================================================
        // PARTE 1: Secuencia completa del video
        // ============================================================
        separador("PARTE 1: Add, insert, remove con objetos");

        ArrayList<Punto> puntos = new ArrayList<>();
        Punto p1 = new Punto(1, 2, "p1");
        Punto p2 = new Punto(5, 5, "p2");
        Punto p3 = new Punto(1, 3, "p3");
        Punto p4 = new Punto(3, 3, "p4");

        puntos.add(p1);
        puntos.add(p2);
        puntos.add(p3);
        System.out.println("  Despues de add(p1, p2, p3): " + puntos);

        puntos.add(0, p4);  // Inserta p4 al principio
        System.out.println("  Despues de add(0, p4):    " + puntos);

        puntos.remove(2);    // Elimina el tercero (p2)
        System.out.println("  Despues de remove(2):     " + puntos);

        puntos.remove(p1);   // Elimina p1 por referencia
        System.out.println("  Despues de remove(p1):    " + puntos);
        System.out.println("  Resultado final: " + puntos);
        System.out.println();

        // ============================================================
        // PARTE 2: remove con new Punto (NO funciona si es distinta instancia)
        // ============================================================
        separador("PARTE 2: remove(new Punto()) NO borra (distinta referencia)");

        ArrayList<Punto> lista = new ArrayList<>();
        lista.add(new Punto(1, 2, "p1"));
        lista.add(new Punto(5, 5, "p2"));
        lista.add(new Punto(1, 3, "p3"));

        System.out.println("  Lista inicial: " + lista);

        // Intentar borrar con un new Punto (misma info, distinta instancia)
        boolean borrado = lista.remove(new Punto(1, 2, "p1"));
        System.out.println("  remove(new Punto(1,2,\"p1\")): " + borrado
            + " (NO lo borra, son instancias distintas)");
        System.out.println("  Lista despues: " + lista);
        System.out.println();

        // ============================================================
        // PARTE 3: borrarPunto() por contenido (funciona)
        // ============================================================
        separador("PARTE 3: borrarPunto() por contenido (funciona)");

        System.out.println("  Lista antes: " + lista);
        borrarPunto(lista, new Punto(1, 2, "p1"));
        System.out.println("  Despues de borrarPunto(lista, new Punto(1,2,\"p1\")): " + lista);
        System.out.println("  (AHORA si lo borra, porque compara atributos manualmente)");
        System.out.println();

        // ============================================================
        // PARTE 4: for-each con remove - IMPORTANTE: salir con return
        // ============================================================
        separador("PARTE 4: for-each + remove (con return)");

        ArrayList<Punto> lista2 = new ArrayList<>();
        lista2.add(new Punto(1, 2, "a"));
        lista2.add(new Punto(3, 4, "b"));
        lista2.add(new Punto(5, 6, "c"));

        System.out.println("  Lista inicial: " + lista2);
        borrarPunto(lista2, new Punto(3, 4, "b"));
        System.out.println("  Despues de borrar punto (3,4,\"b\"): " + lista2);
        System.out.println("  (Sin el return, daria ConcurrentModificationException)");
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V19: EJEMPLOS ARRAYLIST)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - toString() del ArrayList usa toString() de cada elemento");
        System.out.println("  - remove(objeto) compara REFERENCIAS, no contenido");
        System.out.println("  - Para borrar por contenido: crear metodo propio");
        System.out.println("  - En for-each + remove: hacer return tras borrar");
        System.out.println("  - (El tema 6 explica equals() y hashCode() correctamente)");
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
