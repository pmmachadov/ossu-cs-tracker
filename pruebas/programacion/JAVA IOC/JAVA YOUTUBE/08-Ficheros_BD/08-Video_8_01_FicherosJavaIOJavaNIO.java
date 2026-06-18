import java.io.*;

/**
 * Video 8-01: Ficheros - java.io y java.nio
 *
 * Tema 8: Almacenamiento y acceso a datos en Java
 * Primer vídeo (teórico) de la unidad.
 *
 * URL: https://www.youtube.com/watch?v=VjU_B45Chbw&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=172
 */
class Video_8_01_FicherosJavaIOJavaNIO {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "8-01 JAVA: Ficheros - java.io y java.nio ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=VjU_B45Chbw&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=172";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 8";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 8-01 - FICHEROS: java.io y java.nio
        ================================================================

        Este vídeo introduce el Tema 8 del curso: almacenamiento y
        acceso a datos en Java mediante ficheros (binarios y de texto)
        y bases de datos.

        --- ÍNDICE DE LA UNIDAD 8 ---
        1. Introducción a los ficheros (este vídeo)
        2. Clase File
        3. Flujos / Streams de E/S
        4. Ficheros binarios
        5. Ficheros de texto
        6. Serialización
        7. Acceso y manipulación de bases de datos

        --- CONCEPTO DE FICHERO (ARCHIVO) ---
        Secuencia de datos almacenados en un dispositivo con sistema
        de archivos (disco duro, USB, móvil...).
        Pueden contener texto, imágenes, audio, vídeo...

        --- PROCESO GENERAL PARA TRABAJAR CON FICHEROS ---
        1. Importar paquetes (java.io o java.nio)
        2. Crear instancia de la clase File (representa el fichero)
        3. Abrir el fichero
        4. Leer o escribir datos
        5. CERRAR el fichero (importante para liberar recursos)

        --- TIPOS DE FICHEROS ---

        FICHEROS DE TEXTO:
        - Secuencia de caracteres (letras, números, símbolos)
        - Contenido interpretable por un ser humano
        - MENOS eficientes: cada dígito ocupa 2 bytes (Unicode)
        - Ej: entero de 9 dígitos -> 9 * 2 = 18 bytes

        FICHEROS BINARIOS:
        - Secuencia de bytes (no interpretable directamente)
        - MÁS eficientes: un int ocupa 4 bytes
        - Ej: entero de 9 dígitos -> 4 bytes
        - No portable (mismo hardware/lenguaje)
        - Lectura/escritura más rápida

        --- PAQUETES java.io vs java.nio ---

        java.io (original):
        - Basado en flujos (streams) UNIDIRECCIONALES
        - Operaciones BLOQUEANTES (el hilo espera)
        - Sin selectores, sin mapeo en memoria
        - Más simple y fácil de usar
        - Adecuado para aplicaciones sencillas

        java.nio (desde Java 1.4):
        - Basado en CANALES (bidireccionales) y BUFFERS
        - Operaciones NO BLOQUEANTES
        - SELECTORES: monitorizar múltiples canales con un hilo
        - MAPEO DE ARCHIVOS EN MEMORIA (mejor rendimiento)
        - Soporte superior de codificación de caracteres (Charset)
        - Más escalable para alta concurrencia
        - Recomendado para aplicaciones con acceso intensivo a ficheros

        --- ¿CUÁL USAR? ---
        - Aplicaciones simples: java.io (más fácil)
        - Alta concurrencia / rendimiento: java.nio
        - En este curso usaremos principalmente java.io
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // DEMO: COMPARACIÓN DE TAMAÑOS (texto vs binario)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  COMPARACION: TEXTO vs BINARIO");
        System.out.println("=========================================");
        System.out.println();

        int numero = 123456789; // 9 dígitos

        System.out.println("  Numero a almacenar: " + numero);
        System.out.println("  Como TEXTO (Unicode):");
        System.out.println("    Cada digito -> 1 caracter char (2 bytes)");
        System.out.println("    9 digitos * 2 bytes = 18 bytes");
        System.out.println();
        System.out.println("  Como BINARIO (int):");
        System.out.println("    Un int -> 4 bytes (32 bits)");
        System.out.println("    Rango: -2^31 a 2^31-1");
        System.out.println("    4 bytes vs 18 bytes = ahorro del 77%");
        System.out.println();

        // ============================================================
        // DEMO: INSTANCIA DE FILE (creación, no uso real)
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  PROCESO BASICO CON FICHEROS");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  1. Importar: java.io.File");
        System.out.println("  2. Crear instancia:");
        System.out.println("     File f = new File(\"ejemplo.txt\");");
        System.out.println("  3. Abrir: new FileReader(f) / new FileInputStream(f)");
        System.out.println("  4. Leer/Escribir datos");
        System.out.println("  5. Cerrar: fichero.close()");
        System.out.println();

        // ============================================================
        // RESUMEN VISUAL
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  RESUMEN: java.io vs java.nio");
        System.out.println("=========================================");
        System.out.println();
        System.out.printf("  %-20s %-25s %-25s%n", "CARACTERÍSTICA", "java.io", "java.nio");
        System.out.printf("  %-20s %-25s %-25s%n", "---------------", "-------", "--------");
        System.out.printf("  %-20s %-25s %-25s%n", "Base", "Flujos (Streams)", "Canales + Buffers");
        System.out.printf("  %-20s %-25s %-25s%n", "Dirección", "Unidireccional", "Bidireccional");
        System.out.printf("  %-20s %-25s %-25s%n", "Bloqueo", "Bloqueante", "No bloqueante");
        System.out.printf("  %-20s %-25s %-25s%n", "Selectores", "No", "Sí");
        System.out.printf("  %-20s %-25s %-25s%n", "Mapeo memoria", "No", "Sí");
        System.out.printf("  %-20s %-25s %-25s%n", "Charset", "Básico", "Charset class");
        System.out.printf("  %-20s %-25s %-25s%n", "Complejidad", "Simple", "Complejo");
        System.out.printf("  %-20s %-25s %-25s%n", "Rendimiento", "Menor", "Mayor");
        System.out.println();
        System.out.println("  RECOMENDACION:");
        System.out.println("  - Simple lectura/escritura -> java.io");
        System.out.println("  - Alta concurrencia/rendimiento -> java.nio");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 8 - V01: FICHEROS java.io y java.nio)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Fichero: secuencia de datos almacenados en disco");
        System.out.println("  - Texto: legible, chars Unicode (2 bytes/char), menos eficiente");
        System.out.println("  - Binario: bytes, no legible, mas eficiente, no portable");
        System.out.println("  - java.io: flujos, bloqueante, simple");
        System.out.println("  - java.nio: canales+ buffers, no bloqueante, escalable");
        System.out.println("  - Importante cerrar ficheros (liberar recursos)");
        System.out.println("  - Proximo video: Clase File");
    }
}
