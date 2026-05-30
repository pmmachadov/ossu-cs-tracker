"""
Generate curated preguntas directas for ED and SI.
Adds high-quality exam-style cards for missing topics.
"""

import json
import re

def load_json(path):
    with open(path, encoding='utf-8') as f:
        return json.load(f)

def save_json(path, data):
    with open(path, 'w', encoding='utf-8') as f:
        json.dump(data, f, ensure_ascii=False, indent=2)

# Load current pd-all
pd_all = load_json('public/data/preguntas-directas/pd-all.json')
existing_ids = {c['id'] for c in pd_all['cards']}

def next_id(prefix, subject):
    """Get next available ID"""
    existing = [c for c in pd_all['cards'] if c['id'].startswith(f'{prefix}-{subject}-')]
    nums = [int(c['id'].split('-')[-1]) for c in existing if c['id'].split('-')[-1].isdigit()]
    max_num = max(nums) if nums else 0
    return f'{prefix}-{subject}-{max_num + 1:03d}'

def add_card(front, back, tags, difficulty='medium'):
    """Add a new card to pd_all"""
    subject = 'ed' if front.startswith('(ED') else 'si'
    cid = next_id('pd', subject)
    card = {
        "id": cid,
        "front": front,
        "back": back,
        "tags": sorted(set(tags)),
        "difficulty": difficulty
    }
    pd_all['cards'].append(card)
    return cid

# =============================================
# ED - Missing Topics
# =============================================

ed_new = []

# 1. IDE Concepts
ed_new.append({
    "front": """(ED — EAC1 / IDE) ¿Qué es un IDE? Enumera 5 características principales que debe tener. ¿Qué diferencia hay entre un IDE y un editor de texto como Notepad++?

1. ¿Cuál es la diferencia fundamental?
2. Pon 3 ejemplos de IDEs""",
    
    "back": """IDE (Integrated Development Environment) = Entorno Integrado de Desarrollo.

Características principales:
● Editor de código con resaltado de sintaxis
● Compilador/Intérprete integrado
● Depurador (debugger)
● Autocompletado y sugerencias
● Gestión de proyectos y archivos

Diferencia con editor de texto:
● Editor: solo escribe texto plano, sin herramientas integradas
● IDE: todo en uno - edita, compila, depura, ejecuta

Ejemplos: Eclipse, IntelliJ IDEA, NetBeans, VS Code""",
    "tags": ['ed', 'eac1', 'ide', 'definicion', 'herramientas']
})

# 2. Software lifecycle - Waterfall vs Agile
ed_new.append({
    "front": """(ED — EAC1 / Ciclo de vida) Describe el modelo en cascada (Waterfall) vs metodologías ágiles (Scrum).

1. ¿Cuáles son las fases del modelo en cascada?
2. ¿En qué se diferencia Scrum del modelo cascada?
3. ¿Qué es un sprint en Scrum?""",
    
    "back": """Modelo en cascada (Waterfall):
1. Análisis de requisitos
2. Diseño del sistema
3. Implementación
4. Pruebas
5. Despliegue
6. Mantenimiento

● Secuencial: cada fase termina antes de empezar la siguiente
● Rígido: difícil volver atrás
● Bueno para proyectos con requisitos claros

Metodologías ágiles (Scrum):
● Iterativo: ciclos cortos (sprints de 2-4 semanas)
● Flexible: se adapta a cambios
● Entrega continua de valor
● Sprint: ciclo de trabajo con un objetivo entregable al final
● Roles: Product Owner, Scrum Master, Development Team""",
    "tags": ['ed', 'eac1', 'ciclo-vida', 'metodologia', 'agil']
})

# 3. POO - Encapsulation, Inheritance, Polymorphism
ed_new.append({
    "front": """(ED — EAC2 / POO) Explica los 3 pilares de la Programación Orientada a Objetos.

1. Encapsulación: ¿qué es y cómo se implementa en Java?
2. Herencia: ¿qué es y cómo se usa 'extends'?
3. Polimorfismo: ¿qué es y cómo se consigue?

Pon un ejemplo breve de cada uno.""",
    
    "back": """1. ENCAPSULACIÓN:
Ocultar los detalles internos de una clase.
● Atributos private
● Acceso mediante getters/setters public
● Protege la integridad de los datos

Ejemplo:
```java
public class Persona {
    private String nombre;
    
    public String getNombre() { return nombre; }
    public void setNombre(String n) { this.nombre = n; }
}
```

2. HERENCIA:
Una clase hija hereda atributos y métodos de la clase padre.
● extends para heredar
● super() para llamar al constructor padre
● Reutilización de código

Ejemplo:
```java
public class Animal { void comer() {...} }
public class Perro extends Animal { void ladrar() {...} }
```

3. POLIMORFISMO:
Un objeto puede comportarse de múltiples formas.
● Mismo método, diferente implementación
● @Override para sobrescribir métodos

Ejemplo:
```java
Animal a = new Perro();
a.comer(); // Llama al método de Perro (si está override)
```""",
    "tags": ['ed', 'eac2', 'poo', 'encapsulacion', 'herencia', 'polimorfismo']
})

