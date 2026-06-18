import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 10-3: JAVA FX - HolaMundo (dos versiones)
 * Version 1: Sin FXML (codigo directo en Java)
 * Version 2: Con FXML (arquitectura MVC)
 *
 * URL: https://www.youtube.com/watch?v=oxqKvOvTn6c&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=212
 */
class Video_10_03_HolaMundoJavaFX {

    public static final String TITULO = "10-3 JAVA FX: HolaMundo ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=oxqKvOvTn6c&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=212";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 10 (JavaFX)";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          10-3 JAVA FX: HolaMundo
        ================================================================

        --- VERSION 1: SIN FXML (codigo Java directo) ---

        App.java:
          import javafx.application.Application;
          import javafx.scene.Scene;
          import javafx.scene.control.Alert;
          import javafx.scene.control.Button;
          import javafx.scene.control.TextField;
          import javafx.scene.layout.VBox;
          import javafx.stage.Stage;

          public class App extends Application {

              @Override
              public void start(Stage stage) {
                  TextField texto = new TextField();
                  Button boton = new Button("Saludar");

                  boton.setOnAction(e -> {
                      String nombre = texto.getText();
                      Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                      alerta.setTitle("Saludo personalizado");
                      // alerta.setHeaderText(null); // opcional: quitar cabecera
                      alerta.setContentText("Hola mundo " + nombre);
                      alerta.show();
                  });

                  VBox vbox = new VBox(10); // 10 = espaciado entre componentes
                  vbox.setAlignment(javafx.geometry.Pos.CENTER);
                  vbox.setPadding(new javafx.geometry.Insets(20));
                  vbox.getChildren().addAll(texto, boton);

                  Scene scene = new Scene(vbox, 300, 150);
                  stage.setTitle("Ejemplo sin FXML");
                  stage.setScene(scene);
                  stage.show();
              }

              public static void main(String[] args) {
                  launch(args);
              }
          }

        Componentes usados:
          * TextField  -> Caja de texto (constructor vacio)
          * Button     -> Boton (constructor con String "Saludar")
          * VBox       -> Contenedor vertical con espaciado 10px
          * Alert      -> Ventana emergente (AlertType.INFORMATION)
          * Insets     -> Padding (margen interno) de 20px en los 4 lados

        Metodos clave:
          * setOnAction()     -> Evento al hacer clic en el boton (lambda)
          * setTitle()        -> Titulo de la ventana/emergente
          * setHeaderText()   -> Cabecera de la alerta (null para quitarla)
          * setContentText()  -> Contenido de la alerta
          * setAlignment()    -> Pos.CENTER centra los componentes
          * setPadding()      -> Margen interno del VBox (Insets)
          * getChildren()     -> Lista de hijos del contenedor

        ================================================================

        --- VERSION 2: CON FXML (arquitectura MVC) ---

        vista.fxml (archivo en src/main/resources/):
          <?xml version="1.0" encoding="UTF-8"?>
          <?import javafx.scene.layout.VBox?>
          <?import javafx.scene.control.TextField?>
          <?import javafx.scene.control.Button?>
          <VBox fx:controller="com.aula.saludo2.ControladorVentana"
                xmlns:fx="http://javafx.com/fxml"
                alignment="CENTER" spacing="10">
              <padding>
                  <Insets top="20" bottom="20" left="20" right="20" />
              </padding>
              <TextField fx:id="texto" />
              <Button fx:id="boton" text="Saludar" onAction="#saludar" />
          </VBox>

        ControladorVentana.java:
          import javafx.fxml.FXML;
          import javafx.scene.control.Alert;
          import javafx.scene.control.Button;
          import javafx.scene.control.TextField;

          public class ControladorVentana {

              @FXML
              private TextField texto;  // fx:id="texto" en el FXML

              @FXML
              private Button boton;     // fx:id="boton" en el FXML

              @FXML
              public void saludar() {
                  String nombre = texto.getText();
                  Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                  alerta.setTitle("Saludo personalizado");
                  alerta.setContentText("Hola mundo " + nombre);
                  alerta.show();
              }
          }

        App.java (version con FXML):
          import javafx.application.Application;
          import javafx.fxml.FXMLLoader;
          import javafx.scene.Parent;
          import javafx.scene.Scene;
          import javafx.stage.Stage;

          public class App extends Application {

              @Override
              public void start(Stage stage) throws Exception {
                  Parent root = FXMLLoader.load(
                      getClass().getResource("vista.fxml")
                  );
                  Scene scene = new Scene(root, 300, 150);
                  stage.setTitle("Ejemplo con FXML");
                  stage.setScene(scene);
                  stage.show();
              }

              public static void main(String[] args) {
                  launch(args);
              }
          }

        ================================================================

        --- RECIBIR EL EVENTO EN EL CONTROLADOR ---

        Se puede recibir el ActionEvent en el metodo del controlador:

          @FXML
          public void saludar(ActionEvent event) {
              // Obtener la fuente del evento (el boton pulsado)
              Button botonPulsado = (Button) event.getSource();
              botonPulsado.setStyle("-fx-background-color: #00ff00");

              String nombre = texto.getText();
              Alert alerta = new Alert(Alert.AlertType.INFORMATION);
              alerta.setTitle("Saludo personalizado");
              alerta.setContentText("Hola mundo " + nombre);
              alerta.show();
          }

