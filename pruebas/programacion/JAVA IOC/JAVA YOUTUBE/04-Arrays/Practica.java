public class Practica {

    static int[] numeros = new int[8];

    public static void main(String[] args) {

        pideNumeros();
        int cantPares = contarPares();
        int[] numInv = invertirNumeros();
        salidaPares(cantPares);
        salidaInvertido(numInv);

    }
    // Entrada: Pide 8 números enteros por teclado y los almacena en un array.

    /*
     * 
     * Iniciar scanner
     * Pedir 8 numeros
     * recorrer los numeros
     * agregando N 1,2,...
     * guardarlos en una variable o array (numeros)
     * cerrar scanner
     * 
     */

    // contarPares: Recorre el array y devuelve la cantidad de números pares.

    /*
     *
     * inicializo variable contador
     * if si es par lo cuento contador++
     * lo guardo en la variable p
     * 
     * return p
     *
     * 
     */

    // invertir: Crea un nuevo array con los elementos en orden inverso al original.

    /*
     * inicializo el array de numeros y numInv
     * recorro el array de 0 hasta 7 hacer
     * array[array.length -1 -i]
     * guardo el resultado en numInv
     */

    // Salida: Muestra el número de pares

    /*
     * Escribir cantPares
     */

    // Salida: Array invertido

    /*
     * Escribir snumInv
     */
}
