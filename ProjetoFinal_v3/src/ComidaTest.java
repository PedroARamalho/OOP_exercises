import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ComidaTest {

    @Test
    public void testConstructor() {
        Comida comida = new Comida(5, 5, 1);
        assertTrue(comida.getX() >= 0 && comida.getX() <= 4); // Verifica se a coordenada x está dentro dos limites da arena
        assertTrue(comida.getY() >= 0 && comida.getY() <= 4); // Verifica se a coordenada y está dentro dos limites da arena
        assertFalse(comida.getWidth() == 1); // Verifica se a largura da comida é incorreta
        assertTrue(comida.getHeight() == 1); // Verifica se a altura da comida é correta
    }

    @Test
    public void testInitComida() {
        String comidaStr = Comida.initComida(5, 5, 1);
        String[] parts = comidaStr.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        int width = Integer.parseInt(parts[4]) - Integer.parseInt(parts[0]);
        int height = Integer.parseInt(parts[5]) - Integer.parseInt(parts[1]);
        assertTrue(x >= 0 && x <= 4); // Verifica se a coordenada x está dentro dos limites da arena
        assertTrue(y >= 0 && y <= 4); // Verifica se a coordenada y está dentro dos limites da arena
        assertTrue(width == 1); // Verifica se a largura da comida é correta
        assertTrue(height == 1); // Verifica se a altura da comida é correta
    }

    @Test
    public void testComidaInsideArena() {
        int arenaWidth = 10;
        int arenaHeight = 10;
        int headSize = 2;
        Comida comida = new Comida(arenaWidth, arenaHeight, headSize);
        assertTrue(comida.getX() >= 0 && comida.getX() <= arenaWidth - headSize); // Verifica se a coordenada x está dentro dos limites da arena
        assertTrue(comida.getY() >= 0 && comida.getY() <= arenaHeight - headSize); // Verifica se a coordenada y está dentro dos limites da arena
    }

    @Test
    public void testComidaWithRandomSizes() {
        int arenaWidth = 10;
        int arenaHeight = 10;
        int headSize = 2;
        Comida comida = new Comida(arenaWidth, arenaHeight, headSize);
        assertFalse(comida.getWidth() >= 1 && comida.getWidth() <= headSize); // Verifica se a largura da comida não está dentro dos limites corretos
        assertTrue(comida.getHeight() >= 1 && comida.getHeight() <= headSize); // Verifica se a altura da comida está dentro dos limites corretos
    }
}
