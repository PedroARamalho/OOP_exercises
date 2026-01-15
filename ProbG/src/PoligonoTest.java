import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PoligonoTest {

    @Test
    public void testIntersects_PoligonosInterceptam() {
        // Definir os polígonos
        Ponto[] vertices1 = { new Ponto(0, 0), new Ponto(3, 0), new Ponto(3, 3), new Ponto(0, 3) };
        Poligono poligono1 = new Poligono(vertices1);

        Ponto[] vertices2 = { new Ponto(2, 1), new Ponto(4, 1), new Ponto(4, 3), new Ponto(2, 3) };
        Poligono poligono2 = new Poligono(vertices2);

        // Testar a interseção entre os polígonos
        assertTrue(poligono1.intersects(poligono2));
    }
    @Test
    public void testIntersects_PoligonosInterceptam1() {
        // Definir os polígonos
        Ponto[] vertices1 = { new Ponto(5, 5), new Ponto(8, 5), new Ponto(8, 7), new Ponto(5, 7) };
        Poligono poligono1 = new Poligono(vertices1);

        Ponto[] vertices2 = { new Ponto(7, 1), new Ponto(9, 1), new Ponto(9, 3), new Ponto(7, 3) };
        Poligono poligono2 = new Poligono(vertices2);

        // Testar a interseção entre os polígonos
        assertFalse(poligono1.intersects(poligono2));
    }


    @Test
    public void testIntersects_PoligonosNaoInterceptam() {
        // Definir os polígonos
        Ponto[] vertices1 = { new Ponto(0, 0), new Ponto(3, 0), new Ponto(3, 3), new Ponto(0, 3) };
        Poligono poligono1 = new Poligono(vertices1);

        Ponto[] vertices2 = { new Ponto(4, 4), new Ponto(6, 4), new Ponto(6, 6), new Ponto(4, 6) };
        Poligono poligono2 = new Poligono(vertices2);

        // Testar a interseção entre os polígonos
        assertFalse(poligono1.intersects(poligono2));
    }
    @Test
    public void testIntersects_PoligonosNaoInterceptam1() {
        // Definir os polígonos
        Ponto[] vertices1 = { new Ponto(5, 5), new Ponto(8, 5), new Ponto(8, 7), new Ponto(5, 7) };
        Poligono poligono1 = new Poligono(vertices1);

        Ponto[] vertices2 = { new Ponto(7, 4), new Ponto(9, 4), new Ponto(9, 6), new Ponto(7, 6) };
        Poligono poligono2 = new Poligono(vertices2);

        // Testar a interseção entre os polígonos
        assertTrue(poligono1.intersects(poligono2));
    }
    @Test
    public void testIntersects_PoligonosComLinhasComuns() {
        // Definir os polígonos
        Ponto[] vertices1 = { new Ponto(0, 0), new Ponto(4, 0), new Ponto(4, 4), new Ponto(0, 4) };
        Poligono poligono1 = new Poligono(vertices1);

        Ponto[] vertices2 = { new Ponto(2, 2), new Ponto(6, 2), new Ponto(6, 6), new Ponto(2, 6) };
        Poligono poligono2 = new Poligono(vertices2);

        // Testar a interseção entre os polígonos
        assertTrue(poligono1.intersects(poligono2));
    }

    @Test
    public void testIntersects_PoligonosComPontosEmComum() {
        // Definir os polígonos
        Ponto[] vertices1 = { new Ponto(0, 0), new Ponto(4, 0), new Ponto(4, 4), new Ponto(0, 4) };
        Poligono poligono1 = new Poligono(vertices1);

        Ponto[] vertices2 = { new Ponto(2, 2), new Ponto(6, 2), new Ponto(6, 6), new Ponto(2, 6), new Ponto(0, 0) };
        Poligono poligono2 = new Poligono(vertices2);

        // Testar a interseção entre os polígonos
        assertTrue(poligono1.intersects(poligono2));
    }
}