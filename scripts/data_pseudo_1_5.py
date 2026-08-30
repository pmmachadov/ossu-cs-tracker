# -*- coding: utf-8 -*-
# Pseudocódigos para Exámenes 1 al 5

PSEUDO_1_5 = {
    # --- EXAMEN 1 ---
    "ex-java-01-11": """Algoritmo CalcularPromedio
    Definir notas Como Entero
    Dimension notas[4]
    notas[0] <- 4; notas[1] <- 7; notas[2] <- 3; notas[3] <- 9
    
    Definir media Como Real
    media <- calcular(notas, 4)
    Escribir "Media: ", media
FinAlgoritmo

Funcion media <- calcular(n, longitud)
    Definir suma, i Como Entero
    suma <- 0
    Para i <- 0 Hasta longitud - 1 Con Paso 1 Hacer
        suma <- suma + n[i]
    FinPara
    media <- suma / longitud
FinFuncion""",

    "ex-java-01-12": """Algoritmo TrazaPasoPorValor
    Definir a, b, c Como Entero
    a <- 3
    b <- 5
    c <- metodo(a, b)
    Escribir a, " ", b, " ", c  // Imprime: 3 5 30
FinAlgoritmo

Funcion res <- metodo(x, y)  // Recibe copias de los valores
    x <- x + 2               // x local pasa a ser 5
    y <- y + 1               // y local pasa a ser 6
    res <- x * y             // devuelve 30
FinFuncion""",

    "ex-java-01-13": """Algoritmo Multiplos3y5
    Definir n, suma, i Como Entero
    Escribir "n: "
    Leer n
    suma <- 0
    Para i <- 1 Hasta n - 1 Con Paso 1 Hacer
        Si (i MOD 3 = 0) O (i MOD 5 = 0) Entonces
            suma <- suma + i
        FinSi
    FinPara
    Escribir "Suma: ", suma
FinAlgoritmo""",

    "ex-java-01-14": """Algoritmo Primeros10Primos
    Definir encontrados, num Como Entero
    encontrados <- 0
    num <- 2
    Mientras encontrados < 10 Hacer
        Si esPrimo(num) Entonces
            Escribir num
            encontrados <- encontrados + 1
        FinSi
        num <- num + 1
    FinMientras
FinAlgoritmo

Funcion primo <- esPrimo(n)
    Definir i Como Entero
    Definir primo Como Logico
    Si n < 2 Entonces
        primo <- Falso
    Sino
        primo <- Verdadero
        i <- 2
        Mientras (i * i <= n) Y primo Hacer
            Si n MOD i = 0 Entonces
                primo <- Falso
            FinSi
            i <- i + 1
        FinMientras
    FinSi
FinFuncion""",

    "ex-java-01-15": """Algoritmo CalculadoraMenu
    Definir opcion Como Entero
    Definir a, b Como Real
    Repetir
        Escribir "1.Sumar 2.Restar 3.Multiplicar 4.Dividir 0.Salir"
        Leer opcion
        Si opcion <> 0 Entonces
            Escribir "Ingrese a y b: "
            Leer a, b
            Segun opcion Hacer
                1: Escribir "Suma: ", (a + b)
                2: Escribir "Resta: ", (a - b)
                3: Escribir "Prod: ", (a * b)
                4: Si b = 0 Entonces
                       Escribir "División entre cero"
                   Sino
                       Escribir "Div: ", (a / b)
                   FinSi
                De Otro Modo:
                   Escribir "Opción no válida"
            FinSegun
        FinSi
    Hasta Que opcion = 0
FinAlgoritmo""",

    "ex-java-01-16": """Algoritmo DemostracionPasoParametros
    // 1. Tipos primitivos: copia exacta del valor
    Definir num Como Entero
    num <- 10
    modificarPrimitivo(num)
    Escribir "num = ", num           // Sigue siendo 10
    
    // 2. Objetos / Arrays: copia de la referencia
    // Modificar atributos internos afecta al objeto original
    // Reasignar la referencia solo cambia la variable local
FinAlgoritmo

SubProceso modificarPrimitivo(copia)
    copia <- 99  // No afecta a la variable original fuera
FinSubProceso""",

    "ex-java-01-17": """Algoritmo ComparacionBucles
    // Bucle MIENTRAS (While): Evalúa condición antes de entrar (0..N vueltas)
    Mientras condicion Hacer
        // Acciones
    FinMientras

    // Bucle REPETIR-HASTA QUE / HACER-MIENTRAS (Do-While): Al menos 1 vuelta obligatoria
    Repetir
        // Acciones (p. ej. mostrar menú y pedir opción)
    Hasta Que condicionSalida

    // Bucle PARA (For): Rango determinado con contador e incremento conocido
    Para i <- 0 Hasta N - 1 Con Paso 1 Hacer
        // Acciones
    FinPara
FinAlgoritmo""",

    # --- EXAMEN 2 ---
    "ex-java-02-11": """Algoritmo ArraysSuma
    Definir nums, i, total Como Entero
    Dimension nums[5]
    nums[0] <- 3; nums[1] <- 1; nums[2] <- 4; nums[3] <- 1; nums[4] <- 5
    
    total <- suma(nums, 5)
    Escribir total
    Escribir "[", nums[0], ", ", nums[1], ", ", nums[2], ", ", nums[3], ", ", nums[4], "]"
FinAlgoritmo

Funcion t <- suma(n, longitud)
    Definir t, i Como Entero
    t <- 0
    Para i <- 0 Hasta longitud - 1 Con Paso 1 Hacer
        t <- t + n[i]
    FinPara
FinFuncion""",

    "ex-java-02-12": """Algoritmo TrazaMatriz
    Definir m Como Entero
    Dimension m[3, 2]
    m[0,0] <- 1; m[0,1] <- 2
    m[1,0] <- 3; m[1,1] <- 4
    m[2,0] <- 5; m[2,1] <- 6
    
    Escribir "F: 3"
    Escribir "C: 2"
    Escribir m[2,1] - m[0,0] // 6 - 1 = 5
    
    Para i <- 0 Hasta 2 Con Paso 1 Hacer
        Escribir Sin Saltar m[i, i MOD 2], " "
    FinPara
    // Imprime: 1 4 5
FinAlgoritmo""",

    "ex-java-02-13": """Algoritmo InvertirPalabrasCadena
    Definir texto, invertido Como Cadena
    Definir i Como Entero
    Escribir "Introduce una frase: "
    Leer texto
    
    invertido <- ""
    Para i <- Longitud(texto) Hasta 1 Con Paso -1 Hacer
        invertido <- invertido + Subcadena(texto, i, i)
    FinPara
    Escribir "Invertida: ", invertido
FinAlgoritmo""",

    "ex-java-02-14": """Algoritmo MayorYMenorArray
    Definir n, i, mayor, menor Como Entero
    Definir arr Como Entero
    Dimension arr[10]
    
    Escribir "Introduce 10 enteros:"
    Para i <- 0 Hasta 9 Con Paso 1 Hacer
        Leer arr[i]
    FinPara
    
    mayor <- arr[0]
    menor <- arr[0]
    Para i <- 1 Hasta 9 Con Paso 1 Hacer
        Si arr[i] > mayor Entonces
            mayor <- arr[i]
        FinSi
        Si arr[i] < menor Entonces
            menor <- arr[i]
        FinSi
    FinPara
    
    Escribir "Máximo: ", mayor, ", Mínimo: ", menor
FinAlgoritmo""",

    "ex-java-02-15": """Algoritmo SumarMatrices
    Definir A, B, C, f, c Como Entero
    Dimension A[3, 3], B[3, 3], C[3, 3]
    
    // Rellenar matrices A y B ...
    Para f <- 0 Hasta 2 Con Paso 1 Hacer
        Para c <- 0 Hasta 2 Con Paso 1 Hacer
            C[f, c] <- A[f, c] + B[f, c]
        FinPara
    FinPara
    
    // Mostrar matriz resultado C
    Para f <- 0 Hasta 2 Con Paso 1 Hacer
        Para c <- 0 Hasta 2 Con Paso 1 Hacer
            Escribir Sin Saltar C[f, c], " "
        FinPara
        Escribir ""
    FinPara
FinAlgoritmo""",

    "ex-java-02-16": """Algoritmo BurbujaYBusquedaBinaria
    Definir a Como Entero
    Dimension a[5]
    // Cargar datos en a ...
    
    // 1. Ordenación por Burbuja
    Para i <- 0 Hasta 3 Con Paso 1 Hacer
        Para j <- 0 Hasta 3 - i Con Paso 1 Hacer
            Si a[j] > a[j + 1] Entonces
                temp <- a[j]
                a[j] <- a[j + 1]
                a[j + 1] <- temp
            FinSi
        FinPara
    FinPara
    
    // 2. Búsqueda binaria
    pos <- busquedaBinaria(a, 5, clave)
FinAlgoritmo

Funcion pos <- busquedaBinaria(arr, n, clave)
    Definir ini, fin, medio, pos Como Entero
    ini <- 0
    fin <- n - 1
    pos <- -1
    Mientras (ini <= fin) Y (pos = -1) Hacer
        medio <- trunc((ini + fin) / 2)
        Si arr[medio] = clave Entonces
            pos <- medio
        Sino
            Si arr[medio] < clave Entonces
                ini <- medio + 1
            Sino
                fin <- medio - 1
            FinSi
        FinSi
    FinMientras
FinFuncion""",

    "ex-java-02-17": """Algoritmo LogicaBusquedaBinaria
    // La búsqueda binaria requiere que la lista esté ORDENADA.
    // En cada iteración calcula el punto medio:
    //   medio <- (inicio + fin) / 2
    // Si arr[medio] = elemento buscado -> ENCONTRADO
    // Si arr[medio] < buscado -> descarta mitad izquierda: inicio <- medio + 1
    // Si arr[medio] > buscado -> descarta mitad derecha: fin <- medio - 1
    // Complejidad temporal: O(log n) frente a O(n) lineal
FinAlgoritmo""",

    # --- EXAMEN 3 ---
    "ex-java-03-11": """Clase CuentaBancaria
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
FinClase""",

    "ex-java-03-12": """Clase Contador
    Atributos:
        Estatico total Como Entero <- 0  // Compartido por todas las instancias
        Instancia valor Como Entero <- 0 // Propio de cada objeto
        
    Constructor()
        total <- total + 1
        valor <- total
    FinConstructor
FinClase

Algoritmo PruebaContador
    c1 <- Nuevo Contador() // total=1, c1.valor=1
    c2 <- Nuevo Contador() // total=2, c2.valor=2
    c3 <- Nuevo Contador() // total=3, c3.valor=3
    Escribir "v=", c1.valor, " tot=", Contador.total // v=1 tot=3
FinAlgoritmo""",

    "ex-java-03-13": """Clase Rectangulo
    Atributos:
        Privado ancho Como Real
        Privado alto Como Real
        
    Constructor(p_ancho, p_alto)
        ancho <- p_ancho
        alto <- p_alto
    FinConstructor
    
    Metodo area() -> Real
        Devolver ancho * alto
    FinMetodo
    
    Metodo perimetro() -> Real
        Devolver 2 * (ancho + alto)
    FinMetodo
FinClase""",

    "ex-java-03-14": """Clase Estudiante
    Atributos:
        Privado nombre Como Cadena
        Privado edad Como Entero
        Privado notas Como ListaDeReales
        
    Constructor(p_nombre, p_edad)
        nombre <- p_nombre
        edad <- p_edad
        notas <- Nueva Lista()
    FinConstructor
    
    Metodo agregarNota(nota)
        notas.agregar(nota)
    FinMetodo
    
    Metodo media() -> Real
        Si notas.longitud() = 0 Entonces
            Devolver 0.0
        FinSi
        Definir suma Como Real <- 0.0
        Para Cada n En notas Hacer
            suma <- suma + n
        FinPara
        Devolver suma / notas.longitud()
    FinMetodo
FinClase""",

    "ex-java-03-15": """Clase CuentaBancariaConId
    Atributos:
        Privado titular Como Cadena
        Privado saldo Como Real
        Privado numeroCuenta Como Entero
        Estatico Privado contadorCuentas Como Entero <- 1000
        
    Constructor(p_titular, p_saldoInicial)
        titular <- p_titular
        saldo <- p_saldoInicial
        contadorCuentas <- contadorCuentas + 1
        numeroCuenta <- contadorCuentas
    FinConstructor
    
    Metodo transferir(destino, cantidad) -> Logico
        Si (cantidad > 0) Y (saldo >= cantidad) Entonces
            saldo <- saldo - cantidad
            destino.ingresar(cantidad)
            Devolver Verdadero
        FinSi
        Devolver Falso
    FinMetodo
FinClase""",

    "ex-java-03-16": """Estructura Encapsulacion
    // La encapsulación agrupa datos (atributos) y métodos en una entidad (clase)
    // y restringe el acceso directo al estado interno.
    // 
    // Principio:
    // 1. Atributos 'Privados': impiden modificaciones externas descontroladas.
    // 2. Métodos 'Públicos' (Getters/Setters): proporcionan validación y control.
FinEstructura""",

    # --- EXAMEN 4 ---
    "ex-java-04-11": """Clase Abstracta Vehiculo
    Metodo Abstracto mover()
FinClase

Clase Coche HeredaDe Vehiculo
    Sobrescribir Metodo mover()
        Escribir "El coche rueda"
    FinMetodo
FinClase

Algoritmo ProbarHerencia
    Definir v Como Vehiculo
    v <- Nuevo Coche()  // Polimorfismo
    v.mover()
FinAlgoritmo""",

    "ex-java-04-12": """Clase Abstracta Figura
    Metodo Abstracto area() -> Real
FinClase

Clase Circulo HeredaDe Figura
    Atributo radio Como Real
    Sobrescribir Metodo area() -> Real
        Devolver PI * radio * radio
    FinMetodo
FinClase

Clase Cuadrado HeredaDe Figura
    Atributo lado Como Real
    Sobrescribir Metodo area() -> Real
        Devolver lado * lado
    FinMetodo
FinClase

Algoritmo PolimorfismoFiguras
    Definir figuras Como ArregloDeFiguras
    figuras[0] <- Nuevo Circulo(2)   // area = 12.566
    figuras[1] <- Nuevo Cuadrado(3)  // area = 9.0
    Para Cada f En figuras Hacer
        Escribir f.area()
    FinPara
FinAlgoritmo""",

    "ex-java-04-13": """Clase Empleado
    Atributos: nombre Como Cadena, salarioBase Como Real
    Constructor(p_nombre, p_salarioBase)
        nombre <- p_nombre; salarioBase <- p_salarioBase
    FinConstructor
    Metodo calcularSalario() -> Real
        Devolver salarioBase
    FinMetodo
FinClase

Clase Gerente HeredaDe Empleado
    Atributo bono Como Real
    Constructor(p_nombre, p_salarioBase, p_bono)
        Super(p_nombre, p_salarioBase)
        bono <- p_bono
    FinConstructor
    Sobrescribir Metodo calcularSalario() -> Real
        Devolver Super.calcularSalario() + bono
    FinMetodo
FinClase""",

    "ex-java-04-14": """Interfaz Movible
    Metodo moverse()
FinInterfaz

Interfaz Sonoro
    Metodo sonar()
FinInterfaz

Clase Robot Implementa Movible, Sonoro
    Metodo moverse()
        Escribir "Robot avanzando sobre ruedas"
    FinMetodo
    Metodo sonar()
        Escribir "Beep beep!"
    FinMetodo
FinClase""",

    "ex-java-04-15": """Clase Abstracta Instrumento
    Estatico total Como Entero <- 0
    Constructor()
        total <- total + 1
    FinConstructor
    Metodo Abstracto tocar()
FinClase

Clase Guitarra HeredaDe Instrumento
    Metodo tocar()
        Escribir "Strum guitarra"
    FinMetodo
FinClase

Clase Piano HeredaDe Instrumento
    Metodo tocar()
        Escribir "Notas piano"
    FinMetodo
FinClase""",

    "ex-java-04-16": """Estructura ClaseAbstractaVsInterfaz
    // CLASE ABSTRACTA:
    // - Puede tener constructores, atributos de instancia y métodos con código.
    // - Java solo permite HERENCIA SIMPLE (extends 1 sola clase).
    // - Modela una relación "ES UN" (ej: Perro ES UN Animal).
    //
    // INTERFAZ:
    // - Define un contrato de comportamiento (capacidades).
    // - Permite HERENCIA MÚLTIPLE (implements muchas interfaces).
    // - Modela una relación "PUEDE HACER" (ej: Robot PUEDE Movible, Sonoro).
FinEstructura""",

    # --- EXAMEN 5 ---
    "ex-java-05-11": """Algoritmo LeerArchivoSeguro
    Definir lector Como FlujoLectura
    Intentar
        lector <- AbrirArchivo("datos.txt")
        Mientras No FinDeArchivo(lector) Hacer
            linea <- LeerLinea(lector)
            Escribir linea
        FinMientras
    Capturar ExcepcionIO e
        Escribir "Error al leer archivo: ", e.mensaje
    Finalmente
        Si lector <> Nulo Entonces
            Cerrar(lector)
        FinSi
    FinIntentar
FinAlgoritmo""",

    "ex-java-05-12": """Funcion res <- dividir(a, b)
    Intentar
        res <- a / b
        Escribir "division exitosa"
        Devolver res
    Capturar ExcepcionDivisionPorCero e
        Escribir "capturada excepcion"
        Devolver 0
    Finalmente
        Escribir "bloque finally siempre ejecuta"
    FinIntentar
FinFuncion""",

    "ex-java-05-13": """Algoritmo GestionAlumnosFichero
    Definir archivo Como FlujoLectura
    Definir totalAlumnos, aprobados Como Entero
    Definir sumaNotas, nota Como Real
    
    totalAlumnos <- 0
    aprobados <- 0
    sumaNotas <- 0.0
    
    archivo <- Abrir("alumnos.txt")
    Mientras HayMasLineas(archivo) Hacer
        nombre <- LeerCadena(archivo)
        nota <- LeerReal(archivo)
        totalAlumnos <- totalAlumnos + 1
        sumaNotas <- sumaNotas + nota
        Si nota >= 5.0 Entonces
            aprobados <- aprobados + 1
        FinSi
    FinMientras
    Cerrar(archivo)
    
    Escribir "Media global: ", (sumaNotas / totalAlumnos)
    Escribir "Aprobados: ", aprobados
FinAlgoritmo""",

    "ex-java-05-14": """Algoritmo MapaCiudadesHabitantes
    Definir habitantes Como Diccionario // Clave: Ciudad (Texto), Valor: Entero
    habitantes <- Nuevo Diccionario()
    
    habitantes.insertar("Madrid", 3300000)
    habitantes.insertar("Barcelona", 1600000)
    habitantes.insertar("Valencia", 800000)
    
    Para Cada ciudad En habitantes.claves() Hacer
        Escribir ciudad, " -> ", habitantes.obtener(ciudad), " habitantes"
    FinPara
FinAlgoritmo""",

    "ex-java-05-15": """SubProceso validarHora(h, m, s)
    Si (h < 0 O h > 23) O (m < 0 O m > 59) O (s < 0 O s > 59) Entonces
        Lanzar ExcepcionHoraInvalida("Formato de hora incorrecto")
    FinSi
    Escribir "Hora válida: ", h, ":", m, ":", s
FinSubProceso""",

    "ex-java-05-16": """Estructura ColeccionesJava
    // ARRAYLIST:
    // - Lista ordenada basada en arrays dinámicos.
    // - Admite elementos duplicados y acceso por índice O(1).
    //
    // HASHSET:
    // - Conjunto sin orden específico. NO permite duplicados.
    // - Búsqueda, inserción y eliminación rápidas O(1).
    //
    // HASHMAP:
    // - Estructura clave-valor. Claves únicas (sin duplicados).
    // - Búsqueda ultra rápida por clave O(1).
FinEstructura"""
}
