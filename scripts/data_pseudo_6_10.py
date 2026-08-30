# -*- coding: utf-8 -*-
# Pseudocódigos para Exámenes 6 al 10

PSEUDO_6_10 = {
    # --- EXAMEN 6 ---
    "ex-java-06-09": """Algoritmo CorregirEqualsPersona
    // Para comparar correctamente objetos en Java se debe sobrescribir equals(Object o)
    Clase Persona
        Atributos: nombre Como Cadena, edad Como Entero
        
        Constructor(p_nombre, p_edad)
            nombre <- p_nombre; edad <- p_edad
        FinConstructor
        
        Sobrescribir Metodo esIgualA(otro) -> Logico
            Si esteObjeto = otro Entonces Devolver Verdadero FinSi
            Si otro EsNulo O No EsTipo(otro, Persona) Entonces Devolver Falso FinSi
            Definir p Como Persona <- Convertir(otro, Persona)
            Devolver (edad = p.edad) Y (nombre = p.nombre)
        FinMetodo
    FinClase
FinAlgoritmo""",

    "ex-java-06-10": """Algoritmo PolimorfismoAnimales
    // Vector de referencias de clase base Animal
    Definir granja Como ArregloDeAnimales
    granja[0] <- Nuevo Perro()
    granja[1] <- Nuevo Gato()
    granja[2] <- Nuevo Animal()
    
    // Enlace dinámico: ejecuta el método del objeto real
    granja[0].hacerSonido() // Imprime: Guau
    granja[1].hacerSonido() // Imprime: Miau
    granja[2].hacerSonido() // Imprime: Sonido generico
FinAlgoritmo""",

    "ex-java-06-11": """Clase Vehiculo
    Atributos: matricula Como Cadena, marca Como Cadena, tarifaBase Como Real
    Constructor(p_mat, p_marca, p_tarifa)
        matricula <- p_mat; marca <- p_marca; tarifaBase <- p_tarifa
    FinConstructor
    Metodo calcularAlquiler(dias) -> Real
        Devolver tarifaBase * dias
    FinMetodo
FinClase

Clase Coche HeredaDe Vehiculo
    Atributo plazas Como Entero
    Constructor(p_mat, p_marca, p_tarifa, p_plazas)
        Super(p_mat, p_marca, p_tarifa)
        plazas <- p_plazas
    FinConstructor
    Sobrescribir Metodo calcularAlquiler(dias) -> Real
        Devolver Super.calcularAlquiler(dias) + (plazas * 1.5 * dias)
    FinMetodo
FinClase""",

    "ex-java-06-12": """Interfaz Imprimible
    Metodo imprimir()
FinInterfaz

Interfaz ExportableJSON
    Metodo exportarJSON() -> Cadena
FinInterfaz

Clase Factura Implementa Imprimible, ExportableJSON
    Atributo numero Como Entero, total Como Real
    Metodo imprimir()
        Escribir "Factura #", numero, " Total: ", total
    FinMetodo
    Metodo exportarJSON() -> Cadena
        Devolver "{'numero': " + numero + ", 'total': " + total + "}"
    FinMetodo
FinClase""",

    "ex-java-06-13": """Algoritmo GestionFigurasColeccion
    Definir figuras Como ListaDeFiguras
    figuras <- Nueva Lista()
    
    figuras.agregar(Nuevo Circulo(5.0))
    figuras.agregar(Nuevo Rectangulo(4.0, 6.0))
    figuras.agregar(Nuevo Triangulo(3.0, 8.0))
    
    Definir sumaAreas Como Real <- 0.0
    Para Cada fig En figuras Hacer
        sumaAreas <- sumaAreas + fig.calcularArea()
    FinPara
    Escribir "Área total acumulada: ", sumaAreas
FinAlgoritmo""",

    "ex-java-06-14": """Algoritmo JerarquiaEmpresa
    Clase Empleado
        Atributo nombre Como Cadena, sueldo Como Real
    FinClase
    
    Clase Desarrollador HeredaDe Empleado
        Atributo lenguajePrincipal Como Cadena
    FinClase
    
    Clase Disenador HeredaDe Empleado
        Atributo herramienta Como Cadena
    FinClase
FinAlgoritmo""",

    "ex-java-06-15": """Estructura HerenciaVsComposicion
    // HERENCIA ("Es un"):
    // Coche ES UN Vehículo. Permite reutilizar código pero genera alto acoplamiento.
    //
    // COMPOSICIÓN ("Tiene un"):
    // Coche TIENE UN Motor. Mayor flexibilidad, desacoplamiento y sustitución dinámica.
    // Regla de diseño: "Favorecer la composición sobre la herencia".
FinEstructura""",

    # --- EXAMEN 7 ---
    "ex-java-07-09": """Algoritmo CorreccionTryCatchFinally
    Intentar
        Definir res Como Entero
        res <- 10 / 0  // Genera ExcepcionAritmetica
        Escribir "Resultado: ", res
    Capturar ExcepcionAritmetica e
        Escribir "Error: No se puede dividir entre cero"
    Finalmente
        Escribir "Limpieza de recursos y cierre garantizado"
    FinIntentar
FinAlgoritmo""",

    "ex-java-07-10": """Algoritmo TrazaManejoExcepciones
    Definir arr Como Entero
    Dimension arr[3]
    Intentar
        arr[5] <- 100 // Error: Fuera de rango
    Capturar ExcepcionIndiceFueraDeRango e
        Escribir "Índice no válido"
    Capturar Excepcion e
        Escribir "Error genérico"
    Finalmente
        Escribir "Fin de bloque"
    FinIntentar
    // Salida: Índice no válido -> Fin de bloque
FinAlgoritmo""",

    "ex-java-07-11": """SubProceso retirarSaldoSeguro(saldoActual, cantidad)
    Si cantidad <= 0 Entonces
        Lanzar ExcepcionArgumentoInvalido("La cantidad debe ser positiva")
    FinSi
    Si cantidad > saldoActual Entonces
        Lanzar ExcepcionSaldoInsuficiente("Fondos insuficientes en cuenta")
    FinSi
    saldoActual <- saldoActual - cantidad
    Devolver saldoActual
FinSubProceso""",

    "ex-java-07-12": """Algoritmo ValidarFormularioRegistro
    Intentar
        Escribir "Introduce edad: "
        Leer edad
        Si edad < 18 O edad > 120 Entonces
            Lanzar ExcepcionEdadInvalida("Edad fuera de rango permitido")
        FinSi
        
        Escribir "Introduce email: "
        Leer email
        Si No Contiene(email, "@") Entonces
            Lanzar ExcepcionEmailInvalido("Formato de correo no válido")
        FinSi
        
        Escribir "Usuario registrado con éxito"
    Capturar ExcepcionValidacion e
        Escribir "Error en validación: ", e.mensaje
    FinIntentar
FinAlgoritmo""",

    "ex-java-07-13": """Algoritmo FlujoLecturaConRecursos
    // En Java se usa try-with-resources para autocierre
    AbrirRecurso(lector <- "datos.txt")
        Mientras HayLineas(lector) Hacer
            linea <- LeerLinea(lector)
            Escribir linea
        FinMientras
    FinAbrirRecurso // Cierre automático del flujo incluso si hay error
FinAlgoritmo""",

    "ex-java-07-14": """Algoritmo ReintentosConExcepcion
    Definir intentos Como Entero <- 0
    Definir conectado Como Logico <- Falso
    Mientras (intentos < 3) Y (No conectado) Hacer
        Intentar
            conectarServidor()
            conectado <- Verdadero
            Escribir "Conexión exitosa"
        Capturar ExcepcionConexion e
            intentos <- intentos + 1
            Escribir "Fallo de conexión. Intento ", intentos, " de 3"
        FinIntentar
    FinMientras
FinAlgoritmo""",

    "ex-java-07-15": """Estructura CheckedVsUnchecked
    // CHECKED EXCEPTIONS (Verificadas por compilador):
    // Heredan de Exception (ej: IOException, SQLException).
    // Obligan a tratarlas con try-catch o declararlas con throws.
    //
    // UNCHECKED EXCEPTIONS (No verificadas en compilación):
    // Heredan de RuntimeException (ej: NullPointerException, IndexOutOfBounds).
    // Suelen deberse a bugs de programación.
FinEstructura""",

    # --- EXAMEN 8 ---
    "ex-java-08-09": """Algoritmo CorregirConcurrenciaLista
    // En Java, modificar una lista mientras se itera con for-each lanza ConcurrentModificationException
    // Solución: usar un Iterador explícito y su método it.remove()
    Definir lista Como ListaDeCadenas
    Definir it Como Iterador
    it <- lista.obtenerIterador()
    Mientras it.tieneSiguiente() Hacer
        elemento <- it.siguiente()
        Si elemento = "borrar" Entonces
            it.eliminarActual() // Eliminación segura
        FinSi
    FinMientras
FinAlgoritmo""",

    "ex-java-08-10": """Algoritmo TrazaTreeSetOrdenado
    Definir conjunto Como ConjuntoTreeSet
    conjunto <- Nuevo ConjuntoTreeSet()
    
    conjunto.insertar("Juan")
    conjunto.insertar("Ana")
    conjunto.insertar("Pedro")
    conjunto.insertar("Ana") // Duplicado ignorado
    
    // TreeSet mantiene los elementos ordenados alfabéticamente
    // Salida: Ana, Juan, Pedro
FinAlgoritmo""",

    "ex-java-08-11": """Algoritmo FrecuenciaPalabrasTexto
    Definir mapaFrecuencias Como Diccionario // Clave: Palabra, Valor: Contador
    mapaFrecuencias <- Nuevo Diccionario()
    
    Definir palabras Como ArregloDeCadenas
    palabras <- DividirTexto(frase, " ")
    
    Para Cada p En palabras Hacer
        p <- AMinusculas(p)
        Si mapaFrecuencias.existeClave(p) Entonces
            mapaFrecuencias.asignar(p, mapaFrecuencias.obtener(p) + 1)
        Sino
            mapaFrecuencias.asignar(p, 1)
        FinSi
    FinPara
    
    Para Cada clave En mapaFrecuencias.claves() Hacer
        Escribir clave, ": ", mapaFrecuencias.obtener(clave), " veces"
    FinPara
FinAlgoritmo""",

    "ex-java-08-12": """Clase Generica Par<K, V>
    Atributos:
        Privado clave Como K
        Privado valor Como V
        
    Constructor(p_clave, p_valor)
        clave <- p_clave
        valor <- p_valor
    FinConstructor
    
    Metodo getClave() -> K
        Devolver clave
    FinMetodo
    
    Metodo getValor() -> V
        Devolver valor
    FinMetodo
FinClase""",

    "ex-java-08-13": """Algoritmo OrdenarAlumnosPorNota
    Definir listaAlumnos Como ListaDeAlumnos
    listaAlumnos <- Nueva Lista()
    // Añadir alumnos ...
    
    // Ordenar con comparador descendente por nota
    Ordenar(listaAlumnos, Criterio(a1, a2) -> a2.nota - a1.nota)
    
    Para Cada al En listaAlumnos Hacer
        Escribir al.nombre, " - Nota: ", al.nota
    FinPara
FinAlgoritmo""",

    "ex-java-08-14": """Algoritmo OrdenarPorLongitudYAlfabetico
    // Criterio de ordenación:
    // 1. Longitud de palabra ascendente
    // 2. Si empatan en longitud, orden alfabético
    Funcion comp <- compararPalabras(p1, p2)
        Si Longitud(p1) <> Longitud(p2) Entonces
            comp <- Longitud(p1) - Longitud(p2)
        Sino
            comp <- CompararTexto(p1, p2)
        FinSi
    FinFuncion
FinAlgoritmo""",

    "ex-java-08-15": """Estructura ComparativaColecciones
    // LIST (ArrayList, LinkedList):
    // Secuencia ordenada por posición. Permite duplicados. Acceso por índice.
    //
    // SET (HashSet, TreeSet):
    // Conjunto sin duplicados. HashSet: O(1) sin orden; TreeSet: orden natural O(log n).
    //
    // MAP (HashMap, TreeMap):
    // Pares clave-valor. Claves únicas. Búsqueda directa por clave.
FinEstructura""",

    # --- EXAMEN 9 ---
    "ex-java-09-09": """Algoritmo SerializacionCorregida
    // 1. La clase DEBE implementar Serializable
    // 2. Usar ObjectOutputStream envuelto sobre FileOutputStream
    Clase Persona Implementa Serializable
        Atributos: nombre Como Cadena, edad Como Entero
    FinClase
    
    Algoritmo GuardarObjeto
        Definir flujo Como FlujoObjetosSalida
        flujo <- AbrirFlujoObjetosSalida("persona.dat")
        flujo.escribirObjeto(Nueva Persona("Luis", 25))
        flujo.cerrar()
    FinAlgoritmo
FinAlgoritmo""",

    "ex-java-09-10": """Algoritmo TrazaLecturaBinaria
    // En flujos DataOutputStream/DataInputStream los datos se leen
    // en el MISMO ORDEN y con los MISMOS TIPOS que se escribieron:
    // 1. in.readInt()      -> recupera entero (4 bytes)
    // 2. in.readDouble()   -> recupera decimal (8 bytes)
    // 3. in.readUTF()      -> recupera cadena de texto
FinAlgoritmo""",

    "ex-java-09-11": """Algoritmo GuardarListaObjetosBinario
    Definir lista Como ListaDePersonas
    lista <- Nueva Lista()
    lista.agregar(Nueva Persona("Ana", 20))
    lista.agregar(Nueva Persona("Carlos", 30))
    
    // Guardar lista completa
    Definir salida Como FlujoObjetosSalida
    salida <- AbrirFlujoObjetos("personas.dat")
    salida.escribirObjeto(lista)
    salida.cerrar()
    
    // Recuperar lista completa
    Definir entrada Como FlujoObjetosEntrada
    entrada <- AbrirFlujoObjetosEntrada("personas.dat")
    Definir listaLeida Como ListaDePersonas
    listaLeida <- entrada.leerObjeto()
    entrada.cerrar()
FinAlgoritmo""",

    "ex-java-09-12": """Algoritmo CopiarFicheroBinarioBytes
    Definir origen, destino Como FlujoBytes
    Definir buffer Como ArregloDeBytes
    Dimension buffer[4096] // Bloque de 4 KB
    Definir bytesLeidos Como Entero
    
    origen <- AbrirFlujoLectura("origen.jpg")
    destino <- AbrirFlujoEscritura("copia.jpg")
    
    bytesLeidos <- origen.leer(buffer)
    Mientras bytesLeidos <> -1 Hacer
        destino.escribir(buffer, 0, bytesLeidos)
        bytesLeidos <- origen.leer(buffer)
    FinMientras
    
    origen.cerrar()
    destino.cerrar()
FinAlgoritmo""",

    "ex-java-09-13": """Algoritmo GuardarYLeerDoublesBinario
    Definir datos Como DataOutputStream
    datos <- AbrirDataOutput("numeros.bin")
    Para i <- 1 Hasta 5 Con Paso 1 Hacer
        Leer valorDouble
        datos.escribirDouble(valorDouble)
    FinPara
    datos.cerrar()
    
    // Lectura
    Definir lector Como DataInputStream
    lector <- AbrirDataInput("numeros.bin")
    Para i <- 1 Hasta 5 Con Paso 1 Hacer
        Escribir lector.leerDouble()
    FinPara
    lector.cerrar()
FinAlgoritmo""",

    "ex-java-09-14": """Algoritmo ProcesarCSVConNIO
    Definir lineas Como ListaDeCadenas
    lineas <- ArchivosNIO.leerTodasLasLineas("alumnos.csv")
    
    Definir sumaNotas Como Real <- 0.0
    Definir total Como Entero <- 0
    
    Para Cada linea En lineas Hacer
        partes <- DividirTexto(linea, ";")
        nombre <- partes[0]
        nota <- ConvertirAReal(partes[1])
        sumaNotas <- sumaNotas + nota
        total <- total + 1
    FinPara
    
    Escribir "Nota media del curso: ", (sumaNotas / total)
FinAlgoritmo""",

    "ex-java-09-15": """Estructura FicherosTextoVsBinarios
    // FICHEROS DE TEXTO:
    // Representación en caracteres legibles (ASCII/UTF-8).
    // Facilidad de lectura humana, pero requiere parseo de tipos.
    //
    // FICHEROS BINARIOS:
    // Representación directa en bytes idéntica a memoria.
    // Mayor velocidad de E/S, menor tamaño y sin pérdida de precisión.
FinEstructura""",

    # --- EXAMEN 10 ---
    "ex-java-10-09": """Algoritmo CorregirStreamPipeline
    // En Java Streams:
    // 1. mapToInt() permite operaciones numéricas como sum() o average()
    // 2. Un stream no se puede reutilizar tras invocar una operación terminal
    Definir numeros Como ListaDeEnteros
    Definir sumaPares Como Entero
    sumaPares <- numeros.filtrar(n -> n MOD 2 = 0).sumar()
    Escribir "Suma: ", sumaPares
FinAlgoritmo""",

    "ex-java-10-10": """Algoritmo TrazaStreamPipeline
    // Lista inicial: ["Pedro", "Ana", "Eva", "Beatriz", "Alba"]
    // 1. filter(s -> longitud >= 3) -> Mantiene todas
    // 2. sorted() -> ["Alba", "Ana", "Beatriz", "Eva", "Pedro"]
    // 3. limit(3) -> ["Alba", "Ana", "Beatriz"]
    // 4. map(s -> A_Mayusculas(s)) -> ["ALBA", "ANA", "BEATRIZ"]
FinAlgoritmo""",

    "ex-java-10-11": """Algoritmo OperacionesStreamNumeros
    Definir numeros Como ListaDeEnteros
    // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    
    // 1. Filtrar pares
    // 2. Elevar al cuadrado
    // 3. Obtener suma
    Definir sumaCuadradosPares Como Entero
    sumaCuadradosPares <- numeros.filtrar(n -> n MOD 2 = 0)
                                 .transformar(n -> n * n)
                                 .sumar()
    Escribir "Resultado: ", sumaCuadradosPares
FinAlgoritmo""",

    "ex-java-10-12": """Algoritmo FiltrarAlumnosAprobadosStream
    Definir alumnos Como ListaDeAlumnos
    Definir nombresAprobados Como ListaDeCadenas
    
    nombresAprobados <- alumnos.filtrar(a -> a.nota >= 5.0)
                               .ordenarPor(a -> a.nombre)
                               .transformar(a -> a.nombre)
                               .recolectarEnLista()
                               
    Para Cada nom En nombresAprobados Hacer
        Escribir nom
    FinPara
FinAlgoritmo""",

    "ex-java-10-13": """Funcion alumnoOpt <- buscarAlumnoPorNombre(alumnos, nombreBuscado)
    // Devuelve Optional con el alumno si existe o vacío si no
    Para Cada al En alumnos Hacer
        Si al.nombre = nombreBuscado Entonces
            Devolver OpcionalConValor(al)
        FinSi
    FinPara
    Devolver OpcionalVacio()
FinFuncion""",

    "ex-java-10-14": """Algoritmo CalculoEdadConJavaTime
    Definir fechaNacimiento, hoy Como Fecha
    Escribir "Introduce fecha (AAAA-MM-DD): "
    Leer textoFecha
    
    fechaNacimiento <- ParsearFecha(textoFecha)
    hoy <- FechaActual()
    
    Definir periodo Como Periodo
    periodo <- CalcularDiferenciaFechas(fechaNacimiento, hoy)
    
    Escribir "Tienes ", periodo.anios, " años, ", periodo.meses, " meses y ", periodo.dias, " días"
FinAlgoritmo""",

    "ex-java-10-15": """Estructura LambdasEInterfacesFuncionales
    // EXPRESIÓN LAMBDA:
    // Función anónima concisa: (parámetros) -> expresión
    //
    // INTERFAZ FUNCIONAL:
    // Interfaz con UN ÚNICO método abstracto (anotada con @FunctionalInterface).
    // Ejemplos estándar de Java:
    // - Predicate<T>: T -> boolean (filtrar)
    // - Function<T, R>: T -> R (transformar/map)
    // - Consumer<T>: T -> void (ejecutar acción)
    // - Supplier<T>: () -> T (proveer valor)
FinEstructura"""
}
