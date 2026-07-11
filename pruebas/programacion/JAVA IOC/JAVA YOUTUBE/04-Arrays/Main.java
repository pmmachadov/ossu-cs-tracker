import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Banda banda = new Banda("Metal DAW");

        banda.agregarMusico(new Musico("James", 9, Instrumento.VOCALISTA));
        banda.agregarMusico(new Musico("Kirk", 8, Instrumento.GUITARRISTA));

        banda.agregarMusico(new Musico("Dave", 7, Instrumento.GUITARRISTA));
        banda.agregarMusico(new Musico("Jimi", 10, Instrumento.GUITARRISTA));

        banda.agregarMusico(new Musico("Flea", 8, Instrumento.BAJISTA));
        banda.agregarMusico(new Musico("Cliff", 9, Instrumento.BAJISTA));

        banda.agregarMusico(new Musico("Lars", 7, Instrumento.BATERIA));
        banda.agregarMusico(new Musico("Rick", 6, Instrumento.TECLISTA));

        System.out.println("\n--- FORMACIÓN DE LA BANDA ---");
        banda.listarFormacion();
    }
}

enum Instrumento {
    VOCALISTA, GUITARRISTA, BAJISTA, BATERIA, TECLISTA
}

class Musico {
    private String nombre;
    private int habilidad;
    private Instrumento instrumento;

    public Musico(String nombre, int habilidad, Instrumento instrumento) {
        this.nombre = nombre;
        this.habilidad = habilidad;
        this.instrumento = instrumento;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (Nv. " + habilidad + ") - " + instrumento;
    }
}

class Banda {
    private String nombre;
    private List<Musico> musicos;
    private Map<Instrumento, Integer> maximosPorInstrumento;

    public Banda(String nombre) {
        this.nombre = nombre;
        this.musicos = new ArrayList<>();

        this.maximosPorInstrumento = new HashMap<>();
        maximosPorInstrumento.put(Instrumento.VOCALISTA, 1);
        maximosPorInstrumento.put(Instrumento.GUITARRISTA, 2);
        maximosPorInstrumento.put(Instrumento.BAJISTA, 1);
        maximosPorInstrumento.put(Instrumento.BATERIA, 1);
        maximosPorInstrumento.put(Instrumento.TECLISTA, 1);
    }

    public void agregarMusico(Musico m) {
        int actuales = contarMusicosInstrumento(m.getInstrumento());
        int maximo = maximosPorInstrumento.get(m.getInstrumento());

        if (actuales >= maximo) {
            System.out.println("ERROR: No se puede añadir a " + m.getNombre() + ". La banda ya tiene el máximo de "
                    + m.getInstrumento() + "s.");
        } else {
            musicos.add(m);
            System.out.println("OK: " + m.getNombre() + " se ha unido a la banda.");
        }
    }

    private int contarMusicosInstrumento(Instrumento i) {
        int contador = 0;
        for (Musico m : musicos) {
            if (m.getInstrumento() == i) {
                contador++;
            }
        }
        return contador;
    }

    public void listarFormacion() {
        musicos.sort((m1, m2) -> Integer.compare(
                obtenerPrioridad(m1.getInstrumento()),
                obtenerPrioridad(m2.getInstrumento())));

        Iterator<Musico> iterator = musicos.iterator();
        while (iterator.hasNext()) {
            System.out.println(" - " + iterator.next());
        }
    }

    private int obtenerPrioridad(Instrumento i) {
        return switch (i) {
            case VOCALISTA -> 1;
            case GUITARRISTA -> 2;
            case BAJISTA -> 3;
            case BATERIA -> 4;
            case TECLISTA -> 5;
        };
    }
}

// 3.4

// Método obtenerPrioridad (0.5 puntos) Método privado que recibe un Rol y
// devuelve un int según este orden:

// GUERRERO
// MAGO
// ARQUERO
// SANADOR
// LADRÓN
// 3.5

// Método listarFormacion (1 punto) Ordena los aventureros por

// prioridad (de menor a mayor número) usando sort con una expresión lambda, y
// luego los muestra uno por uno con un Iterator en el formato: - <nombre> (Nv.
// <nivel>) - <ROL>

// Sección 4:

// Clase Main (2 puntos)

// Crea una clase con el método main que:

// Cree un equipo llamado "Los Legendarios".
// Añada los siguientes aventureros en este orden:

// Nombre Nivel Rol
// Thorn 9 GUERRERO
// Elara 10 MAGO
// Finn 7 ARQUERO
// Lyra 8 SANADOR
// Shadow 6 LADRÓN
// Brom 5 GUERRERO
// Zara 7 MAGO
// Kai 8 ARQUERO
