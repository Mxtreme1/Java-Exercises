package simplepool;

/**
* Created by Nina on 7/28/2017.
*/
public class PoolWorld implements IPoolWorld {


   public double xP;
   public double yP;
   public double xV;
   public double yV;
   private double width;
   private double length;
   private V2 ballPosition;
   public double A;
   public double epsilon;

   public PoolWorld(V2 initialBallPosition, V2 initialBallVelocity,
                    double width, double length, double brakeAcceleration, double epsilon){
       this.ballPosition = initialBallPosition;
       this.xP = initialBallPosition.getX();
       this.yP = initialBallPosition.getY();

       this.xV = initialBallVelocity.getX();
       this.yV = initialBallVelocity.getY();
       // calculate total velocity and check if smaller than epsilon
       double totalVel = Math.sqrt(Math.pow(this.xV, 2) + Math.pow(this.yV, 2));

       if (totalVel < epsilon){
           // under epsilon, ball is not considered moving, set velocities to 0
           this.xV = 0;
           this.yV = 0;
       }

       this.width = width;
       this.length = length;
       this.A = brakeAcceleration;
       this.epsilon = epsilon;

   }
   @Override
   public IPoolWorld step(double seconds) {

       // calculate position in direction x
       double xNewPos;
       double yNewPos;
       double totalXD = Math.abs(Physics.positionAtTime(seconds, this.xP, this.xV, this.A));
       double totalYD = Math.abs(Physics.positionAtTime(seconds, this.yP, this.yV, this.A));
       double distX = (totalXD % this.width);
       double collideX = (Math.floor(totalXD / this.width) % 2);
       if (collideX == 0) {
           xNewPos = distX;
       } else {
           xNewPos = this.width - distX;
       }


       double distY = (totalYD % this.length);
       double collideY = (Math.floor(totalYD / this.length) % 2);
       if (collideY == 0) {

           yNewPos = distY;
       }
       else {
           yNewPos = this.length - distY;
       }


       totalXD = (Physics.positionAtTime(seconds, this.xP, this.xV, this.A));
       totalYD = (Physics.positionAtTime(seconds, this.yP, this.yV, this.A));

       // calculate x velocity
       double xNewV = Physics.velocityAtTime(seconds, this.xV, this.A);
       if ((collideX != 0 && totalXD > this.width) || (collideX == 0 && totalXD < 0)){
           xNewV = -xNewV;
       }

       // calculate y velocity
       double yNewV = Physics.velocityAtTime(seconds, this.yV, this.A);
       if ((collideY != 0 && totalYD > this.length) || (collideY == 0 && totalYD < 0)){
           yNewV = -yNewV;
       }

       // check if total velocity is less than epsilon

       double totalVNew = Math.sqrt(Math.pow(xNewV, 2) + Math.pow(yNewV, 2));
       if (totalVNew < epsilon) {
           yNewV = 0;
           xNewV = 0;
       }

       V2 newBallPosition = new V2(xNewPos, yNewPos);
       V2 newBallVelocity = new V2(xNewV, yNewV);


       return new PoolWorld(newBallPosition, newBallVelocity, this.width, this.length, this.A, this.epsilon);

   }



   @Override
   public boolean isMoving () {

       // check if velocity in both directions is at zero
       if (this.xV == 0 && this.yV == 0) {
           return false;
       }
       // velocity in at least one direction is above epsilon, the ball is still moving
       else {
           return true;
       }
   }

   @Override
   public V2 getCurrentBallPosition () {
       return this.ballPosition;
   }

   @Override
   public double getLength () {
       return this.length;

   }

   @Override
   public double getWidth () {
       return this.width;
   }
}
