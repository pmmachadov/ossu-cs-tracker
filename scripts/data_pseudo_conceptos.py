# -*- coding: utf-8 -*-
# Pseudocódigos para Conceptos (ex-java-21-*)

PSEUDO_CONCEPTOS = {
    "ex-java-21-10": """Algoritmo OperadoresAritmeticos
    Definir a, b Como Entero
    a <- 10; b <- 3
    
    Escribir "Suma: ", a + b          // 13
    Escribir "Resta: ", a - b         // 7
    Escribir "Multiplicación: ", a * b // 30
    Escribir "División: ", a / b      // 3 (división entera)
    Escribir "Módulo (resto): ", a MOD b // 1
FinAlgoritmo""",

    "ex-java-21-11": """Algoritmo AsignacionCompuesta
    Definir numero Como Entero
    numero <- 3
    
    numero <- numero + 5  // Forma clásica: 8
    numero <- numero + 5  // Equivalente con '+=': numero += 5 -> 13
    numero <- numero * 2  // Equivalente con '*=': numero *= 2 -> 26
    
    Escribir "Resultado final: ", numero
FinAlgoritmo""",

    "ex-java-21-12": """Algoritmo ConcatenacionCadenas
    Definir saludo, nombre, mensaje Como Cadena
    saludo <- "Hola "
    nombre <- "Pablo"
    
    // Concatenación de cadenas con '+'
    mensaje <- saludo + nombre + ", bienvenido!"
    Escribir mensaje // Imprime: Hola Pablo, bienvenido!
FinAlgoritmo""",

    "ex-java-21-14": """Algoritmo ConvertirCadenaANumero
    Definir textoNumero Como Cadena
    Definir entero Como Entero
    Definir decimal Como Real
    
    textoNumero <- "1313"
    entero <- ConvertirANumero(textoNumero) // Integer.parseInt()
    
    textoDecimal <- "3.1416"
    decimal <- ConvertirAReal(textoDecimal)  // Double.parseDouble()
    
    Escribir "Número recuperado: ", entero + 10 // 1323
FinAlgoritmo""",

    "ex-java-21-15": """Algoritmo ConvertirNumeroACadena
    Definir numero Como Entero
    Definir texto Como Cadena
    
    numero <- 42
    texto <- ConvertirATexto(numero) // String.valueOf(numero) o "" + numero
    
    Escribir "Cadena resultante: ", texto
FinAlgoritmo""",

    "ex-java-21-16": """Algoritmo OperadoresComparacion
    Definir x, y Como Entero
    x <- 5; y <- 10
    
    Escribir (x = y)  // Falso (en Java: ==)
    Escribir (x <> y) // Verdadero (en Java: !=)
    Escribir (x < y)  // Verdadero
    Escribir (x >= y) // Falso
FinAlgoritmo""",

    "ex-java-21-17": """Algoritmo CompararCadenasIgualdad
    Definir s1, s2 Como Cadena
    s1 <- "Hola"
    s2 <- "Hola"
    
    // En Java:
    // s1 == s2 compara si apuntan a la MISMA POSICIÓN de memoria
    // s1.equals(s2) compara si el TEXTO/CONTENIDO es idéntico
    Si s1 = s2 Entonces
        Escribir "El contenido de las cadenas es idéntico"
    FinSi
FinAlgoritmo""",

    "ex-java-21-18": """Algoritmo OperadoresLogicos
    Definir tienePermiso, esMayor Como Logico
    esMayor <- Verdadero
    tienePermiso <- Falso
    
    // AND (Y): Ambas deben ser verdaderas
    Si esMayor Y tienePermiso Entonces Escribir "Acceso permitido" FinSi
    
    // OR (O): Al menos una debe ser verdadera
    Si esMayor O tienePermiso Entonces Escribir "Acceso condicional" FinSi
    
    // NOT (NO): Invierte el valor lógico
    Si No tienePermiso Entonces Escribir "Falta permiso" FinSi
FinAlgoritmo""",

    "ex-java-21-19": """Algoritmo EstructuraIfElse
    Definir edad Como Entero
    Escribir "Introduce tu edad: "
    Leer edad
    
    Si edad >= 18 Entonces
        Escribir "Acceso concedido (Mayor de edad)"
    Sino
        Escribir "Acceso denegado (Menor de edad)"
    FinSi
FinAlgoritmo""",

    "ex-java-21-20": """Algoritmo ConfirmacionConsola
    Definir respuesta Como Cadena
    Escribir "¿Desea continuar? (s/n): "
    Leer respuesta
    
    Si AMinusculas(respuesta) = "s" O AMinusculas(respuesta) = "si" Entonces
        Escribir "Operación confirmada"
    Sino
        Escribir "Operación cancelada"
    FinSi
FinAlgoritmo""",

    "ex-java-21-21": """Algoritmo EncadenarCondicionesElseIf
    Definir nota Como Real
    Escribir "Introduce nota: "
    Leer nota
    
    Si nota >= 9.0 Entonces
        Escribir "Sobresaliente"
    Sino Si nota >= 7.0 Entonces
        Escribir "Notable"
    Sino Si nota >= 5.0 Entonces
        Escribir "Aprobado"
    Sino
        Escribir "Suspenso"
    FinSi
FinAlgoritmo""",

    "ex-java-21-22": """Algoritmo EstructuraSwitch
    Definir dia Como Entero
    Escribir "Introduce número de día (1-7): "
    Leer dia
    
    Segun dia Hacer
        1: Escribir "Lunes"
        2: Escribir "Martes"
        3: Escribir "Miércoles"
        4: Escribir "Jueves"
        5: Escribir "Viernes"
        6: Escribir "Sábado"
        7: Escribir "Domingo"
        De Otro Modo:
            Escribir "Día no válido"
    FinSegun
FinAlgoritmo""",

    "ex-java-21-23": """Algoritmo ImportanciaBreakEnSwitch
    // En Java, olvidar 'break' hace que la ejecución continúe en cascada (fall-through)
    // ejecutando los siguientes 'case' aunque no coincida el valor.
    Segun opcion Hacer
        1:
            Escribir "Opción 1 ejecutada"
            // break evita saltar al caso 2
        2:
            Escribir "Opción 2 ejecutada"
    FinSegun
FinAlgoritmo""",

    "ex-java-21-24": """Algoritmo TiposAdmitidosSwitch
    // Java admite en 'switch':
    // 1. Enteros y caracteres: int, byte, short, char
    // 2. Cadenas de texto: String
    // 3. Enumeraciones: Enum
    Definir estado Como Cadena <- "ACTIVO"
    Segun estado Hacer
        "ACTIVO":   Escribir "Usuario en línea"
        "INACTIVO": Escribir "Usuario desconectado"
        "BLOQUEADO": Escribir "Cuenta suspendida"
    FinSegun
FinAlgoritmo""",

    "ex-java-21-25": """Algoritmo OperadorTernario
    Definir edad Como Entero <- 20
    Definir estado Como Cadena
    
    // Condición ? valorSiVerdadero : valorSiFalso
    estado <- Si (edad >= 18) Entonces "Adulto" Sino "Menor"
    Escribir "Estado: ", estado
FinAlgoritmo""",

    "ex-java-21-27": """Algoritmo BucleWhile
    Definir contador Como Entero
    contador <- 0
    
    Mientras contador < 5 Hacer
        Escribir "Iteración: ", contador
        contador <- contador + 1
    FinMientras
FinAlgoritmo""",

    "ex-java-21-28": """Algoritmo BucleDoWhile
    Definir opcion Como Entero
    
    // Se ejecuta al menos UNA vez antes de evaluar la condición de salida
    Repetir
        Escribir "Menú: 1. Jugar, 2. Opciones, 0. Salir"
        Leer opcion
    Hasta Que opcion = 0
FinAlgoritmo""",

    "ex-java-21-29": """Algoritmo BucleForEstructura
    Definir i Como Entero
    
    // Para (inicio; condición; incremento)
    Para i <- 0 Hasta 9 Con Paso 1 Hacer
        Escribir "Contador i = ", i
    FinPara
FinAlgoritmo""",

    "ex-java-21-30": """Algoritmo UsoBreakYContinue
    Definir i Como Entero
    
    Para i <- 1 Hasta 10 Con Paso 1 Hacer
        Si i = 3 Entonces
            // continue: salta la vuelta actual sin salir del bucle
        FinSi
        Si i = 8 Entonces
            // break: interrumpe y sale del bucle inmediatamente
        FinSi
        Escribir i
    FinPara
FinAlgoritmo""",

    "ex-java-21-31": """Algoritmo AmbitoVariableBucle
    // La variable declarada en la cabecera de un 'for' (ej: 'int i = 0')
    // tiene ÁMBITO LOCAL (bloque). Al finalizar el bucle, se destruye y no es accesible fuera.
    Para i <- 0 Hasta 4 Con Paso 1 Hacer
        Escribir "Dentro del bucle: ", i
    FinPara
    // Fuera de aquí 'i' ya no existe
FinAlgoritmo"""
}
