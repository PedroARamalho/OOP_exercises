import java.util.List;
import java.util.ArrayList;

public class Arena {
    private int width;
    private int height;
    private  char[][] matrix;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height][width];
        initializeMatrix();
    }
    public void initializeMatrix() {
        // Fill the matrix with dots to represent empty cells
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                matrix[y][x] = '.';
            }
        }
    }

    public void draw() {
        // Print the contents of the matrix representing the arena
        for (char[] row : matrix) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    public void drawComida(Comida comida) {

        Ponto[] pointsArray = comida.getPointsInside();
        for (Ponto currentPoint : pointsArray) {
            int x = (int) currentPoint.getX();
            int y = (int) currentPoint.getY();
            if (x > 0 && x < width && y > 0 && y < height)
            matrix[y][x] = 'F'; // Draw food represented by 'F' at position (x, y)
        }
    }

    public void drawObstacle(Obstacle obstaculo) {

        Ponto[] pointsArray = obstaculo.getPointsInside();
        for (Ponto currentPoint : pointsArray) {
            int x = (int) currentPoint.getX();
            int y = (int) currentPoint.getY();
            if (x > 0 && x < width && y > 0 && y < height)
            matrix[y][x] = 'O';
        }
    }



    public void drawSnake(Snake snake) {
        List<Quadrado> body = snake.getBody();

        if (body.isEmpty()) {
            Quadrado head = snake;
            Ponto[] pointsArray = head.getPointsInside();
            for (Ponto currentPoint : pointsArray) {
                int x = (int) currentPoint.getX();
                int y = (int) currentPoint.getY();
                if (x >= 0 && x < width && y >= 0 && y < height) { // Verificar se está dentro dos limites
                    matrix[y][x] = 'H';
                }
            }
        } else {
            Quadrado head = body.get(0);
            Ponto[] pointsArray = head.getPointsInside();
            for (Ponto currentPoint : pointsArray) {
                int x = (int) currentPoint.getX();
                int y = (int) currentPoint.getY();
                if (x >= 0 && x < width && y >= 0 && y < height) { // Verificar se está dentro dos limites
                    matrix[y][x] = 'H';
                }
            }

            for (int i = 1; i < body.size(); i++) {
                Quadrado segment = body.get(i);
                pointsArray = segment.getPointsInside();
                for (Ponto currentPoint : pointsArray) {
                    int x = (int) currentPoint.getX();
                    int y = (int) currentPoint.getY();
                    if (x >= 0 && x < width && y >= 0 && y < height) { // Verificar se está dentro dos limites
                        matrix[y][x] = 'T';
                    }
                }
            }
        }

        System.out.println();
    }

    public boolean checkCollisionWithFood(Snake snake, Comida comida) {
        Quadrado head = snake.getBody().get(0); // Obter a cabeça da cobra
        Ponto[] pointsInside = head.getPointsInside(); // Obter os pontos dentro da cabeça da cobra
        for (Ponto point : pointsInside) {
            int x = (int) point.getX();
            int y = (int) point.getY();
            if (x >= 0 && x < width && y >= 0 && y < height) { // Verificar se está dentro dos limites
                if (matrix[y][x] == 'F') { // Verificar se a cabeça da cobra está na mesma posição que a comida
                    return true;
                }
            }
        }
        return false;
    }


    public boolean checkCollisionWithTail(Snake snake) {
        for (int i = 4; i <= snake.getSize(); i++) {
            if (snake.getBody().get(0).Duplicates(snake.getBody().get(i)))
                    return true;
        }
        return false;
    }

    public boolean checkCollisionWithObstacle(Snake snake, Obstacle obstaculo) {
        Quadrado head = snake.getBody().get(0); // Obter a cabeça da cobra
        Ponto[] pointsInside = head.getPointsInside(); // Obter os pontos dentro da cabeça da cobra
        for (Ponto point : pointsInside) {
            int x = (int) point.getX();
            int y = (int) point.getY();
            if (x >= 0 && x < width && y >= 0 && y < height) { // Verificar se está dentro dos limites
                if (matrix[y][x] == 'O') { // Verificar se a cabeça da cobra está na mesma posição que o obstáculo
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkCollisionWithWall(Snake snake){
        Quadrado head = snake.getBody().get(0); // Obter a cabeça da cobra
        Ponto[] pointsInside = head.getPointsInside(); // Obter os pontos dentro da cabeça da cobra
        for (Ponto point : pointsInside) {
            int x = (int) point.getX();
            int y = (int) point.getY();
            if (x < 0 || x >= width || y < 0 || y >= height) { // Verificar se a cabeça da cobra está fora dos limites da arena
                return true;
            }
        }
        return false;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public char[][] getMatrix() {
        return this.matrix;
    }

}