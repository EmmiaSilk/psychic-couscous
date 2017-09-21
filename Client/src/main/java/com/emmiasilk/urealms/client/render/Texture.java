package com.emmiasilk.urealms.client.render;

import com.emmiasilk.urealms.api.logging.Logging;
import com.emmiasilk.urealms.api.util.I18n;
import com.emmiasilk.urealms.client.util.IOTools;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL30;

import java.io.IOException;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.stb.STBImage.stbi_failure_reason;
import static org.lwjgl.stb.STBImage.stbi_load_from_memory;

/**
 * Created by Emmia on 2017-09-15.
 */
public class Texture {

    private final int handle;

    private final int height;
    private final int width;
    private final int channels;


    private Texture(int handle, int width, int height, int channels) {
        this.handle = handle;
        this.height = height;
        this.width = width;
        this.channels = channels;

        Logging.logInfo("Creating texture: " + handle);

        // Set default texture options
        bind();
        setParameter(GL_TEXTURE_WRAP_S, GL_REPEAT);
        setParameter(GL_TEXTURE_WRAP_T, GL_REPEAT);
        setParameter(GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        setParameter(GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    }

    public static Texture createTexture(ByteBuffer imageData, int width, int height, int channels) {
        // Create handle
        int[] handleHolder = new int[1];
        glGenTextures(handleHolder);
        int handle = handleHolder[0];//glGenTextures();
        Texture texture = new Texture(handle, width, height, channels);
        // Choose texture internal format
        int format = GL_RGB;
        if (channels == 3) {
            format = GL_RGB;
        } else if (channels == 4) {
            format = GL_RGBA;
        }
        Logging.logDebug("Hash: " + imageData.asCharBuffer().hashCode());
        Logging.logDebug("Width: " + width);
        Logging.logDebug("Height: " + height);
        Logging.logDebug("Channels: " + channels);
        // Create internal texture
        glTexImage2D(GL_TEXTURE_2D, 0, format, width, height, 0, format, GL_UNSIGNED_BYTE, imageData);
        GL30.glGenerateMipmap(GL_TEXTURE_2D);


        // Check hash code (debug!)
        imageData = BufferUtils.createByteBuffer(width * height * channels);
        GL11.glGetTexImage(GL_TEXTURE_2D, 0, format, GL_UNSIGNED_BYTE, imageData);
        Logging.logDebug("Hash 2: " + imageData.asCharBuffer().hashCode());

        return texture;
    }

    public static Texture loadTexture(String path, int desiredChannels) {

        Logging.logDebug(path);

        // Image source data
        ByteBuffer imageSource;
        try {
            imageSource = IOTools.ioResourceToByteBuffer(path, 1024);
            // Read image data to memory
        } catch (IOException ex) {
            Logging.logError(I18n.getLocalizedString("client.texture.loading_io_exception"));
            ex.printStackTrace();
            return null;
        }


        // Temporary storage for image metadata
        int[] x = new int[1];
        int[] y = new int[1];
        int[] channelCount = new int[1];

        // Load image into memory
        ByteBuffer imageData = stbi_load_from_memory(imageSource, x, y, channelCount, desiredChannels);

        if (imageData != null) {
            return createTexture(imageData, x[0], y[0], channelCount[0]);
        }
        //TODO: Crash if image data is null.
        Logging.logError(stbi_failure_reason());
        Logging.logError(I18n.getLocalizedString("client.texture.invalid_data", path));
        return null;
    }

    public void bind() {
        glBindTexture(GL_TEXTURE_2D, handle);
    }

    /**
     * Bind a texture to a given texture slot, an integer 0-31.
     *
     * @param location The location for this texture-- An integer 0-31.
     */
    public void bindTo(int location) {
        GL13.glActiveTexture(GL13.GL_TEXTURE0 + location);
        bind();
    }

    public void setParameter(int name, int param) {
        glTexParameteri(GL_TEXTURE_2D, name, param);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getChannels() {
        return channels;
    }
}
