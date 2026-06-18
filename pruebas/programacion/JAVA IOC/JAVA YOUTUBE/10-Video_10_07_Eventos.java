

class Video_10_07_Eventos {

    public static final String TITULO = "10-7 JAVA FX: Eventos ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=dUbNtI4bQZo&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=216";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 10 (JavaFX)";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String RESUMEN =
        """
        ================================================================
          10-7 JAVA FX: EVENTOS
        ================================================================

        --- MODELO DE PROPAGACION DE EVENTOS (BURBUJA) ---

        JavaFX usa un modelo de propagacion de eventos en BURBUJA
        de tres fases:

        1. FASE DE CAPTURA:
           - El evento viaja desde el NODO RAIZ hasta el NODO OBJETIVO
           - Los nodos intermedios pueden CAPTURAR el evento
           - Se usa addEventFilter() para interceptar antes del destino

        2. FASE OBJETIVO:
           - El nodo objetivo tiene la oportunidad de manejar el evento
           - Es el manejador final (event handler)

        3. FASE DE BURBUJA:
           - El evento "burbujea" desde el nodo objetivo hacia la raiz
           - Cada nodo intermedio puede manejar el evento de nuevo
           - Se usa addEventHandler() o setOn...()

        Ejemplo de propagacion:
          VBox (raiz)
            |-- Rectangle (objetivo)

          Clic en Rectangle:
            1. addEventFilter en VBox (captura) -> "Ha pasado por VBox"
            2. setOnMouseClicked en Rectangle -> "Evento en el rectangulo"
            3. addEventHandler en VBox -> "Evento en el VBox"

        ================================================================

        --- FILTRADO DE EVENTOS (addEventFilter) ---

        * Permite interceptar un evento ANTES de que llegue a su destino
        * Se puede consumir el evento con event.consume() para
          que NO llegue al manejador final
        * Si se consume, el evento NO continua su propagacion

        Ejemplo:
          vbox.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
              if (e.getButton() == MouseButton.SECONDARY) {
                  System.out.println("Mostrando menu contextual");
                  // Aqui se podria consumir: e.consume();
              }
          });

          vbox.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
              // Este codigo se ejecutara DESPUES del filtro
              // SOLO si no se ha consumido el evento
          });

        ================================================================

        --- REGISTRO DE MANEJADORES DE EVENTOS ---

        Forma 1: Metodo setOn... (mas usado)
          boton.setOnAction(e -> System.out.println("Clic!"));

        Forma 2: addEventHandler (para filtros y handlers)
          escena.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> { });

        Forma 3: addEventFilter (captura antes del destino)
          vbox.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> { });

        ================================================================

        --- EVENTOS DE RATON (MouseEvent) ---

        Evento                         Metodo
        -----------------------------  --------------------------
        Clic del raton                 setOnMouseClicked()
        Presionar boton                setOnMousePressed()
        Soltar boton                   setOnMouseReleased()
        Arrastrar (clic + mover)       setOnMouseDragged()
        Mover el raton                 setOnMouseMoved()
        Girar la rueda                 setOnScroll()
        Entrar en un nodo              setOnMouseEntered()
        Salir de un nodo               setOnMouseExited()

        Metodos de MouseEvent:
          e.getButton()                  -> MouseButton (PRIMARY / SECONDARY / MIDDLE)
          e.getX(), e.getY()             -> Coordenadas del evento
          e.getSceneX(), e.getSceneY()   -> Coordenadas en la escena
          e.getScreenX(), e.getScreenY() -> Coordenadas en pantalla
          e.getClickCount()              -> Numero de clics (doble clic = 2)

        Ejemplo:
          escena.setOnMouseClicked(e -> {
              if (e.getButton() == MouseButton.PRIMARY) {
                  label.setText("Has hecho clic izquierdo");
              } else if (e.getButton() == MouseButton.SECONDARY) {
                  label.setText("Has hecho clic derecho");
              }
          });

        Evento Scroll (rueda del raton):
          escena.setOnScroll(e -> {
              double deltaY = e.getDeltaY(); // positivo: arriba, negativo: abajo
              if (deltaY > 0) {
                  // Ampliar
              } else {
                  // Reducir
              }
          });

        Evento Drag (arrastrar):
          escena.setOnMouseDragged(e -> {
              System.out.println("Arrastrando - X: " + e.getX() + " Y: " + e.getY());
          });

        Evento Mouse Moved:
          escena.setOnMouseMoved(e -> {
              System.out.println("Raton en: " + e.getX() + ", " + e.getY());
          });

        ================================================================

        --- EVENTOS DE TECLADO (KeyEvent) ---

        Evento                         Metodo
        -----------------------------  --------------------------
        Presionar una tecla            setOnKeyPressed()
        Soltar una tecla               setOnKeyReleased()
        Escribir un caracter           setOnKeyTyped()

        Metodos de KeyEvent:
          e.getCode()          -> KeyCode de la tecla pulsada
          e.getText()          -> Caracter escrito (KeyTyped)
          e.isControlDown()    -> Booleano: Control pulsado?
          e.isShiftDown()      -> Booleano: Shift pulsado?
          e.isAltDown()        -> Booleano: Alt pulsado?
          e.isMetaDown()       -> Booleano: Meta (Win/Command) pulsado?

        Ejemplo tecla simple:
          escena.setOnKeyPressed(e -> {
              if (e.getCode() == KeyCode.ENTER) {
                  System.out.println("Se presiono ENTER");
              } else if (e.getCode() == KeyCode.A) {
                  System.out.println("Se presiono la tecla A");
              }
          });

        Ejemplo tecla soltada:
          escena.setOnKeyReleased(e -> {
              if (e.getCode() == KeyCode.SPACE) {
                  System.out.println("Se solto la barra espaciadora");
              }
          });

        ================================================================

        --- COMBINACIONES DE TECLAS ---

        Metodo 1: Usando isControlDown(), isShiftDown(), etc.

          escena.setOnKeyPressed(e -> {
              // Control + S
              if (e.isControlDown() && e.getCode() == KeyCode.S) {
                  System.out.println("Se presiono Control + S");
              }
              // Control + Shift + K
              if (e.isControlDown() && e.isShiftDown() && e.getCode() == KeyCode.K) {
                  System.out.println("Se presiono Control + Shift + K");
              }
          });

        Metodo 2: Usando KeyCombination (mas declarativo)

          KeyCombination combo = new KeyCodeCombination(
              KeyCode.S, KeyCombination.CONTROL_DOWN
          );

          escena.setOnKeyPressed(e -> {
              if (combo.match(e)) {
                  System.out.println("Combinacion Control+S detectada");
              }
          });

        ================================================================

        --- COMBINACION DE TRES TECLAS CUALESQUIERA (A+B+C) ---

        Para teclas que NO son modificadores (Control, Shift, Alt...):

          Set<KeyCode> teclasActivas = new HashSet<>();

          escena.setOnKeyPressed(e -> {
              teclasActivas.add(e.getCode());
              if (teclasActivas.contains(KeyCode.A) &&
                  teclasActivas.contains(KeyCode.B) &&
                  teclasActivas.contains(KeyCode.C)) {
                  System.out.println("Teclas A, B y C presionadas simultaneamente");
              }
          });

          escena.setOnKeyReleased(e -> {
              teclasActivas.remove(e.getCode());
          });

        * Se usa un HashSet<KeyCode> para almacenar teclas pulsadas
        * Al presionar: se anade el KeyCode al Set
        * Al soltar: se elimina el KeyCode del Set
        * Se comprueba si las tres teclas estan en el Set

        ================================================================

        --- BUENAS PRACTICAS CON EVENTOS ---

        1. Usar LAMBDAS para simplificar el codigo
        2. Separar la LOGICA en metodos aparte (ej: crearEventos())
        3. Usar CONSTANTES para tipos de eventos si se repiten
        4. Consumir eventos con consume() cuando sea necesario
        5. No modificar la UI desde hilos que no sean el de JavaFX

        ================================================================

        --- EJEMPLO: MENU CONTEXTUAL (clic derecho) ---

        import javafx.scene.control.ContextMenu;
        import javafx.scene.control.MenuItem;

        ContextMenu menu = new ContextMenu();
        MenuItem itemAzul = new MenuItem("Rectangulo azul");
        MenuItem itemVerde = new MenuItem("Rectangulo verde");

        itemAzul.setOnAction(e -> rectangulo.setFill(Color.LIGHTBLUE));
        itemVerde.setOnAction(e -> rectangulo.setFill(Color.LIGHTGREEN));

        menu.getItems().addAll(itemAzul, itemVerde);

        // Mostrar menu contextual al hacer clic derecho
        vbox.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                menu.show(vbox, e.getScreenX(), e.getScreenY());
            }
        });

        ================================================================

        --- EJEMPLO COMPLETO: CUBO 3D INTERACTIVO ---

        import javafx.application.Application;
        import javafx.beans.property.DoubleProperty;
        import javafx.beans.property.SimpleDoubleProperty;
        import javafx.scene.Scene;
        import javafx.scene.input.KeyCode;
        import javafx.scene.input.MouseButton;
        import javafx.scene.layout.VBox;
        import javafx.scene.paint.Color;
        import javafx.scene.paint.PhongMaterial;
        import javafx.scene.shape.Box;
        import javafx.scene.transform.Rotate;
        import javafx.stage.Stage;

        public class App extends Application {

            // Variables para control de rotacion
            private double anchorX, anchorY;
            private double angleAnchorX, angleAnchorY;
            private DoubleProperty rotationX = new SimpleDoubleProperty(0);
            private DoubleProperty rotationY = new SimpleDoubleProperty(0);

            // Colores para el cubo
            private Color[] coloresCubo = {
                Color.RED, Color.LIGHTBLUE, Color.LIGHTGREEN,
                Color.YELLOW, Color.ORANGE, Color.PURPLE
            };
            private int indiceColorActual = 0;

            @Override
            public void start(Stage stage) {
                // Crear cubo
                Box cubo = new Box(200, 200, 200);

                // Material con iluminacion
                PhongMaterial material = new PhongMaterial();
                material.setDiffuseColor(Color.LIGHTGREEN);
                cubo.setMaterial(material);

                // Rotaciones
                Rotate xRotate = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
                Rotate yRotate = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS);

                // Layout
                VBox root = new VBox(cubo);
                root.setAlignment(javafx.geometry.Pos.CENTER);

                // Escena
                Scene scene = new Scene(root, 600, 400);
                scene.setFill(Color.SILVER);

                // Anadir transformaciones al cubo
                cubo.getTransforms().addAll(xRotate, yRotate);

                // Configurar ventana
                stage.setTitle("Cubo 3D Interactivo");
                stage.setScene(scene);
                stage.show();

                // ======== EVENTOS ========

                // 1. ROTACION: clic + arrastrar
                scene.setOnMousePressed(e -> {
                    anchorX = e.getSceneX();
                    anchorY = e.getSceneY();
                    angleAnchorX = rotationX.get();
                    angleAnchorY = rotationY.get();
                });

                scene.setOnMouseDragged(e -> {
                    rotationX.set(angleAnchorX + (anchorY - e.getSceneY()));
                    rotationY.set(angleAnchorY + (e.getSceneX() - anchorX));
                });

                // Binding: vincular rotaciones a las propiedades
                xRotate.angleProperty().bind(rotationX);
                yRotate.angleProperty().bind(rotationY);

                // 2. ZOOM con rueda del raton
                scene.setOnScroll(e -> {
                    double factorZoom = (e.getDeltaY() > 0) ? 1.1 : 1 / 1.1;
                    cubo.setScaleX(cubo.getScaleX() * factorZoom);
                    cubo.setScaleY(cubo.getScaleY() * factorZoom);
                    cubo.setScaleZ(cubo.getScaleZ() * factorZoom);
                });

                // 3. CAMBIAR COLOR con clic derecho
                cubo.setOnMouseClicked(e -> {
                    if (e.getButton() == MouseButton.SECONDARY) {
                        cambiarColorCubo(cubo);
                    }
                });

                // 4. ZOOM con teclado (Control + / Control -)
                scene.setOnKeyPressed(e -> {
                    double factorZoom = 1.1;
                    if (e.isControlDown() && e.getCode() == KeyCode.EQUALS) {
                        cubo.setScaleX(cubo.getScaleX() * factorZoom);
                        cubo.setScaleY(cubo.getScaleY() * factorZoom);
                        cubo.setScaleZ(cubo.getScaleZ() * factorZoom);
                    } else if (e.isControlDown() && e.getCode() == KeyCode.MINUS) {
                        factorZoom = 1 / factorZoom;
                        cubo.setScaleX(cubo.getScaleX() * factorZoom);
                        cubo.setScaleY(cubo.getScaleY() * factorZoom);
                        cubo.setScaleZ(cubo.getScaleZ() * factorZoom);
                    }
                });
            }

            private void cambiarColorCubo(Box cubo) {
                indiceColorActual = (indiceColorActual + 1) % coloresCubo.length;
                PhongMaterial material = new PhongMaterial();
                material.setDiffuseColor(coloresCubo[indiceColorActual]);
                cubo.setMaterial(material);
            }

            public static void main(String[] args) {
                launch(args);
            }
        }

        Eventos en el cubo 3D:
          * ARRASTRAR: rota el cubo en 3D (eje X e Y)
          * RUEDA: aumenta/disminuye el tamano
          * CLIC DERECHO: cambia el color del cubo
          * CONTROL +: aumenta tamano
          * CONTROL -: disminuye tamano

        ================================================================

        --- APLICAR TEXTURAS AL CUBO ---

        Para aplicar una imagen como textura en lugar de color solido:

          PhongMaterial material = new PhongMaterial();
          Image textura = new Image(
              getClass().getResourceAsStream("/textura1.jpg")
          );
          material.setDiffuseMap(textura);     // Textura
          // material.setDiffuseColor(Color.RED);  // Color (opcional, combinable)
          cubo.setMaterial(material);

        * setDiffuseMap(Image): aplica una imagen como textura
        * Se puede combinar con setDiffuseColor() para tener ambos
        * La imagen debe estar en src/main/resources/

        ================================================================

        --- CLASES IMPORTANTES PARA EVENTOS ---

        javafx.scene.input.MouseEvent      -> Eventos de raton
        javafx.scene.input.KeyEvent         -> Eventos de teclado
        javafx.scene.input.ScrollEvent      -> Eventos de rueda
        javafx.scene.input.MouseButton      -> PRIMARY, SECONDARY, MIDDLE
        javafx.scene.input.KeyCode          -> Codigos de teclas (ENTER, A, SPACE...)
        javafx.scene.input.KeyCombination   -> Combinaciones de teclas
        javafx.event.ActionEvent            -> Acciones (botones, menu items...)
        javafx.event.Event                  -> Clase base de todos los eventos

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
