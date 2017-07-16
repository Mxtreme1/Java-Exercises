package searchtree;



/**
 * Created by mr492 on 29/06/17.
 */
public class BinarySearchTree implements Tree{
    private int number = 0;
    private int value;
    private boolean set = false;
    private int position = 0;
    private BinarySearchTree[] treepart = new BinarySearchTree[2];
    private int[] elements = new int[this.number];
    private StringBuilder sb;


    public BinarySearchTree() {
        this.treepart = treepart;
        this.elements = elements;
    }

    public BinarySearchTree copy() {
        BinarySearchTree copied = new BinarySearchTree();
        if (this.set) {
            copied.set = true;
            copied.value = this.value;
            if (this.treepart[0] != null) {
                copied.treepart[0] = this.treepart[0].copy();
            }
            if (this.treepart[1] != null) {
                copied.treepart[1] = this.treepart[1].copy();
            }
        }
        copied.number = this.number;
        return copied;
    }

    @Override
    public BinarySearchTree add(int i) {
        BinarySearchTree copiedtree = this.copy();
        System.out.println("Inserting: " + i);
        System.out.println("With value " + copiedtree.value);
        if (! copiedtree.contains(i)) {
            copiedtree.number++;
            int[] elem = new int[copiedtree.number];
            for (int j = 0; j < this.number; j++) {
                elem[j] = this.elements[j];
            }
            elem[copiedtree.number - 1] = i;
            copiedtree.elements = elem;
            if (!copiedtree.set) {
                copiedtree.treepart[0] = new BinarySearchTree();
                copiedtree.treepart[1] = new BinarySearchTree();
                copiedtree.value = i;
                copiedtree.set = true;
                return copiedtree;
            } else {
                if (i > copiedtree.value) {
                    copiedtree.treepart[1] = copiedtree.treepart[1].add(i);
                } else if (i < copiedtree.value) {
                    copiedtree.treepart[0] = copiedtree.treepart[0].add(i);
                }
            }
        }
        return copiedtree;
    }

    @Override
    public boolean contains(int i) {
        if (this.set) {
            if (this.value == i) {
                return true;
            }
            else if (i > this.value) {
                return this.treepart[1].contains(i);
            }
            else if (i < this.value) {
                return this.treepart[0].contains(i);
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.number;
    }

    @Override
    public String elementsAsString() {
        this.position = 0;
        this.elements = new int[this.size()];
        this.sb = new StringBuilder();
        return this.asStringHelper();
    }

    public String asStringHelper() {
/*        if (this.set) {
            this.elements[this.position] = this.value;
            this.position++;
            if (this.treepart[0] != null) {
                this.treepart[0].asStringHelper();
            }
            if (this.treepart[1] != null) {
                this.treepart[1].asStringHelper();
            }
        }*/
        for (int i : this.elements) {
            sb.append(i);
        }
        return sb.toString();
    }


    public int getNumber() {
        return this.number;
    }
}
