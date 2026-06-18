import java.util.*;

class Video_7_30_EjerciciosColecciones {

    public static final String TITULO = "7-30 JAVA: Ejercicios Colecciones ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=PwnUcPdz9bU&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=171";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        VIDEO 7-30 - EJERCICIOS COLECCIONES (TEMA 7)

        PRACTICA 1: SISTEMA DE GESTION DE EQUIPO DE FUTBOL

        Clases: Futbolista, Deportista (interfaz), Equipo, Posicion (enum)

        --- INTERFAZ Deportista ---
        int getAnosProfesional()
        List<String> getListadoEquipos()
        int getTotalTrofeos()

        --- ENUM Posicion ---
        PORTERO(nombre, salMin, salMax)
        DEFENSA(nombre, salMin, salMax)
        CENTROCAMPISTA(nombre, salMin, salMax)
        DELANTERO(nombre, salMin, salMax)
        Cada posicion tiene salario minimo y maximo asociado.

        --- CLASE Futbolista implements Deportista ---
        Atributos: nombre, edad, posicion, anosProfesional, equipos, trofeos
        Metodos: agregarEquipo(String), toString()
        Maximos por equipo: 2 porteros, 5 defensas, 5 centrocampistas, 4 delanteros

        --- CLASE Equipo ---
        Atributos: nombre, List<Futbolista> futbolistas
        Map estatico MAX_FUTBOLISTAS_POSICION con maximos por posicion
        agregarFutbolista(Futbolista f) -> lanza RegistroFutbolistaException si posicion llena
        listarFormacionEquipo() -> ordena por posicion y usa Iterator

        --- EXCEPCION RegistroFutbolistaException ---
        Mensaje: "No se puede anadir el futbolista X a la posicion Y: maximo alcanzado"

        PRACTICA 2: SISTEMA DE ANALISIS DE TEXTOS

