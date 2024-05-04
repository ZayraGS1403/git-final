package src.presentation;

import src.domain.Player;
import src.domain.Quoridor;
import src.domain.TypeMove;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.*;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class QuoridiorGUI extends JFrame {
    private JPanel mainPanel;
    private JButton[][] boardButtons;
    private JButton[][] horizontalWallButtons;
    private JButton[][] verticalWallButtons;
    private static final int BOARD_SIZE = 9;

    private JMenuItem buttonNew;
    private JMenuItem buttonOpen;
    private JMenuItem buttonSave;
    private JMenuItem buttonExit;
    private JButton startButton; // Botón para comenzar
    private JButton exitButton; // Botón para salir
    private JButton gameButton; // Botón para el juego
    private JButton createGame; // Botón para crear una partida
    JMenuBar menuBar;

    private JLabel jLabel;
    private JButton humanVsHuman;
    private JButton robotVsRobot;
    private JButton robotVsHuman;
    private JPanel buttonPanel;

    private Quoridor quoridor;
    private JComboBox<Object> comboBox;
    private JTextField textField2;
    private JTextField textField1;
    private Color Jugador1;
    private JButton comenzar;
    private JMenu menu;

    public QuoridiorGUI() {
        setTitle("QuoriAng Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Preparar elementos del menú
        // Agregar la barra de menú a la ventana principal
        setJMenuBar(prepareElementsMenu());
        prepareActions();
        createButtons(); // Crear botones
        acciones(); // Acciones de los botones

     }



    private void acciones(){

        // Acción del botón "Comenzar"
        startButton.addActionListener(e -> {
            jLabel.setVisible(false);
            startButton.setVisible(false);
            exitButton.setVisible(false);
            gameButton.setVisible(true);
            add(preparateConfigGame());
            revalidate();
            repaint();
        });

        // Acción del botón "Salir"
        exitButton.addActionListener(e -> System.exit(0));

        // Acción del botón "Quoridor Game"
        gameButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Bienvenido al juego Quoridor, Trabajo realizado por Andres Serrato y Zayra Gutierrez"));

        // Acción del botón "Crear Partida"
        createGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createGrid();
                mostrarTablero();
                repaint();
            }
        });



    }



    private void createButtons() {
        // Panel para los botones
        buttonPanel = new JPanel(new FlowLayout());
        startButton = new JButton("Comenzar");
        exitButton = new JButton("Salir");
        createGame = new JButton("Crear Partida");

        // Ajustar el tamaño de los botones
        Dimension buttonSize = new Dimension(150, 50);


        startButton.setPreferredSize(buttonSize);
        exitButton.setPreferredSize(buttonSize);
        createGame.setPreferredSize(buttonSize);

        // Ajustar el tamaño de la letra de los botones
        Font buttonFont = new Font("Amasis MT Pro Light", Font.LAYOUT_LEFT_TO_RIGHT, 20);

        // Añadir los botones al panel
        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(createGame);
        add(buttonPanel, BorderLayout.SOUTH);


        // Panel para el encabezado
        // Panel para el encabezado
        JPanel headerPanel = new JPanel(new BorderLayout());
        ImageIcon imageIcon = new ImageIcon("src/QG.jpg");
        jLabel = new JLabel(imageIcon);

        gameButton = new JButton("QUORIDOR GAME");
        gameButton.setHorizontalAlignment(SwingConstants.CENTER);

        headerPanel.add(jLabel, BorderLayout.CENTER);
        headerPanel.add(gameButton, BorderLayout.NORTH);
        headerPanel.setComponentZOrder(jLabel, 0);
        headerPanel.setComponentZOrder(gameButton, 1);
        add(headerPanel, BorderLayout.NORTH);

    }

    private JMenuBar prepareElementsMenu() {
        menuBar = new JMenuBar();
        menu = new JMenu("File");

        buttonNew = new JMenuItem("New");
        buttonOpen = new JMenuItem("Open");
        buttonSave = new JMenuItem("Save");
        buttonExit = new JMenuItem("Exit");

        menu.add(buttonNew);
        menu.add(buttonOpen);
        menu.add(buttonSave);
        menu.add(buttonExit);

        menuBar.add(menu);

        return menuBar;
    }

    private void prepareActions() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        buttonNew.addMouseListener(createMouseListener());
        buttonSave.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                save();
            }
        });
        buttonOpen.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                open();
            }
        });
        buttonExit.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                close();
            }
        });

