package shapes;

/**
 * Created by mr492 on 22/06/17.
 */
public class Ellipse implements Shape {
    /**
     * Implementation of an Ellipsoid as a Shape
     */
        double centerx;
        double centery;
        double radiusx;
        double radiusy;
    public Ellipse(V2 center, V2 radii) {
        //Constructor of Ellipse points and radii as args
        this.centerx = center.getX();
        this.centery = center.getY();
        this.radiusx = radii.getX();
        this.radiusy = radii.getY();
    }
    public boolean contains(V2 point) {
        //Tests if a point is contained in the Ellipse. This is done with the standard Formula
        double xminhsq = Math.pow(point.getX() - centerx, 2);
        double yminksq = Math.pow(point.getY() - centery, 2);
        double rxsq = Math.pow(this.radiusx, 2);
        double rysq = Math.pow(this.radiusy, 2);
        if ((xminhsq / rxsq) + (yminksq / rysq) <= 1) {
            return true;
        }
        return false;
    }
    public Shape move(V2 displacement) {
        //Moves the Ellipse by the Vector and returns a new moved Ellipse
        double mvcx = this.centerx + displacement.getX();
        double mvcy = this.centery + displacement.getY();
        return new Ellipse(new V2(mvcx, mvcy), new V2(this.radiusx, this.radiusy));
    }
    public Box boundingBox() {
        //Produces the bounding Box of an Ellipse and returns it as a Box Instance
       V2 upperleft = new V2(this.centerx - radiusx, this.centery + radiusy); //most up-left point
       V2 dimensions = new V2(2 * radiusx, 2 * radiusy);
       return new Box(upperleft, dimensions);

    }
}