        --- CLASE AnalizadorTextos ---
        Atributos: String texto, HashMap<String, Integer> palabras
        Constructor recibe texto, pasa a minusculas, inicializa mapa, llama a contarPalabras()
        contarPalabras(): split("\\\\W+"), for each con put(key, getOrDefault(key,0)+1)
        palabrasMasFrecuentes(int n): ordena por valor descendente, devuelve sublist
        palabrasMenosFrecuentes(int n): ordena por valor ascendente, devuelve sublist
        palabrasPorLongitud(): HashMap<Integer, List<String>> agrupado por length
        ================================================================
        """;

    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println("=== PRACTICA 1: EQUIPO DE FUTBOL ===");

        Equipo valencia = new Equipo("Valencia");
        String[] nombres = {"Portero1","Portero2","Portero3","Defensa1","Defensa2","Defensa3",
            "Centro1","Centro2","Centro3","Delantero1","Delantero2","Delantero3","Delantero4","Delantero5"};
        Posicion[] posiciones = {Posicion.PORTERO,Posicion.PORTERO,Posicion.PORTERO,
            Posicion.DEFENSA,Posicion.DEFENSA,Posicion.DEFENSA,
            Posicion.CENTROCAMPISTA,Posicion.CENTROCAMPISTA,Posicion.CENTROCAMPISTA,
            Posicion.DELANTERO,Posicion.DELANTERO,Posicion.DELANTERO,Posicion.DELANTERO,Posicion.DELANTERO};
        for (int i = 0; i < nombres.length; i++) {
            valencia.agregarFutbolista(new Futbolista(nombres[i], 25, posiciones[i]));
        }
        valencia.listarFormacionEquipo();
        System.out.println();
        System.out.println("=== PRACTICA 2: ANALIZADOR TEXTOS ===");
        String texto = "Esto es un ejemplo ejemplo palabra palabra palabra. "
            + "Prueba de analisis de textos con colecciones en Java.";
        AnalizadorTextos analizador = new AnalizadorTextos(texto);
        System.out.println("3 palabras mas frecuentes: " + analizador.palabrasMasFrecuentes(3));
        System.out.println("3 palabras menos frecuentes: " + analizador.palabrasMenosFrecuentes(3));
        System.out.println("Palabras por longitud: " + analizador.palabrasPorLongitud());
    }
}

enum Posicion {
    PORTERO("Portero", 2000, 4000),
    DEFENSA("Defensa", 2500, 5000),
    CENTROCAMPISTA("Centrocampista", 3000, 6000),
    DELANTERO("Delantero", 4000, 8000);

    private String nombre;
    private int salarioMin, salarioMax;
    Posicion(String nombre, int salMin, int salMax) {
        this.nombre = nombre; this.salarioMin = salMin; this.salarioMax = salMax;
    }
    public String getNombre() { return nombre; }
    public int getSalarioMin() { return salarioMin; }
    public int getSalarioMax() { return salarioMax; }
}

interface Deportista {
    int getAnosProfesional();
    List<String> getListadoEquipos();
    int getTotalTrofeos();
}

class Futbolista implements Deportista {
    private String nombre;
    private int edad;
    private Posicion posicion;
    private int anosProfesional;
    private List<String> equipos = new ArrayList<>();
    private int trofeos;

    public Futbolista(String nombre, int edad, Posicion posicion) {
        this.nombre = nombre; this.edad = edad; this.posicion = posicion;
        this.anosProfesional = 0; this.trofeos = 0;
    }
    public Futbolista(String nombre, int edad, Posicion posicion, int anosProf, int trofeos) {
        this(nombre, edad, posicion);
        this.anosProfesional = anosProf; this.trofeos = trofeos;
    }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public Posicion getPosicion() { return posicion; }
    public void agregarEquipo(String equipo) { equipos.add(equipo); }
    public int getAnosProfesional() { return anosProfesional; }
    public List<String> getListadoEquipos() { return new ArrayList<>(equipos); }
    public int getTotalTrofeos() { return trofeos; }
    public String toString() {
        return "Futbolista{nombre=" + nombre + ", edad=" + edad
            + ", posicion=" + posicion.getNombre() + "}";
    }
}

class Equipo {
    private static final Map<Posicion, Integer> MAX_FUTBOLISTAS_POSICION = new HashMap<>();
    static {
        MAX_FUTBOLISTAS_POSICION.put(Posicion.PORTERO, 2);
        MAX_FUTBOLISTAS_POSICION.put(Posicion.DEFENSA, 5);
        MAX_FUTBOLISTAS_POSICION.put(Posicion.CENTROCAMPISTA, 5);
        MAX_FUTBOLISTAS_POSICION.put(Posicion.DELANTERO, 4);
    }

    private String nombre;
    private List<Futbolista> futbolistas = new ArrayList<>();

    public Equipo(String nombre) { this.nombre = nombre; }

    private int obtenerJugadoresPosicion(Posicion p) {
        int cont = 0;
        for (Futbolista f : futbolistas) {
            if (f.getPosicion() == p) cont++;
        }
        return cont;
    }

    public void agregarFutbolista(Futbolista f) {
        try {
            int actuales = obtenerJugadoresPosicion(f.getPosicion());
            int maximo = MAX_FUTBOLISTAS_POSICION.get(f.getPosicion());
            if (actuales >= maximo) {
                throw new RegistroFutbolistaException(f);
            }
            futbolistas.add(f);
            f.agregarEquipo(this.nombre);
            System.out.println("  Anadido: " + f.getNombre() + " (" + f.getPosicion().getNombre() + ")");
        } catch (RegistroFutbolistaException e) {
            System.out.println("  ERROR: " + e.getMessage());
        }
    }

    private int prioridadPosicion(Posicion p) {
        return switch(p) {
            case PORTERO -> 1;
            case DEFENSA -> 2;
            case CENTROCAMPISTA -> 3;
            case DELANTERO -> 4;
        };
    }

    public void listarFormacionEquipo() {
        futbolistas.sort((f1, f2) -> Integer.compare(
            prioridadPosicion(f1.getPosicion()), prioridadPosicion(f2.getPosicion())));
        System.out.println("  Formacion del equipo " + nombre + ":");
        Iterator<Futbolista> it = futbolistas.iterator();
        while (it.hasNext()) {
            System.out.println("    " + it.next());
        }
    }
}

class RegistroFutbolistaException extends Exception {
    public RegistroFutbolistaException(Futbolista f) {
        super("No se puede anadir el futbolista " + f.getNombre()
            + " a la posicion " + f.getPosicion().getNombre()
            + ": se ha alcanzado el maximo de jugadores para esa posicion");
    }
}

class AnalizadorTextos {
    private String texto;
    private HashMap<String, Integer> palabras = new HashMap<>();

    public AnalizadorTextos(String texto) {
        this.texto = texto.toLowerCase();
        contarPalabras();
    }

    private void contarPalabras() {
        String[] arr = texto.split("\\W+");
        for (String str : arr) {
            if (!str.isEmpty())
                palabras.put(str, palabras.getOrDefault(str, 0) + 1);
        }
    }

    public List<Map.Entry<String, Integer>> palabrasMasFrecuentes(int n) {
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(palabras.entrySet());
        lista.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return lista.subList(0, Math.min(n, lista.size()));
    }

    public List<Map.Entry<String, Integer>> palabrasMenosFrecuentes(int n) {
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(palabras.entrySet());
        lista.sort(Map.Entry.comparingByValue());
        return lista.subList(0, Math.min(n, lista.size()));
    }

    public HashMap<Integer, List<String>> palabrasPorLongitud() {
        HashMap<Integer, List<String>> resultado = new HashMap<>();
        for (String palabra : palabras.keySet()) {
            int longitud = palabra.length();
            resultado.computeIfAbsent(longitud, k -> new ArrayList<>()).add(palabra);
        }
        for (List<String> lista : resultado.values()) {
            Collections.sort(lista);
        }
        return resultado;
    }
}