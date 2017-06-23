package shapes;

import java.util.List;

/**
 * Created by mr492 on 21/06/17.
 */
public class Shapes {
    /**
     *  Each method creates a new Shape instance
     */
    public static Shape makeEllipse(V2 center, V2 radii) {
        //Creates an Ellipse instance if the radii are greater than 0
        if (radii.getX() <= 0 || radii.getY() <= 0) {
            throw new IllegalArgumentException();
        }
        return new Ellipse(center, radii);
    }
    public static Shape makeRectangle(V2 upperLeftCorner, V2 dimensions) {
        //Creates a new Rectangle instance if the dimensions are greater than 0
        if (dimensions.getX() <= 0 || dimensions.getY() <= 0) {
            throw new IllegalArgumentException();
        }
        return new Rectangle(upperLeftCorner, dimensions);
    }
    public static Shape makePicture(List<Shape> shapes) {
        //Creates a new picture out of the shapes given
        return new Picture(shapes);
    }
}
