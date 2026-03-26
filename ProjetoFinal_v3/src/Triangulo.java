/**
 * A classe Triangulo estende Poligono para representar um triângulo.
 * @author Pedro Ramalho
 * @version 1.0 - 05/04/2024
 */

public class Triangulo extends Poligono{

    public Triangulo(String s){
        super(s);
        if (this.pontos.size() != 3 || hasCollinearConsecutivePoints()) {
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
    }

    /**
     * Retorna uma representação em string do polígono, listando seus vértices.
     * @return Uma string que representa o triângulo.
     */
    @Override
    public String toString() {
        StringBuilder s_out = new StringBuilder();
        s_out.append("Triangulo: [");
        for (int i = 0; i < pontos.size(); i++) {
            int x = (int) pontos.get(i).getX();
            int y = (int) pontos.get(i).getY();
            s_out.append("(").append(x).append(",").append(y).append(")");
            if (i < pontos.size() - 1) {
                s_out.append(", ");
            }
        }
        s_out.append("]");
        return s_out.toString();
    }
}
