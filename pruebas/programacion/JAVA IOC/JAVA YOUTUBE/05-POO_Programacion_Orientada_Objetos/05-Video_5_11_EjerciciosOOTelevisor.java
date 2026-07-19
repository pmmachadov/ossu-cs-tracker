class Video_5_11_EjerciciosOOTelevisor {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-11 JAVA: Ejercicios OO Clase Televisor DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=zgjT_i_eORA&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=104";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 5";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // RESUMEN para el examen (CHULETA)
    // -------------------------------------------------------------
    public static final String RESUMEN = """
            ====================================================================
              RESUMEN RAPIDO - EJERCICIOS OO TELEVISOR (TEMA 5 - V11)
            ====================================================================

            --- PARTE 1: AÑADIR VOLUMEN ---
            - Nuevo atributo: private int volumen;
            - Constructor: volumen = 5 (por defecto)
            - Canales validos: 1 a 99
            - Volumen valido: 0 a 99
            - Los setters SOLO modifican si el valor es valido.
            - Cada vez que se modifica canal/volumen, se muestra el valor.

            --- SETTER SIN REINICIO (solo si es valido) ---
            void setCanal(int valorCanal) {
                if (valorCanal > 0 && valorCanal < 100) {
                    canal = valorCanal;
                }
                System.out.println("Canal: " + canal);
            }

            void setVolumen(int valorVolumen) {
                if (valorVolumen >= 0 && valorVolumen < 100) {
                    volumen = valorVolumen;
                }
                System.out.println("Volumen: " + volumen);
            }

            --- PARTE 2: ANHADIR COLOR + CAMBIAR LIMITES ---
            - Nuevo atributo: private int color;
            - Constructor: color = 7 (por defecto)

            NUEVOS LIMITES DEL EJERCICIO:
            - Canal: 0 a 10, con REINICIO CIRCULAR
              * Si canal=10 y subimos -> canal=0
              * Si canal=0 y bajamos -> canal=10

            - Color: 1 a 7, con SATURACION
              * Si color=7 y subimos -> color=7 (se queda)
              * Si color=1 y bajamos -> color=1 (se queda)

            - Volumen: 0 a 15, con SATURACION
              * Si volumen=15 y subimos -> volumen=15
              * Si volumen=0 y bajamos -> volumen=0

            --- DIFERENCIA CIRCULAR vs SATURACION ---
            CIRCULAR: al llegar al limite superior, vuelve al inferior.
              if (valor > 10) canal = 0;
              else if (valor < 0) canal = 10;

            SATURACION: al llegar al limite, se queda ahi.
              if (valor > 7) color = 7;
              else if (valor < 1) color = 1;

            --- METODO mostrarDatos() ---
            Para depuracion, se crea un metodo que muestra todo el estado:
              void mostrarDatos(String nombre) {
                  System.out.println("TV " + nombre + ":");
                  System.out.println("  Canal actual = " + canal);
                  System.out.println("  Volumen = " + volumen);
                  System.out.println("  Color = " + color);
              }

            --- ESTRUCTURA FINAL DE LA CLASE ---
            class Televisor {
                private int canal, volumen, color;

                Televisor() {
                    canal = 1; volumen = 5; color = 7;
                }

                // Setters con validacion
                void setCanal(int v) { ... }   // circular 0-10
                void setVolumen(int v) { ... } // saturacion 0-15
                void setColor(int v) { ... }   // saturacion 1-7

                // Subir/Bajar usando setters
                void subirCanal()   { setCanal(canal + 1); }
                void bajarCanal()   { setCanal(canal - 1); }
                void subirVolumen() { setVolumen(volumen + 1); }
                void bajarVolumen() { setVolumen(volumen - 1); }
                void subirColor()   { setColor(color + 1); }
                void bajarColor()   { setColor(color - 1); }

                void mostrarDatos(String nombre) { ... }
            }

            ====================================================================
            """;

    // ================================================================
    // CLASE TELEVISOR (version final con canal, volumen y color)
    // ================================================================
    static class Televisor {
        private int canal;
        private int volumen;
        private int color;

        // Constructor
        Televisor() {
            canal = 1;
            volumen = 5;
            color = 7;
        }

        // ---- SETTERS ----

        // Canal: 0 a 10, CIRCULAR (10+1=0, 0-1=10)
        void setCanal(int valorCanal) {
            if (valorCanal > 10) {
                canal = 0;
            } else if (valorCanal < 0) {
                canal = 10;
            } else {
                canal = valorCanal;
            }
            System.out.println("  Canal: " + canal);
        }

        // Volumen: 0 a 15, SATURACION (15+1=15, 0-1=0)
        void setVolumen(int valorVolumen) {
            if (valorVolumen > 15) {
                volumen = 15;
            } else if (valorVolumen < 0) {
                volumen = 0;
            } else {
                volumen = valorVolumen;
            }
            System.out.println("  Volumen: " + volumen);
        }

        // Color: 1 a 7, SATURACION (7+1=7, 1-1=1)
        void setColor(int valorColor) {
            if (valorColor > 7) {
                color = 7;
            } else if (valorColor < 1) {
                color = 1;
            } else {
                color = valorColor;
            }
            System.out.println("  Color: " + color);
        }

        // ---- SUBIR/BAJAR ----
        void subirCanal() {
            setCanal(canal + 1);
        }

        void bajarCanal() {
            setCanal(canal - 1);
        }

        void subirVolumen() {
            setVolumen(volumen + 1);
        }

        void bajarVolumen() {
            setVolumen(volumen - 1);
        }

        void subirColor() {
            setColor(color + 1);
        }

        void bajarColor() {
            setColor(color - 1);
        }

        // ---- MOSTRAR DATOS ----
        void mostrarDatos(String nombre) {
            System.out.println("  TV " + nombre + ":");
            System.out.println("    Canal actual = " + canal);
            System.out.println("    Volumen = " + volumen);
            System.out.println("    Color = " + color);
        }

        // Getters (para comprobaciones)
        int getCanal() {
            return canal;
        }

        int getVolumen() {
            return volumen;
        }

        int getColor() {
            return color;
        }
    }

    // ================================================================
    // METODO PRINCIPAL
    // ================================================================
    public static void main(String[] args) {
        separador("INFORMACION DEL VIDEO");
        System.out.println("TITULO: " + TITULO);
        System.out.println("URL:    " + URL);
        System.out.println();
        System.out.println("TEMA 5 - V11: EJERCICIOS OO TELEVISOR");
        System.out.println();

        // ============================================================
        // PARTE 1: Probar setters con validacion
        // ============================================================
        separador("PARTE 1: Estado inicial + operaciones basicas");

        Televisor tv1 = new Televisor();
        Televisor tv2 = new Televisor();

        // tv1: subir volumen, bajar canal
        System.out.println("  tv1.subirVolumen() -> volumen 5 -> 6");
        tv1.subirVolumen();
        System.out.println("  tv1.bajarCanal() -> canal 1 -> 0 (minimo)");
        tv1.bajarCanal();
        System.out.println();

        // tv2: bajar volumen, subir canal
        System.out.println("  tv2.subirCanal() -> canal 1 -> 2");
        tv2.subirCanal();
        System.out.println("  tv2.bajarVolumen() -> volumen 5 -> 4");
        tv2.bajarVolumen();
        System.out.println();

        System.out.println("  ESTADO FINAL PARTE 1:");
        tv1.mostrarDatos("tv1");
        tv2.mostrarDatos("tv2");
        System.out.println();

        // ============================================================
        // PARTE 2: Probar limites (circular y saturacion)
        // ============================================================
        separador("PARTE 2: Prueba de limites");

        // Canal circular (0-10)
        tv1.setCanal(10);
        System.out.println("  tv1.setCanal(10) -> maximo");
        tv1.subirCanal();
        System.out.println("  tv1.subirCanal() -> 10+1=11 -> vuelve a 0 (circular)");
        System.out.println("  Canal actual: " + tv1.getCanal());
        System.out.println();

        tv1.bajarCanal();
        System.out.println("  tv1.bajarCanal() -> 0-1=-1 -> vuelve a 10 (circular)");
        System.out.println("  Canal actual: " + tv1.getCanal());
        System.out.println();

        // Color saturacion (1-7)
        tv1.setColor(7);
        System.out.println("  tv1.setColor(7) -> maximo");
        tv1.subirColor();
        System.out.println("  tv1.subirColor() -> 7+1=8 -> se queda en 7");
        System.out.println("  Color actual: " + tv1.getColor());
        System.out.println();

        tv1.setColor(1);
        System.out.println("  tv1.setColor(1) -> minimo");
        tv1.bajarColor();
        System.out.println("  tv1.bajarColor() -> 1-1=0 -> se queda en 1");
        System.out.println("  Color actual: " + tv1.getColor());
        System.out.println();

        // Volumen saturacion (0-15)
        tv1.setVolumen(15);
        System.out.println("  tv1.setVolumen(15) -> maximo");
        tv1.subirVolumen();
        System.out.println("  tv1.subirVolumen() -> 15+1=16 -> se queda en 15");
        System.out.println("  Volumen actual: " + tv1.getVolumen());
        System.out.println();

        tv1.setVolumen(0);
        System.out.println("  tv1.setVolumen(0) -> minimo");
        tv1.bajarVolumen();
        System.out.println("  tv1.bajarVolumen() -> 0-1=-1 -> se queda en 0");
        System.out.println("  Volumen actual: " + tv1.getVolumen());
        System.out.println();

        // ============================================================
        // RESUMEN FINAL
        // ============================================================
        separador("RESUMEN: TODOS LOS DATOS DE TV1 TRAS LAS PRUEBAS");
        tv1.mostrarDatos("tv1");
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V11: EJERCICIOS OO TELEVISOR)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  RESUMEN DE LIMITES:");
        System.out.println("  Canal:  0-10 (CIRCULAR: 10+1=0, 0-1=10)");
        System.out.println("  Color:  1-7  (SATURACION: se queda en limite)");
        System.out.println("  Volumen: 0-15 (SATURACION: se queda en limite)");
    }

    // -------------------------------------------------------------
    // METODO AUXILIAR
    // -------------------------------------------------------------
    public static void separador(String titulo) {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("  " + titulo);
        System.out.println("============================================================");
    }
}
