import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;
import java.text.DecimalFormat;

class Video_7_21_APIDeJavaTime {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "7-21 JAVA: API de Java - Time DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=KT59aB-YQM4&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=162";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-21 - API DE JAVA: TIME
        ================================================================

        Video:        7-21 JAVA: API de Java - Time
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7

        --- RESUMEN (transcripcion) ---

        La libreria java.time (Java 8+) sustituye a las antiguas
        clases Date y Calendar de java.util. Es mas flexible y
        facil de usar.

        --- CLASES PRINCIPALES DE JAVA.TIME ---

        LocalDate:
          - Representa una fecha (ano, mes, dia)
          - Sin hora ni zona horaria
          - Ej: LocalDate.of(2023, 12, 25)

        LocalTime:
          - Representa una hora (horas, minutos, segundos, nanosegundos)
          - Sin fecha ni zona horaria
          - Ej: LocalTime.of(14, 30, 0)

        LocalDateTime:
          - Combinacion de LocalDate + LocalTime
          - Ej: LocalDateTime.of(2023, 12, 25, 14, 30)

        Instant:
          - Punto especifico en el tiempo (hasta nanosegundos)
          - Medido desde la epoch Unix (1/1/1970 00:00:00)
          - Util para marcas de tiempo y diferencias

        Duration:
          - Duracion en segundos y nanosegundos
          - Para tiempos menores a un dia (aproximacion)
          - Metodos: toDays(), toHours(), toMinutes(), toSeconds()
          - NO sirve para anos/meses (duracion variable)

        Period:
          - Periodo en anos, meses y dias
          - Para calcular edades y diferencias largas
          - Si sirve para anos y meses

        DateTimeFormatter:
          - Formatear y analizar fechas/horas
          - Ej: DateTimeFormatter.ofPattern("dd/MM/yyyy")

        --- CREACION DE INSTANCIAS ---

        Las clases de java.time NO tienen constructores publicos.
        Se crean mediante METODOS ESTATICOS:

          LocalDateTime.of(ano, mes, dia, hora, min)
          LocalDateTime.now()
          Instant.now()
          Duration.between(inicio, fin)
          Period.between(fechaInicio, fechaFin)

        --- EJEMPLO 1: CALCULAR TIEMPO VIVIDO CON DURATION ---

        LocalDateTime fechaNac = LocalDateTime.of(1981, 9, 1, 8, 0);
        Instant instanteNac = fechaNac.atZone(ZoneId.systemDefault()).toInstant();
        Instant ahora = Instant.now();

        Duration duracion = Duration.between(instanteNac, ahora);

        long dias = duracion.toDays();
        long horas = duracion.toHours();
        long mins = duracion.toMinutes();
        long segs = duracion.toSeconds();

        // DecimalFormat para separadores de miles
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("Has vivido " + df.format(dias) + " dias");

        --- VALIDACION DE FECHAS ---

        LocalDateTime.of() lanza DateTimeException si la fecha
        no es valida (ej: 31 de febrero, 29 de febrero en ano no bisiesto).

        --- CONSULTA DE LA API ---

        Para cada clase, la documentacion (docs.oracle.com) muestra:
          - Arbol de herencia
          - Interfaces implementadas
          - Constantes estaticas (MAX, MIN, EPOCH...)
          - Metodos estaticos para crear instancias (of, now, between...)
          - Metodos de instancia (getYear, toDays, format...)
          - Ausencia de constructores (todos privados)

        --- CONCEPTOS CLAVE ---

        - java.time desde Java 8 (sustituye Date/Calendar)
        - LocalDate: fecha sin hora
        - LocalTime: hora sin fecha
        - LocalDateTime: fecha + hora
        - Instant: punto en el tiempo (nanosegundos)
        - Duration: diferencia en segundos (NO meses/anos)
        - Period: diferencia en anos/meses/dias
        - Sin constructores: usar metodos estaticos (of, now, between)
        - DateTimeFormatter para formatear fechas
        - Proximo video: Period para calcular edad exacta
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // EJEMPLO 1: CALCULAR TIEMPO CON DURATION
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 1: TIEMPO VIVIDO CON DURATION");
        System.out.println("=========================================");

        LocalDateTime fechaNac = LocalDateTime.of(1981, 9, 1, 8, 0);
        System.out.println("  Fecha de nacimiento: " + fechaNac);

        Instant instanteNac = fechaNac.atZone(ZoneId.systemDefault()).toInstant();
        Instant ahora = Instant.now();

        Duration duracion = Duration.between(instanteNac, ahora);

        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println();
        System.out.println("  Has vivido:");
        System.out.println("    " + df.format(duracion.toDays())    + " dias");
        System.out.println("    " + df.format(duracion.toHours())   + " horas");
        System.out.println("    " + df.format(duracion.toMinutes()) + " minutos");
        System.out.println("    " + df.format(duracion.toSeconds()) + " segundos");
        System.out.println();

        // ============================================================
        // EJEMPLO 2: VALIDACION DE FECHAS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 2: VALIDACION DE FECHAS");
        System.out.println("=========================================");

        // Fecha valida
        LocalDateTime valida = LocalDateTime.of(1984, 2, 29, 8, 0);
        System.out.println("  29/02/1984 (bisiesto): VALIDA -> " + valida);

        // Fecha invalida
        try {
            LocalDateTime invalida = LocalDateTime.of(1983, 2, 29, 8, 0);
            System.out.println("  29/02/1983 (no bisiesto): " + invalida);
        } catch (DateTimeException e) {
            System.out.println("  29/02/1983 (no bisiesto): INVALIDA -> "
                + e.getClass().getSimpleName());
        }
        System.out.println();

        // ============================================================
        // EJEMPLO 3: METODOS DE LOCALDATE
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 3: METODOS DE LOCALDATE");
        System.out.println("=========================================");

        LocalDate hoy = LocalDate.now();
        System.out.println("  Hoy: " + hoy);
        System.out.println("  Ano: " + hoy.getYear());
        System.out.println("  Mes: " + hoy.getMonthValue()
            + " (" + hoy.getMonth() + ")");
        System.out.println("  Dia: " + hoy.getDayOfMonth()
            + " (" + hoy.getDayOfWeek() + ")");
        System.out.println("  Dia del ano: " + hoy.getDayOfYear());
        System.out.println();

        // ============================================================
        // EJEMPLO 4: FORMATEO DE FECHAS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  EJEMPLO 4: FORMATEO DE FECHAS");
        System.out.println("=========================================");

        LocalDateTime ahoraDT = LocalDateTime.now();
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");
        DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("  Fecha corta:  " + ahoraDT.format(formato1));
        System.out.println("  Fecha larga:  " + ahoraDT.format(formato2));
        System.out.println("  Hora:         " + ahoraDT.format(formato3));
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V21: API DE JAVA - TIME)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - java.time: API moderna de fecha/hora (Java 8+)");
        System.out.println("  - LocalDate, LocalTime, LocalDateTime, Instant");
        System.out.println("  - Duration: diferencias en segundos (no meses/anos)");
        System.out.println("  - Period: diferencias en anos/meses/dias");
        System.out.println("  - Sin constructores -> metodos estaticos");
        System.out.println("  - DateTimeFormatter para formatear");
        System.out.println("  - Proximo video: Period para edad exacta");
    }
}
