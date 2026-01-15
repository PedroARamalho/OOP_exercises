import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        Ponto[] pontos1=new Ponto[size1];
        for(int i = 0;i < size1;i++)
            pontos1[i]=new Ponto(sc.nextInt(),sc.nextInt());
        int size2 = sc.nextInt();
        Ponto[] pontos2=new Ponto[size2];
        for(int i = 0;i < size2;i++)
            pontos2[i]=new Ponto(sc.nextInt(),sc.nextInt());
        sc.close();
        Caixa caixa1 = new Caixa(pontos1);
        Caixa caixa2 = new Caixa(pontos2);
        if (!caixa1.intersects(caixa2)) {
            System.out.println(caixa1.intersects(caixa2));
            System.exit(0);
        }
        else {
            Poligono poligono1 = new Poligono(pontos1);
            poligono1.isPoligono();
            Poligono poligono2 = new Poligono(pontos2);
            poligono2.isPoligono();
            System.out.println(caixa1.intersects(caixa2));

        }
    }
}