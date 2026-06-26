// CONTENIDO COMPLETO de todas las cards (campo 'back')
// =============================================================

// Error parseando cards_java_t1_introduccion.json: Se ha pasado un objeto no válido. Se esperaba ':' o '}'. (1552): {
  "id": "cards-java-t1",
  "name": "Java - Tema 1: Introducción a la programación",
  "description": "Cards sobre algoritmos, pseudocódigo, diagramas de flujo, variables, expresiones aritméticas, operadores relacionales y lógicos del curso IOC - Aula en la nube",
  "subject": "Programación - Java",
  "deck": "Java",
  "cards": [
    {
      "id": "java-t1-001",
      "front": "¿Qué es un algoritmo?",
      "back": "Un algoritmo es un conjunto de instrucciones (pasos) ordenadas y finitas que permiten resolver un problema.

Características:
- Preciso: cada paso debe estar claramente definido.
- Ordenado: los pasos deben ejecutarse en un orden específico.
- Finito: debe terminar después de un número determinado de pasos.

Ejemplo: Receta de cocina, instrucciones de montaje, algoritmo de ordenación.",
      "tags": ["java", "algoritmo", "definicion", "tema-1"],
      "difficulty": "easy"
    },
    {
      "id": "java-t1-002",
      "front": "¿Qué es un pseudocódigo y cómo se representa un algoritmo?",
      "back": "El pseudocódigo es una forma de representar algoritmos utilizando un lenguaje cercano al humano pero con estructura de programación.

NO es código real, es una mezcla de lenguaje natural y estructura de programación.

Formas de representar algoritmos:
1. Pseudocódigo: lenguaje cercano al humano.
2. Diagramas de flujo: representación gráfica con figuras geométricas.
3. Lenguaje de programación: código ejecutable (Java, Python, etc.).

Ejemplo de pseudocódigo:
INICIO
  LEER nota
  SI nota >= 5 ENTONCES
    ESCRIBIR "Aprobado"
  SINO
    ESCRIBIR "Suspenso"
  FIN SI
FIN",
      "tags": ["java", "algoritmo", "pseudocodigo", "representacion", "tema-1"],
      "difficulty": "easy"
    },
    {
      "id": "java-t1-003",
      "front": "¿Qué es una variable en programación?",
      "back": "Una variable es un espacio en memoria que almacena un valor que puede cambiar durante la ejecución del programa.

Características:
- Tiene un nombre (identificador).
- Tiene un tipo de datos (determina qué valores puede contener).
- Tiene un valor que se puede modificar.

Ejemplo:
contador = 0     // declaración e inicialización
contador = 5     // la variable cambia de valor
contador = 10    // vuelve a cambiar

Reglas para nombres de variables:
- Deben empezar con letra o guión bajo.
- No pueden contener espacios.
- Sensibles a mayúsculas/minúsculas (edad != Edad).
- No pueden ser palabras reservadas del lenguaje.",
      "tags": ["java", "variables", "memoria", "tema-1"],
      "difficulty": "easy"
    },
    {
      "id": "java-t1-004",
      "front": "¿Qué son los operadores relacionales y cuáles son?",
      "back": "Los operadores relacionales se usan para COMPARAR dos valores. El resultado siempre es un valor BOOLEANO (true o false).

>   Mayor que         5 > 3 → true
<   Menor que         5 < 3 → false
>=  Mayor o igual    5 >= 5 → true
<=  Menor o igual    5 <= 3 → false
==  Igual a          5 == 5 → true
!=  Distinto de      5 != 5 → false

Ejemplo en pseudocódigo:
SI edad >= 18 ENTONCES
  ESCRIBIR "Eres mayor de edad"
FIN SI

OJO: == es comparación, = es asignación (son diferentes).",
      "tags": ["java", "operadores", "relacionales", "comparacion", "tema-1"],
      "difficulty": "easy"
    },
    {
      "id": "java-t1-005",
      "front": "¿Qué son los operadores lógicos y cuáles son?",
      "back": "Los operadores lógicos combinan condiciones booleanas. Trabajan con valores true/false.

Y (AND) - Símbolo: ∧ o AND
- SÓLO si las dos condiciones son true → resultado true.
- true ∧ true = true
- true ∧ false = false
- false ∧ true = false
- false ∧ false = false

O (OR) - Símbolo: ∨ o OR
- Con que UNA sea true → resultado true.
- true ∨ true = true
- true ∨ false = true
- false ∨ true = true
- false ∨ false = false

NO (NOT) - Símbolo: ¬ o NOT
- Invierte el valor: ¬true = false, ¬false = true

Ejemplo:
SI (edad >= 18) Y (tiene_carnet = true) ENTONCES
  "Puede conducir"
FIN SI",
      "tags": ["java", "operadores", "logicos", "AND", "OR", "NOT", "tema-1"],
      "difficulty": "easy"
    },
    {
      "id": "java-t1-006",
      "front": "¿Qué son las expresiones aritméticas y cuál es la prioridad de operadores?",
      "back": "Las expresiones aritméticas combinan números y operadores para producir un resultado numérico.

Operadores:
+  Suma
-  Resta
*  Multiplicación
/  División
%  Módulo (resto de la división)

Prioridad (de mayor a menor):
1. Paréntesis ()
2. Multiplicación *, división /, módulo %
3. Suma +, resta -

Ejemplo:
2 + 3 * 4 = 2 + 12 = 14
(2 + 3) * 4 = 5 * 4 = 20
17 % 5 = 2 (resto de dividir 17 entre 5 = 3*5=15, resto=2)

Los paréntesis anidados se resuelven de dentro hacia fuera.",
      "tags": ["java", "expresiones", "aritmeticas", "prioridad", "operadores", "tema-1"],
      "difficulty": "easy"
    },
    {
      "id": "java-t1-007",
      "front": "¿Qué son las estructuras de control alternativas (condicionales)?",
      "back": "Permiten ejecutar un bloque de código u otro según una condición.

Tipos:

1. SI ENTONCES (if):
SI (condición) ENTONCES
  // código si condición es true
FIN SI

2. SI ENTONCES SI NO (if-else):
SI (condición) ENTONCES
  // código si true
SI NO
  // código si false
FIN SI

3. SEGUN (switch):
SEGUN (variable) HACER
  CASO valor1: instrumentos
  CASO valor2: instrumentos
  ...
FIN SEGUN

Ejemplo:
SI (nota >= 5) ENTONCES
  ESCRIBIR "Aprobado"
SI NO
  ESCRIBIR "Suspenso"
FIN SI",
      "tags": ["java", "estructuras", "control", "condicionales", "if", "switch", "tema-1"],
      "difficulty": "easy"
    }
  ]
}
// Error parseando cards_java_t2_introduccion_java.json: Se ha pasado un objeto no válido. Se esperaba ':' o '}'. (472): {
  "id": "cards-java-t2",
  "name": "Java - Tema 2: Introducción a Java",
  "description": "Cards del curso Java IOC - Sintaxis básica, tipos, variables, Strings, Scanner, condicionales, bucles, arrays",
  "subject": "Programación - Java",
  "deck": "Java",
  "cards": [
    {
      "id": "java-t2-001",
      "front": "¿Cómo se escribe un 'Hola Mundo' en Java?",
      "back": "class HolaMundo {
    public static void main(String[] args) {
        System.out.println("Hola Mundo");
    }
}

Estructura básica:
- class NombreClase { ... } → define la clase.
- public static void main(String[] args) → método principal (entrada del programa).
- System.out.println() → imprime texto en pantalla y salta de línea.
- System.out.print() → imprime SIN saltar de línea.

El nombre de la clase debe coincidir con el nombre del archivo .java.
El método main es obligatorio para que un programa sea ejecutable.",
      "tags": ["java", "hola-mundo", "main", "sintaxis", "tema-2"],
      "difficulty": "easy"
    },
    {
      "id": "java-t2-002",
      "front": "¿Cuáles son los tipos de datos primitivos en Java?",
      "back": "byte → 8 bits, entero (-128 a 127)
short → 16 bits, entero (-32.768 a 32.767)
int → 32 bits, entero (-2^31 a 2^31-1)
long → 64 bits, entero (con L al final: 100L)
float → 32 bits, decimal (con f al final: 3.14f)
double → 64 bits, decimal (3.14)
char → 16 bits, caracter Unicode ('A', 'ñ', '\u00F1')
boolean → true o false

String NO es primitivo, es una clase.

Ejemplo:
int edad = 25;
double precio = 19.99;
char letra = 'A';
boolean activo = true;",
      "tags": ["java", "tipos", "datos", "primitivos", "variables", "tema-2"],
      "difficulty": "easy"
    },
    {
      "id": "java-t2-003",
      "front": "¿Cómo se declaran e inicializan variables en Java?",
      "back": "Sintaxis: tipo nombre = valor;

int numero = 10;
double precio = 9.99;
String texto = "Hola";
boolean mayor = true;

Reglas:
- El nombre debe empezar con letra, _ o $. NO con número.
- Sensible a mayúsculas/minúsculas (contador != Contador).
- No usar palabras reservadas (class, int, if, etc.).
- Convención: usar camelCase (miVariable, numeroAlumnos).

Declarar sin inicializar (luego se asigna):
int edad;
edad = 25;

Múltiples variables en una línea:
int a, b, c;
int x = 1, y = 2;",
      "tags": ["java", "variables", "declaracion", "inicializacion", "sintaxis", "tema-2"],
      "difficulty": "easy"
    },
    {
      "id": "java-t2-004",
      "front": "¿Qué métodos principales tiene la clase String en Java?",
      "back": "String es una clase (NO primitivo). Sus objetos son INMUTABLES.

Principales métodos:

.length() → longitud del String
"Hola".length() → 4

.charAt(pos) → caracter en posición
"Hola".charAt(1) → 'o'

.substring(inicio, fin) → subcadena
"Hola".substring(1, 3) → "ol"

.equals(otro) → compara contenido (== compara referencias)
"Hola".equals("Hola") → true

.equalsIgnoreCase(otro) → igual ignorando mayúsculas

.indexOf(caracter) → primera posición donde aparece
"Hola".indexOf('o') → 1

.toUpperCase() / .toLowerCase() → convertir mayúsculas/minúsculas

.trim() → elimina espacios al inicio y final

.replace(viejo, nuevo) → reemplaza caracteres

.split(regex) → divide el String en un array",
      "tags": ["java", "String", "metodos", "cadenas", "tema-2"],
      "difficulty": "medium"
    },
    {
      "id": "java-t2-005",
      "front": "¿Cómo se lee entrada del usuario con Scanner en Java?",
      "back": "import java.util.Scanner;

Scanner entrada = new Scanner(System.in);

String texto = entrada.nextLine();     // leer línea completa
int num = entrada.nextInt();           // leer entero
double decimal = entrada.nextDouble(); // leer decimal

Ejemplo:
Scanner sc = new Scanner(System.in);
System.out.print("Dime tu nombre: ");
String nombre = sc.nextLine();
System.out.print("Dime tu edad: ");
int edad = sc.nextInt();
System.out.println("Te llamas " + nombre + " y tienes " + edad + " años");
sc.close();  // cerrar al terminar

OJO: nextInt() no consume el salto de línea. Si mezclas nextInt() y nextLine(), puede dar problemas (el nextLine() coge el 
 pendiente).",
      "tags": ["java", "Scanner", "entrada", "usuario", "input", "tema-2"],
      "difficulty": "medium"
    },
    {
      "id": "java-t2-006",
      "front": "¿Cómo funciona el if-else en Java?",
      "back": "if (condicion) {
    // código si condición es true
} else if (otraCondicion) {
    // código si otraCondicion es true
} else {
    // código si ninguna es true
}

Ejemplo:
int nota = 7;
if (nota >= 5) {
    System.out.println("Aprobado");
} else {
    System.out.println("Suspenso");
}

If-else anidados:
if (nota >= 9) {
    System.out.println("Sobresaliente");
} else if (nota >= 7) {
    System.out.println("Notable");
} else if (nota >= 5) {
    System.out.println("Aprobado");
} else {
    System.out.println("Suspenso");
}

Las llaves son opcionales si solo hay UNA línea de código.
La condición debe ser una expresión booleana (true/false).",
      "tags": ["java", "if", "else", "condicionales", "control", "tema-2"],
      "difficulty": "easy"
    },
    {
      "id": "java-t2-007",
      "front": "¿Cómo funciona el switch en Java?",
      "back": "switch (variable) {
    case valor1:
        // código
        break;
    case valor2:
        // código
        break;
    default:
        // código si ninguno
}

Ejemplo:
int dia = 3;
switch (dia) {
    case 1:
        System.out.println("Lunes");
        break;
    case 2:
        System.out.println("Martes");
        break;
    case 3:
        System.out.println("Miércoles");
        break;
    default:
        System.out.println("Día no válido");
}

Funciona con: byte, short, int, char, String (Java 7+), enum.
break → sale del switch. Si no se pone, continúa al siguiente case (fall-through).
dafault → opcional, se ejecuta si ningún case coincide.

Java 14+ también tiene switch expresión con ->",
      "tags": ["java", "switch", "condicionales", "control", "tema-2"],
      "difficulty": "medium"
    },
    {
      "id": "java-t2-008",
      "front": "¿Cómo funciona el operador ternario en Java?",
      "back": "Sintaxis: condición ? valor_si_true : valor_si_false

Es una forma abreviada de if-else que devuelve un valor.

Ejemplo:
int edad = 18;
String mensaje = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
System.out.println(mensaje);

Equivalente con if-else:
String mensaje;
if (edad >= 18) {
    mensaje = "Mayor de edad";
} else {
    mensaje = "Menor de edad";
}

Se puede anidar (no recomendado):
int nota = 7;
String resultado = (nota >= 9) ? "Sobre" : (nota >= 7) ? "Notable" : "Apro";

Útil para asignaciones rápidas y return condicional.",
      "tags": ["java", "ternario", "operador", "condicional", "tema-2"],
      "difficulty": "medium"
    },
    {
      "id": "java-t2-009",
      "front": "¿Cómo funcionan los bucles while y do-while en Java?",
      "back": "WHILE: repite mientras la condición sea true. Puede ejecutarse 0 veces.
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}

DO-WHILE: ejecuta al menos 1 vez, luego repite mientras condición true.
int i = 0;
do {
    System.out.println(i);
    i++;
} while (i < 5);

Diferencia clave:
- while: primero comprueba, luego ejecuta.
- do-while: primero ejecuta, luego comprueba.

Ejemplo menú (típico uso do-while):
String opcion;
do {
    System.out.println("1. Opción 1");
    System.out.println("2. Salir");
    opcion = scanner.nextLine();
} while (!opcion.equals("2"));",
      "tags": ["java", "while", "do-while", "bucles", "iteracion", "tema-2"],
      "difficulty": "medium"
    },
    {
      "id": "java-t2-010",
      "front": "¿Cómo funciona el bucle for en Java?",
      "back": "for (inicialización; condición; incremento) {
    // código a repetir
}

Ejemplo básico:
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}  // Imprime 0, 1, 2, 3, 4

Partes:
1. Inicialización: se ejecuta UNA VEZ al principio.
2. Condición: se evalúa antes de cada iteración.
3. Incremento: se ejecuta al final de cada iteración.

Ejemplo decreciente:
for (int i = 10; i > 0; i--) {
    System.out.println(i);
}

Ejemplo con paso de 2:
for (int i = 0; i < 10; i += 2) {
    System.out.println(i);  // 0, 2, 4, 6, 8
}

Bucle infinito (no recomendado):
for (;;) { }",
      "tags": ["java", "for", "bucle", "iteracion", "tema-2"],
      "difficulty": "easy"
    },
    {
      "id": "java-t2-011",
      "front": "¿Qué hacen break y continue en los bucles?",
      "back": "break: sale del bucle inmediatamente.
for (int i = 0; i < 10; i++) {
    if (i == 5) break;
    System.out.print(i + " ");  // 0 1 2 3 4
}

continue: salta a la siguiente iteración (ignora el resto del código).
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) continue;
    System.out.print(i + " ");  // 1 3 5 7 9
}

break en switch: sale del switch.
break en bucles anidados: solo sale del bucle más interno.

Para salir de un bucle externo desde dentro, se puede usar una etiqueta (goto simulado):
outer:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1) break outer;
    }
}",
      "tags": ["java", "break", "continue", "bucles", "control", "tema-2"],
      "difficulty": "medium"
    },
    {
      "id": "java-t2-012",
      "front": "¿Qué son los bucles for anidados y cómo se usan?",
      "back": "Un bucle for dentro de otro bucle for. Útil para recorrer matrices, dibujar figuras, etc.

for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        System.out.print("[" + i + "][" + j + "] ");
    }
    System.out.println();
}

Salida:
[0][0] [0][1] [0][2]
[1][0] [1][1] [1][2]
[2][0] [2][1] [2][2]

Ejemplo - tabla de multiplicar:
for (int i = 1; i <= 10; i++) {
    for (int j = 1; j <= 10; j++) {
        System.out.print((i*j) + "	");
    }
    System.out.println();
}

