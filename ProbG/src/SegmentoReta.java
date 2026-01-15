/**
 * A classe SegmentoReta representa um segmento de reta definido por dois pontos distintos no espaço bidimensional.
 * Esta verifica se os dois pontos fornecidos são diferentes, garantindo assim que formam um segmento de reta válido.
 *
 * @author Pedro Ramalho
 * @version 1.0 - 29/02/2024
 * @inv Os pontos recebidos formam um segmento de reta, ou seja, não existem ter 2 pontos iguais.
 */

public class SegmentoReta {
    private final Ponto p1, p2;

    /**
     * Construtor para a classe SegmentoReta. Verifica se os dois pontos fornecidos formam um segmento de reta válido.
     *
     * @param p1 Primeiro ponto (tipo Ponto) do segmento de reta.
     * @param p2 Segundo ponto (tipo Ponto) do segmento de reta.
     */

    public SegmentoReta(Ponto p1, Ponto p2) {
        isSegmento(p1, p2);
        this.p1=p1;
        this.p2=p2;
    }

    /**
     * Verifica se dois pontos formam um segmento de reta válido.
     *
     * @param p1 Primeiro ponto (tipo Ponto) a ser verificado.
     * @param p2 Segundo ponto (tipo Ponto) a ser verificado.
     */

    public void isSegmento(Ponto p1, Ponto p2){
        if(Math.abs(p1.dist(p2)) < Math.pow(10,-9)){
            System.out.println("Segmento:vi");
            System.exit(0);
        }
    }

    /**
     * Verifica se dois segmentos de reta se intersectam.
     *
     * @param other O outro segmento de reta (tipo SegmentoReta) a ser verificado.
     * @return Verdadeiro se os dois segmentos de reta se intersectam; falso, caso contrário (tipo booleano).
     */

    public boolean intersects(SegmentoReta other) {
        Ponto p3=other.getP1();
        Ponto p4=other.getP2();

        // If one edge of one segment touches any part of the other and the other edge doesnt touch,
        // automatically it is assumed that it is either collinear or overlaping
        if (onSegment(this.p1, p3, this.p2) && !onSegment(this.p1, p4, this.p2)) return false;
        if (onSegment(this.p1, p4, this.p2) && !onSegment(this.p1, p3, this.p2)) return false;
        if (onSegment(p3, this.p1, p4) && !onSegment(p3, this.p2, p4)) return false;
        if (onSegment(p3, this.p2, p4) && !onSegment(p3, this.p1, p4)) return false;

        // Calculate direction of each triplet points
        int dir1=direction(this.p1, this.p2, p3);
        int dir2=direction(this.p1, this.p2, p4);
        int dir3=direction(p3, p4, this.p1);
        int dir4=direction(p3, p4, this.p2);

        // Check if the segments intersect
        return dir1!=dir2 && dir3!=dir4;
    }

    /**
     * Calcula a direção da curva formada por três pontos.
     *
     * @param a Primeiro ponto (tipo Ponto) na curva.
     * @param b Segundo ponto (tipo Ponto) na curva.
     * @param c Terceiro ponto (tipo Ponto)na curva.
     *
     * @return Um inteiro que representa a direção da curva formada pelos três pontos:
     *          0 para colinear, 1 para horário e 2 para anti-horário.
     */

    private int direction(Ponto a, Ponto b, Ponto c) {
        double val=(b.getY()-a.getY())*(c.getX()-b.getX())-(b.getX()-a.getX())*(c.getY()-b.getY());
        if(val==0) return 0;
        return (val>0) ? 1:2;
    }

    /**
     * Verifica se um ponto está no segmento de reta formado por outros dois pontos.
     *
     * @param p Primeiro ponto (tipo Ponto) do segmento de reta.
     * @param q Ponto a ser verificado (tipo Ponto).
     * @param r Segundo ponto (tipo Ponto) do segmento de reta.
     * @return Verdadeiro se o ponto q estiver no segmento de reta formado
     *          pelos pontos p e r; falso, caso contrário (tipo booleano).
     */
    private boolean onSegment(Ponto p, Ponto q, Ponto r) {
        return new Reta(p, q).isCollinear(r);
    }

    /**
     * Metodos de retorno de pontos do segmento de reta.
     *
     * @return O primeiro ponto (tipo Ponto) do segmento de reta.
     */
    public Ponto getP1() {
        return p1;
    }

    /**
     * @return O segundo ponto (tipo Ponto) do segmento de reta.
     */
    public Ponto getP2() {
        return p2;
    }
}
