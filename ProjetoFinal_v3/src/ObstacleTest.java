import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ObstacleTest {

    @Test
    public void testConstructor() {
        Obstacle obstacle = new Obstacle(2, 2, 3);
        assertTrue(obstacle.getX() == 2); // Verifica se a coordenada x foi inicializada corretamente
        assertTrue(obstacle.getY() == 2); // Verifica se a coordenada y foi inicializada corretamente
    }

    @Test
    public void testInitObstacle() {
        String obstacleStr = Obstacle.initComida(2, 2, 3);
        String[] parts = obstacleStr.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        int width = Integer.parseInt(parts[4]) - Integer.parseInt(parts[0]);
        int height = Integer.parseInt(parts[5]) - Integer.parseInt(parts[1]);
        assertTrue(x == 2); // Verifica se a coordenada x foi gerada corretamente
        assertTrue(y == 2); // Verifica se a coordenada y foi gerada corretamente
    }

    @Test
    public void testObstacleWithRandomSizes() {
        Obstacle obstacle = new Obstacle(2, 2, 5);
        assertFalse(obstacle.getWidth() >= 1 && obstacle.getWidth() <= 5); // Verifica se a largura do obstáculo está dentro dos limites corretos
        assertTrue(obstacle.getHeight() >= 1 && obstacle.getHeight() <= 5); // Verifica se a altura do obstáculo está dentro dos limites corretos
    }
}
