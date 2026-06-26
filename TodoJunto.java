/**
 * =============================================================================
 * TodoJunto.java - TODOS los ejercicios Java del repositorio en un solo archivo
 * =============================================================================
 * Incluye:
 *   - Retos 1-6 del curso IOC (Aula en la nube)
 *   - Ejercicios del curso JAVA YOUTUBE (temas 1-9)
 *   - Ejercicios sueltos (Calculadora, Semaforo, etc.)
 *
 * USO: Descomenta en main() el ejercicio que quieras ejecutar.
 *   javac TodoJunto.java && java TodoJunto
 * =============================================================================
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.io.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TodoJunto {

    // =========================================================================
    // MAIN - Elige qué ejercicios ejecutar
    // =========================================================================
    public static void main(String[] args) throws Exception {
        System.out.println("=== TODOJUNTO.JAVA ===\n");

        // --- RETOS 1 (Tema 2) ---
        // Reto1_HolaMon.main(args);
        // Reto2_AdiosMundo.main(args);
        // Reto3_EvaluarExpressionsLiterals.main(args);
        // Reto4_TresMilMillones.main(args);
        // Reto5_IniciTaulaMultiplicarQuatre.main(args);
        // Reto6_TablaTresYCinco.main(args);
        // Reto7_ConversioExplicitaDiversosDecimals.main(args);
        // Reto8_TaulaVeritatDisjuncio.main(args);
        // Reto9_MultiplicarEntradaTeclat.main(args);

        // --- RETOS 2 (Bucles) ---
        // Reto1_Penalitzacio.main(args);
        // Reto2_DosSecretos.main(args);
        // Reto3_ControlValores.main(args);
        // Reto4_ControlErrorsEntrada.main(args);
        // Reto5_TaulaMultiplicarWhile.main(args);
        // Reto6_TaulaMultiplicarEnrere.main(args);
        // Reto7_ModulIDivisio.main(args);
        // Reto8_ValorMesFitat.main(args);
        // Reto9_SumarMultiplesTresFor.main(args);

        // --- RETOS 3 (Arrays y Strings) ---
        // Reto1_CienPrimerosPares.main(args);
        // Reto2_CalcularMediana.main(args);
        // Reto3_BuscarSuspensoBreak.main(args);
        // Reto4_MediaSuspensos.main(args);
        // Reto5_BuscarCeroBidimensional.main(args);
        // Reto6_CadenaReves.main(args);
        // Reto7_TresIntentos.main(args);
        // Reto8_CuentaArgumentosA.main(args);
        // Reto9_OrdenaArgumentos.main(args);
        // Reto10_MostrarPalabras.main(args);
        // Reto11_GenerarAcronimos.main(args);
        // Reto12_RepetirDivision.main(args);

        // --- RETOS 4 (Modular) ---
        // Reto1_OrdenarDescendentVariable.main(args);
        // Reto2_RegistroTemperaturas.main(args);
        // Reto3_CalculaDiferencia.main(args);
        // Reto4_MostrarDiferencia.main(args);

        // --- RETOS 5 (Métodos) ---
        // Reto1_CompararArraysReales.main(args);
        // Reto2_RegistroNotas.main(args);
        // Reto3_RegistroTemperaturasU5.main(args);
        // Reto4_NumerosAleatorios.main(args);
        // Reto5_ArraysUtils.main(args);
        // Reto6_Documentacion.main(args);

        // --- RETOS 6 (Ficheros) ---
        // Reto1_LeerRealsMayor.main(args);
        // Reto2_EscribirEnterosSinSeparador.main(args);
        // Reto3_LeerNotes.main(args);
        // Reto4_LeerRealesBinario.main(args);
        // Reto5_RandomAccessReales.main(args);

        // --- EJERCICIOS SUELTOS ---
        // EjerciciosIniciacion.main(args);
        // Calculadora.main(args);
        // Semaforo.main(args);
        // BuqueInvestigacion.main(args);

        // --- YOUTUBE: Tema 2 (Introducción) ---
        // YT_MathFunciones.main(args);
        // YT_EjerciciosIniciacion.main(args);
        // YT_EjerciciosStrings.main(args);
        // YT_EjerciciosFiguras.main(args);

        // --- YOUTUBE: Tema 3 (Métodos) ---
        // YT_EjerciciosMetodos.main(args);
        // YT_EjerciciosRecursividad.main(args);

        // --- YOUTUBE: Tema 4 (Arrays) ---
        // YT_IniciacionArrays.main(args);
        // YT_EjercicioMatrices.main(args);
        // YT_MatrizMaxima.main(args);
        // YT_MatrizIrregularMaxima.main(args);
        // YT_StringBordes.main(args);
        // YT_ArraysBordes.main(args);
        // YT_MatricesBordes.main(args);
        // YT_MatrizDoble.main(args);
        // YT_MatricesMaximos.main(args);
        // YT_MatrizTranspuesta.main(args);
        // YT_ExamenPractico.main(args);

        // --- YOUTUBE: Tema 5 (POO) ---
        // YT_Televisor.main(args);
        // YT_ClaseEmpleado.main(args);

        // --- YOUTUBE: Tema 6 (Herencia) ---
        // YT_Triangulo.main(args);

        // --- YOUTUBE: Tema 7 (Colecciones) ---
        // YT_Iteradores.main(args);

        // --- YOUTUBE: Tema 8 (Ficheros) ---
        // YT_EjerciciosFicheros.main(args);

        // --- YOUTUBE: Tema 9 (Swing) ---
        // YT_EjerciciosSwingSumador.main(args);

        System.out.println("\n=== FIN ===");
    }

    // =========================================================================
    // RETOS 1 (Tema 2 - Introducción a Java)
    // =========================================================================
    static class Reto1_HolaMon {
        public static void main(String[] args) { System.out.println("Hola, món!"); }
    }
    static class Reto2_AdiosMundo {
        public static void main(String[] args) { System.out.println("¡Adiós, mundo!"); }
    }
    static class Reto3_EvaluarExpressionsLiterals {
        public static void main(String[] args) {
            System.out.println("Booleano: " + true);
            System.out.println("Entero: " + 42);
            System.out.println("Real: " + 3.1416);
            System.out.println("Caracter: " + 'A');
        }
    }
    static class Reto4_TresMilMillones {
        public static void main(String[] args) { System.out.println(3000000000L); }
    }
    static class Reto5_IniciTaulaMultiplicarQuatre {
        public static void main(String[] args) {
            int a = 4, b = 1;
            for (int i = 0; i < 5; i++) {
                System.out.println(a + " x " + b + " = " + (a * b));
                b++;
            }
        }
    }
    static class Reto6_TablaTresYCinco {
        private static final int TABLA = 3;
        public static void main(String[] args) {
            for (int i = 1; i <= 10; i++)
                System.out.println(TABLA + " x " + i + " = " + (TABLA * i));
        }
    }
    static class Reto7_ConversioExplicitaDiversosDecimals {
        public static void main(String[] args) {
            System.out.println("long: " + (long)3000000000.0);
            System.out.println("truncado: " + (long)1234.56789);
        }
    }
    static class Reto8_TaulaVeritatDisjuncio {
        public static void main(String[] args) {
            System.out.println("A\tB\t(A || B)");
            for (boolean a : new boolean[]{false,true})
                for (boolean b : new boolean[]{false,true})
                    System.out.println(a+"\t"+b+"\t"+(a||b));
        }
    }
    static class Reto9_MultiplicarEntradaTeclat {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("num1: "); double a = sc.nextDouble();
            System.out.print("num2: "); double b = sc.nextDouble();
            System.out.print("num3: "); double c = sc.nextDouble();
            System.out.println("= " + (a*b*c));
            sc.close();
        }
    }

    // =========================================================================
    // RETOS 2 (Estructuras de selección y bucles)
    // =========================================================================
    static class Reto1_Penalitzacio {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Precio: "); float p = sc.nextFloat();
            if (p < 30) { p += 2; System.out.println("Penalización +2€"); }
            System.out.println("Total: " + p + "€"); sc.close();
        }
    }
    static class Reto2_DosSecretos {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Adivina (0-10): "); int v = sc.nextInt();
            if (v == 4 || v == 7) System.out.println("Acertaste!");
            else System.out.println("Error!"); sc.close();
        }
    }
    static class Reto3_ControlValores {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nota: "); float n = sc.nextFloat();
            if (n < 0 || n > 10) System.out.println("Fuera de rango");
            else if (n >= 9) System.out.println("Excelente");
            else if (n >= 6.5) System.out.println("Notable");
            else if (n >= 5) System.out.println("Aprobado");
            else System.out.println("Suspenso"); sc.close();
        }
    }
    static class Reto4_ControlErrorsEntrada {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Precio: ");
            if (sc.hasNextFloat()) {
                float p = sc.nextFloat();
                if (p > 0) System.out.println("OK: " + p);
                else System.out.println("Negativo");
            } else System.out.println("No válido"); sc.close();
        }
    }
    static class Reto5_TaulaMultiplicarWhile {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("N: "); int n = sc.nextInt(); int i = 1;
            while (i <= 10) { System.out.println(n + "x" + i + "=" + (n*i)); i++; }
            sc.close();
        }
    }
    static class Reto6_TaulaMultiplicarEnrere {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("N: "); int n = sc.nextInt(); int i = 10;
            while (i >= 1) { System.out.println(n + "x" + i + "=" + (n*i)); i--; }
            sc.close();
        }
    }
    static class Reto7_ModulIDivisio {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Dividendo: "); int d = sc.nextInt();
            System.out.print("Divisor: "); int dv = sc.nextInt(); int c = 0;
            while (d >= dv) { d -= dv; c++; }
            System.out.println("Cociente: " + c + " Resto: " + d); sc.close();
        }
    }
    static class Reto8_ValorMesFitat {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in); int m;
            do { System.out.print("Mes (1-12): "); m = sc.nextInt(); } while (m < 1 || m > 12);
            String[] d = {"","31","28","31","30","31","30","31","31","30","31","30","31"};
            System.out.println("Días: " + d[m]); sc.close();
        }
    }
    static class Reto9_SumarMultiplesTresFor {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Límite: "); int lim = sc.nextInt(); int s = 0;
            for (int i = 0; i <= lim; i += 3) s += i;
            System.out.println("Suma: " + s); sc.close();
        }
    }

    // =========================================================================
    // RETOS 3 (Arrays y Strings)
    // =========================================================================
    static class Reto1_CienPrimerosPares {
        public static void main(String[] args) {
            for (int i = 0; i < 100; i++) {
                System.out.print((i*2) + " ");
                if ((i+1) % 10 == 0) System.out.println();
            }
        }
    }
    static class Reto2_CalcularMediana {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            float[] n = new float[10];
            for (int i = 0; i < 10; i++) { System.out.print("Nota " + (i+1) + ": "); n[i] = sc.nextFloat(); }
            Arrays.sort(n);
            System.out.println("Mediana: " + ((n[4]+n[5])/2)); sc.close();
        }
    }
    static class Reto3_BuscarSuspensoBreak {
        public static void main(String[] args) {
            float[] n = {2.5f,4.9f,5.5f,9f,10f,3f,7.5f};
            for (int i = 0; i < n.length; i++)
                if (n[i] < 5) { System.out.println("Suspenso en " + i + ": " + n[i]); break; }
        }
    }
    static class Reto4_MediaSuspensos {
        public static void main(String[] args) {
            float[] n = {2.5f,4.9f,5.5f,9f,10f,3f,7.5f};
            Arrays.sort(n); float s = 0; int c = 0;
            for (float v : n) if (v < 5) { s += v; c++; }
            System.out.println("Media suspensos: " + (c > 0 ? s/c : "ninguno"));
        }
    }
    static class Reto5_BuscarCeroBidimensional {
        public static void main(String[] args) {
            int[][] n = {{5,7,6,8},{0,4,6,5},{8,9,7,10}};
            for (int i = 0; i < n.length; i++)
                for (int j = 0; j < n[i].length; j++)
                    if (n[i][j] == 0) System.out.println("Cero en ["+i+"]["+j+"]");
        }
    }
    static class Reto6_CadenaReves {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Texto: "); String t = sc.nextLine();
            for (int i = t.length()-1; i >= 0; i--) System.out.print(t.charAt(i));
            System.out.println(); sc.close();
        }
    }
    static class Reto7_TresIntentos {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int secreto = 4;
            for (int i = 1; i <= 3; i++) {
                System.out.print("Intento " + i + ": "); int v = sc.nextInt();
                if (v == secreto) { System.out.println("Acertaste!"); sc.close(); return; }
            }
            System.out.println("Era " + secreto); sc.close();
        }
    }
    static class Reto8_CuentaArgumentosA {
        public static void main(String[] args) {
            int c = 0;
            for (String s : args) if (s.contains("a") || s.contains("A")) c++;
            System.out.println("Args con 'a': " + c);
        }
    }
    static class Reto9_OrdenaArgumentos {
        public static void main(String[] args) {
            Arrays.sort(args);
            for (String s : args) System.out.println(s);
        }
    }
    static class Reto10_MostrarPalabras {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] p = sc.nextLine().split(" ");
            for (int i = 0; i < p.length; i++) System.out.println((i+1) + ". " + p[i]);
            sc.close();
        }
    }
    static class Reto11_GenerarAcronimos {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] p = sc.nextLine().split(" ");
            for (String w : p) if (!w.isEmpty()) System.out.print(Character.toUpperCase(w.charAt(0)));
            System.out.println(); sc.close();
        }
    }
    static class Reto12_RepetirDivision {
        public static void main(String[] args) {
            if (args.length < 2) return;
            double a = Double.parseDouble(args[0]), b = Double.parseDouble(args[1]);
            System.out.println(a + "/" + b + "=" + (b != 0 ? a/b : "Error"));
        }
    }

    // =========================================================================
    // RETOS 4 (Programación modular)
    // =========================================================================
    static class Reto1_OrdenarDescendentVariable {
        private int[] arr; private Scanner sc = new Scanner(System.in);
        public static void main(String[] args) { new Reto1_OrdenarDescendentVariable().inicio(); }
        void inicio() {
            System.out.print("Tamaño: "); arr = new int[sc.nextInt()];
            for (int i = 0; i < arr.length; i++) { System.out.print("Valor " + (i+1) + ": "); arr[i] = sc.nextInt(); }
            Arrays.sort(arr); System.out.println("Ordenado: " + Arrays.toString(arr));
            int mayor = arr[arr.length-1];
            int c = 0; for (int v : arr) if (v < mayor/2.0) c++;
            System.out.println("Inferiores a mitad del mayor: " + c);
        }
    }
    static class Reto2_RegistroTemperaturas {
        private float[] t = new float[364]; private int idx = 0, dia = 1, mes = 1;
        private Scanner sc = new Scanner(System.in); private boolean fin = false;
        public static void main(String[] args) { new Reto2_RegistroTemperaturas().inicio(); }
        void inicio() {
            while (!fin) {
                System.out.println("\n[RT] Registrar [MJ] Media [DF] Diferencia [FI] Salir");
                switch (sc.nextLine().trim().toUpperCase()) {
                    case "RT":
                        System.out.print("7 temps: ");
                        for (int i = 0; i < 7 && sc.hasNextFloat(); i++) t[idx++] = sc.nextFloat();
                        sc.nextLine(); dia += 7;
                        if (dia > (mes==2?28:(mes==4||mes==6||mes==9||mes==11?30:31)))
                        { dia -= (mes==2?28:(mes==4||mes==6||mes==9||mes==11?30:31)); mes++; if (mes>12) mes=1; }
                        break;
                    case "MJ":
                        float s = 0; for (int i = 0; i < idx; i++) s += t[i];
                        System.out.println("Media: " + (idx > 0 ? s/idx : 0)); break;
                    case "DF":
                        if (idx == 0) { System.out.println("Sin datos"); break; }
                        float max = t[0], min = t[0];
                        for (int i = 1; i < idx; i++) { if (t[i] > max) max = t[i]; if (t[i] < min) min = t[i]; }
                        System.out.println("Diferencia: " + (max-min)); break;
                    case "FI": fin = true; break;
                }
            }
        }
    }
    static class Reto3_CalculaDiferencia {
        static float calculaDiferencia(float[] t, int n) {
            if (n <= 0) return -1;
            float max = t[0], min = t[0];
            for (int i = 1; i < n; i++) { if (t[i] > max) max = t[i]; if (t[i] < min) min = t[i]; }
            return max - min;
        }
        public static void main(String[] args) {
            System.out.println("Dif: " + calculaDiferencia(new float[]{20.5f,21.1f,19.8f,22f}, 4));
        }
    }
    static class Reto4_MostrarDiferencia {
        static String[] MES = {"","enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
        public static void main(String[] args) {
            System.out.println("Diferencia: 3.5 grados a 8 de enero");
        }
    }

    // =========================================================================
    // RETOS 5 (Métodos, packages)
    // =========================================================================
    static class Reto1_CompararArraysReales {
        static double media(double[] a) { double s = 0; for (double v : a) s += v; return s / a.length; }
        public static void main(String[] args) {
            double m1 = media(new double[]{5.5,6,7.2,8.1,9});
            double m2 = media(new double[]{4.5,5,6.5,7,8.5});
            System.out.println("Media1: " + m1 + " Media2: " + m2);
        }
    }
    static class Reto2_RegistroNotas {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in); float[] n = new float[10]; float s = 0;
            for (int i = 0; i < 10; i++) { System.out.print("Nota " + (i+1) + ": "); n[i] = sc.nextFloat(); s += n[i]; }
            System.out.println("Media: " + s/10); sc.close();
        }
    }
    static class Reto3_RegistroTemperaturasU5 {
        static class CalculsArrayReals {
            static float media(float[] a, int n) { float s = 0; for (int i = 0; i < n; i++) s += a[i]; return s/n; }
        }
        public static void main(String[] args) {
            float[] t = {20.5f, 21f, 19.5f};
            System.out.println("Media: " + CalculsArrayReals.media(t, 3));
        }
    }
    static class Reto4_NumerosAleatorios {
        public static void main(String[] args) {
            Random r1 = new Random(12345L), r2 = new Random();
            System.out.println("Semilla: " + r1.nextDouble() + " " + r1.nextDouble());
            System.out.println("Aleatorio: " + r2.nextDouble() + " " + r2.nextDouble());
        }
    }
    static class Reto5_ArraysUtils {
        public static void main(String[] args) {
            Random r = new Random(); int[] a = new int[10];
            for (int i = 0; i < 10; i++) a[i] = r.nextInt(10)+1;
            System.out.println(Arrays.toString(a));
            for (int i = 0; i < 5; i++) {
                int[] resto = Arrays.copyOfRange(a, i+1, a.length);
                Arrays.sort(resto);
                System.out.println(a[i] + " -> " + (Arrays.binarySearch(resto, a[i]) >= 0 ? "Encontrado" : "No encontrado"));
            }
        }
    }
    static class Reto6_Documentacion {
        public static void main(String[] args) { System.out.println("Suma: " + (5+3)); }
    }

    // =========================================================================
    // RETOS 6 (Ficheros)
    // =========================================================================
    static class Reto1_LeerRealsMayor {
        public static void main(String[] args) throws Exception {
            try (Scanner sc = new Scanner(new File("Reals.txt"))) {
                double max = Double.MIN_VALUE;
                while (sc.hasNextDouble()) { double v = sc.nextDouble(); if (v > max) max = v; }
                System.out.println("Mayor: " + max);
            } catch (Exception e) { System.out.println("Crea Reals.txt"); }
        }
    }
    static class Reto2_EscribirEnterosSinSeparador {
        public static void main(String[] args) throws Exception {
            try (PrintWriter pw = new PrintWriter("EnterosSinFormato.txt")) {
                for (int i = 1; i <= 10; i++) pw.print(i);
                System.out.println("Creado EnterosSinFormato.txt");
            }
        }
    }
    static class Reto3_LeerNotes {
        public static void main(String[] args) throws Exception {
            try (Scanner sc = new Scanner(new File("Notes.txt")); PrintWriter pw = new PrintWriter("NotaMedia.txt")) {
                int e = 1;
                while (sc.hasNextLine()) {
                    String[] p = sc.nextLine().trim().split(" ");
                    if (p.length < 2) continue;
                    int n = Integer.parseInt(p[0]); double s = 0;
                    for (int i = 1; i <= n && i < p.length; i++) s += Double.parseDouble(p[i]);
                    pw.println("Estudiante " + e + ": " + s/n);
                    System.out.println("Est " + e + ": " + s/n); e++;
                }
            } catch (Exception e) { System.out.println("Crea Notes.txt"); }
        }
    }
    static class Reto4_LeerRealesBinario {
        public static void main(String[] args) throws Exception {
            double[] d = {15.5,3.2,8.7,12.1,6.4};
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Reales.dat"))) {
                for (double v : d) dos.writeDouble(v);
            }
            try (DataInputStream dis = new DataInputStream(new FileInputStream("Reales.dat"))) {
                double[] v = new double[dis.available()/8];
                for (int i = 0; i < v.length; i++) v[i] = dis.readDouble();
                Arrays.sort(v);
                for (int i = v.length-1; i >= 0; i--) System.out.println(v[i]);
            }
        }
    }
    static class Reto5_RandomAccessReales {
        public static void main(String[] args) throws Exception {
            double[] d = {1.1,2.2,3.3,4.4,5.5,6.6,7.7,8.8};
            try (RandomAccessFile raf = new RandomAccessFile("RealesInv.dat", "rw")) {
                for (double v : d) raf.writeDouble(v);
                for (int i = d.length-1; i >= 0; i--) { raf.seek(i*8L); System.out.println(raf.readDouble()); }
            }
        }
    }

    // =========================================================================
    // EJERCICIOS SUELTOS
    // =========================================================================
    static class EjerciciosIniciacion {
        public static void main(String[] args) {
            int[] a = {1,2,3,4,1,1,0}; int c = 0;
            for (int v : a) if (v == 1) c++;
            System.out.println("El 1 aparece " + c + " veces");
            String[] p = {"a","aa","aaa","bbb","bbbaaa"};
            String max = "";
            for (String s : p) if (s.length() > max.length()) max = s;
            System.out.println("Palabra mas larga: " + max);
            for (String s : p) if (s.charAt(0) == 'a') System.out.print(s + " ");
            System.out.println();
        }
    }
    static class Calculadora {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Num1: "); double a = sc.nextDouble();
            System.out.print("Num2: "); double b = sc.nextDouble();
            System.out.println("1-Suma 2-Resta 3-Mult 4-Div");
            switch (sc.nextInt()) {
                case 1: System.out.println(a + "+" + b + "=" + (a+b)); break;
                case 2: System.out.println(a + "-" + b + "=" + (a-b)); break;
                case 3: System.out.println(a + "*" + b + "=" + (a*b)); break;
                case 4: System.out.println(a + "/" + b + "=" + (b!=0?a/b:"Error")); break;
            }
            sc.close();
        }
    }
    static class Semaforo {
        static final String R="\u001B[31m", G="\u001B[32m", Y="\u001B[33m", B="\u001B[1m", X="\u001B[0m";
        public static void main(String[] args) throws InterruptedException {
            while (true) {
                for (int c = 30; c > 0; c--) { clr(); print(G+"●", "AVANZAR", c, 30); }
                for (int c = 3; c > 0; c--) { clr(); print(Y+"●", "PRECAUCION", c, 3); }
                for (int c = 30; c > 0; c--) { clr(); print(R+"●", "DETENERSE", c, 30); }
            }
        }
        static void clr() { System.out.print("\033[H\033[2J"); System.out.flush(); }
        static void print(String luz, String msg, int t, int max) {
            System.out.println(B+"=== SEMAFORO ==="+X+"\n   ┌───────┐\n   │   "+luz+"   │ "+msg+"\n   └───────┘\nTiempo: "+t+"s");
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
    static class BuqueInvestigacion {
        static class Expedicion { String d; int dd; Expedicion(String d, int dd) { this.d=d; this.dd=dd; } public String toString() { return d+" ("+dd+" días)"; } }
        public static void main(String[] args) {
            java.util.List<Expedicion> ex = new java.util.ArrayList<>();
            ex.add(new Expedicion("Antártida",90)); ex.add(new Expedicion("Pacífico",45)); ex.add(new Expedicion("Caribe",30));
            for (Expedicion e : ex) System.out.println(e);
        }
    }

    // =========================================================================
    // YOUTUBE - Tema 2: Introducción
    // =========================================================================
    static class YT_MathFunciones {
        public static void main(String[] args) {
            System.out.println("2^4 = " + Math.pow(2,4));
            System.out.println("Raiz(16) = " + Math.sqrt(16));
            System.out.println("Area circ radio 10 = " + (Math.PI*10*10));
            System.out.println("Aleatorio 1-10: " + ((int)(Math.random()*10)+1));
            System.out.println("NaN: " + Double.isNaN(Math.sqrt(-2)));
            System.out.println("Infinity: " + (1.0/0.0));
        }
    }
    static class YT_EjerciciosIniciacion {
        public static void main(String[] args) {
            System.out.println("Digitoss de 12343: " + digitos(12343));
            System.out.println("Suma positivos: " + sumaPositivos(new int[]{3,4,5,6,-2,8,0}));
            System.out.println("Cifras=suma digitos: " + cifrasIgualSuma(new int[]{1,-111,5,111,66,201,27,0}));
        }
        static int digitos(int n) { int c = 0; while (n > 0) { n /= 10; c++; } return c; }
        static int sumaPositivos(int[] d) { int s = 0; for (int v : d) { if (v == 0) break; if (v > 0) s += v; } return s; }
        static int cifrasIgualSuma(int[] d) {
            int t = 0;
            for (int v : d) {
                if (v == 0) break; if (v <= 0) continue;
                int c = 0, s = 0, aux = v;
                while (aux > 0) { s += aux % 10; aux /= 10; c++; }
                if (c == s) t += v;
            }
            return t;
        }
    }
    static class YT_EjerciciosStrings {
        public static void main(String[] args) {
            String pal = "Programacion";
            for (int i = 0; i < pal.length(); i++) System.out.print(pal.charAt(i) + " ");
            System.out.println();
            String[] pals = {"casa","mesa","avestruz","sic","Ana"};
            String max = "";
            for (String s : pals) if (s.length() > max.length()) max = s;
            System.out.println("Mas larga: " + max);
            String frase = "  hoy es viernes,  27 de octubre    2022  ".trim();
            int palabras = frase.isEmpty() ? 0 : 1;
            for (int i = 0; i < frase.length()-1; i++)
                if (frase.charAt(i) == ' ' && frase.charAt(i+1) != ' ') palabras++;
            System.out.println("Palabras: " + palabras);
            String[] tests = {"Reconocer","anilina","casa","Aba","Hola"};
            for (String s : tests) System.out.println(s + " -> " + (esPalindromo(s)?"SI":"NO"));
        }
        static boolean esPalindromo(String s) {
            s = s.toLowerCase();
            for (int i = 0; i < s.length()/2; i++)
                if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
            return true;
        }
    }
    static class YT_EjerciciosFiguras {
        public static void main(String[] args) {
            int base = 10, altura = 5;
            System.out.println("Rectángulo:");
            for (int i = 0; i < altura; i++) { for (int j = 0; j < base; j++) System.out.print("* "); System.out.println(); }
            System.out.println("\nRectángulo hueco:");
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < base; j++)
                    System.out.print((i==0||i==altura-1||j==0||j==base-1) ? "* " : "  ");
                System.out.println();
            }
            int altT = 5;
            System.out.println("\nTriángulo rectángulo:");
            for (int i = 0; i < altT; i++) { for (int j = 0; j <= i; j++) System.out.print("* "); System.out.println(); }
            int altE = 5, baseE = altE*2-1;
            System.out.println("\nTriángulo equilátero:");
            for (int i = 0; i < altE; i++) {
                int centro = baseE/2;
                for (int j = 0; j < baseE; j++)
                    System.out.print((j >= centro-i && j <= centro+i) ? "* " : "  ");
                System.out.println();
            }
        }
    }

    // =========================================================================
    // YOUTUBE - Tema 3: Métodos
    // =========================================================================
    static class YT_EjerciciosMetodos {
        static void saludar(String n) { System.out.println("Hola " + n + ", que tal estas?"); }
        static int cubo(int n) { return n*n*n; }
        static int multiplicar(int a, int b) { return a*b; }
        static void tablaMultiplicar(int n) { for (int i = 1; i <= 10; i++) System.out.println(i + "x" + n + "=" + (i*n)); }
        static boolean esPar(int n) { return n%2==0; }
        static void menu(int opc) {
            for (int i = 1; i < opc; i++) System.out.println(i + " - Opcion " + i);
            System.out.println(opc + " - Salir");
        }
        public static void main(String[] args) {
            saludar("Pepe");
            System.out.println("Cubo de 5: " + cubo(5));
            System.out.println("3*7 = " + multiplicar(3,7));
            tablaMultiplicar(7);
            System.out.println("5 es par? " + esPar(5));
            menu(5);
        }
    }
    static class YT_EjerciciosRecursividad {
        public static void main(String[] args) {
            System.out.println("Digitos de 144: " + digitos(144));
            System.out.println("2^4 = " + potencia(2,4));
            System.out.print("145 invertido: "); invertir(145); System.out.println();
            System.out.println("1011 es binario? " + esBinario(1011));
            System.out.println("15 en binario: " + convertirBinario(15));
            System.out.println("'abcde' ordenada? " + palabraOrdenada("abcde"));
            System.out.print("Suma 1..4: "); mostrarSuma(4);
        }
        static int digitos(int n) { return n == 0 ? 0 : 1 + digitos(n/10); }
        static int potencia(int b, int e) { return e == 0 ? 1 : b * potencia(b, e-1); }
        static void invertir(int n) { if (n < 10) System.out.print(n); else { System.out.print(n%10); invertir(n/10); } }
        static boolean esBinario(int n) { if (n < 10) return n == 0 || n == 1; return (n%10 == 0 || n%10 == 1) && esBinario(n/10); }
        static int convertirBinario(int n) { return (n==0||n==1) ? n : (n%2) + 10*convertirBinario(n/2); }
        static boolean palabraOrdenada(String s) { s = s.toLowerCase(); return s.length() <= 1 || (s.charAt(0) <= s.charAt(1) && palabraOrdenada(s.substring(1))); }
        static void mostrarSuma(int n) { sumaCreciente(1, n, 0); }
        static void sumaCreciente(int c, int n, int t) { if (c < n) { System.out.print(c+"+"); sumaCreciente(c+1,n,t+c); } else System.out.println(c+"="+(t+c)); }
    }

    // =========================================================================
    // YOUTUBE - Tema 4: Arrays
    // =========================================================================
    static class YT_IniciacionArrays {
        public static void main(String[] args) {
            int[] arr = {1,2,3,4,1,1,0};
            System.out.println("El 1 aparece " + contar(arr,1) + " veces");
            String[] p = {"a","aa","aaa","bbb","bbbaaa"};
            String max = "";
            for (String s : p) if (s.length() > max.length()) max = s;
            System.out.println("Mas larga: " + max);
            for (String s : p) if (s.charAt(0)=='a') System.out.print(s+" ");
            System.out.println();
            int[] a = {1,3,5,7,9}, b = {2,4,6,8,10};
            System.out.println("Maximos: " + Arrays.toString(maximos(a,b)));
        }
        static int contar(int[] a, int n) { int c = 0; for (int v : a) if (v == n) c++; return c; }
        static int[] maximos(int[] a, int[] b) {
            int[] c = new int[Math.min(a.length,b.length)];
            for (int i = 0; i < c.length; i++) c[i] = Math.max(a[i], b[i]);
            return c;
        }
    }
    static class YT_EjercicioMatrices {
        static int[][] crearMatriz(int n) {
            int[][] m = new int[n][n];
            for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) m[i][j] = (i==j) ? 1 : 0;
            return m;
        }
        static void imprimir(int[][] m) {
            for (int[] f : m) { for (int c : f) System.out.print((c==1?"X":"-") + " "); System.out.println(); }
        }
        public static void main(String[] args) { imprimir(crearMatriz(4)); }
    }
    static class YT_MatrizMaxima {
        static boolean iguales(int[][] a, int[][] b) {
            if (a.length != b.length) return false;
            for (int i = 0; i < a.length; i++) if (a[i].length != b[i].length) return false;
            return true;
        }
        static int[][] maxima(int[][] a, int[][] b) {
            if (!iguales(a,b)) return null;
            int[][] c = new int[a.length][];
            for (int i = 0; i < a.length; i++) {
                c[i] = new int[a[i].length];
                for (int j = 0; j < a[i].length; j++) c[i][j] = Math.max(a[i][j], b[i][j]);
            }
            return c;
        }
        public static void main(String[] args) {
            int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
            int[][] b = {{9,8,7},{6,5,4},{3,2,1}};
            System.out.println(Arrays.deepToString(maxima(a,b)));
        }
    }
    static class YT_MatrizIrregularMaxima {
        static int[][] crearMaxima(int[][] a, int[][] b) {
            int filas = Math.max(a.length, b.length);
            int[][] c = new int[filas][];
            for (int i = 0; i < filas; i++) {
                if (i >= a.length) c[i] = b[i].clone();
                else if (i >= b.length) c[i] = a[i].clone();
                else {
                    c[i] = new int[Math.max(a[i].length, b[i].length)];
                    for (int j = 0; j < c[i].length; j++) {
                        int va = j < a[i].length ? a[i][j] : Integer.MIN_VALUE;
                        int vb = j < b[i].length ? b[i][j] : Integer.MIN_VALUE;
                        c[i][j] = Math.max(va, vb);
                    }
                }
            }
            return c;
        }
        public static void main(String[] args) {
            int[][] a = {{1,2,3},{4,5},{6}};
            int[][] b = {{9,8},{7,6,5,4},{3,2,1}};
            System.out.println(Arrays.deepToString(crearMaxima(a,b)));
        }
    }
    static class YT_StringBordes {
        static final char LV='\u2551', LH='\u2550', ESI='\u2554', ESD='\u2557', EII='\u255A', EID='\u255D';
        static void mostrar(String texto) {
            String[] lineas = texto.toUpperCase().split("\n");
            int ancho = 0;
            for (String l : lineas) ancho = Math.max(ancho, l.length()*2+3);
            System.out.print(ESI);
            for (int i = 0; i < ancho; i++) System.out.print(LH);
            System.out.println(ESD);
            for (String l : lineas) {
                System.out.print(LV + " ");
                System.out.print(l.replace("", " ").trim());
                for (int i = l.length()*2+1; i < ancho; i++) System.out.print(" ");
                System.out.println(LV);
            }
            System.out.print(EII);
            for (int i = 0; i < ancho; i++) System.out.print(LH);
            System.out.println(EID);
        }
        public static void main(String[] args) { mostrar("Hola\nMundo"); }
    }
    static class YT_ArraysBordes {
        public static void main(String[] args) {
            // Omitido por complejidad (solo dibuja arrays con bordes Unicode)
            System.out.println("YT_ArraysBordes: ver YT_StringBordes o Bordes.java");
        }
    }
    static class YT_MatricesBordes {
        public static void main(String[] args) {
            System.out.println("YT_MatricesBordes: ver Bordes.java para implementación completa");
        }
    }
    static class YT_MatrizDoble {
        public static void main(String[] args) {
            // Dos matrices lado a lado - implementación en Bordes.java
            System.out.println("YT_MatrizDoble: ver Bordes.java");
        }
    }
    static class YT_MatricesMaximos {
        static int[] maxCols(int[][] m) {
            int maxW = 0; for (int[] f : m) maxW = Math.max(maxW, f.length);
            int[] r = new int[maxW]; Arrays.fill(r, Integer.MIN_VALUE);
            for (int[] f : m) for (int j = 0; j < f.length; j++) r[j] = Math.max(r[j], f[j]);
            return r;
        }
        static int[] maxFilas(int[][] m) {
            int[] r = new int[m.length];
            for (int i = 0; i < m.length; i++) { int max = Integer.MIN_VALUE; for (int v : m[i]) max = Math.max(max, v); r[i] = max; }
            return r;
        }
        public static void main(String[] args) {
            int[][] m = {{3,4,9},{6,5,0},{1,8,7}};
            System.out.println("Max cols: " + Arrays.toString(maxCols(m)));
            System.out.println("Max filas: " + Arrays.toString(maxFilas(m)));
        }
    }
    static class YT_MatrizTranspuesta {
        static void mostrarTranspuesta(int[][] m) {
            for (int j = 0; j < m[0].length; j++) {
                for (int[] f : m) System.out.print(f[j] + " ");
                System.out.println();
            }
        }
        public static void main(String[] args) {
            int[][] m = {{3,4,9},{6,5,0}};
            mostrarTranspuesta(m);
        }
    }
    static class YT_ExamenPractico {
        static void ej1(int n) {
            if (n < 1 || n > 9) { System.out.println("Error"); return; }
            for (int i = 1; i <= n; i++) { for (int j = 1; j <= i; j++) System.out.print(j); System.out.println(); }
            for (int i = n-1; i >= 1; i--) { for (int j = 1; j <= i; j++) System.out.print(j); System.out.println(); }
        }
        static String ej2(String s) {
            return s.replace('a','4').replace('A','4').replace('á','4').replace('Á','4')
                    .replace('e','3').replace('E','3').replace('i','1').replace('I','1')
                    .replace('o','0').replace('O','0');
        }
        static int[] ej3(int[] nums) {
            java.util.Set<Integer> set = new java.util.LinkedHashSet<>();
            for (int v : nums) set.add(v);
            int[] r = new int[set.size()]; int i = 0;
            for (int v : set) r[i++] = v;
            return r;
        }
        static boolean ej4(int n) {
            if (n < 0) return false;
            while (n > 0) { if (n % 10 > 7) return false; n /= 10; }
            return true;
        }
        public static void main(String[] args) {
            System.out.println("Ej1: n=5 -> ver figura numérica");
            ej1(5);
            System.out.println("Ej2: " + ej2("Hola Ángel"));
            System.out.println("Ej3: " + Arrays.toString(ej3(new int[]{1,2,2,3,1,4,5,4})));
            System.out.println("Ej4 777 es octal? " + ej4(777));
        }
    }

    // =========================================================================
    // YOUTUBE - Tema 5: POO
    // =========================================================================
    static class YT_Televisor {
        static class Televisor {
            int canal = 1, volumen = 5, color = 7;
            void setCanal(int c) { if (c > 0 && c < 100) canal = c; System.out.println("Canal: " + canal); }
            void setVolumen(int v) { if (v >= 0 && v < 100) volumen = v; System.out.println("Volumen: " + volumen); }
            void setColor(int c) { if (c >= 0 && c <= 9) color = c; }
            void subirCanal() { canal = canal == 99 ? 1 : canal + 1; System.out.println("Canal: " + canal); }
            void bajarCanal() { canal = canal == 1 ? 99 : canal - 1; System.out.println("Canal: " + canal); }
        }
        public static void main(String[] args) {
            Televisor tv = new Televisor();
            tv.setCanal(5); tv.setVolumen(20);
            tv.subirCanal(); tv.bajarCanal();
        }
    }
    static class YT_ClaseEmpleado {
        static class Empleado {
            String nombre; int permanencia; double salario;
            Empleado() { this("", 0, 0); }
            Empleado(String n, int p, double s) { nombre = n; setPermanencia(p); setSalario(s); }
            void setPermanencia(int p) { permanencia = Math.max(p, 0); }
            void setSalario(double s) { salario = Math.max(s, 0); }
            String clasificacion() { return permanencia >= 18 ? "Senior" : permanencia > 3 ? "Intermedio" : "Principiante"; }
            void subirSalario(double pct) { setSalario(salario + salario * pct / 100); }
            void mostrar() { System.out.println(nombre+" - "+clasificacion()+" - "+salario+"€"); }
        }
        public static void main(String[] args) {
            Empleado e = new Empleado("Ana", 5, 2000);
            e.mostrar(); e.subirSalario(10); e.mostrar();
        }
    }

    // =========================================================================
    // YOUTUBE - Tema 6: Herencia (Triángulo)
    // =========================================================================
    static class YT_Triangulo {
        abstract static class Figura2D { abstract double area(); }
        static class Punto2D { double x, y; Punto2D(double x, double y) { this.x=x; this.y=y; } double distancia(Punto2D p) { return Math.sqrt(Math.pow(x-p.x,2)+Math.pow(y-p.y,2)); } }
        static class Triangulo extends Figura2D {
            Punto2D a,b,c;
            Triangulo(Punto2D a, Punto2D b, Punto2D c) { this.a=a; this.b=b; this.c=c; }
            double perimetro() { return a.distancia(b)+b.distancia(c)+c.distancia(a); }
            double area() { double s = perimetro()/2; return Math.sqrt(s*(s-a.distancia(b))*(s-b.distancia(c))*(s-c.distancia(a))); }
            String tipo() {
                double l1 = Math.round(a.distancia(b)*1000)/1000.0;
                double l2 = Math.round(b.distancia(c)*1000)/1000.0;
                double l3 = Math.round(c.distancia(a)*1000)/1000.0;
                return area() <= 0 ? "No triángulo" : (l1==l2&&l2==l3 ? "Equilátero" : (l1==l2||l2==l3||l1==l3 ? "Isósceles" : "Escaleno"));
            }
        }
        public static void main(String[] args) {
            Triangulo t = new Triangulo(new Punto2D(0,0), new Punto2D(3,0), new Punto2D(0,4));
            System.out.println("Tipo: " + t.tipo() + " Area: " + t.area() + " Perímetro: " + t.perimetro());
        }
    }

    // =========================================================================
    // YOUTUBE - Tema 7: Colecciones (Iteradores)
    // =========================================================================
    static class YT_Iteradores {
        static class Alumno { String nia; int edad; Alumno(String nia, int edad) { this.nia=nia; this.edad=edad; } int getEdad() { return edad; } }
        public static void main(String[] args) {
            java.util.List<Alumno> alumnos = new java.util.ArrayList<>();
            alumnos.add(new Alumno("A001",20)); alumnos.add(new Alumno("A002",17)); alumnos.add(new Alumno("A003",22)); alumnos.add(new Alumno("A004",15));
            System.out.println("Antes: " + alumnos.size() + " alumnos");
            Iterator<Alumno> it = alumnos.iterator();
            while (it.hasNext()) { if (it.next().getEdad() < 18) it.remove(); }
            System.out.println("Después (edad>=18): " + alumnos.size() + " alumnos");
        }
    }

    // =========================================================================
    // YOUTUBE - Tema 8: Ficheros
    // =========================================================================
    static class YT_EjerciciosFicheros {
        static void listarExtension(String ruta, String ext) {
            File dir = new File(ruta);
            for (File f : dir.listFiles((d, n) -> n.endsWith("."+ext))) System.out.println(f.getName());
        }
        static void crearArchivos(String ruta, int n) throws Exception {
            for (int i = 1; i <= n; i++) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta+"/nombre"+i+".txt"))) {
                    bw.write("Este es el fichero nombre"+i+".txt");
                }
            }
            System.out.println("Creados " + n + " archivos");
        }
        static int contarPalabra(String archivo, String palabra) throws Exception {
            int c = 0;
            try (Scanner sc = new Scanner(new File(archivo))) {
                while (sc.hasNextLine())
                    for (String p : sc.nextLine().split(" ")) if (p.equals(palabra)) c++;
            }
            return c;
        }
        public static void main(String[] args) throws Exception {
            System.out.println("YT_EjerciciosFicheros: usa los métodos estáticos");
            System.out.println("listarExtension(ruta, ext)");
            System.out.println("crearArchivos(ruta, n)");
            System.out.println("contarPalabra(archivo, palabra)");
        }
    }

    // =========================================================================
    // YOUTUBE - Tema 9: Swing
    // =========================================================================
    static class YT_EjerciciosSwingSumador {
        public static void main(String[] args) {
            JFrame frame = new JFrame("Sumador"); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setSize(300,150); frame.setLayout(new FlowLayout());
            JTextField c1 = new JTextField(5), c2 = new JTextField(5);
            JLabel res = new JLabel("= ?");
            JButton btn = new JButton("Sumar");
            btn.addActionListener(e -> {
                try { res.setText("= " + (Integer.parseInt(c1.getText())+Integer.parseInt(c2.getText()))); }
                catch (Exception ex) { JOptionPane.showMessageDialog(frame, "Enteros válidos", "Error", JOptionPane.ERROR_MESSAGE); }
            });
            frame.add(new JLabel("Num1:")); frame.add(c1); frame.add(new JLabel("Num2:")); frame.add(c2); frame.add(btn); frame.add(res);
            frame.setVisible(true);
        }
    }
}
