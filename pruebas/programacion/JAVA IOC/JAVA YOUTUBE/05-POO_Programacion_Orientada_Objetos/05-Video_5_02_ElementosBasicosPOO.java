class Video_5_02_ElementosBasicosPOO {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-02 JAVA: Elementos basicos de la POO DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=tfLy9Eu7aNM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=95";
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
          RESUMEN RAPIDO - ELEMENTOS BASICOS POO (TEMA 5 - V02)
        ====================================================================

        --- CONCEPTOS ---
        1. CLASE: Molde/plantilla que define atributos y metodos.
           - Nombre en PascalCase (mayuscula inicial).
           - Ej: class Persona { ... }, class Bicicleta { ... }

        2. OBJETO: Instancia concreta de una clase.
           - Cada objeto tiene su propio ESTADO (valores de atributos).

        3. UML (Unified Modeling Language):
           - Lenguaje grafico para modelar clases.
           - Tres secciones: NOMBRE | ATRIBUTOS | METODOS
           - Ej: Persona: nombre, edad, dni, ciudad, profesion
                           +mostrarDatos() +cambiarProfesion()

        --- ESTRUCTURA DE UNA CLASE EN JAVA ---
        class Persona {
            // ATRIBUTOS (sin inicializar, se asignan al crear instancia)
            String nombre;
            int edad;
            String ciudad;
            String profesion;
            String dni;

            // CONSTRUCTOR (crea instancias con valores iniciales)
            public Persona(String n, int e, String d) {
                nombre = n;
                edad = e;
                dni = d;
                ciudad = "Sin ciudad";
                profesion = "Sin profesion";
            }

            // METODO DE INSTANCIA (sin static)
            public void mostrarDatos() {
                System.out.println("Nombre: " + nombre);
                System.out.println("Edad: " + edad);
                // ...
            }
        }

        --- CONSTRUCTOR ---
        - Metodo especial que se ejecuta al crear un objeto (new).
        - Tiene el MISMO nombre que la clase.
        - Puede tener 0, 1 o varios parametros.
        - Sirve para INICIALIZAR los atributos del objeto.
        - Sintaxis: public NombreClase(parametros) { ... }
        - Se pueden tener VARIOS constructores (sobrecarga).

        --- METODOS DE INSTANCIA vs ESTATICOS ---
        - SIN static: metodo de INSTANCIA.
          - Solo se puede llamar sobre un objeto (p1.mostrarDatos()).
          - Trabaja con los atributos de esa instancia concreta.

        - CON static: metodo de CLASE.
          - Se puede llamar sin crear objeto (Persona.mostrarDatos()).
          - No puede acceder a atributos de instancia directamente.
          - Hasta ahora usabamos static porque no habia objetos.
          - En POO, los metodos normales NO llevan static.

        --- CREAR INSTANCIAS ---
        Persona p1 = new Persona("Pepe", 40, "202020A");
        Persona p2 = new Persona("Marta", 25, "303030B");

        - new: palabra clave para crear un objeto.
        - Persona(...): llama al constructor con los parametros.
        - p1, p2: identificadores de las instancias.

        --- ACCEDER A MIEMBROS ---
        - p1.mostrarDatos();    // metodo de instancia
        - p1.nombre             // atributo (NO RECOMENDADO directamente)

        Los atributos deberian ser PRIVADOS (lo veremos mas adelante).

        ====================================================================
        """;

    // -------------------------------------------------------------
    // ATRIBUTOS de la clase Persona
    // -------------------------------------------------------------
    String nombre;
    int edad;
    String ciudad;
    String profesion;
    String dni;

    // -------------------------------------------------------------
    // CONSTRUCTOR (con 3 parametros)
    // -------------------------------------------------------------
    Video_5_02_ElementosBasicosPOO(String n, int e, String d) {
        nombre = n;
        edad = e;
        dni = d;
        ciudad = "Sin ciudad";
        profesion = "Sin profesion";
    }

    // -------------------------------------------------------------
    // METODO DE INSTANCIA (sin static)
    // -------------------------------------------------------------
    void mostrarDatos() {
        System.out.println("  Nombre: " + nombre);
        System.out.println("  Edad: " + edad);
        System.out.println("  DNI: " + dni);
        System.out.println("  Ciudad: " + ciudad);
        System.out.println("  Profesion: " + profesion);
    }

    // -------------------------------------------------------------
    // METODO PRINCIPAL
    // -------------------------------------------------------------
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 5 - V02: ELEMENTOS BASICOS DE LA POO");
        System.out.println("========================================");
        System.out.println();

        // ============================================================
        // EJEMPLO 1: Dos instancias con el mismo constructor
        // ============================================================
        separador("EJEMPLO 1: Crear instancias con constructor");

        System.out.println("  Persona p1 = new Persona(\"Pepe\", 40, \"202020A\");");
        System.out.println("  Persona p2 = new Persona(\"Marta\", 25, \"303030B\");");
        System.out.println();

        Video_5_02_ElementosBasicosPOO p1 =
            new Video_5_02_ElementosBasicosPOO("Pepe", 40, "202020A");
        Video_5_02_ElementosBasicosPOO p2 =
            new Video_5_02_ElementosBasicosPOO("Marta", 25, "303030B");

        System.out.println("  Datos de p1 (Pepe):");
        p1.mostrarDatos();
        System.out.println();
        System.out.println("  Datos de p2 (Marta):");
        p2.mostrarDatos();
        System.out.println();

        // ============================================================
        // EJEMPLO 2: Acceso a atributos directamente (NO RECOMENDADO)
        // ============================================================
        separador("EJEMPLO 2: Acceso directo a atributos");

        System.out.println("  (Aunque no es buena practica, se puede acceder):");
        System.out.println("  p1.nombre = " + p1.nombre);
        System.out.println("  p2.edad = " + p2.edad);
        System.out.println();

        // ============================================================
        // CONCEPTOS CLAVE
        // ============================================================
        separador("RECORDATORIO: CLASE vs OBJETO vs INSTANCIA");

        System.out.println("  CLASE  -> Persona (el molde)");
        System.out.println("  OBJETO -> Cualquier entidad del mundo real simulada");
        System.out.println("  INSTANCIA -> p1, p2 (objetos concretos creados)");
        System.out.println();
        System.out.println("  ATRIBUTOS: nombre, edad, dni, ciudad, profesion");
        System.out.println("    -> definen el ESTADO de cada instancia");
        System.out.println("  METODOS: mostrarDatos()");
        System.out.println("    -> definen el COMPORTAMIENTO");
        System.out.println();
        System.out.println("  CONSTRUCTOR: public Persona(String n, int e, String d)");
        System.out.println("    -> Se ejecuta con 'new'");
        System.out.println("    -> Inicializa los atributos de la nueva instancia");
        System.out.println();
        System.out.println("  STATIC: los metodos de instancia NO llevan static");
        System.out.println("    -> Se llaman sobre el objeto: p1.mostrarDatos()");
        System.out.println("    -> Los metodos static son de la CLASE, no del objeto");

        System.out.println();
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V02: ELEMENTOS BASICOS POO)");
        System.out.println("============================================================");
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
