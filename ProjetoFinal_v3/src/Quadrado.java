import java.util.ArrayList;
import java.util.List;

public class Quadrado extends Retangulo {

    public Quadrado(String s) {
        super(s);
        if (!isQuadrado()) {
            throw new IllegalArgumentException("Quadrado:vi");
        }
    }

    private boolean isQuadrado() {
        if (this.pontos.size() != 4) {
            return false;
        }

        double dist_AB = pontos.get(0).dist(pontos.get(1));
        double dist_BC = pontos.get(1).dist(pontos.get(2));
        double dist_CD = pontos.get(2).dist(pontos.get(3));
        double dist_DA = pontos.get(3).dist(pontos.get(0));

        return dist_AB == dist_BC && dist_BC == dist_CD && dist_CD == dist_DA;
    }

    @Override
    public String toString() {
        StringBuilder s_out = new StringBuilder();
        s_out.append("Quadrado: [");
        for (int i = 0; i < pontos.size(); i++) {
            int x = (int) pontos.get(i).getX();
            int y = (int) pontos.get(i).getY();
            s_out.append("(").append(x).append(",").append(y).append(")");
            if (i < pontos.size() - 1) {
                s_out.append(", ");
            }
        }
        s_out.append("]");
        return s_out.toString();
    }

    public Ponto[] getPointsInside() {
        List<Ponto> pointsInside = new ArrayList<>();

        double minX = Double.MAX_VALUE, minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE, maxY = Double.MIN_VALUE;
        for (Ponto vertex : pontos) {
            double x = vertex.getX();
            double y = vertex.getY();
            if (x < minX) minX = x;
            if (x > maxX) maxX = x;
            if (y < minY) minY = y;
            if (y > maxY) maxY = y;
        }

        for (int x = (int) Math.ceil(minX); x <= maxX; x++) {
            for (int y = (int) Math.ceil(minY); y <= maxY; y++) {
                if (isInside(x, y)) {
                    pointsInside.add(new Ponto(x, y));
                }
            }
        }

        Ponto[] pointsArray = new Ponto[pointsInside.size()];
        pointsArray = pointsInside.toArray(pointsArray);

        return pointsArray;
    }

    private boolean isInside(double x, double y) {
        double[] xCoords = new double[pontos.size()];
        double[] yCoords = new double[pontos.size()];
        for (int i = 0; i < pontos.size(); i++) {
            xCoords[i] = pontos.get(i).getX();
            yCoords[i] = pontos.get(i).getY();
        }

        boolean oddNodes = false;
        int j = pontos.size() - 1;
        for (int i = 0; i < pontos.size(); i++) {
            if ((yCoords[i] < y && yCoords[j] >= y || yCoords[j] < y && yCoords[i] >= y)
                    && (xCoords[i] <= x || xCoords[j] <= x)) {
                if (xCoords[i] + (y - yCoords[i]) / (yCoords[j] - yCoords[i]) * (xCoords[j] - xCoords[i]) < x) {
                    oddNodes = !oddNodes;
                }
            }
            j = i;
        }

        return oddNodes;
    }

    public int getHeight() {
        return (int) (pontos.get(2).getY() - pontos.get(0).getY());
    }

    public int getWidth() {
        return (int) (pontos.get(1).getX() - pontos.get(0).getX());
    }

    public double getX() {
        return pontos.get(0).getX();
    }

    public double getY() {
        return pontos.get(0).getY();
    }

    public void setPosition(double x, double y) {
        double deltaX = x - pontos.get(0).getX();
        double deltaY = y - pontos.get(0).getY();
        for (Ponto ponto : pontos) {
            ponto.setX(ponto.getX() + deltaX);
            ponto.setY(ponto.getY() + deltaY);
        }
    }
}
