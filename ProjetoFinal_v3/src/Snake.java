import java.util.ArrayList;
import java.util.List;

public class Snake extends Quadrado {
    private List<Quadrado> body;
    private int headSize; // Adicionando um campo para armazenar o tamanho da cabeça
    private int snakeSize;

    public Snake(int headSize, int arenaWidth, int arenaHeight) {
        super(initSnake(headSize));
        this.headSize = headSize; // Atribuindo o tamanho da cabeça ao campo headSize
        body = new ArrayList<>();
        body.add(this); // Adiciona a cabeça da cobra ao corpo
    }

    public void move(int directionX, int directionY) {
        // Atualiza a posição de cada segmento do corpo da cobra
        for (int i = body.size() - 1; i > 0; i--) {
            Quadrado currentSegment = body.get(i);
            Quadrado previousSegment = body.get(i - 1);
            currentSegment.setPosition(previousSegment.getX(), previousSegment.getY());
        }
        // Move a cabeça da cobra para a nova posição
        setPosition(getX() + directionX, getY() + directionY);
    }

    public void grow() {
        Quadrado newSegment = new Quadrado(initSnake(headSize));; // Inicializar o novo segmento com o tamanho da cabeça
        newSegment.setPosition(body.get(snakeSize).getX(), body.get(snakeSize).getY());
        snakeSize++;
        body.add(newSegment);
    }
/*
    public  String growSnake(int headSize){
        return body.get(0).getX() 0 0 " + headSize + " " + headSize + " " + headSize + " " + headSize + " 0";
    }
*/

    public static String initSnake(int headSize){
        return "0 0 0 " + headSize + " " + headSize + " " + headSize + " " + headSize + " 0";
    }

    public List<Quadrado> getBody() {
        return body;
    }

    public int getSize() {
        return snakeSize;
    }

    public int getHeadSize() {
        return this.headSize;
    }
}