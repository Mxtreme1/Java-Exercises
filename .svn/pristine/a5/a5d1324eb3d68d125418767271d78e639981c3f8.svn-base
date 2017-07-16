package searchtree;

/**
 * Created by mr492 on 30/06/17.
 */
public class Node implements Treeparts{
    private int value;
    private Treeparts[] children = new Treeparts[2];

    public Node(int i) {
        this.value = i;
        this.children[0] = new Empty();
        this.children[1] = new Empty();

    }

    @Override
    public void add(int i) {
        //if item not already contained add it to the tree by creating a new Branch with the int at the according place
        if (! this.contains(i)) {
            if (i < this.value) {
                if (this.children[0] instanceof Empty) {
                    this.children[0] = new Node(i);
                }
                else {
                    this.children[0].add(i);
                }
            }
            else if (i > this.value) {
                if (this.children[1] instanceof Empty) {
                    this.children[1] = new Node(i);
                }
                else {
                    this.children[1].add(i);
                }
            }

        }
    }

    @Override
    public boolean contains(int i) {
        //Search the tree for the value recursively
        if (this.value == i) {
            return true;
        }
        if (i < this.value) {
            return this.children[0].contains(i);
        }
        if (i > this.value) {
            return this.children[1].contains(i);
        }
        return false;
    }

    @Override
    public int size() {
        return this.children[0].size() + 1 + this.children[1].size();
    }

    public int[] asString(int[] intarray, BST bst) {
        //go completely left (to smallest value) and append that int to an array then go to the next bigger value
        //in the tree and add it as well until arrived at the biggest value
        if (this.children[0] instanceof Node) {
            this.children[0].asString(intarray, bst);
        }
        intarray[bst.index] = this.value;
        bst.index++;
        if (this.children[1] instanceof Node) {
            this.children[1].asString(intarray, bst);
        }
        return intarray;
    }
}
