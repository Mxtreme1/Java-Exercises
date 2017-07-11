package generictree;

import org.junit.Test;


import static org.junit.Assert.*;

public class TestExamples {

    @Test
    public void testInts1() {
        Tree<Integer> t = Trees.makeTree(new Integer[]{2, 3, 4, 4, 1});
        assertTrue(t.contains(4));
        assertFalse(t.contains(6));
        assertEquals(4, t.size());
    }

    @Test
    public void testStrings() {
        Tree<String> t = Trees.makeTree(new String[]{"abc", "abcd",
                                                     "xy", "xy", "z"});
        Tree<String> t2 = t.add("hi").add("world").add("hi");
        assertFalse(t.contains("hi"));
        assertTrue(t2.contains("hi"));
        assertEquals(6, t2.size());
        assertEquals(4, t.size());
        assertEquals("abc, abcd, hi, world, xy, z",
                     t2.elementsAsString());
    }

    @Test
    public void testChars() {
        Tree<Character> t = Trees.makeTree(new Character[]{'2', '3',
                                                           '4', '4', '1'});
        Tree<Character> t2 = t.add('6').add('7').add('6');
        assertFalse(t.contains('6'));
        assertTrue(t2.contains('6'));
        assertEquals(6, t2.size());
        assertEquals(4, t.size());
        assertEquals("1, 2, 3, 4, 6, 7", t2.elementsAsString());
    }

}