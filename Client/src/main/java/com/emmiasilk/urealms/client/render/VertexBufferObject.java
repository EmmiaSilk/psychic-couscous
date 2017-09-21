package com.emmiasilk.urealms.client.render;

import org.lwjgl.opengl.GL15;

/**
 * Created by Emmia on 2017-09-14.
 */
public class VertexBufferObject {

    public static final int target = GL15.GL_ARRAY_BUFFER;

    public final int handle;

    /**
     * A wrapper for a Vertex Buffer Object.
     */
    public VertexBufferObject() {
        // Only one buffer
        handle = GL15.glGenBuffers();
    }

    /**
     * Bind this VBO.
     *
     * @return This Vertex Buffer Object.
     */
    public VertexBufferObject bind() {
        GL15.glBindBuffer(target, handle);
        return this;
    }

    /**
     * Fill this VertexBufferObject with data.
     *
     * @param vertices The floating point coordinates of this vertex.
     * @param usage    Intended use for the buffer.
     * @return This Vertex buffer Object.
     */
    public VertexBufferObject writeData(float[] vertices, int usage) {
        GL15.glBufferData(target, vertices, usage);
        return this;
    }

    public int getHandle() {
        return handle;
    }
}
