

class Video_10_05_Layouts {

    public static final String TITULO = "10-5 JAVA FX: Layouts ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=ZqFSvySxVBM&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=214";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 10 (JavaFX)";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          10-5 JAVA FX: LAYOUTS
        ================================================================

        --- QUE SON LOS LAYOUTS? ---

        * Contenedores que organizan los componentes de una forma
          determinada
        * Permiten posicionar nodos dentro de un area de la ventana
        * Se pueden anidar (layout dentro de layout) para interfaces
          complejas
        * Todos heredan de la clase Pane (que hereda de Region -> Parent)

        --- TIPOS DE LAYOUTS EN JAVA FX ---

        1. Pane:
           * Layout mas simple, sin esquema de diseno especifico
           * Permite posicionamiento manual de los nodos
           * Superclase de todos los demas layouts

        2. StackPane:
           * Organiza nodos en una PILA, uno ENCIMA del otro
           * Util para superponer elementos graficos

        3. VBox (Vertical Box):
           * Coloca nodos VERTICALMENTE (uno bajo otro)
           * Constructor: VBox(espaciado) o VBox()
           * Ej: VBox(10) -> separacion de 10px entre componentes

        4. HBox (Horizontal Box):
           * Coloca nodos HORIZONTALMENTE (uno al lado del otro)
           * Constructor: HBox(espaciado)
           * Ej: HBox(10) -> separacion de 10px entre componentes

        5. GridPane:
           * Organiza nodos en una REJILLA bidimensional (filas y cols)
           * Similar a una tabla
           * Mayor control sobre dimensiones de filas y columnas
           * grid.add(componente, columna, fila);

        6. BorderPane:
           * Divide el area en CINCO regiones:
             - Top (arriba), Bottom (abajo)
             - Left (izquierda), Right (derecha)
             - Center (centro)
           * border.setTop(componente);
           * border.setCenter(componente);
           * border.setBottom(componente);
           * border.setLeft(componente);
           * border.setRight(componente);

        7. FlowPane:
           * Coloca elementos en una FILA
           * Cuando se alcanza el borde, pasa a la SIGUIENTE fila
           * Se ajusta automaticamente al escalar la ventana
           * Ej: Si hay 3 botones y al achicar la ventana no caben,
             los que no caben bajan a la fila de abajo

        8. TilePane:
           * Coloca nodos en una cuadricula
           * TODOS los nodos tienen el MISMO tamano
           * Similar a GridPane pero sin control individual
           * Util para elementos alineados uniformemente

        9. AnchorPane:
           * Permite ANCLAR nodos a los bordes del layout
           * AnchorPane.setTopAnchor(nodo, distancia);
           * AnchorPane.setBottomAnchor(nodo, distancia);
           * AnchorPane.setLeftAnchor(nodo, distancia);
           * AnchorPane.setRightAnchor(nodo, distancia);
           * Util para disenos que se ajustan al cambiar tamano
             de la ventana

        ================================================================

        --- EJEMPLO COMPARATIVO: HBox vs VBox ---

        // HBox: botones uno al lado del otro (horizontal)
        Button btn1 = new Button("Insertar");
        Button btn2 = new Button("Modificar");
        Button btn3 = new Button("Listar");

        HBox hbox = new HBox(10);   // separacion 10px
        hbox.getChildren().addAll(btn1, btn2, btn3);
        hbox.setAlignment(javafx.geometry.Pos.CENTER);
        hbox.setPadding(new javafx.geometry.Insets(20));

        // Resultado: [Insertar] [Modificar] [Listar] (horizontal)

        // VBox: mismos botones uno bajo otro (vertical)
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(btn1, btn2, btn3);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        vbox.setPadding(new javafx.geometry.Insets(20));

        // Resultado: [Insertar]  (vertical)
        //            [Modificar]
        //            [Listar]

        ================================================================

        --- COMBINACION DE LAYOUTS ---

        Se pueden anidar layouts para crear interfaces complejas:

        VBox principal
        |-- HBox (fila superior con botones)
        |   |-- Button "Insertar"
        |   |-- Button "Modificar"
        |   |-- Button "Listar"
        |-- FlowPane (area principal)
            |-- Label "Esto es una etiqueta"

