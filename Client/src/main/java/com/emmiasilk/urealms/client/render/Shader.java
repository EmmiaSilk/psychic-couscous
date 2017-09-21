package com.emmiasilk.urealms.client.render;

import com.emmiasilk.urealms.api.logging.Logging;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import java.io.*;

/**
 * A wrapper for GLSL shaders. This class has static methods for creating shaders and
 * instance methods for reading the handle and destroying the shader.
 */
public class Shader {

    // Handle
    public final int handle;

    /**
     * A wrapper for a GLSL Shader.
     *
     * @param type type The shader type (parameter for {@link GL20#glCreateShader(int type)}).
     */
    private Shader(int type) {
        handle = GL20.glCreateShader(type);
    }

    /**
     * Compile a shader from a given source.
     *
     * @param type   The shader type (parameter for {@link GL20#glCreateShader(int type)}).
     * @param source The source code to compile the shader as.
     * @return The compiled shader.
     */
    public static Shader createShader(int type, CharSequence source) {
        // Create shader
        Shader shader = new Shader(type);
        // Compile from source
        GL20.glShaderSource(shader.handle, source);
        GL20.glCompileShader(shader.handle);

        // Check for errors
        int status = GL20.glGetShaderi(shader.handle, GL20.GL_COMPILE_STATUS);
        if (status != GL11.GL_TRUE) {
            throw new RuntimeException(GL20.glGetShaderInfoLog(shader.handle));
        }

        return shader;
    }

    /**
     * Load and compile shader from a file path.
     *
     * @param type The shader type (parameter for {@link GL20#glCreateShader(int type)}).
     * @param path The path of the shader source.
     * @return The compiled shader.
     */
    public static Shader loadShader(int type, String path) {
        Logging.logDebug(path);
        StringBuilder builder = new StringBuilder();

        try {
            InputStream in = new FileInputStream(path);

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load shader: " + path + "\n" + e.getMessage());
        }

        CharSequence source = builder.toString();

        return createShader(type, source);
    }

    /**
     * Load and compile shader from a file path.
     *
     * @param type The shader type (parameter for {@link GL20#glCreateShader(int type)}).
     * @param name The name of the shader file within the /resources/shaders/ folder.
     * @return The compiled shader.
     */
    public static Shader loadShaderResource(int type, String name) {
        String path = Shader.class.getResource("/resources/shaders/" + name).getPath();

        return loadShader(type, path);
    }

    /**
     * Return the shader's handle.
     *
     * @return The handle of this shader.
     */
    public int getHandle() {
        return handle;
    }

    public void destroy() {
        GL20.glDeleteShader(handle);
    }

    //TODO: Create error handler with localised output for when a shader fails to compile.

}
