package btreeerror;

public class Branchtwo implements BTree {
    final private BTree left, right;

    public Branchtwo(BTree left, BTree right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int count() {
        return left.count() + right.count();
    }

    @Override
    public int height() {
        return Math.max(left.height(), right.height()) + 1; //gets bigger with every recursive call
    }

    @Override
    public BTree mirror() {
        return new Branchtwo(right.mirror(), left.mirror());
    }

    @Override
    public int full() {
        int fl = left.full();
        int fr = right.full();
        if (fl == fr) {
            return 1 + fl;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Branchtwo branch = (Branchtwo) o;

        if (left != null ? !left.equals(branch.left) : branch.left != null) return false;
        return right != null ? right.equals(branch.right) : branch.right == null;
    }

    @Override
    public int hashCode() {
        int result = left != null ? left.hashCode() : 0;
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }
}
