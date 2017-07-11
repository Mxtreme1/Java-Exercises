package searchtree;

/**
 * Created by thiemann on 03.07.17.
 */
public class Trees {
    public static <T extends Comparable<T>> Tree<T> makeTree(int[] elements) {
        Tree<T> result = new Leaf<T>();
        for( int i : elements) {
            result = result.add(i);
        }
        return result;
    }
}
