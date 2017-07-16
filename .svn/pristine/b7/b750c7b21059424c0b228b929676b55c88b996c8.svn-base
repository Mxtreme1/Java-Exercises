package onedgame;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestExamples {

    @Test (expected = IllegalArgumentException.class)
    public void testWrongInput1() {
        Main.isWinnable(3, new boolean[]{});
    }

    @Test (expected = IllegalArgumentException.class)
    public void testWrongInput2() {
        Main.isWinnable(0, new boolean[]{false, true});
    }

    @Test (expected = IllegalArgumentException.class)
    public void testWrongInput3() {
        Main.isWinnable(3, new boolean[]{true});
    }

    @Test
    public void testWinning1() {
        assertTrue(Main.isWinnable(3, new boolean[]{false,
                                                    false,
                                                    false,
                                                    true,
                                                    true ,
                                                    true}));
    }

    @Test
    public void testLoosing1() {
        assertFalse(Main.isWinnable(3, new boolean[]{false,
                                                     false,
                                                     true,
                                                     true ,
                                                     true,
                                                     false}));

    }

    @Test
    public void testWinning2() {
        assertTrue(Main.isWinnable(3, new boolean[]{false, false, false, false, false, false, false}));
    }

    @Test
    public void testWinning3() {
        assertTrue(Main.isWinnable(3, new boolean[]{false, true, true, false, true, true, false, true, true, true}));
    }

    @Test
    public void testWinning4() {
        assertTrue(Main.isWinnable(3, new boolean[]{false, true, false, false, true , false, true, true}));
    }

    @Test
    public void testLoosing2() {
        assertFalse(Main.isWinnable(3, new boolean[]{false, true, true, true, true, true, true}));
    }

    @Test
    public void testLoosing3() {
        assertFalse(Main.isWinnable(3, new boolean[]{false, true, true, true, false, false, false, false}));
    }

}