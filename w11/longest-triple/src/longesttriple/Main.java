package longesttriple;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mr492 on 13/07/17.
 */
public class Main {

    /**
     * Finds the longest possible concatenation of triples in the list and returns it as a Triple instance
     * @param strings
     * @return
     */
    public static Triple longestTriple(List<String> strings) {
        String[] arr = new String[]{"", "", ""};
        int currentBiggest = 0;
        if (strings.size() < 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < strings.size() - 2; i++) {
            if (strings.get(i).length() + strings.get(i + 1).length() + strings.get(i + 2).length() > currentBiggest) {
                arr[0] = strings.get(i);
                arr[1] = strings.get(i + 1);
                arr[2] = strings.get(i + 2);
                currentBiggest = strings.get(i).length() + strings.get(i + 1).length() + strings.get(i + 2).length();
            }
        }
        return new Triple(arr[0], arr[1], arr[2]);
    }
}
