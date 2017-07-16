package simplepool;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class ExampleTests {

    @Test
    public void testWithoutBrake() {
        IPoolWorld w = PoolWorlds.makePoolWorld(Geometry.v2(50, 60),
                                                Geometry.v2(10, -20),
                                                110,
                                                100,
                                                0,
                                                0.01);
        assertV2Equals(Geometry.v2(50, 60), w.getCurrentBallPosition(), 0.001);
        assertV2Equals(Geometry.v2(80, 0), w.step(3).getCurrentBallPosition(), 0.001);

        w = w.step(4.5);
        assertV2Equals(Geometry.v2(95, 30), w.getCurrentBallPosition(), 0.001);

        assertV2Equals(Geometry.v2(100, 80), w.step(2.5).getCurrentBallPosition(), 0.001);
    }

    @Test
    public void testWithBrake() {
        IPoolWorld w = PoolWorlds.makePoolWorld(Geometry.v2(50, 60),
                                                Geometry.v2(10, -20),
                                                110,
                                                100,
                                                0.2,
                                                0.01);
        assertV2Equals(Geometry.v2(50, 60), w.getCurrentBallPosition(), 0.001);
        assertV2Equals(Geometry.v2(79.1, 0.9), w.step(3).getCurrentBallPosition(), 0.001);

        w = w.step(4.5);
        assertV2Equals(Geometry.v2(92.975, 27.975), w.getCurrentBallPosition(), 0.001);

        assertV2Equals(Geometry.v2(104.9, 75.1), w.step(2.5).getCurrentBallPosition(), 0.001);
    }


    @Test
    public void testDone() {
        IPoolWorld w = PoolWorlds.makePoolWorld(Geometry.v2(6, 5),
                                                Geometry.v2(0, 0.009),
                                                150,
                                                100,
                                                0,
                                                0.01);
        assertFalse(w.isMoving());
    }


    public static void assertV2Equals(V2 v1, V2 v2, double delta) {
        String vectorMsg = String.format("v1=%s; v2=%s", v1, v2);
        assertEquals("x components differ: " + vectorMsg, v1.getX(), v2.getX(),
                     delta);
        assertEquals("y components differ: " + vectorMsg, v1.getY(), v2.getY(),
                     delta);
    }


}
