import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PoligonoTest {

    @Test
    public void testSuccessfulPolygonCreation() {
        String validPoints = "0 0 1 0 1 1 0 1";
        Poligono poligono = new Poligono(validPoints);
        assertNotNull(poligono);
        assertEquals(4, poligono.pontos.size(), "Polygon should have exactly 4 points.");
    }

    @Test
    public void testDetectionOfCollinearPoints() {
        String collinearPoints = "0 0 1 1 2 2 3 3";
        Exception exception = assertThrows(Exception.class, () -> new Poligono(collinearPoints));
        assertTrue(exception.getMessage().contains("Poligono:vi"), "Expected failure due to collinear points.");
    }

    @Test
    public void testForNonIntersectingEdges() {
        String intersectingEdges = "0 0 2 2 2 0 0 2";
        Exception exception = assertThrows(Exception.class, () -> new Poligono(intersectingEdges));
        assertTrue(exception.getMessage().contains("Poligono:vi"), "Expected failure due to intersecting edges.");
    }

    @Test
    public void testCentroidOfSquare() {
        Poligono square = new Poligono("0 0 2 0 2 2 0 2");
        Ponto expectedCentroid = new Ponto(1, 1);

        Ponto calculatedCentroid = square.centroide();

        assertEquals(expectedCentroid.getX(), calculatedCentroid.getX(), 1e-9, "X coordinate");
        assertEquals(expectedCentroid.getY(), calculatedCentroid.getY(), 1e-9, "Y coordinate");
    }

    @Test
    public void testCentroidOfTriangle() {
        Poligono triangle = new Poligono("0 0 4 0 2 2");
        Ponto expectedCentroid = new Ponto(2, 0.666666667);

        Ponto calculatedCentroid = triangle.centroide();

        assertEquals(expectedCentroid.getX(), calculatedCentroid.getX(), 1e-9, "X coordinate");
        assertEquals(expectedCentroid.getY(), calculatedCentroid.getY(), 1e-9, "Y coordinate");
    }

    @Test
    public void testRotateNonagon() {
        Poligono nonagon = new Poligono("1 1 3 2 5 1 6 3 5 5 3 6 1 5 0 3 1 3");
        double angulo = 90;
        Ponto Centroide = null;
        Ponto originalCentroid = nonagon.centroide();
        nonagon.rotate(angulo, Centroide);
        Ponto newCentroid = nonagon.centroide();

        assertEquals(originalCentroid, newCentroid, "Centroid should remain unchanged after rotation");
    }

    @Test
    public void testCentroide() {
        Poligono retangulo = new Poligono("0 0 4 0 4 2 0 2");
        Ponto expectedCentroide = new Ponto(2, 1);
        Ponto calculatedCentroide = retangulo.centroide();
        assertEquals(expectedCentroide.getX(), calculatedCentroide.getX(), "O X do centroide calculado não é como esperado.");
        assertEquals(expectedCentroide.getY(), calculatedCentroide.getY(), "O Y do centroide calculado não é como esperado.");
    }

    @Test
    public void testRotate180DegreesSquare() {
        Poligono quadrado = new Poligono("0 0 2 0 2 2 0 2");
        quadrado.rotate(180, null);

        Ponto expectedPoint1 = new Ponto(2, 2);
        Ponto expectedPoint2 = new Ponto(0, 2);
        Ponto expectedPoint3 = new Ponto(0, 0);
        Ponto expectedPoint4 = new Ponto(2, 0);

        assertEquals(expectedPoint1.getX(), quadrado.pontos.get(0).getX());
        assertEquals(expectedPoint1.getY(), quadrado.pontos.get(0).getY());
        assertEquals(expectedPoint2.getX(), quadrado.pontos.get(1).getX());
        assertEquals(expectedPoint2.getY(), quadrado.pontos.get(1).getY());
        assertEquals(expectedPoint3.getX(), quadrado.pontos.get(2).getX());
        assertEquals(expectedPoint3.getY(), quadrado.pontos.get(2).getY());
        assertEquals(expectedPoint4.getX(), quadrado.pontos.get(3).getX());
        assertEquals(expectedPoint4.getY(), quadrado.pontos.get(3).getY());
    }

    @Test
    public void testRotate360DegreesTriangleWithCustomCentroid() {
        Poligono triangulo = new Poligono("0 4 2 4 1 6");
        Ponto centroideEspecifico = new Ponto(1, 5);
        triangulo.rotate(360, centroideEspecifico);

        Ponto expectedPoint1 = new Ponto(0, 4);
        Ponto expectedPoint2 = new Ponto(2, 4);
        Ponto expectedPoint3 = new Ponto(1, 6);

        assertEquals(expectedPoint1.getX(), triangulo.pontos.get(0).getX(), "X do ponto 1 não corresponde ao esperado.");
        assertEquals(expectedPoint1.getY(), triangulo.pontos.get(0).getY(), "Y do ponto 1 não corresponde ao esperado.");
        assertEquals(expectedPoint2.getX(), triangulo.pontos.get(1).getX(), "X do ponto 2 não corresponde ao esperado.");
        assertEquals(expectedPoint2.getY(), triangulo.pontos.get(1).getY(), "Y do ponto 2 não corresponde ao esperado.");
        assertEquals(expectedPoint3.getX(), triangulo.pontos.get(2).getX(), "X do ponto 3 não corresponde ao esperado.");
        assertEquals(expectedPoint3.getY(), triangulo.pontos.get(2).getY(), "Y do ponto 3 não corresponde ao esperado.");
    }

    @Test
    public void testTranslacaoTriangulo() {
        Poligono triangulo = new Poligono("0 0 2 0 1 2");
        triangulo.translate(3, 4);

        assertEquals(new Ponto(3, 4), triangulo.pontos.get(0), "A translação do ponto 1 não é como esperado.");
        assertEquals(new Ponto(5, 4), triangulo.pontos.get(1), "A translação do ponto 2 não é como esperado.");
        assertEquals(new Ponto(4, 6), triangulo.pontos.get(2), "A translação do ponto 3 não é como esperado.");
    }

    @Test
    public void testTranslacaoZeroPentagono() {
        Poligono pentagono = new Poligono("1 1 3 1 4 3 2 5 1 3");
        pentagono.translate(0, 0);

        assertEquals(new Ponto(1, 1), pentagono.pontos.get(0), "A posição do ponto após a translação é inesperada.");
        assertEquals(new Ponto(3, 1), pentagono.pontos.get(1), "A posição do ponto após a translação é inesperada.");
        assertEquals(new Ponto(4, 3), pentagono.pontos.get(2), "A posição do ponto após a translação é inesperada.");
        assertEquals(new Ponto(2, 5), pentagono.pontos.get(3), "A posição do ponto após a translação é inesperada.");
        assertEquals(new Ponto(1, 3), pentagono.pontos.get(4), "A posição do ponto após a translação é inesperada.");
    }

    @Test
    public void testAjustarCentroideQuadrado() {
        Poligono quadrado = new Poligono("1 1 3 1 3 3 1 3");
        Ponto novoCentroide = new Ponto(5, 5);
        quadrado.ajustar_poligono_centroide(novoCentroide);

        Ponto centroideAjustado = quadrado.centroide();
        assertTrue(Math.abs(novoCentroide.getX() - centroideAjustado.getX()) < 1e-9 && Math.abs(novoCentroide.getY() - centroideAjustado.getY()) < 1e-9,
                "O centroide ajustado não corresponde ao esperado.");
    }

    @Test
    public void testAjustarCentroideTriangulo() {
        Poligono triangulo = new Poligono("0 0 2 0 1 2");
        Ponto novoCentroide = new Ponto(4, 4);
        triangulo.ajustar_poligono_centroide(novoCentroide);

        Ponto centroideAjustado = triangulo.centroide();
        assertTrue(Math.abs(novoCentroide.getX() - centroideAjustado.getX()) < 1e-9 && Math.abs(novoCentroide.getY() - centroideAjustado.getY()) < 1e-9,
                "O centroide ajustado não corresponde ao esperado.");
    }

}
