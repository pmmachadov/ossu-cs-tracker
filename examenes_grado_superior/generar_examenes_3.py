# -*- coding: utf-8 -*-
"""
Generador de 5 exámenes NUEVOS (11-15) de Programación (Java) para Grado
Superior (1º DAW/DAM). Temas distintos de los exámenes 1-10:
  * Examen 11 — Hilos y programación concurrente
  * Examen 12 — JDBC y bases de datos
  * Examen 13 — Swing y eventos de interfaz gráfica
  * Examen 14 — Expresiones regulares y procesamiento de texto
  * Examen 15 — Ordenación y búsqueda: algoritmos y complejidad

Reutiliza el renderizado (DOCX + PDF) de generar_examenes.py, incluida la
paleta clara/oscura y los 6 espacios antes del bloque RESPUESTA / SOLUCIÓN.

Uso:
  python generar_examenes_3.py            # genera DOCX y PDF (modo claro)
  python generar_examenes_3.py docx pdf dark
"""
import os
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

from generar_examenes import (  # noqa: E402
    render_docx,
    PDFExam,
    find_font,
)

EXAMENES = []

# =====================================================================
# EXAMEN 11 — Hilos y programación concurrente
# =====================================================================
EXAMENES.append({
    "titulo": "EXAMEN DE PROGRAMACIÓN – 1º GRADO SUPERIOR",
    "subtitulo": "Examen 11 · Hilos y programación concurrente",
    "temas": [
        "Creación de hilos: Thread, Runnable y expresiones lambda",
        "Sincronización: synchronized, monitores y visibilidad (volatile)",
        "Coordinación: sleep, join, wait/notify",
        "java.util.concurrent: ExecutorService, Future y pools de hilos",
        "Problemas clásicos: condición de carrera y deadlock",
    ],
    "puntuacion": 16,
    "info": [("Convocatoria", "Evaluación 3"), ("Valoración", "Concurrencia en Java")],
    "secciones": [
        {
            "titulo": "Parte 1: Opción múltiple y Verdadero/Falso",
            "puntos": "5 puntos — 0,5 cada pregunta",
            "preguntas": [
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método pone en marcha un hilo nuevo?",
                    "opciones": ["a) run()", "b) start()", "c) execute()", "d) begin()"],
                    "respuesta": "b) start() — Crea el hilo del sistema y ejecuta run() en él. Llamar a run() directamente lo ejecuta en el hilo actual.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Cuál de estas expresiones crea correctamente un hilo con una lambda?",
                    "opciones": [
                        "a) new Thread(() -> System.out.println(\"Hola\"));",
                        "b) new Thread(\"Hola\");",
                        "c) Thread.start(() -> System.out.println(\"Hola\"));",
                        "d) new Runnable(() -> System.out.println(\"Hola\"));",
                    ],
                    "respuesta": "a) new Thread(() -> ...) — Runnable es una interfaz funcional, por lo que la lambda es válida como argumento del constructor de Thread.",
                },
                {
                    "tipo": "vf",
                    "enunciado": "Llamar directamente a run() sobre un objeto Thread lanza el código en un hilo nuevo en paralelo.",
                    "respuesta": "Falso — run() invocado directamente se ejecuta de forma síncrona en el hilo que lo llama. Para ejecutarlo en paralelo hay que usar start().",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué palabra clave impide que dos hilos entren a la vez en un método?",
                    "opciones": ["a) volatile", "b) synchronized", "c) locked", "d) atomic"],
                    "respuesta": "b) synchronized — Serializa el acceso al método o bloque de código. Solo un hilo a la vez puede adquirir el \"monitor\" (lock intrínseco) del objeto; los demás hilos esperan en cola hasta que se libere.\n\n💡 ¿Por qué es fundamental?\nSin `synchronized`, operaciones no atómicas como `contador++` (leer valor -> sumar 1 -> guardar) sufren **condiciones de carrera** (*race conditions*) y se pierden incrementos si varios hilos acceden a la vez.\n\n💻 Ejemplo práctico de Contador Seguro:\n\n```java\nclass ContadorSeguro {\n    private int valor = 0;\n\n    // Con synchronized, solo 1 hilo puede ejecutar este método a la vez\n    public synchronized void incrementar() {\n        valor++; // Operación protegida contra condiciones de carrera\n    }\n\n    public synchronized int getValor() {\n        return valor;\n    }\n}\n\npublic class DemoSynchronized {\n    public static void main(String[] args) throws InterruptedException {\n        ContadorSeguro c = new ContadorSeguro();\n\n        // 2 hilos que incrementan 1000 veces cada uno\n        Thread h1 = new Thread(() -> { for (int i = 0; i < 1000; i++) c.incrementar(); });\n        Thread h2 = new Thread(() -> { for (int i = 0; i < 1000; i++) c.incrementar(); });\n\n        h1.start();\n        h2.start();\n        h1.join(); // Espera a que termine h1\n        h2.join(); // Espera a que termine h2\n\n        System.out.println(\"Total esperado 2000 -> Total obtenido: \" + c.getValor());\n    }\n}\n```",
                },
                {
                    "tipo": "test",
                    "enunciado": "Si un hilo llama a wait() sin haber adquirido el monitor (sin estar en un bloque synchronized), ¿qué ocurre?",
                    "opciones": [
                        "a) Se bloquea hasta que otro hilo la notifique",
                        "b) Se lanza IllegalMonitorStateException",
                        "c) Se lanza InterruptedException",
                        "d) No ocurre nada",
                    ],
                    "respuesta": "b) IllegalMonitorStateException — En Java, los métodos `wait()`, `notify()` y `notifyAll()` provienen de la clase `Object` y EXIGEN que el hilo actual sea dueño del monitor del objeto (es decir, la llamada DEBE estar dentro de un bloque o método `synchronized` sobre ese mismo objeto).\n\n💡 Explicación detallada:\n• Si invocas `obj.wait()` fuera de `synchronized (obj)`, la JVM no puede liberar el cerrojo ni gestionar la cola de espera, por lo que lanza `IllegalMonitorStateException` (es una `RuntimeException` no comprobada).\n• `InterruptedException` solo se lanzaría si otro hilo interrumpe al hilo mientras ya está en espera válida dentro del monitor.\n\n💻 Comparativa de código Incorrecto vs Correcto:\n\n```java\nObject cerrojo = new Object();\n\n// ❌ INCORRECTO: Lanza IllegalMonitorStateException al instante\n// cerrojo.wait(); \n\n// ✅ CORRECTO: Adquiere primero el monitor con synchronized\nsynchronized (cerrojo) {\n    try {\n        System.out.println(\"Esperando notificación de otro hilo...\");\n        cerrojo.wait(); // Libera el monitor temporalmente y espera notify()\n        System.out.println(\"Reanudado tras recibir notify()\");\n    } catch (InterruptedException e) {\n        Thread.currentThread().interrupt();\n    }\n}\n```",
                },
                {
                    "tipo": "vf",
                    "enunciado": "volatile garantiza la visibilidad de una variable entre hilos, pero no la atomicidad de operaciones compuestas como contador++.",
                    "respuesta": "Verdadero — volatile evita que cada hilo use una copia en caché, pero no serializa lecturas-modificaciones-escrituras; para eso se necesita synchronized o clases atómicas.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué interfaz de java.util.concurrent permite ejecutar tareas en un pool de hilos?",
                    "opciones": ["a) ThreadPool", "b) ExecutorService", "c) RunnableService", "d) FuturePool"],
                    "respuesta": "b) ExecutorService — Es la interfaz principal de concurrencia en Java que gestiona un pool de hilos reutilizables, desacoplando la creación de hilos de la ejecución de tareas.\n\n💡 Características clave:\n• `submit(Callable<T>)` / `submit(Runnable)`: Envía tareas y devuelve un `Future<T>` para obtener el resultado de forma asíncrona con `.get()`.\n• `shutdown()`: Cierra el pool ordenadamente tras terminar las tareas en curso.\n• Se instancia comúnmente con la factoría `Executors.newFixedThreadPool(n)`.\n\n💻 Ejemplo práctico de ExecutorService:\n\n```java\nimport java.util.concurrent.*;\n\npublic class DemoExecutor {\n    public static void main(String[] args) throws Exception {\n        // 1. Crear un pool de 2 hilos reutilizables\n        ExecutorService pool = Executors.newFixedThreadPool(2);\n\n        // 2. Enviar una tarea Callable que calcula un valor\n        Callable<String> tarea = () -> {\n            Thread.sleep(500);\n            return \"Procesado por: \" + Thread.currentThread().getName();\n        };\n\n        Future<String> futuro = pool.submit(tarea);\n\n        System.out.println(\"Haciendo otras tareas mientras el hilo calcula...\");\n        \n        // 3. Obtener el resultado (.get() espera si aún no ha terminado)\n        String resultado = futuro.get();\n        System.out.println(\"Resultado: \" + resultado);\n\n        // 4. SIEMPRE cerrar el pool al finalizar\n        pool.shutdown();\n    }\n}\n```",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método de Thread hace que el hilo actual espere a que termine otro?",
                    "opciones": ["a) sleep()", "b) yield()", "c) join()", "d) wait()"],
                    "respuesta": "c) join() — El hilo que lo invoca espera a que el hilo destino finalice.",
                },
                {
                    "tipo": "vf",
                    "enunciado": "Un deadlock ocurre cuando dos o más hilos esperan, cada uno, un recurso que otro mantiene, bloqueándose indefinidamente.",
                    "respuesta": "Verdadero — Es una espera circular: A espera el recurso de B y B espera el de A. Se evita, por ejemplo, adquiriendo los recursos siempre en el mismo orden.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué excepción hay que capturar o declarar al usar Thread.sleep()?",
                    "opciones": ["a) IOException", "b) InterruptedException", "c) RuntimeException", "d) SleepException"],
                    "respuesta": "b) InterruptedException — sleep() la lanza si otro hilo interrumpe al que duerme.",
                },
            ],
        },
        {
            "titulo": "Parte 2: Análisis y depuración",
            "puntos": "3 puntos",
            "preguntas": [
                {
                    "tipo": "ejercicio",
                    "enunciado": "Analiza el siguiente código. ¿Qué valor imprime normalmente? ¿Puede imprimir algo distinto? Explica por qué.",
                    "puntos": "1,5 ptos",
                    "code": "public class Carrera {\n    static int contador = 0;\n    public static void main(String[] args) throws InterruptedException {\n        Thread t1 = new Thread(() -> { for (int i = 0; i < 1000; i++) contador++; });\n        Thread t2 = new Thread(() -> { for (int i = 0; i < 1000; i++) contador++; });\n        t1.start(); t2.start();\n        t1.join(); t2.join();\n        System.out.println(contador);\n    }\n}",
                    "respuesta": [
                        "contador++ no es atómico: son tres operaciones (leer, sumar, escribir). Dos hilos pueden leer el mismo valor y escribir el mismo resultado, perdiendo incrementos.",
                        "El valor esperado sería 2000, pero en la práctica suele salir menos (p. ej. 1923) y es distinto en cada ejecución: es una condición de carrera.",
                        "Solución: declarar el método con synchronized (o usar AtomicInteger): public static synchronized void inc() { contador++; }.",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "El siguiente código a veces se bloquea sin terminar. ¿Qué problema tiene y cómo se corrige?",
                    "puntos": "1,5 ptos",
                    "code": "public class Bloqueo {\n    static final Object A = new Object();\n    static final Object B = new Object();\n    public static void main(String[] args) {\n        new Thread(() -> { synchronized (A) {\n            try { Thread.sleep(50); } catch (InterruptedException e) {}\n            synchronized (B) { System.out.println(\"Hilo 1\"); }\n        } }).start();\n        new Thread(() -> { synchronized (B) {\n            try { Thread.sleep(50); } catch (InterruptedException e) {}\n            synchronized (A) { System.out.println(\"Hilo 2\"); }\n        } }).start();\n    }\n}",
                    "respuesta": [
                        "Es un deadlock clásico: el hilo 1 toma A y espera B, mientras el hilo 2 toma B y espera A. Ninguno libera su recurso y ambos quedan bloqueados para siempre.",
                        "Corrección: adquirir los bloqueos siempre en el mismo orden (p. ej. primero A y después B en los dos hilos), o usar tryLock con java.util.concurrent.locks.Lock.",
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
                    "enunciado": "Escribe un programa que cree 5 hilos (Runnable con lambda). Cada hilo imprime su número y una iteración 3 veces, duerme 100 ms entre impresiones, y el main espera a todos con join() antes de imprimir el mensaje final.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "public class HilosBasicos {",
                        "    public static void main(String[] args) throws InterruptedException {",
                        "        Thread[] hilos = new Thread[5];",
                        "        for (int i = 1; i <= 5; i++) {",
                        "            final int num = i;",
                        "            hilos[i - 1] = new Thread(() -> {",
                        "                for (int j = 1; j <= 3; j++) {",
                        "                    System.out.println(\"Hilo \" + num + \": iteración \" + j);",
                        "                    try { Thread.sleep(100); } catch (InterruptedException e) { }",
                        "                }",
                        "            });",
                        "            hilos[i - 1].start();",
                        "        }",
                        "        for (Thread h : hilos) h.join();",
                        "        System.out.println(\"Todos los hilos han terminado\");",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Implementa una clase Contador con un método incrementar() sincronizado y un main que lance 10 hilos que incrementen 1000 veces cada uno. Comprueba que el resultado final es exactamente 10000.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "public class ContadorSeguro {",
                        "    private int valor = 0;",
                        "    public synchronized void incrementar() { valor++; }",
                        "    public synchronized int getValor() { return valor; }",
                        "    public static void main(String[] args) throws InterruptedException {",
                        "        ContadorSeguro c = new ContadorSeguro();",
                        "        Thread[] hilos = new Thread[10];",
                        "        for (int i = 0; i < 10; i++) {",
                        "            hilos[i] = new Thread(() -> {",
                        "                for (int j = 0; j < 1000; j++) c.incrementar();",
                        "            });",
                        "            hilos[i].start();",
                        "        }",
                        "        for (Thread h : hilos) h.join();",
                        "        System.out.println(\"Valor final: \" + c.getValor()); // 10000",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Usa ExecutorService con un pool fijo de 3 hilos para calcular el cuadrado de los números 1 a 6. Cada tarea debe ser un Callable<Integer> y el main debe mostrar los resultados con Future.get().",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.util.ArrayList;",
                        "import java.util.List;",
                        "import java.util.concurrent.*;",
                        "public class PoolTareas {",
                        "    public static void main(String[] args) throws Exception {",
                        "        ExecutorService pool = Executors.newFixedThreadPool(3);",
                        "        List<Future<Integer>> futuros = new ArrayList<>();",
                        "        for (int n = 1; n <= 6; n++) {",
                        "            final int v = n;",
                        "            futuros.add(pool.submit(() -> v * v));",
                        "        }",
                        "        for (Future<Integer> f : futuros) {",
                        "            System.out.println(\"Cuadrado: \" + f.get());",
                        "        }",
                        "        pool.shutdown();",
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
                    "enunciado": "Explica la diferencia entre sleep() y wait(), y entre heredar de Thread e implementar Runnable. ¿Cuándo conviene usar ExecutorService?",
                    "respuesta": [
                        "sleep() es estático y solo pausa el hilo actual sin liberar el monitor; wait() libera el monitor del objeto y debe llamarse desde un bloque synchronized, quedando el hilo a la espera de notify()/notifyAll().",
                        "Implementar Runnable es preferible a heredar Thread porque no se gasta la única herencia de clase y separa la tarea del mecanismo de ejecución.",
                        "ExecutorService conviene cuando hay muchas tareas cortas o repetidas: reutiliza hilos (evita el coste de crearlos), limita el número máximo con el pool y permite obtener resultados con Future.",
                    ],
                },
            ],
        },
    ],
})

# =====================================================================
# EXAMEN 12 — JDBC y bases de datos
# =====================================================================
EXAMENES.append({
    "titulo": "EXAMEN DE PROGRAMACIÓN – 1º GRADO SUPERIOR",
    "subtitulo": "Examen 12 · JDBC y bases de datos",
    "temas": [
        "Conexión: DriverManager, URL JDBC y cierre de recursos",
        "Statement frente a PreparedStatement",
        "ResultSet: recorrido y obtención de valores",
        "Transacciones: commit, rollback y autoCommit",
        "Seguridad: inyección SQL y claves autogeneradas",
    ],
    "puntuacion": 16,
    "info": [("Convocatoria", "Evaluación 3"), ("Valoración", "Acceso a datos con JDBC")],
    "secciones": [
        {
            "titulo": "Parte 1: Opción múltiple y Verdadero/Falso",
            "puntos": "5 puntos — 0,5 cada pregunta",
            "preguntas": [
                {
                    "tipo": "test",
                    "enunciado": "¿Cuál es la forma habitual de cargar el driver JDBC en aplicaciones clásicas?",
                    "opciones": [
                        "a) Class.forName(\"com.mysql.cj.jdbc.Driver\")",
                        "b) new Driver(\"mysql\")",
                        "c) Driver.load(\"mysql\")",
                        "d) JDBC.register(\"mysql\")",
                    ],
                    "respuesta": "a) Class.forName(...) — Carga la clase del driver, que se registra sola en DriverManager (en JDBC 4+ ni siquiera es necesario si el driver está en el classpath).",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método de DriverManager establece la conexión con la base de datos?",
                    "opciones": [
                        "a) DriverManager.connect(url)",
                        "b) DriverManager.getConnection(url, user, pass)",
                        "c) Connection.open(url, user, pass)",
                        "d) JDBC.connect(url, user, pass)",
                    ],
                    "respuesta": "b) getConnection(url, user, pass) — Devuelve un objeto Connection con la sesión abierta contra la BD.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué objeto se recomienda para ejecutar consultas SQL con parámetros de forma segura?",
                    "opciones": ["a) Statement", "b) PreparedStatement", "c) CallableStatement", "d) ResultSet"],
                    "respuesta": "b) PreparedStatement — La consulta se precompila y los parámetros se envían por separado con setString/setInt, evitando la inyección SQL.",
                },
                {
                    "tipo": "vf",
                    "enunciado": "Usar PreparedStatement con parámetros (?) protege frente a inyección SQL porque el usuario nunca puede alterar la estructura de la consulta.",
                    "respuesta": "Verdadero — La consulta se precompila en el motor de base de datos antes de recibir los valores. Los parámetros asignados con `?` se tratan estrictamente como **datos literales** (cadenas de texto o números), por lo que cualquier comando malicioso inyectado (como comillas, `' OR '1'='1'`, o `DROP TABLE`) queda neutralizado sin alterar la sintaxis SQL.\n\n💡 Comparativa Código Vulnerable vs Seguro:\n\n```java\nString usuario = \"' OR '1'='1\"; // Intento de inyección SQL maliciosa\nString clave   = \"' OR '1'='1\";\n\n// ❌ VULNERABLE (Statement concatenado):\n// Genera: SELECT * FROM usuarios WHERE user = '' OR '1'='1' AND pass = '' OR '1'='1'\n// Da acceso de administrador a cualquiera sin verificar la clave real.\nStatement st = conexion.createStatement();\nResultSet rs1 = st.executeQuery(\n    \"SELECT * FROM usuarios WHERE user = '\" + usuario + \"' AND pass = '\" + clave + \"'\");\n\n// ✅ SEGURO (PreparedStatement parametrizado):\n// La estructura SQL ya está fijada. Busca un usuario cuyo nombre literal sea \"' OR '1'='1\"\nString sql = \"SELECT * FROM usuarios WHERE user = ? AND pass = ?\";\ntry (PreparedStatement ps = conexion.prepareStatement(sql)) {\n    ps.setString(1, usuario); // Se escapa y parametriza como dato seguro\n    ps.setString(2, clave);\n    try (ResultSet rs2 = ps.executeQuery()) {\n        if (rs2.next()) {\n            System.out.println(\"Login exitoso\");\n        }\n    }\n}\n```",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método ejecuta un SELECT y devuelve las filas?",
                    "opciones": ["a) executeUpdate()", "b) executeQuery()", "c) executeSelect()", "d) query()"],
                    "respuesta": "b) executeQuery() — Devuelve un ResultSet con las filas de la consulta.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método de ResultSet avanza a la siguiente fila?",
                    "opciones": ["a) next()", "b) hasNext()", "c) moveNext()", "d) advance()"],
                    "respuesta": "a) next() — Devuelve true si hay fila siguiente y false al llegar al final; se usa como condición del bucle de recorrido.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método de ResultSet obtiene el valor de la columna 1 como cadena?",
                    "opciones": ["a) getString(1)", "b) getText(1)", "c) getValue(1)", "d) read(1)"],
                    "respuesta": "a) getString(1) — Los índices de columna empiezan en 1 (no en 0).",
                },
                {
                    "tipo": "vf",
                    "enunciado": "executeUpdate() devuelve el número de filas afectadas por un INSERT, UPDATE o DELETE.",
                    "respuesta": "Verdadero — Para INSERT/UPDATE/DELETE se usa executeUpdate(); executeQuery() es solo para SELECT.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método confirma los cambios de una transacción?",
                    "opciones": ["a) conn.commit()", "b) conn.save()", "c) conn.end()", "d) conn.flush()"],
                    "respuesta": "a) commit() — Hace permanentes los cambios desde el último commit/rollback.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Cómo se obtienen las claves autogeneradas tras un INSERT (p. ej. un AUTO_INCREMENT)?",
                    "opciones": [
                        "a) ps.getGeneratedKeys() tras preparar con Statement.RETURN_GENERATED_KEYS",
                        "b) ps.getLastId()",
                        "c) conn.getIdentity()",
                        "d) No es posible con JDBC",
                    ],
                    "respuesta": "a) getGeneratedKeys() — Se prepara la sentencia con Statement.RETURN_GENERATED_KEYS y se lee el ResultSet devuelto.",
                },
            ],
        },
        {
            "titulo": "Parte 2: Análisis y depuración",
            "puntos": "3 puntos",
            "preguntas": [
                {
                    "tipo": "ejercicio",
                    "enunciado": "El siguiente método tiene dos problemas graves. Encuéntralos y propón la corrección.",
                    "puntos": "1,5 ptos",
                    "code": "public void buscar(String nombre) throws SQLException {\n    Connection conn = DriverManager.getConnection(url, user, pass);\n    Statement st = conn.createStatement();\n    ResultSet rs = st.executeQuery(\"SELECT * FROM alumnos WHERE nombre = '\" + nombre + \"'\");\n    while (rs.next()) System.out.println(rs.getString(\"nombre\"));\n}",
                    "respuesta": [
                        "1) Inyección SQL: el valor del usuario se concatena directamente en el SQL. Si nombre es  ' OR '1'='1  se devuelven todas las filas. Debe usarse PreparedStatement con parámetro ? y setString(1, nombre).",
                        "2) Fuga de recursos: la conexión, el Statement y el ResultSet nunca se cierran. Debe usarse try-with-resources para cerrarlos automáticamente, incluso si hay excepción.",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "¿Qué error lanza este código en tiempo de ejecución y por qué?",
                    "puntos": "1,5 ptos",
                    "code": "ResultSet rs = st.executeQuery(\"SELECT id, nombre FROM alumnos\");\nwhile (rs.next()) {\n    System.out.println(rs.getString(0));\n}",
                    "respuesta": [
                        "Lanza SQLException: los índices de columna de ResultSet empiezan en 1, por lo que getString(0) es inválido.",
                        "Corrección: usar getString(1) (o mejor, el nombre de la columna: rs.getString(\"nombre\")).",
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
                    "enunciado": "Escribe un método insertarAlumno(String nombre, int edad) que inserte un alumno en la tabla alumnos (id autoincremental, nombre, edad) usando PreparedStatement y try-with-resources.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.sql.*;",
                        "public class InsertarAlumno {",
                        "    public static void insertar(String nombre, int edad) {",
                        "        String url = \"jdbc:mysql://localhost:3306/centro\";",
                        "        String sql = \"INSERT INTO alumnos (nombre, edad) VALUES (?, ?)\";",
                        "        try (Connection conn = DriverManager.getConnection(url, \"root\", \"1234\");",
                        "             PreparedStatement ps = conn.prepareStatement(sql)) {",
                        "            ps.setString(1, nombre);",
                        "            ps.setInt(2, edad);",
                        "            ps.executeUpdate();",
                        "            System.out.println(\"Alumno insertado\");",
                        "        } catch (SQLException e) {",
                        "            e.printStackTrace();",
                        "        }",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Escribe un método listarMayores(int edadMinima) que muestre nombre y edad de los alumnos con edad >= edadMinima, ordenados por edad, usando PreparedStatement.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.sql.*;",
                        "public class ListarAlumnos {",
                        "    public static void listarMayores(int edadMinima) {",
                        "        String url = \"jdbc:mysql://localhost:3306/centro\";",
                        "        String sql = \"SELECT nombre, edad FROM alumnos WHERE edad >= ? ORDER BY edad\";",
                        "        try (Connection conn = DriverManager.getConnection(url, \"root\", \"1234\");",
                        "             PreparedStatement ps = conn.prepareStatement(sql)) {",
                        "            ps.setInt(1, edadMinima);",
                        "            try (ResultSet rs = ps.executeQuery()) {",
                        "                while (rs.next()) {",
                        "                    System.out.println(rs.getString(\"nombre\") + \" - \" + rs.getInt(\"edad\"));",
                        "                }",
                        "            }",
                        "        } catch (SQLException e) {",
                        "            e.printStackTrace();",
                        "        }",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Implementa una transferencia bancaria con transacción: resta el importe de la cuenta origen, lo suma a la destino y hace commit; si algo falla, rollback. Usa setAutoCommit(false).",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.sql.*;",
                        "public class Transferencia {",
                        "    public static void transferir(int idOrigen, int idDestino, double importe) {",
                        "        String url = \"jdbc:mysql://localhost:3306/banco\";",
                        "        String sql = \"UPDATE cuentas SET saldo = saldo + ? WHERE id = ?\";",
                        "        try (Connection conn = DriverManager.getConnection(url, \"root\", \"1234\")) {",
                        "            conn.setAutoCommit(false);",
                        "            try (PreparedStatement ps = conn.prepareStatement(sql)) {",
                        "                ps.setDouble(1, -importe); ps.setInt(2, idOrigen);",
                        "                ps.executeUpdate();",
                        "                ps.setDouble(1, importe); ps.setInt(2, idDestino);",
                        "                ps.executeUpdate();",
                        "                conn.commit();",
                        "                System.out.println(\"Transferencia realizada\");",
                        "            } catch (SQLException e) {",
                        "                conn.rollback();",
                        "                throw e;",
                        "            }",
                        "        } catch (SQLException e) {",
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
                    "enunciado": "Explica las ventajas de PreparedStatement frente a Statement y qué es una transacción y por qué conviene usarla en operaciones de varios pasos.",
                    "respuesta": [
                        "Seguridad: los parámetros se envían separados del SQL, por lo que es inmune a la inyección SQL.",
                        "Rendimiento: la consulta se precompila una vez y se reutiliza con distintos valores (además de permitir cache de planes en muchos SGBD).",
                        "Legibilidad: el SQL queda limpio con ? en lugar de concatenaciones largas.",
                        "Transacción: conjunto de operaciones que se ejecutan como una unidad (todo o nada). Con setAutoCommit(false) los cambios no se persisten hasta commit(); si algo falla, rollback() deshace todo, evitando estados a medias (p. ej. dinero que sale de una cuenta y no llega a otra).",
                    ],
                },
            ],
        },
    ],
})

# =====================================================================
# EXAMEN 13 — Swing y eventos de interfaz gráfica
# =====================================================================
EXAMENES.append({
    "titulo": "EXAMEN DE PROGRAMACIÓN – 1º GRADO SUPERIOR",
    "subtitulo": "Examen 13 · Swing y eventos de interfaz gráfica",
    "temas": [
        "JFrame, componentes básicos y layouts",
        "Modelo de eventos: listeners y lambdas",
        "Eventos de ratón y teclado",
        "El hilo de despacho de eventos (EDT) y SwingUtilities.invokeLater",
        "Diálogos y gestión de errores de entrada",
    ],
    "puntuacion": 16,
    "info": [("Convocatoria", "Evaluación 3"), ("Valoración", "Interfaces gráficas con Swing")],
    "secciones": [
        {
            "titulo": "Parte 1: Opción múltiple y Verdadero/Falso",
            "puntos": "5 puntos — 0,5 cada pregunta",
            "preguntas": [
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método hace visible una ventana JFrame?",
                    "opciones": ["a) setVisible(true)", "b) show()", "c) display()", "d) open()"],
                    "respuesta": "a) setVisible(true) — Sin esta llamada (o equivalente) la ventana no se muestra.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué layout coloca los componentes en las regiones NORTE, SUR, ESTE, OESTE y CENTRO?",
                    "opciones": ["a) FlowLayout", "b) BorderLayout", "c) GridLayout", "d) BoxLayout"],
                    "respuesta": "b) BorderLayout — Es el layout por defecto de JFrame; cada región puede contener un componente.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método registra la acción que se ejecuta al pulsar un JButton?",
                    "opciones": ["a) addActionListener()", "b) setOnClick()", "c) onClick()", "d) addClickListener()"],
                    "respuesta": "a) addActionListener() — Recibe un ActionListener; con lambdas: boton.addActionListener(e -> { ... }).",
                },
                {
                    "tipo": "vf",
                    "enunciado": "Según las buenas prácticas de Swing, toda modificación de componentes debe hacerse en el hilo de despacho de eventos (EDT).",
                    "respuesta": "Verdadero — Swing no es seguro para hilos; las actualizaciones fuera del EDT pueden provocar fallos intermitentes. Se usa SwingUtilities.invokeLater() para encolarlas.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué construcción lanza la interfaz en el EDT desde el main?",
                    "opciones": [
                        "a) SwingUtilities.invokeLater(() -> new MiVentana());",
                        "b) Thread.startUI(() -> new MiVentana());",
                        "c) UI.launch(new MiVentana());",
                        "d) Swing.start(new MiVentana());",
                    ],
                    "respuesta": "a) SwingUtilities.invokeLater(...) — Encola la creación de la ventana en el EDT.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué componente muestra una etiqueta de texto no editable?",
                    "opciones": ["a) JLabel", "b) JText", "c) JLabelField", "d) JField"],
                    "respuesta": "a) JLabel — Se usa para textos informativos; con setText() se cambia su contenido.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué componente permite editar texto multilínea?",
                    "opciones": ["a) JTextField", "b) JTextArea", "c) JPasswordField", "d) JLabel"],
                    "respuesta": "b) JTextArea — Acepta varias líneas; JTextField es de una sola línea.",
                },
                {
                    "tipo": "vf",
                    "enunciado": "setDefaultCloseOperation(EXIT_ON_CLOSE) hace que al pulsar la X de la ventana finalice la aplicación (System.exit).",
                    "respuesta": "Verdadero — EXIT_ON_CLOSE cierra la JVM; DO_NOTHING_ON_CLOSE o DISPOSE_ON_CLOSE son las alternativas para controlar el cierre.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método de JTextField devuelve el texto introducido?",
                    "opciones": ["a) getText()", "b) getValue()", "c) text()", "d) getContent()"],
                    "respuesta": "a) getText() — Devuelve el contenido actual del campo como String.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué interfaz permite reaccionar a eventos de ratón como clic o entrada del cursor?",
                    "opciones": ["a) MouseListener", "b) ButtonListener", "c) InputListener", "d) PointerListener"],
                    "respuesta": "a) MouseListener — Define métodos como mouseClicked, mouseEntered, mouseExited.",
                },
            ],
        },
        {
            "titulo": "Parte 2: Análisis y depuración",
            "puntos": "3 puntos",
            "preguntas": [
                {
                    "tipo": "ejercicio",
                    "enunciado": "El botón de esta ventana no hace nada al pulsarlo. ¿Por qué? Propón la corrección.",
                    "puntos": "1,5 ptos",
                    "code": "JButton boton = new JButton(\"Saludar\");\nJLabel saludo = new JLabel(\" \");\n// ... se añaden al JFrame ...\nboton.addActionListener(new ActionListener() {\n    public void actionPerformed(ActionEvent e) {\n        saludo.setText(\"Hola\");\n    }\n});",
                    "respuesta": [
                        "El código del listener parece correcto; el problema típico es que el botón nunca llegó a registrarse porque falta la llamada o porque el listener se añadió antes de crear el JLabel (null).",
                        "En este caso concreto la causa más habitual es que el botón añadido al frame es otro objeto distinto, o que no se llamó a setVisible(true).",
                        "Solución: asegurar que el listener se registra sobre el mismo botón que se añade al contenedor y que la ventana se hace visible con setVisible(true).",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Este programa actualiza un JLabel desde un hilo que cuenta. ¿Qué riesgo tiene y cómo se corrige?",
                    "puntos": "1,5 ptos",
                    "code": "JLabel etiqueta = new JLabel(\"0\");\nnew Thread(() -> {\n    for (int i = 1; i <= 10; i++) {\n        etiqueta.setText(String.valueOf(i));\n        try { Thread.sleep(500); } catch (InterruptedException e) { }\n    }\n}).start();",
                    "respuesta": [
                        "El hilo secundario modifica un componente Swing fuera del EDT, lo que viola el modelo de hilos de Swing y puede producir actualizaciones erráticas o excepciones.",
                        "Corrección: encolar la actualización en el EDT: SwingUtilities.invokeLater(() -> etiqueta.setText(String.valueOf(i)));",
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
                    "enunciado": "Crea una ventana con un JTextField, un JButton \"Invertir\" y un JLabel. Al pulsar el botón, el JLabel muestra el texto del campo invertido (usa StringBuilder.reverse()).",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import javax.swing.*;",
                        "import java.awt.*;",
                        "public class InvertirTexto extends JFrame {",
                        "    private JTextField campo;",
                        "    private JLabel resultado;",
                        "    public InvertirTexto() {",
                        "        setTitle(\"Invertir texto\");",
                        "        setLayout(new FlowLayout());",
                        "        campo = new JTextField(15);",
                        "        JButton boton = new JButton(\"Invertir\");",
                        "        resultado = new JLabel(\" \");",
                        "        boton.addActionListener(e ->",
                        "            resultado.setText(new StringBuilder(campo.getText()).reverse().toString()));",
                        "        add(campo); add(boton); add(resultado);",
                        "        setSize(320, 120);",
                        "        setDefaultCloseOperation(EXIT_ON_CLOSE);",
                        "        setVisible(true);",
                        "    }",
                        "    public static void main(String[] args) {",
                        "        SwingUtilities.invokeLater(InvertirTexto::new);",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Haz una mini calculadora Swing: dos JTextField numéricos, un JButton \"Sumar\" y un JLabel con el resultado. Controla la excepción NumberFormatException mostrando \"Error de formato\".",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import javax.swing.*;",
                        "import java.awt.*;",
                        "public class MiniCalculadora extends JFrame {",
                        "    public MiniCalculadora() {",
                        "        setTitle(\"Suma\");",
                        "        setLayout(new FlowLayout());",
                        "        JTextField a = new JTextField(5);",
                        "        JTextField b = new JTextField(5);",
                        "        JButton sumar = new JButton(\"Sumar\");",
                        "        JLabel res = new JLabel(\" \");",
                        "        sumar.addActionListener(e -> {",
                        "            try {",
                        "                int total = Integer.parseInt(a.getText()) + Integer.parseInt(b.getText());",
                        "                res.setText(String.valueOf(total));",
                        "            } catch (NumberFormatException ex) {",
                        "                res.setText(\"Error de formato\");",
                        "            }",
                        "        });",
                        "        add(a); add(new JLabel(\"+\")); add(b); add(sumar); add(res);",
                        "        setSize(360, 110);",
                        "        setDefaultCloseOperation(EXIT_ON_CLOSE);",
                        "        setVisible(true);",
                        "    }",
                        "    public static void main(String[] args) {",
                        "        SwingUtilities.invokeLater(MiniCalculadora::new);",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Implementa un contador con dos botones (+1 y -1) y un JLabel que muestre el valor actual. Usa lambdas para los listeners.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import javax.swing.*;",
                        "import java.awt.*;",
                        "public class Contador extends JFrame {",
                        "    private int valor = 0;",
                        "    private JLabel etiqueta;",
                        "    public Contador() {",
                        "        setTitle(\"Contador\");",
                        "        setLayout(new FlowLayout());",
                        "        etiqueta = new JLabel(\"0\");",
                        "        JButton mas = new JButton(\"+1\");",
                        "        JButton menos = new JButton(\"-1\");",
                        "        mas.addActionListener(e -> { valor++; etiqueta.setText(String.valueOf(valor)); });",
                        "        menos.addActionListener(e -> { valor--; etiqueta.setText(String.valueOf(valor)); });",
                        "        add(menos); add(etiqueta); add(mas);",
                        "        setSize(260, 100);",
                        "        setDefaultCloseOperation(EXIT_ON_CLOSE);",
                        "        setVisible(true);",
                        "    }",
                        "    public static void main(String[] args) {",
                        "        SwingUtilities.invokeLater(Contador::new);",
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
                    "enunciado": "¿Qué es el EDT (Event Dispatch Thread) y por qué es importante en Swing? Explica también la diferencia entre ActionListener y MouseListener.",
                    "respuesta": [
                        "El EDT es el hilo único que procesa los eventos de Swing (clics, teclado, repintados) y donde deben ejecutarse todas las modificaciones de componentes.",
                        "Trabajar fuera del EDT provoca condiciones de carrera y fallos visuales; por eso las tareas largas se ejecutan en hilos separados y el resultado se vuelca al EDT con invokeLater.",
                        "ActionListener responde a la acción lógica del componente (pulsar un botón, pulsar Enter en un campo) — un único método: actionPerformed.",
                        "MouseListener responde a eventos de ratón de bajo nivel (clic, entrada, salida, pulsar/soltar) — varios métodos como mouseClicked o mouseEntered.",
                    ],
                },
            ],
        },
    ],
})

# =====================================================================
# EXAMEN 14 — Expresiones regulares y procesamiento de texto
# =====================================================================
EXAMENES.append({
    "titulo": "EXAMEN DE PROGRAMACIÓN – 1º GRADO SUPERIOR",
    "subtitulo": "Examen 14 · Expresiones regulares y procesamiento de texto",
    "temas": [
        "Clases Pattern y Matcher",
        "Cuantificadores, clases de caracteres y anclas",
        "matches() frente a find() y grupos de captura",
        "Validación de DNI, email, teléfono y fechas",
        "replaceAll, split y procesamiento de texto real",
    ],
    "puntuacion": 16,
    "info": [("Convocatoria", "Evaluación 3"), ("Valoración", "Regex y texto")],
    "secciones": [
        {
            "titulo": "Parte 1: Opción múltiple y Verdadero/Falso",
            "puntos": "5 puntos — 0,5 cada pregunta",
            "preguntas": [
                {
                    "tipo": "test",
                    "enunciado": "¿Qué clase compila una expresión regular en Java?",
                    "opciones": ["a) Pattern", "b) Regex", "c) Matcher", "d) RegexCompiler"],
                    "respuesta": "a) Pattern — Pattern.compile(\"...\") compila la regex; Matcher se obtiene con pattern.matcher(texto).",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método comprueba si TODA la cadena coincide con la expresión?",
                    "opciones": ["a) matches()", "b) find()", "c) lookingAt()", "d) contains()"],
                    "respuesta": "a) matches() — Exige que la expresión cubra la cadena completa (equivale a anclar con ^ y $).",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué cuantificador significa 'una o más veces'?",
                    "opciones": ["a) *", "b) +", "c) ?", "d) {1}"],
                    "respuesta": "b) + — a+ acepta 'a', 'aa', 'aaa'...; * acepta cero o más; ? cero o una.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método de Matcher busca la siguiente coincidencia dentro de la cadena?",
                    "opciones": ["a) find()", "b) next()", "c) match()", "d) search()"],
                    "respuesta": "a) find() — Avanza por la cadena localizando coincidencias parciales; se repite mientras devuelva true.",
                },
                {
                    "tipo": "vf",
                    "enunciado": "En el código fuente Java, para representar la regex de un dígito hay que escribir \"\\\\d\" (doble barra).",
                    "respuesta": "Verdadero — La barra invertida es carácter de escape en los literales String, por lo que se necesita \\\\ para que la regex reciba \\d.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué expresión valida un teléfono de 9 dígitos que empieza por 6, 7 o 9?",
                    "opciones": ["a) [679]\\\\d{8}", "b) \\\\d{9}", "c) [6-9]{9}", "d) 6|7|9\\\\d{8}"],
                    "respuesta": "a) [679]\\\\d{8} — Primera cifra 6, 7 o 9, seguidas de exactamente 8 dígitos.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método de String reemplaza todas las coincidencias de una regex?",
                    "opciones": ["a) replaceAll()", "b) replace()", "c) replaceFirst()", "d) replaceAllMatches()"],
                    "respuesta": "a) replaceAll(regex, reemplazo) — Sustituye todas las apariciones; replace() (sin regex) reemplaza literales.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué construcción permite capturar una parte de la coincidencia para recuperarla después?",
                    "opciones": ["a) (grupo)", "b) [grupo]", "c) {grupo}", "d) <grupo>"],
                    "respuesta": "a) (grupo) — Los paréntesis crean grupos; con matcher.group(1) se recupera el primero.",
                },
                {
                    "tipo": "vf",
                    "enunciado": "La regex ^abc$ solo coincide con cadenas que empiecen y terminen exactamente en 'abc' (coincidencia completa).",
                    "respuesta": "Verdadero — ^ ancla el inicio y $ el final; con matches() las anclas son redundantes porque ya exige la cadena completa.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método de String divide la cadena usando una expresión regular como separador?",
                    "opciones": ["a) split()", "b) cut()", "c) divide()", "d) tokenize()"],
                    "respuesta": "a) split(regex) — Devuelve un String[]; p. ej. \"a;b;c\".split(\";\") → [\"a\", \"b\", \"c\"].",
                },
            ],
        },
        {
            "titulo": "Parte 2: Análisis y depuración",
            "puntos": "3 puntos",
            "preguntas": [
                {
                    "tipo": "ejercicio",
                    "enunciado": "Este validador de emails acepta direcciones incorrectas como 'a@b.com.extra'. ¿Por qué y cómo se corrige?",
                    "puntos": "1,5 ptos",
                    "code": "String email = \"a@b.com.extra\";\nPattern p = Pattern.compile(\"[a-z]+@[a-z]+\\\\.com\");\nMatcher m = p.matcher(email);\nif (m.find()) System.out.println(\"Email válido\");",
                    "respuesta": [
                        "find() busca coincidencias parciales: 'a@b.com' aparece dentro de 'a@b.com.extra', así que el resultado es válido aunque la cadena completa no lo sea.",
                        "Corrección: usar matches() en lugar de find() (o anclar la regex con ^...$). Además, el punto en \\.com está bien escapado, pero el dominio puede incluir más niveles.",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "El siguiente código intenta extraer los precios de un texto, pero no imprime nada. ¿Qué falla?",
                    "puntos": "1,5 ptos",
                    "code": "String texto = \"Pan 1,20 € - Leche 0,85 €\";\nPattern p = Pattern.compile(\"(\\\\d+,\\\\d{2})\");\nMatcher m = p.matcher(texto);\nif (m.find()) {\n    System.out.println(m.group(1));\n}",
                    "respuesta": [
                        "El código solo imprime UNA coincidencia (la primera: '1,20') porque usa if en lugar de while.",
                        "Corrección: sustituir if (m.find()) por while (m.find()) para recorrer todas las coincidencias e imprimir también '0,85'.",
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
                    "enunciado": "Escribe un programa que valide un NIF: 8 dígitos seguidos de una letra, y que la letra sea la correcta según el algoritmo (resto de dividir el número entre 23 con la tabla TRWAGMYFPDXBNJZSQVHLCKE).",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.util.Scanner;",
                        "public class ValidarNIF {",
                        "    static final String LETRAS = \"TRWAGMYFPDXBNJZSQVHLCKE\";",
                        "    public static void main(String[] args) {",
                        "        Scanner sc = new Scanner(System.in);",
                        "        System.out.print(\"NIF: \");",
                        "        String nif = sc.nextLine().trim().toUpperCase();",
                        "        if (!nif.matches(\"\\\\d{8}[A-Z]\")) {",
                        "            System.out.println(\"Formato incorrecto\");",
                        "            return;",
                        "        }",
                        "        int num = Integer.parseInt(nif.substring(0, 8));",
                        "        char esperada = LETRAS.charAt(num % 23);",
                        "        if (nif.charAt(8) == esperada) System.out.println(\"NIF válido\");",
                        "        else System.out.println(\"Letra incorrecta, debería ser \" + esperada);",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Escribe un programa que, dado un texto, extraiga e imprima todas las palabras que empiezan por vocal (a, e, i, o, u), usando Pattern y Matcher con find() en bucle.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.util.regex.*;",
                        "public class Vocales {",
                        "    public static void main(String[] args) {",
                        "        String texto = \"El oso y el águila comen uvas en la isla\";",
                        "        Pattern p = Pattern.compile(\"\\\\b[aeiouáéíóú][a-záéíóúñ]*\", Pattern.CASE_INSENSITIVE);",
                        "        Matcher m = p.matcher(texto);",
                        "        while (m.find()) {",
                        "            System.out.println(m.group());",
                        "        }",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Escribe un programa que oculte los números de teléfono (9 dígitos) de un texto sustituyéndolos por \"[OCULTO]\", usando replaceAll con la regex adecuada.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "public class OcultarTelefonos {",
                        "    public static void main(String[] args) {",
                        "        String texto = \"Llama al 612345678 o al 699000111 hoy\";",
                        "        String resultado = texto.replaceAll(\"\\\\d{9}\", \"[OCULTO]\");",
                        "        System.out.println(resultado);",
                        "        // Llama al [OCULTO] o al [OCULTO] hoy",
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
                    "enunciado": "Explica la diferencia entre matches() y find(), y para qué sirven los grupos de captura. Pon un ejemplo de uso de grupo.",
                    "respuesta": [
                        "matches() exige que toda la cadena encaje con la regex; find() localiza coincidencias parciales y puede llamarse repetidamente para recorrerlas.",
                        "Los grupos de captura (paréntesis) permiten extraer partes de la coincidencia: en la regex (\\\\d{2})/(\\\\d{2})/(\\\\d{4}) para una fecha, group(1) sería el día, group(2) el mes y group(3) el año.",
                        "Ejemplo: Pattern.compile(\"Fecha: (\\\\d{2})/(\\\\d{2})/(\\\\d{4})\").matcher(texto).find() permite recuperar día/mes/año sin re-parsing manual.",
                    ],
                },
            ],
        },
    ],
})

# =====================================================================
# EXAMEN 15 — Ordenación y búsqueda: algoritmos y complejidad
# =====================================================================
EXAMENES.append({
    "titulo": "EXAMEN DE PROGRAMACIÓN – 1º GRADO SUPERIOR",
    "subtitulo": "Examen 15 · Ordenación y búsqueda: algoritmos y complejidad",
    "temas": [
        "Algoritmos básicos: burbuja, selección e inserción",
        "Arrays.sort y Collections.sort",
        "Comparable y Comparator (incluidas lambdas)",
        "Búsqueda binaria: requisitos e implementación",
        "Complejidad algorítmica: O(n), O(n²), O(n log n)",
    ],
    "puntuacion": 16,
    "info": [("Convocatoria", "Evaluación 3"), ("Valoración", "Algoritmos de ordenación y búsqueda")],
    "secciones": [
        {
            "titulo": "Parte 1: Opción múltiple y Verdadero/Falso",
            "puntos": "5 puntos — 0,5 cada pregunta",
            "preguntas": [
                {
                    "tipo": "test",
                    "enunciado": "¿Qué complejidad temporal tiene la ordenación por burbuja en el peor caso?",
                    "opciones": ["a) O(n²)", "b) O(n log n)", "c) O(n)", "d) O(log n)"],
                    "respuesta": "a) O(n²) — Dos bucles anidados sobre n elementos; lo mismo aplica a selección e inserción en el peor caso.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método de la clase Arrays ordena un array?",
                    "opciones": ["a) Arrays.sort()", "b) Arrays.order()", "c) Arrays.sortArray()", "d) Arrays.quickSort()"],
                    "respuesta": "a) Arrays.sort() — Ordena arrays de primitivos o de objetos (con Comparable o Comparator).",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué requisito imprescindible tiene la búsqueda binaria?",
                    "opciones": ["a) El array debe estar ordenado", "b) El array no puede tener duplicados", "c) Solo funciona con enteros", "d) El array debe ser pequeño"],
                    "respuesta": "a) Estar ordenado — Divide el espacio en dos en cada paso; sin orden previo las comparaciones con el medio no garantizan nada.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué interfaz deben implementar los objetos para que Arrays.sort los ordene con su orden natural?",
                    "opciones": ["a) Comparable", "b) Comparator", "c) Orderable", "d) Sortable"],
                    "respuesta": "a) Comparable — Define compareTo(T otro); p. ej. los String ya son Comparable.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método define la interfaz Comparable?",
                    "opciones": ["a) compareTo(T o)", "b) compare(T a, T b)", "c) compareTo(T a, T b)", "d) equals(T o)"],
                    "respuesta": "a) compareTo(T o) — Devuelve negativo, cero o positivo según este objeto sea menor, igual o mayor que el argumento.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué interfaz permite ordenar una colección con criterios externos sin tocar la clase?",
                    "opciones": ["a) Comparator", "b) Comparable", "c) Orderable", "d) Sortable"],
                    "respuesta": "a) Comparator — Con compare(a, b); se puede pasar a Arrays.sort/Collections.sort y combinarse con lambdas o comparing().",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué método de Collections ordena una List?",
                    "opciones": ["a) Collections.sort(lista)", "b) Collections.order(lista)", "c) Collections.sortList(lista)", "d) Arrays.sort(lista)"],
                    "respuesta": "a) Collections.sort(lista) — Ordena la lista in-place; acepta un Comparator opcional como segundo argumento.",
                },
                {
                    "tipo": "vf",
                    "enunciado": "Aplicar búsqueda binaria a un array desordenado puede devolver resultados incorrectos sin lanzar ninguna excepción.",
                    "respuesta": "Verdadero — El algoritmo asume orden y no lo comprueba: puede devolver -1 o una posición equivocada silenciosamente.",
                },
                {
                    "tipo": "test",
                    "enunciado": "¿Qué algoritmo usa internamente Arrays.sort para objetos en Java moderno (caso promedio O(n log n))?",
                    "opciones": ["a) TimSort (variante de merge sort)", "b) Burbuja", "c) Selección", "d) Inserción"],
                    "respuesta": "a) TimSort — Ordenación estable O(n log n) en el caso promedio; para primitivos usa dual-pivot quicksort.",
                },
                {
                    "tipo": "test",
                    "enunciado": "En la búsqueda binaria, si el valor buscado es MAYOR que el elemento central, ¿en qué mitad se continúa?",
                    "opciones": ["a) En la mitad derecha", "b) En la mitad izquierda", "c) Se termina", "d) Se reinicia el algoritmo"],
                    "respuesta": "a) Mitad derecha — El elemento central descarta toda la mitad izquierda (incluido él mismo).",
                },
            ],
        },
        {
            "titulo": "Parte 2: Análisis y depuración",
            "puntos": "3 puntos",
            "preguntas": [
                {
                    "tipo": "ejercicio",
                    "enunciado": "Este programa busca un valor y a veces dice que no existe aunque sí está. ¿Por qué?",
                    "puntos": "1,5 ptos",
                    "code": "int[] datos = {12, 5, 8, 23, 16, 2};\nint buscado = 16;\nint pos = Arrays.binarySearch(datos, buscado);\nSystem.out.println(pos >= 0 ? \"Encontrado en \" + pos : \"No existe\");",
                    "respuesta": [
                        "Arrays.binarySearch exige un array ordenado; como datos no está ordenado, el resultado es impredecible (puede devolver -1 aunque 16 esté presente).",
                        "Corrección: ordenar antes: Arrays.sort(datos); y luego buscar. Alternativa: búsqueda lineal si no se puede ordenar.",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "¿Por qué este código no compila y cómo se arregla de dos formas distintas?",
                    "puntos": "1,5 ptos",
                    "code": "class Persona {\n    String nombre;\n    int edad;\n    Persona(String n, int e) { nombre = n; edad = e; }\n}\n// ...\nList<Persona> lista = new ArrayList<>();\nlista.add(new Persona(\"Ana\", 25));\nCollections.sort(lista);",
                    "respuesta": [
                        "Collections.sort(lista) exige que Persona implemente Comparable<Persona>; si no, el compilador falla.",
                        "Solución 1: que Persona implemente Comparable<Persona> con compareTo por edad (o nombre).",
                        "Solución 2: pasar un Comparator: Collections.sort(lista, Comparator.comparingInt(p -> p.edad));",
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
                    "enunciado": "Implementa a mano la ordenación por selección: en cada pasada encuentra el mínimo de la parte no ordenada y lo coloca en su sitio. Muéstralo con un array de 5 enteros.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "public class Seleccion {",
                        "    public static void ordenar(int[] a) {",
                        "        for (int i = 0; i < a.length - 1; i++) {",
                        "            int min = i;",
                        "            for (int j = i + 1; j < a.length; j++) {",
                        "                if (a[j] < a[min]) min = j;",
                        "            }",
                        "            int aux = a[i]; a[i] = a[min]; a[min] = aux;",
                        "        }",
                        "    }",
                        "    public static void main(String[] args) {",
                        "        int[] a = {29, 10, 14, 37, 13};",
                        "        ordenar(a);",
                        "        System.out.println(java.util.Arrays.toString(a)); // [10, 13, 14, 29, 37]",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Ordena una lista de alumnos (nombre, nota) por nota descendente y, a igual nota, por nombre ascendente, usando Comparator con lambdas.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "import java.util.*;",
                        "class Alumno {",
                        "    String nombre; double nota;",
                        "    Alumno(String n, double nt) { nombre = n; nota = nt; }",
                        "    public String toString() { return nombre + \" (\" + nota + \")\"; }",
                        "}",
                        "public class OrdenarAlumnos {",
                        "    public static void main(String[] args) {",
                        "        List<Alumno> lista = new ArrayList<>(List.of(",
                        "            new Alumno(\"Ana\", 7.5), new Alumno(\"Luis\", 9.0), new Alumno(\"Eva\", 7.5)));",
                        "        lista.sort(Comparator.comparingDouble((Alumno a) -> a.nota).reversed()",
                        "                    .thenComparing(a -> a.nombre));",
                        "        System.out.println(lista); // [Luis (9.0), Ana (7.5), Eva (7.5)]",
                        "    }",
                        "}",
                    ],
                },
                {
                    "tipo": "ejercicio",
                    "enunciado": "Implementa la búsqueda binaria de forma recursiva (método buscar(int[] a, int objetivo, int ini, int fin)) y pruébala con un array ordenado.",
                    "puntos": "2 ptos",
                    "respuesta": [
                        "public class BusquedaBinaria {",
                        "    static int buscar(int[] a, int objetivo, int ini, int fin) {",
                        "        if (ini > fin) return -1;",
                        "        int medio = (ini + fin) / 2;",
                        "        if (a[medio] == objetivo) return medio;",
                        "        if (objetivo < a[medio]) return buscar(a, objetivo, ini, medio - 1);",
                        "        return buscar(a, objetivo, medio + 1, fin);",
                        "    }",
                        "    public static void main(String[] args) {",
                        "        int[] datos = {2, 5, 8, 12, 16, 23};",
                        "        System.out.println(buscar(datos, 16, 0, datos.length - 1)); // 4",
                        "        System.out.println(buscar(datos, 7, 0, datos.length - 1));  // -1",
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
                    "enunciado": "Compara burbuja, selección e inserción en cuanto a complejidad y estabilidad. ¿Cuándo conviene usar Arrays.sort/Collections.sort en lugar de implementar uno propio?",
                    "respuesta": [
                        "Los tres son O(n²) en el peor caso; inserción es O(n) con datos casi ordenados y es estable; selección no es estable; burbuja es estable pero casi siempre la peor opción.",
                        "Arrays.sort/Collections.sort usan algoritmos O(n log n) (TimSort/dual-pivot quicksort) y están muy optimizados, así que para datos reales siempre conviene usarlos.",
                        "Implementar a mano solo tiene sentido didáctico, con datos muy pequeños, o cuando se necesita un criterio muy concreto de estabilidad o comportamiento.",
                    ],
                },
            ],
        },
    ],
})


def main():
    out_dir = os.path.dirname(os.path.abspath(__file__))
    args = sys.argv[1:] if len(sys.argv) > 1 else ["docx", "pdf"]
    want_docx = "docx" in args
    want_pdf = "pdf" in args
    dark = "dark" in args or "oscuro" in args

    print("Fuente Unicode disponible:", bool(find_font("arial.ttf")))
    print("Modo PDF:", "OSCURO" if dark else "claro")

    for i, ex in enumerate(EXAMENES, start=11):
        nombre = f"Examen_{i}_Java_{ex['subtitulo'].split('·')[-1].strip().replace(' ', '_')}"
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
