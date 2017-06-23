package shapes;

import sun.security.provider.SHA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr492 on 22/06/17.
 */

public class Picture implements Shape {
    /**
     * Implementation of a Picture.
     * A picture is the connection of multiple Shape instances.
     */
    List<Shape> elements;
    public Picture(List<Shape> shapes){
        //Constructor of a Picture takes a list of Shapes
       this.elements = shapes;
    }

    public boolean contains(V2 point) {
        //Checks if a Point is contained by the picture.
        //This is the case if one of the element contains the point.
        for (Shape ashape : this.elements) {
            if (ashape.contains(point)) {
                return true;
            }
        }
        return false;
    }
    public Shape move(V2 displacement) {
        //Moves the whole picture by a vector by moving every element contained and returns a new moved picture
        List<Shape> newelements = new ArrayList<Shape>();
        for (Shape elem : this.elements) {
            newelements.add(elem.move(displacement));
        }
        return new Picture(newelements);
    }
    public Box boundingBox() {
        //Creates a bounding Box by searching for the highest and most left point and the dimensions.
        //The dimensions are found by the dimensions of the elements added to the upper left corner
        //Returns a Box instance.
        double leftx = Long.MAX_VALUE;
        double lefty = Long.MIN_VALUE;
        double dimxmax = Long.MIN_VALUE;
        double dimymin = Long.MAX_VALUE;
        for (Shape elem : this.elements) {
            if (elem.boundingBox().getUpperLeftCorner().getX() < leftx) {
                leftx = elem.boundingBox().getUpperLeftCorner().getX();
            }
            if (elem.boundingBox().getUpperLeftCorner().getY() > lefty) {
                lefty = elem.boundingBox().getUpperLeftCorner().getY();
            }
            if (elem.boundingBox().getUpperLeftCorner().getX() + elem.boundingBox().getDimensions().getX() > dimxmax) {
                dimxmax = elem.boundingBox().getUpperLeftCorner().getX() + elem.boundingBox().getDimensions().getX();
            }
            if (elem.boundingBox().getUpperLeftCorner().getY() - elem.boundingBox().getDimensions().getY() < dimymin) {
                dimymin = elem.boundingBox().getUpperLeftCorner().getY() - elem.boundingBox().getDimensions().getY();
            }
        }
        V2 upleftcorner = new V2(leftx, lefty);
        V2 dimension = new V2(Math.abs(dimxmax - leftx), Math.abs(lefty - dimymin));
        return new Box(upleftcorner, dimension);
    }
}
