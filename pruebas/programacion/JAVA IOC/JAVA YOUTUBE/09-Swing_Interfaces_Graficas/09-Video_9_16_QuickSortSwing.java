import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * 9-16: JAVA Swing - QuickSort visualizacion grafica
 * Muestra rectangulos de alturas aleatorias ordenandose
 * con el algoritmo QuickSort (y Burbuja para comparar).
 */
class Video_9_16_QuickSortSwing {

    static class QuickSortSwing extends JPanel {
        private int dimension, espaciado, cantidad, intervalo;
        private int[] alturas;

        QuickSortSwing(int dimension, int espaciado, int cantidad, int intervalo) {
            this.dimension = dimension;
            this.espaciado = espaciado;
            this.cantidad = cantidad;
            this.intervalo = intervalo;
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

        void quickSort() throws InterruptedException {
            Thread.sleep(2000);
            quickSort(alturas, 0, alturas.length - 1);
            JOptionPane.showMessageDialog(this,
                "Se ha ordenado el array de " + cantidad + " elementos",
                "Ordenacion finalizada", JOptionPane.INFORMATION_MESSAGE);
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

        void burbuja() throws InterruptedException {
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
            JOptionPane.showMessageDialog(this,
                "Se ha ordenado el array de " + cantidad + " elementos",
                "Ordenacion finalizada", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        int dimension = 20, espaciado = 5, cantidad = 40, intervalo = 100;

        JFrame ventana = new JFrame("Ordenar con QuickSort");
        QuickSortSwing qs = new QuickSortSwing(dimension, espaciado, cantidad, intervalo);
        ventana.add(qs);
        ventana.setSize(cantidad * (dimension + espaciado) + 20, 850);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

        new Thread(() -> {
            try { qs.quickSort(); } catch (InterruptedException e) {}
        }).start();
    }
}
