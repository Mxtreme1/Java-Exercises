package shapes;

/**
 * Created by mr492 on 21/06/17.
 */

public class Rectangle implements Shape{
    /**
     * Implementation of a rectangle as a shape.
     */
    public static double uplex;
    public static double upley;
    public static double uprix;
    public static double upriy;
    public static double dolex;
    public static double doley;
    public static double dorex;
    public static double dorey;
    public static V2 dimension;
    public Rectangle(V2 upperLeftCorner, V2 dimensions) {
        //Constructor of the rectangle takes an upper left corner and the dimensions of the rectangle and creates all corner points
        V2 upri = new V2(upperLeftCorner.getX() + dimensions.getX(), upperLeftCorner.getY());
        V2 uple = upperLeftCorner;
        V2 dore = new V2(upperLeftCorner.getX() + dimensions.getX(), upperLeftCorner.getY() - dimensions.getY());
        V2 dole = new V2(upperLeftCorner.getX(), upperLeftCorner.getY() - dimensions.getY());
        this.uplex = uple.getX();
        this.upley = uple.getY();
        this.uprix = upri.getX();
        this.upriy = upri.getY();
        this.dolex = dole.getX();
        this.doley = dole.getY();
        this.dorex = dore.getX();
        this.dorey = dore.getY();
        this.dimension = dimensions;
    }
    public boolean contains(V2 point) {
        //Checks if a Point is contained by the given rectangle.
        double px = point.getX();
        double py = point.getY();
        //is px bigger or equal than the most left point/ smaller or equal to the most right
        //is the y coordinate bigger or equal than the lowest point/ smaller or equal to the highest point
        if (px >= uplex && px <= uprix && py >= doley && py <= upley) {
            return true;
        }
        return false;
    }
    public Shape move(V2 displacement) {
        //moves the rectangle by the vector given by adding the displacement to the coordinates and returns a new rectangle
        V2 movedUple = new V2(this.uplex + displacement.getX(), this.upley + displacement.getY());
        return new Rectangle(movedUple, this.dimension);
    }
    public Box boundingBox() {
        //Creates the bounding Box of the rectangle. The upper left corner is the same and the dimensions are gathered
        //by subtracting the most right/up x/y by the most left/down x/y
        //Returns a Box instance
        double dimx = Math.abs(this.uplex - this.uprix);
        double dimy = Math.abs(this.upley - this.doley);
        V2 dimensions = new V2(dimx, dimy);
        return new Box(new V2(this.uplex, this.upley), dimensions);
    }
}
