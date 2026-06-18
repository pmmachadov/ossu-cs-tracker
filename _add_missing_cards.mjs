import fs from 'fs';

// ============================================================
// 1. ADD MISSING GUI CARDS TO programacion.json
// ============================================================
const progPath = 'public/data/programacion.json';
const prog = JSON.parse(fs.readFileSync(progPath, 'utf8'));

// Find last ID for u6
const u6cards = prog.cards.filter(c => c.id.startsWith('prog-u6-'));
const lastU6Num = Math.max(...u6cards.map(c => parseInt(c.id.split('-')[2])));
console.log('Last u6 card:', 'prog-u6-' + String(lastU6Num).padStart(3, '0'));

const newGUICards = [
  // --- JTextArea (multiline text input) ---
  {
    id: 'prog-u7-001',
    front: '¿Qué es JTextArea en Java Swing?',
    back: 'JTextArea es un componente de Swing que permite al usuario introducir o editar múltiples líneas de texto. A diferencia de JTextField (una sola línea), JTextArea puede mostrar y editar varias líneas.\n\nSintaxis:\nJTextArea area = new JTextArea(10, 30);  // 10 filas, 30 columnas\narea.setText(\"Texto inicial\");\nString texto = area.getText();\n\nPara habilitar el scroll: new JScrollPane(area);',
    tags: ['programacion', 'gui', 'swing', 'JTextArea', 'componentes'],
    difficulty: 'medium'
  },
  {
    id: 'prog-u7-002',
    front: '¿Cómo se añade una JTextArea a un JScrollPane en Swing?',
    back: 'JTextArea no tiene scroll propio. Para que el texto se desplace cuando sea demasiado largo, se debe envolver en un JScrollPane:\n\nJTextArea area = new JTextArea(15, 40);\narea.setLineWrap(true);           // salto de línea automático\narea.setWrapStyleWord(true);      // salto por palabras completas\nJScrollPane scroll = new JScrollPane(area);\n\nLuego se añade el JScrollPane al contenedor (JFrame, JPanel).',
    tags: ['programacion', 'gui', 'swing', 'JTextArea', 'JScrollPane'],
    difficulty: 'medium'
  },
  {
    id: 'prog-u7-003',
    front: '¿Cuál es la diferencia entre JTextField y JTextArea en Swing?',
    back: 'JTextField: entrada de texto de una sola línea. No tiene salto de línea. Usa ActionListener para detectar Enter.\n\nJTextArea: entrada de texto de múltiples líneas. Puede mostrar y editar bloques de texto. Necesita JScrollPane para scroll. Usa métodos como append(), setText(), getText().\n\nEjemplos:\nJTextField tf = new JTextField(20);           // 1 línea\nJTextArea ta = new JTextArea(10, 30);         // múltiples líneas\nta.append(\"Nueva línea\\n\");                    // añadir texto',
    tags: ['programacion', 'gui', 'swing', 'JTextField', 'JTextArea'],
    difficulty: 'medium'
  },
  // --- JCheckBox ---
  {
    id: 'prog-u7-004',
    front: '¿Qué es JCheckBox en Java Swing y cómo se usa?',
    back: 'JCheckBox es un componente Swing que representa una casilla de verificación (checkbox). Permite seleccionar o deseleccionar una opción. Se pueden seleccionar varias casillas simultáneamente.\n\nSintaxis:\nJCheckBox check1 = new JCheckBox(\"Opción 1\");\nJCheckBox check2 = new JCheckBox(\"Opción 2\", true);  // seleccionado por defecto\n\nPara comprobar si está seleccionado:\nif (check1.isSelected()) { ... }\n\nItemListener:\ncheck1.addItemListener(e -> {\n    if (e.getStateChange() == ItemEvent.SELECTED) { ... }\n});',
    tags: ['programacion', 'gui', 'swing', 'JCheckBox', 'componentes'],
    difficulty: 'medium'
  },
  // --- JRadioButton ---
  {
    id: 'prog-u7-005',
    front: '¿Qué es JRadioButton y cómo se agrupan en Java Swing?',
    back: 'JRadioButton es un componente Swing para opciones exclusivas (solo una seleccionable del grupo). Deben agruparse con ButtonGroup para que solo uno esté seleccionado a la vez.\n\nSintaxis:\nJRadioButton rb1 = new JRadioButton(\"Masculino\");\nJRadioButton rb2 = new JRadioButton(\"Femenino\");\nJRadioButton rb3 = new JRadioButton(\"Otro\");\n\nButtonGroup grupo = new ButtonGroup();\ngrupo.add(rb1);\ngrupo.add(rb2);\ngrupo.add(rb3);\n\nActionListener:\nrb1.addActionListener(e -> System.out.println(\"Seleccionado: \" + e.getActionCommand()));',
    tags: ['programacion', 'gui', 'swing', 'JRadioButton', 'ButtonGroup'],
    difficulty: 'medium'
  },
  // --- JComboBox ---
  {
    id: 'prog-u7-006',
    front: '¿Qué es JComboBox en Java Swing y cómo se usa?',
    back: 'JComboBox es un componente Swing que muestra un menú desplegable con opciones. Solo se ve la opción activa, y al hacer clic se despliega la lista.\n\nSintaxis:\nString[] opciones = {\"Rojo\", \"Verde\", \"Azul\"};\nJComboBox<String> combo = new JComboBox<>(opciones);\ncombo.setSelectedIndex(0);  // seleccionar por defecto\n\nObtener selección:\nString seleccion = (String) combo.getSelectedItem();\nint indice = combo.getSelectedIndex();\n\nActionListener:\ncombo.addActionListener(e -> {\n    String item = (String) combo.getSelectedItem();\n});',
    tags: ['programacion', 'gui', 'swing', 'JComboBox', 'componentes'],
    difficulty: 'medium'
  },
  // --- JMenuBar, JMenu, JMenuItem ---
  {
    id: 'prog-u7-007',
    front: '¿Cómo se crea una barra de menú en Java Swing (JMenuBar, JMenu, JMenuItem)?',
    back: 'Para crear un menú en Swing se usan tres clases:\n\n1. JMenuBar: la barra que contiene los menús (se coloca en el JFrame)\n2. JMenu: cada menú desplegable (Archivo, Editar, Ayuda...)\n3. JMenuItem: cada opción dentro de un menú\n\nEjemplo:\nJMenuBar menuBar = new JMenuBar();\n\nJMenu archivo = new JMenu(\"Archivo\");\nJMenuItem abrir = new JMenuItem(\"Abrir\");\nJMenuItem guardar = new JMenuItem(\"Guardar\");\nJMenuItem salir = new JMenuItem(\"Salir\");\n\narchivo.add(abrir);\narchivo.add(guardar);\narchivo.addSeparator();  // línea separadora\narchivo.add(salir);\n\nmenuBar.add(archivo);\nframe.setJMenuBar(menuBar);\n\nManejadores:\nitem.addActionListener(e -> { ... });',
    tags: ['programacion', 'gui', 'swing', 'JMenuBar', 'JMenu', 'JMenuItem'],
    difficulty: 'medium'
  },
  // --- JDialog ---
  {
    id: 'prog-u7-008',
    front: '¿Qué es JDialog en Java Swing y cómo se diferencia de JOptionPane?',
    back: 'JDialog es una ventana emergente personalizable en Swing. A diferencia de JOptionPane (diálogos predefinidos), JDialog permite diseñar el contenido libremente.\n\nSintaxis:\nJDialog dialogo = new JDialog(frame, \"Título\", true);  // true = modal\nDialogo.setSize(300, 200);\ndialogo.setLayout(new FlowLayout());\ndialogo.add(new JLabel(\"Mensaje\"));\ndialogo.add(new JButton(\"Cerrar\"));\ndialogo.setVisible(true);\n\nModal: true bloquea la ventana padre hasta cerrar el diálogo.\nModal: false permite interactuar con ambas ventanas.\nPara cerrar: dialogo.dispose();',
    tags: ['programacion', 'gui', 'swing', 'JDialog', 'dialogos'],
    difficulty: 'medium'
  },
  // --- JPopupMenu ---
  {
    id: 'prog-u7-009',
    front: '¿Cómo se crea un menú contextual (popup) en Java Swing?',
    back: 'JPopupMenu crea un menú contextual que aparece al hacer clic derecho. Se usa junto con MouseListener.\n\nSintaxis:\nJPopupMenu popup = new JPopupMenu();\nJMenuItem op1 = new JMenuItem(\"Copiar\");\nJMenuItem op2 = new JMenuItem(\"Pegar\");\npopup.add(op1);\npopup.add(op2);\n\n// Asociar al componente:\ncomponente.addMouseListener(new MouseAdapter() {\n    public void mouseReleased(MouseEvent e) {\n        if (e.isPopupTrigger()) {  // clic derecho\n            popup.show(componente, e.getX(), e.getY());\n        }\n    }\n});\n\nTambién se puede usar MouseAdapter para solo sobrescribir el método deseado.',
    tags: ['programacion', 'gui', 'swing', 'JPopupMenu', 'menu-contextual'],
    difficulty: 'medium'
  },
];

