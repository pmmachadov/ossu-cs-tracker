class Video_5_01_POO_Introduccion {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-01 JAVA: Programacion orientada a objetos DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=tELkj4CmvgY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=94";
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
          RESUMEN RAPIDO - POO INTRODUCCION (TEMA 5 - V01)
        ====================================================================

        --- CRISIS DEL SOFTWARE (agnos 60-70) ---
        Los programas crecian y el paradigma orientado a procedimientos
          generaba:
        - Codigo dificil de mantener
        - Codigo poco reutilizable (codigo duplicado)
        - Proyectos fuera de plazo y presupuesto
        - Software de baja calidad

        Solucion: surge la PROGRAMACION ORIENTADA A OBJETOS (POO).

        --- CONCEPTOS FUNDAMENTALES ---

        1. OBJETO:
           - Entidad que simula un objeto del mundo real.
           - Tiene ATRIBUTOS (propiedades/estado) y METODOS
             (comportamiento).
           - Ej: una persona tiene nombre, dni, edad (atributos) y
             puede cambiar de profesion, obtener datos (metodos).

        2. CLASE:
           - Es el MOLDE / PLANTILLA para crear objetos.
           - Define los atributos y metodos que tendran todos los
             objetos de ese tipo.
           - En Java: class Persona { ... }
           - Convencion: nombre de clase empieza con MAYUSCULA
             (PascalCase): Persona, CuentaBancaria, Coche.

        3. INSTANCIA:
           - Es un OBJETO concreto creado a partir de una clase.
           - Cada instancia tiene su propio ESTADO (valores de sus
             atributos).
           - Ej: de la clase Persona podemos crear las instancias
             "Pepe" y "Marta", cada una con su nombre, edad, etc.

        4. ESTADO:
           - Es el valor actual de todos los atributos de un objeto.
           - Pepe: {nombre="Pepe", dni="202020A", edad=45,
                    ciudad="Valencia", profesion="Profesor"}
           - Marta: {nombre="Marta", dni="303030B", edad=25,
                     ciudad="Madrid", profesion="Periodista"}

        5. COMPORTAMIENTO:
           - Son los METODOS que definen que puede hacer un objeto.
           - Pueden modificar el estado (cambiar profesion) o
             consultarlo (obtener datos).

        6. MENSAJES:
           - La forma en que los objetos interactuan entre si.
           - Un objeto invoca un metodo de otro objeto.
           - Ej: persona1.cambiarCiudad("Barcelona") -> mensaje
             al objeto persona1.

        --- CONVENIOS DE CODIGO (Java) ---
        - Clases: PascalCase (primera letra mayuscula)
          Ej: Persona, Coche, CuentaBancaria
        - Variables y metodos: camelCase (primera minuscula,
          siguientes mayusculas)
          Ej: nombrePersona, cambiarProfesion(), obtenerDatos()
        - Metodos siempre tienen parentesis: metodo()
        - Variables nunca tienen parentesis

        --- ESTRUCTURA TEMA 5 ---
        1. Introduccion teorica a la POO (conceptos, UML)
        2. POO en Java (clases, objetos, constructores, metodos,
           this, modificadores de acceso, static...)

        ====================================================================
        """;

    // -------------------------------------------------------------
    // Simulacion del ejemplo: Clase Persona (concepto)
    // -------------------------------------------------------------

    // ATRIBUTOS (definen el estado de cada instancia)
    String nombre;
    String dni;
    int edad;
    String ciudad;
    String profesion;

    // Constructor
    Video_5_01_POO_Introduccion(String nombre, String dni, int edad,
                                  String ciudad, String profesion) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.ciudad = ciudad;
        this.profesion = profesion;
    }

    // METODOS (definen el comportamiento)

    /** Muestra todos los datos de la persona */
    void obtenerDatos() {
        System.out.println("  Nombre: " + nombre);
        System.out.println("  DNI: " + dni);
        System.out.println("  Edad: " + edad);
        System.out.println("  Ciudad: " + ciudad);
        System.out.println("  Profesion: " + profesion);
    }

    /** Cambia la profesion */
    void cambiarProfesion(String nuevaProfesion) {
        System.out.println("  " + nombre + " cambia de profesion: "
            + profesion + " -> " + nuevaProfesion);
        this.profesion = nuevaProfesion;
    }

    /** Cambia la ciudad de residencia */
    void modificarCiudadResidencia(String nuevaCiudad) {
        System.out.println("  " + nombre + " se muda de " + ciudad
            + " a " + nuevaCiudad);
        this.ciudad = nuevaCiudad;
    }

    // -------------------------------------------------------------
    // METODO PRINCIPAL
    // -------------------------------------------------------------
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("INICIO DEL TEMA 5: PROGRAMACION ORIENTADA A OBJETOS");
        System.out.println("================================================");
        System.out.println("Del paradigma orientado a procedimientos -> POO");
        System.out.println();

        // ============================================================
        // CREACION DE INSTANCIAS (objetos)
        // ============================================================
        separador("CREACION DE OBJETOS (INSTANCIAS)");

        System.out.println("Creamos dos objetos de la clase Persona:");
        System.out.println();

        Video_5_01_POO_Introduccion pepe =
            new Video_5_01_POO_Introduccion("Pepe", "202020A", 45,
                                             "Valencia", "Profesor");
        Video_5_01_POO_Introduccion marta =
            new Video_5_01_POO_Introduccion("Marta", "303030B", 25,
                                             "Madrid", "Periodista");

        System.out.println("  Objeto 'pepe'  -> Instancia de Persona");
        System.out.println("  Objeto 'marta' -> Instancia de Persona");
        System.out.println("  Ambas son instancias de la MISMA clase Persona,");
        System.out.println("  pero cada una tiene su PROPIO estado.");
        System.out.println();

        // ============================================================
        // MOSTRAR ESTADO INICIAL
        // ============================================================
        separador("ESTADO INICIAL DE CADA OBJETO");

        System.out.println("  Datos de PEPE:");
        pepe.obtenerDatos();
        System.out.println();
        System.out.println("  Datos de MARTA:");
        marta.obtenerDatos();
        System.out.println();

        // ============================================================
        // INTERACCION: MENSAJES (metodos)
        // ============================================================
        separador("INTERACCION CON OBJETOS (MENSAJES)");

        System.out.println("  --- Pepe cambia de profesion ---");
        pepe.cambiarProfesion("Informatico");
        System.out.println();

        System.out.println("  --- Marta se muda a Barcelona ---");
        marta.modificarCiudadResidencia("Barcelona");
        System.out.println();

        // ============================================================
        // ESTADO FINAL
        // ============================================================
        separador("ESTADO FINAL DE CADA OBJETO");

        System.out.println("  Datos de PEPE (despues de cambios):");
        pepe.obtenerDatos();
        System.out.println();
        System.out.println("  Datos de MARTA (despues de cambios):");
        marta.obtenerDatos();
        System.out.println();

        // ============================================================
        // CONCEPTOS ADICIONALES
        // ============================================================
        separador("CONCEPTOS CLAVE DE POO");

        System.out.println("  1. CLASE: Plantilla/molde (class Persona)");
        System.out.println("  2. OBJETO: Entidad del mundo real simulada");
        System.out.println("  3. INSTANCIA: Objeto concreto creado de una clase");
        System.out.println("  4. ATRIBUTOS: Propiedades/estado del objeto");
        System.out.println("  5. METODOS: Comportamiento del objeto");
        System.out.println("  6. MENSAJE: Llamada a un metodo de otro objeto");
        System.out.println();
        System.out.println("  CONVENCIONES JAVA:");
        System.out.println("  - Clases: PascalCase (Persona, CuentaBancaria)");
        System.out.println("  - Variables/Metodos: camelCase (nombre, obtenerDatos())");
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V01: INTRODUCCION A LA POO)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  PROXIMO VIDEO: Ejemplo practico POO en Java");
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
