import java.util.Random;

public class Obstacle extends Quadrado {
    public Obstacle(int x, int y, int headSize) {
        super(initComida(x, y, headSize));
    }

    protected static String initComida(int x, int y, int headSize) {
        Random random = new Random();

        int x2 = x + headSize;
        int y2 = y + headSize;

        // Ensure points are within bounds and form a valid square
        if (x2 < x || y2 < y) {
            x = Math.max(0, x - headSize);
            y = Math.max(0, y - headSize);
            x2 = x + headSize;
            y2 = y + headSize;
        }

        return x + " " + y + " " + x + " " + y2 + " " + x2 + " " + y2 + " " + x2 + " " + y;
    }
}
