package listeditor;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Run a RepeatEditor.
 */
public class Main {

    public static void main(String[] args) {
        // Here's how to create a PrintWriter from a  PrintStream like System
        // .out.
        // The last parameter of "PrintWriter" is "autoFlush" (see Java API).
        // Setting it to true causes the println method to print its argument
        // immediatly when called.
        // Otherwise the JVM buffers the output (for efficiency) and may
        // print it at a latter time.
        PrintWriter sysOutWriter =
                new PrintWriter(new OutputStreamWriter(System.out,
                                                       StandardCharsets.UTF_8),
                                true);
        // now we invoke our RepeatEditor. AbortEditor should be run in the
        // same way.
        new RepeatEditor(sysOutWriter).run(new Scanner(System.in));
    }
}
