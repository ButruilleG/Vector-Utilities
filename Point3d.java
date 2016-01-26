package Vector;

public class Point3d {
	/**
	 * x value of point
	 */
	public double x;

	/**
	 * y value of point
	 */
	public double y;

	/**
	 * z value of point
	 */
	public double z;

	/**
	 * Constructor
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	/**
	 * Creates a string representation of the point
	 */
	public String toString() {
		return "[" + x + "," + y + "," + z + "]";
	}

	@Override
	/**
	 * Makes a deep copy of the point
	 */
	public Point3d clone() {
		return new Point3d(x, y, z);
	}

	/**
	 * Determines whether point compare is equal to this point
	 * 
	 * @param compare
	 * @return
	 */
	public boolean equals(Point3d compare) {
		if (compare == this)
			return true;

		if (compare == null)
			return false;

		if (compare.x == x && compare.y == y && compare.z == z) {
			return true;
		} else {
			return false;
		}
	}
}
