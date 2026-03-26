import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuadradoTest {

    @Test
    public void testSuccessfulSquareCreation() {
        String validSquarePoints = "0 0 0 2 2 2 2 0";
        assertDoesNotThrow(() -> new Quadrado(validSquarePoints), "Should successfully create a square with valid points.");
    }

    @Test
    public void testFailureOnRectangleCreation() {
        String invalidSquarePoints = "0 0 0 3 4 3 4 0";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Quadrado(invalidSquarePoints), "Expected to throw IllegalArgumentException for invalid square points.");
        assertTrue(exception.getMessage().contains("Quadrado:vi"), "Expected failure due to invalid square properties.");
    }
}
