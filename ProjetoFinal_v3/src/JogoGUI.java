import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
/**
 * Classe JogoGUI representa a interface gráfica do jogo da cobra.
 */
public class JogoGUI extends JFrame {
    private Snake snake;
    private Arena arena;
    private Comida comida;
    private List<Obstacle> obstacles;
    private int score;
    private javax.swing.Timer gameTimer;
    private boolean isPaused = false;

    private JPanel gamePanel;
    private JLabel scoreLabel;

    private int directionX = 1;
    private int directionY = 0;

    private static int CELL_SIZE = 20;
    private static int ARENA_WIDTH = 20;
    private static int ARENA_HEIGHT = 20;

    private static final Dimension MENU_SIZE = new Dimension(300, 200); // Tamanho fixo do menu
    /**
     * Construtor da classe JogoGUI. Inicializa a janela do jogo.
     */
    public JogoGUI() {
        setTitle("Jogo da Cobra");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setupConfigPanel();
    }
    /**
     * Configura o painel de configuração do jogo.
     */
    private void setupConfigPanel() {
        JPanel configPanel = new JPanel();
        configPanel.setLayout(new GridLayout(4, 2));
        configPanel.setPreferredSize(MENU_SIZE);

        JLabel headSizeLabel = new JLabel("Tamanho da Cabeça:");
        JTextField headSizeField = new JTextField("1");

        JLabel widthLabel = new JLabel("Largura da Arena:");
        JTextField widthField = new JTextField("20");

        JLabel heightLabel = new JLabel("Altura da Arena:");
        JTextField heightField = new JTextField("20");

        JButton startButton = new JButton("Iniciar Jogo");
        startButton.addActionListener(e -> {
            int headSize = Integer.parseInt(headSizeField.getText());
            ARENA_WIDTH = Integer.parseInt(widthField.getText());
            ARENA_HEIGHT = Integer.parseInt(heightField.getText());

            initializeGame(headSize, ARENA_WIDTH, ARENA_HEIGHT);
            setContentPane(gamePanel);
            pack();
            setVisible(true);
        });

        configPanel.add(headSizeLabel);
        configPanel.add(headSizeField);
        configPanel.add(widthLabel);
        configPanel.add(widthField);
        configPanel.add(heightLabel);
        configPanel.add(heightField);
        configPanel.add(new JLabel()); // Empty label for layout
        configPanel.add(startButton);

        setContentPane(configPanel);
        pack();
        setSize(MENU_SIZE);
        setLocationRelativeTo(null); // Centralize the window
        setVisible(true);
    }
    /**
     * Configura o painel do jogo onde a ação acontece.
     */
    private void setupGamePanel() {
        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGame(g);
            }
        };
        gamePanel.setBackground(Color.BLACK);
        gamePanel.setPreferredSize(new Dimension(ARENA_WIDTH * CELL_SIZE, ARENA_HEIGHT * CELL_SIZE));
    }
    /**
     * Configura o painel de informações que mostra a pontuação do jogo.
     */
    private void setupInfoPanel() {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());

        scoreLabel = new JLabel("Pontuação: 0");
        scoreLabel.setForeground(Color.WHITE);
        infoPanel.add(scoreLabel, BorderLayout.NORTH);

        add(infoPanel, BorderLayout.EAST);
    }
    /**
     * Inicializa os elementos do jogo, como a cobra, a comida e os obstáculos.
     *
     * @param headSize Tamanho da cabeça da cobra.
     * @param width    Largura da arena do jogo.
     * @param height   Altura da arena do jogo.
     */
    private void initializeGame(int headSize, int width, int height) {
        Random random = new Random();

        int maxObstacles = 5;

        score = 0;
        obstacles = new ArrayList<>();

        try {
            for (int i = 0; i < maxObstacles; i++) {
                int randomX = random.nextInt(Math.max(1, width - headSize));
                int randomY = random.nextInt(Math.max(1, height - headSize));
                Obstacle obstacle = new Obstacle(randomX, randomY, headSize);
                obstacles.add(obstacle);
            }

            arena = new Arena(width, height);
            snake = new Snake(headSize, width, height);
            comida = new Comida(width, height, headSize);

            arena.drawComida(comida);
            arena.drawSnake(snake);

            for (Obstacle obstacle : obstacles) {
                arena.drawObstacle(obstacle);
            }

            gameTimer = new javax.swing.Timer(100, e -> gameLoop());
            gameTimer.start();
        } catch (IllegalArgumentException e) {
            System.err.println("Erro na inicialização do jogo: " + e.getMessage());
        }

        setupGamePanel();
        setupInfoPanel();

        setSize(width * CELL_SIZE, height * CELL_SIZE);
        setMinimumSize(new Dimension(width * CELL_SIZE, height * CELL_SIZE));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e.getKeyCode());
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }
    /**
     * Loop principal do jogo, responsável por mover a cobra e verificar colisões.
     */
    private void gameLoop() {
        if (!isPaused) {
            snake.move(directionX, directionY);

            if (arena.checkCollisionWithWall(snake)) {
                gameOver("BATEU NA PAREDE");
                return;
            }

            if (arena.checkCollisionWithFood(snake, comida)) {
                snake.grow();
                score += 10;
                updateScore();
                repositionFood();
            }

            for (Obstacle obstacle : obstacles) {
                if (arena.checkCollisionWithObstacle(snake, obstacle)) {
                    gameOver("BATEU NO OBSTÁCULO");
                    return;
                }
            }

            if (arena.checkCollisionWithTail(snake)) {
                gameOver("BATEU NA CAUDA");
                return;
            }

            arena.initializeMatrix();
            arena.drawSnake(snake);
            arena.drawComida(comida);
            for (Obstacle obstacle : obstacles) {
                arena.drawObstacle(obstacle);
            }

            gamePanel.repaint();
        }
    }
    /**
     * Atualiza a pontuação exibida no painel de informações.
     */
    private void updateScore() {
        scoreLabel.setText("Pontuação: " + score);
    }
    /**
     * Reposiciona a comida em uma nova posição aleatória na arena.
     */
    private void repositionFood() {
        Random random = new Random();
        int newX = random.nextInt(Math.max(1, arena.getWidth() - snake.getHeadSize()));
        int newY = random.nextInt(Math.max(1, arena.getHeight() - snake.getHeadSize()));
        comida.setPosition(newX, newY);
    }
    /**
     * Trata os eventos de tecla pressionada para mover a cobra ou pausar o jogo.
     *
     * @param keyCode Código da tecla pressionada.
     */
    private void handleKeyPress(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_W -> {
                if (directionY == 0) {
                    directionX = 0;
                    directionY = -snake.getHeadSize();
                }
            }
            case KeyEvent.VK_A -> {
                if (directionX == 0) {
                    directionX = -snake.getHeadSize();
                    directionY = 0;
                }
            }
            case KeyEvent.VK_S -> {
                if (directionY == 0) {
                    directionX = 0;
                    directionY = snake.getHeadSize();
                }
            }
            case KeyEvent.VK_D -> {
                if (directionX == 0) {
                    directionX = snake.getHeadSize();
                    directionY = 0;
                }
            }
            case KeyEvent.VK_P -> togglePause();
            case KeyEvent.VK_ESCAPE -> System.exit(0);
        }
    }
    /**
     * Alterna entre pausar e retomar o jogo.
     */
    private void togglePause() {
        isPaused = !isPaused;
        if (isPaused) {
            gameTimer.stop();
        } else {
            gameTimer.start();
        }
    }
    /**
     * Encerra o jogo e exibe uma mensagem de fim de jogo.
     *
     * @param message Mensagem de fim de jogo.
     */
    private void gameOver(String message) {
        gameTimer.stop();
        JOptionPane.showMessageDialog(this, "Fim de Jogo\n" + message + "\nPontuação: " + score, "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
        setupConfigPanel();
    }
    /**
     * Desenha o estado atual do jogo na interface gráfica.
     *
     * @param g Objeto Graphics utilizado para desenhar os componentes.
     */
    private void drawGame(Graphics g) {
        if (arena != null) {
            for (int y = 0; y < arena.getHeight(); y++) {
                for (int x = 0; x < arena.getWidth(); x++) {
                    char cell = arena.getMatrix()[y][x];
                    switch (cell) {
                        case 'F' -> g.setColor(Color.RED);
                        case 'O' -> g.setColor(Color.GRAY);
                        case 'H' -> g.setColor(Color.GREEN);
                        case 'T' -> g.setColor(Color.YELLOW);
                        default -> g.setColor(Color.BLACK);
                    }
                    g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JogoGUI::new);
    }
}
