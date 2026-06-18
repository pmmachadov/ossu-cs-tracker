

class Video_10_06_BindingsPropiedades {

    public static final String TITULO = "10-6 JAVA FX: Bindings y propiedades ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=ESLDAQ-CC4M&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=215";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 10 (JavaFX)";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          10-6 JAVA FX: BINDINGS Y PROPIEDADES
        ================================================================

        --- CONCEPTO DE PROPIEDAD (Property) ---

        * Contenedor especial que puede guardar un valor
        * Envuelve (encapsula) el valor para poder ser OBSERVADO
        * Cuando el valor cambia, notifica a quienes esten vinculados

        Tipos de propiedades:
          SimpleStringProperty   -> String
          SimpleIntegerProperty  -> int/Integer
          SimpleDoubleProperty   -> double/Double
          SimpleBooleanProperty  -> boolean/Boolean
          SimpleObjectProperty   -> cualquier objeto

        Declaracion de propiedades:
          StringProperty  s1 = new SimpleStringProperty("Hola");
          StringProperty  s2 = new SimpleStringProperty("mundo");
          IntegerProperty a  = new SimpleIntegerProperty(5);
          DoubleProperty  euros = new SimpleDoubleProperty(1.123);
          BooleanProperty condicion = new SimpleBooleanProperty(true);

        ================================================================

        --- TIPOS DE BINDING (enlace entre propiedades) ---

        1. BINDING UNIDIRECCIONAL (bind)
           * Una propiedad A depende del valor de B
           * Si B cambia -> A cambia automaticamente
           * Si intentas cambiar A directamente -> EXCEPCION
           * Sintaxis: propiedadA.bind(propiedadB);

        2. BINDING BIDIRECCIONAL (bindBidirectional)
           * Ambas propiedades se actualizan cuando cualquiera cambia
           * Sintaxis: propiedadA.bindBidirectional(propiedadB);
           * En el momento del bind, el valor que prevalece es
             el de la propiedad que se pasa como argumento

        3. BINDING DE EXPRESIONES
           * Permite operaciones complejas entre propiedades
           * Soporta suma, resta, multiplicacion, division, etc.
           * Soporta condiciones (and, or, not)
           * Soporta concatenacion de Strings

        --- EJEMPLOS DE BINDING ---

        // Unidireccional
        StringProperty s1 = new SimpleStringProperty("Hola");
        StringProperty s2 = new SimpleStringProperty("mundo");

        System.out.println(s2.get()); // "mundo" (antes del bind)
        s2.bind(s1);                   // s2 queda vinculado a s1
        System.out.println(s2.get()); // "Hola" (despues del bind)

        s1.set("Adios");
        System.out.println(s2.get()); // "Adios" (se actualiza solo)

        // s2.set("Otra"); -> EXCEPCION! (no se puede cambiar directamente)

        // Bidireccional
        StringProperty s1 = new SimpleStringProperty("Hola");
        StringProperty s2 = new SimpleStringProperty("mundo");

        s1.bindBidirectional(s2);   // Prevalece s2 -> ambas = "mundo"
        s2.set("Adios");
        System.out.println(s1.get()); // "Adios"
        s1.set("Fin");
        System.out.println(s2.get()); // "Fin"

        ================================================================

        --- BINDING DE EXPRESIONES (con operaciones) ---

        // Suma directa entre propiedades
        IntegerProperty a = new SimpleIntegerProperty(5);
        IntegerProperty b = new SimpleIntegerProperty(10);
        IntegerProperty sum = new SimpleIntegerProperty();
        sum.bind(a.add(b));

        System.out.println(sum.get()); // 15

        a.set(20);
        System.out.println(sum.get()); // 30 (se recalcula solo)

        // sum.set(50); -> EXCEPCION! (esta vinculado)

        ================================================================

        --- ESPECIALIZACIONES DE BINDING ---

        NumberBinding:
          * Clase abstracta para valores numericos
          * Depende de uno o mas observables (propiedades)
          * Cuando cambia algun observable, se recalcula

        DoubleBinding:
          * Especializacion de NumberBinding para valores decimales

        StringBinding:
          * Para crear cadenas de texto a partir de observables
          * Usa Bindings.concat() para concatenar

        BooleanBinding:
          * Para propiedades booleanas
          * Soporta and(), or(), not()

        Ejemplo con NumberBinding:
          IntegerProperty a = new SimpleIntegerProperty(5);
          IntegerProperty b = new SimpleIntegerProperty(10);
          NumberBinding suma = a.add(b);
          System.out.println(suma.getValue()); // 15

