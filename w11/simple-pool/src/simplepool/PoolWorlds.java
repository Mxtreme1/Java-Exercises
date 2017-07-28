package simplepool;

/**
 * Created by mr492 on 28/07/17.
 */
public class PoolWorlds {
    /**
     ∗ @param brakeAcceleration
     * @param initialBallPosition
     ∗ @param initialBallVelocity
     ∗ @param width
     ∗ @param length
     ∗ @return
     */

    public static IPoolWorld makePoolWorld(
            V2 initialBallPosition,
            V2 initialBallVelocity,
            double length,
            double width,
            double brakeAcceleration,
            double epsilon) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
        if (initialBallPosition.getX() < 0 || initialBallPosition.getX() > length || initialBallPosition.getY() < 0 || initialBallPosition.getY() > width) {
            throw new IllegalArgumentException();
        }
        if (brakeAcceleration < 0 || brakeAcceleration > 1 || epsilon < 0) {
            throw new IllegalArgumentException();
        }
        return new PoolWorld(initialBallPosition, initialBallVelocity, length, width, brakeAcceleration, epsilon);
    }
}
