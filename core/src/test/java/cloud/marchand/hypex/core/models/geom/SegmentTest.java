package cloud.marchand.hypex.core.models.geom;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SegmentTest {

    private static final double THRESHOLD = 0.000000000001;

    private Segment a;
    private Segment b;
    private Segment c;
    private Segment d;
    private Segment e;
    private Segment f;

    @Before
    public void setup() {
        a = new Segment(
            new Point(1, 1),
            new Point(1, 5)
        );
        b = new Segment(
            new Point(3, 5),
            new Point(3, 1)
        );
        c = new Segment(
            new Point(5, 2),
            new Point(2, 5)
        );
        d = new Segment(
            new Point(1, 6),
            new Point(6, 6)
        );
        e = new Segment(
            new Point(6, 8),
            new Point(1, 8)
        );
        f = new Segment(
            new Point(5, 5),
            new Point(2, 9)
        );
    }

    @Test
    public void intersectAB() {
        assertNull(a.getIntersectionPoint(b));
    }

    @Test
    public void intersectBC() {
        Point res = b.getIntersectionPoint(c);
        assertNotNull(res);
        assertTrue("x=" + res.x + " should be 3", 3d - res.x <= 0.000_001);
        assertTrue("y=" + res.y + " should be 4", 4d - res.y <= 0.000_001);
    }

    @Test
    public void intersectDE() {
        assertNull(d.getIntersectionPoint(e));
    }

    @Test
    public void intersectFE() {
        Point res = f.getIntersectionPoint(e);
        assertNotNull(res);
        assertTrue("x=" + res.x + " should be 2.75", 2.75d - res.x <= 0.000_001);
        assertTrue("y=" + res.y + " should be 8.00", 8.00d - res.y <= 0.000_001);
    }

    @Test
    public void intersectCF() {
        assertNull(c.getIntersectionPoint(f));
    }
    
    @Test
    public void getAngle() {
        assertTrue("Angle should be PI/2", Math.abs(a.getAngle() - (Math.PI / 2)) <= THRESHOLD);
        assertTrue("Angle should be -PI/2", Math.abs(b.getAngle() + (Math.PI / 2)) <= THRESHOLD);
        assertTrue("Angle should be 0", d.getAngle() <= THRESHOLD);
        assertTrue("Angle should be PI", Math.abs(e.getAngle() - Math.PI) <= THRESHOLD);
        Segment s = new Segment(new Point(0, 0), new Point(3, 3));
        assertTrue(Math.abs(s.getAngle() - (Math.PI / 4)) <= THRESHOLD);
    }

}
