package searchtree;

/**
 * Created by mr492 on 30/06/17.
 */
public interface Treeparts {
    //Interface for parts of trees meaning either leafs or nodes
    void add(int i);
    boolean contains(int i);
    int size();
    int[] asString(int[] intarray, BST bst);
}