Ejemplo - figura (triángulo):
for (int i = 0; i < 5; i++) {
    for (int j = 0; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}",
      "tags": ["java", "for", "anidados", "bucles", "figuras", "tema-2"],
      "difficulty": "medium"
    },
    {
      "id": "java-t2-013",
      "front": "¿Qué es el casting y el parseo en Java?",
      "back": "CASTING (conversión entre tipos compatibles):
- Implícito: automático de tipo pequeño a grande.
  int a = 5;
  double b = a;  // int → double, OK

- Explícito: de tipo grande a pequeño (puede perder datos).
  double x = 5.7;
  int y = (int) x;  // y = 5 (pierde decimales)

PARSEO (convertir String a número):
- Integer.parseInt("123") → 123
- Double.parseDouble("3.14") → 3.14
- Boolean.parseBoolean("true") → true

Ejemplo:
String edadStr = "25";
int edad = Integer.parseInt(edadStr);
System.out.println(edad + 1);  // 26 (no 251)

OJO: parseInt lanza NumberFormatException si el String no es un número válido.",
      "tags": ["java", "casting", "parseo", "conversion", "tipos", "tema-2"],
      "difficulty": "medium"
    },
    {
      "id": "java-t2-014",
      "front": "¿Qué son las secuencias de escape en Java?",
      "back": "Las secuencias de escape permiten incluir caracteres especiales dentro de un String.


 → nueva línea
	 → tabulación
 → retorno de carro
\" → comillas dobles
\' → comilla simple
\\ → barra invertida
\b → retroceso (backspace)

Ejemplos:
System.out.println("Línea 1
Línea 2");
// Línea 1
// Línea 2

System.out.println("	Tabulado");
//     Tabulado

System.out.println("Él dijo: \"Hola\"");
// Él dijo: "Hola"

System.out.println("Ruta: C:\\Users\\Pablo");
// Ruta: C:\Users\Pablo",
      "tags": ["java", "escape", "secuencias", "strings", "caracteres", "tema-2"],
      "difficulty": "easy"
    },
    {
      "id": "java-t2-015",
      "front": "¿Cómo funciona la precedencia de operadores en Java?",
      "back": "Orden de evaluación (de mayor a menor prioridad):

1. Paréntesis ()
2. Unarios: ++ -- + - !
3. Multiplicativos: * / %
4. Aditivos: + -
5. Relacionales: < > <= >= instanceof
6. Igualdad: == !=
7. Lógicos AND: &&
8. Lógicos OR: ||
9. Ternario: ? :
10. Asignación: = += -= *= /= %=

Ejemplo complejo:
int x = 5 + 3 * 2 - 4 / 2;
// 1º: 3*2 = 6
// 2º: 4/2 = 2
// 3º: 5 + 6 = 11
// 4º: 11 - 2 = 9
// x = 9

Cuando hay dudas: usar paréntesis para ser explícito.",
      "tags": ["java", "precedencia", "operadores", "prioridad", "tema-2"],
      "difficulty": "hard"
    },
    {
      "id": "java-t2-016",
      "front": "¿Qué es la clase Math en Java?",
      "back": "La clase Math proporciona métodos y constantes matemáticas. TODOS son estáticos.

Constantes:
Math.PI → 3.14159...
Math.E → 2.71828...

Métodos principales:
Math.abs(x) → valor absoluto
Math.max(a, b) → el mayor
Math.min(a, b) → el menor
Math.sqrt(x) → raíz cuadrada
Math.pow(x, y) → x^y
Math.round(x) → redondeo (4.5 → 5)
Math.ceil(x) → redondeo hacia arriba (4.2 → 5.0)
Math.floor(x) → redondeo hacia abajo (4.8 → 4.0)
Math.random() → aleatorio entre 0.0 y 1.0 (excluido 1)
Math.sin(x), Math.cos(x), Math.tan(x) → trigonometría

Aleatorio entre min y max (incluidos):
int aleatorio = (int)(Math.random() * (max - min + 1)) + min;",
      "tags": ["java", "Math", "clase", "matematicas", "metodos-estaticos", "tema-2"],
      "difficulty": "easy"
    },
    {
      "id": "java-t2-017",
      "front": "¿Qué es la precisión de decimales en Java y cómo se maneja?",
      "back": "Los números decimales en Java (float/double) pueden tener errores de precisión.

Problema:
double resultado = 0.1 + 0.2;  // 0.30000000000000004 (NO 0.3)

Soluciones:

1. Redondear al mostrar:
System.out.printf("%.2f", 0.1 + 0.2);  // 0.30

2. String.format:
String s = String.format("%.2f", 0.1 + 0.2);

3. BigDecimal (para cálculos precisos, ej. dinero):
import java.math.BigDecimal;
BigDecimal a = new BigDecimal("0.1");
BigDecimal b = new BigDecimal("0.2");
BigDecimal suma = a.add(b);  // 0.3 exacto

4. Multiplicar por potencia de 10 y usar enteros:
double decimal = 3.57;
int centimos = (int)(decimal * 100);  // 357 céntimos

Para comparar doubles NUNCA usar ==, usar un margen:
if (Math.abs(a - b) < 0.0001)",
      "tags": ["java", "precision", "decimales", "BigDecimal", "double", "tema-2"],
      "difficulty": "hard"
    },
    {
      "id": "java-t2-018",
      "front": "¿Cómo se declaran e inicializan arrays en Java?",
      "back": "SIN VALORES INICIALES:
int[] notas = new int[5];  // {0, 0, 0, 0, 0}

CON VALORES INICIALES:
int[] notas = {10, 20, 30, 40, 50};  // 5 elementos

DECLARAR PRIMERO, CREAR DESPUÉS:
int[] notas;
notas = new int[5];

DOS SINTAXIS VÁLIDAS:
int[] notas = new int[5];   // Recomendada (Java-style)
int notas[] = new int[5];   // También válida (C-style)

Acceso a elementos:
notas[0] = 10;  // primer elemento (índice 0)
notas[4] = 50;  // último elemento (índice length-1)

Valores por defecto según tipo:
- int/short/byte/long → 0
- double/float → 0.0
- boolean → false
- char → '\0'
- String/objetos → null",
      "tags": ["java", "arrays", "declaracion", "inicializacion", "tema-2"],
      "difficulty": "easy"
    }
  ]
}
// Error parseando cards_java_t3_metodos.json: Se ha pasado un objeto no válido. Se esperaba ':' o '}'. (5360): {
  "id": "cards-java-t3",
  "name": "Java - Tema 3: Métodos en Java",
  "description": "Cards del curso Java IOC - Métodos, paso por valor, variables locales/globales, sobrecarga, pila de llamadas, recursividad",
  "subject": "Programación - Java",
  "deck": "Java",
  "cards": [
    {
      "id": "java-t3-001",
      "front": "¿Qué es un método en Java y cuál es su sintaxis?",
      "back": "Un método es un bloque de código que realiza una tarea específica.

Sintaxis:
[modificador] [tipo_retorno] nombreMetodo([parametros]) {
    // cuerpo
    return valor;
}

Partes:
- Modificador: public, private, static...
- Tipo retorno: int, double, void...
- Parámetros: valores de entrada (opcional)

Ejemplo:
static int suma(int a, int b) {
    return a + b;
}
int total = suma(5, 3);  // total = 8",
      "tags": ["java", "metodos", "sintaxis", "tema-3"],
      "difficulty": "easy"
    },
    {
      "id": "java-t3-002",
      "front": "¿Qué es el paso por valor en Java?",
      "back": "Los argumentos se pasan SIEMPRE por valor: se copia el valor en el parámetro.

Modificar el parámetro dentro del método NO afecta al original.

Ejemplo:
static void incrementar(int x) {
    x = x + 1;
}
int a = 5;
incrementar(a);
System.out.println(a);  // 5 (NO cambió)

Con objetos: se pasa la copia de la referencia (el objeto SÍ puede modificarse).",
      "tags": ["java", "metodos", "paso-por-valor", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-003",
      "front": "¿Qué diferencia hay entre variables locales y globales?",
      "back": "LOCALES: dentro de un método. Solo existen en ese ámbito. Deben inicializarse.
GLOBALES (de clase): fuera de métodos. Existen mientras el objeto exista. Tienen valor por defecto.

class Ejemplo {
    static int global = 10;
    static void metodo() {
        int local = 5;
        System.out.println(global + local);  // 15
    }
}

Prioridad: la variable local tiene prioridad sobre la global si tienen el mismo nombre.",
      "tags": ["java", "variables", "locales", "globales", "scope", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-004",
      "front": "¿Qué es la sobrecarga de métodos (overloading)?",
      "back": "Múltiples métodos con el MISMO nombre pero DIFERENTES parámetros.

Java diferencia por: número, tipo y orden de parámetros.
NO diferencia por tipo de retorno.

static int suma(int a, int b) { return a + b; }
static double suma(double a, double b) { return a + b; }
static int suma(int a, int b, int c) { return a + b + c; }

suma(5, 3);      // int, int
suma(5.0, 3.0);  // double, double
suma(5, 3, 2);   // int, int, int",
      "tags": ["java", "sobrecarga", "overloading", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-005",
      "front": "¿Qué es la pila de llamadas y cómo se relaciona con la recursividad?",
      "back": "Estructura LIFO que almacena llamadas a métodos pendientes.
- Push: al llamar a un método.
- Pop: al terminar.

En recursividad, las llamadas se apilan hasta el caso base, luego se desapilan.

Traza factorial(4):
Push: fact(4) -> fact(3) -> fact(2) -> fact(1) -> fact(0)
Pop:  fact(0)=1 -> fact(1)=1 -> fact(2)=2 -> fact(3)=6 -> fact(4)=24

Si la recursión es muy profunda -> StackOverflowError.",
      "tags": ["java", "pila-llamadas", "recursividad", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-006",
      "front": "Escribe el método factorial recursivo.
factorial(4) = 4*3*2*1 = 24",
      "back": "static int factorial(int n) {
    if (n == 0) return 1;          // Caso base
    return n * factorial(n - 1);    // Caso general
}

// Ternario:
static int factorial(int n) {
    return (n == 0) ? 1 : n * factorial(n - 1);
}

Traza fact(4):
4 * fact(3) = 4 * 3 * fact(2) = 4 * 3 * 2 * fact(1)
= 4 * 3 * 2 * 1 * fact(0) = 4 * 3 * 2 * 1 * 1 = 24",
      "tags": ["java", "recursividad", "factorial", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-007",
      "front": "Escribe fibonacci recursivo.
Serie: 0, 1, 1, 2, 3, 5, 8, 13...",
      "back": "static int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n-1) + fibonacci(n-2);
}

fib(4) = fib(3)+fib(2) = (fib(2)+fib(1)) + (fib(1)+fib(0))
= ((fib(1)+fib(0))+1) + (1+0) = ((1+0)+1)+1 = 3

Complejidad O(2^n) - muy ineficiente.

Iterativa (eficiente):
static int fibonacciIt(int n) {
    if (n <= 1) return n;
    int a=0, b=1;
    for (int i=2; i<=n; i++) { b = a + b; a = b - a; }
    return b;
}",
      "tags": ["java", "recursividad", "fibonacci", "tema-3"],
      "difficulty": "hard"
    },
    {
      "id": "java-t3-008",
      "front": "Explica la búsqueda binaria recursiva. ¿Qué requisito tiene?",
      "back": "Busca en array ORDENADO dividiendo por la mitad.

static boolean busquedaBinaria(int[] nums, int buscado, int inf, int sup) {
    if (inf > sup) return false;
    int mitad = (inf + sup) / 2;
    if (nums[mitad] < buscado)
        return busquedaBinaria(nums, buscado, mitad+1, sup);
    else if (nums[mitad] > buscado)
        return busquedaBinaria(nums, buscado, inf, mitad-1);
    else return true;
}

Requisito: array ORDENADO.
Complejidad: O(log n).

Método intermedio:
static void mostrarBusquedaBinaria(int[] nums, int buscado) {
    if (busquedaBinaria(nums, buscado, 0, nums.length-1))
        System.out.println("Encontrado");
    else System.out.println("NO encontrado");
}",
      "tags": ["java", "busqueda-binaria", "recursividad", "tema-3"],
      "difficulty": "hard"
    }
  ]
}

// ================================================
// Java YouTube - Tema 3: Recursividad
// ================================================

// --- java-t3-v10-001 ---
Un método recursivo es aquel que se llama a SÍ MISMO durante su ejecución. Es una alternativa a los bucles (iteración) para resolver problemas que pueden descomponerse en subproblemas más pequeños del mismo tipo.

Ejemplo básico:
static int factorial(int n) {
    if (n == 0) {
        return 1;                 // Caso base
    } else {
        return n * factorial(n - 1);  // Llamada recursiva
    }
}

// --- java-t3-v10-002 ---
1. CASO BASE: condición que DETIENE la recursión. Es la solución más simple posible. Sin caso base → recursión infinita → StackOverflowError.

2. CASO GENERAL (o recursivo): el método se llama a sí mismo con un problema MÁS PEQUEÑO (normalmente n-1, n/2, etc.). Cada llamada debe acercarse al caso base.

Ejemplo en factorial:
- Caso base: if (n == 0) return 1;
- Caso general: return n * factorial(n - 1);

// --- java-t3-v10-003 ---
n! = n * (n-1) * (n-2) * ... * 1

Definición recursiva:
- 0! = 1  (caso base)
- n! = n * (n-1)!  (caso general, para n > 0)

Código:
static int factorial(int n) {
    if (n == 0) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
}

Ejemplos:
- factorial(0) = 1
- factorial(3) = 3 * 2 * 1 * 1 = 6
- factorial(4) = 4 * 3 * 2 * 1 * 1 = 24
- factorial(5) = 5 * 4 * 3 * 2 * 1 * 1 = 120

// --- java-t3-v10-004 ---
APILADO (orden de llamadas):
  factorial(4) -> 4 * factorial(3)
    factorial(3) -> 3 * factorial(2)
      factorial(2) -> 2 * factorial(1)
        factorial(1) -> 1 * factorial(0)
          factorial(0) -> return 1  ← CASO BASE

DESAPILADO (orden de retornos):
          factorial(0) = 1
        factorial(1) = 1 * 1 = 1
      factorial(2) = 2 * 1 = 2
    factorial(3) = 3 * 2 = 6
  factorial(4) = 4 * 6 = 24

La pila llegó a tener 6 niveles (main + 5 llamadas a factorial).

// --- java-t3-v10-005 ---
Se produce una RECURSIÓN INFINITA: el método se llama a sí mismo sin parar, apilando infinitos frames en la pila de llamadas hasta que la memoria se agota. Esto lanza un StackOverflowError (desbordamiento de pila).

Ejemplo de código peligroso:
static int recursionInfinita() {
    return recursionInfinita();  // Sin caso base
}

Siempre debe haber:
1. Un caso base que detenga la recursión.
2. Una llamada recursiva que se acerque al caso base (n-1, n/2, etc.).

// --- java-t3-v10-006 ---
ITERACIÓN (for/while):
- Usa una misma variable que se actualiza en cada vuelta.
- NO apila frames en la pila (menos memoria).
- Generalmente más eficiente.
- Puede ser más complejo de leer para ciertos problemas.

RECURSIÓN:
- El método se llama a sí mismo.
- Cada llamada APILA un nuevo frame en la pila (más memoria).
- Puede causar StackOverflowError si es muy profunda.
- Más legible para problemas como factorial, Fibonacci, árboles.

En general: la recursión es más elegante pero menos eficiente en memoria.

// --- java-t3-v10-007 ---
Caso base: suma(1) = 1
Caso general: suma(n) = n + suma(n-1)

Código:
static int sumaRecursiva(int n) {
    if (n == 1) {
        return 1;              // Caso base
    } else {
        return n + sumaRecursiva(n - 1);  // Caso general
    }
}

Ejemplo: sumaRecursiva(10) = 10+9+8+...+1 = 55

// --- java-t3-v10-008 ---
Porque cada llamada recursiva crea un NUEVO registro de activación (stack frame) que se apila encima del anterior. Cada frame contiene sus propias variables locales y parámetros.

Ejemplo con factorial(4): se apilan 5 frames de factorial (fact4, fact3, fact2, fact1, fact0) encima del main. La pila llega a tener 6 niveles.

Problemas:
- Consume más memoria que un bucle.
- Si la recursión es muy profunda (ej: factorial(100000)), se agota la pila → StackOverflowError.

Por eso la recursión no siempre es la mejor opción; hay que usarla con cuidado.

// Error parseando cards_java_youtube_t3_v11.json: Se ha pasado un objeto no válido. Se esperaba ':' o '}'. (665): {
  "id": "programacion-java-youtube-t3-v11",
  "name": "Java YouTube - Tema 3: Triángulo recursivo",
  "description": "Cards del curso JAVA desde 0 - Triángulo recursivo con asteriscos, dos soluciones, eficiencia de pila",
  "subject": "Programación - Java",
  "cards": [
    {
      "id": "java-t3-v11-001",
      "front": "¿Cómo se dibuja un triángulo rectángulo de asteriscos de forma recursiva? (Solución 1: tree)",
      "back": "Con un método tree(int a, int b, int n) que usa 3 parámetros como contadores:
- a = fila actual
- b = columna actual
- n = altura total

Código:
static void tree(int a, int b, int n) {
    if (a > b) {
        System.out.print("*");
        tree(a, b + 1, n);       // Siguiente columna
    } else {
        System.out.println();     // Salto de línea
        if (n > a + 1) {
            tree(a + 1, 0, n);   // Siguiente fila
        }
    }
}

Llamada inicial: tree(0, 0, 3)",
      "tags": ["java", "recursividad", "triangulo", "tree", "solucion-1", "tema-3"],
      "difficulty": "hard"
    },
    {
      "id": "java-t3-v11-002",
      "front": "¿Cómo se implementa la solución más eficiente del triángulo recursivo con dos métodos?",
      "back": "Con dos métodos recursivos:

1. triangulo(int n) - controla las FILAS:
   - Se llama a sí mismo con n-1 (va de la altura hacia abajo)
   - Luego llama a filaTriangulo(n) para imprimir la fila actual

2. filaTriangulo(int n) - controla las COLUMNAS:
   - Imprime '*' y se llama con n-1
   - Cuando n=0, imprime salto de línea (caso base)

Código:
static void triangulo(int n) {
    if (n > 0) {
        triangulo(n - 1);        // Primero filas anteriores
        filaTriangulo(n);        // Luego esta fila
    }
}

static void filaTriangulo(int n) {
    if (n > 0) {
        System.out.print("*");
        filaTriangulo(n - 1);
    } else {
        System.out.println();
    }
}

Llamada inicial: triangulo(3)",
      "tags": ["java", "recursividad", "triangulo", "solucion-2", "eficiente", "tema-3"],
      "difficulty": "hard"
    },
    {
      "id": "java-t3-v11-003",
      "front": "¿Cuál es la diferencia de eficiencia entre las dos soluciones del triángulo recursivo (altura 3)?",
      "back": "SOLUCIÓN 1 (tree(a,b,n)):
- Pila máxima: 10 llamadas anidadas para altura 3.
- Cada asterisco y cada salto de línea son una llamada recursiva.
- Para altura 10, la pila crece muchísimo.

SOLUCIÓN 2 (triangulo + filaTriangulo):
- Pila máxima: 6 llamadas anidadas para altura 3.
- Las filas se apilan primero (triangulo), luego se resuelven una a una (filaTriangulo).
- Para altura 10, la pila crece mucho menos.

La solución 2 es MEJOR porque las llamadas a filaTriangulo se resuelven y desapilan antes de pasar a la siguiente fila, usando menos memoria.",
      "tags": ["java", "recursividad", "triangulo", "eficiencia", "pila", "comparacion", "tema-3"],
      "difficulty": "hard"
    },
    {
      "id": "java-t3-v11-004",
      "front": "¿Cómo simula la recursión un bucle for anidado en el método tree(a, b, n)?",
      "back": "La recursión con parámetros contadores reemplaza los bucles:

Bucle for equivalente:
for (int a = 0; a < n; a++) {          // Filas
    for (int b = 0; b <= a; b++) {      // Columnas
        System.out.print("*");
    }
    System.out.println();
}

Versión recursiva tree(a, b, n):
- El IF (a > b) equivale al bucle interno de columnas.
  - Imprime '*' y llama a tree(a, b+1, n) -> incremento de columna.
- El ELSE equivale al fin de la fila.
  - Imprime salto de línea.
  - Si quedan filas (n > a+1), llama a tree(a+1, 0, n) -> siguiente fila.

Parámetros:
- a = contador de fila (se incrementa al cambiar de fila)
- b = contador de columna (se incrementa al imprimir asterisco)
- n = límite (altura total) - nunca cambia",
      "tags": ["java", "recursividad", "triangulo", "for-anidado", "simulacion", "tema-3"],
      "difficulty": "hard"
    },
    {
      "id": "java-t3-v11-005",
      "front": "¿Por qué la solución con triangulo(n) + filaTriangulo(n) es más eficiente que tree(a,b,n)?",
      "back": "Porque separa las dos responsabilidades:

1. triangulo(n) se encarga de las FILAS:
   - Se llama recursivamente con n-1 hasta llegar a 0 (caso base).
   - Solo apila N llamadas (una por cada fila).
   - Cuando vuelve del caso base, llama a filaTriangulo(n) que se resuelve y DESAPILA.

2. filaTriangulo(n) se encarga de las COLUMNAS:
   - Imprime '*' y se llama con n-1.
   - Cuando termina (n=0), se desapila completamente.

En tree(a,b,n): la pila crece continuamente porque las llamadas para una fila NO se resuelven hasta que terminan todas las filas siguientes.

Para altura 3:
- tree: 10 llamadas en pila
- triangulo+fila: 6 llamadas en pila

Para altura 10:
- tree: ~65 llamadas
- triangulo+fila: ~15 llamadas",
      "tags": ["java", "recursividad", "triangulo", "eficiencia", "pila", "comparacion", "tema-3"],
      "difficulty": "hard"
    }
  ]
}

// Error parseando cards_java_youtube_t3_v12.json: Se ha pasado un objeto no válido. Se esperaba ':' o '}'. (4661): {
  "id": "programacion-java-youtube-t3-v12",
  "name": "Java YouTube - Tema 3: Ejercicios resueltos recursividad",
  "description": "Cards del curso JAVA desde 0 - 7 ejercicios de recursividad: dígitos, potencia, invertir, binario, palabra ordenada, suma 1..n",
  "subject": "Programación - Java",
  "cards": [
    {
      "id": "java-t3-v12-001",
      "front": "Ejercicio: Implementa un método recursivo que cuente la cantidad de dígitos de un número n > 0.

Ej: digitos(121) = 3, digitos(5) = 1",
      "back": "static int digitos(int n) {
    if (n == 0) {
        return 0;               // Caso base
    } else {
        return 1 + digitos(n / 10);  // Cuenta 1 digito y sigue con el resto
    }
}

Lógica: dividir entre 10 elimina el último dígito.
- digitos(5): 1 + digitos(0) = 1 + 0 = 1
- digitos(144): 1 + digitos(14) = 1 + 1 + digitos(1) = 1 + 1 + 1 + digitos(0) = 3

Alternativa con operador ternario:
return (n == 0) ? 0 : 1 + digitos(n / 10);",
      "tags": ["java", "recursividad", "ejercicio", "digitos", "contar", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v12-002",
      "front": "Ejercicio: Implementa un método recursivo que calcule base^exponente (números positivos).

Ej: potencia(2, 4) = 16",
      "back": "static int potencia(int base, int exp) {
    if (exp == 0) {
        return 1;  // Caso base: cualquier número^0 = 1
    } else {
        return base * potencia(base, exp - 1);
    }
}

Lógica: base^exp = base * base^(exp-1)
- potencia(2, 4) = 2 * potencia(2, 3)
  = 2 * 2 * potencia(2, 2)
  = 2 * 2 * 2 * potencia(2, 1)
  = 2 * 2 * 2 * 2 * potencia(2, 0)
  = 2 * 2 * 2 * 2 * 1 = 16",
      "tags": ["java", "recursividad", "ejercicio", "potencia", "exponente", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v12-003",
      "front": "Ejercicio: Implementa un método recursivo que imprima un número invertido.

Ej: invertir(145) → imprime 541",
      "back": "static void invertir(int n) {
    if (n >= 0 && n < 10) {
        System.out.println(n);   // Caso base: un solo dígito
    } else {
        System.out.print(n % 10);  // Imprime el último dígito
        invertir(n / 10);         // Llama recursivamente sin el último
    }
}

Lógica:
- n % 10 → obtiene el último dígito
- n / 10 → elimina el último dígito

Traza invertir(145):
1. print(145 % 10) = print(5) → invertir(14)
2. print(14 % 10) = print(4) → invertir(1)
3. println(1) → caso base

Salida: 541",
      "tags": ["java", "recursividad", "ejercicio", "invertir", "digitos", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v12-004",
      "front": "Ejercicio: Implementa un método recursivo que compruebe si un número es binario (solo 0s y 1s).

Ej: esBinario(1011) = true, esBinario(123) = false",
      "back": "static boolean esBinario(int n) {
    // Caso base: un solo dígito
    if (n >= 0 && n < 10) {
        return (n == 0 || n == 1);
    }
    // Caso general
    if (n % 10 == 0 || n % 10 == 1) {
        return esBinario(n / 10);  // Este dígito es válido, seguir
    } else {
        return false;  // Dígito no binario encontrado
    }
}

Lógica: analizar el último dígito con %10.
Si es 0 o 1, seguir con el siguiente (n/10).
Si no, devolver false.
Si llegamos a un solo dígito, comprobar si es 0 o 1.",
      "tags": ["java", "recursividad", "ejercicio", "binario", "comprobar", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v12-005",
      "front": "Ejercicio: Implementa un método recursivo que convierta un número decimal a binario (devuelve entero).

Ej: convertirBinario(15) = 1111",
      "back": "static int convertirBinario(int n) {
    if (n == 0 || n == 1) {
        return n;  // Caso base: 0→0, 1→1
    } else {
        return (n % 2) + 10 * convertirBinario(n / 2);
    }
}

Lógica:
- n % 2 → resto de dividir entre 2 (0 o 1), va a la derecha
- n / 2 → siguiente número a convertir
- * 10 → desplaza el resultado anterior a la izquierda

VERSIÓN VOID (más simple):
static void imprimirBinario(int n) {
    if (n > 1) {
        imprimirBinario(n / 2);
    }
    System.out.print(n % 2);
}

Traza convertirBinario(15):
→ 15%2 + 10*conv(7) = 1 + 10*(1 + 10*conv(3))
= 1 + 10*(1 + 10*(1 + 10*conv(1)))
= 1 + 10*(1 + 10*(1 + 10*1))
= 1 + 10*(1 + 10*(1 + 10))
= 1 + 10*(1 + 110) = 1 + 10*111 = 1 + 1110 = 1111",
      "tags": ["java", "recursividad", "ejercicio", "binario", "conversion", "decimal", "tema-3"],
      "difficulty": "hard"
    },
    {
      "id": "java-t3-v12-006",
      "front": "Ejercicio: Implementa un método recursivo que compruebe si una palabra está ordenada alfabéticamente.

Ej: palabraOrdenada("abcde") = true, palabraOrdenada("abcdfe") = false",
      "back": "static boolean palabraOrdenada(String cad) {
    cad = cad.toLowerCase();  // Ignorar mayúsculas
    // Caso base: 0 o 1 letras → ordenada
    if (cad.length() <= 1) {
        return true;
    }
    // Caso general
    if (cad.charAt(0) <= cad.charAt(1)) {
        return palabraOrdenada(cad.substring(1));  // 1ª ≤ 2ª, seguir
    } else {
        return false;  // 1ª > 2ª, no ordenada
    }
}

Lógica:
- Comparar primera letra (charAt(0)) con segunda (charAt(1)).
- Si primera ≤ segunda (según ASCII/Unicode), seguir con substring desde 1.
- Si primera > segunda, devolver false.
- Cuando quede 1 letra (o 0), devolver true.

El método convierte a minúsculas con toLowerCase() para evitar
problemas con mayúsculas (las mayúsculas tienen menor valor ASCII).",
      "tags": ["java", "recursividad", "ejercicio", "palabra", "orden-alfabetico", "string", "tema-3"],
      "difficulty": "hard"
    },
    {
      "id": "java-t3-v12-007",
      "front": "Ejercicio: Implementa un método recursivo que muestre la suma de 1 a n en formato: 1+2+3+4 = 10

(versión creciente, que es como pide el enunciado)",
      "back": "// Versión CRECIENTE: 1 + 2 + ... + n
static void sumaCreciente(int cont, int n, int total) {
    if (cont < n) {
        System.out.print(cont + " + ");
        sumaCreciente(cont + 1, n, total + cont);
    } else {
        System.out.println(cont + " = " + (total + cont));
    }
}

// Método auxiliar (solo requiere n)
static void mostrarSumaCreciente(int n) {
    sumaCreciente(1, n, 0);
}

// Versión DECRECIENTE: 4 + 3 + 2 + 1 = 10 (más fácil)
static void sumaDecreciente(int n, int total) {
    if (n == 1) {
        System.out.println("1 = " + (total + 1));
    } else {
        System.out.print(n + " + ");
        sumaDecreciente(n - 1, total + n);
    }
}

Traza mostrarSumaCreciente(4):
→ sumaCreciente(1,4,0): print("1 + ") → sumaCreciente(2,4,1)
→ print("2 + ") → sumaCreciente(3,4,3)
→ print("3 + ") → sumaCreciente(4,4,6)
→ println("4 = 10") ← (6+4=10)",
      "tags": ["java", "recursividad", "ejercicio", "suma", "creciente", "decreciente", "tema-3"],
      "difficulty": "hard"
    }
  ]
}

