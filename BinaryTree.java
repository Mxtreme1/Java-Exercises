package searchtree;

/**
 * Created by Nina on 6/29/2017.
 */
public class BinaryTree implements Tree {
    // array of ints from which the tree was created
    public int[] anArray;
    // binary tree representation of the array
    public BTree BinTree;
    // binary tree in ordered array form
    public int[] printArray;
    public int printIndex;

    /**
     * Adds and element i to a tree
     * @param  anArray integer array
     * @return returns a new tree with added element
     */


    public BinaryTree(int[] anArray){

        this.anArray = anArray;

        // if array is empty binary tree is Empty
        if (anArray.length == 0){
            this.BinTree = new Empty();
        }
        else{
            // create root of tree with first element of list
            this.BinTree = new Branch(anArray[0]);

            // add all other elements of list to the tree
            for (int index = 1; index < anArray.length; index++){
                this.BinTree.add(anArray[index]);
            }
        }
    }

    @Override
    public Tree add(int item){
        // check if the item is already contained
        if (this.contains(item)){
            // item is contained, instance does not change
            // and can be given back the way it is
            return this;
        }

        // have to add the item
        else{
            // create a new array with one more index space than
            // current Binary Tree array
            int[] newArray = new int[this.anArray.length + 1];

            // add all elements of last array to new array at the
            // same index postions
            for(int index = 0; index < anArray.length; index ++){
                newArray[index] = anArray[index];
            }

            // add new item to last position in array
            newArray[this.anArray.length] = item;

            // create a new instance of BinaryTree with the new
            // array and return this instance
            return Trees.makeTree(newArray);
        }
    }

    /**
     * Checks if current tree contains item i
     * @param item integer
     * @return returns boolean of where item is contained
     */
    @Override
    public Boolean contains(int item){
        // call up the recursive BTree method on the
        // BinaryTree representation to check if item
        // is contained
        return this.BinTree.contains(item);
    }

    /**
     * Returns the amount of elements contained in the tree
     */
    @Override
    public int size(){
        // call up the recursive BTree method on the
        // BinaryTree representation to calculate tree size
        return this.BinTree.size();
    }

    /**
     * Returns the tree as a string, with elements seperated by
     * commas and sorted
     */
    @Override
    public String elementsAsString(){
        // if tree is empty return emtpty string
        if (this.size() == 0){
            return("");
        }

        // create new array with the size of tree
        this.printArray = new int[this.size()];
        // initiate printIndex at 0 (gets incremented in branch class)
        this.printIndex = 0;
        // call up print method of BTree in branch with instance of Binary
        // Tree to have access to printIndex attribute and also give over
        // the array
        int[] finalPrint = this.BinTree.print(this.printArray, this);

        // create string
        String sortedString = "";

        // for all elements in array up till the last one
        // add to the end of string with a command and space
        for(int index = 0; index < finalPrint.length - 1; index++){
            sortedString += Integer.toString(finalPrint[index]) + ", ";
        }

        // add last element of array to the end of string
        sortedString += Integer.toString(finalPrint[finalPrint.length -1]);

        // return string
        return(sortedString);
    }


}