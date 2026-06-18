import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

/**
 * Video 9-04: Java Swing - Ejercicios iniciacion
 *
 * Tema 9: 3 ejercicios de iniciacion con componentes Swing
 * y eventos: sumador, conversor de monedas y login.
 *
 * URL: https://www.youtube.com/watch?v=SawioBQDAvA&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=197
 */
class Video_9_04_EjerciciosSwing {

    static final String CONTENIDO = """
        ================================================================
          VIDEO 9-04 - EJERCICIOS SWING INICIACION
        ================================================================

        3 ejercicios para practicar componentes Swing y eventos.

        EJERCICIO 1: Sumador de enteros
          - 2 JTextField para introducir numeros
          - JLabel para mostrar resultado
          - JButton "Sumar"
          - Si no son enteros validos -> JOptionPane.ERROR_MESSAGE

        EJERCICIO 2: Conversor monedas (Euro/Dolar)
          - JTextField con cantidad
          - JComboBox (Euro->Dolar / Dolar->Euro)
          - JButton "Convertir"
          - Resultado en JLabel o JOptionPane
          - 1 dolar = 0.91 euros (aprox)

        EJERCICIO 3: Ventana de Login
          - JTextField para nombre de usuario
          - 2 x JPasswordField (contrasena + verificar)
          - JButton "Login"
          - Validar: >=8 chars, 1 mayuscula, 1 minuscula, 1 numero
          - Regex: (?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}
          - Si valida: limpiar campos y mostrar "Inicio de sesion exitoso"
        ================================================================
        """;

    // ================================================================
    // EJERCICIO 1: Sumador de enteros
    // ================================================================
    static class SumadorEnteros extends JFrame {
        private JTextField campo1, campo2;
        private JLabel etiquetaSuma, etiquetaResultado;
        private JButton botonSumar;

        public SumadorEnteros() {
            setTitle("Sumador de enteros");
            setSize(400, 150);
            setLayout(new FlowLayout());

            campo1 = new JTextField(5);
            etiquetaSuma = new JLabel(" + ");
            campo2 = new JTextField(5);
            etiquetaResultado = new JLabel(" = ");
            botonSumar = new JButton("Sumar");

            botonSumar.addActionListener(e -> {
                try {
                    int num1 = Integer.parseInt(campo1.getText());
                    int num2 = Integer.parseInt(campo2.getText());
                    int suma = num1 + num2;
                    etiquetaResultado.setText(" = " + suma);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                        "Debes introducir valores enteros validos",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            });

            add(campo1);
            add(etiquetaSuma);
            add(campo2);
            add(botonSumar);
            add(etiquetaResultado);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }

    // ================================================================
    // EJERCICIO 2: Conversor monedas (Euro/Dolar)
    // ================================================================
    static class ConversorMonedas extends JFrame {
        private JTextField campo;
        private JLabel resultado;
        private JComboBox<String> opciones;
        private JButton botonConvertir;

        private static final double TASA = 0.91; // 1 dolar = 0.91 euros

        public ConversorMonedas() {
            setTitle("Conversor de monedas");
            setSize(450, 150);
            setLayout(new FlowLayout());

            campo = new JTextField(10);
            resultado = new JLabel(" ");
            opciones = new JComboBox<>(new String[]{"Euro a Dolar", "Dolar a Euro"});
            botonConvertir = new JButton("Convertir");

            botonConvertir.addActionListener(e -> {
                try {
                    double cantidad = Double.parseDouble(campo.getText());
                    String seleccion = (String) opciones.getSelectedItem();
                    String mensaje;
                    double convertido;

                    if (seleccion.equals("Euro a Dolar")) {
                        // Euro a Dolar: dividir entre tasa
                        convertido = cantidad / TASA;
                        mensaje = String.format("%.2f euros = %.2f dolares", cantidad, convertido);
                    } else {
                        // Dolar a Euro: multiplicar por tasa
                        convertido = cantidad * TASA;
                        mensaje = String.format("%.2f dolares = %.2f euros", cantidad, convertido);
                    }
                    resultado.setText(" = " + mensaje);

                } catch (NumberFormatException ex) {
                    resultado.setText(" ERROR: Debes introducir una cantidad valida");
                }
            });

            add(campo);
            add(opciones);
            add(botonConvertir);
            add(resultado);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }

    // ================================================================
    // EJERCICIO 3: Ventana de Login
    // ================================================================
    static class VentanaLogin extends JFrame {
        private JTextField campoUsuario;
        private JPasswordField campoPass, campoVerificarPass;
        private JButton botonLogin;

        // Regex: al menos 1 digito, 1 minuscula, 1 mayuscula, minimo 8 chars
        private static final Pattern PATRON_PASSWORD =
            Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}");

        public VentanaLogin() {
            setTitle("Login");
            setSize(350, 200);
            setLayout(new GridLayout(4, 2));

            add(new JLabel("Nombre de usuario:"));
            campoUsuario = new JTextField();
            add(campoUsuario);

            add(new JLabel("Contrasena:"));
            campoPass = new JPasswordField();
            add(campoPass);

            add(new JLabel("Verificar contrasena:"));
            campoVerificarPass = new JPasswordField();
            add(campoVerificarPass);

            botonLogin = new JButton("Login");
            add(new JLabel(""));
            add(botonLogin);

            botonLogin.addActionListener(e -> {
                String pass1 = String.valueOf(campoPass.getPassword());
                String pass2 = String.valueOf(campoVerificarPass.getPassword());

                if (!PATRON_PASSWORD.matcher(pass1).matches()) {
                    System.out.println("  La contrasena debe contener al menos 8 caracteres,"
                        + " una mayuscula, una minuscula y un numero");
                } else if (!pass1.equals(pass2)) {
                    System.out.println("  Las contrasenas no coinciden");
                } else {
                    System.out.println("  Inicio de sesion exitoso");
                    campoUsuario.setText("");
                    campoPass.setText("");
                    campoVerificarPass.setText("");
                }
            });

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }

    // ================================================================
    // MAIN
    // ================================================================
    public static void main(String[] args) {
        System.out.println(CONTENIDO);
        System.out.println();

        System.out.println("=========================================");
        System.out.println("  EJERCICIOS SWING");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("  Se abriran 3 ventanas de ejemplo.");
        System.out.println("  Cierra cada ventana para continuar.");
        System.out.println();

        System.out.println("  --- EJERCICIO 1: Sumador de enteros ---");
        new SumadorEnteros();
        esperar();

        System.out.println("  --- EJERCICIO 2: Conversor monedas ---");
        new ConversorMonedas();
        esperar();

        System.out.println("  --- EJERCICIO 3: Ventana Login ---");
        new VentanaLogin();
        esperar();

        System.out.println();
        System.out.println("================================================================");
        System.out.println("  FIN DEL VIDEO (TEMA 9 - V04: EJERCICIOS SWING INICIACION)");
        System.out.println("================================================================");
        System.out.println();
        System.out.println("  CONCEPTOS CLAVE:");
        System.out.println("  - JTextField: entrada de texto");
        System.out.println("  - JPasswordField: entrada de contrasena (oculta con puntos)");
        System.out.println("  - JComboBox: selector desplegable");
        System.out.println("  - JLabel: etiqueta de texto");
        System.out.println("  - JOptionPane: ventanas de dialogo (error, info, etc.)");
        System.out.println("  - Integer.parseInt() / Double.parseDouble(): convertir texto");
        System.out.println("  - Pattern + Matcher: validar con expresiones regulares");
        System.out.println("  - getPassword(): devuelve char[] (seguridad)");
    }

    static void esperar() {
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
    }
}
