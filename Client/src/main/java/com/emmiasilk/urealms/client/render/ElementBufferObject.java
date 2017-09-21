package com.emmiasilk.urealms.client.render;

import org.lwjgl.opengl.GL15;

/**
 * Created by Emmia on 2017-09-14.
 */
public class ElementBufferObject {

    public static final int target = GL15.GL_ELEMENT_ARRAY_BUFFER;
    public final int handle;

    public ElementBufferObject() {
        handle = GL15.glGenBuffers();
    }

    public ElementBufferObject bind() {
        GL15.glBindBuffer(target, handle);
        return this;
    }

    /**
     * Bind Element Buffer 0
     */
    public void unbind() {
        GL15.glBindBuffer(target, 0);
    }

    /**
     * Fill the EBO with data
     *
     * @param indices An array of vertex indices.
     * @param usage   Intended use for the buffer.
     * @return
     */
    public ElementBufferObject writeData(int[] indices, int usage) {
        GL15.glBufferData(target, indices, usage);
        return this;
    }
}
