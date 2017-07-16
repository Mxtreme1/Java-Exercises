package btreeerror;

/**
 * Created by thiemann on 19.06.17.
 */
public interface BTree {
    /**
     * Count the number of leaves in this btree.
     * @return number of leaves.
     */
    public int count();

    /**
     * The height of a btree is the maximal length of a branch.
     * @return the height of this btree.
     */
    public int height();

    /**
     * The mirror image of a btree has the same nodes, but all left and right subtrees are swapped.
     * @return the mirror image of this btree.
     */
    public BTree mirror();

    /**
     * A binary tree is full if all branches have the same length.
     * That is, at each node both subtrees have the same height.
     * @return a positive number (>=0) if this btree is full.
     */
    public int full();
}
