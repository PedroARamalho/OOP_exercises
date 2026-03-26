import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrianguloTest {

    @Test
    public void test_valid_triangle() {
        String validTrianglePoints = "0 0 1 1 0 2";
        Triangulo triangle = new Triangulo(validTrianglePoints);
        assertEquals(3, triangle.pontos.size(), "Triangle should have exactly 3 points.");
    }
}
