package shapeserror;

/**
 * A class for a box in a cartesian coordinate system
 */
public class Box {
    private final V2 lowerRightCorner;
    private final V2 dimensions;

    /**
     * A box is defined by its lower right corner and its dimensions.
     * Dimensions have to be positive (>= 0).
     *
     */
    public Box(V2 lowerRightCorner, V2 dimensions) {
        if (dimensions.getY() < 0 || dimensions.getY() < 0) {
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
