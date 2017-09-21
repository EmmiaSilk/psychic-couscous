package com.emmiasilk.urealms.core.geometry;

/**
 * A point in three-dimensional space made up of floating point numbers.
 * This class also contains methods for manipulating points.
 * <p>
 * <p>Math functions in this class modify the original point they are called from, such
 * that the the </p>
 */
public class Point3f {

    /**
     * The first value in the point.
     */
    private float x;
    /**
     * The second value in the point.
     */
    private float y;
    /**
     * The third value in the point.
     */
    private float z;

    /**
     * Creates a new {@code Point3f} where all values are 0.
     */
    public Point3f() {
        this(0, 0, 0);
    }

    /**
     * Creates a new {@code Point3f} with the given {@code float} values.
     *
     * @param x The first value in the point.
     * @param y The second value in the point.
     * @param z The third value in the point.
     */
    public Point3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Creates a new {@code Point3f} with values copied from a {@code Vector3d}.
     *
     * @param vector The vector which acts as the source for the float values.
     */
    public Point3f(Vector3f vector) {
        this(vector.getX(), vector.getY(), vector.getZ());
    }

    public float getX() {
        return x;
    }

    public void setX(float value) {
        this.x = value;
    }

    public float getY() {
        return y;
    }

    public void setY(float value) {
        this.y = value;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float value) {
        this.z = value;
    }

    public Point3f add(Vector3f vector) {
        this.x += vector.getX();
        this.y += vector.getY();
        this.z += vector.getZ();
        return this;
    }

    public Point3f subtract(Vector3f vector) {
        this.x -= vector.getX();
        this.y -= vector.getY();
        this.z -= vector.getZ();
        return this;
    }

    public Vector3f directionTo(Point3f point) {
        Vector3f vector = new Vector3f(0, 0, 0);
        vector.setX(this.x - point.x);
        vector.setY(this.y - point.y);
        vector.setZ(this.z - point.z);
        return vector;
    }

    public Point3f passValuesFrom(Point3f point) {
        this.x = point.x;
        this.y = point.y;
        this.z = point.z;
        return this;
    }

    /**
     * Creates a new Point3f with the same values as the point that this method is called from.
     *
     * @return A copy of this point.
     */
    public Point3f copy() {
        return new Point3f(x, y, z);
    }

}
