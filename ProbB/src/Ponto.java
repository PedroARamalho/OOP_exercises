public class Ponto {
    private double x, y;

    //Construtor
    public Ponto(double x, double y) {
        if (x >= 0 && y >= 0) {         // Verifica se ambas as coordenadas são positivas
            this.x = x;
            this.y = y;
        } else {
            System.out.println("iv");
            System.exit(0);        // Terminar com codigo zero
        }
    }

    // Funcao para calcular distancia entre pontos
    public double dist(Ponto p) {
        double dx = this.x - p.x;
        double dy = this.y - p.x;
        return Math.sqrt(dx * dx + dy * dy);

    }

}