// Error parseando cards_java_youtube_t3_v4.json: Se ha pasado un objeto no válido. Se esperaba ':' o '}'. (3396): {
  "id": "programacion-java-youtube-t3",
  "name": "Java YouTube - Tema 3: Métodos",
  "description": "Cards del curso JAVA desde 0 - Paso por valor, Declaración de métodos, Ejercicios",
  "subject": "Programación - Java",
  "cards": [
    {
      "id": "java-t3-v4-001",
      "front": "¿Qué es el paso por valor en Java?",
      "back": "Es el mecanismo por el cual, al pasar una variable como parámetro a un método, se envía una COPIA del valor de esa variable, no la variable en sí. Si dentro del método se modifica el parámetro, la variable original NO se modifica.",
      "tags": ["java", "metodos", "paso-por-valor", "tema-3"],
      "difficulty": "easy"
    },
    {
      "id": "java-t3-v4-002",
      "front": "¿Qué ocurre si modificamos un parámetro primitivo dentro de un método en Java?",
      "back": "Como Java usa paso por valor con tipos primitivos, modificar el parámetro dentro del método solo afecta a la COPIA local. La variable original del ámbito exterior (ej: main) NO se modifica.

Ejemplo:
int x = 5;
metodo(x);  // Se pasa copia de 5
// x sigue siendo 5 aunque dentro del método se modifique",
      "tags": ["java", "metodos", "paso-por-valor", "tema-3"],
      "difficulty": "easy"
    },
    {
      "id": "java-t3-v4-003",
      "front": "¿Existen punteros en Java como en C/C++?",
      "back": "No exactamente. En C/C++ los punteros son tipos de dato explícitos que almacenan direcciones de memoria. En Java no existe el tipo 'puntero' como tal, pero internamente las referencias a objetos funcionan como punteros 'escondidos'.

- Con primitivos: paso por valor (copia del dato).
- Con objetos: se pasa una copia de la referencia (el objeto se puede modificar, pero la referencia en sí no se puede reasignar).",
      "tags": ["java", "metodos", "punteros", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v4-004",
      "front": "¿Puede una variable y un método llamarse igual en Java?",
      "back": "Sí, es perfectamente válido. El compilador distingue porque los métodos siempre llevan paréntesis (aunque estén vacíos), mientras que las variables no.

Ejemplo:
int doble;       // Variable
doble(5);        // Método

Los paréntesis ( ) indican que es una llamada a método.",
      "tags": ["java", "metodos", "identificadores", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v4-005",
      "front": "¿Puede un parámetro formal llamarse igual que la variable que se le pasa desde el main?",
      "back": "Sí. Son variables DISTINTAS porque pertenecen a ÁMBITOS diferentes:
- La variable del main pertenece al ámbito del método main.
- El parámetro formal pertenece al ámbito del método al que se llama.

Aunque se llamen igual, son independientes y modificar una no afecta a la otra (paso por valor).",
      "tags": ["java", "metodos", "ambito", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v4-006",
      "front": "¿Qué significa public static void main(String[] args)?",
      "back": "Es la declaración del método principal (punto de entrada) en Java:

- public: accesible desde cualquier clase.
- static: se puede ejecutar sin crear un objeto.
- void: no devuelve ningún valor.
- main: nombre del método (la JVM lo busca para iniciar).
- String[] args: array de Strings con los argumentos pasados por línea de comandos.

Ejemplo:
java MiClase arg1 arg2
→ args[0] = "arg1", args[1] = "arg2"",
      "tags": ["java", "metodos", "main", "tema-3"],
      "difficulty": "easy"
    },
    {
      "id": "java-t3-v4-007",
      "front": "¿Cómo se accede a los argumentos pasados por consola en el método main?",
      "back": "Los argumentos se reciben en el parámetro String[] args del main. Se accede como a cualquier array:

for (int i = 0; i < args.length; i++) {
    System.out.println(args[i]);
}

Ejemplo de ejecución:
java Programa.java hola mundo 123
→ args[0]="hola", args[1]="mundo", args[2]="123"",
      "tags": ["java", "metodos", "main", "argumentos", "tema-3"],
      "difficulty": "easy"
    },
    {
      "id": "java-t3-v4-008",
      "front": "Dado el código:
int numb = 10;
int doble = doble(numb);

static int doble(int a) {
    a = a * 2;
    return a;
}

¿Qué valores tienen numb y doble al final?",
      "back": "numb = 10 (NO cambia, sigue siendo 10)
doble = 20 (resultado del método)

Explicación: Al llamar a doble(numb), se pasa una COPIA del valor 10. Dentro del método, a se multiplica por 2 (a=20), pero eso no afecta a la variable original numb del main. El método devuelve 20, que se asigna a la variable doble.",
      "tags": ["java", "metodos", "paso-por-valor", "ejercicio", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v4-009",
      "front": "¿Cuál es la ventaja de que Java use paso por valor en lugar de punteros explícitos?",
      "back": "Java es más SEGURO y menos propenso a errores que C/C++ porque:
- No se puede modificar accidentalmente una variable original desde un método.
- No hay riesgo de acceder a direcciones de memoria inválidas.
- La gestión de memoria es más sencilla (no hay que liberar manualmente).

Sin embargo, los punteros de C/C++ dan más control sobre la memoria, lo que es útil para programación de sistemas operativos y aplicaciones de bajo nivel.",
      "tags": ["java", "metodos", "paso-por-valor", "punteros", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v4-010",
      "front": "¿Qué diferencia hay entre paso por valor y paso por referencia?",
      "back": "PASO POR VALOR:
- Se envía una COPIA del valor de la variable.
- La variable original NO se modifica.
- Es el único mecanismo en Java para tipos primitivos.

PASO POR REFERENCIA:
- Se envía la dirección de memoria de la variable.
- La variable original SÍ se puede modificar desde el método.
- Existe en C/C++ mediante punteros.

NOTA: En Java, con objetos se pasa la referencia por valor (copia de la referencia). El objeto se puede modificar, pero la referencia en sí no se puede reasignar desde el método.",
      "tags": ["java", "metodos", "paso-por-valor", "referencia", "tema-3"],
      "difficulty": "hard"
    },
    {
      "id": "java-t3-v4-011",
      "front": "¿Qué ocurre al ejecutar este código?

int num = 5;
int resultado = metodoMismoNombre(num);

static int metodoMismoNombre(int num) {
    num = num * 2;
    return num;
}",
      "back": "num = 5 (la variable del main NO cambia)
resultado = 10

Aunque el parámetro del método se llame igual que la variable del main (num), son variables distintas con ámbitos diferentes. El método recibe una copia del valor (5), la multiplica por 2 (10), y devuelve el resultado. El num del main sigue siendo 5.",
      "tags": ["java", "metodos", "paso-por-valor", "ambito", "ejercicio", "tema-3"],
      "difficulty": "medium"
    }
  ]
}


// ================================================
// Java YouTube - Tema 3: Variables locales y globales
// ================================================

// --- java-t3-v5-001 ---
Es una variable que se declara DENTRO de un método (incluido el main). Solo existe y es accesible dentro de ese método. Al terminar el método, la variable local se destruye.

Ejemplo:
public static void main(String[] args) {
    int x = 10;  // x es variable LOCAL del main
}
// Aquí x ya NO existe

// --- java-t3-v5-002 ---
Es una variable que se declara DENTRO de la clase pero FUERA de cualquier método. Es accesible desde TODOS los métodos de la clase (si usan static). Se declara con la palabra clave 'static'.

Ejemplo:
class Ejemplo {
    static int x = 5;  // Variable GLOBAL de clase

    public static void main(String[] args) {
        System.out.println(x);  // 5
    }
}

// --- java-t3-v5-003 ---
Sí. Los parámetros formales de un método se consideran variables LOCALES del mismo. Se pueden usar dentro del cuerpo del método como cualquier otra variable local, pero NO existen fuera de él.

Ejemplo:
static void metodo(int z) {
    // z es variable LOCAL (parametro formal)
    System.out.println(z);
}
// Fuera del metodo, z NO existe

// --- java-t3-v5-004 ---
La variable local SOBREESCRIBE (oculta) a la variable global dentro de ese método. El método usará la variable local, no la global.

Ejemplo:
static int x = 100;  // Global

static void metodo() {
    int x = 5;  // Local - oculta a la global
    System.out.println(x);  // 5 (local), NO 100
}

// --- java-t3-v5-005 ---
Sí, de momento. Al igual que los métodos, las variables globales se declaran con 'static' para poder usarlas desde métodos static (como el main) sin necesidad de crear objetos. En programación orientada a objetos se explicará con más detalle.

Ejemplo correcto:
class Ejemplo {
    static int num = 5;  // static necesario

    public static void main(String[] args) {
        System.out.println(num);  // Accede sin problema
    }
}

// --- java-t3-v5-006 ---
No. Da igual si la variable global está declarada antes o después de los métodos. Todos los métodos de la clase pueden acceder a ella independientemente de dónde esté declarada.

Ejemplo (válido):
class Ejemplo {
    static void metodo() {
        System.out.println(num);  // Accede aunque esté declarada después
    }
    static int num = 10;  // Global declarada después del método
}

// --- java-t3-v5-007 ---
Se imprime: 1000

Explicación:
1. En cubo(10), se declara una variable LOCAL x = 10*10*10 = 1000.
2. Esta x local es la que se devuelve (return x).
3. En el main, x = cubo(p) asigna el resultado (1000) a la variable GLOBAL x.
4. Por eso System.out.println(x) imprime 1000.

NOTA: La x local del método cubo y la x global son distintas. La local oculta a la global dentro del método.

// --- java-t3-v5-008 ---
Se imprime: 64

Explicación paso a paso:
1. Variable global numb = 5.
2. En main: numb = cubo(numb - 1) = cubo(4).
3. En cubo(int numb): el parámetro formal numb (local) recibe 4.
4. x = 4 * 4 * 4 = 64.
5. Se devuelve 64.
6. Ese 64 se asigna a la variable GLOBAL numb.
7. System.out.println(numb) imprime 64.

La variable global numb cambia de 5 a 64.

// --- java-t3-v5-009 ---
Se imprime: 1000

Explicación paso a paso:
1. Variable global numb = 5.
2. En main: se declara variable LOCAL numb = 10 (oculta a la global).
3. numb (local) = cubo(10).
4. En cubo(int numb): parámetro local recibe 10.
5. x = 10 * 10 * 10 = 1000.
6. Se devuelve 1000.
7. Ese 1000 se asigna a la variable LOCAL numb del main.
8. System.out.println(numb) imprime 1000 (la local).
9. La variable global numb sigue siendo 5 (no se tocó).

// --- java-t3-v5-010 ---
VARIABLE LOCAL:
- Se declara DENTRO de un método.
- Solo es accesible desde ese método.
- Se destruye al terminar el método.
- Tiene prioridad sobre la global si tienen el mismo nombre.

VARIABLE GLOBAL (de clase):
- Se declara DENTRO de la clase, FUERA de los métodos.
- Es accesible desde TODOS los métodos de la clase.
- Se declara con 'static' (por ahora).
- Existe mientras la clase exista.

Ejemplo:
class Demo {
    static int global = 10;  // Global

    static void metodo() {
        int local = 5;       // Local
        System.out.println(global);  // OK: accede a global
    }
    // local NO existe fuera de metodo()
}

// Error parseando cards_java_youtube_t3_v6.json: Se ha pasado un objeto no válido. Se esperaba ':' o '}'. (5103): {
  "id": "programacion-java-youtube-t3-v6",
  "name": "Java YouTube - Tema 3: Sobrecarga de métodos",
  "description": "Cards del curso JAVA desde 0 - Sobrecarga (overloading), reglas, tipos de retorno, promoción de tipos",
  "subject": "Programación - Java",
  "cards": [
    {
      "id": "java-t3-v6-001",
      "front": "¿Qué es la sobrecarga de métodos (overloading) en Java?",
      "back": "Es la capacidad de tener VARIOS métodos con el MISMO nombre pero con DIFERENTES parámetros (distinto número o tipo). El compilador decide cuál ejecutar según los argumentos que se pasen en la llamada.

Ejemplo válido:
- saludar()
- saludar(String nombre)
- saludar(String nombre, String ciudad)",
      "tags": ["java", "metodos", "sobrecarga", "overloading", "tema-3"],
      "difficulty": "easy"
    },
    {
      "id": "java-t3-v6-002",
      "front": "¿Cuáles son las reglas para que dos métodos con el mismo nombre sean válidos en Java?",
      "back": "REGLAS DE SOBRECARGA:
1. Deben diferenciarse en el NÚMERO de parámetros.
2. O en el TIPO de al menos UN parámetro.
3. El tipo de RETORNO NO cuenta para diferenciarlos.

Si dos métodos tienen los MISMOS parámetros (mismo tipo y cantidad), dará ERROR de compilación aunque el retorno sea distinto.",
      "tags": ["java", "metodos", "sobrecarga", "reglas", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v6-003",
      "front": "¿Se pueden tener dos métodos sobrecargados sin parámetros?",
      "back": "NO. Si dos métodos tienen el mismo nombre y NINGÚN parámetro, son idénticos para el compilador. Dará ERROR de compilación, aunque el tipo de retorno sea diferente.

Ejemplo INCORRECTO:
static String saludar() { ... }
static void saludar() { ... }
-> ERROR: Java no sabe cuál llamar al ejecutar saludar()",
      "tags": ["java", "metodos", "sobrecarga", "sin-parametros", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v6-004",
      "front": "¿Son válidos estos dos métodos? ¿Por qué?

static int suma(int a, int b) { return a + b; }
static void suma(int a, int b) { System.out.println(a+b); }",
      "back": "NO son válidos. Aunque el tipo de retorno es diferente (int vs void), ambos métodos tienen los MISMOS parámetros (int a, int b). Java no puede diferenciarlos y da ERROR de compilación.

Solución: cambiar el tipo de al menos un parámetro:
static void suma(double a, double b) { ... }  // AHORA SÍ",
      "tags": ["java", "metodos", "sobrecarga", "error", "tema-3"],
      "difficulty": "hard"
    },
    {
      "id": "java-t3-v6-005",
      "front": "Dados estos métodos:

static int suma(int a, int b) { return a + b; }
static void suma(double a, double b) { System.out.println(a + b); }

¿Qué método se ejecuta en cada caso?
1. suma(1, 2)
2. suma(1.0, 2.0)
3. suma(1.0, 2)",
      "back": "1. suma(1, 2) -> suma(int, int) porque ambos argumentos son int. Devuelve 3.

2. suma(1.0, 2.0) -> suma(double, double) porque ambos son double. Imprime 3.0.

3. suma(1.0, 2) -> suma(double, double). Java convierte el int (2) a double (2.0) automáticamente. Imprime 3.0.",
      "tags": ["java", "metodos", "sobrecarga", "promocion", "ejercicio", "tema-3"],
      "difficulty": "hard"
    },
    {
      "id": "java-t3-v6-006",
      "front": "¿Qué es la promoción de tipos en la sobrecarga de métodos?",
      "back": "Java puede convertir automáticamente un tipo a otro más amplio cuando busca el método adecuado:

- int -> long -> float -> double (conversión automática, sin pérdida)
- char -> int (se convierte a su valor Unicode: 'a' = 97)

Ejemplo:
suma(int a, int b) y suma(double a, double b)
Al llamar suma('a', 3) -> usa suma(int, int) porque 'a' se convierte a 97.",
      "tags": ["java", "metodos", "sobrecarga", "promocion", "tipos", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v6-007",
      "front": "¿Qué valor imprime suma('a', 3) si existe:
static int suma(int a, int b) { return a + b; }",
      "back": "Imprime: 100

Explicación: El char 'a' se convierte automáticamente a su valor en la tabla Unicode/ASCII, que es 97. Entonces suma(97, 3) = 100.

Otros ejemplos:
- 'A' + 3 = 68 ('A' = 65)
- '0' + 3 = 51 ('0' = 48)",
      "tags": ["java", "metodos", "sobrecarga", "char", "ascii", "ejercicio", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v6-008",
      "front": "¿Es válida esta sobrecarga? ¿Por qué?

static String presentar(String nombre) { ... }
static String presentar(String nombre, int edad) { ... }
static String presentar(String nombre, String idioma) { ... }",
      "back": "SÍ es válida. Los tres métodos tienen el mismo nombre 'presentar' pero:
- 1º: 1 parámetro (String)
- 2º: 2 parámetros (String, int)
- 3º: 2 parámetros (String, String)

Aunque el 2º y 3º tienen el mismo número de parámetros, el TIPO del segundo parámetro es diferente (int vs String), por lo que son distinguibles.",
      "tags": ["java", "metodos", "sobrecarga", "ejemplo", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v6-009",
      "front": "¿Qué ocurre si llamamos a saludar("Pepe") sin asignar el resultado a ninguna variable, teniendo:

static String saludar(String nombre) { return "Hola " + nombre; }",
      "back": "El método se ejecuta correctamente y devuelve "Hola Pepe", pero ese valor se PIERDE porque no se asigna a ninguna variable ni se usa en una expresión. No se muestra nada por pantalla (a menos que el método mismo imprima algo).

Para ver el resultado hay que:
- Asignarlo: String texto = saludar("Pepe"); System.out.println(texto);
- O usarlo directamente: System.out.println(saludar("Pepe"));",
      "tags": ["java", "metodos", "sobrecarga", "retorno", "perdida", "tema-3"],
      "difficulty": "easy"
    }
  ]
}


// ================================================
// Java YouTube - Tema 3: Pila de llamadas
// ================================================

// --- java-t3-v7-001 ---
Es una estructura de datos (en memoria RAM) que utiliza la JVM para gestionar las llamadas a métodos. Funciona como una pila LIFO (Last In, First Out): el último método que se apila es el primero en ejecutarse y desapilarse.

- El primer método en apilarse es el main.
- Cada llamada a un método nuevo se apila encima.
- Cuando un método termina (return o fin de void), se desapila.
- Al desapilar el main, el programa termina.

// --- java-t3-v7-002 ---
Cada vez que se invoca un método, se crea un registro de activación (stack frame) que se apila en la pila de llamadas. Este registro contiene:

- Las variables LOCALES del método.
- Los PARÁMETROS recibidos.
- La dirección de retorno (a dónde volver cuando termine).

Cada método solo puede acceder a la información de su propio registro de activación (más las variables globales si las hay).

// --- java-t3-v7-003 ---
Orden de apilado (ejecución):
1. Se apila main (primero en ejecutarse).
2. main llama a A → se apila A encima.
3. A llama a B → se apila B encima.
4. B llama a C → se apila C encima.

Orden de desapilado (finalización):
5. C termina → se desapila C, vuelve a B.
6. B termina → se desapila B, vuelve a A.
7. A termina → se desapila A, vuelve a main.
8. main termina → se desapila main, programa termina.

Es decir, el ÚLTIMO en apilarse es el PRIMERO en desapilarse (LIFO).

// --- java-t3-v7-004 ---
proceso(3) devuelve 3. Se imprime 3.

Explicación paso a paso del bucle (n=3):
- i=0: s = 0 + 0 = 0
- i=1: s = 0 + 1 = 1
- i=2: s = 1 + 2 = 3
- i=3: condición falsa, sale del bucle.

return s → 3.

Pila de llamadas:
1. main: num=3, sum=? → apila proceso(3)
2. proceso(3): n=3, i=0→1→2→3, s=0→1→3 → return 3 → desapila
3. main: sum=3 → imprime 3 → desapila main (fin)

// --- java-t3-v7-005 ---
Se imprime: 9

Explicación de proceso1(3):
p1 = 1
Vuelta 1 (i=0): p1 += proceso2(0) → proceso2(0) devuelve 1 → p1=2
Vuelta 2 (i=1): p1 += proceso2(1) → proceso2(1): bucle 1 vez, p2=1+1=2 → devuelve 2 → p1=2+2=4
Vuelta 3 (i=2): p1 += proceso2(2) → proceso2(2): bucle 2 veces, p2=1+2=3, luego 3+2=5 → devuelve 5 → p1=4+5=9

return 9.

La pila llegó a tener 3 niveles: main → proceso1 → proceso2

// --- java-t3-v7-006 ---
La pila de llamadas se almacena en la memoria RAM. Es una zona de memoria reservada por la JVM (Java Virtual Machine) para gestionar la ejecución de métodos.

- Cada hilo (thread) tiene su propia pila de llamadas.
- Si la pila se llena (demasiadas llamadas anidadas), se produce un desbordamiento de pila: StackOverflowError (típico en recursión infinita).
- La pila es más rápida que el heap, pero tiene tamaño limitado.

// --- java-t3-v7-007 ---
VERDADERO (con matices).

Un método solo puede acceder directamente a:
- Sus propias variables locales.
- Sus propios parámetros.
- Variables GLOBALES (de clase, static) si las hay.

NO puede acceder a las variables locales de otros métodos aunque estén en la pila. Cada registro de activación es independiente.

Esto es lo que hace que Java sea seguro: un método no puede modificar accidentalmente las variables de otro método.

// --- java-t3-v7-008 ---
La recursión es cuando un método se llama a sí mismo. Cada llamada recursiva crea un NUEVO registro de activación en la pila, con sus propias variables locales.

Ejemplo: factorial(4)
Pila: factorial(4) → factorial(3) → factorial(2) → factorial(1)

1. factorial(4): 4 * factorial(3) → espera
2. factorial(3): 3 * factorial(2) → espera
3. factorial(2): 2 * factorial(1) → espera
4. factorial(1): return 1 (caso base) → DESAPILA
5. factorial(2): 2 * 1 = 2 → DESAPILA
6. factorial(3): 3 * 2 = 6 → DESAPILA
7. factorial(4): 4 * 6 = 24 → DESAPILA

Sin caso base (condición de parada) → StackOverflowError.


// ================================================
// Java YouTube - Tema 3: Ejercicio pila de llamadas
// ================================================

// --- java-t3-v8-001 ---
Se imprime: 18

Explicación:
proceso1(4): a=4, x=0, i recorre 0,2,4 (paso 2, 3 vueltas)

Vuelta 1 (i=0): x += proceso2(0,1)
  proceso2(0,1): a=0,b=1, y=1, j<1 (1 iteración): y=2 → return 2
  x = 0 + 2 = 2

Vuelta 2 (i=2): x += proceso2(2,3)
  proceso2(2,3): a=2,b=3, y=1, j<5 (5 iteraciones): y=6 → return 6
  x = 2 + 6 = 8

Vuelta 3 (i=4): x += proceso2(4,5)
  proceso2(4,5): a=4,b=5, y=1, j<9 (9 iteraciones): y=10 → return 10
  x = 8 + 10 = 18

Fórmula: proceso2(a,b) = 1 + (a + b)
proceso1(4) = 0 + 2 + 6 + 10 = 18

// --- java-t3-v8-002 ---
Da 3 vueltas para a=4:
- i=0 → entra (0 <= 4)
- i=2 → entra (2 <= 4)
- i=4 → entra (4 <= 4)
- i=6 → NO entra (6 > 4), termina el bucle

El incremento es i += 2, por lo que i toma valores 0, 2, 4.

// --- java-t3-v8-003 ---
Da exactamente (a + b) vueltas, porque j empieza en 0 y la condición es j < a + b.

Ejemplos:
- proceso2(0,1): a+b=1 → 1 vuelta
- proceso2(2,3): a+b=5 → 5 vueltas
- proceso2(4,5): a+b=9 → 9 vueltas

Como y empieza en 1 y se incrementa una vez por cada vuelta:
proceso2(a,b) = 1 + (a + b)

// --- java-t3-v8-004 ---
proceso2(a, b) = 1 + (a + b)

Explicación:
- y empieza en 1.
- El bucle da exactamente (a + b) iteraciones.
- En cada iteración se incrementa y en 1.
- Por lo tanto, y = 1 + (a + b).

Ejemplos:
- proceso2(0,1) = 1 + 1 = 2
- proceso2(2,3) = 1 + 5 = 6
- proceso2(4,5) = 1 + 9 = 10

// --- java-t3-v8-005 ---
1. Poner un BREAKPOINT (clic izquierdo al lado del número de línea) en la línea donde se llama a proceso1(4).
2. Iniciar depuración (F5 o clic en 'Run and Debug').
3. Usar Step Into (F11) para entrar en proceso1.
4. Observar el panel CALL STACK para ver: main → proceso1.
5. Al llegar a proceso2(i, i+1), Step Into para entrar en proceso2.
6. El Call Stack mostrará: main → proceso1 → proceso2.
7. Usar Step Over (F10) para ejecutar sin entrar en métodos.
8. Para bucles largos: poner otro breakpoint en el return y pulsar Continue (F5).
9. En el panel VARIABLES se ven los valores locales de cada frame.

// --- java-t3-v8-006 ---
proceso1(4): a=4, x inicial = 0

Después de vuelta 1 (i=0): x = 0 + proceso2(0,1) = 0 + 2 = 2
Después de vuelta 2 (i=2): x = 2 + proceso2(2,3) = 2 + 6 = 8
Después de vuelta 3 (i=4): x = 8 + proceso2(4,5) = 8 + 10 = 18

Valor final retornado: 18

(en el main, x = 18 → System.out.println(x) imprime 18)

// Error parseando cards_java_youtube_t3_v9.json: Se ha pasado un objeto no válido. Se esperaba ':' o '}'. (762): {
  "id": "programacion-java-youtube-t3-v9",
  "name": "Java YouTube - Tema 3: Menú de opciones con métodos",
  "description": "Cards del curso JAVA desde 0 - Menú de figuras con métodos, JavaDoc, bucles anidados, Scanner, do-while, switch",
  "subject": "Programación - Java",
  "cards": [
    {
      "id": "java-t3-v9-001",
      "front": "¿Cómo se implementa un menú cíclico en Java que se repite hasta que el usuario elige salir?",
      "back": "Con un bucle do-while que se ejecuta mientras la opción sea distinta de la de salida:

Scanner entrada = new Scanner(System.in);
int opcion;
do {
    mostrarMenu();
    opcion = entrada.nextInt();
    switch (opcion) {
        case 1: ... break;
        case 2: ... break;
        case 5: System.out.println("Fin"); break;
        default: System.out.println("Opcion no valida");
    }
} while (opcion != 5);
entrada.close();

El do-while garantiza que el menú se muestra al menos una vez.",
      "tags": ["java", "menu", "do-while", "switch", "scanner", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v9-002",
      "front": "¿Cómo se dibuja un cuadrado de nxn con asteriscos (con relleno) usando bucles anidados?",
      "back": "for (int fila = 0; fila < n; fila++) {
    for (int col = 0; col < n; col++) {
        System.out.print("*");
    }
    System.out.println();
}

- El bucle externo controla las FILAS (altura).
- El bucle interno controla las COLUMNAS (anchura).
- Se imprime "*" en cada posición, sin salto de línea.
- Al final de cada fila, System.out.println() para saltar a la siguiente.",
      "tags": ["java", "figuras", "cuadrado", "bucles-anidados", "tema-3"],
      "difficulty": "easy"
    },
    {
      "id": "java-t3-v9-003",
      "front": "¿Cómo se dibuja un cuadrado sin relleno (solo el borde) con asteriscos?",
      "back": "for (int fila = 0; fila < n; fila++) {
    for (int col = 0; col < n; col++) {
        if (fila == 0 || fila == n-1 || col == 0 || col == n-1) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }
    }
    System.out.println();
}

Se imprime "*" solo si:
- Es la primera o última fila (fila == 0 || fila == n-1)
- Es la primera o última columna (col == 0 || col == n-1)
En cualquier otro caso, se imprime un espacio " ".",
      "tags": ["java", "figuras", "cuadrado", "sin-relleno", "borde", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v9-004",
      "front": "¿Cómo se dibuja un triángulo rectángulo con relleno de altura dada?",
      "back": "for (int fila = 0; fila < altura; fila++) {
    for (int col = 0; col <= fila; col++) {
        System.out.print("*");
    }
    System.out.println();
}

- fila 0: 1 asterisco
- fila 1: 2 asteriscos
- fila 2: 3 asteriscos
- ...
- fila n-1: n asteriscos

El bucle interno imprime hasta `col <= fila`, por lo que cada fila tiene (fila+1) asteriscos.",
      "tags": ["java", "figuras", "triangulo", "rectangulo", "relleno", "tema-3"],
      "difficulty": "easy"
    },
    {
      "id": "java-t3-v9-005",
      "front": "¿Cómo se dibuja un triángulo rectángulo sin relleno (solo borde)?",
      "back": "for (int fila = 0; fila < altura; fila++) {
    for (int col = 0; col <= fila; col++) {
        if (fila == altura-1 || col == 0 || col == fila) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }
    }
    System.out.println();
}

Se imprime "*" solo si:
- Es la última fila (fila == altura-1) → base del triángulo
- Es la primera columna (col == 0) → lado izquierdo
- Es la diagonal (col == fila) → hipotenusa

El interior se rellena con espacios " ".",
      "tags": ["java", "figuras", "triangulo", "sin-relleno", "borde", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v9-006",
      "front": "¿Qué son los comentarios JavaDoc (/**) y cómo se usan?",
      "back": "Los comentarios JavaDoc se escriben con /** ... */ antes de un método o clase. Sirven para documentar el código y VS Code los muestra al usar el método.

Estructura:
/**
 * Descripción del método
 * @param nombreParámetro descripción del parámetro
 * @return descripción del valor devuelto (si no es void)
 */

En VS Code: /** + Enter genera la plantilla automáticamente.

Ejemplo:
/**
 * Dibuja un cuadrado con relleno
 * @param n lado del cuadrado
 */
static void cuadrado(int n) { ... }",
      "tags": ["java", "javadoc", "documentacion", "comentarios", "tema-3"],
      "difficulty": "easy"
    },
    {
      "id": "java-t3-v9-007",
      "front": "¿Por qué es buena práctica separar el código en métodos en lugar de ponerlo todo en el main?",
      "back": "Ventajas de usar métodos:
1. REUTILIZACIÓN: el mismo método se puede llamar varias veces.
2. LEGIBILIDAD: el main queda más limpio y fácil de entender.
3. MANTENIBILIDAD: si hay que cambiar la lógica, se modifica solo un método.
4. ORGANIZACIÓN: cada método tiene una responsabilidad única.
5. FACILITA PRUEBAS: se puede probar cada método por separado.

En el ejercicio del menú de figuras, cada figura (cuadrado, triángulo) tiene su propio método, y el main solo gestiona el flujo del menú.",
      "tags": ["java", "metodos", "buenas-practicas", "organizacion", "tema-3"],
      "difficulty": "medium"
    },
    {
      "id": "java-t3-v9-008",
      "front": "¿Cómo se puede pedir la dimensión de la figura por teclado dentro del menú?",
      "back": "Dentro del switch, antes de llamar al método de la figura, se pide la dimensión:

Scanner entrada = new Scanner(System.in);
int opcion, dimension;

do {
    mostrarMenu();
    opcion = entrada.nextInt();
    
    if (opcion >= 1 && opcion <= 4) {
        System.out.print("Indica el tamano de la figura: ");
        dimension = entrada.nextInt();
    }
    
    switch (opcion) {
        case 1: cuadrado(dimension); break;
        case 2: cuadradoSinRelleno(dimension); break;
        case 3: triangulo(dimension); break;
        case 4: trianguloSinRelleno(dimension); break;
        case 5: System.out.println("Fin del programa"); break;
        default: System.out.println("Opcion no valida");
    }
} while (opcion != 5);

Así se evita pedir tamaño cuando la opción no es válida o es salir.",
      "tags": ["java", "menu", "dimension", "scanner", "interactivo", "tema-3"],
      "difficulty": "medium"
    }
  ]
}

// Error parseando cards_java_youtube_t4_v1.json: Secuencia de escape no reconocida. (2357): {
  "id": "programacion-java-youtube-t4-v1",
  "name": "Java YouTube - Tema 4: Arrays (introducción)",
  "description": "Cards del curso JAVA desde 0 - Arrays unidimensionales: declaración, inicialización, length, for-each, valores por defecto",
  "subject": "Programación - Java",
  "cards": [
    {
      "id": "java-t4-v1-001",
      "front": "¿Qué es un array en Java?",
      "back": "Un array es una colección de tamaño FIJO que contiene variables del MISMO TIPO.

Características:
- Se accede a cada elemento mediante un ÍNDICE numérico.
- El primer índice es 0.
- El último índice es longitud - 1.
- El tamaño se fija al crearlo (con new) y NO se puede modificar.
- Todos los elementos son del mismo tipo (int, double, String, etc.).

Declaración:
int[] notas = new int[8];  // Array de 8 enteros
int notas[] = new int[8];  // Otra sintaxis válida",
      "tags": ["java", "arrays", "definicion", "tema-4"],
      "difficulty": "easy"
    },
    {
      "id": "java-t4-v1-002",
      "front": "¿Cómo se declara e inicializa un array en Java?",
      "back": "SIN VALORES INICIALES (todos a valor por defecto):
int[] notas = new int[5];  // {0, 0, 0, 0, 0}

CON VALORES INICIALES:
int[] notas = {10, 20, 30, 40, 50};  // 5 elementos

DECLARAR PRIMERO, INICIALIZAR DESPUÉS:
int[] notas;          // Solo declaración
notas = new int[5];   // Inicialización

DOS SINTAXIS:
int[] notas = new int[5];   // Recomendada
int notas[] = new int[5];   // También válida",
      "tags": ["java", "arrays", "declaracion", "inicializacion", "tema-4"],
      "difficulty": "easy"
    },
    {
      "id": "java-t4-v1-003",
      "front": "¿Qué es la propiedad length en un array?",
      "back": "length es un ATRIBUTO (no un método, no lleva paréntesis) que devuelve el número de elementos del array.

int[] arr = {10, 20, 30};
arr.length → 3

Último elemento:
arr[arr.length - 1]  → arr[2] = 30

Bucle típico:
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}

¡Cuidado! arr.length es el tamaño total, pero el último índice es length-1.",
      "tags": ["java", "arrays", "length", "propiedad", "tema-4"],
      "difficulty": "easy"
    },
    {
      "id": "java-t4-v1-004",
      "front": "¿Qué valores por defecto tienen los arrays según su tipo?",
      "back": "int, short, byte, long → 0
float, double → 0.0
boolean → false
char → '\0' (carácter nulo Unicode, el primero)
Objetos (String incluido) → null

Ejemplo:
int[] nums = new int[5];      // {0, 0, 0, 0, 0}
boolean[] flags = new boolean[3]; // {false, false, false}
String[] nombres = new String[4]; // {null, null, null, null}

Si no se asignan valores, todos los elementos tendrán el valor por defecto de su tipo.",
      "tags": ["java", "arrays", "valores-por-defecto", "tipos", "tema-4"],
      "difficulty": "easy"
    },
    {
      "id": "java-t4-v1-005",
      "front": "¿Qué es ArrayIndexOutOfBoundsException y cuándo ocurre?",
      "back": "Es una excepción (error en tiempo de ejecución) que ocurre cuando se intenta acceder a un índice que NO existe en el array.

int[] arr = new int[5];  // Índices válidos: 0, 1, 2, 3, 4
arr[5] = 10;  // ERROR: ArrayIndexOutOfBoundsException

El índice 5 no existe porque el array tiene 5 elementos (0..4).

Regla: el último índice válido es SIEMPRE longitud - 1.

Siempre usar:
for (int i = 0; i < arr.length; i++)  // NUNCA <=

Un error común: confundir length (tamaño) con el último índice (length-1).",
      "tags": ["java", "arrays", "exception", "error", "indice", "tema-4"],
      "difficulty": "medium"
    },
    {
      "id": "java-t4-v1-006",
      "front": "¿Cómo se recorre un array con el bucle for-each (for mejorado)?",
      "back": "Sintaxis:
for (tipo variable : array) {
    // usar variable
}

Ejemplo:
int[] numeros = {10, 20, 30, 40, 50};
for (int n : numeros) {
    System.out.println(n);
}

Ventajas:
- Más corto y legible.
- No hay riesgo de error con índices.

Desventajas:
- Solo LECTURA: NO se pueden modificar los elementos.
- No se tiene acceso al índice (no se sabe en qué posición se está).

Para modificar elementos se necesita el for tradicional con índice.",
      "tags": ["java", "arrays", "for-each", "bucle", "recorrer", "tema-4"],
      "difficulty": "medium"
    },
    {
      "id": "java-t4-v1-007",
      "front": "¿Cuál es la estructura típica del bucle for para recorrer un array?",
      "back": "for (int i = 0; i < array.length; i++) {
    // array[i] es el elemento en la posición i
}

Esta estructura funciona para CUALQUIER array, independientemente de su tamaño:
- Inicialización: i = 0 (primer elemento)
- Condición: i < array.length (mientras no superemos el tamaño)
- Incremento: i++ (pasar al siguiente elemento)

Ejemplo completo:
int[] notas = new int[5];
for (int i = 0; i < notas.length; i++) {
    notas[i] = i * 2;  // Asigna {0, 2, 4, 6, 8}
}

NUNCA usar i <= array.length (eso daría ArrayIndexOutOfBoundsException en la última iteración).",
      "tags": ["java", "arrays", "bucle", "for", "recorrer", "tema-4"],
      "difficulty": "easy"
    }
  ]
}

// Error parseando cards_java_youtube_t4_v2.json: Se ha pasado un objeto no válido. Se esperaba ':' o '}'. (5742): {
  "id": "programacion-java-youtube-t4-v2",
  "name": "Java YouTube - Tema 4: Búsqueda Binaria (recursiva)",
  "description": "Cards del curso JAVA desde 0 - Algoritmo de búsqueda binaria recursiva en arrays ordenados: implementación, método intermedio, traza y complejidad",
  "subject": "Programación - Java",
  "cards": [
    {
      "id": "java-t4-v2-001",
      "front": "¿Qué es el algoritmo de búsqueda binaria?",
      "back": "Es un algoritmo MUY EFICIENTE para buscar un elemento en una colección ORDENADA.

En lugar de analizar todos los elementos uno por uno (búsqueda lineal), lo que hace es:
1. Colocarse en el MEDIO de la colección.
2. Si ese elemento es el buscado → FIN (encontrado).
3. Si el elemento del medio es MAYOR que el buscado → buscar en la MITAD IZQUIERDA (todos los de la derecha son mayores).
4. Si el elemento del medio es MENOR que el buscado → buscar en la MITAD DERECHA (todos los de la izquierda son menores).

REQUISITO: el array debe estar ORDENADO (ascendente).

Complejidad: O(log n) — mucho más eficiente que búsqueda lineal O(n).

Ejemplo: buscar el 4 en {1,2,3,4,5,6,7,8} → en 1 paso lo encuentra (el 4 está en el medio).",
      "tags": ["java", "busqueda-binaria", "algoritmo", "definicion", "tema-4"],
      "difficulty": "easy"
    },
    {
      "id": "java-t4-v2-002",
      "front": "Implementa el método de búsqueda binaria recursiva en Java.

Firma: static boolean busquedaBinaria(int[] nums, int buscado, int limiteInf, int limiteSup)",
      "back": "static boolean busquedaBinaria(int[] nums, int buscado, int limiteInf, int limiteSup) {
    // Caso base: no quedan elementos
    if (limiteInf > limiteSup) {
        return false;
    }

    int mitad = (limiteInf + limiteSup) / 2;

    if (nums[mitad] == buscado) {
        return true;  // Encontrado
    } else if (nums[mitad] < buscado) {
        // Buscar en la mitad derecha
        return busquedaBinaria(nums, buscado, mitad + 1, limiteSup);
    } else {
        // Buscar en la mitad izquierda
        return busquedaBinaria(nums, buscado, limiteInf, mitad - 1);
    }
}

Parámetros:
- nums: array de enteros ORDENADO
- buscado: número a encontrar
- limiteInf: índice inferior del subarray
- limiteSup: índice superior del subarray

Devuelve: true si lo encuentra, false si no.",
      "tags": ["java", "busqueda-binaria", "recursividad", "codigo", "tema-4"],
      "difficulty": "medium"
    },
    {
      "id": "java-t4-v2-003",
      "front": "Explica el caso base de la búsqueda binaria recursiva.

¿Cuándo devuelve false?",
      "back": "El caso base es:

if (limiteInf > limiteSup) {
    return false;
}

Esto ocurre cuando:
- Hemos dividido el array tantas veces que ya no quedan elementos.
- El límite inferior ha superado al límite superior.
- Significa que el elemento NO está en el array.

Ejemplo: buscar 9 en {1,2,3,4,5,6,7,8}
1º: inf=0, sup=7 → mitad=3 (nums[3]=4). 9>4 → buscar derecha (inf=4, sup=7)
2º: inf=4, sup=7 → mitad=5 (nums[5]=6). 9>6 → buscar derecha (inf=6, sup=7)
3º: inf=6, sup=7 → mitad=6 (nums[6]=7). 9>7 → buscar derecha (inf=7, sup=7)
4º: inf=7, sup=7 → mitad=7 (nums[7]=8). 9>8 → buscar derecha (inf=8, sup=7)
5º: inf=8 > sup=7 → return false (no encontrado)

NOTA: La condición es inf > sup, NO inf >= sup. Si inf == sup aún hay 1 elemento.",
      "tags": ["java", "busqueda-binaria", "recursividad", "caso-base", "tema-4"],
      "difficulty": "medium"
    },
    {
      "id": "java-t4-v2-004",
      "front": "¿Cómo se calcula la posición central (mitad) en la búsqueda binaria?",
      "back": "int mitad = (limiteInf + limiteSup) / 2;

Se suman los dos límites y se divide entre 2.

IMPORTANTE: Al ser enteros, la división TRUNCA (no redondea).

Ejemplos:
- inf=0, sup=7 → (0+7)/2 = 3 → mitad = 3
- inf=4, sup=7 → (4+7)/2 = 5 → mitad = 5
- inf=1, sup=2 → (1+2)/2 = 1 → mitad = 1
- inf=2, sup=3 → (2+3)/2 = 2 → mitad = 2

Siempre se queda con el elemento de la IZQUIERDA del centro cuando hay un número par de elementos.

Para arrays con 8 elementos (0 a 7):
- mitad = 3 → nums[3] es el 4º elemento (índice 3, no el 3.5).",
      "tags": ["java", "busqueda-binaria", "mitad", "indice", "calculo", "tema-4"],
      "difficulty": "easy"
    },
    {
      "id": "java-t4-v2-005",
      "front": "Explica las 3 condiciones dentro de la búsqueda binaria recursiva.",
      "back": "Dentro del método, después de calcular la mitad, hay TRES casos:

1. nums[mitad] == buscado:
   return true;
   → El elemento central ES el que buscamos. FIN.

2. nums[mitad] < buscado:
   return busquedaBinaria(nums, buscado, mitad + 1, limiteSup);
   → El central es MENOR que el buscado.
   → Todos los de la izquierda son aún menores.
   → Buscar en la MITAD DERECHA (desde mitad+1 hasta limiteSup).

3. nums[mitad] > buscado (else):
   return busquedaBinaria(nums, buscado, limiteInf, mitad - 1);
   → El central es MAYOR que el buscado.
   → Todos los de la derecha son aún mayores.
   → Buscar en la MITAD IZQUIERDA (desde limiteInf hasta mitad-1).

Ejemplo básico: buscar 4 en {1,2,3,4,5,6,7,8}
- mit=3, nums[3]=4, 4==4 → return true (¡1 sola llamada!)",
      "tags": ["java", "busqueda-binaria", "condiciones", "recursividad", "tema-4"],
      "difficulty": "medium"
    },
    {
      "id": "java-t4-v2-006",
      "front": "¿Qué es el método intermedio (wrapper) y por qué se usa en la búsqueda binaria?",
      "back": "El método recursivo necesita 4 parámetros: nums, buscado, limiteInf, limiteSup.

Es INCÓMODO llamarlo siempre con los límites iniciales (0 y length-1).

Solución: crear un método INTERMEDIO que solo reciba 2 parámetros:

static void mostrarBusquedaBinaria(int[] nums, int buscado) {
    if (busquedaBinaria(nums, buscado, 0, nums.length - 1)) {
        System.out.println("El numero " + buscado + " esta en el array");
    } else {
        System.out.println("El numero " + buscado + " NO esta en el array");
    }
}

Este método:
- Inicializa los límites a 0 y nums.length-1.
- Llama al método recursivo.
- Muestra el resultado por pantalla.

Ejemplo de uso:
mostrarBusquedaBinaria(nums, 4);  // "El numero 4 esta en el array"
mostrarBusquedaBinaria(nums, 9);  // "El numero 9 NO esta en el array"",
      "tags": ["java", "busqueda-binaria", "metodo-intermedio", "wrapper", "tema-4"],
      "difficulty": "easy"
    },
    {
      "id": "java-t4-v2-007",
      "front": "Haz la traza de búsqueda binaria para buscar el 9 en: {1, 2, 3, 4, 5, 6, 7, 8}

Explica paso a paso por qué NO lo encuentra.",
      "back": "Array: {1,2,3,4,5,6,7,8} (índices 0..7)
Buscado: 9

LLAMADA 1: busquedaBinaria(nums, 9, 0, 7)
- inf=0, sup=7 → 0 < 7 ✓ (no es caso base)
- mitad = (0+7)/2 = 3
- nums[3] = 4
- 4 < 9 → buscar derecha: busquedaBinaria(nums, 9, 4, 7)

LLAMADA 2: busquedaBinaria(nums, 9, 4, 7)
- inf=4, sup=7 → 4 < 7 ✓
- mitad = (4+7)/2 = 5
- nums[5] = 6
- 6 < 9 → buscar derecha: busquedaBinaria(nums, 9, 6, 7)

LLAMADA 3: busquedaBinaria(nums, 9, 6, 7)
- inf=6, sup=7 → 6 < 7 ✓
- mitad = (6+7)/2 = 6
- nums[6] = 7
- 7 < 9 → buscar derecha: busquedaBinaria(nums, 9, 7, 7)

LLAMADA 4: busquedaBinaria(nums, 9, 7, 7)
- inf=7, sup=7 → 7 <= 7, NO es caso base aún
- mitad = (7+7)/2 = 7
- nums[7] = 8
- 8 < 9 → buscar derecha: busquedaBinaria(nums, 9, 8, 7)

LLAMADA 5: busquedaBinaria(nums, 9, 8, 7)
- inf=8, sup=7 → 8 > 7 → caso base: return FALSE
- El 9 NO está en el array.

5 llamadas recursivas en total.",
      "tags": ["java", "busqueda-binaria", "traza", "recursividad", "ejemplo", "tema-4"],
      "difficulty": "hard"
    },
    {
      "id": "java-t4-v2-008",
      "front": "¿Cuál es la complejidad de la búsqueda binaria y por qué es más eficiente que la búsqueda lineal?",
      "back": "BÚSQUEDA BINARIA: O(log n)
BÚSQUEDA LINEAL: O(n)

¿Por qué es más eficiente la binaria?
- En cada paso DIVIDE el problema a la mitad.
- No necesita revisar todos los elementos.

Ejemplo con array de 8 elementos:
- Lineal: hasta 8 comparaciones.
- Binaria: máximo 4 comparaciones (log₂8 = 3 comparaciones + 1).

Ejemplo con array de 1.000.000 elementos:
- Lineal: hasta 1.000.000 comparaciones.
- Binaria: máximo 20 comparaciones (log₂1.000.000 ≈ 20).

¡La binaria es 50.000 VECES más rápida para 1 millón de elementos!

REQUISITO: el array debe estar ORDENADO. Si no, no funciona.

Para arrays pequeños (n < 100), la diferencia es pequeña.
Para arrays GRANDES, la búsqueda binaria es MUCHO más eficiente.",
      "tags": ["java", "busqueda-binaria", "complejidad", "eficiencia", "O-log-n", "tema-4"],
      "difficulty": "medium"
    },
    {
      "id": "java-t4-v2-009",
      "front": "Escribe el código COMPLETO de la búsqueda binaria recursiva (método recursivo + método intermedio).

Incluye el main con:
- Array {1,2,3,4,5,6,7,8}
- Buscar el 4 (existe)
- Buscar el 9 (no existe)",
      "back": "class BusquedaBinaria {

    static boolean busquedaBinaria(int[] nums, int buscado, int limiteInf, int limiteSup) {
        if (limiteInf > limiteSup) {
            return false;
        }

        int mitad = (limiteInf + limiteSup) / 2;

        if (nums[mitad] == buscado) {
            return true;
        } else if (nums[mitad] < buscado) {
            return busquedaBinaria(nums, buscado, mitad + 1, limiteSup);
        } else {
            return busquedaBinaria(nums, buscado, limiteInf, mitad - 1);
        }
    }

    static void mostrarBusquedaBinaria(int[] nums, int buscado) {
        if (busquedaBinaria(nums, buscado, 0, nums.length - 1)) {
            System.out.println("El numero " + buscado + " esta en el array");
        } else {
            System.out.println("El numero " + buscado + " NO esta en el array");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};

        mostrarBusquedaBinaria(nums, 4);  // "El numero 4 esta en el array"
        mostrarBusquedaBinaria(nums, 9);  // "El numero 9 NO esta en el array"
    }
}

Salida:
El numero 4 esta en el array
El numero 9 NO esta en el array",
      "tags": ["java", "busqueda-binaria", "codigo-completo", "recursividad", "tema-4"],
      "difficulty": "medium"
    },
    {
      "id": "java-t4-v2-010",
      "front": "¿Qué diferencia hay entre nums[mitad] < buscado y nums[mitad] > buscado en la búsqueda binaria?

Pista: ¿hacia qué lado se busca en cada caso?",
      "back": "SI nums[mitad] < buscado:
- El elemento del centro es MENOR que el buscado.
- Como el array está ordenado ASCENDENTE, todos los de la IZQUIERDA son aún más pequeños.
- Buscar en la MITAD DERECHA.
- Llamada: busquedaBinaria(nums, buscado, mitad + 1, limiteSup)

SI nums[mitad] > buscado (else):
- El elemento del centro es MAYOR que el buscado.
- Todos los de la DERECHA son aún más grandes.
- Buscar en la MITAD IZQUIERDA.
- Llamada: busquedaBinaria(nums, buscado, limiteInf, mitad - 1)

Regla mnemotécnica:
- El buscado es mayor que el centro → ve a la derecha (números más grandes).
- El buscado es menor que el centro → ve a la izquierda (números más pequeños).

Ejemplo: buscar 9 (grande) en {1..8} → nums[3]=4 < 9 → derecha.
Ejemplo: buscar 2 (pequeño) en {1..8} → nums[3]=4 > 2 → izquierda.",
      "tags": ["java", "busqueda-binaria", "recursividad", "derecha-izquierda", "comparacion", "tema-4"],
      "difficulty": "medium"
    }
  ]
}


