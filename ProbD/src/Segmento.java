/**
 Lê os dados de entrada, verifica as constraints, processa os dados utilizando a funcionalidade
 das classes e escreve o resultado na consola
 @author Pedro Ramalho 68010
 @version 4.0 27/2/23
 @inv p1, p2    dois pontos que formam um segmento de reta
 @param p1 != p2
 */
public class Segmento {
    private final Ponto p1, p2;

    public Segmento(Ponto p1, Ponto p2) {
        this.p1 = p1;
        this.p2 = p2;
        if (p1.dist(p2) == 0) {
            System.out.println("Segmento:vi");
            System.exit(0);
        }
    }

    public Ponto getPonto1() {
        return p1;
    }

    public Ponto getPonto2() {
        return p2;
    }


    /**
     * Metodo que calcula o ponto de intersecao de duas retas e ve se ele esta contido em ambos os segmentos
     *
     * @return boolean, true se o ponto esta contido nas duas retas, false se nao estiven em pelo menos uma delas
     */
    public boolean intersects(Segmento other) {
        Ponto r1 = this.getPonto1();
        Ponto r2 = this.getPonto2();
        Ponto q1 = other.getPonto1();
        Ponto q2 = other.getPonto2();

        // calcular m e b das retas
        double slope1 = (r2.getX() - r1.getX()) == 0 ? Double.POSITIVE_INFINITY : (r2.getY() - r1.getY()) / (r2.getX() - r1.getX());
        double slope2 = (q2.getX() - q1.getX()) == 0 ? Double.POSITIVE_INFINITY : (q2.getY() - q1.getY()) / (q2.getX() - q1.getX());
        double b1 = r1.getY() - slope1 * r1.getX();
        double b2 = q1.getY() - slope2 * q1.getX();

        if (Double.isInfinite(slope1) && Double.isInfinite(slope2)) {
            return true;
        } else if (Double.isInfinite(slope1)) {
            // segmento do retanfulo vertical, calcular o x
            double x = r1.getX();
        } else if (Double.isInfinite(slope2)) {
            // segmento vertical, calcular o x
            double x = q1.getX();
            // declives iguais com ordenada na origem igual = retas coincidentes
        } else if(slope1 == slope2 && b1 == b2)
            return true;
            // declives iguais com ordenada na origem diferente = retas paralelas
        else if(slope1 == slope2)
            return false;
        else {
            // calculo normal de intercessao de retas
            double x = (b2 - b1) / (slope1 - slope2);
            double y = Double.isInfinite(slope1) ? slope2 * (x - q1.getX()) + q1.getY() : slope1 * (x - p1.getX()) + p1.getY();

            if (x < 0 || y < 0) {
                return false;
            }

            Ponto intersection = new Ponto(x, y);

            return intersection.isOnSegment(p1, p2) && intersection.isOnSegment(q1, q2);
        }

        return false;
    }

}


