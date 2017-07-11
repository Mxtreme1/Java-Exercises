package searchtree;

/**
 * Created by thiemann on 03.07.17.
 */
public interface Tree<T> {
    /**
     * Construct a new tree that also contains i.
     * @param i the new element
     * @return the extended tree.
     */
    public Tree<T> add(int i);
    public boolean contains(int i);
    public int size();
    public String elementsAsString();
}
