package simplepool;

public interface IPoolWorld {
	
	/**
	 * Return a world representing this world "seconds" seconds advanced into
	 * the future.
	 */
	public IPoolWorld step(double seconds);
	
	/**
	 * Return true iff the ball is still isMoving
	 */
	public boolean isMoving();

	public V2 getCurrentBallPosition();

	public double getLength();
	public double getWidth();


}
