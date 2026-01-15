import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    // Inicializar o scanner

        Ponto a = new Ponto(sc.nextDouble(), sc.nextDouble());  // Scan dos 2 primeiros doubles
        Ponto b = new Ponto(sc.nextDouble(), sc.nextDouble());  // Scan dos outros 2 doubles

        System.out.println((int) a.dist(b));    // Print da distancia dos dois pontos
        sc.close();
    }
}