          a.set(20);
          System.out.println(suma.getValue()); // 30

        Ejemplo con DoubleBinding:
          DoubleProperty x = new SimpleDoubleProperty(2.5);
          DoubleProperty y = new SimpleDoubleProperty(4.5);
          DoubleBinding resultado = x.multiply(y);
          System.out.println(resultado.get()); // 11.25

        Ejemplo con StringBinding:
          StringProperty nombre   = new SimpleStringProperty("Juan");
          StringProperty apellido = new SimpleStringProperty("Perez");
          StringBinding nombreCompleto =
              (StringBinding) Bindings.concat(nombre, " ", apellido);
          System.out.println(nombreCompleto.get()); // "Juan Perez"

          nombre.set("Ana");
          System.out.println(nombreCompleto.get()); // "Ana Perez"

        Ejemplo con BooleanBinding:
          BooleanProperty condA = new SimpleBooleanProperty(true);
          BooleanProperty condB = new SimpleBooleanProperty(false);

          BooleanBinding ambasVerdaderas = condA.and(condB);
          System.out.println(ambasVerdaderas.get()); // false

          condB.set(true);
          System.out.println(ambasVerdaderas.get()); // true

          BooleanBinding cualquieraVerdadera = condA.or(condB);
          System.out.println(cualquieraVerdadera.get()); // true

          BooleanBinding noA = condA.not();
          System.out.println(noA.get()); // false (condA es true)

        ================================================================

        --- CLASE Bindings (metodos estaticos) ---

        Bindings.add(obs1, obs2)         -> Suma
        Bindings.subtract(obs1, obs2)    -> Resta
        Bindings.multiply(obs1, obs2)    -> Multiplicacion
        Bindings.divide(obs1, obs2)      -> Division
        Bindings.concat(obs1, obs2, ...) -> Concatenacion
        Bindings.when(condicion)         -> Condicional
            .then(valorTrue)
            .otherwise(valorFalse)

        Ejemplo con Bindings.when():
          BooleanProperty condicion = new SimpleBooleanProperty(true);
          StringProperty resultado = new SimpleStringProperty("");

          resultado.bind(
              Bindings.when(condicion)
                  .then("Verdadero")
                  .otherwise("Falso")
          );

          System.out.println(resultado.get()); // "Verdadero"
          condicion.set(false);
          System.out.println(resultado.get()); // "Falso"

        ================================================================

        --- EJEMPLO COMPLEJO (analizar antes de ver solucion) ---

        IntegerProperty num1  = new SimpleIntegerProperty(10);
        IntegerProperty num2  = new SimpleIntegerProperty(20);
        IntegerProperty valorCondicion = new SimpleIntegerProperty(50);

        NumberBinding multiplicacion = num1.multiply(num2);
        // multiplicacion = 10 * 20 = 200

        NumberBinding resultado = Bindings.when(multiplicacion.greaterThan(100))
            .then(multiplicacion.add(valorCondicion))
            .otherwise(multiplicacion);
        // resultado = 200 + 50 = 250 (200 > 100 es true)

        System.out.println("Resultado inicial: " + resultado.getValue()); // 250

        num1.set(5);
        // multiplicacion = 5 * 20 = 100
        // 100 > 100 es FALSE -> otherwise -> resultado = 100
        System.out.println("Tras num1=5: " + resultado.getValue()); // 100

        num2.set(25);
        // multiplicacion = 5 * 25 = 125
        // 125 > 100 es TRUE -> then -> resultado = 125 + 50 = 175
        System.out.println("Tras num2=25: " + resultado.getValue()); // 175

        valorCondicion.set(100);
        // multiplicacion sigue = 125
        // 125 > 100 TRUE -> resultado = 125 + 100 = 225
        System.out.println("Tras valorCondicion=100: " + resultado.getValue()); // 225

        ================================================================

        --- EJEMPLO PRACTICO 1: BARRA DE PROGRESO ---

        import javafx.application.Application;
        import javafx.application.Platform;
        import javafx.beans.property.DoubleProperty;
        import javafx.beans.property.SimpleDoubleProperty;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.scene.control.ProgressBar;
        import javafx.scene.layout.VBox;
        import javafx.stage.Stage;

