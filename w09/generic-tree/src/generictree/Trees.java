package generictree;


/**
 * Created by thiemann on 03.07.17.
 */
public class Trees {
    //Method uses the type variable which needs to be comparable
    public static <T extends Comparable<T>> Tree<T> makeTree(T[] elements) {
        Tree<T> result = new Leaf<>();
        for( T i : elements) {
            result = result.add(i);
        }
        return result;
    }
}
