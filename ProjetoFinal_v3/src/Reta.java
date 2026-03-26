public class Reta {

    private Ponto p1;
    private Ponto p2;

    public Reta(Ponto p1, Ponto p2) {
        if (Math.abs(p1.dist(p2)) < Math.pow(10, -9)) {
            throw new IllegalArgumentException("Reta:vi");
        }
        this.p1 = p1;
        this.p2 = p2;
    }

    public boolean areCollinear(Ponto p) {
        double inclinacao0 = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
        double inclinacao1 = (p.getY() - p1.getY()) / (p.getX() - p1.getX());
        return Math.abs(inclinacao0 - inclinacao1) < Math.pow(10, -9);
    }
}
