import java.time.*;
import java.time.format.DateTimeFormatter;

class Video_7_22_APIDeJavaPeriodDuration {

    // ──────────────────────────────────────────────────────────────
    // Datos del vídeo y la playlist
    // ──────────────────────────────────────────────────────────────
    public static final String TITULO = "7-22 JAVA: API de Java - Period y Duration DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=r_W7qc7hUBw&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=163";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // ──────────────────────────────────────────────────────────────
    // Contenido del vídeo en formato texto
    // ──────────────────────────────────────────────────────────────
    public static final String CONTENIDO = """
        ================================================================
          VIDEO 7-22 - API DE JAVA: PERIOD Y DURATION
        ================================================================

        Video:        7-22 JAVA: API de Java - Period y Duration
        Canal:        Aula en la nube
        Playlist:     MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 7

        --- RESUMEN (transcripcion) ---

        Continuacion del ejemplo anterior. Ahora usamos PERIOD para
        calcular la edad exacta en anios/meses/dias, y DURATION para
        las horas/minutos/segundos.

        --- DIFERENCIA ENTRE PERIOD Y DURATION ---

        PERIOD:
          - Almacena diferencia en ANIOS, MESES y DIAS
          - Tiene en cuenta la duracion variable de meses y bisiestos
          - Metodo estatico: Period.between(fechaInicio, fechaFin)
          - Metodos: getYears(), getMonths(), getDays()
          - Sirve para calcular edades exactas

        DURATION:
          - Almacena diferencia en SEGUNDOS y NANOSEGUNDOS
          - NO tiene en cuenta meses/anos (duracion variable)
          - Se puede convertir a: toDays(), toHours(), toMinutes()
          - Metodo estatico: Duration.between(temporal1, temporal2)
          - Sirve para diferencias cortas (menos de un dia)

        --- EJEMPLO: CALCULAR EDAD EXACTA ---

        LocalDate fechaNac = LocalDate.of(1981, 9, 1);
        LocalTime horaNac = LocalTime.of(8, 0);

        // Fecha y hora actuales
        LocalDateTime fechaHoraActual = LocalDateTime.now();

        // Periodo entre fechas (anos, meses, dias)
        Period p = Period.between(fechaNac, fechaHoraActual.toLocalDate());

        // Duracion entre horas (horas, minutos, segundos)
        Duration d = Duration.between(horaNac, fechaHoraActual.toLocalTime());

        // Si la duracion es negativa, la hora actual es anterior
        // a la hora de nacimiento de ese dia -> restar un dia
        if (d.isNegative()) {
            p = p.minusDays(1);
            d = d.plusDays(1);
        }

        // Extraer valores
        long horas = d.toHours();
        long minutos = d.toMinutes() % 60;
        long segundos = d.toSeconds() % 60;

        System.out.println(p.getYears() + " anios, "
            + p.getMonths() + " meses, " + p.getDays() + " dias, "
            + horas + " horas, " + minutos + " min, " + segundos + " seg");

        --- VALIDACION: FECHA POSTERIOR AL ACTUAL ---

        LocalDateTime fechaNacDT = LocalDateTime.of(fechaNac, horaNac);
        if (fechaNacDT.isAfter(fechaHoraActual)) {
            System.out.println("Fecha de nacimiento no valida");
        } else {
            // ... calcular edad ...
        }

        --- EXPLORAR CODIGO FUENTE DE LA API ---

        En Visual Studio Code: boton derecho sobre una clase
        (ej: LocalDate) -> Go to Definition.

        Se puede ver el codigo fuente real de la API de Java:
          - Copyright de Oracle
          - Constructores privados (no instanciables directamente)
          - Metodos estaticos "of" que validan y llaman al constructor
          - Documentacion Javadoc que coincide con la API online
          - Codigo escrito por expertos, validado y testeado

        --- METODOS UTILIZADOS (vistos en la API) ---

        LocalDate.of(ano, mes, dia)
        LocalTime.of(hora, min)
        LocalDateTime.now()
        LocalDateTime.of(LocalDate, LocalTime)
        Period.between(LocalDate, LocalDate)
        Duration.between(Temporal, Temporal)
        Period.getYears(), getMonths(), getDays()
        Duration.toHours(), toMinutes(), toSeconds()
        Duration.isNegative()
        Period.minusDays(long)
        Duration.plusDays(long)
        LocalDateTime.isAfter(LocalDateTime)

        --- CONCEPTOS CLAVE ---

        - Period: para calcular edades (anios, meses, dias)
        - Duration: para horas, minutos, segundos
        - Period.between() tiene en cuenta bisiestos y duracion de meses
        - Si Duration es negativa: restar un dia al Period
        - Validar fecha de nacimiento posterior a la actual
        - El codigo fuente de la API se puede inspeccionar
        - Proximo video: ejercicios de repaso del Tema 7
        ================================================================
        """;

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        // ============================================================
        // CALCULAR EDAD EXACTA CON PERIOD + DURATION
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  CALCULAR EDAD EXACTA");
        System.out.println("=========================================");

