package unittests;

import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionsTest {

    @Test
    public void turbineControl() {
        //Tests various possible variations of the code
        assertEquals(Functions.turbineControl(50.5), "LESS_WATER");
        assertEquals(Functions.turbineControl(49.9), "MORE_WATER");
        assertEquals(Functions.turbineControl(49), "DISCONNECT");
        assertEquals(Functions.turbineControl(51), "DISCONNECT");
        assertEquals(Functions.turbineControl(50.001), "LESS_WATER");
        assertEquals(Functions.turbineControl(50.5), "LESS_WATER");
        assertEquals(Functions.turbineControl(50.0001), "STEADY");
        assertEquals(Functions.turbineControl(49.9999), "STEADY");
        assertEquals(Functions.turbineControl(-33.33), "DISCONNECT");
    }

}
