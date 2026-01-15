/**
 * A classe Reta representa uma reta definida por três pontos no espaço bidimensional.
 * Esta verifica se os três pontos formam ou não uma linha reta, garantindo que não são colineares.
 *
 * @author Pedro Ramalho
 * @version 2.0 - 28/02/2024
 * @inv Os pontos formam uma reta.
 */

public class Reta {
    private final Ponto[] reta=new Ponto[3];

    /**
     * Construtor para a classe Reta. Verifica se os três pontos fornecidos formam uma linha reta.
     *
     * @param p1 Primeiro ponto (tipo Ponto) da reta.
     * @param p2 Segundo ponto (tipo Ponto) da reta.
     */

    public Reta(Ponto p1, Ponto p2){
        if((Math.abs(p1.dist(p2)) < Math.pow(10,-9))){
            System.out.println("Reta:vi");
            System.exit(0);
        }
        this.reta[0]=p1;
        this.reta[1]=p2;
    }

    /**
     * Calcula o declive entre dois pontos.
     *
     * @param p1 Primeiro ponto (tipo Ponto) para o cálculo do declive.
     * @param p2 Segundo ponto (tipo Ponto) para o cálculo do declive.
     * @return O declive (tipo decimal) entre o ponto p1 e o ponto p2.
     */
    private double declive(Ponto p1, Ponto p2) {

        if(Math.abs(p1.getX()-p2.getX())<1e-9) {
            return Double.MAX_VALUE;
        }
        return (p2.getY()-p1.getY())/(p2.getX()-p1.getX());
    }

    /**
     * Verifica se os três pontos da reta são colineares.
     *
     * @return Verdadeiro se os pontos são colineares; falso, caso contrário (tipo booleano).
     * @param point
     */
    public boolean isCollinear(Ponto point) {
        double slope1=declive(reta[0], reta[1]);
        double slope2=declive(reta[0], point);
        return Math.abs(slope1-slope2)<1e-9;
    }
}

