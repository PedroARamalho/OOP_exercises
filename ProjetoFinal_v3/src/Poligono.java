import java.util.*;

/**
 * A classe Poligono recebe uma lista de pontos e verifica as condicoes necessarias
 *
 * @author Pedro Ramalho
 * @version 2.0 - 04/04/2024
 * @inv Os pontos recebidos formam um polígono;
 * @inv São 3 ou mais pontos;
 * @inv Os pontos não são colineares;
 * @inv Os segmentos de reta formados pelos pontos não se interceptam.
 */
public class Poligono {

    public List<Ponto> pontos;

    /**
     * Construtor para a classe Poligono. Verifica se os pontos fornecidos formam um polígono válido.
     *
     * @param pontos Array de pontos (tipo Ponto) que formam o polígono.
     */
    public Poligono(String s) {

        List<Ponto> pontos = new ArrayList<>();
        String[] string_dados = s.split(" ");
        int i = 0;
        if(string_dados.length % 2 != 0){
            i = 1;
        }
        for(; i < string_dados.length; i += 2){
            int x = Integer.parseInt(string_dados[i]);
            int y = Integer.parseInt(string_dados[i+1]);
            pontos.add(new Ponto(x,y));
        }
        this.pontos = pontos;
        validatePolygon();
    }

    /**
     * Valida o polígono verificando se há pontos colineares consecutivos e se há arestas intersectantes.
     * Encerra o programa se condições inválidas forem encontradas.
     */
    private void validatePolygon() {
        if (hasCollinearConsecutivePoints() || hasIntersectingEdges()) {
            System.out.println("Poligono:vi");
            System.exit(0);
        }
    }

