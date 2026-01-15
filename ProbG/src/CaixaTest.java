import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaixaTest {

    @Test
    public void testVerificarIntercepcao_CaixasInterceptam() {
        // Definir os polígonos para criar as caixas
        Ponto[] vertices1 = { new Ponto(5, 5), new Ponto(8, 5), new Ponto(8, 7), new Ponto(5, 7) };
        Poligono poligono1 = new Poligono(vertices1);

        Ponto[] vertices2 = { new Ponto(7, 1), new Ponto(9, 1), new Ponto(9, 3), new Ponto(7, 3) };
        Poligono poligono2 = new Poligono(vertices2);

        // Testar a interseção entre as caixas envolventes
        assertFalse(Caixa.verificarIntercepcao(poligono1, poligono2));
    }
    @Test
    public void testVerificarIntercepcao_CaixasInterceptam1() {
        // Definir os polígonos para criar as caixas
        Ponto[] vertices1 = { new Ponto(0, 0), new Ponto(5, 0), new Ponto(5, 5), new Ponto(0, 5) };
        Poligono poligono1 = new Poligono(vertices1);

        Ponto[] vertices2 = { new Ponto(4, 4), new Ponto(6, 4), new Ponto(6, 6), new Ponto(4, 6) };
        Poligono poligono2 = new Poligono(vertices2);

        // Testar a interseção entre as caixas envolventes
        assertTrue(Caixa.verificarIntercepcao(poligono1, poligono2));
    }

    @Test
    public void testVerificarIntercepcao_CaixasNaoInterceptam() {
        // Definir os polígonos para criar as caixas
        Ponto[] vertices1 = { new Ponto(5, 5), new Ponto(8, 5), new Ponto(8, 7), new Ponto(5, 7) };
        Poligono poligono1 = new Poligono(vertices1);

        Ponto[] vertices2 = { new Ponto(7, 4), new Ponto(9, 4), new Ponto(9, 6), new Ponto(7, 6) };
        Poligono poligono2 = new Poligono(vertices2);

        // Testar a interseção entre as caixas envolventes
        assertTrue(Caixa.verificarIntercepcao(poligono1, poligono2));
    }
    @Test
    public void testVerificarIntercepcao_CaixasNaoInterceptam1() {
        // Definir os polígonos para criar as caixas
        Ponto[] vertices1 = { new Ponto(0, 0), new Ponto(5, 0), new Ponto(5, 5), new Ponto(0, 5) };
        Poligono poligono1 = new Poligono(vertices1);

        Ponto[] vertices2 = { new Ponto(6, 6), new Ponto(8, 6), new Ponto(8, 8), new Ponto(6, 8) };
        Poligono poligono2 = new Poligono(vertices2);

        // Testar a interseção entre as caixas envolventes
        assertFalse(Caixa.verificarIntercepcao(poligono1, poligono2));
    }
    @Test
    public void testVerificarIntercepcao_CaixasSobrepostas() {
        // Definir os polígonos
        Ponto[] vertices1 = { new Ponto(0, 0), new Ponto(3, 0), new Ponto(3, 3), new Ponto(0, 3) };
        Poligono poligono1 = new Poligono(vertices1);

        Ponto[] vertices2 = { new Ponto(2, 1), new Ponto(5, 1), new Ponto(5, 4), new Ponto(2, 4) };
        Poligono poligono2 = new Poligono(vertices2);

        // Testar a interseção entre as caixas envolventes dos polígonos
        assertTrue(Caixa.verificarIntercepcao(poligono1, poligono2));
    }
}