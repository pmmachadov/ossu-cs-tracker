class Video_2_03_Hola_Mundo_Java {

    public static final String TITULO = "2-3 Mi primer programa en Java: Hola Mundo";
    public static final String URL = "https://www.youtube.com/watch?v=AVEU8AEZ5YE&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=19";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 2";

    public static final String RESUMEN =
        """
        ================================================================
          2-3 MI PRIMER PROGRAMA EN JAVA: HOLA MUNDO
        ================================================================

        --- CODIGO DEL HOLA MUNDO ---

        // Aplicacion Hola Mundo de ejemplo
        class HolaMundo {
            public static void main(String[] args) {
                System.out.println("Hola Mundo!");
            }
        }

        --- ESTRUCTURA DEL PROGRAMA ---

        1. Comentarios (opcional): // texto (no se ejecuta)
        2. class NombreClase { ... }
           - El nombre de la clase DEBE coincidir con el nombre del archivo
           - Si tiene varias palabras: cada palabra empieza con mayuscula
             (Ej: HolaMundo.java -> class HolaMundo)
           - Llaves { } delimitan el bloque de la clase
        3. Metodo main: public static void main(String[] args) { ... }
           - PUNTO DE INICIO del programa (primero que se ejecuta)
           - Siempre se escribe exactamente igual
           - Llaves { } delimitan el bloque del metodo
        4. Instruccion: System.out.println("texto");
           - Imprime por pantalla el texto entre comillas dobles
           - Se debe poner punto y coma (;) al final de cada instruccion
           - System.out.println() es una funcion de la libreria de Java

        --- PASOS PARA CREAR Y EJECUTAR ---

        1. Crear carpeta para el proyecto (ej: curso-java/Introduccion-a-Java)
        2. Abrir la carpeta en VS Code: File -> Open Folder
        3. Crear archivo: HolaMundo.java (mismo nombre que la clase)
        4. Escribir el codigo
        5. COMPILAR (opcional, VS Code lo hace solo):
           - Abrir terminal: Terminal -> New Terminal
           - javac HolaMundo.java  -> genera HolaMundo.class (bytecode)
        6. EJECUTAR:
           - Opcion 1: java HolaMundo (desde terminal, sin .class)
           - Opcion 2: Click en "Run" (triangulo) arriba a la derecha
           - Opcion 3: Click en "Play" (Run Java) en el codigo

        --- PARTES DEL METODO MAIN EXPLICADAS ---

        public:       visibilidad (accesible desde cualquier parte)
        static:       pertenece a la clase, no a un objeto
        void:         no devuelve ningun valor (procedimiento)
        main:         nombre del metodo (punto de entrada)
        String[] args: parametro que recibe (argumentos desde terminal)

        --- REGLAS IMPORTANTES ---

        * El archivo .java debe llamarse IGUAL que la clase
        * Las llaves { } delimitan bloques (clase, metodo, etc.)
        * Cada instruccion termina con punto y coma (;)
        * Los bloques NO llevan punto y coma
        * System.out.println() imprime texto y salta de linea
        * Los comentarios // no se ejecutan

        --- DIFERENCIA CON PSEUDOCODIGO ---

        Pseudocodigo:        Escribir("Hola Mundo")
        Java:                System.out.println("Hola Mundo!");

        Java requiere mas codigo por su naturaleza orientada a objetos,
        pero esto da ventajas en programas grandes y complejos.
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
