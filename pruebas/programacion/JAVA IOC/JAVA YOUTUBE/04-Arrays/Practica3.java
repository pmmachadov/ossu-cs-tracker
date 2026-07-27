import java.util.ArrayList;

class Libro {
    private String titulo, autor;
    private int anyoPublicacion;
    private boolean prestado;

    public Libro(String titulo, String autor, int anyo) {
        this.titulo = titulo;
        this.autor = autor;
        this.anyoPublicacion = anyo;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnyo() {
        return anyoPublicacion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setTitulo(String t) {
        titulo = t;
    }

    public void setAutor(String a) {
        autor = a;
    }

    public void prestar() {
        if (!prestado)
            prestado = true;
    }

    public void devolver() {
        prestado = false;
    }

    public String toString() {
        return titulo + " (" + autor + ", " + anyoPublicacion + ") "
                + (prestado ? "[PRESTADO]" : "[DISPONIBLE]");
    }
}

class Biblioteca {
    private ArrayList<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro l) {
        libros.add(l);
    }

    public void listarDisponibles() {
        for (Libro l : libros)
            if (!l.isPrestado())
                System.out.println(l);
    }

    public ArrayList<Libro> buscarPorAutor(String autor) {
        ArrayList<Libro> res = new ArrayList<>();
        for (Libro l : libros)
            if (l.getAutor().equalsIgnoreCase(autor))
                res.add(l);
        return res;
    }
}

// 3.2

// Diseña las clases para gestionar una Biblioteca digital:

// Clase Libro: atributos privados titulo (String), autor (String),

// anyoPublicacion (int),
// prestado (boolean).
// Constructor con todos los parámetros.
// Métodos getters y setters.
// Método prestar() que marque como prestado si no lo está.
// Método devolver() que marque como disponible.
// Método toString() que muestre la información del libro.

// Clase Biblioteca:
// atributo libros (ArrayList<Libro>).
// Método agregarLibro(Libro l).
// Método listarDisponibles() que muestre solo los libros no prestados.
// Método
// buscarPorAutor(String autor) que devuelva los libros de ese autor.
