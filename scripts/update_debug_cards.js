import fs from 'fs';

const updates = {
  "ex-java-01-11": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
public class Media {
    // static int calcular(int[] n) {               // ❌ ERROR ①: int trunca los decimales
    static double calcular(int[] n) {              // ✅ CORRECTO ①: tipo double para no perder decimales
        int s = 0;
        for (int x : n) {
            s += x;
        }
        // return s / n.length;                     // ❌ ERROR ②: división entera entre enteros pierde decimales
        return (double) s / n.length;              // ✅ CORRECTO ②: casteo a double para división real
    }

    public static void main(String[] args) {
        int[] notas = {5, 7, 9};
        // double m = calcular(notas[]);            // ❌ ERROR ③: sobran los corchetes al pasar el array como argumento
        double m = calcular(notas);                // ✅ CORRECTO ③: pasar solo el identificador del array
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

  "ex-java-02-11": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
public class ArrayBug {
    public static void main(String[] args) {
        int[] n = {1, 2, 3, 4, 5};
        int t = 0;
        // for (int i = 0; i <= n.length; i++) {    // ❌ ERROR ①: índice fuera de rango en la última vuelta (i=5)
        for (int i = 0; i < n.length; i++) {       // ✅ CORRECTO ①: usar condición estricta < n.length
            t += n[i];
        }

        String s1 = "hola";
        String s2 = new String("hola");
        // if (s1 == s2)                            // ❌ ERROR ②: compara referencias en memoria, no contenido
        if (s1.equals(s2)) {                       // ✅ CORRECTO ②: usar equals() para comparar cadenas
            System.out.println("Iguales");
        }

        // s1.toUpperCase();                        // ❌ ERROR ③: String es inmutable; el resultado se pierde
        s1 = s1.toUpperCase();                     // ✅ CORRECTO ③: reasignar el resultado a la variable
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

  "ex-java-04-11": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
abstract class Vehiculo {
    abstract void mover();
}

// class Coche extends Vehiculo { }                // ❌ ERROR ①: no implementa mover() ni es abstracta
class Coche extends Vehiculo {                     // ✅ CORRECTO ①: implementar el método abstracto mover()
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
        v.mover();                                 // Imprime "El coche avanza"
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

  "ex-java-05-11": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
import java.io.*;

public class LeerArchivo {
    public static void main(String[] args) {
        // BufferedReader br = new BufferedReader(new FileReader("datos.txt")); // ❌ ERROR ①: fuga de recursos (nunca se cierra)
        // catch (Throwable e) { ... }             // ❌ ERROR ②: Throwable oculta errores críticos de la JVM
        // ✅ CORRECTO ① y ②: try-with-resources para cierre automático y captura de IOException
        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String linea = br.readLine();
            System.out.println(linea);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

  "ex-java-06-09": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
public class PotenciaBug {
    static int potencia(int base, int exp) {
        // ❌ ERROR ①: falta el caso base (recursión infinita → StackOverflowError)
        if (exp == 0) {
            return 1;                              // ✅ CORRECTO ①: caso base cuando exp == 0 devuelve 1
        }

        // return base * potencia(base, exp + 1);  // ❌ ERROR ②: exp + 1 aleja la llamada del caso base
        return base * potencia(base, exp - 1);     // ✅ CORRECTO ②: reducir el exponente hacia cero (exp - 1)
    }

    public static void main(String[] args) {
        System.out.println(potencia(2, 3));        // 8
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

  "ex-java-07-09": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
public class WrapperBug {
    public static void main(String[] args) {
        Integer n = null;
        // int x = n;                               // ❌ ERROR ①: unboxing automático de null → NullPointerException
        int x = (n != null) ? n : 0;               // ✅ CORRECTO ①: verificar null antes del unboxing

        Integer a = 200;
        Integer b = 200;
        // System.out.println(a == b);              // ❌ ERROR ②: == compara referencias (fuera de -128..127 da false)
        System.out.println(a.equals(b));           // ✅ CORRECTO ②: usar equals() para comparar valores numéricos
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
        // System.out.println(x == y);              // ❌ ERROR ②: compara referencias de objetos, no sus valores
        System.out.println(x.equals(y));           // ✅ CORRECTO ②: usar equals() para comparar objetos Integer
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

// class Persona { ... }                            // ❌ ERROR ①: Persona no es Serializable → NotSerializableException
class Persona implements Serializable {            // ✅ CORRECTO ①: implementar Serializable y declarar serialVersionUID
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

  "ex-java-10-09": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
import java.util.*;
import java.util.stream.*;

public class StreamBug {
    public static void main(String[] args) {
        List<String> nombres = List.of("Ana", "Bea", "Carlos");
        Stream<String> st = nombres.stream();

        // st.forEach(System.out::println);         // ❌ ERROR ①: consume el stream
        // st.filter(s -> s.length() > 2).forEach(System.out::println); // ❌ ERROR ①: reutilizar stream consumido → IllegalStateException
        // ✅ CORRECTO ①: crear un nuevo stream por cada operación terminal
        nombres.stream().forEach(System.out::println);
        nombres.stream().filter(s -> s.length() > 2).forEach(System.out::println);

        // int limite = 2; nombres.stream().filter(s -> s.length() >= limite); limite = 3; // ❌ ERROR ②: variable capturada no es effectively final
        // ✅ CORRECTO ②: no reasignar la variable capturada por la expresión lambda
        final int limite = 2;
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

  "ex-java-12-11": `RESPUESTA / SOLUCIÓN

Código con cada error y su corrección directa:

\`\`\`java
public void buscar(Connection conn, String nombre) {
    // String sql = "SELECT * FROM alumnos WHERE nombre = '" + nombre + "'"; // ❌ ERROR ①: inyección SQL por concatenación de parámetros
    // Statement st = conn.createStatement();   // ❌ ERROR ②: fuga de recursos (no se cierran Statement ni ResultSet)
    // ResultSet rs = st.executeQuery(sql);
    
    // ✅ CORRECTO ① y ②: usar PreparedStatement con comodín '?' y try-with-resources
    String sql = "SELECT id, nombre FROM alumnos WHERE nombre = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
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
    // System.out.println(rs.getString(0));        // ❌ ERROR ①: en JDBC las columnas empiezan en 1 (getString(0) lanza SQLException)
    System.out.println(rs.getString(1));           // ✅ CORRECTO ①: índice base 1 (o por nombre: rs.getString("id"))
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

  "ex-java-13-12": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
JLabel etiqueta = new JLabel("0");
new Thread(() -> {
    for (int i = 1; i <= 10; i++) {
        final int valor = i;
        // etiqueta.setText(String.valueOf(i));     // ❌ ERROR ①: modifica componente Swing fuera del Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {         // ✅ CORRECTO ①: encolar la modificación en el EDT con invokeLater
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

  "ex-java-14-11": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
String email = "a@b.com.extra";
Pattern p = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
Matcher m = p.matcher(email);

// if (m.find())                                   // ❌ ERROR ①: find() busca coincidencias parciales y acepta sufijos inválidos
if (m.matches()) {                                 // ✅ CORRECTO ①: matches() valida la cadena completa de principio a fin
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

  "ex-java-18-11": `RESPUESTA / SOLUCIÓN

Código con el error y su corrección directa:

\`\`\`java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrecioTest {
    @Test
    void iva() {
        double total = 100.0 * 1.21;
        // assertEquals(121.0, total);              // ❌ ERROR ①: comparación exacta de double falla por imprecisión de coma flotante
        assertEquals(121.0, total, 0.001);         // ✅ CORRECTO ①: incluir delta de tolerancia para números de coma flotante
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
        // System.out.println(opt.orElse(caro()));   // ❌ ERROR ①: orElse evalúa siempre el argumento (cálculo innecesario)
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
\`\`\``
};

function applyUpdates(filePath) {
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
