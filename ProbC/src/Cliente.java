import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Poligono p = new Poligono(size);
        for(int i = 0; i < size; i++)
            p.add(new Ponto(sc.nextDouble(),sc.nextDouble()));
        sc.close();
        System.out.println(String.format("%.2f", p.perimetro())); //prints: 2.37
    }
}