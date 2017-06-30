package searchtree;

/**
 * Created by Nina on 6/29/2017.
 * This is the interface for the representation
 * of a binary tree using recursive methods to build
 * and gain information from them
 */
public interface BTree {
    /**
     * Integer value that needs to be added to
     * Binary Tree
     * @param i integer
     */
    public void add(int i);

    /**
     * Searches a tree recursively for item
     * @param i int value being searched for in tree
     * @return boolean on whether item is contained
     */
    public boolean contains(int i);

    /**
     * Calculates size of tree recursively
     * @return int value of the size of tree
     */
    public int size();


    /**
     * adds value of knot to an array to eventually
     * give back a sorted array representation of the binary tree
     * @param printArray array the size of the binary tree
     * @param BinaryTree instance of Binary Tree to call up index attribute
     * @return
     */
    public int[] print(int[] printArray, BinaryTree BinaryTree);
}
