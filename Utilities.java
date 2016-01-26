package Vector;

public class Utilities {
	private static final Point3d ORIGIN = new Point3d(0, 0, 0);

	private Utilities() {
	}

	/**
	 * Returns the result of point b subtracted from point a
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static Point3d pointDifference(Point3d a, Point3d b) {
		return new Point3d(a.x - b.x, a.y - b.y, a.z - b.z);
	}

	/**
	 * scales a vector by scalar num
	 * 
	 * @param a
	 * @param num
	 */
	public static void vectorScale(Point3d a, double num) {
		a.x = a.x * num;
		a.y = a.y * num;
		a.z = a.z * num;
	}

	/**
	 * Multiplies the magnitude of the vector a by scalar num, by modifying the
	 * endpoint of a
	 * 
	 * @param a
	 * @param num
	 */
	public static void vectorScale(Vector3d a, double num) {
		vectorScale(a.endpoint, num);
	}

	/**
	 * Returns the result of a vector from the origin to point a, being scaled
	 * by num, without changing the properties of a
	 * 
	 * @param a
	 * @param num
	 */
	public static Point3d vectorScalar(Point3d a, double num) {
		Point3d vec = a.clone();
		vec.x = vec.x * num;
		vec.y = vec.y * num;
		vec.z = vec.z * num;

		return vec;
	}

	/**
	 * Returns the result of a vector being scaled by num, without changing the
	 * properties of that vector
	 * 
	 * @param a
	 * @param num
	 */
	public static Vector3d vectorScalar(Vector3d a, double num) {
		return new Vector3d(a.centerpoint, vectorScalar(a.endpoint, num));
	}

	/**
	 * Returns the length of a vector from the origin to point a
	 * 
	 * @param a
	 * @return
	 */
	public static double vectorLength(Point3d a) {
		double dot = vectorDotProduct(a);
		double length = Math.sqrt(dot);

		return length;
	}

	/**
	 * Returns the magnitude of a vector
	 * 
	 * @param a
	 * @return
	 */
	public static double vectorLength(Vector3d a) {
		Vector3d tempVector = relativeVector(a);

		return vectorLength(tempVector.endpoint);
	}

	/**
	 * Returns the vector from the origin to a multiplied by itself
	 * 
	 * @param a
	 * @return
	 */
	public static double vectorDotProduct(Point3d a) {
		return a.x * a.x + a.y * a.y + a.z * a.z;
	}

	/**
	 * Returns a vector from the origin to a multiplied by itself
	 * 
	 * @param a
	 * @return
	 * @throws IllegalArgumentException
	 *             throws IllegalArgumentException if the vector doesn't start
	 *             at the origin
	 */
	public static double vectorDotProduct(Vector3d a) throws IllegalArgumentException {
		double cpMultiply = vectorDotProduct(a.centerpoint);

		if (cpMultiply != 0) {
			throw new IllegalArgumentException("vector does not start at the origin");
		} else {
			return vectorDotProduct(a.endpoint);
		}
	}

	/**
	 * Returns the dot product of the vectors from the origin to a and b
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double vectorDotProduct(Point3d a, Point3d b) {
		return a.x * b.x + a.y * b.y + a.z * b.z;
	}

	/**
	 * Returns the dot product of two vectors from the origin
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws IllegaArgumentException
	 *             throws IllegalArgumentException throws
	 *             IllegalArgumentExcpeption if one of both vectors don't have
	 *             center points that start at the origin
	 */
	public static double vectorDotProduct(Vector3d a, Vector3d b) throws IllegalArgumentException {
		double cpMultiplyA = vectorDotProduct(a.centerpoint);
		double cpMultiplyB = vectorDotProduct(b.centerpoint);

		if (cpMultiplyA != 0 || cpMultiplyB != 0) {
			throw new IllegalArgumentException("one or more vectors provided do not start at the origin");
		} else {
			return vectorDotProduct(a.endpoint, b.endpoint);
		}
	}

	/**
	 * Returns a vector from the origin with the same magnitude and direction as
	 * the given vector
	 * 
	 * @param a
	 * @return
	 */
	public static Vector3d relativeVector(Vector3d a) {
		return new Vector3d(pointDifference(a.endpoint, a.centerpoint));
	}

	/**
	 * Returns a unit vector that points in the same direction as the vector
	 * from the centerpoint to a
	 * 
	 * @param a
	 * @return
	 */
	public static Point3d unitVector(Point3d a) {
		Point3d aPrime = a.clone();

		vectorScale(aPrime, 1 / vectorLength(aPrime));

		return aPrime;
	}

	/**
	 * Returns a unit vector that points in the same direction as the vector a
	 * 
	 * @param a
	 * @return
	 */
	public static Vector3d unitVector(Vector3d a) {
		return new Vector3d(unitVector(relativeVector(a).endpoint));
	}

	/**
	 * Returns the scalar component of the vector projection from a to be
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static double vectorProjectionScalar(Vector3d a, Vector3d b) throws IllegalArgumentException {
		double bLength = vectorLength(b);

		if (bLength <= 0) {
			throw new IllegalArgumentException("vector b has a magnitude of 0");
		}

		return vectorDotProduct(relativeVector(a), unitVector(b));
	}

	public static Vector3d vectorProjection(Vector3d a, Vector3d b) throws IllegalArgumentException {
		double scalar = vectorProjectionScalar(a, b);

		return vectorScalar(b, scalar);
	}

	/**
	 * Finds the cross product of vectors from the origin to points a and b
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static Point3d crossProduct(Point3d a, Point3d b) {
		double x = a.y * b.z - a.z * b.y;
		double y = a.z * b.x - a.x * b.z;
		double z = a.x * b.y - a.y * b.x;

		Point3d p = new Point3d(x, y, z);
		return p;
	}
}
