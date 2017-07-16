package blockworld;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BlockTest {
    @Test (expected = IllegalArgumentException.class)
    public void unallowedBlockx() {
        Block gravel = new Block(-1, 0, 1, ':');
    }

    @Test (expected = IllegalArgumentException.class)
    public void unallowedBlocky() {
        Block gravel = new Block(0, -1, 1, ':');
    }

    @Test (expected = IllegalArgumentException.class)
    public void unallowedBlockv() {
        Block gravel = new Block(0, 0, -1, ':');
    }

    @Test
    public void gettersandsetters() {
        Block cobble = new Block(1, 2, 3, '¨');
        assertEquals(1, cobble.getxblock());
        cobble.setxblock(4);
        assertEquals(4, cobble.getxblock());
        assertEquals(2, cobble.getyblock());
        cobble.setyblock(5);
        assertEquals(5, cobble.getyblock());
        assertEquals(3, cobble.getvblock());
        cobble.setvblock(6);
        assertEquals(6, cobble.getvblock());
        assertEquals('¨', cobble.getshape());
        cobble.setshape('i');
        assertEquals('i', cobble.getshape());
    }
}
