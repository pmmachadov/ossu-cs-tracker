class Video_5_03_EjemplosOO {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-03 JAVA: Ejemplos orientacion a objetos DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=mNt0D-pKmU4&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=96";
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
          RESUMEN RAPIDO - EJEMPLOS ORIENTACION A OBJETOS (TEMA 5 - V03)
        ====================================================================

        --- ATRIBUTOS ---
        - Caracteristicas individuales que diferencian un objeto de otro.
        - Determinan el ESTADO del objeto.
        - Se declaran como VARIABLES DE INSTANCIA (sin static).
        - Cada instancia tiene sus propios valores.
        - Se declaran en la clase, se modifican desde la instancia.

        --- ENCAPSULACION ---
        - Los atributos deben ser PRIVATE para que no sean accesibles
          desde fuera de la clase.
        - Para modificarlos/consultarlos se usan METODOS PUBLICOS.
        - Ventaja: podemos controlar los valores (ej: edad no negativa).
        - Si los atributos son publicos, cualquiera puede asignar
          valores invalidos (edad negativa, saldo sin control, etc.).

        Ejemplo de encapsulacion:
        private int edad;   // no accesible desde fuera

        public void establecerEdad(int n) {
            if (n >= 0) {
                edad = n;
            } else {
                System.out.println("No se pueden poner edades negativas");
            }
        }

        --- METODOS ---
        - Definen el COMPORTAMIENTO de los objetos.
        - Conjunto de instrucciones que realizan una tarea.
        - Pueden modificar el estado del objeto.

        --- MENSAJES ---
        - Interaccion entre objetos mediante llamadas a metodos.
        - Un mensaje tiene 3 elementos:
          1. Objeto DESTINO (hacia quien va el mensaje)
          2. Nombre del METODO
          3. PARAMETROS (si necesita)
        - Ej: p1.establecerEdad(34);  -> mensaje a p1
        - Ej: cuenta1.retirar(50);    -> mensaje a cuenta1

        --- INSTANCIACION ---
        - Proceso de crear un objeto a partir de una clase.
        - Se hace con la palabra clave 'new' + constructor.
        - El constructor devuelve una instancia de la clase.

        --- CLASE CUENTA BANCARIA (nueva) ---
        Atributos: int id, double saldo, Persona propietario, String tipo
        Metodos: verSaldo(), ingresar(double), retirar(double),
                 anadirPropietario(Persona), mostrarDatos()

        --- COMPOSICION DE OBJETOS ---
        - Una clase puede tener como atributo otra clase.
        - Ej: CuentaBancaria tiene un atributo Persona propietario.
        - Asi podemos relacionar objetos del mundo real.
        - Desde la cuenta podemos acceder a los datos de la persona.

        --- VENTAJAS DE LA POO ---
        1. REUTILIZACION: el codigo de una clase se usa en todas
           sus instancias.
        2. ENCAPSULACION: control sobre los valores de los atributos.
        3. MANTENIBILIDAD: cambios locales, no afectan a todo.
        4. MODELADO: los objetos reflejan la realidad.

        ====================================================================
        """;

    // ================================================================
    // CLASE PERSONA (con encapsulacion)
    // ================================================================
    static class Persona {
        // Atributos PRIVADOS (encapsulados)
        private String nombre;
        private int edad;
        private String ciudad;
        private String profesion;
        private String dni;

        // Constructor
        Persona(String n, int e, String d) {
            nombre = n;
            edad = e;
            dni = d;
            ciudad = "Sin ciudad";
            profesion = "Sin profesion";
        }

        // Metodo publico para establecer la edad (con validacion)
        void establecerEdad(int n) {
            if (n >= 0) {
                edad = n;
            } else {
                System.out.println("  ERROR: No se pueden poner edades negativas");
            }
        }

        // Metodo para obtener la edad
        int obtenerEdad() {
            return edad;
        }

        // Getter para nombre (necesario para la cuenta)
        String obtenerNombre() {
            return nombre;
        }

        // Mostrar datos
        void mostrarDatos() {
            System.out.println("    Nombre: " + nombre);
            System.out.println("    Edad: " + edad);
            System.out.println("    DNI: " + dni);
            System.out.println("    Ciudad: " + ciudad);
            System.out.println("    Profesion: " + profesion);
        }
    }

    // ================================================================
    // CLASE CUENTA BANCARIA
    // ================================================================
    static class CuentaBancaria {
        private int id;
        private double saldo;
        private Persona propietario;  // Composicion: objeto dentro de otro
        private String tipo;

        // Constructor
        CuentaBancaria(int num) {
            id = num;
            saldo = 0;
            propietario = null;
            tipo = "Corriente";
        }

        // Anadir propietario (objeto Persona)
        void anadirPropietario(Persona p) {
            propietario = p;
        }

        // Ver saldo
        void verSaldo() {
            System.out.println("  El saldo de la cuenta " + id + " es: " + saldo + " euros");
        }

        // Ingresar dinero
        void ingresar(double n) {
            if (n > 0) {
                saldo += n;
                System.out.println("  Ingresados " + n + " euros en la cuenta " + id);
            } else {
                System.out.println("  ERROR: No se puede ingresar una cantidad negativa");
            }
        }

        // Retirar dinero (con comprobacion de saldo)
        void retirar(double n) {
            if (n <= 0) {
                System.out.println("  ERROR: Cantidad no valida para retirar");
            } else if (saldo >= n) {
                saldo -= n;
                System.out.println("  Retirados " + n + " euros de la cuenta " + id);
            } else {
                System.out.println("  ERROR: No hay suficiente saldo en la cuenta " + id);
            }
        }

        // Mostrar datos completos (cuenta + propietario)
        void mostrarDatos() {
            System.out.println("  === DATOS DE LA CUENTA " + id + " ===");
            if (propietario != null) {
                System.out.println("  Propietario:");
                propietario.mostrarDatos();
            } else {
                System.out.println("  Propietario: Sin asignar");
            }
            System.out.println("  Tipo: " + tipo);
            verSaldo();
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

        // ============================================================
        // PARTE 1: ATRIBUTOS Y ESTADO
        // ============================================================
        separador("PARTE 1: ATRIBUTOS Y ESTADO DE CADA INSTANCIA");

        Persona p1 = new Persona("Pepe", 40, "202020A");
        Persona p2 = new Persona("Marta", 25, "303030B");

        System.out.println("  Estado de p1: {nombre=Pepe, edad=40, dni=202020A}");
        System.out.println("  Estado de p2: {nombre=Marta, edad=25, dni=303030B}");
        System.out.println("  Misma clase, mismo tipo de atributos,");
        System.out.println("  pero cada instancia tiene su PROPIO estado.");
        System.out.println();

        // ============================================================
        // PARTE 2: ENCAPSULACION
        // ============================================================
        separador("PARTE 2: ENCAPSULACION - Control de valores");

        System.out.println("  Intentando establecer edad negativa a Marta:");
        p2.establecerEdad(-5);
        System.out.println("  Edad real de Marta: " + p2.obtenerEdad() + " (no cambio)");
        System.out.println();

        System.out.println("  Estableciendo edad valida a Marta (34):");
        p2.establecerEdad(34);
        System.out.println("  Edad de Marta ahora: " + p2.obtenerEdad());
        System.out.println();

        // ============================================================
        // PARTE 3: MENSAJES E INSTANCIACION
        // ============================================================
        separador("PARTE 3: CUENTA BANCARIA - Mensajes entre objetos");

        CuentaBancaria c1 = new CuentaBancaria(1);
        CuentaBancaria c2 = new CuentaBancaria(2);

        // Asignar propietarios (COMPOSICION: objeto Persona dentro de Cuenta)
        c1.anadirPropietario(p1);
        c2.anadirPropietario(p2);

        // Mensajes: ingresar dinero
        c1.ingresar(100);
        c2.ingresar(200);
        System.out.println();

        // Mensajes: retirar dinero
        c1.retirar(50);
        c2.retirar(250);   // No deberia poder (solo tiene 200)
        System.out.println();

        // Consultar saldos
        c1.verSaldo();
        c2.verSaldo();
        System.out.println();

        // ============================================================
        // PARTE 4: MOSTRAR DATOS COMPLETOS
        // ============================================================
        separador("PARTE 4: DATOS COMPLETOS (Cuenta + Propietario)");

        c1.mostrarDatos();
        c2.mostrarDatos();

        // ============================================================
        // RESUMEN FINAL
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V03: EJEMPLOS ORIENTACION A OBJETOS)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS REPASADOS:");
        System.out.println("  1. ATRIBUTOS -> estado del objeto (variables de instancia)");
        System.out.println("  2. ENCAPSULACION -> private + metodos publicos");
        System.out.println("  3. METODOS -> comportamiento del objeto");
        System.out.println("  4. MENSAJES -> llamadas a metodos entre objetos");
        System.out.println("  5. INSTANCIACION -> new + constructor");
        System.out.println("  6. COMPOSICION -> una clase dentro de otra");
        System.out.println("  7. REUTILIZACION -> codigo compartido entre instancias");
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
