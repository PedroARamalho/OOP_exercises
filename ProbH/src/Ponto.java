public class Ponto{
    private double x, y;

    public Ponto(double x, double y) {
        if(x >= 0 && y >= 0){
            this.x = x;
            this.y = y;
        }
        else {
            System.out.println("Ponto:vi");
            System.exit(0);
        }
    }
    double dist(Ponto p) {
        double dx = x - p.getX();
        double dy = y - p.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean isRepetido(Ponto[] points, int current){
        for (int i = 0; i < current; i++) {
            if (points[i] == points[current])
                return true;
        }
        return false;
    }


    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
}

