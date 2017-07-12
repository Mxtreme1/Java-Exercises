package generictree;

/**
 * Created by thiemann on 03.07.17.
 */
//Class uses the type variable which needs to be comparable
public class Node<T extends Comparable<T>> implements Tree<T> {
    private final Tree<T> left;
    private final T v;
    private final Tree<T> right;

    public Node(Tree<T> left, T v, Tree<T> right) {
        this.left = left;
        this.v = v;
        this.right = right;
    }

    @Override
    public Tree<T> add(T i) {
        if (i.compareTo(v) == 0) {
            return this; // i is present, return unchanged
        }
        if (i.compareTo(v) < 0) {
            Tree<T> newl = left.add(i);
            return new Node<T>(newl, v, right);
        } else {
            Tree<T> newr = right.add(i);
            return new Node<T>(left, v, newr);
        }
    }

    @Override
    public boolean contains(T i) {
        if (i.compareTo(v) == 0) {
            return true;
        }
        if (i.compareTo(v) < 0) {
            return left.contains(i);
        } else {
            return right.contains(i);
        }
    }

    @Override
    public int size() {
        int sizel = left.size();
        int sizer = right.size();
        return 1 + sizel + sizer;
    }

    @Override
    public String elementsAsString() {
        String elemsl = left.elementsAsString();
        String elemsr = right.elementsAsString();
        String result = elemsl;
        if (!result.equals("")) {
            result = result + ", ";
        }
        result = result + v;
        if (!elemsr.equals("")) {
            result = result + ", " + elemsr;
        }
        return result;
    }
}
