public class Main {

    public static void main(String[] args) {

        // 1. Pseudocódigo (Lógica para examen en papel)
        // En el examen, si te piden un miembro estático, indícalo claramente. Sirve
        // para llevar una "cuenta global" que todos los objetos comparten
        // .
        // CLASE Punto
        // // Atributo de clase (compartido por todos)
        // ESTÁTICO ENTERO cantidadPuntos = 0

        // // Constructor: se ejecuta con cada 'new'
        // CONSTRUCTOR Punto()
        // cantidadPuntos = cantidadPuntos + 1
        // FIN CONSTRUCTOR

        // // Función de clase: se llama sin crear objetos
        // ESTÁTICO FUNCIÓN getCantidadPuntos() : ENTERO
        // RETORNAR cantidadPuntos
        // FIN FUNCIÓN
        // FIN CLASE
        // 2. Código en Java
        // Siguiendo tu resumen, implementamos el contador de instancias. Recuerda:
        // static significa que solo hay una copia en memoria para todos

        public class Punto {
            private static int cantidadPuntos = 0;

            public Punto() {
                cantidadPuntos++;
            }

            public static int getCantidadPuntos() {
                return cantidadPuntos;
            }
        }

    }
}