// ================================================
// cards_java_youtube_t4_v3
// ================================================

// ---  ---
import java.util.Random;

public class GeneradorMatrices {

    public static void main(String[] args) {
        // Matriz irregular
        int[][] nums = generarMatriz(0, 5, 0, 5, 9);
        for (int[] fila : nums) {
            System.out.println(Arrays.toString(fila));
        }
        
        // Matriz cuadrada 9x9
        int[][] cuadrada = generarMatriz(9, 9);
        
        // Matriz regular 10x5
        int[][] regular = generarMatriz(10, 5, 20);
    }

    static int[][] generarMatriz(int anchoMin, int anchoMax, int altoMin, int altoMax, int numMax) {
        if (anchoMin < 0) anchoMin = 0;
        if (anchoMax < 0) anchoMax = 0;
        if (altoMin < 0) altoMin = 0;
        if (altoMax < 0) altoMax = 0;
        if (anchoMin > anchoMax) anchoMin = anchoMax;
        if (altoMin > altoMax) altoMin = altoMax;

        Random r = new Random();
        int[][] matriz = new int[r.nextInt(altoMin, altoMax + 1)][];
        for (int i = 0; i < matriz.length; i++) {
            int columnas = r.nextInt(anchoMin, anchoMax + 1);
            matriz[i] = new int[columnas];
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = r.nextInt(numMax + 1);
            }
        }
        return matriz;
    }

    static int[][] generarMatriz(int lado, int numMax) {
        return generarMatriz(lado, lado, lado, lado, numMax);
    }

    static int[][] generarMatriz(int ancho, int alto, int numMax) {
        return generarMatriz(ancho, ancho, alto, alto, numMax);
    }
}

