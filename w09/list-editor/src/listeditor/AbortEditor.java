package listeditor;

import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by mr492 on 04/07/17.
 */
public class AbortEditor extends ListEditor{
    public AbortEditor(PrintWriter out) {
        super(out);
    }

    @Override
    protected void executeMissing(String cmd, Scanner restOfLine) {
        throw new InputMismatchException();
    }
}
