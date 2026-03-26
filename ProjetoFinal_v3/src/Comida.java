import java.util.Random;

public class Comida extends Quadrado {
    public Comida(int arenaWidth, int arenaHeight, int headSize) {
        super(initComida(arenaWidth, arenaHeight, headSize));
    }

    protected static String initComida(int arenaWidth, int arenaHeight, int headSize) {
        Random random = new Random();

        int maxX = Math.max(1, arenaWidth - headSize);
        int maxY = Math.max(1, arenaHeight - headSize);

        int x = random.nextInt(maxX);
        int y = random.nextInt(maxY);

        int x2 = x + headSize;
        int y2 = y + headSize;

        // Ensure points are forming a valid square
        x2 = Math.min(x2, arenaWidth - 1);
        y2 = Math.min(y2, arenaHeight - 1);

        return x + " " + y + " " + x + " " + y2 + " " + x2 + " " + y2 + " " + x2 + " " + y;
    }

    public void setPosition(int x, int y) {
        super.setPosition(x, y);
    }
}
