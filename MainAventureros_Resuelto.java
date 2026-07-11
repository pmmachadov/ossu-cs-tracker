/**
 * MainAventureros.java - EJERCICIO RESUELTO
 * 
 * Úsalo para comparar después de intentarlo tú.
 * ¡No hagas trampa! Primero inténtalo, luego mira esto.
 */
public class MainAventureros {
    public static void main(String[] args) {
        Equipo equipo = new Equipo("Los Legendarios");

        equipo.agregarAventurero(new Aventurero("Thorn", 9, Rol.GUERRERO));
        equipo.agregarAventurero(new Aventurero("Elara", 10, Rol.MAGO));
        equipo.agregarAventurero(new Aventurero("Finn", 7, Rol.ARQUERO));
        equipo.agregarAventurero(new Aventurero("Lyra", 8, Rol.SANADOR));
        equipo.agregarAventurero(new Aventurero("Shadow", 6, Rol.LADRON));

        equipo.agregarAventurero(new Aventurero("Brom", 5, Rol.GUERRERO));   // ERROR
        equipo.agregarAventurero(new Aventurero("Zara", 7, Rol.MAGO));       // ERROR
        equipo.agregarAventurero(new Aventurero("Kai", 8, Rol.ARQUERO));     // OK

        System.out.println("\n--- EQUIPO FINAL ---");
        equipo.listarFormacion();
    }
}

enum Rol {
    GUERRERO, MAGO, ARQUERO, SANADOR, LADRON
}

class Aventurero {
    private String nombre;
    private int nivel;
    private Rol rol;

    public Aventurero(String nombre, int nivel, Rol rol) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.rol = rol;
    }

    public Rol getRol() { return rol; }

    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return nombre + " (Nv. " + nivel + ") - " + rol;
    }
}

class Equipo {
    private String nombre;
    private List<Aventurero> aventureros;
    private Map<Rol, Integer> maximosPorRol;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.aventureros = new ArrayList<>();

        // 1. INICIALIZAR LÍMITES
        this.maximosPorRol = new HashMap<>();
        maximosPorRol.put(Rol.GUERRERO, 1);
        maximosPorRol.put(Rol.MAGO, 1);
        maximosPorRol.put(Rol.ARQUERO, 2);
        maximosPorRol.put(Rol.SANADOR, 1);
        maximosPorRol.put(Rol.LADRON, 1);
    }

    // 2. AÑADIR CON VALIDACIÓN
    public void agregarAventurero(Aventurero a) {
        int actuales = contarAventurerosPorRol(a.getRol());
        int maximo = maximosPorRol.get(a.getRol());

        if (actuales >= maximo) {
            System.out.println("ERROR: No se puede añadir a " + a.getNombre()
                    + ". El equipo ya tiene el máximo de " + a.getRol() + "s.");
        } else {
            aventureros.add(a);
            System.out.println("OK: " + a.getNombre() + " se ha unido al equipo.");
        }
    }

    // 3. CONTAR POR ROL
    private int contarAventurerosPorRol(Rol r) {
        int contador = 0;
        for (Aventurero a : aventureros) {
            if (a.getRol() == r) {
                contador++;
            }
        }
        return contador;
    }

    // 4. MOSTRAR ORDENADO
    public void listarFormacion() {
        aventureros.sort((a1, a2) -> Integer.compare(
                obtenerPrioridad(a1.getRol()),
                obtenerPrioridad(a2.getRol())));

        Iterator<Aventurero> iterator = aventureros.iterator();
        while (iterator.hasNext()) {
            System.out.println(" - " + iterator.next());
        }
    }

    // 5. PRIORIDAD CON SWITCH
    private int obtenerPrioridad(Rol r) {
        return switch (r) {
            case GUERRERO -> 1;
            case MAGO -> 2;
            case ARQUERO -> 3;
            case SANADOR -> 4;
            case LADRON -> 5;
        };
    }
}