# 4. Compilation process - JVM, bytecode
ed_new.append({
    "front": """(ED — EAC1 / Compilación) Explica el proceso de compilación en Java.

1. ¿Qué es el código fuente, bytecode y código máquina?
2. ¿Qué hace el compilador de Java (javac)?
3. ¿Qué es la JVM y por qué Java es "portable"?
4. ¿Qué diferencia hay entre compilador e intérprete?""",
    
    "back": """Proceso de compilación Java:

Código fuente (.java)
    → javac (compilador)
Bytecode (.class)
    → JVM (intérprete)
Código máquina

1. Definiciones:
● Código fuente: escrito por el programador (.java)
● Bytecode: código intermedio (.class), independiente de la plataforma
● Código máquina: ejecutable por el procesador (0s y 1s)

2. javac: traduce .java a .class (bytecode).

3. JVM (Java Virtual Machine):
● Interpreta el bytecode y lo ejecuta
● Cada SO tiene su propia JVM
● "Write once, run anywhere": el mismo .class funciona en cualquier SO

4. Compilador vs Intérprete:
● Compilador: traduce todo el código de golpe → más rápido
● Intérprete: traduce línea por línea → más lento pero portable""",
    "tags": ['ed', 'eac1', 'compilacion', 'jvm', 'bytecode']
})

# 5. Debugging
ed_new.append({
    "front": """(ED — EAC2 / Depuración) Estás en Eclipse con este código y hay un error:

```java
public class Calculo {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int resultado = a / b;
        System.out.println("Resultado: " + resultado);
    }
}
```

1. ¿Qué error da al ejecutar? ¿Por qué?
2. Explica cómo pondrías un breakpoint y usarías el debugger.
3. ¿Qué diferencias hay entre Step Into (F5) y Step Over (F6)?""",
    
    "back": """1. Error: ArithmeticException: / by zero
   No se puede dividir entre 0 en aritmética entera.

2. Para depurar:
   ● Doble clic en el margen izquierdo (línea 5) → breakpoint azul
   ● Botón derecho → Debug As → Java Application
   ● El programa se para en el breakpoint
   ● Inspeccionar variables con la vista Variables

3. Step Into (F5) vs Step Over (F6):
   ● Step Into: entra DENTRO del método llamado (ve el código interno)
   ● Step Over: ejecuta el método completo y pasa a la siguiente línea
   ● Step Return (F7): sale del método actual y vuelve al que lo llamó

Perspectiva Debug: permite ver variables, expresiones, breakpoints y pila de llamadas.""",
    "tags": ['ed', 'eac2', 'depuracion', 'debug', 'eclipse']
})

# 6. Version control - CVS/SVN vs Git concepts
ed_new.append({
    "front": """(ED — EAC2 / Control de versiones) Explica los conceptos básicos de control de versiones.

1. ¿Qué es un sistema de control de versiones (VCS)?
2. ¿Qué diferencia hay entre CVS, SVN (centralizado) y Git (distribuido)?
3. ¿Qué es un repositorio? ¿Y un commit?
4. ¿Qué ventaja tiene Git sobre SVN?""",
    
    "back": """1. VCS: sistema que registra los cambios en archivos a lo largo del tiempo,
   permitiendo volver a versiones anteriores.

2. CVS/SVN (centralizado):
   ● Un único repositorio central en un servidor
   ● Todos los desarrolladores trabajan contra él
   ● Si el servidor cae, no se puede trabajar

   Git (distribuido):
   ● Cada desarrollador tiene una copia COMPLETA del repositorio
   ● Se puede trabajar sin conexión
   ● Más rápido y flexible

3. Conceptos:
   ● Repositorio: almacén de archivos y su historial de cambios
   ● Commit: snapshot / punto de guardado con mensaje descriptivo
   ● Working copy: copia local de los archivos

4. Ventajas de Git:
   ● Trabajo offline
   ● Branching (ramas) más rápido y ligero
   ● Más seguro (cada clon es un backup completo)
   ● Más usado en la industria (GitHub, GitLab)""",
    "tags": ['ed', 'eac2', 'control-versiones', 'git', 'svn']
})

