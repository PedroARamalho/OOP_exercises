import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PontoTest {

    @Test
    void dist() {
       assertEquals(1, new Ponto(1,1).dist(new Ponto(2,1)));
    }

    @Test
    void getX() {
        assertEquals(1, new Ponto(1,3).getX());
    }

    @Test
    void getY() {
        assertEquals(2, new Ponto(1,2).getY());
    }

    /*
    @Test
    public void testConstructor0(){
        assertThrows(IllegalArgumentException.class,	()	->	{new Point(-1,0);});
    }

     */

}