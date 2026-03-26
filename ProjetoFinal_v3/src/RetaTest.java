import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RetaTest {

    @Test
    public void testPointsAreCollinear() {
        Ponto p1 = new Ponto(1, 1);
        Ponto p2 = new Ponto(2, 2);
        Ponto p3 = new Ponto(3, 3);

        Reta reta = new Reta(p1, p2);
        assertTrue(reta.areCollinear(p3));
    }

    @Test
    public void testPointsAreNotCollinear() {
        Ponto p1 = new Ponto(1, 1);
        Ponto p2 = new Ponto(2, 2);
        Ponto p3 = new Ponto(3, 4);

        Reta reta = new Reta(p1, p2);
        assertFalse(reta.areCollinear(p3));
    }

    /*
    @Test
    public void testConstructor1(){
        assertThrows(IllegalArgumentException.class,	()	->	{new Straight(new Point(0,0),new Point(0,0));});
    }
     */
}