# 7. Documentation - Javadoc structure
ed_new.append({
    "front": """(ED — EAC3 / Javadoc) Escribe el Javadoc completo para esta clase:

```java
public class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }
    
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por 0");
        }
        return a / b;
    }
}
```

Incluye:
1. Comentario de clase (@author, @version)
2. Comentario de método (@param, @return, @throws)
3. ¿Qué comandos se usan para generar la documentación HTML?""",
    
    "back": """```java
/**
 * Clase Calculadora con operaciones básicas.
 * 
 * @author Pablo Machado
 * @version 1.0
 */
public class Calculadora {
    
    /**
     * Suma dos números enteros.
     * 
     * @param a primer sumando
     * @param b segundo sumando
     * @return la suma de a y b
     */
    public int sumar(int a, int b) {
        return a + b;
    }
    
    /**
     * Divide dos números enteros.
     * 
     * @param a dividendo
     * @param b divisor
     * @return el cociente de a entre b
     * @throws IllegalArgumentException si b es 0
     */
    public int dividir(int a, int b) {
        // ...
    }
}
```

Etiquetas Javadoc:
● @param: describe un parámetro
● @return: describe el valor de retorno
● @throws: describe una excepción
● @author: autor de la clase
● @version: versión de la clase
● @see: referencia a otro método/clase
● @deprecated: método obsoleto

Comando para generar HTML:
```bash
javadoc -d docs/ src/*.java
```""",
    "tags": ['ed', 'eac3', 'javadoc', 'documentacion']
})

# 8. Metodologías tradicionales vs ágiles (PMBOK)
ed_new.append({
    "front": """(ED — EAC2 / Metodologías) Compara metodologías tradicionales y ágiles.

1. ¿Qué es PMBOK? ¿Qué áreas de conocimiento cubre?
2. ¿Qué son las metodologías ágiles? Menciona 2 ejemplos.
3. ¿Cuándo usar cada una? Pon un ejemplo de proyecto para cada caso.""",
    
    "back": """PMBOK (Project Management Body of Knowledge):
Guía de buenas prácticas para gestión de proyectos tradicional.
Áreas: alcance, tiempo, coste, calidad, recursos, comunicación,
riesgos, adquisiciones, interesados.

Metodologías ágiles:
● Scrum: sprints, daily standup, retrospectivas
● Kanban: tablero visual, límite de WIP, flujo continuo
● Extreme Programming (XP): TDD, pair programming, integración continua

Cuándo usar cada una:

Tradicional (Waterfall/PMBOK):
● Requisitos claros y estables
● Proyectos grandes y predecibles
● Ej: construir un puente, un sistema de nóminas

Ágil (Scrum/Kanban):
● Requisitos cambiantes o poco definidos
● Proyectos con incertidumbre
● Ej: desarrollar una app web, un startup""",
    "tags": ['ed', 'eac2', 'pmbok', 'metodologia', 'agil']
})

# 9. Eclipse - perspectives, views, shortcuts
ed_new.append({
    "front": """(ED — EAC2 / Eclipse) Explica la interfaz de Eclipse.

1. ¿Qué es una perspectiva (perspective)? Menciona 3 ejemplos.
2. ¿Qué es una vista (view)? Menciona 4 ejemplos importantes.
3. Escribe 5 atajos de teclado útiles en Eclipse.
4. ¿Cómo se instala un plugin en Eclipse?""",
    
    "back": """1. Perspectiva: conjunto de vistas organizadas para una tarea específica.
   ● Java Perspective: para programar (Package Explorer, Editor, Outline)
   ● Debug Perspective: para depurar (Variables, Breakpoints, Console)
   ● Git Perspective: para control de versiones

2. Vistas importantes:
   ● Package Explorer: árbol de proyectos y archivos
   ● Outline: métodos y atributos de la clase actual
   ● Problems: errores y warnings del proyecto
   ● Console: salida de la ejecución

3. Atajos de teclado:
   Ctrl+Space: autocompletar
   Ctrl+Shift+F: formatear código
   Ctrl+Shift+O: organizar imports
   Ctrl+D: borrar línea
   Ctrl+/: comentar/descomentar línea
   F11: Debug (ejecutar en modo depuración)
   Ctrl+F11: Run (ejecutar)

4. Instalar plugin:
   Help → Eclipse Marketplace → buscar plugin → Install""",
    "tags": ['ed', 'eac2', 'eclipse', 'ide', 'atajos']
})

