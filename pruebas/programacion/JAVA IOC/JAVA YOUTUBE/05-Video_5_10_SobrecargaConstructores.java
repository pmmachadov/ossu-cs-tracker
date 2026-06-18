class Video_5_10_SobrecargaConstructores {

    // -------------------------------------------------------------
    // Datos del video y la playlist
    // -------------------------------------------------------------
    public static final String TITULO = "5-10 JAVA: Sobrecarga de constructores DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=ys9QFPbsDiU&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=103";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 5";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    // -------------------------------------------------------------
    // RESUMEN para el examen (CHULETA)
    // -------------------------------------------------------------
    public static final String RESUMEN =
        """
        ====================================================================
          RESUMEN RAPIDO - SOBRECARGA DE CONSTRUCTORES (TEMA 5 - V10)
        ====================================================================

        --- CONSTRUCTORES ---
        - Metodo especial para CREAR instancias (new).
        - Mismo nombre que la clase, SIN tipo de retorno.
        - Pueden recibir parametros o no.
        - Se pueden tener VARIOS constructores distintos (SOBRECARGA).

        --- SOBRECARGA DE CONSTRUCTORES ---
        - Varios constructores con DISTINTOS parametros.
        - Java diferencia por numero y/o tipo de parametros.
        - Ej:
          Televisor()              -> canal = 1 (por defecto)
          Televisor(int n)          -> canal = n (si es valido)

        --- ACCESO A ATRIBUTOS SIN ENCAPSULACION ---
        - Si un atributo NO lleva modificador (ni public ni private),
          es package-private (visible desde el mismo paquete).
        - Se puede acceder directamente: tv1.canal = 8;
        - Pero es MALA PRACTICA (rompe la encapsulacion).

        --- BUENA PRACTICA: SETTER CON VALIDACION ---
        En lugar de acceso directo, usar setter que valide:
          public void setCanal(int valorCanal) {
              if (valorCanal >= 1 && valorCanal <= 99) {
                  canal = valorCanal;
              } else if (valorCanal < 1) {
                  canal = 1;
              } else {
                  canal = 99;
              }
          }

        --- REUTILIZAR SETTER EN CONSTRUCTOR ---
        El constructor con parametros puede LLAMAR al setter:
          Televisor(int n) {
              setCanal(n);  // Usa la misma validacion
          }

        --- SUBCIR Y BAJAR CANAL CON SETTER ---
        En lugar de canal++ o canal-- directo, llaman al setter:
          void subirCanal() {
              setCanal(canal + 1);
          }
          void bajarCanal() {
              setCanal(canal - 1);
          }

        De esta forma, la validacion se aplica SIEMPRE.

        --- COMPORTAMIENTO CON VALIDACION ---
        - Si canal=99 y subimos: setCanal(100) -> canal=99 (maximo)
        - Si canal=1 y bajamos: setCanal(0) -> canal=1 (minimo)
        - Si creamos Televisor(110): setCanal(110) -> canal=99
        - Si creamos Televisor(0): setCanal(0) -> canal=1

        --- DOS FORMAS DE MANEJAR LIMITES ---
        Forma 1 (CIRCULAR): 99+1=1, 1-1=1 (se reinicia)
          if (valorCanal < 1) canal = 1;
          else if (valorCanal > 99) canal = 1;  // Reinicio

        Forma 2 (SATURACION): 99+1=99, 1-1=1 (se queda en el limite)
          if (valorCanal < 1) canal = 1;
          else if (valorCanal > 99) canal = 99;  // Se queda en maximo

        ====================================================================
        """;

    // ================================================================
    // CLASE TELEVISOR (con sobrecarga de constructores y validacion)
    // ================================================================
    static class Televisor {
        private int canal;  // Privado -> encapsulado

        // Constructor por defecto
        Televisor() {
            canal = 1;
        }

        // Constructor con parametro (reutiliza el setter)
        Televisor(int n) {
            setCanal(n);
        }

        // SETTER con validacion (canales entre 1 y 99)
        // Forma 2: SATURACION (se queda en el limite)
        void setCanal(int valorCanal) {
            if (valorCanal < 1) {
                canal = 1;
            } else if (valorCanal > 99) {
                canal = 99;
            } else {
                canal = valorCanal;
            }
        }

        // GETTER
        int getCanal() {
            return canal;
        }

        // Subir canal usando el setter (hereda la validacion)
        void subirCanal() {
            setCanal(canal + 1);
        }

        // Bajar canal usando el setter
        void bajarCanal() {
            setCanal(canal - 1);
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
        System.out.println("TEMA 5 - V10: SOBRECARGA DE CONSTRUCTORES");
        System.out.println();

        // ============================================================
        // PARTE 1: Constructor por defecto
        // ============================================================
        separador("PARTE 1: Constructor por defecto");

        Televisor tv1 = new Televisor();
        System.out.println("  tv1 = new Televisor()  -> canal = " + tv1.getCanal());
        System.out.println();

        // ============================================================
        // PARTE 2: Constructor con parametro (validado)
        // ============================================================
        separador("PARTE 2: Constructor con parametro (validacion)");

        Televisor tv2 = new Televisor(50);   // valido
        Televisor tv3 = new Televisor(110);  // invalido (>99) -> 99
        Televisor tv4 = new Televisor(0);    // invalido (<1) -> 1

        System.out.println("  tv2 = new Televisor(50)  -> canal = " + tv2.getCanal() + " (valido)");
        System.out.println("  tv3 = new Televisor(110) -> canal = " + tv3.getCanal() + " (maximo 99)");
        System.out.println("  tv4 = new Televisor(0)   -> canal = " + tv4.getCanal() + " (minimo 1)");
        System.out.println();

        // ============================================================
        // PARTE 3: Subir/bajar canal con limites
        // ============================================================
        separador("PARTE 3: Subir y bajar canal con limites");

        // Poner tv1 al maximo y subir
        tv1.setCanal(99);
        System.out.println("  tv1.setCanal(99) -> " + tv1.getCanal());
        tv1.subirCanal();
        System.out.println("  tv1.subirCanal() -> " + tv1.getCanal() + " (se queda en 99)");
        System.out.println();

        // Poner tv2 al minimo y bajar
        tv2.setCanal(1);
        System.out.println("  tv2.setCanal(1) -> " + tv2.getCanal());
        tv2.bajarCanal();
        System.out.println("  tv2.bajarCanal() -> " + tv2.getCanal() + " (se queda en 1)");
        System.out.println();

        // ============================================================
        // PARTE 4: Secuencia completa (como en el video)
        // ============================================================
        separador("PARTE 4: Secuencia completa del video");

        Televisor tA = new Televisor();
        Televisor tB = new Televisor(100);  // Invalido -> se pone a 99

        tA.setCanal(99);                     // tA = 99
        System.out.println("  tA canal = " + tA.getCanal());
        System.out.println("  tB canal = " + tB.getCanal() + " (100 invalido -> 99)");
        System.out.println();

        tA.subirCanal();                     // tA: 99+1=100 -> 99
        tB.subirCanal();                     // tB: 99+1=100 -> 99
        System.out.println("  Despues de subirCanal en ambos:");
        System.out.println("  tA canal = " + tA.getCanal());
        System.out.println("  tB canal = " + tB.getCanal());
        System.out.println();

        // ============================================================
        // RESUMEN
        // ============================================================
        System.out.println("============================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 5 - V10: SOBRECARGA DE CONSTRUCTORES)");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - Sobrecarga: varios constructores con distintos params");
        System.out.println("  - El constructor puede llamar al setter para validar");
        System.out.println("  - subirCanal() y bajarCanal() usan setCanal()");
        System.out.println("  - La validacion se aplica SIEMPRE desde cualquier metodo");
        System.out.println("  - Dos estrategias: circular (reinicio) o saturacion");
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
