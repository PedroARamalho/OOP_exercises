import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter the size of the head of the snake:");
        int headSize = scanner.nextInt();

        System.out.println("Enter the width of the arena:");
        int width = scanner.nextInt();

        System.out.println("Enter the height of the arena:");
        int height = scanner.nextInt();

        // Verificar se o tamanho da cabeça da cobra é menor ou igual à largura/altura da arena
        if (headSize >= width || headSize >= height) {
            System.out.println("O tamanho da cabeça da cobra é muito grande para a arena.");
            return;
        }


        System.out.println("Enter the maximum number of obstacles:");
        int maxObstacles = scanner.nextInt();

        int score = 0; // Variável de pontuação

        ArrayList<Obstacle> obstacles = new ArrayList<>(); // Lista para armazenar os obstáculos

        // Gerar obstáculos aleatórios
        for (int i = 0; i < maxObstacles; i++) {
            int randomX = random.nextInt(width);
            int randomY = random.nextInt(height);
            Obstacle obstacle = new Obstacle(randomX, randomY, headSize);
            obstacles.add(obstacle);
        }

        Arena arena = new Arena(width, height);
        Snake snake = new Snake(headSize, width, height);
        Comida c1 = new Comida(random.nextInt(width), random.nextInt(height), headSize);

        arena.drawComida(c1);
        arena.drawSnake(snake);

        // Desenhar todos os obstáculos
        for (Obstacle obstacle : obstacles) {
            arena.drawObstacle(obstacle);
        }

        arena.draw();

        // Loop para receber os comandos WASD até o usuário pressionar uma tecla inválida
        while (true) {
            System.out.println("Use WASD keys to move the snake (W - up, A - left, S - down, D - right)");
            char moveDirection = scanner.next().charAt(0);
            int directionX = 0, directionY = 0;
            boolean collisionWithTail = false;

            // Interpretar o movimento com base na entrada do usuário
            switch (moveDirection) {
                case 'W':
                case 'w':
                    directionY = -headSize; // Move para cima
                    break;
                case 'A':
                case 'a':
                    directionX = -headSize; // Move para a esquerda
                    break;
                case 'S':
                case 's':
                    directionY = headSize; // Move para baixo
                    break;
                case 'D':
                case 'd':
                    directionX = headSize; // Move para a direita
                    break;
                default:
                    // Tecla inválida, encerrar o loop
                    return;
            }

            // Movimentar a cobra na direção especificada
            //snake.move(directionX, directionY);

            if (arena.checkCollisionWithWall(snake)) {
                // Se houver colisão com a parede, encerrar o jogo
                System.out.println("BATEU NA PAREDE");
                System.exit(0);
            }

            // Verificar colisão com comida
            if (arena.checkCollisionWithFood(snake, c1)) {
                // Se houver colisão com comida, crescer a cobra, reposicionar a comida e aumentar a pontuação
                snake.grow();
                int newX = random.nextInt(width - headSize); // Limitar dentro dos limites da arena
                int newY = random.nextInt(height - headSize); // Limitar dentro dos limites da arena
                c1.setPosition(newX, newY);
                score += 10; // Incrementar a pontuação
                System.out.println("Score: " + score); // Exibir a pontuação atual
            }

            // Verificar colisão com obstáculos
            for (Obstacle obstacle : obstacles) {
                if (arena.checkCollisionWithObstacle(snake, obstacle)) {
                    // Se houver colisão com um obstáculo, encerrar o jogo
                    System.out.println("BATEU NO OBSTÁCULO");
                    System.exit(0);
                }
            }

            // Verificar colisão com a cauda
            if (arena.checkCollisionWithTail(snake)) {
                // Se houver colisão com a cauda, encerrar o jogo
                System.out.println("BATEU NA CAUDA");
                System.exit(0);
            }

            // Limpar a arena e desenhar a cobra, os obstáculos e a comida
            arena.initializeMatrix();
            arena.drawSnake(snake);
            arena.drawComida(c1);

            // Desenhar todos os obstáculos
            for (Obstacle obstacle : obstacles) {
                arena.drawObstacle(obstacle);
            }

            arena.draw();
        }
    }
}
