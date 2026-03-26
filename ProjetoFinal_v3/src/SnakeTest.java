import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class SnakeTest {

    @Test
    public void testConstructor() {
        Snake snake = new Snake(3, 5, 5);
        assertEquals(0, snake.getSize()); // Verifica se o tamanho inicial da cobra está correto
        assertEquals(1, snake.getBody().size()); // Verifica se a lista do corpo da cobra contém apenas a cabeça inicial
    }

    @Test
    public void testMove() {
        Snake snake = new Snake(3, 5, 5);
        snake.move(1, 0); // Move a cobra uma unidade para a direita
        assertEquals(1, snake.getBody().get(0).getX()); // Verifica se a cabeça foi movida corretamente
    }

    @Test
    public void testGrow() {
        Snake snake = new Snake(3, 5, 5);
        snake.grow(); // Faz a cobra crescer
        assertEquals(1, snake.getSize()); // Verifica se o tamanho da cobra aumentou corretamente
        assertTrue(snake.getBody().get(1).getX() == 0 && snake.getBody().get(1).getY() == 0); // Verifica se o novo segmento foi adicionado corretamente
    }

    @Test
    public void testInitSnake() {
        String expected = "0 0 0 3 3 3 3 0"; // Espera-se que a string de inicialização tenha esse formato
        assertEquals(expected, Snake.initSnake(3)); // Verifica se o método initSnake retorna a string esperada
    }
}
