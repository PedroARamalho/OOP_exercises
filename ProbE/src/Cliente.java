/**
 Lê os dados de entrada, verifica as constraints, processa os dados utilizando a funcionalidade
 das classes e escreve o resultado na consola
 @author Pedro Ramalho 68010
 @version 4.0 27/2/23
 */
import java.util.Scanner;

import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int nPoints=sc.nextInt();
        Ponto[] points=new Ponto[nPoints];
        for(int i=0;i<nPoints;i++)
            points[i]=new Ponto(sc.nextDouble(),sc.nextDouble());

        int trajSize=nPoints-1;
        Trajetoria traj=new Trajetoria(trajSize,points);

        int obsSize=sc.nextInt();
        Retangulo[] obstacles=new Retangulo[obsSize];
        for(int i=0;i<obsSize;i++)
            obstacles[i]=new Retangulo(new Ponto(sc.nextDouble(),sc.nextDouble()),
                    new Ponto(sc.nextDouble(),sc.nextDouble()),
                    new Ponto(sc.nextDouble(),sc.nextDouble()),
                    new Ponto(sc.nextDouble(),sc.nextDouble()));
        sc.close();
        System.out.println(traj.intersects(obstacles,obsSize));
    }
}