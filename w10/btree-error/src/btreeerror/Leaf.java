package btreeerror;

public class Leaf implements BTree {
    private final int value;

    public Leaf(int value) {
        this.value = value;
    }

    @Override
    public int count() {
        return 1;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public BTree mirror() {
        return this;
        // alternativ: return new Leaf(value)
    }

    @Override
    public int full() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Leaf leaf = (Leaf) o;

        return value == leaf.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
