package longesttriple;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ExampleTests {

    @Test
    public void tripleTest() {
       assertEquals(new Triple("bb", "c", "dd"),
                    Main.longestTriple(Arrays.asList("a", "bb", "c", "dd")));
    }

    @Test
    public void tripleTest2() {
        assertEquals(new Triple("eeeee", "ffff", "ggg"),
                Main.longestTriple(Arrays.asList("a", "bb", "c", "dd", "eeeee", "ffff", "ggg")));
    }

    @Test (expected = IllegalArgumentException.class)
    public void lessthanthree() {
        assertEquals(new Triple("bb", "c", "dd"),
                Main.longestTriple(Arrays.asList("a", "dd")));
    }


}