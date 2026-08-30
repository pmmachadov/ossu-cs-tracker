# -*- coding: utf-8 -*-
# Pseudocódigos para Exámenes 11 al 15

PSEUDO_11_15 = {
    # --- EXAMEN 11 ---
    "ex-java-11-11": """Algoritmo CorregirCondicionCarrera
    // Para evitar condiciones de carrera al incrementar un contador compartido por hilos
    // se debe sincronizar la sección crítica o usar AtomicInteger
    Clase ContadorSincronizado
        Privado cuenta Como Entero <- 0
        
        Metodo Sincronizado incrementar()
            cuenta <- cuenta + 1
        FinMetodo
        
        Metodo obtenerValor() -> Entero
            Devolver cuenta
        FinMetodo
    FinClase
FinAlgoritmo""",

    "ex-java-11-12": """Algoritmo TrazaJoinHilos
    // t.start() inicia la ejecución concurrente del hilo
    // t.join() BLOQUEA el hilo principal hasta que 't' termina su ejecución
    Definir hilo Como Hilo
    hilo <- IniciarHilo(TareaImprimir1a100)
    EsperarAQueTermine(hilo) // join()
    Escribir "Hilo secundario finalizado. Continuando main..."
FinAlgoritmo""",

    "ex-java-11-13": """Algoritmo DosHilosParesImpares
    // Hilo 1: imprime impares del 1 al 19
    // Hilo 2: imprime pares del 2 al 20
    IniciarHiloEnParalelo(
        Para i <- 1 Hasta 19 Con Paso 2 Hacer Escribir "Impar: ", i FinPara
    )
    IniciarHiloEnParalelo(
        Para i <- 2 Hasta 20 Con Paso 2 Hacer Escribir "Par: ", i FinPara
    )
FinAlgoritmo""",

    "ex-java-11-14": """Algoritmo ProductorConsumidorConBuffer
    Clase BufferSincronizado
        Privado dato Como Entero
        Privado disponible Como Logico <- Falso
        
        Metodo Sincronizado producir(valor)
            Mientras disponible Hacer
                Esperar() // wait()
            FinMientras
            dato <- valor
            disponible <- Verdadero
            NotificarATodos() // notifyAll()
        FinMetodo
        
        Metodo Sincronizado consumir() -> Entero
            Mientras No disponible Hacer
                Esperar() // wait()
            FinMientras
            disponible <- Falso
            NotificarATodos()
            Devolver dato
        FinMetodo
    FinClase
FinAlgoritmo""",

    "ex-java-11-15": """Algoritmo SumaConcurrenteExecutor
    // Dividir un array de 1000 elementos en 4 partes y sumar con un pool de hilos
    Definir pool Como PoolDe4Hilos
    Definir sumaTotal Como Entero <- 0
    
    sumaPart1 <- pool.ejecutarTarea(SumarRango(arr, 0, 249))
    sumaPart2 <- pool.ejecutarTarea(SumarRango(arr, 250, 499))
    sumaPart3 <- pool.ejecutarTarea(SumarRango(arr, 500, 749))
    sumaPart4 <- pool.ejecutarTarea(SumarRango(arr, 750, 999))
    
    sumaTotal <- sumaPart1.obtener() + sumaPart2.obtener() + sumaPart3.obtener() + sumaPart4.obtener()
    Escribir "Suma total concurrente: ", sumaTotal
FinAlgoritmo""",

    "ex-java-11-16": """Estructura ConcurrenciaHilos
    // THREAD vs RUNNABLE:
    // - extends Thread: gasta la única herencia de Java.
    // - implements Runnable: desacopla la tarea de la ejecución, permitiendo heredar de otra clase.
    //
    // SYNCHRONIZED vs VOLATILE:
    // - synchronized: exclusión mutua atómica para bloques críticos.
    // - volatile: garantiza visibilidad inmediata del valor en memoria principal para todos los hilos.
FinEstructura""",

    # --- EXAMEN 12 ---
    "ex-java-12-11": """Algoritmo PrevenirInyeccionSQL
    // VULNERABLE (Statement concatenado):
    // "SELECT * FROM usuarios WHERE user = '" + user + "' AND pass = '" + pass + "'"
    //
    // SEGURO (PreparedStatement parametrizado):
    Definir stmt Como PreparedStatement
    stmt <- conexion.prepararConsulta("SELECT * FROM usuarios WHERE user = ? AND pass = ?")
    stmt.establecerCadena(1, user)
    stmt.establecerCadena(2, pass)
    resultado <- stmt.ejecutarConsulta()
FinAlgoritmo""",

    "ex-java-12-12": """Algoritmo TrazaResultSetJDBC
    // rs.next() avanza el cursor a la siguiente fila.
    // Inicialmente el cursor apunta ANTES de la primera fila.
    // Devuelve 'Verdadero' si hay fila, o 'Falso' si llegó al final.
    Mientras rs.siguienteFila() Hacer
        id <- rs.obtenerEntero("id")
        nombre <- rs.obtenerCadena("nombre")
        Escribir id, " - ", nombre
    FinMientras
FinAlgoritmo""",

    "ex-java-12-13": """Algoritmo InsertarRegistroBD
    Intentar
        conexion <- Conectar("jdbc:mysql://localhost:3306/tienda", "user", "pass")
        stmt <- conexion.prepararConsulta("INSERT INTO productos (nombre, precio) VALUES (?, ?)")
        stmt.establecerCadena(1, "Teclado Mecánico")
        stmt.establecerReal(2, 49.99)
        filasAfectadas <- stmt.ejecutarActualizacion()
        Escribir "Filas insertadas: ", filasAfectadas
    Capturar ExcepcionSQL e
        Escribir "Error en BD: ", e.mensaje
    FinIntentar
FinAlgoritmo""",

    "ex-java-12-14": """Algoritmo ConsultarAlumnosAprobadosBD
    stmt <- conexion.prepararConsulta("SELECT nombre, nota FROM alumnos WHERE nota >= ?")
    stmt.establecerReal(1, 5.0)
    rs <- stmt.ejecutarConsulta()
    
    Mientras rs.siguienteFila() Hacer
        nom <- rs.obtenerCadena("nombre")
        nt <- rs.obtenerReal("nota")
        Escribir nom, " tiene nota: ", nt
    FinMientras
FinAlgoritmo""",

    "ex-java-12-15": """Algoritmo TransaccionBancariaJDBC
    Intentar
        conexion.desactivarAutocommit() // Inicia transacción manual
        
        stmtResta <- conexion.preparar("UPDATE cuentas SET saldo = saldo - ? WHERE id = ?")
        stmtResta.establecerReal(1, 100.0); stmtResta.establecerEntero(2, 1)
        stmtResta.ejecutar()
        
        stmtSuma <- conexion.preparar("UPDATE cuentas SET saldo = saldo + ? WHERE id = ?")
        stmtSuma.establecerReal(1, 100.0); stmtSuma.establecerEntero(2, 2)
        stmtSuma.ejecutar()
        
        conexion.confirmarTransaccion() // commit()
        Escribir "Transferencia completada con éxito"
    Capturar ExcepcionSQL e
        conexion.revertirTransaccion()  // rollback()
        Escribir "Error. Transferencia revertida"
    FinIntentar
FinAlgoritmo""",

    "ex-java-12-16": """Estructura VentajasJDBC
    // PREPAREDSTATEMENT:
    // 1. Inmunidad total a Inyección SQL mediante parámetros '?' tipados.
    // 2. Mayor rendimiento gracias a la precompilación y caché del plan de consulta en el motor.
    //
    // TRANSACCIÓN (ACID):
    // Agrupa múltiples operaciones como una unidad atómica (Todo o Nada).
    // Evita inconsistencias ante caídas o fallos de red.
FinEstructura""",

    # --- EXAMEN 13 ---
    "ex-java-13-11": """Algoritmo RegistrarActionListenerBoton
    // En Swing, para que un botón responda al clic debe registrarse su ActionListener
    Definir boton Como BotonSwing("Pulsar")
    boton.alHacerClic(Evento ->
        Escribir "Botón pulsado correctamente"
    )
FinAlgoritmo""",

    "ex-java-13-12": """Algoritmo ActualizarSwingEnEDT
    // Regla de oro en Swing: NUNCA actualizar componentes visuales fuera del EDT
    // Solución: Usar SwingUtilities.invokeLater()
    IniciarHiloSegundoPlano(
        // Tarea pesada en segundo plano ...
        resultado <- calcularDatosPesados()
        
        // Enviar actualización a la cola de la interfaz gráfica (EDT)
        EjecutarEnHiloEDT(
            etiquetaResultado.setTexto(resultado)
        )
    )
FinAlgoritmo""",

    "ex-java-13-13": """Ventana InvertirTextoSwing
    Componentes:
        campoTexto Como CampoDeTexto
        botonInvertir Como Boton("Invertir")
        etiquetaResultado Como Etiqueta
        
    Constructor()
        botonInvertir.alHacerClic(Evento ->
            cadenaOriginal <- campoTexto.obtenerTexto()
            cadenaInvertida <- InvertirCadena(cadenaOriginal)
            etiquetaResultado.establecerTexto(cadenaInvertida)
        )
    FinConstructor
FinVentana""",

    "ex-java-13-14": """Ventana MiniCalculadoraSwing
    Componentes:
        campoNum1, campoNum2 Como CampoDeTexto
        botonSumar Como Boton("Sumar")
        etiquetaResultado Como Etiqueta
        
    Constructor()
        botonSumar.alHacerClic(Evento ->
            Intentar
                n1 <- ParsearReal(campoNum1.obtenerTexto())
                n2 <- ParsearReal(campoNum2.obtenerTexto())
                etiquetaResultado.establecerTexto("Resultado: " + (n1 + n2))
            Capturar ExcepcionFormatoNumero e
                etiquetaResultado.establecerTexto("Error: Introduce números válidos")
            FinIntentar
        )
    FinConstructor
FinVentana""",

    "ex-java-13-15": """Ventana ContadorSwing
    Componentes:
        Privado valor Como Entero <- 0
        etiquetaValor Como Etiqueta("0")
        botonMas Como Boton("+1")
        botonMenos Como Boton("-1")
        
    Constructor()
        botonMas.alHacerClic(e ->
            valor <- valor + 1
            etiquetaValor.establecerTexto(ConvertirATexto(valor))
        )
        botonMenos.alHacerClic(e ->
            valor <- valor - 1
            etiquetaValor.establecerTexto(ConvertirATexto(valor))
        )
    FinConstructor
FinVentana""",

    "ex-java-13-16": """Estructura EventDispatchThread
    // EDT (Event Dispatch Thread):
    // Es el hilo único responsable de dibujar componentes y gestionar eventos en Swing.
    //
    // Peligros:
    // 1. Tarea pesada en el EDT -> Congela la interfaz (la ventana no responde).
    // 2. Modificar Swing desde otro hilo -> Provoca inconsistencias visuales y excepciones.
FinEstructura""",

    # --- EXAMEN 14 ---
    "ex-java-14-11": """Algoritmo ValidacionRegexEmailEstricta
    // Expresión regular con anclajes ^ (inicio) y $ (fin) para evitar coincidencias parciales:
    // Regex: ^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$
    Definir email Como Cadena
    Si EncajaRegexTotal(email, "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$") Entonces
        Escribir "Email completamente válido"
    Sino
        Escribir "Email no válido"
    FinSi
FinAlgoritmo""",

    "ex-java-14-12": """Algoritmo ExtraerTodosPreciosRegex
    // Para iterar sobre TODAS las coincidencias en un texto se usa un bucle MIENTRAS con matcher.find()
    Definir texto Como Cadena <- "Pan: 1,20€, Leche: 0,95€, Café: 2,50€"
    Definir matcher Como CoincidenciasRegex
    matcher <- BuscarPatron(texto, "\\d+,\\d{2}€")
    
    Mientras matcher.haySiguienteCoincidencia() Hacer
        Escribir "Precio detectado: ", matcher.obtenerCoincidencia()
    FinMientras
FinAlgoritmo""",

    "ex-java-14-13": """Algoritmo ValidarNIF
    Definir nif Como Cadena
    Definir tablaLetras Como Cadena <- "TRWAGMYFPDXBNJZSQVHLCKE"
    
    Escribir "Introduce NIF (8 dígitos + letra): "
    Leer nif
    
    Si EncajaRegex(nif, "^\\d{8}[A-Za-z]$") Entonces
        numDNI <- ConvertirAEntero(Subcadena(nif, 1, 8))
        letraUsuario <- Mayuscula(Subcadena(nif, 9, 9))
        letraCorrecta <- Subcadena(tablaLetras, (numDNI MOD 23) + 1, (numDNI MOD 23) + 1)
        
        Si letraUsuario = letraCorrecta Entonces
            Escribir "NIF correcto y válido"
        Sino
            Escribir "Letra incorrecta. Debería ser: ", letraCorrecta
        FinSi
    Sino
        Escribir "Formato de NIF incorrecto"
    FinSi
FinAlgoritmo""",

    "ex-java-14-14": """Algoritmo ExtraerPalabrasQueEmpiezanPorVocal
    Definir texto Como Cadena <- "El oso y el águila están en la isla"
    Definir matcher Como CoincidenciasRegex
    // Regex: \\b[aeiouáéíóúAEIOUÁÉÍÓÚ][a-zA-ZáéíóúÁÉÍÓÚ]*\\b
    matcher <- BuscarPatron(texto, "\\b[aeiouAEIOU][a-zA-Z]*\\b")
    
    Mientras matcher.haySiguienteCoincidencia() Hacer
        Escribir "Palabra con vocal inicial: ", matcher.obtenerCoincidencia()
    FinMientras
FinAlgoritmo""",

    "ex-java-14-15": """Algoritmo EnmascararTelefonos
    Definir texto Como Cadena <- "Llama al 612345678 o al 699001122 para informes"
    // Reemplaza números de 9 dígitos por ***-***-***
    Definir textoOculto Como Cadena
    textoOculto <- ReemplazarRegex(texto, "\\b\\d{9}\\b", "*********")
    Escribir textoOculto
FinAlgoritmo""",

    "ex-java-14-16": """Estructura MatchesVsFindRegex
    // MATCHES():
    // Comprueba si TODA la cadena encaja exactamente con el patrón (de extremo a extremo).
    //
    // FIND():
    // Busca subcadenas que encajen dentro del texto global (coincidencia parcial repetible).
    //
    // GRUPOS DE CAPTURA ():
    // Permiten extraer fragmentos específicos de la coincidencia (ej: día, mes y año en una fecha).
FinEstructura""",

    # --- EXAMEN 15 ---
    "ex-java-15-11": """Algoritmo CondicionBusquedaBinaria
    // ERROR COMÚN: Aplicar búsqueda binaria sobre datos desordenados
    Definir datos Como Entero
    Dimension datos[6]
    // datos desordenados: [45, 12, 85, 32, 89, 16]
    
    // 1. OBLIGATORIO: Ordenar antes de buscar
    Ordenar(datos) // [12, 16, 32, 45, 85, 89]
    
    // 2. Ahora sí funciona la búsqueda binaria
    pos <- BusquedaBinaria(datos, 16)
    Escribir "Elemento en posición: ", pos
FinAlgoritmo""",

    "ex-java-15-12": """Algoritmo OrdenarObjetosComparableVsComparator
    // OPCIÓN 1 (Comparable): La clase implementa compareTo(otra) definiendo su orden natural
    Clase Persona Implementa Comparable
        Metodo compararCon(otra) -> Entero
            Devolver esteObjeto.edad - otra.edad
        FinMetodo
    FinClase
    
    // OPCIÓN 2 (Comparator): Comparador externo personalizado
    Definir comparadorPorNombre Como Comparator
    comparadorPorNombre <- (p1, p2) -> CompararTexto(p1.nombre, p2.nombre)
FinAlgoritmo""",

    "ex-java-15-13": """Algoritmo OrdenacionPorSeleccion
    Definir a Como Entero
    Dimension a[n]
    Definir i, j, minIdx, aux Como Entero
    
    Para i <- 0 Hasta n - 2 Con Paso 1 Hacer
        minIdx <- i
        Para j <- i + 1 Hasta n - 1 Con Paso 1 Hacer
            Si a[j] < a[minIdx] Entonces
                minIdx <- j
            FinSi
        FinPara
        // Intercambiar el menor con el elemento en la posición i
        aux <- a[i]
        a[i] <- a[minIdx]
        a[minIdx] <- aux
    FinPara
FinAlgoritmo""",

    "ex-java-15-14": """Algoritmo OrdenarAlumnosPorNotaDescendente
    Definir listaAlumnos Como ListaDeAlumnos
    // Ordenar por nota descendente (de mayor a menor)
    Ordenar(listaAlumnos, (a1, a2) ->
        Si a2.nota > a1.nota Entonces Devolver 1
        Sino Si a2.nota < a1.nota Entonces Devolver -1
        Sino Devolver CompararTexto(a1.nombre, a2.nombre) FinSi
    )
FinAlgoritmo""",

    "ex-java-15-15": """Funcion pos <- busquedaBinariaRecursiva(a, objetivo, ini, fin)
    Si ini > fin Entonces
        pos <- -1 // Caso base: no encontrado
    Sino
        medio <- trunc((ini + fin) / 2)
        Si a[medio] = objetivo Entonces
            pos <- medio // Caso base: encontrado
        Sino
            Si a[medio] < objetivo Entonces
                pos <- busquedaBinariaRecursiva(a, objetivo, medio + 1, fin)
            Sino
                pos <- busquedaBinariaRecursiva(a, objetivo, ini, medio - 1)
            FinSi
        FinSi
    FinSi
FinFuncion""",

    "ex-java-15-16": """Estructura ComparativaAlgoritmosOrdenacion
    // BURBUJA:
    // Complejidad: O(n²) peor/medio, O(n) mejor. Estable: SÍ.
    //
    // SELECCIÓN:
    // Complejidad: O(n²) en todos los casos (siempre busca el mínimo). Estable: NO.
    //
    // INSERCIÓN:
    // Complejidad: O(n²) peor caso, O(n) si ya está casi ordenado. Estable: SÍ.
FinEstructura"""
}
