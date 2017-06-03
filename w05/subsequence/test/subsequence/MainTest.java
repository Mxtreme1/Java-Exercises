package subsequence;


import org.junit.Test;

import static org.junit.Assert.*;
import static subsequence.PartialOrdering.*;

/**
 * Created by thiemann on 21.05.17.
 */
public class MainTest {
    //Tests for various possibilities
    @Test
    public void subsequenceCompareEquals() {
        assertEquals(PartialOrdering.subsequenceCompare(" ", " "), PartialOrdering.EQUAL);
    }
    @Test
    public void subsequenceCompareEquals1() {
        assertEquals(PartialOrdering.subsequenceCompare("Hello World", "Hello World"), PartialOrdering.EQUAL);
    }
    @Test
    public void subsequenceCompareIncomparable() {
        assertEquals(PartialOrdering.subsequenceCompare("Hello World", "World Hello"), PartialOrdering.INCOMPARABLE);
    }
    @Test
    public void subsequenceCompareLess() {
        assertEquals(PartialOrdering.subsequenceCompare("Hello World", "Hello Worldo"), PartialOrdering.LESS);
    }
    @Test
    public void subsequenceCompareGreater() {
        assertEquals(PartialOrdering.subsequenceCompare("Hello World", "eloWrld"), PartialOrdering.GREATER);
    }

}
