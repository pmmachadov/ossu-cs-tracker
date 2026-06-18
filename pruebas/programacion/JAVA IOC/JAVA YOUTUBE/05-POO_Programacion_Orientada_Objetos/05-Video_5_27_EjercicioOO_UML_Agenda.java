import java.util.ArrayList;

class Video_5_27_EjercicioOO_UML_Agenda {

    public static final String TITULO = "5-27 JAVA: OO + UML - Agenda DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=gVVrpTPwSdE&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=120";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 5";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN = "RESUMEN RAPIDO - UML + AGENDA (TEMA 5 - V27)\n"
        + "============================================\n"
        + "UML: Agenda (1) -> Pagina (365, array) -> Cita (*, ArrayList)\n"
        + "Minutos redondeados a multiplo de 5. Hora 0-23.\n"
        + "DIAS_MES: 31,28,31,30,31,30,31,31,30,31,30,31\n";

    // ================================================================
    // CLASE CITA
    // ================================================================
    static class Cita {
        private int hora, minutos;
        private String titulo, texto;

        Cita(int hora, int minutos, String titulo, String texto) {
            setHora(hora);
            setMinutos(minutos);
            this.titulo = titulo;
            this.texto = texto;
        }

        int getHora() { return hora; }
        int getMinutos() { return minutos; }
        String getTitulo() { return titulo; }

        void setHora(int h) {
            if (h < 0 || h > 23) {
                this.hora = 0;
            } else {
                this.hora = h;
            }
        }

        void setMinutos(int m) {
            if (m < 0 || m >= 60) {
                this.minutos = 0;
                return;
            }
            int mod = m % 5;
            if (mod == 0) {
                this.minutos = m;
            } else if (mod <= 2) {
                this.minutos = m - mod;
            } else {
                this.minutos = m + (5 - mod);
            }
            if (this.minutos >= 60) {
                this.minutos = 55;
            }
        }

        public String toString() {
            return String.format("(%02d:%02d) [%s] %s", hora, minutos, titulo, texto);
        }
    }

    // ================================================================
    // CLASE PAGINA
    // ================================================================
    static class Pagina {
        private int dia, mes;
        private ArrayList<Cita> citas;

        Pagina(int dia, int mes) {
            this.dia = dia;
            this.mes = mes;
            this.citas = new ArrayList<>();
        }

        int getDia() { return dia; }
        int getMes() { return mes; }

        Cita buscarCita(int hora, int min) {
            for (Cita c : citas) {
                if (c.getHora() == hora && c.getMinutos() == min) {
                    return c;
                }
            }
            return null;
        }

        boolean agregarCita(int hora, int minutos, String titulo, String texto) {
            Cita c = new Cita(hora, minutos, titulo, texto);
            if (buscarCita(c.getHora(), c.getMinutos()) != null) {
                System.out.println("  ERROR: No se puede agregar la cita, hora ocupada");
                return false;
            }
            citas.add(c);
            System.out.println("  Cita agregada correctamente a las "
                + c.getHora() + ":" + c.getMinutos());
            return true;
        }

        boolean borrarCita(int hora, int min) {
            Cita c = buscarCita(hora, min);
            if (c != null) {
                citas.remove(c);
                System.out.println("  Cita borrada correctamente");
                return true;
            }
            System.out.println("  ERROR: No se puede borrar la cita, no existe");
            return false;
        }

        void verCitas() {
            String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio",
                              "Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
            System.out.println("  CITAS DEL " + dia + " DE " + meses[mes-1]);
            for (Cita c : citas) {
                System.out.println("    " + c);
            }
        }
    }

    // ================================================================
    // CLASE AGENDA
    // ================================================================
    static class Agenda {
        private static final int[] DIAS_MES = {31,28,31,30,31,30,31,31,30,31,30,31};
        private static final String[] MESES = {"Enero","Febrero","Marzo","Abril","Mayo","Junio",
                                                "Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

        private int ano;
        private Pagina[] paginas;
        private Pagina abierta;

        Agenda(int ano) {
            this.ano = ano;
            this.paginas = new Pagina[365];
            int d = 1, m = 1;
            for (int i = 0; i < paginas.length; i++) {
                paginas[i] = new Pagina(d, m);
                d++;
                if (d > DIAS_MES[m-1]) {
                    d = 1;
                    m++;
                }
            }
            this.abierta = paginas[0];
        }

        Pagina getAbierta() { return abierta; }

        void abrirPagina(int dia, int mes) {
            for (Pagina p : paginas) {
                if (p.getDia() == dia && p.getMes() == mes) {
                    this.abierta = p;
                    System.out.println("  Pagina abierta: " + dia + " de " + MESES[mes-1] + " de " + ano);
                    return;
                }
            }
            System.out.println("  Pagina no valida");
            System.out.println("  Pagina abierta: " + abierta.getDia() + " de "
                + MESES[abierta.getMes()-1] + " de " + ano);
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 5 - V27: UML + AGENDA");
        System.out.println();

        Agenda agenda = new Agenda(2023);
        agenda.abrirPagina(3, 2);

        Pagina pag = agenda.getAbierta();
        pag.agregarCita(11, 21, "Reunion 1", "Que lenguaje aprender primero");
        pag.agregarCita(11, 15, "Reunion 2", "El futuro de la IA");
        pag.agregarCita(11, 14, "Reunion 3", "Desarrollo con Unreal Engine");
        pag.agregarCita(11, 59, "Reunion 4", "Desarrollo con Unity");
        System.out.println();
        pag.verCitas();
        System.out.println();

        // Fecha invalida
        agenda.abrirPagina(30, 2);
        System.out.println();

        // Fecha valida
        agenda.abrirPagina(28, 2);
        System.out.println();

        System.out.println("============================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V27: UML + AGENDA)");
        System.out.println("============================================");
    }
}
