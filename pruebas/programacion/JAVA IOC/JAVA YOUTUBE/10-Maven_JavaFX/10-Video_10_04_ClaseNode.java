

class Video_10_04_ClaseNode {

    public static final String TITULO = "10-4 JAVA FX: Clase Node ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=3pRevR7Pml4&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=213";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 10 (JavaFX)";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          10-4 JAVA FX: CLASE NODE
        ================================================================

        --- QUE ES LA CLASE NODE? ---

        * Superclase de TODOS los elementos que pueden ser
          renderizados en una escena de JavaFX
        * Incluye: formas basicas, controles, contenedores,
          imagenes, texto, multimedia, web, etc.
        * TODOS los componentes heredan de Node

        --- CARACTERISTICAS DE LOS NODOS ---

        1. Posicion y tamaño:
           - Posicion: coordenadas X, Y, Z (3D) -> setTranslateX(), etc.
           - Tamaño: width (ancho) y height (alto) -> 2D
           - Profundidad (depth): solo en subclases 3D (paquete shape)
             con el atributo "depth"

        2. Estilo y apariencia:
           - Se pueden estilizar con JavaFX CSS
           - Colores, sombras, desenfoques, etc.
           - Se vera en detalle en un video dedicado a CSS

        3. Eventos:
           - API para manejar clics, teclado, interacciones
           - Se vera en detalle en video dedicado a Eventos

        4. Transformaciones:
           - Traslacion (mover): setTranslateX(), setTranslateY()
           - Rotacion: setRotate(angulo)
           - Escalado: setScaleX(factor), setScaleY(factor)
           - Visibilidad: setVisible(boolean)
           - Deshabilitar: setDisable(boolean)

        5. Estructura en arbol (Scene Graph):
           - Un nodo puede tener un padre y varios hijos
           - Forma una jerarquia en arbol -> Scene Graph
           - Ver clase Parent para mas detalle

        --- METODOS IMPORTANTES DE LA CLASE NODE ---

        Metodo                      Descripcion
        -------------------------- ------------------------------------
        setTranslateX(double)       Mueve el nodo en el eje X (px)
        setTranslateY(double)       Mueve el nodo en el eje Y (px)
        setRotate(double)           Rota el nodo (grados)
        setScaleX(double)           Escala horizontal (1.0 = 100%)
        setScaleY(double)           Escala vertical (1.0 = 100%)
        setVisible(boolean)         Muestra/oculta el nodo
        setDisable(boolean)         Habilita/deshabilita interaccion
        setStyle(String)            Aplica CSS inline al nodo

        --- EJEMPLO: METODOS DE NODE SOBRE UN BOTON ---

        import javafx.application.Application;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.stage.Stage;

        public class App extends Application {
            @Override
            public void start(Stage stage) {
                Button boton = new Button("Pulsa");

                // Metodos de Node aplicados al boton
                boton.setTranslateX(50);   // mover 50px a la derecha
                boton.setTranslateY(50);   // mover 50px hacia abajo
                boton.setRotate(45);       // rotar 45 grados
                boton.setScaleX(1.5);      // escalar 1.5x en horizontal

                // Nota: Aunque se puede pasar un Node directamente
                // a la Scene, es mejor usar un contenedor (Parent)
                Scene scene = new Scene(boton, 500, 500);
                stage.setTitle("Ejemplo Node");
                stage.setScene(scene);
                stage.show();
            }

            public static void main(String[] args) {
                launch(args);
            }
        }

        ================================================================

        --- CLASE PARENT (subclase de Node) ---

        * Clase abstracta que puede tener nodos hijos
        * Permite crear jerarquias de componentes (Scene Graph)
        * Un objeto Parent es un objeto que puede tener nodos hijos
        * Subclases principales: Group, Region, Pane, etc.

        Caracteristicas de Parent:
          1. Contiene multiples nodos hijos
          2. Los hijos a su vez pueden ser Parent (anidamiento)
          3. Transformaciones aplicadas al parent afectan a TODOS
             los hijos
          4. Estilo aplicado al parent puede heredarse a los hijos
          5. Puede capturar eventos que se propaguen desde los hijos

        Subclases de Parent mas usadas:
          * Group       -> Agrupa nodos sin aplicar diseno especifico
          * Region      -> Base para paneles redimensionables
          * Pane        -> Contenedor base para todos los paneles
          * VBox        -> Contenedor vertical
          * HBox        -> Contenedor horizontal
          * AnchorPane  -> Ancla nodos a los bordes
          * GridPane    -> Diseno en cuadricula (tabla)
          * BorderPane  -> Areas: top, bottom, left, right, center
          * StackPane   -> Apila nodos uno encima del otro
          * FlowPane    -> Flujo horizontal/vertical con ajuste
          * TilePane    -> Rejilla de celdas del mismo tamano

        --- EJEMPLO: PARENT CON TRANSFORMACIONES ---

        import javafx.application.Application;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.layout.VBox;
        import javafx.stage.Stage;