// Error parseando cards_java_youtube_t7_v1.json: Primitivo JSON no válido: d": "programacion-java-youtube-t7-v1",
  "name": "Java YouTube - Tema 7: Métodos Referenciados (Method Reference)",
  "description": "Cards del curso JAVA desde 0 - Métodos referenciados: concepto, tipos, sintaxis, ejemplos con Calculadora, Function<String,Integer>",
  "subject": "Programación - Java",
  "cards": [
    {
      "id": "java-t7-v1-001",
      "front": "¿Qué es un método referenciado (method reference) en Java?",
      "back": "Un método referenciado es una forma abreviada de escribir una expresión lambda que simplemente llama a un método ya existente.

Sintaxis: `ClaseOMetodo::nombreMetodo`

En lugar de programar la expresión dentro de la lambda, se hace referencia a un método que ya está programado en otra clase.

Se introdujo en Java 8, al igual que las interfaces funcionales y las expresiones lambda.

Ejemplo:
- Lambda: `nombre -> System.out.println(nombre)`
- Method Reference: `System.out::println`

Ambos hacen exactamente lo mismo: imprimir cada elemento.",
      "tags": ["java", "method-reference", "metodos-referenciados", "definicion", "tema-7"],
      "difficulty": "easy"
    },
    {
      "id": "java-t7-v1-002",
      "front": "¿Cuáles son las ventajas de usar métodos referenciados frente a expresiones lambda?",
      "back": "1. MÁS LEGIBLES: sintaxis más concisa. Con solo ver el nombre del método sabemos qué hace (si tiene un nombre significativo).

2. REUTILIZACIÓN DE CÓDIGO: al hacer referencia a un método ya probado y optimizado, se evita duplicar código. Si se usa la misma lambda en dos clases distintas, cualquier cambio habría que hacerlo en ambos sitios. Con un método referenciado, solo se cambia en un lugar.

3. FACILITAN LA REFACTORIZACIÓN: cualquier cambio en la implementación del método referenciado se refleja automáticamente en todos los sitios donde se use.

4. INTEROPERABILIDAD CON INTERFACES FUNCIONALES: se pueden combinar con la API de Stream y otras bibliotecas de programación funcional.

NOTA: A veces es mejor usar lambda si el método solo se va a ejecutar una vez o no sabemos en qué clase incluirlo.",
      "tags": ["java", "method-reference", "ventajas", "legibilidad", "reutilizacion", "tema-7"],
      "difficulty": "easy"
    },
    {
      "id": "java-t7-v1-003",
      "front": "¿Cuáles son los 4 tipos de métodos referenciados en Java?",
      "back": "1. REFERENCIA A MÉTODO ESTÁTICO:
   `Clase::metodoEstatico`
   Ej: `Integer::parseInt`

2. REFERENCIA A MÉTODO DE INSTANCIA (de un objeto específico):
   `objeto::metodoInstancia`
   Ej: `variableString::length`

3. REFERENCIA A MÉTODO DE INSTANCIA DE UN OBJETO ARBITRARIO DE UN TIPO PARTICULAR:
   `Clase::metodoInstancia`
   Ej: `String::length` (sin instancia, se aplica al parámetro)

4. REFERENCIA A CONSTRUCTOR:
   `Clase::new`
   Ej: `Persona::new`

Diferencia clave entre tipo 2 y 3:
- Tipo 2 usa una instancia concreta (`str::length`)
- Tipo 3 usa la clase y se aplica al objeto que recibe como parámetro (`String::length`)",
      "tags": ["java", "method-reference", "tipos", "sintaxis", "tema-7"],
      "difficulty": "medium"
    },
    {
      "id": "java-t7-v1-004",
      "front": "Escribe el ejemplo completo de método referenciado con forEach y System.out::println",
      "back": "```java
List<String> nombres = Arrays.asList(\"Pepe\", \"Tom\", \"John\");

// Con EXPRESIÓN LAMBDA:
nombres.forEach(nombre -> System.out.println(nombre));

// Con MÉTODO REFERENCIADO (equivalente):
nombres.forEach(System.out::println);

// Ambos imprimen:
// Pepe
// Tom
// John
```

Explicación:
- `nombres.forEach()` itera sobre cada elemento de la lista.
- La lambda `nombre -> System.out.println(nombre)` recibe un nombre y lo imprime.
- El method reference `System.out::println` hace exactamente lo mismo: imprime cada elemento.
- Es más conciso y legible (System.out es un objeto, println es su método de instancia).",
      "tags": ["java", "method-reference", "foreach", "println", "ejemplo", "tema-7"],
      "difficulty": "easy"
    },
    {
      "id": "java-t7-v1-005",
      "front": "Implementa la interfaz funcional Calculadora y úsala con métodos referenciados para: suma, resta, multiplicación, división, cuadrado de suma y cálculo complejo.",
      "back": "```java
// INTERFAZ FUNCIONAL
@FunctionalInterface
interface Calculadora {
    int operacion(int a, int b);
}

// CLASE CON LOS MÉTODOS A REFERENCIAR
class EjemploMetodoReferenciados {
    static int suma(int a, int b) { return a + b; }
    static int resta(int a, int b) { return a - b; }
    static int multiplicacion(int a, int b) { return a * b; }
    static int division(int a, int b) { return a / b; }
    static int cuadradoSuma(int a, int b) { return (int) Math.pow(a + b, 2); }
    static int calculoComplejo(int a, int b) {
        a += b;
        b += a;
        return a * b;
    }

    public static void main(String[] args) {
        int a = 3, b = 5;

        // ASIGNACIÓN CON MÉTODOS REFERENCIADOS
        Calculadora suma = EjemploMetodoReferenciados::suma;
        Calculadora resta = EjemploMetodoReferenciados::resta;
        Calculadora mult = EjemploMetodoReferenciados::multiplicacion;
        Calculadora div = EjemploMetodoReferenciados::division;
        Calculadora cuadSuma = EjemploMetodoReferenciados::cuadradoSuma;
        Calculadora compleja = EjemploMetodoReferenciados::calculoComplejo;

        System.out.println(\"A + B = \" + suma.operacion(a, b));       // 8
        System.out.println(\"A - B = \" + resta.operacion(a, b));     // -2
        System.out.println(\"A * B = \" + mult.operacion(a, b));      // 15
        System.out.println(\"A / B = \" + div.operacion(a, b));       // 0
        System.out.println(\"(A+B)^2 = \" + cuadSuma.operacion(a, b)); // 64
        System.out.println(\"Complejo = \" + compleja.operacion(a, b)); // 104
    }
}
```

Cada método referenciado tiene la MISMA firma que el método abstracto de la interfaz: recibe 2 ints y devuelve 1 int.",
      "tags": ["java", "method-reference", "calculadora", "codigo", "ejemplo", "tema-7"],
      "difficulty": "medium"
    },
    {
      "id": "java-t7-v1-006",
      "front": "¿Qué es la interfaz funcional Function<T, R> y cómo se usa con métodos referenciados?",
      "back": "`Function<T, R>` es una interfaz funcional del paquete `java.util.function`.
- T: tipo del argumento (entrada)
- R: tipo del resultado (salida)
- Método abstracto: `R apply(T t)`

Sirve para realizar TRANSFORMACIONES: convertir un tipo de dato en otro.

Ejemplo 1 - String a Integer (longitud):
```java
Function<String, Integer> longitudCadena = String::length;
int longitud = longitudCadena.apply(\"Hola mundo\");  // 10
```

Ejemplo 2 - Integer a Integer (cuadrado con lambda):
```java
Function<Integer, Integer> cuadrado = x -> x * x;
int resultado = cuadrado.apply(5);  // 25
```

Combinación: convertir String a su longitud, y luego al cuadrado:
```java
int longitud = longitudCadena.apply(\"Hola mundo\");  // 10
int cuadLong = cuadrado.apply(longitud);             // 100
```

Function es muy útil en streams y colecciones para transformaciones.",
      "tags": ["java", "function", "interfaz-funcional", "apply", "transformacion", "tema-7"],
      "difficulty": "medium"
    },
    {
      "id": "java-t7-v1-007",
      "front": "¿Qué diferencia hay entre estos dos métodos referenciados?

1. `String::length`
2. `objetoString::length`",
      "back": "1. `String::length` (CON MAYÚSCULA - nombre de clase)
   → REFERENCIA A MÉTODO DE INSTANCIA DE UN OBJETO ARBITRARIO
   → La String sobre la que se llama al método se pasa como parámetro.
   → Ej: `Function<String, Integer> f = String::length;`
   → `f.apply(\"hola\")` equivale a `\"hola\".length()`

2. `objetoString::length` (en minúscula - nombre de variable/objeto)
   → REFERENCIA A MÉTODO DE INSTANCIA DE UN OBJETO ESPECÍFICO
   → Usa una instancia concreta ya existente.
   → Ej: `String saludo = \"hola\";`
   → `Supplier<Integer> s = saludo::length;`
   → `s.get()` siempre devuelve la longitud de \"hola\" (no recibe parámetros)

Diferencia clave:
- Tipo 2 (objeto concreto): el método se aplica SIEMPRE al mismo objeto.
- Tipo 3 (clase): el método se aplica al objeto que se recibe como argumento.",
      "tags": ["java", "method-reference", "diferencia", "instancia", "clase-vs-objeto", "tema-7"],
      "difficulty": "hard"
    },
    {
      "id": "java-t7-v1-008",
      "front": "¿Cómo se hace una referencia a constructor en Java? Pon un ejemplo.",
      "back": "La referencia a constructor se hace con `Clase::new`.

Se usa cuando se quiere crear una instancia de una clase usando una interfaz funcional que tenga un método que devuelva un objeto.

Ejemplo con interfaz funcional propia:
```java
@FunctionalInterface
interface ProvedorPersona {
    Persona crear(String nombre, int edad);
}

// Constructor de Persona
class Persona {
    String nombre;
    int edad;
    Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}

// Uso con method reference
ProvedorPersona fabrica = Persona::new;
Persona p = fabrica.crear(\"Ana\", 25);
```

Ejemplo con la API de Stream (más común):
```java
// Crear personas a partir de un array de nombres
List<String> nombres = Arrays.asList(\"Ana\", \"Luis\", \"Eva\");
List<Persona> personas = nombres.stream()
    .map(Persona::new)  // constructor que solo recibe nombre
    .toList();
```

El constructor debe tener una firma compatible con el método abstracto de la interfaz funcional.",
      "tags": ["java", "method-reference", "constructor", "new", "ejemplo", "tema-7"],
      "difficulty": "medium"
    },
    {
      "id": "java-t7-v1-009",
      "front": "¿Cuándo es mejor usar una expresión lambda en lugar de un método referenciado?",
      "back": "Aunque los métodos referenciados son preferibles en muchos casos, hay situaciones donde es mejor usar una lambda:

1. CÓDIGO DESECHABLE: si la lógica solo se va a ejecutar UNA VEZ y no merece la pena crear un método aparte.

2. SIN CLASE ADECUADA: si no sabemos en qué clase incluir ese método (no tenemos un contexto semántico donde tenga sentido).

3. LÓGICA MUY SIMPLE: operaciones triviales como `x -> x * x` que no merecen un método aparte.

4. NECESITAMOS VARIABLES LOCALES: las lambdas pueden capturar variables locales del ámbito; los métodos referenciados no.

Ejemplo de lambda más adecuada que method reference:
```java
Function<Integer, Integer> cuadrado = x -> x * x;
// vs crear un método static int cuadrado(int x) { return x * x; }
```

REGLAS PRÁCTICAS:
- Si el método ya existe → method reference.
- Si es una operación nueva y se usa varias veces → crear método y referenciarlo.
- Si es una operación simple de usar y olvidar → lambda.",
      "tags": ["java", "lambda", "method-reference", "comparacion", "buena-practica", "tema-7"],
      "difficulty": "medium"
    },
    {
      "id": "java-t7-v1-010",
      "front": "Escribe el código completo del ejemplo con Function<String, Integer> y Function<Integer, Integer> usando method reference y lambda.",
      "back": "```java
import java.util.function.Function;

class EjemploFunction {
    public static void main(String[] args) {
        // 1. Transformar String a Integer (longitud)
        // String::length es un método referenciado (tipo 3: clase::metodoInstancia)
        Function<String, Integer> longitudCadena = String::length;

        // 2. Transformar Integer a Integer (cuadrado)
        // Usamos lambda porque es una operación simple de un solo uso
        Function<Integer, Integer> cuadrado = x -> x * x;

        String texto = \"Hola mundo\";
        int longitud = longitudCadena.apply(texto);
        int cuadradoLongitud = cuadrado.apply(longitud);

        System.out.println(\"Texto: \" + texto);
        System.out.println(\"Longitud: \" + longitud);      // 10 o 12 (depende del texto)
        System.out.println(\"Cuadrado: \" + cuadradoLongitud); // 100 o 144
    }
}
```

Con \"Hola mundo\":
- longitud = 10
- cuadrado = 100

Con \"Hola\":
- longitud = 4
- cuadrado = 16

NOTA: `String::length` funciona aquí porque String es la clase (TIPO) sobre la que se invoca el método. `apply(\"texto\")` equivale a `\"texto\".length()`.",
      "tags": ["java", "function", "method-reference", "string-length", "lambda", "codigo-completo", "tema-7"],
      "difficulty": "medium"
    }
  ]
}
.

// ================================================
// Java YouTube - Tema 7: Programación Funcional (API Stream)
// ================================================

// --- java-t7-v2-001 ---
Es una API introducida en Java 8 (junto con interfaces funcionales, lambdas y métodos referenciados) que permite procesar datos de forma funcional.

Un Stream es una secuencia de elementos que se pueden procesar en paralelo o de forma secuencial.

Proporciona métodos para:
- Filtrar elementos
- Transformar tipos de datos
- Convertir colecciones

NO almacena datos, solo los procesa.

Ejemplo básico:
```java
List<String> resultado = lista.stream()
    .filter(n -> n.length() > 3)
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.toList());
```

// --- java-t7-v2-002 ---
1. OPERACIONES INTERMEDIAS
   - Transforman un Stream en OTRO Stream
   - Son PEREZOSAS (lazy): no se ejecutan hasta que se invoca una terminal
   - Ej: filter, map, sorted, distinct, flatMap

2. OPERACIONES TERMINALES
   - Producen un RESULTADO final (nueva colección, valor único, acción)
   - Desencadenan la ejecución de todas las intermedias
   - Ej: collect, reduce, forEach, count, min, max

ESQUEMA:
```
Stream -> [filter] -> [map] -> [sorted] -> collect -> Lista
  (lazy)   (lazy)    (lazy)    (lazy)    (terminal) (resultado)
```

Sin operación terminal, las intermedias NO se ejecutan nunca.

// --- java-t7-v2-003 ---
Una operación intermedia perezosa es aquella que NO se ejecuta en el momento en que se declara. Simplemente queda REGISTRADA en la cadena de operaciones.

Todas las operaciones intermedias se EJECUTAN DE GOLPE cuando se invoca una operación TERMINAL.

Ejemplo:
```java
lista.stream()
    .filter(n -> n % 2 == 0)   // NO se ejecuta aún
    .map(n -> n * n)           // NO se ejecuta aún
    .forEach(System.out::println); // TERMINAL: AQUÍ se ejecuta TODO
```

Ventajas:
- Optimización: Java puede combinar operaciones
- Eficiencia: solo se procesan los elementos necesarios
- Posibilidad de trabajar con streams infinitos (takeWhile, limit)

// --- java-t7-v2-004 ---
1. filter(Predicate<T>)
   - Filtra elementos según una condición.
   - Ej: .filter(nombre -> nombre.length() > 3)

2. map(Function<T,R>)
   - Transforma cada elemento aplicando una función.
   - Ej: .map(String::toUpperCase)

3. flatMap(Function<T, Stream<R>>)
   - Aplana un Stream de colecciones en elementos individuales.
   - Ej: .flatMap(Collection::stream)

4. distinct()
   - Elimina elementos duplicados (usa equals()).

5. sorted() / sorted(Comparator<T>)
   - sorted() ordena por orden natural (Comparable)
   - sorted(Comparator) ordena según un comparador.

6. takeWhile(Predicate<T>)
   - Toma elementos MIENTRAS se cumpla la condición.

7. dropWhile(Predicate<T>)
   - Elimina elementos MIENTRAS se cumpla la condición.

// --- java-t7-v2-005 ---
1. forEach(Consumer<T>)
   - Ejecuta una acción por cada elemento.
   - Ej: .forEach(System.out::println)

2. collect(Collector<T,A,R>)
   - Transforma el Stream en una colección u objeto.
   - Ej: .collect(Collectors.toList())

3. reduce(identidad, BinaryOperator<T>)
   - Combina los elementos en un único valor usando un acumulador.
   - Ej: .reduce(0, Integer::sum)

4. count()
   - Cuenta el número de elementos (devuelve long).
   - Ej: long total = stream.count();

5. min(Comparator<T>) / max(Comparator<T>)
   - Devuelve el elemento mínimo/máximo según un Comparator.

6. anyMatch(Predicate) / allMatch(Predicate) / noneMatch(Predicate)
   - Evalúa si alguno/todos/ninguno cumplen la condición.

// --- java-t7-v2-006 ---
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploStreams1 {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Ana", "Carlos", "Antonio", "David", "Eva");

        List<String> nombresFiltrados = nombres.stream()
                .filter(nombre -> nombre.length() > 3)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(nombresFiltrados);
        // [ANTONIO, CARLOS, DAVID]
        // "Ana"(3) y "Eva"(3) se eliminan en el filter
    }
}
```

También se puede usar .forEach(System.out::println) en vez de collect para imprimir directamente.

Si se cambia sorted() por sorted(String.CASE_INSENSITIVE_ORDER), se ordena sin distinguir mayúsculas.

// --- java-t7-v2-007 ---
reduce(identidad, BinaryOperator<T>) combina todos los elementos del Stream en un único valor.

Ejemplo: suma de los cuadrados de los números pares
```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4);

int sumaCuadradosPares = numeros.stream()
        .filter(n -> n % 2 == 0)    // Stream: [2, 4]
        .map(n -> n * n)            // Stream: [4, 16]
        .reduce(0, Integer::sum);   // 0 + 4 + 16 = 20

System.out.println(sumaCuadradosPares); // 20
```

¿Cómo funciona reduce(0, Integer::sum)?
1. acumulado = 0 (identidad)
2. acumulado = 0 + 4 = 4
3. acumulado = 4 + 16 = 20

Reduce también se puede usar con lambda:
.reduce(0, (acumulado, n) -> acumulado + n * 2)

El acumulador debe ser compatible con el tipo de dato del Stream.

// --- java-t7-v2-008 ---
FILTER: evalúa TODOS los elementos del Stream y se queda con los que cumplen la condición.

takeWhile: toma elementos MIENTRAS se cumpla la condición. En cuanto un elemento NO la cumple, PARA y no sigue evaluando el resto.

EJEMPLO con lista [1, 40] (ordenada):
```java
// filter: se queda con TODOS los < 20
List<Integer> filtrados = lista.stream()
    .filter(n -> n < 20)
    .toList();  // [1, 2, 3, ..., 19]

// takeWhile: se queda con los < 20 PERO para al encontrar el 20
List<Integer> tomados = lista.stream()
    .takeWhile(n -> n < 20)
    .toList();  // [1, 2, 3, ..., 19]

// dropWhile: ELIMINA mientras < 20, luego conserva el resto
List<Integer> restantes = lista.stream()
    .dropWhile(n -> n < 20)
    .toList();  // [20, 21, ..., 40]
```

Diferencia clave: filter recorre TODO. takeWhile/dropWhile paran cuando la condición cambia (como un while).

IMPORTANTE: takeWhile y dropWhile tienen sentido con datos ORDENADOS.

// --- java-t7-v2-009 ---
flatMap aplana un Stream de colecciones en un Stream de elementos individuales.

Útil cuando tenemos colecciones dentro de colecciones.

```java
List<Integer> lista1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
List<Integer> lista2 = List.of(11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
List<List<Integer>> listaFinal = List.of(lista1, lista2);

// SIN flatMap: Stream de 2 listas
// CON flatMap: Stream de 20 enteros
List<Integer> plana = listaFinal.stream()
    .flatMap(Collection::stream)  // aplana: 1,2,3...20
    .filter(n -> n % 10 == 0)     // 10, 20
    .map(n -> n / 10)             // 1, 2
    .toList();                    // [1, 2]
```

Proceso:
- listaFinal = [[1..10], [11..20]] (2 listas)
- flatMap: [1,2,3...20] (20 enteros)
- filter: [10, 20]
- map: [1, 2]
- toList: [1, 2]

// --- java-t7-v2-010 ---
```java
List<String> palabras = Arrays.asList("a", "ab", "abc", "abcd");

String frase = palabras.stream()
        .filter(p -> p.length() > 1)    // ["ab", "abc", "abcd"]
        .map(p -> p + "_")            // ["ab_", "abc_", "abcd_"]
        .reduce("Frase: ", String::concat);  // "Frase: ab_abc_abcd_"

System.out.println(frase);
```

Cómo funciona reduce con String::concat:
1. acumulado = "Frase: " (identidad)
2. acumulado = "Frase: " + "ab_" = "Frase: ab_"
3. acumulado = "Frase: ab_" + "abc_" = "Frase: ab_abc_"
4. acumulado = "Frase: ab_abc_" + "abcd_" = "Frase: ab_abc_abcd_"

Si cambiamos filter(p -> p.length() > 2):
- Se queda solo con ["abc", "abcd"]
- Resultado: "Frase: abc_abcd_"

// Error parseando cards_java_youtube_t7_v3.json: Se ha pasado un objeto no válido. Se esperaba ':' o '}'. (2026): {
  "id": "programacion-java-youtube-t7-v3",
  "name": "Java YouTube - Tema 7: Ejemplos Programación Funcional",
  "description": "Cards del curso JAVA desde 0 - flatMap, takeWhile, dropWhile, peek, reduce con lambda, lista de listas",
  "subject": "Programación - Java",
  "cards": [
    {
      "id": "java-t7-v3-001",
      "front": "¿Qué hace flatMap() en la API Stream de Java?",
      "back": "flatMap aplana un Stream de colecciones en un Stream de elementos individuales.

Ej: List<List<Integer>> listaFinal.stream().flatMap(Collection::stream)

Sin flatMap -> Stream de 4 listas.
Con flatMap -> Stream de 40 enteros individuales.

Util para extraer elementos de colecciones anidadas.",
      "tags": ["java", "stream", "flatmap", "aplanar", "tema-7"],
      "difficulty": "medium"
    },
    {
      "id": "java-t7-v3-002",
      "front": "Diferencia entre filter() y takeWhile() en Stream.",
      "back": "FILTER: evalua TODOS los elementos del Stream.
TAKEWHILE: toma elementos MIENTRAS se cumpla la condicion. Al encontrar uno que NO cumple, PARA y no sigue.

Ej: [2,4,6,8,11,12]
- filter(par) -> [2,4,6,8,12]
- takeWhile(par) -> [2,4,6,8] (para al llegar al 11)",
      "tags": ["java", "stream", "filter", "takewhile", "diferencia", "tema-7"],
      "difficulty": "medium"
    },
    {
      "id": "java-t7-v3-003",
      "front": "¿Qué hace dropWhile() en Stream?",
      "back": "ELIMINA elementos del Stream MIENTRAS se cumpla la condicion. Al encontrar uno que NO cumple, conserva el RESTO.

.dropWhile(n -> n < 20) en [1..40] -> [20..40]

Si el primer elemento no cumple la condicion, NO elimina nada.

[2,4,6,8,10,11,12..] .dropWhile(par) -> [11,12..]",
      "tags": ["java", "stream", "dropwhile", "eliminar", "tema-7"],
      "difficulty": "medium"
    },
    {
      "id": "java-t7-v3-004",
      "front": "¿Qué es peek() en Stream y para qué sirve?",
      "back": "Operacion INTERMEDIA de DEPURACION. Permite ver el estado del Stream en un punto sin modificarlo.

.peek(n -> System.out.print(n + " "))

Se usa para DEBUG, para ver como se transforman los datos paso a paso.
NO debe usarse para modificar datos (solo observacion).",
      "tags": ["java", "stream", "peek", "depuracion", "debug", "tema-7"],
      "difficulty": "medium"
    },
    {
      "id": "java-t7-v3-005",
      "front": "¿Cómo se usa reduce() con una expresion lambda personalizada?",
      "back": "reduce(identidad, (acumulado, elemento) -> expresion)

int total = List.of(1,2,3,4).stream()
    .reduce(0, (acum, n) -> acum + n * 2);

Iteraciones:
1: acum=0, n=1 -> 0+2=2
2: acum=2, n=2 -> 2+4=6
3: acum=6, n=3 -> 6+6=12
4: acum=12, n=4 -> 12+8=20

Resultado: 20

Con Integer::sum (solo suma): .reduce(0, Integer::sum) = 10",
      "tags": ["java", "stream", "reduce", "lambda", "acumulador", "tema-7"],
      "difficulty": "medium"
    },
    {
      "id": "java-t7-v3-006",
      "front": "Implementa Stream: aplane 4 listas, filtre multiplos de 10, divida entre 10 y recolecte.",
      "back": "List<Integer> l1=List.of(1,2,3,4,5,6,7,8,9,10);
List<Integer> l2=List.of(11,12,13,14,15,16,17,18,19,20);
List<Integer> l3=List.of(21,22,23,24,25,26,27,28,29,30);
List<Integer> l4=List.of(31,32,33,34,35,36,37,38,39,40);

List<List<Integer>> lf = List.of(l1,l2,l3,l4);

List<Integer> r = lf.stream()
    .flatMap(Collection::stream)  // [1..40]
    .filter(n -> n % 10 == 0)     // [10,20,30,40]
    .map(n -> n / 10)             // [1,2,3,4]
    .collect(Collectors.toList());// [1,2,3,4]",
      "tags": ["java", "stream", "flatmap", "filter", "map", "collect", "codigo", "tema-7"],
      "difficulty": "hard"
    }
  ]
}

// Error parseando cards_java_youtube_t7_v4.json: Se ha pasado un objeto no válido. Se esperaba ':' o '}'. (488): {
  "id": "programacion-java-youtube-t7-v4",
  "name": "Java YouTube - Tema 7: Ejemplos API Stream",
  "description": "Cards del curso JAVA desde 0 - palabras unicas, orden alfabetico, CASE_INSENSITIVE_ORDER, orden por longitud, comparator, contar letras, constructor reference, Trabajador",
  "subject": "Programación - Java",
  "cards": [
    {
      "id": "java-t7-v4-001",
      "front": "¿Cómo se cuentan palabras unicas en un String usando Stream?",
      "back": "String texto = "Ejemplo ejemplo texto texto texto";

Set<String> unicas = Arrays.stream(texto.split("\\s+"))
    .map(String::toLowerCase)          // todas a minusculas
    .collect(Collectors.toSet());      // Set -> sin duplicados

int cantidad = unicas.size();  // 2 (ejemplo, texto)

Pasos:
1. split("\\s+") -> separa por espacios (1 o mas)
2. stream() -> convierte array a Stream
3. map(String::toLowerCase) -> normaliza mayus/minus
4. collect(Collectors.toSet()) -> elimina duplicados (Set)
5. size() -> cuenta elementos unicos",
      "tags": ["java", "stream", "palabras-unicas", "set", "split", "tema-7"],
      "difficulty": "medium"
    },
    {
      "id": "java-t7-v4-002",
      "front": "¿Cómo ordenar palabras alfabeticamente con sorted(), ignorando mayusculas?",
      "back": "String texto = "Ejemplo de ordenamiento alfabetico";

Arrays.stream(texto.split("\\s+"))
    .sorted(String.CASE_INSENSITIVE_ORDER)  // ignora mayus/minus
    .forEach(System.out::println);

Resultado: alfabetico, de, Ejemplo, ordenamiento

String.CASE_INSENSITIVE_ORDER es un Comparator
que ordena ignorando mayusculas/minusculas.

Sin CASE_INSENSITIVE_ORDER (solo sorted()):
- Las MAYUSCULAS van primero (orden ASCII)
- Ejemplo -> alfabetico -> de -> Java -> ordenamiento...",
      "tags": ["java", "stream", "sorted", "case-insensitive", "orden", "tema-7"],
      "difficulty": "medium"
    },
    {
      "id": "java-t7-v4-003",
      "front": "¿Cómo ordenar palabras por longitud de mayor a menor con Stream?",
      "back": "String texto = "Voy a aprobar programacion con buena nota";

List<String> resultado = Arrays.stream(texto.split("\\s+"))
    .distinct()                                    // elimina duplicados
    .sorted(Comparator.comparingInt(String::length) // ordena por length
        .reversed())                                // de mayor a menor
    .toList();

Resultado: [programacion, aprobar, buena, nota, Voy, con, a]

Comparator.comparingInt(String::length):
  crea un comparator basado en la longitud de las palabras
.reversed(): invierte el orden (de mayor a menor)
.distinct(): elimina palabras duplicadas antes de ordenar",
      "tags": ["java", "stream", "sorted", "comparator", "longitud", "reversed", "tema-7"],
      "difficulty": "hard"
    },
    {
      "id": "java-t7-v4-004",
      "front": "¿Cómo crear un Comparator personalizado para contar letras especificas en Stream?",
      "back": "// Ordenar palabras segun la cantidad de 'a' que contienen
Comparator<String> comparador = (p1, p2) -> {
    int a1 = (int) p1.chars().filter(c -> c == 'a' || c == 'A').count();
    int a2 = (int) p2.chars().filter(c -> c == 'a' || c == 'A').count();
    return Integer.compare(a1, a2);  // de menos 'a' a mas 'a'
};

String texto = "Ordenar palabras segun la cantidad de veces que aparece la letra a";

List<String> palabras = Arrays.stream(texto.split("\\s+"))
    .sorted(comparador)
    .collect(Collectors.toList());

Uso de chars():
- palabra.chars() convierte String a IntStream de caracteres
- .filter(c -> c == 'a') filtra solo las 'a'
- .count() cuenta cuantas hay (devuelve long, se castea a int)",
      "tags": ["java", "stream", "comparator", "chars", "count", "letras", "tema-7"],
      "difficulty": "hard"
    },
    {
      "id": "java-t7-v4-005",
      "front": "¿Cómo filtrar palabras que contengan una letra especifica en Stream?",
      "back": "// Solo palabras que tengan la letra 'a'
List<String> resultado = Arrays.stream(texto.split("\\s+"))
    .map(String::toLowerCase)           // normalizar a minusculas
    .filter(palabra -> palabra.contains("a"))  // solo las que tienen 'a'
    .sorted(comparador)                  // ordenar por cantidad de 'a'
    .collect(Collectors.toList());

Se usa map(String::toLowerCase) antes del filter
para que contains("a") encuentre tanto 'a' como 'A'.

Sin el map(), palabras como "Java" no pasarian
el filter porque contains("a") busca 'a' minuscula.",
      "tags": ["java", "stream", "filter", "contains", "letras", "tema-7"],
      "difficulty": "medium"
    },
    {
      "id": "java-t7-v4-006",
      "front": "¿Cómo usar un method reference a constructor (ClassName::new) en Stream?",
      "back": "// Clase Trabajador con constructor que recibe String
class Trabajador {
    String nombre;
    Trabajador(String nombre) { this.nombre = nombre; }
    public String toString() { return "[nombre=" + nombre + "]"; }
}

// Convertir List<String> a List<Trabajador> con constructor ref
List<String> nombres = Arrays.asList("Tom", "Jon", "Kal", "Ana");

Function<String, Trabajador> refConstructor = Trabajador::new;

List<Trabajador> trabajadores = nombres.stream()
    .map(refConstructor)               // String -> Trabajador
    .collect(Collectors.toList());

System.out.println(trabajadores);
// [[nombre=Tom], [nombre=Jon], [nombre=Kal], [nombre=Ana]]

Trabajador::new es un method reference al constructor.
Java busca un constructor que reciba String (coincidencia de tipos).
Si la lista fuera de Integer, buscaria un constructor que reciba int.",
      "tags": ["java", "stream", "constructor", "method-reference", "trabajador", "map", "tema-7"],
      "difficulty": "hard"
    }
  ]
}

// Error parseando cards_java_youtube_t7_v5.json: Se ha pasado un objeto no válido. Se esperaba ':' o '}'. (1655): {
  "id": "programacion-java-youtube-t7-v5",
  "name": "Java YouTube - Tema 7: Programación Funcional Avanzada",
  "description": "Cards del curso JAVA desde 0 - parallelStream, rendimiento, collect groupingBy, toMap, LinkedHashMap, orden por frecuencia de palabras",
  "subject": "Programación - Java",
  "cards": [
    {
      "id": "java-t7-v5-001",
      "front": "¿Qué es parallelStream() y cómo mejora el rendimiento?",
      "back": "parallelStream() divide automaticamente el trabajo en VARIOS subprocesos, aprovechando los multiples procesadores.

Solo hay que cambiar:
  coleccion.stream()     -> secuencial
  coleccion.parallelStream() -> paralelo

Ejemplo:
int[] nums = generarArray(10_000_000);
Instant inicio = Instant.now();
lista.parallelStream().sorted().toArray();
Instant fin = Instant.now();

long ms = Duration.between(inicio, fin).toMillis();

Rendimiento (10 millones de elementos):
- Secuencial: ~5.7 segundos
- Paralelo:   ~1 segundo

Rendimiento (100 millones):
- Secuencial: ~77 segundos
- Paralelo:   ~7 segundos

NO usar parallelStream para tareas simples o pocos datos.",
      "tags": ["java", "stream", "parallelstream", "rendimiento", "multihilo", "tema-7"],
      "difficulty": "hard"
    },
    {
      "id": "java-t7-v5-002",
      "front": "¿Qué es Collectors.groupingBy() y cómo funciona?",
      "back": "Collectors.groupingBy() agrupa elementos de un Stream en un Map.
Similar a GROUP BY de SQL.

Sintaxis basica:
Map<K, List<T>> resultado = stream
    .collect(Collectors.groupingBy(funcionClasificacion));

Ejemplo - agrupar palabras por si mismas y contar:
Map<String, Long> conteo = Arrays.stream(texto.split("\\s+"))
    .collect(Collectors.groupingBy(
        Function.identity(),     // clave: la palabra misma
        Collectors.counting()    // valor: cantidad de apariciones
    ));

Function.identity() devuelve el elemento sin modificarlo.
Collectors.counting() cuenta cuantos elementos hay en cada grupo.

Resultado: {palabra=3, ejemplo=2, esto=1, es=1, un=1}",
      "tags": ["java", "stream", "collectors", "groupingby", "agrupar", "tema-7"],
      "difficulty": "hard"
    },
    {
      "id": "java-t7-v5-003",
      "front": "¿Qué es Collectors.toMap() y cuales son sus parámetros?",
      "back": "Collectors.toMap() recolecta elementos de un Stream en un Map.

Sintaxis completa (4 parametros):
Collectors.toMap(
    keyMapper,      // funcion para generar la clave
    valueMapper,    // funcion para generar el valor
    mergeFunction,  // funcion de combinacion si hay claves duplicadas
    mapFactory      // constructor del Map (tipo concreto)
);

Ejemplo con 2 parametros:
Map<String, Integer> m = stream
    .collect(Collectors.toMap(
        e -> e.getKey(),    // clave: el key del entry
        e -> e.getValue()   // valor: el value del entry
    ));

Ejemplo con 4 parametros:
.collect(Collectors.toMap(
    Map.Entry::getKey,
    Map.Entry::getValue,
    (e1, e2) -> e1,          // si hay conflicto, usar el primero
    LinkedHashMap::new        // usar LinkedHashMap (mantiene orden)
));",
      "tags": ["java", "stream", "collectors", "tomap", "map", "linkedhashmap", "tema-7"],
      "difficulty": "hard"
    },
    {
      "id": "java-t7-v5-004",
      "front": "¿Cómo ordenar palabras por frecuencia de mayor a menor usando Stream?",
      "back": "String texto = "Esto es un ejemplo ejemplo palabra palabra palabra";

Map<String, Long> palabrasOrden = Arrays.stream(texto.split("\\s+"))
    .collect(Collectors.groupingBy(      // agrupar palabras iguales
        Function.identity(),              // clave: la palabra
        Collectors.counting()))           // valor: frecuencia
    .entrySet().stream()                  // convertir a Stream de entradas
    .sorted(Map.Entry.<String, Long>      // ordenar por valor (frecuencia)
        comparingByValue(Comparator.reverseOrder()))  // de mayor a menor
    .collect(Collectors.toMap(
        Map.Entry::getKey,                // clave: la palabra
        Map.Entry::getValue,              // valor: la frecuencia
        (e1, e2) -> e1,                   // combinacion (no necesaria)
        LinkedHashMap::new));             // LinkedHashMap (mantiene orden)

System.out.println(palabrasOrden);
// {palabra=3, ejemplo=2, un=1, es=1, Esto=1}

LinkedHashMap mantiene el orden de insercion,
por lo que las palabras quedan ordenadas por frecuencia.",
      "tags": ["java", "stream", "frecuencia", "groupingby", "sorted", "tomap", "linkedhashmap", "tema-7"],
      "difficulty": "hard"
    },
    {
      "id": "java-t7-v5-005",
      "front": "¿Qué es Function.identity() y para qué se usa en Stream?",
      "back": "Function.identity() es una funcion que devuelve el elemento SIN modificarlo.

Equivale a: x -> x (lambda identidad)

Se usa cuando NO queremos transformar el elemento,
sino mantenerlo tal cual.

Ejemplo tipico con groupingBy:
Map<String, Long> conteo = stream
    .collect(Collectors.groupingBy(
        Function.identity(),  // la palabra sin cambios
        Collectors.counting()
    ));

Tambien se puede escribir como:
    .collect(Collectors.groupingBy(
        palabra -> palabra,   // lambda identidad
        Collectors.counting()
    ));

Sin identity agruparia aplicando alguna transformacion.
Con identity agrupa por el valor exacto del elemento.",
      "tags": ["java", "stream", "function-identity", "lambda", "groupingby", "tema-7"],
      "difficulty": "medium"
    },
    {
      "id": "java-t7-v5-006",
      "front": "¿Qué es LinkedHashMap y por qué se usa con toMap()?",
      "back": "LinkedHashMap es una implementacion de Map que MANTIENE el ORDEN DE INSERCION de los elementos.

HashMap no garantiza ningun orden.
TreeMap ordena por clave (orden natural o Comparator).
LinkedHashMap ordena por insercion (el orden en que se añadieron).

Ejemplo:
.collect(Collectors.toMap(
    Map.Entry::getKey,
    Map.Entry::getValue,
    (e1, e2) -> e1,
    LinkedHashMap::new    // <-- mantiene el orden de insercion
));

Es util cuando:
- Ordenamos un Stream y queremos conservar ese orden en el Map
- Queremos un Map predecible que recuerde el orden original

Sin LinkedHashMap, el HashMap reordenaria los elementos
perdiendo la ordenacion que hicimos con sorted().",
      "tags": ["java", "linkedhashmap", "tomap", "orden", "map", "tema-7"],
      "difficulty": "medium"
    }
  ]
}

// Error parseando cards_java_youtube_t7_v6.json: Se ha pasado un objeto no válido. Se esperaba ':' o '}'. (3672): {
  "id": "programacion-java-youtube-t7-v6",
  "name": "Java YouTube - Tema 7: Ejercicios Colecciones",
  "description": "Cards del curso JAVA desde 0 - Practica 1: equipo futbol, Futbolista, Deportista, Equipo, enum Posicion, comparator, iterator. Practica 2: AnalizadorTextos, HashMap, split, frecuencia palabras, palabras por longitud",
  "subject": "Programación - Java",
  "cards": [
    {
      "id": "java-t7-v6-001",
      "front": "¿Como modelar un sistema de equipo de futbol con enum Posicion, interfaz Deportista, clase Futbolista y clase Equipo?",
      "back": "ESTRUCTURA:

1. ENUM Posicion: PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO
   - Cada uno con nombre, salarioMin, salarioMax

2. INTERFAZ Deportista:
   - int getAnosProfesional()
   - List<String> getListadoEquipos()
   - int getTotalTrofeos()

3. CLASE Futbolista implements Deportista:
   - nombre, edad, posicion (Posicion), anosProfesional, equipos (List<String>), trofeos
   - agregarEquipo(String equipo)
   - toString() muestra nombre, edad, posicion
   - getListadoEquipos() devuelve COPIA del ArrayList (encapsulacion)

4. CLASE Equipo:
   - nombre, List<Futbolista> futbolistas
   - Map estatico MAX_FUTBOLISTAS_POSICION con maximos por posicion
   - agregarFutbolista(): lanza excepcion si posicion llena
   - listarFormacionEquipo(): ordena por posicion, recorre con Iterator",
      "tags": ["java", "poo", "futbol", "equipo", "enum", "interfaz", "tema-7"],
      "difficulty": "hard"
    },
    {
      "id": "java-t7-v6-002",
      "front": "¿Como controlar que no se exceda el maximo de jugadores por posicion en un equipo?",
      "back": "Se usa un Map estatico con los maximos:
private static final Map<Posicion, Integer> MAX = new HashMap<>();
static {
    MAX.put(Posicion.PORTERO, 2);
    MAX.put(Posicion.DEFENSA, 5);
    MAX.put(Posicion.CENTROCAMPISTA, 5);
    MAX.put(Posicion.DELANTERO, 4);
}

Metodo auxiliar:
private int obtenerJugadoresPosicion(Posicion p) {
    int cont = 0;
    for (Futbolista f : futbolistas)
        if (f.getPosicion() == p) cont++;
    return cont;
}

En agregarFutbolista():
int actuales = obtenerJugadoresPosicion(f.getPosicion());
int maximo = MAX.get(f.getPosicion());
if (actuales >= maximo) {
    throw new RegistroFutbolistaException(f);
}
futbolistas.add(f);

Si se intenta anadir un portero teniendo ya 2, se lanza la excepcion.",
      "tags": ["java", "equipo", "maximo", "control", "excepcion", "map", "tema-7"],
      "difficulty": "hard"
    },
    {
      "id": "java-t7-v6-003",
      "front": "¿Como ordenar futbolistas por posicion (portero->defensa->centro->delantero) usando Comparator?",
      "back": "Se crea un metodo auxiliar que asigna prioridad numerica a cada posicion:

private int prioridadPosicion(Posicion p) {
    return switch(p) {
        case PORTERO -> 1;
        case DEFENSA -> 2;
        case CENTROCAMPISTA -> 3;
        case DELANTERO -> 4;
    };
}

Luego se usa sort con Comparator:
futbolistas.sort((f1, f2) -> Integer.compare(
    prioridadPosicion(f1.getPosicion()),
    prioridadPosicion(f2.getPosicion())));

Integer.compare(a, b):
- Si a < b -> negativo -> f1 va antes
- Si a > b -> positivo -> f2 va antes
- Si a == b -> 0 -> iguales

Resultado: porteros primero, luego defensas, centrocampistas, delanteros.",
      "tags": ["java", "comparator", "ordenar", "posicion", "enum", "sort", "tema-7"],
      "difficulty": "hard"
    },
    {
      "id": "java-t7-v6-004",
      "front": "¿Como recorrer una lista con Iterator en lugar de for-each?",
      "back": "Iterator<Futbolista> it = futbolistas.iterator();
while (it.hasNext()) {
    Futbolista f = it.next();
    System.out.println("  " + f);
}

Metodos de Iterator<E>:
- boolean hasNext(): true si quedan elementos
- E next(): devuelve el siguiente elemento
- void remove(): elimina el ultimo elemento devuelto (OPCIONAL)

Ventajas de Iterator sobre for-each:
- Permite modificar la lista durante el recorrido (remove)
- Unifica el recorrido de cualquier Collection

Desventajas:
- Mas verboso que for-each

Se pide explicitamente en el ejercicio usar Iterator.",
      "tags": ["java", "iterator", "recorrer", "lista", "foreach", "tema-7"],
      "difficulty": "medium"
    },
    {
      "id": "java-t7-v6-005",
      "front": "¿Como implementar un AnalizadorTextos que cuente frecuencia de palabras usando HashMap?",
      "back": "class AnalizadorTextos {
    private String texto;
    private HashMap<String, Integer> palabras = new HashMap<>();

    public AnalizadorTextos(String texto) {
        this.texto = texto.toLowerCase();
        contarPalabras();
    }

    private void contarPalabras() {
        String[] arr = texto.split("\\W+");  // separa por NO letras/numeros
        for (String str : arr) {
            if (!str.isEmpty())
                palabras.put(str, palabras.getOrDefault(str, 0) + 1);
        }
    }
}

Claves del algoritmo:
1. split("\\W+"): separa por cualquier caracter que NO sea letra, numero o _
   (W mayuscula = cualquier caracter NO de palabra)
2. toLowerCase(): no distingue mayusculas/minusculas
3. getOrDefault(key, 0): si la clave no existe, devuelve 0; si existe, su valor
4. put(key, valor+1): incrementa la frecuencia",
      "tags": ["java", "hashmap", "analizador", "frecuencia", "split", "getordefault", "tema-7"],
      "difficulty": "hard"
    },
    {
      "id": "java-t7-v6-006",
      "front": "¿Como obtener las N palabras mas/menos frecuentes de un HashMap?",
      "back": "public List<Map.Entry<String, Integer>> palabrasMasFrecuentes(int n) {
    // Convertir entrySet a List para ordenar
    List<Map.Entry<String, Integer>> lista = new ArrayList<>(palabras.entrySet());
    // Ordenar por valor (frecuencia) descendente
    lista.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    // Devolver sublista con las n primeras
    return lista.subList(0, Math.min(n, lista.size()));
}

public List<Map.Entry<String, Integer>> palabrasMenosFrecuentes(int n) {
    List<Map.Entry<String, Integer>> lista = new ArrayList<>(palabras.entrySet());
    lista.sort(Map.Entry.comparingByValue());  // ascendente (menos frecuentes primero)
    return lista.subList(0, Math.min(n, lista.size()));
}

Detalles:
- entrySet() devuelve Set<Map.Entry<K,V>>
- new ArrayList<>(collection): crea lista mutable para ordenar
- comparingByValue(): orden natural del valor (Integer)
- reverseOrder(): invierte el orden (mayor a menor)
- subList(0, min(n, size)): evita IndexOutOfBounds si hay menos de n palabras
- Math.min(n, lista.size()): se queda con el menor valor",
      "tags": ["java", "hashmap", "frecuencia", "sort", "entryset", "subList", "tema-7"],
      "difficulty": "hard"
    },
    {
      "id": "java-t7-v6-007",
      "front": "¿Como agrupar palabras por longitud usando HashMap<Integer, List<String>>?",
      "back": "public HashMap<Integer, List<String>> palabrasPorLongitud() {
    HashMap<Integer, List<String>> resultado = new HashMap<>();

    for (String palabra : palabras.keySet()) {
        int longitud = palabra.length();

        // Si no existe la clave, crea una lista vacia y la añade
        resultado.computeIfAbsent(longitud, k -> new ArrayList<>()).add(palabra);
    }

    // Ordenar alfabeticamente cada lista
    for (List<String> lista : resultado.values()) {
        Collections.sort(lista);
    }

    return resultado;
}

Alternativa sin computeIfAbsent:
if (!resultado.containsKey(longitud)) {
    resultado.put(longitud, new ArrayList<>());
}
resultado.get(longitud).add(palabra);

Resultado: {3=[con, de], 4=[esto, un], 5=[texto], 8=[ejemplo]}

Se usa HashMap para que clave=longitud, valor=lista de palabras con esa longitud.
Collections.sort() ordena cada lista alfabeticamente.",
      "tags": ["java", "hashmap", "agrupar", "longitud", "computeifabsent", "sort", "tema-7"],
      "difficulty": "hard"
    },
    {
      "id": "java-t7-v6-008",
      "front": "¿Que diferencia hay entre split("\\s+") y split("\\W+") en Java?",
      "back": "split("\\s+"):
- Separa por ESPACIOS EN BLANCO (espacio, tab, salto de linea)
- \\s = cualquier whitespace
- + = uno o mas
- Ej: "Hola mundo" -> ["Hola", "mundo"]
- No separa por signos de puntuacion

split("\\W+"):
- Sepa por cualquier caracter que NO sea letra, numero o _
- \\W = cualquier caracter NO de palabra (W mayuscula = negacion de \\w)
- \\w = [a-zA-Z0-9_] (letras, numeros, guion bajo)
- Ej: "Hola, mundo!" -> ["Hola", "mundo"]
- Separa por espacios, comas, puntos, signos, etc.

split("\\W+") es mejor para analisis de textos porque
separa automaticamente por cualquier signo de puntuacion.",
      "tags": ["java", "split", "regex", "strings", "whitespace", "tema-7"],
      "difficulty": "medium"
    }
  ]
}

