package searchtree;

/**
 * Created by thiemann on 03.07.17.
 */
public class Node<T extends Comparable<T>> implements Tree<T> {
    private final Tree<T> left;
    private final int v;
    private final Tree<T> right;

    public Node(Tree<T> left, int v, Tree<T> right) {
        this.left = left;
        this.v = v;
        this.right = right;
    }

    @Override
    public Tree<T> add(int i) {
        if (i == v) {
            return this; // i is present, return unchanged
        }
        if (i < v) {
            Tree<T> newl = left.add(i);
            return new Node(newl, v, right);
        } else {
            Tree<T> newr = right.add(i);
            return new Node(left, v, newr);
        }
    }

    @Override
    public boolean contains(int i) {
        if (i == v) {
            return true;
        }
        if (i < v) {
            return left.contains(i);
        } else {
            return right.contains(i);
        }
    }

    // not proper object-oriented style
    public boolean alternativeContains(int i) {
        Node node = this;
        Tree<T> t;
        if (i == v) {
            return true;
        }
        if (i < v) {
            t = node.left;
        } else {
            t = node.right;
        }
        //  Tree t may be a Node or Leaf
        // incomplete
        return false;
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
