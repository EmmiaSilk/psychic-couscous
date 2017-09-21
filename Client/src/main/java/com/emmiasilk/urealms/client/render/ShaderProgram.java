package com.emmiasilk.urealms.client.render;


import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import static org.lwjgl.opengl.GL20.*;

/**
 * A wrapper for a shader program.
 */
public class ShaderProgram {

    /**
     * The internal handle OpenGL uses to refer to the shader.
     */
    public final int handle;

    /**
     * Create a new shader program.
     */
    public ShaderProgram() {
        handle = glCreateProgram();
    }

    /**
     * Creates and links a new shader program with the given shaders attached.
     * <p>
     * <p>This program can't be modified since the program is linked immediately.</p>
     *
     * @param shaders The shaders to attach.
     */
    public ShaderProgram(Shader... shaders) {
        this();
        // Attach all given shaders
        for (Shader shader : shaders) {
            attach(shader);
        }
        link();
    }

    public int getHandle() {
        return handle;
    }

    /**
     * Attach a shader to this program.
     *
     * @param shader The shader to attach to this program
     */
    public void attach(Shader shader) {
        GL20.glAttachShader(handle, shader.handle);
    }

    /**
     * Link all attached shaders into this program.
     * <p>
     * <p>After linking the program, the original shaders can be safely destroyed.</p>
     */
    public void link() {
        glLinkProgram(handle);
    }

    /**
     * Use this shader program for future shader and rendering calls.
     */
    public void use() {
        glUseProgram(handle);
    }

    /**
     * Set the the value of an int uniform to a value converted from a boolean.
     *
     * @param name  The name of the uniform.
     * @param value The value to give this uniform.
     */
    public final void setBoolean(String name, boolean value) {
        glUniform1i(locationOf(name), (value) ? GL11.GL_TRUE : GL11.GL_FALSE);
    }

    /**
     * Set the the value of an int uniform to a given value.
     *
     * @param name  The name of the uniform.
     * @param value The value to give this uniform.
     */
    public final void setInt(String name, int value) {
        glUniform1i(locationOf(name), value);
    }

    /**
     * Set the the value of a float uniform to a given value.
     *
     * @param name  The name of the uniform.
     * @param value The value to give this uniform.
     */
    public final void setFloat(String name, float value) {
        glUniform1f(locationOf(name), value);
    }

    /**
     * Set the value of length-1 float vector uniform to a given vector value.
     *
     * @param name   The name of the uniform.
     * @param vector The vector to set as the value of the uniform.
     */
    public final void setFloat1fv(String name, float[] vector) {
        glUniform1fv(locationOf(name), vector);
    }

    /**
     * Set the value of length-2 float vector uniform to a given vector value.
     *
     * @param name   The name of the uniform.
     * @param vector The vector to set as the value of the uniform.
     */
    public final void setFloat2fv(String name, float[] vector) {
        glUniform2fv(locationOf(name), vector);
    }

    /**
     * Set the value of length-3 float vector uniform to a given vector value.
     *
     * @param name   The name of the uniform.
     * @param vector The vector to set as the value of the uniform.
     */
    public final void setFloat3fv(String name, float[] vector) {
        glUniform3fv(locationOf(name), vector);
    }

    /**
     * Set the value of length-4 float vector uniform to a given vector value.
     *
     * @param name   The name of the uniform.
     * @param vector The vector to set as the value of the uniform.
     */
    public final void setFloat4fv(String name, float[] vector) {
        glUniform4fv(locationOf(name), vector);
    }

    /**
     * Set the value of length-1 int vector uniform to a given vector value.
     *
     * @param name   The name of the uniform.
     * @param vector The vector to set as the value of the uniform.
     */
    public final void setInt1iv(String name, int[] vector) {
        glUniform1iv(locationOf(name), vector);
    }

    /**
     * Set the value of length-2 int vector uniform to a given vector value.
     *
     * @param name   The name of the uniform.
     * @param vector The vector to set as the value of the uniform.
     */
    public final void setInt2iv(String name, int[] vector) {
        glUniform2iv(locationOf(name), vector);
    }

    /**
     * Set the value of length-3 int vector uniform to a given vector value.
     *
     * @param name   The name of the uniform.
     * @param vector The vector to set as the value of the uniform.
     */
    public final void setInt3iv(String name, int[] vector) {
        glUniform3iv(locationOf(name), vector);
    }

    /**
     * Set the value of length-4 int vector uniform to a given vector value.
     *
     * @param name   The name of the uniform.
     * @param vector The vector to set as the value of the uniform.
     */
    public final void setInt4iv(String name, int[] vector) {
        glUniform4iv(locationOf(name), vector);
    }

    /**
     * Returns the location (int) of a uniform used by this shader program.
     *
     * @param name The name of the uniform.
     * @return The location of the uniform.
     */
    public final int locationOf(String name) {
        return glGetUniformLocation(handle, name);
    }

    /**
     * Destroy this shader program so that it no longer takes up memory.
     */
    public void destroy() {
        glDeleteProgram(handle);
    }
}
