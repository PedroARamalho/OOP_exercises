/**
 * A classe Poligono representa um polígono definido por um conjunto de pontos no espaço bidimensional.
 * Esta verifica se os pontos fornecidos formam um polígono válido, garantindo que são três ou mais pontos,
 * que não são colineares e que os segmentos de reta formados pelos pontos não se interceptam.
 *
 * @author Pedro Ramalho
 * @version 2.0 - 29/02/2024
 * @inv Os pontos recebidos formam um polígono;
 * @inv São 3 ou mais pontos;
 * @inv Os pontos não são colineares;
 * @inv Os segmentos de reta formados pelos pontos não se interceptam.
 */

public class Poligono{
    private final int vertexes;
    private final Ponto[] points;
    private double perTotal;

    /**
     * Construtor para a classe Poligono. Verifica se os pontos fornecidos formam um polígono válido.
     *
     * @param pontos Array de pontos (tipo Ponto) que formam o polígono.
     */

    public Poligono(Ponto[] pontos) {
        this.vertexes=pontos.length;
        this.points=new Ponto[vertexes];
        System.arraycopy(pontos, 0, this.points, 0, vertexes);


    }




    /**
     * Calcula o perímetro do polígono.
     */
    public void perimetro() {
        for(int i=0;i<this.vertexes-1;i++)
            perTotal+=Math.abs(points[i].dist(points[i+1]));
        perTotal+=Math.abs(points[this.vertexes-1].dist(points[0]));
        System.out.println((int)perTotal);
    }

    /**
     * Verifica se o poligono tem, pelo menos, 3 pontos e se os pontos formam um poligono.
     */
    public void isPoligono(){
        if(this.vertexes<3) {
            System.out.println("Poligono:vi");
            System.exit(0);
        }
        // Check collinearity for all adjacent triplets including the wrap-around cases
        for(int i=0;i<this.vertexes;i++) {
            Reta r=new Reta(points[i], points[(i+1)%this.vertexes]);
            if (r.isCollinear(points[(i + 2) % this.vertexes])) {
                System.out.println("Poligono:vi");
                System.exit(0);
            }
        }

        for (int i=0;i<this.vertexes;i++) {
            for (int j=0;j<this.vertexes;j++) {
                // Skip adjacent segments and the segment itself
                if (Math.abs(i-j)<=1 || Math.abs(i-j)==this.vertexes-1) continue;

                SegmentoReta s1=new SegmentoReta(points[i], points[(i+1)%this.vertexes]);
                SegmentoReta s2=new SegmentoReta(points[j], points[(j+1)%this.vertexes]);

                if(s1.intersects(s2)) {
                    System.out.println("Poligono:vi");
                    System.exit(0);
                }
            }
        }
    }
}
