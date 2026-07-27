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
