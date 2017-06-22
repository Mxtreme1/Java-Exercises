package shapes;

/**
 * Created by mr492 on 21/06/17.
 */
public class Shapes implements Shape {
    public static Shape makeEllipse(V2 center, V2 radii) {
        V2 up = new V2(center.getX(), center.getY() + radii.getY());
        V2 down = new V2(center.getX(), center.getY() - radii.getY());
        V2 right = new V2(center.getX() + radii.getX(), center.getY());
        V2 left = new V2(center.getX() - radii.getX(), center.getY());

    }
    public static Shape makeRectangle(V2 upperLeftCorner, V2 dimensions) {
        V2 upri = new V2(dimensions.getX(), upperLeftCorner.getY());
        V2 uple = upperLeftCorner;
        V2 dori = dimensions;
        V2 dole = new V2(upperLeftCorner.getX(), dimensions.getY());
    }
    public static Shape makePicture(List<Shape> shapes) {

    }
}