    /**
     * Verifica se existem três pontos consecutivos colineares.
     * @return true se houver três pontos consecutivos colineares, caso contrário false.
     */
    boolean hasCollinearConsecutivePoints() {
        for (int i = 0; i < pontos.size(); i++) {
            Ponto p1 = pontos.get(i);
            Ponto p2 = pontos.get((i + 1) % pontos.size());
            Ponto p3 = pontos.get((i + 2) % pontos.size());

            if (new Reta(p1, p2).areCollinear(p3)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se há arestas intersectantes dentro do polígono.
     * @return true se houver qualquer par de arestas que se intersectam, caso contrário false.
     */
    private boolean hasIntersectingEdges() {
        for (int i = 0; i < this.pontos.size(); i++) {
            for (int j = 0; j < this.pontos.size(); j++) {
                if (Math.abs(i - j) <= 1 || Math.abs(i - j) == this.pontos.size() - 1) continue;

                SegmentoReta s1 = new SegmentoReta(this.pontos.get(i), this.pontos.get((i + 1) % this.pontos.size()));
                SegmentoReta s2 = new SegmentoReta(this.pontos.get(j), this.pontos.get((j + 1) % this.pontos.size()));

                if (s1.doIntersect(s2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Obtém todas as arestas do polígono como segmentos.
     * @return Array de segmentos representando as arestas do polígono.
     */
    public SegmentoReta[] getPolygonSegments() {
        SegmentoReta[] segments = new SegmentoReta[pontos.size()];
        for (int i = 0; i < pontos.size(); i++)
            segments[i] = new SegmentoReta(pontos.get(i), pontos.get((i + 1) % pontos.size()));
        return segments;
    }

    /**
     * Verifica se este polígono é uma duplicata de outro polígono.
     * Dois polígonos são considerados duplicatas se tiverem o mesmo número de arestas e se cada aresta em um polígono for igual a uma aresta no outro polígono.
     *
     * @param outroPoligono O outro polígono a ser comparado com este polígono.
     * @return true se os polígonos forem duplicatas.
     */
    public boolean Duplicates(Poligono outroPoligono) {
        if (this.pontos.size() != outroPoligono.pontos.size())
            return false;

        SegmentoReta[] thisPointsSegments = this.getPolygonSegments();
        SegmentoReta[] outroPoligonoSegments = outroPoligono.getPolygonSegments();

        int result = 0;
        for (int i = 0; i < thisPointsSegments.length; i++){
            for (int j = 0; j < outroPoligonoSegments.length; j++){
                if (thisPointsSegments[i].equals(outroPoligonoSegments[j]))
                    result++;
            }
        }
        return result == thisPointsSegments.length;
    }

    /**
     * Retorna uma representação em string do polígono, listando seus vértices.
     * @return Uma string que representa o polígono.
     */
    @Override
    public String toString() {
        StringBuilder s_out = new StringBuilder();
        s_out.append("Poligono de ").append(pontos.size()).append(" vertices: [");
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

    /**
     * Calcula o centróide do polígono, que é o ponto médio geométrico de todos os vértices do polígono.
     * @return Ponto representando o centróide do polígono.
     */
    public Ponto centroide() {
        double Gx = 0;
        double Gy = 0;
        for (Ponto ponto : this.pontos) {
            Gx += ponto.getX();
            Gy += ponto.getY();
        }
        return new Ponto(Gx / this.pontos.size(), Gy / this.pontos.size());
    }

    /**
     * Roda o polígono em torno de um centróide especificado ou, se nenhum for fornecido,
     * em torno do centróide do polígono. A rotação é baseada em um ângulo fornecido.
     *
     * @param angulo O ângulo de rotação em graus. Positivo para rotação no sentido anti-horário,
     *               negativo para rotação no sentido horário.
     * @param centroideEspecifico O centróide específico em torno do qual o polígono deve ser rotacionado.
     *                            Se nulo, o centróide calculado do polígono será usado.
     */

    public Poligono rotate(double angulo, Ponto centroideEspecifico) {
        Ponto centroideUsado = centroideEspecifico != null ? centroideEspecifico : centroide();
        double angleRadians = Math.toRadians(angulo);

        List<Ponto> rotatedPoints = new ArrayList<>();
        for (Ponto p : pontos) {
            double x = p.getX() - centroideUsado.getX();
            double y = p.getY() - centroideUsado.getY();

            double newX = Math.round(x * Math.cos(angleRadians) - y * Math.sin(angleRadians) + centroideUsado.getX());
            double newY = Math.round(x * Math.sin(angleRadians) + y * Math.cos(angleRadians) + centroideUsado.getY());

            rotatedPoints.add(new Ponto(newX, newY));
        }
        if (pontos.size() == 3)
            return new Triangulo(pointsToString(rotatedPoints));
        else if (pontos.size() == 4 && pontos.get(0).dist(pontos.get(1)) == pontos.get(1).dist(pontos.get(2)))
            return new Quadrado(pointsToString(rotatedPoints));
        else if (pontos.size() == 4)
            return new Retangulo(pointsToString(rotatedPoints));
        else
            return new Poligono(pointsToString(rotatedPoints));
    }


    public void translate(double pontox, double pontoy){
        for(int i = 0; i < pontos.size(); i++){
            Ponto p = pontos.get(i);
            double x = p.getX() + pontox;
            double y = p.getY() + pontoy;

            pontos.set(i, new Ponto(x,y));
        }
    }

    /** Método auxiliar para converter a lista de pontos em formato de string
     *
     * @param pontos lista de pontos do novo poligono
     * @return list de pontos do novo poligono no formato string
     */
    private String pointsToString(List<Ponto> pontos) {
        StringBuilder sb = new StringBuilder();
        for (Ponto p : pontos) {
            sb.append((int) p.getX()).append(" ").append((int) p.getY()).append(" ");
        }
        return sb.toString().trim();
    }
    /**
     * Ajusta a posição de todos os pontos do polígono para que o centróide do polígono seja movido para um novo ponto especificado.
     * Isso é alcançado calculando a diferença entre o centróide atual do polígono e o novo centróide desejado. Essa diferença
     * é então aplicada a cada ponto do polígono, movendo efetivamente todo o polígono no plano, de modo que seu centróide
     * se alinhe com o novo ponto especificado.
     *
     * @param novoCentroide O novo ponto (Centroide) para o qual o centróide do polígono deve ser movido. Este ponto age como
     *                      o novo centro geométrico do polígono após a tradução.
     */
    public void ajustar_poligono_centroide(Ponto Centroide) {

        double difX = Centroide.getX() - centroide().getX();
        double difY = Centroide.getY() - centroide().getY();

        for(int i = 0; i < pontos.size(); i++){
            Ponto p = pontos.get(i);
            double newX = p.getX() + difX;
            double newY = p.getY() + difY;
            pontos.set(i, new Ponto(newX, newY));
        }
    }

}