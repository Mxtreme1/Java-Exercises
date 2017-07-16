package listeditor;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * The abstract base class for list editors. It recognizes the commands from
 * w04.
 * <p>
 * The method "executeMissing" should be overridden. It is called whenever the
 * user enters a command that is not recognised.
 */
public abstract class ListEditor {
    public static final String WORD_PATTERN = "[A-Za-z0-9]+";

    private final List<String> words = new LinkedList<>();
    private final Deque<String> pushBackBuffer = new LinkedList<>();
    protected final PrintWriter out;

    protected ListEditor(PrintWriter out) {
        this.out = out;
    }

    /**
     * Run the ListEditor on the input contained in "scanner". Empty lines
     * are ignored. Non-empty lines are interpreted as commands.
     */
    public void run(Scanner scanner) {
        out.println("Welcome to the ListEditor. Enter a command.");
        while (!pushBackBuffer.isEmpty() || scanner.hasNextLine()) {
            String line;
            if (!pushBackBuffer.isEmpty()) {
                line = pushBackBuffer.pop();
            } else {
                line = scanner.nextLine();
            }
            Scanner lineScanner = new Scanner(line);
            if (lineScanner.hasNext()) {
                String cmd = lineScanner.next();
                execute(cmd, lineScanner);
            } else {
                // ignore empty lines
                lineScanner.close();
            }
        }
    }

    public List<String> currentList() {
        return Collections.unmodifiableList(words);
    }

    /**
     * Push a line of text back into the input. It will be executed next,
     * before the rest of the input.
     */
    protected void pushBack(String line) {
        pushBackBuffer.push(line);
    }


    /**
     * This method is called when a line of the input is not recognized.
     *
     * @param restOfLine A scanner containing the line of input that was not
     *            recognized.
     */
    protected abstract void executeMissing(String cmd, Scanner restOfLine);

    private void execute(String cmd, Scanner restOfLine) {
        int s = words.size();
        switch (cmd) {
            case "append":
                if (restOfLine.hasNext(WORD_PATTERN)) {
                    String w = restOfLine.next();
                    words.add(w);
                } else {
                    executeMissing(cmd, restOfLine);
                }
                break;
            case "pop":
                if (s > 0) {
                    words.remove(s - 1);
                } else {
                    doesNotCompute();
                }
                break;
            case "set":
                if (restOfLine.hasNextInt()) {
                    int i = restOfLine.nextInt();
                    if (restOfLine.hasNext(WORD_PATTERN)) {
                        String w = restOfLine.next();
                        if (0 <= i && i < s) {
                            words.set(i, w);
                        } else {
                            doesNotCompute();
                        }
                    } else {
                        executeMissing(cmd, restOfLine);
                    }
                } else {
                    executeMissing(cmd, restOfLine);
                }
                break;
            case "remove-first":
                if (restOfLine.hasNext(WORD_PATTERN)) {
                    String w = restOfLine.next();
                    words.remove(w);
                } else {
                    executeMissing(cmd, restOfLine);
                }
                break;
            case "remove-all":
                if (restOfLine.hasNext(WORD_PATTERN)) {
                    String w = restOfLine.next();
                    while (words.remove(w)) {
                        // nothing
                    }
                } else {
                    executeMissing(cmd, restOfLine);
                }
                break;
            case "print":
                out.print("::");
                for (String w : words) {
                    out.print(" " + w);
                }
                out.println();
                break;
            case "sort":
                Collections.sort(words);
                break;
            case "reverse":
                Collections.reverse(words);
                break;
            default:
                executeMissing(cmd, restOfLine);
        }
        if (restOfLine.hasNext()) {
        }
        restOfLine.close();
    }

    private void doesNotCompute() {
        out.println("DOES NOT COMPUTE");
    }

}