        public class App extends Application {
            @Override
            public void start(Stage stage) {
                Button boton1 = new Button("Boton 1");
                Button boton2 = new Button("Boton 2");

                VBox vbox = new VBox(10);  // separacion 10px

                // Transformacion SOLO a boton1
                boton1.setRotate(45);      // boton1 rotado 45 grados

                // Transformacion al contenedor (afecta a ambos)
                vbox.setRotate(45);         // vbox rotado 45 grados
                // Resultado: boton1 = 90 grados, boton2 = 45 grados

                vbox.getChildren().addAll(boton1, boton2);

                Scene scene = new Scene(vbox, 500, 500);
                stage.setTitle("Ejemplo Parent");
                stage.setScene(scene);
                stage.show();
            }

            public static void main(String[] args) {
                launch(args);
            }
        }

        Importante:
          * Si el VBox se rota, los botones dentro heredan esa rotacion
          * Si ademas boton1 tiene su propia rotacion, se suma
          * Si se aplica setTranslateX/Y al VBox, MUEVE TODO
          * Si se aplica setTranslateX/Y a un boton individual,
            SOLO mueve ese boton
          * Sin traslaciones, los botones aparecen en la esquina
            superior izquierda y pueden salirse de la ventana
            al rotarlos

        ================================================================

        --- COMPONENTES PRINCIPALES QUE HEREDAN DE NODE ---

        (Jerarquia resumida)

        Node
        |-- Parent (abstracto, puede tener hijos)
        |   |-- Group          -> Agrupa nodos
        |   |-- Region
        |   |   |-- Pane
        |   |   |   |-- VBox, HBox, AnchorPane, GridPane,
        |   |   |       BorderPane, StackPane, FlowPane, TilePane
        |   |   |-- Control
        |   |       |-- Button, Label, TextField, CheckBox,
        |   |           RadioButton, ComboBox, Slider,
        |   |           ProgressBar, TableView, etc.
        |   |-- WebView       -> Contenido web
        |   |-- Canvas        -> Dibujo libre
        |   |-- ImageView     -> Muestra imagenes
        |
        |-- Shape (formas geometricas)
        |   |-- Rectangle, Circle, Ellipse, Line,
        |       Polygon, Path (rutas compuestas)
        |
        |-- Text (texto con estilos avanzados)
        |
        |-- MediaView (reproduccion multimedia)

        ================================================================

        --- CONTENEDORES (LAYOUTS) EN JAVA FX ---

        VBox (Vertical Box):
          * Coloca componentes en VERTICAL (uno bajo otro)
          * Constructor: VBox(espaciado) o VBox()
          * vbox.setAlignment(Pos.CENTER);
          * vbox.setPadding(new Insets(20));

        HBox (Horizontal Box):
          * Coloca componentes en HORIZONTAL (uno al lado del otro)
          * Constructor: HBox(espaciado)

        AnchorPane:
          * Permite anclar nodos a los bordes
          * AnchorPane.setTopAnchor(nodo, valor);
          * AnchorPane.setBottomAnchor(nodo, valor);
          * AnchorPane.setLeftAnchor(nodo, valor);
          * AnchorPane.setRightAnchor(nodo, valor);

        GridPane:
          * Diseno en cuadricula (filas y columnas)
          * grid.add(componente, columna, fila);
          * grid.add(componente, columna, fila, colspan, rowspan);

        BorderPane:
          * Areas predefinidas: top, bottom, left, right, center
          * border.setTop(componente);
          * border.setCenter(componente);
          * border.setBottom(componente);

        StackPane:
          * Apila componentes uno encima del otro
          * Util para superponer elementos

        FlowPane:
          * Coloca componentes en flujo horizontal/vertical
          * Se ajusta automaticamente al tamano disponible

        TilePane:
          * Rejilla de celdas del mismo tamano

        ================================================================

        --- NOTA SOBRE LA PRACTICA RECOMENDADA ---

        * Aunque se puede pasar un Node directamente a la Scene:
            Scene scene = new Scene(boton, 500, 500);
        * Es MEJOR PRACTICA usar un contenedor (Parent) como VBox/HBox:
            VBox vbox = new VBox();
            vbox.getChildren().add(boton);
            Scene scene = new Scene(vbox, 500, 500);
        * Los contenedores proporcionan mas flexibilidad y control
          sobre el diseno

        ================================================================

        --- METODOS DE TRASLACION EN PRACTICA ---

        setTranslateX(valor):  Mueve a la derecha (+)
        setTranslateY(valor):  Mueve hacia abajo (+)

        Ejemplo:
          boton1.setTranslateX(50);   // 50px a la derecha
          boton1.setTranslateY(50);   // 50px hacia abajo
          boton2.setTranslateX(10);   // 10px a la derecha
          boton2.setTranslateY(50);   // 50px hacia abajo

        * Los valores se pueden combinar
        * Si se usa VBox con espaciado, los nodos se separan auto
        * Si se usan traslaciones, se puede solapar componentes
          intencionadamente

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
