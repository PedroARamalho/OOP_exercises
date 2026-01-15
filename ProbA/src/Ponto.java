public class Ponto {
    private final double x, y;
    // Construtor
    public Ponto(double x, double y) {
            this.x = x;
            this.y = y;
    }
    // Funcao para fazer distancia de pontos
    public double dist(Ponto p) {

        double dx = this.x - p.x;
        double dy = this.y - p.x;
        return Math.sqrt(dx * dx + dy * dy);

    }
}
