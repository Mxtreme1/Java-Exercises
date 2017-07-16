package shapeserror;

import org.junit.Test;

/**
 * Created by mr492 on 12/07/17.
 */
public class testExamples {

    @Test (expected = IllegalArgumentException.class)
    public void bad() {
        V2 lrc = new V2(0.0, 0.0);
        V2 dim = new V2(-3.0, 2.0);
        Box b = new Box(lrc, dim); //Box misses the negative x dimension
    }

    @Test (expected = IllegalArgumentException.class)
    public void good() {
        V2 lrc = new V2(0.0, 0.0);
        V2 dim = new V2(-3.0, 2.0);
        Boxtwo b2 = new Boxtwo(lrc, dim); //Catches it now
    }
}
