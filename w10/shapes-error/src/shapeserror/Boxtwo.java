package shapeserror;

/**
 * A class for a box in a cartesian coordinate system
 */
public class Boxtwo {
    private final V2 lowerRightCorner;
    private final V2 dimensions;

    /**
     * A box is defined by its lower right corner and its dimensions.
     * Dimensions have to be positive (>= 0).
     *
     */
    public Boxtwo(V2 lowerRightCorner, V2 dimensions) {
        //Now uses dimensions.getX instead of 2 times getY
        if (dimensions.getX() < 0 || dimensions.getY() < 0) {
            throw new IllegalArgumentException("Bad dimensions: " + dimensions);
        }
        this.lowerRightCorner = lowerRightCorner;
        this.dimensions = dimensions;

    }

    public V2 getLowerRightCorner() {
        return lowerRightCorner;
    }

    public V2 getDimensions() {
        return dimensions;
    }
}
