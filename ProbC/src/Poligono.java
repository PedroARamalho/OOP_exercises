public class Poligono{
    private final Ponto[] points;
    private int r;
    public Poligono(int r) {
        points=new Ponto[r];
    }

    private int i = 0;
    public void add(Ponto p){
        points[i++]=p;
    }

    public double perimetro(){
        double result = 0;
        for(int i=1; i < points.length; i++)
            result += points[i-1].dist(points[i]);
        return result;
    }
}
