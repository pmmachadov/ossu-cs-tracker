class Video_5_04_CaracteristicasPOO {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-04 JAVA: Caracteristicas de la POO DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=1Ivd5SL-mwg&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=97";
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
          RESUMEN RAPIDO - CARACTERISTICAS DE LA POO (TEMA 5 - V04)
        ====================================================================

        Las 4 caracteristicas basicas de la POO:
        1. ABSTRACCION
        2. ENCAPSULAMIENTO
        3. HERENCIA
        4. POLIMORFISMO

        --- 1. ABSTRACCION ---
        - Proceso de extraer las caracteristicas esenciales de un objeto
          del mundo real, ignorando los detalles irrelevantes.
        - Nos preguntamos: ?Que necesito almacenar? ?Que debe hacer?
        - Ej: para una aplicacion que agrupa personas por ciudades,
          abstraemos: nombre, edad, ciudad. No nos interesa el color
          de ojos ni la altura.
        - El resultado es una CLASE (molde) con atributos y metodos.
        - Todos los objetos de esa clase tendran los mismos tipos de
          atributos, pero cada uno con sus valores concretos.

        --- 2. ENCAPSULAMIENTO ---
        - Capacidad de un objeto de OCULTAR su informacion interna.
        - Solo se accede a traves de METODOS PUBLICOS.
        - Los atributos deben ser PRIVATE.
        - Getters: metodos para OBTENER el valor de un atributo.
        - Setters: metodos para MODIFICAR el valor de un atributo.
        - No todos los atributos necesitan getter y setter.
          Ej: el DNI se asigna al crear y NO se puede modificar,
          solo consultar (getter si, setter no).
        - Ventajas:
          * Control sobre los valores (validacion en setters).
          * Podemos cambiar la implementacion interna sin afectar
            al codigo que usa la clase.
          * Protegemos la integridad del objeto.

        --- 3. HERENCIA ---
        - Mecanismo que permite que una CLASE (subclase/hija) herede
          atributos y metodos de otra CLASE (superclase/padre).
        - Ej: Persona (superclase) -> Alumno y Profesor (subclases).
          Alumno hereda nombre, edad, dni de Persona, y anade nia.
          Profesor hereda de Persona y anade clasesQueImparte.
        - La subclase puede:
          * Anadir nuevos atributos y metodos.
          * Redefinir metodos heredados (sobrescribirlos).
        - La herencia puede tener VARIOS NIVELES.
        - Ventaja: REUTILIZACION de codigo.
        - Notacion UML: flecha vacia de la subclase a la superclase.

        --- 4. POLIMORFISMO ---
        - Capacidad de un metodo de comportarse de forma DISTINTA
          dependiendo del tipo de objeto sobre el que se invoca.
        - Ej: el metodo obtenerDatos() en Persona muestra datos basicos,
          en Alumno muestra datos basicos + nia,
          en Profesor muestra datos basicos + clases.
        - Mismo nombre de metodo, comportamiento diferente.
        - Esta muy relacionado con la herencia.
        - Se vera en profundidad en el TEMA 6.

        --- VENTAJAS DE LA POO ---
        - Aislamiento: cada objeto es independiente.
        - Codigo mas breve y conciso.
        - Reutilizacion: el codigo de una clase se usa en todas
          sus instancias y subclases.
        - Mantenibilidad: cambios localizados en una clase.

        ====================================================================
        """;

    // ================================================================
    // CLASE PERSONA (ABSTRACCION + ENCAPSULAMIENTO)
    // ================================================================
    static class Persona {
        // Atributos PRIVADOS (encapsulamiento)
        private String nombre;
        private int edad;
        private String dni;    // Sin setter -> solo se asigna al crear
        private String ciudad;
        private String profesion;

        // Constructor
        Persona(String nombre, int edad, String dni) {
            this.nombre = nombre;
            this.edad = edad;
            this.dni = dni;
            this.ciudad = "Sin ciudad";
            this.profesion = "Sin profesion";
        }

        // GETTERS (para obtener valores)
        String getNombre() { return nombre; }
        int getEdad() { return edad; }
        String getDni() { return dni; }       // Solo getter, NO setter
        String getCiudad() { return ciudad; }
        String getProfesion() { return profesion; }

        // SETTERS (para modificar valores con control)
        void setNombre(String nombre) { this.nombre = nombre; }

        void setEdad(int edad) {
            if (edad >= 0) {
                this.edad = edad;
            } else {
                System.out.println("  ERROR: Edad no puede ser negativa");
            }
        }

        void setCiudad(String ciudad) { this.ciudad = ciudad; }

        void setProfesion(String profesion) { this.profesion = profesion; }

        // Metodo polimorfico (se redefinira en subclases)
        void obtenerDatos() {
            System.out.println("  Nombre: " + nombre);
            System.out.println("  Edad: " + edad);
            System.out.println("  DNI: " + dni);
            System.out.println("  Ciudad: " + ciudad);
            System.out.println("  Profesion: " + profesion);
        }
    }

    // ================================================================
    // CLASE ALUMNO (HERENCIA de Persona)
    // ================================================================
    static class Alumno extends Persona {
        // Atributo especifico de Alumno
        private String nia;  // Numero de Identificacion de Alumno

        // Constructor
        Alumno(String nombre, int edad, String dni, String nia) {
            super(nombre, edad, dni);  // Llama al constructor de Persona
            this.nia = nia;
        }

        // Getter especifico
        String getNia() { return nia; }
        void setNia(String nia) { this.nia = nia; }

        // POLIMORFISMO: redefinimos obtenerDatos()
        @Override
        void obtenerDatos() {
            super.obtenerDatos();  // Llama al metodo de Persona
            System.out.println("  NIA: " + nia);
        }
    }

    // ================================================================
    // CLASE PROFESOR (HERENCIA de Persona)
    // ================================================================
    static class Profesor extends Persona {
        // Atributo especifico de Profesor
        private String[] clasesQueImparte;

        // Constructor
        Profesor(String nombre, int edad, String dni, String[] clases) {
            super(nombre, edad, dni);
            this.clasesQueImparte = clases;
        }

        // Getter
        String[] getClases() { return clasesQueImparte; }

        // POLIMORFISMO: redefinimos obtenerDatos()
        @Override
        void obtenerDatos() {
            super.obtenerDatos();  // Llama al metodo de Persona
            System.out.print("  Clases que imparte: ");
            for (String c : clasesQueImparte) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 5 - V04: LAS 4 CARACTERISTICAS DE LA POO");
        System.out.println();

        // ============================================================
        // PARTE 1: ABSTRACCION + ENCAPSULAMIENTO
        // ============================================================
        separador("PARTE 1: ABSTRACCION y ENCAPSULAMIENTO");

        System.out.println("  ABSTRACCION: Hemos extraido de una persona del");
        System.out.println("  mundo real los atributos: nombre, edad, dni,");
        System.out.println("  ciudad, profesion. Solo lo esencial.");
        System.out.println();
        System.out.println("  ENCAPSULAMIENTO: Todos los atributos son private.");
        System.out.println("  Solo se accede mediante getters y setters.");
        System.out.println("  El DNI solo tiene getter (no se puede modificar).");
        System.out.println();

        Persona p = new Persona("Pepe", 40, "202020A");
        System.out.println("  Persona creada: " + p.getNombre());
        System.out.println("  DNI: " + p.getDni() + " (solo lectura)");
        System.out.println();

        System.out.println("  Intentando cambiar edad a -5:");
        p.setEdad(-5);  // No lo permite
        System.out.println("  Edad actual: " + p.getEdad() + " (no cambio)");
        System.out.println();

        // ============================================================
        // PARTE 2: HERENCIA
        // ============================================================
        separador("PARTE 2: HERENCIA");

        System.out.println("  Alumno extiende Persona (hereda todo + anade nia)");
        System.out.println("  Profesor extiende Persona (hereda todo + anade clases)");
        System.out.println();

        Alumno al = new Alumno("Maria", 20, "101010C", "12345A");
        Profesor pr = new Profesor("Juan", 45, "505050D",
                                    new String[]{"Programacion", "BBDD"});

        System.out.println("  Alumno: " + al.getNombre()
            + " | Edad: " + al.getEdad()     // Heredado de Persona
            + " | NIA: " + al.getNia());      // Propio de Alumno
        System.out.println("  Profesor: " + pr.getNombre()
            + " | Edad: " + pr.getEdad()       // Heredado de Persona
            + " | DNI: " + pr.getDni());       // Heredado de Persona
        System.out.println();

        // ============================================================
        // PARTE 3: POLIMORFISMO
        // ============================================================
        separador("PARTE 3: POLIMORFISMO");

        System.out.println("  El mismo metodo obtenerDatos() se comporta");
        System.out.println("  de forma DISTINTA segun la clase:");
        System.out.println();

        System.out.println("  --- Persona ---");
        p.obtenerDatos();
        System.out.println();

        System.out.println("  --- Alumno ---");
        al.obtenerDatos();   // Muestra datos Persona + NIA
        System.out.println();

        System.out.println("  --- Profesor ---");
        pr.obtenerDatos();   // Muestra datos Persona + Clases
        System.out.println();

        // ============================================================
        // RESUMEN FINAL
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V04: CARACTERISTICAS DE LA POO)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  LAS 4 CARACTERISTICAS:");
        System.out.println("  1. ABSTRACCION: Extraer lo esencial del mundo real");
        System.out.println("  2. ENCAPSULAMIENTO: Ocultar datos, solo metodos publicos");
        System.out.println("  3. HERENCIA: extends, reutilizar codigo entre clases");
        System.out.println("  4. POLIMORFISMO: mismo metodo, distinto comportamiento");
        System.out.println();
        System.out.println("  PROXIMO TEMA: Diseno orientado a objetos con UML");
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
