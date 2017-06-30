package searchtree;

/**
 * Empty means that it is the end of the route for the given binary tree
 * in a certain direction. It helps distinguish a Branch from being either
 * a inner knot or a leaf.
 */
public class Empty implements BTree {

    public Empty(){
        // doesn't really need to be constructed,
        // just an empty tree node
    }

    @Override
    public void add(int i) {
        // add is done in the Branch class,
        // never reaches empty
    }

    @Override
    public boolean contains(int i) {
        // since node is empty, cannot contain
        // any items i
        return false;
    }

    @Override
    public int[] print(int[] printArray, BinaryTree BinaryTree) {
        // return the printArray as is
        return printArray;
    }

    @Override
    public int size() {
        //is empty, therefore does not
        // contribute to the size of the tree
        return 0;
    }
}
