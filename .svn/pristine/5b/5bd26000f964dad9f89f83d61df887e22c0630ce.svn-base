package rainfall;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExampleTests {

    @Test
    public void rainfallTest1() {
        List<Optional<Double>> readings =
                Main.rainfall(Arrays.asList(
                        3.0, 0.0, -1.0, 7.0, -999.0, -999.0, 5.0,
                        3.0, -999.0, -1.0));
        List<Optional<Double>> expected = Arrays.asList(
                Optional.of(3.333), Optional.empty(), Optional.of(4.0));
        assertRainfallEquals(expected, readings, 0.001);
    }

    public static void assertRainfallEquals(List<Optional<Double>> expected,
                                            List<Optional<Double>> actual,
                                            double delta) {
        String listMessage = " Expected: " + expected + "\n Actual: " + actual;
        assertTrue("Sizes differ. \n" + listMessage,
                   expected.size() == actual.size());
        for (int i = 0; i < expected.size(); i++) {
            String message = "Difference at index " + i + "\n" + listMessage;
            Optional<Double> expectedElem = expected.get(i);
            Optional<Double> actualElem = actual.get(i);
            assertTrue(expectedElem.isPresent() == actualElem.isPresent());
            if (actualElem.isPresent()) {
                assertEquals(message,
                             expectedElem.get(), actualElem.get(), delta);
            }
        }
    }


}