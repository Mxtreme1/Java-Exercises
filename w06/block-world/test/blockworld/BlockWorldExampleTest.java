package blockworld;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BlockWorldExampleTest {

    @Test (expected = IllegalArgumentException.class)
    public void outofworlderror() {
        List<Block> bs = Collections.singletonList(new Block (2, 2, 1, 'x'));
        BlockWorld w = new BlockWorld(1, 2, bs, '.');
    }

    @Test
    public void testMultiBlock() {
        List<Block> bs = new ArrayList<Block>();
        bs.add(new Block(0, 0, 1, 'a'));
        bs.add(new Block(0, 0, 1, 'b'));
        BlockWorld w = new BlockWorld(1, 2, bs, '.');
        w.step();
        assertArrayEquals(new char[][]{new char[]{'.', 'b'}}, w.observe());
    }

    @Test
    public void testmultidim() {
        List<Block> bs = new ArrayList<Block>();
        bs.add(new Block(0, 0, 1, 'a'));
        bs.add(new Block(1, 0, 1, 'b'));
        BlockWorld w = new BlockWorld(2, 2, bs, '.');
        assertArrayEquals(new char[][]{new char[]{'a', '.'}, new char[]{'b', '.'}}, w.observe());
        assertFalse(w.isDead());
        w.step();
        assertArrayEquals(new char[][]{new char[]{'.', 'a'}, new char[]{'.', 'b'}}, w.observe());
        assertTrue(w.isDead());
    }

    @Test
    public void testMinimalWorld() {
        List<Block> bs = Collections.singletonList(new Block (0, 0, 1, 'x'));
        BlockWorld w = new BlockWorld(1, 2, bs, '.');
        assertFalse(w.isDead());
        assertArrayEquals(new char[][]{ new char[]{ 'x', '.'}}, w.observe());
        w.step();
        assertTrue(w.isDead());
        assertArrayEquals(new char[][]{ new char[]{ '.', 'x'}}, w.observe());
    }

    @Test
    public void deadbeforeobserve() {
        List<Block> bs = new ArrayList<Block>();
        bs.add(new Block(0, 0, 2, 'x'));
        bs.add(new Block(0, 0, 0, 'o'));
        BlockWorld w = new BlockWorld(2, 6, bs, '.');
        w.observe();
        w.step();
        w.observe();
        w.step();
        w.observe();
        w.step();
        w.observe();
        assertEquals(true, w.isDead());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingBlockConstructionx() {
        new Block(-1, 0, 1, 'x');
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingBlockConstructiony() {
        new Block(0, -1, 1, 'x');
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingBlockConstructionv() {
        new Block(0, 0, -1, 'x');
    }

}