import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Ejercicio: Equipo de Aventureros
 * 
 * Estructura idéntica al de la Banda de música, pero con temática RPG.
 * 
 * COMPLETA los métodos marcados con TODO y haz que funcione.
 * 
 * Compilar: javac MainAventureros.java && java MainAventureros
 */
public class MainAventureros {
    public static void main(String[] args) {
        Equipo equipo = new Equipo("Los Legendarios");

        equipo.agregarAventurero(new Aventurero("Thorn", 9, Rol.GUERRERO));
        equipo.agregarAventurero(new Aventurero("Elara", 10, Rol.MAGO));
        equipo.agregarAventurero(new Aventurero("Finn", 7, Rol.ARQUERO));
        equipo.agregarAventurero(new Aventurero("Lyra", 8, Rol.SANADOR));
        equipo.agregarAventurero(new Aventurero("Shadow", 6, Rol.LADRON));

        // Casos de prueba (deberían saltar errores)
        equipo.agregarAventurero(new Aventurero("Brom", 5, Rol.GUERRERO));   // Ya hay 1
        equipo.agregarAventurero(new Aventurero("Zara", 7, Rol.MAGO));       // Ya hay 1
        equipo.agregarAventurero(new Aventurero("Kai", 8, Rol.ARQUERO));     // OK, máximo 2

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

class Equipo {
    private String nombre;
    private List<Aventurero> aventureros;
    private Map<Rol, Integer> maximosPorRol;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.aventureros = new ArrayList<>();

        this.maximosPorRol = new HashMap<>();
        // TODO: Inicializa los límites aquí
        // GUERRERO -> 1, MAGO -> 1, ARQUERO -> 2, SANADOR -> 1, LADRON -> 1
    }

    public void agregarAventurero(Aventurero a) {
        // TODO: Implementa este método siguiendo el patrón de la Banda
        // 1. Contar cuántos aventureros del mismo rol hay ya
        // 2. Comparar con el máximo permitido
        // 3. Si ya está lleno -> mensaje de error
        // 4. Si no -> añadir a la lista y mensaje OK
    }

    private int contarAventurerosPorRol(Rol r) {
        // TODO: Cuenta cuántos aventureros tienen este rol
        return 0;
    }

    public void listarFormacion() {
        // TODO: Ordena por prioridad (GUERRERO 1º, MAGO 2º, ...)
        // y muestra cada aventurero con un iterador
    }

    private int obtenerPrioridad(Rol r) {
        // TODO: Devuelve la prioridad según el rol
        // GUERRERO=1, MAGO=2, ARQUERO=3, SANADOR=4, LADRON=5
        return 0;
    }
}
