package simplepool;

/**
 * Created by mr492 on 28/07/17.
 */
public class PoolWorld implements IPoolWorld{
    public V2 p0;
    public V2 v0;
    public double l;
    public double w;
    public double ar;
    public double epsilon;
    public double vel_Vector_Length;
    public double xacc;
    public double yacc;
    public PoolWorld(V2 p0, V2 v0, double l, double w, double ar, double epsilon) {
        this.p0 = p0;
        this.v0 = v0;
        this.l = l;
        this.w = w;
        this.ar = ar;
        this.epsilon = epsilon;
        this.vel_Vector_Length = (Math.sqrt(Math.pow(v0.getX(), 2) + Math.pow(v0.getY(), 2)));
        this.xacc = (ar * Math.abs(v0.getX())) / this.vel_Vector_Length;
        this.yacc = (ar * Math.abs(v0.getY())) / this.vel_Vector_Length;
    }

    @Override
    public IPoolWorld step(double seconds) {
        V2 p1 = Physics.positionAtTime(seconds, p0, new V2(Math.abs(v0.getX()), Math.abs(v0.getY())), ar);
        V2 v1 = new V2(v0.getX() - this.xacc * seconds, v0.getY() - this.yacc * seconds);
        double p2x = (p1.getX() - p0.getX()) % l;
        double p2y = (p1.getY() - p0.getY()) % w;
        double pxnew;
        double pynew;
        double xhits = (Math.floor((p0.getX() + p1.getX()) / l) % 2);
        double yhits = (Math.floor((p0.getY() + p1.getY()) / w) % 2);
        if (v0.getX() < 0) {
            if (xhits == 0) {
                pxnew = l - p2x;
            }
            else {
                pxnew = p2x;
            }
        }
        else {
            if (xhits == 0) {
                pxnew = p2x;
            }
            else {
                pxnew = l - p2x;
            }
        }
        if (v0.getY() < 0) {
            if (yhits == 0) {
                pynew = w - p2y;
            }
            else {
                pynew = p2y;
            }
        }
        else {
            if (yhits == 0) {
                pynew = p2y;
            }
            else {
                pynew = w - p2y;
            }
        }
        V2 p_After_Step = new V2(pxnew, pynew);
        return new PoolWorld(p_After_Step, v1, l, w, ar, epsilon);
    }

    @Override
    public boolean isMoving() {
        if (this.vel_Vector_Length < epsilon) {
           return false;
        }
        return true;
    }

    @Override
    public V2 getCurrentBallPosition() {
        return new V2(Math.abs(p0.getX()), Math.abs(p0.getY()));
    }

    @Override
    public double getLength() {
        return this.l;
    }

    @Override
    public double getWidth() {
        return this.w;
    }
}
