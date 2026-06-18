

class Video_10_09_ProyectoFinal {

    public static final String TITULO = "10-9 JAVA FX: Proyecto Final - Agenda de contactos ☕ DAM - DAW";
    public static final String URL = "https://www.youtube.com/watch?v=djm_Cd67nuE&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=218";
    public static final String CANAL = "Aula en la nube";
    public static final String URL_CANAL = "https://www.youtube.com/@aulaenlanube";
    public static final String PLAYLIST = "MEGA Curso JAVA desde 0 [ DAM - DAW ] - TEMA 10 (JavaFX)";
    public static final String REPO = "https://github.com/aulaenlanube/curso-programacion-java";

    public static final String CONTENIDO = """
        ================================================================
          10-9 JAVA FX: PROYECTO FINAL - AGENDA DE CONTACTOS
        ================================================================

        --- REQUISITOS DE LA APLICACION ---

        Pantalla principal dividida en dos partes:
          IZQUIERDA: Tabla (TableView) con 3 columnas:
                     - Nombre, Telefono, Correo
          DERECHA:   Detalles del contacto seleccionado:
                     - Imagen de perfil
                     - Nombre, Telefono, Correo, Web personal

        Boton "Agregar contacto" que abre ventana modal con formulario:
          - Campos: nombre, telefono, correo, web personal
          - Boton "Seleccionar imagen" (FileChooser, solo .jpg/.png)
          - Vista previa de la imagen seleccionada
          - Boton Guardar / Cancelar

        Requisitos tecnicos:
          - MVC con FXML para las vistas (minimo 2 archivos)
          - Clase Contacto como modelo
          - Controladores separados para cada vista
          - CSS externo para estilos
          - FileChooser para seleccionar imagen
          - Copia de imagen a carpeta del proyecto
          - Imagen por defecto si no se selecciona ninguna

        Ampliaciones posibles:
          - Editar y eliminar contactos
          - Persistencia en base de datos
          - Paginacion (max 10 contactos por pagina)
          - Modo oscuro / cambio de tema CSS

        ================================================================

        --- ESTRUCTURA DEL PROYECTO ---

        src/
          main/
            java/com/aula/agenda/
              |-- modelo/
              |   |-- Contacto.java
              |-- controlador/
              |   |-- VentanaPrincipalController.java
              |   |-- NuevoContactoController.java
              |-- vista/
              |   |-- App.java
            resources/com/aula/agenda/
              |-- vista/
              |   |-- ventanaPrincipal.fxml
              |   |-- nuevoContacto.fxml
              |-- estilos/
              |   |-- estilos.css
              |-- imgs/
                  |-- (imagenes de contactos)
                  |-- default.jpg

        ================================================================

        --- MODELO: Contacto.java ---

        public class Contacto {

            private final StringProperty nombre;
            private final StringProperty telefono;
            private final StringProperty correo;
            private final StringProperty webPersonal;
            private final StringProperty imagenPerfil;

            private static final String RUTA_IMAGENES =
                "/com/aula/agenda/imgs/";

            public Contacto(String nombre, String telefono, String correo,
                            String webPersonal, String imagenPerfil) {
                this.nombre = new SimpleStringProperty(nombre);
                this.telefono = new SimpleStringProperty(telefono);
                this.correo = new SimpleStringProperty(correo);
                this.webPersonal = new SimpleStringProperty(webPersonal);
                this.imagenPerfil = new SimpleStringProperty(imagenPerfil);
            }

            // Getters y setters (StringProperty)
            public StringProperty nombreProperty() { return nombre; }
            public StringProperty telefonoProperty() { return telefono; }
            public StringProperty correoProperty() { return correo; }
            public StringProperty webPersonalProperty() { return webPersonal; }
            public StringProperty imagenPerfilProperty() { return imagenPerfil; }

            public String getNombre() { return nombre.get(); }
            public String getTelefono() { return telefono.get(); }
            public String getCorreo() { return correo.get(); }
            public String getWebPersonal() { return webPersonal.get(); }
            public String getImagenPerfil() { return imagenPerfil.get(); }

            // Metodo para obtener la ruta completa de la imagen de perfil
            public String getRutaImagenPerfil() {
                if (getImagenPerfil() != null && !getImagenPerfil().isEmpty()) {
                    return RUTA_IMAGENES + getImagenPerfil();
                }
                return null;
            }

            @Override
            public String toString() { return getNombre(); }
        }

        * Atributos como StringProperty (NO String) para que la tabla
          sea reactiva a los cambios (observable)
        * RUTA_IMAGENES constante con la ruta a la carpeta de imagenes

        ================================================================

        --- VISTA PRINCIPAL: ventanaPrincipal.fxml ---

        <?xml version="1.0" encoding="UTF-8"?>
        <?import javafx.scene.layout.HBox?>
        <?import javafx.scene.layout.VBox?>
        <?import javafx.scene.control.TableView?>
        <?import javafx.scene.control.TableColumn?>
        <?import javafx.scene.control.Label?>
        <?import javafx.scene.control.Button?>
        <?import javafx.scene.image.ImageView?>
        <HBox fx:controller="com.aula.agenda.controlador.VentanaPrincipalController"
              xmlns:fx="http://javafx.com/fxml">

            <!-- TABLA (izquierda) -->
            <TableView fx:id="tablaContactos" prefWidth="400">
                <columns>
                    <TableColumn fx:id="columnaNombre" text="Nombre" prefWidth="130" />
                    <TableColumn fx:id="columnaTelefono" text="Telefono" prefWidth="120" />
                    <TableColumn fx:id="columnaCorreo" text="Correo" prefWidth="150" />
                </columns>
                <padding><Insets top="20" right="20" bottom="20" left="20" /></padding>
            </TableView>

            <!-- DETALLES (derecha) -->
            <VBox fx:id="panelDetalles" prefWidth="400" spacing="10"
                  alignment="CENTER" padding="20">
                <ImageView fx:id="imagenPerfil" fitHeight="150" fitWidth="150" />
                <Label fx:id="labelNombre" text="Selecciona un contacto" />
                <Label fx:id="labelTelefono" />
                <Label fx:id="labelCorreo" />
                <Label fx:id="labelWebPersonal" />
                <Button fx:id="botonNuevoContacto" text="Agregar contacto"
                        onAction="#mostrarFormulario" />
            </VBox>
        </HBox>

        ================================================================

        --- CONTROLADOR PRINCIPAL: VentanaPrincipalController.java ---

        public class VentanaPrincipalController {

            @FXML private TableView<Contacto> tablaContactos;
            @FXML private TableColumn<Contacto, String> columnaNombre;
            @FXML private TableColumn<Contacto, String> columnaTelefono;
            @FXML private TableColumn<Contacto, String> columnaCorreo;
            @FXML private Label labelNombre;
            @FXML private Label labelTelefono;
            @FXML private Label labelCorreo;
            @FXML private Label labelWebPersonal;
            @FXML private ImageView imagenPerfil;
            @FXML private VBox panelDetalles;

            private ObservableList<Contacto> listaContactos;

            @FXML
            public void initialize() {
                // Inicializar lista observable
                listaContactos = FXCollections.observableArrayList();

                // Agregar contactos de muestra
                listaContactos.addAll(
                    new Contacto("Pep", "111", "pep@pc.com",
                        "aulaenlanube.com", "img1.jpg"),
                    new Contacto("Tom", "222", "tom@pc.com",
                        "aulaenlanube.com", "img2.jpg"),
                    new Contacto("John", "333", "john@pc.com",
                        "aulaenlanube.com", "img3.jpg"),
                    new Contacto("Sam", "444", "sam@pc.com",
                        "aulaenlanube.com", "img4.jpg")
                );

                // Vincular la lista a la tabla
                tablaContactos.setItems(listaContactos);

                // Configurar columnas (extraer valor del Contacto)
                columnaNombre.setCellValueFactory(
                    cellData -> cellData.getValue().nombreProperty()
                );
                columnaTelefono.setCellValueFactory(
                    cellData -> cellData.getValue().telefonoProperty()
                );
                columnaCorreo.setCellValueFactory(
                    cellData -> cellData.getValue().correoProperty()
                );

                // Listener para cambio de seleccion en la tabla
                tablaContactos.getSelectionModel()
                    .selectedItemProperty()
                    .addListener((obs, oldVal, newVal) -> {
                        mostrarDetallesContacto(newVal);
                    });
            }

            private void mostrarDetallesContacto(Contacto contacto) {
                if (contacto != null) {
                    labelNombre.setText(contacto.getNombre());
                    labelTelefono.setText(contacto.getTelefono());
                    labelCorreo.setText(contacto.getCorreo());
                    labelWebPersonal.setText(contacto.getWebPersonal());

                    String rutaImg = contacto.getRutaImagenPerfil();
                    if (rutaImg != null && !rutaImg.isEmpty()) {
                        imagenPerfil.setImage(
                            new Image(getClass().getResourceAsStream(rutaImg))
                        );
                    } else {
                        imagenPerfil.setImage(null);
                    }
                } else {
                    labelNombre.setText("Selecciona un contacto");
                    labelTelefono.setText("");
                    labelCorreo.setText("");
                    labelWebPersonal.setText("");
                    imagenPerfil.setImage(null);
                }
            }

            @FXML
            private void mostrarFormulario() {
                try {
                    FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/com/aula/agenda/vista/nuevoContacto.fxml")
                    );
                    Parent root = loader.load();

                    // Vincular controlador del formulario con este
                    NuevoContactoController controladorForm = loader.getController();
                    controladorForm.setControladorPrincipal(this);

                    Stage ventanaFormulario = new Stage();
                    ventanaFormulario.setTitle("Nuevo contacto");
                    ventanaFormulario.initModality(Modality.APPLICATION_MODAL);
                    ventanaFormulario.initOwner(
                        ((Button) panelDetalles.lookup("#botonNuevoContacto"))
                            .getScene().getWindow()
                    );

                    Scene scene = new Scene(root, 400, 500);
                    scene.getStylesheets().add(
                        getClass().getResource("/com/aula/agenda/estilos/estilos.css")
                            .toExternalForm()
                    );
                    ventanaFormulario.setScene(scene);
                    ventanaFormulario.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Metodo llamado desde NuevoContactoController al guardar
            public void agregarContacto(Contacto contacto) {
                listaContactos.add(contacto);
            }
        }

        ================================================================

        --- VISTA FORMULARIO: nuevoContacto.fxml ---

        <?xml version="1.0" encoding="UTF-8"?>
        <?import javafx.scene.layout.VBox?>
        <?import javafx.scene.layout.HBox?>
        <?import javafx.scene.control.Label?>
        <?import javafx.scene.control.TextField?>
        <?import javafx.scene.control.Button?>
        <?import javafx.scene.image.ImageView?>
        <VBox fx:controller="com.aula.agenda.controlador.NuevoContactoController"
              xmlns:fx="http://javafx.com/fxml" spacing="10" padding="20">

            <Label text="Formulario de contacto" style="-fx-font-size: 18; -fx-font-weight: bold;" />

            <HBox spacing="10"><Label text="Nombre:" prefWidth="100" />
                <TextField fx:id="campoNombre" HBox.hgrow="ALWAYS" /></HBox>
            <HBox spacing="10"><Label text="Telefono:" prefWidth="100" />
                <TextField fx:id="campoTelefono" HBox.hgrow="ALWAYS" /></HBox>
            <HBox spacing="10"><Label text="Correo:" prefWidth="100" />
                <TextField fx:id="campoCorreo" HBox.hgrow="ALWAYS" /></HBox>
            <HBox spacing="10"><Label text="Web personal:" prefWidth="100" />
                <TextField fx:id="campoWebPersonal" HBox.hgrow="ALWAYS" /></HBox>

            <ImageView fx:id="vistaPreviaImagen" fitHeight="100" fitWidth="100" />
            <Label fx:id="labelNombreImagen" text="Ninguna imagen seleccionada" />
            <Button text="Seleccionar imagen" onAction="#cargarImagen" />

            <HBox spacing="10" alignment="CENTER_RIGHT">
                <Button text="Cancelar" styleClass="boton-cancelar"
                        onAction="#cancelar" />
                <Button text="Guardar" styleClass="boton-guardar"
                        onAction="#guardarContacto" />
            </HBox>
        </VBox>

        ================================================================

        --- CONTROLADOR FORMULARIO: NuevoContactoController.java ---

        public class NuevoContactoController {

            @FXML private TextField campoNombre;
            @FXML private TextField campoTelefono;
            @FXML private TextField campoCorreo;
            @FXML private TextField campoWebPersonal;
            @FXML private Label labelNombreImagen;
            @FXML private ImageView vistaPreviaImagen;

            private File archivoImagen;
            private VentanaPrincipalController controladorPrincipal;

            // Ruta donde se guardaran las imagenes de los contactos
            private static final String RUTA_DESTINO_IMAGENES =
                "src/main/resources/com/aula/agenda/imgs/";

            public void setControladorPrincipal(
                    VentanaPrincipalController ctrl) {
                this.controladorPrincipal = ctrl;
            }

            @FXML
            public void initialize() { }

            @FXML
            private void cargarImagen() {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Seleccionar imagen de perfil");

                // Filtrar solo imagenes
                fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter(
                        "Imagenes", "*.jpg", "*.png", "*.jpeg"
                    )
                );

                archivoImagen = fileChooser.showOpenDialog(
                    labelNombreImagen.getScene().getWindow()
                );

                if (archivoImagen != null) {
                    labelNombreImagen.setText(archivoImagen.getName());

                    // Vista previa (opcional)
                    Image imagen = new Image(archivoImagen.toURI().toString());
                    vistaPreviaImagen.setImage(imagen);
                }
            }

            @FXML
            private void guardarContacto() {
                String nombre = campoNombre.getText();
                String telefono = campoTelefono.getText();
                String correo = campoCorreo.getText();
                String webPersonal = campoWebPersonal.getText();
                String nombreImagen;

                if (archivoImagen != null) {
                    nombreImagen = guardarImagen();
                } else {
                    nombreImagen = "default.jpg"; // Imagen por defecto
                }

                Contacto nuevoContacto = new Contacto(
                    nombre, telefono, correo, webPersonal, nombreImagen
                );

                controladorPrincipal.agregarContacto(nuevoContacto);
                cancelar();
            }

            private String guardarImagen() {
                try {
                    Path carpetaDestino = Paths.get(RUTA_DESTINO_IMAGENES);
                    Path imagenOrigen = Paths.get(archivoImagen.getAbsolutePath());
                    Path imagenDestino = carpetaDestino.resolve(archivoImagen.getName());

                    Files.copy(imagenOrigen, imagenDestino,
                        StandardCopyOption.REPLACE_EXISTING);

                    return archivoImagen.getName();
                } catch (IOException e) {
                    e.printStackTrace();
                    return "default.jpg";
                }
            }

            @FXML
            private void cancelar() {
                Stage ventana = (Stage) labelNombreImagen.getScene().getWindow();
                ventana.close();
            }
        }

        ================================================================

        --- APP PRINCIPAL: App.java ---

        public class App extends Application {

            @Override
            public void start(Stage ventanaPrincipal) throws Exception {
                HBox layoutPrincipal = FXMLLoader.load(
                    getClass().getResource(
                        "/com/aula/agenda/vista/ventanaPrincipal.fxml"
                    )
                );

                Scene scene = new Scene(layoutPrincipal, 800, 500);
                scene.getStylesheets().add(
                    getClass().getResource(
                        "/com/aula/agenda/estilos/estilos.css"
                    ).toExternalForm()
                );

                ventanaPrincipal.setTitle("Agenda contactos");
                ventanaPrincipal.setScene(scene);
                ventanaPrincipal.show();
            }

            public static void main(String[] args) {
                launch(args);
            }
        }

        ================================================================

        --- CSS: estilos.css ---

        /* Estilos generales */
        .root {
            -fx-font-family: "Arial";
            -fx-font-size: 14px;
        }

        /* Tabla */
        .table-view {
            -fx-border-color: #bdc3c7;
            -fx-border-radius: 5px;
        }

        .table-column {
            -fx-alignment: CENTER_LEFT;
        }

        /* Labels de detalles */
        .label {
            -fx-text-fill: #2c3e50;
        }

        .label-titulo {
            -fx-font-size: 18px;
            -fx-font-weight: bold;
            -fx-text-fill: #2c3e50;
        }

        /* Boton cancelar (gris) */
        .boton-cancelar {
            -fx-background-color: #95a5a6;
            -fx-text-fill: white;
            -fx-background-radius: 5px;
            -fx-padding: 8 16;
        }

        .boton-cancelar:hover {
            -fx-background-color: #7f8c8d;
        }

        /* Boton guardar (verde) */
        .boton-guardar {
            -fx-background-color: #27ae60;
            -fx-text-fill: white;
            -fx-background-radius: 5px;
            -fx-padding: 8 16;
        }

        .boton-guardar:hover {
            -fx-background-color: #2ecc71;
        }

        /* Boton agregar contacto (principal) */
        #botonNuevoContacto {
            -fx-background-color: #3498db;
            -fx-text-fill: white;
            -fx-background-radius: 5px;
            -fx-padding: 10 20;
            -fx-font-size: 14px;
        }

        #botonNuevoContacto:hover {
            -fx-background-color: #2980b9;
        }

        /* ImageView con sombra */
        #imagenPerfil {
            -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 10, 0, 0, 5);
        }

        ================================================================

        --- FUNCIONAMIENTO DETALLADO ---

        1. AL INICIAR:
           - App.java carga ventanaPrincipal.fxml
           - Se ejecuta initialize() del VentanaPrincipalController
           - Se inicializa listaContactos con 4 contactos de muestra
           - Se vinculan las columnas de la tabla con los getters
             del Contacto (cellValueFactory)
           - Se anade listener al modelo de seleccion de la tabla

        2. AL SELECCIONAR UN CONTACTO:
           - El listener detecta el cambio en selectedItemProperty
           - Llama a mostrarDetallesContacto(contacto)
           - Actualiza los 4 labels con los datos del contacto
           - Carga la imagen desde resources usando getResourceAsStream

        3. AL HACER CLIC EN "AGREGAR CONTACTO":
           - mostrarFormulario() carga nuevoContacto.fxml
           - Obtiene el controlador del formulario via loader.getController()
           - Pasa la referencia this (controlador principal) al formulario
           - Crea una ventana Stage modal (initModality + initOwner)
           - Asigna el mismo CSS a la nueva escena

        4. EN EL FORMULARIO:
           - FileChooser con ExtensionFilter para solo imagenes
           - Al seleccionar imagen: se guarda el File y se muestra
             el nombre en un Label
           - Al guardar: se crea un Contacto con los datos
           - Si hay imagen: se copia a imgs/ con Files.copy()
           - Si no: se usa "default.jpg"
           - Se invoca controladorPrincipal.agregarContacto()
           - Se cierra la ventana

        5. REACTIVIDAD:
           - listaContactos es ObservableList<Contacto>
           - Al hacer add(), la tabla se actualiza automaticamente
           - Los atributos del Contacto son StringProperty
           - Cualquier cambio en los datos se refleja en la tabla

        ================================================================

        --- AMPLIACIONES POSIBLES ---

        1. Editar/Eliminar contactos:
           - Anadir botones "Editar" y "Eliminar" en la vista
           - Editar: abrir el formulario con datos precargados
           - Eliminar: quitar de la lista y borrar la imagen

        2. Persistencia en BD:
           - Conectar con MySQL usando el conector
           - Guardar/cargar contactos al iniciar/cerrar
           - CRUD completo en la base de datos

        3. Paginacion:
           - Limitar TableView a 10 filas
           - Botones "Anterior" / "Siguiente"
           - Cargar solo 10 contactos cada vez desde la BD

        4. Modo oscuro:
           - Crear un segundo archivo CSS (modo-oscuro.css)
           - Boton para intercambiar hojas de estilo
           - scene.getStylesheets().clear() + add()

        ================================================================
        """;

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("   " + TITULO);
        System.out.println("============================================");
        System.out.println("Video: " + URL);
        System.out.println();
        System.out.println(CONTENIDO);
    }
}
