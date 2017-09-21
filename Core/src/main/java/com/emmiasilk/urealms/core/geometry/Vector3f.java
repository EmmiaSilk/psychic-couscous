package com.emmiasilk.urealms.core.geometry;

/**
 * A vector made up of three floating-point numbers.
 * This class also contains math functions for manipulating these vectors.
 */
public class Vector3f {

    /**
     * The first value in the vector.
     */
    private float x;
    /**
     * The second value in the vector.
     */
    private float y;
    /**
     * The third value in the vector.
     */
    private float z;

    /**
     * Creates a new {@code Vector3d} where all values are 0.
     */
    public Vector3f() {
        this(0, 0, 0);
    }

    /**
     * Creates a new vector with the given {@code float} values.
     *
     * @param x The first value in the vector.
     * @param y The second value in the vector.
     * @param z The third value in the vector.
     */
    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Calculates the dot product of two given vectors.
     *
     * @param first  The first vector in the cross product.
     * @param second The second vector in the cross product.
     * @return A new vector orthogonal to the given vectors.
     */
    public static Vector3f cross(Vector3f first, Vector3f second) {
        float px = first.y * second.z - first.z * second.y;
        float py = first.z * second.x - first.x * second.z;
        float pz = first.x * second.y - first.y * second.x;
        return new Vector3f(px, py, pz);
    }

    /**
     * @return The {@code float} x value of this vector.
     */
    public float getX() {
        return x;
    }

    /**
     * Sets the {@code float} x value of this vector to the given value.
     */
    public void setX(float value) {
        this.x = value;
    }

    /**
     * @return The {@code float} y value of this vector.
     */
    public float getY() {
        return y;
    }

    /**
     * Sets the {@code float} y value of this vector to the given value.
     */
    public void setY(float value) {
        this.y = value;
    }

    /**
     * @return The {@code float} z value of this vector.
     */
    public float getZ() {
        return z;
    }

    /**
     * Sets the {@code float} z value of this vector to the given value.
     */
    public void setZ(float value) {
        this.z = value;
    }

    /**
     * Add another vector to this vector.
     *
     * @param other The other vector to add with.
     * @return This vector after addition.
     */
    public Vector3f add(Vector3f other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
        return this;
    }

    /**
     * Subtract another vector from this vector.
     *
     * @param other The other vector to subtract with.
     * @return This vector after the subtraction.
     */
    public Vector3f subtract(Vector3f other) {
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
        return this;
    }

    /**
     * Rotate this vector along the Z axis, changing the X and Y values.
     *
     * @param degrees The angle in degrees to rotate the vector.
     * @return This vector, rotated.
     */
    public Vector3f rotateXY(double degrees) {
        double radians = Math.toRadians(degrees);
        double rx = Math.cos(radians) - Math.sin(radians);
        double ry = Math.cos(radians) + Math.sin(radians);
        this.x = (float) (this.x * rx);
        this.y = (float) (this.y * ry);
        return this;
    }

    /**
     * Rotate this vector along the Y axis, changing the X and Z values.
     *
     * @param degrees The angle in degrees to rotate the vector.
     * @return This vector, rotated.
     */
    public Vector3f rotateXZ(double degrees) {
        double radians = Math.toRadians(degrees);
        double rz = Math.cos(radians) - Math.sin(radians);
        double rx = Math.cos(radians) + Math.sin(radians);
        this.z = (float) (this.z * rz);
        this.x = (float) (this.x * rx);
        return this;
    }

    /**
     * Rotate this vector along the X axis, changing the Y and Z values.
     *
     * @param degrees The angle in degrees to rotate the vector.
     * @return This vector, rotated.
     */
    public Vector3f rotateYZ(double degrees) {
        double radians = Math.toRadians(degrees);
        double ry = Math.cos(radians) - Math.sin(radians);
        double rz = Math.cos(radians) + Math.sin(radians);
        this.y = (float) (this.y * ry);
        this.z = (float) (this.y * rz);
        return this;
    }

    /**
     * Multiply components of this vector by respective given values.
     *
     * @return This vector, scaled.
     */
    public Vector3f scale(float x, float y, float z) {
        this.setX(this.x * x);
        this.setY(this.y * y);
        this.setZ(this.z * z);
        return this;
    }

    /**
     * Multiply all components of this vector by the corresponding components of another vector.
     */
    public Vector3f scale(Vector3f vector) {
        return scale(vector.x, vector.y, vector.z);
    }

    /**
     * Multiply all components of this vector by a given magnitude.
     */
    public Vector3f scale(float magnitude) {
        this.scale(magnitude, magnitude, magnitude);
        return this;
    }

    /**
     * Scales down this vector such that the length equals 1.
     *
     * @return This vector, normalized.
     */
    public Vector3f normalize() {
        this.scale(1f / this.getLength());
        return this;
    }

    public Vector3f negate() {
        this.scale(-1);
        return this;
    }

    /**
     * Calculates the length of this vector using the function: sqrt( x^2 + y^2 + z^2 )
     *
     * @return The length of this vector.
     */
    public float getLength() {
        return (float) Math.sqrt((x * x) + (y * y) + (z * z));
    }

    /**
     * Calculates the dot product of this and the given vector.
     *
     * @return The dot product.
     */
    public float dot(Vector3f vector) {
        return (this.x * vector.x) + (this.y * vector.y) + (this.z * vector.z);
    }

    /**
     * Calculates the dot product of this and the given vector.
     *
     * @param vector The second vector in the cross product.
     * @return A new vector orthogonal to this and the given vector.
     */
    public Vector3f cross(Vector3f vector) {
        return cross(this, vector);
    }

    /**
     * Returns a float array containing the x, y, and z values of this vector.
     *
     * @return A float array of length 3.
     */
    public float[] toArray() {
        return new float[]{x, y, z};
    }

    /**
     * Returns a float array containing the x, y, and z of the vector and the given w.
     *
     * @param w The fourth value in the array.
     * @return A float array of length 4.
     */
    public float[] array4f(float w) {
        return new float[]{x, y, z, w};
    }

    /**
     * Creates a new Vector3d with the same values as the vector that this method is called from.
     *
     * @return A copy of this vector.
     */
    public Vector3f copy() {
        return new Vector3f(x, y, z);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        // Check if every value (x, y, z) is the same.
        Vector3f other = (Vector3f) obj;
        return x == other.x && y == other.y && z == other.z;
    }
}
