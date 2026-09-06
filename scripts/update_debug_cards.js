import fs from 'fs';

export const updates = {
  // ==================== EXAMEN 1 ====================
  "ex-java-01-11": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
public class Media {
    // static int calcular(int[] n) {   // ❌ ERROR ①: int trunca los decimales
    static double calcular(int[] n) {  // ✅ CORRECTO ①: tipo double para no perder decimales
        int s = 0;
        for (int x : n) {
            s += x;
        }
        // return s / n.length;         // ❌ ERROR ②: división entera entre enteros pierde decimales
        return (double) s / n.length;  // ✅ CORRECTO ②: casteo a double para división real
    }

    public static void main(String[] args) {
        int[] notas = {5, 7, 9};
        // double m = calcular(notas[]); // ❌ ERROR ③: sobran los corchetes al pasar el array
        double m = calcular(notas);     // ✅ CORRECTO ③: pasar solo el identificador del array
        System.out.println("Media: " + m);
    }
}
\`\`\`

1. Tipo de retorno: \`int\` → \`double\` para mantener los decimales del promedio.
2. División con casteo: \`(double) s / n.length\` para forzar división en coma flotante.
3. Invocación de método: \`calcular(notas)\` sin corchetes \`[]\`.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo CalcularMediaArreglo
    Definir notas Como ArregloDeEnteros <- [5, 7, 9]
    Definir suma Como Real <- 0.0
    Para Cada nota En notas Hacer
        suma <- suma + nota
    FinPara
    Definir media Como Real
    media <- suma / notas.longitud()
    Escribir "Media: ", media
FinAlgoritmo
\`\`\``,

  // ==================== EXAMEN 2 ====================
  "ex-java-02-11": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
public class ArrayBug {
    public static void main(String[] args) {
        int[] n = {1, 2, 3, 4, 5};
        int t = 0;
        // for (int i = 0; i <= n.length; i++) { // ❌ ERROR ①: índice fuera de rango en la última vuelta (i=5)
        for (int i = 0; i < n.length; i++) {    // ✅ CORRECTO ①: usar condición estricta < n.length
            t += n[i];
        }

        String s1 = "hola";
        String s2 = new String("hola");
        // if (s1 == s2)        // ❌ ERROR ②: compara referencias en memoria, no contenido
        if (s1.equals(s2)) {   // ✅ CORRECTO ②: usar equals() para comparar cadenas
            System.out.println("Iguales");
        }

        // s1.toUpperCase();    // ❌ ERROR ③: String es inmutable; el resultado se pierde
        s1 = s1.toUpperCase(); // ✅ CORRECTO ③: reasignar el resultado a la variable
        System.out.println(s1);
    }
}
\`\`\`

1. Límite de array: \`i < n.length\` evita \`ArrayIndexOutOfBoundsException\`.
2. Comparación de strings: \`s1.equals(s2)\` en lugar de \`==\`.
3. Inmutabilidad: \`s1 = s1.toUpperCase()\` almacena el nuevo string generado.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo CorregirErroresArrayYStrings
    Definir n Como ArregloDeEnteros <- [1, 2, 3, 4, 5]
    Definir t Como Entero <- 0
    Para i <- 0 Hasta n.longitud() - 1 Con Paso 1 Hacer
        t <- t + n[i]
    FinPara
    
    Definir s1, s2 Como Cadena
    s1 <- "hola"
    s2 <- "hola"
    Si s1 = s2 Entonces
        Escribir "Iguales"
    FinSi
    s1 <- Mayusculas(s1)
    Escribir s1
FinAlgoritmo
\`\`\``,

  // ==================== EXAMEN 3 ====================
  "ex-java-03-11": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
public class Cuenta {
    // String titular;                             // ❌ ERROR ①: falta encapsulamiento (visibilidad de paquete)
    private String titular;                        // ✅ CORRECTO ①: atributo privado encapsulado

    // double saldo;                               // ❌ ERROR ①: falta encapsulamiento (visibilidad de paquete)
    private double saldo;                          // ✅ CORRECTO ①: atributo privado encapsulado

    public Cuenta(String titular, double saldo) {
        // titular = titular;                      // ❌ ERROR ②: asigna el parámetro a sí mismo (shadowing sin this)
        this.titular = titular;                    // ✅ CORRECTO ②: asignar al atributo de la instancia con this

        // saldo = saldo;                          // ❌ ERROR ②: asigna el parámetro a sí mismo (shadowing sin this)
        this.saldo = saldo;                        // ✅ CORRECTO ②: asignar al atributo de la instancia con this
    }

    // (sin métodos getters)                       // ❌ ERROR ③: sin getters no se pueden consultar los atributos
    public String getTitular() { return titular; } // ✅ CORRECTO ③: getter público para leer titular
    public double getSaldo() { return saldo; }     // ✅ CORRECTO ③: getter público para leer saldo

    public void depositar(double m) {
        saldo += m;
    }

    public void retirar(double m) {
        if (saldo >= m) {
            saldo -= m;
        }
    }

    public void mostrar() {
        System.out.println(titular + " " + saldo);
    }
}
\`\`\`

1. **Encapsulación de atributos**: Declarar \`titular\` y \`saldo\` como \`private\` para proteger el estado interno.
2. **Uso de \`this\` en el constructor**: Diferenciar los atributos de los parámetros que comparten el mismo identificador.
3. **Métodos accesores**: Añadir \`getTitular()\` y \`getSaldo()\` para lectura segura desde el exterior.

---
### Pseudocódigo:

\`\`\`pseudocode
Clase CuentaBancaria
    Atributos:
        Privado titular Como Cadena
        Privado saldo Como Real
        
    Constructor(p_titular, p_saldo)
        titular <- p_titular
        saldo <- p_saldo
    FinConstructor
    
    Metodo ingresar(cantidad)
        Si cantidad > 0 Entonces
            saldo <- saldo + cantidad
        FinSi
    FinMetodo
    
    Metodo retirar(cantidad)
        Si (cantidad > 0) Y (cantidad <= saldo) Entonces
            saldo <- saldo - cantidad
        FinSi
    FinMetodo
    
    Metodo consultarSaldo() -> Real
        Devolver saldo
    FinMetodo
FinClase
\`\`\``,

  // ==================== EXAMEN 4 ====================
  "ex-java-04-11": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
abstract class Vehiculo {
    abstract void mover();
}

// class Coche extends Vehiculo { } // ❌ ERROR ①: no implementa mover() ni es abstracta
class Coche extends Vehiculo {      // ✅ CORRECTO ①: implementar el método abstracto mover()
    @Override
    void mover() {
        System.out.println("El coche avanza");
    }
}

class Moto extends Vehiculo {
    @Override
    void mover() {
        System.out.println("La moto avanza");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehiculo v = new Coche();
        v.mover(); // Imprime "El coche avanza"
    }
}
\`\`\`

1. Las subclases no abstractas de una clase abstracta **deben** implementar todos sus métodos abstractos.
2. Al implementar \`mover()\` en \`Coche\`, el polimorfismo invoca correctamente el método en tiempo de ejecución.

---
### Pseudocódigo:

\`\`\`pseudocode
Clase Abstracta Vehiculo
    Metodo Abstracto mover()
FinClase

Clase Coche HeredaDe Vehiculo
    Sobrescribir Metodo mover()
        Escribir "El coche avanza"
    FinMetodo
FinClase

Algoritmo ProbarHerencia
    Definir v Como Vehiculo
    v <- Nuevo Coche()
    v.mover()
FinAlgoritmo
\`\`\``,

  // ==================== EXAMEN 5 ====================
  "ex-java-05-11": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
import java.io.*;

public class LeerArchivo {
    public static void main(String[] args) {
        // try { BufferedReader br = new BufferedReader(new FileReader("datos.txt")); // ❌ ERROR ①: fuga de recursos (br nunca se cierra)
        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {   // ✅ CORRECTO ①: try-with-resources para cierre automático de br
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        // }                      // ❌ ERROR ②: try sin catch (IOException no capturada y error de compilación)
        } catch (IOException e) { // ✅ CORRECTO ②: capturar la excepción específica IOException
            e.printStackTrace();
        }
        System.out.println("Fin");
    }
}
\`\`\`

1. Gestión de recursos: \`try-with-resources\` garantiza que el \`BufferedReader\` se cierre siempre al finalizar.
2. Excepciones: Capturar \`IOException\` específica en lugar de \`Throwable\`.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo LecturaSeguraArchivo
    Intentar
        AbrirRecurso lector <- "datos.txt"
        linea <- lector.leerLinea()
        Escribir linea
    Capturar ExcepcionIO e
        Escribir "Error de lectura: ", e.mensaje
    FinIntentar
FinAlgoritmo
\`\`\``,

  // ==================== EXAMEN 6 ====================
  "ex-java-06-09": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
public class PotenciaBug {
    static int potencia(int base, int exp) {
        // (sin caso base)                         // ❌ ERROR ①: falta el caso base (recursión infinita → StackOverflowError)
        if (exp == 0) return 1;                   // ✅ CORRECTO ①: caso base cuando exp == 0 devuelve 1

        // return base * potencia(base, exp + 1); // ❌ ERROR ②: exp + 1 aleja la llamada del caso base
        return base * potencia(base, exp - 1);    // ✅ CORRECTO ②: reducir el exponente hacia cero (exp - 1)
    }

    public static void main(String[] args) {
        System.out.println(potencia(2, 3)); // 8
    }
}
\`\`\`

1. Caso base: \`if (exp == 0) return 1;\` detiene la recursión cuando el exponente llega a 0.
2. Paso recursivo: \`exp - 1\` converge hacia el caso base.

---
### Pseudocódigo:

\`\`\`pseudocode
Funcion potencia(base, exp) -> Entero
    Si exp = 0 Entonces
        Devolver 1
    FinSi
    Devolver base * potencia(base, exp - 1)
FinFuncion
\`\`\``,

  // ==================== EXAMEN 7 ====================
  "ex-java-07-06": `RESPUESTA / SOLUCIÓN

Verdadero — **Contrato equals/hashCode**: si \`a.equals(b)\` es \`true\`, entonces \`a.hashCode()\` debe ser igual a \`b.hashCode()\`.

Código con el error y su corrección directa:

\`\`\`java
class Persona {
    String nombre;
    Persona(String nombre) { this.nombre = nombre; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Persona)) return false;
        return ((Persona) o).nombre.equals(this.nombre);
    }

    // (sin hashCode() sobrescrito)                                // ❌ ERROR: sin hashCode consistente, objetos iguales caen en cubetas distintas
    @Override public int hashCode() { return nombre.hashCode(); } // ✅ CORRECTO: sobrescribir hashCode() con los mismos campos que equals()
}
\`\`\`

\`\`\`java
Persona p1 = new Persona("Ana");
Persona p2 = new Persona("Ana");
System.out.println(p1.equals(p2)); // true

HashSet<Persona> set = new HashSet<>();
set.add(p1);
set.add(p2);
// System.out.println(set.size()); // ¡2! duplicados no detectados // ❌ ERROR: sin hashCode() set.size() es 2 en vez de 1
System.out.println(set.size());    // 1                            // ✅ CORRECTO: con hashCode() coinciden en cubeta y elimina el duplicado
\`\`\`

- **HashSet y HashMap** usan \`hashCode()\` para ubicar la cubeta de almacenamiento (*bucket*). Si dos objetos iguales tienen distinto hash, jamás se comparan con \`equals()\`.
- **Regla de oro**: si sobrescribes \`equals()\`, debes sobrescribir obligatoriamente \`hashCode()\` con los mismos atributos.`,

  "ex-java-07-09": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
public class WrapperBug {
    public static void main(String[] args) {
        Integer n = null;
        // int x = n;                 // ❌ ERROR ①: unboxing automático de null → NullPointerException
        int x = (n != null) ? n : 0; // ✅ CORRECTO ①: verificar null antes del unboxing

        Integer a = 200;
        Integer b = 200;
        // System.out.println(a == b);      // ❌ ERROR ②: == compara referencias (fuera de -128..127 da false)
        System.out.println(a.equals(b)); // ✅ CORRECTO ②: usar equals() para comparar valores numéricos
    }
}
\`\`\`

1. Unboxing seguro: Comprobar \`n != null\` antes de asignar a primitivo \`int\`.
2. Comparación de Wrappers: Usar siempre \`.equals()\` en lugar de \`==\` para objetos como \`Integer\`, \`Double\`, etc.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo ComprobacionSeguraWrappers
    Definir n Como EnteroObjeto <- Nulo
    Definir x Como Entero
    Si n <> Nulo Entonces
        x <- n.valorPrimitivo()
    Sino
        x <- 0
    FinSi
    
    Definir a, b Como EnteroObjeto
    a <- 200
    b <- 200
    Si a.esIgualA(b) Entonces
        Escribir "Mismo valor"
    FinSi
FinAlgoritmo
\`\`\``,

  // ==================== EXAMEN 8 ====================
  "ex-java-08-09": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
import java.util.*;

public class BorrarPares {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        // for (Integer n : numeros) { if (n % 2 == 0) numeros.remove(n); } // ❌ ERROR ①: remove() en for-each → ConcurrentModificationException
        // ✅ CORRECTO ①: usar Iterator con it.remove() o removeIf()
        Iterator<Integer> it = numeros.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0) {
                it.remove();
            }
        }

        Integer x = numeros.get(0);
        Integer y = numeros.get(1);
        // System.out.println(x == y);      // ❌ ERROR ②: compara referencias de objetos, no sus valores
        System.out.println(x.equals(y)); // ✅ CORRECTO ②: usar equals() para comparar objetos Integer
    }
}
\`\`\`

1. Modificación concurrente: Eliminar elementos mediante \`it.remove()\` o \`numeros.removeIf(...)\`.
2. Comparación de objetos: Usar \`x.equals(y)\`.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo CorregirConcurrenciaLista
    Definir lista Como ListaDeEnteros
    Definir it Como Iterador
    it <- lista.obtenerIterador()
    Mientras it.tieneSiguiente() Hacer
        n <- it.siguiente()
        Si n MOD 2 = 0 Entonces
            it.eliminarActual()
        FinSi
    FinMientras
FinAlgoritmo
\`\`\``,

  // ==================== EXAMEN 9 ====================
  "ex-java-09-09": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
