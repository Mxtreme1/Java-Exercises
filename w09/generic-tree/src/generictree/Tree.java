package generictree;

/**
 * Created by thiemann on 03.07.17.
 */
//Class uses the type variable which needs to be comparable
public interface Tree<T extends Comparable<T>> {
    /**
     * Construct a new tree that also contains i.
     * @param i the new element
     * @return the extended tree.
     */
    public Tree<T> add(T i);
    public boolean contains(T i);
    public int size();
    public String elementsAsString();
}