// Add cards
prog.cards.push(...newGUICards);

// Write back
fs.writeFileSync(progPath, JSON.stringify(prog, null, 2), 'utf8');
console.log(`Added ${newGUICards.length} GUI cards to programacion.json`);
console.log('Total cards now:', prog.cards.length);

// ============================================================
// 2. ADD EXAM-STYLE EXERCISE CARDS TO java-ejercicios.json
// ============================================================
const ejPath = 'public/data/java-ejercicios.json';
const ej = JSON.parse(fs.readFileSync(ejPath, 'utf8'));

// Find last ID
const lastId = ej.cards.map(c => c.id).sort().pop();
console.log('Last exercise ID:', lastId);

const newExamCards = [
  {
    id: 'ex-examen-menu',
    front: 'Ejercicio: Crear un menú interactivo en Java',
    back: 'Crea un programa con un menú que muestre las opciones:\n1. Dibujar figura\n2. Modificar String\n3. Eliminar duplicados\n4. Octal\n5. Salir\n\nRequisitos:\n- Si se introduce un valor inválido, mostrar el menú de nuevo con advertencia.\n- El programa pide acciones hasta seleccionar Salir.\n- Cada opción se resuelve con un método independiente.',
    tags: ['programacion', 'ejercicio-examen', 'menu', 'estructura'],
    difficulty: 'hard'
  },
  {
    id: 'ex-examen-figura',
    front: 'Ejercicio: Dibujar figura numérica con patrón',
    back: 'Crea un método que reciba un tamaño N (1-9) y dibuje:\n  1\n 2 1 2\n3 2 1 2 3\n 2 1 2\n  1\n\n(Patrón piramidal con N=3). Si N>9 o N<1, mostrar advertencia.\nEjemplo N=2:\n 1\n1 2 1\n 1',
    tags: ['programacion', 'ejercicio-examen', 'bucles', 'figuras'],
    difficulty: 'hard'
  },
  {
    id: 'ex-examen-string-leet',
    front: 'Ejercicio: Convertir String a "leet speak"',
    back: 'Crea un método que reciba un String y lo devuelva cambiando:\n- a → 4\n- e → 3\n- i → 1\n- o → 0\n- espacio → _\n\nSolo se pueden usar CharAt() y length() de String.\nEjemplo:\n"Examen de PROGRAMACIÓN" → "3x4m3n_d3_PR0GR4M4C10N"',
    tags: ['programacion', 'ejercicio-examen', 'strings', 'manipulacion'],
    difficulty: 'hard'
  },
  {
    id: 'ex-examen-duplicados',
    front: 'Ejercicio: Eliminar duplicados de un array',
    back: 'Crea un método que reciba un array de enteros y devuelva un NUEVO array sin elementos duplicados. El array devuelto debe tener el tamaño exacto a la cantidad de elementos distintos.\n\nEjemplo:\n[1,2,3,2,5,6,7,2,3] → [1,2,3,5,6,7]\n\nNo usar Set ni colecciones.',
    tags: ['programacion', 'ejercicio-examen', 'arrays', 'duplicados'],
    difficulty: 'hard'
  },
  {
    id: 'ex-examen-octal',
    front: 'Ejercicio: Verificar si un número está en octal (recursivo)',
    back: 'Crea un método recursivo que determine si un número está en octal. Un número octal solo contiene dígitos del 0 al 7. El número debe ser >= 0.\n\nEjemplo:\n1770 → está en octal\n1790 → NO está en octal (contiene 9)\n\nPista: extrae el último dígito con módulo 10 y comprueba si es > 7. Luego divide entre 10 y sigue recursivamente.',
    tags: ['programacion', 'ejercicio-examen', 'recursividad', 'octal'],
    difficulty: 'hard'
  },
  {
    id: 'ex-examen-matriz-patron',
    front: 'Ejercicio: Matriz con patrón de números',
    back: 'Crea un método que reciba un tamaño N y muestre:\n1 2 3 4\n1 2 3 4\n1 2 3 4\n1 2 3 4\n\n(Ejemplo N=4). Si N>9, la siguiente línea al 9 se reinicia a 1.\n\nPatrón: matriz NxN donde cada fila imprime del 1 a N.',
    tags: ['programacion', 'ejercicio-examen', 'matrices', 'bucles-anidados'],
    difficulty: 'medium'
  },
  {
    id: 'ex-examen-gestion-alumnos',
    front: 'Ejercicio: Sistema de gestión de notas de alumnos (POO)',
    back: 'Crea las clases necesarias para gestionar las notas de un grupo de alumnos.\nRequisitos:\n- Alumno: nombre, edad, nia, lista de módulos\n- Módulo: nombre (enumerado PRG, BDA, SI, ED, LM), lista de notas\n- Cada nota tiene: valor (0-10), fecha\n- Métodos para añadir módulos y notas a un alumno\n- Excepción personalizada ModuloRepetidoException\n  mensaje: "El alumno X ya está matriculado del módulo Y"',
    tags: ['programacion', 'ejercicio-examen', 'poo', 'herencia', 'excepciones', 'enumerados'],
    difficulty: 'hard'
  },
  {
    id: 'ex-examen-agenda-telefonica',
    front: 'Ejercicio: Agenda telefónica con HashMap',
    back: 'Crea una clase AgendaTelefonica que permita:\n- Añadir contactos (String)\n- Añadir teléfonos (int) a un contacto (cada contacto puede tener varios)\n- Si el contacto no existe al añadir teléfono, crearlo automáticamente\n- Mostrar los teléfonos de un contacto\n\nUsa HashMap<String, ArrayList<Integer>> para almacenar los datos.',
    tags: ['programacion', 'ejercicio-examen', 'colecciones', 'HashMap', 'ArrayList'],
    difficulty: 'medium'
  },
  {
    id: 'ex-examen-palabra-larga-fichero',
    front: 'Ejercicio: Encontrar la(s) palabra(s) más larga(s) de un fichero',
    back: 'Crea un método que reciba el nombre de un fichero de texto y devuelva la palabra más larga encontrada. Si hay varias palabras con la misma longitud máxima, devolver todas ellas.\n\nUsa BufferedReader para leer línea a línea.\nDivide cada línea en palabras con split(" ").\nCompara longitudes y guarda las más largas.',
    tags: ['programacion', 'ejercicio-examen', 'ficheros', 'strings', 'lectura'],
    difficulty: 'medium'
  },
  {
    id: 'ex-examen-enteros-unicos',
    front: 'Ejercicio: Mostrar enteros únicos de un array',
    back: 'Crea un método que reciba un array de enteros y muestre SOLO los enteros que aparecen una única vez (no repetidos).\n\nEjemplo:\n[1,2,3,2,5,6,7,2,3] → [1,5,6,7]\n\nEs decir, si un número aparece más de una vez, se excluye completamente.',
    tags: ['programacion', 'ejercicio-examen', 'arrays', 'unicos'],
    difficulty: 'medium'
  },
];

ej.cards.push(...newExamCards);
fs.writeFileSync(ejPath, JSON.stringify(ej, null, 2), 'utf8');
console.log(`Added ${newExamCards.length} exam exercise cards to java-ejercicios.json`);
console.log('Total exercise cards now:', ej.cards.length);

console.log('\n✅ Done! Cards created successfully.');
