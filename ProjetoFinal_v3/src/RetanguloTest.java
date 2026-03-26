import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RetanguloTest {

    @Test
    public void testSuccessfulRectangleCreation() {
        String validRectanglePoints = "0 0 0 2 3 2 3 0";
        assertDoesNotThrow(() -> new Retangulo(validRectanglePoints), "Should successfully create a rectangle with valid points.");
    }

    @Test
    public void testFailureOnInvalidRectangleCreation() {
        String invalidRectanglePoints = "0 0 0 2 2 2 2 1";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Retangulo(invalidRectanglePoints), "Expected to throw IllegalArgumentException for invalid rectangle points.");
        assertTrue(exception.getMessage().contains("Retangulo:vi"), "Expected failure due to invalid rectangle properties.");
    }
}
