package btreeerror;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mr492 on 12/07/17.
 */
public class LeafTest {
    @Test
    public void bad() {
        Leaf l = new Leaf(1);
        Leaf r = new Leaf(2);
        Branch br = new Branch(l, r);
        assertEquals(1, br.height()); //method height is incorrect, as the maximum is always 0
    }

    @Test
    public void good() {
        Leaf l = new Leaf(1);
        Leaf r = new Leaf(2);
        Branchtwo br = new Branchtwo(l, r);
        assertEquals(1, br.height()); //method height is now implemented correctly
    }

}