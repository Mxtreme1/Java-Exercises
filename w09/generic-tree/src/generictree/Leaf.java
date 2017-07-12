package generictree;

/**
 * Created by thiemann on 03.07.17.
 */
//Class uses the type variable which needs to be comparable
public class Leaf<T extends Comparable<T>> implements Tree<T> {
    @Override
    public Tree<T> add(T i) {
        return new Node<T>(new Leaf<T>(), i, new Leaf<T>());
    }

    @Override
    public boolean contains(T i) {
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
