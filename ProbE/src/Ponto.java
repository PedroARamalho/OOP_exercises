/**
 Verifica se os pontos sao do 1 quadrante e faz a distancia entra pontos
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


    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
}