# 10. Testing - black box vs white box
ed_new.append({
    "front": """(ED — EAC3 / Testing) Explica los tipos de pruebas.

1. ¿Qué diferencia hay entre caja negra y caja blanca?
2. Pon un ejemplo de cada una.
3. ¿Qué es una prueba unitaria? ¿Y una prueba de integración?
4. ¿Qué es la cobertura de código? ¿Por qué es importante?""",
    
    "back": """1. Caja negra (black box) vs Caja blanca (white box):

CAJA NEGRA:
● No conocemos el código interno
● Probamos solo entradas y salidas
● Basado en especificaciones
● Ej: meter números en una calculadora y ver si suma bien

CAJA BLANCA:
● Conocemos el código interno
● Probamos caminos, condiciones, bucles
● Basado en la estructura del código
● Ej: verificar que todos los if/else se ejecutan

2. Tipos de pruebas:
● Unitarias: prueban una función/método individual
● Integración: prueban la interacción entre varios componentes
● Sistema: prueban el sistema completo
● Aceptación: el cliente valida que cumple requisitos
● Carga/Rendimiento: cómo responde con muchos usuarios

3. Cobertura de código:
Porcentaje del código que se ejecuta durante las pruebas.
● Cobertura de líneas: % de líneas ejecutadas
● Cobertura de ramas: % de if/else ejecutados
● Importante: saber si hay código sin probar""",
    "tags": ['ed', 'eac3', 'testing', 'caja-negra', 'caja-blanca']
})

# 11. Metrics - McCabe cyclomatic complexity
ed_new.append({
    "front": """(ED — EAC3 / Métricas) Explica la complejidad ciclomática de McCabe.

1. ¿Qué mide la complejidad ciclomática?
2. ¿Cómo se calcula? (fórmulas)
3. ¿Qué valores se consideran aceptables?
4. Calcula la CC de este código:

```java
public void clasificar(int nota) {
    if (nota < 0) return;
    if (nota < 5) System.out.println(\"Suspenso\");
    else if (nota < 7) System.out.println(\"Bien\");
    else System.out.println(\"Notable\");
}```""",
    
    "back": """1. Complejidad ciclomática (CC):
Mide el número de caminos linealmente independientes en el código.
A mayor CC, más difícil de probar y mantener.

2. Fórmulas:
   CC = número de condiciones + 1
   CC = aristas - nodos + 2 (en grafo de flujo)
   CC = número de regiones del grafo

3. Interpretación:
   1-10: código simple, bien estructurado
   11-20: complejidad moderada
   21-50: complejo, difícil de probar
   >50: muy complejo, necesita refactorización

4. Cálculo para el ejemplo:
Condiciones: (nota<0), (nota<5), (nota<7) = 3 condiciones
CC = 3 + 1 = 4

Esto significa que necesitamos al menos 4 casos de prueba
para cubrir todos los caminos posibles.""",
    "tags": ['ed', 'eac3', 'metrica', 'mccabe', 'complejidad']
})

# 12. Programming paradigms
ed_new.append({
    "front": """(ED — EAC1 / Paradigmas) Explica los paradigmas de programación.

1. ¿Qué es un paradigma de programación?
2. Menciona 5 paradigmas con un ejemplo de lenguaje para cada uno.
3. ¿Qué diferencias hay entre programación estructurada y POO?""",
    
    "back": """Paradigma: estilo/filosofía de programación.
Define cómo se estructura y organiza el código.

1. Imperativo: secuencia de instrucciones que modifican el estado
   ● Lenguajes: C, Pascal, BASIC

2. Estructurado: evita GOTO, usa secuencia/selección/iteración
   ● Lenguajes: C, Pascal

3. Orientado a Objetos (POO): organiza el código en clases/objetos
   ● Lenguajes: Java, C++, Python, C#

4. Funcional: basado en funciones matemáticas sin estado mutable
   ● Lenguajes: Haskell, Lisp, Scala

5. Lógico: basado en reglas y hechos (predicados)
   ● Lenguajes: Prolog

Diferencias Estructurado vs POO:
● Estructurado: funciones + datos separados, difícil de mantener
● POO: datos + métodos juntos (encapsulación), reutilizable (herencia)""",
    "tags": ['ed', 'eac1', 'paradigmas', 'programacion', 'poo']
})

# Add all ED cards
added_ed = 0
for card_data in ed_new:
    cid = add_card(card_data['front'], card_data['back'], card_data['tags'])
    added_ed += 1
    print(f'  Added {cid}: {card_data["front"][:70]}...')

print(f'\nAdded {added_ed} new ED preguntas directas')
print(f'Total ED now: {len([c for c in pd_all["cards"] if c["front"].startswith("(ED")])}')

# Save
save_json('public/data/preguntas-directas/pd-all.json', pd_all)
print('\nSaved pd-all.json')
