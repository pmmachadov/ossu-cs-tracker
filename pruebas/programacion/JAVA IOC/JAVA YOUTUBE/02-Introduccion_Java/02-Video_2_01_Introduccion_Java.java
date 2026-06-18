

class Video_2_01_Introduccion_Java {

    public static final String TITULO = "2-1 Introduccion a Java DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=8gkaitxt-CI&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=17";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          2-1 INTRODUCCION A JAVA
        ================================================================

        --- ORIGEN E HISTORIA DE JAVA ---

        * 1991: Sun Microsystems (James Gosling) crea "Oak"
        * Objetivo: programar dispositivos inteligentes
          (televisores, radios, electrodomesticos)
        * Rechazaron C++ por: demasiada memoria, gestion manual
          de memoria compleja, aritmetica de punteros peligrosa
        * 1995: Se presenta Java oficialmente
        * 1996: Se lanza JDK 1.0 (primera version)
        * Nombre "Oak" -> problemas legales (nombre registrado)
        * Nuevo nombre "Java" -> variedad de cafe de la isla de Java (Indonesia)
        * Logotipo: una taza de cafe humeante
        * Version actual (sept 2022): Java Standard Edition 19

        --- CARACTERISTICAS PRINCIPALES ---

        * Orientado a objetos: fuertemente orientado a objetos
        * Write Once, Run Anywhere (WORA): mismo bytecode funciona
          en cualquier plataforma con JVM
        * Garbage Collector: recolector de basura automatico
          - Libera al programador de gestionar la memoria
          - Cuando se pierde una referencia, el GC libera esa memoria
        * Multiplataforma: gracias a la JVM
        * Seguro y robusto

        --- PROCESO DE EJECUCION ---

        1. Codigo fuente (.java) -> Archivo escrito en lenguaje Java
        2. Compilador (javac) -> Compila el .java
        3. Bytecode (.class) -> Codigo intermedio independiente
           de la plataforma (identico en cualquier SO)
        4. JVM (Java Virtual Machine) -> Interpreta el bytecode
        5. Compilador JIT (Just in Time) -> Optimiza metodos
           que se ejecutan con frecuencia (los compila a codigo maquina)
        6. Codigo maquina -> Especifico del Hardware
        7. Hardware -> Ejecuta el programa

        Esquema:
          .java  -->  javac  -->  .class (bytecode)
                                   |
                                   v
                                 JVM
                                   |
                          +--------+--------+
                          |                 |
                     JIT (optimiza)    Interpreta
                          |                 |
                          v                 v
                     Codigo maquina <-- (codigo nativo)
                          |
                          v
                       Hardware

        --- BYTECODE DE JAVA ---

        * El archivo .class (bytecode) es IDENTICO en cualquier plataforma
        * Puedo compilar en Windows y ejecutar el .class en Linux, Mac, etc.
        * Solo necesito una JVM instalada en esa plataforma
        * La JVM convierte el bytecode a codigo maquina especifico
          de cada procesador (Intel, AMD, ARM, Apple Silicon...)

        --- COMPILADOR JIT (Just in Time) ---

        * Mejora el rendimiento de la JVM
        * Cuenta cuantas veces se ejecuta cada metodo
        * Cuando un metodo supera un umbral, lo compila a codigo maquina
        * Los metodos compilados ya no pasan por el interprete
        * Iguala el rendimiento de Java al de aplicaciones nativas

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Java: lenguaje orientado a objetos, multiplataforma
        * Creador: James Gosling (Sun Microsystems)
        * Nombre original: Oak (roble)
        * Nombre actual: Java (cafe de la isla de Java)
        * Write Once, Run Anywhere (WORA)
        * .java -> codigo fuente
        * javac -> compilador de Java
        * .class -> bytecode (codigo intermedio)
        * JVM -> Java Virtual Machine (interpreta bytecode)
        * JIT -> Just in Time (optimiza metodos frecuentes)
        * Garbage Collector -> libera memoria automaticamente
        * JDK (Java Development Kit) -> incluye JRE + herramientas
        * JRE (Java Runtime Environment) -> incluye JVM + librerias
        ================================================================
        """;

    public static void main(String[] args) {
        mostrarInformacion();
    }

    public static void mostrarInformacion() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("   INFORMACION DEL VIDEO");
        System.out.println("============================================");
        System.out.println("Video:      " + TITULO);
        System.out.println("Canal:      " + CANAL);
        System.out.println("URL Canal:  " + URL_CANAL);
        System.out.println("URL Video:  " + URL);
        System.out.println("Playlist:   " + PLAYLIST);
        System.out.println();
        System.out.println(RESUMEN);
    }
}
