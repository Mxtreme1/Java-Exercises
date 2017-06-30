package searchtree;

/**
 * Branches each contain their own value and also
 * have a left and right attribute which either extends
 * to another instance of branch or to an instance of empty. If a branch
 * has an empty instance for right and left it is a leaf, else
 * it is an inner knot.
 */
public class Branch implements BTree{
    // int value of knot
    public int branchVal;
    // what extends to the left/right of the current
    // node (either another branch or empty)
    public BTree left; // smaller values end up here
    public BTree right; // bigger value end up here


    public Branch(int i){
        this.branchVal = i;
        // always start of with left and right
        // being emtpy (so a leaf)
        this.left = new Empty();
        this.right = new Empty();
    }

    @Override
    public void add(int i) {
        // if value is same as, nothing needs to be
        // added to the tree
        if (branchVal == i) {
            // do nothing
        }
        // new value is smaller than current knot
        // go into the left branch
        else if (branchVal > i) {
            // left side is empty, append item as
            // a new branch
            if (this.left instanceof Empty) {
                this.left = new Branch(i);
            }
            // left side is not empty, call up left side branch
            // to add item
            else {
                this.left.add(i);
            }
        }

        // analog to smaller value than current knot but for the
        // greater values and right side of knot
        else if (branchVal < i) {
            if (this.right instanceof Empty) {
                this.right = new Branch(i);
            }
            else {
                this.right.add(i);
            }
        }
    }


    @Override
    public boolean contains(int i) {
        // knot is same as value, contained in tree
        if (branchVal == i) {
            return true;
        }

        // knot is not the same, check left and right branches of
        // knot
        else {
            // if either left or right branch contains return true
            if (this.left.contains(i) || this.right.contains(i)){
                return true;
            }
            // neither left or right side contains value
            return false;
        }
    }

    @Override
    public int size() {
        // take the size of the left side of branch
        // plus the size of right side of branch and add 1
        // (ex. leaf would have to empty branches so would return 0+0+1)
        return(this.left.size()+this.right.size()+1);
    }

    @Override
    public int[] print(int[] printArray, BinaryTree BinaryTree) {
        // if left side of branch is not empty call up
        if (!(this.left instanceof Empty)){
            // goes to the next left most part of tree (smallest value)
            this.left.print(printArray, BinaryTree);
        }

        // when reached next smallest value adds item to array
        // according to current printIndex value
        printArray[BinaryTree.printIndex] = branchVal;

        // increases index value by 1 so that next value
        // gets stored at next position
        BinaryTree.printIndex += 1;

        // works its way back up from smallest values to
        // biggest values of the tree
        if(!(this.right instanceof Empty)){
            // eventually goes to right most point of tree (biggest value)
            this.right.print(printArray, BinaryTree);
        }
        return printArray;
    }
}