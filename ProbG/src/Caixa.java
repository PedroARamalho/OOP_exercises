/**
 * A classe Caixa representa uma caixa definida por um conjunto de pontos no espaço bidimensional.
 * Esta caixa sao os limites exteriores do conjunto de pontos que e introduzido em cada poligono.
 * A verificacao da colisao das caixas e feita aqui, e mesmo antes de serem criados quaisquer poligonos
 *
 * @author Pedro Ramalho
 * @version 2.0 - 15/03/2024
 */

public class Caixa {
    private double xMin, yMin, xMax, yMax;

    /**
     * Construtor para a classe Caixa. Aumenta conforme os pontos que sao dados.
     *
     * @param p Array de pontos (tipo Ponto) que eventualmente poderao formar o polígono.
     */
    public Caixa(Ponto[] p){
        this.xMin=Double.MAX_VALUE;
        this.yMin=Double.MAX_VALUE;
        this.xMax=Double.MIN_VALUE;
        this.yMax=Double.MIN_VALUE;
        for(Ponto ponto : p){
            if(ponto.getX()<xMin) xMin=ponto.getX();
            if(ponto.getY()<yMin) yMin=ponto.getY();
            if(ponto.getX()>xMax) xMax=ponto.getX();
            if(ponto.getY()>yMax) yMax=ponto.getY();
        }
    }

    /**
     * Verifica se as caixas se intersetam.
     *
     * @return Verdadeiro se as caixas se intersetam; falso, caso contrário (tipo booleano).
     */
    public boolean intersects(Caixa other) {
        return !(other.xMax <= this.xMin || other.xMin >= this.xMax || other.yMax <= this.yMin || other.yMin >= this.yMax);
    }
}