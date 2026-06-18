

class Video_10_08_CSS {

    public static final String TITULO = "10-8 JAVA FX: Uso de CSS ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=8Rv4SHZ-9xM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=217";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 10 (JavaFX)";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          10-8 JAVA FX: USO DE CSS
        ================================================================

        --- VINCULAR CSS A UNA ESCENA ---

        Para asociar un archivo .css a una escena JavaFX:

          scene.getStylesheets().add(
              getClass().getResource("/css/estilos.css").toExternalForm()
          );

        * El archivo debe estar en src/main/resources/
        * getResource() devuelve una URL
        * toExternalForm() convierte la URL a String
        * Se puede usar toString() pero toExternalForm() es lo
          recomendado en JavaFX

        Ejemplo completo:
          Parent root = FXMLLoader.load(getClass().getResource("vista.fxml"));
          Scene scene = new Scene(root, 500, 400);
          scene.getStylesheets().add(
              getClass().getResource("/css/estilos.css").toExternalForm()
          );
          stage.setScene(scene);
          stage.show();

        ================================================================

        --- SELECTORES CSS EN JAVA FX ---

        Selector de CLASE (.nombreClase):
          .boton-personalizado {
              -fx-background-color: #3498db;
              -fx-text-fill: white;
          }

        Selector de ID (#nombreId):
          #texto-destacado {
              -fx-font-size: 20px;
              -fx-font-weight: bold;
              -fx-text-fill: #2ecc71;
              -fx-font-family: "Arial";
          }

        Selector de TIPO (Button, Label, Text...):
          Button {
              -fx-background-color: #2ecc71;
              -fx-text-fill: white;
              -fx-background-radius: 5px;
              -fx-border-radius: 5px;
              -fx-padding: 10 20;
          }

          Label {
              -fx-text-fill: #333333;
              -fx-font-size: 14px;
          }

        ================================================================

        --- PROPIEDADES CSS TIPICAS EN JAVA FX ---

        Propiedad CSS              Descripcion
        --------------------------  ------------------------------------
        -fx-background-color        Color de fondo
        -fx-text-fill               Color del texto
        -fx-font-size               Tamano de la letra
        -fx-font-weight             Negrita (bold, normal)
        -fx-font-family             Tipografia (Arial, Verdana...)
        -fx-background-radius       Radio de las esquinas del fondo
        -fx-border-radius           Radio de las esquinas del borde
        -fx-border-color            Color del borde
        -fx-border-width            Ancho del borde
        -fx-padding                 Margen interno (arriba/abajo izq/der)
        -fx-accent                  Color de acento (ProgressBar, etc.)

        Diferencia con CSS web:
          * En JavaFX las propiedades empiezan con -fx-
          * Ej: CSS web: background-color -> JavaFX: -fx-background-color
          * Ej: CSS web: font-size -> JavaFX: -fx-font-size

        ================================================================

        --- ASIGNAR CLASE CSS A UN COMPONENTE ---

        Desde codigo Java:
          boton.getStyleClass().add("boton-personalizado");
          // No se incluye el punto, solo el nombre de la clase

        Desde FXML:
          <Button styleClass="boton-1" text="Saludar" />

        ================================================================

        --- ASIGNAR ID CSS A UN COMPONENTE ---

        Desde codigo Java:
          Text texto = new Text("Texto destacado");
          texto.setId("texto-destacado");

        Desde FXML:
          <Label fx:id="etiquetaPrincipal" text="Ejemplos CSS" />

        Nota: el fx:id en FXML sirve tanto para acceder desde el
        controlador (@FXML) como para aplicar CSS con #nombreId.

        ================================================================

        --- ESTILOS EN LINEA (setStyle) ---

        * Se aplican directamente al componente con setStyle()
        * Anulan CUALQUIER estilo definido en CSS externo
        * NO es recomendable usarlos (dificil mantenimiento)
        * Prioridad: estilo en linea > clase CSS > tipo CSS

        Ejemplo:
          Button b1 = new Button("Pulsa 1");
          b1.setStyle("-fx-background-color: red; -fx-text-fill: white;");

        Usar solo en casos concretos. Para aplicaciones grandes
        siempre es mejor usar archivos CSS externos.