        LocalDate fechaNac = LocalDate.of(1981, 9, 1);
        LocalTime horaNac = LocalTime.of(8, 0);
        System.out.println("  Fecha de nacimiento: " + fechaNac + " a las " + horaNac);

        LocalDateTime fechaHoraActual = LocalDateTime.now();
        System.out.println("  Fecha y hora actual: " + fechaHoraActual);
        System.out.println();

        Period p = Period.between(fechaNac, fechaHoraActual.toLocalDate());
        Duration d = Duration.between(horaNac, fechaHoraActual.toLocalTime());

        if (d.isNegative()) {
            p = p.minusDays(1);
            d = d.plusDays(1);
        }

        long horas = d.toHours();
        long minutos = d.toMinutes() % 60;
        long segundos = d.toSeconds() % 60;

        System.out.println("  Han pasado (con Period + Duration):");
        System.out.println("    " + p.getYears() + " anios, "
            + p.getMonths() + " meses, " + p.getDays() + " dias, "
            + horas + " horas, " + minutos + " min, " + segundos + " seg");
        System.out.println();

        // ============================================================
        // VALIDACION: FECHA POSTERIOR AL ACTUAL
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  VALIDACION DE FECHA");
        System.out.println("=========================================");

        LocalDateTime nacDT = LocalDateTime.of(fechaNac, horaNac);

        if (nacDT.isAfter(fechaHoraActual)) {
            System.out.println("  Fecha de nacimiento NO valida (posterior al actual)");
        } else {
            System.out.println("  Fecha de nacimiento valida (anterior al actual)");
        }
        System.out.println();

        // ============================================================
        // DEMO: CAMBIO DE CERCANIA A CUMPLEANIOS
        // ============================================================
        System.out.println("=========================================");
        System.out.println("  DEMO: PROXIMIDAD AL CUMPLEANIOS");
        System.out.println("=========================================");

        // Simular cumpleanos de hace 2 dias
        LocalDate cumple = fechaHoraActual.toLocalDate().minusDays(2);
        LocalTime horaCumple = LocalTime.of(8, 0);

        Period pCumple = Period.between(
            LocalDate.of(1981, cumple.getMonthValue(), cumple.getDayOfMonth()),
            fechaHoraActual.toLocalDate());

        System.out.println("  Si hubiera nacido el " + cumple
            + " (hace 2 dias):");
        System.out.println("    Edad: " + pCumple.getYears() + " anios, "
            + pCumple.getMonths() + " meses, "
            + pCumple.getDays() + " dias");
        System.out.println();

        // ============================================================
        // FIN
        // ============================================================
        System.out.println("==============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 7 - V22: PERIOD Y DURATION)");
        System.out.println("==============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Period.between() para anos/meses/dias exactos");
        System.out.println("  - Duration.between() para horas/min/seg");
        System.out.println("  - Si Duration es negativa -> restar 1 dia al Period");
        System.out.println("  - isAfter() para validar fechas");
        System.out.println("  - Go to Definition para ver codigo fuente API");
    }
}
