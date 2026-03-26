import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Reta_segmentTest {
    @Test
    public void testIntersectingSegments() {
        SegmentoReta segment1 = new SegmentoReta(new Ponto(0, 0), new Ponto(3, 3));
        SegmentoReta segment2 = new SegmentoReta(new Ponto(0, 3), new Ponto(3, 0));

        assertTrue(segment1.doIntersect(segment2));
    }

    @Test
    public void testNonIntersectingParallelSegments() {
        SegmentoReta segment1 = new SegmentoReta(new Ponto(0, 0), new Ponto(2, 2));
        SegmentoReta segment2 = new SegmentoReta(new Ponto(0, 1), new Ponto(2, 3));

        assertFalse(segment1.doIntersect(segment2));
    }

    @Test
    public void testNonIntersectingCollinearSegments() {
        SegmentoReta segment1 = new SegmentoReta(new Ponto(0, 0), new Ponto(1, 1));
        SegmentoReta segment2 = new SegmentoReta(new Ponto(2, 2), new Ponto(3, 3));

        assertFalse(segment1.doIntersect(segment2));
    }

    @Test
    public void testSegmentsSharingOneEndpoint() {
        SegmentoReta segment1 = new SegmentoReta(new Ponto(0, 0), new Ponto(2, 2));
        SegmentoReta segment2 = new SegmentoReta(new Ponto(2, 2), new Ponto(3, 2));

        assertFalse(segment1.doIntersect(segment2));
    }

    @Test
    public void testSegmentsIntersectAtEndpointsOnly() {
        SegmentoReta segment1 = new SegmentoReta(new Ponto(0, 0), new Ponto(2, 2));
        SegmentoReta segment2 = new SegmentoReta(new Ponto(2, 2), new Ponto(4, 4));

        assertFalse(segment1.doIntersect(segment2));
    }
}