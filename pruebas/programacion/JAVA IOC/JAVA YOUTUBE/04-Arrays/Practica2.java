/*
 * Práctica 1: Biblioteca digital
 *
 * Clases diseñadas para gestionar una biblioteca con libros.
 * Se incluye la clase Libro y la clase Biblioteca.
 */

import java.util.ArrayList;

/**
 * Clase que representa un libro con sus atributos y operaciones básicas.
 */
class Libro {
    // Atributos privados según especificación
    private String titulo; // Título del libro
    private String autor; // Autor del libro
    private int anyoPublicacion; // Año de publicación
    private boolean prestado; // Estado de préstamo (true = prestado, false = disponible)

    /**
     * Constructor con todos los parámetros.
     * Inicializa el libro con el título, autor y año dados.
     * Por defecto, el libro se crea como no prestado.
     *
     * @param titulo Título del libro
     * @param autor  Autor del libro
     * @param anyo   Año de publicación
     */
    public Libro(String titulo, String autor, int anyo) {
        this.titulo = titulo;
        this.autor = autor;
        this.anyoPublicacion = anyo;
        this.prestado = false; // Inicialmente disponible
    }

    // Getters y setters según se requieren

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

    /**
     * Método prestar(): marca el libro como prestado si no lo está.
     * Si ya está prestado, no hace nada (no se cambia el estado).
     */
    public void prestar() {
        if (!prestado) {
            prestado = true;
        }
    }

    /**
     * Método devolver(): marca el libro como disponible (no prestado).
     */
    public void devolver() {
        prestado = false;
    }

    /**
     * Representación textual del libro.
     * Muestra el título, autor, año y estado (PRESTADO o DISPONIBLE).
     *
     * @return Cadena con la información del libro
     */
    @Override
    public String toString() {
        return titulo + " (" + autor + ", " + anyoPublicacion + ") "
                + (prestado ? "[PRESTADO]" : "[DISPONIBLE]");
    }
}

/**
 * Clase que gestiona una colección de libros.
 * Permite agregar, listar disponibles y buscar por autor.
 */
class Biblioteca {
    // Atributo: lista de libros
    private ArrayList<Libro> libros = new ArrayList<>();

    /**
     * Agrega un libro a la biblioteca.
     *
     * @param l Libro a agregar
     */
    public void agregarLibro(Libro l) {
        libros.add(l);
    }

    /**
     * Lista por consola todos los libros que no están prestados.
     * Utiliza el toString() de cada libro para mostrar su información.
     */
    public void listarDisponibles() {
        for (Libro l : libros) {
            if (!l.isPrestado()) {
                System.out.println(l);
            }
        }
    }

    /**
     * Busca libros cuyo autor coincida (sin distinción de mayúsculas/minúsculas).
     *
     * @param autor Nombre del autor a buscar
     * @return ArrayList con los libros encontrados (puede estar vacío)
     */
    public ArrayList<Libro> buscarPorAutor(String autor) {
        ArrayList<Libro> res = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getAutor().equalsIgnoreCase(autor)) {
                res.add(l);
            }
        }
        return res;
    }
}

// Nota: Para probar las clases se puede crear una clase main en Practica1
// (descomentar el bloque inferior) o ejecutar pruebas unitarias.
/*
 * public class Practica1 {
 * public static void main(String[] args) {
 * // Ejemplo de uso
 * Biblioteca biblio = new Biblioteca();
 * Libro l1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967);
 * Libro l2 = new Libro("El Quijote", "Miguel de Cervantes", 1605);
 * biblio.agregarLibro(l1);
 * biblio.agregarLibro(l2);
 * l1.prestar(); // Prestamos el primer libro
 * System.out.println("Libros disponibles:");
 * biblio.listarDisponibles(); // Solo mostrará El Quijote
 * System.out.println("Búsqueda por autor 'garcía márquez':");
 * for (Libro l : biblio.buscarPorAutor("Gabriel García Márquez")) {
 * System.out.println(l);
 * }
 * }
 * }
 */
