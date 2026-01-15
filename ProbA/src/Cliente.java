import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Inicializar o scanner

        Ponto a = new Ponto(sc.nextDouble(), sc.nextDouble());  // Scanear os dois primeiros doubles que encontra
        Ponto b = new Ponto(sc.nextDouble(), sc.nextDouble());  // Scanear os outros dois doubles que faltam

        System.out.println((int) a.dist(b)); // Faz print da parte inteira da distancia dos dois pontos
        sc.close();
    }
}
