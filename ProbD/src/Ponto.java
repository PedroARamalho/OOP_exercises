/**
 Lê os dados de entrada, verifica as constraints, processa os dados utilizando a funcionalidade
 das classes e escreve o resultado na consola
 @author Pedro Ramalho 68010
 @version 4.0 27/2/23
 @inv x,y   Coordenadas do ponto, todas positivas e pertencentes ao 1º quadrante
 @param x>=0 && y>=0
 */
public class Ponto {

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

    /**Metodo para calcular se um ponto está num segmento
     @return booleano, true se o ponto está no segmento, false se não está*/
    public boolean isOnSegment(Ponto p1, Ponto p2) {
        double epsilon = 1e-10;
        return Math.abs(this.dist(p1) + this.dist(p2) - p1.dist(p2)) < epsilon;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
}

