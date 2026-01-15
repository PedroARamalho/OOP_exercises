public class Ponto {
    private double x, y;

    public Ponto(double x, double y){
        if (x < 0 || y < 0) {            // Verifica se ambas as coordenadas são positivas
            System.out.println("Ponto:vi");
            System.exit(0);        // Terminar com codigo zero
        } else {
            this.x = x;
            this.y = y;
        }
    }

    public double dist (Ponto that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
