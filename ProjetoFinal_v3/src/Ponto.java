import java.util.Objects;

public class Ponto {
    private double x;
    private double y;

    public Ponto(double x, double y) {
        if (x < 0 || y < 0) {
            //throw new IllegalArgumentException("Ponto:vi");


        }
        this.x = x;
        this.y = y;
    }

    public double dist(Ponto p) {
        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + (int) x + "," + (int) y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ponto ponto = (Ponto) o;
        return Double.compare(ponto.x, x) <= 1e-9 && Double.compare(ponto.y, y) <= 1e-9;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
