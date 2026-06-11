/**
 * Semaforo.java
 * 
 * Aplicación que simula un semáforo que cambia de luz cada cierto tiempo:
 * - Luz verde: 30 segundos
 * - Luz amarilla: 3 segundos
 * - Luz roja: 30 segundos
 * 
 * El ciclo se repite indefinidamente hasta que el usuario pulse Ctrl+C.
 */
public class Semaforo {
    
    // Colores ANSI para la consola
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BOLD = "\u001B[1m";

    public static void main(String[] args) throws InterruptedException {
        System.out.println(BOLD + "=== SEMÁFORO AUTOMÁTICO ===" + RESET);
        System.out.println("Presiona Ctrl+C para salir.\n");

        while (true) {
            // LUZ VERDE (30 segundos)
            mostrarLuz(GREEN + "●" + RESET, "VERDE", "   ", "   ", 30);

            // LUZ AMARILLA (3 segundos)
            mostrarLuz("   ", YELLOW + "●" + RESET, "VERDE", "   ", 3);

            // LUZ ROJA (30 segundos)
            mostrarLuz("   ", "   ", RED + "●" + RESET, "ROJA", 30);
        }
    }

    /**
     * Muestra el estado del semáforo y espera los segundos indicados.
     */
    private static void mostrarLuz(String luzVerde, String luzAmarilla, String luzRoja,
                                    String estado, int segundos) throws InterruptedException {
        // Limpiar pantalla (código ANSI)
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(BOLD + "=== SEMÁFORO ===" + RESET + "\n");

        // Dibujar el semáforo
        System.out.println("   ┌───────┐");
        System.out.println("   │       │");
        System.out.println("   │   " + luzRoja + "   │   " + (estado.equals("ROJA") ? RED + "¡DETENERSE!" + RESET : ""));
        System.out.println("   │       │");
        System.out.println("   │   " + luzAmarilla + "   │   " + (estado.equals("AMARILLA") ? YELLOW + "¡PRECAUCIÓN!" + RESET : ""));
        System.out.println("   │       │");
        System.out.println("   │   " + luzVerde + "   │   " + (estado.equals("VERDE") ? GREEN + "¡AVANZAR!" + RESET : ""));
        System.out.println("   │       │");
        System.out.println("   └───────┘\n");

        System.out.println(BOLD + "Luz: " + estado + RESET);
        System.out.println("Tiempo restante: " + segundos + "s\n");

        // Contador regresivo segundo a segundo
        for (int i = segundos; i > 0; i--) {
            System.out.print("\rCambio en: " + i + "s   ");
            System.out.flush();
            Thread.sleep(1000); // 1 segundo
        }
    }
}
