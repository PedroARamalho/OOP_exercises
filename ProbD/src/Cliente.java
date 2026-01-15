/**
 Lê os dados de entrada, verifica as constraints, processa os dados utilizando a funcionalidade
 das classes e escreve o resultado na consola
 @author Pedro Ramalho 68010
 @version 4.0 27/2/23
 */
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ponto p1 = new Ponto(scanner.nextDouble(), scanner.nextDouble());
        Ponto p2 = new Ponto(scanner.nextDouble(), scanner.nextDouble());
        Ponto p3 = new Ponto(scanner.nextDouble(), scanner.nextDouble());
        Ponto p4 = new Ponto(scanner.nextDouble(), scanner.nextDouble());
        Ponto p5 = new Ponto(scanner.nextDouble(), scanner.nextDouble());
        Ponto p6 = new Ponto(scanner.nextDouble(), scanner.nextDouble());

        Retangulo rectangle = new Retangulo(p1, p2, p3, p4);

        Segmento segment = new Segmento(p5, p6);

        //Verifica se a reta interseta o retangulo
        if (rectangle.segmentoIntersetaRetangulo(segment)) {
            System.out.println("Fail");
        } else {
            System.out.println("OK");
        }
        scanner.close();
    }
}