        ================================================================

        --- PRIORIDAD DE ESTILOS ---

        1. Estilo en LINEA (setStyle) -> maxima prioridad
        2. Clase CSS anadida con getStyleClass().add()
        3. Selector de tipo (Button, Label, Text...)
        4. Estilo por defecto de JavaFX

        Si un componente tiene una clase CSS y un estilo en linea,
        el estilo en linea prevalece sobre la clase.

        ================================================================

        --- EJEMPLO COMPLETO: CSS + FXML + MULTIPLES VENTANAS ---

        ESTRUCTURA DEL PROYECTO:
          src/
            main/
              java/com/aula/estilos/
                App.java
                ControladorVentanaPrincipal.java
                ControladorVentanaSecundaria.java
              resources/
                fxml/
                  ventanaPrincipal.fxml
                  ventanaSecundaria.fxml
                css/
                  estilosVentanaPrincipal.css
                  estilosVentanaSecundaria.css

        --- ventanaPrincipal.fxml ---
          <?xml version="1.0" encoding="UTF-8"?>
          <?import javafx.scene.layout.VBox?>
          <?import javafx.scene.control.Label?>
          <?import javafx.scene.control.Button?>
          <VBox fx:controller="com.aula.estilos.ControladorVentanaPrincipal"
                xmlns:fx="http://javafx.com/fxml"
                spacing="20" alignment="CENTER"
                padding="20">
              <Label fx:id="etiquetaPrincipal" text="Ejemplos CSS con JavaFX y FXML"
                     styleClass="etiqueta-principal" />
              <Button fx:id="botonPrincipal" text="Saludar"
                      styleClass="boton-1" onAction="#saludo" />
              <Button fx:id="botonSecundario" text="Modificar estilo"
                      styleClass="boton-1" onAction="#modificarEstilo" />
          </VBox>

