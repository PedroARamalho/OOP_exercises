import java.util.Objects;

/**
 * A classe SegmentoReta representa um segmento de reta definido por dois pontos distintos no espaço bidimensional.
 * Esta verifica se os dois pontos fornecidos são diferentes, garantindo assim que formam um segmento de reta válido.
 *
 * @author Pedro Ramalho
 * @version 1.0 - 29/02/2024
 * @inv Os pontos recebidos formam um segmento de reta, ou seja, não existem ter 2 pontos iguais.
 */

public class SegmentoReta{

    private final Ponto p1;
    private final Ponto p2;

    /**
     * Construtor para a classe SegmentoReta. Verifica se os dois pontos fornecidos formam um segmento de reta válido.
     *
     * @param p1 Primeiro ponto (tipo Ponto) do segmento de reta.
     * @param p2 Segundo ponto (tipo Ponto) do segmento de reta.
     */
    public SegmentoReta(Ponto p1, Ponto p2) {
        if (Math.abs(p1.dist(p2)) < Math.pow(10,-9)) {
            System.out.println("Segmento:vi");
            System.exit(0);
        }
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Verifica se dois pontos formam um segmento de reta válido.
     *
     * @param p1 Primeiro ponto (tipo Ponto) a ser verificado.
     * @param p2 Segundo ponto (tipo Ponto) a ser verificado.
     */
    private boolean onSegment(Ponto p1, Ponto p2, Ponto p3) {
        return new Reta(p1,p3).areCollinear(p2);
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
     * Verifica se dois segmentos de reta se intersectam.
     *
     * @param other O outro segmento de reta (tipo SegmentoReta) a ser verificado.
     * @return Verdadeiro se os dois segmentos de reta se intersectam; falso, caso contrário (tipo booleano).
     */
    public boolean doIntersect(SegmentoReta other) {
        Ponto p3 = other.p1;
        Ponto p4 = other.p2;

        // Check if any of the other segment's endpoints lie on this segment and vice versa.
        if (onSegment(this.p1, p3, this.p2) && !onSegment(this.p1, p4, this.p2)) return false;
        if (onSegment(this.p1, p4, this.p2) && !onSegment(this.p1, p3, this.p2)) return false;
        if (onSegment(p3, this.p1, p4) && !onSegment(p3, this.p2, p4)) return false;
        if (onSegment(p3, this.p2, p4) && !onSegment(p3, this.p1, p4)) return false;

        // Compute orientations needed for general and special cases
        int dir1=direction(this.p1, this.p2, p3);
        int dir2=direction(this.p1, this.p2, p4);
        int dir3=direction(p3, p4, this.p1);
        int dir4=direction(p3, p4, this.p2);

        // General case: segments intersect if they are diagonally opposite.
        return dir1!=dir2 && dir3!=dir4;
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SegmentoReta segmento = (SegmentoReta) o;
        return segmento.p1.equals(p2) && segmento.p2.equals(p1);
    }
}