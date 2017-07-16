package simplepool;

/**
 * Implementation of basic movement formulas for 1D and 2D movements.
 */
public class Physics {

    /**
     * Given a velocity "v0" and a brake acceleration, calculate the number
     * of second until movement stops.
     */
    public static double brakingTimeToStop(double v0, double brakeAcceleration) {
        if (brakeAcceleration < 0) {
            throw new IllegalArgumentException("Negative breaking acceleration");
        }

        // https://web-docs.gsi.de/~wolle/TELEKOLLEG/TRANS/formeln_mechanik.pdf
        return Math.abs(v0) / brakeAcceleration;
    }

    /**
     * Given an initial velocity v0 and a brake acceleration, calculate the
     * velocity in "seconds" seconds.
     */
    public static double velocityAtTime(double seconds, double v0, double brakeAcceleration) {
        if (brakeAcceleration < 0) {
            throw new IllegalArgumentException("Negative breaking acceleration");
        }
        if (seconds < 0) {
            throw new IllegalArgumentException("Negative time");
        }

        if (seconds > brakingTimeToStop(v0, brakeAcceleration)) {
            return 0;
        } else {
            // https://web-docs.gsi.de/~wolle/TELEKOLLEG/TRANS/formeln_mechanik.pdf
            return v0 - Math.signum(v0) * brakeAcceleration * seconds;
        }
    }

    /**
     * Given an initial velocity  and a brake acceleration, calculate the
     * distance until movement stops.
     */
    public static double brakingDistance(double seconds, double v0, double brakeAcceleration) {
        if (brakeAcceleration < 0) {
            throw new IllegalArgumentException("Negative breaking acceleration");
        }
        if (seconds < 0) {
            throw new IllegalArgumentException("Negative time");
        }

        // https://web-docs.gsi.de/~wolle/TELEKOLLEG/TRANS/formeln_mechanik.pdf
        return v0 * v0 / (2 * brakeAcceleration);
    }

    /**
     * Given an initial position s0 and velocity v0 and a braking acceleration
     * calculate the positin in "seconds" seconds.
     */
    public static double positionAtTime(double seconds, double s0, double v0, double brakeAcceleration) {
        if (brakeAcceleration < 0) {
            throw new IllegalArgumentException("Negative breaking acceleration");
        }
        if (seconds < 0) {
            throw new IllegalArgumentException("Negative time");
        }

        // https://web-docs.gsi.de/~wolle/TELEKOLLEG/TRANS/formeln_mechanik.pdf
        if (brakingTimeToStop(v0, brakeAcceleration) < seconds) {
            return s0 + Math.signum(v0) * brakingDistance(seconds, v0, brakeAcceleration);
        } else {
            return s0 + v0 * seconds
                              - Math.signum(v0) * 0.5 * brakeAcceleration
                                * seconds * seconds;
        }
    }

    /**
     * 2D version of positionAtTime.
     */
    public static V2 positionAtTime(double seconds, V2 s0, V2 v0, double breakAcceleration) {
        return Geometry.v2(
                positionAtTime(seconds, s0.getX(), v0.getX(), breakAcceleration),
                positionAtTime(seconds, s0.getY(), v0.getY(), breakAcceleration)
        );
    }

    /**
     * 2D version of velocityAtTime.
     */
    public static V2 velocityAtTime(double seconds, V2 v0, double breakAcceleration) {
        return Geometry.v2(
                velocityAtTime(seconds, v0.getX(), breakAcceleration),
                velocityAtTime(seconds, v0.getY(), breakAcceleration)
        );
    }




}
