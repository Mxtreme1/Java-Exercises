package searchtree;

/**
 * Created by mr492 on 30/06/17.
 */
/*
Implementation of a Binary Search Tree using the interface Tree
 */
public class BST implements Tree{
    public int[] values;
    public Treeparts node;
    public int index = 0;
    private int[] intarray;
    private String stringsort;

    public BST(int[] nodes) {
        this.values = nodes;
        if (nodes.length > 0) {
            //All the values in the provided array are inserted
            this.node = new Node(this.values[0]);

            for (int i : nodes) {
                this.node.add(i);
            }
        }
        else {
            //if no nodes are given the tree is empty
            this.node = new Empty();
        }
    }

    @Override
    public Tree add(int i) {
        //if item is already in the tree don't add it again otherwise make a new tree with the bigger array off values
        if (! this.node.contains(i)) {
            int[] newvalues = new int[this.values.length + 1];
            for (int j = 0; j < this.values.length; j++) {
                newvalues[j] = this.values[j];
            }
            newvalues[this.values.length] = i;
            return Trees.makeTree(newvalues);
        }
        return this;
    }

    @Override
    public boolean contains(int i) {
        return this.node.contains(i);
    }

    @Override
    public int size() {
        return this.node.size();
    }

    @Override
    public String elementsAsString() {
        //If there are elements in the tree append their values in order to a string
        if (this.size() > 0) {
            this.intarray = new int[this.size()];
            this.index = 0;
            this.stringsort = "";
            int[] stringtoprint = this.node.asString(intarray, this);
            for (int i =0; i < stringtoprint.length - 1; i++) {
                stringsort += Integer.toString(stringtoprint[i]) + ", ";
            }
            stringsort += Integer.toString(stringtoprint[stringtoprint.length - 1]);
            return stringsort;
        }
        return "";
    }
}