import java.io.*;

public class Guardar {
    public static void main(String[] args) {
        Persona p = new Persona("Ana", 22);

        // ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("p.dat")); // ❌ ERROR ②: fuga de recursos (nunca se cierra)
        // ✅ CORRECTO ②: usar try-with-resources para cierre y vaciado automático
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("p.dat"))) {
            out.writeObject(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// class Persona { ... }                 // ❌ ERROR ①: Persona no es Serializable → NotSerializableException
class Persona implements Serializable { // ✅ CORRECTO ①: implementar Serializable y declarar serialVersionUID
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int edad;

    Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
\`\`\`

1. Interfaz \`Serializable\`: Toda clase a guardar con \`ObjectOutputStream\` debe implementar \`Serializable\`.
2. Cierre de flujos: Usar \`try-with-resources\`.

---
### Pseudocódigo:

\`\`\`pseudocode
Clase Persona Implementa Serializable
    Atributos: nombre Como Cadena, edad Como Entero
FinClase

Algoritmo GuardarObjeto
    Intentar
        AbrirRecurso flujo <- "persona.dat"
        flujo.escribirObjeto(Nueva Persona("Luis", 25))
    Capturar ExcepcionIO e
        Escribir "Error al serializar: ", e.mensaje
    FinIntentar
FinAlgoritmo
\`\`\``,

  // ==================== EXAMEN 10 ====================
  "ex-java-10-09": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
import java.util.*;
import java.util.stream.*;

public class StreamBug {
    public static void main(String[] args) {
        List<String> nombres = List.of("Ana", "Bea", "Carlos");
        Stream<String> st = nombres.stream();

        // st.forEach(System.out::println); st.filter(...); // ❌ ERROR ①: reutilizar stream ya consumido → IllegalStateException
        nombres.stream().forEach(System.out::println);       // ✅ CORRECTO ①: crear un nuevo stream por cada operación terminal
        nombres.stream().filter(s -> s.length() > 2).forEach(System.out::println);

        // int limite = 2; filter(s -> s.length() >= limite); limite = 3; // ❌ ERROR ②: variable capturada no es effectively final
        final int limite = 2;                                            // ✅ CORRECTO ②: declarar la variable final y no reasignarla
        nombres.stream().filter(s -> s.length() >= limite).forEach(System.out::println);
    }
}
\`\`\`

1. Reutilización de Streams: Un stream queda cerrado/consumido tras su primera operación terminal.
2. Variables en lambdas: Deben ser \`final\` o *effectively final* (no reasignadas).

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo CorregirStreamPipeline
    Definir nombres Como ListaDeCadenas <- ["Ana", "Bea", "Carlos"]
    nombres.obtenerStream().filtrar(s -> s.longitud() > 2).paraCada(Escribir)
FinAlgoritmo
\`\`\``,

  // ==================== EXAMEN 11 ====================
  "ex-java-11-05": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
Object cerrojo = new Object();

// cerrojo.wait();       // ❌ ERROR: IllegalMonitorStateException (wait invocado sin monitor sincronizado)
synchronized (cerrojo) { // ✅ CORRECTO: sincronizar obligatoriamente sobre el cerrojo antes de llamar a wait()
    try {
        cerrojo.wait();
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}
\`\`\`

1. \`wait()\`, \`notify()\` y \`notifyAll()\` **exigen** poseer el monitor del objeto. Si se invocan fuera de un bloque o método \`synchronized (objeto)\`, la JVM lanza inmediatamente \`IllegalMonitorStateException\`.
2. Siempre debe capturarse \`InterruptedException\`.`,

  "ex-java-11-11": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
import java.util.concurrent.atomic.AtomicInteger;

public class Carrera {
    // static int contador = 0;                           // ❌ ERROR ①: variable compartida sin sincronización genera condición de carrera
    static AtomicInteger contador = new AtomicInteger(0); // ✅ CORRECTO ①: AtomicInteger garantiza operaciones atómicas thread-safe

    public static void main(String[] args) throws InterruptedException {
        // Thread t1 = new Thread(() -> { for (int i = 0; i < 1000; i++) contador++; }); // ❌ ERROR ②: contador++ no es atómico (pierde incrementos)
        Thread t1 = new Thread(() -> { for (int i = 0; i < 1000; i++) contador.incrementAndGet(); }); // ✅ CORRECTO ②: incremento atómico indivisible

        Thread t2 = new Thread(() -> { for (int i = 0; i < 1000; i++) contador.incrementAndGet(); });
        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println(contador.get()); // 2000 garantizado
    }
}
\`\`\`

1. **Condición de carrera**: \`contador++\` no es una instrucción indivisible a nivel de bytecode; dos hilos pueden sobrescribir sus resultados perdiendo incrementos.
2. **Soluciones**: Usar \`AtomicInteger\` con \`incrementAndGet()\` o envolver el acceso en un método con \`public static synchronized void incrementar()\`.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo CorregirCondicionCarrera
    Clase ContadorSincronizado
        Privado cuenta Como Entero <- 0
        
        Metodo Sincronizado incrementar()
            cuenta <- cuenta + 1
        FinMetodo
        
        Metodo obtenerValor() -> Entero
            Devolver cuenta
        FinMetodo
    FinClase
FinAlgoritmo
\`\`\``,

  "ex-java-11-12": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
public class Bloqueo {
    static final Object A = new Object();
    static final Object B = new Object();

    public static void main(String[] args) {
        // Hilo 1: adquiere A y después B
        new Thread(() -> {
            synchronized (A) {
                try { Thread.sleep(50); } catch (InterruptedException e) {}
                synchronized (B) {
                    System.out.println("Hilo 1");
                }
            }
        }).start();

        // Hilo 2:
        new Thread(() -> {
            // synchronized (B) { synchronized (A) { ... } } // ❌ ERROR ①: adquirir cerrojos en orden inverso (B y luego A) causa deadlock
            synchronized (A) { synchronized (B) {          // ✅ CORRECTO ①: adquirir cerrojos en el mismo orden consistente (A y luego B)
                System.out.println("Hilo 2");
            }}
        }).start();
    }
}
\`\`\`

1. **Deadlock (interbloqueo)**: Ocurre cuando dos hilos retienen un recurso y esperan mutuamente por el recurso retenido por el otro en una espera circular.
2. **Solución**: Jerarquía estricta de adquisición de recursos (adquirir siempre \`A\` antes que \`B\`) o emplear \`tryLock()\` con timeout de \`ReentrantLock\`.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo PrevenirDeadlockBloqueos
    // Regla de oro: todos los hilos deben bloquear los recursos en el MISMO ORDEN
    BloquearRecurso(RecursoA)
    BloquearRecurso(RecursoB)
    EjecutarSeccionCritica()
    LiberarRecurso(RecursoB)
    LiberarRecurso(RecursoA)
FinAlgoritmo
\`\`\``,

  // ==================== EXAMEN 12 ====================
  "ex-java-12-04": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
// Statement st = conn.createStatement(); st.executeQuery("... WHERE user = '" + u + "'"); // ❌ ERROR: concatenar variables permite inyección SQL
String sql = "SELECT * FROM usuarios WHERE user = ? AND pass = ?";                         // ✅ CORRECTO: consulta parametrizada con marcadores '?'
try (PreparedStatement ps = conexion.prepareStatement(sql)) {
    ps.setString(1, u);
    ps.setString(2, p);
    try (ResultSet rs = ps.executeQuery()) {
        // procesar resultado de forma segura
    }
}
\`\`\`

1. La concatenación de cadenas permite alterar la sintaxis SQL (p. ej. \`' OR '1'='1\`).
2. \`PreparedStatement\` precompila la consulta en la base de datos y trata los valores como datos puros, nunca como código ejecutable.`,

  "ex-java-12-11": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
public void buscar(Connection conn, String nombre) {
    // String sql = "SELECT * FROM alumnos WHERE nombre = '" + nombre + "'"; // ❌ ERROR ①: inyección SQL por concatenación de parámetros
    String sql = "SELECT id, nombre FROM alumnos WHERE nombre = ?";        // ✅ CORRECTO ①: consulta parametrizada con '?'

    // Statement st = conn.createStatement();                  // ❌ ERROR ②: fuga de recursos (Statement y ResultSet nunca se cierran)
    try (PreparedStatement ps = conn.prepareStatement(sql)) { // ✅ CORRECTO ②: try-with-resources para cierre automático de ps y rs
        ps.setString(1, nombre);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ": " + rs.getString("nombre"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
\`\`\`

1. Inyección SQL: Usar siempre \`PreparedStatement\` con parámetros \`?\` para sanear la entrada del usuario.
2. Cierre de recursos: \`try-with-resources\` garantiza el cierre de conexiones, sentencias y conjuntos de resultados.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo PrevenirInyeccionSQL
    Definir stmt Como PreparedStatement
    stmt <- conexion.prepararConsulta("SELECT id, nombre FROM alumnos WHERE nombre = ?")
    stmt.establecerCadena(1, nombre)
    resultado <- stmt.ejecutarConsulta()
    Mientras resultado.siguienteFila() Hacer
        Escribir resultado.obtenerEntero("id"), ": ", resultado.obtenerCadena("nombre")
    FinMientras
FinAlgoritmo
\`\`\``,

  "ex-java-12-12": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
ResultSet rs = st.executeQuery("SELECT id, nombre FROM alumnos");
while (rs.next()) {
    // System.out.println(rs.getString(0)); // ❌ ERROR ①: en JDBC las columnas empiezan en 1 (getString(0) lanza SQLException)
    System.out.println(rs.getString(1));    // ✅ CORRECTO ①: índice base 1 (o por nombre: rs.getString("id"))
}
\`\`\`

1. En JDBC, los índices de columna de \`ResultSet\` están indexados a partir de **1**, a diferencia de los arrays de Java que empiezan en **0**.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo TrazaResultSetJDBC
    Mientras rs.siguienteFila() Hacer
        id <- rs.obtenerEntero(1) // Índice base 1
        nombre <- rs.obtenerCadena(2)
        Escribir id, " - ", nombre
    FinMientras
FinAlgoritmo
\`\`\``,

  // ==================== EXAMEN 13 ====================
  "ex-java-13-11": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
import javax.swing.*;
import java.awt.FlowLayout;

public class VentanaSaludar extends JFrame {
    public VentanaSaludar() {
        setLayout(new FlowLayout());
        JButton boton = new JButton("Saludar");
        JLabel saludo = new JLabel(" ");

        boton.addActionListener(e -> saludo.setText("Hola"));

        // add(new JButton("Saludar")); // ❌ ERROR ①: añadir una nueva instancia sin listener en vez del botón configurado
        add(boton);                     // ✅ CORRECTO ①: añadir al contenedor la misma instancia 'boton' con el ActionListener
        add(saludo);

        pack();
        // (olvidar setVisible)         // ❌ ERROR ②: la ventana permanece oculta si no se invoca setVisible(true)
        setVisible(true);               // ✅ CORRECTO ②: hacer visible la interfaz gráfica en pantalla
    }
}
\`\`\`

1. **Registro de listeners**: El componente visual añadido al contenedor debe ser exactamente el mismo objeto sobre el que se registró el \`ActionListener\`.
2. **Visibilidad en Swing**: Los \`JFrame\` son invisibles por defecto hasta que se invoca explícitamente \`setVisible(true)\`.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo RegistrarActionListenerBoton
    Definir boton Como BotonSwing("Pulsar")
    boton.alHacerClic(Evento ->
        Escribir "Botón pulsado correctamente"
    )
    Ventana.anadir(boton)
    Ventana.mostrar()
FinAlgoritmo
\`\`\``,

  "ex-java-13-12": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
JLabel etiqueta = new JLabel("0");
new Thread(() -> {
    for (int i = 1; i <= 10; i++) {
        final int valor = i;
        // etiqueta.setText(String.valueOf(i)); // ❌ ERROR ①: modifica componente Swing fuera del Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {     // ✅ CORRECTO ①: encolar la modificación en el EDT con invokeLater
            etiqueta.setText(String.valueOf(valor));
        });
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}).start();
\`\`\`

1. Regla de hilos en Swing: Toda modificación a componentes visuales debe ejecutarse en el **Event Dispatch Thread (EDT)** usando \`SwingUtilities.invokeLater\`.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo ActualizarSwingEnEDT
    IniciarHiloSegundoPlano(
        Para i <- 1 Hasta 10 Hacer
            EjecutarEnHiloEDT(
                etiqueta.setTexto(i)
            )
            Esperar(500)
        FinPara
    )
FinAlgoritmo
\`\`\``,

  // ==================== EXAMEN 14 ====================
  "ex-java-14-05": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
// String regex = "\d+";  // ❌ ERROR: \d no es un escape de cadena válido en el compilador de Java
String regex = "\\d+";    // ✅ CORRECTO: doble barra \\d para que el String envíe \d al motor de Regex
\`\`\`

1. En Java, el carácter \`\\\` dentro de un literal \`String\` inicia una secuencia de escape del lenguaje (\`\\n\`, \`\\t\`, etc.). Como \`\\d\` no existe en Java, el código no compila.
2. Se debe escribir \`"\\\\d+"\` para que la cadena contenga una barra invertida real que el motor de expresiones regulares interprete como dígito.`,

  "ex-java-14-11": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
String email = "a@b.com.extra";
Pattern p = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
Matcher m = p.matcher(email);

// if (m.find())   // ❌ ERROR ①: find() busca coincidencias parciales y acepta sufijos inválidos
if (m.matches()) { // ✅ CORRECTO ①: matches() valida la cadena completa de principio a fin
    System.out.println("Email válido");
} else {
    System.out.println("Email inválido");
}
\`\`\`

1. \`find()\` busca cualquier coincidencia dentro del texto, permitiendo caracteres extra no deseados al final.
2. \`matches()\` obliga a que toda la cadena coincida exactamente con la expresión regular.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo ValidacionRegexEmailEstricta
    Definir email Como Cadena <- "a@b.com.extra"
    Si EncajaRegexTotal(email, "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$") Entonces
        Escribir "Email válido"
    Sino
        Escribir "Email inválido"
    FinSi
FinAlgoritmo
\`\`\``,

  "ex-java-14-12": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
import java.util.regex.*;

public class ExtraerPrecios {
    public static void main(String[] args) {
        String texto = "Pan 1,20 € - Leche 0,85 €";
        Pattern p = Pattern.compile("(\\d+,\\d{2})");
        Matcher m = p.matcher(texto);

        // if (m.find()) { // ❌ ERROR ①: if solo procesa la primera coincidencia ('1,20') y se detiene
        while (m.find()) { // ✅ CORRECTO ①: while itera sobre todas las coincidencias del texto ('1,20' y '0,85')
            System.out.println(m.group(1));
        }
    }
}
\`\`\`

1. **\`if (m.find())\`**: Avanza el cursor a la primera subcadena coincidente e interrumpe el flujo, omitiendo el resto de datos.
2. **\`while (m.find())\`**: Itera continuamente hasta que no queden más coincidencias en toda la cadena.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo ExtraerTodosPreciosRegex
    Definir texto Como Cadena <- "Pan: 1,20€, Leche: 0,85€"
    Definir matcher Como CoincidenciasRegex
    matcher <- BuscarPatron(texto, "\d+,\d{2}")
    
    Mientras matcher.haySiguienteCoincidencia() Hacer
        Escribir "Precio detectado: ", matcher.obtenerCoincidencia()
    FinMientras
FinAlgoritmo
\`\`\``,

  // ==================== EXAMEN 15 ====================
  "ex-java-15-11": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
import java.util.Arrays;

public class BuscarBinario {
    public static void main(String[] args) {
        int[] datos = {12, 5, 8, 23, 16, 2};
        int buscado = 16;

        // int pos = Arrays.binarySearch(datos, buscado); // ❌ ERROR ①: binarySearch sobre datos desordenados produce resultado erróneo
        Arrays.sort(datos);                               // ✅ CORRECTO ①: ordenar obligatoriamente el array antes de aplicar binarySearch
        int pos = Arrays.binarySearch(datos, buscado);

        System.out.println(pos >= 0 ? "Encontrado en " + pos : "No existe");
    }
}
\`\`\`

1. **Requisito de búsqueda binaria**: El algoritmo asume que el array está ordenado de menor a mayor. Si los datos están desordenados, descarta mitades incorrectas y puede devolver un valor negativo (no encontrado) aunque el elemento sí exista.
2. Si no es posible ordenar el array, debe aplicarse **búsqueda lineal** (\`O(n)\`).

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo CondicionBusquedaBinaria
    Definir datos Como Entero
    Dimension datos[6]
    // 1. OBLIGATORIO: Ordenar antes de buscar
    Ordenar(datos)
    // 2. Ahora sí funciona la búsqueda binaria
    pos <- BusquedaBinaria(datos, 16)
    Escribir "Elemento en posición: ", pos
FinAlgoritmo
\`\`\``,

  "ex-java-15-12": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
import java.util.*;

class Persona {
    String nombre;
    int edad;
    Persona(String n, int e) { nombre = n; edad = e; }
}

public class OrdenarPersonas {
    public static void main(String[] args) {
        List<Persona> lista = new ArrayList<>();
        lista.add(new Persona("Ana", 25));
        lista.add(new Persona("Carlos", 20));

        // Collections.sort(lista); // ❌ ERROR ①: Persona no implementa Comparable (error de compilación)
        // ✅ CORRECTO ① (Solución 1): pasar un Comparator explícito
        Collections.sort(lista, Comparator.comparingInt(p -> p.edad));

        // ✅ CORRECTO ① (Solución 2): hacer que Persona implemente Comparable<Persona> con compareTo
    }
}
\`\`\`

\`\`\`java
// Solución alternativa implementando Comparable:
class PersonaComparable implements Comparable<PersonaComparable> {
    String nombre;
    int edad;

    @Override
    public int compareTo(PersonaComparable otra) {
        return Integer.compare(this.edad, otra.edad); // ✅ CORRECTO: orden natural definido
    }
}
\`\`\`

1. **Error de compilación**: \`Collections.sort(List<T>)\` exige que el tipo genérico \`T\` implemente la interfaz \`Comparable<? super T>\`.
2. **Dos soluciones**:
   - Pasar un comparador externo: \`Collections.sort(lista, Comparator.comparingInt(p -> p.edad))\`.
   - Implementar \`Comparable<Persona>\` y sobrescribir su método \`compareTo\`.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo OrdenarObjetosComparableVsComparator
    // Opción 1: Comparator externo
    OrdenarConComparador(lista, (p1, p2) -> p1.edad - p2.edad)
FinAlgoritmo
\`\`\``,

  // ==================== EXAMEN 16 ====================
  "ex-java-16-11": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
import java.util.ArrayDeque;
import java.util.Deque;

public class ColaEficiente {
    // private ArrayList<String> datos = new ArrayList<>(); // ❌ ERROR ①: ArrayList desplaza todos los elementos en remove(0) con coste O(n)
    private Deque<String> datos = new ArrayDeque<>();       // ✅ CORRECTO ①: ArrayDeque ofrece operaciones de cola en O(1) amortizado

    public void encolar(String s) {
        datos.addLast(s);
    }

    public String desencolar() {
        // return datos.remove(0); // ❌ ERROR ②: coste O(n) por cada desencolado (O(n²) en n operaciones)
        return datos.pollFirst();  // ✅ CORRECTO ②: desencolar del frente en O(1) sin reubicar memoria
    }
}
\`\`\`

1. **Problema de rendimiento**: En \`ArrayList\`, \`remove(0)\` obliga a copiar y desplazar todas las referencias posteriores una posición hacia la izquierda (\`O(n)\`). En un millón de elementos esto degrada gravemente la velocidad.
2. **Solución estándar**: Usar la interfaz \`Queue\` o \`Deque\` implementada por \`ArrayDeque\`, que implementa un array circular con punteros de frente y final con coste \`O(1)\`.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo TrazaColaFIFO
    Definir cola Como Cola
    cola.encolar("A")
    cola.encolar("B")
    Escribir cola.desencolar() // A en O(1)
FinAlgoritmo
\`\`\``,

  "ex-java-16-12": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
public class PilaFija {
    private int[] datos = new int[10];
    private int tope = -1;

    public void push(int v) {
        // datos[++tope] = v; // ❌ ERROR ①: desbordamiento de pila (ArrayIndexOutOfBoundsException al superar capacidad)
        if (tope >= datos.length - 1) throw new IllegalStateException("Pila llena"); // ✅ CORRECTO ①: comprobar límite antes de apilar
        datos[++tope] = v;
    }

    public int pop() {
        // return datos[tope--]; // ❌ ERROR ②: pop sobre pila vacía accede a datos[-1] sin control
        if (tope < 0) throw new IllegalStateException("Pila vacía"); // ✅ CORRECTO ②: comprobar que no esté vacía antes de desapilar
        return datos[tope--];
    }
}
\`\`\`

1. **Desbordamiento (*Stack Overflow*)**: Al insertar más de 10 elementos, \`tope\` llega a 10 y \`datos[10]\` lanza \`ArrayIndexOutOfBoundsException\`.
2. **Subdesbordamiento (*Stack Underflow*)**: Si la pila está vacía (\`tope == -1\`), hacer \`pop()\` intenta leer \`datos[-1]\`.
3. Debe validarse el estado de la pila antes de operar, o bien utilizar \`ArrayDeque<Integer>\` que se redimensiona dinámicamente.

---
### Pseudocódigo:

\`\`\`pseudocode
Clase PilaSegura
    Metodo desapilarSeguro()
        Si No estaVacia() Entonces
            Devolver elementos.eliminarUltimo()
        Sino
            LanzarError("Pila vacía")
        FinSi
    FinMetodo
FinClase
\`\`\``,

  // ==================== EXAMEN 17 ====================
  "ex-java-17-11": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
import java.io.*;

public class LeerEficiente {
    public static void main(String[] args) {
        // FileReader fr = new FileReader("datos.txt"); // ❌ ERROR ①: lectura byte a byte lenta y fuga de recursos sin try-with-resources
        // ✅ CORRECTO ①: try-with-resources con BufferedReader y lectura línea a línea
        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
\`\`\`

1. **Fuga de recursos**: Al no usar \`try-with-resources\` ni bloque \`finally\`, si surge una excepción el flujo queda abierto consumiendo descriptores del sistema operativo.
2. **Rendimiento**: \`read()\` directo hace una petición al kernel por cada carácter. \`BufferedReader\` carga bloques completos en memoria RAM.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo LecturaBufferizadaSegura
    Intentar
        AbrirRecurso lector <- "datos.txt"
        linea <- lector.leerLinea()
        Mientras linea <> Nulo Hacer
            Escribir linea
            linea <- lector.leerLinea()
        FinMientras
    Capturar ExcepcionIO e
        Escribir "Error: ", e.mensaje
    FinIntentar
FinAlgoritmo
\`\`\``,

  "ex-java-17-12": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
import java.io.*;

public class CopiaBug {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("a.txt"));
             PrintWriter pw = new PrintWriter(new FileWriter("b.txt"))) {

            // while (br.readLine() != null) { pw.println(br.readLine()); } // ❌ ERROR ①: doble llamada a readLine() salta líneas impares
            String linea;
            while ((linea = br.readLine()) != null) {                      // ✅ CORRECTO ①: almacenar en variable la línea para no saltar ninguna
                pw.println(linea);
            }
        }
    }
}
\`\`\`

1. **Doble lectura**: \`br.readLine()\` avanza el puntero de lectura cada vez que es llamado. Al evaluarlo en la condición del \`while\` lee la línea 1; luego dentro del cuerpo lee la línea 2 y la escribe. La línea 1 se pierde por completo.
2. **Solución**: Asignar el resultado de la lectura a una variable local \`linea\` en la propia condición del bucle.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo CopiaSeguraLineas
    Mientras (linea <- lector.leerLinea()) <> Nulo Hacer
        escritor.escribirLinea(linea)
    FinMientras
FinAlgoritmo
\`\`\``,

  // ==================== EXAMEN 18 ====================
  "ex-java-18-11": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrecioTest {
    @Test
    void iva() {
        double total = 100.0 * 1.21;
        // assertEquals(121.0, total);      // ❌ ERROR ①: comparación exacta de double falla por imprecisión de coma flotante
        assertEquals(121.0, total, 0.001); // ✅ CORRECTO ①: incluir delta de tolerancia para números de coma flotante
    }
}
\`\`\`

1. En operaciones de punto flotante en binario (\`double\`), las operaciones como \`100.0 * 1.21\` producen pequeñas desviaciones (\`120.99999999999999\`).
2. En JUnit, \`assertEquals\` con \`double\` requiere un tercer parámetro de tolerancia (*delta*).

---
### Pseudocódigo:

\`\`\`pseudocode
Clase PrecioTest
    @Test
    Metodo testIva()
        total <- 100.0 * 1.21
        AfirmarIgualesConTolerancia(121.0, total, 0.001)
    FinMetodo
FinClase
\`\`\``,

  "ex-java-18-12": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
public class Util {
    public static String iniciales(String nombre) {
        String[] partes = nombre.split(" ");
        String res = "";
        // for (int i = 0; i <= partes.length; i++) { // ❌ ERROR ①: i <= partes.length produce ArrayIndexOutOfBoundsException en la última vuelta
        for (int i = 0; i < partes.length; i++) {     // ✅ CORRECTO ①: condición estricta i < partes.length para no desbordar el array
            res += partes[i].charAt(0);
        }
        return res;
    }
}
\`\`\`

1. **Índice fuera de límites**: Para un array de 2 elementos (\`length = 2\`), los índices válidos son \`0\` y \`1\`. Al usar \`<=\`, la última iteración intenta acceder a \`partes[2]\`, lanzando \`ArrayIndexOutOfBoundsException\`.
2. El test JUnit falla al interceptar la excepción no prevista. La corrección consiste en usar \`i < partes.length\`.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo ExtraerInicialesArray
    Para i <- 0 Hasta partes.longitud() - 1 Con Paso 1 Hacer
        res <- res + primerCaracter(partes[i])
    FinPara
    Devolver res
FinAlgoritmo
\`\`\``,

  // ==================== EXAMEN 19 ====================
  "ex-java-19-11": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
public class Configuracion {
    // private static Configuracion instancia;        // ❌ ERROR ①: sin volatile los cambios pueden no ser visibles entre distintos hilos
    private static volatile Configuracion instancia; // ✅ CORRECTO ①: volatile garantiza visibilidad inmediata de la referencia entre hilos

    // public String idioma = "es";                   // ❌ ERROR ②: atributo público rompe el encapsulamiento de la clase
    private String idioma = "es";                     // ✅ CORRECTO ②: atributo privado con métodos getter y setter

    private Configuracion() { }

    // public static Configuracion getInstance() { if (instancia == null) instancia = new Configuracion(); } // ❌ ERROR ③: condición de carrera
    public static Configuracion getInstance() {      // ✅ CORRECTO ③: patrón Double-Checked Locking para acceso concurrente seguro
        if (instancia == null) {
            synchronized (Configuracion.class) {
                if (instancia == null) {
                    instancia = new Configuracion();
                }
            }
        }
        return instancia;
    }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
}
\`\`\`

1. **Condición de carrera**: En un entorno multi-hilo, si dos hilos evalúan \`instancia == null\` simultáneamente, ambos crean objetos distintos violando el patrón Singleton.
2. **Double-Checked Locking**: Sincroniza solo la primera vez que se instancia el objeto, manteniendo el rendimiento en las lecturas posteriores.

---
### Pseudocódigo:

\`\`\`pseudocode
Clase PatronSingleton
    Privado Estatico Volatil instancia Como Configuracion <- Nulo
    
    Metodo Estatico obtenerInstancia() -> Configuracion
        Si instancia = Nulo Entonces
            BloquearClase()
            Si instancia = Nulo Entonces
                instancia <- Nueva Configuracion()
            FinSi
            DesbloquearClase()
        FinSi
        Devolver instancia
    FinMetodo
FinClase
\`\`\``,

  "ex-java-19-12": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
// public void enviar(String tipo, String mensaje) { if (...) else if (...) } // ❌ ERROR ①: viola Open/Closed al acoplar creación y envío
// ✅ CORRECTO ①: desacoplar mediante interfaz y Factory Method polimórfico

interface Canal {
    void enviar(String mensaje);
}

class EmailCanal implements Canal {
    public void enviar(String msg) { System.out.println("Email: " + msg); }
}

class SMSCanal implements Canal {
    public void enviar(String msg) { System.out.println("SMS: " + msg); }
}

public class CanalFactory {
    public static Canal crear(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "email" -> new EmailCanal();
            case "sms" -> new SMSCanal();
            default -> throw new IllegalArgumentException("Canal desconocido: " + tipo);
        };
    }
}
\`\`\`

1. **Principio Open/Closed**: Toda nueva vía de notificación obligaba a modificar el método original con más ramas \`if-else\`.
2. **Factory Method**: Cada nuevo canal se implementa como una clase independiente sin alterar la lógica existente.

---
### Pseudocódigo:

\`\`\`pseudocode
Clase PatronFactoryNotificaciones
    Metodo Estatico crearNotificacion(tipo) -> Canal
        Segun tipo Hacer
            "EMAIL": Devolver Nueva NotificacionEmail()
            "SMS":   Devolver Nueva NotificacionSMS()
            De Otro Modo: Lanzar ExcepcionTipoDesconocido()
        FinSegun
    FinMetodo
FinClase
\`\`\``,

  // ==================== EXAMEN 20 ====================
  "ex-java-20-11": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
import java.util.Optional;

public class Defecto {
    static String caro() {
        System.out.println("Calculando...");
        return "valor caro";
    }

    public static void main(String[] args) {
        Optional<String> opt = Optional.of("presente");
        // System.out.println(opt.orElse(caro()));        // ❌ ERROR ①: orElse evalúa siempre el argumento (cálculo innecesario)
        System.out.println(opt.orElseGet(Defecto::caro)); // ✅ CORRECTO ①: orElseGet solo evalúa la función si el Optional está vacío
    }
}
\`\`\`

1. \`orElse(valor)\` evalúa la expresión siempre por anticipado.
2. \`orElseGet(Supplier)\` evalúa la función de forma perezosa (*lazy*), únicamente cuando el \`Optional\` está vacío.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo EvaluarOptionalPerezoso
    Definir opt Como Optional(Cadena) <- Optional("presente")
    // orElseGet solo invoca calcularValorCaro si opt está vacío
    Escribir opt.obtenerOSiNoLlamar(() -> calcularValorCaro())
FinAlgoritmo
\`\`\``,

  "ex-java-20-12": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
import java.util.*;

public class FiltroLista {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        // for (Integer n : nums) { if (n % 2 == 0) nums.remove(n); } // ❌ ERROR ①: remove() directo dentro de for-each lanza ConcurrentModificationException
        nums.removeIf(n -> n % 2 == 0);                               // ✅ CORRECTO ①: usar removeIf() para eliminar elementos de forma segura

        // Alternativa con Iterator explícito:
        // Iterator<Integer> it = nums.iterator();
        // while (it.hasNext()) { if (it.next() % 2 == 0) it.remove(); } // ✅ CORRECTO: it.remove() sobre iterador explícito

        System.out.println(nums); // [1, 3, 5]
    }
}
\`\`\`

1. **Modificación concurrente**: El bucle \`for-each\` utiliza un \`Iterator\` oculto. Si se invoca \`nums.remove(n)\` directamente sobre la lista durante la iteración, el iterador detecta que la estructura cambió y lanza \`ConcurrentModificationException\`.
2. **Soluciones**: Usar el método funcional \`removeIf()\` o un \`Iterator\` explícito llamando a \`it.remove()\`.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo FiltrarElementosLista
    Definir it Como Iterador <- lista.obtenerIterador()
    Mientras it.tieneSiguiente() Hacer
        Si it.siguiente() MOD 2 = 0 Entonces
            it.eliminarActual()
        FinSi
    FinMientras
FinAlgoritmo
\`\`\``,

  // ==================== ARRAYS & CONCEPTOS ====================
  "ex-java-arr-20": `RESPUESTA / SOLUCIÓN

Traza línea por línea con cada error y su corrección directa:

\`\`\`java
public class TrazaArrays {
    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 10};
        int[] b = a;            // ✅ b apunta al MISMO array que a (alias de referencia)
        b[0] = 99;              // Modifica el array compartido
        System.out.println(a[0]); // → 99  (a y b son el MISMO objeto)

        int[] c = new int[a.length];
        System.arraycopy(a, 0, c, 0, a.length); // ✅ COPIA real independiente de los valores
        c[1] = 77;              // Modifica solo c
        System.out.println(a[1]); // → 4  (a NO se ve afectado)

        int[] d = {1, 2, 3};
        intercambiar(d, 0, 2);  // ✅ Modifica d porque arr apunta al MISMO array
        System.out.println(d[0] + " " + d[2]); // → 3 1

        int[] e = {5, 10, 15};
        // duplicar(e);         // ❌ ERROR: la función duplicar original no modifica 'e' (paso por valor de la referencia)
        duplicar(e);            // ✅ CORRECTO: con el método corregido in-place, 'e' sí se modifica
        System.out.println(e[0]); // → 10 (con método in-place) o 5 (original)
    }

    static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // static void duplicar(int[] arr) { arr = new int[]{arr[0]*2, arr[1]*2, arr[2]*2}; } // ❌ ERROR: reasignar 'arr = new int[]' solo cambia la copia local
    static void duplicar(int[] arr) {                                                      // ✅ CORRECTO: modificar el contenido del array original in-place
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }
}
\`\`\`

**Salida original:**
\`\`\`
99
4
3 1
5
\`\`\`

**Conceptos que evalúa** (trampa clásica de examen):
1. **\`b = a\`** → alias, NO copia. Ambos apuntan al mismo array.
2. **\`System.arraycopy\`** → copia REAL independiente en nueva memoria.
3. **Modificar contenido** (\`arr[i] = x\`) en un método SÍ afecta al array original porque la referencia apunta al mismo objeto.
4. **Reasignar la referencia** (\`arr = new int[]{...}\`) solo cambia la variable local del método. El array exterior queda intacto.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo TrazaArrays
    Definir a <- [2, 4, 6, 8, 10]
    Definir b <- a         // Alias compartido
    b[0] <- 99
    Escribir a[0]          // 99
    Definir c <- Copiar(a) // Copia independiente
    c[1] <- 77
    Escribir a[1]          // 4
FinAlgoritmo
\`\`\``,

  "ex-java-21-23": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
int cajon = 2;
switch (cajon) {
    case 1:
        System.out.println("Uno");
        break;
    case 2:
        System.out.println("Dos");
        // (olvidar break aquí) // ❌ ERROR: olvidar break provoca fall-through indeseado ejecutando los siguientes case
        break;                  // ✅ CORRECTO: break detiene la ejecución del switch al terminar el caso
    case 3:
        System.out.println("Tres");
        break;
    default:
        System.out.println("Fin");
}
\`\`\`

- En Java, si omites el **\`break;\`** al final de un \`case\`, el flujo continúa ejecutando en cascada (*fall-through*) las instrucciones de los siguientes casos sin comprobar si sus condiciones coinciden.
- Salida con el error (sin break en case 2): \`Dos\`, \`Tres\`, \`Fin\`.
- Salida correcta (con break): exclusivamente \`Dos\`.

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo ImportanciaBreakEnSwitch
    Segun opcion Hacer
        1:
            Escribir "Opción 1"
        2:
            Escribir "Opción 2"
            // break evita saltar a los siguientes casos
    FinSegun
FinAlgoritmo
\`\`\``,

  "ex-java-21-31": `RESPUESTA / SOLUCIÓN

**Solo dentro del bucle** (ámbito de bloque): al terminar, la variable deja de existir.

Código con el error y su corrección directa:

\`\`\`java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
// System.out.println(i);                                      // ❌ ERROR: 'i' no existe fuera del bucle (ámbito local al for)
// int i; for (i = 0; i < 10; i++) { } System.out.println(i); // ✅ CORRECTO: declarar 'i' antes del bucle si se requiere usar tras finalizar
\`\`\`

- A diferencia de JavaScript (\`var\` "se escapa" del bucle), en Java la variable declarada en la cabecera del \`for\` tiene **ámbito de bloque**.
- Si necesitas su valor tras finalizar el bucle:

\`\`\`java
int i;
for (i = 0; i < 10; i++) { }
System.out.println(i);   // ✅ 10
\`\`\`

---
### Pseudocódigo:

\`\`\`pseudocode
Algoritmo AmbitoVariableBucle
    Para i <- 0 Hasta 4 Con Paso 1 Hacer
        Escribir "Dentro del bucle: ", i
    FinPara
    // Fuera de aquí 'i' ya no existe
FinAlgoritmo
\`\`\``
};

function applyUpdates(filePath) {
  if (!fs.existsSync(filePath)) return;
  const data = JSON.parse(fs.readFileSync(filePath, 'utf8'));
  let count = 0;

  data.cards.forEach(card => {
    if (updates[card.id]) {
      card.back = updates[card.id];
      count++;
    }
  });

  fs.writeFileSync(filePath, JSON.stringify(data, null, 2), 'utf8');
  console.log(`Updated ${count} debug cards in ${filePath}`);
}

applyUpdates('public/data/examenes/examen-java-ejercicios.json');
applyUpdates('public/data/examenes/examen-java.json');
applyUpdates('public/data/examenes/examen-java-test.json');
