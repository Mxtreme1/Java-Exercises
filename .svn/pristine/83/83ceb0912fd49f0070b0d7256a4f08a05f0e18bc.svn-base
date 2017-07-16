package formatsi;

import org.junit.Test;

import static org.junit.Assert.*;

public class FormatTest {
    //Tests the method formatSI for various possible errors including standard ones and cornercases
    @Test
    public void formatSI() throws Exception {
        assertEquals(formatsi.Format.formatSI(1000, "g"), "1.0kg");
    }
    @Test
    public void formatSI1() throws Exception {
        assertEquals(formatsi.Format.formatSI(0, "g"), "0.0g");
    }
    @Test
    public void formatSI2() throws Exception {
        assertEquals(formatsi.Format.formatSI(10, "g"), "10.0g");
    }
    @Test
    public void formatSI3() throws Exception {
        assertEquals(formatsi.Format.formatSI(Math.pow(10, 27), "g"), "1.000E+27g");
    }
    @Test
    public void formatSI4() throws Exception {
        assertEquals(formatsi.Format.formatSI(Math.pow(10, -27), "g"), "1.000E-27g");
    }
    @Test
    public void formatSI5() throws Exception {
        assertEquals(formatsi.Format.formatSI(1000000, "a"), "1.0Ma");
    }
    @Test
    public void formatSI6() throws Exception {
        assertEquals(formatsi.Format.formatSI(10000, "g"), "10.0kg");
    }
    @Test
    public void formatSIFailing() throws Exception {
        assertEquals(formatsi.Format.formatSI(1, "m"), "1.0m");
        /**
         * The method doesnt notice, if x is already in the correct unit and outputs the same
         * value in a smaller unit
         *
         * For correction:
         * line 52 needs to be if (l < 0) {
         */
    }

}
