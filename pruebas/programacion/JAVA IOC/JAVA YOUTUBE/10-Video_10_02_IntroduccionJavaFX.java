

class Video_10_02_IntroduccionJavaFX {

    public static final String TITULO = "10-2 Introduccion a JavaFX DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=HOr5djeytsA&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=211";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 10 (JavaFX)";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          10-2 INTRODUCCION A JAVA FX
        ================================================================

        --- HISTORIA DE JAVA FX ---

        * JavaFX: evolucion de Java Swing
        * Swing se quedo limitado con moviles, tablets, etc.
        * Bibliotecas graficas avanzadas: formas 2D, 3D, imagenes,
          multimedia, CSS para disenar interfaces
        * Originalmente desarrollado y mantenido por Oracle
        * Incluido en el JDK oficial desde Java 8 (2014)
        * A partir de Java 11: Oracle descontinuo su soporte
        * Separado del JDK -> codigo abierto: OpenJFX
        * Mantenido por la comunidad: https://github.com/openjdk/jfx
        * Implementacion usada en el curso: OpenJFX
        * Otras implementaciones comerciales: Gluon (para moviles)

        --- API DE OPENJFX ---

        Clases principales:
          Application    -> Clase base que deben heredar las apps JavaFX
          Stage          -> Ventana principal de la aplicacion
          Scene          -> Contiene todos los elementos de una ventana
          Node           -> Elementos individuales (boton, label, tabla...)

        --- PRIMER EJEMPLO: HOLA MUNDO (sin FXML) ---

        import javafx.application.Application;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.stage.Stage;

        public class App extends Application {

            @Override
            public void start(Stage stage) {
                Button boton = new Button("Saludar");
                boton.setOnAction(e -> System.out.println("Hola mundo desde JavaFX"));

                Scene scene = new Scene(boton, 200, 100);
                stage.setScene(scene);
                stage.setTitle("Hola mundo FX");
                stage.show();
            }

            public static void main(String[] args) {
                launch(args);
            }
        }

        Metodo launch():
          * Punto de entrada de cualquier app JavaFX
          * Inicializa el entorno de JavaFX
          * Llama al metodo start() con un Stage (ventana principal)

        --- ARQUITECTURA MVC (Modelo-Vista-Controlador) ---

        Modelo (Model):
          * Representa la logica de negocio y los datos
          * NO sabe nada sobre la interfaz de usuario
          * Coleccion de metodos utilizados por el controlador

        Vista (View):
          * Lo que se muestra al usuario (interfaz)
          * Se disena mediante un archivo FXML (XML-based)
          * Obtiene datos del modelo para representarlos
          * Envia acciones del usuario al controlador

        Controlador (Controller):
          * Intermediario entre el modelo y la vista
          * Recibe acciones de la vista y solicita metodos al modelo
          * Actualiza la vista segun los cambios del modelo

        Beneficios de MVC:
          * Separacion de la interfaz de la logica de la aplicacion
          * Codigo mas mantenible y escalable
          * Facilita el trabajo en equipo

        --- ARCHIVO FXML ---

        * Lenguaje de marcado basado en XML para disenar la vista
        * Separa la interfaz de la logica de la aplicacion

        Ejemplo basico de FXML:
          <?xml version="1.0" encoding="UTF-8"?>
          <?import javafx.scene.layout.AnchorPane?>
          <?import javafx.scene.control.Button?>
          <AnchorPane fx:controller="miControlador"
                      xmlns:fx="http://javafx.com/fxml">
              <Button fx:id="miBoton" text="Haz clic aqui" />
          </AnchorPane>

        Elementos clave del FXML:
          * fx:controller -> Clase Java que controla este componente
          * fx:id         -> Identificador para acceder al componente
                             desde el controlador
          * onAction      -> Metodo del controlador que se ejecuta
                             al hacer clic

        --- CONTROLADOR EN JAVA ---

        import javafx.fxml.FXML;
        import javafx.scene.control.Button;

