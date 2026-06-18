import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * 9-16b: JAVA Swing - QuickSort vs Burbuja (comparativa visual)
 * Muestra dos ventanas ordenando simultaneamente para comparar
 * la eficiencia de QuickSort vs Burbuja.
 */
class Video_9_16_QuickSortBurbujaSwing {

    static class PanelOrdenacion extends JPanel {
        private int dimension, espaciado, cantidad, intervalo;
        private int[] alturas;
        private String nombre;

        PanelOrdenacion(int dimension, int espaciado, int cantidad, int intervalo, String nombre) {
            this.dimension = dimension;
            this.espaciado = espaciado;
            this.cantidad = cantidad;
            this.intervalo = intervalo;
            this.nombre = nombre;
            alturas = new int[cantidad];
            for (int i = 0; i < cantidad; i++) alturas[i] = dimension * (i + 1);
            desordenar();
        }

        private void desordenar() {
            Random r = new Random();
            for (int i = 0; i < alturas.length; i++) {
                int idx = r.nextInt(alturas.length);
                int tmp = alturas[i];
                alturas[i] = alturas[idx];
                alturas[idx] = tmp;
            }
        }

        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < cantidad; i++) {
                int x = 5 + i * (dimension + espaciado);
                int alturaActual = alturas[i];
                int y = getHeight() - alturaActual;
                g.fillRect(x, y, dimension, alturaActual);
            }
        }

        synchronized void ordenarQuickSort() throws InterruptedException {
            Thread.sleep(2000);
            quickSort(alturas, 0, alturas.length - 1);
            JOptionPane.showMessageDialog(null,
                "Se ha ordenado el array de " + cantidad + " elementos",
                nombre + " - QuickSort finalizado", JOptionPane.INFORMATION_MESSAGE);
        }

        private void quickSort(int[] arr, int izq, int der) throws InterruptedException {
            int pivote = arr[izq];
            int i = izq;
            int j = der;
            while (i < j) {
                while (arr[i] <= pivote && i < j) i++;
                while (arr[j] > pivote) j--;
                if (i < j) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    Thread.sleep(intervalo);
                    repaint();
                }
            }
            arr[izq] = arr[j];
            arr[j] = pivote;
            Thread.sleep(intervalo);
            repaint();
            if (izq < j - 1) quickSort(arr, izq, j - 1);
            if (j + 1 < der) quickSort(arr, j + 1, der);
        }

        synchronized void ordenarBurbuja() throws InterruptedException {
            Thread.sleep(2000);
            for (int i = 0; i < alturas.length - 1; i++) {
                for (int j = 0; j < alturas.length - 1 - i; j++) {
                    if (alturas[j] > alturas[j + 1]) {
                        int tmp = alturas[j];
                        alturas[j] = alturas[j + 1];
                        alturas[j + 1] = tmp;
                        Thread.sleep(intervalo);
                        repaint();
                    }
                }
            }
            JOptionPane.showMessageDialog(null,
                "Se ha ordenado el array de " + cantidad + " elementos",
                nombre + " - Burbuja finalizado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        int dimension = 20, espaciado = 5, cantidad = 40, intervalo = 100;

        // Ventana QuickSort
        JFrame vQS = new JFrame("QuickSort");
        PanelOrdenacion qs = new PanelOrdenacion(dimension, espaciado, cantidad, intervalo, "QuickSort");
        vQS.add(qs);
        vQS.setSize(cantidad * (dimension + espaciado) + 20, 850);
        vQS.setLocation(50, 50);
        vQS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vQS.setVisible(true);

        // Ventana Burbuja
        JFrame vBurb = new JFrame("Burbuja");
        PanelOrdenacion burb = new PanelOrdenacion(dimension, espaciado, cantidad, intervalo, "Burbuja");
        vBurb.add(burb);
        vBurb.setSize(cantidad * (dimension + espaciado) + 20, 850);
        vBurb.setLocation(cantidad * (dimension + espaciado) + 120, 50);
        vBurb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vBurb.setVisible(true);

        // Hilos para ejecutar ambos algoritmos simultaneamente
        new Thread(() -> {
            try { qs.ordenarQuickSort(); }
            catch (InterruptedException e) { System.err.println("Error QuickSort: " + e.getMessage()); }
        }).start();

        new Thread(() -> {
            try { burb.ordenarBurbuja(); }
            catch (InterruptedException e) { System.err.println("Error Burbuja: " + e.getMessage()); }
        }).start();
    }
}
