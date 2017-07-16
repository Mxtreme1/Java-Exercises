package undoarray;

import java.util.*;

/**
 * Created by mr492 on 13/07/17.
 */

/**
 * An Array which supports undoing as long as the history size isnt reached.
 * @param <X> A generic type
 */
public class UndoArray<X> {
    X init;
    int size;
    int historySize;
    List<X> elements = new  ArrayList<>(); // the elements of the Array
    X[] arr; // the elements in array form
    //The history of the Array containing pairs of Indices and changed elements
    List<AbstractMap.SimpleEntry<Integer, X>> history = new ArrayList<>();

    /**
     * Constructor for UndoArray
     * @param init The initial value of each array field
     * @param size The array size
     * @param historySize The history size
     */
    public UndoArray(X init, int size, int historySize) {
        if (size < 0 || historySize < 0) {
            throw new IllegalArgumentException();
        }
        this.init = init;
        this.size = size;
        this.historySize = historySize;
        for (int i = 0; i < size ; i++) {
            elements.add((X) init);
        }
        this.arr = (X[])elements.toArray();
    }

    /**
     * Puts the item elem to the position idx of the array and saves the previous state in the history
     * with the index and value.
     * @param idx A valid array position
     * @param elem An instance of type X
     */
    public void put(int idx, X elem) {
        if (idx < 0 || idx > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        history.add(0, new AbstractMap.SimpleEntry<>(idx, arr[idx]));
        if (history.size() > historySize) {
            history.remove(history.get(historySize));
        }
        arr[idx] = elem;
    }

    public List<X> get() {
        return Collections.unmodifiableList(Arrays.asList(arr));
    }

    /**
     * Changes the last changed index of the array back to its previous state
     *and removes the state from the history
     * @return true if anything was undone false if not
     */
    public boolean undo() {
        if (! history.isEmpty()) {
            arr[history.get(0).getKey()] = history.get(0).getValue();
            history.remove(history.get(0));
            return true;
        }
        return false;
    }
}
