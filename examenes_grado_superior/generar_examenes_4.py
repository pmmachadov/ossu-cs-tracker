# -*- coding: utf-8 -*-
"""
Generador de 5 exámenes NUEVOS (16-20) de Programación (Java) para Grado
Superior (1º DAW/DAM). Temas distintos de los exámenes 1-15:
  16 - Estructuras de datos dinámicas (pilas, colas, listas enlazadas)
  17 - Flujos de texto (Reader/Writer, try-with-resources)
  18 - Testing con JUnit y depuración
  19 - Patrones de diseño (Singleton, Factory, Observer, DAO, MVC)
  20 - Repaso integral (preguntas nuevas, sin repetir las de 1-10)

Reutiliza el renderizado (DOCX y PDF) de generar_examenes.py.

Uso:
  python generar_examenes_4.py            # DOCX y PDF de los exámenes 16-20
  python generar_examenes_4.py docx       # solo DOCX
  python generar_examenes_4.py pdf        # solo PDF
  python generar_examenes_4.py dark       # tema oscuro (junto con docx/pdf)
"""
import os
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

from generar_examenes import (  # noqa: E402
    ASIGNATURA,
    CURSO,
    DURACION,
    PDFExam,
    find_font,
    render_docx,
)

EXAMENES = []

# =====================================================================
# EXAMEN 16 — Estructuras de datos dinámicas: pilas, colas y listas
# =====================================================================
EXAMENES.append({
    "titulo": "EXAMEN DE PROGRAMACIÓN – 1º GRADO SUPERIOR",
    "subtitulo": "Examen 16 · Estructuras de datos dinámicas: pilas, colas y listas enlazadas",
    "temas": [
        "ArrayList vs LinkedList: costes de acceso e inserción",
        "Pilas (LIFO) y colas (FIFO): ArrayDeque y Deque",
        "Listas enlazadas: nodos, inserción y borrado",
        "Iteradores: Iterator, for-each y ConcurrentModificationException",
    ],
    "puntuacion": 16,
    "info": [("Convocatoria", "Evaluación 3"), ("Valoración", "Estructuras de datos dinámicas")],
    "secciones": [
        {
            "titulo": "Parte 1: Opción múltiple y Verdadero/Falso",
            "puntos": "5 puntos — 0,5 cada pregunta",
            "preguntas": [
                {
                    "tipo": "test",
                    "enunciado": "¿Qué clase de Java implementa una lista doblemente enlazada?",
                    "opciones": ["a) ArrayList", "b) LinkedList", "c) ArrayDeque", "d) Vector"],
                    "respuesta": "b) LinkedList — Está implementada como lista doblemente enlazada; cada nodo guarda referencia al anterior y al siguiente.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué estructura sigue el principio FIFO (primero en entrar, primero en salir)?",
                    "opciones": ["a) Pila", "b) Cola", "c) Lista", "d) Conjunto"],
                    "respuesta": "b) Cola — En una cola el primer elemento encolado es el primero en salir (FIFO).",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué estructura sigue el principio LIFO (último en entrar, primero en salir)?",
                    "opciones": ["a) Pila", "b) Cola", "c) Deque", "d) Vector"],
                    "respuesta": "a) Pila — En una pila el último elemento apilado es el primero en salir (LIFO).",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método de Deque añade un elemento al final de la estructura?",
                    "opciones": ["a) addLast()", "b) addFirst()", "c) push()", "d) insert()"],
                    "respuesta": "a) addLast() — Añade el elemento al final; addFirst() y push() lo añaden al principio.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método de Deque extrae y devuelve el primer elemento (comportamiento de cola)?",
                    "opciones": ["a) pollFirst()", "b) pop()", "c) peekLast()", "d) removeLast()"],
                    "respuesta": "a) pollFirst() — Extrae el primer elemento (o poll(), equivalente); pop() extrae del principio con comportamiento de pila.",
                },
                {
                    "tipo": "vf",
                    "enunciado": "ArrayList es más eficiente que LinkedList para accesos aleatorios por índice (get(i)).",
                    "respuesta": "Verdadero — ArrayList accede por índice en O(1) al estar respaldado por un array; LinkedList debe recorrer nodos hasta la posición (O(n)).",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué interfaz permite recorrer una colección con hasNext() y next()?",
                    "opciones": ["a) Iterator", "b) Iterable", "c) Enumerator", "d) Loopable"],
                    "respuesta": "a) Iterator — El bucle for-each usa internamente un Iterator sobre la colección (Iterable).",
                },
                {
                    "tipo": "vf",
                    "enunciado": "Modificar una lista con remove() mientras se recorre con for-each lanza ConcurrentModificationException.",
                    "respuesta": "Verdadero — El iterador interno detecta modificaciones estructurales; hay que usar iterator.remove() o copiar la lista.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método usa la clase Stack (java.util) para añadir un elemento encima?",
                    "opciones": ["a) push()", "b) addTop()", "c) insert()", "d) put()"],
                    "respuesta": "a) push() — Stack (clase legacy) usa push() para apilar y pop() para desapilar.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Cuál es la implementación recomendada de pila en Java moderno?",
                    "opciones": ["a) ArrayDeque", "b) Stack", "c) Vector", "d) ArrayList"],
                    "respuesta": "a) ArrayDeque — Más rápida que Stack (que es sincronizada y hereda de Vector) y no limitada por el tamaño del array.",
                },
            ],
        },
        {
            "titulo": "Parte 2: Análisis y depuración",
            "puntos": "3 puntos",
            "preguntas": [
                {
                    "tipo": "ejercicio",
                    "enunciado": "El siguiente código implementa una cola con ArrayList. ¿Qué problema de rendimiento tiene y cómo lo mejorarías?",
                    "puntos": "1,5 ptos",
                    "code": "import java.util.ArrayList;\\npublic class ColaConLista {\\n    private ArrayList<String> datos = new ArrayList<>();\\n    public void encolar(String s) { datos.add(s); }\\n    public String desencolar() {\\n        return datos.remove(0);\\n    }\\n}",
                    "respuesta": [
                        "Problema: datos.remove(0) desplaza todos los elementos una posición hacia la izquierda → O(n) por cada desencolado.",
                        "Con n operaciones el coste total es O(n²), inaceptable para colas grandes.",
                        "Solución: usar ArrayDeque<String> (o la interfaz Queue) con addLast()/pollFirst(), que operan en O(1) amortizado.",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "La siguiente pila usa un array fijo. ¿Qué ocurre al apilar más elementos de los permitidos y cómo se corrige?",
                    "puntos": "1,5 ptos",
                    "code": "public class PilaFija {\\n    private int[] datos = new int[10];\\n    private int tope = -1;\\n    public void push(int v) { datos[++tope] = v; }\\n    public int pop() { return datos[tope--]; }\\n}",
                    "respuesta": [
                        "Al apilar el elemento 11 se accede a datos[10], que está fuera del array (índices 0-9) → ArrayIndexOutOfBoundsException.",
                        "Además pop() sobre una pila vacía devuelve datos[-1] sin control.",
                        "Solución: usar ArrayDeque<Integer> (push/pop) o redimensionar el array manualmente (Arrays.copyOf) y comprobar tope antes de operar.",
                    ],
                },
            ],
        },
        {
            "titulo": "Parte 3: Ejercicios de programación",
            "puntos": "6 puntos",
            "preguntas": [
                {
                    "tipo": "ejercicio",
                    "enunciado": "Implementa una clase ColaClientes que gestione una cola de nombres con ArrayDeque: encolar(), desencolar() y mostrar() (recorrido sin vaciar). Crea un main de prueba.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.util.ArrayDeque;",
                        "import java.util.Deque;",
                        "public class ColaClientes {",
                        "    private Deque<String> cola = new ArrayDeque<>();",
                        "    public void encolar(String nombre) { cola.addLast(nombre); }",
                        "    public String desencolar() { return cola.pollFirst(); }",
                        "    public void mostrar() {",
                        "        for (String c : cola) System.out.println(c);",
                        "    }",
                        "    public static void main(String[] args) {",
                        "        ColaClientes c = new ColaClientes();",
                        "        c.encolar(\"Ana\"); c.encolar(\"Luis\"); c.encolar(\"Marta\");",
                        "        System.out.println(\"Atendido: \" + c.desencolar()); // Ana",
                        "        c.mostrar(); // Luis, Marta",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Escribe un programa que compruebe si una expresión con paréntesis (), corchetes [] y llaves {} está balanceada, usando una pila.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.util.ArrayDeque;",
                        "import java.util.Deque;",
                        "public class ParentesisBalanceados {",
                        "    static boolean balanceado(String expr) {",
                        "        Deque<Character> pila = new ArrayDeque<>();",
                        "        for (char c : expr.toCharArray()) {",
                        "            if (c == '(' || c == '[' || c == '{') pila.push(c);",
                        "            else if (c == ')' || c == ']' || c == '}') {",
                        "                if (pila.isEmpty()) return false;",
                        "                char apertura = pila.pop();",
                        "                if (!coinciden(apertura, c)) return false;",
                        "            }",
                        "        }",
                        "        return pila.isEmpty();",
                        "    }",
                        "    static boolean coinciden(char a, char c) {",
                        "        return (a == '(' && c == ')') || (a == '[' && c == ']') || (a == '{' && c == '}');",
                        "    }",
                        "    public static void main(String[] args) {",
                        "        System.out.println(balanceado(\"(a + b) * [c - {d}]\")); // true",
                        "        System.out.println(balanceado(\"(a + b]\"));             // false",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Implementa una lista enlazada simple propia: clase Nodo (valor y siguiente) y clase ListaEnlazada con métodos agregar(int) e imprimir().",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "class Nodo {",
                        "    int valor;",
                        "    Nodo siguiente;",
                        "    Nodo(int valor) { this.valor = valor; }",
                        "}",
                        "public class ListaEnlazada {",
                        "    private Nodo cabeza;",
                        "    public void agregar(int v) {",
                        "        Nodo nuevo = new Nodo(v);",
                        "        if (cabeza == null) { cabeza = nuevo; return; }",
                        "        Nodo actual = cabeza;",
                        "        while (actual.siguiente != null) actual = actual.siguiente;",
                        "        actual.siguiente = nuevo;",
                        "    }",
                        "    public void imprimir() {",
                        "        for (Nodo n = cabeza; n != null; n = n.siguiente)",
                        "            System.out.print(n.valor + \" \");",
                        "        System.out.println();",
                        "    }",
                        "    public static void main(String[] args) {",
                        "        ListaEnlazada l = new ListaEnlazada();",
                        "        l.agregar(3); l.agregar(7); l.agregar(1);",
                        "        l.imprimir(); // 3 7 1",
                        "    }",
                        "}",
                    ],
                },
            ],
        },
        {
            "titulo": "Parte 4: Pregunta teórica",
            "puntos": "2 puntos",
            "preguntas": [
                {
                    "tipo": "teorica",
                    "enunciado": "Compara ArrayList y LinkedList indicando en qué operaciones es mejor cada una. ¿Cuándo elegirías ArrayDeque?",
                    "respuesta": [
                        "ArrayList: acceso por índice O(1), inserción/borrado al final O(1) amortizado, pero insertar/borrar en el centro O(n) por el desplazamiento. Mejor para lecturas frecuentes por índice.",
                        "LinkedList: inserción/borrado en posiciones conocidas O(1) (si se tiene el nodo), pero acceso por índice O(n). Mejor para muchas inserciones/borrados al principio.",
                        "ArrayDeque: ideal para pilas y colas (push/pop, addFirst/addLast, pollFirst/pollLast) con O(1) amortizado, sin el coste de los nodos de LinkedList.",
                    ],
                },
            ],
        },
    ],
})

# =====================================================================
# EXAMEN 17 — Flujos de texto: Reader, Writer, Scanner y PrintWriter
# =====================================================================
EXAMENES.append({
    "titulo": "EXAMEN DE PROGRAMACIÓN – 1º GRADO SUPERIOR",
    "subtitulo": "Examen 17 · Flujos de texto: Reader, Writer y try-with-resources",
    "temas": [
        "Lectura de ficheros de texto: FileReader, BufferedReader, Scanner",
        "Escritura: FileWriter, BufferedWriter, PrintWriter",
        "try-with-resources y AutoCloseable",
        "Codificación de caracteres y NIO (Files.newBufferedReader)",
    ],
    "puntuacion": 16,
    "info": [("Convocatoria", "Evaluación 3"), ("Valoración", "Entrada/salida de texto")],
    "secciones": [
        {
            "titulo": "Parte 1: Opción múltiple y Verdadero/Falso",
            "puntos": "5 puntos — 0,5 cada pregunta",
            "preguntas": [
                {
                    "tipo": "test",
                    "enunciado": "¿Qué clase envuelve un FileReader para leer el fichero línea a línea con eficiencia?",
                    "opciones": ["a) BufferedReader", "b) DataInputStream", "c) ObjectReader", "d) LineReader"],
                    "respuesta": "a) BufferedReader — Añade un buffer de memoria y el método readLine(), evitando una lectura del disco por carácter.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método de BufferedReader lee una línea completa?",
                    "opciones": ["a) readLine()", "b) read()", "c) nextLine()", "d) line()"],
                    "respuesta": "a) readLine() — Devuelve la línea sin el salto de línea, o null cuando se llega al final del fichero.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué clase combina buffer y métodos print()/println() para escribir texto cómodamente?",
                    "opciones": ["a) PrintWriter", "b) FileWriter", "c) DataWriter", "d) BufferedOutput"],
                    "respuesta": "a) PrintWriter — Ofrece print()/println() sobre cualquier Writer y no lanza IOException en esos métodos.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué construcción cierra automáticamente los recursos al final del bloque?",
                    "opciones": ["a) try-with-resources", "b) try-catch normal", "c) finally manual", "d) try-alone"],
                    "respuesta": "a) try-with-resources — Declara los recursos entre paréntesis y los cierra automáticamente al salir del bloque.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué interfaz deben implementar los recursos usados en try-with-resources?",
                    "opciones": ["a) AutoCloseable", "b) Serializable", "c) Resource", "d) Disposable"],
                    "respuesta": "a) AutoCloseable — (o su subinterfaz Closeable). Sin ella el compilador rechaza el recurso.",
                },
                {
                    "tipo": "vf",
                    "enunciado": "FileWriter, por defecto, sobrescribe el contenido del fichero si ya existe.",
                    "respuesta": "Verdadero — Por defecto abre en modo escritura (trunca el fichero); hay que pasar el flag true al constructor para añadir al final (append).",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Cuál es la forma correcta de leer un fichero con Scanner?",
                    "opciones": ["a) new Scanner(new File(\"datos.txt\"))", "b) Scanner.readFile(\"datos.txt\")", "c) File.scanner(\"datos.txt\")", "d) Scanner.open(\"datos.txt\")"],
                    "respuesta": "a) new Scanner(new File(\"datos.txt\")) — Scanner acepta un File (o Path) y permite leer con nextLine(), nextInt(), etc.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué clase se recomienda para leer un fichero de texto con codificación explícita (p. ej. UTF-8)?",
                    "opciones": ["a) Files.newBufferedReader(path, StandardCharsets.UTF_8)", "b) new BufferedReader(new FileReader(path)) sin charset", "c) new DataReader(path)", "d) new TextFile(path)"],
                    "respuesta": "a) Files.newBufferedReader(path, charset) — Permite indicar la codificación; FileReader sin charset usa la codificación por defecto de la plataforma.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método de PrintWriter escribe sin salto de línea al final?",
                    "opciones": ["a) print()", "b) println()", "c) writeLine()", "d) newLineOnly()"],
                    "respuesta": "a) print() — Escribe el texto sin añadir salto de línea; println() lo añade.",
                },
                {
                    "tipo": "vf",
                    "enunciado": "Si no se cierra un BufferedWriter, parte del contenido puede quedarse en el buffer y no escribirse en el fichero.",
                    "respuesta": "Verdadero — Al cerrar (o hacer flush()) se vacía el buffer al disco; si el programa termina sin cerrar, puede perderse contenido.",
                },
            ],
        },
        {
            "titulo": "Parte 2: Análisis y depuración",
            "puntos": "3 puntos",
            "preguntas": [
                {
                    "tipo": "ejercicio",
                    "enunciado": "El siguiente código lee un fichero carácter a carácter. ¿Qué problemas tiene? Propón una versión mejorada.",
                    "puntos": "1,5 ptos",
                    "code": "import java.io.*;\\npublic class LeerLento {\\n    public static void main(String[] args) throws IOException {\\n        FileReader fr = new FileReader(\"datos.txt\");\\n        int c;\\n        while ((c = fr.read()) != -1) {\\n            System.out.print((char) c);\\n        }\\n    }\\n}",
                    "respuesta": [
                        "1. No se cierra el recurso: si ocurre una excepción, el FileReader queda abierto (fuga de recursos).",
                        "2. read() sin buffer hace una llamada al sistema por carácter → muy lento en ficheros grandes.",
                        "Solución: try-with-resources + BufferedReader y readLine():",
                        "try (BufferedReader br = new BufferedReader(new FileReader(\"datos.txt\"))) {",
                        "    String linea;",
                        "    while ((linea = br.readLine()) != null) System.out.println(linea);",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Este programa copia un fichero línea a línea pero pierde líneas. ¿Por qué? Corrígelo.",
                    "puntos": "1,5 ptos",
                    "code": "import java.io.*;\\npublic class CopiaBug {\\n    public static void main(String[] args) throws IOException {\\n        try (BufferedReader br = new BufferedReader(new FileReader(\"a.txt\"));\\n             PrintWriter pw = new PrintWriter(new FileWriter(\"b.txt\"))) {\\n            while (br.readLine() != null) {\\n                pw.println(br.readLine());\\n            }\\n        }\\n    }\\n}",
                    "respuesta": [
                        "El bucle llama a br.readLine() dos veces por iteración: una en la condición y otra dentro del cuerpo.",
                        "La primera línea se lee y se descarta (solo se comprueba que no es null), y la segunda se escribe.",
                        "Resultado: se pierden las líneas impares y la última línea puede escribirse como null.",
                        "Corrección: guardar la línea en una variable:",
                        "String linea;",
                        "while ((linea = br.readLine()) != null) { pw.println(linea); }",
                    ],
                },
            ],
        },
        {
            "titulo": "Parte 3: Ejercicios de programación",
            "puntos": "6 puntos",
            "preguntas": [
                {
                    "tipo": "ejercicio",
                    "enunciado": "Escribe un programa que lea un fichero notas.txt (formato: nombre;nota por línea) y muestre la nota media de la clase.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.io.*;",
                        "public class MediaNotas {",
                        "    public static void main(String[] args) {",
                        "        double suma = 0;",
                        "        int n = 0;",
                        "        try (BufferedReader br = new BufferedReader(new FileReader(\"notas.txt\"))) {",
                        "            String linea;",
                        "            while ((linea = br.readLine()) != null) {",
                        "                String[] partes = linea.split(\";\");",
                        "                suma += Double.parseDouble(partes[1].trim());",
                        "                n++;",
                        "            }",
                        "        } catch (IOException e) {",
                        "            e.printStackTrace();",
                        "        }",
                        "        System.out.println(\"Media: \" + (n > 0 ? suma / n : 0));",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Escribe un programa que genere un fichero tabla.txt con la tabla de multiplicar de un número leído por teclado, usando PrintWriter.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.io.*;",
                        "import java.util.Scanner;",
                        "public class TablaMultiplicar {",
                        "    public static void main(String[] args) {",
                        "        Scanner sc = new Scanner(System.in);",
                        "        System.out.print(\"Número: \");",
                        "        int n = sc.nextInt();",
                        "        try (PrintWriter pw = new PrintWriter(new FileWriter(\"tabla.txt\"))) {",
                        "            for (int i = 1; i <= 10; i++) {",
                        "                pw.println(n + \" x \" + i + \" = \" + (n * i));",
                        "            }",
                        "            System.out.println(\"Tabla escrita en tabla.txt\");",
                        "        } catch (IOException e) {",
                        "            e.printStackTrace();",
                        "        }",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Copia un fichero de texto línea a línea usando try-with-resources y Files.newBufferedReader con UTF-8. Si el fichero de origen no existe, muestra un mensaje sin romper el programa.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.nio.charset.StandardCharsets;",
                        "import java.nio.file.*;",
                        "import java.io.*;",
                        "public class CopiaTexto {",
                        "    public static void main(String[] args) {",
                        "        Path origen = Paths.get(\"origen.txt\");",
                        "        Path destino = Paths.get(\"copia.txt\");",
                        "        try (BufferedReader br = Files.newBufferedReader(origen, StandardCharsets.UTF_8);",
                        "             PrintWriter pw = new PrintWriter(Files.newBufferedWriter(destino, StandardCharsets.UTF_8))) {",
                        "            String linea;",
                        "            while ((linea = br.readLine()) != null) pw.println(linea);",
                        "            System.out.println(\"Copiado\");",
                        "        } catch (NoSuchFileException e) {",
                        "            System.out.println(\"El fichero de origen no existe\");",
                        "        } catch (IOException e) {",
                        "            e.printStackTrace();",
                        "        }",
                        "    }",
                        "}",
                    ],
                },
            ],
        },
        {
            "titulo": "Parte 4: Pregunta teórica",
            "puntos": "2 puntos",
            "preguntas": [
                {
                    "tipo": "teorica",
                    "enunciado": "Explica la diferencia entre flujos de bytes (InputStream/OutputStream) y flujos de caracteres (Reader/Writer). ¿Por qué conviene usar BufferedReader y PrintWriter?",
                    "respuesta": [
                        "Los flujos de bytes trabajan con datos binarios (byte a byte): sirven para imágenes, audio, objetos serializados, etc.",
                        "Los flujos de caracteres (Reader/Writer) traducen bytes a caracteres usando una codificación (UTF-8, ISO-8859-1...): adecuados para texto.",
                        "BufferedReader añade un buffer y readLine(), reduciendo las llamadas al disco de una por carácter a una por bloque.",
                        "PrintWriter ofrece print()/println() sobre Writer y no obliga a capturar IOException en cada escritura, simplificando el código de salida de texto.",
                    ],
                },
            ],
        },
    ],
})

# =====================================================================
# EXAMEN 18 — Testing con JUnit y depuración
# =====================================================================
EXAMENES.append({
    "titulo": "EXAMEN DE PROGRAMACIÓN – 1º GRADO SUPERIOR",
    "subtitulo": "Examen 18 · Testing con JUnit y depuración",
    "temas": [
        "JUnit 5: anotaciones @Test, @BeforeEach, @BeforeAll",
        "Assertions: assertEquals, assertTrue, assertThrows, assertSame",
        "Casos límite y calidad de los tests",
        "Depuración: stack traces, breakpoints y cobertura",
    ],
    "puntuacion": 16,
    "info": [("Convocatoria", "Evaluación 3"), ("Valoración", "Pruebas unitarias y depuración")],
    "secciones": [
        {
            "titulo": "Parte 1: Opción múltiple y Verdadero/Falso",
            "puntos": "5 puntos — 0,5 cada pregunta",
            "preguntas": [
                {
                    "tipo": "test",
                    "enunciado": "¿Qué anotación de JUnit 5 marca un método como test?",
                    "opciones": ["a) @Test", "b) @Run", "c) @TestCase", "d) @Check"],
                    "respuesta": "a) @Test — Los métodos anotados con @Test se ejecutan como pruebas unitarias.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método de Assertions compara un valor esperado con el real?",
                    "opciones": ["a) assertEquals(esperado, real)", "b) assertSame(esperado, real)", "c) assertEqual(esperado, real)", "d) compare(esperado, real)"],
                    "respuesta": "a) assertEquals(esperado, real) — Usa equals() para comparar; admite un mensaje opcional como tercer argumento.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué anotación ejecuta un método de inicialización antes de CADA test de la clase?",
                    "opciones": ["a) @BeforeEach", "b) @BeforeAll", "c) @Setup", "d) @Init"],
                    "respuesta": "a) @BeforeEach — Se ejecuta antes de cada @Test; @BeforeAll lo hace una sola vez antes de todos.",
                },
                {
                    "tipo": "vf",
                    "enunciado": "Los tests de una clase deben ser independientes entre sí: no deben depender del orden de ejecución ni del estado dejado por otro test.",
                    "respuesta": "Verdadero — Si un test depende de otro, fallará de forma intermitente; cada test debe preparar su propio estado (p. ej. con @BeforeEach).",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué assertion falla cuando la condición que recibe es falsa?",
                    "opciones": ["a) assertTrue(cond)", "b) assertFalse(cond)", "c) assertNull(x)", "d) assertSame(a, b)"],
                    "respuesta": "a) assertTrue(cond) — Falla si cond es false; assertFalse es la contraria.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Cómo se comprueba en JUnit 5 que un método lanza una excepción concreta?",
                    "opciones": ["a) assertThrows(Tipo.class, () -> metodo())", "b) try-catch manual siempre", "c) assertException(Tipo.class)", "d) @Expected(Tipo.class)"],
                    "respuesta": "a) assertThrows — Ejecuta el lambda y verifica que lanza la excepción indicada; además devuelve la excepción para inspeccionarla.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué assertion comprueba que dos variables apuntan a la MISMA referencia (no equivalentes)?",
                    "opciones": ["a) assertSame(a, b)", "b) assertEquals(a, b)", "c) assertIdentical(a, b)", "d) assertRef(a, b)"],
                    "respuesta": "a) assertSame(a, b) — Usa ==; assertEquals usa equals(). Para comparar contenido se usa assertEquals.",
                },
                {
                    "tipo": "vf",
                    "enunciado": "Un test sin ninguna assertion siempre pasa aunque el código probado esté mal.",
                    "respuesta": "Verdadero — Si no se aserta nada, JUnit solo comprueba que no haya excepciones; por eso todo test debe verificar resultados con assertions.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Por qué falla assertEquals(2.5, resultado) al comparar doubles?",
                    "opciones": ["a) Por la precisión binaria: hay que usar assertEquals(2.5, resultado, 0.001)", "b) Porque double no se puede comparar", "c) Porque assertEquals no acepta double", "d) No falla nunca"],
                    "respuesta": "a) Por la precisión binaria — Los doubles no siempre se representan exactamente; JUnit exige un delta (tercer argumento) en la comparación.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué anotación ejecuta código una sola vez ANTES de todos los tests de la clase?",
                    "opciones": ["a) @BeforeAll", "b) @BeforeEach", "c) @BeforeClass (JUnit 4)", "d) @SetupAll"],
                    "respuesta": "a) @BeforeAll (JUnit 5) — Se ejecuta una vez; el método debe ser static (o de instancia con @TestInstance(PER_CLASS)).",
                },
            ],
        },
        {
            "titulo": "Parte 2: Análisis y depuración",
            "puntos": "3 puntos",
            "preguntas": [
                {
                    "tipo": "ejercicio",
                    "enunciado": "Este test falla de forma intermitente. ¿Por qué y cómo se corrige?",
                    "puntos": "1,5 ptos",
                    "code": "import org.junit.jupiter.api.Test;\\nimport static org.junit.jupiter.api.Assertions.*;\\npublic class PrecioTest {\\n    @Test\\n    void iva() {\\n        double total = 100.0 * 1.21;\\n        assertEquals(121.0, total);\\n    }\\n}",
                    "respuesta": [
                        "100.0 * 1.21 no es exactamente 121.0 en binario: el resultado real es 120.99999999999999 (o similar).",
                        "assertEquals(double, double) sin delta falla por la precisión de coma flotante.",
                        "Corrección: assertEquals(121.0, total, 0.001); — el tercer argumento es la tolerancia (delta).",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "El siguiente test debería pasar pero falla. Depura el código de la clase probada.",
                    "puntos": "1,5 ptos",
                    "code": "public class Util {\\n    public static String iniciales(String nombre) {\\n        String[] partes = nombre.split(\" \");\\n        String res = \"\";\\n        for (int i = 0; i <= partes.length; i++) {\\n            res += partes[i].charAt(0);\\n        }\\n        return res;\\n    }\\n}\\n// Test:\\n// assertEquals(\"JL\", Util.iniciales(\"Juan Lopez\"));",
                    "respuesta": [
                        "El bucle usa i <= partes.length en lugar de i < partes.length: para \"Juan Lopez\" hay 2 partes (índices 0 y 1) y el bucle intenta acceder a partes[2].",
                        "Eso lanza ArrayIndexOutOfBoundsException (o StringIndexOutOfBounds si el array estuviera vacío), por lo que el test falla.",
                        "Corrección: for (int i = 0; i < partes.length; i++) { res += partes[i].charAt(0); }",
                    ],
                },
            ],
        },
        {
            "titulo": "Parte 3: Ejercicios de programación",
            "puntos": "6 puntos",
            "preguntas": [
                {
                    "tipo": "ejercicio",
                    "enunciado": "Escribe la clase Calculadora (suma, resta, divide) y su clase de test JUnit 5 que verifique: sumas, restas, división exacta y que dividir entre cero lanza IllegalArgumentException.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "public class Calculadora {",
                        "    public int suma(int a, int b) { return a + b; }",
                        "    public int resta(int a, int b) { return a - b; }",
                        "    public double divide(double a, double b) {",
                        "        if (b == 0) throw new IllegalArgumentException(\"División entre cero\");",
                        "        return a / b;",
                        "    }",
                        "}",
                        "// --- Test ---",
                        "import org.junit.jupiter.api.Test;",
                        "import static org.junit.jupiter.api.Assertions.*;",
                        "public class CalculadoraTest {",
                        "    private final Calculadora c = new Calculadora();",
                        "    @Test void sumas() { assertEquals(5, c.suma(2, 3)); }",
                        "    @Test void restas() { assertEquals(-1, c.resta(2, 3)); }",
                        "    @Test void divisionExacta() { assertEquals(2.5, c.divide(5, 2), 0.0001); }",
                        "    @Test void divisionEntreCero() {",
                        "        assertThrows(IllegalArgumentException.class, () -> c.divide(5, 0));",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Implementa la clase EsPalindromo (método estático esPalindromo(String)) y su test con casos límite: \"ana\" (true), \"Hola\" (false), cadena vacía (true), \"Ana\" ignorando mayúsculas (true).",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "public class EsPalindromo {",
                        "    public static boolean esPalindromo(String s) {",
                        "        if (s == null) return false;",
                        "        String limpio = s.toLowerCase().replace(\" \", \"\");",
                        "        return new StringBuilder(limpio).reverse().toString().equals(limpio);",
                        "    }",
                        "}",
                        "// --- Test ---",
                        "import org.junit.jupiter.api.Test;",
                        "import static org.junit.jupiter.api.Assertions.*;",
                        "public class EsPalindromoTest {",
                        "    @Test void casos() {",
                        "        assertTrue(EsPalindromo.esPalindromo(\"ana\"));",
                        "        assertFalse(EsPalindromo.esPalindromo(\"hola\"));",
                        "        assertTrue(EsPalindromo.esPalindromo(\"\"));",
                        "        assertTrue(EsPalindromo.esPalindromo(\"Ana\"));",
                        "        assertFalse(EsPalindromo.esPalindromo(null));",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Escribe una clase ListaTareas con @BeforeEach que inicialice una lista vacía, y tests que verifiquen añadir, eliminar y contar elementos.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.util.ArrayList;",
                        "import java.util.List;",
                        "public class ListaTareas {",
                        "    private final List<String> tareas = new ArrayList<>();",
                        "    public void anadir(String t) { tareas.add(t); }",
                        "    public boolean eliminar(String t) { return tareas.remove(t); }",
                        "    public int contar() { return tareas.size(); }",
                        "}",
                        "// --- Test ---",
                        "import org.junit.jupiter.api.BeforeEach;",
                        "import org.junit.jupiter.api.Test;",
                        "import static org.junit.jupiter.api.Assertions.*;",
                        "public class ListaTareasTest {",
                        "    private ListaTareas lista;",
                        "    @BeforeEach void setUp() { lista = new ListaTareas(); }",
                        "    @Test void anadirIncrementa() {",
                        "        lista.anadir(\"Estudiar\");",
                        "        assertEquals(1, lista.contar());",
                        "    }",
                        "    @Test void eliminarFunciona() {",
                        "        lista.anadir(\"Estudiar\");",
                        "        assertTrue(lista.eliminar(\"Estudiar\"));",
                        "        assertEquals(0, lista.contar());",
                        "    }",
                        "    @Test void eliminarInexistente() {",
                        "        assertFalse(lista.eliminar(\"No existe\"));",
                        "    }",
                        "}",
                    ],
                },
            ],
        },
        {
            "titulo": "Parte 4: Pregunta teórica",
            "puntos": "2 puntos",
            "preguntas": [
                {
                    "tipo": "teorica",
                    "enunciado": "¿Qué es la cobertura de código? ¿Un 100 % de cobertura garantiza que el programa no tiene errores? Razona la respuesta.",
                    "respuesta": [
                        "La cobertura mide el porcentaje de código (líneas, ramas o condiciones) que ejecutan los tests.",
                        "Un 100 % de cobertura NO garantiza ausencia de errores: los tests pueden ejecutar el código sin verificar resultados correctos, o no probar valores límite, entradas inesperadas o condiciones de carrera.",
                        "La cobertura es una herramienta de calidad útil (detecta código sin probar), pero la clave está en la calidad de las assertions y en probar casos límite.",
                    ],
                },
            ],
        },
    ],
})

# =====================================================================
# EXAMEN 19 — Patrones de diseño: Singleton, Factory, Observer, DAO y MVC
# =====================================================================
EXAMENES.append({
    "titulo": "EXAMEN DE PROGRAMACIÓN – 1º GRADO SUPERIOR",
    "subtitulo": "Examen 19 · Patrones de diseño: Singleton, Factory, Observer, DAO y MVC",
    "temas": [
        "Singleton: propósito, implementación thread-safe y críticas",
        "Factory Method y creación de objetos",
        "Observer: sujeto y observadores desacoplados",
        "DAO y MVC: separación de responsabilidades",
    ],
    "puntuacion": 16,
    "info": [("Convocatoria", "Evaluación 3"), ("Valoración", "Patrones de diseño")],
    "secciones": [
        {
            "titulo": "Parte 1: Opción múltiple y Verdadero/Falso",
            "puntos": "5 puntos — 0,5 cada pregunta",
            "preguntas": [
                {
                    "tipo": "test",
                    "enunciado": "¿Qué patrón garantiza que una clase tenga una única instancia en toda la aplicación?",
                    "opciones": ["a) Singleton", "b) Factory", "c) Observer", "d) Adapter"],
                    "respuesta": "a) Singleton — Controla la creación para que solo exista una instancia, accesible globalmente (getInstance()).",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué patrón crea objetos sin que el cliente conozca la clase concreta?",
                    "opciones": ["a) Factory Method", "b) Singleton", "c) Observer", "d) Iterator"],
                    "respuesta": "a) Factory Method — Centraliza la creación en un método que decide qué clase concreta instanciar según un parámetro o condición.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué patrón notifica automáticamente a varios objetos cuando otro cambia de estado?",
                    "opciones": ["a) Observer", "b) Strategy", "c) Proxy", "d) Decorator"],
                    "respuesta": "a) Observer — El sujeto mantiene una lista de observadores y los notifica sin conocer sus clases concretas.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué patrón separa la lógica de negocio, la interfaz de usuario y los datos en tres componentes?",
                    "opciones": ["a) MVC", "b) DAO", "c) Singleton", "d) Facade"],
                    "respuesta": "a) MVC (Modelo-Vista-Controlador) — El modelo gestiona los datos, la vista los muestra y el controlador gestiona las acciones del usuario.",
                },
                {
                    "tipo": "vf",
                    "enunciado": "El constructor de una clase Singleton suele ser privado para impedir que se creen instancias desde fuera.",
                    "respuesta": "Verdadero — El constructor privado fuerza a usar getInstance(), que controla la creación de la única instancia.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué patrón encapsula el acceso a la base de datos separándolo de la lógica de negocio?",
                    "opciones": ["a) DAO", "b) MVC", "c) Factory", "d) Template"],
                    "respuesta": "a) DAO (Data Access Object) — Aísla las operaciones de persistencia (INSERT, SELECT...) en una clase dedicada.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método expone normalmente un Singleton?",
                    "opciones": ["a) getInstance()", "b) newInstance()", "c) create()", "d) instance()"],
                    "respuesta": "a) getInstance() — Devuelve la instancia única, creándola la primera vez si no existe.",
                },
                {
                    "tipo": "vf",
                    "enunciado": "En el patrón Observer, el sujeto conoce las clases concretas de sus observadores.",
                    "respuesta": "Falso — El sujeto solo conoce la interfaz Observador (o un Consumer), lo que desacopla ambas partes.",
                },
                {
                    "tipo": "test",
                    "enunciado": "En MVC, ¿qué componente gestiona las acciones del usuario (clics, teclado)?",
                    "opciones": ["a) Controlador", "b) Modelo", "c) Vista", "d) DAO"],
                    "respuesta": "a) Controlador — Recibe las acciones del usuario, modifica el modelo y actualiza la vista.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué patrón permite añadir responsabilidades a un objeto en tiempo de ejecución sin modificar su clase?",
                    "opciones": ["a) Decorator", "b) Singleton", "c) Factory", "d) Template Method"],
                    "respuesta": "a) Decorator — Envuelve el objeto con otro que añade comportamiento (p. ej. BufferedReader envuelve a FileReader).",
                },
            ],
        },
        {
            "titulo": "Parte 2: Análisis y depuración",
            "puntos": "3 puntos",
            "preguntas": [
                {
                    "tipo": "ejercicio",
                    "enunciado": "Este Singleton no es seguro para hilos. Explica qué puede ocurrir y cómo corregirlo.",
                    "puntos": "1,5 ptos",
                    "code": "public class Configuracion {\\n    private static Configuracion instancia;\\n    public String idioma = \"es\";\\n    private Configuracion() { }\\n    public static Configuracion getInstance() {\\n        if (instancia == null) {\\n            instancia = new Configuracion();\\n        }\\n        return instancia;\\n    }\\n}",
                    "respuesta": [
                        "Problema: si dos hilos llaman a getInstance() a la vez y ambos ven instancia == null, cada uno crea su propia instancia → se rompe la unicidad.",
                        "Además el campo idioma es público (rompe el encapsulamiento): debería ser private con getter/setter.",
                        "Corrección (doble comprobación):",
                        "private static volatile Configuracion instancia;",
                        "public static Configuracion getInstance() {",
                        "    if (instancia == null) {",
                        "        synchronized (Configuracion.class) {",
                        "            if (instancia == null) instancia = new Configuracion();",
                        "        }",
                        "    }",
                        "    return instancia;",
                        "}",
                        "O más simple: usar un enum (enum Configuracion { INSTANCIA }) o inicialización estática.",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "El siguiente método fábrica tiene un problema de mantenimiento. Identifícalo y propón una mejora.",
                    "puntos": "1,5 ptos",
                    "code": "public class Notificador {\\n    public void enviar(String tipo, String mensaje) {\\n        if (tipo.equals(\"email\")) {\\n            System.out.println(\"Enviando email: \" + mensaje);\\n        } else if (tipo.equals(\"sms\")) {\\n            System.out.println(\"Enviando SMS: \" + mensaje);\\n        } else if (tipo.equals(\"push\")) {\\n            System.out.println(\"Enviando push: \" + mensaje);\\n        }\\n    }\\n}",
                    "respuesta": [
                        "Problema: el método crece con cada nuevo canal (cadenas if-else) y mezcla la decisión de creación con el envío; viola el principio abierto/cerrado.",
                        "Mejora: Factory Method que devuelve una interfaz Canal con su implementación:",
                        "interface Canal { void enviar(String msg); }",
                        "class Email implements Canal { public void enviar(String m) { System.out.println(\"Email: \" + m); } }",
                        "class SMS implements Canal { public void enviar(String m) { System.out.println(\"SMS: \" + m); } }",
                        "static Canal crear(String tipo) {",
                        "    switch (tipo) {",
                        "        case \"email\": return new Email();",
                        "        case \"sms\": return new SMS();",
                        "        default: throw new IllegalArgumentException(\"Canal desconocido: \" + tipo);",
                        "    }",
                        "}",
                        "Añadir un canal nuevo solo requiere una clase nueva y un case.",
                    ],
                },
            ],
        },
        {
            "titulo": "Parte 3: Ejercicios de programación",
            "puntos": "6 puntos",
            "preguntas": [
                {
                    "tipo": "ejercicio",
                    "enunciado": "Implementa un Singleton Logger thread-safe (doble comprobación) con método log(String) que imprima con marca de tiempo, y úsalo desde dos puntos del programa.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.time.LocalTime;",
                        "public class Logger {",
                        "    private static volatile Logger instancia;",
                        "    private Logger() { }",
                        "    public static Logger getInstance() {",
                        "        if (instancia == null) {",
                        "            synchronized (Logger.class) {",
                        "                if (instancia == null) instancia = new Logger();",
                        "            }",
                        "        }",
                        "        return instancia;",
                        "    }",
                        "    public void log(String msg) {",
                        "        System.out.println(\"[\" + LocalTime.now() + \"] \" + msg);",
                        "    }",
                        "    public static void main(String[] args) {",
                        "        Logger l1 = Logger.getInstance();",
                        "        Logger l2 = Logger.getInstance();",
                        "        System.out.println(l1 == l2); // true: misma instancia",
                        "        l1.log(\"Iniciando\");",
                        "        l2.log(\"Finalizando\");",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Implementa el patrón Observer: una clase Noticias (sujeto) con suscribir()/publicar(), y una clase Suscriptor que recibe las noticias. Demuestra el funcionamiento con dos suscriptores.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.util.ArrayList;",
                        "import java.util.List;",
                        "interface Observador { void recibir(String noticia); }",
                        "class Noticias {",
                        "    private final List<Observador> suscriptores = new ArrayList<>();",
                        "    public void suscribir(Observador o) { suscriptores.add(o); }",
                        "    public void publicar(String noticia) {",
                        "        for (Observador o : suscriptores) o.recibir(noticia);",
                        "    }",
                        "}",
                        "class Suscriptor implements Observador {",
                        "    private final String nombre;",
                        "    Suscriptor(String nombre) { this.nombre = nombre; }",
                        "    public void recibir(String noticia) {",
                        "        System.out.println(nombre + \" recibió: \" + noticia);",
                        "    }",
                        "}",
                        "public class DemoObserver {",
                        "    public static void main(String[] args) {",
                        "        Noticias n = new Noticias();",
                        "        n.suscribir(new Suscriptor(\"Ana\"));",
                        "        n.suscribir(new Suscriptor(\"Luis\"));",
                        "        n.publicar(\"Notas publicadas\");",
                        "        // Ana recibió: Notas publicadas",
                        "        // Luis recibió: Notas publicadas",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Diseña un DAO para una clase Alumno (id, nombre, nota): interfaz AlumnoDAO con insertar() y listar(), e implementación AlumnoDAOMemoria con una lista. Escribe también un pequeño uso de ejemplo.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.util.ArrayList;",
                        "import java.util.List;",
                        "class Alumno {",
                        "    int id; String nombre; double nota;",
                        "    Alumno(int id, String nombre, double nota) {",
                        "        this.id = id; this.nombre = nombre; this.nota = nota;",
                        "    }",
                        "    public String toString() { return id + \" - \" + nombre + \" (\" + nota + \")\"; }",
                        "}",
                        "interface AlumnoDAO {",
                        "    void insertar(Alumno a);",
                        "    List<Alumno> listar();",
                        "}",
                        "class AlumnoDAOMemoria implements AlumnoDAO {",
                        "    private final List<Alumno> datos = new ArrayList<>();",
                        "    public void insertar(Alumno a) { datos.add(a); }",
                        "    public List<Alumno> listar() { return datos; }",
                        "}",
                        "public class DemoDAO {",
                        "    public static void main(String[] args) {",
                        "        AlumnoDAO dao = new AlumnoDAOMemoria();",
                        "        dao.insertar(new Alumno(1, \"Ana\", 8.5));",
                        "        dao.insertar(new Alumno(2, \"Luis\", 6.0));",
                        "        for (Alumno a : dao.listar()) System.out.println(a);",
                        "    }",
                        "}",
                    ],
                },
            ],
        },
        {
            "titulo": "Parte 4: Pregunta teórica",
            "puntos": "2 puntos",
            "preguntas": [
                {
                    "tipo": "teorica",
                    "enunciado": "Ventajas e inconvenientes de Singleton. ¿Cuándo lo usarías y cuándo lo evitarías?",
                    "respuesta": [
                        "Ventajas: instancia única garantizada (configuración, log, pool de conexiones), acceso global cómodo, creación perezosa.",
                        "Inconvenientes: introduce estado global (dificulta los tests, que deben poder aislar/restablecer el estado), acopla el código a la clase concreta, y en entornos multihilo exige sincronización.",
                        "Usar: recursos compartidos de toda la aplicación (logger, configuración). Evitar: cuando basta inyección de dependencias o cuando la 'unicidad' no es un requisito real del dominio.",
                    ],
                },
            ],
        },
    ],
})

# =====================================================================
# EXAMEN 20 — Repaso integral (preguntas nuevas)
# =====================================================================
EXAMENES.append({
    "titulo": "EXAMEN DE PROGRAMACIÓN – 1º GRADO SUPERIOR",
    "subtitulo": "Examen 20 · Repaso integral de Java",
    "temas": [
        "Repaso de fundamentos, POO, colecciones y streams",
        "Ficheros, excepciones y Optional",
        "Hilos, JDBC y Swing a nivel básico",
        "Ordenación, búsqueda y estructuras dinámicas",
    ],
    "puntuacion": 16,
    "info": [("Convocatoria", "Final"), ("Valoración", "Examen final de repaso")],
    "secciones": [
        {
            "titulo": "Parte 1: Opción múltiple y Verdadero/Falso",
            "puntos": "5 puntos — 0,5 cada pregunta",
            "preguntas": [
                {
                    "tipo": "test",
                    "enunciado": "¿Qué devuelve \"Hola\".substring(1, 3)?",
                    "opciones": ["a) \"ol\"", "b) \"ola\"", "c) \"Ho\"", "d) \"lo\""],
                    "respuesta": "a) \"ol\" — substring(inicio, fin) toma los caracteres desde el índice 1 (incluido) hasta el 3 (excluido): 'o' y 'l'.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué ocurre al ejecutar List.of(1, 2, 3).add(4)?",
                    "opciones": ["a) UnsupportedOperationException", "b) Se añade el 4", "c) NullPointerException", "d) ArrayIndexOutOfBoundsException"],
                    "respuesta": "a) UnsupportedOperationException — List.of() devuelve una lista inmutable; no permite add/remove/set.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Cuál es el resultado de la expresión 5 % 2?",
                    "opciones": ["a) 1", "b) 2", "c) 2.5", "d) 0"],
                    "respuesta": "a) 1 — % es el operador módulo (resto de la división entera): 5 entre 2 da cociente 2 y resto 1.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué clase se recomienda para concatenar muchas cadenas dentro de un bucle?",
                    "opciones": ["a) StringBuilder", "b) String con +", "c) StringBuffer solo en un hilo", "d) char[]"],
                    "respuesta": "a) StringBuilder — Cada + crea un String nuevo (O(n²) en bucles); StringBuilder muta el buffer en O(1) amortizado por append.",
                },
                {
                    "tipo": "test",
                    "enunciado": "En try-with-resources, si el cuerpo lanza una excepción y el cierre del recurso también, ¿qué ocurre?",
                    "opciones": ["a) Se lanza la del cuerpo y la del cierre se añade como suprimida (addSuppressed)", "b) Se lanza la del cierre", "c) Se lanzan ambas como RuntimeException", "d) No se lanza ninguna"],
                    "respuesta": "a) Se lanza la excepción del cuerpo y la del cierre se registra como suprimida — accesible con getSuppressed().",
                },
                {
                    "tipo": "vf",
                    "enunciado": "Un método static puede invocarse sin crear una instancia de su clase.",
                    "respuesta": "Verdadero — Los miembros static pertenecen a la clase, no a los objetos; se invocan con NombreClase.metodo().",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Cuánto suma IntStream.range(1, 4).sum()?",
                    "opciones": ["a) 6", "b) 10", "c) 3", "d) 7"],
                    "respuesta": "a) 6 — range(1, 4) genera 1, 2, 3 (el fin se excluye) y su suma es 6.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método de Map devuelve un valor por defecto si la clave no existe?",
                    "opciones": ["a) getOrDefault(clave, defecto)", "b) getOrNull(clave)", "c) get(clave)", "d) valueOrDefault(clave)"],
                    "respuesta": "a) getOrDefault(clave, defecto) — Devuelve el valor asociado o el defecto si la clave no está en el mapa.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué excepción lanza Integer.parseInt(\"abc\")?",
                    "opciones": ["a) NumberFormatException", "b) IOException", "c) ParseException", "d) ClassCastException"],
                    "respuesta": "a) NumberFormatException — Es una RuntimeException lanzada cuando la cadena no representa un entero válido.",
                },
                {
                    "tipo": "vf",
                    "enunciado": "Los records de Java generan automáticamente equals(), hashCode() y toString() basados en sus componentes.",
                    "respuesta": "Verdadero — Un record declara los campos en el encabezado y el compilador genera el constructor canónico, acceso, equals, hashCode y toString.",
                },
            ],
        },
        {
            "titulo": "Parte 2: Análisis y depuración",
            "puntos": "3 puntos",
            "preguntas": [
                {
                    "tipo": "ejercicio",
                    "enunciado": "El siguiente código calcula un valor por defecto pero se ejecuta más de lo necesario. ¿Por qué? ¿Cómo se corrige?",
                    "puntos": "1,5 ptos",
                    "code": "import java.util.Optional;\\npublic class Defecto {\\n    static String caro() {\\n        System.out.println(\"Calculando...\");\\n        return \"valor caro\";\\n    }\\n    public static void main(String[] args) {\\n        Optional<String> opt = Optional.of(\"presente\");\\n        System.out.println(opt.orElse(caro()));\\n    }\\n}",
                    "respuesta": [
                        "orElse(valor) evalúa el argumento SIEMPRE, aunque el Optional tenga valor: se imprime 'Calculando...' sin necesidad.",
                        "El coste es doble: cálculo inútil (y efectos secundarios visibles).",
                        "Corrección: orElseGet(() -> caro()) — el Supplier solo se ejecuta cuando el Optional está vacío:",
                        "System.out.println(opt.orElseGet(Defecto::caro)); // no imprime 'Calculando...'",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Este código lanza ConcurrentModificationException. ¿Por qué y cómo se arregla?",
                    "puntos": "1,5 ptos",
                    "code": "import java.util.*;\\npublic class FiltroLista {\\n    public static void main(String[] args) {\\n        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5));\\n        for (Integer n : nums) {\\n            if (n % 2 == 0) nums.remove(n);\\n        }\\n        System.out.println(nums);\\n    }\\n}",
                    "respuesta": [
                        "El for-each usa un Iterator interno; nums.remove() modifica estructuralmente la lista mientras se itera.",
                        "El iterador detecta la modificación y lanza ConcurrentModificationException.",
                        "Soluciones:",
                        "1) Iterator explícito:",
                        "Iterator<Integer> it = nums.iterator();",
                        "while (it.hasNext()) { if (it.next() % 2 == 0) it.remove(); }",
                        "2) O filtrar con streams: nums.removeIf(n -> n % 2 == 0);",
                    ],
                },
            ],
        },
        {
            "titulo": "Parte 3: Ejercicios de programación",
            "puntos": "6 puntos",
            "preguntas": [
                {
                    "tipo": "ejercicio",
                    "enunciado": "Usando streams, escribe un método que reciba una lista de palabras y devuelva la palabra más larga (o cadena vacía si la lista es vacía).",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.util.*;",
                        "public class PalabraMasLarga {",
                        "    static String masLarga(List<String> palabras) {",
                        "        return palabras.stream()",
                        "                .max(Comparator.comparingInt(String::length))",
                        "                .orElse(\"\");",
                        "    }",
                        "    public static void main(String[] args) {",
                        "        List<String> lista = List.of(\"java\", \"programacion\", \"hola\", \"a\");",
                        "        System.out.println(masLarga(lista)); // programacion",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Escribe un programa que lea un fichero numeros.txt (un entero por línea) y muestre la suma y el máximo usando Files.lines y streams.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.nio.file.*;",
                        "import java.io.IOException;",
                        "public class SumaFichero {",
                        "    public static void main(String[] args) {",
                        "        try (var lineas = Files.lines(Paths.get(\"numeros.txt\"))) {",
                        "            var nums = lineas.filter(l -> !l.isBlank()).mapToInt(Integer::parseInt);",
                        "            System.out.println(\"Suma: \" + nums.sum());",
                        "        } catch (IOException e) {",
                        "            e.printStackTrace();",
                        "        }",
                        "    }",
                        "}",
                        "Nota: el stream de Files.lines se cierra con try-with-resources.",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Define la clase Libro (titulo, autor, paginas) con constructor y getters, y usando streams: ordena una lista por páginas ascendente y muestra solo los libros de más de 300 páginas.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.util.*;",
                        "public class Libro {",
                        "    private final String titulo;",
                        "    private final String autor;",
                        "    private final int paginas;",
                        "    public Libro(String titulo, String autor, int paginas) {",
                        "        this.titulo = titulo; this.autor = autor; this.paginas = paginas;",
                        "    }",
                        "    public String getTitulo() { return titulo; }",
                        "    public int getPaginas() { return paginas; }",
                        "    public String toString() { return titulo + \" (\" + paginas + \"p)\"; }",
                        "    public static void main(String[] args) {",
                        "        List<Libro> libros = List.of(",
                        "            new Libro(\"A\", \"X\", 450),",
                        "            new Libro(\"B\", \"Y\", 250),",
                        "            new Libro(\"C\", \"Z\", 600));",
                        "        libros.stream()",
                        "              .filter(l -> l.getPaginas() > 300)",
                        "              .sorted(Comparator.comparingInt(Libro::getPaginas))",
                        "              .forEach(System.out::println);",
                        "        // A (450p), C (600p)",
                        "    }",
                        "}",
                    ],
                },
            ],
        },
        {
            "titulo": "Parte 4: Pregunta teórica",
            "puntos": "2 puntos",
            "preguntas": [
                {
                    "tipo": "teorica",
                    "enunciado": "Compara Optional.orElse(valor) y Optional.orElseGet(supplier). ¿Cuándo usarías cada uno? Pon un ejemplo.",
                    "respuesta": [
                        "orElse(valor) recibe el valor ya calculado y lo evalúa SIEMPRE, aunque el Optional no esté vacío.",
                        "orElseGet(supplier) recibe una función que solo se ejecuta si el Optional está vacío.",
                        "Usar orElseGet cuando el valor por defecto es caro de calcular o tiene efectos secundarios (consultas, logs, creación de objetos pesados).",
                        "Ejemplo: opt.orElseGet(() -> cargarDeBD()) evita la consulta cuando el valor ya existe; opt.orElse(\"desconocido\") es correcto para constantes baratas.",
                    ],
                },
            ],
        },
    ],
})

# =====================================================================
# GENERACIÓN (misma lógica que generar_examenes_2.py, exámenes 16-20)
# =====================================================================

def main():
    out_dir = os.path.dirname(os.path.abspath(__file__))
    args = sys.argv[1:] if len(sys.argv) > 1 else ["docx", "pdf"]
    want_docx = "docx" in args
    want_pdf = "pdf" in args
    dark = "dark" in args or "oscuro" in args

    print("Fuente Unicode disponible:", bool(find_font("arial.ttf")))
    print("Modo PDF:", "OSCURO" if dark else "claro")

    for i, ex in enumerate(EXAMENES, start=16):
        nombre = f"Examen_{i}_Java_{ex['subtitulo'].split('·')[-1].strip().replace(' ','_')}"
        for c in ':;*?"<>|':
            nombre = nombre.replace(c, "-")
        nombre = nombre.replace("/", "-").replace("\\", "-")[:80]
        base = os.path.join(out_dir, nombre)
        print(f"\n=== Examen {i}: {ex['subtitulo']} ===")

        if want_docx:
            path = base + ".docx"
            try:
                render_docx(ex, path, dark=dark)
                print("   DOCX OK:", os.path.basename(path))
            except Exception as e:
                print("   DOCX ERROR:", e)

        if want_pdf:
            path = base + ".pdf"
            try:
                PDFExam(ex, dark=dark).build(path)
                print("   PDF  OK:", os.path.basename(path))
            except Exception as e:
                import traceback
                print("   PDF  ERROR:", e)
                traceback.print_exc()

    print("\nFinalizado.")


if __name__ == "__main__":
    main()