//        startButton.addActionListener(e -> mostrarTablero()); // Agregar acción al botón de comenzar
//        exitButton.addActionListener(e -> close()); // Agregar acción al botón de salir
    }

    private MouseListener createMouseListener() {
        return new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(QuoridiorGUI.this, "Esta funcionalidad se encuentra en construcción", "Informacion", INFORMATION_MESSAGE);
            }
        };
    }

    private void close() {
        int result = JOptionPane.showConfirmDialog(QuoridiorGUI.this, "¿Estás seguro de que quieres salir?", "Confirmacion", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void save() {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(QuoridiorGUI.this, "Esta funcionalidad se encuentra en construcción", "Informacion", INFORMATION_MESSAGE);
        }
    }

    private void open() {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showOpenDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(QuoridiorGUI.this, "Esta funcionalidad se encuentra en construcción", "Informacion", INFORMATION_MESSAGE);
        }
    }

    private void createGrid() {
        this.getContentPane().removeAll();
        this.revalidate();
        this.repaint();
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        int cellSize = 40;
        int wallSize = 10;
        int borderPadding = calculateBorderPadding(cellSize, wallSize); // Calculamos el espacio adicional necesario en los bordes
        addCellAndWallButtons(cellSize, wallSize, borderPadding);
        int panelSize = calculatePanelSize(cellSize, wallSize, borderPadding);
        mainPanel.setPreferredSize(new Dimension(panelSize, panelSize));
        mainPanel.setVisible(false);
        add(mainPanel, BorderLayout.CENTER);
        this.ActualizarTablero();
    }

    private int calculateBorderPadding(int cellSize, int wallSize) {
        // Calculamos el espacio adicional necesario en los bordes para centrar los botones
        int totalCellAndWallSize = BOARD_SIZE * (cellSize + wallSize) - wallSize; // Tamaño total de las celdas y las paredes sin contar las paredes de los bordes
        return (totalCellAndWallSize - cellSize * BOARD_SIZE) / 2; // Espacio adicional en los bordes
    }

    private void addCellAndWallButtons(int cellSize, int wallSize, int borderPadding) {
        boardButtons = new JButton[BOARD_SIZE][BOARD_SIZE];
        horizontalWallButtons = new JButton[BOARD_SIZE - 1][BOARD_SIZE];
        verticalWallButtons = new JButton[BOARD_SIZE][BOARD_SIZE - 1];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                addButtonForCell(i, j, cellSize, wallSize, borderPadding);
                if (i < BOARD_SIZE - 1) {
                    addHorizontalWallButton(i, j, cellSize, wallSize, borderPadding);
                }
                if (j < BOARD_SIZE - 1) {
                    addVerticalWallButton(i, j, cellSize, wallSize, borderPadding);
                }
            }
        }
    }

    private void addButtonForCell(int i, int j, int cellSize, int wallSize, int borderPadding) {
        JButton cellButton = new JButton();
        cellButton.setBackground(Color.WHITE);
        cellButton.setBounds(borderPadding + j * (cellSize + wallSize), borderPadding + i * (cellSize + wallSize), cellSize, cellSize);
        cellButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cellButton.addActionListener(e -> {
            if (!quoridor.turn(TypeMove.piecemove, i, j)) {
                System.out.println("No es un movimiento valido");
            }
            this.ActualizarTablero();
        });
        mainPanel.add(cellButton);
        if (i == quoridor.getPlayer1().getX() && j == quoridor.getPlayer1().getY()) {
            cellButton.setBackground(quoridor.getPlayer1().getPlayerColor());
        }
        if (i == quoridor.getPlayer2().getX() && j == quoridor.getPlayer2().getY()) {
            cellButton.setBackground(quoridor.getPlayer2().getPlayerColor());
        }
        // Agregar el botón de celda al array boardButtons
        boardButtons[i][j] = cellButton;

    }

    private void ActualizarTablero() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                this.boardButtons[i][j].setBackground(Color.WHITE);
                if (this.quoridor.getPlayer1().getX() == i && this.quoridor.getPlayer1().getY() == j) {
                    this.boardButtons[i][j].setBackground(this.quoridor.getPlayer1().getPlayerColor());
                }
                if (this.quoridor.getPlayer2().getX() == i && this.quoridor.getPlayer2().getY() == j) {
                    this.boardButtons[i][j].setBackground(this.quoridor.getPlayer2().getPlayerColor());
                }
            }
        }
    }

    private void addHorizontalWallButton(int i, int j, int cellSize, int wallSize, int borderPadding) {
        JButton horizontalWallButton = new JButton();
        horizontalWallButton.setBackground(Color.LIGHT_GRAY);
        horizontalWallButton.setBounds(borderPadding + j * (cellSize + wallSize), borderPadding + (i + 1) * (cellSize + wallSize) - wallSize, cellSize, wallSize);
        mainPanel.add(horizontalWallButton);

        // Agregar el botón de pared horizontal al array horizontalWallButtons
        horizontalWallButtons[i][j] = horizontalWallButton;
    }

    private void addVerticalWallButton(int i, int j, int cellSize, int wallSize, int borderPadding) {
        JButton verticalWallButton = new JButton();
        verticalWallButton.setBackground(Color.LIGHT_GRAY);
        verticalWallButton.setBounds(borderPadding + (j + 1) * (cellSize + wallSize) - wallSize, borderPadding + i * (cellSize + wallSize), wallSize, cellSize);
        mainPanel.add(verticalWallButton);

        // Agregar el botón de pared vertical al array verticalWallButtons
        verticalWallButtons[i][j] = verticalWallButton;
    }

    private int calculatePanelSize(int cellSize, int wallSize, int borderPadding) {
        return BOARD_SIZE * cellSize + (BOARD_SIZE - 1) * wallSize + 2 * borderPadding; // Añadimos el espacio adicional en los bordes
    }

    private void mostrarTablero() {
        mainPanel.setVisible(true);
        startButton.setVisible(false);
        exitButton.setVisible(false);
        createGame.setVisible(false);

        opcionesPartidas().setVisible(false);
        buttonPanel.setVisible(false);

        add(mainPanel, BorderLayout.CENTER);

    }

