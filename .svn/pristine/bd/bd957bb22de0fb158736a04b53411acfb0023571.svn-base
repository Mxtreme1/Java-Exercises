package listeditor;

import java.io.PrintWriter;
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
        //If the command wasnt found and is repeat try to repeat the following command n times
        if (cmd.equals("repeat")) {
            int n = restOfLine.nextInt();
            //gets the command and pushes it n times
            String command = restOfLine.nextLine();
            if (n >= 0 && command.contains("append") || command.contains("pop") || command.contains("set") || command.contains("remove-first") || command.contains("remove-all") || command.contains("print") || command.contains("sort") || command.contains("reverse")) {
                for (int i = 0; i < n; i++) {
                    this.pushBack(command);
                }
            }
            else {
                //if its not a valid command throw exception
                throw new InputMismatchException();
            }
        }
        else {
            //if command not repeat
            throw new InputMismatchException();
        }
    }
}
