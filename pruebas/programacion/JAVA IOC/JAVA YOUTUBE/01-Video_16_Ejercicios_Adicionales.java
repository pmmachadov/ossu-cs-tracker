

class Video_16_Ejercicios_Adicionales {

    public static final String TITULO = "Video 16 - Ejercicios adicionales y de ampliacion DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=ZzFF_aXLO5g&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=16";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ]";

    public static final String RESUMEN =
        """
        ================================================================
          VIDEO 16 - EJERCICIOS ADICIONALES Y DE AMPLIACION
        ================================================================

        --- EJERCICIO 1: INTERCAMBIAR DOS VARIABLES ---

        Intercambiar el valor de dos variables a y b.
        Se necesita una variable auxiliar c para no perder el valor.

        Algoritmo Intercambiar
          Definir a, b, c Como Entero
          Escribir("Introduce a y b:")
          Leer(a, b)
          c <- a
          a <- b
          b <- c
          Escribir("a: ", a, " b: ", b)
        FinAlgoritmo

        Entrada: a=5, b=7  ->  Salida: a:7, b:5

        --- EJERCICIO 2: MINUTOS A DIAS, HORAS Y MINUTOS ---

        Dado un tiempo en minutos, calcular los dias, horas y minutos.

        Algoritmo CalcularDiasHorasMinutos
          Definir tiempo, minutosDia, dias, resto, horas, minutos Como Entero
          minutosDia <- 60 * 24   // 1440 minutos tiene un dia
          Escribir("Introduce el tiempo en minutos:")
          Leer(tiempo)
          dias <- tiempo / minutosDia       // division entera -> trunca
          resto <- tiempo MOD minutosDia    // minutos que sobran del dia
          horas <- resto / 60
          minutos <- resto MOD 60
          Escribir("Dias: ", dias, " Horas: ", horas, " Minutos: ", minutos)
        FinAlgoritmo

        Entrada: 1500 minutos
        Proceso: 1500/1440 = 1 dia, 1500 MOD 1440 = 60 resto
                 60/60 = 1 hora, 60 MOD 60 = 0 minutos
        Salida: Dias: 1, Horas: 1, Minutos: 0

        --- EJERCICIO 3: LEER 5 NUMEROS, NEGATIVOS Y MAXIMO ---

        Leer cinco numeros enteros, decir si alguno fue negativo
        e indicar el valor maximo introducido.

        Algoritmo MaximoYNegativos
          Definir num, max, cont Como Entero
          Definir negativo Como Booleano
          cont <- 0; max <- 0; negativo <- Falso

          Mientras (cont < 5) Hacer
            Leer(num)
            Si (cont = 0) Entonces max <- num  // primer valor es el maximo inicial
            FinSi
            Si (num < 0) Entonces negativo <- Verdadero
            FinSi
            Si (num > max) Entonces max <- num
            FinSi
            cont <- cont + 1
          FinMientras

          Si (negativo = Verdadero) Entonces
            Escribir("Algun numero ha sido negativo")
          Sino
            Escribir("No hay ningun numero negativo")
          FinSi
          Escribir("El numero maximo ha sido: ", max)
        FinAlgoritmo

        Entrada: 5,6,3,-2,1
        Salida: "Algun numero ha sido negativo", "El numero maximo ha sido: 6"

        --- EJERCICIO 4: CONTAR DIGITOS DE UN NUMERO ---

        Determinar cuantos digitos tiene un numero entero.

        Algoritmo ContarDigitos
          Definir num, digitos Como Entero
          Escribir("Introduce un numero:")
          Leer(num)
          digitos <- 0
          Mientras (num <> 0) Hacer
            num <- num / 10    // division entera: elimina ultimo digito
            digitos <- digitos + 1
          FinMientras
          Escribir("Cantidad de digitos: ", digitos)
        FinAlgoritmo

        Entrada: 1014  ->  Salida: Cantidad de digitos: 4
        Nota: si num=0, el resultado seria 0 (caso especial)

        --- EJERCICIO 5: MAXIMO, MINIMO Y FRECUENCIA ---

        Leer N numeros (N>0). Hallar el mayor, el menor y las veces
        que aparece cada uno.

        Algoritmo MaxMinFrecuencia
          Definir n, num, cont, max, min, contMax, contMin Como Entero
          cont <- 0
          Escribir("Introduce n:")
          Leer(n)

          Mientras (cont < n) Hacer
            Leer(num)
            Si (cont = 0) Entonces
              max <- num; min <- num
              contMax <- 1; contMin <- 1
            Sino
              Si (num > max) Entonces
                max <- num; contMax <- 1
              Sino
                Si (num = max) Entonces contMax <- contMax + 1
                FinSi
              FinSi
              Si (num < min) Entonces
                min <- num; contMin <- 1
              Sino
                Si (num = min) Entonces contMin <- contMin + 1
                FinSi
              FinSi
            FinSi
            cont <- cont + 1
          FinMientras

          Escribir("Minimo: ", min, " aparece ", contMin, " veces")
          Escribir("Maximo: ", max, " aparece ", contMax, " veces")
        FinAlgoritmo

        Entrada: n=5, numeros: 1,5,5,1,6
        Salida: Minimo: 1 aparece 2 veces, Maximo: 6 aparece 1 vez

        --- CONCEPTOS CLAVE PARA EL EXAMEN ---

        * Intercambio de variables: usar variable auxiliar (c <- a; a <- b; b <- c)
        * Division entera trunca: 1500/1440 = 1 (no 1.04)
        * MOD (resto): util para extraer residuos en conversiones
        * Primer valor como max/min inicial: mejor que usar 0 o valores arbitrarios
        * Contar digitos: dividir entre 10 repetidamente hasta llegar a 0
        * Al actualizar max/min, reiniciar contador de frecuencia a 1
        * Si el numero es igual al max/min, incrementar contador
        * Booleano: variable que guarda true/false para indicar estado
        ================================================================
        """;

    public static void main(String[] args) {
        mostrarInformacion();
    }

    public static void mostrarInformacion() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("   INFORMACION DEL VIDEO");
        System.out.println("============================================");
        System.out.println("Video:      " + TITULO);
        System.out.println("Canal:      " + CANAL);
        System.out.println("URL Canal:  " + URL_CANAL);
        System.out.println("URL Video:  " + URL);
        System.out.println("Playlist:   " + PLAYLIST);
        System.out.println();
        System.out.println(RESUMEN);
    }
}
