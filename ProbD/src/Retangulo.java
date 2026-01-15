/**
 Lê os dados de entrada, verifica as constraints, processa os dados utilizando a funcionalidade
 das classes e escreve o resultado na consola
 @author Pedro Ramalho 68010
 @version 4.0 27/2/23
 @inv s1, s2, s3, s4    Os quatro segmentos que definem o retangulo
 @param s1 != s2 != s3 != s4
 */
public class Retangulo {
    private Ponto p1, p2, p3, p4;

    public Retangulo(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        if (!isRetangulo(1e-6) || p1.dist(p2) == 0 ||
                p2.dist(p3) == 0 ||
                p3.dist(p4) == 0 ||
                p4.dist(p1) == 0) {
            System.out.println("Retangulo:vi");
            System.exit(0);
        }
    }


    /**Metodo que verifica intersecoes do retangulo com o segmento dado
     @return boolean, true se algum dos casos intersetar um dos segmentos do retangulo,
     false se nenhum dos segmentos do retangulo for intersetado
     */
    public boolean segmentoIntersetaRetangulo(Segmento s) {
        Segmento s1 = new Segmento(p1, p2);
        Segmento s2 = new Segmento(p2, p3);
        Segmento s3 = new Segmento(p3, p4);
        Segmento s4 = new Segmento(p4, p1);
        // Verifica se algum dos segmentos do retangulo inteseta o segmento dado
        return s1.intersects(s) || s2.intersects(s) || s3.intersects(s) || s4.intersects(s);
    }
    /**Metodo que verifica se a distancia do ponto medio do retangulo a cada verice e igual
     @return boolean, true se as distancias do ponto medio forem iguais, false se forem diferentes
     */
    //
    public boolean isRetangulo(double epsilon) {
        // Calcula ponto medio do retangulo
        double x = (p1.getX() + p3.getX()) / 2.0;
        double y = (p1.getY() + p3.getY()) / 2.0;
        Ponto midpoint = new Ponto(x, y);

        // Calcula a distancia do ponto media a cada verice do retangulo
        double d1 = p1.dist(midpoint);
        double d2 = p2.dist(midpoint);
        double d3 = p3.dist(midpoint);
        double d4 = p4.dist(midpoint);

        // Verifica se todas as distancias sao iguais
        return Math.abs(d1 - d2) < epsilon
                && Math.abs(d1 - d3) < epsilon
                && Math.abs(d1 - d4) < epsilon;

    }
}
