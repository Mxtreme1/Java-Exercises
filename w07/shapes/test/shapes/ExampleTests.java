package shapes;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;
import sun.applet.Main;
import sun.security.provider.SHA;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ExampleTests {

    @Test (expected = IllegalArgumentException.class)
    public void makeShapeInvalidDimension1() {
        Shapes.makeEllipse(new V2(0, 0), new V2(0, 1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void makeShapeInvalidDimension2() {
        Shapes.makeEllipse(new V2(0, 0), new V2(1, 0));
    }

    @Test (expected = IllegalArgumentException.class)
    public void makeShapeInvalidDimension3() {
        Shapes.makeRectangle(new V2(0, 0), new V2(0, 1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void makeShapeInvalidDimension4() {
        Shapes.makeRectangle(new V2(0, 0), new V2(1, 0));
    }


    @Test
    public void dimensions() {
        Shape r = Shapes.makeRectangle(new V2(0.0, 0.0), new V2(1.0, 1.0));
        Shape e = Shapes.makeEllipse(new V2(0.5, 1.5), new V2(1.0, 2.0));
        Shape p = Shapes.makePicture(Arrays.asList(e, r));
        assertEquals(new V2(2.0, 4.5), p.boundingBox().getDimensions());
    }

    @org.junit.Test
    public void testEllipse() throws Exception {
        Shape e = Shapes.makeEllipse(new V2(0, 0), new V2(1, 2));
        V2 p1 = new V2(0.5, 1);
        V2 p2 = new V2(1,1);
        assertTrue(e.contains(p1));
        assertFalse(e.contains(p2));

        assertFalse(e.move(new V2(-2, 0))
                     .contains(p1));
    }

    @org.junit.Test
    public void testPicture() throws Exception {
        Shape e = Shapes.makeEllipse(new V2(0, 0), new V2(2, 1));
        Shape r = Shapes.makeRectangle(new V2(0,2), new V2(1, 2));
        V2 p1 = new V2(0.5, 1);
        V2 p2 = new V2(1,1);

        Shape pict = Shapes.makePicture(Arrays.asList(e, r));
        assertTrue(r.contains(p2));
        assertTrue(pict.contains(p1));
        assertTrue(pict.contains(p2));
        assertFalse(pict.contains(new V2(2, 0.5)));
        pict.move(new V2(1, 0));
        assertTrue(pict.contains(new V2(1.5, 1)));


    }

    @Test
    public void testRectangleMethods() {
        Shape r = Shapes.makeRectangle(new V2(0, 1), new V2(1, 1));
        assertTrue(r.contains(new V2(1, 0)));
        assertFalse(r.contains(new V2(2, 2)));
        assertEquals(new Box(new V2(0, 1), new V2(1, 1)).getDimensions().getX(), r.boundingBox().getDimensions().getX(), 0.001);
        assertEquals(new Box(new V2(0, 1), new V2(1, 1)).getDimensions().getY(), r.boundingBox().getDimensions().getY(), 0.001);
        assertEquals(new Box(new V2(0, 1), new V2(1, 1)).getUpperLeftCorner().getX(), r.boundingBox().getUpperLeftCorner().getX(), 0.001);
        assertEquals(new Box(new V2(0, 1), new V2(1, 1)).getUpperLeftCorner().getY(), r.boundingBox().getUpperLeftCorner().getY(), 0.001);
        r = r.move(new V2(0, 1));
        assertEquals(new Box(new V2(0, 2), new V2(1, 1)).getDimensions().getX(), r.boundingBox().getDimensions().getX(), 0.001);
        assertEquals(new Box(new V2(0, 2), new V2(1, 1)).getDimensions().getY(), r.boundingBox().getDimensions().getY(), 0.001);
        assertEquals(new Box(new V2(0, 2), new V2(1, 1)).getUpperLeftCorner().getX(), r.boundingBox().getUpperLeftCorner().getX(), 0.001);
        assertEquals(new Box(new V2(0, 2), new V2(1, 1)).getUpperLeftCorner().getY(), r.boundingBox().getUpperLeftCorner().getY(), 0.001);
        assertTrue(r.contains(new V2(1, 1)));
        assertFalse(r.contains(new V2(2, 2)));
    }

    @Test
    public void testEllipseMethods() {
        Shape e = Shapes.makeEllipse(new V2(0, 0), new V2(1, 1));
        assertTrue(e.contains(new V2(0.5, Math.sqrt(3) / 2)));
        assertFalse(e.contains(new V2(1, 0.1)));
        assertEquals(new Box(new V2(-1, 1), new V2(2, 2)).getUpperLeftCorner().getX(), e.boundingBox().getUpperLeftCorner().getX(), 0.001) ;
        assertEquals(new Box(new V2(-1, 1), new V2(2, 2)).getUpperLeftCorner().getY(), e.boundingBox().getUpperLeftCorner().getY(), 0.001);
        assertEquals(new Box(new V2(-1, 1), new V2(2, 2)).getDimensions().getX(), e.boundingBox().getDimensions().getX(), 0.001);
        assertEquals(new Box(new V2(-1, 1), new V2(2, 2)).getDimensions().getY(), e.boundingBox().getDimensions().getY(), 0.001);
        e = e.move(new V2(0, 1));
        assertTrue(e.contains(new V2(1, 1)));
        assertFalse(e.contains(new V2(1, 1.1)));
        assertEquals(new Box(new V2(-1, 2), new V2(2, 2)).getUpperLeftCorner().getX(), e.boundingBox().getUpperLeftCorner().getX(), 0.001) ;
        assertEquals(new Box(new V2(-1, 2), new V2(2, 2)).getUpperLeftCorner().getY(), e.boundingBox().getUpperLeftCorner().getY(), 0.001);
        assertEquals(new Box(new V2(-1, 2), new V2(2, 2)).getDimensions().getX(), e.boundingBox().getDimensions().getX(), 0.001);
        assertEquals(new Box(new V2(-1, 2), new V2(2, 2)).getDimensions().getY(), e.boundingBox().getDimensions().getY(), 0.001);
    }
    @Test
    public void testPictureMethods() {
        Shape e = Shapes.makeEllipse(new V2(0, 0), new V2(1, 1));
        Shape r = Shapes.makeRectangle(new V2(0, 1), new V2(1, 1));
        Shape p = Shapes.makePicture(Arrays.asList(e, r));
        assertEquals(new Box(new V2(-1, 1), new V2(2, 2)).getDimensions().getX(), p.boundingBox().getDimensions().getX(), 0.001);
        assertEquals(new Box(new V2(-1, 1), new V2(2, 2)).getDimensions().getY(), p.boundingBox().getDimensions().getY(), 0.001);
        assertEquals(new Box(new V2(-1, 1), new V2(2, 2)).getUpperLeftCorner().getX(), p.boundingBox().getUpperLeftCorner().getX(), 0.001);
        assertEquals(new Box(new V2(-1, 1), new V2(2, 2)).getUpperLeftCorner().getY(), p.boundingBox().getUpperLeftCorner().getY(), 0.001);
        assertTrue(p.contains(new V2(1, 0)));
        assertFalse(p.contains(new V2(2, 2)));
        assertTrue(p.contains(new V2(0.5, Math.sqrt(3) / 2)));
        assertFalse(p.contains(new V2(1, 3)));
        p = p.move(new V2(0, 1));
        assertEquals(new Box(new V2(-1, 2), new V2(2, 2)).getDimensions().getX(), p.boundingBox().getDimensions().getX(), 0.001);
        assertEquals(new Box(new V2(-1, 2), new V2(2, 2)).getDimensions().getY(), p.boundingBox().getDimensions().getY(), 0.001);
        assertEquals(new Box(new V2(-1, 2), new V2(2, 2)).getUpperLeftCorner().getX(), p.boundingBox().getUpperLeftCorner().getX(), 0.001);
        assertEquals(new Box(new V2(-1, 2), new V2(2, 2)).getUpperLeftCorner().getY(), p.boundingBox().getUpperLeftCorner().getY(), 0.001);
        assertTrue(p.contains(new V2(1, 1)));
        assertTrue(p.contains(new V2(1, 1)));
        assertFalse(p.contains(new V2(-1, -1)));
        assertFalse(p.contains(new V2(2, 0)));
    }
}