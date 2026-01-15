/**
Verifica se os segmentos intersetam os obstaculos
 @author Pedro Ramalho 68010
 @version 4.0 27/2/23
 @inv traj, trajSize   array de segmentos que fazem parte da trajetoria e numero de segmentos que constituem a trajetoria
 @param qualquer ponto da trajetoria != qualquer outro ponto da trajetoria
 */
public class Trajetoria {
    private Segmento[] traj;
    private int trajSize;

    public Trajetoria(int size, Ponto[] p) {
        this.trajSize=size;
        this.traj=new Segmento[size];
        for(int i=0;i<size;i++){
            this.traj[i]=new Segmento(p[i],p[i+1]);
        }
        isTrajetoria(p);
    }

    public void isTrajetoria(Ponto[] p){
        for(int i = 0; i<trajSize-1; i++)
            for (int j = i+2; j<trajSize+1; j++)
            if (p[i].getX()==p[j].getX() &&
                    p[i].getY()==p[j].getY()) {
                System.out.println("Trajetoria:vi");
                System.exit(0);
            }
    }

    public int intersects(Retangulo[] r, int rSize){
        int[] countR =new int[rSize];
        int count=0;
        for(int i=0;i<this.trajSize;i++)
            for(int j=0;j<rSize;j++)
                if(this.traj[i].intersects(r[j].getS1()) || this.traj[i].intersects(r[j].getS2())
                || this.traj[i].intersects(r[j].getS3()) || this.traj[i].intersects(r[j].getS4()))
                    countR[j]++;
        for(int j=0;j<rSize;j++)
            if(countR[j]>0)
                count++;
        return count;
    }
}