package listeditor;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * Created by fennell on 6/25/17.
 */
public class ExampleTests {

    private StringWriter outWriter;
    private PrintWriter out;

    @Before
    public void setUp() {
        // This line ensures that println works the same on Windows and MacOS/Linux.
        System.setProperty("line.separator", "\n");

        outWriter = new StringWriter();
        out = new PrintWriter(outWriter);
    }

    private void assertOutput(List<String> expectedOutputLines) {
        String prefix = "Welcome to the ListEditor. Enter a command.";
        StringBuilder expectedOutput = new StringBuilder();
        for (String line : expectedOutputLines) {
            expectedOutput.append(line + "\n");
        }
        assertEquals(prefix + "\n" + expectedOutput.toString(),
                     outWriter.toString());
    }

    @Test
    public void testAbort() {
        ListEditor editor = new AbortEditor(out);
        editor.run(new Scanner("append 5\nprint\nappend 6"));

        assertEquals(asList("5", "6"), editor.currentList());
        assertOutput(Collections.singletonList(":: 5"));
    }

    @Test(expected = InputMismatchException.class)
    public void testAbortFail() {
        ListEditor editor = new AbortEditor(out);
        editor.run(new Scanner("append 5\nblabla 6\nappend 6"));
    }

    @Test
    public void testRepeat() {
        ListEditor editor = new RepeatEditor(out);
        editor.run(new Scanner("repeat 5 append 5\nprint\nappend 6"));
        assertEquals(asList("5", "5", "5", "5", "5", "6"),
                     editor.currentList());
        assertOutput(Collections.singletonList(":: 5 5 5 5 5"));
    }

    @Test (expected = InputMismatchException.class)
    public void testRepeatmismatch() {
        ListEditor editor = new RepeatEditor(out);
        editor.run(new Scanner("rpeat 5 append 5\nprint\nappend 6"));
    }

    @Test (expected = InputMismatchException.class)
    public void testRepeatmismatch2() {
        ListEditor editor = new RepeatEditor(out);
        editor.run(new Scanner("repeat 5 aapend 5\nprint\nappend 6"));
    }

}