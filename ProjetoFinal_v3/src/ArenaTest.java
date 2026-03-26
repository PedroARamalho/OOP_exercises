import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {

    @Test
    public void testCheckCollisionWithFood() {
        Arena arena = new Arena(5, 5);
        Snake snake = new Snake(1, 5, 5);
        Comida comida = new Comida(3, 3, 1); // Coloca a comida na posição (3,3)
        assertFalse(arena.checkCollisionWithFood(snake, comida)); // Verifica se há colisão com a comida
    }

    @Test
    public void testCheckCollisionWithWall() {
        Arena arena = new Arena(5, 5);
        Snake snake = new Snake(1, 5, 5);
        snake.setPosition(1, 0); // Posicionando a cabeça da cobra fora dos limites à esquerda
        assertFalse(arena.checkCollisionWithWall(snake));
    }

    @Test
    public void testCheckCollisionWithTail_NoCollision() {
        Arena arena = new Arena(5, 5);
        Snake snake = new Snake(1, 5, 5);
        assertFalse(arena.checkCollisionWithTail(snake)); // Não deve haver colisão quando a cobra é criada
    }



}