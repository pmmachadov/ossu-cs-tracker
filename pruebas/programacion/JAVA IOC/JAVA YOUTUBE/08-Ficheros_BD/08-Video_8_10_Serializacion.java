import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Video 8-10: Serialización de objetos
 *
 * Tema 8: Convertir el estado de un objeto a una secuencia
 * de bytes para almacenarlo en un fichero binario.
 *
 * URL: https://www.youtube.com/watch?v=p2zgGu4nOCc&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=181
 */
class Video_8_10_Serializacion {

    public static final String TITULO = "8-10 JAVA: Serialización ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=p2zgGu4nOCc&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=181";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-10 - SERIALIZACIÓN
        ================================================================

        La serializacion convierte el ESTADO de un objeto (valores
        de sus atributos) en una secuencia de bytes.

        Usos:
          - Almacenar objetos en ficheros binarios
          - Transmitir objetos por una red
          - Guardar objetos en bases de datos

        --- REQUISITO ---
        La clase debe implementar la interfaz Serializable.
        Es una interfaz de MARCADOR (no tiene metodos).
        Solo indica a la JVM que la clase puede ser serializada.

        --- SERIALIZAR (escribir) ---
        FileOutputStream fos = new FileOutputStream("archivo.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(objeto);   // cualquier objeto Serializable
        oos.close();

        --- DESERIALIZAR (leer) ---
        FileInputStream fis = new FileInputStream("archivo.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Grupo g = (Grupo) ois.readObject();  // casting obligatorio
        ois.close();

        --- EXCEPCIONES ---
        - IOException: problemas de entrada/salida
        - ClassNotFoundException: la clase no esta disponible

        --- IMPORTANTE ---
        - Los objetos se leen en el MISMO ORDEN que se escribieron
        - Si una clase contiene objetos de otra clase, ambas deben
          implementar Serializable
        - La serializacion es INSEGURA (evitar fuentes no confiables)
        - Alternativa mas segura: JSON
        ================================================================
        """;

    // ================================================================
    // CLASES PARA SERIALIZAR
    // ================================================================

    static class Alumno implements Serializable {
        private String nombre;
        private String nia;
        private int edad;

        public Alumno(String nombre, String nia, int edad) {
            this.nombre = nombre;
            this.nia = nia;
            this.edad = edad;
        }

        public String getNombre() { return nombre; }
        public String getNia() { return nia; }
        public int getEdad() { return edad; }

        @Override
        public String toString() {
            return "Alumno{nombre=" + nombre + ", nia=" + nia + ", edad=" + edad + "}";
        }
    }

    static class Grupo implements Serializable {
        private String nombre;
        private List<Alumno> alumnos = new ArrayList<>();

        public Grupo(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() { return nombre; }
        public List<Alumno> getAlumnos() { return alumnos; }

        public void agregarAlumno(Alumno a) {
            alumnos.add(a);
        }

        public void mostrarAlumnos() {
            for (Alumno a : alumnos) {
                System.out.println("    " + a);
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Grupo{nombre=").append(nombre).append("}\n");
            for (Alumno a : alumnos) {
                sb.append("  ").append(a).append("\n");
            }
            return sb.toString();
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: SERIALIZAR UN GRUPO CON ALUMNOS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 1: SERIALIZAR (escribir objeto)");
        System.out.println("=========================================");

        Grupo grupo = new Grupo("1 DAM");
        grupo.agregarAlumno(new Alumno("Pep", "1234A", 18));
        grupo.agregarAlumno(new Alumno("Tom", "5678B", 20));

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("grupo.dat"))) {

            oos.writeObject(grupo);
            System.out.println("  Grupo serializado en 'grupo.dat'");
            System.out.println("  Datos del grupo:");
            System.out.println("    Nombre: " + grupo.getNombre());
            System.out.println("    Alumnos:");
            grupo.mostrarAlumnos();
        } catch (IOException e) {
            System.out.println("  Error al serializar: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 2: DESERIALIZAR (leer objeto)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 2: DESERIALIZAR (leer objeto)");
        System.out.println("=========================================");

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("grupo.dat"))) {

            Grupo grupoLeido = (Grupo) ois.readObject();  // casting
            System.out.println("  Grupo deserializado de 'grupo.dat':");
            System.out.println("    Nombre: " + grupoLeido.getNombre());
            System.out.println("    Alumnos:");
            grupoLeido.mostrarAlumnos();
        } catch (FileNotFoundException e) {
            System.out.println("  Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("  Error de E/S: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("  Clase no encontrada: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 3: VARIOS OBJETOS DE DISTINTOS TIPOS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 3: VARIOS OBJETOS");
        System.out.println("=========================================");

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("varios.dat"))) {

            // Escribir un grupo
            Grupo g2 = new Grupo("2 DAM");
            g2.agregarAlumno(new Alumno("Ana", "1111C", 19));
            oos.writeObject(g2);

            // Escribir un entero
            oos.writeInt(23);

            // Escribir un alumno suelto
            oos.writeObject(new Alumno("John", "3333A", 20));

            System.out.println("  Escritos en 'varios.dat':");
            System.out.println("    1. Grupo (2 DAM)");
            System.out.println("    2. int (23)");
            System.out.println("    3. Alumno (John, 3333A, 20)");
        } catch (IOException e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // LEERLOS EN EL MISMO ORDEN
        System.out.println("  Leyendo 'varios.dat' (mismo orden):");
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("varios.dat"))) {

            Grupo gLeido = (Grupo) ois.readObject();
            int enteroLeido = ois.readInt();
            Alumno aLeido = (Alumno) ois.readObject();

            System.out.println("    1. Grupo: " + gLeido.getNombre());
            System.out.println("       Alumnos:");
            gLeido.mostrarAlumnos();
            System.out.println("    2. int: " + enteroLeido);
            System.out.println("    3. Alumno: " + aLeido);
        } catch (Exception e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  RESUMEN: SERIALIZACION");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  SERIALIZAR (escribir):");
        System.out.println("    FileOutputStream -> ObjectOutputStream");
        System.out.println("    oos.writeObject(objeto);");
        System.out.println();
        System.out.println("  DESERIALIZAR (leer):");
        System.out.println("    FileInputStream -> ObjectInputStream");
        System.out.println("    Grupo g = (Grupo) ois.readObject();");
        System.out.println("    // readObject() devuelve Object -> CASTING");
        System.out.println("    // Puede lanzar ClassNotFoundException");
        System.out.println();
        System.out.println("  REQUISITO: implements Serializable");
        System.out.println("    (interfaz de marcador, sin metodos)");
        System.out.println();
        System.out.println("  ORDEN: leer en el mismo orden que se escribio");
        System.out.println("  ANIDADAS: si Grupo contiene Alumno, ambos Serializable");

        System.out.println();
        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V10: SERIALIZACION)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Serializable: interfaz de marcador (sin metodos)");
        System.out.println("  - ObjectOutputStream.writeObject() para serializar");
        System.out.println("  - ObjectInputStream.readObject() para deserializar");
        System.out.println("  - readObject() devuelve Object -> casting obligatorio");
        System.out.println("  - readObject() lanza ClassNotFoundException");
        System.out.println("  - Leer en el MISMO ORDEN que se escribio");
        System.out.println("  - Si una clase contiene otra, ambas deben ser Serializable");
        System.out.println("  - Proximo video: java.nio (canales y buffers)");
    }
}
