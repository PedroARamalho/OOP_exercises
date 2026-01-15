/**
 Verifica se segmentos se intersetam
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
        double r1x=other.getPonto1().getX(), r1y=other.getPonto1().getY();
        double r2x=other.getPonto2().getX(), r2y=other.getPonto2().getY();
        double s1x=getPonto1().getX(), s1y=getPonto1().getY();
        double s2x=getPonto2().getX(), s2y=getPonto2().getY();

        //gets the slopes and accounts for vertical slopes
        double slopeR=(r2x-r1x)==0 ? Double.POSITIVE_INFINITY : (r2y-r1y)/(r2x-r1x);
        double slopeS=(s2x-s1x)==0 ? Double.POSITIVE_INFINITY : (s2y-s1y)/(s2x-s1x);

        //collinear and overlaping
        if(slopeR==slopeS && r1x==s1x && Math.max(r1y, r2y)>=Math.min(s1y, s2y)
                && Math.max(s1y, s2y)>=Math.min(r1y, r2y))
            return true;

        //not collinear and not parallel
        if(slopeR!=slopeS) {
            double xIntersection;
            double yIntersection;
            if(slopeR==Double.POSITIVE_INFINITY) {
                //r is vertical
                xIntersection=r1x;
                yIntersection=slopeS*(xIntersection-s1x) + s1y;
            } else if(slopeS==Double.POSITIVE_INFINITY) {
                //s is vertical
                xIntersection=s1x;
                yIntersection=slopeR*(xIntersection-r1x) + r1y;
            } else {
                //neither line is vertical
                double yInterceptR=r1y-(slopeR*r1x);
                double yInterceptS=s1y-(slopeS*s1x);
                xIntersection=(yInterceptS-yInterceptR)/(slopeR-slopeS);
                yIntersection=slopeR*xIntersection + yInterceptR;
            }

            return xIntersection>=Math.min(r1x, r2x) && xIntersection<=Math.max(r1x, r2x) &&
                    xIntersection>=Math.min(s1x, s2x) && xIntersection<=Math.max(s1x, s2x) &&
                    yIntersection>=Math.min(r1y, r2y) && yIntersection<=Math.max(r1y, r2y) &&
                    yIntersection>=Math.min(s1y, s2y) && yIntersection<=Math.max(s1y, s2y);
        }
        return false;
    }

}


