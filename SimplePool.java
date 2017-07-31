@Override
public IPoolWorld step(double seconds) {

   // variables for the new position in direction x and y direction
   double xNewPos;
   double yNewPos;

   // calculate the total distance gone (possibly extending past the pool table)
   // and take the absolute value
   double totalXD = Math.abs(Physics.positionAtTime(seconds, this.xP, this.xV, this.A));
   double totalYD = Math.abs(Physics.positionAtTime(seconds, this.yP, this.yV, this.A));

   // calculate the actual x distance from either end of the pool table after
   // removing all complete end to end distance travelled (modulo width)
   double distX = (totalXD % this.width);

   // calculate how many collisions there were against the wall, this will help determine
   // new velocity direction and also whether the new position is calculated from the origin
   // or subtracted from the farthest most wall point
   double collideX = (Math.floor(totalXD / this.width) % 2);


   if (collideX == 0) {
       // even amount of collisions, ball travelling in same direction as when it
       // was moving at time t0, distance travelled is simply distX
       xNewPos = distX;
   } else {
       // odd number of collisions, ball is travelling in opposite direction from when
       // it first started out, traveling from the furthest most point toward the origin
       // therefore extra distance traveled is minus the width to get actual position on
       // coordinate system
       xNewPos = this.width - distX;
   }

   // y position calculations analog to x position calculations
   double distY = (totalYD % this.length);
   double collideY = (Math.floor(totalYD / this.length) % 2);
   if (collideY == 0) {
       yNewPos = distY;
   }
   else {
       yNewPos = this.length - distY;
   }

   // recalculate total distance travelled this time keeping possible negative distance
   totalXD = (Physics.positionAtTime(seconds, this.xP, this.xV, this.A));
   totalYD = (Physics.positionAtTime(seconds, this.yP, this.yV, this.A));

   // use physics formula to calculate the velocity in x and y direction at time "seconds"
   double xNewV = Physics.velocityAtTime(seconds, this.xV, this.A);
   double yNewV = Physics.velocityAtTime(seconds, this.yV, this.A);

   // if collisions is odd and total distance travelled is greater than the width then the ball
   // is moving in the opposite direction and the velocity direction must be switched, same applies
   // if the collisions were even and the distance travelled is negative, then the ball is also
   // travelling in the opposite direction from when it first moved. Otherwise velocity directions
   // stays the same
   if ((collideX != 0 && totalXD > this.width) || (collideX == 0 && totalXD < 0)){
       xNewV = -xNewV;
   }

   if ((collideY != 0 && totalYD > this.length) || (collideY == 0 && totalYD < 0)){
       yNewV = -yNewV;
   }


   // calculate the total velocity using the distance formula to combine x and y velocity
   double totalVNew = Math.sqrt(Math.pow(xNewV, 2) + Math.pow(yNewV, 2));

   // if total new velocity is less than epsilon, ball is stationary, set both x and y
   // velocities to 0
   if (totalVNew < epsilon) {
       yNewV = 0;
       xNewV = 0;
   }

   // make new vectors out of the calculated new ball position and velocity
   V2 newBallPosition = new V2(xNewPos, yNewPos);
   V2 newBallVelocity = new V2(xNewV, yNewV);

   // create a new instance of PoolWorld that reflects the ball movement and position after "seconds"
   return new PoolWorld(newBallPosition, newBallVelocity, this.width, this.length, this.A, this.epsilon);

}