        public class miControlador {

            @FXML
            private Button miBoton;  // fx:id="miBoton" en el FXML

            @FXML
            public void initialize() {
                // Se ejecuta automaticamente DESPUES de cargar
                // todos los elementos de la interfaz desde el FXML
                miBoton.setOnAction(e -> System.out.println("Boton pulsado"));
            }
        }

        Anotacion @FXML:
          * Marca campos y metodos para enlazar con el FXML
          * El nombre del campo debe coincidir con el fx:id del FXML
          * Normalmente hay UNA unica clase controladora por FXML
          * Se asigna en el elemento raiz del FXML

        Metodo initialize():
          * Se llama automaticamente tras cargar todos los elementos
          * Es el lugar ideal para configurar eventos y crear instancias

        --- EJEMPLO COMPLETO MVC: CONTADOR ---

        MODELO (Contador.java):
          public class Contador {
              private int n = 0;
              public void incrementar() { n++; }
              public int getValor() { return n; }
          }

        VISTA (vista.fxml):
          <?xml version="1.0" encoding="UTF-8"?>
          <?import javafx.scene.layout.VBox?>
          <?import javafx.scene.control.Button?>
          <?import javafx.scene.control.Label?>
          <VBox fx:controller="Controlador"
                xmlns:fx="http://javafx.com/fxml">
              <Label fx:id="textoEtiqueta" text="Pulsa el boton" />
              <Button fx:id="botonIncrementar" text="Incrementar" />
          </VBox>

        CONTROLADOR (Controlador.java):
          import javafx.fxml.FXML;
          import javafx.scene.control.Button;
          import javafx.scene.control.Label;

          public class Controlador {
              @FXML private Button botonIncrementar;
              @FXML private Label textoEtiqueta;

              private Contador contador;

              @FXML
              public void initialize() {
                  contador = new Contador();
                  botonIncrementar.setOnAction(e -> {
                      contador.incrementar();
                      textoEtiqueta.setText("Contador: " + contador.getValor());
                  });
              }
          }

        APP PRINCIPAL (App.java):
          import javafx.application.Application;
          import javafx.fxml.FXMLLoader;
          import javafx.scene.Parent;
          import javafx.scene.Scene;
          import javafx.stage.Stage;

          public class App extends Application {
              @Override
              public void start(Stage stage) throws Exception {
                  Parent root = FXMLLoader.load(getClass().getResource("vista.fxml"));
                  Scene scene = new Scene(root);
                  stage.setScene(scene);
                  stage.setTitle("JavaFX Demo");
                  stage.show();
              }

              public static void main(String[] args) {
                  launch(args);
              }
          }

        --- ARCHIVO module-info.java ---

        * Se anade si la aplicacion esta modularizada (Java 9+)
        * Especifica que modulos del JDK o terceros se requieren
        * Mejora la modularidad y el encapsulamiento
        * Permite a la JVM realizar optimizaciones adicionales

        Ejemplo:
          module com.aula.fx.prueba1 {
              requires javafx.controls;
              requires javafx.fxml;
              opens com.aula.fx.prueba1 to javafx.fxml;
              exports com.aula.fx.prueba1;
          }

        * Si el modulo no es accesible: anadir "transitive"
        * opens: permite que JavaFX acceda a las clases del paquete

        --- CAMBIO DE VISTAS (MULTIPLE SCENES) ---

        * Se pueden tener varios archivos FXML para distintas vistas
        * Cada vista tiene su propio controlador
        * El controlador puede cambiar de vista usando:
            stage.setScene(scene);
        * Ejemplo: primary.fxml <-> secondary.fxml
        * En el controlador se inyecta el Stage via:
            ((Stage) boton.getScene().getWindow()).setScene(nuevaScene);

        --- RECURSOS ADICIONALES ---

        * Documentacion oficial OpenJFX: https://openjfx.io/
        * API JavaFX: https://openjfx.io/javadoc/
        * Repositorio: https://github.com/openjdk/jfx

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
