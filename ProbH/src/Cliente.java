import java.util.Scanner;
import java.util.*;

    public class Cliente {
        public static void main(String[] args) {
            Random generator = new Random(0);
            Scanner scanner = new Scanner(System.in);

            int nTrajetorias=scanner.nextInt();
            Trajetoria[] trajetorias = new Trajetoria[nTrajetorias];


        for (int i = 0; i < nTrajetorias; i++) {
            int nPontos = scanner.nextInt();
            Ponto[] points=new Ponto[nPontos];
            for(int j=0;j<nPontos;j++) {
                points[j] = new Ponto(generator.nextInt(100), generator.nextInt(100));
                if(points[j].isRepetido(points,j))
                    j--;
            }
            trajetorias[i] =new Trajetoria(nPontos,points);
        }
        scanner.close();
        for (int i = 0; i < nTrajetorias; i++) {
            System.out.println(trajetorias[i]);
        }
        }
    }

