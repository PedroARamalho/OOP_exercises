public class Segmento {
    private final Ponto p1, p2;

    public Segmento(Ponto p1, Ponto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Ponto getPonto1() {
        return p1;
    }

    public Ponto getPonto2() {
        return p2;
    }
}