        Codigo:
          Button btn1 = new Button("Insertar");
          Button btn2 = new Button("Modificar");
          Button btn3 = new Button("Listar");

          HBox hbox = new HBox(10);
          hbox.getChildren().addAll(btn1, btn2, btn3);

          Label etiqueta = new Label("Esto es una etiqueta");
          FlowPane flow = new FlowPane();
          flow.getChildren().add(etiqueta);

          VBox vbox = new VBox(10);
          vbox.getChildren().addAll(hbox, flow);

          Scene scene = new Scene(vbox, 400, 300);

        ================================================================

        --- EJEMPLO COMPLETO DEL VIDEO: BorderPane COMPUESTO ---

        import javafx.application.Application;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.BorderPane;
        import javafx.scene.layout.HBox;
        import javafx.scene.layout.VBox;
        import javafx.stage.Stage;

        public class App extends Application {

            @Override
            public void start(Stage stage) {
                // 5 botones
                Button btnInsertar = new Button("Insertar");
                Button btnModificar = new Button("Modificar");
                Button btnListar = new Button("Listar");
                Button btnBorrar = new Button("Borrar");
                Button btnReiniciar = new Button("Reiniciar");

                // --- CONTENEDOR SUPERIOR (HBox) ---
                HBox hboxSup = new HBox(10);
                hboxSup.getChildren().addAll(btnInsertar, btnModificar, btnListar);
                hboxSup.setAlignment(javafx.geometry.Pos.CENTER);

                // --- CONTENEDOR CENTRAL (VBox con Label + ImageView) ---
                Label etiqueta = new Label("Esto es una etiqueta");

                // Cargar imagen desde resources/
                Image imagen = new Image(
                    getClass().getResourceAsStream("/javafx-logo.png")
                );
                ImageView imageView = new ImageView(imagen);

                VBox vboxCentro = new VBox(10);
                vboxCentro.getChildren().addAll(etiqueta, imageView);
                vboxCentro.setAlignment(javafx.geometry.Pos.CENTER);

                // --- CONTENEDOR INFERIOR (HBox) ---
                HBox hboxInf = new HBox(10);
                hboxInf.getChildren().addAll(btnBorrar, btnReiniciar);
                hboxInf.setAlignment(javafx.geometry.Pos.CENTER);

                // --- LAYOUT PRINCIPAL (BorderPane) ---
                BorderPane border = new BorderPane();
                border.setTop(hboxSup);
                border.setCenter(vboxCentro);
                border.setBottom(hboxInf);
                border.setPadding(new javafx.geometry.Insets(20));

                // --- ESCENA ---
                Scene scene = new Scene(border, 600, 400);
                stage.setTitle("Ejemplos Layouts");
                stage.setScene(scene);
                stage.show();
            }

            public static void main(String[] args) {
                launch(args);
            }
        }

        Estructura de la ventana:
          +------------------------------------------+
          |  [Insertar]  [Modificar]  [Listar]       | <- HBox (top)
          |                                (centrado) |
          |------------------------------------------|
          |                                          |
          |       "Esto es una etiqueta"             | <- VBox (center)
          |                                          |
          |            [JavaFX Logo]                 |
          |                                          |
          |------------------------------------------|
          |       [Borrar]  [Reiniciar]              | <- HBox (bottom)
          |                                (centrado) |
          +------------------------------------------+

        ================================================================

        --- OBSERVACIONES ---

        * ImageView (javafx.scene.image.ImageView):
          - Clase para mostrar imagenes en JavaFX
          - Constructor: ImageView(Image image)
          - Image se crea con:
              Image img = new Image(getClass().getResourceAsStream("/ruta.png"));
          - La imagen debe estar en src/main/resources/
          - La barra "/" al inicio indica raiz de resources

        * BorderPane.setPadding(new Insets(20)):
          - Margen interno de 20px en los 4 lados
          - Aplica al contenedor principal, no a los hijos

        * Pos.CENTER:
          - Los contenedores secundarios se centran en sus regiones
          - Se puede combinar con otros valores (TOP_LEFT, etc.)

        * Espaciado (10 en los constructores):
          - Separa los componentes hijos entre si
          - No confundir con padding (margen interno del contenedor)

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
