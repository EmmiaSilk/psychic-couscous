package com.emmiasilk.urealms.client.render;

import org.lwjgl.opengl.GL30;

/**
 * Created by Emmia on 2017-09-14.
 */
public class VertexArrayObject {

    public final int handle;

    public VertexArrayObject() {
        handle = GL30.glGenVertexArrays();
    }

    /**
     * Bind this VAO.
     *
     * @return This Vertex Array Object.
     */
    public VertexArrayObject bind() {
        GL30.glBindVertexArray(handle);
        return this;
    }

    public int getHandle() {
        return handle;
    }

    /**
     * Binds Vertex Array 0.
     */
    public void unbind() {
        GL30.glBindVertexArray(0);
    }
}