//   private void preparateElementsPlayer1(){
//    // Assuming player1 is a JPanel and it's defined in your class
//    player1.removeAll();
//    // agregamos los componentes al panel de la informacion del jugador 1
//    JLabel labelPlayer1 = new JLabel("Jugador 1");
//    player1.add(labelPlayer1);
//
//    //crear un panel para el JcomboBox y la etiqueta
//    JPanel bridgePanel = new JPanel(); // Define bridgePanel here
//    bridgePanel.setLayout(new BoxLayout(bridgePanel, BoxLayout.Y_AXIS));
//
//    //crear un JcomboBox de la etiqueta
//    JLabel bridgeLabel = new JLabel("Tipo de barrera");
//    bridgeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
//    bridgeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//    //crear un JcomboBox de las opciones
//    String[] opciones = {"normal", "temporal"};
//    JComboBox<String> comboBox = new JComboBox<>(opciones);
//
//    //personalizar el JcomboBox
//    bridgeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
//    bridgeLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//    bridgeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//    //agregamos la etiqueta y el jcombobox al panel
//    bridgePanel.add(bridgeLabel);
//    bridgePanel.add(Box.createVerticalStrut(10));
//    bridgePanel.add(comboBox);
//
//    player1.add(bridgePanel);
//
//}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuoridiorGUI gui = new QuoridiorGUI();
            gui.setVisible(true);
        });
    }

    private JComboBox<String> opcionesPartidas() {
        String[] dificultades = {"Computador vs humano", "Computador vs computador", "Humano vs humano"};
        JComboBox<String> comboBox = new JComboBox<>(dificultades);
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedDifficulty = (String) comboBox.getSelectedItem();
            }
        };
        comboBox.addActionListener(actionListener);

        return comboBox;
    }



    private JPanel preparateConfigGame(){

        getContentPane().removeAll();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        //ponme un margen de 20 pixeles
        panel.setBorder(new EmptyBorder(20,20,20,20));
        panel.add(new JLabel("Configuración de la partida"));
        panel.add(createGame);
        panel.setBackground(new Color(0, 0, 0, 0));
        panel.add(prepareElementsTypeGame());
        panel.add(prepareElementsSizeBoard());
        panel.add(dificultad());
        panel.add(nombres());
        panel.add(colores());

        repaint();
        revalidate();
        return panel;
    }



    private JPanel prepareElementsTypeGame(){
        JPanel panel = new JPanel();
        panel.setBorder(new CompoundBorder(new EmptyBorder(0,0,0,0), new TitledBorder("Tipo de Juego")));
        panel.setLayout(new GridLayout(0,1, WIDTH,0));
        comboBox = new JComboBox<>();
        comboBox.addItem("Humano vs Humano");
        comboBox.addItem("Humano vs Computador");
        comboBox.addItem("Computador vs Computador");
        panel.add(comboBox);
        return panel;
    }

    private JPanel prepareElementsSizeBoard(){
        JPanel panel = new JPanel();
        panel.setBorder(new CompoundBorder(new EmptyBorder(0,0,0,0), new TitledBorder("Tamaño del Tablero")));
        panel.setLayout(new GridLayout(0,1, WIDTH,0));
        JTextField textField = new JTextField();
        panel.add(textField);
        return panel;
    }

    private JPanel dificultad(){
        JPanel panel = new JPanel();
        panel.setBorder(new CompoundBorder(new EmptyBorder(0,0,0,0), new TitledBorder("Dificultad:")));
        panel.setLayout(new GridLayout(0,1, WIDTH,0));
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Facil");
        comboBox.addItem("Medio");
        comboBox.addItem("Dificil");
        panel.add(comboBox);
        return panel;
    }

    private JPanel nombres(){
        JPanel panel = new JPanel();
        panel.setBorder(new CompoundBorder(new EmptyBorder(0,0,0,0), new TitledBorder("Nombres de los jugadores")));
        panel.setLayout(new GridLayout(0,1, WIDTH,0));
        textField1 = new JTextField();
        textField2 = new JTextField();
        panel.add(textField1);
        panel.add(textField2);
        return panel;
    }


   private JPanel colores(){
    JPanel panel = new JPanel();
    panel.setBorder(new CompoundBorder(new EmptyBorder(0,0,0,0), new TitledBorder("Colores de los jugadores")));
    panel.setLayout(new GridLayout(0,1, WIDTH,0));

    JButton colorButton1 = new JButton("Seleccionar Color Jugador 1");
    colorButton1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = JColorChooser.showDialog(null, "Selecciona un color para el Jugador 1", Color.RED);
            if (color != null) {
                colorButton1.setBackground(color);
                quoridor.getPlayer1().setPlayerColor(color); // Asume que quoridor es una variable de instancia de la clase Quoridor
            }
        }
    });

    JButton colorButton2 = new JButton("Seleccionar Color Jugador 2");
    colorButton2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = JColorChooser.showDialog(null, "Selecciona un color para el Jugador 2", Color.BLUE);
            if (color != null) {
                colorButton2.setBackground(color);
                quoridor.getPlayer2().setPlayerColor(color); // Asume que quoridor es una variable de instancia de la clase Quoridor
            }
        }
    });

    panel.add(colorButton1);
    panel.add(colorButton2);
    return panel;
}

}
