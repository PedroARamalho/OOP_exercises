/**
 * A classe Ponto representa um ponto no espaço bidimensional e garante que este pertence sempre ao primeiro quadrante
 *
 * @author Pedro Ramalho
 * @version 2.0 - 28/02/2024
 * @inv Os pontos pertencem ao 1.º quadrante.
 */

public class Ponto {
    private double x, y;

    /**
     * Construtor para a classe Ponto. Garante que ambas as coordenadas são positivas.
     *
     * @param x Coordenada x do ponto (tipo double).
     * @param y Coordenada y do ponto (tipo double).
     */

    public Ponto(double x, double y){
        if (x >= 0 && y >= 0) {
            this.x = x;
            this.y = y;
        } else {
            System.out.println("Ponto:vi");
            System.exit(0);
        }
    }

    /**
     * Métodos de retorno de coordenadas deste ponto.
     *
     * @return A coordenada x (tipo double) deste ponto.
     */

    public double getX(){
        return this.x;
    }

    /**
     * @return A coordenada y (tipo double) deste ponto.
     */
    public double getY(){
        return this.y;
    }

    /**
     * Método para calcular a distância euclidiana entre este ponto e outro ponto.
     *
     * @param that O outro ponto (tipo Ponto) com o qual a distância será calculada.
     * @return A distância euclidiana (tipo double) entre o ponto desta instancia e o ponto 'that'.
     */

    public double dist (Ponto that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
