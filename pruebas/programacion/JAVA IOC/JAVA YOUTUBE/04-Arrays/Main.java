import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* =====================================================================
   Seccion 1: Enumerado (1 punto)

   Define un tipo enumerado llamado Rol con los valores:
   GUERRERO, MAGO, ARQUERO, SANADOR, LADRON
   ===================================================================== */

enum Rol {
    GUERRERO, MAGO, ARQUERO, SANADOR, LADRON
}

/*
 * =====================================================================
 * Seccion 2: Clase Aventurero (2 puntos)
 *
 * Atributos privados: String nombre, int nivel, Rol rol.
 * Implementa:
 * - Constructor que inicialice los tres atributos.
 * - Getter para rol y getter para nombre.
 * - toString() con formato: <nombre> (Nv. <nivel>) - <ROL>
 * =====================================================================
 */

class Aventurero {
    private String nombre;
    private int nivel;
    private Rol rol;

    public Aventurero(String nombre, int nivel, Rol rol) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (Nv. " + nivel + ") - " + rol;
    }
}

/*
 * =====================================================================
 * Seccion 3: Clase Equipo (5 puntos)
 *
 * Atributos privados:
 * - String nombre
 * - List<Aventurero> aventureros
 * - Map<Rol, Integer> maximosPorRol
 * =====================================================================
 */

class Equipo {
    private String nombre;
    private List<Aventurero> aventureros;
    private Map<Rol, Integer> maximosPorRol;

    /*
     * 3.1 Constructor (1 punto)
     * Inicializa el nombre, la lista vacia y el mapa con los limites:
     * GUERRERO=1, MAGO=1, ARQUERO=2, SANADOR=1, LADRON=1
     */
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.aventureros = new ArrayList<>();
        this.maximosPorRol = new HashMap<>();
        maximosPorRol.put(Rol.GUERRERO, 1);
        maximosPorRol.put(Rol.MAGO, 1);
        maximosPorRol.put(Rol.ARQUERO, 2);
        maximosPorRol.put(Rol.SANADOR, 1);
        maximosPorRol.put(Rol.LADRON, 1);
    }

    /*
     * 3.2 Metodo contarAventurerosPorRol (1 punto)
     * Privado. Recibe un Rol y devuelve cuantos aventureros de ese rol hay.
     */
    private int contarAventurerosPorRol(Rol r) {
        int contador = 0;
        for (Aventurero a : aventureros) {
            if (a.getRol() == r)
                contador++;
        }
        return contador;
    }

    /*
     * 3.3 Metodo agregarAventurero (1.5 puntos)
     * Anade solo si no se ha alcanzado el maximo para ese rol.
     * Si se puede: "OK: <nombre> se ha unido al equipo."
     * Si no:
     * "ERROR: No se puede anadir a <nombre>. El equipo ya tiene el maximo de <ROL>s."
     */
    public void agregarAventurero(Aventurero a) {
        int actuales = contarAventurerosPorRol(a.getRol());
        int maximo = maximosPorRol.get(a.getRol());

        if (actuales >= maximo) {
            System.out.println("ERROR: No se puede anadir a " + a.getNombre()
                    + ". El equipo ya tiene el maximo de " + a.getRol() + "s.");
        } else {
            aventureros.add(a);
            System.out.println("OK: " + a.getNombre() + " se ha unido al equipo.");
        }
    }

    /*
     * 3.4 Metodo obtenerPrioridad (0.5 puntos)
     * Privado. Devuelve int segun el orden:
     * GUERRERO=1, MAGO=2, ARQUERO=3, SANADOR=4, LADRON=5
     */
    private int obtenerPrioridad(Rol r) {
        return switch (r) {
            case GUERRERO -> 1;
            case MAGO -> 2;
            case ARQUERO -> 3;
            case SANADOR -> 4;
            case LADRON -> 5;
        };
    }

    /*
     * 3.5 Metodo listarFormacion (1 punto)
     * Ordena por prioridad con sort (lambda) y muestra con Iterator
     * en formato: " - <nombre> (Nv. <nivel>) - <ROL>"
     */
    public void listarFormacion() {
        aventureros.sort((a1, a2) -> Integer.compare(
                obtenerPrioridad(a1.getRol()),
                obtenerPrioridad(a2.getRol())));

        Iterator<Aventurero> iterator = aventureros.iterator();
        while (iterator.hasNext()) {
            System.out.println(" - " + iterator.next());
        }
    }
}

/*
 * =====================================================================
 * Seccion 4: Clase Main (2 puntos)
 *
 * Crea un equipo "Los Legendarios" y anade estos aventureros:
 *
 * Thorn 9 GUERRERO
 * Elara 10 MAGO
 * Finn 7 ARQUERO
 * Lyra 8 SANADOR
 * Shadow 6 LADRON
 * Brom 5 GUERRERO (debe dar ERROR)
 * Zara 7 MAGO (debe dar ERROR)
 * Kai 8 ARQUERO (debe entrar)
 *
 * Finalmente muestra "--- EQUIPO FINAL ---" y la formacion ordenada.
 * =====================================================================
 */

public class Main {
    public static void main(String[] args) {
        Equipo equipo = new Equipo("Los Legendarios");

        equipo.agregarAventurero(new Aventurero("Thorn", 9, Rol.GUERRERO));
        equipo.agregarAventurero(new Aventurero("Elara", 10, Rol.MAGO));
        equipo.agregarAventurero(new Aventurero("Finn", 7, Rol.ARQUERO));
        equipo.agregarAventurero(new Aventurero("Lyra", 8, Rol.SANADOR));
        equipo.agregarAventurero(new Aventurero("Shadow", 6, Rol.LADRON));
        equipo.agregarAventurero(new Aventurero("Brom", 5, Rol.GUERRERO));
        equipo.agregarAventurero(new Aventurero("Zara", 7, Rol.MAGO));
        equipo.agregarAventurero(new Aventurero("Kai", 8, Rol.ARQUERO));

        System.out.println("\n--- EQUIPO FINAL ---");
        equipo.listarFormacion();
    }
}
