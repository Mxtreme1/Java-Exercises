package searchtree;

/**
 * Created by thiemann on 03.07.17.
 */
public class Leaf<T extends Comparable<T>> implements Tree<T> {
    @Override
    public Tree<T> add(int i) {
        return new Node<T>(new Leaf<T>(), i, new Leaf<T>());
    }

    @Override
    public boolean contains(int i) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String elementsAsString() {
        return "";
    }
}
