package Vector;

public class Vector3d {
	public Point3d centerpoint;
	public Point3d endpoint;

	/**
	 * Creates a new vector, from the origin to the endpoint ep
	 * 
	 * @param ep
	 */
	public Vector3d(Point3d ep) {
		centerpoint = new Point3d(0, 0, 0);
		endpoint = ep.clone();
	}

	/**
	 * creates a new vector, from point cp to point ep
	 * 
	 * @param cp
	 * @param ep
	 */
	public Vector3d(Point3d cp, Point3d ep) {
		centerpoint = cp.clone();
		endpoint = ep.clone();
	}

	@Override
	/**
	 * creates a deep copy of this vector
	 */
	public Vector3d clone() {
		return new Vector3d(centerpoint.clone(), endpoint.clone());
	}

	@Override
	/**
	 * creates a string representation of the vector
	 */
	public String toString() {
		return centerpoint.toString() + "->" + endpoint.toString();
	}
}
