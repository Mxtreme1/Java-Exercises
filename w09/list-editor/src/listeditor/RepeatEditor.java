package listeditor;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by mr492 on 04/07/17.
 */
public class RepeatEditor extends ListEditor {
    public RepeatEditor(PrintWriter out) {
        super(out);
    }

    @Override
    protected void executeMissing(String cmd, Scanner restOfLine) {
        if (cmd.equals("repeat")) {
            int n = restOfLine.nextInt();
            String command = restOfLine.nextLine();
            if (n >= 0 && command.contains("append") || command.contains("pop") || command.contains("set") || command.contains("remove-first") || command.contains("remove-all") || command.contains("print") || command.contains("sort") || command.contains("reverse")) {
                for (int i = 0; i < n; i++) {
                    this.pushBack(command);
                }
            }
            else {
                throw new InputMismatchException();
            }
        }
        else {
            throw new InputMismatchException();
        }
    }
}