        public class App extends Application {
            @Override
            public void start(Stage stage) {
                VBox root = new VBox(20);
                root.setAlignment(javafx.geometry.Pos.CENTER);

                ProgressBar barra = new ProgressBar(0);
                Label etiqueta = new Label("Procesando...");

                DoubleProperty progressValue = new SimpleDoubleProperty(0);
                barra.progressProperty().bind(progressValue);

                root.getChildren().addAll(barra, etiqueta);

                Scene scene = new Scene(root, 400, 300);
                stage.setTitle("Barra de progreso");
                stage.setScene(scene);
                stage.show();

                // Hilo para simular progreso
                new Thread(() -> {
                    for (int i = 0; i <= 100; i++) {
                        final double progreso = i / 100.0;
                        Platform.runLater(() -> {
                            progressValue.set(progreso);
                            if (progreso >= 1.0) {
                                etiqueta.setText("Completado!");
                                barra.setStyle("-fx-accent: green;");
                            }
                        });
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

            public static void main(String[] args) {
                launch(args);
            }
        }

        Puntos clave:
          * barra.progressProperty() devuelve DoubleProperty
          * Se vincula con bind() a progressValue
          * El hilo NO debe tocar la UI directamente
          * Platform.runLater() ejecuta codigo en el hilo de JavaFX
          * "-fx-accent: green" cambia el color de la barra

        ================================================================

        --- EJEMPLO PRACTICO 2: CONVERSOR DE MONEDAS ---

        import javafx.application.Application;
        import javafx.beans.binding.Bindings;
        import javafx.beans.property.DoubleProperty;
        import javafx.beans.property.SimpleDoubleProperty;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.VBox;
        import javafx.stage.Stage;

        public class App extends Application {
            @Override
            public void start(Stage stage) {
                VBox root = new VBox(10);
                root.setPadding(new javafx.geometry.Insets(20));

                TextField campoEuros = new TextField();
                Label etiquetaDolares = new Label("En dolares: $0.00");

                DoubleProperty euros = new SimpleDoubleProperty(0);
                DoubleProperty tasaCambio = new SimpleDoubleProperty(1.08);

                // Vincular euros al texto del campo (con parseo seguro)
                euros.bind(Bindings.createDoubleBinding(() -> {
                    try {
                        return Double.parseDouble(campoEuros.getText());
                    } catch (NumberFormatException e) {
                        return 0.0;
                    }
                }, campoEuros.textProperty()));

                // Calcular dolares
                DoubleProperty dolares = new SimpleDoubleProperty();
                dolares.bind(euros.multiply(tasaCambio));

                // Vincular la etiqueta al resultado con formato
                etiquetaDolares.textProperty().bind(
                    Bindings.format("En dolares: $%.2f", dolares)
                );

                root.getChildren().addAll(
                    new Label("Euros:"),
                    campoEuros,
                    etiquetaDolares
                );

                Scene scene = new Scene(root, 300, 200);
                stage.setTitle("Conversor de monedas");
                stage.setScene(scene);
                stage.show();
            }

            public static void main(String[] args) {
                launch(args);
            }
        }

        Puntos clave:
          * Bindings.createDoubleBinding() crea un DoubleBinding
            que se evalua cuando cambia el observable (textProperty)
          * Try-catch para NumberFormatException: si no es numero -> 0
          * Bindings.format("$%.2f", dolares) -> formato con 2 decimales
          * Todo se actualiza en TIEMPO REAL al escribir

        ================================================================

        --- PLATFORM.runLater() ---

        * Metodo ESTATICO de javafx.application.Platform
        * Ejecuta un Runnable en el hilo de la aplicacion JavaFX
        * Necesario cuando se modifica la UI desde OTRO hilo
        * Si no se usa -> IllegalStateException:
          "Not on FX application thread"

        Sintaxis:
          Platform.runLater(() -> {
              // codigo que modifica la UI
          });

        ================================================================

        --- CREAR DoubleBinding CON Bindings.createDoubleBinding() ---

        Bindings.createDoubleBinding(
            () -> {
                // Funcion que devuelve un double
                // Se ejecuta cada vez que cambia algun observable
            },
            observable1,   // cambio en observable1 dispara la funcion
            observable2,   // cambio en observable2 tambien
            ...
        );

        ================================================================
        """;

    public static void main(String[] args) {
        mostrarInformacion();
    }

    public static void mostrarInformacion() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("   INFORMACION DEL VIDEO");
        System.out.println("============================================");
        System.out.println("Video:      " + TITULO);
        System.out.println("Canal:      " + CANAL);
        System.out.println("URL Canal:  " + URL_CANAL);
        System.out.println("URL Video:  " + URL);
        System.out.println("Playlist:   " + PLAYLIST);
        System.out.println();
        System.out.println(RESUMEN);
    }
}
