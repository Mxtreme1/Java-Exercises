package searchtree;

/**
 * Created by thiemann on 11.06.17.
 */
public interface Tree {
    /**
     * Adds and element i to a tree
     * @param int i
     * @return returns a new tree with added element
     */
    public Tree add(int item);

    /**
     * Checks if current tree contains item i
     * @param int i
     * @return returns boolean of where item is contained
     */
    public Boolean contains(int item);

    /**
     * Returns the amount of elements contained in the tree
     */
    public int size();

    /**
     * Returns the tree as a string, with elements seperated by
     * commas and sorted
     */
    public String elementsAsString();
}