        * ActionEvent event -> parametro que recibe info del evento
        * event.getSource() -> devuelve Object (hay que hacer casting)
        * boton.setStyle("-fx-background-color: #00ff00") -> cambia
          el color de fondo del boton a verde
        * se pueden usar colores hexadecimales (#ff0000, #00ff00, etc.)

        ================================================================

        --- ASIGNAR EVENTO DESDE initialize() EN VEZ DE onAction ---

        Se puede quitar el onAction del FXML y asignar el evento
        programaticamente en el metodo initialize():

        FXML (sin onAction):
          <Button fx:id="boton" text="Saludar" />

        Controlador (con initialize):
          @FXML
          public void initialize() {
              // Se ejecuta automaticamente tras cargar el FXML
              boton.setOnAction(e -> saludar());
          }

          @FXML
          public void saludar() {
              String nombre = texto.getText();
              Alert alerta = new Alert(Alert.AlertType.INFORMATION);
              alerta.setTitle("Saludo personalizado");
              alerta.setContentText("Hola mundo " + nombre);
              alerta.show();
          }

        * initialize() se ejecuta automaticamente tras cargar la vista
        * Se pueden pasar ActionEvent desde la lambda:
            boton.setOnAction(e -> saludar(e));

        ================================================================

        --- module-info.java (para proyecto modular) ---

          module com.aula.saludo2 {
              requires javafx.controls;
              requires javafx.fxml;
              requires transitive javafx.graphics;  // evitar warning
              opens com.aula.saludo2 to javafx.fxml;
              exports com.aula.saludo2;
          }

        * transitive: necesario si hay advertencia de acceso
        * opens: permite que JavaFX acceda al paquete via reflexion
        * exports: exporta el paquete a otros modulos

        ================================================================

        --- COMPARATIVA: SIN FXML vs CON FXML ---

        | Aspecto        | Sin FXML                | Con FXML               |
        |----------------|-------------------------|------------------------|
        | Vista          | Codigo Java (VBox...)   | Archivo .fxml aparte   |
        | Controlador    | En el mismo App.java    | Clase separada         |
        | Modelo         | -                       | Se puede anadir        |
        | Mantenibilidad | Baja (mezcla UI/logica) | Alta (separacion MVC)  |
        | Complejidad    | Menos archivos          | Mas archivos pero      |
        |                |                         | mejor organizado       |

        ================================================================

        --- PASOS PARA CREAR PROYECTO CON FXML EN VS CODE ---

        1. Ctrl+Shift+P -> Create Java Project -> Maven
        2. More -> OpenJFX -> javafx-archetype-fxml
        3. groupId: com.aula.saludo2, artifactId: saludo2
        4. Version: 1.0
        5. En module-info.java anadir "transitive" si hay warning
        6. Crear vista.fxml en src/main/resources/
        7. Crear ControladorVentana.java en src/main/java/
        8. Modificar App.java para cargar el FXML
        9. Ejecutar

        ================================================================
        """;

    /**
     * Version 1: Sin FXML (codigo directo en Java)
     * Muestra un TextField + boton "Saludar".
     * Al pulsar el boton, muestra una alerta con el nombre introducido.
     */
    public static class AppSinFXML extends Application {

        @Override
        public void start(Stage stage) {
            TextField texto = new TextField();
            Button boton = new Button("Saludar");

            boton.setOnAction(e -> {
                String nombre = texto.getText();
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Saludo personalizado");
                alerta.setContentText("Hola mundo " + nombre);
                alerta.show();
            });

            VBox vbox = new VBox(10);
            vbox.setAlignment(javafx.geometry.Pos.CENTER);
            vbox.setPadding(new javafx.geometry.Insets(20));
            vbox.getChildren().addAll(texto, boton);

            Scene scene = new Scene(vbox, 300, 150);
            stage.setTitle("Ejemplo sin FXML");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }

    /**
     * Version 2: Con FXML - Controlador
     * Enlaza los componentes de vista.fxml y maneja el evento.
     */
    public static class ControladorVentana {

        @FXML
        private TextField texto;

        @FXML
        private Button boton;

        @FXML
        public void initialize() {
            // Opcion 1: asignar evento desde initialize()
            // boton.setOnAction(e -> saludar());
        }

        @FXML
        public void saludar() {
            String nombre = texto.getText();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Saludo personalizado");
            alerta.setContentText("Hola mundo " + nombre);
            alerta.show();
        }
    }

    /**
     * Version 2: Con FXML - App que carga la vista
     */
    public static class AppConFXML extends Application {

        @Override
        public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(
                getClass().getResource("vista.fxml")
            );
            Scene scene = new Scene(root, 300, 150);
            stage.setTitle("Ejemplo con FXML");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("   " + TITULO);
        System.out.println("============================================");
        System.out.println("Video: " + URL);
        System.out.println();
        System.out.println(CONTENIDO);
        System.out.println();
        System.out.println("Para ejecutar la Version 1 (sin FXML):");
        System.out.println("  Video_10_03_HolaMundoJavaFX$AppSinFXML.main(args)");
        System.out.println();
        System.out.println("Para ejecutar la Version 2 (con FXML):");
        System.out.println("  Necesita crear vista.fxml en resources/");
        System.out.println("  y ejecutar AppConFXML.main(args)");
    }
}