        --- estilosVentanaPrincipal.css ---
          #etiquetaPrincipal {
              -fx-text-fill: #2c3e50;
              -fx-font-size: 18px;
              -fx-font-weight: bold;
          }

          .boton-1 {
              -fx-background-color: #9b59b6;
              -fx-text-fill: white;
              -fx-background-radius: 5px;
              -fx-border-radius: 5px;
              -fx-padding: 8 16;
          }

          .boton-2 {
              -fx-background-color: #e67e22;
              -fx-text-fill: white;
              -fx-background-radius: 5px;
              -fx-border-radius: 5px;
              -fx-padding: 8 16;
          }

        --- ControladorVentanaPrincipal.java ---
          public class ControladorVentanaPrincipal {

              @FXML private Button botonPrincipal;
              @FXML private Button botonSecundario;
              private int estiloBoton = 0;

              @FXML
              public void saludo() {
                  Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                  alerta.setTitle("Saludo");
                  alerta.setHeaderText(null);
                  alerta.setContentText("Hola mundo desde JavaFX");
                  alerta.show();
              }

              @FXML
              public void modificarEstilo() {
                  if (estiloBoton % 2 == 0) {
                      // Cambiar a boton-2
                      botonPrincipal.getStyleClass().removeAll("boton-1");
                      botonPrincipal.getStyleClass().add("boton-2");
                      botonSecundario.getStyleClass().removeAll("boton-1");
                      botonSecundario.getStyleClass().add("boton-2");
                  } else {
                      // Cambiar a boton-1
                      botonPrincipal.getStyleClass().removeAll("boton-2");
                      botonPrincipal.getStyleClass().add("boton-1");
                      botonSecundario.getStyleClass().removeAll("boton-2");
                      botonSecundario.getStyleClass().add("boton-1");
                  }
                  estiloBoton++;
              }
          }

        --- ventanaSecundaria.fxml ---
          <?xml version="1.0" encoding="UTF-8"?>
          <?import javafx.scene.layout.VBox?>
          <?import javafx.scene.control.Label?>
          <?import javafx.scene.control.Button?>
          <VBox fx:controller="com.aula.estilos.ControladorVentanaSecundaria"
                xmlns:fx="http://javafx.com/fxml"
                spacing="20" alignment="CENTER"
                padding="20">
              <Label text="Ventana secundaria" />
              <Button fx:id="botonCerrar" text="Cerrar ventana"
                      onAction="#cerrarVentana" />
          </VBox>

        --- estilosVentanaSecundaria.css ---
          Label {
              -fx-text-fill: #2c3e50;
              -fx-font-size: 18px;
              -fx-font-weight: bold;
          }

          #botonCerrar {
              -fx-background-color: #3498db;
              -fx-text-fill: white;
              -fx-font-size: 14px;
              -fx-background-radius: 5px;
              -fx-border-radius: 5px;
              -fx-padding: 8 16;
          }

        --- ControladorVentanaSecundaria.java ---
          public class ControladorVentanaSecundaria {

              @FXML private Button botonCerrar;

              @FXML
              public void cerrarVentana() {
                  Stage ventana = (Stage) botonCerrar.getScene().getWindow();
                  ventana.close();
              }
          }

        --- App.java ---
          public class App extends Application {

              @Override
              public void start(Stage ventanaPrincipal) throws Exception {
                  Parent root = FXMLLoader.load(
                      getClass().getResource("/fxml/ventanaPrincipal.fxml")
                  );
                  Scene scene = new Scene(root, 500, 400);
                  scene.getStylesheets().add(
                      getClass().getResource("/css/estilosVentanaPrincipal.css")
                          .toExternalForm()
                  );

                  ventanaPrincipal.setTitle("Ventana principal");
                  ventanaPrincipal.setScene(scene);
                  ventanaPrincipal.show();

                  // Abrir ventana secundaria
                  abrirVentanaSecundaria();

                  // Al cerrar la principal, terminar todo
                  ventanaPrincipal.setOnCloseRequest(e -> {
                      Platform.exit();
                      System.exit(0);
                  });
              }

              private void abrirVentanaSecundaria() throws Exception {
                  Stage ventanaSecundaria = new Stage();
                  Parent root = FXMLLoader.load(
                      getClass().getResource("/fxml/ventanaSecundaria.fxml")
                  );
                  Scene scene = new Scene(root, 300, 200);
                  scene.getStylesheets().add(
                      getClass().getResource("/css/estilosVentanaSecundaria.css")
                          .toExternalForm()
                  );

                  ventanaSecundaria.setTitle("Ventana secundaria");
                  ventanaSecundaria.setScene(scene);
                  ventanaSecundaria.show();
              }

              public static void main(String[] args) {
                  launch(args);
              }
          }

        ================================================================

        --- CAMBIAR HOJA DE ESTILOS COMPLETA ---

        En lugar de cambiar clase por clase, se puede cambiar
        la hoja de estilos completa:

          // Quitar la hoja actual
          scene.getStylesheets().clear();

          // Anadir la nueva hoja
          scene.getStylesheets().add(
              getClass().getResource("/css/estilosVentanaPrincipal2.css")
                  .toExternalForm()
          );

        * Util cuando se quiere cambiar el estilo de MUCHOS
          componentes a la vez (temas completos)
        * Las clases se definen con el mismo nombre en ambos CSS
        * Solo cambian las propiedades dentro de cada clase

        ================================================================

        --- DOCUMENTACION DE CSS PARA JAVA FX ---

        * Repositorio oficial OpenJFX:
          https://github.com/openjdk/jfx
        * Documentacion CSS JavaFX (OpenJFX):
          https://openjfx.io/javadoc/
        * La referencia CSS contiene todas las propiedades
          disponibles para cada componente

        ================================================================

        --- REGLAS IMPORTANTES ---

        1. Los archivos CSS deben ir en src/main/resources/
        2. Las propiedades CSS en JavaFX empiezan con -fx-
        3. Los estilos en LINEA (setStyle) tienen maxima prioridad
        4. No es recomendable usar estilos en linea (dificil
           mantenimiento)
        5. Para cambiar estilos de muchos componentes, cambiar
           la hoja CSS completa
        6. Para cerrar ventanas: ((Stage) boton.getScene().getWindow()).close()
        7. Para que el programa termine al cerrar la principal:
             ventanaPrincipal.setOnCloseRequest(e -> {
                 Platform.exit();
                 System.exit(0);
             });

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
