/**
 *
 * A classe Retangulo estende Poligono para representar um retângulo.
 * @author Pedro Ramalho
 * @version 1.0 - 05/04/2024
 */

public class Retangulo extends Poligono {

    public Retangulo(String s) {
        super(s);
        if (!isRetangulo()) {
            //throw new IllegalArgumentException("Retangulo:vi");
            System.out.println("Retangulo:vi");
            System.exit(0);
        }
    }
    /**
     * Valida se o polígono construído satisfaz as propriedades de um retângulo.
     * Este método verifica:
     * - A presença exata de quatro pontos.
     * - Igualdade de comprimento das diagonais.
     * - Igualdade de comprimento dos lados opostos.
     *
     * @return true se o polígono for um retângulo válido.
     */

    private boolean isRetangulo() {
        if (this.pontos.size() != 4) {
            return false;
        }

        double diagonal_1 = pontos.get(0).dist(pontos.get(2));
        double diagonal_2 = pontos.get(1).dist(pontos.get(3));
        double dist_AB = pontos.get(0).dist(pontos.get(1));
        double dist_BC = pontos.get(1).dist(pontos.get(2));
        double dist_CD = pontos.get(2).dist(pontos.get(3));
        double dist_DA = pontos.get(3).dist(pontos.get(0));

        boolean diagonais_iguais = diagonal_1 == diagonal_2;
        boolean lados_iguais = dist_AB == dist_CD && dist_BC == dist_DA;

        return diagonais_iguais && lados_iguais;
    }

    /**
     * Retorna uma representação em string do polígono, listando seus vértices.
     * @return Uma string que representa o retângulo.
     */
    @Override
    public String toString() {
        StringBuilder s_out = new StringBuilder();
        s_out.append("Retangulo: [");
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
