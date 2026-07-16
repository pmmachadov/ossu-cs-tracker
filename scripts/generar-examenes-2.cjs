     1|const fs = require('fs');
     2|const dir = 'public/data/examenes';
     3|
     4|// ========== DWEC EAC1 ==========
     5|const dwecEac1 = {
     6|  "id": "examen-dwec-eac1",
     7|  "name": "DWEC - EAC1 (Desarrollo Web en Entorno Cliente)",
     8|  "description": "Preguntas de la EAC1 de DWEC - JavaScript: sintaxis, funciones, arrays, objetos",
     9|  "subject": "Desarrollo Web en Entorno Cliente",
    10|  "cards": [
    11|    {
    12|      "id": "examen-dwec-eac1-1",
    13|      "front": "¿Qué diferencia hay entre const y let en JavaScript? ¿Cuándo usar cada uno?",
    14|      "back": "const: valor constante, no reasignable. Debe inicializarse en su declaración.\nlet: variable reasignable, ámbito de bloque (block scope).\nUsar const por defecto, let solo cuando se necesita reasignar. Evitar var (ámbito de función, hoisting).",
    15|      "tags": ["dwec", "eac1", "javascript", "variables"]
    16|    },
    17|    {
    18|      "id": "examen-dwec-eac1-2",
    19|      "front": "¿Qué tipos primitivos tiene JavaScript?",
    20|      "back": "string, number, boolean, null, undefined.",
    21|      "tags": ["dwec", "eac1", "javascript", "tipos"]
    22|    },
    23|    {
    24|      "id": "examen-dwec-eac1-3",
    25|      "front": "¿Cuál es la diferencia entre == y === en JavaScript?",
    26|      "back": "=== compara valor y tipo (estricta, recomendada).\n== compara valor con conversión implícita de tipo (no recomendada).",
    27|      "tags": ["dwec", "eac1", "javascript", "operadores"]
    28|    },
    29|    {
    30|      "id": "examen-dwec-eac1-4",
    31|      "front": "¿Cómo se usa un condicional if comparando strings de forma insensible a mayúsculas?",
    32|      "back": "Usar .toLowerCase() en ambos lados de la comparación:\nif (variable.toLowerCase() === 'valor') { ... }",
    33|      "tags": ["dwec", "eac1", "javascript", "condicionales"]
    34|    },
    35|    {
    36|      "id": "examen-dwec-eac1-5",
    37|      "front": "¿Qué diferencia hay entre do-while y while?",
    38|      "back": "do-while: ejecuta el bloque al menos una vez antes de evaluar la condición.\nwhile: evalúa la condición antes de cada iteración (puede ejecutarse 0 veces).",
    39|      "tags": ["dwec", "eac1", "javascript", "bucles"]
    40|    },
    41|    {
    42|      "id": "examen-dwec-eac1-6",
    43|      "front": "¿Qué hace la instrucción continue dentro de un bucle?",
    44|      "back": "Salta a la siguiente iteración del bucle, omitiendo el código restante de la iteración actual.",
    45|      "tags": ["dwec", "eac1", "javascript", "bucles"]
    46|    },
    47|    {
    48|      "id": "examen-dwec-eac1-7",
    49|      "front": "¿Qué diferencia hay entre una función tradicional y una arrow function?",
    50|      "back": "Función tradicional: function nombre(param) { return valor; }\nArrow function: const fn = (param) => param * 2;\nArrow functions son más concisas, no tienen su propio this ni arguments.",
    51|      "tags": ["dwec", "eac1", "javascript", "funciones"]
    52|    },
    53|    {
    54|      "id": "examen-dwec-eac1-8",
    55|      "front": "¿Cómo se crea un objeto Date en JavaScript para una fecha específica?",
    56|      "back": "const fecha = new Date(2000, 4, 15);\nNota: los meses van de 0 (enero) a 11 (diciembre).\nPara obtener el año: fecha.getFullYear();",
    57|      "tags": ["dwec", "eac1", "javascript", "date"]
    58|    },
    59|    {
    60|      "id": "examen-dwec-eac1-9",
    61|      "front": "¿Qué métodos de array has utilizado en JS? Explica filter, find y sort.",
    62|      "back": "filter(): crea nuevo array con elementos que cumplen condición.\nfind(): devuelve primer elemento que cumple condición (o undefined).\nfindIndex(): devuelve índice del primer elemento que cumple.\nsort(): ordena el array (requiere función de comparación para números).\nforEach(): itera sobre cada elemento.\nspread operator: [...array] crea copia superficial.",
    63|      "tags": ["dwec", "eac1", "javascript", "arrays"]
    64|    },
    65|    {
    66|      "id": "examen-dwec-eac1-10",
    67|      "front": "¿Cómo se declara una propiedad privada en una clase de JavaScript (ES2022)?",
    68|      "back": "Usando el prefijo #:\nclass Producto {\n  #stock; // propiedad privada\n  constructor(nombre, precio, stock) {\n    this.nombre = nombre;\n    this.#stock = stock;\n  }\n  get info() {\n    return `${this.nombre} - ${this.precio.toFixed(2)} €`;\n  }\n}",
    69|      "tags": ["dwec", "eac1", "javascript", "clases", "poo"]
    70|    },
    71|    {
    72|      "id": "examen-dwec-eac1-11",
    73|      "front": "¿Cómo se exporta e importa un módulo en ES6? ¿Qué atributo debe tener el script HTML?",
    74|      "back": "Exportar: export function miFuncion() { ... }\nImportar: import { miFuncion } from './modulo.js';\nEl script HTML debe tener type=\"module\".",
    75|      "tags": ["dwec", "eac1", "javascript", "modulos"]
    76|    },
    77|    {
    78|      "id": "examen-dwec-eac1-12",
    79|      "front": "¿Cómo validar que un string contiene solo dígitos con expresión regular?",
    80|      "back": "const soloDigitos = /^\\d+$/.test(valor);\n.test() devuelve true si el patrón coincide.",
    81|      "tags": ["dwec", "eac1", "javascript", "regex"]
    82|    }
    83|  ]
    84|};
    85|
    86|// ========== DWEC EAC3 ==========
    87|const dwecEac3 = {
    88|  "id": "examen-dwec-eac3",
    89|  "name": "DWEC - EAC3 (Desarrollo Web en Entorno Cliente)",
    90|  "description": "Preguntas de la EAC3 de DWEC - DOM, Eventos, Fetch API y Express",
    91|  "subject": "Desarrollo Web en Entorno Cliente",
    92|  "cards": [
    93|    {
    94|      "id": "examen-dwec-eac3-1",
    95|      "front": "¿Qué selectores del DOM existen y qué devuelve cada uno?",
    96|      "back": "document.getElementById('id') → un elemento\n  document.querySelectorAll('.clase') → NodeList\n  document.querySelector('#id') → primer elemento que coincide",
    97|      "tags": ["dwec", "eac3", "dom", "selectores"]
    98|    },
    99|    {
   100|      "id": "examen-dwec-eac3-2",
   101|      "front": "¿Cómo se manipulan las clases CSS desde JavaScript?",
   102|      "back": "element.classList.add('activo');\nelement.classList.remove('activo');\nelement.classList.toggle('activo');\nelement.classList.contains('activo');",
   103|      "tags": ["dwec", "eac3", "dom", "css"]
   104|    },
   105|    {
   106|      "id": "examen-dwec-eac3-3",
   107|      "front": "¿Cómo se crea un elemento del DOM y se añade a un contenedor? ¿Cómo se vacía un contenedor?",
   108|      "back": "const div = document.createElement('div');\ndiv.classList.add('item');\ndiv.textContent = 'Texto';\ncontenedor.appendChild(div);\n\nVaciar: contenedor.innerHTML = '';",
   109|      "tags": ["dwec", "eac3", "dom", "creacion"]
   110|    },
   111|    {
   112|      "id": "examen-dwec-eac3-4",
   113|      "front": "¿Qué eventos del ratón existen y cuál es la diferencia entre mouseenter/mouseover?",
   114|      "back": "click, mouseenter, mouseleave, mouseover, mouseout, mousemove.\nmouseenter/mouseleave: no burbujean (solo en el elemento).\nmouseover/mouseout: burbujean (también en hijos).",
   115|      "tags": ["dwec", "eac3", "eventos", "raton"]
   116|    },
   117|    {
   118|      "id": "examen-dwec-eac3-5",
   119|      "front": "¿Cómo se registra y elimina un evento en JavaScript?",
   120|      "back": "element.addEventListener('click', handler);\nelement.removeEventListener('click', handler);\n\nPara poder eliminar el evento, handler debe ser una función nombrada (no anónima).",
   121|      "tags": ["dwec", "eac3", "eventos"]
   122|    },
   123|    {
   124|      "id": "examen-dwec-eac3-6",
   125|      "front": "¿Qué propiedades y métodos del objeto event son más importantes?",
   126|      "back": "event.target: elemento que disparó el evento\nevent.preventDefault(): evita comportamiento por defecto\nevent.stopPropagation(): detiene la propagación (burbujeo)",
   127|      "tags": ["dwec", "eac3", "eventos"]
   128|    },
   129|    {
   130|      "id": "examen-dwec-eac3-7",
   131|      "front": "¿Por qué es importante usar DOMContentLoaded?",
   132|      "back": "document.addEventListener('DOMContentLoaded', () => { ... });\nAsegura que el código se ejecute solo cuando el DOM esté completamente cargado, evitando errores al intentar acceder a elementos que aún no existen.",
   133|      "tags": ["dwec", "eac3", "dom"]
   134|    },
   135|    {
   136|      "id": "examen-dwec-eac3-8",
   137|      "front": "¿Cómo se usa fetch para GET y POST?",
   138|      "back": "GET:\nconst res = await fetch(url);\nconst data = await res.json();\n\nPOST:\nconst res = await fetch(url, {\n  method: 'POST',\n  headers: { 'Content-Type': 'application/json' },\n  body: JSON.stringify({ campo: 'valor' })\n});",
   139|      "tags": ["dwec", "eac3", "fetch", "api"]
   140|    },
   141|    {
   142|      "id": "examen-dwec-eac3-9",
   143|      "front": "¿Cómo se manejan errores con async/await?",
   144|      "back": "async function cargarDatos() {\n  try {\n    const res = await fetch(url);\n    if (!res.ok) throw new Error('Error');\n    return await res.json();\n  } catch (err) {\n    console.error(err);\n  }\n}",
   145|      "tags": ["dwec", "eac3", "async", "await", "errores"]
   146|    },
   147|    {
   148|      "id": "examen-dwec-eac3-10",
   149|      "front": "¿Qué son req.params y req.body en Express?",
   150|      "back": "req.params: parámetros de ruta URL (ej: /:id).\nreq.body: datos JSON del cuerpo de la petición POST/PUT.\nPara usar req.body hay que configurar: app.use(express.json());",
   151|      "tags": ["dwec", "eac3", "express"]
   152|    },
   153|    {
   154|      "id": "examen-dwec-eac3-11",
   155|      "front": "¿Cuáles son los códigos HTTP más comunes y su significado?",
   156|      "back": "200 OK\n201 Created\n400 Bad Request\n404 Not Found\n409 Conflict\n500 Internal Server Error",
   157|      "tags": ["dwec", "eac3", "http", "codigos"]
   158|    },
   159|    {
   160|      "id": "examen-dwec-eac3-12",
   161|      "front": "¿Cómo se usa e.preventDefault() en un formulario?",
   162|      "back": "form.addEventListener('submit', (e) => {\n  e.preventDefault(); // evita recarga de página\n  // validar y enviar...\n});",
   163|      "tags": ["dwec", "eac3", "formularios"]
   164|    },
   165|    {
   166|      "id": "examen-dwec-eac3-13",
   167|      "front": "¿Qué diálogos del navegador existen y qué devuelven?",
   168|      "back": "prompt('Mensaje'): devuelve string o null\nalert('Mensaje'): muestra mensaje\nconfirm('¿Seguro?'): devuelve true o false",
   169|      "tags": ["dwec", "eac3", "dialogos"]
   170|    }
   171|  ]
   172|};
   173|
   174|// ========== ED EAC2 (UML) ==========
   175|const edEac2 = {
   176|  "id": "examen-ed-eac2",
   177|  "name": "ED - EAC2 (Entornos de Desarrollo)",
   178|  "description": "Preguntas de la EAC2 de ED - Diagramas UML y Modelado Orientado a Objetos",
   179|  "subject": "Entornos de Desarrollo",
   180|  "cards": [
   181|    {
   182|      "id": "examen-ed-eac2-1",
   183|      "front": "¿Qué elementos componen un diagrama de clases UML?",
   184|      "back": "Una clase se representa como un rectángulo dividido en 3 secciones:\n1. Nombre de la clase\n2. Atributos (visibilidad nombre: tipo)\n3. Métodos/Operaciones (visibilidad nombre(param: tipo): retorno)",
   185|      "tags": ["ed", "eac2", "uml", "diagrama-clases"]
   186|    },
   187|    {
   188|      "id": "examen-ed-eac2-2",
   189|      "front": "¿Qué símbolos de visibilidad se usan en UML y qué significan?",
   190|      "back": "+ público (public)\n- privado (private)\n# protegido (protected)\n~ paquete/package",
   191|      "tags": ["ed", "eac2", "uml", "visibilidad"]
   192|    },
   193|    {
   194|      "id": "examen-ed-eac2-3",
   195|      "front": "¿Qué tipos de relaciones entre clases existen en UML y cómo se representan?",
   196|      "back": "Asociación: línea sólida entre clases\nHerencia: flecha triangular vacía apuntando a la superclase\nComposición: rombo relleno (pertenencia fuerte)\nAgregación: rombo vacío (pertenencia débil)\nDependencia: flecha punteada (uso temporal)",
   197|      "tags": ["ed", "eac2", "uml", "relaciones"]
   198|    },
   199|    {
   200|      "id": "examen-ed-eac2-4",
   201|      "front": "¿Qué diferencia hay entre composición y agregación en UML?",
   202|      "back": "Composición (rombo relleno): relación fuerte, las partes NO pueden existir sin el todo. Ej: Mano ◆--- Dedo\nAgregación (rombo vacío): relación débil, las partes pueden existir sin el todo. Ej: Frutería ◇--- Fruta\n\nSi desaparece el todo: en composición desaparecen las partes; en agregación no.",
   203|      "tags": ["ed", "eac2", "uml", "composicion", "agregacion"]
   204|    },
   205|    {
   206|      "id": "examen-ed-eac2-5",
   207|      "front": "¿Qué significa la multiplicidad en UML y qué valores se usan?",
   208|      "back": "1 → exactamente uno\n0..1 → cero o uno\n* → cero o más\n1..* → uno o más",
   209|      "tags": ["ed", "eac2", "uml", "multiplicidad"]
   210|    },
   211|    {
   212|      "id": "examen-ed-eac2-6",
   213|      "front": "¿Cómo se declara una enumeración en Java?",
   214|      "back": "Se declara con la palabra clave `enum` seguida del nombre y las constantes entre llaves.\n\nEjemplo:\n```java\npublic enum Especialidad {\n    BIOLOGIA,\n    GEOLOGIA,\n    OCEANOGRAFIA;\n}\n```\n\nCaracterísticas:\n- Define un conjunto fijo de constantes con nombre\n- Las constantes van separadas por comas y terminan con punto y coma\n- Es type-safe: el compilador verifica los valores",
   215|      "tags": ["ed", "eac2", "java", "enum"]
   216|    },
   217|    {
   218|      "id": "examen-ed-eac2-7",
   219|      "front": "¿Cómo se implementa la herencia en Java?",
   220|      "back": "public class DirectorEstacion extends Cientifico {\n  private double presupuestoAsignado;\n  public DirectorEstacion(...) {\n    super(dni, nombre, especialidad, aniosExperiencia);\n    this.presupuestoAsignado = presupuestoAsignado;\n  }\n}\n\nextends para heredar, super() como primera línea del constructor.",
   221|      "tags": ["ed", "eac2", "java", "herencia"]
   222|    },
   223|    {
   224|      "id": "examen-ed-eac2-8",
   225|      "front": "¿Qué es y cómo se representa un diagrama de casos de uso?",
   226|      "back": "Actor: rol externo (figura humana)\nCaso de uso: óvalo con acción\n<<include>>: obligatorio (un caso SIEMPRE incluye otro)\n<<extend>>: opcional (extensión bajo condición)",
   227|      "tags": ["ed", "eac2", "uml", "casos-de-uso"]
   228|    },
   229|    {
   230|      "id": "examen-ed-eac2-9",
   231|      "front": "¿Qué elementos tiene un diagrama de secuencia?",
   232|      "back": "Líneas de vida verticales (objetos)\nMensajes horizontales numerados\nActivaciones (rectángulos sobre línea de vida)\nRetornos punteados",
   233|      "tags": ["ed", "eac2", "uml", "secuencia"]
   234|    },
   235|    {
   236|      "id": "examen-ed-eac2-10",
   237|      "front": "¿Qué diferencia hay entre diagrama de secuencia y diagrama de comunicación?",
   238|      "back": "Secuencia: énfasis en el orden temporal de los mensajes (líneas de vida verticales).\nComunicación: énfasis en las relaciones estructurales entre objetos (rectángulos conectados con mensajes numerados).",
   239|      "tags": ["ed", "eac2", "uml", "secuencia", "comunicacion"]
   240|    },
   241|    {
   242|      "id": "examen-ed-eac2-11",
   243|      "front": "¿Qué elementos componen un diagrama de actividades?",
   244|      "back": "Nodo inicial (círculo negro)\nNodo final (círculo doble)\nActividades (rectángulos redondeados)\nBifurcaciones paralelas (barras negras: fork/join)\nDecisiones (rombos con guardas [condición])",
   245|      "tags": ["ed", "eac2", "uml", "actividades"]
   246|    }
   247|  ]
   248|};
   249|
   250|const edEac3 = {
   251|  "id": "examen-ed-eac3",
   252|  "name": "ED - EAC3 (Entornos de Desarrollo)",
   253|  "description": "Preguntas de la EAC3 de ED - Pruebas de Software, Git, Refactorización, Spring Boot y Swing",
   254|  "subject": "Entornos de Desarrollo",
   255|  "cards": [
   256|    {
   257|      "id": "examen-ed-eac3-1",
   258|      "front": "¿Qué tipos de pruebas de software existen?",
   259|      "back": "Caja blanca: analiza estructura interna del código, caminos de ejecución.\nCaja negra: entradas/salidas sin conocer implementación.\nRegresión: detectar errores tras cambios.\nAceptación (Beta): validación con el cliente en entorno real.",
   260|      "tags": ["ed", "eac3", "pruebas", "testing"]
   261|    },
   262|    {
   263|      "id": "examen-ed-eac3-2",
   264|      "front": "¿Cómo se calcula la complejidad ciclomática de McCabe?",
   265|      "back": "CC = número de condiciones + 1\nCC = número de aristas - número de nodos + 2\n\nValores:\n1-10: simple\n11-20: moderado\n21-50: complejo\n>50: muy complejo",
   266|      "tags": ["ed", "eac3", "mccabe", "complejidad"]
   267|    },
   268|    {
   269|      "id": "examen-ed-eac3-3",
   270|      "front": "¿Cómo se aplican las clases de equivalencia y valores límite en pruebas?",
   271|      "back": "1. Identificar rangos y restricciones de entrada\n2. Definir clases válidas e inválidas\n3. Seleccionar representantes de cada clase\n4. Incluir valores límite (mínimo, máximo, justo fuera)",
   272|      "tags": ["ed", "eac3", "pruebas", "equivalencia"]
   273|    },
   274|    {
   275|      "id": "examen-ed-eac3-4",
   276|      "front": "¿Cuáles son los comandos esenciales de Git y su orden?",
   277|      "back": "git init → inicializar repositorio\ngit add archivo.java → añadir al staging\ngit status → ver estado\ngit commit -m \"mensaje\" → confirmar cambios\ngit log → ver historial\ngit branch nombre → crear rama\ngit checkout nombre → cambiar de rama\ngit merge nombre → fusionar rama",
   278|      "tags": ["ed", "eac3", "git"]
   279|    },
   280|    {
   281|      "id": "examen-ed-eac3-5",
   282|      "front": "¿Qué es HEAD en Git? ¿Qué es un conflicto?",
   283|      "back": "HEAD: commit más reciente de la rama actual.\nConflicto: ocurre al fusionar cambios que modifican las mismas líneas en ambos archivos. Git no puede resolverlo automáticamente.",
   284|      "tags": ["ed", "eac3", "git"]
   285|    },
   286|    {
   287|      "id": "examen-ed-eac3-6",
   288|      "front": "¿Qué es refactorización y qué técnicas se aplican?",
   289|      "back": "Refactorización: mejorar el código sin alterar su comportamiento externo.\nTécnicas:\n- Extraer método: convertir bloque en método independiente\n- Extraer constantes: eliminar números mágicos\n- Renombrar: mejorar legibilidad de nombres",
   290|      "tags": ["ed", "eac3", "refactorizacion"]
   291|    },
   292|    {
   293|      "id": "examen-ed-eac3-7",
   294|      "front": "¿Cómo se generan y qué etiquetas tiene un Javadoc?",
   295|      "back": "/**\n * Descripción.\n * @param param Descripción\n * @return Descripción\n * @author Nombre\n * @version 1.0\n */\n\nGenerar: javadoc -d docs Clase.java",
   296|      "tags": ["ed", "eac3", "javadoc"]
   297|    },
   298|    {
   299|      "id": "examen-ed-eac3-8",
   300|      "front": "¿Qué anotaciones y aserciones de JUnit 5 son las más importantes?",
   301|      "back": "Anotaciones:\n@Test: marca método de prueba\n@BeforeEach / @AfterEach: antes/después de cada test\n@BeforeAll / @AfterAll: antes/después de todos (método estático)\n\nAserciones:\nassertEquals(esperado, actual)\nassertTrue(condicion)\nassertThrows(Tipo.class, () -> código)",
   302|      "tags": ["ed", "eac3", "junit", "testing"]
   303|    },
   304|    {
   305|      "id": "examen-ed-eac3-9",
   306|      "front": "¿Qué diferencia hay entre @Controller y @RestController en Spring Boot?",
   307|      "back": "@Controller: devuelve vistas (templates Thymeleaf).\n@RestController: devuelve datos directamente (JSON).\n\nAmbas se usan con @GetMapping, @PostMapping, etc.",
   308|      "tags": ["ed", "eac3", "spring", "controller"]
   309|    },
   310|    {
   311|      "id": "examen-ed-eac3-10",
   312|      "front": "¿Cómo funciona Thymeleaf con Spring Boot?",
   313|      "back": "Motor de plantillas por defecto en Spring Boot.\nEn el Controller: model.addAttribute(\"clave\", valor);\nEn el template HTML: th:text=\"${clave}\"\nPlantillas en src/main/resources/templates/",
   314|      "tags": ["ed", "eac3", "thymeleaf", "spring"]
   315|    },
   316|    {
   317|      "id": "examen-ed-eac3-11",
   318|      "front": "¿Qué componentes de Swing se usan para crear una interfaz gráfica?",
   319|      "back": "JFrame: ventana principal\nJPanel: contenedor\nJLabel: etiqueta de texto\nJTextField: campo de texto una línea\nJTextArea: campo multilínea\nJComboBox: lista desplegable\nJButton: botón",
   320|      "tags": ["ed", "eac3", "swing"]
   321|    },
   322|    {
   323|      "id": "examen-ed-eac3-12",
   324|      "front": "¿Cómo se manejan eventos en Swing?",
   325|      "back": "btn.addActionListener(new ActionListener() {\n  public void actionPerformed(ActionEvent e) {\n    // código al pulsar\n  }\n});\n\nO con lambda (Java 8+):\nbtn.addActionListener(e -> metodo());\nsetLayout(null) + setBounds(x, y, ancho, alto) para posicionamiento absoluto.",
   326|      "tags": ["ed", "eac3", "swing", "eventos"]
   327|    }
   328|  ]
   329|};
   330|
   331|// Escribir archivos
   332|fs.writeFileSync(`${dir}/dwec-eac1.json`, JSON.stringify(dwecEac1, null, 2));
   333|fs.writeFileSync(`${dir}/dwec-eac3.json`, JSON.stringify(dwecEac3, null, 2));
   334|fs.writeFileSync(`${dir}/ed-eac2.json`, JSON.stringify(edEac2, null, 2));
   335|fs.writeFileSync(`${dir}/ed-eac3.json`, JSON.stringify(edEac3, null, 2));
   336|
   337|console.log('=== FICHEROS CREADOS ===');
   338|console.log(`${dir}/dwec-eac1.json - ${dwecEac1.cards.length} cartas`);
   339|console.log(`${dir}/dwec-eac3.json - ${dwecEac3.cards.length} cartas`);
   340|console.log(`${dir}/ed-eac2.json - ${edEac2.cards.length} cartas`);
   341|console.log(`${dir}/ed-eac3.json - ${edEac3.cards.length} cartas`);
   342|console.log(`Total: ${dwecEac1.cards.length + dwecEac3.cards.length + edEac2.cards.length + edEac3.cards.length} cartas`);
   343|