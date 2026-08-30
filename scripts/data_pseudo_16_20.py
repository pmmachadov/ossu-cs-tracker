# -*- coding: utf-8 -*-
# Pseudocódigos para Exámenes 16 al 20

PSEUDO_16_20 = {
    # --- EXAMEN 16 ---
    "ex-java-16-11": """Algoritmo CorregirPilaDesbordamiento
    // Antes de desapilar (pop) o consultar la cima (peek) en una Pila (Stack)
    // SIEMPRE debe verificarse que no esté vacía para evitar EmptyStackException
    Clase PilaSegura
        Privado elementos Como Lista
        
        Metodo desapilarSeguro() -> Elemento
            Si No estaVacia() Entonces
                Devolver elementos.eliminarUltimo()
            Sino
                Escribir "Advertencia: La pila está vacía"
                Devolver Nulo
            FinSi
        FinMetodo
        
        Metodo estaVacia() -> Logico
            Devolver elementos.longitud() = 0
        FinMetodo
    FinClase
FinAlgoritmo""",

    "ex-java-16-12": """Algoritmo TrazaColaFIFO
    // En una Cola (Queue / LinkedList):
    // offer(x) encola al final. poll() desencola del frente (FIFO).
    Definir cola Como Cola
    cola.encolar("A")
    cola.encolar("B")
    cola.encolar("C")
    
    Escribir cola.desencolar() // Imprime: A
    cola.encolar("D")
    Escribir cola.desencolar() // Imprime: B
    // Quedan en cola: C, D
FinAlgoritmo""",

    "ex-java-16-13": """Algoritmo BalanceoParentesisConPila
    Funcion correcto <- validarParentesis(expresion)
        Definir pila Como Pila
        pila <- Nueva Pila()
        correcto <- Verdadero
        
        Para i <- 1 Hasta Longitud(expresion) Hacer
            c <- Subcadena(expresion, i, i)
            Si c = "(" O c = "{" O c = "[" Entonces
                pila.apilar(c)
            Sino Si c = ")" O c = "}" O c = "]" Entonces
                Si pila.estaVacia() O No CoincidePar(pila.desapilar(), c) Entonces
                    correcto <- Falso
                FinSi
            FinSi
        FinPara
        
        Si No pila.estaVacia() Entonces
            correcto <- Falso
        FinSi
    FinFuncion
FinAlgoritmo""",

    "ex-java-16-14": """Clase ListaEnlazadaSimple
    Estructura Nodo
        dato Como Entero
        siguiente Como Nodo
    FinEstructura
    
    Privado cabeza Como Nodo <- Nulo
    
    Metodo insertarAlInicio(valor)
        nuevoNodo <- Nuevo Nodo(valor)
        nuevoNodo.siguiente <- cabeza
        cabeza <- nuevoNodo
    FinMetodo
    
    Metodo mostrar()
        actual <- cabeza
        Mientras actual <> Nulo Hacer
            Escribir actual.dato, " -> "
            actual <- actual.siguiente
        FinMientras
    FinMetodo
FinClase""",

    "ex-java-16-15": """Algoritmo ColaAtencionClientes
    Definir colaClientes Como Cola
    colaClientes <- Nueva Cola()
    
    // Llegada de clientes
    colaClientes.encolar("Cliente 1")
    colaClientes.encolar("Cliente 2")
    colaClientes.encolar("Cliente 3")
    
    // Atender por orden de llegada
    Mientras No colaClientes.estaVacia() Hacer
        atendido <- colaClientes.desencolar()
        Escribir "Atendiendo a: ", atendido
    FinMientras
FinAlgoritmo""",

    "ex-java-16-16": """Estructura PilasColasListas
    // PILA (Stack - LIFO: Last In, First Out):
    // Inserción y extracción por el mismo extremo (tope). Ideal para llamadas recursivas y 'Deshacer'.
    //
    // COLA (Queue - FIFO: First In, First Out):
    // Inserción por el final y extracción por el frente. Ideal para turnos e impresión.
    //
    // LISTA ENLAZADA:
    // Nodos con punteros. Inserción/borrado O(1) en extremos sin recolocar memoria.
FinEstructura""",

    # --- EXAMEN 17 ---
    "ex-java-17-11": """Algoritmo CorregirTryWithResourcesLectura
    // try-with-resources garantiza el cierre automático del BufferedReader y FileReader
    Intentar (lector <- AbrirLectorTexto("datos.txt"))
        linea <- lector.leerLinea()
        Mientras linea <> Nulo Hacer
            Escribir linea
            linea <- lector.leerLinea()
        FinMientras
    Capturar ExcepcionIO e
        Escribir "Error de E/S: ", e.mensaje
    FinIntentar
FinAlgoritmo""",

    "ex-java-17-12": """Algoritmo TrazaPrintWriterModoAppend
    // Modo Append (FileWriter(nombre, true)): Añade al final sin borrar contenido previo
    Definir escritor Como FlujoEscritura
    escritor <- AbrirEscrituraTexto("log.txt", ModoAnadir <- Verdadero)
    escritor.escribirLinea("Registro evento A")
    escritor.escribirLinea("Registro evento B")
    escritor.cerrar()
FinAlgoritmo""",

    "ex-java-17-13": """Algoritmo ContarLineasPalabrasCaracteres
    Definir totalLineas, totalPalabras, totalChars Como Entero <- 0
    
    Intentar (lector <- AbrirLectorTexto("documento.txt"))
        linea <- lector.leerLinea()
        Mientras linea <> Nulo Hacer
            totalLineas <- totalLineas + 1
            totalChars <- totalChars + Longitud(linea)
            palabras <- DividirTexto(linea, " ")
            totalPalabras <- totalPalabras + Longitud(palabras)
            linea <- lector.leerLinea()
        FinMientras
    FinIntentar
    
    Escribir "Líneas: ", totalLineas, " Palabras: ", totalPalabras, " Caracteres: ", totalChars
FinAlgoritmo""",

    "ex-java-17-14": """Algoritmo FiltrarLineasPorPalabraClave
    Definir palabraBuscada Como Cadena <- "ERROR"
    
    Intentar (lector <- AbrirLector("servidor.log"); escritor <- AbrirEscritor("errores.txt"))
        linea <- lector.leerLinea()
        Mientras linea <> Nulo Hacer
            Si Contiene(linea, palabraBuscada) Entonces
                escritor.escribirLinea(linea)
            FinSi
            linea <- lector.leerLinea()
        FinMientras
    FinIntentar
FinAlgoritmo""",

    "ex-java-17-15": """Algoritmo EscribirInformeConPrintWriter
    Intentar (pw <- AbrirPrintWriter("informe.txt"))
        pw.formatear("=== REPORTE DE VENTAS ===%n")
        pw.formatear("Producto: %-15s Precio: %6.2f€%n", "Ratón", 15.50)
        pw.formatear("Producto: %-15s Precio: %6.2f€%n", "Teclado", 45.00)
    Capturar ExcepcionIO e
        Escribir "Error escribiendo reporte"
    FinIntentar
FinAlgoritmo""",

    "ex-java-17-16": """Estructura FlujosTextoJava
    // CARÁCTER (Reader / Writer):
    // Trabajan con caracteres Unicode (16 bits). Manejan codificación (UTF-8, ISO).
    //
    // BUFFERED (BufferedReader / BufferedWriter):
    // Añaden memoria intermedia para reducir accesos a disco y ofrecen readLine() / newLine().
    //
    // AUTO-CLOSEABLE:
    // Interfaz que permite la sintaxis try-with-resources sin bloques finally manuales.
FinEstructura""",

    # --- EXAMEN 18 ---
    "ex-java-18-11": """Algoritmo TestCalculadoraJUnit
    // En JUnit 5, las aserciones validan el comportamiento esperado: assertEquals(esperado, actual)
    Clase CalculadoraTest
        @Test
        Metodo testSumar()
            calc <- Nueva Calculadora()
            resultado <- calc.sumar(2, 3)
            AfirmarIguales(5, resultado)
        FinMetodo
        
        @Test
        Metodo testDividirPorCeroLanzaExcepcion()
            calc <- Nueva Calculadora()
            AfirmarQueLanza(ExcepcionAritmetica, () -> calc.dividir(5, 0))
        FinMetodo
    FinClase
FinAlgoritmo""",

    "ex-java-18-12": """Algoritmo CicloVidaJUnit5
    // ORDEN DE EJECUCIÓN:
    // 1. @BeforeAll: se ejecuta 1 vez antes de todos los tests
    // 2. Por cada test:
    //      a. @BeforeEach: inicializa el entorno de prueba
    //      b. @Test: ejecuta el test concreto
    //      c. @AfterEach: limpia recursos del test
    // 3. @AfterAll: se ejecuta 1 vez al terminar todos los tests
FinAlgoritmo""",

    "ex-java-18-13": """Algoritmo TestCadenaInvertidaJUnit
    Clase StringUtilsTest
        @Test
        Metodo testInvertirCadenaNormal()
            AfirmarIguales("aloh", UtilidadesTexto.invertir("hola"))
        FinMetodo
        
        @Test
        Metodo testInvertirCadenaVacia()
            AfirmarIguales("", UtilidadesTexto.invertir(""))
        FinMetodo
        
        @Test
        Metodo testInvertirNuloDevuelveNulo()
            AfirmarNulo(UtilidadesTexto.invertir(Nulo))
        FinMetodo
    FinClase
FinAlgoritmo""",

    "ex-java-18-14": """Algoritmo TestValidarEdadUsuario
    Clase UsuarioServiceTest
        @Test
        Metodo testMayorEdadValido()
            AfirmarVerdadero(UsuarioService.esMayorEdad(18))
            AfirmarVerdadero(UsuarioService.esMayorEdad(25))
        FinMetodo
        
        @Test
        Metodo testMenorEdadInvalido()
            AfirmarFalso(UsuarioService.esMayorEdad(17))
        FinMetodo
    FinClase
FinAlgoritmo""",

    "ex-java-18-15": """Algoritmo TestCuentaBancariaAserciones
    Clase CuentaBancariaTest
        @Test
        Metodo testIngresoAumentaSaldo()
            cuenta <- Nueva Cuenta(100.0)
            cuenta.ingresar(50.0)
            AfirmarIguales(150.0, cuenta.obtenerSaldo())
        FinMetodo
        
        @Test
        Metodo testRetiroExcesivoLanzaExcepcion()
            cuenta <- Nueva Cuenta(50.0)
            AfirmarQueLanza(ExcepcionSaldoInsuficiente, () -> cuenta.retirar(100.0))
        FinMetodo
    FinClase
FinAlgoritmo""",

    "ex-java-18-16": """Estructura PiramideDeTesting
    // 1. TESTS UNITARIOS (Base de la pirámide):
    // Prueban clases o métodos aislados en memoria. Ultra rápidos y abundantes (JUnit).
    //
    // 2. TESTS DE INTEGRACIÓN:
    // Prueban la interacción entre módulos (ej: Servicio + Base de Datos).
    //
    // 3. TESTS END-TO-END / SISTEMA (Cúspide):
    // Prueban el flujo completo de la aplicación como un usuario real.
FinEstructura""",

    # --- EXAMEN 19 ---
    "ex-java-19-11": """Clase PatronSingleton
    Privado Estatico instancia Como ConexionBD <- Nulo
    
    // Constructor privado para impedir 'new' externo
    Constructor Privado()
        // Inicializar conexion
    FinConstructor
    
    // Punto de acceso global único
    Metodo Estatico obtenerInstancia() -> ConexionBD
        Si instancia = Nulo Entonces
            instancia <- Nueva ConexionBD()
        FinSi
        Devolver instancia
    FinMetodo
FinClase""",

    "ex-java-19-12": """Clase PatronFactoryNotificaciones
    Metodo Estatico crearNotificacion(tipo) -> Notificacion
        Segun tipo Hacer
            "EMAIL": Devolver Nueva NotificacionEmail()
            "SMS":   Devolver Nueva NotificacionSMS()
            "PUSH":  Devolver Nueva NotificacionPush()
            De Otro Modo: Lanzar ExcepcionTipoDesconocido()
        FinSegun
    FinMetodo
FinClase""",

    "ex-java-19-13": """Algoritmo PatronObserver
    Interfaz Observador
        Metodo actualizar(precio)
    FinInterfaz
    
    Clase AccionBolsa
        Privado observadores Como ListaDeObservadores
        Privado precio Como Real
        
        Metodo suscribir(obs)
            observadores.agregar(obs)
        FinMetodo
        
        Metodo cambiarPrecio(nuevoPrecio)
            precio <- nuevoPrecio
            Para Cada obs En observadores Hacer
                obs.actualizar(precio)
            FinPara
        FinMetodo
    FinClase
FinAlgoritmo""",

    "ex-java-19-14": """Algoritmo PatronDAO
    Interfaz AlumnoDAO
        Metodo buscarPorId(id) -> Alumno
        Metodo guardar(alumno)
        Metodo eliminar(id)
    FinInterfaz
    
    Clase AlumnoDAOBD Implementa AlumnoDAO
        Metodo buscarPorId(id) -> Alumno
            // Ejecuta SQL SELECT y retorna objeto Alumno
        FinMetodo
    FinClase
FinAlgoritmo""",

    "ex-java-19-15": """Algoritmo PatronMVC
    // MODELO: Gestiona datos y lógica de negocio (Alumno, BaseDatos)
    // VISTA: Interfaz de usuario que muestra la información (VentanaSwing, Consola)
    // CONTROLADOR: Intermediario que recibe eventos de la Vista y actualiza el Modelo
FinAlgoritmo""",

    "ex-java-19-16": """Estructura PatronesDeDiseno
    // CREACIONALES (Singleton, Factory, Builder):
    // Abstraen el proceso de instanciación y creación de objetos.
    //
    // ESTRUCTURALES (Adapter, Decorator, Facade):
    // Facilitan el ensamblado y composición de clases e interfaces.
    //
    // DE COMPORTAMIENTO (Observer, Strategy, Command):
    // Gestionan algoritmos, responsabilidades y comunicación entre objetos.
FinEstructura""",

    # --- EXAMEN 20 ---
    "ex-java-20-11": """Algoritmo CorregirConcurrenciaYFlujos
    // En Java 8+:
    // 1. Usar try-with-resources para cerrar flujos
    // 2. Usar colecciones concurrentes o sincronización para variables compartidas entre hilos
    Definir mapaConcurrente Como ConcurrentHashMap()
    mapaConcurrente.asignar("clave", 100)
FinAlgoritmo""",

    "ex-java-20-12": """Algoritmo TrazaCompletaRepaso
    // 1. Crear lista de empleados
    // 2. Filtrar con Stream los de departamento 'IT'
    // 3. Obtener sueldo medio con mapToDouble().average()
    Definir sueldoMedioIT Como Real
    sueldoMedioIT <- empleados.filtrar(e -> e.depto = "IT")
                              .extraerSueldo()
                              .promedio()
    Escribir "Sueldo medio IT: ", sueldoMedioIT
FinAlgoritmo""",

    "ex-java-20-13": """Clase LibroInmutable
    Atributos:
        Final Privado titulo Como Cadena
        Final Privado autor Como Cadena
        Final Privado paginas Como Entero
        
    Constructor(p_tit, p_aut, p_pag)
        titulo <- p_tit; autor <- p_aut; paginas <- p_pag
    FinConstructor
    
    Metodo getTitulo() -> Cadena Devolver titulo FinMetodo
    Metodo getAutor() -> Cadena Devolver autor FinMetodo
    Metodo getPaginas() -> Entero Devolver paginas FinMetodo
FinClase""",

    "ex-java-20-14": """Algoritmo EstadisticasAlumnosAvanzadas
    Definir alumnos Como ListaDeAlumnos
    
    // Agrupar por curso usando Map<Curso, List<Alumno>>
    Definir mapaPorCurso Como Diccionario
    mapaPorCurso <- alumnos.agruparPor(a -> a.curso)
    
    // Obtener la nota máxima global
    Definir notaMax Como Real
    notaMax <- alumnos.transformarANotas().maximo()
    
    Escribir "Nota más alta del centro: ", notaMax
FinAlgoritmo""",

    "ex-java-20-15": """Algoritmo GestorBibliotecaCompleto
    Clase Biblioteca
        Privado libros Como ListaDeLibros
        
        Metodo prestarLibro(isbn) -> Logico
            libro <- buscarLibro(isbn)
            Si libro <> Nulo Y No libro.estaPrestado() Entonces
                libro.marcarPrestado(Verdadero)
                Devolver Verdadero
            FinSi
            Devolver Falso
        FinMetodo
    FinClase
FinAlgoritmo""",

    "ex-java-20-16": """Estructura OrElseVsOrElseGet
    // OPTIONAL.OR_ELSE(valorPorDefecto):
    // El argumento se calcula SIEMPRE (evaluación ansiosa), haya o no valor en el Optional.
    // Usar cuando el valor por defecto ya está creado o es una constante simple.
    //
    // OPTIONAL.OR_ELSE_GET(() -> generarValor()):
    // El proveedor solo se ejecuta si el Optional está VACÍO (evaluación perezosa).
    // Usar cuando generar el valor por defecto implique operaciones costosas o consultas a BD.
FinEstructura"""
}
