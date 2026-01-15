public class Trajetoria {
    private Segmento[] traj;
    private int trajSize;

    public Trajetoria(int size, Ponto[] p) {
        this.trajSize = size;
        this.traj = new Segmento[size];
        for (int i = 0; i < size; i++) {
            this.traj[i] = new Segmento(p[i], p[i + 1]);
            System.out.println(traj[i]);
        }
    }
}
